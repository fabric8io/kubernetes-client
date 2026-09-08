
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
    "mapping",
    "overhead",
    "resourceClaimName"
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
    @JsonProperty("mapping")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NodeAllocatableMappedResources> mapping = new ArrayList<>();
    @JsonProperty("overhead")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NodeAllocatableOverheadResources> overhead = new ArrayList<>();
    @JsonProperty("resourceClaimName")
    private String resourceClaimName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NodeAllocatableResourceClaimStatus() {
    }

    public NodeAllocatableResourceClaimStatus(List<String> containers, List<NodeAllocatableMappedResources> mapping, List<NodeAllocatableOverheadResources> overhead, String resourceClaimName) {
        super();
        this.containers = containers;
        this.mapping = mapping;
        this.overhead = overhead;
        this.resourceClaimName = resourceClaimName;
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
     * Mapping contains allocations through devices mapped in the device spec's `nodeAllocatableResources[...].mapping` field. This is used by kubelet for pod level and container-level cgroup enforcement.
     */
    @JsonProperty("mapping")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NodeAllocatableMappedResources> getMapping() {
        return mapping;
    }

    /**
     * Mapping contains allocations through devices mapped in the device spec's `nodeAllocatableResources[...].mapping` field. This is used by kubelet for pod level and container-level cgroup enforcement.
     */
    @JsonProperty("mapping")
    public void setMapping(List<NodeAllocatableMappedResources> mapping) {
        this.mapping = mapping;
    }

    /**
     * Overhead contains allocations through devices mapped in the device spec's `nodeAllocatableResources[...].overhead` field. This is used by kubelet for pod level and container-level cgroup enforcement.
     */
    @JsonProperty("overhead")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NodeAllocatableOverheadResources> getOverhead() {
        return overhead;
    }

    /**
     * Overhead contains allocations through devices mapped in the device spec's `nodeAllocatableResources[...].overhead` field. This is used by kubelet for pod level and container-level cgroup enforcement.
     */
    @JsonProperty("overhead")
    public void setOverhead(List<NodeAllocatableOverheadResources> overhead) {
        this.overhead = overhead;
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
