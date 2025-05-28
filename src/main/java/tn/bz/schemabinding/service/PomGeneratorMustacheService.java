package tn.bz.schemabinding.service;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.bz.schemabinding.entity.XsdEntry;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class PomGeneratorMustacheService {

    public String generatePomXml() throws IOException {
        // Step 1: Collect all .xsd files from resources
        Path xsdDir = Paths.get("src/main/resources/xsd");
        if (!Files.exists(xsdDir)) {
            throw new IOException("XSD directory not found at: " + xsdDir.toAbsolutePath());
        }

        List<XsdEntry> xsdEntries = Files.list(xsdDir)
                .filter(path -> path.toString().endsWith(".xsd"))
                .map(path -> new XsdEntry(path.getFileName().toString()))
                .collect(Collectors.toList());

        // Prepare data context for Mustache
        Map<String, Object> context = new HashMap<>();
        context.put("groupId", "tn.bz");
        context.put("artifactId", "schema-binding");
        context.put("version", "1.0-SNAPSHOT");
        context.put("packageSuffix", "schema");
        context.put("xsdEntries", xsdEntries);

        // Step 3: Load and compile template
        String template = Files.readString(Paths.get("src/main/resources/templates/pom.mustache"));
        Template mustacheTemplate = Mustache.compiler().compile(template);

        // Step 4: Generate content
        String generatedPom = mustacheTemplate.execute(context);

        // Step 5: Write to pom.xml
        Path pomPath = Paths.get("pom.xml");
        Files.writeString(pomPath, generatedPom);
        return "pom.xml has been successfully generated at: " + pomPath.toAbsolutePath();

    }
}

