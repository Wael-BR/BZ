package tn.bz.schemabinding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.bz.schemabinding.service.SchemaBindingUtils;
import tn.bz.schemabinding.service.SchemaService;

import java.io.File;
import java.util.*;

@RestController
@RequestMapping("/api")
public class SchemaController {

    @Autowired
    private SchemaService schemaService;

    @GetMapping("/classes")
    public Set<String> listAvailableClasses() {
        return schemaService.listAvailableClasses();
    }

    @GetMapping("/generate-json")
    public Object generateJson(@RequestParam String className) throws Exception {
        Class<?> clazz = schemaService.getClassByName(className);
        Map<String, Object> structure = new LinkedHashMap<>();
        structure.put(clazz.getSimpleName(), SchemaBindingUtils.buildJsonStructure(clazz));

        // Create the file path: src/main/resources/json_output/{packageName}.json
        String packageName = clazz.getPackage().getName();
        String lastPackage = packageName.substring(packageName.lastIndexOf('.') + 1);

        File outputFile = new File("src/main/resources/json_output", lastPackage + ".json");
        outputFile.getParentFile().mkdirs(); // Ensure directory exists

        // Write the JSON to the file
        new com.fasterxml.jackson.databind.ObjectMapper()
                .writerWithDefaultPrettyPrinter()
                .writeValue(outputFile, structure);

        return structure;
    }

}
