
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
 * ContainerStateTerminated is a terminated state of a container.
 */
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

    /**
     * Container's ID in the format '&lt;type&gt;://&lt;container_id&gt;'
     */
    @JsonProperty("containerID")
    public String getContainerID() {
        return containerID;
    }

    /**
     * Container's ID in the format '&lt;type&gt;://&lt;container_id&gt;'
     */
    @JsonProperty("containerID")
    public void setContainerID(String containerID) {
        this.containerID = containerID;
    }

    /**
     * Exit status from the last termination of the container
     */
    @JsonProperty("exitCode")
    public Integer getExitCode() {
        return exitCode;
    }

    /**
     * Exit status from the last termination of the container
     */
    @JsonProperty("exitCode")
    public void setExitCode(Integer exitCode) {
        this.exitCode = exitCode;
    }

    /**
     * ContainerStateTerminated is a terminated state of a container.
     */
    @JsonProperty("finishedAt")
    public String getFinishedAt() {
        return finishedAt;
    }

    /**
     * ContainerStateTerminated is a terminated state of a container.
     */
    @JsonProperty("finishedAt")
    public void setFinishedAt(String finishedAt) {
        this.finishedAt = finishedAt;
    }

    /**
     * Message regarding the last termination of the container
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * Message regarding the last termination of the container
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * (brief) reason from the last termination of the container
     */
    @JsonProperty("reason")
    public String getReason() {
        return reason;
    }

    /**
     * (brief) reason from the last termination of the container
     */
    @JsonProperty("reason")
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * Signal from the last termination of the container
     */
    @JsonProperty("signal")
    public Integer getSignal() {
        return signal;
    }

    /**
     * Signal from the last termination of the container
     */
    @JsonProperty("signal")
    public void setSignal(Integer signal) {
        this.signal = signal;
    }

    /**
     * ContainerStateTerminated is a terminated state of a container.
     */
    @JsonProperty("startedAt")
    public String getStartedAt() {
        return startedAt;
    }

    /**
     * ContainerStateTerminated is a terminated state of a container.
     */
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
        if (!(o instanceof ContainerStateTerminated)) {
            return false;
        }
        ContainerStateTerminated other = (ContainerStateTerminated) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$containerID = this.getContainerID();
        Object other$containerID = other.getContainerID();
        if (this$containerID == null ? other$containerID != null : !this$containerID.equals(other$containerID)) {
            return false;
        }
        Object this$exitCode = this.getExitCode();
        Object other$exitCode = other.getExitCode();
        if (this$exitCode == null ? other$exitCode != null : !this$exitCode.equals(other$exitCode)) {
            return false;
        }
        Object this$finishedAt = this.getFinishedAt();
        Object other$finishedAt = other.getFinishedAt();
        if (this$finishedAt == null ? other$finishedAt != null : !this$finishedAt.equals(other$finishedAt)) {
            return false;
        }
        Object this$message = this.getMessage();
        Object other$message = other.getMessage();
        if (this$message == null ? other$message != null : !this$message.equals(other$message)) {
            return false;
        }
        Object this$reason = this.getReason();
        Object other$reason = other.getReason();
        if (this$reason == null ? other$reason != null : !this$reason.equals(other$reason)) {
            return false;
        }
        Object this$signal = this.getSignal();
        Object other$signal = other.getSignal();
        if (this$signal == null ? other$signal != null : !this$signal.equals(other$signal)) {
            return false;
        }
        Object this$startedAt = this.getStartedAt();
        Object other$startedAt = other.getStartedAt();
        if (this$startedAt == null ? other$startedAt != null : !this$startedAt.equals(other$startedAt)) {
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
        return other instanceof ContainerStateTerminated;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $containerID = this.getContainerID();
        result = result * prime + ($containerID == null ? 43 : $containerID.hashCode());
        Object $exitCode = this.getExitCode();
        result = result * prime + ($exitCode == null ? 43 : $exitCode.hashCode());
        Object $finishedAt = this.getFinishedAt();
        result = result * prime + ($finishedAt == null ? 43 : $finishedAt.hashCode());
        Object $message = this.getMessage();
        result = result * prime + ($message == null ? 43 : $message.hashCode());
        Object $reason = this.getReason();
        result = result * prime + ($reason == null ? 43 : $reason.hashCode());
        Object $signal = this.getSignal();
        result = result * prime + ($signal == null ? 43 : $signal.hashCode());
        Object $startedAt = this.getStartedAt();
        result = result * prime + ($startedAt == null ? 43 : $startedAt.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ContainerStateTerminated(" + "containerID=" + this.getContainerID() + ", exitCode=" + this.getExitCode() + ", finishedAt=" + this.getFinishedAt() + ", message=" + this.getMessage() + ", reason=" + this.getReason() + ", signal=" + this.getSignal() + ", startedAt=" + this.getStartedAt() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
