
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
    "features",
    "images",
    "nodeInfo",
    "phase",
    "runtimeHandlers",
    "volumesAttached",
    "volumesInUse"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
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

    public NodeStatus(List<NodeAddress> addresses, Map<String, Quantity> allocatable, Map<String, Quantity> capacity, List<NodeCondition> conditions, NodeConfigStatus config, NodeDaemonEndpoints daemonEndpoints, NodeFeatures features, List<ContainerImage> images, NodeSystemInfo nodeInfo, String phase, List<NodeRuntimeHandler> runtimeHandlers, List<AttachedVolume> volumesAttached, List<String> volumesInUse) {
        super();
        this.addresses = addresses;
        this.allocatable = allocatable;
        this.capacity = capacity;
        this.conditions = conditions;
        this.config = config;
        this.daemonEndpoints = daemonEndpoints;
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
