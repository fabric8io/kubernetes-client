
package io.fabric8.openshift.api.model.operator.v1alpha1;

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
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditions",
    "currentVersionAvailability",
    "latestAvailableDeploymentGeneration",
    "nodeStatuses",
    "observedGeneration",
    "state",
    "targetVersionAvailability",
    "taskSummary"
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class StaticPodOperatorStatus implements Editable<StaticPodOperatorStatusBuilder> , KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<OperatorCondition> conditions = new ArrayList<>();
    @JsonProperty("currentVersionAvailability")
    private VersionAvailability currentVersionAvailability;
    @JsonProperty("latestAvailableDeploymentGeneration")
    private Integer latestAvailableDeploymentGeneration;
    @JsonProperty("nodeStatuses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NodeStatus> nodeStatuses = new ArrayList<>();
    @JsonProperty("observedGeneration")
    private Long observedGeneration;
    @JsonProperty("state")
    private String state;
    @JsonProperty("targetVersionAvailability")
    private VersionAvailability targetVersionAvailability;
    @JsonProperty("taskSummary")
    private String taskSummary;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public StaticPodOperatorStatus() {
    }

    public StaticPodOperatorStatus(List<OperatorCondition> conditions, VersionAvailability currentVersionAvailability, Integer latestAvailableDeploymentGeneration, List<NodeStatus> nodeStatuses, Long observedGeneration, String state, VersionAvailability targetVersionAvailability, String taskSummary) {
        super();
        this.conditions = conditions;
        this.currentVersionAvailability = currentVersionAvailability;
        this.latestAvailableDeploymentGeneration = latestAvailableDeploymentGeneration;
        this.nodeStatuses = nodeStatuses;
        this.observedGeneration = observedGeneration;
        this.state = state;
        this.targetVersionAvailability = targetVersionAvailability;
        this.taskSummary = taskSummary;
    }

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<OperatorCondition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<OperatorCondition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("currentVersionAvailability")
    public VersionAvailability getCurrentVersionAvailability() {
        return currentVersionAvailability;
    }

    @JsonProperty("currentVersionAvailability")
    public void setCurrentVersionAvailability(VersionAvailability currentVersionAvailability) {
        this.currentVersionAvailability = currentVersionAvailability;
    }

    @JsonProperty("latestAvailableDeploymentGeneration")
    public Integer getLatestAvailableDeploymentGeneration() {
        return latestAvailableDeploymentGeneration;
    }

    @JsonProperty("latestAvailableDeploymentGeneration")
    public void setLatestAvailableDeploymentGeneration(Integer latestAvailableDeploymentGeneration) {
        this.latestAvailableDeploymentGeneration = latestAvailableDeploymentGeneration;
    }

    @JsonProperty("nodeStatuses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
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

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("targetVersionAvailability")
    public VersionAvailability getTargetVersionAvailability() {
        return targetVersionAvailability;
    }

    @JsonProperty("targetVersionAvailability")
    public void setTargetVersionAvailability(VersionAvailability targetVersionAvailability) {
        this.targetVersionAvailability = targetVersionAvailability;
    }

    @JsonProperty("taskSummary")
    public String getTaskSummary() {
        return taskSummary;
    }

    @JsonProperty("taskSummary")
    public void setTaskSummary(String taskSummary) {
        this.taskSummary = taskSummary;
    }

    @JsonIgnore
    public StaticPodOperatorStatusBuilder edit() {
        return new StaticPodOperatorStatusBuilder(this);
    }

    @JsonIgnore
    public StaticPodOperatorStatusBuilder toBuilder() {
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
