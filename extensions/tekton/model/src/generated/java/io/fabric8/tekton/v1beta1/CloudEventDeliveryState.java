
package io.fabric8.tekton.v1beta1;

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
 * CloudEventDeliveryState reports the state of a cloud event to be sent.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "condition",
    "message",
    "retryCount",
    "sentAt"
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
public class CloudEventDeliveryState implements Editable<CloudEventDeliveryStateBuilder>, KubernetesResource
{

    @JsonProperty("condition")
    private String condition;
    @JsonProperty("message")
    private String message;
    @JsonProperty("retryCount")
    private Integer retryCount;
    @JsonProperty("sentAt")
    private String sentAt;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CloudEventDeliveryState() {
    }

    public CloudEventDeliveryState(String condition, String message, Integer retryCount, String sentAt) {
        super();
        this.condition = condition;
        this.message = message;
        this.retryCount = retryCount;
        this.sentAt = sentAt;
    }

    /**
     * Current status
     */
    @JsonProperty("condition")
    public String getCondition() {
        return condition;
    }

    /**
     * Current status
     */
    @JsonProperty("condition")
    public void setCondition(String condition) {
        this.condition = condition;
    }

    /**
     * Error is the text of error (if any)
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * Error is the text of error (if any)
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * RetryCount is the number of attempts of sending the cloud event
     */
    @JsonProperty("retryCount")
    public Integer getRetryCount() {
        return retryCount;
    }

    /**
     * RetryCount is the number of attempts of sending the cloud event
     */
    @JsonProperty("retryCount")
    public void setRetryCount(Integer retryCount) {
        this.retryCount = retryCount;
    }

    /**
     * CloudEventDeliveryState reports the state of a cloud event to be sent.
     */
    @JsonProperty("sentAt")
    public String getSentAt() {
        return sentAt;
    }

    /**
     * CloudEventDeliveryState reports the state of a cloud event to be sent.
     */
    @JsonProperty("sentAt")
    public void setSentAt(String sentAt) {
        this.sentAt = sentAt;
    }

    @JsonIgnore
    public CloudEventDeliveryStateBuilder edit() {
        return new CloudEventDeliveryStateBuilder(this);
    }

    @JsonIgnore
    public CloudEventDeliveryStateBuilder toBuilder() {
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
        if (!(o instanceof CloudEventDeliveryState)) {
            return false;
        }
        CloudEventDeliveryState other = (CloudEventDeliveryState) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$condition = this.getCondition();
        Object other$condition = other.getCondition();
        if (this$condition == null ? other$condition != null : !this$condition.equals(other$condition)) {
            return false;
        }
        Object this$message = this.getMessage();
        Object other$message = other.getMessage();
        if (this$message == null ? other$message != null : !this$message.equals(other$message)) {
            return false;
        }
        Object this$retryCount = this.getRetryCount();
        Object other$retryCount = other.getRetryCount();
        if (this$retryCount == null ? other$retryCount != null : !this$retryCount.equals(other$retryCount)) {
            return false;
        }
        Object this$sentAt = this.getSentAt();
        Object other$sentAt = other.getSentAt();
        if (this$sentAt == null ? other$sentAt != null : !this$sentAt.equals(other$sentAt)) {
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
        return other instanceof CloudEventDeliveryState;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $condition = this.getCondition();
        result = result * prime + ($condition == null ? 43 : $condition.hashCode());
        Object $message = this.getMessage();
        result = result * prime + ($message == null ? 43 : $message.hashCode());
        Object $retryCount = this.getRetryCount();
        result = result * prime + ($retryCount == null ? 43 : $retryCount.hashCode());
        Object $sentAt = this.getSentAt();
        result = result * prime + ($sentAt == null ? 43 : $sentAt.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "CloudEventDeliveryState(" + "condition=" + this.getCondition() + ", message=" + this.getMessage() + ", retryCount=" + this.getRetryCount() + ", sentAt=" + this.getSentAt() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
