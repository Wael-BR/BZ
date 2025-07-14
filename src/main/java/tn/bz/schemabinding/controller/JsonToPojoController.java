package tn.bz.schemabinding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.bz.schemabinding.service.notNeeded.JsonToPojoService;

@RestController
@RequestMapping("/api/json2pojo")
public class JsonToPojoController {

    @Autowired
    private JsonToPojoService jsonToPojoService;

    @PostMapping("/generate")
    public ResponseEntity<String> generateFromJson(@RequestParam("file") MultipartFile jsonFile) {
        String result = jsonToPojoService.generateFromJson(jsonFile);
        return ResponseEntity.ok(result);
    }
}