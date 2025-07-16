package tn.bz.schemabinding.entity.dto.CRS_NEG_V2;

import lombok.Data;

import java.util.List;

@Data
public class Extrait {
    private Entete Entete;
    private List<DetailWrapper> Details;
}
