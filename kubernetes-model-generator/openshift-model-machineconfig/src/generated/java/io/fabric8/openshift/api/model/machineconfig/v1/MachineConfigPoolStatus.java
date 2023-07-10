
package io.fabric8.openshift.api.model.machineconfig.v1;

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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "conditions",
    "configuration",
    "degradedMachineCount",
    "machineCount",
    "observedGeneration",
    "readyMachineCount",
    "unavailableMachineCount",
    "updatedMachineCount"
})
@ToString
@EqualsAndHashCode
@Setter
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class MachineConfigPoolStatus implements KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MachineConfigPoolCondition> conditions = new ArrayList<MachineConfigPoolCondition>();
    @JsonProperty("configuration")
    private MachineConfigPoolStatusConfiguration configuration;
    @JsonProperty("degradedMachineCount")
    private Integer degradedMachineCount;
    @JsonProperty("machineCount")
    private Integer machineCount;
    @JsonProperty("observedGeneration")
    private Long observedGeneration;
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
     * 
     */
    public MachineConfigPoolStatus() {
    }

    public MachineConfigPoolStatus(List<MachineConfigPoolCondition> conditions, MachineConfigPoolStatusConfiguration configuration, Integer degradedMachineCount, Integer machineCount, Long observedGeneration, Integer readyMachineCount, Integer unavailableMachineCount, Integer updatedMachineCount) {
        super();
        this.conditions = conditions;
        this.configuration = configuration;
        this.degradedMachineCount = degradedMachineCount;
        this.machineCount = machineCount;
        this.observedGeneration = observedGeneration;
        this.readyMachineCount = readyMachineCount;
        this.unavailableMachineCount = unavailableMachineCount;
        this.updatedMachineCount = updatedMachineCount;
    }

    @JsonProperty("conditions")
    public List<MachineConfigPoolCondition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<MachineConfigPoolCondition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("configuration")
    public MachineConfigPoolStatusConfiguration getConfiguration() {
        return configuration;
    }

    @JsonProperty("configuration")
    public void setConfiguration(MachineConfigPoolStatusConfiguration configuration) {
        this.configuration = configuration;
    }

    @JsonProperty("degradedMachineCount")
    public Integer getDegradedMachineCount() {
        return degradedMachineCount;
    }

    @JsonProperty("degradedMachineCount")
    public void setDegradedMachineCount(Integer degradedMachineCount) {
        this.degradedMachineCount = degradedMachineCount;
    }

    @JsonProperty("machineCount")
    public Integer getMachineCount() {
        return machineCount;
    }

    @JsonProperty("machineCount")
    public void setMachineCount(Integer machineCount) {
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

    @JsonProperty("readyMachineCount")
    public Integer getReadyMachineCount() {
        return readyMachineCount;
    }

    @JsonProperty("readyMachineCount")
    public void setReadyMachineCount(Integer readyMachineCount) {
        this.readyMachineCount = readyMachineCount;
    }

    @JsonProperty("unavailableMachineCount")
    public Integer getUnavailableMachineCount() {
        return unavailableMachineCount;
    }

    @JsonProperty("unavailableMachineCount")
    public void setUnavailableMachineCount(Integer unavailableMachineCount) {
        this.unavailableMachineCount = unavailableMachineCount;
    }

    @JsonProperty("updatedMachineCount")
    public Integer getUpdatedMachineCount() {
        return updatedMachineCount;
    }

    @JsonProperty("updatedMachineCount")
    public void setUpdatedMachineCount(Integer updatedMachineCount) {
        this.updatedMachineCount = updatedMachineCount;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
