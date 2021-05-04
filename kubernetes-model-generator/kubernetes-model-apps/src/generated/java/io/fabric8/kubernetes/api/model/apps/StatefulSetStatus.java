
package io.fabric8.kubernetes.api.model.apps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import lombok.ToString;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
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
@ToString
@EqualsAndHashCode
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
public class StatefulSetStatus implements KubernetesResource
{

    @JsonProperty("collisionCount")
    private Integer collisionCount;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<StatefulSetCondition> conditions = new ArrayList<StatefulSetCondition>();
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
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public StatefulSetStatus() {
    }

    /**
     * 
     * @param currentRevision
     * @param replicas
     * @param updateRevision
     * @param readyReplicas
     * @param collisionCount
     * @param currentReplicas
     * @param conditions
     * @param updatedReplicas
     * @param observedGeneration
     */
    public StatefulSetStatus(Integer collisionCount, List<StatefulSetCondition> conditions, Integer currentReplicas, String currentRevision, Long observedGeneration, Integer readyReplicas, Integer replicas, String updateRevision, Integer updatedReplicas) {
        super();
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

    @JsonProperty("collisionCount")
    public Integer getCollisionCount() {
        return collisionCount;
    }

    @JsonProperty("collisionCount")
    public void setCollisionCount(Integer collisionCount) {
        this.collisionCount = collisionCount;
    }

    @JsonProperty("conditions")
    public List<StatefulSetCondition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<StatefulSetCondition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("currentReplicas")
    public Integer getCurrentReplicas() {
        return currentReplicas;
    }

    @JsonProperty("currentReplicas")
    public void setCurrentReplicas(Integer currentReplicas) {
        this.currentReplicas = currentReplicas;
    }

    @JsonProperty("currentRevision")
    public String getCurrentRevision() {
        return currentRevision;
    }

    @JsonProperty("currentRevision")
    public void setCurrentRevision(String currentRevision) {
        this.currentRevision = currentRevision;
    }

    @JsonProperty("observedGeneration")
    public Long getObservedGeneration() {
        return observedGeneration;
    }

    @JsonProperty("observedGeneration")
    public void setObservedGeneration(Long observedGeneration) {
        this.observedGeneration = observedGeneration;
    }

    @JsonProperty("readyReplicas")
    public Integer getReadyReplicas() {
        return readyReplicas;
    }

    @JsonProperty("readyReplicas")
    public void setReadyReplicas(Integer readyReplicas) {
        this.readyReplicas = readyReplicas;
    }

    @JsonProperty("replicas")
    public Integer getReplicas() {
        return replicas;
    }

    @JsonProperty("replicas")
    public void setReplicas(Integer replicas) {
        this.replicas = replicas;
    }

    @JsonProperty("updateRevision")
    public String getUpdateRevision() {
        return updateRevision;
    }

    @JsonProperty("updateRevision")
    public void setUpdateRevision(String updateRevision) {
        this.updateRevision = updateRevision;
    }

    @JsonProperty("updatedReplicas")
    public Integer getUpdatedReplicas() {
        return updatedReplicas;
    }

    @JsonProperty("updatedReplicas")
    public void setUpdatedReplicas(Integer updatedReplicas) {
        this.updatedReplicas = updatedReplicas;
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
