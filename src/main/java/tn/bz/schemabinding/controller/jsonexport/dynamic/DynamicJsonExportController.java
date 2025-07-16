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
}
