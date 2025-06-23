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

        Map<String, List<JsonNode>> arrays = new LinkedHashMap<>();
        findAllArrays(root, "", arrays);

        if (arrays.isEmpty()) {
            throw new IllegalArgumentException("No arrays of objects found in JSON!");
        }

        int totalInserted = 0;

        for (Map.Entry<String, List<JsonNode>> entry : arrays.entrySet()) {

            String tableName = baseTableName.replaceAll("[^a-zA-Z0-9_]", "_");
            List<JsonNode> items = entry.getValue();

            List<Map<String, Object>> rows = new ArrayList<>();
            Set<String> rawColumns = new LinkedHashSet<>();

            for (int i = 0; i < items.size(); i++) {
                Map<String, Object> row = flatten(items.get(i));
                row.put("array_index", i);
                rows.add(row);
                rawColumns.addAll(row.keySet());
                rawColumns.add("array_index");
            }

            // Sanitize column names by replacing '.' and other chars with '_'
            List<String> sanitizedColumns = new ArrayList<>();
            Map<String, String> rawToSanitized = new HashMap<>();

            for (String rawCol : rawColumns) {
                String sanitized = sanitizeColumnName(rawCol);
                // Avoid duplicate sanitized names
                int suffix = 1;
                String baseSanitized = sanitized;
                while (sanitizedColumns.contains(sanitized)) {
                    sanitized = baseSanitized + "_" + suffix++;
                }
                sanitizedColumns.add(sanitized);
                rawToSanitized.put(rawCol, sanitized);
            }

            // Build CREATE TABLE SQL for SQL Server with proper IF NOT EXISTS
            // SQL Server 2016+ syntax:
            String createSql =
                    "IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'" + tableName + "') AND type in (N'U')) " +
                            "BEGIN " +
                            "CREATE TABLE " + tableName + " (id INT IDENTITY(1,1) PRIMARY KEY, ";

            for (int i = 0; i < sanitizedColumns.size(); i++) {
                createSql += sanitizedColumns.get(i) + " NVARCHAR(MAX)";
                if (i < sanitizedColumns.size() - 1) {
                    createSql += ", ";
                }
            }
            createSql += ") END";

            jdbcTemplate.execute(createSql);

            // Build INSERT statement with sanitized column names
            String insertSql = "INSERT INTO " + tableName + " (" +
                    String.join(", ", sanitizedColumns) + ") VALUES (" +
                    String.join(", ", Collections.nCopies(sanitizedColumns.size(), "?")) + ")";

            jdbcTemplate.batchUpdate(insertSql, new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Map<String, Object> row = rows.get(i);
                    int idx = 1;
                    for (String rawCol : rawColumns) {
                        String sanitizedCol = rawToSanitized.get(rawCol);
                        Object val = row.get(rawCol);
                        ps.setObject(idx++, val);
                    }
                }

                @Override
                public int getBatchSize() {
                    return rows.size();
                }
            });

            totalInserted += rows.size();
        }

        return "Inserted " + totalInserted + " rows into " + arrays.size() + " table(s)";
    }

    private String sanitizeColumnName(String rawName) {
        // Replace dots, spaces, and other non-alphanumeric chars with underscore
        return rawName.replaceAll("[^a-zA-Z0-9]", "_");
    }

    /**
     * Recursively find all arrays of JSON objects.
     */
    private void findAllArrays(JsonNode node, String path, Map<String, List<JsonNode>> arrays) {
        if (node.isArray() && node.size() > 0 && node.get(0).isObject()) {
            arrays.put(path.isEmpty() ? "root" : path, new ArrayList<>());
            node.forEach(arrays.get(path.isEmpty() ? "root" : path)::add);
        } else if (node.isObject()) {
            node.fields().forEachRemaining(entry ->
                    findAllArrays(entry.getValue(), path.isEmpty() ? entry.getKey() : path + "_" + entry.getKey(), arrays)
            );
        }
    }

    /**
     * Fully flatten an object node using dot notation.
     */
    private Map<String, Object> flatten(JsonNode node) {
        Map<String, Object> result = new LinkedHashMap<>();
        flattenRecursive(node, "", result);
        return result;
    }

    private void flattenRecursive(JsonNode node, String prefix, Map<String, Object> result) {
        if (node.isObject()) {
            node.fields().forEachRemaining(entry ->
                    flattenRecursive(entry.getValue(), prefix.isEmpty() ? entry.getKey() : prefix + "." + entry.getKey(), result)
            );
        } else if (node.isArray()) {
            // skip nested arrays for DB
        } else {
            result.put(prefix, node.isNull() ? null : node.asText());
        }
    }
}
