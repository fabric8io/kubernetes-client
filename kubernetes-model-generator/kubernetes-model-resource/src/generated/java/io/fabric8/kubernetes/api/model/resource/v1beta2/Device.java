
package io.fabric8.kubernetes.api.model.resource.v1beta2;

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
 * Device represents one individual hardware instance that can be selected based on its attributes. Besides the name, exactly one field must be set.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "allNodes",
    "attributes",
    "capacity",
    "consumesCounters",
    "name",
    "nodeName",
    "nodeSelector",
    "taints"
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
public class Device implements Editable<DeviceBuilder>, KubernetesResource
{

    @JsonProperty("allNodes")
    private Boolean allNodes;
    @JsonProperty("attributes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, DeviceAttribute> attributes = new LinkedHashMap<>();
    @JsonProperty("capacity")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, DeviceCapacity> capacity = new LinkedHashMap<>();
    @JsonProperty("consumesCounters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DeviceCounterConsumption> consumesCounters = new ArrayList<>();
    @JsonProperty("name")
    private String name;
    @JsonProperty("nodeName")
    private String nodeName;
    @JsonProperty("nodeSelector")
    private NodeSelector nodeSelector;
    @JsonProperty("taints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DeviceTaint> taints = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Device() {
    }

    public Device(Boolean allNodes, Map<String, DeviceAttribute> attributes, Map<String, DeviceCapacity> capacity, List<DeviceCounterConsumption> consumesCounters, String name, String nodeName, NodeSelector nodeSelector, List<DeviceTaint> taints) {
        super();
        this.allNodes = allNodes;
        this.attributes = attributes;
        this.capacity = capacity;
        this.consumesCounters = consumesCounters;
        this.name = name;
        this.nodeName = nodeName;
        this.nodeSelector = nodeSelector;
        this.taints = taints;
    }

    /**
     * AllNodes indicates that all nodes have access to the device.<br><p> <br><p> Must only be set if Spec.PerDeviceNodeSelection is set to true. At most one of NodeName, NodeSelector and AllNodes can be set.
     */
    @JsonProperty("allNodes")
    public Boolean getAllNodes() {
        return allNodes;
    }

    /**
     * AllNodes indicates that all nodes have access to the device.<br><p> <br><p> Must only be set if Spec.PerDeviceNodeSelection is set to true. At most one of NodeName, NodeSelector and AllNodes can be set.
     */
    @JsonProperty("allNodes")
    public void setAllNodes(Boolean allNodes) {
        this.allNodes = allNodes;
    }

    /**
     * Attributes defines the set of attributes for this device. The name of each attribute must be unique in that set.<br><p> <br><p> The maximum number of attributes and capacities combined is 32.
     */
    @JsonProperty("attributes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, DeviceAttribute> getAttributes() {
        return attributes;
    }

    /**
     * Attributes defines the set of attributes for this device. The name of each attribute must be unique in that set.<br><p> <br><p> The maximum number of attributes and capacities combined is 32.
     */
    @JsonProperty("attributes")
    public void setAttributes(Map<String, DeviceAttribute> attributes) {
        this.attributes = attributes;
    }

    /**
     * Capacity defines the set of capacities for this device. The name of each capacity must be unique in that set.<br><p> <br><p> The maximum number of attributes and capacities combined is 32.
     */
    @JsonProperty("capacity")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, DeviceCapacity> getCapacity() {
        return capacity;
    }

    /**
     * Capacity defines the set of capacities for this device. The name of each capacity must be unique in that set.<br><p> <br><p> The maximum number of attributes and capacities combined is 32.
     */
    @JsonProperty("capacity")
    public void setCapacity(Map<String, DeviceCapacity> capacity) {
        this.capacity = capacity;
    }

    /**
     * ConsumesCounters defines a list of references to sharedCounters and the set of counters that the device will consume from those counter sets.<br><p> <br><p> There can only be a single entry per counterSet.<br><p> <br><p> The total number of device counter consumption entries must be &lt;= 32. In addition, the total number in the entire ResourceSlice must be &lt;= 1024 (for example, 64 devices with 16 counters each).
     */
    @JsonProperty("consumesCounters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DeviceCounterConsumption> getConsumesCounters() {
        return consumesCounters;
    }

    /**
     * ConsumesCounters defines a list of references to sharedCounters and the set of counters that the device will consume from those counter sets.<br><p> <br><p> There can only be a single entry per counterSet.<br><p> <br><p> The total number of device counter consumption entries must be &lt;= 32. In addition, the total number in the entire ResourceSlice must be &lt;= 1024 (for example, 64 devices with 16 counters each).
     */
    @JsonProperty("consumesCounters")
    public void setConsumesCounters(List<DeviceCounterConsumption> consumesCounters) {
        this.consumesCounters = consumesCounters;
    }

    /**
     * Name is unique identifier among all devices managed by the driver in the pool. It must be a DNS label.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name is unique identifier among all devices managed by the driver in the pool. It must be a DNS label.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * NodeName identifies the node where the device is available.<br><p> <br><p> Must only be set if Spec.PerDeviceNodeSelection is set to true. At most one of NodeName, NodeSelector and AllNodes can be set.
     */
    @JsonProperty("nodeName")
    public String getNodeName() {
        return nodeName;
    }

    /**
     * NodeName identifies the node where the device is available.<br><p> <br><p> Must only be set if Spec.PerDeviceNodeSelection is set to true. At most one of NodeName, NodeSelector and AllNodes can be set.
     */
    @JsonProperty("nodeName")
    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    /**
     * Device represents one individual hardware instance that can be selected based on its attributes. Besides the name, exactly one field must be set.
     */
    @JsonProperty("nodeSelector")
    public NodeSelector getNodeSelector() {
        return nodeSelector;
    }

    /**
     * Device represents one individual hardware instance that can be selected based on its attributes. Besides the name, exactly one field must be set.
     */
    @JsonProperty("nodeSelector")
    public void setNodeSelector(NodeSelector nodeSelector) {
        this.nodeSelector = nodeSelector;
    }

    /**
     * If specified, these are the driver-defined taints.<br><p> <br><p> The maximum number of taints is 4.<br><p> <br><p> This is an alpha field and requires enabling the DRADeviceTaints feature gate.
     */
    @JsonProperty("taints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DeviceTaint> getTaints() {
        return taints;
    }

    /**
     * If specified, these are the driver-defined taints.<br><p> <br><p> The maximum number of taints is 4.<br><p> <br><p> This is an alpha field and requires enabling the DRADeviceTaints feature gate.
     */
    @JsonProperty("taints")
    public void setTaints(List<DeviceTaint> taints) {
        this.taints = taints;
    }

    @JsonIgnore
    public DeviceBuilder edit() {
        return new DeviceBuilder(this);
    }

    @JsonIgnore
    public DeviceBuilder toBuilder() {
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
