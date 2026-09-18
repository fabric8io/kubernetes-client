
package io.fabric8.kubernetes.api.model.authorization.v1;

import java.util.LinkedHashMap;
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
 * SubjectAccessReviewStatus
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "allowed",
    "denied",
    "evaluationError",
    "reason"
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
public class SubjectAccessReviewStatus implements Editable<SubjectAccessReviewStatusBuilder>, KubernetesResource
{

    @JsonProperty("allowed")
    private Boolean allowed;
    @JsonProperty("denied")
    private Boolean denied;
    @JsonProperty("evaluationError")
    private String evaluationError;
    @JsonProperty("reason")
    private String reason;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SubjectAccessReviewStatus() {
    }

    public SubjectAccessReviewStatus(Boolean allowed, Boolean denied, String evaluationError, String reason) {
        super();
        this.allowed = allowed;
        this.denied = denied;
        this.evaluationError = evaluationError;
        this.reason = reason;
    }

    /**
     * allowed is required. True if the action would be allowed, false otherwise.
     */
    @JsonProperty("allowed")
    public Boolean getAllowed() {
        return allowed;
    }

    /**
     * allowed is required. True if the action would be allowed, false otherwise.
     */
    @JsonProperty("allowed")
    public void setAllowed(Boolean allowed) {
        this.allowed = allowed;
    }

    /**
     * denied is optional. True if the action would be denied, otherwise false. If both allowed is false and denied is false, then the authorizer has no opinion on whether to authorize the action. Denied may not be true if Allowed is true.
     */
    @JsonProperty("denied")
    public Boolean getDenied() {
        return denied;
    }

    /**
     * denied is optional. True if the action would be denied, otherwise false. If both allowed is false and denied is false, then the authorizer has no opinion on whether to authorize the action. Denied may not be true if Allowed is true.
     */
    @JsonProperty("denied")
    public void setDenied(Boolean denied) {
        this.denied = denied;
    }

    /**
     * evaluationError is an indication that some error occurred during the authorization check. It is entirely possible to get an error and be able to continue determine authorization status in spite of it. For instance, RBAC can be missing a role, but enough roles are still present and bound to reason about the request.
     */
    @JsonProperty("evaluationError")
    public String getEvaluationError() {
        return evaluationError;
    }

    /**
     * evaluationError is an indication that some error occurred during the authorization check. It is entirely possible to get an error and be able to continue determine authorization status in spite of it. For instance, RBAC can be missing a role, but enough roles are still present and bound to reason about the request.
     */
    @JsonProperty("evaluationError")
    public void setEvaluationError(String evaluationError) {
        this.evaluationError = evaluationError;
    }

    /**
     * reason is optional.  It indicates why a request was allowed or denied.
     */
    @JsonProperty("reason")
    public String getReason() {
        return reason;
    }

    /**
     * reason is optional.  It indicates why a request was allowed or denied.
     */
    @JsonProperty("reason")
    public void setReason(String reason) {
        this.reason = reason;
    }

    @JsonIgnore
    public SubjectAccessReviewStatusBuilder edit() {
        return new SubjectAccessReviewStatusBuilder(this);
    }

    @JsonIgnore
    public SubjectAccessReviewStatusBuilder toBuilder() {
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
        if (!(o instanceof SubjectAccessReviewStatus)) {
            return false;
        }
        SubjectAccessReviewStatus other = (SubjectAccessReviewStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$allowed = this.getAllowed();
        Object other$allowed = other.getAllowed();
        if (this$allowed == null ? other$allowed != null : !this$allowed.equals(other$allowed)) {
            return false;
        }
        Object this$denied = this.getDenied();
        Object other$denied = other.getDenied();
        if (this$denied == null ? other$denied != null : !this$denied.equals(other$denied)) {
            return false;
        }
        Object this$evaluationError = this.getEvaluationError();
        Object other$evaluationError = other.getEvaluationError();
        if (this$evaluationError == null ? other$evaluationError != null : !this$evaluationError.equals(other$evaluationError)) {
            return false;
        }
        Object this$reason = this.getReason();
        Object other$reason = other.getReason();
        if (this$reason == null ? other$reason != null : !this$reason.equals(other$reason)) {
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
        return other instanceof SubjectAccessReviewStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $allowed = this.getAllowed();
        result = result * prime + ($allowed == null ? 43 : $allowed.hashCode());
        Object $denied = this.getDenied();
        result = result * prime + ($denied == null ? 43 : $denied.hashCode());
        Object $evaluationError = this.getEvaluationError();
        result = result * prime + ($evaluationError == null ? 43 : $evaluationError.hashCode());
        Object $reason = this.getReason();
        result = result * prime + ($reason == null ? 43 : $reason.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "SubjectAccessReviewStatus(" + "allowed=" + this.getAllowed() + ", denied=" + this.getDenied() + ", evaluationError=" + this.getEvaluationError() + ", reason=" + this.getReason() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
