
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

/**
 * PersistentVolumeStatus is the current status of a persistent volume.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "lastPhaseTransitionTime",
    "message",
    "phase",
    "reason"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class PersistentVolumeStatus implements Editable<PersistentVolumeStatusBuilder>, KubernetesResource
{

    @JsonProperty("lastPhaseTransitionTime")
    private String lastPhaseTransitionTime;
    @JsonProperty("message")
    private String message;
    @JsonProperty("phase")
    private String phase;
    @JsonProperty("reason")
    private String reason;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PersistentVolumeStatus() {
    }

    public PersistentVolumeStatus(String lastPhaseTransitionTime, String message, String phase, String reason) {
        super();
        this.lastPhaseTransitionTime = lastPhaseTransitionTime;
        this.message = message;
        this.phase = phase;
        this.reason = reason;
    }

    /**
     * PersistentVolumeStatus is the current status of a persistent volume.
     */
    @JsonProperty("lastPhaseTransitionTime")
    public String getLastPhaseTransitionTime() {
        return lastPhaseTransitionTime;
    }

    /**
     * PersistentVolumeStatus is the current status of a persistent volume.
     */
    @JsonProperty("lastPhaseTransitionTime")
    public void setLastPhaseTransitionTime(String lastPhaseTransitionTime) {
        this.lastPhaseTransitionTime = lastPhaseTransitionTime;
    }

    /**
     * message is a human-readable message indicating details about why the volume is in this state.
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * message is a human-readable message indicating details about why the volume is in this state.
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * phase indicates if a volume is available, bound to a claim, or released by a claim. More info: https://kubernetes.io/docs/concepts/storage/persistent-volumes#phase
     */
    @JsonProperty("phase")
    public String getPhase() {
        return phase;
    }

    /**
     * phase indicates if a volume is available, bound to a claim, or released by a claim. More info: https://kubernetes.io/docs/concepts/storage/persistent-volumes#phase
     */
    @JsonProperty("phase")
    public void setPhase(String phase) {
        this.phase = phase;
    }

    /**
     * reason is a brief CamelCase string that describes any failure and is meant for machine parsing and tidy display in the CLI.
     */
    @JsonProperty("reason")
    public String getReason() {
        return reason;
    }

    /**
     * reason is a brief CamelCase string that describes any failure and is meant for machine parsing and tidy display in the CLI.
     */
    @JsonProperty("reason")
    public void setReason(String reason) {
        this.reason = reason;
    }

    @JsonIgnore
    public PersistentVolumeStatusBuilder edit() {
        return new PersistentVolumeStatusBuilder(this);
    }

    @JsonIgnore
    public PersistentVolumeStatusBuilder toBuilder() {
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
        if (!(o instanceof PersistentVolumeStatus)) {
            return false;
        }
        PersistentVolumeStatus other = (PersistentVolumeStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$lastPhaseTransitionTime = this.getLastPhaseTransitionTime();
        Object other$lastPhaseTransitionTime = other.getLastPhaseTransitionTime();
        if (this$lastPhaseTransitionTime == null ? other$lastPhaseTransitionTime != null : !this$lastPhaseTransitionTime.equals(other$lastPhaseTransitionTime)) {
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
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof PersistentVolumeStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $lastPhaseTransitionTime = this.getLastPhaseTransitionTime();
        result = result * prime + ($lastPhaseTransitionTime == null ? 43 : $lastPhaseTransitionTime.hashCode());
        Object $message = this.getMessage();
        result = result * prime + ($message == null ? 43 : $message.hashCode());
        Object $phase = this.getPhase();
        result = result * prime + ($phase == null ? 43 : $phase.hashCode());
        Object $reason = this.getReason();
        result = result * prime + ($reason == null ? 43 : $reason.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PersistentVolumeStatus(" + "lastPhaseTransitionTime=" + this.getLastPhaseTransitionTime() + ", message=" + this.getMessage() + ", phase=" + this.getPhase() + ", reason=" + this.getReason() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
