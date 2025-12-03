
package io.fabric8.kubernetes.api.model.resource.v1beta2;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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

}
