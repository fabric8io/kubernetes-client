
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
 * StatefulSetStatus represents the current state of a StatefulSet.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "availableReplicas",
    "collisionCount",
    "conditions",
    "currentReplicas",
    "currentRevision",
    "observedGeneration",
    "readyReplicas",
    "replicas",
    "updateRevision",
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
public class StatefulSetStatus implements Editable<StatefulSetStatusBuilder>, KubernetesResource
{

    @JsonProperty("availableReplicas")
    private Integer availableReplicas;
    @JsonProperty("collisionCount")
    private Integer collisionCount;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<StatefulSetCondition> conditions = new ArrayList<>();
    @JsonProperty("currentReplicas")
    private Integer currentReplicas;
    @JsonProperty("currentRevision")
    private String currentRevision;
    @JsonProperty("observedGeneration")
    private Long observedGeneration;
    @JsonProperty("readyReplicas")
    private Integer readyReplicas;
    @JsonProperty("replicas")
    private Integer replicas;
    @JsonProperty("updateRevision")
    private String updateRevision;
    @JsonProperty("updatedReplicas")
    private Integer updatedReplicas;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public StatefulSetStatus() {
    }

    public StatefulSetStatus(Integer availableReplicas, Integer collisionCount, List<StatefulSetCondition> conditions, Integer currentReplicas, String currentRevision, Long observedGeneration, Integer readyReplicas, Integer replicas, String updateRevision, Integer updatedReplicas) {
        super();
        this.availableReplicas = availableReplicas;
        this.collisionCount = collisionCount;
        this.conditions = conditions;
        this.currentReplicas = currentReplicas;
        this.currentRevision = currentRevision;
        this.observedGeneration = observedGeneration;
        this.readyReplicas = readyReplicas;
        this.replicas = replicas;
        this.updateRevision = updateRevision;
        this.updatedReplicas = updatedReplicas;
    }

    /**
     * Total number of available pods (ready for at least minReadySeconds) targeted by this statefulset.
     */
    @JsonProperty("availableReplicas")
    public Integer getAvailableReplicas() {
        return availableReplicas;
    }

    /**
     * Total number of available pods (ready for at least minReadySeconds) targeted by this statefulset.
     */
    @JsonProperty("availableReplicas")
    public void setAvailableReplicas(Integer availableReplicas) {
        this.availableReplicas = availableReplicas;
    }

    /**
     * collisionCount is the count of hash collisions for the StatefulSet. The StatefulSet controller uses this field as a collision avoidance mechanism when it needs to create the name for the newest ControllerRevision.
     */
    @JsonProperty("collisionCount")
    public Integer getCollisionCount() {
        return collisionCount;
    }

    /**
     * collisionCount is the count of hash collisions for the StatefulSet. The StatefulSet controller uses this field as a collision avoidance mechanism when it needs to create the name for the newest ControllerRevision.
     */
    @JsonProperty("collisionCount")
    public void setCollisionCount(Integer collisionCount) {
        this.collisionCount = collisionCount;
    }

    /**
     * Represents the latest available observations of a statefulset's current state.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<StatefulSetCondition> getConditions() {
        return conditions;
    }

    /**
     * Represents the latest available observations of a statefulset's current state.
     */
    @JsonProperty("conditions")
    public void setConditions(List<StatefulSetCondition> conditions) {
        this.conditions = conditions;
    }

    /**
     * currentReplicas is the number of Pods created by the StatefulSet controller from the StatefulSet version indicated by currentRevision.
     */
    @JsonProperty("currentReplicas")
    public Integer getCurrentReplicas() {
        return currentReplicas;
    }

    /**
     * currentReplicas is the number of Pods created by the StatefulSet controller from the StatefulSet version indicated by currentRevision.
     */
    @JsonProperty("currentReplicas")
    public void setCurrentReplicas(Integer currentReplicas) {
        this.currentReplicas = currentReplicas;
    }

    /**
     * currentRevision, if not empty, indicates the version of the StatefulSet used to generate Pods in the sequence [0,currentReplicas).
     */
    @JsonProperty("currentRevision")
    public String getCurrentRevision() {
        return currentRevision;
    }

    /**
     * currentRevision, if not empty, indicates the version of the StatefulSet used to generate Pods in the sequence [0,currentReplicas).
     */
    @JsonProperty("currentRevision")
    public void setCurrentRevision(String currentRevision) {
        this.currentRevision = currentRevision;
    }

    /**
     * observedGeneration is the most recent generation observed for this StatefulSet. It corresponds to the StatefulSet's generation, which is updated on mutation by the API Server.
     */
    @JsonProperty("observedGeneration")
    public Long getObservedGeneration() {
        return observedGeneration;
    }

    /**
     * observedGeneration is the most recent generation observed for this StatefulSet. It corresponds to the StatefulSet's generation, which is updated on mutation by the API Server.
     */
    @JsonProperty("observedGeneration")
    public void setObservedGeneration(Long observedGeneration) {
        this.observedGeneration = observedGeneration;
    }

    /**
     * readyReplicas is the number of pods created for this StatefulSet with a Ready Condition.
     */
    @JsonProperty("readyReplicas")
    public Integer getReadyReplicas() {
        return readyReplicas;
    }

    /**
     * readyReplicas is the number of pods created for this StatefulSet with a Ready Condition.
     */
    @JsonProperty("readyReplicas")
    public void setReadyReplicas(Integer readyReplicas) {
        this.readyReplicas = readyReplicas;
    }

    /**
     * replicas is the number of Pods created by the StatefulSet controller.
     */
    @JsonProperty("replicas")
    public Integer getReplicas() {
        return replicas;
    }

    /**
     * replicas is the number of Pods created by the StatefulSet controller.
     */
    @JsonProperty("replicas")
    public void setReplicas(Integer replicas) {
        this.replicas = replicas;
    }

    /**
     * updateRevision, if not empty, indicates the version of the StatefulSet used to generate Pods in the sequence [replicas-updatedReplicas,replicas)
     */
    @JsonProperty("updateRevision")
    public String getUpdateRevision() {
        return updateRevision;
    }

    /**
     * updateRevision, if not empty, indicates the version of the StatefulSet used to generate Pods in the sequence [replicas-updatedReplicas,replicas)
     */
    @JsonProperty("updateRevision")
    public void setUpdateRevision(String updateRevision) {
        this.updateRevision = updateRevision;
    }

    /**
     * updatedReplicas is the number of Pods created by the StatefulSet controller from the StatefulSet version indicated by updateRevision.
     */
    @JsonProperty("updatedReplicas")
    public Integer getUpdatedReplicas() {
        return updatedReplicas;
    }

    /**
     * updatedReplicas is the number of Pods created by the StatefulSet controller from the StatefulSet version indicated by updateRevision.
     */
    @JsonProperty("updatedReplicas")
    public void setUpdatedReplicas(Integer updatedReplicas) {
        this.updatedReplicas = updatedReplicas;
    }

    @JsonIgnore
    public StatefulSetStatusBuilder edit() {
        return new StatefulSetStatusBuilder(this);
    }

    @JsonIgnore
    public StatefulSetStatusBuilder toBuilder() {
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
        if (!(o instanceof StatefulSetStatus)) {
            return false;
        }
        StatefulSetStatus other = (StatefulSetStatus) o;
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
        Object this$currentReplicas = this.getCurrentReplicas();
        Object other$currentReplicas = other.getCurrentReplicas();
        if (this$currentReplicas == null ? other$currentReplicas != null : !this$currentReplicas.equals(other$currentReplicas)) {
            return false;
        }
        Object this$currentRevision = this.getCurrentRevision();
        Object other$currentRevision = other.getCurrentRevision();
        if (this$currentRevision == null ? other$currentRevision != null : !this$currentRevision.equals(other$currentRevision)) {
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
        Object this$updateRevision = this.getUpdateRevision();
        Object other$updateRevision = other.getUpdateRevision();
        if (this$updateRevision == null ? other$updateRevision != null : !this$updateRevision.equals(other$updateRevision)) {
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
        return other instanceof StatefulSetStatus;
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
        Object $currentReplicas = this.getCurrentReplicas();
        result = result * prime + ($currentReplicas == null ? 43 : $currentReplicas.hashCode());
        Object $currentRevision = this.getCurrentRevision();
        result = result * prime + ($currentRevision == null ? 43 : $currentRevision.hashCode());
        Object $observedGeneration = this.getObservedGeneration();
        result = result * prime + ($observedGeneration == null ? 43 : $observedGeneration.hashCode());
        Object $readyReplicas = this.getReadyReplicas();
        result = result * prime + ($readyReplicas == null ? 43 : $readyReplicas.hashCode());
        Object $replicas = this.getReplicas();
        result = result * prime + ($replicas == null ? 43 : $replicas.hashCode());
        Object $updateRevision = this.getUpdateRevision();
        result = result * prime + ($updateRevision == null ? 43 : $updateRevision.hashCode());
        Object $updatedReplicas = this.getUpdatedReplicas();
        result = result * prime + ($updatedReplicas == null ? 43 : $updatedReplicas.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "StatefulSetStatus(" + "availableReplicas=" + this.getAvailableReplicas() + ", collisionCount=" + this.getCollisionCount() + ", conditions=" + this.getConditions() + ", currentReplicas=" + this.getCurrentReplicas() + ", currentRevision=" + this.getCurrentRevision() + ", observedGeneration=" + this.getObservedGeneration() + ", readyReplicas=" + this.getReadyReplicas() + ", replicas=" + this.getReplicas() + ", updateRevision=" + this.getUpdateRevision() + ", updatedReplicas=" + this.getUpdatedReplicas() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
