
package io.fabric8.kubernetes.api.model.apiextensions.v1;

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
    "fieldPath",
    "message",
    "messageExpression",
    "optionalOldSelf",
    "reason",
    "rule"
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
public class ValidationRule implements Editable<ValidationRuleBuilder>, KubernetesResource
{

    @JsonProperty("fieldPath")
    private String fieldPath;
    @JsonProperty("message")
    private String message;
    @JsonProperty("messageExpression")
    private String messageExpression;
    @JsonProperty("optionalOldSelf")
    private Boolean optionalOldSelf;
    @JsonProperty("reason")
    private String reason;
    @JsonProperty("rule")
    private String rule;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ValidationRule() {
    }

    public ValidationRule(String fieldPath, String message, String messageExpression, Boolean optionalOldSelf, String reason, String rule) {
        super();
        this.fieldPath = fieldPath;
        this.message = message;
        this.messageExpression = messageExpression;
        this.optionalOldSelf = optionalOldSelf;
        this.reason = reason;
        this.rule = rule;
    }

    @JsonProperty("fieldPath")
    public String getFieldPath() {
        return fieldPath;
    }

    @JsonProperty("fieldPath")
    public void setFieldPath(String fieldPath) {
        this.fieldPath = fieldPath;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty("messageExpression")
    public String getMessageExpression() {
        return messageExpression;
    }

    @JsonProperty("messageExpression")
    public void setMessageExpression(String messageExpression) {
        this.messageExpression = messageExpression;
    }

    @JsonProperty("optionalOldSelf")
    public Boolean getOptionalOldSelf() {
        return optionalOldSelf;
    }

    @JsonProperty("optionalOldSelf")
    public void setOptionalOldSelf(Boolean optionalOldSelf) {
        this.optionalOldSelf = optionalOldSelf;
    }

    @JsonProperty("reason")
    public String getReason() {
        return reason;
    }

    @JsonProperty("reason")
    public void setReason(String reason) {
        this.reason = reason;
    }

    @JsonProperty("rule")
    public String getRule() {
        return rule;
    }

    @JsonProperty("rule")
    public void setRule(String rule) {
        this.rule = rule;
    }

    @JsonIgnore
    public ValidationRuleBuilder edit() {
        return new ValidationRuleBuilder(this);
    }

    @JsonIgnore
    public ValidationRuleBuilder toBuilder() {
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
        if (!(o instanceof ValidationRule)) {
            return false;
        }
        ValidationRule other = (ValidationRule) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$fieldPath = this.getFieldPath();
        Object other$fieldPath = other.getFieldPath();
        if (this$fieldPath == null ? other$fieldPath != null : !this$fieldPath.equals(other$fieldPath)) {
            return false;
        }
        Object this$message = this.getMessage();
        Object other$message = other.getMessage();
        if (this$message == null ? other$message != null : !this$message.equals(other$message)) {
            return false;
        }
        Object this$messageExpression = this.getMessageExpression();
        Object other$messageExpression = other.getMessageExpression();
        if (this$messageExpression == null ? other$messageExpression != null : !this$messageExpression.equals(other$messageExpression)) {
            return false;
        }
        Object this$optionalOldSelf = this.getOptionalOldSelf();
        Object other$optionalOldSelf = other.getOptionalOldSelf();
        if (this$optionalOldSelf == null ? other$optionalOldSelf != null : !this$optionalOldSelf.equals(other$optionalOldSelf)) {
            return false;
        }
        Object this$reason = this.getReason();
        Object other$reason = other.getReason();
        if (this$reason == null ? other$reason != null : !this$reason.equals(other$reason)) {
            return false;
        }
        Object this$rule = this.getRule();
        Object other$rule = other.getRule();
        if (this$rule == null ? other$rule != null : !this$rule.equals(other$rule)) {
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
        return other instanceof ValidationRule;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $fieldPath = this.getFieldPath();
        result = result * prime + ($fieldPath == null ? 43 : $fieldPath.hashCode());
        Object $message = this.getMessage();
        result = result * prime + ($message == null ? 43 : $message.hashCode());
        Object $messageExpression = this.getMessageExpression();
        result = result * prime + ($messageExpression == null ? 43 : $messageExpression.hashCode());
        Object $optionalOldSelf = this.getOptionalOldSelf();
        result = result * prime + ($optionalOldSelf == null ? 43 : $optionalOldSelf.hashCode());
        Object $reason = this.getReason();
        result = result * prime + ($reason == null ? 43 : $reason.hashCode());
        Object $rule = this.getRule();
        result = result * prime + ($rule == null ? 43 : $rule.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ValidationRule(" + "fieldPath=" + this.getFieldPath() + ", message=" + this.getMessage() + ", messageExpression=" + this.getMessageExpression() + ", optionalOldSelf=" + this.getOptionalOldSelf() + ", reason=" + this.getReason() + ", rule=" + this.getRule() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
