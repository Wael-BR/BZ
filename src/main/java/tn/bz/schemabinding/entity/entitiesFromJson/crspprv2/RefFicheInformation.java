
package tn.bz.schemabinding.entity.entitiesFromJson.crspprv2;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import javax.validation.Valid;

@Generated("jsonschema2pojo")
public class RefFicheInformation {

    private Object numFicheInformation;
    private Object dateFicheInformation;
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Object getNumFicheInformation() {
        return numFicheInformation;
    }

    public void setNumFicheInformation(Object numFicheInformation) {
        this.numFicheInformation = numFicheInformation;
    }

    public Object getDateFicheInformation() {
        return dateFicheInformation;
    }

    public void setDateFicheInformation(Object dateFicheInformation) {
        this.dateFicheInformation = dateFicheInformation;
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
        sb.append(RefFicheInformation.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("numFicheInformation");
        sb.append('=');
        sb.append(((this.numFicheInformation == null)?"<null>":this.numFicheInformation));
        sb.append(',');
        sb.append("dateFicheInformation");
        sb.append('=');
        sb.append(((this.dateFicheInformation == null)?"<null>":this.dateFicheInformation));
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
        result = ((result* 31)+((this.numFicheInformation == null)? 0 :this.numFicheInformation.hashCode()));
        result = ((result* 31)+((this.dateFicheInformation == null)? 0 :this.dateFicheInformation.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RefFicheInformation) == false) {
            return false;
        }
        RefFicheInformation rhs = ((RefFicheInformation) other);
        return ((((this.numFicheInformation == rhs.numFicheInformation)||((this.numFicheInformation!= null)&&this.numFicheInformation.equals(rhs.numFicheInformation)))&&((this.dateFicheInformation == rhs.dateFicheInformation)||((this.dateFicheInformation!= null)&&this.dateFicheInformation.equals(rhs.dateFicheInformation))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
