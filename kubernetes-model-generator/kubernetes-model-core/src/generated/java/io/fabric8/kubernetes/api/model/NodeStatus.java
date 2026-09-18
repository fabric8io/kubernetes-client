
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
 * NodeStatus is information about the current status of a node.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "addresses",
    "allocatable",
    "capacity",
    "conditions",
    "config",
    "daemonEndpoints",
    "declaredFeatures",
    "features",
    "images",
    "nodeInfo",
    "phase",
    "runtimeHandlers",
    "volumesAttached",
    "volumesInUse"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class NodeStatus implements Editable<NodeStatusBuilder>, KubernetesResource
{

    @JsonProperty("addresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NodeAddress> addresses = new ArrayList<>();
    @JsonProperty("allocatable")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Quantity> allocatable = new LinkedHashMap<>();
    @JsonProperty("capacity")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Quantity> capacity = new LinkedHashMap<>();
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NodeCondition> conditions = new ArrayList<>();
    @JsonProperty("config")
    private NodeConfigStatus config;
    @JsonProperty("daemonEndpoints")
    private NodeDaemonEndpoints daemonEndpoints;
    @JsonProperty("declaredFeatures")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> declaredFeatures = new ArrayList<>();
    @JsonProperty("features")
    private NodeFeatures features;
    @JsonProperty("images")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ContainerImage> images = new ArrayList<>();
    @JsonProperty("nodeInfo")
    private NodeSystemInfo nodeInfo;
    @JsonProperty("phase")
    private String phase;
    @JsonProperty("runtimeHandlers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NodeRuntimeHandler> runtimeHandlers = new ArrayList<>();
    @JsonProperty("volumesAttached")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AttachedVolume> volumesAttached = new ArrayList<>();
    @JsonProperty("volumesInUse")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> volumesInUse = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NodeStatus() {
    }

    public NodeStatus(List<NodeAddress> addresses, Map<String, Quantity> allocatable, Map<String, Quantity> capacity, List<NodeCondition> conditions, NodeConfigStatus config, NodeDaemonEndpoints daemonEndpoints, List<String> declaredFeatures, NodeFeatures features, List<ContainerImage> images, NodeSystemInfo nodeInfo, String phase, List<NodeRuntimeHandler> runtimeHandlers, List<AttachedVolume> volumesAttached, List<String> volumesInUse) {
        super();
        this.addresses = addresses;
        this.allocatable = allocatable;
        this.capacity = capacity;
        this.conditions = conditions;
        this.config = config;
        this.daemonEndpoints = daemonEndpoints;
        this.declaredFeatures = declaredFeatures;
        this.features = features;
        this.images = images;
        this.nodeInfo = nodeInfo;
        this.phase = phase;
        this.runtimeHandlers = runtimeHandlers;
        this.volumesAttached = volumesAttached;
        this.volumesInUse = volumesInUse;
    }

    /**
     * List of addresses reachable to the node. Queried from cloud provider, if available. More info: https://kubernetes.io/docs/reference/node/node-status/#addresses Note: This field is declared as mergeable, but the merge key is not sufficiently unique, which can cause data corruption when it is merged. Callers should instead use a full-replacement patch. See https://pr.k8s.io/79391 for an example. Consumers should assume that addresses can change during the lifetime of a Node. However, there are some exceptions where this may not be possible, such as Pods that inherit a Node's address in its own status or consumers of the downward API (status.hostIP).
     */
    @JsonProperty("addresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NodeAddress> getAddresses() {
        return addresses;
    }

    /**
     * List of addresses reachable to the node. Queried from cloud provider, if available. More info: https://kubernetes.io/docs/reference/node/node-status/#addresses Note: This field is declared as mergeable, but the merge key is not sufficiently unique, which can cause data corruption when it is merged. Callers should instead use a full-replacement patch. See https://pr.k8s.io/79391 for an example. Consumers should assume that addresses can change during the lifetime of a Node. However, there are some exceptions where this may not be possible, such as Pods that inherit a Node's address in its own status or consumers of the downward API (status.hostIP).
     */
    @JsonProperty("addresses")
    public void setAddresses(List<NodeAddress> addresses) {
        this.addresses = addresses;
    }

    /**
     * Allocatable represents the resources of a node that are available for scheduling. Defaults to Capacity.
     */
    @JsonProperty("allocatable")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Quantity> getAllocatable() {
        return allocatable;
    }

    /**
     * Allocatable represents the resources of a node that are available for scheduling. Defaults to Capacity.
     */
    @JsonProperty("allocatable")
    public void setAllocatable(Map<String, Quantity> allocatable) {
        this.allocatable = allocatable;
    }

    /**
     * Capacity represents the total resources of a node. More info: https://kubernetes.io/docs/reference/node/node-status/#capacity
     */
    @JsonProperty("capacity")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Quantity> getCapacity() {
        return capacity;
    }

    /**
     * Capacity represents the total resources of a node. More info: https://kubernetes.io/docs/reference/node/node-status/#capacity
     */
    @JsonProperty("capacity")
    public void setCapacity(Map<String, Quantity> capacity) {
        this.capacity = capacity;
    }

    /**
     * Conditions is an array of current observed node conditions. More info: https://kubernetes.io/docs/reference/node/node-status/#condition
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NodeCondition> getConditions() {
        return conditions;
    }

    /**
     * Conditions is an array of current observed node conditions. More info: https://kubernetes.io/docs/reference/node/node-status/#condition
     */
    @JsonProperty("conditions")
    public void setConditions(List<NodeCondition> conditions) {
        this.conditions = conditions;
    }

    /**
     * NodeStatus is information about the current status of a node.
     */
    @JsonProperty("config")
    public NodeConfigStatus getConfig() {
        return config;
    }

    /**
     * NodeStatus is information about the current status of a node.
     */
    @JsonProperty("config")
    public void setConfig(NodeConfigStatus config) {
        this.config = config;
    }

    /**
     * NodeStatus is information about the current status of a node.
     */
    @JsonProperty("daemonEndpoints")
    public NodeDaemonEndpoints getDaemonEndpoints() {
        return daemonEndpoints;
    }

    /**
     * NodeStatus is information about the current status of a node.
     */
    @JsonProperty("daemonEndpoints")
    public void setDaemonEndpoints(NodeDaemonEndpoints daemonEndpoints) {
        this.daemonEndpoints = daemonEndpoints;
    }

    /**
     * DeclaredFeatures represents the features related to feature gates that are declared by the node.
     */
    @JsonProperty("declaredFeatures")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getDeclaredFeatures() {
        return declaredFeatures;
    }

    /**
     * DeclaredFeatures represents the features related to feature gates that are declared by the node.
     */
    @JsonProperty("declaredFeatures")
    public void setDeclaredFeatures(List<String> declaredFeatures) {
        this.declaredFeatures = declaredFeatures;
    }

    /**
     * NodeStatus is information about the current status of a node.
     */
    @JsonProperty("features")
    public NodeFeatures getFeatures() {
        return features;
    }

    /**
     * NodeStatus is information about the current status of a node.
     */
    @JsonProperty("features")
    public void setFeatures(NodeFeatures features) {
        this.features = features;
    }

    /**
     * List of container images on this node
     */
    @JsonProperty("images")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ContainerImage> getImages() {
        return images;
    }

    /**
     * List of container images on this node
     */
    @JsonProperty("images")
    public void setImages(List<ContainerImage> images) {
        this.images = images;
    }

    /**
     * NodeStatus is information about the current status of a node.
     */
    @JsonProperty("nodeInfo")
    public NodeSystemInfo getNodeInfo() {
        return nodeInfo;
    }

    /**
     * NodeStatus is information about the current status of a node.
     */
    @JsonProperty("nodeInfo")
    public void setNodeInfo(NodeSystemInfo nodeInfo) {
        this.nodeInfo = nodeInfo;
    }

    /**
     * NodePhase is the recently observed lifecycle phase of the node. More info: https://kubernetes.io/docs/concepts/nodes/node/#phase The field is never populated, and now is deprecated.
     */
    @JsonProperty("phase")
    public String getPhase() {
        return phase;
    }

    /**
     * NodePhase is the recently observed lifecycle phase of the node. More info: https://kubernetes.io/docs/concepts/nodes/node/#phase The field is never populated, and now is deprecated.
     */
    @JsonProperty("phase")
    public void setPhase(String phase) {
        this.phase = phase;
    }

    /**
     * The available runtime handlers.
     */
    @JsonProperty("runtimeHandlers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NodeRuntimeHandler> getRuntimeHandlers() {
        return runtimeHandlers;
    }

    /**
     * The available runtime handlers.
     */
    @JsonProperty("runtimeHandlers")
    public void setRuntimeHandlers(List<NodeRuntimeHandler> runtimeHandlers) {
        this.runtimeHandlers = runtimeHandlers;
    }

    /**
     * List of volumes that are attached to the node.
     */
    @JsonProperty("volumesAttached")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AttachedVolume> getVolumesAttached() {
        return volumesAttached;
    }

    /**
     * List of volumes that are attached to the node.
     */
    @JsonProperty("volumesAttached")
    public void setVolumesAttached(List<AttachedVolume> volumesAttached) {
        this.volumesAttached = volumesAttached;
    }

    /**
     * List of attachable volumes in use (mounted) by the node.
     */
    @JsonProperty("volumesInUse")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getVolumesInUse() {
        return volumesInUse;
    }

    /**
     * List of attachable volumes in use (mounted) by the node.
     */
    @JsonProperty("volumesInUse")
    public void setVolumesInUse(List<String> volumesInUse) {
        this.volumesInUse = volumesInUse;
    }

    @JsonIgnore
    public NodeStatusBuilder edit() {
        return new NodeStatusBuilder(this);
    }

    @JsonIgnore
    public NodeStatusBuilder toBuilder() {
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
        if (!(o instanceof NodeStatus)) {
            return false;
        }
        NodeStatus other = (NodeStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$addresses = this.getAddresses();
        Object other$addresses = other.getAddresses();
        if (this$addresses == null ? other$addresses != null : !this$addresses.equals(other$addresses)) {
            return false;
        }
        Object this$allocatable = this.getAllocatable();
        Object other$allocatable = other.getAllocatable();
        if (this$allocatable == null ? other$allocatable != null : !this$allocatable.equals(other$allocatable)) {
            return false;
        }
        Object this$capacity = this.getCapacity();
        Object other$capacity = other.getCapacity();
        if (this$capacity == null ? other$capacity != null : !this$capacity.equals(other$capacity)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$config = this.getConfig();
        Object other$config = other.getConfig();
        if (this$config == null ? other$config != null : !this$config.equals(other$config)) {
            return false;
        }
        Object this$daemonEndpoints = this.getDaemonEndpoints();
        Object other$daemonEndpoints = other.getDaemonEndpoints();
        if (this$daemonEndpoints == null ? other$daemonEndpoints != null : !this$daemonEndpoints.equals(other$daemonEndpoints)) {
            return false;
        }
        Object this$declaredFeatures = this.getDeclaredFeatures();
        Object other$declaredFeatures = other.getDeclaredFeatures();
        if (this$declaredFeatures == null ? other$declaredFeatures != null : !this$declaredFeatures.equals(other$declaredFeatures)) {
            return false;
        }
        Object this$features = this.getFeatures();
        Object other$features = other.getFeatures();
        if (this$features == null ? other$features != null : !this$features.equals(other$features)) {
            return false;
        }
        Object this$images = this.getImages();
        Object other$images = other.getImages();
        if (this$images == null ? other$images != null : !this$images.equals(other$images)) {
            return false;
        }
        Object this$nodeInfo = this.getNodeInfo();
        Object other$nodeInfo = other.getNodeInfo();
        if (this$nodeInfo == null ? other$nodeInfo != null : !this$nodeInfo.equals(other$nodeInfo)) {
            return false;
        }
        Object this$phase = this.getPhase();
        Object other$phase = other.getPhase();
        if (this$phase == null ? other$phase != null : !this$phase.equals(other$phase)) {
            return false;
        }
        Object this$runtimeHandlers = this.getRuntimeHandlers();
        Object other$runtimeHandlers = other.getRuntimeHandlers();
        if (this$runtimeHandlers == null ? other$runtimeHandlers != null : !this$runtimeHandlers.equals(other$runtimeHandlers)) {
            return false;
        }
        Object this$volumesAttached = this.getVolumesAttached();
        Object other$volumesAttached = other.getVolumesAttached();
        if (this$volumesAttached == null ? other$volumesAttached != null : !this$volumesAttached.equals(other$volumesAttached)) {
            return false;
        }
        Object this$volumesInUse = this.getVolumesInUse();
        Object other$volumesInUse = other.getVolumesInUse();
        if (this$volumesInUse == null ? other$volumesInUse != null : !this$volumesInUse.equals(other$volumesInUse)) {
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
        return other instanceof NodeStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $addresses = this.getAddresses();
        result = result * prime + ($addresses == null ? 43 : $addresses.hashCode());
        Object $allocatable = this.getAllocatable();
        result = result * prime + ($allocatable == null ? 43 : $allocatable.hashCode());
        Object $capacity = this.getCapacity();
        result = result * prime + ($capacity == null ? 43 : $capacity.hashCode());
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $config = this.getConfig();
        result = result * prime + ($config == null ? 43 : $config.hashCode());
        Object $daemonEndpoints = this.getDaemonEndpoints();
        result = result * prime + ($daemonEndpoints == null ? 43 : $daemonEndpoints.hashCode());
        Object $declaredFeatures = this.getDeclaredFeatures();
        result = result * prime + ($declaredFeatures == null ? 43 : $declaredFeatures.hashCode());
        Object $features = this.getFeatures();
        result = result * prime + ($features == null ? 43 : $features.hashCode());
        Object $images = this.getImages();
        result = result * prime + ($images == null ? 43 : $images.hashCode());
        Object $nodeInfo = this.getNodeInfo();
        result = result * prime + ($nodeInfo == null ? 43 : $nodeInfo.hashCode());
        Object $phase = this.getPhase();
        result = result * prime + ($phase == null ? 43 : $phase.hashCode());
        Object $runtimeHandlers = this.getRuntimeHandlers();
        result = result * prime + ($runtimeHandlers == null ? 43 : $runtimeHandlers.hashCode());
        Object $volumesAttached = this.getVolumesAttached();
        result = result * prime + ($volumesAttached == null ? 43 : $volumesAttached.hashCode());
        Object $volumesInUse = this.getVolumesInUse();
        result = result * prime + ($volumesInUse == null ? 43 : $volumesInUse.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NodeStatus(" + "addresses=" + this.getAddresses() + ", allocatable=" + this.getAllocatable() + ", capacity=" + this.getCapacity() + ", conditions=" + this.getConditions() + ", config=" + this.getConfig() + ", daemonEndpoints=" + this.getDaemonEndpoints() + ", declaredFeatures=" + this.getDeclaredFeatures() + ", features=" + this.getFeatures() + ", images=" + this.getImages() + ", nodeInfo=" + this.getNodeInfo() + ", phase=" + this.getPhase() + ", runtimeHandlers=" + this.getRuntimeHandlers() + ", volumesAttached=" + this.getVolumesAttached() + ", volumesInUse=" + this.getVolumesInUse() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
