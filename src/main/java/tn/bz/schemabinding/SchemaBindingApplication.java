package tn.bz.schemabinding;

import com.fasterxml.jackson.databind.ObjectMapper;
import tn.bz.schema.crsneg.Document;
import tn.bz.schema.crsneg.ObjectFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.File;

@SpringBootApplication
public class SchemaBindingApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SchemaBindingApplication.class, args);
        System.out.println("Schema Binding");
        ObjectFactory factory = new ObjectFactory();

        // Create root Document
        Document document = factory.createDocument();

        // Create nested objects
        Document.EnteteDoc enteteDoc = factory.createDocumentEnteteDoc();
        Document.Extraits extraits = factory.createDocumentExtraits();
        Document.Extraits.Extrait extrait = factory.createDocumentExtraitsExtrait();
        Document.Extraits.Extrait.Details details = factory.createDocumentExtraitsExtraitDetails();
        Document.Extraits.Extrait.Details.Detail detail = factory.createDocumentExtraitsExtraitDetailsDetail();
        Document.Extraits.Extrait.Details.Detail.RefOperation refOp = factory.createDocumentExtraitsExtraitDetailsDetailRefOperation();
        Document.Extraits.Extrait.Details.Detail.RefAutorisationBct refAuto = factory.createDocumentExtraitsExtraitDetailsDetailRefAutorisationBct();
        Document.Extraits.Extrait.Entete entete = factory.createDocumentExtraitsExtraitEntete();
        Document.Extraits.Extrait.Entete.RefCompte refCompte = factory.createDocumentExtraitsExtraitEnteteRefCompte();
        Document.Extraits.Extrait.Entete.Titulaire titulaire = factory.createDocumentExtraitsExtraitEnteteTitulaire();

        // Populate example fields (replace with real setters from your classes)
        // e.g. refOp.setCode("XYZ123");
        // detail.setSomeField("value");

        // Build the structure
        detail.setRefOperation(refOp);
        detail.setRefAutorisationBct(refAuto);
        details.getDetails().add(detail);
        extrait.setDetails(details);
        entete.setRefCompte(refCompte);
        entete.setTitulaire(titulaire);
        extrait.setEntete(entete);
        extraits.getExtraits().add(extrait);
        document.setExtraits(extraits);
        document.setEnteteDoc(enteteDoc);

        System.out.println("Generating JSON...");

        // Convert to JSON
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(document);

        System.out.println(json);

        /*******************      hedhi output file .json **********************************/
        /**           output.json tetbadel 7asseb kol esm file .xsd **/
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/java/tn/bz/schemabinding/json_output/output.json"), document);
        System.out.println("✅ JSON written to output.json");




    }

}
