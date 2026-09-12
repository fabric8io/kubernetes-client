
package io.fabric8.kubernetes.api.model.resource.v1beta1;

import java.util.LinkedHashMap;
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
 * AllocationResult contains attributes of an allocated resource.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "allocationTimestamp",
    "devices",
    "nodeSelector"
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
public class AllocationResult implements Editable<AllocationResultBuilder>, KubernetesResource
{

    @JsonProperty("allocationTimestamp")
    private String allocationTimestamp;
    @JsonProperty("devices")
    private DeviceAllocationResult devices;
    @JsonProperty("nodeSelector")
    private NodeSelector nodeSelector;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AllocationResult() {
    }

    public AllocationResult(String allocationTimestamp, DeviceAllocationResult devices, NodeSelector nodeSelector) {
        super();
        this.allocationTimestamp = allocationTimestamp;
        this.devices = devices;
        this.nodeSelector = nodeSelector;
    }

    /**
     * AllocationResult contains attributes of an allocated resource.
     */
    @JsonProperty("allocationTimestamp")
    public String getAllocationTimestamp() {
        return allocationTimestamp;
    }

    /**
     * AllocationResult contains attributes of an allocated resource.
     */
    @JsonProperty("allocationTimestamp")
    public void setAllocationTimestamp(String allocationTimestamp) {
        this.allocationTimestamp = allocationTimestamp;
    }

    /**
     * AllocationResult contains attributes of an allocated resource.
     */
    @JsonProperty("devices")
    public DeviceAllocationResult getDevices() {
        return devices;
    }

    /**
     * AllocationResult contains attributes of an allocated resource.
     */
    @JsonProperty("devices")
    public void setDevices(DeviceAllocationResult devices) {
        this.devices = devices;
    }

    /**
     * AllocationResult contains attributes of an allocated resource.
     */
    @JsonProperty("nodeSelector")
    public NodeSelector getNodeSelector() {
        return nodeSelector;
    }

    /**
     * AllocationResult contains attributes of an allocated resource.
     */
    @JsonProperty("nodeSelector")
    public void setNodeSelector(NodeSelector nodeSelector) {
        this.nodeSelector = nodeSelector;
    }

    @JsonIgnore
    public AllocationResultBuilder edit() {
        return new AllocationResultBuilder(this);
    }

    @JsonIgnore
    public AllocationResultBuilder toBuilder() {
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
        if (!(o instanceof AllocationResult)) {
            return false;
        }
        AllocationResult other = (AllocationResult) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$allocationTimestamp = this.getAllocationTimestamp();
        Object other$allocationTimestamp = other.getAllocationTimestamp();
        if (this$allocationTimestamp == null ? other$allocationTimestamp != null : !this$allocationTimestamp.equals(other$allocationTimestamp)) {
            return false;
        }
        Object this$devices = this.getDevices();
        Object other$devices = other.getDevices();
        if (this$devices == null ? other$devices != null : !this$devices.equals(other$devices)) {
            return false;
        }
        Object this$nodeSelector = this.getNodeSelector();
        Object other$nodeSelector = other.getNodeSelector();
        if (this$nodeSelector == null ? other$nodeSelector != null : !this$nodeSelector.equals(other$nodeSelector)) {
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
        return other instanceof AllocationResult;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $allocationTimestamp = this.getAllocationTimestamp();
        result = result * prime + ($allocationTimestamp == null ? 43 : $allocationTimestamp.hashCode());
        Object $devices = this.getDevices();
        result = result * prime + ($devices == null ? 43 : $devices.hashCode());
        Object $nodeSelector = this.getNodeSelector();
        result = result * prime + ($nodeSelector == null ? 43 : $nodeSelector.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AllocationResult(" + "allocationTimestamp=" + this.getAllocationTimestamp() + ", devices=" + this.getDevices() + ", nodeSelector=" + this.getNodeSelector() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
