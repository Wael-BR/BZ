package tn.bz.schemabinding.controller.jsonexport;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.bz.schemabinding.entity.dto.MAJ_CRS_ALL_TNDCV_V3.DocumentWrapper;
import tn.bz.schemabinding.service.jsonexport.Json_ALL_ExportService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/json")
public class Json_ALL_ExportController {
    @Autowired
    private Json_ALL_ExportService jsonExportService;

    @GetMapping("/ALL")
    public DocumentWrapper exportJson() {
        List<Map<String, Object>> rawData = jsonExportService.fetchRawData();
        return jsonExportService.convertToDocument(rawData);
    }
}
