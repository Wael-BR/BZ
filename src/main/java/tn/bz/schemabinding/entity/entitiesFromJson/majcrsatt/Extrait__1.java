
package tn.bz.schemabinding.entity.entitiesFromJson.majcrsatt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    "Entete",
    "Details"
})
@Generated("jsonschema2pojo")
@Embeddable
public class Extrait__1 {

    @Id
    private Long id;
    @JsonProperty("Entete")
    @Valid
    private Entete entete;
    @JsonProperty("Details")
    @Valid
    private List<Detail> details = new ArrayList<Detail>();
    @JsonIgnore
    @Valid
    @Transient
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Entete")
    public Entete getEntete() {
        return entete;
    }

    @JsonProperty("Entete")
    public void setEntete(Entete entete) {
        this.entete = entete;
    }

    @JsonProperty("Details")
    public List<Detail> getDetails() {
        return details;
    }

    @JsonProperty("Details")
    public void setDetails(List<Detail> details) {
        this.details = details;
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
        sb.append(Extrait__1 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("entete");
        sb.append('=');
        sb.append(((this.entete == null)?"<null>":this.entete));
        sb.append(',');
        sb.append("details");
        sb.append('=');
        sb.append(((this.details == null)?"<null>":this.details));
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
        result = ((result* 31)+((this.details == null)? 0 :this.details.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.entete == null)? 0 :this.entete.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Extrait__1) == false) {
            return false;
        }
        Extrait__1 rhs = ((Extrait__1) other);
        return ((((this.details == rhs.details)||((this.details!= null)&&this.details.equals(rhs.details)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.entete == rhs.entete)||((this.entete!= null)&&this.entete.equals(rhs.entete))));
    }

}
