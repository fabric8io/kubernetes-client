
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
 * NodeAllocatableOverheadResources describes auxiliary overhead resource allocations.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "perContainer",
    "perPod"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class NodeAllocatableOverheadResources implements Editable<NodeAllocatableOverheadResourcesBuilder>, KubernetesResource
{

    @JsonProperty("name")
    private String name;
    @JsonProperty("perContainer")
    private Quantity perContainer;
    @JsonProperty("perPod")
    private Quantity perPod;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NodeAllocatableOverheadResources() {
    }

    public NodeAllocatableOverheadResources(String name, Quantity perContainer, Quantity perPod) {
        super();
        this.name = name;
        this.perContainer = perContainer;
        this.perPod = perPod;
    }

    /**
     * Name is the name of the resource (e.g., cpu, memory).
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name is the name of the resource (e.g., cpu, memory).
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * NodeAllocatableOverheadResources describes auxiliary overhead resource allocations.
     */
    @JsonProperty("perContainer")
    public Quantity getPerContainer() {
        return perContainer;
    }

    /**
     * NodeAllocatableOverheadResources describes auxiliary overhead resource allocations.
     */
    @JsonProperty("perContainer")
    public void setPerContainer(Quantity perContainer) {
        this.perContainer = perContainer;
    }

    /**
     * NodeAllocatableOverheadResources describes auxiliary overhead resource allocations.
     */
    @JsonProperty("perPod")
    public Quantity getPerPod() {
        return perPod;
    }

    /**
     * NodeAllocatableOverheadResources describes auxiliary overhead resource allocations.
     */
    @JsonProperty("perPod")
    public void setPerPod(Quantity perPod) {
        this.perPod = perPod;
    }

    @JsonIgnore
    public NodeAllocatableOverheadResourcesBuilder edit() {
        return new NodeAllocatableOverheadResourcesBuilder(this);
    }

    @JsonIgnore
    public NodeAllocatableOverheadResourcesBuilder toBuilder() {
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
        if (!(o instanceof NodeAllocatableOverheadResources)) {
            return false;
        }
        NodeAllocatableOverheadResources other = (NodeAllocatableOverheadResources) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$perContainer = this.getPerContainer();
        Object other$perContainer = other.getPerContainer();
        if (this$perContainer == null ? other$perContainer != null : !this$perContainer.equals(other$perContainer)) {
            return false;
        }
        Object this$perPod = this.getPerPod();
        Object other$perPod = other.getPerPod();
        if (this$perPod == null ? other$perPod != null : !this$perPod.equals(other$perPod)) {
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
        return other instanceof NodeAllocatableOverheadResources;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $perContainer = this.getPerContainer();
        result = result * prime + ($perContainer == null ? 43 : $perContainer.hashCode());
        Object $perPod = this.getPerPod();
        result = result * prime + ($perPod == null ? 43 : $perPod.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NodeAllocatableOverheadResources(" + "name=" + this.getName() + ", perContainer=" + this.getPerContainer() + ", perPod=" + this.getPerPod() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
