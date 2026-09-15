
package io.fabric8.kubernetes.api.model.policy.v1;

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
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * PodDisruptionBudgetStatus represents information about the status of a PodDisruptionBudget. Status may trail the actual state of a system.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditions",
    "currentHealthy",
    "desiredHealthy",
    "disruptedPods",
    "disruptionsAllowed",
    "expectedPods",
    "observedGeneration"
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
public class PodDisruptionBudgetStatus implements Editable<PodDisruptionBudgetStatusBuilder>, KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("currentHealthy")
    private Integer currentHealthy;
    @JsonProperty("desiredHealthy")
    private Integer desiredHealthy;
    @JsonProperty("disruptedPods")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> disruptedPods = new LinkedHashMap<>();
    @JsonProperty("disruptionsAllowed")
    private Integer disruptionsAllowed;
    @JsonProperty("expectedPods")
    private Integer expectedPods;
    @JsonProperty("observedGeneration")
    private Long observedGeneration;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PodDisruptionBudgetStatus() {
    }

    public PodDisruptionBudgetStatus(List<Condition> conditions, Integer currentHealthy, Integer desiredHealthy, Map<String, String> disruptedPods, Integer disruptionsAllowed, Integer expectedPods, Long observedGeneration) {
        super();
        this.conditions = conditions;
        this.currentHealthy = currentHealthy;
        this.desiredHealthy = desiredHealthy;
        this.disruptedPods = disruptedPods;
        this.disruptionsAllowed = disruptionsAllowed;
        this.expectedPods = expectedPods;
        this.observedGeneration = observedGeneration;
    }

    /**
     * Conditions contain conditions for PDB. The disruption controller sets the DisruptionAllowed condition. The following are known values for the reason field (additional reasons could be added in the future): - SyncFailed: The controller encountered an error and wasn't able to compute<br><p>               the number of allowed disruptions. Therefore no disruptions are<br><p>               allowed and the status of the condition will be False.<br><p> - InsufficientPods: The number of pods are either at or below the number<br><p>                     required by the PodDisruptionBudget. No disruptions are<br><p>                     allowed and the status of the condition will be False.<br><p> - SufficientPods: There are more pods than required by the PodDisruptionBudget.<br><p>                   The condition will be True, and the number of allowed<br><p>                   disruptions are provided by the disruptionsAllowed property.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * Conditions contain conditions for PDB. The disruption controller sets the DisruptionAllowed condition. The following are known values for the reason field (additional reasons could be added in the future): - SyncFailed: The controller encountered an error and wasn't able to compute<br><p>               the number of allowed disruptions. Therefore no disruptions are<br><p>               allowed and the status of the condition will be False.<br><p> - InsufficientPods: The number of pods are either at or below the number<br><p>                     required by the PodDisruptionBudget. No disruptions are<br><p>                     allowed and the status of the condition will be False.<br><p> - SufficientPods: There are more pods than required by the PodDisruptionBudget.<br><p>                   The condition will be True, and the number of allowed<br><p>                   disruptions are provided by the disruptionsAllowed property.
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * current number of healthy pods
     */
    @JsonProperty("currentHealthy")
    public Integer getCurrentHealthy() {
        return currentHealthy;
    }

    /**
     * current number of healthy pods
     */
    @JsonProperty("currentHealthy")
    public void setCurrentHealthy(Integer currentHealthy) {
        this.currentHealthy = currentHealthy;
    }

    /**
     * minimum desired number of healthy pods
     */
    @JsonProperty("desiredHealthy")
    public Integer getDesiredHealthy() {
        return desiredHealthy;
    }

    /**
     * minimum desired number of healthy pods
     */
    @JsonProperty("desiredHealthy")
    public void setDesiredHealthy(Integer desiredHealthy) {
        this.desiredHealthy = desiredHealthy;
    }

    /**
     * DisruptedPods contains information about pods whose eviction was processed by the API server eviction subresource handler but has not yet been observed by the PodDisruptionBudget controller. A pod will be in this map from the time when the API server processed the eviction request to the time when the pod is seen by PDB controller as having been marked for deletion (or after a timeout). The key in the map is the name of the pod and the value is the time when the API server processed the eviction request. If the deletion didn't occur and a pod is still there it will be removed from the list automatically by PodDisruptionBudget controller after some time. If everything goes smooth this map should be empty for the most of the time. Large number of entries in the map may indicate problems with pod deletions.
     */
    @JsonProperty("disruptedPods")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getDisruptedPods() {
        return disruptedPods;
    }

    /**
     * DisruptedPods contains information about pods whose eviction was processed by the API server eviction subresource handler but has not yet been observed by the PodDisruptionBudget controller. A pod will be in this map from the time when the API server processed the eviction request to the time when the pod is seen by PDB controller as having been marked for deletion (or after a timeout). The key in the map is the name of the pod and the value is the time when the API server processed the eviction request. If the deletion didn't occur and a pod is still there it will be removed from the list automatically by PodDisruptionBudget controller after some time. If everything goes smooth this map should be empty for the most of the time. Large number of entries in the map may indicate problems with pod deletions.
     */
    @JsonProperty("disruptedPods")
    public void setDisruptedPods(Map<String, String> disruptedPods) {
        this.disruptedPods = disruptedPods;
    }

    /**
     * Number of pod disruptions that are currently allowed.
     */
    @JsonProperty("disruptionsAllowed")
    public Integer getDisruptionsAllowed() {
        return disruptionsAllowed;
    }

    /**
     * Number of pod disruptions that are currently allowed.
     */
    @JsonProperty("disruptionsAllowed")
    public void setDisruptionsAllowed(Integer disruptionsAllowed) {
        this.disruptionsAllowed = disruptionsAllowed;
    }

    /**
     * total number of pods counted by this disruption budget
     */
    @JsonProperty("expectedPods")
    public Integer getExpectedPods() {
        return expectedPods;
    }

    /**
     * total number of pods counted by this disruption budget
     */
    @JsonProperty("expectedPods")
    public void setExpectedPods(Integer expectedPods) {
        this.expectedPods = expectedPods;
    }

    /**
     * Most recent generation observed when updating this PDB status. DisruptionsAllowed and other status information is valid only if observedGeneration equals to PDB's object generation.
     */
    @JsonProperty("observedGeneration")
    public Long getObservedGeneration() {
        return observedGeneration;
    }

    /**
     * Most recent generation observed when updating this PDB status. DisruptionsAllowed and other status information is valid only if observedGeneration equals to PDB's object generation.
     */
    @JsonProperty("observedGeneration")
    public void setObservedGeneration(Long observedGeneration) {
        this.observedGeneration = observedGeneration;
    }

    @JsonIgnore
    public PodDisruptionBudgetStatusBuilder edit() {
        return new PodDisruptionBudgetStatusBuilder(this);
    }

    @JsonIgnore
    public PodDisruptionBudgetStatusBuilder toBuilder() {
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
        if (!(o instanceof PodDisruptionBudgetStatus)) {
            return false;
        }
        PodDisruptionBudgetStatus other = (PodDisruptionBudgetStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$currentHealthy = this.getCurrentHealthy();
        Object other$currentHealthy = other.getCurrentHealthy();
        if (this$currentHealthy == null ? other$currentHealthy != null : !this$currentHealthy.equals(other$currentHealthy)) {
            return false;
        }
        Object this$desiredHealthy = this.getDesiredHealthy();
        Object other$desiredHealthy = other.getDesiredHealthy();
        if (this$desiredHealthy == null ? other$desiredHealthy != null : !this$desiredHealthy.equals(other$desiredHealthy)) {
            return false;
        }
        Object this$disruptedPods = this.getDisruptedPods();
        Object other$disruptedPods = other.getDisruptedPods();
        if (this$disruptedPods == null ? other$disruptedPods != null : !this$disruptedPods.equals(other$disruptedPods)) {
            return false;
        }
        Object this$disruptionsAllowed = this.getDisruptionsAllowed();
        Object other$disruptionsAllowed = other.getDisruptionsAllowed();
        if (this$disruptionsAllowed == null ? other$disruptionsAllowed != null : !this$disruptionsAllowed.equals(other$disruptionsAllowed)) {
            return false;
        }
        Object this$expectedPods = this.getExpectedPods();
        Object other$expectedPods = other.getExpectedPods();
        if (this$expectedPods == null ? other$expectedPods != null : !this$expectedPods.equals(other$expectedPods)) {
            return false;
        }
        Object this$observedGeneration = this.getObservedGeneration();
        Object other$observedGeneration = other.getObservedGeneration();
        if (this$observedGeneration == null ? other$observedGeneration != null : !this$observedGeneration.equals(other$observedGeneration)) {
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
        return other instanceof PodDisruptionBudgetStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $currentHealthy = this.getCurrentHealthy();
        result = result * prime + ($currentHealthy == null ? 43 : $currentHealthy.hashCode());
        Object $desiredHealthy = this.getDesiredHealthy();
        result = result * prime + ($desiredHealthy == null ? 43 : $desiredHealthy.hashCode());
        Object $disruptedPods = this.getDisruptedPods();
        result = result * prime + ($disruptedPods == null ? 43 : $disruptedPods.hashCode());
        Object $disruptionsAllowed = this.getDisruptionsAllowed();
        result = result * prime + ($disruptionsAllowed == null ? 43 : $disruptionsAllowed.hashCode());
        Object $expectedPods = this.getExpectedPods();
        result = result * prime + ($expectedPods == null ? 43 : $expectedPods.hashCode());
        Object $observedGeneration = this.getObservedGeneration();
        result = result * prime + ($observedGeneration == null ? 43 : $observedGeneration.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PodDisruptionBudgetStatus(" + "conditions=" + this.getConditions() + ", currentHealthy=" + this.getCurrentHealthy() + ", desiredHealthy=" + this.getDesiredHealthy() + ", disruptedPods=" + this.getDisruptedPods() + ", disruptionsAllowed=" + this.getDisruptionsAllowed() + ", expectedPods=" + this.getExpectedPods() + ", observedGeneration=" + this.getObservedGeneration() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
