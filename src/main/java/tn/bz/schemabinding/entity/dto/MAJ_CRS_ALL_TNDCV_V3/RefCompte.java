package tn.bz.schemabinding.entity.dto.MAJ_CRS_ALL_TNDCV_V3;

import lombok.Data;

@Data
public class RefCompte {
    private String Rib;
    private String DateOuvCpte;
    private String EtatCpte;
    private String DateclotureCpte;
    private String DateGelCpte;
    private Amount SoldDebMois;
    private Amount SoldfinMois;
}
