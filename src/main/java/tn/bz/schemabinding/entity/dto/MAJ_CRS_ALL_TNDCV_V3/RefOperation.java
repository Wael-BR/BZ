package tn.bz.schemabinding.entity.dto.MAJ_CRS_ALL_TNDCV_V3;

import lombok.Data;

@Data
public class RefOperation {
    private String NatMvtOp;
    private Amount MntOpDev;
    private Amount MntOpDin;
    private String DateRetVoy;
    private String DateMvt;
    private String CodMvt;
    private String NatOp;
    private String ModReg;
    private String NumMsgeSwiftMvt;
}
