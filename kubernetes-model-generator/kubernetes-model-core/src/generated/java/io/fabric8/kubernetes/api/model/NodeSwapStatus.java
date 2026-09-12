
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
 * NodeSwapStatus represents swap memory information.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "capacity"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class NodeSwapStatus implements Editable<NodeSwapStatusBuilder>, KubernetesResource
{

    @JsonProperty("capacity")
    private Long capacity;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NodeSwapStatus() {
    }

    public NodeSwapStatus(Long capacity) {
        super();
        this.capacity = capacity;
    }

    /**
     * Total amount of swap memory in bytes.
     */
    @JsonProperty("capacity")
    public Long getCapacity() {
        return capacity;
    }

    /**
     * Total amount of swap memory in bytes.
     */
    @JsonProperty("capacity")
    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    @JsonIgnore
    public NodeSwapStatusBuilder edit() {
        return new NodeSwapStatusBuilder(this);
    }

    @JsonIgnore
    public NodeSwapStatusBuilder toBuilder() {
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
        if (!(o instanceof NodeSwapStatus)) {
            return false;
        }
        NodeSwapStatus other = (NodeSwapStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$capacity = this.getCapacity();
        Object other$capacity = other.getCapacity();
        if (this$capacity == null ? other$capacity != null : !this$capacity.equals(other$capacity)) {
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
        return other instanceof NodeSwapStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $capacity = this.getCapacity();
        result = result * prime + ($capacity == null ? 43 : $capacity.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NodeSwapStatus(" + "capacity=" + this.getCapacity() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
