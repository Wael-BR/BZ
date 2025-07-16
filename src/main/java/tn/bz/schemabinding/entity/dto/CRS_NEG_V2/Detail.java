package tn.bz.schemabinding.entity.dto.CRS_NEG_V2;

import lombok.Data;
import tn.bz.schemabinding.entity.dto.CRS_NEG_V2.RefOperation;
import tn.bz.schemabinding.entity.dto.CRS_NEG_V2.RefFicheInformation;
import tn.bz.schemabinding.entity.dto.CRS_NEG_V2.RefAutorisationBct;
import tn.bz.schemabinding.entity.dto.CRS_NEG_V2.DecDouane;

@Data
public class Detail {
    private String Rib;
    private RefOperation RefOperation;
    private RefFicheInformation RefFicheInformation;
    private RefAutorisationBct RefAutorisationBct;
    private DecDouane DecDouane;
    private String NomFourniClient;
    private String DenomBenif;
    private String Pays;
}
