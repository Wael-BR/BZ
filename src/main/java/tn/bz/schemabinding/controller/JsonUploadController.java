package tn.bz.schemabinding.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.bz.schemabinding.service.GenericJsonToDbService;

@RestController
@RequestMapping("/api/json-upload")
public class JsonUploadController {

    private final GenericJsonToDbService service;

    public JsonUploadController(GenericJsonToDbService service) {
        this.service = service;
    }

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<String> uploadJson(@RequestParam("file") MultipartFile file) throws Exception {
        String baseTableName = file.getOriginalFilename().replace(".json", "").replaceAll("[^a-zA-Z0-9_]", "_");
        String result = service.processJsonFile(baseTableName, file.getInputStream());
        return ResponseEntity.ok(result);
    }
}
