package tn.bz.schemabinding.entity.dto.CRS_PPR_V2;

import lombok.Data;

import java.util.List;

@Data
public class Document {
    private EnteteDoc enteteDoc;
    private List<ExtraitWrapper> extraits;
}
