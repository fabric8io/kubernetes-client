
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
import io.fabric8.kubernetes.api.model.Condition;
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
 * MachineConfigNodeStatus holds the reported information on a particular machine config node.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditions",
    "configVersion",
    "irreconcilableChanges",
    "observedGeneration",
    "pinnedImageSets"
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
public class MachineConfigNodeStatus implements Editable<MachineConfigNodeStatusBuilder>, KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("configVersion")
    private MachineConfigNodeStatusMachineConfigVersion configVersion;
    @JsonProperty("irreconcilableChanges")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<IrreconcilableChangeDiff> irreconcilableChanges = new ArrayList<>();
    @JsonProperty("observedGeneration")
    private Long observedGeneration;
    @JsonProperty("pinnedImageSets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MachineConfigNodeStatusPinnedImageSet> pinnedImageSets = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachineConfigNodeStatus() {
    }

    public MachineConfigNodeStatus(List<Condition> conditions, MachineConfigNodeStatusMachineConfigVersion configVersion, List<IrreconcilableChangeDiff> irreconcilableChanges, Long observedGeneration, List<MachineConfigNodeStatusPinnedImageSet> pinnedImageSets) {
        super();
        this.conditions = conditions;
        this.configVersion = configVersion;
        this.irreconcilableChanges = irreconcilableChanges;
        this.observedGeneration = observedGeneration;
        this.pinnedImageSets = pinnedImageSets;
    }

    /**
     * conditions represent the observations of a machine config node's current state. Valid types are: UpdatePrepared, UpdateExecuted, UpdatePostActionComplete, UpdateComplete, Updated, Resumed, Drained, AppliedFilesAndOS, Cordoned, Uncordoned, RebootedNode, NodeDegraded, PinnedImageSetsProgressing, and PinnedImageSetsDegraded.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * conditions represent the observations of a machine config node's current state. Valid types are: UpdatePrepared, UpdateExecuted, UpdatePostActionComplete, UpdateComplete, Updated, Resumed, Drained, AppliedFilesAndOS, Cordoned, Uncordoned, RebootedNode, NodeDegraded, PinnedImageSetsProgressing, and PinnedImageSetsDegraded.
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * MachineConfigNodeStatus holds the reported information on a particular machine config node.
     */
    @JsonProperty("configVersion")
    public MachineConfigNodeStatusMachineConfigVersion getConfigVersion() {
        return configVersion;
    }

    /**
     * MachineConfigNodeStatus holds the reported information on a particular machine config node.
     */
    @JsonProperty("configVersion")
    public void setConfigVersion(MachineConfigNodeStatusMachineConfigVersion configVersion) {
        this.configVersion = configVersion;
    }

    /**
     * irreconcilableChanges is an optional field that contains the observed differences between this nodes configuration and the target rendered MachineConfig. This field will be set when there are changes to the target rendered MachineConfig that can only be applied to new nodes joining the cluster. Entries must be unique, keyed on the fieldPath field. Must not exceed 32 entries.
     */
    @JsonProperty("irreconcilableChanges")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<IrreconcilableChangeDiff> getIrreconcilableChanges() {
        return irreconcilableChanges;
    }

    /**
     * irreconcilableChanges is an optional field that contains the observed differences between this nodes configuration and the target rendered MachineConfig. This field will be set when there are changes to the target rendered MachineConfig that can only be applied to new nodes joining the cluster. Entries must be unique, keyed on the fieldPath field. Must not exceed 32 entries.
     */
    @JsonProperty("irreconcilableChanges")
    public void setIrreconcilableChanges(List<IrreconcilableChangeDiff> irreconcilableChanges) {
        this.irreconcilableChanges = irreconcilableChanges;
    }

    /**
     * observedGeneration represents the generation of the MachineConfigNode object observed by the Machine Config Operator's controller. This field is updated when the controller observes a change to the desiredConfig in the configVersion of the machine config node spec.
     */
    @JsonProperty("observedGeneration")
    public Long getObservedGeneration() {
        return observedGeneration;
    }

    /**
     * observedGeneration represents the generation of the MachineConfigNode object observed by the Machine Config Operator's controller. This field is updated when the controller observes a change to the desiredConfig in the configVersion of the machine config node spec.
     */
    @JsonProperty("observedGeneration")
    public void setObservedGeneration(Long observedGeneration) {
        this.observedGeneration = observedGeneration;
    }

    /**
     * pinnedImageSets describes the current and desired pinned image sets for this node.
     */
    @JsonProperty("pinnedImageSets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<MachineConfigNodeStatusPinnedImageSet> getPinnedImageSets() {
        return pinnedImageSets;
    }

    /**
     * pinnedImageSets describes the current and desired pinned image sets for this node.
     */
    @JsonProperty("pinnedImageSets")
    public void setPinnedImageSets(List<MachineConfigNodeStatusPinnedImageSet> pinnedImageSets) {
        this.pinnedImageSets = pinnedImageSets;
    }

    @JsonIgnore
    public MachineConfigNodeStatusBuilder edit() {
        return new MachineConfigNodeStatusBuilder(this);
    }

    @JsonIgnore
    public MachineConfigNodeStatusBuilder toBuilder() {
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
        if (!(o instanceof MachineConfigNodeStatus)) {
            return false;
        }
        MachineConfigNodeStatus other = (MachineConfigNodeStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$configVersion = this.getConfigVersion();
        Object other$configVersion = other.getConfigVersion();
        if (this$configVersion == null ? other$configVersion != null : !this$configVersion.equals(other$configVersion)) {
            return false;
        }
        Object this$irreconcilableChanges = this.getIrreconcilableChanges();
        Object other$irreconcilableChanges = other.getIrreconcilableChanges();
        if (this$irreconcilableChanges == null ? other$irreconcilableChanges != null : !this$irreconcilableChanges.equals(other$irreconcilableChanges)) {
            return false;
        }
        Object this$observedGeneration = this.getObservedGeneration();
        Object other$observedGeneration = other.getObservedGeneration();
        if (this$observedGeneration == null ? other$observedGeneration != null : !this$observedGeneration.equals(other$observedGeneration)) {
            return false;
        }
        Object this$pinnedImageSets = this.getPinnedImageSets();
        Object other$pinnedImageSets = other.getPinnedImageSets();
        if (this$pinnedImageSets == null ? other$pinnedImageSets != null : !this$pinnedImageSets.equals(other$pinnedImageSets)) {
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
        return other instanceof MachineConfigNodeStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $configVersion = this.getConfigVersion();
        result = result * prime + ($configVersion == null ? 43 : $configVersion.hashCode());
        Object $irreconcilableChanges = this.getIrreconcilableChanges();
        result = result * prime + ($irreconcilableChanges == null ? 43 : $irreconcilableChanges.hashCode());
        Object $observedGeneration = this.getObservedGeneration();
        result = result * prime + ($observedGeneration == null ? 43 : $observedGeneration.hashCode());
        Object $pinnedImageSets = this.getPinnedImageSets();
        result = result * prime + ($pinnedImageSets == null ? 43 : $pinnedImageSets.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "MachineConfigNodeStatus(" + "conditions=" + this.getConditions() + ", configVersion=" + this.getConfigVersion() + ", irreconcilableChanges=" + this.getIrreconcilableChanges() + ", observedGeneration=" + this.getObservedGeneration() + ", pinnedImageSets=" + this.getPinnedImageSets() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
