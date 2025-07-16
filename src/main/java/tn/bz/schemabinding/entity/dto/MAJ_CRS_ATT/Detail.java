package tn.bz.schemabinding.entity.dto.MAJ_CRS_ATT;

import lombok.Data;

@Data
public class Detail {
    private String Rib;
    private RefOperation RefOperation;
    private RefAutorisationBct RefAutorisationBct;
    private String DenomBenif;
    private String Pays;
}
