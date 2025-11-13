
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
 * ResourceClaimStatus tracks whether the resource has been allocated and what the result of that was.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "allocation",
    "devices",
    "reservedFor"
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
public class ResourceClaimStatus implements Editable<ResourceClaimStatusBuilder>, KubernetesResource
{

    @JsonProperty("allocation")
    private AllocationResult allocation;
    @JsonProperty("devices")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AllocatedDeviceStatus> devices = new ArrayList<>();
    @JsonProperty("reservedFor")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ResourceClaimConsumerReference> reservedFor = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ResourceClaimStatus() {
    }

    public ResourceClaimStatus(AllocationResult allocation, List<AllocatedDeviceStatus> devices, List<ResourceClaimConsumerReference> reservedFor) {
        super();
        this.allocation = allocation;
        this.devices = devices;
        this.reservedFor = reservedFor;
    }

    /**
     * ResourceClaimStatus tracks whether the resource has been allocated and what the result of that was.
     */
    @JsonProperty("allocation")
    public AllocationResult getAllocation() {
        return allocation;
    }

    /**
     * ResourceClaimStatus tracks whether the resource has been allocated and what the result of that was.
     */
    @JsonProperty("allocation")
    public void setAllocation(AllocationResult allocation) {
        this.allocation = allocation;
    }

    /**
     * Devices contains the status of each device allocated for this claim, as reported by the driver. This can include driver-specific information. Entries are owned by their respective drivers.
     */
    @JsonProperty("devices")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AllocatedDeviceStatus> getDevices() {
        return devices;
    }

    /**
     * Devices contains the status of each device allocated for this claim, as reported by the driver. This can include driver-specific information. Entries are owned by their respective drivers.
     */
    @JsonProperty("devices")
    public void setDevices(List<AllocatedDeviceStatus> devices) {
        this.devices = devices;
    }

    /**
     * ReservedFor indicates which entities are currently allowed to use the claim. A Pod which references a ResourceClaim which is not reserved for that Pod will not be started. A claim that is in use or might be in use because it has been reserved must not get deallocated.<br><p> <br><p> In a cluster with multiple scheduler instances, two pods might get scheduled concurrently by different schedulers. When they reference the same ResourceClaim which already has reached its maximum number of consumers, only one pod can be scheduled.<br><p> <br><p> Both schedulers try to add their pod to the claim.status.reservedFor field, but only the update that reaches the API server first gets stored. The other one fails with an error and the scheduler which issued it knows that it must put the pod back into the queue, waiting for the ResourceClaim to become usable again.<br><p> <br><p> There can be at most 256 such reservations. This may get increased in the future, but not reduced.
     */
    @JsonProperty("reservedFor")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ResourceClaimConsumerReference> getReservedFor() {
        return reservedFor;
    }

    /**
     * ReservedFor indicates which entities are currently allowed to use the claim. A Pod which references a ResourceClaim which is not reserved for that Pod will not be started. A claim that is in use or might be in use because it has been reserved must not get deallocated.<br><p> <br><p> In a cluster with multiple scheduler instances, two pods might get scheduled concurrently by different schedulers. When they reference the same ResourceClaim which already has reached its maximum number of consumers, only one pod can be scheduled.<br><p> <br><p> Both schedulers try to add their pod to the claim.status.reservedFor field, but only the update that reaches the API server first gets stored. The other one fails with an error and the scheduler which issued it knows that it must put the pod back into the queue, waiting for the ResourceClaim to become usable again.<br><p> <br><p> There can be at most 256 such reservations. This may get increased in the future, but not reduced.
     */
    @JsonProperty("reservedFor")
    public void setReservedFor(List<ResourceClaimConsumerReference> reservedFor) {
        this.reservedFor = reservedFor;
    }

    @JsonIgnore
    public ResourceClaimStatusBuilder edit() {
        return new ResourceClaimStatusBuilder(this);
    }

    @JsonIgnore
    public ResourceClaimStatusBuilder toBuilder() {
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
