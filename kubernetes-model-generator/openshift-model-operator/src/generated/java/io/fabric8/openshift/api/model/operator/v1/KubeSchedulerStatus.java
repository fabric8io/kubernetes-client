
package io.fabric8.openshift.api.model.operator.v1;

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
    "conditions",
    "generations",
    "latestAvailableRevision",
    "latestAvailableRevisionReason",
    "nodeStatuses",
    "observedGeneration",
    "readyReplicas",
    "version"
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
public class KubeSchedulerStatus implements KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<OperatorCondition> conditions = new ArrayList<OperatorCondition>();
    @JsonProperty("generations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<GenerationStatus> generations = new ArrayList<GenerationStatus>();
    @JsonProperty("latestAvailableRevision")
    private Integer latestAvailableRevision;
    @JsonProperty("latestAvailableRevisionReason")
    private String latestAvailableRevisionReason;
    @JsonProperty("nodeStatuses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NodeStatus> nodeStatuses = new ArrayList<NodeStatus>();
    @JsonProperty("observedGeneration")
    private Long observedGeneration;
    @JsonProperty("readyReplicas")
    private Integer readyReplicas;
    @JsonProperty("version")
    private String version;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public KubeSchedulerStatus() {
    }

    /**
     * 
     * @param nodeStatuses
     * @param latestAvailableRevision
     * @param generations
     * @param latestAvailableRevisionReason
     * @param readyReplicas
     * @param conditions
     * @param version
     * @param observedGeneration
     */
    public KubeSchedulerStatus(List<OperatorCondition> conditions, List<GenerationStatus> generations, Integer latestAvailableRevision, String latestAvailableRevisionReason, List<NodeStatus> nodeStatuses, Long observedGeneration, Integer readyReplicas, String version) {
        super();
        this.conditions = conditions;
        this.generations = generations;
        this.latestAvailableRevision = latestAvailableRevision;
        this.latestAvailableRevisionReason = latestAvailableRevisionReason;
        this.nodeStatuses = nodeStatuses;
        this.observedGeneration = observedGeneration;
        this.readyReplicas = readyReplicas;
        this.version = version;
    }

    @JsonProperty("conditions")
    public List<OperatorCondition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<OperatorCondition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("generations")
    public List<GenerationStatus> getGenerations() {
        return generations;
    }

    @JsonProperty("generations")
    public void setGenerations(List<GenerationStatus> generations) {
        this.generations = generations;
    }

    @JsonProperty("latestAvailableRevision")
    public Integer getLatestAvailableRevision() {
        return latestAvailableRevision;
    }

    @JsonProperty("latestAvailableRevision")
    public void setLatestAvailableRevision(Integer latestAvailableRevision) {
        this.latestAvailableRevision = latestAvailableRevision;
    }

    @JsonProperty("latestAvailableRevisionReason")
    public String getLatestAvailableRevisionReason() {
        return latestAvailableRevisionReason;
    }

    @JsonProperty("latestAvailableRevisionReason")
    public void setLatestAvailableRevisionReason(String latestAvailableRevisionReason) {
        this.latestAvailableRevisionReason = latestAvailableRevisionReason;
    }

    @JsonProperty("nodeStatuses")
    public List<NodeStatus> getNodeStatuses() {
        return nodeStatuses;
    }

    @JsonProperty("nodeStatuses")
    public void setNodeStatuses(List<NodeStatus> nodeStatuses) {
        this.nodeStatuses = nodeStatuses;
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

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
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
