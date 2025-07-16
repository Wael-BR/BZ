package tn.bz.schemabinding.entity.dto.MAJ_CRS_ALL_TNDCV_V3;

import lombok.Data;

import java.util.List;

@Data
public class Document {
    private EnteteDoc EnteteDoc;
    private List<ExtraitWrapper> Extraits;
}
