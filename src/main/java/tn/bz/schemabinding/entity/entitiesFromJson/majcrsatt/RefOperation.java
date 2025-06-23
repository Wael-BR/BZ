
package tn.bz.schemabinding.entity.entitiesFromJson.majcrsatt;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "NatMvtOp",
    "CodMvt",
    "DateMvt",
    "NatOp",
    "MntOpDev",
    "MntOpDin",
    "ModReg",
    "NumMsgeSwiftMvt"
})
@Generated("jsonschema2pojo")
@Embeddable
public class RefOperation {

    @Id
    private Long id;
    @JsonProperty("NatMvtOp")
    private String natMvtOp;
    @JsonProperty("CodMvt")
    private String codMvt;
    @JsonProperty("DateMvt")
    private String dateMvt;
    @JsonProperty("NatOp")
    private String natOp;
    @JsonProperty("MntOpDev")
    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mnt_op_dev_id")
    private MntOpDev mntOpDev;
    @JsonProperty("MntOpDin")
    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mnt_op_din_id")
    private MntOpDin mntOpDin;
    @JsonProperty("ModReg")
    private String modReg;
    @JsonProperty("NumMsgeSwiftMvt")
    private String numMsgeSwiftMvt;
    @JsonIgnore
    @Valid
    @Transient
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("NatMvtOp")
    public String getNatMvtOp() {
        return natMvtOp;
    }

    @JsonProperty("NatMvtOp")
    public void setNatMvtOp(String natMvtOp) {
        this.natMvtOp = natMvtOp;
    }

    @JsonProperty("CodMvt")
    public String getCodMvt() {
        return codMvt;
    }

    @JsonProperty("CodMvt")
    public void setCodMvt(String codMvt) {
        this.codMvt = codMvt;
    }

    @JsonProperty("DateMvt")
    public String getDateMvt() {
        return dateMvt;
    }

    @JsonProperty("DateMvt")
    public void setDateMvt(String dateMvt) {
        this.dateMvt = dateMvt;
    }

    @JsonProperty("NatOp")
    public String getNatOp() {
        return natOp;
    }

    @JsonProperty("NatOp")
    public void setNatOp(String natOp) {
        this.natOp = natOp;
    }

    @JsonProperty("MntOpDev")
    public MntOpDev getMntOpDev() {
        return mntOpDev;
    }

    @JsonProperty("MntOpDev")
    public void setMntOpDev(MntOpDev mntOpDev) {
        this.mntOpDev = mntOpDev;
    }

    @JsonProperty("MntOpDin")
    public MntOpDin getMntOpDin() {
        return mntOpDin;
    }

    @JsonProperty("MntOpDin")
    public void setMntOpDin(MntOpDin mntOpDin) {
        this.mntOpDin = mntOpDin;
    }

    @JsonProperty("ModReg")
    public String getModReg() {
        return modReg;
    }

    @JsonProperty("ModReg")
    public void setModReg(String modReg) {
        this.modReg = modReg;
    }

    @JsonProperty("NumMsgeSwiftMvt")
    public String getNumMsgeSwiftMvt() {
        return numMsgeSwiftMvt;
    }

    @JsonProperty("NumMsgeSwiftMvt")
    public void setNumMsgeSwiftMvt(String numMsgeSwiftMvt) {
        this.numMsgeSwiftMvt = numMsgeSwiftMvt;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
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
        sb.append("codMvt");
        sb.append('=');
        sb.append(((this.codMvt == null)?"<null>":this.codMvt));
        sb.append(',');
        sb.append("dateMvt");
        sb.append('=');
        sb.append(((this.dateMvt == null)?"<null>":this.dateMvt));
        sb.append(',');
        sb.append("natOp");
        sb.append('=');
        sb.append(((this.natOp == null)?"<null>":this.natOp));
        sb.append(',');
        sb.append("mntOpDev");
        sb.append('=');
        sb.append(((this.mntOpDev == null)?"<null>":this.mntOpDev));
        sb.append(',');
        sb.append("mntOpDin");
        sb.append('=');
        sb.append(((this.mntOpDin == null)?"<null>":this.mntOpDin));
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
        result = ((result* 31)+((this.codMvt == null)? 0 :this.codMvt.hashCode()));
        result = ((result* 31)+((this.natOp == null)? 0 :this.natOp.hashCode()));
        result = ((result* 31)+((this.mntOpDin == null)? 0 :this.mntOpDin.hashCode()));
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
        return ((((((((((this.codMvt == rhs.codMvt)||((this.codMvt!= null)&&this.codMvt.equals(rhs.codMvt)))&&((this.natOp == rhs.natOp)||((this.natOp!= null)&&this.natOp.equals(rhs.natOp))))&&((this.mntOpDin == rhs.mntOpDin)||((this.mntOpDin!= null)&&this.mntOpDin.equals(rhs.mntOpDin))))&&((this.modReg == rhs.modReg)||((this.modReg!= null)&&this.modReg.equals(rhs.modReg))))&&((this.dateMvt == rhs.dateMvt)||((this.dateMvt!= null)&&this.dateMvt.equals(rhs.dateMvt))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.mntOpDev == rhs.mntOpDev)||((this.mntOpDev!= null)&&this.mntOpDev.equals(rhs.mntOpDev))))&&((this.natMvtOp == rhs.natMvtOp)||((this.natMvtOp!= null)&&this.natMvtOp.equals(rhs.natMvtOp))))&&((this.numMsgeSwiftMvt == rhs.numMsgeSwiftMvt)||((this.numMsgeSwiftMvt!= null)&&this.numMsgeSwiftMvt.equals(rhs.numMsgeSwiftMvt))));
    }

}
