
package io.fabric8.kubernetes.api.model.flowcontrol.v1beta1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * PriorityLevelConfigurationCondition defines the condition of priority level.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "lastTransitionTime",
    "message",
    "reason",
    "status",
    "type"
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
public class PriorityLevelConfigurationCondition implements Editable<PriorityLevelConfigurationConditionBuilder>, KubernetesResource
{

    @JsonProperty("lastTransitionTime")
    private String lastTransitionTime;
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
    public PriorityLevelConfigurationCondition() {
    }

    public PriorityLevelConfigurationCondition(String lastTransitionTime, String message, String reason, String status, String type) {
        super();
        this.lastTransitionTime = lastTransitionTime;
        this.message = message;
        this.reason = reason;
        this.status = status;
        this.type = type;
    }

    /**
     * PriorityLevelConfigurationCondition defines the condition of priority level.
     */
    @JsonProperty("lastTransitionTime")
    public String getLastTransitionTime() {
        return lastTransitionTime;
    }

    /**
     * PriorityLevelConfigurationCondition defines the condition of priority level.
     */
    @JsonProperty("lastTransitionTime")
    public void setLastTransitionTime(String lastTransitionTime) {
        this.lastTransitionTime = lastTransitionTime;
    }

    /**
     * `message` is a human-readable message indicating details about last transition.
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * `message` is a human-readable message indicating details about last transition.
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * `reason` is a unique, one-word, CamelCase reason for the condition's last transition.
     */
    @JsonProperty("reason")
    public String getReason() {
        return reason;
    }

    /**
     * `reason` is a unique, one-word, CamelCase reason for the condition's last transition.
     */
    @JsonProperty("reason")
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * `status` is the status of the condition. Can be True, False, Unknown. Required.
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * `status` is the status of the condition. Can be True, False, Unknown. Required.
     */
    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * `type` is the type of the condition. Required.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * `type` is the type of the condition. Required.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public PriorityLevelConfigurationConditionBuilder edit() {
        return new PriorityLevelConfigurationConditionBuilder(this);
    }

    @JsonIgnore
    public PriorityLevelConfigurationConditionBuilder toBuilder() {
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

}
