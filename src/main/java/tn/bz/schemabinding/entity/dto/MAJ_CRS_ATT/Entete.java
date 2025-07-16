package tn.bz.schemabinding.entity.dto.MAJ_CRS_ATT;

import lombok.Data;

@Data
public class Entete {
    private String AgenceDom;
    private Titulaire Titulaire;
    private RefCompte RefCompte;
    private Integer NbrEcritures;
}
