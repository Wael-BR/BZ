package tn.bz.schemabinding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.bz.schemabinding.service.PomGeneratorMustacheService;

import java.io.IOException;

@RestController
@RequestMapping("/generate")
public class PomController {

    @Autowired
    private PomGeneratorMustacheService pomGeneratorService;

    @PostMapping("/pom")
    public String generatePom() {
        try {
            return pomGeneratorService.generatePomXml();
        } catch (IOException e) {
            return "Error: " + e.getMessage();
        }
    }
}
