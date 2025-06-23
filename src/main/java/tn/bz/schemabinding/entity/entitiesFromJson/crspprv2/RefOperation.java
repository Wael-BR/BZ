
package tn.bz.schemabinding.entity.entitiesFromJson.crspprv2;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import javax.validation.Valid;

@Generated("jsonschema2pojo")
public class RefOperation {

    private Object natMvtOp;
    @Valid
    private MntOpDev mntOpDev;
    @Valid
    private MntOpDin mntOpDin;
    private Object dateMvt;
    private Object codMvt;
    private Object natOp;
    private Object modReg;
    private Object numMsgeSwiftMvt;
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Object getNatMvtOp() {
        return natMvtOp;
    }

    public void setNatMvtOp(Object natMvtOp) {
        this.natMvtOp = natMvtOp;
    }

    public MntOpDev getMntOpDev() {
        return mntOpDev;
    }

    public void setMntOpDev(MntOpDev mntOpDev) {
        this.mntOpDev = mntOpDev;
    }

    public MntOpDin getMntOpDin() {
        return mntOpDin;
    }

    public void setMntOpDin(MntOpDin mntOpDin) {
        this.mntOpDin = mntOpDin;
    }

    public Object getDateMvt() {
        return dateMvt;
    }

    public void setDateMvt(Object dateMvt) {
        this.dateMvt = dateMvt;
    }

    public Object getCodMvt() {
        return codMvt;
    }

    public void setCodMvt(Object codMvt) {
        this.codMvt = codMvt;
    }

    public Object getNatOp() {
        return natOp;
    }

    public void setNatOp(Object natOp) {
        this.natOp = natOp;
    }

    public Object getModReg() {
        return modReg;
    }

    public void setModReg(Object modReg) {
        this.modReg = modReg;
    }

    public Object getNumMsgeSwiftMvt() {
        return numMsgeSwiftMvt;
    }

    public void setNumMsgeSwiftMvt(Object numMsgeSwiftMvt) {
        this.numMsgeSwiftMvt = numMsgeSwiftMvt;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RefOperation.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("natMvtOp");
        sb.append('=');
        sb.append(((this.natMvtOp == null)?"<null>":this.natMvtOp));
        sb.append(',');
        sb.append("mntOpDev");
        sb.append('=');
        sb.append(((this.mntOpDev == null)?"<null>":this.mntOpDev));
        sb.append(',');
        sb.append("mntOpDin");
        sb.append('=');
        sb.append(((this.mntOpDin == null)?"<null>":this.mntOpDin));
        sb.append(',');
        sb.append("dateMvt");
        sb.append('=');
        sb.append(((this.dateMvt == null)?"<null>":this.dateMvt));
        sb.append(',');
        sb.append("codMvt");
        sb.append('=');
        sb.append(((this.codMvt == null)?"<null>":this.codMvt));
        sb.append(',');
        sb.append("natOp");
        sb.append('=');
        sb.append(((this.natOp == null)?"<null>":this.natOp));
        sb.append(',');
        sb.append("modReg");
        sb.append('=');
        sb.append(((this.modReg == null)?"<null>":this.modReg));
        sb.append(',');
        sb.append("numMsgeSwiftMvt");
        sb.append('=');
        sb.append(((this.numMsgeSwiftMvt == null)?"<null>":this.numMsgeSwiftMvt));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.mntOpDin == null)? 0 :this.mntOpDin.hashCode()));
        result = ((result* 31)+((this.codMvt == null)? 0 :this.codMvt.hashCode()));
        result = ((result* 31)+((this.natOp == null)? 0 :this.natOp.hashCode()));
        result = ((result* 31)+((this.modReg == null)? 0 :this.modReg.hashCode()));
        result = ((result* 31)+((this.dateMvt == null)? 0 :this.dateMvt.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.mntOpDev == null)? 0 :this.mntOpDev.hashCode()));
        result = ((result* 31)+((this.natMvtOp == null)? 0 :this.natMvtOp.hashCode()));
        result = ((result* 31)+((this.numMsgeSwiftMvt == null)? 0 :this.numMsgeSwiftMvt.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RefOperation) == false) {
            return false;
        }
        RefOperation rhs = ((RefOperation) other);
        return ((((((((((this.mntOpDin == rhs.mntOpDin)||((this.mntOpDin!= null)&&this.mntOpDin.equals(rhs.mntOpDin)))&&((this.codMvt == rhs.codMvt)||((this.codMvt!= null)&&this.codMvt.equals(rhs.codMvt))))&&((this.natOp == rhs.natOp)||((this.natOp!= null)&&this.natOp.equals(rhs.natOp))))&&((this.modReg == rhs.modReg)||((this.modReg!= null)&&this.modReg.equals(rhs.modReg))))&&((this.dateMvt == rhs.dateMvt)||((this.dateMvt!= null)&&this.dateMvt.equals(rhs.dateMvt))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.mntOpDev == rhs.mntOpDev)||((this.mntOpDev!= null)&&this.mntOpDev.equals(rhs.mntOpDev))))&&((this.natMvtOp == rhs.natMvtOp)||((this.natMvtOp!= null)&&this.natMvtOp.equals(rhs.natMvtOp))))&&((this.numMsgeSwiftMvt == rhs.numMsgeSwiftMvt)||((this.numMsgeSwiftMvt!= null)&&this.numMsgeSwiftMvt.equals(rhs.numMsgeSwiftMvt))));
    }

}
