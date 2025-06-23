
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
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "AgenceDom",
    "Titulaire",
    "RefCompte",
    "NbrEcritures"
})
@Generated("jsonschema2pojo")
@Entity
public class Entete {

    @Id
    private Long id;
    @JsonProperty("AgenceDom")
    private String agenceDom;
    @JsonProperty("Titulaire")
    @Valid
    @Embedded
    private Titulaire titulaire;
    @JsonProperty("RefCompte")
    @Valid
    @Embedded
    private RefCompte refCompte;
    @JsonProperty("NbrEcritures")
    private String nbrEcritures;
    @JsonIgnore
    @Valid
    @Transient
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("AgenceDom")
    public String getAgenceDom() {
        return agenceDom;
    }

    @JsonProperty("AgenceDom")
    public void setAgenceDom(String agenceDom) {
        this.agenceDom = agenceDom;
    }

    @JsonProperty("Titulaire")
    public Titulaire getTitulaire() {
        return titulaire;
    }

    @JsonProperty("Titulaire")
    public void setTitulaire(Titulaire titulaire) {
        this.titulaire = titulaire;
    }

    @JsonProperty("RefCompte")
    public RefCompte getRefCompte() {
        return refCompte;
    }

    @JsonProperty("RefCompte")
    public void setRefCompte(RefCompte refCompte) {
        this.refCompte = refCompte;
    }

    @JsonProperty("NbrEcritures")
    public String getNbrEcritures() {
        return nbrEcritures;
    }

    @JsonProperty("NbrEcritures")
    public void setNbrEcritures(String nbrEcritures) {
        this.nbrEcritures = nbrEcritures;
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
        sb.append(Entete.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("agenceDom");
        sb.append('=');
        sb.append(((this.agenceDom == null)?"<null>":this.agenceDom));
        sb.append(',');
        sb.append("titulaire");
        sb.append('=');
        sb.append(((this.titulaire == null)?"<null>":this.titulaire));
        sb.append(',');
        sb.append("refCompte");
        sb.append('=');
        sb.append(((this.refCompte == null)?"<null>":this.refCompte));
        sb.append(',');
        sb.append("nbrEcritures");
        sb.append('=');
        sb.append(((this.nbrEcritures == null)?"<null>":this.nbrEcritures));
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
        result = ((result* 31)+((this.agenceDom == null)? 0 :this.agenceDom.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.refCompte == null)? 0 :this.refCompte.hashCode()));
        result = ((result* 31)+((this.nbrEcritures == null)? 0 :this.nbrEcritures.hashCode()));
        result = ((result* 31)+((this.titulaire == null)? 0 :this.titulaire.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Entete) == false) {
            return false;
        }
        Entete rhs = ((Entete) other);
        return ((((((this.agenceDom == rhs.agenceDom)||((this.agenceDom!= null)&&this.agenceDom.equals(rhs.agenceDom)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.refCompte == rhs.refCompte)||((this.refCompte!= null)&&this.refCompte.equals(rhs.refCompte))))&&((this.nbrEcritures == rhs.nbrEcritures)||((this.nbrEcritures!= null)&&this.nbrEcritures.equals(rhs.nbrEcritures))))&&((this.titulaire == rhs.titulaire)||((this.titulaire!= null)&&this.titulaire.equals(rhs.titulaire))));
    }

}
