
package tn.bz.schemabinding.entity.entitiesFromJson.crspprv2;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import javax.validation.Valid;

@Generated("jsonschema2pojo")
public class RefAutorisationBct {

    private Object numAutBCT;
    private Object dateAutBCT;
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RefAutorisationBct.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("numAutBCT");
        sb.append('=');
        sb.append(((this.numAutBCT == null)?"<null>":this.numAutBCT));
        sb.append(',');
        sb.append("dateAutBCT");
        sb.append('=');
        sb.append(((this.dateAutBCT == null)?"<null>":this.dateAutBCT));
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
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.dateAutBCT == null)? 0 :this.dateAutBCT.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RefAutorisationBct) == false) {
            return false;
        }
        RefAutorisationBct rhs = ((RefAutorisationBct) other);
        return ((((this.numAutBCT == rhs.numAutBCT)||((this.numAutBCT!= null)&&this.numAutBCT.equals(rhs.numAutBCT)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.dateAutBCT == rhs.dateAutBCT)||((this.dateAutBCT!= null)&&this.dateAutBCT.equals(rhs.dateAutBCT))));
    }

}
