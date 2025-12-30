
package io.fabric8.kubernetes.api.model;

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
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * PodCondition contains details for the current condition of this pod.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "lastProbeTime",
    "lastTransitionTime",
    "message",
    "observedGeneration",
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
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class PodCondition implements Editable<PodConditionBuilder>, KubernetesResource
{

    @JsonProperty("lastProbeTime")
    private String lastProbeTime;
    @JsonProperty("lastTransitionTime")
    private String lastTransitionTime;
    @JsonProperty("message")
    private String message;
    @JsonProperty("observedGeneration")
    private Long observedGeneration;
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
    public PodCondition() {
    }

    public PodCondition(String lastProbeTime, String lastTransitionTime, String message, Long observedGeneration, String reason, String status, String type) {
        super();
        this.lastProbeTime = lastProbeTime;
        this.lastTransitionTime = lastTransitionTime;
        this.message = message;
        this.observedGeneration = observedGeneration;
        this.reason = reason;
        this.status = status;
        this.type = type;
    }

    /**
     * PodCondition contains details for the current condition of this pod.
     */
    @JsonProperty("lastProbeTime")
    public String getLastProbeTime() {
        return lastProbeTime;
    }

    /**
     * PodCondition contains details for the current condition of this pod.
     */
    @JsonProperty("lastProbeTime")
    public void setLastProbeTime(String lastProbeTime) {
        this.lastProbeTime = lastProbeTime;
    }

    /**
     * PodCondition contains details for the current condition of this pod.
     */
    @JsonProperty("lastTransitionTime")
    public String getLastTransitionTime() {
        return lastTransitionTime;
    }

    /**
     * PodCondition contains details for the current condition of this pod.
     */
    @JsonProperty("lastTransitionTime")
    public void setLastTransitionTime(String lastTransitionTime) {
        this.lastTransitionTime = lastTransitionTime;
    }

    /**
     * Human-readable message indicating details about last transition.
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * Human-readable message indicating details about last transition.
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * If set, this represents the .metadata.generation that the pod condition was set based upon. The PodObservedGenerationTracking feature gate must be enabled to use this field.
     */
    @JsonProperty("observedGeneration")
    public Long getObservedGeneration() {
        return observedGeneration;
    }

    /**
     * If set, this represents the .metadata.generation that the pod condition was set based upon. The PodObservedGenerationTracking feature gate must be enabled to use this field.
     */
    @JsonProperty("observedGeneration")
    public void setObservedGeneration(Long observedGeneration) {
        this.observedGeneration = observedGeneration;
    }

    /**
     * Unique, one-word, CamelCase reason for the condition's last transition.
     */
    @JsonProperty("reason")
    public String getReason() {
        return reason;
    }

    /**
     * Unique, one-word, CamelCase reason for the condition's last transition.
     */
    @JsonProperty("reason")
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * Status is the status of the condition. Can be True, False, Unknown. More info: https://kubernetes.io/docs/concepts/workloads/pods/pod-lifecycle#pod-conditions
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * Status is the status of the condition. Can be True, False, Unknown. More info: https://kubernetes.io/docs/concepts/workloads/pods/pod-lifecycle#pod-conditions
     */
    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Type is the type of the condition. More info: https://kubernetes.io/docs/concepts/workloads/pods/pod-lifecycle#pod-conditions
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Type is the type of the condition. More info: https://kubernetes.io/docs/concepts/workloads/pods/pod-lifecycle#pod-conditions
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public PodConditionBuilder edit() {
        return new PodConditionBuilder(this);
    }

    @JsonIgnore
    public PodConditionBuilder toBuilder() {
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
