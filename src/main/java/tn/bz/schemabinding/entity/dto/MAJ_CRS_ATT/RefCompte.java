package tn.bz.schemabinding.entity.dto.MAJ_CRS_ATT;

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
