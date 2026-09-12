
package io.fabric8.kubernetes.api.model.resource.v1;

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
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * NodeAllocatableMapping defines how a DRA allocation directly translates into a node allocatable resource quantity. The mapping can be derived from either the count of allocated devices (via deviceMultiplier) or the specific capacity consumed (via capacityKey and capacityMultiplier). These options are mutually exclusive. Kubelet adds this mapped resource quantity from claim to both requests and limits at the pod-level cgroup, and to limits at the container-level cgroup for each container referencing the claim.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "capacityKey",
    "capacityMultiplier",
    "deviceMultiplier"
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
public class NodeAllocatableMapping implements Editable<NodeAllocatableMappingBuilder>, KubernetesResource
{

    @JsonProperty("capacityKey")
    private String capacityKey;
    @JsonProperty("capacityMultiplier")
    private Quantity capacityMultiplier;
    @JsonProperty("deviceMultiplier")
    private Quantity deviceMultiplier;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NodeAllocatableMapping() {
    }

    public NodeAllocatableMapping(String capacityKey, Quantity capacityMultiplier, Quantity deviceMultiplier) {
        super();
        this.capacityKey = capacityKey;
        this.capacityMultiplier = capacityMultiplier;
        this.deviceMultiplier = deviceMultiplier;
    }

    /**
     * CapacityKey references a capacity name defined as a key in the `spec.devices[&#42;].capacity` map. When this field is set, the value associated with this key in the `status.allocation.devices.results[&#42;].consumedCapacity` map (for a specific claim allocation) determines the base quantity for the node allocatable resource. `capacityMultiplier` must also be set and is multiplied with the base quantity. For example, if `spec.devices[&#42;].capacity` has an entry "dra.example.com/memory": "128Gi", and this field is set to "dra.example.com/memory", then for a claim allocation that consumes { "dra.example.com/memory": "4Gi" } the base quantity for the node allocatable resource mapping will be "4Gi". The final node allocatable resource amount is `consumedCapacity[capacityKey]` &#42; `capacityMultiplier`.
     */
    @JsonProperty("capacityKey")
    public String getCapacityKey() {
        return capacityKey;
    }

    /**
     * CapacityKey references a capacity name defined as a key in the `spec.devices[&#42;].capacity` map. When this field is set, the value associated with this key in the `status.allocation.devices.results[&#42;].consumedCapacity` map (for a specific claim allocation) determines the base quantity for the node allocatable resource. `capacityMultiplier` must also be set and is multiplied with the base quantity. For example, if `spec.devices[&#42;].capacity` has an entry "dra.example.com/memory": "128Gi", and this field is set to "dra.example.com/memory", then for a claim allocation that consumes { "dra.example.com/memory": "4Gi" } the base quantity for the node allocatable resource mapping will be "4Gi". The final node allocatable resource amount is `consumedCapacity[capacityKey]` &#42; `capacityMultiplier`.
     */
    @JsonProperty("capacityKey")
    public void setCapacityKey(String capacityKey) {
        this.capacityKey = capacityKey;
    }

    /**
     * NodeAllocatableMapping defines how a DRA allocation directly translates into a node allocatable resource quantity. The mapping can be derived from either the count of allocated devices (via deviceMultiplier) or the specific capacity consumed (via capacityKey and capacityMultiplier). These options are mutually exclusive. Kubelet adds this mapped resource quantity from claim to both requests and limits at the pod-level cgroup, and to limits at the container-level cgroup for each container referencing the claim.
     */
    @JsonProperty("capacityMultiplier")
    public Quantity getCapacityMultiplier() {
        return capacityMultiplier;
    }

    /**
     * NodeAllocatableMapping defines how a DRA allocation directly translates into a node allocatable resource quantity. The mapping can be derived from either the count of allocated devices (via deviceMultiplier) or the specific capacity consumed (via capacityKey and capacityMultiplier). These options are mutually exclusive. Kubelet adds this mapped resource quantity from claim to both requests and limits at the pod-level cgroup, and to limits at the container-level cgroup for each container referencing the claim.
     */
    @JsonProperty("capacityMultiplier")
    public void setCapacityMultiplier(Quantity capacityMultiplier) {
        this.capacityMultiplier = capacityMultiplier;
    }

    /**
     * NodeAllocatableMapping defines how a DRA allocation directly translates into a node allocatable resource quantity. The mapping can be derived from either the count of allocated devices (via deviceMultiplier) or the specific capacity consumed (via capacityKey and capacityMultiplier). These options are mutually exclusive. Kubelet adds this mapped resource quantity from claim to both requests and limits at the pod-level cgroup, and to limits at the container-level cgroup for each container referencing the claim.
     */
    @JsonProperty("deviceMultiplier")
    public Quantity getDeviceMultiplier() {
        return deviceMultiplier;
    }

    /**
     * NodeAllocatableMapping defines how a DRA allocation directly translates into a node allocatable resource quantity. The mapping can be derived from either the count of allocated devices (via deviceMultiplier) or the specific capacity consumed (via capacityKey and capacityMultiplier). These options are mutually exclusive. Kubelet adds this mapped resource quantity from claim to both requests and limits at the pod-level cgroup, and to limits at the container-level cgroup for each container referencing the claim.
     */
    @JsonProperty("deviceMultiplier")
    public void setDeviceMultiplier(Quantity deviceMultiplier) {
        this.deviceMultiplier = deviceMultiplier;
    }

    @JsonIgnore
    public NodeAllocatableMappingBuilder edit() {
        return new NodeAllocatableMappingBuilder(this);
    }

    @JsonIgnore
    public NodeAllocatableMappingBuilder toBuilder() {
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
        if (!(o instanceof NodeAllocatableMapping)) {
            return false;
        }
        NodeAllocatableMapping other = (NodeAllocatableMapping) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$capacityKey = this.getCapacityKey();
        Object other$capacityKey = other.getCapacityKey();
        if (this$capacityKey == null ? other$capacityKey != null : !this$capacityKey.equals(other$capacityKey)) {
            return false;
        }
        Object this$capacityMultiplier = this.getCapacityMultiplier();
        Object other$capacityMultiplier = other.getCapacityMultiplier();
        if (this$capacityMultiplier == null ? other$capacityMultiplier != null : !this$capacityMultiplier.equals(other$capacityMultiplier)) {
            return false;
        }
        Object this$deviceMultiplier = this.getDeviceMultiplier();
        Object other$deviceMultiplier = other.getDeviceMultiplier();
        if (this$deviceMultiplier == null ? other$deviceMultiplier != null : !this$deviceMultiplier.equals(other$deviceMultiplier)) {
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
        return other instanceof NodeAllocatableMapping;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $capacityKey = this.getCapacityKey();
        result = result * prime + ($capacityKey == null ? 43 : $capacityKey.hashCode());
        Object $capacityMultiplier = this.getCapacityMultiplier();
        result = result * prime + ($capacityMultiplier == null ? 43 : $capacityMultiplier.hashCode());
        Object $deviceMultiplier = this.getDeviceMultiplier();
        result = result * prime + ($deviceMultiplier == null ? 43 : $deviceMultiplier.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NodeAllocatableMapping(" + "capacityKey=" + this.getCapacityKey() + ", capacityMultiplier=" + this.getCapacityMultiplier() + ", deviceMultiplier=" + this.getDeviceMultiplier() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
