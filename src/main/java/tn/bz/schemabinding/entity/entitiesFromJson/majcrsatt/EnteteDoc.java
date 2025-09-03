
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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "CodeIAT",
    "DateDec",
    "CodeAnnexe",
    "PeriodDec"
})
@Generated("jsonschema2pojo")
public class EnteteDoc {

    @JsonProperty("CodeIAT")
    private Object codeIAT;
    @JsonProperty("DateDec")
    private Object dateDec;
    @JsonProperty("CodeAnnexe")
    private Object codeAnnexe;
    @JsonProperty("PeriodDec")
    private Object periodDec;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("CodeIAT")
    public Object getCodeIAT() {
        return codeIAT;
    }

    @JsonProperty("CodeIAT")
    public void setCodeIAT(Object codeIAT) {
        this.codeIAT = codeIAT;
    }

    @JsonProperty("DateDec")
    public Object getDateDec() {
        return dateDec;
    }

    @JsonProperty("DateDec")
    public void setDateDec(Object dateDec) {
        this.dateDec = dateDec;
    }

    @JsonProperty("CodeAnnexe")
    public Object getCodeAnnexe() {
        return codeAnnexe;
    }

    @JsonProperty("CodeAnnexe")
    public void setCodeAnnexe(Object codeAnnexe) {
        this.codeAnnexe = codeAnnexe;
    }

    @JsonProperty("PeriodDec")
    public Object getPeriodDec() {
        return periodDec;
    }

    @JsonProperty("PeriodDec")
    public void setPeriodDec(Object periodDec) {
        this.periodDec = periodDec;
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
        sb.append(EnteteDoc.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("codeIAT");
        sb.append('=');
        sb.append(((this.codeIAT == null)?"<null>":this.codeIAT));
        sb.append(',');
        sb.append("dateDec");
        sb.append('=');
        sb.append(((this.dateDec == null)?"<null>":this.dateDec));
        sb.append(',');
        sb.append("codeAnnexe");
        sb.append('=');
        sb.append(((this.codeAnnexe == null)?"<null>":this.codeAnnexe));
        sb.append(',');
        sb.append("periodDec");
        sb.append('=');
        sb.append(((this.periodDec == null)?"<null>":this.periodDec));
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
        result = ((result* 31)+((this.dateDec == null)? 0 :this.dateDec.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.codeIAT == null)? 0 :this.codeIAT.hashCode()));
        result = ((result* 31)+((this.codeAnnexe == null)? 0 :this.codeAnnexe.hashCode()));
        result = ((result* 31)+((this.periodDec == null)? 0 :this.periodDec.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof EnteteDoc) == false) {
            return false;
        }
        EnteteDoc rhs = ((EnteteDoc) other);
        return ((((((this.dateDec == rhs.dateDec)||((this.dateDec!= null)&&this.dateDec.equals(rhs.dateDec)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.codeIAT == rhs.codeIAT)||((this.codeIAT!= null)&&this.codeIAT.equals(rhs.codeIAT))))&&((this.codeAnnexe == rhs.codeAnnexe)||((this.codeAnnexe!= null)&&this.codeAnnexe.equals(rhs.codeAnnexe))))&&((this.periodDec == rhs.periodDec)||((this.periodDec!= null)&&this.periodDec.equals(rhs.periodDec))));
    }

}
