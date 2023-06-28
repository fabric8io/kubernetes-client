
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
    "containerID",
    "exitCode",
    "finishedAt",
    "message",
    "reason",
    "signal",
    "startedAt"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("jsonschema2pojo")
public class ContainerStateTerminated implements KubernetesResource
{

    @JsonProperty("containerID")
    private java.lang.String containerID;
    @JsonProperty("exitCode")
    private Integer exitCode;
    @JsonProperty("finishedAt")
    private String finishedAt;
    @JsonProperty("message")
    private java.lang.String message;
    @JsonProperty("reason")
    private java.lang.String reason;
    @JsonProperty("signal")
    private Integer signal;
    @JsonProperty("startedAt")
    private String startedAt;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ContainerStateTerminated() {
    }

    public ContainerStateTerminated(java.lang.String containerID, Integer exitCode, String finishedAt, java.lang.String message, java.lang.String reason, Integer signal, String startedAt) {
        super();
        this.containerID = containerID;
        this.exitCode = exitCode;
        this.finishedAt = finishedAt;
        this.message = message;
        this.reason = reason;
        this.signal = signal;
        this.startedAt = startedAt;
    }

    @JsonProperty("containerID")
    public java.lang.String getContainerID() {
        return containerID;
    }

    @JsonProperty("containerID")
    public void setContainerID(java.lang.String containerID) {
        this.containerID = containerID;
    }

    @JsonProperty("exitCode")
    public Integer getExitCode() {
        return exitCode;
    }

    @JsonProperty("exitCode")
    public void setExitCode(Integer exitCode) {
        this.exitCode = exitCode;
    }

    @JsonProperty("finishedAt")
    public String getFinishedAt() {
        return finishedAt;
    }

    @JsonProperty("finishedAt")
    public void setFinishedAt(String finishedAt) {
        this.finishedAt = finishedAt;
    }

    @JsonProperty("message")
    public java.lang.String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(java.lang.String message) {
        this.message = message;
    }

    @JsonProperty("reason")
    public java.lang.String getReason() {
        return reason;
    }

    @JsonProperty("reason")
    public void setReason(java.lang.String reason) {
        this.reason = reason;
    }

    @JsonProperty("signal")
    public Integer getSignal() {
        return signal;
    }

    @JsonProperty("signal")
    public void setSignal(Integer signal) {
        this.signal = signal;
    }

    @JsonProperty("startedAt")
    public String getStartedAt() {
        return startedAt;
    }

    @JsonProperty("startedAt")
    public void setStartedAt(String startedAt) {
        this.startedAt = startedAt;
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
