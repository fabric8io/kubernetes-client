
package io.fabric8.openshift.api.model.machineconfiguration.v1;

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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "availableMachineCount",
    "machineCount",
    "observedGeneration",
    "poolSynchronizerType",
    "readyMachineCount",
    "unavailableMachineCount",
    "updatedMachineCount"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class PoolSynchronizerStatus implements Editable<PoolSynchronizerStatusBuilder>, KubernetesResource
{

    @JsonProperty("availableMachineCount")
    private Long availableMachineCount;
    @JsonProperty("machineCount")
    private Long machineCount;
    @JsonProperty("observedGeneration")
    private Long observedGeneration;
    @JsonProperty("poolSynchronizerType")
    private String poolSynchronizerType;
    @JsonProperty("readyMachineCount")
    private Long readyMachineCount;
    @JsonProperty("unavailableMachineCount")
    private Long unavailableMachineCount;
    @JsonProperty("updatedMachineCount")
    private Long updatedMachineCount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PoolSynchronizerStatus() {
    }

    public PoolSynchronizerStatus(Long availableMachineCount, Long machineCount, Long observedGeneration, String poolSynchronizerType, Long readyMachineCount, Long unavailableMachineCount, Long updatedMachineCount) {
        super();
        this.availableMachineCount = availableMachineCount;
        this.machineCount = machineCount;
        this.observedGeneration = observedGeneration;
        this.poolSynchronizerType = poolSynchronizerType;
        this.readyMachineCount = readyMachineCount;
        this.unavailableMachineCount = unavailableMachineCount;
        this.updatedMachineCount = updatedMachineCount;
    }

    /**
     * availableMachineCount is the number of machines managed by the node synchronizer which are available.
     */
    @JsonProperty("availableMachineCount")
    public Long getAvailableMachineCount() {
        return availableMachineCount;
    }

    /**
     * availableMachineCount is the number of machines managed by the node synchronizer which are available.
     */
    @JsonProperty("availableMachineCount")
    public void setAvailableMachineCount(Long availableMachineCount) {
        this.availableMachineCount = availableMachineCount;
    }

    /**
     * machineCount is the number of machines that are managed by the node synchronizer.
     */
    @JsonProperty("machineCount")
    public Long getMachineCount() {
        return machineCount;
    }

    /**
     * machineCount is the number of machines that are managed by the node synchronizer.
     */
    @JsonProperty("machineCount")
    public void setMachineCount(Long machineCount) {
        this.machineCount = machineCount;
    }

    /**
     * observedGeneration is the last generation change that has been applied.
     */
    @JsonProperty("observedGeneration")
    public Long getObservedGeneration() {
        return observedGeneration;
    }

    /**
     * observedGeneration is the last generation change that has been applied.
     */
    @JsonProperty("observedGeneration")
    public void setObservedGeneration(Long observedGeneration) {
        this.observedGeneration = observedGeneration;
    }

    /**
     * poolSynchronizerType describes the type of the pool synchronizer.
     */
    @JsonProperty("poolSynchronizerType")
    public String getPoolSynchronizerType() {
        return poolSynchronizerType;
    }

    /**
     * poolSynchronizerType describes the type of the pool synchronizer.
     */
    @JsonProperty("poolSynchronizerType")
    public void setPoolSynchronizerType(String poolSynchronizerType) {
        this.poolSynchronizerType = poolSynchronizerType;
    }

    /**
     * readyMachineCount is the number of machines managed by the node synchronizer that are in a ready state.
     */
    @JsonProperty("readyMachineCount")
    public Long getReadyMachineCount() {
        return readyMachineCount;
    }

    /**
     * readyMachineCount is the number of machines managed by the node synchronizer that are in a ready state.
     */
    @JsonProperty("readyMachineCount")
    public void setReadyMachineCount(Long readyMachineCount) {
        this.readyMachineCount = readyMachineCount;
    }

    /**
     * unavailableMachineCount is the number of machines managed by the node synchronizer but are unavailable.
     */
    @JsonProperty("unavailableMachineCount")
    public Long getUnavailableMachineCount() {
        return unavailableMachineCount;
    }

    /**
     * unavailableMachineCount is the number of machines managed by the node synchronizer but are unavailable.
     */
    @JsonProperty("unavailableMachineCount")
    public void setUnavailableMachineCount(Long unavailableMachineCount) {
        this.unavailableMachineCount = unavailableMachineCount;
    }

    /**
     * updatedMachineCount is the number of machines that have been updated by the node synchronizer.
     */
    @JsonProperty("updatedMachineCount")
    public Long getUpdatedMachineCount() {
        return updatedMachineCount;
    }

    /**
     * updatedMachineCount is the number of machines that have been updated by the node synchronizer.
     */
    @JsonProperty("updatedMachineCount")
    public void setUpdatedMachineCount(Long updatedMachineCount) {
        this.updatedMachineCount = updatedMachineCount;
    }

    @JsonIgnore
    public PoolSynchronizerStatusBuilder edit() {
        return new PoolSynchronizerStatusBuilder(this);
    }

    @JsonIgnore
    public PoolSynchronizerStatusBuilder toBuilder() {
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
        if (!(o instanceof PoolSynchronizerStatus)) {
            return false;
        }
        PoolSynchronizerStatus other = (PoolSynchronizerStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$availableMachineCount = this.getAvailableMachineCount();
        Object other$availableMachineCount = other.getAvailableMachineCount();
        if (this$availableMachineCount == null ? other$availableMachineCount != null : !this$availableMachineCount.equals(other$availableMachineCount)) {
            return false;
        }
        Object this$machineCount = this.getMachineCount();
        Object other$machineCount = other.getMachineCount();
        if (this$machineCount == null ? other$machineCount != null : !this$machineCount.equals(other$machineCount)) {
            return false;
        }
        Object this$observedGeneration = this.getObservedGeneration();
        Object other$observedGeneration = other.getObservedGeneration();
        if (this$observedGeneration == null ? other$observedGeneration != null : !this$observedGeneration.equals(other$observedGeneration)) {
            return false;
        }
        Object this$poolSynchronizerType = this.getPoolSynchronizerType();
        Object other$poolSynchronizerType = other.getPoolSynchronizerType();
        if (this$poolSynchronizerType == null ? other$poolSynchronizerType != null : !this$poolSynchronizerType.equals(other$poolSynchronizerType)) {
            return false;
        }
        Object this$readyMachineCount = this.getReadyMachineCount();
        Object other$readyMachineCount = other.getReadyMachineCount();
        if (this$readyMachineCount == null ? other$readyMachineCount != null : !this$readyMachineCount.equals(other$readyMachineCount)) {
            return false;
        }
        Object this$unavailableMachineCount = this.getUnavailableMachineCount();
        Object other$unavailableMachineCount = other.getUnavailableMachineCount();
        if (this$unavailableMachineCount == null ? other$unavailableMachineCount != null : !this$unavailableMachineCount.equals(other$unavailableMachineCount)) {
            return false;
        }
        Object this$updatedMachineCount = this.getUpdatedMachineCount();
        Object other$updatedMachineCount = other.getUpdatedMachineCount();
        if (this$updatedMachineCount == null ? other$updatedMachineCount != null : !this$updatedMachineCount.equals(other$updatedMachineCount)) {
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
        return other instanceof PoolSynchronizerStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $availableMachineCount = this.getAvailableMachineCount();
        result = result * prime + ($availableMachineCount == null ? 43 : $availableMachineCount.hashCode());
        Object $machineCount = this.getMachineCount();
        result = result * prime + ($machineCount == null ? 43 : $machineCount.hashCode());
        Object $observedGeneration = this.getObservedGeneration();
        result = result * prime + ($observedGeneration == null ? 43 : $observedGeneration.hashCode());
        Object $poolSynchronizerType = this.getPoolSynchronizerType();
        result = result * prime + ($poolSynchronizerType == null ? 43 : $poolSynchronizerType.hashCode());
        Object $readyMachineCount = this.getReadyMachineCount();
        result = result * prime + ($readyMachineCount == null ? 43 : $readyMachineCount.hashCode());
        Object $unavailableMachineCount = this.getUnavailableMachineCount();
        result = result * prime + ($unavailableMachineCount == null ? 43 : $unavailableMachineCount.hashCode());
        Object $updatedMachineCount = this.getUpdatedMachineCount();
        result = result * prime + ($updatedMachineCount == null ? 43 : $updatedMachineCount.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PoolSynchronizerStatus(" + "availableMachineCount=" + this.getAvailableMachineCount() + ", machineCount=" + this.getMachineCount() + ", observedGeneration=" + this.getObservedGeneration() + ", poolSynchronizerType=" + this.getPoolSynchronizerType() + ", readyMachineCount=" + this.getReadyMachineCount() + ", unavailableMachineCount=" + this.getUnavailableMachineCount() + ", updatedMachineCount=" + this.getUpdatedMachineCount() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
