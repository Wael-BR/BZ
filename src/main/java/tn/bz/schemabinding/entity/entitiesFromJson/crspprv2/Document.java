
package tn.bz.schemabinding.entity.entitiesFromJson.crspprv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;
import javax.validation.Valid;

@Generated("jsonschema2pojo")
public class Document {

    @Valid
    private EnteteDoc enteteDoc;
    @Valid
    private List<Extrait> extraits = new ArrayList<Extrait>();
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public EnteteDoc getEnteteDoc() {
        return enteteDoc;
    }

    public void setEnteteDoc(EnteteDoc enteteDoc) {
        this.enteteDoc = enteteDoc;
    }

    public List<Extrait> getExtraits() {
        return extraits;
    }

    public void setExtraits(List<Extrait> extraits) {
        this.extraits = extraits;
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
        sb.append(Document.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("enteteDoc");
        sb.append('=');
        sb.append(((this.enteteDoc == null)?"<null>":this.enteteDoc));
        sb.append(',');
        sb.append("extraits");
        sb.append('=');
        sb.append(((this.extraits == null)?"<null>":this.extraits));
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
        result = ((result* 31)+((this.extraits == null)? 0 :this.extraits.hashCode()));
        result = ((result* 31)+((this.enteteDoc == null)? 0 :this.enteteDoc.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Document) == false) {
            return false;
        }
        Document rhs = ((Document) other);
        return ((((this.extraits == rhs.extraits)||((this.extraits!= null)&&this.extraits.equals(rhs.extraits)))&&((this.enteteDoc == rhs.enteteDoc)||((this.enteteDoc!= null)&&this.enteteDoc.equals(rhs.enteteDoc))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
