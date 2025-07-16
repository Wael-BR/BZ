package tn.bz.schemabinding.entity.dto.MAJ_CRS_ATT;

import lombok.Data;

@Data
public class RefOperation {
    private String NatMvtOp;
    private String CodMvt;
    private String DateMvt;
    private String NatOp;
    private Amount MntOpDev;
    private Amount MntOpDin;
    private String ModReg;
    private String NumMsgeSwiftMvt;
}
