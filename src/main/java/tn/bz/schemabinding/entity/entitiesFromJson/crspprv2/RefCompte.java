
package tn.bz.schemabinding.entity.entitiesFromJson.crspprv2;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import javax.validation.Valid;

@Generated("jsonschema2pojo")
public class RefCompte {

    private Object rib;
    private Object deviseCpte;
    private Object dateOuvCpte;
    private Object etatCpte;
    private Object dateclotureCpte;
    private Object dateGelCpte;
    private Object numAutBCT;
    private Object dateAutBCT;
    @Valid
    private SoldDebMois soldDebMois;
    @Valid
    private SoldfinMois soldfinMois;
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Object getRib() {
        return rib;
    }

    public void setRib(Object rib) {
        this.rib = rib;
    }

    public Object getDeviseCpte() {
        return deviseCpte;
    }

    public void setDeviseCpte(Object deviseCpte) {
        this.deviseCpte = deviseCpte;
    }

    public Object getDateOuvCpte() {
        return dateOuvCpte;
    }

    public void setDateOuvCpte(Object dateOuvCpte) {
        this.dateOuvCpte = dateOuvCpte;
    }

    public Object getEtatCpte() {
        return etatCpte;
    }

    public void setEtatCpte(Object etatCpte) {
        this.etatCpte = etatCpte;
    }

    public Object getDateclotureCpte() {
        return dateclotureCpte;
    }

    public void setDateclotureCpte(Object dateclotureCpte) {
        this.dateclotureCpte = dateclotureCpte;
    }

    public Object getDateGelCpte() {
        return dateGelCpte;
    }

    public void setDateGelCpte(Object dateGelCpte) {
        this.dateGelCpte = dateGelCpte;
    }

    public Object getNumAutBCT() {
        return numAutBCT;
    }

    public void setNumAutBCT(Object numAutBCT) {
        this.numAutBCT = numAutBCT;
    }

    public Object getDateAutBCT() {
        return dateAutBCT;
    }

    public void setDateAutBCT(Object dateAutBCT) {
        this.dateAutBCT = dateAutBCT;
    }

    public SoldDebMois getSoldDebMois() {
        return soldDebMois;
    }

    public void setSoldDebMois(SoldDebMois soldDebMois) {
        this.soldDebMois = soldDebMois;
    }

    public SoldfinMois getSoldfinMois() {
        return soldfinMois;
    }

    public void setSoldfinMois(SoldfinMois soldfinMois) {
        this.soldfinMois = soldfinMois;
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
        sb.append(RefCompte.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("rib");
        sb.append('=');
        sb.append(((this.rib == null)?"<null>":this.rib));
        sb.append(',');
        sb.append("deviseCpte");
        sb.append('=');
        sb.append(((this.deviseCpte == null)?"<null>":this.deviseCpte));
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
        sb.append("numAutBCT");
        sb.append('=');
        sb.append(((this.numAutBCT == null)?"<null>":this.numAutBCT));
        sb.append(',');
        sb.append("dateAutBCT");
        sb.append('=');
        sb.append(((this.dateAutBCT == null)?"<null>":this.dateAutBCT));
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
        result = ((result* 31)+((this.numAutBCT == null)? 0 :this.numAutBCT.hashCode()));
        result = ((result* 31)+((this.soldfinMois == null)? 0 :this.soldfinMois.hashCode()));
        result = ((result* 31)+((this.deviseCpte == null)? 0 :this.deviseCpte.hashCode()));
        result = ((result* 31)+((this.etatCpte == null)? 0 :this.etatCpte.hashCode()));
        result = ((result* 31)+((this.dateOuvCpte == null)? 0 :this.dateOuvCpte.hashCode()));
        result = ((result* 31)+((this.dateGelCpte == null)? 0 :this.dateGelCpte.hashCode()));
        result = ((result* 31)+((this.rib == null)? 0 :this.rib.hashCode()));
        result = ((result* 31)+((this.soldDebMois == null)? 0 :this.soldDebMois.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.dateclotureCpte == null)? 0 :this.dateclotureCpte.hashCode()));
        result = ((result* 31)+((this.dateAutBCT == null)? 0 :this.dateAutBCT.hashCode()));
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
        return ((((((((((((this.numAutBCT == rhs.numAutBCT)||((this.numAutBCT!= null)&&this.numAutBCT.equals(rhs.numAutBCT)))&&((this.soldfinMois == rhs.soldfinMois)||((this.soldfinMois!= null)&&this.soldfinMois.equals(rhs.soldfinMois))))&&((this.deviseCpte == rhs.deviseCpte)||((this.deviseCpte!= null)&&this.deviseCpte.equals(rhs.deviseCpte))))&&((this.etatCpte == rhs.etatCpte)||((this.etatCpte!= null)&&this.etatCpte.equals(rhs.etatCpte))))&&((this.dateOuvCpte == rhs.dateOuvCpte)||((this.dateOuvCpte!= null)&&this.dateOuvCpte.equals(rhs.dateOuvCpte))))&&((this.dateGelCpte == rhs.dateGelCpte)||((this.dateGelCpte!= null)&&this.dateGelCpte.equals(rhs.dateGelCpte))))&&((this.rib == rhs.rib)||((this.rib!= null)&&this.rib.equals(rhs.rib))))&&((this.soldDebMois == rhs.soldDebMois)||((this.soldDebMois!= null)&&this.soldDebMois.equals(rhs.soldDebMois))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.dateclotureCpte == rhs.dateclotureCpte)||((this.dateclotureCpte!= null)&&this.dateclotureCpte.equals(rhs.dateclotureCpte))))&&((this.dateAutBCT == rhs.dateAutBCT)||((this.dateAutBCT!= null)&&this.dateAutBCT.equals(rhs.dateAutBCT))));
    }

}
