package tn.bz.schemabinding.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.*;

@Service
public class GenericJsonToDbService {

    private final JdbcTemplate jdbcTemplate;

    public GenericJsonToDbService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String createTableFromJson(String baseTableName, InputStream inputStream) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(inputStream);

        Set<String> rawColumns = new LinkedHashSet<>();
        collectAllPaths(root, "", rawColumns);

        if (rawColumns.isEmpty()) {
            throw new IllegalArgumentException("No usable fields found in JSON!");
        }

        // Keep only last two segments of each path
        List<String> sanitizedColumns = new ArrayList<>();
        Set<String> used = new HashSet<>();
        for (String fullPath : rawColumns) {
            String[] parts = fullPath.split("_");
            String shortName = parts.length >= 2
                    ? parts[parts.length - 2] + "_" + parts[parts.length - 1]
                    : fullPath;
            String sanitized = sanitizeColumnName(shortName);

            // Ensure uniqueness
            String uniqueName = sanitized;
            int counter = 1;
            while (used.contains(uniqueName)) {
                uniqueName = sanitized + "_" + counter++;
            }
            sanitizedColumns.add(uniqueName);
            used.add(uniqueName);
        }

        // Sanitize table name
        String tableName = baseTableName.replaceAll("[^a-zA-Z0-9_]", "_");

        // Generate CREATE TABLE SQL
        StringBuilder sql = new StringBuilder();
        sql.append("IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'")
                .append(tableName).append("') AND type in (N'U')) BEGIN CREATE TABLE ")
                .append(tableName).append(" (id INT IDENTITY(1,1) PRIMARY KEY, ");
        for (int i = 0; i < sanitizedColumns.size(); i++) {
            sql.append(sanitizedColumns.get(i)).append(" NVARCHAR(MAX)");
            if (i < sanitizedColumns.size() - 1) sql.append(", ");
        }
        sql.append(") END");

        jdbcTemplate.execute(sql.toString());

        return "Created table [" + tableName + "] with " + sanitizedColumns.size() + " columns.";
    }

    private void collectAllPaths(JsonNode node, String path, Set<String> fields) {
        if (node == null) return;

        if (node.isObject()) {
            node.fields().forEachRemaining(entry -> {
                String newPath = path.isEmpty() ? entry.getKey() : path + "_" + entry.getKey();
                collectAllPaths(entry.getValue(), newPath, fields);
            });
        } else if (node.isArray()) {
            for (JsonNode element : node) {
                collectAllPaths(element, path, fields);
            }
        } else {
            fields.add(path);
        }
    }

    private String sanitizeColumnName(String rawName) {
        return rawName.replaceAll("[^a-zA-Z0-9]", "_");
    }
}
