
package io.fabric8.kubernetes.api.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
 * NodeAllocatableResourceClaimStatus describes the status of node allocatable resources allocated via DRA.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "containers",
    "resourceClaimName",
    "resources"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class NodeAllocatableResourceClaimStatus implements Editable<NodeAllocatableResourceClaimStatusBuilder>, KubernetesResource
{

    @JsonProperty("containers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> containers = new ArrayList<>();
    @JsonProperty("resourceClaimName")
    private String resourceClaimName;
    @JsonProperty("resources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Quantity> resources = new LinkedHashMap<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NodeAllocatableResourceClaimStatus() {
    }

    public NodeAllocatableResourceClaimStatus(List<String> containers, String resourceClaimName, Map<String, Quantity> resources) {
        super();
        this.containers = containers;
        this.resourceClaimName = resourceClaimName;
        this.resources = resources;
    }

    /**
     * Containers lists the names of all containers in this pod that reference the claim.
     */
    @JsonProperty("containers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getContainers() {
        return containers;
    }

    /**
     * Containers lists the names of all containers in this pod that reference the claim.
     */
    @JsonProperty("containers")
    public void setContainers(List<String> containers) {
        this.containers = containers;
    }

    /**
     * ResourceClaimName is the resource claim referenced by the pod that resulted in this node allocatable resource allocation.
     */
    @JsonProperty("resourceClaimName")
    public String getResourceClaimName() {
        return resourceClaimName;
    }

    /**
     * ResourceClaimName is the resource claim referenced by the pod that resulted in this node allocatable resource allocation.
     */
    @JsonProperty("resourceClaimName")
    public void setResourceClaimName(String resourceClaimName) {
        this.resourceClaimName = resourceClaimName;
    }

    /**
     * Resources is a map of the node-allocatable resource name to the aggregate quantity allocated to the claim.
     */
    @JsonProperty("resources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Quantity> getResources() {
        return resources;
    }

    /**
     * Resources is a map of the node-allocatable resource name to the aggregate quantity allocated to the claim.
     */
    @JsonProperty("resources")
    public void setResources(Map<String, Quantity> resources) {
        this.resources = resources;
    }

    @JsonIgnore
    public NodeAllocatableResourceClaimStatusBuilder edit() {
        return new NodeAllocatableResourceClaimStatusBuilder(this);
    }

    @JsonIgnore
    public NodeAllocatableResourceClaimStatusBuilder toBuilder() {
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
