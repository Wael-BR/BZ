package tn.bz.schemabinding.service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.util.Locale;

@Service
public class PomGenerationService {

    private static final String BASE_PACKAGE = "tn.bz.schema.";

    public String generateAndWritePom() throws Exception {
        File xsdDir = new File("src/main/resources/xsd");
        File[] xsdFiles = xsdDir.listFiles((dir, name) -> name.toLowerCase(Locale.ROOT).endsWith(".xsd"));

        if (xsdFiles == null || xsdFiles.length == 0) {
            throw new RuntimeException("No XSD files found.");
        }

        StringBuilder executionsBlock = new StringBuilder();
        StringBuilder sourcesBlock = new StringBuilder();

        for (File file : xsdFiles) {
            String filename = file.getName();
            String baseName = filename.substring(0, filename.lastIndexOf('.'));
            String id = baseName.toLowerCase().replaceAll("[^a-z0-9]", "-");
            String pkg = BASE_PACKAGE + baseName.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");

            executionsBlock.append("                    <execution>\n")
                    .append("                        <id>generate-").append(id).append("</id>\n")
                    .append("                        <phase>generate-sources</phase>\n")
                    .append("                        <goals>\n")
                    .append("                            <goal>xjc</goal>\n")
                    .append("                        </goals>\n")
                    .append("                        <configuration>\n")
                    .append("                            <sources>\n")
                    .append("                                <source>src/main/resources/xsd/").append(filename).append("</source>\n")
                    .append("                            </sources>\n")
                    .append("                            <outputDirectory>${project.basedir}/src/main/java</outputDirectory>\n")
                    .append("                            <packageName>").append(pkg).append("</packageName>\n")
                    .append("                            <clearOutputDir>false</clearOutputDir>\n")
                    .append("                        </configuration>\n")
                    .append("                    </execution>\n");

            sourcesBlock.append("                                        <source>${project.build.directory}/generated-sources/jaxb/")
                    .append(id).append("</source>\n");
        }

        String staticPomTemplate = Files.readString(new File("src/main/resources/static/pom-static-template.xml").toPath());

        String finalPom = staticPomTemplate
                .replace("<!--__JAXB_EXECUTIONS__-->", executionsBlock.toString())
                .replace("<!--__BUILD_HELPER_SOURCES__-->", sourcesBlock.toString());

        try (FileWriter writer = new FileWriter("pom.xml")) {
            writer.write(finalPom);
        }

        return "pom.xml generated successfully.";
    }
}
