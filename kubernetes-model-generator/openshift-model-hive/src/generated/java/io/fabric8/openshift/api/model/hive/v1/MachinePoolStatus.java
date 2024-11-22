
package io.fabric8.openshift.api.model.hive.v1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditions",
    "controlledByReplica",
    "machineSets",
    "ownedLabels",
    "ownedMachineLabels",
    "ownedTaints",
    "replicas"
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
public class MachinePoolStatus implements Editable<MachinePoolStatusBuilder> , KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MachinePoolCondition> conditions = new ArrayList<>();
    @JsonProperty("controlledByReplica")
    private Long controlledByReplica;
    @JsonProperty("machineSets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MachineSetStatus> machineSets = new ArrayList<>();
    @JsonProperty("ownedLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> ownedLabels = new ArrayList<>();
    @JsonProperty("ownedMachineLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> ownedMachineLabels = new ArrayList<>();
    @JsonProperty("ownedTaints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TaintIdentifier> ownedTaints = new ArrayList<>();
    @JsonProperty("replicas")
    private Integer replicas;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public MachinePoolStatus() {
    }

    public MachinePoolStatus(List<MachinePoolCondition> conditions, Long controlledByReplica, List<MachineSetStatus> machineSets, List<String> ownedLabels, List<String> ownedMachineLabels, List<TaintIdentifier> ownedTaints, Integer replicas) {
        super();
        this.conditions = conditions;
        this.controlledByReplica = controlledByReplica;
        this.machineSets = machineSets;
        this.ownedLabels = ownedLabels;
        this.ownedMachineLabels = ownedMachineLabels;
        this.ownedTaints = ownedTaints;
        this.replicas = replicas;
    }

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<MachinePoolCondition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<MachinePoolCondition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("controlledByReplica")
    public Long getControlledByReplica() {
        return controlledByReplica;
    }

    @JsonProperty("controlledByReplica")
    public void setControlledByReplica(Long controlledByReplica) {
        this.controlledByReplica = controlledByReplica;
    }

    @JsonProperty("machineSets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<MachineSetStatus> getMachineSets() {
        return machineSets;
    }

    @JsonProperty("machineSets")
    public void setMachineSets(List<MachineSetStatus> machineSets) {
        this.machineSets = machineSets;
    }

    @JsonProperty("ownedLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getOwnedLabels() {
        return ownedLabels;
    }

    @JsonProperty("ownedLabels")
    public void setOwnedLabels(List<String> ownedLabels) {
        this.ownedLabels = ownedLabels;
    }

    @JsonProperty("ownedMachineLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getOwnedMachineLabels() {
        return ownedMachineLabels;
    }

    @JsonProperty("ownedMachineLabels")
    public void setOwnedMachineLabels(List<String> ownedMachineLabels) {
        this.ownedMachineLabels = ownedMachineLabels;
    }

    @JsonProperty("ownedTaints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TaintIdentifier> getOwnedTaints() {
        return ownedTaints;
    }

    @JsonProperty("ownedTaints")
    public void setOwnedTaints(List<TaintIdentifier> ownedTaints) {
        this.ownedTaints = ownedTaints;
    }

    @JsonProperty("replicas")
    public Integer getReplicas() {
        return replicas;
    }

    @JsonProperty("replicas")
    public void setReplicas(Integer replicas) {
        this.replicas = replicas;
    }

    @JsonIgnore
    public MachinePoolStatusBuilder edit() {
        return new MachinePoolStatusBuilder(this);
    }

    @JsonIgnore
    public MachinePoolStatusBuilder toBuilder() {
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
