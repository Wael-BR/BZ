
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
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "NumAutBCT",
    "DateAutBCT"
})
@Generated("jsonschema2pojo")
@Embeddable
public class RefAutorisationBct {

    @Id
    private Long id;
    @JsonProperty("NumAutBCT")
    @Transient
    private Object numAutBCT;
    @JsonProperty("DateAutBCT")
    @Transient
    private Object dateAutBCT;
    @JsonIgnore
    @Valid
    @Transient
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("NumAutBCT")
    public Object getNumAutBCT() {
        return numAutBCT;
    }

    @JsonProperty("NumAutBCT")
    public void setNumAutBCT(Object numAutBCT) {
        this.numAutBCT = numAutBCT;
    }

    @JsonProperty("DateAutBCT")
    public Object getDateAutBCT() {
        return dateAutBCT;
    }

    @JsonProperty("DateAutBCT")
    public void setDateAutBCT(Object dateAutBCT) {
        this.dateAutBCT = dateAutBCT;
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
        sb.append(RefAutorisationBct.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("numAutBCT");
        sb.append('=');
        sb.append(((this.numAutBCT == null)?"<null>":this.numAutBCT));
        sb.append(',');
        sb.append("dateAutBCT");
        sb.append('=');
        sb.append(((this.dateAutBCT == null)?"<null>":this.dateAutBCT));
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
        result = ((result* 31)+((this.numAutBCT == null)? 0 :this.numAutBCT.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.dateAutBCT == null)? 0 :this.dateAutBCT.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RefAutorisationBct) == false) {
            return false;
        }
        RefAutorisationBct rhs = ((RefAutorisationBct) other);
        return ((((this.numAutBCT == rhs.numAutBCT)||((this.numAutBCT!= null)&&this.numAutBCT.equals(rhs.numAutBCT)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.dateAutBCT == rhs.dateAutBCT)||((this.dateAutBCT!= null)&&this.dateAutBCT.equals(rhs.dateAutBCT))));
    }

}
