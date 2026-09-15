
package io.fabric8.openshift.api.model.hive.v1;

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

/**
 * MachinePoolStatus defines the observed state of MachinePool
 */
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
public class MachinePoolStatus implements Editable<MachinePoolStatusBuilder>, KubernetesResource
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

    /**
     * Conditions includes more detailed status for the cluster deployment
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<MachinePoolCondition> getConditions() {
        return conditions;
    }

    /**
     * Conditions includes more detailed status for the cluster deployment
     */
    @JsonProperty("conditions")
    public void setConditions(List<MachinePoolCondition> conditions) {
        this.conditions = conditions;
    }

    /**
     * ControlledByReplica indicates which replica of the hive-machinepool StatefulSet is responsible for this MachinePool. Note that this value indicates the replica that most recently handled the MachinePool. If the hive-machinepool statefulset is scaled up or down, the controlling replica can change, potentially causing logs to be spread across multiple pods.
     */
    @JsonProperty("controlledByReplica")
    public Long getControlledByReplica() {
        return controlledByReplica;
    }

    /**
     * ControlledByReplica indicates which replica of the hive-machinepool StatefulSet is responsible for this MachinePool. Note that this value indicates the replica that most recently handled the MachinePool. If the hive-machinepool statefulset is scaled up or down, the controlling replica can change, potentially causing logs to be spread across multiple pods.
     */
    @JsonProperty("controlledByReplica")
    public void setControlledByReplica(Long controlledByReplica) {
        this.controlledByReplica = controlledByReplica;
    }

    /**
     * MachineSets is the status of the machine sets for the machine pool on the remote cluster.
     */
    @JsonProperty("machineSets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<MachineSetStatus> getMachineSets() {
        return machineSets;
    }

    /**
     * MachineSets is the status of the machine sets for the machine pool on the remote cluster.
     */
    @JsonProperty("machineSets")
    public void setMachineSets(List<MachineSetStatus> machineSets) {
        this.machineSets = machineSets;
    }

    /**
     * OwnedLabels lists the keys of labels this MachinePool created on the remote MachineSet's MachineSpec. (In contrast with OwnedMachineLabels.) Used to identify labels to remove from the remote MachineSet when they are absent from the MachinePool's spec.labels.
     */
    @JsonProperty("ownedLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getOwnedLabels() {
        return ownedLabels;
    }

    /**
     * OwnedLabels lists the keys of labels this MachinePool created on the remote MachineSet's MachineSpec. (In contrast with OwnedMachineLabels.) Used to identify labels to remove from the remote MachineSet when they are absent from the MachinePool's spec.labels.
     */
    @JsonProperty("ownedLabels")
    public void setOwnedLabels(List<String> ownedLabels) {
        this.ownedLabels = ownedLabels;
    }

    /**
     * OwnedMachineLabels lists the keys of labels this MachinePool created on the remote MachineSet's MachineTemplateSpec. (In contrast with OwnedLabels.) Used to identify labels to remove from the remote MachineSet when they are absent from the MachinePool's spec.machineLabels.
     */
    @JsonProperty("ownedMachineLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getOwnedMachineLabels() {
        return ownedMachineLabels;
    }

    /**
     * OwnedMachineLabels lists the keys of labels this MachinePool created on the remote MachineSet's MachineTemplateSpec. (In contrast with OwnedLabels.) Used to identify labels to remove from the remote MachineSet when they are absent from the MachinePool's spec.machineLabels.
     */
    @JsonProperty("ownedMachineLabels")
    public void setOwnedMachineLabels(List<String> ownedMachineLabels) {
        this.ownedMachineLabels = ownedMachineLabels;
    }

    /**
     * OwnedTaints lists identifiers of taints this MachinePool created on the remote MachineSet. Used to identify taints to remove from the remote MachineSet when they are absent from the MachinePool's spec.taints.
     */
    @JsonProperty("ownedTaints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TaintIdentifier> getOwnedTaints() {
        return ownedTaints;
    }

    /**
     * OwnedTaints lists identifiers of taints this MachinePool created on the remote MachineSet. Used to identify taints to remove from the remote MachineSet when they are absent from the MachinePool's spec.taints.
     */
    @JsonProperty("ownedTaints")
    public void setOwnedTaints(List<TaintIdentifier> ownedTaints) {
        this.ownedTaints = ownedTaints;
    }

    /**
     * Replicas is the current number of replicas for the machine pool.
     */
    @JsonProperty("replicas")
    public Integer getReplicas() {
        return replicas;
    }

    /**
     * Replicas is the current number of replicas for the machine pool.
     */
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
        if (!(o instanceof MachinePoolStatus)) {
            return false;
        }
        MachinePoolStatus other = (MachinePoolStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$controlledByReplica = this.getControlledByReplica();
        Object other$controlledByReplica = other.getControlledByReplica();
        if (this$controlledByReplica == null ? other$controlledByReplica != null : !this$controlledByReplica.equals(other$controlledByReplica)) {
            return false;
        }
        Object this$machineSets = this.getMachineSets();
        Object other$machineSets = other.getMachineSets();
        if (this$machineSets == null ? other$machineSets != null : !this$machineSets.equals(other$machineSets)) {
            return false;
        }
        Object this$ownedLabels = this.getOwnedLabels();
        Object other$ownedLabels = other.getOwnedLabels();
        if (this$ownedLabels == null ? other$ownedLabels != null : !this$ownedLabels.equals(other$ownedLabels)) {
            return false;
        }
        Object this$ownedMachineLabels = this.getOwnedMachineLabels();
        Object other$ownedMachineLabels = other.getOwnedMachineLabels();
        if (this$ownedMachineLabels == null ? other$ownedMachineLabels != null : !this$ownedMachineLabels.equals(other$ownedMachineLabels)) {
            return false;
        }
        Object this$ownedTaints = this.getOwnedTaints();
        Object other$ownedTaints = other.getOwnedTaints();
        if (this$ownedTaints == null ? other$ownedTaints != null : !this$ownedTaints.equals(other$ownedTaints)) {
            return false;
        }
        Object this$replicas = this.getReplicas();
        Object other$replicas = other.getReplicas();
        if (this$replicas == null ? other$replicas != null : !this$replicas.equals(other$replicas)) {
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
        return other instanceof MachinePoolStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $controlledByReplica = this.getControlledByReplica();
        result = result * prime + ($controlledByReplica == null ? 43 : $controlledByReplica.hashCode());
        Object $machineSets = this.getMachineSets();
        result = result * prime + ($machineSets == null ? 43 : $machineSets.hashCode());
        Object $ownedLabels = this.getOwnedLabels();
        result = result * prime + ($ownedLabels == null ? 43 : $ownedLabels.hashCode());
        Object $ownedMachineLabels = this.getOwnedMachineLabels();
        result = result * prime + ($ownedMachineLabels == null ? 43 : $ownedMachineLabels.hashCode());
        Object $ownedTaints = this.getOwnedTaints();
        result = result * prime + ($ownedTaints == null ? 43 : $ownedTaints.hashCode());
        Object $replicas = this.getReplicas();
        result = result * prime + ($replicas == null ? 43 : $replicas.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "MachinePoolStatus(" + "conditions=" + this.getConditions() + ", controlledByReplica=" + this.getControlledByReplica() + ", machineSets=" + this.getMachineSets() + ", ownedLabels=" + this.getOwnedLabels() + ", ownedMachineLabels=" + this.getOwnedMachineLabels() + ", ownedTaints=" + this.getOwnedTaints() + ", replicas=" + this.getReplicas() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
