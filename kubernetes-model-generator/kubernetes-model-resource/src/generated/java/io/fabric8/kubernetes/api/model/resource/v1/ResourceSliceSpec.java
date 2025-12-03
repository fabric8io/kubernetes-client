
package io.fabric8.kubernetes.api.model.resource.v1;

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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.NodeSelector;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * ResourceSliceSpec contains the information published by the driver in one ResourceSlice.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "allNodes",
    "devices",
    "driver",
    "nodeName",
    "nodeSelector",
    "perDeviceNodeSelection",
    "pool",
    "sharedCounters"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ResourceSliceSpec implements Editable<ResourceSliceSpecBuilder>, KubernetesResource
{

    @JsonProperty("allNodes")
    private Boolean allNodes;
    @JsonProperty("devices")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Device> devices = new ArrayList<>();
    @JsonProperty("driver")
    private String driver;
    @JsonProperty("nodeName")
    private String nodeName;
    @JsonProperty("nodeSelector")
    private NodeSelector nodeSelector;
    @JsonProperty("perDeviceNodeSelection")
    private Boolean perDeviceNodeSelection;
    @JsonProperty("pool")
    private ResourcePool pool;
    @JsonProperty("sharedCounters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<CounterSet> sharedCounters = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ResourceSliceSpec() {
    }

    public ResourceSliceSpec(Boolean allNodes, List<Device> devices, String driver, String nodeName, NodeSelector nodeSelector, Boolean perDeviceNodeSelection, ResourcePool pool, List<CounterSet> sharedCounters) {
        super();
        this.allNodes = allNodes;
        this.devices = devices;
        this.driver = driver;
        this.nodeName = nodeName;
        this.nodeSelector = nodeSelector;
        this.perDeviceNodeSelection = perDeviceNodeSelection;
        this.pool = pool;
        this.sharedCounters = sharedCounters;
    }

    /**
     * AllNodes indicates that all nodes have access to the resources in the pool.<br><p> <br><p> Exactly one of NodeName, NodeSelector, AllNodes, and PerDeviceNodeSelection must be set.
     */
    @JsonProperty("allNodes")
    public Boolean getAllNodes() {
        return allNodes;
    }

    /**
     * AllNodes indicates that all nodes have access to the resources in the pool.<br><p> <br><p> Exactly one of NodeName, NodeSelector, AllNodes, and PerDeviceNodeSelection must be set.
     */
    @JsonProperty("allNodes")
    public void setAllNodes(Boolean allNodes) {
        this.allNodes = allNodes;
    }

    /**
     * Devices lists some or all of the devices in this pool.<br><p> <br><p> Must not have more than 128 entries.
     */
    @JsonProperty("devices")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Device> getDevices() {
        return devices;
    }

    /**
     * Devices lists some or all of the devices in this pool.<br><p> <br><p> Must not have more than 128 entries.
     */
    @JsonProperty("devices")
    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    /**
     * Driver identifies the DRA driver providing the capacity information. A field selector can be used to list only ResourceSlice objects with a certain driver name.<br><p> <br><p> Must be a DNS subdomain and should end with a DNS domain owned by the vendor of the driver. This field is immutable.
     */
    @JsonProperty("driver")
    public String getDriver() {
        return driver;
    }

    /**
     * Driver identifies the DRA driver providing the capacity information. A field selector can be used to list only ResourceSlice objects with a certain driver name.<br><p> <br><p> Must be a DNS subdomain and should end with a DNS domain owned by the vendor of the driver. This field is immutable.
     */
    @JsonProperty("driver")
    public void setDriver(String driver) {
        this.driver = driver;
    }

    /**
     * NodeName identifies the node which provides the resources in this pool. A field selector can be used to list only ResourceSlice objects belonging to a certain node.<br><p> <br><p> This field can be used to limit access from nodes to ResourceSlices with the same node name. It also indicates to autoscalers that adding new nodes of the same type as some old node might also make new resources available.<br><p> <br><p> Exactly one of NodeName, NodeSelector, AllNodes, and PerDeviceNodeSelection must be set. This field is immutable.
     */
    @JsonProperty("nodeName")
    public String getNodeName() {
        return nodeName;
    }

    /**
     * NodeName identifies the node which provides the resources in this pool. A field selector can be used to list only ResourceSlice objects belonging to a certain node.<br><p> <br><p> This field can be used to limit access from nodes to ResourceSlices with the same node name. It also indicates to autoscalers that adding new nodes of the same type as some old node might also make new resources available.<br><p> <br><p> Exactly one of NodeName, NodeSelector, AllNodes, and PerDeviceNodeSelection must be set. This field is immutable.
     */
    @JsonProperty("nodeName")
    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    /**
     * ResourceSliceSpec contains the information published by the driver in one ResourceSlice.
     */
    @JsonProperty("nodeSelector")
    public NodeSelector getNodeSelector() {
        return nodeSelector;
    }

    /**
     * ResourceSliceSpec contains the information published by the driver in one ResourceSlice.
     */
    @JsonProperty("nodeSelector")
    public void setNodeSelector(NodeSelector nodeSelector) {
        this.nodeSelector = nodeSelector;
    }

    /**
     * PerDeviceNodeSelection defines whether the access from nodes to resources in the pool is set on the ResourceSlice level or on each device. If it is set to true, every device defined the ResourceSlice must specify this individually.<br><p> <br><p> Exactly one of NodeName, NodeSelector, AllNodes, and PerDeviceNodeSelection must be set.
     */
    @JsonProperty("perDeviceNodeSelection")
    public Boolean getPerDeviceNodeSelection() {
        return perDeviceNodeSelection;
    }

    /**
     * PerDeviceNodeSelection defines whether the access from nodes to resources in the pool is set on the ResourceSlice level or on each device. If it is set to true, every device defined the ResourceSlice must specify this individually.<br><p> <br><p> Exactly one of NodeName, NodeSelector, AllNodes, and PerDeviceNodeSelection must be set.
     */
    @JsonProperty("perDeviceNodeSelection")
    public void setPerDeviceNodeSelection(Boolean perDeviceNodeSelection) {
        this.perDeviceNodeSelection = perDeviceNodeSelection;
    }

    /**
     * ResourceSliceSpec contains the information published by the driver in one ResourceSlice.
     */
    @JsonProperty("pool")
    public ResourcePool getPool() {
        return pool;
    }

    /**
     * ResourceSliceSpec contains the information published by the driver in one ResourceSlice.
     */
    @JsonProperty("pool")
    public void setPool(ResourcePool pool) {
        this.pool = pool;
    }

    /**
     * SharedCounters defines a list of counter sets, each of which has a name and a list of counters available.<br><p> <br><p> The names of the SharedCounters must be unique in the ResourceSlice.<br><p> <br><p> The maximum number of counters in all sets is 32.
     */
    @JsonProperty("sharedCounters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<CounterSet> getSharedCounters() {
        return sharedCounters;
    }

    /**
     * SharedCounters defines a list of counter sets, each of which has a name and a list of counters available.<br><p> <br><p> The names of the SharedCounters must be unique in the ResourceSlice.<br><p> <br><p> The maximum number of counters in all sets is 32.
     */
    @JsonProperty("sharedCounters")
    public void setSharedCounters(List<CounterSet> sharedCounters) {
        this.sharedCounters = sharedCounters;
    }

    @JsonIgnore
    public ResourceSliceSpecBuilder edit() {
        return new ResourceSliceSpecBuilder(this);
    }

    @JsonIgnore
    public ResourceSliceSpecBuilder toBuilder() {
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
