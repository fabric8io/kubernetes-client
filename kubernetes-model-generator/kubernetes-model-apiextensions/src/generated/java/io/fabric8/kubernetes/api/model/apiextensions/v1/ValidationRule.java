
package io.fabric8.kubernetes.api.model.apiextensions.v1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
@ToString
@EqualsAndHashCode
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
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ValidationRule implements Editable<ValidationRuleBuilder> , KubernetesResource
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
     * 
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

}
