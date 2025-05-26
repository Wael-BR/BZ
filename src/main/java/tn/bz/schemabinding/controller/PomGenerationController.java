package tn.bz.schemabinding.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.bz.schemabinding.service.PomGenerationService;

@RestController
@RequestMapping("/api/pom")
public class PomGenerationController {

    private final PomGenerationService service;

    public PomGenerationController(PomGenerationService service) {
        this.service = service;
    }

    @PostMapping("/generate")
    public ResponseEntity<String> generatePom() {
        try {
            String result = service.generateAndWritePom();
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }
}
