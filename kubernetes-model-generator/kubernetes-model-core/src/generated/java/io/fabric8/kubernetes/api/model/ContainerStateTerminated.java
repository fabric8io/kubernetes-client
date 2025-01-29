
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
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
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
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ContainerStateTerminated implements Editable<ContainerStateTerminatedBuilder>, KubernetesResource
{

    @JsonProperty("containerID")
    private String containerID;
    @JsonProperty("exitCode")
    private Integer exitCode;
    @JsonProperty("finishedAt")
    private String finishedAt;
    @JsonProperty("message")
    private String message;
    @JsonProperty("reason")
    private String reason;
    @JsonProperty("signal")
    private Integer signal;
    @JsonProperty("startedAt")
    private String startedAt;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ContainerStateTerminated() {
    }

    public ContainerStateTerminated(String containerID, Integer exitCode, String finishedAt, String message, String reason, Integer signal, String startedAt) {
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
    public String getContainerID() {
        return containerID;
    }

    @JsonProperty("containerID")
    public void setContainerID(String containerID) {
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
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty("reason")
    public String getReason() {
        return reason;
    }

    @JsonProperty("reason")
    public void setReason(String reason) {
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

    @JsonIgnore
    public ContainerStateTerminatedBuilder edit() {
        return new ContainerStateTerminatedBuilder(this);
    }

    @JsonIgnore
    public ContainerStateTerminatedBuilder toBuilder() {
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
