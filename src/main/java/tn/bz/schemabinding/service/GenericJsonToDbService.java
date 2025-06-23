package tn.bz.schemabinding.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

@Service
public class GenericJsonToDbService {

    private final JdbcTemplate jdbcTemplate;

    public GenericJsonToDbService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String processJsonFile(String baseTableName, InputStream inputStream) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(inputStream);

        // Flat rows for single table
        List<Map<String, Object>> flatRows = new ArrayList<>();
        // Collect all possible raw columns
        Set<String> rawColumns = new LinkedHashSet<>();

        // Flatten entire tree into rows for single table
        flattenNode(root, "", new LinkedHashMap<>(), flatRows);

        if (flatRows.isEmpty()) {
            throw new IllegalArgumentException("No data rows found in JSON!");
        }

        // Collect all unique columns
        for (Map<String, Object> row : flatRows) {
            rawColumns.addAll(row.keySet());
        }

        // Map: rawName -> sanitized
        Map<String, String> rawToSanitized = new LinkedHashMap<>();
        Map<String, String> sanitizedToRaw = new LinkedHashMap<>();
        List<String> sanitizedColumns = new ArrayList<>();
        for (String raw : rawColumns) {
            String sanitized = sanitizeColumnName(raw);
            int suffix = 1;
            String base = sanitized;
            while (sanitizedColumns.contains(sanitized)) {
                sanitized = base + "_" + suffix++;
            }
            sanitizedColumns.add(sanitized);
            rawToSanitized.put(raw, sanitized);
            sanitizedToRaw.put(sanitized, raw);
        }

        // Create table if not exists
        String tableName = baseTableName.replaceAll("[^a-zA-Z0-9_]", "_");
        StringBuilder createSql = new StringBuilder();
        createSql.append(
                "IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'" + tableName + "') AND type in (N'U')) BEGIN "
        );
        createSql.append("CREATE TABLE ").append(tableName).append(" (id INT IDENTITY(1,1) PRIMARY KEY, ");
        for (int i = 0; i < sanitizedColumns.size(); i++) {
            createSql.append(sanitizedColumns.get(i)).append(" NVARCHAR(MAX)");
            if (i < sanitizedColumns.size() - 1) {
                createSql.append(", ");
            }
        }
        createSql.append(") END");

        jdbcTemplate.execute(createSql.toString());

        // Insert SQL
        String insertSql = "INSERT INTO " + tableName + " (" +
                String.join(", ", sanitizedColumns) + ") VALUES (" +
                String.join(", ", Collections.nCopies(sanitizedColumns.size(), "?")) + ")";

        // Batch insert
        jdbcTemplate.batchUpdate(insertSql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Map<String, Object> row = flatRows.get(i);
                int idx = 1;
                for (String sanitized : sanitizedColumns) {
                    String raw = sanitizedToRaw.get(sanitized);
                    ps.setObject(idx++, row.get(raw));
                }
            }

            @Override
            public int getBatchSize() {
                return flatRows.size();
            }
        });

        return "Inserted " + flatRows.size() + " rows into table [" + tableName + "]";
    }

    private String sanitizeColumnName(String rawName) {
        return rawName.replaceAll("[^a-zA-Z0-9]", "_");
    }

    /**
     * Recursively flatten the entire tree into rows for a single table.
     * If an array is found, flatten each element into its own row,
     * combining context from parent path.
     */
    private void flattenNode(JsonNode node, String path, Map<String, Object> parentContext, List<Map<String, Object>> flatRows) {
        if (node.isArray()) {
            int idx = 0;
            for (JsonNode element : node) {
                Map<String, Object> newContext = new LinkedHashMap<>(parentContext);
                newContext.put(path + "_index", idx++);
                flattenNode(element, path, newContext, flatRows);
            }
        } else if (node.isObject()) {
            Map<String, Object> newContext = new LinkedHashMap<>(parentContext);
            node.fields().forEachRemaining(entry -> {
                String childPath = path.isEmpty() ? entry.getKey() : path + "." + entry.getKey();
                flattenNode(entry.getValue(), childPath, newContext, flatRows);
            });
            // Only add if this object node is not just a parent for deeper objects/arrays
            if (!newContext.equals(parentContext)) {
                flatRows.add(newContext);
            }
        } else {
            parentContext.put(path, node.isNull() ? null : node.asText());
        }
    }
}
