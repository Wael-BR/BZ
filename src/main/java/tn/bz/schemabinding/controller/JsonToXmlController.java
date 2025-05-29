package tn.bz.schemabinding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.bz.schemabinding.service.JsonToXmlService;

@RestController
@RequestMapping("/api/generic-convert")
public class JsonToXmlController {

    @Autowired
    private JsonToXmlService service;

    @PostMapping("/{fileName}")
    public String convertAndSaveToFile(
            @PathVariable String fileName,
            @RequestParam(defaultValue = "root") String rootElementName
    ) throws Exception {
        return service.convertJsonToXmlAndSave(fileName, rootElementName);
    }

    @PostMapping("/upload")
    public String convertAndSaveFromUpload(
            @RequestParam("file") MultipartFile fileName,
            @RequestParam(defaultValue = "root") String rootElementName,
            @RequestParam(defaultValue = "uploaded") String outputFileName
    ) throws Exception {
        String jsonContent = new String(fileName.getBytes());

        return service.convertJsonStringToXmlAndSave(jsonContent, outputFileName, rootElementName);
    }
}
