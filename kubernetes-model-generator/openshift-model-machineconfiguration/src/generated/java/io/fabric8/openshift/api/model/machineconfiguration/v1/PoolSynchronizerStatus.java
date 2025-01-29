
package io.fabric8.openshift.api.model.machineconfiguration.v1;

import java.util.LinkedHashMap;
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

    @JsonProperty("availableMachineCount")
    public Long getAvailableMachineCount() {
        return availableMachineCount;
    }

    @JsonProperty("availableMachineCount")
    public void setAvailableMachineCount(Long availableMachineCount) {
        this.availableMachineCount = availableMachineCount;
    }

    @JsonProperty("machineCount")
    public Long getMachineCount() {
        return machineCount;
    }

    @JsonProperty("machineCount")
    public void setMachineCount(Long machineCount) {
        this.machineCount = machineCount;
    }

    @JsonProperty("observedGeneration")
    public Long getObservedGeneration() {
        return observedGeneration;
    }

    @JsonProperty("observedGeneration")
    public void setObservedGeneration(Long observedGeneration) {
        this.observedGeneration = observedGeneration;
    }

    @JsonProperty("poolSynchronizerType")
    public String getPoolSynchronizerType() {
        return poolSynchronizerType;
    }

    @JsonProperty("poolSynchronizerType")
    public void setPoolSynchronizerType(String poolSynchronizerType) {
        this.poolSynchronizerType = poolSynchronizerType;
    }

    @JsonProperty("readyMachineCount")
    public Long getReadyMachineCount() {
        return readyMachineCount;
    }

    @JsonProperty("readyMachineCount")
    public void setReadyMachineCount(Long readyMachineCount) {
        this.readyMachineCount = readyMachineCount;
    }

    @JsonProperty("unavailableMachineCount")
    public Long getUnavailableMachineCount() {
        return unavailableMachineCount;
    }

    @JsonProperty("unavailableMachineCount")
    public void setUnavailableMachineCount(Long unavailableMachineCount) {
        this.unavailableMachineCount = unavailableMachineCount;
    }

    @JsonProperty("updatedMachineCount")
    public Long getUpdatedMachineCount() {
        return updatedMachineCount;
    }

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
