
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
    "Rib",
    "RefOperation",
    "RefAutorisationBct",
    "DenomBenif",
    "Pays"
})
@Generated("jsonschema2pojo")
@Embeddable
public class Detail__1 {

    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @JsonProperty("Rib")
    private String rib;
    @JsonProperty("RefOperation")
    @Valid
    @Embedded
    private RefOperation refOperation;
    @JsonProperty("RefAutorisationBct")
    @Valid
    @Embedded
    private RefAutorisationBct refAutorisationBct;
    @JsonProperty("DenomBenif")
    private String denomBenif;
    @JsonProperty("Pays")
    private String pays;
    @JsonIgnore
    @Valid
    @Transient
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Rib")
    public String getRib() {
        return rib;
    }

    @JsonProperty("Rib")
    public void setRib(String rib) {
        this.rib = rib;
    }

    @JsonProperty("RefOperation")
    public RefOperation getRefOperation() {
        return refOperation;
    }

    @JsonProperty("RefOperation")
    public void setRefOperation(RefOperation refOperation) {
        this.refOperation = refOperation;
    }

    @JsonProperty("RefAutorisationBct")
    public RefAutorisationBct getRefAutorisationBct() {
        return refAutorisationBct;
    }

    @JsonProperty("RefAutorisationBct")
    public void setRefAutorisationBct(RefAutorisationBct refAutorisationBct) {
        this.refAutorisationBct = refAutorisationBct;
    }

    @JsonProperty("DenomBenif")
    public String getDenomBenif() {
        return denomBenif;
    }

    @JsonProperty("DenomBenif")
    public void setDenomBenif(String denomBenif) {
        this.denomBenif = denomBenif;
    }

    @JsonProperty("Pays")
    public String getPays() {
        return pays;
    }

    @JsonProperty("Pays")
    public void setPays(String pays) {
        this.pays = pays;
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
        sb.append(Detail__1 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("rib");
        sb.append('=');
        sb.append(((this.rib == null)?"<null>":this.rib));
        sb.append(',');
        sb.append("refOperation");
        sb.append('=');
        sb.append(((this.refOperation == null)?"<null>":this.refOperation));
        sb.append(',');
        sb.append("refAutorisationBct");
        sb.append('=');
        sb.append(((this.refAutorisationBct == null)?"<null>":this.refAutorisationBct));
        sb.append(',');
        sb.append("denomBenif");
        sb.append('=');
        sb.append(((this.denomBenif == null)?"<null>":this.denomBenif));
        sb.append(',');
        sb.append("pays");
        sb.append('=');
        sb.append(((this.pays == null)?"<null>":this.pays));
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
        result = ((result* 31)+((this.refAutorisationBct == null)? 0 :this.refAutorisationBct.hashCode()));
        result = ((result* 31)+((this.refOperation == null)? 0 :this.refOperation.hashCode()));
        result = ((result* 31)+((this.rib == null)? 0 :this.rib.hashCode()));
        result = ((result* 31)+((this.denomBenif == null)? 0 :this.denomBenif.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.pays == null)? 0 :this.pays.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Detail__1) == false) {
            return false;
        }
        Detail__1 rhs = ((Detail__1) other);
        return (((((((this.refAutorisationBct == rhs.refAutorisationBct)||((this.refAutorisationBct!= null)&&this.refAutorisationBct.equals(rhs.refAutorisationBct)))&&((this.refOperation == rhs.refOperation)||((this.refOperation!= null)&&this.refOperation.equals(rhs.refOperation))))&&((this.rib == rhs.rib)||((this.rib!= null)&&this.rib.equals(rhs.rib))))&&((this.denomBenif == rhs.denomBenif)||((this.denomBenif!= null)&&this.denomBenif.equals(rhs.denomBenif))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.pays == rhs.pays)||((this.pays!= null)&&this.pays.equals(rhs.pays))));
    }

}
