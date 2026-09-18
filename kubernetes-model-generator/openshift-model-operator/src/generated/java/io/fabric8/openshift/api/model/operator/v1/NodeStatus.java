
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
 * NodeStatus provides information about the current state of a particular node managed by this operator.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "currentRevision",
    "lastFailedCount",
    "lastFailedReason",
    "lastFailedRevision",
    "lastFailedRevisionErrors",
    "lastFailedTime",
    "lastFallbackCount",
    "nodeName",
    "targetRevision"
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
public class NodeStatus implements Editable<NodeStatusBuilder>, KubernetesResource
{

    @JsonProperty("currentRevision")
    private Integer currentRevision;
    @JsonProperty("lastFailedCount")
    private Integer lastFailedCount;
    @JsonProperty("lastFailedReason")
    private String lastFailedReason;
    @JsonProperty("lastFailedRevision")
    private Integer lastFailedRevision;
    @JsonProperty("lastFailedRevisionErrors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> lastFailedRevisionErrors = new ArrayList<>();
    @JsonProperty("lastFailedTime")
    private String lastFailedTime;
    @JsonProperty("lastFallbackCount")
    private Integer lastFallbackCount;
    @JsonProperty("nodeName")
    private String nodeName;
    @JsonProperty("targetRevision")
    private Integer targetRevision;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NodeStatus() {
    }

    public NodeStatus(Integer currentRevision, Integer lastFailedCount, String lastFailedReason, Integer lastFailedRevision, List<String> lastFailedRevisionErrors, String lastFailedTime, Integer lastFallbackCount, String nodeName, Integer targetRevision) {
        super();
        this.currentRevision = currentRevision;
        this.lastFailedCount = lastFailedCount;
        this.lastFailedReason = lastFailedReason;
        this.lastFailedRevision = lastFailedRevision;
        this.lastFailedRevisionErrors = lastFailedRevisionErrors;
        this.lastFailedTime = lastFailedTime;
        this.lastFallbackCount = lastFallbackCount;
        this.nodeName = nodeName;
        this.targetRevision = targetRevision;
    }

    /**
     * currentRevision is the generation of the most recently successful deployment. Can not be set on creation of a nodeStatus. Updates must only increase the value.
     */
    @JsonProperty("currentRevision")
    public Integer getCurrentRevision() {
        return currentRevision;
    }

    /**
     * currentRevision is the generation of the most recently successful deployment. Can not be set on creation of a nodeStatus. Updates must only increase the value.
     */
    @JsonProperty("currentRevision")
    public void setCurrentRevision(Integer currentRevision) {
        this.currentRevision = currentRevision;
    }

    /**
     * lastFailedCount is how often the installer pod of the last failed revision failed.
     */
    @JsonProperty("lastFailedCount")
    public Integer getLastFailedCount() {
        return lastFailedCount;
    }

    /**
     * lastFailedCount is how often the installer pod of the last failed revision failed.
     */
    @JsonProperty("lastFailedCount")
    public void setLastFailedCount(Integer lastFailedCount) {
        this.lastFailedCount = lastFailedCount;
    }

    /**
     * lastFailedReason is a machine readable failure reason string.
     */
    @JsonProperty("lastFailedReason")
    public String getLastFailedReason() {
        return lastFailedReason;
    }

    /**
     * lastFailedReason is a machine readable failure reason string.
     */
    @JsonProperty("lastFailedReason")
    public void setLastFailedReason(String lastFailedReason) {
        this.lastFailedReason = lastFailedReason;
    }

    /**
     * lastFailedRevision is the generation of the deployment we tried and failed to deploy.
     */
    @JsonProperty("lastFailedRevision")
    public Integer getLastFailedRevision() {
        return lastFailedRevision;
    }

    /**
     * lastFailedRevision is the generation of the deployment we tried and failed to deploy.
     */
    @JsonProperty("lastFailedRevision")
    public void setLastFailedRevision(Integer lastFailedRevision) {
        this.lastFailedRevision = lastFailedRevision;
    }

    /**
     * lastFailedRevisionErrors is a list of human readable errors during the failed deployment referenced in lastFailedRevision.
     */
    @JsonProperty("lastFailedRevisionErrors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getLastFailedRevisionErrors() {
        return lastFailedRevisionErrors;
    }

    /**
     * lastFailedRevisionErrors is a list of human readable errors during the failed deployment referenced in lastFailedRevision.
     */
    @JsonProperty("lastFailedRevisionErrors")
    public void setLastFailedRevisionErrors(List<String> lastFailedRevisionErrors) {
        this.lastFailedRevisionErrors = lastFailedRevisionErrors;
    }

    /**
     * NodeStatus provides information about the current state of a particular node managed by this operator.
     */
    @JsonProperty("lastFailedTime")
    public String getLastFailedTime() {
        return lastFailedTime;
    }

    /**
     * NodeStatus provides information about the current state of a particular node managed by this operator.
     */
    @JsonProperty("lastFailedTime")
    public void setLastFailedTime(String lastFailedTime) {
        this.lastFailedTime = lastFailedTime;
    }

    /**
     * lastFallbackCount is how often a fallback to a previous revision happened.
     */
    @JsonProperty("lastFallbackCount")
    public Integer getLastFallbackCount() {
        return lastFallbackCount;
    }

    /**
     * lastFallbackCount is how often a fallback to a previous revision happened.
     */
    @JsonProperty("lastFallbackCount")
    public void setLastFallbackCount(Integer lastFallbackCount) {
        this.lastFallbackCount = lastFallbackCount;
    }

    /**
     * nodeName is the name of the node
     */
    @JsonProperty("nodeName")
    public String getNodeName() {
        return nodeName;
    }

    /**
     * nodeName is the name of the node
     */
    @JsonProperty("nodeName")
    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    /**
     * targetRevision is the generation of the deployment we're trying to apply. Can not be set on creation of a nodeStatus.
     */
    @JsonProperty("targetRevision")
    public Integer getTargetRevision() {
        return targetRevision;
    }

    /**
     * targetRevision is the generation of the deployment we're trying to apply. Can not be set on creation of a nodeStatus.
     */
    @JsonProperty("targetRevision")
    public void setTargetRevision(Integer targetRevision) {
        this.targetRevision = targetRevision;
    }

    @JsonIgnore
    public NodeStatusBuilder edit() {
        return new NodeStatusBuilder(this);
    }

    @JsonIgnore
    public NodeStatusBuilder toBuilder() {
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
        if (!(o instanceof NodeStatus)) {
            return false;
        }
        NodeStatus other = (NodeStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$currentRevision = this.getCurrentRevision();
        Object other$currentRevision = other.getCurrentRevision();
        if (this$currentRevision == null ? other$currentRevision != null : !this$currentRevision.equals(other$currentRevision)) {
            return false;
        }
        Object this$lastFailedCount = this.getLastFailedCount();
        Object other$lastFailedCount = other.getLastFailedCount();
        if (this$lastFailedCount == null ? other$lastFailedCount != null : !this$lastFailedCount.equals(other$lastFailedCount)) {
            return false;
        }
        Object this$lastFailedReason = this.getLastFailedReason();
        Object other$lastFailedReason = other.getLastFailedReason();
        if (this$lastFailedReason == null ? other$lastFailedReason != null : !this$lastFailedReason.equals(other$lastFailedReason)) {
            return false;
        }
        Object this$lastFailedRevision = this.getLastFailedRevision();
        Object other$lastFailedRevision = other.getLastFailedRevision();
        if (this$lastFailedRevision == null ? other$lastFailedRevision != null : !this$lastFailedRevision.equals(other$lastFailedRevision)) {
            return false;
        }
        Object this$lastFailedRevisionErrors = this.getLastFailedRevisionErrors();
        Object other$lastFailedRevisionErrors = other.getLastFailedRevisionErrors();
        if (this$lastFailedRevisionErrors == null ? other$lastFailedRevisionErrors != null : !this$lastFailedRevisionErrors.equals(other$lastFailedRevisionErrors)) {
            return false;
        }
        Object this$lastFailedTime = this.getLastFailedTime();
        Object other$lastFailedTime = other.getLastFailedTime();
        if (this$lastFailedTime == null ? other$lastFailedTime != null : !this$lastFailedTime.equals(other$lastFailedTime)) {
            return false;
        }
        Object this$lastFallbackCount = this.getLastFallbackCount();
        Object other$lastFallbackCount = other.getLastFallbackCount();
        if (this$lastFallbackCount == null ? other$lastFallbackCount != null : !this$lastFallbackCount.equals(other$lastFallbackCount)) {
            return false;
        }
        Object this$nodeName = this.getNodeName();
        Object other$nodeName = other.getNodeName();
        if (this$nodeName == null ? other$nodeName != null : !this$nodeName.equals(other$nodeName)) {
            return false;
        }
        Object this$targetRevision = this.getTargetRevision();
        Object other$targetRevision = other.getTargetRevision();
        if (this$targetRevision == null ? other$targetRevision != null : !this$targetRevision.equals(other$targetRevision)) {
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
        return other instanceof NodeStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $currentRevision = this.getCurrentRevision();
        result = result * prime + ($currentRevision == null ? 43 : $currentRevision.hashCode());
        Object $lastFailedCount = this.getLastFailedCount();
        result = result * prime + ($lastFailedCount == null ? 43 : $lastFailedCount.hashCode());
        Object $lastFailedReason = this.getLastFailedReason();
        result = result * prime + ($lastFailedReason == null ? 43 : $lastFailedReason.hashCode());
        Object $lastFailedRevision = this.getLastFailedRevision();
        result = result * prime + ($lastFailedRevision == null ? 43 : $lastFailedRevision.hashCode());
        Object $lastFailedRevisionErrors = this.getLastFailedRevisionErrors();
        result = result * prime + ($lastFailedRevisionErrors == null ? 43 : $lastFailedRevisionErrors.hashCode());
        Object $lastFailedTime = this.getLastFailedTime();
        result = result * prime + ($lastFailedTime == null ? 43 : $lastFailedTime.hashCode());
        Object $lastFallbackCount = this.getLastFallbackCount();
        result = result * prime + ($lastFallbackCount == null ? 43 : $lastFallbackCount.hashCode());
        Object $nodeName = this.getNodeName();
        result = result * prime + ($nodeName == null ? 43 : $nodeName.hashCode());
        Object $targetRevision = this.getTargetRevision();
        result = result * prime + ($targetRevision == null ? 43 : $targetRevision.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NodeStatus(" + "currentRevision=" + this.getCurrentRevision() + ", lastFailedCount=" + this.getLastFailedCount() + ", lastFailedReason=" + this.getLastFailedReason() + ", lastFailedRevision=" + this.getLastFailedRevision() + ", lastFailedRevisionErrors=" + this.getLastFailedRevisionErrors() + ", lastFailedTime=" + this.getLastFailedTime() + ", lastFallbackCount=" + this.getLastFallbackCount() + ", nodeName=" + this.getNodeName() + ", targetRevision=" + this.getTargetRevision() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
