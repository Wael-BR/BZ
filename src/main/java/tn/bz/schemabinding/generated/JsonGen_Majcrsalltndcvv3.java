package tn.bz.schemabinding.generated;

import com.fasterxml.jackson.databind.ObjectMapper;
import tn.bz.schema.majcrsalltndcvv3.ObjectFactory;
import tn.bz.schema.majcrsalltndcvv3.Document;

public class JsonGen_Majcrsalltndcvv3 {
    public static void main(String[] args) throws Exception {
        ObjectFactory factory = new ObjectFactory();
        Document document = factory.createDocument();

        // TODO: Optionally populate fields here if needed

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(document);
        System.out.println(json);

        java.io.File output = new java.io.File("src/main/resources/json_output/majcrsalltndcvv3.json");
        output.getParentFile().mkdirs();
        mapper.writerWithDefaultPrettyPrinter().writeValue(output, document);
        System.out.println("✅ JSON written to " + output.getPath());
    }
}
