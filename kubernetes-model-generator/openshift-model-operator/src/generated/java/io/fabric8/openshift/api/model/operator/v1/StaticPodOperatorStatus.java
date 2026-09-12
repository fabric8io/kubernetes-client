
package io.fabric8.openshift.api.model.operator.v1;

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
 * StaticPodOperatorStatus is status for controllers that manage static pods.  There are different needs because individual node status must be tracked.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditions",
    "generations",
    "latestAvailableRevision",
    "latestAvailableRevisionReason",
    "nodeStatuses",
    "observedGeneration",
    "readyReplicas",
    "version"
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
    @JsonProperty("generations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<GenerationStatus> generations = new ArrayList<>();
    @JsonProperty("latestAvailableRevision")
    private Integer latestAvailableRevision;
    @JsonProperty("latestAvailableRevisionReason")
    private String latestAvailableRevisionReason;
    @JsonProperty("nodeStatuses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NodeStatus> nodeStatuses = new ArrayList<>();
    @JsonProperty("observedGeneration")
    private Long observedGeneration;
    @JsonProperty("readyReplicas")
    private Integer readyReplicas;
    @JsonProperty("version")
    private String version;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public StaticPodOperatorStatus() {
    }

    public StaticPodOperatorStatus(List<OperatorCondition> conditions, List<GenerationStatus> generations, Integer latestAvailableRevision, String latestAvailableRevisionReason, List<NodeStatus> nodeStatuses, Long observedGeneration, Integer readyReplicas, String version) {
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
     * generations are used to determine when an item needs to be reconciled or has changed in a way that needs a reaction.
     */
    @JsonProperty("generations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<GenerationStatus> getGenerations() {
        return generations;
    }

    /**
     * generations are used to determine when an item needs to be reconciled or has changed in a way that needs a reaction.
     */
    @JsonProperty("generations")
    public void setGenerations(List<GenerationStatus> generations) {
        this.generations = generations;
    }

    /**
     * latestAvailableRevision is the deploymentID of the most recent deployment
     */
    @JsonProperty("latestAvailableRevision")
    public Integer getLatestAvailableRevision() {
        return latestAvailableRevision;
    }

    /**
     * latestAvailableRevision is the deploymentID of the most recent deployment
     */
    @JsonProperty("latestAvailableRevision")
    public void setLatestAvailableRevision(Integer latestAvailableRevision) {
        this.latestAvailableRevision = latestAvailableRevision;
    }

    /**
     * latestAvailableRevisionReason describe the detailed reason for the most recent deployment
     */
    @JsonProperty("latestAvailableRevisionReason")
    public String getLatestAvailableRevisionReason() {
        return latestAvailableRevisionReason;
    }

    /**
     * latestAvailableRevisionReason describe the detailed reason for the most recent deployment
     */
    @JsonProperty("latestAvailableRevisionReason")
    public void setLatestAvailableRevisionReason(String latestAvailableRevisionReason) {
        this.latestAvailableRevisionReason = latestAvailableRevisionReason;
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
     * readyReplicas indicates how many replicas are ready and at the desired state
     */
    @JsonProperty("readyReplicas")
    public Integer getReadyReplicas() {
        return readyReplicas;
    }

    /**
     * readyReplicas indicates how many replicas are ready and at the desired state
     */
    @JsonProperty("readyReplicas")
    public void setReadyReplicas(Integer readyReplicas) {
        this.readyReplicas = readyReplicas;
    }

    /**
     * version is the level this availability applies to
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * version is the level this availability applies to
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
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
        Object this$generations = this.getGenerations();
        Object other$generations = other.getGenerations();
        if (this$generations == null ? other$generations != null : !this$generations.equals(other$generations)) {
            return false;
        }
        Object this$latestAvailableRevision = this.getLatestAvailableRevision();
        Object other$latestAvailableRevision = other.getLatestAvailableRevision();
        if (this$latestAvailableRevision == null ? other$latestAvailableRevision != null : !this$latestAvailableRevision.equals(other$latestAvailableRevision)) {
            return false;
        }
        Object this$latestAvailableRevisionReason = this.getLatestAvailableRevisionReason();
        Object other$latestAvailableRevisionReason = other.getLatestAvailableRevisionReason();
        if (this$latestAvailableRevisionReason == null ? other$latestAvailableRevisionReason != null : !this$latestAvailableRevisionReason.equals(other$latestAvailableRevisionReason)) {
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
        Object this$readyReplicas = this.getReadyReplicas();
        Object other$readyReplicas = other.getReadyReplicas();
        if (this$readyReplicas == null ? other$readyReplicas != null : !this$readyReplicas.equals(other$readyReplicas)) {
            return false;
        }
        Object this$version = this.getVersion();
        Object other$version = other.getVersion();
        if (this$version == null ? other$version != null : !this$version.equals(other$version)) {
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
        Object $generations = this.getGenerations();
        result = result * prime + ($generations == null ? 43 : $generations.hashCode());
        Object $latestAvailableRevision = this.getLatestAvailableRevision();
        result = result * prime + ($latestAvailableRevision == null ? 43 : $latestAvailableRevision.hashCode());
        Object $latestAvailableRevisionReason = this.getLatestAvailableRevisionReason();
        result = result * prime + ($latestAvailableRevisionReason == null ? 43 : $latestAvailableRevisionReason.hashCode());
        Object $nodeStatuses = this.getNodeStatuses();
        result = result * prime + ($nodeStatuses == null ? 43 : $nodeStatuses.hashCode());
        Object $observedGeneration = this.getObservedGeneration();
        result = result * prime + ($observedGeneration == null ? 43 : $observedGeneration.hashCode());
        Object $readyReplicas = this.getReadyReplicas();
        result = result * prime + ($readyReplicas == null ? 43 : $readyReplicas.hashCode());
        Object $version = this.getVersion();
        result = result * prime + ($version == null ? 43 : $version.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "StaticPodOperatorStatus(" + "conditions=" + this.getConditions() + ", generations=" + this.getGenerations() + ", latestAvailableRevision=" + this.getLatestAvailableRevision() + ", latestAvailableRevisionReason=" + this.getLatestAvailableRevisionReason() + ", nodeStatuses=" + this.getNodeStatuses() + ", observedGeneration=" + this.getObservedGeneration() + ", readyReplicas=" + this.getReadyReplicas() + ", version=" + this.getVersion() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
