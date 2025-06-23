
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
    "TypeTitul",
    "TypeIdentifiant",
    "CodeIdentifiant",
    "Nom",
    "Prenom",
    "RaisSociale",
    "Nationalite"
})
@Generated("jsonschema2pojo")
@Embeddable
public class Titulaire {

    @Id
    private Long id;
    @JsonProperty("TypeTitul")
    @Transient
    private Object typeTitul;
    @JsonProperty("TypeIdentifiant")
    @Transient
    private Object typeIdentifiant;
    @JsonProperty("CodeIdentifiant")
    @Transient
    private Object codeIdentifiant;
    @JsonProperty("Nom")
    @Transient
    private Object nom;
    @JsonProperty("Prenom")
    @Transient
    private Object prenom;
    @JsonProperty("RaisSociale")
    @Transient
    private Object raisSociale;
    @JsonProperty("Nationalite")
    @Transient
    private Object nationalite;
    @JsonIgnore
    @Valid
    @Transient
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("TypeTitul")
    public Object getTypeTitul() {
        return typeTitul;
    }

    @JsonProperty("TypeTitul")
    public void setTypeTitul(Object typeTitul) {
        this.typeTitul = typeTitul;
    }

    @JsonProperty("TypeIdentifiant")
    public Object getTypeIdentifiant() {
        return typeIdentifiant;
    }

    @JsonProperty("TypeIdentifiant")
    public void setTypeIdentifiant(Object typeIdentifiant) {
        this.typeIdentifiant = typeIdentifiant;
    }

    @JsonProperty("CodeIdentifiant")
    public Object getCodeIdentifiant() {
        return codeIdentifiant;
    }

    @JsonProperty("CodeIdentifiant")
    public void setCodeIdentifiant(Object codeIdentifiant) {
        this.codeIdentifiant = codeIdentifiant;
    }

    @JsonProperty("Nom")
    public Object getNom() {
        return nom;
    }

    @JsonProperty("Nom")
    public void setNom(Object nom) {
        this.nom = nom;
    }

    @JsonProperty("Prenom")
    public Object getPrenom() {
        return prenom;
    }

    @JsonProperty("Prenom")
    public void setPrenom(Object prenom) {
        this.prenom = prenom;
    }

    @JsonProperty("RaisSociale")
    public Object getRaisSociale() {
        return raisSociale;
    }

    @JsonProperty("RaisSociale")
    public void setRaisSociale(Object raisSociale) {
        this.raisSociale = raisSociale;
    }

    @JsonProperty("Nationalite")
    public Object getNationalite() {
        return nationalite;
    }

    @JsonProperty("Nationalite")
    public void setNationalite(Object nationalite) {
        this.nationalite = nationalite;
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
        sb.append(Titulaire.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("typeTitul");
        sb.append('=');
        sb.append(((this.typeTitul == null)?"<null>":this.typeTitul));
        sb.append(',');
        sb.append("typeIdentifiant");
        sb.append('=');
        sb.append(((this.typeIdentifiant == null)?"<null>":this.typeIdentifiant));
        sb.append(',');
        sb.append("codeIdentifiant");
        sb.append('=');
        sb.append(((this.codeIdentifiant == null)?"<null>":this.codeIdentifiant));
        sb.append(',');
        sb.append("nom");
        sb.append('=');
        sb.append(((this.nom == null)?"<null>":this.nom));
        sb.append(',');
        sb.append("prenom");
        sb.append('=');
        sb.append(((this.prenom == null)?"<null>":this.prenom));
        sb.append(',');
        sb.append("raisSociale");
        sb.append('=');
        sb.append(((this.raisSociale == null)?"<null>":this.raisSociale));
        sb.append(',');
        sb.append("nationalite");
        sb.append('=');
        sb.append(((this.nationalite == null)?"<null>":this.nationalite));
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
        result = ((result* 31)+((this.nationalite == null)? 0 :this.nationalite.hashCode()));
        result = ((result* 31)+((this.typeIdentifiant == null)? 0 :this.typeIdentifiant.hashCode()));
        result = ((result* 31)+((this.codeIdentifiant == null)? 0 :this.codeIdentifiant.hashCode()));
        result = ((result* 31)+((this.raisSociale == null)? 0 :this.raisSociale.hashCode()));
        result = ((result* 31)+((this.typeTitul == null)? 0 :this.typeTitul.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.nom == null)? 0 :this.nom.hashCode()));
        result = ((result* 31)+((this.prenom == null)? 0 :this.prenom.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Titulaire) == false) {
            return false;
        }
        Titulaire rhs = ((Titulaire) other);
        return (((((((((this.nationalite == rhs.nationalite)||((this.nationalite!= null)&&this.nationalite.equals(rhs.nationalite)))&&((this.typeIdentifiant == rhs.typeIdentifiant)||((this.typeIdentifiant!= null)&&this.typeIdentifiant.equals(rhs.typeIdentifiant))))&&((this.codeIdentifiant == rhs.codeIdentifiant)||((this.codeIdentifiant!= null)&&this.codeIdentifiant.equals(rhs.codeIdentifiant))))&&((this.raisSociale == rhs.raisSociale)||((this.raisSociale!= null)&&this.raisSociale.equals(rhs.raisSociale))))&&((this.typeTitul == rhs.typeTitul)||((this.typeTitul!= null)&&this.typeTitul.equals(rhs.typeTitul))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.nom == rhs.nom)||((this.nom!= null)&&this.nom.equals(rhs.nom))))&&((this.prenom == rhs.prenom)||((this.prenom!= null)&&this.prenom.equals(rhs.prenom))));
    }

}
