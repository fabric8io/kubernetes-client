
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
 * ContainerStateWaiting is a waiting state of a container.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "message",
    "reason"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ContainerStateWaiting implements Editable<ContainerStateWaitingBuilder>, KubernetesResource
{

    @JsonProperty("message")
    private String message;
    @JsonProperty("reason")
    private String reason;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ContainerStateWaiting() {
    }

    public ContainerStateWaiting(String message, String reason) {
        super();
        this.message = message;
        this.reason = reason;
    }

    /**
     * Message regarding why the container is not yet running.
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * Message regarding why the container is not yet running.
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * (brief) reason the container is not yet running.
     */
    @JsonProperty("reason")
    public String getReason() {
        return reason;
    }

    /**
     * (brief) reason the container is not yet running.
     */
    @JsonProperty("reason")
    public void setReason(String reason) {
        this.reason = reason;
    }

    @JsonIgnore
    public ContainerStateWaitingBuilder edit() {
        return new ContainerStateWaitingBuilder(this);
    }

    @JsonIgnore
    public ContainerStateWaitingBuilder toBuilder() {
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
        if (!(o instanceof ContainerStateWaiting)) {
            return false;
        }
        ContainerStateWaiting other = (ContainerStateWaiting) o;
        if (!other.canEqual(this)) {
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
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof ContainerStateWaiting;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $message = this.getMessage();
        result = result * prime + ($message == null ? 43 : $message.hashCode());
        Object $reason = this.getReason();
        result = result * prime + ($reason == null ? 43 : $reason.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ContainerStateWaiting(" + "message=" + this.getMessage() + ", reason=" + this.getReason() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
