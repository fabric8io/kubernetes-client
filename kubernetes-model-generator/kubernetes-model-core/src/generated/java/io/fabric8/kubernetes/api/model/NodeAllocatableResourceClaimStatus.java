
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof NodeAllocatableResourceClaimStatus)) {
            return false;
        }
        NodeAllocatableResourceClaimStatus other = (NodeAllocatableResourceClaimStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$containers = this.getContainers();
        Object other$containers = other.getContainers();
        if (this$containers == null ? other$containers != null : !this$containers.equals(other$containers)) {
            return false;
        }
        Object this$mapping = this.getMapping();
        Object other$mapping = other.getMapping();
        if (this$mapping == null ? other$mapping != null : !this$mapping.equals(other$mapping)) {
            return false;
        }
        Object this$overhead = this.getOverhead();
        Object other$overhead = other.getOverhead();
        if (this$overhead == null ? other$overhead != null : !this$overhead.equals(other$overhead)) {
            return false;
        }
        Object this$resourceClaimName = this.getResourceClaimName();
        Object other$resourceClaimName = other.getResourceClaimName();
        if (this$resourceClaimName == null ? other$resourceClaimName != null : !this$resourceClaimName.equals(other$resourceClaimName)) {
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
        return other instanceof NodeAllocatableResourceClaimStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $containers = this.getContainers();
        result = result * prime + ($containers == null ? 43 : $containers.hashCode());
        Object $mapping = this.getMapping();
        result = result * prime + ($mapping == null ? 43 : $mapping.hashCode());
        Object $overhead = this.getOverhead();
        result = result * prime + ($overhead == null ? 43 : $overhead.hashCode());
        Object $resourceClaimName = this.getResourceClaimName();
        result = result * prime + ($resourceClaimName == null ? 43 : $resourceClaimName.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NodeAllocatableResourceClaimStatus(" + "containers=" + this.getContainers() + ", mapping=" + this.getMapping() + ", overhead=" + this.getOverhead() + ", resourceClaimName=" + this.getResourceClaimName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
