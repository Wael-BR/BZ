package tn.bz.schemabinding.util;

import java.sql.*;
import java.util.*;

public class DynamicCodeGenerator {

    public static String generateDtoFromTable(Connection conn, String tableName, String className, String packageName) throws SQLException {
        StringBuilder sb = new StringBuilder("package " + packageName + ";\n\nimport lombok.Data;\n\n@Data\npublic class " + className + " {\n");

        DatabaseMetaData metaData = conn.getMetaData();
        String catalog = conn.getCatalog();
        String schema = "dbo";

        try (ResultSet columns = metaData.getColumns(catalog, schema, tableName, null)) {
            while (columns.next()) {
                String colName = columns.getString("COLUMN_NAME");
                int dataType = columns.getInt("DATA_TYPE");

                String fieldType = mapSqlTypeToJava(dataType);
                sb.append("    private ").append(fieldType).append(" ").append(toCamel(colName)).append(";\n");
            }
        }

        sb.append("}\n");
        return sb.toString();
    }

    private static String toCamel(String s) {
        return s.substring(0, 1).toLowerCase() + s.substring(1).replaceAll("[^a-zA-Z0-9]", "");
    }

    private static String mapSqlTypeToJava(int sqlType) {
        switch (sqlType) {
            case Types.INTEGER: return "Integer";
            case Types.FLOAT:
            case Types.DOUBLE:
            case Types.REAL: return "Double";
            case Types.DECIMAL:
            case Types.NUMERIC: return "java.math.BigDecimal";
            case Types.DATE:
            case Types.TIMESTAMP: return "java.sql.Timestamp";
            case Types.BOOLEAN: return "Boolean";
            default: return "String";
        }
    }
}
