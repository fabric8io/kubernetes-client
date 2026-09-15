
package io.fabric8.kubernetes.api.model.apps;

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
 * DeploymentStatus is the most recently observed status of the Deployment.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "availableReplicas",
    "collisionCount",
    "conditions",
    "observedGeneration",
    "readyReplicas",
    "replicas",
    "terminatingReplicas",
    "unavailableReplicas",
    "updatedReplicas"
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
public class DeploymentStatus implements Editable<DeploymentStatusBuilder>, KubernetesResource
{

    @JsonProperty("availableReplicas")
    private Integer availableReplicas;
    @JsonProperty("collisionCount")
    private Integer collisionCount;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DeploymentCondition> conditions = new ArrayList<>();
    @JsonProperty("observedGeneration")
    private Long observedGeneration;
    @JsonProperty("readyReplicas")
    private Integer readyReplicas;
    @JsonProperty("replicas")
    private Integer replicas;
    @JsonProperty("terminatingReplicas")
    private Integer terminatingReplicas;
    @JsonProperty("unavailableReplicas")
    private Integer unavailableReplicas;
    @JsonProperty("updatedReplicas")
    private Integer updatedReplicas;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DeploymentStatus() {
    }

    public DeploymentStatus(Integer availableReplicas, Integer collisionCount, List<DeploymentCondition> conditions, Long observedGeneration, Integer readyReplicas, Integer replicas, Integer terminatingReplicas, Integer unavailableReplicas, Integer updatedReplicas) {
        super();
        this.availableReplicas = availableReplicas;
        this.collisionCount = collisionCount;
        this.conditions = conditions;
        this.observedGeneration = observedGeneration;
        this.readyReplicas = readyReplicas;
        this.replicas = replicas;
        this.terminatingReplicas = terminatingReplicas;
        this.unavailableReplicas = unavailableReplicas;
        this.updatedReplicas = updatedReplicas;
    }

    /**
     * Total number of available non-terminating pods (ready for at least minReadySeconds) targeted by this deployment.
     */
    @JsonProperty("availableReplicas")
    public Integer getAvailableReplicas() {
        return availableReplicas;
    }

    /**
     * Total number of available non-terminating pods (ready for at least minReadySeconds) targeted by this deployment.
     */
    @JsonProperty("availableReplicas")
    public void setAvailableReplicas(Integer availableReplicas) {
        this.availableReplicas = availableReplicas;
    }

    /**
     * Count of hash collisions for the Deployment. The Deployment controller uses this field as a collision avoidance mechanism when it needs to create the name for the newest ReplicaSet.
     */
    @JsonProperty("collisionCount")
    public Integer getCollisionCount() {
        return collisionCount;
    }

    /**
     * Count of hash collisions for the Deployment. The Deployment controller uses this field as a collision avoidance mechanism when it needs to create the name for the newest ReplicaSet.
     */
    @JsonProperty("collisionCount")
    public void setCollisionCount(Integer collisionCount) {
        this.collisionCount = collisionCount;
    }

    /**
     * Represents the latest available observations of a deployment's current state.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DeploymentCondition> getConditions() {
        return conditions;
    }

    /**
     * Represents the latest available observations of a deployment's current state.
     */
    @JsonProperty("conditions")
    public void setConditions(List<DeploymentCondition> conditions) {
        this.conditions = conditions;
    }

    /**
     * The generation observed by the deployment controller.
     */
    @JsonProperty("observedGeneration")
    public Long getObservedGeneration() {
        return observedGeneration;
    }

    /**
     * The generation observed by the deployment controller.
     */
    @JsonProperty("observedGeneration")
    public void setObservedGeneration(Long observedGeneration) {
        this.observedGeneration = observedGeneration;
    }

    /**
     * Total number of non-terminating pods targeted by this Deployment with a Ready Condition.
     */
    @JsonProperty("readyReplicas")
    public Integer getReadyReplicas() {
        return readyReplicas;
    }

    /**
     * Total number of non-terminating pods targeted by this Deployment with a Ready Condition.
     */
    @JsonProperty("readyReplicas")
    public void setReadyReplicas(Integer readyReplicas) {
        this.readyReplicas = readyReplicas;
    }

    /**
     * Total number of non-terminating pods targeted by this deployment (their labels match the selector).
     */
    @JsonProperty("replicas")
    public Integer getReplicas() {
        return replicas;
    }

    /**
     * Total number of non-terminating pods targeted by this deployment (their labels match the selector).
     */
    @JsonProperty("replicas")
    public void setReplicas(Integer replicas) {
        this.replicas = replicas;
    }

    /**
     * Total number of terminating pods targeted by this deployment. Terminating pods have a non-null .metadata.deletionTimestamp and have not yet reached the Failed or Succeeded .status.phase.<br><p> <br><p> This is a beta field and requires enabling DeploymentReplicaSetTerminatingReplicas feature (enabled by default).
     */
    @JsonProperty("terminatingReplicas")
    public Integer getTerminatingReplicas() {
        return terminatingReplicas;
    }

    /**
     * Total number of terminating pods targeted by this deployment. Terminating pods have a non-null .metadata.deletionTimestamp and have not yet reached the Failed or Succeeded .status.phase.<br><p> <br><p> This is a beta field and requires enabling DeploymentReplicaSetTerminatingReplicas feature (enabled by default).
     */
    @JsonProperty("terminatingReplicas")
    public void setTerminatingReplicas(Integer terminatingReplicas) {
        this.terminatingReplicas = terminatingReplicas;
    }

    /**
     * Total number of unavailable pods targeted by this deployment. This is the total number of pods that are still required for the deployment to have 100% available capacity. They may either be pods that are running but not yet available or pods that still have not been created.
     */
    @JsonProperty("unavailableReplicas")
    public Integer getUnavailableReplicas() {
        return unavailableReplicas;
    }

    /**
     * Total number of unavailable pods targeted by this deployment. This is the total number of pods that are still required for the deployment to have 100% available capacity. They may either be pods that are running but not yet available or pods that still have not been created.
     */
    @JsonProperty("unavailableReplicas")
    public void setUnavailableReplicas(Integer unavailableReplicas) {
        this.unavailableReplicas = unavailableReplicas;
    }

    /**
     * Total number of non-terminating pods targeted by this deployment that have the desired template spec.
     */
    @JsonProperty("updatedReplicas")
    public Integer getUpdatedReplicas() {
        return updatedReplicas;
    }

    /**
     * Total number of non-terminating pods targeted by this deployment that have the desired template spec.
     */
    @JsonProperty("updatedReplicas")
    public void setUpdatedReplicas(Integer updatedReplicas) {
        this.updatedReplicas = updatedReplicas;
    }

    @JsonIgnore
    public DeploymentStatusBuilder edit() {
        return new DeploymentStatusBuilder(this);
    }

    @JsonIgnore
    public DeploymentStatusBuilder toBuilder() {
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
        if (!(o instanceof DeploymentStatus)) {
            return false;
        }
        DeploymentStatus other = (DeploymentStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$availableReplicas = this.getAvailableReplicas();
        Object other$availableReplicas = other.getAvailableReplicas();
        if (this$availableReplicas == null ? other$availableReplicas != null : !this$availableReplicas.equals(other$availableReplicas)) {
            return false;
        }
        Object this$collisionCount = this.getCollisionCount();
        Object other$collisionCount = other.getCollisionCount();
        if (this$collisionCount == null ? other$collisionCount != null : !this$collisionCount.equals(other$collisionCount)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$observedGeneration = this.getObservedGeneration();
        Object other$observedGeneration = other.getObservedGeneration();
        if (this$observedGeneration == null ? other$observedGeneration != null : !this$observedGeneration.equals(other$observedGeneration)) {
            return false;
        }
        Object this$readyReplicas = this.getReadyReplicas();
        Object other$readyReplicas = other.getReadyReplicas();
        if (this$readyReplicas == null ? other$readyReplicas != null : !this$readyReplicas.equals(other$readyReplicas)) {
            return false;
        }
        Object this$replicas = this.getReplicas();
        Object other$replicas = other.getReplicas();
        if (this$replicas == null ? other$replicas != null : !this$replicas.equals(other$replicas)) {
            return false;
        }
        Object this$terminatingReplicas = this.getTerminatingReplicas();
        Object other$terminatingReplicas = other.getTerminatingReplicas();
        if (this$terminatingReplicas == null ? other$terminatingReplicas != null : !this$terminatingReplicas.equals(other$terminatingReplicas)) {
            return false;
        }
        Object this$unavailableReplicas = this.getUnavailableReplicas();
        Object other$unavailableReplicas = other.getUnavailableReplicas();
        if (this$unavailableReplicas == null ? other$unavailableReplicas != null : !this$unavailableReplicas.equals(other$unavailableReplicas)) {
            return false;
        }
        Object this$updatedReplicas = this.getUpdatedReplicas();
        Object other$updatedReplicas = other.getUpdatedReplicas();
        if (this$updatedReplicas == null ? other$updatedReplicas != null : !this$updatedReplicas.equals(other$updatedReplicas)) {
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
        return other instanceof DeploymentStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $availableReplicas = this.getAvailableReplicas();
        result = result * prime + ($availableReplicas == null ? 43 : $availableReplicas.hashCode());
        Object $collisionCount = this.getCollisionCount();
        result = result * prime + ($collisionCount == null ? 43 : $collisionCount.hashCode());
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $observedGeneration = this.getObservedGeneration();
        result = result * prime + ($observedGeneration == null ? 43 : $observedGeneration.hashCode());
        Object $readyReplicas = this.getReadyReplicas();
        result = result * prime + ($readyReplicas == null ? 43 : $readyReplicas.hashCode());
        Object $replicas = this.getReplicas();
        result = result * prime + ($replicas == null ? 43 : $replicas.hashCode());
        Object $terminatingReplicas = this.getTerminatingReplicas();
        result = result * prime + ($terminatingReplicas == null ? 43 : $terminatingReplicas.hashCode());
        Object $unavailableReplicas = this.getUnavailableReplicas();
        result = result * prime + ($unavailableReplicas == null ? 43 : $unavailableReplicas.hashCode());
        Object $updatedReplicas = this.getUpdatedReplicas();
        result = result * prime + ($updatedReplicas == null ? 43 : $updatedReplicas.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "DeploymentStatus(" + "availableReplicas=" + this.getAvailableReplicas() + ", collisionCount=" + this.getCollisionCount() + ", conditions=" + this.getConditions() + ", observedGeneration=" + this.getObservedGeneration() + ", readyReplicas=" + this.getReadyReplicas() + ", replicas=" + this.getReplicas() + ", terminatingReplicas=" + this.getTerminatingReplicas() + ", unavailableReplicas=" + this.getUnavailableReplicas() + ", updatedReplicas=" + this.getUpdatedReplicas() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
