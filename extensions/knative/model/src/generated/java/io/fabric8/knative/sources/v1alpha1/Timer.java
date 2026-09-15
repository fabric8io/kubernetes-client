
package io.fabric8.knative.sources.v1alpha1;

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
    "contentType",
    "message",
    "period",
    "repeatCount"
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
public class Timer implements Editable<TimerBuilder>, KubernetesResource
{

    @JsonProperty("contentType")
    private String contentType;
    @JsonProperty("message")
    private String message;
    @JsonProperty("period")
    private Integer period;
    @JsonProperty("repeatCount")
    private Integer repeatCount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Timer() {
    }

    public Timer(String contentType, String message, Integer period, Integer repeatCount) {
        super();
        this.contentType = contentType;
        this.message = message;
        this.period = period;
        this.repeatCount = repeatCount;
    }

    /**
     * Message to generate
     */
    @JsonProperty("contentType")
    public String getContentType() {
        return contentType;
    }

    /**
     * Message to generate
     */
    @JsonProperty("contentType")
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    /**
     * Interval (in milliseconds) between producing messages
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * Interval (in milliseconds) between producing messages
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty("period")
    public Integer getPeriod() {
        return period;
    }

    @JsonProperty("period")
    public void setPeriod(Integer period) {
        this.period = period;
    }

    /**
     * Content type of generated message
     */
    @JsonProperty("repeatCount")
    public Integer getRepeatCount() {
        return repeatCount;
    }

    /**
     * Content type of generated message
     */
    @JsonProperty("repeatCount")
    public void setRepeatCount(Integer repeatCount) {
        this.repeatCount = repeatCount;
    }

    @JsonIgnore
    public TimerBuilder edit() {
        return new TimerBuilder(this);
    }

    @JsonIgnore
    public TimerBuilder toBuilder() {
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
        if (!(o instanceof Timer)) {
            return false;
        }
        Timer other = (Timer) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$contentType = this.getContentType();
        Object other$contentType = other.getContentType();
        if (this$contentType == null ? other$contentType != null : !this$contentType.equals(other$contentType)) {
            return false;
        }
        Object this$message = this.getMessage();
        Object other$message = other.getMessage();
        if (this$message == null ? other$message != null : !this$message.equals(other$message)) {
            return false;
        }
        Object this$period = this.getPeriod();
        Object other$period = other.getPeriod();
        if (this$period == null ? other$period != null : !this$period.equals(other$period)) {
            return false;
        }
        Object this$repeatCount = this.getRepeatCount();
        Object other$repeatCount = other.getRepeatCount();
        if (this$repeatCount == null ? other$repeatCount != null : !this$repeatCount.equals(other$repeatCount)) {
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
        return other instanceof Timer;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $contentType = this.getContentType();
        result = result * prime + ($contentType == null ? 43 : $contentType.hashCode());
        Object $message = this.getMessage();
        result = result * prime + ($message == null ? 43 : $message.hashCode());
        Object $period = this.getPeriod();
        result = result * prime + ($period == null ? 43 : $period.hashCode());
        Object $repeatCount = this.getRepeatCount();
        result = result * prime + ($repeatCount == null ? 43 : $repeatCount.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Timer(" + "contentType=" + this.getContentType() + ", message=" + this.getMessage() + ", period=" + this.getPeriod() + ", repeatCount=" + this.getRepeatCount() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
