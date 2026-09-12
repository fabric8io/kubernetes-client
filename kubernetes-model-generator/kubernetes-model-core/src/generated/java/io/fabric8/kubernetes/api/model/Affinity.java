
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
 * Affinity is a group of affinity scheduling rules.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "nodeAffinity",
    "podAffinity",
    "podAntiAffinity"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class Affinity implements Editable<AffinityBuilder>, KubernetesResource
{

    @JsonProperty("nodeAffinity")
    private NodeAffinity nodeAffinity;
    @JsonProperty("podAffinity")
    private PodAffinity podAffinity;
    @JsonProperty("podAntiAffinity")
    private PodAntiAffinity podAntiAffinity;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Affinity() {
    }

    public Affinity(NodeAffinity nodeAffinity, PodAffinity podAffinity, PodAntiAffinity podAntiAffinity) {
        super();
        this.nodeAffinity = nodeAffinity;
        this.podAffinity = podAffinity;
        this.podAntiAffinity = podAntiAffinity;
    }

    /**
     * Affinity is a group of affinity scheduling rules.
     */
    @JsonProperty("nodeAffinity")
    public NodeAffinity getNodeAffinity() {
        return nodeAffinity;
    }

    /**
     * Affinity is a group of affinity scheduling rules.
     */
    @JsonProperty("nodeAffinity")
    public void setNodeAffinity(NodeAffinity nodeAffinity) {
        this.nodeAffinity = nodeAffinity;
    }

    /**
     * Affinity is a group of affinity scheduling rules.
     */
    @JsonProperty("podAffinity")
    public PodAffinity getPodAffinity() {
        return podAffinity;
    }

    /**
     * Affinity is a group of affinity scheduling rules.
     */
    @JsonProperty("podAffinity")
    public void setPodAffinity(PodAffinity podAffinity) {
        this.podAffinity = podAffinity;
    }

    /**
     * Affinity is a group of affinity scheduling rules.
     */
    @JsonProperty("podAntiAffinity")
    public PodAntiAffinity getPodAntiAffinity() {
        return podAntiAffinity;
    }

    /**
     * Affinity is a group of affinity scheduling rules.
     */
    @JsonProperty("podAntiAffinity")
    public void setPodAntiAffinity(PodAntiAffinity podAntiAffinity) {
        this.podAntiAffinity = podAntiAffinity;
    }

    @JsonIgnore
    public AffinityBuilder edit() {
        return new AffinityBuilder(this);
    }

    @JsonIgnore
    public AffinityBuilder toBuilder() {
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
        if (!(o instanceof Affinity)) {
            return false;
        }
        Affinity other = (Affinity) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$nodeAffinity = this.getNodeAffinity();
        Object other$nodeAffinity = other.getNodeAffinity();
        if (this$nodeAffinity == null ? other$nodeAffinity != null : !this$nodeAffinity.equals(other$nodeAffinity)) {
            return false;
        }
        Object this$podAffinity = this.getPodAffinity();
        Object other$podAffinity = other.getPodAffinity();
        if (this$podAffinity == null ? other$podAffinity != null : !this$podAffinity.equals(other$podAffinity)) {
            return false;
        }
        Object this$podAntiAffinity = this.getPodAntiAffinity();
        Object other$podAntiAffinity = other.getPodAntiAffinity();
        if (this$podAntiAffinity == null ? other$podAntiAffinity != null : !this$podAntiAffinity.equals(other$podAntiAffinity)) {
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
        return other instanceof Affinity;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $nodeAffinity = this.getNodeAffinity();
        result = result * prime + ($nodeAffinity == null ? 43 : $nodeAffinity.hashCode());
        Object $podAffinity = this.getPodAffinity();
        result = result * prime + ($podAffinity == null ? 43 : $podAffinity.hashCode());
        Object $podAntiAffinity = this.getPodAntiAffinity();
        result = result * prime + ($podAntiAffinity == null ? 43 : $podAntiAffinity.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Affinity(" + "nodeAffinity=" + this.getNodeAffinity() + ", podAffinity=" + this.getPodAffinity() + ", podAntiAffinity=" + this.getPodAntiAffinity() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
