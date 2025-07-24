package tn.bz.schemabinding.service.jsonexport.dynamic;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@Service
public class DynamicJsonExportService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> fetchTableData(String tableName) {
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    /*** follow the json structure kima kenou ***/
    public Map<String, Object> convertToStructuredJson(List<Map<String, Object>> flatRows) {
        Map<String, Object> wrapper = new LinkedHashMap<>();
        Map<String, Object> document = new LinkedHashMap<>();
        wrapper.put("Document", document);

        // 1. Build EnteteDoc from first row
        Map<String, Object> first = flatRows.get(0);
        Map<String, Object> enteteDoc = extractByPrefix(first, "EnteteDoc_");
        document.put("EnteteDoc", enteteDoc);

        // 2. Build list of Extraits
        List<Map<String, Object>> extraits = new ArrayList<>();
        for (Map<String, Object> row : flatRows) {
            Map<String, Object> extraitWrapper = new LinkedHashMap<>();
            Map<String, Object> extrait = new LinkedHashMap<>();

            // Entete + nested parts
            Map<String, Object> entete = extractByPrefix(row, "Entete_");
            entete.put("Titulaire", extractByPrefix(row, "Titulaire_"));
            entete.put("RefCompte", extractByPrefix(row, "RefCompte_"));
            extrait.put("Entete", entete);

            // Details with nested parts
            Map<String, Object> detailWrapper = new LinkedHashMap<>();
            Map<String, Object> detail = extractByPrefix(row, "Detail_");
            detail.put("RefOperation", extractByPrefix(row, "RefOperation_"));
            detail.put("RefAutorisationBct", extractByPrefix(row, "RefAutorisationBct_"));
            detailWrapper.put("Detail", detail);
            extrait.put("Details", List.of(detailWrapper));

            extraitWrapper.put("Extrait", extrait);
            extraits.add(extraitWrapper);
        }

        document.put("Extraits", extraits);
        return wrapper;
    }

    private Map<String, Object> extractByPrefix(Map<String, Object> source, String prefix) {
        Map<String, Object> result = new LinkedHashMap<>();
        for (Map.Entry<String, Object> entry : source.entrySet()) {
            if (entry.getKey().startsWith(prefix)) {
                String cleanKey = entry.getKey().substring(prefix.length());
                result.put(cleanKey, entry.getValue());
            }
        }
        return result;
    }


    /**
     * Export given JSON data as pretty-printed file under
     * src/main/resources/ssms_to_json/{tableName}.json
     *
     * @param jsonData the structured JSON Map
     * @param fullTableName e.g. "spring.dbo.majcrsatt"
     * @throws Exception if file write fails
     */
    public void exportJsonToFile(Map<String, Object> jsonData, String fullTableName) throws Exception {
        String[] parts = fullTableName.split("\\.");
        String fileName = parts[parts.length - 1] + ".json";  // e.g. majcrsatt.json
        String dirPath = "src/main/resources/ssms_to_json";

        // Ensure directory exists
        Files.createDirectories(Paths.get(dirPath));

        File outputFile = new File(dirPath, fileName);

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.writeValue(outputFile, jsonData);

        System.out.println("✅ JSON exported to: " + outputFile.getAbsolutePath());
    }
}
