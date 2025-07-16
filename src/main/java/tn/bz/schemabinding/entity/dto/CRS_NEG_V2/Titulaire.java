package tn.bz.schemabinding.entity.dto.CRS_NEG_V2;

import lombok.Data;

@Data
public class Titulaire {
    private String TypeTitul;
    private String TypeIdentifiant;
    private String CodeIdentifiant;
    private String Nom;
    private String Prenom;
    private String Nationalite;
    private String RaisSociale;
}
