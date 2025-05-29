package tn.bz.schemabinding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
}
