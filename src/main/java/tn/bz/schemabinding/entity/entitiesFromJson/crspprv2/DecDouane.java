
package tn.bz.schemabinding.entity.entitiesFromJson.crspprv2;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import javax.validation.Valid;

@Generated("jsonschema2pojo")
public class DecDouane {

    private Object numDecD;
    private Object dateDecD;
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Object getNumDecD() {
        return numDecD;
    }

    public void setNumDecD(Object numDecD) {
        this.numDecD = numDecD;
    }

    public Object getDateDecD() {
        return dateDecD;
    }

    public void setDateDecD(Object dateDecD) {
        this.dateDecD = dateDecD;
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
        sb.append(DecDouane.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("numDecD");
        sb.append('=');
        sb.append(((this.numDecD == null)?"<null>":this.numDecD));
        sb.append(',');
        sb.append("dateDecD");
        sb.append('=');
        sb.append(((this.dateDecD == null)?"<null>":this.dateDecD));
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
        result = ((result* 31)+((this.dateDecD == null)? 0 :this.dateDecD.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.numDecD == null)? 0 :this.numDecD.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DecDouane) == false) {
            return false;
        }
        DecDouane rhs = ((DecDouane) other);
        return ((((this.dateDecD == rhs.dateDecD)||((this.dateDecD!= null)&&this.dateDecD.equals(rhs.dateDecD)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.numDecD == rhs.numDecD)||((this.numDecD!= null)&&this.numDecD.equals(rhs.numDecD))));
    }

}
