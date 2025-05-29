package tn.bz.schemabinding.service;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import javax.xml.transform.*;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class JsonToXmlService {
    public String convertJsonToXmlAndSave(String jsonFileName, String rootElementName) throws Exception {
        // Read JSON file
        File inputFile = new ClassPathResource("json_output/" + jsonFileName).getFile();
        String jsonContent = new String(Files.readAllBytes(inputFile.toPath()));

        // Convert to raw XML
        JSONObject jsonObject = new JSONObject(jsonContent);
        String rawXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<" + rootElementName + ">" +
                XML.toString(jsonObject, rootElementName) +
                "</" + rootElementName + ">";

        // Pretty print the XML
        String prettyXml = formatXml(rawXml);

        // Write to output file
        String outputFileName = jsonFileName.replace(".json", ".xml");
        Path outputPath = Path.of("src/main/resources/xml_output", outputFileName);
        Files.createDirectories(outputPath.getParent());

        try (FileWriter writer = new FileWriter(outputPath.toFile())) {
            writer.write(prettyXml);
        }

        return "XML written to: " + outputPath.toAbsolutePath();
    }

    private String formatXml(String inputXml) throws Exception {
        Document document = DocumentBuilderFactory.newInstance()
                .newDocumentBuilder()
                .parse(new InputSource(new StringReader(inputXml)));

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        // Optional: control indentation size (e.g. 2 spaces)
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

        StringWriter writer = new StringWriter();
        transformer.transform(new DOMSource(document), new StreamResult(writer));

        return writer.toString();
    }
}
