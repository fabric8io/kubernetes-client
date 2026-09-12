
package io.fabric8.kubernetes.api.model.certificates.v1beta1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "lastTransitionTime",
    "lastUpdateTime",
    "message",
    "reason",
    "status",
    "type"
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
public class CertificateSigningRequestCondition implements Editable<CertificateSigningRequestConditionBuilder>, KubernetesResource
{

    @JsonProperty("lastTransitionTime")
    private String lastTransitionTime;
    @JsonProperty("lastUpdateTime")
    private String lastUpdateTime;
    @JsonProperty("message")
    private String message;
    @JsonProperty("reason")
    private String reason;
    @JsonProperty("status")
    private String status;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CertificateSigningRequestCondition() {
    }

    public CertificateSigningRequestCondition(String lastTransitionTime, String lastUpdateTime, String message, String reason, String status, String type) {
        super();
        this.lastTransitionTime = lastTransitionTime;
        this.lastUpdateTime = lastUpdateTime;
        this.message = message;
        this.reason = reason;
        this.status = status;
        this.type = type;
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

    /**
     * human readable message with details about the request state
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * human readable message with details about the request state
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * brief reason for the request state
     */
    @JsonProperty("reason")
    public String getReason() {
        return reason;
    }

    /**
     * brief reason for the request state
     */
    @JsonProperty("reason")
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * Status of the condition, one of True, False, Unknown. Approved, Denied, and Failed conditions may not be "False" or "Unknown". Defaults to "True". If unset, should be treated as "True".
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * Status of the condition, one of True, False, Unknown. Approved, Denied, and Failed conditions may not be "False" or "Unknown". Defaults to "True". If unset, should be treated as "True".
     */
    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * type of the condition. Known conditions include "Approved", "Denied", and "Failed".
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type of the condition. Known conditions include "Approved", "Denied", and "Failed".
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public CertificateSigningRequestConditionBuilder edit() {
        return new CertificateSigningRequestConditionBuilder(this);
    }

    @JsonIgnore
    public CertificateSigningRequestConditionBuilder toBuilder() {
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
        if (!(o instanceof CertificateSigningRequestCondition)) {
            return false;
        }
        CertificateSigningRequestCondition other = (CertificateSigningRequestCondition) o;
        if (!other.canEqual(this)) {
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
        Object this$reason = this.getReason();
        Object other$reason = other.getReason();
        if (this$reason == null ? other$reason != null : !this$reason.equals(other$reason)) {
            return false;
        }
        Object this$status = this.getStatus();
        Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
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
        return other instanceof CertificateSigningRequestCondition;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $lastTransitionTime = this.getLastTransitionTime();
        result = result * prime + ($lastTransitionTime == null ? 43 : $lastTransitionTime.hashCode());
        Object $lastUpdateTime = this.getLastUpdateTime();
        result = result * prime + ($lastUpdateTime == null ? 43 : $lastUpdateTime.hashCode());
        Object $message = this.getMessage();
        result = result * prime + ($message == null ? 43 : $message.hashCode());
        Object $reason = this.getReason();
        result = result * prime + ($reason == null ? 43 : $reason.hashCode());
        Object $status = this.getStatus();
        result = result * prime + ($status == null ? 43 : $status.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "CertificateSigningRequestCondition(" + "lastTransitionTime=" + this.getLastTransitionTime() + ", lastUpdateTime=" + this.getLastUpdateTime() + ", message=" + this.getMessage() + ", reason=" + this.getReason() + ", status=" + this.getStatus() + ", type=" + this.getType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
