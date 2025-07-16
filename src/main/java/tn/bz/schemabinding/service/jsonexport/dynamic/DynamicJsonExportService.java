package tn.bz.schemabinding.service.jsonexport.dynamic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

}
