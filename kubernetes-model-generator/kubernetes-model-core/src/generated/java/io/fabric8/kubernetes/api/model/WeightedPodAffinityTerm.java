
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
 * The weights of all of the matched WeightedPodAffinityTerm fields are added per-node to find the most preferred node(s)
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "podAffinityTerm",
    "weight"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class WeightedPodAffinityTerm implements Editable<WeightedPodAffinityTermBuilder>, KubernetesResource
{

    @JsonProperty("podAffinityTerm")
    private PodAffinityTerm podAffinityTerm;
    @JsonProperty("weight")
    private Integer weight;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public WeightedPodAffinityTerm() {
    }

    public WeightedPodAffinityTerm(PodAffinityTerm podAffinityTerm, Integer weight) {
        super();
        this.podAffinityTerm = podAffinityTerm;
        this.weight = weight;
    }

    /**
     * The weights of all of the matched WeightedPodAffinityTerm fields are added per-node to find the most preferred node(s)
     */
    @JsonProperty("podAffinityTerm")
    public PodAffinityTerm getPodAffinityTerm() {
        return podAffinityTerm;
    }

    /**
     * The weights of all of the matched WeightedPodAffinityTerm fields are added per-node to find the most preferred node(s)
     */
    @JsonProperty("podAffinityTerm")
    public void setPodAffinityTerm(PodAffinityTerm podAffinityTerm) {
        this.podAffinityTerm = podAffinityTerm;
    }

    /**
     * weight associated with matching the corresponding podAffinityTerm, in the range 1-100.
     */
    @JsonProperty("weight")
    public Integer getWeight() {
        return weight;
    }

    /**
     * weight associated with matching the corresponding podAffinityTerm, in the range 1-100.
     */
    @JsonProperty("weight")
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @JsonIgnore
    public WeightedPodAffinityTermBuilder edit() {
        return new WeightedPodAffinityTermBuilder(this);
    }

    @JsonIgnore
    public WeightedPodAffinityTermBuilder toBuilder() {
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
        if (!(o instanceof WeightedPodAffinityTerm)) {
            return false;
        }
        WeightedPodAffinityTerm other = (WeightedPodAffinityTerm) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$podAffinityTerm = this.getPodAffinityTerm();
        Object other$podAffinityTerm = other.getPodAffinityTerm();
        if (this$podAffinityTerm == null ? other$podAffinityTerm != null : !this$podAffinityTerm.equals(other$podAffinityTerm)) {
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
        return other instanceof WeightedPodAffinityTerm;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $podAffinityTerm = this.getPodAffinityTerm();
        result = result * prime + ($podAffinityTerm == null ? 43 : $podAffinityTerm.hashCode());
        Object $weight = this.getWeight();
        result = result * prime + ($weight == null ? 43 : $weight.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "WeightedPodAffinityTerm(" + "podAffinityTerm=" + this.getPodAffinityTerm() + ", weight=" + this.getWeight() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
