package tn.bz.schemabinding.service;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
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

        document.getDocumentElement().normalize();

        NodeList allElements = document.getElementsByTagName("*");

        for (int i = 0; i < allElements.getLength(); i++) {
            Element parent = (Element) allElements.item(i);

            Element valueElement = getDirectChildByTagName(parent, "Value");
            Element ccyElement = getDirectChildByTagName(parent, "Ccy");

            if (valueElement != null && ccyElement != null) {
                String value = valueElement.getTextContent();
                String ccy = ccyElement.getTextContent();

                // Remove all children
                while (parent.hasChildNodes()) {
                    parent.removeChild(parent.getFirstChild());
                }

                // Set content and attribute
                parent.setTextContent("null".equals(value) ? "" : value);
                parent.setAttribute("Ccy", "null".equals(ccy) ? "" : ccy);
            }
        }

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

        StringWriter writer = new StringWriter();
        transformer.transform(new DOMSource(document), new StreamResult(writer));
        return writer.toString();
    }

    private Element getDirectChildByTagName(Element parent, String tagName) {
        NodeList children = parent.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            if (children.item(i) instanceof Element) {
                Element child = (Element) children.item(i);
                if (child.getTagName().equals(tagName)) {
                    return child;
                }
            }
        }
        return null;
    }


    public String convertJsonStringToXmlAndSave(String jsonContent, String outputFileName, String rootElementName) throws Exception {
        String sanitizedRoot = sanitizeElementName(rootElementName);

        // Convert to raw XML
        JSONObject jsonObject = new JSONObject(jsonContent);
        String rawXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<" + sanitizedRoot + ">" +
                XML.toString(jsonObject, sanitizedRoot) +
                "</" + sanitizedRoot + ">";

        // Format
        String prettyXml = formatXml(rawXml);

        // Save
        if (!outputFileName.endsWith(".xml")) {
            outputFileName += ".xml";
        }
        Path outputPath = Path.of("src/main/resources/xml_output", outputFileName);
        Files.createDirectories(outputPath.getParent());

        try (FileWriter writer = new FileWriter(outputPath.toFile())) {
            writer.write(prettyXml);
        }

        return "XML written to: " + outputPath.toAbsolutePath();
    }



    /*** thi s method is just to ensure the rootElementName is well written  ***/
    private String sanitizeElementName(String name) {
        if (name == null || name.isEmpty()) {
            return "root";
        }

        String sanitized = name.replaceAll("[^a-zA-Z0-9_-]", "_");
        if (!sanitized.matches("^[a-zA-Z].*")) {
            sanitized = "root_" + sanitized;
        }
        return sanitized;
    }

}
