package tn.bz.schemabinding.entity.dto.MAJ_CRS_ALL_TNDCV_V3;

import lombok.Data;

@Data
public class Entete {
    private String AgenceDom;
    private Titulaire Titulaire;
    private RefCompte RefCompte;
    private Integer NbrEcritures;
}
