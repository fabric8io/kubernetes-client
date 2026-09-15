
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
 * NodeAllocatableMappedResources describes mapped node allocatable resource allocations.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "quantity"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class NodeAllocatableMappedResources implements Editable<NodeAllocatableMappedResourcesBuilder>, KubernetesResource
{

    @JsonProperty("name")
    private String name;
    @JsonProperty("quantity")
    private Quantity quantity;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NodeAllocatableMappedResources() {
    }

    public NodeAllocatableMappedResources(String name, Quantity quantity) {
        super();
        this.name = name;
        this.quantity = quantity;
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
     * NodeAllocatableMappedResources describes mapped node allocatable resource allocations.
     */
    @JsonProperty("quantity")
    public Quantity getQuantity() {
        return quantity;
    }

    /**
     * NodeAllocatableMappedResources describes mapped node allocatable resource allocations.
     */
    @JsonProperty("quantity")
    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    @JsonIgnore
    public NodeAllocatableMappedResourcesBuilder edit() {
        return new NodeAllocatableMappedResourcesBuilder(this);
    }

    @JsonIgnore
    public NodeAllocatableMappedResourcesBuilder toBuilder() {
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
        if (!(o instanceof NodeAllocatableMappedResources)) {
            return false;
        }
        NodeAllocatableMappedResources other = (NodeAllocatableMappedResources) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$quantity = this.getQuantity();
        Object other$quantity = other.getQuantity();
        if (this$quantity == null ? other$quantity != null : !this$quantity.equals(other$quantity)) {
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
        return other instanceof NodeAllocatableMappedResources;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $quantity = this.getQuantity();
        result = result * prime + ($quantity == null ? 43 : $quantity.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NodeAllocatableMappedResources(" + "name=" + this.getName() + ", quantity=" + this.getQuantity() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
