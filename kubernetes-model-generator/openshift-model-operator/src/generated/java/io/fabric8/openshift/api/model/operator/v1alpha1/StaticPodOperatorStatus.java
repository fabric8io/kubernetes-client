
package io.fabric8.openshift.api.model.operator.v1alpha1;

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
 * StaticPodOperatorStatus is status for controllers that manage static pods.  There are different needs because individual node status must be tracked. DEPRECATED: Use v1.StaticPodOperatorStatus instead
 */
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
public class StaticPodOperatorStatus implements Editable<StaticPodOperatorStatusBuilder>, KubernetesResource
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

    /**
     * conditions is a list of conditions and their status
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<OperatorCondition> getConditions() {
        return conditions;
    }

    /**
     * conditions is a list of conditions and their status
     */
    @JsonProperty("conditions")
    public void setConditions(List<OperatorCondition> conditions) {
        this.conditions = conditions;
    }

    /**
     * StaticPodOperatorStatus is status for controllers that manage static pods.  There are different needs because individual node status must be tracked. DEPRECATED: Use v1.StaticPodOperatorStatus instead
     */
    @JsonProperty("currentVersionAvailability")
    public VersionAvailability getCurrentVersionAvailability() {
        return currentVersionAvailability;
    }

    /**
     * StaticPodOperatorStatus is status for controllers that manage static pods.  There are different needs because individual node status must be tracked. DEPRECATED: Use v1.StaticPodOperatorStatus instead
     */
    @JsonProperty("currentVersionAvailability")
    public void setCurrentVersionAvailability(VersionAvailability currentVersionAvailability) {
        this.currentVersionAvailability = currentVersionAvailability;
    }

    /**
     * latestAvailableDeploymentGeneration is the deploymentID of the most recent deployment
     */
    @JsonProperty("latestAvailableDeploymentGeneration")
    public Integer getLatestAvailableDeploymentGeneration() {
        return latestAvailableDeploymentGeneration;
    }

    /**
     * latestAvailableDeploymentGeneration is the deploymentID of the most recent deployment
     */
    @JsonProperty("latestAvailableDeploymentGeneration")
    public void setLatestAvailableDeploymentGeneration(Integer latestAvailableDeploymentGeneration) {
        this.latestAvailableDeploymentGeneration = latestAvailableDeploymentGeneration;
    }

    /**
     * nodeStatuses track the deployment values and errors across individual nodes
     */
    @JsonProperty("nodeStatuses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NodeStatus> getNodeStatuses() {
        return nodeStatuses;
    }

    /**
     * nodeStatuses track the deployment values and errors across individual nodes
     */
    @JsonProperty("nodeStatuses")
    public void setNodeStatuses(List<NodeStatus> nodeStatuses) {
        this.nodeStatuses = nodeStatuses;
    }

    /**
     * observedGeneration is the last generation change you've dealt with
     */
    @JsonProperty("observedGeneration")
    public Long getObservedGeneration() {
        return observedGeneration;
    }

    /**
     * observedGeneration is the last generation change you've dealt with
     */
    @JsonProperty("observedGeneration")
    public void setObservedGeneration(Long observedGeneration) {
        this.observedGeneration = observedGeneration;
    }

    /**
     * state indicates what the operator has observed to be its current operational status.
     */
    @JsonProperty("state")
    public String getState() {
        return state;
    }

    /**
     * state indicates what the operator has observed to be its current operational status.
     */
    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    /**
     * StaticPodOperatorStatus is status for controllers that manage static pods.  There are different needs because individual node status must be tracked. DEPRECATED: Use v1.StaticPodOperatorStatus instead
     */
    @JsonProperty("targetVersionAvailability")
    public VersionAvailability getTargetVersionAvailability() {
        return targetVersionAvailability;
    }

    /**
     * StaticPodOperatorStatus is status for controllers that manage static pods.  There are different needs because individual node status must be tracked. DEPRECATED: Use v1.StaticPodOperatorStatus instead
     */
    @JsonProperty("targetVersionAvailability")
    public void setTargetVersionAvailability(VersionAvailability targetVersionAvailability) {
        this.targetVersionAvailability = targetVersionAvailability;
    }

    /**
     * taskSummary is a high level summary of what the controller is currently attempting to do.  It is high-level, human-readable and not guaranteed in any way. (I needed this for debugging and realized it made a great summary).
     */
    @JsonProperty("taskSummary")
    public String getTaskSummary() {
        return taskSummary;
    }

    /**
     * taskSummary is a high level summary of what the controller is currently attempting to do.  It is high-level, human-readable and not guaranteed in any way. (I needed this for debugging and realized it made a great summary).
     */
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
        if (!(o instanceof StaticPodOperatorStatus)) {
            return false;
        }
        StaticPodOperatorStatus other = (StaticPodOperatorStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$currentVersionAvailability = this.getCurrentVersionAvailability();
        Object other$currentVersionAvailability = other.getCurrentVersionAvailability();
        if (this$currentVersionAvailability == null ? other$currentVersionAvailability != null : !this$currentVersionAvailability.equals(other$currentVersionAvailability)) {
            return false;
        }
        Object this$latestAvailableDeploymentGeneration = this.getLatestAvailableDeploymentGeneration();
        Object other$latestAvailableDeploymentGeneration = other.getLatestAvailableDeploymentGeneration();
        if (this$latestAvailableDeploymentGeneration == null ? other$latestAvailableDeploymentGeneration != null : !this$latestAvailableDeploymentGeneration.equals(other$latestAvailableDeploymentGeneration)) {
            return false;
        }
        Object this$nodeStatuses = this.getNodeStatuses();
        Object other$nodeStatuses = other.getNodeStatuses();
        if (this$nodeStatuses == null ? other$nodeStatuses != null : !this$nodeStatuses.equals(other$nodeStatuses)) {
            return false;
        }
        Object this$observedGeneration = this.getObservedGeneration();
        Object other$observedGeneration = other.getObservedGeneration();
        if (this$observedGeneration == null ? other$observedGeneration != null : !this$observedGeneration.equals(other$observedGeneration)) {
            return false;
        }
        Object this$state = this.getState();
        Object other$state = other.getState();
        if (this$state == null ? other$state != null : !this$state.equals(other$state)) {
            return false;
        }
        Object this$targetVersionAvailability = this.getTargetVersionAvailability();
        Object other$targetVersionAvailability = other.getTargetVersionAvailability();
        if (this$targetVersionAvailability == null ? other$targetVersionAvailability != null : !this$targetVersionAvailability.equals(other$targetVersionAvailability)) {
            return false;
        }
        Object this$taskSummary = this.getTaskSummary();
        Object other$taskSummary = other.getTaskSummary();
        if (this$taskSummary == null ? other$taskSummary != null : !this$taskSummary.equals(other$taskSummary)) {
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
        return other instanceof StaticPodOperatorStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $currentVersionAvailability = this.getCurrentVersionAvailability();
        result = result * prime + ($currentVersionAvailability == null ? 43 : $currentVersionAvailability.hashCode());
        Object $latestAvailableDeploymentGeneration = this.getLatestAvailableDeploymentGeneration();
        result = result * prime + ($latestAvailableDeploymentGeneration == null ? 43 : $latestAvailableDeploymentGeneration.hashCode());
        Object $nodeStatuses = this.getNodeStatuses();
        result = result * prime + ($nodeStatuses == null ? 43 : $nodeStatuses.hashCode());
        Object $observedGeneration = this.getObservedGeneration();
        result = result * prime + ($observedGeneration == null ? 43 : $observedGeneration.hashCode());
        Object $state = this.getState();
        result = result * prime + ($state == null ? 43 : $state.hashCode());
        Object $targetVersionAvailability = this.getTargetVersionAvailability();
        result = result * prime + ($targetVersionAvailability == null ? 43 : $targetVersionAvailability.hashCode());
        Object $taskSummary = this.getTaskSummary();
        result = result * prime + ($taskSummary == null ? 43 : $taskSummary.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "StaticPodOperatorStatus(" + "conditions=" + this.getConditions() + ", currentVersionAvailability=" + this.getCurrentVersionAvailability() + ", latestAvailableDeploymentGeneration=" + this.getLatestAvailableDeploymentGeneration() + ", nodeStatuses=" + this.getNodeStatuses() + ", observedGeneration=" + this.getObservedGeneration() + ", state=" + this.getState() + ", targetVersionAvailability=" + this.getTargetVersionAvailability() + ", taskSummary=" + this.getTaskSummary() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
