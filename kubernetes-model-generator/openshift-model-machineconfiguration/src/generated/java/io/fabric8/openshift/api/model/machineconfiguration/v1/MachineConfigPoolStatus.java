
package io.fabric8.openshift.api.model.machineconfiguration.v1;

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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * MachineConfigPoolStatus is the status for MachineConfigPool resource.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "certExpirys",
    "conditions",
    "configuration",
    "degradedMachineCount",
    "machineCount",
    "observedGeneration",
    "poolSynchronizersStatus",
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
public class MachineConfigPoolStatus implements Editable<MachineConfigPoolStatusBuilder>, KubernetesResource
{

    @JsonProperty("certExpirys")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<CertExpiry> certExpirys = new ArrayList<>();
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MachineConfigPoolCondition> conditions = new ArrayList<>();
    @JsonProperty("configuration")
    private MachineConfigPoolStatusConfiguration configuration;
    @JsonProperty("degradedMachineCount")
    private Integer degradedMachineCount;
    @JsonProperty("machineCount")
    private Integer machineCount;
    @JsonProperty("observedGeneration")
    private Long observedGeneration;
    @JsonProperty("poolSynchronizersStatus")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PoolSynchronizerStatus> poolSynchronizersStatus = new ArrayList<>();
    @JsonProperty("readyMachineCount")
    private Integer readyMachineCount;
    @JsonProperty("unavailableMachineCount")
    private Integer unavailableMachineCount;
    @JsonProperty("updatedMachineCount")
    private Integer updatedMachineCount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachineConfigPoolStatus() {
    }

    public MachineConfigPoolStatus(List<CertExpiry> certExpirys, List<MachineConfigPoolCondition> conditions, MachineConfigPoolStatusConfiguration configuration, Integer degradedMachineCount, Integer machineCount, Long observedGeneration, List<PoolSynchronizerStatus> poolSynchronizersStatus, Integer readyMachineCount, Integer unavailableMachineCount, Integer updatedMachineCount) {
        super();
        this.certExpirys = certExpirys;
        this.conditions = conditions;
        this.configuration = configuration;
        this.degradedMachineCount = degradedMachineCount;
        this.machineCount = machineCount;
        this.observedGeneration = observedGeneration;
        this.poolSynchronizersStatus = poolSynchronizersStatus;
        this.readyMachineCount = readyMachineCount;
        this.unavailableMachineCount = unavailableMachineCount;
        this.updatedMachineCount = updatedMachineCount;
    }

    /**
     * certExpirys keeps track of important certificate expiration data
     */
    @JsonProperty("certExpirys")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<CertExpiry> getCertExpirys() {
        return certExpirys;
    }

    /**
     * certExpirys keeps track of important certificate expiration data
     */
    @JsonProperty("certExpirys")
    public void setCertExpirys(List<CertExpiry> certExpirys) {
        this.certExpirys = certExpirys;
    }

    /**
     * conditions represents the latest available observations of current state.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<MachineConfigPoolCondition> getConditions() {
        return conditions;
    }

    /**
     * conditions represents the latest available observations of current state.
     */
    @JsonProperty("conditions")
    public void setConditions(List<MachineConfigPoolCondition> conditions) {
        this.conditions = conditions;
    }

    /**
     * MachineConfigPoolStatus is the status for MachineConfigPool resource.
     */
    @JsonProperty("configuration")
    public MachineConfigPoolStatusConfiguration getConfiguration() {
        return configuration;
    }

    /**
     * MachineConfigPoolStatus is the status for MachineConfigPool resource.
     */
    @JsonProperty("configuration")
    public void setConfiguration(MachineConfigPoolStatusConfiguration configuration) {
        this.configuration = configuration;
    }

    /**
     * degradedMachineCount represents the total number of machines marked degraded (or unreconcilable). A node is marked degraded if applying a configuration failed..
     */
    @JsonProperty("degradedMachineCount")
    public Integer getDegradedMachineCount() {
        return degradedMachineCount;
    }

    /**
     * degradedMachineCount represents the total number of machines marked degraded (or unreconcilable). A node is marked degraded if applying a configuration failed..
     */
    @JsonProperty("degradedMachineCount")
    public void setDegradedMachineCount(Integer degradedMachineCount) {
        this.degradedMachineCount = degradedMachineCount;
    }

    /**
     * machineCount represents the total number of machines in the machine config pool.
     */
    @JsonProperty("machineCount")
    public Integer getMachineCount() {
        return machineCount;
    }

    /**
     * machineCount represents the total number of machines in the machine config pool.
     */
    @JsonProperty("machineCount")
    public void setMachineCount(Integer machineCount) {
        this.machineCount = machineCount;
    }

    /**
     * observedGeneration represents the generation observed by the controller.
     */
    @JsonProperty("observedGeneration")
    public Long getObservedGeneration() {
        return observedGeneration;
    }

    /**
     * observedGeneration represents the generation observed by the controller.
     */
    @JsonProperty("observedGeneration")
    public void setObservedGeneration(Long observedGeneration) {
        this.observedGeneration = observedGeneration;
    }

    /**
     * poolSynchronizersStatus is the status of the machines managed by the pool synchronizers.
     */
    @JsonProperty("poolSynchronizersStatus")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PoolSynchronizerStatus> getPoolSynchronizersStatus() {
        return poolSynchronizersStatus;
    }

    /**
     * poolSynchronizersStatus is the status of the machines managed by the pool synchronizers.
     */
    @JsonProperty("poolSynchronizersStatus")
    public void setPoolSynchronizersStatus(List<PoolSynchronizerStatus> poolSynchronizersStatus) {
        this.poolSynchronizersStatus = poolSynchronizersStatus;
    }

    /**
     * readyMachineCount represents the total number of ready machines targeted by the pool.
     */
    @JsonProperty("readyMachineCount")
    public Integer getReadyMachineCount() {
        return readyMachineCount;
    }

    /**
     * readyMachineCount represents the total number of ready machines targeted by the pool.
     */
    @JsonProperty("readyMachineCount")
    public void setReadyMachineCount(Integer readyMachineCount) {
        this.readyMachineCount = readyMachineCount;
    }

    /**
     * unavailableMachineCount represents the total number of unavailable (non-ready) machines targeted by the pool. A node is marked unavailable if it is in updating state or NodeReady condition is false.
     */
    @JsonProperty("unavailableMachineCount")
    public Integer getUnavailableMachineCount() {
        return unavailableMachineCount;
    }

    /**
     * unavailableMachineCount represents the total number of unavailable (non-ready) machines targeted by the pool. A node is marked unavailable if it is in updating state or NodeReady condition is false.
     */
    @JsonProperty("unavailableMachineCount")
    public void setUnavailableMachineCount(Integer unavailableMachineCount) {
        this.unavailableMachineCount = unavailableMachineCount;
    }

    /**
     * updatedMachineCount represents the total number of machines targeted by the pool that have the CurrentMachineConfig as their config.
     */
    @JsonProperty("updatedMachineCount")
    public Integer getUpdatedMachineCount() {
        return updatedMachineCount;
    }

    /**
     * updatedMachineCount represents the total number of machines targeted by the pool that have the CurrentMachineConfig as their config.
     */
    @JsonProperty("updatedMachineCount")
    public void setUpdatedMachineCount(Integer updatedMachineCount) {
        this.updatedMachineCount = updatedMachineCount;
    }

    @JsonIgnore
    public MachineConfigPoolStatusBuilder edit() {
        return new MachineConfigPoolStatusBuilder(this);
    }

    @JsonIgnore
    public MachineConfigPoolStatusBuilder toBuilder() {
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
        if (!(o instanceof MachineConfigPoolStatus)) {
            return false;
        }
        MachineConfigPoolStatus other = (MachineConfigPoolStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$certExpirys = this.getCertExpirys();
        Object other$certExpirys = other.getCertExpirys();
        if (this$certExpirys == null ? other$certExpirys != null : !this$certExpirys.equals(other$certExpirys)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$configuration = this.getConfiguration();
        Object other$configuration = other.getConfiguration();
        if (this$configuration == null ? other$configuration != null : !this$configuration.equals(other$configuration)) {
            return false;
        }
        Object this$degradedMachineCount = this.getDegradedMachineCount();
        Object other$degradedMachineCount = other.getDegradedMachineCount();
        if (this$degradedMachineCount == null ? other$degradedMachineCount != null : !this$degradedMachineCount.equals(other$degradedMachineCount)) {
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
        Object this$poolSynchronizersStatus = this.getPoolSynchronizersStatus();
        Object other$poolSynchronizersStatus = other.getPoolSynchronizersStatus();
        if (this$poolSynchronizersStatus == null ? other$poolSynchronizersStatus != null : !this$poolSynchronizersStatus.equals(other$poolSynchronizersStatus)) {
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
        return other instanceof MachineConfigPoolStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $certExpirys = this.getCertExpirys();
        result = result * prime + ($certExpirys == null ? 43 : $certExpirys.hashCode());
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $configuration = this.getConfiguration();
        result = result * prime + ($configuration == null ? 43 : $configuration.hashCode());
        Object $degradedMachineCount = this.getDegradedMachineCount();
        result = result * prime + ($degradedMachineCount == null ? 43 : $degradedMachineCount.hashCode());
        Object $machineCount = this.getMachineCount();
        result = result * prime + ($machineCount == null ? 43 : $machineCount.hashCode());
        Object $observedGeneration = this.getObservedGeneration();
        result = result * prime + ($observedGeneration == null ? 43 : $observedGeneration.hashCode());
        Object $poolSynchronizersStatus = this.getPoolSynchronizersStatus();
        result = result * prime + ($poolSynchronizersStatus == null ? 43 : $poolSynchronizersStatus.hashCode());
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
        return "MachineConfigPoolStatus(" + "certExpirys=" + this.getCertExpirys() + ", conditions=" + this.getConditions() + ", configuration=" + this.getConfiguration() + ", degradedMachineCount=" + this.getDegradedMachineCount() + ", machineCount=" + this.getMachineCount() + ", observedGeneration=" + this.getObservedGeneration() + ", poolSynchronizersStatus=" + this.getPoolSynchronizersStatus() + ", readyMachineCount=" + this.getReadyMachineCount() + ", unavailableMachineCount=" + this.getUnavailableMachineCount() + ", updatedMachineCount=" + this.getUpdatedMachineCount() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
