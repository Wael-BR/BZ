
package tn.bz.schemabinding.entity.entitiesFromJson.crspprv2;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import javax.validation.Valid;

@Generated("jsonschema2pojo")
public class Detail__1 {

    private Object rib;
    @Valid
    private RefOperation refOperation;
    @Valid
    private RefFicheInformation refFicheInformation;
    @Valid
    private RefAutorisationBct refAutorisationBct;
    @Valid
    private DecDouane decDouane;
    private Object denomBenif;
    private Object pays;
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Object getRib() {
        return rib;
    }

    public void setRib(Object rib) {
        this.rib = rib;
    }

    public RefOperation getRefOperation() {
        return refOperation;
    }

    public void setRefOperation(RefOperation refOperation) {
        this.refOperation = refOperation;
    }

    public RefFicheInformation getRefFicheInformation() {
        return refFicheInformation;
    }

    public void setRefFicheInformation(RefFicheInformation refFicheInformation) {
        this.refFicheInformation = refFicheInformation;
    }

    public RefAutorisationBct getRefAutorisationBct() {
        return refAutorisationBct;
    }

    public void setRefAutorisationBct(RefAutorisationBct refAutorisationBct) {
        this.refAutorisationBct = refAutorisationBct;
    }

    public DecDouane getDecDouane() {
        return decDouane;
    }

    public void setDecDouane(DecDouane decDouane) {
        this.decDouane = decDouane;
    }

    public Object getDenomBenif() {
        return denomBenif;
    }

    public void setDenomBenif(Object denomBenif) {
        this.denomBenif = denomBenif;
    }

    public Object getPays() {
        return pays;
    }

    public void setPays(Object pays) {
        this.pays = pays;
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
        sb.append(Detail__1 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("rib");
        sb.append('=');
        sb.append(((this.rib == null)?"<null>":this.rib));
        sb.append(',');
        sb.append("refOperation");
        sb.append('=');
        sb.append(((this.refOperation == null)?"<null>":this.refOperation));
        sb.append(',');
        sb.append("refFicheInformation");
        sb.append('=');
        sb.append(((this.refFicheInformation == null)?"<null>":this.refFicheInformation));
        sb.append(',');
        sb.append("refAutorisationBct");
        sb.append('=');
        sb.append(((this.refAutorisationBct == null)?"<null>":this.refAutorisationBct));
        sb.append(',');
        sb.append("decDouane");
        sb.append('=');
        sb.append(((this.decDouane == null)?"<null>":this.decDouane));
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
        result = ((result* 31)+((this.refFicheInformation == null)? 0 :this.refFicheInformation.hashCode()));
        result = ((result* 31)+((this.refOperation == null)? 0 :this.refOperation.hashCode()));
        result = ((result* 31)+((this.decDouane == null)? 0 :this.decDouane.hashCode()));
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
        return (((((((((this.refAutorisationBct == rhs.refAutorisationBct)||((this.refAutorisationBct!= null)&&this.refAutorisationBct.equals(rhs.refAutorisationBct)))&&((this.refFicheInformation == rhs.refFicheInformation)||((this.refFicheInformation!= null)&&this.refFicheInformation.equals(rhs.refFicheInformation))))&&((this.refOperation == rhs.refOperation)||((this.refOperation!= null)&&this.refOperation.equals(rhs.refOperation))))&&((this.decDouane == rhs.decDouane)||((this.decDouane!= null)&&this.decDouane.equals(rhs.decDouane))))&&((this.rib == rhs.rib)||((this.rib!= null)&&this.rib.equals(rhs.rib))))&&((this.denomBenif == rhs.denomBenif)||((this.denomBenif!= null)&&this.denomBenif.equals(rhs.denomBenif))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.pays == rhs.pays)||((this.pays!= null)&&this.pays.equals(rhs.pays))));
    }

}
