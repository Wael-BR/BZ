package generated.to_json;

import com.fasterxml.jackson.databind.ObjectMapper;
import generated.Document;
import generated.ObjectFactory;

public class ToJsonExample {
    public static void main(String[] args) throws Exception {
        ObjectFactory factory = new ObjectFactory();

        // Create root Document
        Document document = factory.createDocument();

        // Create nested objects
        Document.Extraits extraits = factory.createDocumentExtraits();
        Document.Extraits.Extrait extrait = factory.createDocumentExtraitsExtrait();
        Document.Extraits.Extrait.Details details = factory.createDocumentExtraitsExtraitDetails();
        Document.Extraits.Extrait.Details.Detail detail = factory.createDocumentExtraitsExtraitDetailsDetail();
        Document.Extraits.Extrait.Details.Detail.RefOperation refOp = factory.createDocumentExtraitsExtraitDetailsDetailRefOperation();
        Document.Extraits.Extrait.Entete entete = factory.createDocumentExtraitsExtraitEntete();
        Document.Extraits.Extrait.Entete.RefCompte refCompte = factory.createDocumentExtraitsExtraitEnteteRefCompte();
        Document.Extraits.Extrait.Entete.Titulaire titulaire = factory.createDocumentExtraitsExtraitEnteteTitulaire();

        // Populate example fields (replace with real setters from your classes)
        // e.g. refOp.setCode("XYZ123");
        // detail.setSomeField("value");

        // Build the structure
        detail.setRefOperation(refOp);
        details.getDetails().add(detail);
        extrait.setDetails(details);
        entete.setRefCompte(refCompte);
        entete.setTitulaire(titulaire);
        extrait.setEntete(entete);
        extraits.getExtraits().add(extrait);
        document.setExtraits(extraits);

        System.out.println("Generating JSON...");

        // Convert to JSON
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(document);

        System.out.println(json);
    }
}