
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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

}
