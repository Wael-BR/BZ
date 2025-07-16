package tn.bz.schemabinding.entity.dto.CRS_PPR_V2;

import lombok.Data;

@Data
public class RefCompte {
    private String Rib;
    private String DeviseCpte;
    private String DateOuvCpte;
    private String EtatCpte;
    private String DateclotureCpte;
    private String DateGelCpte;
    private String NumAutBCT;
    private String DateAutBCT;
    private Amount SoldDebMois;
    private Amount SoldfinMois;
}
