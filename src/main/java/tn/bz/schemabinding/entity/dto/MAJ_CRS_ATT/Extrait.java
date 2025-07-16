package tn.bz.schemabinding.entity.dto.MAJ_CRS_ATT;

import lombok.Data;

import java.util.List;

@Data
public class Extrait {
    private Entete Entete;
    private List<DetailWrapper> Details;
}
