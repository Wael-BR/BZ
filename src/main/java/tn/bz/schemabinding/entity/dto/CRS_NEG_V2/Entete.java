package tn.bz.schemabinding.entity.dto.CRS_NEG_V2;

import lombok.Data;

@Data
public class Entete {
    private String AgenceDom;
    private Titulaire Titulaire;
    private RefCompte RefCompte;
    private Integer NbrEcritures;
}
