package tn.bz.schemabinding.generated;

import com.fasterxml.jackson.databind.ObjectMapper;
import tn.bz.schema.crsnegv2.ObjectFactory;
import tn.bz.schema.crsnegv2.Document;

public class JsonGen_Crsnegv2 {
    public static void main(String[] args) throws Exception {
        ObjectFactory factory = new ObjectFactory();
        Document document = factory.createDocument();

        // TODO: Optionally populate fields here if needed

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(document);
        System.out.println(json);

        java.io.File output = new java.io.File("src/main/resources/json_output/crsnegv2.json");
        output.getParentFile().mkdirs();
        mapper.writerWithDefaultPrettyPrinter().writeValue(output, document);
        System.out.println("✅ JSON written to " + output.getPath());
    }
}
