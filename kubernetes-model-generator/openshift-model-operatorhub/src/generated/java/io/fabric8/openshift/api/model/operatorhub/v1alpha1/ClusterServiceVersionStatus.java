
package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
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
@ToString
@EqualsAndHashCode
@Setter
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
public class ClusterServiceVersionStatus implements KubernetesResource
{

    @JsonProperty("certsLastUpdated")
    private String certsLastUpdated;
    @JsonProperty("certsRotateAt")
    private String certsRotateAt;
    @JsonProperty("cleanup")
    private CleanupStatus cleanup;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ClusterServiceVersionCondition> conditions = new ArrayList<ClusterServiceVersionCondition>();
    @JsonProperty("lastTransitionTime")
    private String lastTransitionTime;
    @JsonProperty("lastUpdateTime")
    private String lastUpdateTime;
    @JsonProperty("message")
    private java.lang.String message;
    @JsonProperty("phase")
    private java.lang.String phase;
    @JsonProperty("reason")
    private java.lang.String reason;
    @JsonProperty("requirementStatus")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RequirementStatus> requirementStatus = new ArrayList<RequirementStatus>();
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ClusterServiceVersionStatus() {
    }

    public ClusterServiceVersionStatus(String certsLastUpdated, String certsRotateAt, CleanupStatus cleanup, List<ClusterServiceVersionCondition> conditions, String lastTransitionTime, String lastUpdateTime, java.lang.String message, java.lang.String phase, java.lang.String reason, List<RequirementStatus> requirementStatus) {
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

    @JsonProperty("certsLastUpdated")
    public String getCertsLastUpdated() {
        return certsLastUpdated;
    }

    @JsonProperty("certsLastUpdated")
    public void setCertsLastUpdated(String certsLastUpdated) {
        this.certsLastUpdated = certsLastUpdated;
    }

    @JsonProperty("certsRotateAt")
    public String getCertsRotateAt() {
        return certsRotateAt;
    }

    @JsonProperty("certsRotateAt")
    public void setCertsRotateAt(String certsRotateAt) {
        this.certsRotateAt = certsRotateAt;
    }

    @JsonProperty("cleanup")
    public CleanupStatus getCleanup() {
        return cleanup;
    }

    @JsonProperty("cleanup")
    public void setCleanup(CleanupStatus cleanup) {
        this.cleanup = cleanup;
    }

    @JsonProperty("conditions")
    public List<ClusterServiceVersionCondition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<ClusterServiceVersionCondition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("lastTransitionTime")
    public String getLastTransitionTime() {
        return lastTransitionTime;
    }

    @JsonProperty("lastTransitionTime")
    public void setLastTransitionTime(String lastTransitionTime) {
        this.lastTransitionTime = lastTransitionTime;
    }

    @JsonProperty("lastUpdateTime")
    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    @JsonProperty("lastUpdateTime")
    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @JsonProperty("message")
    public java.lang.String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(java.lang.String message) {
        this.message = message;
    }

    @JsonProperty("phase")
    public java.lang.String getPhase() {
        return phase;
    }

    @JsonProperty("phase")
    public void setPhase(java.lang.String phase) {
        this.phase = phase;
    }

    @JsonProperty("reason")
    public java.lang.String getReason() {
        return reason;
    }

    @JsonProperty("reason")
    public void setReason(java.lang.String reason) {
        this.reason = reason;
    }

    @JsonProperty("requirementStatus")
    public List<RequirementStatus> getRequirementStatus() {
        return requirementStatus;
    }

    @JsonProperty("requirementStatus")
    public void setRequirementStatus(List<RequirementStatus> requirementStatus) {
        this.requirementStatus = requirementStatus;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
