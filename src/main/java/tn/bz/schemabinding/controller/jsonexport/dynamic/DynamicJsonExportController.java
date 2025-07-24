package tn.bz.schemabinding.controller.jsonexport.dynamic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.bz.schemabinding.service.jsonexport.dynamic.DynamicJsonExportService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/dynamic")
public class DynamicJsonExportController {
    @Autowired
    private DynamicJsonExportService service;

    @GetMapping("/json")
    public ResponseEntity<?> exportTable(@RequestParam String table) {
        try {
            List<Map<String, Object>> data = service.fetchTableData(table);
            return data.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(data);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error fetching data: " + e.getMessage());
        }
    }

    /*** follow the json structure kima kenou ***/
    @GetMapping("/json-structured")
    public ResponseEntity<?> exportStructuredJson(@RequestParam String table) {
        try {
            List<Map<String, Object>> rows = service.fetchTableData(table);
            if (rows.isEmpty()) return ResponseEntity.noContent().build();
            Map<String, Object> json = service.convertToStructuredJson(rows);
            return ResponseEntity.ok(json);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    /**
     * Save the structured JSON to file under src/main/resources/ssms_to_json/{table}.json
     */
    @PostMapping("/json-structured/save")
    public ResponseEntity<?> saveStructuredJsonToFile(@RequestParam String table) {
        try {
            List<Map<String, Object>> rows = service.fetchTableData(table);
            if (rows.isEmpty()) return ResponseEntity.noContent().build();

            Map<String, Object> json = service.convertToStructuredJson(rows);
            service.exportJsonToFile(json, table);

            String fileName = table.substring(table.lastIndexOf('.') + 1) + ".json";
            return ResponseEntity.ok("✅ JSON exported to src/main/resources/ssms_to_json/" + fileName);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error saving JSON: " + e.getMessage());
        }
    }
}
