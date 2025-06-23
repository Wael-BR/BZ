package tn.bz.schemabinding.service;

import com.sun.codemodel.JCodeModel;
import org.jsonschema2pojo.*;
import org.jsonschema2pojo.rules.RuleFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Service
public class JsonToPojoService {

    public String generateFromJson(MultipartFile jsonFile) {
        try {
            String fileName = jsonFile.getOriginalFilename();
            if (fileName == null || !fileName.endsWith(".json")) {
                throw new IllegalArgumentException("Invalid JSON file.");
            }

            String baseName = fileName.replace(".json", "");
            String packageName = "tn.bz.schemabinding.entity.entitiesFromJson." + baseName;
            String simpleName = baseName.substring(0, 1).toUpperCase() + baseName.substring(1);

            // Output directory
            File outputDir = new File("src/main/java");

            // Create temporary file
            Path tempJsonFile = Files.createTempFile("upload-", ".json");
            try (InputStream inputStream = jsonFile.getInputStream()) {
                Files.copy(inputStream, tempJsonFile, StandardCopyOption.REPLACE_EXISTING);
            }

            // Setup JSONSchema2Pojo
            JCodeModel codeModel = new JCodeModel();
            GenerationConfig config = new DefaultGenerationConfig() {
                @Override
                public boolean isUseLongIntegers() {
                    return true;
                }

                @Override
                public SourceType getSourceType() {
                    return SourceType.JSON;
                }

                @Override
                public boolean isIncludeJsr303Annotations() {
                    return true;
                }

                public boolean isIncludeJPAAnnotations() {
                    return true;
                }
            };

            SchemaMapper mapper = new SchemaMapper(
                    new RuleFactory(config, new Jackson2Annotator(config), new SchemaStore()),
                    new SchemaGenerator()
            );

            mapper.generate(codeModel, simpleName, packageName, tempJsonFile.toUri().toURL());
            codeModel.build(outputDir);

            Files.deleteIfExists(tempJsonFile);

            return "Java classes generated in package: " + packageName;

        } catch (Exception e) {
            throw new RuntimeException("Failed to generate Java classes: " + e.getMessage(), e);
        }
    }
}
