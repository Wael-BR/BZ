package tn.bz.schemabinding.entity.dto.MAJ_CRS_ATT;

import lombok.Data;

@Data
public class Titulaire {
    private String TypeTitul;
    private String TypeIdentifiant;
    private String CodeIdentifiant;
    private String Nom;
    private String Prenom;
    private String RaisSociale;
    private String Nationalite;
}
