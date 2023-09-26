
package io.fabric8.kubernetes.api.model;

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
import io.sundr.builder.annotations.Buildable;
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
    "lastPhaseTransitionTime",
    "message",
    "phase",
    "reason"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("jsonschema2pojo")
public class PersistentVolumeStatus implements Editable<PersistentVolumeStatusBuilder> , KubernetesResource
{

    @JsonProperty("lastPhaseTransitionTime")
    private String lastPhaseTransitionTime;
    @JsonProperty("message")
    private java.lang.String message;
    @JsonProperty("phase")
    private java.lang.String phase;
    @JsonProperty("reason")
    private java.lang.String reason;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PersistentVolumeStatus() {
    }

    public PersistentVolumeStatus(String lastPhaseTransitionTime, java.lang.String message, java.lang.String phase, java.lang.String reason) {
        super();
        this.lastPhaseTransitionTime = lastPhaseTransitionTime;
        this.message = message;
        this.phase = phase;
        this.reason = reason;
    }

    @JsonProperty("lastPhaseTransitionTime")
    public String getLastPhaseTransitionTime() {
        return lastPhaseTransitionTime;
    }

    @JsonProperty("lastPhaseTransitionTime")
    public void setLastPhaseTransitionTime(String lastPhaseTransitionTime) {
        this.lastPhaseTransitionTime = lastPhaseTransitionTime;
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

    @JsonIgnore
    public PersistentVolumeStatusBuilder edit() {
        return new PersistentVolumeStatusBuilder(this);
    }

    @JsonIgnore
    public PersistentVolumeStatusBuilder toBuilder() {
        return edit();
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
