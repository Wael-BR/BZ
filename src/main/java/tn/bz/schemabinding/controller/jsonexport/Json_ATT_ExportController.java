package tn.bz.schemabinding.controller.jsonexport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.bz.schemabinding.entity.dto.MAJ_CRS_ATT.DocumentWrapper;
import tn.bz.schemabinding.service.jsonexport.Json_ATT_ExportService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/json")
public class Json_ATT_ExportController {
    @Autowired
    private Json_ATT_ExportService exportService;

    @GetMapping("/ATT")
    public ResponseEntity<DocumentWrapper> exportDocument() {
        List<Map<String, Object>> data = exportService.fetchData();
        DocumentWrapper document = exportService.convertToDocument(data);

        if (document == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(document);
    }
}
