package tn.bz.schemabinding.controller.jsonexport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.bz.schemabinding.entity.dto.CRS_NEG_V2.DocumentWrapper;
import tn.bz.schemabinding.service.jsonexport.Json_NEG_ExportService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/json")
public class Json_NEG_ExportController {
    @Autowired
    private Json_NEG_ExportService jsonExportService;

    @GetMapping("/NEG")
    public DocumentWrapper exportJson() {
        List<Map<String, Object>> rawData = jsonExportService.fetchRawData();
        return jsonExportService.convertToDocument(rawData);
    }
}
