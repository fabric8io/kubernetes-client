
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
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "addresses",
    "allocatable",
    "capacity",
    "conditions",
    "config",
    "daemonEndpoints",
    "images",
    "nodeInfo",
    "phase",
    "volumesAttached",
    "volumesInUse"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("jsonschema2pojo")
public class NodeStatus implements KubernetesResource
{

    @JsonProperty("addresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NodeAddress> addresses = new ArrayList<NodeAddress>();
    @JsonProperty("allocatable")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, io.fabric8.kubernetes.api.model.Quantity> allocatable = new LinkedHashMap<String, io.fabric8.kubernetes.api.model.Quantity>();
    @JsonProperty("capacity")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, io.fabric8.kubernetes.api.model.Quantity> capacity = new LinkedHashMap<String, io.fabric8.kubernetes.api.model.Quantity>();
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NodeCondition> conditions = new ArrayList<NodeCondition>();
    @JsonProperty("config")
    private NodeConfigStatus config;
    @JsonProperty("daemonEndpoints")
    private NodeDaemonEndpoints daemonEndpoints;
    @JsonProperty("images")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ContainerImage> images = new ArrayList<ContainerImage>();
    @JsonProperty("nodeInfo")
    private NodeSystemInfo nodeInfo;
    @JsonProperty("phase")
    private java.lang.String phase;
    @JsonProperty("volumesAttached")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AttachedVolume> volumesAttached = new ArrayList<AttachedVolume>();
    @JsonProperty("volumesInUse")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> volumesInUse = new ArrayList<java.lang.String>();
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public NodeStatus() {
    }

    public NodeStatus(List<NodeAddress> addresses, Map<String, io.fabric8.kubernetes.api.model.Quantity> allocatable, Map<String, io.fabric8.kubernetes.api.model.Quantity> capacity, List<NodeCondition> conditions, NodeConfigStatus config, NodeDaemonEndpoints daemonEndpoints, List<ContainerImage> images, NodeSystemInfo nodeInfo, java.lang.String phase, List<AttachedVolume> volumesAttached, List<java.lang.String> volumesInUse) {
        super();
        this.addresses = addresses;
        this.allocatable = allocatable;
        this.capacity = capacity;
        this.conditions = conditions;
        this.config = config;
        this.daemonEndpoints = daemonEndpoints;
        this.images = images;
        this.nodeInfo = nodeInfo;
        this.phase = phase;
        this.volumesAttached = volumesAttached;
        this.volumesInUse = volumesInUse;
    }

    @JsonProperty("addresses")
    public List<NodeAddress> getAddresses() {
        return addresses;
    }

    @JsonProperty("addresses")
    public void setAddresses(List<NodeAddress> addresses) {
        this.addresses = addresses;
    }

    @JsonProperty("allocatable")
    public Map<String, io.fabric8.kubernetes.api.model.Quantity> getAllocatable() {
        return allocatable;
    }

    @JsonProperty("allocatable")
    public void setAllocatable(Map<String, io.fabric8.kubernetes.api.model.Quantity> allocatable) {
        this.allocatable = allocatable;
    }

    @JsonProperty("capacity")
    public Map<String, io.fabric8.kubernetes.api.model.Quantity> getCapacity() {
        return capacity;
    }

    @JsonProperty("capacity")
    public void setCapacity(Map<String, io.fabric8.kubernetes.api.model.Quantity> capacity) {
        this.capacity = capacity;
    }

    @JsonProperty("conditions")
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

    @JsonProperty("images")
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
    public java.lang.String getPhase() {
        return phase;
    }

    @JsonProperty("phase")
    public void setPhase(java.lang.String phase) {
        this.phase = phase;
    }

    @JsonProperty("volumesAttached")
    public List<AttachedVolume> getVolumesAttached() {
        return volumesAttached;
    }

    @JsonProperty("volumesAttached")
    public void setVolumesAttached(List<AttachedVolume> volumesAttached) {
        this.volumesAttached = volumesAttached;
    }

    @JsonProperty("volumesInUse")
    public List<java.lang.String> getVolumesInUse() {
        return volumesInUse;
    }

    @JsonProperty("volumesInUse")
    public void setVolumesInUse(List<java.lang.String> volumesInUse) {
        this.volumesInUse = volumesInUse;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
