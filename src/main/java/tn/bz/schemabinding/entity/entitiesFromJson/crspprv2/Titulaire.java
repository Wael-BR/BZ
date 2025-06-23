
package tn.bz.schemabinding.entity.entitiesFromJson.crspprv2;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import javax.validation.Valid;

@Generated("jsonschema2pojo")
public class Titulaire {

    private Object typeIdentifiant;
    private Object codeIdentifiant;
    private Object nom;
    private Object prenom;
    private Object nationalite;
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Object getTypeIdentifiant() {
        return typeIdentifiant;
    }

    public void setTypeIdentifiant(Object typeIdentifiant) {
        this.typeIdentifiant = typeIdentifiant;
    }

    public Object getCodeIdentifiant() {
        return codeIdentifiant;
    }

    public void setCodeIdentifiant(Object codeIdentifiant) {
        this.codeIdentifiant = codeIdentifiant;
    }

    public Object getNom() {
        return nom;
    }

    public void setNom(Object nom) {
        this.nom = nom;
    }

    public Object getPrenom() {
        return prenom;
    }

    public void setPrenom(Object prenom) {
        this.prenom = prenom;
    }

    public Object getNationalite() {
        return nationalite;
    }

    public void setNationalite(Object nationalite) {
        this.nationalite = nationalite;
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
        sb.append(Titulaire.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
        return (((((((this.nationalite == rhs.nationalite)||((this.nationalite!= null)&&this.nationalite.equals(rhs.nationalite)))&&((this.typeIdentifiant == rhs.typeIdentifiant)||((this.typeIdentifiant!= null)&&this.typeIdentifiant.equals(rhs.typeIdentifiant))))&&((this.codeIdentifiant == rhs.codeIdentifiant)||((this.codeIdentifiant!= null)&&this.codeIdentifiant.equals(rhs.codeIdentifiant))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.nom == rhs.nom)||((this.nom!= null)&&this.nom.equals(rhs.nom))))&&((this.prenom == rhs.prenom)||((this.prenom!= null)&&this.prenom.equals(rhs.prenom))));
    }

}
