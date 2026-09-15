
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

/**
 * Device represents one individual hardware instance that can be selected based on its attributes. Besides the name, exactly one field must be set.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "allNodes",
    "allowMultipleAllocations",
    "attributes",
    "bindingConditions",
    "bindingFailureConditions",
    "bindsToNode",
    "capacity",
    "consumesCounters",
    "name",
    "nodeAllocatableResources",
    "nodeName",
    "nodeSelector",
    "taints"
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
    @JsonProperty("allowMultipleAllocations")
    private Boolean allowMultipleAllocations;
    @JsonProperty("attributes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, DeviceAttribute> attributes = new LinkedHashMap<>();
    @JsonProperty("bindingConditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> bindingConditions = new ArrayList<>();
    @JsonProperty("bindingFailureConditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> bindingFailureConditions = new ArrayList<>();
    @JsonProperty("bindsToNode")
    private Boolean bindsToNode;
    @JsonProperty("capacity")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, DeviceCapacity> capacity = new LinkedHashMap<>();
    @JsonProperty("consumesCounters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DeviceCounterConsumption> consumesCounters = new ArrayList<>();
    @JsonProperty("name")
    private String name;
    @JsonProperty("nodeAllocatableResources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, NodeAllocatableResource> nodeAllocatableResources = new LinkedHashMap<>();
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

    public Device(Boolean allNodes, Boolean allowMultipleAllocations, Map<String, DeviceAttribute> attributes, List<String> bindingConditions, List<String> bindingFailureConditions, Boolean bindsToNode, Map<String, DeviceCapacity> capacity, List<DeviceCounterConsumption> consumesCounters, String name, Map<String, NodeAllocatableResource> nodeAllocatableResources, String nodeName, NodeSelector nodeSelector, List<DeviceTaint> taints) {
        super();
        this.allNodes = allNodes;
        this.allowMultipleAllocations = allowMultipleAllocations;
        this.attributes = attributes;
        this.bindingConditions = bindingConditions;
        this.bindingFailureConditions = bindingFailureConditions;
        this.bindsToNode = bindsToNode;
        this.capacity = capacity;
        this.consumesCounters = consumesCounters;
        this.name = name;
        this.nodeAllocatableResources = nodeAllocatableResources;
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
     * AllowMultipleAllocations marks whether the device is allowed to be allocated to multiple DeviceRequests.<br><p> <br><p> If AllowMultipleAllocations is set to true, the device can be allocated more than once, and all of its capacity is consumable, regardless of whether the requestPolicy is defined or not.
     */
    @JsonProperty("allowMultipleAllocations")
    public Boolean getAllowMultipleAllocations() {
        return allowMultipleAllocations;
    }

    /**
     * AllowMultipleAllocations marks whether the device is allowed to be allocated to multiple DeviceRequests.<br><p> <br><p> If AllowMultipleAllocations is set to true, the device can be allocated more than once, and all of its capacity is consumable, regardless of whether the requestPolicy is defined or not.
     */
    @JsonProperty("allowMultipleAllocations")
    public void setAllowMultipleAllocations(Boolean allowMultipleAllocations) {
        this.allowMultipleAllocations = allowMultipleAllocations;
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
     * BindingConditions defines the conditions for proceeding with binding. All of these conditions must be set in the per-device status conditions with a value of True to proceed with binding the pod to the node while scheduling the pod.<br><p> <br><p> The maximum number of binding conditions is 4.<br><p> <br><p> The conditions must be a valid condition type string.<br><p> <br><p> This is a beta field and requires enabling the DRADeviceBindingConditions and DRAResourceClaimDeviceStatus feature gates.
     */
    @JsonProperty("bindingConditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getBindingConditions() {
        return bindingConditions;
    }

    /**
     * BindingConditions defines the conditions for proceeding with binding. All of these conditions must be set in the per-device status conditions with a value of True to proceed with binding the pod to the node while scheduling the pod.<br><p> <br><p> The maximum number of binding conditions is 4.<br><p> <br><p> The conditions must be a valid condition type string.<br><p> <br><p> This is a beta field and requires enabling the DRADeviceBindingConditions and DRAResourceClaimDeviceStatus feature gates.
     */
    @JsonProperty("bindingConditions")
    public void setBindingConditions(List<String> bindingConditions) {
        this.bindingConditions = bindingConditions;
    }

    /**
     * BindingFailureConditions defines the conditions for binding failure. They may be set in the per-device status conditions. If any is set to "True", a binding failure occurred.<br><p> <br><p> The maximum number of binding failure conditions is 4.<br><p> <br><p> The conditions must be a valid condition type string.<br><p> <br><p> This is a beta field and requires enabling the DRADeviceBindingConditions and DRAResourceClaimDeviceStatus feature gates.
     */
    @JsonProperty("bindingFailureConditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getBindingFailureConditions() {
        return bindingFailureConditions;
    }

    /**
     * BindingFailureConditions defines the conditions for binding failure. They may be set in the per-device status conditions. If any is set to "True", a binding failure occurred.<br><p> <br><p> The maximum number of binding failure conditions is 4.<br><p> <br><p> The conditions must be a valid condition type string.<br><p> <br><p> This is a beta field and requires enabling the DRADeviceBindingConditions and DRAResourceClaimDeviceStatus feature gates.
     */
    @JsonProperty("bindingFailureConditions")
    public void setBindingFailureConditions(List<String> bindingFailureConditions) {
        this.bindingFailureConditions = bindingFailureConditions;
    }

    /**
     * BindsToNode indicates if the usage of an allocation involving this device has to be limited to exactly the node that was chosen when allocating the claim. If set to true, the scheduler will set the ResourceClaim.Status.Allocation.NodeSelector to match the node where the allocation was made.<br><p> <br><p> This is a beta field and requires enabling the DRADeviceBindingConditions and DRAResourceClaimDeviceStatus feature gates.
     */
    @JsonProperty("bindsToNode")
    public Boolean getBindsToNode() {
        return bindsToNode;
    }

    /**
     * BindsToNode indicates if the usage of an allocation involving this device has to be limited to exactly the node that was chosen when allocating the claim. If set to true, the scheduler will set the ResourceClaim.Status.Allocation.NodeSelector to match the node where the allocation was made.<br><p> <br><p> This is a beta field and requires enabling the DRADeviceBindingConditions and DRAResourceClaimDeviceStatus feature gates.
     */
    @JsonProperty("bindsToNode")
    public void setBindsToNode(Boolean bindsToNode) {
        this.bindsToNode = bindsToNode;
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
     * ConsumesCounters defines a list of references to sharedCounters and the set of counters that the device will consume from those counter sets.<br><p> <br><p> There can only be a single entry per counterSet.<br><p> <br><p> The maximum number of device counter consumptions per device is 2.
     */
    @JsonProperty("consumesCounters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DeviceCounterConsumption> getConsumesCounters() {
        return consumesCounters;
    }

    /**
     * ConsumesCounters defines a list of references to sharedCounters and the set of counters that the device will consume from those counter sets.<br><p> <br><p> There can only be a single entry per counterSet.<br><p> <br><p> The maximum number of device counter consumptions per device is 2.
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
     * NodeAllocatableResources defines the mapping of node resources that are managed by the DRA driver exposing this device. This includes resources currently reported in v1.Node `status.allocatable` that are not extended resources (see https://kubernetes.io/docs/concepts/configuration/manage-resources-containers/#extended-resources). Examples include "cpu", "memory", "ephemeral-storage", and hugepages. In addition to standard requests made through the Pod `spec`, these resources can also be requested through claims and allocated by the DRA driver. For example, a CPU DRA driver might allocate exclusive CPUs or auxiliary node memory dependencies of an accelerator device. The keys of this map are the node-allocatable resource names (e.g., "cpu", "memory"). Extended resource names are not permitted as keys.
     */
    @JsonProperty("nodeAllocatableResources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, NodeAllocatableResource> getNodeAllocatableResources() {
        return nodeAllocatableResources;
    }

    /**
     * NodeAllocatableResources defines the mapping of node resources that are managed by the DRA driver exposing this device. This includes resources currently reported in v1.Node `status.allocatable` that are not extended resources (see https://kubernetes.io/docs/concepts/configuration/manage-resources-containers/#extended-resources). Examples include "cpu", "memory", "ephemeral-storage", and hugepages. In addition to standard requests made through the Pod `spec`, these resources can also be requested through claims and allocated by the DRA driver. For example, a CPU DRA driver might allocate exclusive CPUs or auxiliary node memory dependencies of an accelerator device. The keys of this map are the node-allocatable resource names (e.g., "cpu", "memory"). Extended resource names are not permitted as keys.
     */
    @JsonProperty("nodeAllocatableResources")
    public void setNodeAllocatableResources(Map<String, NodeAllocatableResource> nodeAllocatableResources) {
        this.nodeAllocatableResources = nodeAllocatableResources;
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
     * If specified, these are the driver-defined taints.<br><p> <br><p> The maximum number of taints is 16. If taints are set for any device in a ResourceSlice, then the maximum number of allowed devices per ResourceSlice is 64 instead of 128.<br><p> <br><p> This is a beta field and requires enabling the DRADeviceTaints feature gate.
     */
    @JsonProperty("taints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DeviceTaint> getTaints() {
        return taints;
    }

    /**
     * If specified, these are the driver-defined taints.<br><p> <br><p> The maximum number of taints is 16. If taints are set for any device in a ResourceSlice, then the maximum number of allowed devices per ResourceSlice is 64 instead of 128.<br><p> <br><p> This is a beta field and requires enabling the DRADeviceTaints feature gate.
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
        if (!(o instanceof Device)) {
            return false;
        }
        Device other = (Device) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$allNodes = this.getAllNodes();
        Object other$allNodes = other.getAllNodes();
        if (this$allNodes == null ? other$allNodes != null : !this$allNodes.equals(other$allNodes)) {
            return false;
        }
        Object this$allowMultipleAllocations = this.getAllowMultipleAllocations();
        Object other$allowMultipleAllocations = other.getAllowMultipleAllocations();
        if (this$allowMultipleAllocations == null ? other$allowMultipleAllocations != null : !this$allowMultipleAllocations.equals(other$allowMultipleAllocations)) {
            return false;
        }
        Object this$attributes = this.getAttributes();
        Object other$attributes = other.getAttributes();
        if (this$attributes == null ? other$attributes != null : !this$attributes.equals(other$attributes)) {
            return false;
        }
        Object this$bindingConditions = this.getBindingConditions();
        Object other$bindingConditions = other.getBindingConditions();
        if (this$bindingConditions == null ? other$bindingConditions != null : !this$bindingConditions.equals(other$bindingConditions)) {
            return false;
        }
        Object this$bindingFailureConditions = this.getBindingFailureConditions();
        Object other$bindingFailureConditions = other.getBindingFailureConditions();
        if (this$bindingFailureConditions == null ? other$bindingFailureConditions != null : !this$bindingFailureConditions.equals(other$bindingFailureConditions)) {
            return false;
        }
        Object this$bindsToNode = this.getBindsToNode();
        Object other$bindsToNode = other.getBindsToNode();
        if (this$bindsToNode == null ? other$bindsToNode != null : !this$bindsToNode.equals(other$bindsToNode)) {
            return false;
        }
        Object this$capacity = this.getCapacity();
        Object other$capacity = other.getCapacity();
        if (this$capacity == null ? other$capacity != null : !this$capacity.equals(other$capacity)) {
            return false;
        }
        Object this$consumesCounters = this.getConsumesCounters();
        Object other$consumesCounters = other.getConsumesCounters();
        if (this$consumesCounters == null ? other$consumesCounters != null : !this$consumesCounters.equals(other$consumesCounters)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$nodeAllocatableResources = this.getNodeAllocatableResources();
        Object other$nodeAllocatableResources = other.getNodeAllocatableResources();
        if (this$nodeAllocatableResources == null ? other$nodeAllocatableResources != null : !this$nodeAllocatableResources.equals(other$nodeAllocatableResources)) {
            return false;
        }
        Object this$nodeName = this.getNodeName();
        Object other$nodeName = other.getNodeName();
        if (this$nodeName == null ? other$nodeName != null : !this$nodeName.equals(other$nodeName)) {
            return false;
        }
        Object this$nodeSelector = this.getNodeSelector();
        Object other$nodeSelector = other.getNodeSelector();
        if (this$nodeSelector == null ? other$nodeSelector != null : !this$nodeSelector.equals(other$nodeSelector)) {
            return false;
        }
        Object this$taints = this.getTaints();
        Object other$taints = other.getTaints();
        if (this$taints == null ? other$taints != null : !this$taints.equals(other$taints)) {
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
        return other instanceof Device;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $allNodes = this.getAllNodes();
        result = result * prime + ($allNodes == null ? 43 : $allNodes.hashCode());
        Object $allowMultipleAllocations = this.getAllowMultipleAllocations();
        result = result * prime + ($allowMultipleAllocations == null ? 43 : $allowMultipleAllocations.hashCode());
        Object $attributes = this.getAttributes();
        result = result * prime + ($attributes == null ? 43 : $attributes.hashCode());
        Object $bindingConditions = this.getBindingConditions();
        result = result * prime + ($bindingConditions == null ? 43 : $bindingConditions.hashCode());
        Object $bindingFailureConditions = this.getBindingFailureConditions();
        result = result * prime + ($bindingFailureConditions == null ? 43 : $bindingFailureConditions.hashCode());
        Object $bindsToNode = this.getBindsToNode();
        result = result * prime + ($bindsToNode == null ? 43 : $bindsToNode.hashCode());
        Object $capacity = this.getCapacity();
        result = result * prime + ($capacity == null ? 43 : $capacity.hashCode());
        Object $consumesCounters = this.getConsumesCounters();
        result = result * prime + ($consumesCounters == null ? 43 : $consumesCounters.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $nodeAllocatableResources = this.getNodeAllocatableResources();
        result = result * prime + ($nodeAllocatableResources == null ? 43 : $nodeAllocatableResources.hashCode());
        Object $nodeName = this.getNodeName();
        result = result * prime + ($nodeName == null ? 43 : $nodeName.hashCode());
        Object $nodeSelector = this.getNodeSelector();
        result = result * prime + ($nodeSelector == null ? 43 : $nodeSelector.hashCode());
        Object $taints = this.getTaints();
        result = result * prime + ($taints == null ? 43 : $taints.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Device(" + "allNodes=" + this.getAllNodes() + ", allowMultipleAllocations=" + this.getAllowMultipleAllocations() + ", attributes=" + this.getAttributes() + ", bindingConditions=" + this.getBindingConditions() + ", bindingFailureConditions=" + this.getBindingFailureConditions() + ", bindsToNode=" + this.getBindsToNode() + ", capacity=" + this.getCapacity() + ", consumesCounters=" + this.getConsumesCounters() + ", name=" + this.getName() + ", nodeAllocatableResources=" + this.getNodeAllocatableResources() + ", nodeName=" + this.getNodeName() + ", nodeSelector=" + this.getNodeSelector() + ", taints=" + this.getTaints() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
