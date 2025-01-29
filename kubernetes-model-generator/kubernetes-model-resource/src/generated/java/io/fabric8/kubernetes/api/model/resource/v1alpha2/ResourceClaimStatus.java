
package io.fabric8.kubernetes.api.model.resource.v1alpha2;

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
 * ResourceClaimStatus tracks whether the resource has been allocated and what the resulting attributes are.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "allocation",
    "deallocationRequested",
    "driverName",
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
    @JsonProperty("deallocationRequested")
    private Boolean deallocationRequested;
    @JsonProperty("driverName")
    private String driverName;
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

    public ResourceClaimStatus(AllocationResult allocation, Boolean deallocationRequested, String driverName, List<ResourceClaimConsumerReference> reservedFor) {
        super();
        this.allocation = allocation;
        this.deallocationRequested = deallocationRequested;
        this.driverName = driverName;
        this.reservedFor = reservedFor;
    }

    /**
     * ResourceClaimStatus tracks whether the resource has been allocated and what the resulting attributes are.
     */
    @JsonProperty("allocation")
    public AllocationResult getAllocation() {
        return allocation;
    }

    /**
     * ResourceClaimStatus tracks whether the resource has been allocated and what the resulting attributes are.
     */
    @JsonProperty("allocation")
    public void setAllocation(AllocationResult allocation) {
        this.allocation = allocation;
    }

    /**
     * DeallocationRequested indicates that a ResourceClaim is to be deallocated.<br><p> <br><p> The driver then must deallocate this claim and reset the field together with clearing the Allocation field.<br><p> <br><p> While DeallocationRequested is set, no new consumers may be added to ReservedFor.
     */
    @JsonProperty("deallocationRequested")
    public Boolean getDeallocationRequested() {
        return deallocationRequested;
    }

    /**
     * DeallocationRequested indicates that a ResourceClaim is to be deallocated.<br><p> <br><p> The driver then must deallocate this claim and reset the field together with clearing the Allocation field.<br><p> <br><p> While DeallocationRequested is set, no new consumers may be added to ReservedFor.
     */
    @JsonProperty("deallocationRequested")
    public void setDeallocationRequested(Boolean deallocationRequested) {
        this.deallocationRequested = deallocationRequested;
    }

    /**
     * DriverName is a copy of the driver name from the ResourceClass at the time when allocation started.
     */
    @JsonProperty("driverName")
    public String getDriverName() {
        return driverName;
    }

    /**
     * DriverName is a copy of the driver name from the ResourceClass at the time when allocation started.
     */
    @JsonProperty("driverName")
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    /**
     * ReservedFor indicates which entities are currently allowed to use the claim. A Pod which references a ResourceClaim which is not reserved for that Pod will not be started.<br><p> <br><p> There can be at most 32 such reservations. This may get increased in the future, but not reduced.
     */
    @JsonProperty("reservedFor")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ResourceClaimConsumerReference> getReservedFor() {
        return reservedFor;
    }

    /**
     * ReservedFor indicates which entities are currently allowed to use the claim. A Pod which references a ResourceClaim which is not reserved for that Pod will not be started.<br><p> <br><p> There can be at most 32 such reservations. This may get increased in the future, but not reduced.
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
