
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
    "partitionTypeAttribute",
    "perDeviceNodeSelection",
    "pool",
    "sharedCounters",
    "skipNodeOperations"
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
    @JsonProperty("partitionTypeAttribute")
    private String partitionTypeAttribute;
    @JsonProperty("perDeviceNodeSelection")
    private Boolean perDeviceNodeSelection;
    @JsonProperty("pool")
    private ResourcePool pool;
    @JsonProperty("sharedCounters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<CounterSet> sharedCounters = new ArrayList<>();
    @JsonProperty("skipNodeOperations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> skipNodeOperations = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ResourceSliceSpec() {
    }

    public ResourceSliceSpec(Boolean allNodes, List<Device> devices, String driver, String nodeName, NodeSelector nodeSelector, String partitionTypeAttribute, Boolean perDeviceNodeSelection, ResourcePool pool, List<CounterSet> sharedCounters, List<String> skipNodeOperations) {
        super();
        this.allNodes = allNodes;
        this.devices = devices;
        this.driver = driver;
        this.nodeName = nodeName;
        this.nodeSelector = nodeSelector;
        this.partitionTypeAttribute = partitionTypeAttribute;
        this.perDeviceNodeSelection = perDeviceNodeSelection;
        this.pool = pool;
        this.sharedCounters = sharedCounters;
        this.skipNodeOperations = skipNodeOperations;
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
     * Devices lists some or all of the devices in this pool.<br><p> <br><p> Must not have more than 128 entries. If any device uses taints or consumes counters the limit is 64.<br><p> <br><p> Only one of Devices and SharedCounters can be set in a ResourceSlice.
     */
    @JsonProperty("devices")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Device> getDevices() {
        return devices;
    }

    /**
     * Devices lists some or all of the devices in this pool.<br><p> <br><p> Must not have more than 128 entries. If any device uses taints or consumes counters the limit is 64.<br><p> <br><p> Only one of Devices and SharedCounters can be set in a ResourceSlice.
     */
    @JsonProperty("devices")
    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    /**
     * Driver identifies the DRA driver providing the capacity information. A field selector can be used to list only ResourceSlice objects with a certain driver name.<br><p> <br><p> Must be a DNS subdomain and should end with a DNS domain owned by the vendor of the driver. It should use only lower case characters. This field is immutable.
     */
    @JsonProperty("driver")
    public String getDriver() {
        return driver;
    }

    /**
     * Driver identifies the DRA driver providing the capacity information. A field selector can be used to list only ResourceSlice objects with a certain driver name.<br><p> <br><p> Must be a DNS subdomain and should end with a DNS domain owned by the vendor of the driver. It should use only lower case characters. This field is immutable.
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
     * PartitionTypeAttribute names a string device attribute (by fully qualified name, e.g. "gpu.example.com/profile") whose value labels each device with its partition type, such as "Full" or "Half" for a MIG-style GPU.<br><p> <br><p> When set, every partitionable device in the slice must carry the attribute and devices sharing a value must share the same ConsumesCounters cost.
     */
    @JsonProperty("partitionTypeAttribute")
    public String getPartitionTypeAttribute() {
        return partitionTypeAttribute;
    }

    /**
     * PartitionTypeAttribute names a string device attribute (by fully qualified name, e.g. "gpu.example.com/profile") whose value labels each device with its partition type, such as "Full" or "Half" for a MIG-style GPU.<br><p> <br><p> When set, every partitionable device in the slice must carry the attribute and devices sharing a value must share the same ConsumesCounters cost.
     */
    @JsonProperty("partitionTypeAttribute")
    public void setPartitionTypeAttribute(String partitionTypeAttribute) {
        this.partitionTypeAttribute = partitionTypeAttribute;
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
     * SharedCounters defines a list of counter sets, each of which has a name and a list of counters available.<br><p> <br><p> The names of the counter sets must be unique in the ResourcePool.<br><p> <br><p> Only one of Devices and SharedCounters can be set in a ResourceSlice.<br><p> <br><p> The maximum number of counter sets is 8.
     */
    @JsonProperty("sharedCounters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<CounterSet> getSharedCounters() {
        return sharedCounters;
    }

    /**
     * SharedCounters defines a list of counter sets, each of which has a name and a list of counters available.<br><p> <br><p> The names of the counter sets must be unique in the ResourcePool.<br><p> <br><p> Only one of Devices and SharedCounters can be set in a ResourceSlice.<br><p> <br><p> The maximum number of counter sets is 8.
     */
    @JsonProperty("sharedCounters")
    public void setSharedCounters(List<CounterSet> sharedCounters) {
        this.sharedCounters = sharedCounters;
    }

    /**
     * SkipNodeOperations lists node-local resource operations (gRPC calls) that will be skipped for the devices in this slice when determining whether operations are necessary on the node. If all allocated devices for a driver in a claim skip an operation, that gRPC call will be skipped. Valid values are:<br><p> <br><p> - "NodePrepareResources": NodePrepareResources gRPC calls are skipped. This<br><p>   value cannot be specified unless "NodeUnprepareResources" is also listed<br><p>   (or "&#42;" is specified).<br><p> - "NodeUnprepareResources": NodeUnprepareResources gRPC calls are skipped. - "&#42;": All node-local resource operations are skipped.<br><p> <br><p> Other values may be added in the future. The kubelet must ignore unknown values.
     */
    @JsonProperty("skipNodeOperations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getSkipNodeOperations() {
        return skipNodeOperations;
    }

    /**
     * SkipNodeOperations lists node-local resource operations (gRPC calls) that will be skipped for the devices in this slice when determining whether operations are necessary on the node. If all allocated devices for a driver in a claim skip an operation, that gRPC call will be skipped. Valid values are:<br><p> <br><p> - "NodePrepareResources": NodePrepareResources gRPC calls are skipped. This<br><p>   value cannot be specified unless "NodeUnprepareResources" is also listed<br><p>   (or "&#42;" is specified).<br><p> - "NodeUnprepareResources": NodeUnprepareResources gRPC calls are skipped. - "&#42;": All node-local resource operations are skipped.<br><p> <br><p> Other values may be added in the future. The kubelet must ignore unknown values.
     */
    @JsonProperty("skipNodeOperations")
    public void setSkipNodeOperations(List<String> skipNodeOperations) {
        this.skipNodeOperations = skipNodeOperations;
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ResourceSliceSpec)) {
            return false;
        }
        ResourceSliceSpec other = (ResourceSliceSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$allNodes = this.getAllNodes();
        Object other$allNodes = other.getAllNodes();
        if (this$allNodes == null ? other$allNodes != null : !this$allNodes.equals(other$allNodes)) {
            return false;
        }
        Object this$devices = this.getDevices();
        Object other$devices = other.getDevices();
        if (this$devices == null ? other$devices != null : !this$devices.equals(other$devices)) {
            return false;
        }
        Object this$driver = this.getDriver();
        Object other$driver = other.getDriver();
        if (this$driver == null ? other$driver != null : !this$driver.equals(other$driver)) {
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
        Object this$partitionTypeAttribute = this.getPartitionTypeAttribute();
        Object other$partitionTypeAttribute = other.getPartitionTypeAttribute();
        if (this$partitionTypeAttribute == null ? other$partitionTypeAttribute != null : !this$partitionTypeAttribute.equals(other$partitionTypeAttribute)) {
            return false;
        }
        Object this$perDeviceNodeSelection = this.getPerDeviceNodeSelection();
        Object other$perDeviceNodeSelection = other.getPerDeviceNodeSelection();
        if (this$perDeviceNodeSelection == null ? other$perDeviceNodeSelection != null : !this$perDeviceNodeSelection.equals(other$perDeviceNodeSelection)) {
            return false;
        }
        Object this$pool = this.getPool();
        Object other$pool = other.getPool();
        if (this$pool == null ? other$pool != null : !this$pool.equals(other$pool)) {
            return false;
        }
        Object this$sharedCounters = this.getSharedCounters();
        Object other$sharedCounters = other.getSharedCounters();
        if (this$sharedCounters == null ? other$sharedCounters != null : !this$sharedCounters.equals(other$sharedCounters)) {
            return false;
        }
        Object this$skipNodeOperations = this.getSkipNodeOperations();
        Object other$skipNodeOperations = other.getSkipNodeOperations();
        if (this$skipNodeOperations == null ? other$skipNodeOperations != null : !this$skipNodeOperations.equals(other$skipNodeOperations)) {
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
        return other instanceof ResourceSliceSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $allNodes = this.getAllNodes();
        result = result * prime + ($allNodes == null ? 43 : $allNodes.hashCode());
        Object $devices = this.getDevices();
        result = result * prime + ($devices == null ? 43 : $devices.hashCode());
        Object $driver = this.getDriver();
        result = result * prime + ($driver == null ? 43 : $driver.hashCode());
        Object $nodeName = this.getNodeName();
        result = result * prime + ($nodeName == null ? 43 : $nodeName.hashCode());
        Object $nodeSelector = this.getNodeSelector();
        result = result * prime + ($nodeSelector == null ? 43 : $nodeSelector.hashCode());
        Object $partitionTypeAttribute = this.getPartitionTypeAttribute();
        result = result * prime + ($partitionTypeAttribute == null ? 43 : $partitionTypeAttribute.hashCode());
        Object $perDeviceNodeSelection = this.getPerDeviceNodeSelection();
        result = result * prime + ($perDeviceNodeSelection == null ? 43 : $perDeviceNodeSelection.hashCode());
        Object $pool = this.getPool();
        result = result * prime + ($pool == null ? 43 : $pool.hashCode());
        Object $sharedCounters = this.getSharedCounters();
        result = result * prime + ($sharedCounters == null ? 43 : $sharedCounters.hashCode());
        Object $skipNodeOperations = this.getSkipNodeOperations();
        result = result * prime + ($skipNodeOperations == null ? 43 : $skipNodeOperations.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ResourceSliceSpec(" + "allNodes=" + this.getAllNodes() + ", devices=" + this.getDevices() + ", driver=" + this.getDriver() + ", nodeName=" + this.getNodeName() + ", nodeSelector=" + this.getNodeSelector() + ", partitionTypeAttribute=" + this.getPartitionTypeAttribute() + ", perDeviceNodeSelection=" + this.getPerDeviceNodeSelection() + ", pool=" + this.getPool() + ", sharedCounters=" + this.getSharedCounters() + ", skipNodeOperations=" + this.getSkipNodeOperations() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
