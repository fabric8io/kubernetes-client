
package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

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
 * ClusterServiceVersionStatus represents information about the status of a CSV. Status may trail the actual state of a system.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "certsLastUpdated",
    "certsRotateAt",
    "cleanup",
    "conditions",
    "lastTransitionTime",
    "lastUpdateTime",
    "message",
    "phase",
    "reason",
    "requirementStatus"
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
public class ClusterServiceVersionStatus implements Editable<ClusterServiceVersionStatusBuilder>, KubernetesResource
{

    @JsonProperty("certsLastUpdated")
    private String certsLastUpdated;
    @JsonProperty("certsRotateAt")
    private String certsRotateAt;
    @JsonProperty("cleanup")
    private CleanupStatus cleanup;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ClusterServiceVersionCondition> conditions = new ArrayList<>();
    @JsonProperty("lastTransitionTime")
    private String lastTransitionTime;
    @JsonProperty("lastUpdateTime")
    private String lastUpdateTime;
    @JsonProperty("message")
    private String message;
    @JsonProperty("phase")
    private String phase;
    @JsonProperty("reason")
    private String reason;
    @JsonProperty("requirementStatus")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RequirementStatus> requirementStatus = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterServiceVersionStatus() {
    }

    public ClusterServiceVersionStatus(String certsLastUpdated, String certsRotateAt, CleanupStatus cleanup, List<ClusterServiceVersionCondition> conditions, String lastTransitionTime, String lastUpdateTime, String message, String phase, String reason, List<RequirementStatus> requirementStatus) {
        super();
        this.certsLastUpdated = certsLastUpdated;
        this.certsRotateAt = certsRotateAt;
        this.cleanup = cleanup;
        this.conditions = conditions;
        this.lastTransitionTime = lastTransitionTime;
        this.lastUpdateTime = lastUpdateTime;
        this.message = message;
        this.phase = phase;
        this.reason = reason;
        this.requirementStatus = requirementStatus;
    }

    /**
     * ClusterServiceVersionStatus represents information about the status of a CSV. Status may trail the actual state of a system.
     */
    @JsonProperty("certsLastUpdated")
    public String getCertsLastUpdated() {
        return certsLastUpdated;
    }

    /**
     * ClusterServiceVersionStatus represents information about the status of a CSV. Status may trail the actual state of a system.
     */
    @JsonProperty("certsLastUpdated")
    public void setCertsLastUpdated(String certsLastUpdated) {
        this.certsLastUpdated = certsLastUpdated;
    }

    /**
     * ClusterServiceVersionStatus represents information about the status of a CSV. Status may trail the actual state of a system.
     */
    @JsonProperty("certsRotateAt")
    public String getCertsRotateAt() {
        return certsRotateAt;
    }

    /**
     * ClusterServiceVersionStatus represents information about the status of a CSV. Status may trail the actual state of a system.
     */
    @JsonProperty("certsRotateAt")
    public void setCertsRotateAt(String certsRotateAt) {
        this.certsRotateAt = certsRotateAt;
    }

    /**
     * ClusterServiceVersionStatus represents information about the status of a CSV. Status may trail the actual state of a system.
     */
    @JsonProperty("cleanup")
    public CleanupStatus getCleanup() {
        return cleanup;
    }

    /**
     * ClusterServiceVersionStatus represents information about the status of a CSV. Status may trail the actual state of a system.
     */
    @JsonProperty("cleanup")
    public void setCleanup(CleanupStatus cleanup) {
        this.cleanup = cleanup;
    }

    /**
     * List of conditions, a history of state transitions
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ClusterServiceVersionCondition> getConditions() {
        return conditions;
    }

    /**
     * List of conditions, a history of state transitions
     */
    @JsonProperty("conditions")
    public void setConditions(List<ClusterServiceVersionCondition> conditions) {
        this.conditions = conditions;
    }

    /**
     * ClusterServiceVersionStatus represents information about the status of a CSV. Status may trail the actual state of a system.
     */
    @JsonProperty("lastTransitionTime")
    public String getLastTransitionTime() {
        return lastTransitionTime;
    }

    /**
     * ClusterServiceVersionStatus represents information about the status of a CSV. Status may trail the actual state of a system.
     */
    @JsonProperty("lastTransitionTime")
    public void setLastTransitionTime(String lastTransitionTime) {
        this.lastTransitionTime = lastTransitionTime;
    }

    /**
     * ClusterServiceVersionStatus represents information about the status of a CSV. Status may trail the actual state of a system.
     */
    @JsonProperty("lastUpdateTime")
    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * ClusterServiceVersionStatus represents information about the status of a CSV. Status may trail the actual state of a system.
     */
    @JsonProperty("lastUpdateTime")
    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * A human readable message indicating details about why the ClusterServiceVersion is in this condition.
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * A human readable message indicating details about why the ClusterServiceVersion is in this condition.
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Current condition of the ClusterServiceVersion
     */
    @JsonProperty("phase")
    public String getPhase() {
        return phase;
    }

    /**
     * Current condition of the ClusterServiceVersion
     */
    @JsonProperty("phase")
    public void setPhase(String phase) {
        this.phase = phase;
    }

    /**
     * A brief CamelCase message indicating details about why the ClusterServiceVersion is in this state. e.g. 'RequirementsNotMet'
     */
    @JsonProperty("reason")
    public String getReason() {
        return reason;
    }

    /**
     * A brief CamelCase message indicating details about why the ClusterServiceVersion is in this state. e.g. 'RequirementsNotMet'
     */
    @JsonProperty("reason")
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * The status of each requirement for this CSV
     */
    @JsonProperty("requirementStatus")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RequirementStatus> getRequirementStatus() {
        return requirementStatus;
    }

    /**
     * The status of each requirement for this CSV
     */
    @JsonProperty("requirementStatus")
    public void setRequirementStatus(List<RequirementStatus> requirementStatus) {
        this.requirementStatus = requirementStatus;
    }

    @JsonIgnore
    public ClusterServiceVersionStatusBuilder edit() {
        return new ClusterServiceVersionStatusBuilder(this);
    }

    @JsonIgnore
    public ClusterServiceVersionStatusBuilder toBuilder() {
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
        if (!(o instanceof ClusterServiceVersionStatus)) {
            return false;
        }
        ClusterServiceVersionStatus other = (ClusterServiceVersionStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$certsLastUpdated = this.getCertsLastUpdated();
        Object other$certsLastUpdated = other.getCertsLastUpdated();
        if (this$certsLastUpdated == null ? other$certsLastUpdated != null : !this$certsLastUpdated.equals(other$certsLastUpdated)) {
            return false;
        }
        Object this$certsRotateAt = this.getCertsRotateAt();
        Object other$certsRotateAt = other.getCertsRotateAt();
        if (this$certsRotateAt == null ? other$certsRotateAt != null : !this$certsRotateAt.equals(other$certsRotateAt)) {
            return false;
        }
        Object this$cleanup = this.getCleanup();
        Object other$cleanup = other.getCleanup();
        if (this$cleanup == null ? other$cleanup != null : !this$cleanup.equals(other$cleanup)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$lastTransitionTime = this.getLastTransitionTime();
        Object other$lastTransitionTime = other.getLastTransitionTime();
        if (this$lastTransitionTime == null ? other$lastTransitionTime != null : !this$lastTransitionTime.equals(other$lastTransitionTime)) {
            return false;
        }
        Object this$lastUpdateTime = this.getLastUpdateTime();
        Object other$lastUpdateTime = other.getLastUpdateTime();
        if (this$lastUpdateTime == null ? other$lastUpdateTime != null : !this$lastUpdateTime.equals(other$lastUpdateTime)) {
            return false;
        }
        Object this$message = this.getMessage();
        Object other$message = other.getMessage();
        if (this$message == null ? other$message != null : !this$message.equals(other$message)) {
            return false;
        }
        Object this$phase = this.getPhase();
        Object other$phase = other.getPhase();
        if (this$phase == null ? other$phase != null : !this$phase.equals(other$phase)) {
            return false;
        }
        Object this$reason = this.getReason();
        Object other$reason = other.getReason();
        if (this$reason == null ? other$reason != null : !this$reason.equals(other$reason)) {
            return false;
        }
        Object this$requirementStatus = this.getRequirementStatus();
        Object other$requirementStatus = other.getRequirementStatus();
        if (this$requirementStatus == null ? other$requirementStatus != null : !this$requirementStatus.equals(other$requirementStatus)) {
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
        return other instanceof ClusterServiceVersionStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $certsLastUpdated = this.getCertsLastUpdated();
        result = result * prime + ($certsLastUpdated == null ? 43 : $certsLastUpdated.hashCode());
        Object $certsRotateAt = this.getCertsRotateAt();
        result = result * prime + ($certsRotateAt == null ? 43 : $certsRotateAt.hashCode());
        Object $cleanup = this.getCleanup();
        result = result * prime + ($cleanup == null ? 43 : $cleanup.hashCode());
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $lastTransitionTime = this.getLastTransitionTime();
        result = result * prime + ($lastTransitionTime == null ? 43 : $lastTransitionTime.hashCode());
        Object $lastUpdateTime = this.getLastUpdateTime();
        result = result * prime + ($lastUpdateTime == null ? 43 : $lastUpdateTime.hashCode());
        Object $message = this.getMessage();
        result = result * prime + ($message == null ? 43 : $message.hashCode());
        Object $phase = this.getPhase();
        result = result * prime + ($phase == null ? 43 : $phase.hashCode());
        Object $reason = this.getReason();
        result = result * prime + ($reason == null ? 43 : $reason.hashCode());
        Object $requirementStatus = this.getRequirementStatus();
        result = result * prime + ($requirementStatus == null ? 43 : $requirementStatus.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ClusterServiceVersionStatus(" + "certsLastUpdated=" + this.getCertsLastUpdated() + ", certsRotateAt=" + this.getCertsRotateAt() + ", cleanup=" + this.getCleanup() + ", conditions=" + this.getConditions() + ", lastTransitionTime=" + this.getLastTransitionTime() + ", lastUpdateTime=" + this.getLastUpdateTime() + ", message=" + this.getMessage() + ", phase=" + this.getPhase() + ", reason=" + this.getReason() + ", requirementStatus=" + this.getRequirementStatus() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
