package tn.bz.schemabinding.service;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;
import org.springframework.stereotype.Service;
import tn.bz.schemabinding.entity.XsdEntry;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PomGeneratorMustacheService {

    public String generatePomXml() throws IOException, InterruptedException {
        // Step 1: Collect all .xsd files from resources
        Path xsdDir = Paths.get("src/main/resources/xsd");
        if (!Files.exists(xsdDir)) {
            throw new IOException("XSD directory not found at: " + xsdDir.toAbsolutePath());
        }

        List<XsdEntry> xsdEntries = Files.list(xsdDir)
                .filter(path -> path.toString().endsWith(".xsd"))
                .map(path -> new XsdEntry(path.getFileName().toString()))
                .collect(Collectors.toList());

        // Step 2: Prepare data context for Mustache
        Map<String, Object> context = new HashMap<>();
        context.put("groupId", "tn.bz");
        context.put("artifactId", "schema-binding");
        context.put("version", "1.0-SNAPSHOT");
        context.put("xsdEntries", xsdEntries);

        // Step 3: Load and compile template
        String template = Files.readString(Paths.get("src/main/resources/templates/pom.mustache"));
        Template mustacheTemplate = Mustache.compiler().compile(template);

        // Step 4: Generate content
        String generatedPom = mustacheTemplate.execute(context);

        // Step 5: Write to pom.xml
        Path pomPath = Paths.get("pom.xml");
        Files.writeString(pomPath, generatedPom);

        // Step 6: Run Maven compile
        String output = runMavenCompile();

        return "pom.xml generated at: " + pomPath.toAbsolutePath() + "\nMaven output:\n" + output;
    }

    private String runMavenCompile() throws IOException, InterruptedException {
        try {
            ProcessBuilder builder = new ProcessBuilder("C:\\Program Files\\apache-maven-3.9.9\\bin\\mvn.cmd", "compile");
            builder.directory(new File(".")); // Set working directory to the current project root
            builder.redirectErrorStream(true); // Merge stderr with stdout

            Process process = builder.start();

            StringBuilder output = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    output.append(line).append(System.lineSeparator());
                    System.out.println(line); // Optional: print to console for live tracking
                }
            }

            int exitCode = process.waitFor();
            if (exitCode != 0) {
                throw new RuntimeException("Maven compile failed with exit code: " + exitCode + "\n" + output);
            }

            return "Maven compile executed successfully:\n" + output;
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Failed to run Maven compile: " + e.getMessage(), e);
        }
    }
}
