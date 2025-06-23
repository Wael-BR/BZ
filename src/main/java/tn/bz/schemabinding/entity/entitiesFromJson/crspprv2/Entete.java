
package tn.bz.schemabinding.entity.entitiesFromJson.crspprv2;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import javax.validation.Valid;

@Generated("jsonschema2pojo")
public class Entete {

    private Object agenceDom;
    @Valid
    private Titulaire titulaire;
    @Valid
    private RefCompte refCompte;
    private Object nbrEcritures;
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Object getAgenceDom() {
        return agenceDom;
    }

    public void setAgenceDom(Object agenceDom) {
        this.agenceDom = agenceDom;
    }

    public Titulaire getTitulaire() {
        return titulaire;
    }

    public void setTitulaire(Titulaire titulaire) {
        this.titulaire = titulaire;
    }

    public RefCompte getRefCompte() {
        return refCompte;
    }

    public void setRefCompte(RefCompte refCompte) {
        this.refCompte = refCompte;
    }

    public Object getNbrEcritures() {
        return nbrEcritures;
    }

    public void setNbrEcritures(Object nbrEcritures) {
        this.nbrEcritures = nbrEcritures;
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
