
package io.fabric8.kubernetes.api.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
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
     * 
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

    @JsonProperty("addresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NodeAddress> getAddresses() {
        return addresses;
    }

    @JsonProperty("addresses")
    public void setAddresses(List<NodeAddress> addresses) {
        this.addresses = addresses;
    }

    @JsonProperty("allocatable")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Quantity> getAllocatable() {
        return allocatable;
    }

    @JsonProperty("allocatable")
    public void setAllocatable(Map<String, Quantity> allocatable) {
        this.allocatable = allocatable;
    }

    @JsonProperty("capacity")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Quantity> getCapacity() {
        return capacity;
    }

    @JsonProperty("capacity")
    public void setCapacity(Map<String, Quantity> capacity) {
        this.capacity = capacity;
    }

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NodeCondition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<NodeCondition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("config")
    public NodeConfigStatus getConfig() {
        return config;
    }

    @JsonProperty("config")
    public void setConfig(NodeConfigStatus config) {
        this.config = config;
    }

    @JsonProperty("daemonEndpoints")
    public NodeDaemonEndpoints getDaemonEndpoints() {
        return daemonEndpoints;
    }

    @JsonProperty("daemonEndpoints")
    public void setDaemonEndpoints(NodeDaemonEndpoints daemonEndpoints) {
        this.daemonEndpoints = daemonEndpoints;
    }

    @JsonProperty("features")
    public NodeFeatures getFeatures() {
        return features;
    }

    @JsonProperty("features")
    public void setFeatures(NodeFeatures features) {
        this.features = features;
    }

    @JsonProperty("images")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ContainerImage> getImages() {
        return images;
    }

    @JsonProperty("images")
    public void setImages(List<ContainerImage> images) {
        this.images = images;
    }

    @JsonProperty("nodeInfo")
    public NodeSystemInfo getNodeInfo() {
        return nodeInfo;
    }

    @JsonProperty("nodeInfo")
    public void setNodeInfo(NodeSystemInfo nodeInfo) {
        this.nodeInfo = nodeInfo;
    }

    @JsonProperty("phase")
    public String getPhase() {
        return phase;
    }

    @JsonProperty("phase")
    public void setPhase(String phase) {
        this.phase = phase;
    }

    @JsonProperty("runtimeHandlers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NodeRuntimeHandler> getRuntimeHandlers() {
        return runtimeHandlers;
    }

    @JsonProperty("runtimeHandlers")
    public void setRuntimeHandlers(List<NodeRuntimeHandler> runtimeHandlers) {
        this.runtimeHandlers = runtimeHandlers;
    }

    @JsonProperty("volumesAttached")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AttachedVolume> getVolumesAttached() {
        return volumesAttached;
    }

    @JsonProperty("volumesAttached")
    public void setVolumesAttached(List<AttachedVolume> volumesAttached) {
        this.volumesAttached = volumesAttached;
    }

    @JsonProperty("volumesInUse")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getVolumesInUse() {
        return volumesInUse;
    }

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
