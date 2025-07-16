package tn.bz.schemabinding.entity.dto.CRS_PPR_V2;

import lombok.Data;

@Data
public class Detail {
    private String Rib;
    private RefOperation RefOperation;
    private RefFicheInformation RefFicheInformation;
    private RefAutorisationBct RefAutorisationBct;
    private DecDouane DecDouane;
    private String DenomBenif;
    private String Pays;
}
