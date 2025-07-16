package tn.bz.schemabinding.controller.jsonexport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.bz.schemabinding.entity.dto.CRS_PPR_V2.DocumentWrapper;
import tn.bz.schemabinding.service.jsonexport.Json_PPR_ExportService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/json")
public class Json_PPR_ExportController {

    @Autowired
    private Json_PPR_ExportService jsonExportService;

    @GetMapping("/PPR")
    public ResponseEntity<DocumentWrapper> exportJson() {
        List<Map<String, Object>> rows = jsonExportService.fetchRawData();
        DocumentWrapper wrapper = jsonExportService.convertToDocument(rows);
        return ResponseEntity.ok(wrapper);
    }
}
