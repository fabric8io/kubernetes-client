
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
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

}
