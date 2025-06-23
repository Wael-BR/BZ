
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
    "DateOuvCpte",
    "EtatCpte",
    "DateclotureCpte",
    "DateGelCpte",
    "SoldDebMois",
    "SoldfinMois"
})
@Generated("jsonschema2pojo")
@Embeddable
public class RefCompte {

    @Id
    private Long id;
    @JsonProperty("Rib")
    @Transient
    private Object rib;
    @JsonProperty("DateOuvCpte")
    @Transient
    private Object dateOuvCpte;
    @JsonProperty("EtatCpte")
    @Transient
    private Object etatCpte;
    @JsonProperty("DateclotureCpte")
    @Transient
    private Object dateclotureCpte;
    @JsonProperty("DateGelCpte")
    @Transient
    private Object dateGelCpte;
    @JsonProperty("SoldDebMois")
    @Valid
    @Embedded
    private SoldDebMois soldDebMois;
    @JsonProperty("SoldfinMois")
    @Valid
    @Embedded
    private SoldfinMois soldfinMois;
    @JsonIgnore
    @Valid
    @Transient
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Rib")
    public Object getRib() {
        return rib;
    }

    @JsonProperty("Rib")
    public void setRib(Object rib) {
        this.rib = rib;
    }

    @JsonProperty("DateOuvCpte")
    public Object getDateOuvCpte() {
        return dateOuvCpte;
    }

    @JsonProperty("DateOuvCpte")
    public void setDateOuvCpte(Object dateOuvCpte) {
        this.dateOuvCpte = dateOuvCpte;
    }

    @JsonProperty("EtatCpte")
    public Object getEtatCpte() {
        return etatCpte;
    }

    @JsonProperty("EtatCpte")
    public void setEtatCpte(Object etatCpte) {
        this.etatCpte = etatCpte;
    }

    @JsonProperty("DateclotureCpte")
    public Object getDateclotureCpte() {
        return dateclotureCpte;
    }

    @JsonProperty("DateclotureCpte")
    public void setDateclotureCpte(Object dateclotureCpte) {
        this.dateclotureCpte = dateclotureCpte;
    }

    @JsonProperty("DateGelCpte")
    public Object getDateGelCpte() {
        return dateGelCpte;
    }

    @JsonProperty("DateGelCpte")
    public void setDateGelCpte(Object dateGelCpte) {
        this.dateGelCpte = dateGelCpte;
    }

    @JsonProperty("SoldDebMois")
    public SoldDebMois getSoldDebMois() {
        return soldDebMois;
    }

    @JsonProperty("SoldDebMois")
    public void setSoldDebMois(SoldDebMois soldDebMois) {
        this.soldDebMois = soldDebMois;
    }

    @JsonProperty("SoldfinMois")
    public SoldfinMois getSoldfinMois() {
        return soldfinMois;
    }

    @JsonProperty("SoldfinMois")
    public void setSoldfinMois(SoldfinMois soldfinMois) {
        this.soldfinMois = soldfinMois;
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
        sb.append(RefCompte.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("rib");
        sb.append('=');
        sb.append(((this.rib == null)?"<null>":this.rib));
        sb.append(',');
        sb.append("dateOuvCpte");
        sb.append('=');
        sb.append(((this.dateOuvCpte == null)?"<null>":this.dateOuvCpte));
        sb.append(',');
        sb.append("etatCpte");
        sb.append('=');
        sb.append(((this.etatCpte == null)?"<null>":this.etatCpte));
        sb.append(',');
        sb.append("dateclotureCpte");
        sb.append('=');
        sb.append(((this.dateclotureCpte == null)?"<null>":this.dateclotureCpte));
        sb.append(',');
        sb.append("dateGelCpte");
        sb.append('=');
        sb.append(((this.dateGelCpte == null)?"<null>":this.dateGelCpte));
        sb.append(',');
        sb.append("soldDebMois");
        sb.append('=');
        sb.append(((this.soldDebMois == null)?"<null>":this.soldDebMois));
        sb.append(',');
        sb.append("soldfinMois");
        sb.append('=');
        sb.append(((this.soldfinMois == null)?"<null>":this.soldfinMois));
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
        result = ((result* 31)+((this.soldfinMois == null)? 0 :this.soldfinMois.hashCode()));
        result = ((result* 31)+((this.etatCpte == null)? 0 :this.etatCpte.hashCode()));
        result = ((result* 31)+((this.dateOuvCpte == null)? 0 :this.dateOuvCpte.hashCode()));
        result = ((result* 31)+((this.dateGelCpte == null)? 0 :this.dateGelCpte.hashCode()));
        result = ((result* 31)+((this.rib == null)? 0 :this.rib.hashCode()));
        result = ((result* 31)+((this.soldDebMois == null)? 0 :this.soldDebMois.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.dateclotureCpte == null)? 0 :this.dateclotureCpte.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RefCompte) == false) {
            return false;
        }
        RefCompte rhs = ((RefCompte) other);
        return (((((((((this.soldfinMois == rhs.soldfinMois)||((this.soldfinMois!= null)&&this.soldfinMois.equals(rhs.soldfinMois)))&&((this.etatCpte == rhs.etatCpte)||((this.etatCpte!= null)&&this.etatCpte.equals(rhs.etatCpte))))&&((this.dateOuvCpte == rhs.dateOuvCpte)||((this.dateOuvCpte!= null)&&this.dateOuvCpte.equals(rhs.dateOuvCpte))))&&((this.dateGelCpte == rhs.dateGelCpte)||((this.dateGelCpte!= null)&&this.dateGelCpte.equals(rhs.dateGelCpte))))&&((this.rib == rhs.rib)||((this.rib!= null)&&this.rib.equals(rhs.rib))))&&((this.soldDebMois == rhs.soldDebMois)||((this.soldDebMois!= null)&&this.soldDebMois.equals(rhs.soldDebMois))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.dateclotureCpte == rhs.dateclotureCpte)||((this.dateclotureCpte!= null)&&this.dateclotureCpte.equals(rhs.dateclotureCpte))));
    }

}
