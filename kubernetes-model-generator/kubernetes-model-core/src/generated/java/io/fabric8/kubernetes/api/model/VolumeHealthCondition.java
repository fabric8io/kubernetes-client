
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
 * VolumeHealthCondition represents an adverse health condition reported for a volume.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "message",
    "reason",
    "status"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class VolumeHealthCondition implements Editable<VolumeHealthConditionBuilder>, KubernetesResource
{

    @JsonProperty("message")
    private String message;
    @JsonProperty("reason")
    private String reason;
    @JsonProperty("status")
    private String status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VolumeHealthCondition() {
    }

    public VolumeHealthCondition(String message, String reason, String status) {
        super();
        this.message = message;
        this.reason = reason;
        this.status = status;
    }

    /**
     * message is a human-readable description. Maximum permitted length of a message is 1024 bytes.
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * message is a human-readable description. Maximum permitted length of a message is 1024 bytes.
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * reason is a brief CamelCase machine-parseable reason. Together with status it forms the unique identity of a condition entry. Maximum permitted length of a reason is 256 bytes.
     */
    @JsonProperty("reason")
    public String getReason() {
        return reason;
    }

    /**
     * reason is a brief CamelCase machine-parseable reason. Together with status it forms the unique identity of a condition entry. Maximum permitted length of a reason is 256 bytes.
     */
    @JsonProperty("reason")
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * status is the machine-parseable health category. Possible values: - "Inaccessible": the volume cannot be accessed. - "DataLoss": data loss has been detected on the volume. - "Degraded": the volume is functioning with reduced capability.
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * status is the machine-parseable health category. Possible values: - "Inaccessible": the volume cannot be accessed. - "DataLoss": data loss has been detected on the volume. - "Degraded": the volume is functioning with reduced capability.
     */
    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonIgnore
    public VolumeHealthConditionBuilder edit() {
        return new VolumeHealthConditionBuilder(this);
    }

    @JsonIgnore
    public VolumeHealthConditionBuilder toBuilder() {
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
        if (!(o instanceof VolumeHealthCondition)) {
            return false;
        }
        VolumeHealthCondition other = (VolumeHealthCondition) o;
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
        Object this$status = this.getStatus();
        Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) {
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
        return other instanceof VolumeHealthCondition;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $message = this.getMessage();
        result = result * prime + ($message == null ? 43 : $message.hashCode());
        Object $reason = this.getReason();
        result = result * prime + ($reason == null ? 43 : $reason.hashCode());
        Object $status = this.getStatus();
        result = result * prime + ($status == null ? 43 : $status.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "VolumeHealthCondition(" + "message=" + this.getMessage() + ", reason=" + this.getReason() + ", status=" + this.getStatus() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
