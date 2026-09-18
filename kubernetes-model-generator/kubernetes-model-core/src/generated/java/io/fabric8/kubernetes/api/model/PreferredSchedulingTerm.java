
package io.fabric8.kubernetes.api.model;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
import io.sundr.builder.annotations.Buildable;

/**
 * An empty preferred scheduling term matches all objects with implicit weight 0 (i.e. it's a no-op). A null preferred scheduling term matches no objects (i.e. is also a no-op).
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "preference",
    "weight"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class PreferredSchedulingTerm implements Editable<PreferredSchedulingTermBuilder>, KubernetesResource
{

    @JsonProperty("preference")
    private NodeSelectorTerm preference;
    @JsonProperty("weight")
    private Integer weight;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PreferredSchedulingTerm() {
    }

    public PreferredSchedulingTerm(NodeSelectorTerm preference, Integer weight) {
        super();
        this.preference = preference;
        this.weight = weight;
    }

    /**
     * An empty preferred scheduling term matches all objects with implicit weight 0 (i.e. it's a no-op). A null preferred scheduling term matches no objects (i.e. is also a no-op).
     */
    @JsonProperty("preference")
    public NodeSelectorTerm getPreference() {
        return preference;
    }

    /**
     * An empty preferred scheduling term matches all objects with implicit weight 0 (i.e. it's a no-op). A null preferred scheduling term matches no objects (i.e. is also a no-op).
     */
    @JsonProperty("preference")
    public void setPreference(NodeSelectorTerm preference) {
        this.preference = preference;
    }

    /**
     * Weight associated with matching the corresponding nodeSelectorTerm, in the range 1-100.
     */
    @JsonProperty("weight")
    public Integer getWeight() {
        return weight;
    }

    /**
     * Weight associated with matching the corresponding nodeSelectorTerm, in the range 1-100.
     */
    @JsonProperty("weight")
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @JsonIgnore
    public PreferredSchedulingTermBuilder edit() {
        return new PreferredSchedulingTermBuilder(this);
    }

    @JsonIgnore
    public PreferredSchedulingTermBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
    @JsonIgnore
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof PreferredSchedulingTerm)) {
            return false;
        }
        PreferredSchedulingTerm other = (PreferredSchedulingTerm) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$preference = this.getPreference();
        Object other$preference = other.getPreference();
        if (this$preference == null ? other$preference != null : !this$preference.equals(other$preference)) {
            return false;
        }
        Object this$weight = this.getWeight();
        Object other$weight = other.getWeight();
        if (this$weight == null ? other$weight != null : !this$weight.equals(other$weight)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof PreferredSchedulingTerm;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $preference = this.getPreference();
        result = result * prime + ($preference == null ? 43 : $preference.hashCode());
        Object $weight = this.getWeight();
        result = result * prime + ($weight == null ? 43 : $weight.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PreferredSchedulingTerm(" + "preference=" + this.getPreference() + ", weight=" + this.getWeight() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
