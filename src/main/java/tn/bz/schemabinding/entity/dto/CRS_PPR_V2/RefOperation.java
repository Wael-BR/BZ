package tn.bz.schemabinding.entity.dto.CRS_PPR_V2;

import lombok.Data;

@Data
public class RefOperation {
    private String NatMvtOp;
    private Amount MntOpDev;
    private Amount MntOpDin;
    private String DateMvt;
    private String CodMvt;
    private String NatOp;
    private String ModReg;
    private String NumMsgeSwiftMvt;
}
