
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "field",
    "message",
    "reason"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class StatusCause implements Editable<StatusCauseBuilder>, KubernetesResource
{

    @JsonProperty("field")
    private String field;
    @JsonProperty("message")
    private String message;
    @JsonProperty("reason")
    private String reason;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public StatusCause() {
    }

    public StatusCause(String field, String message, String reason) {
        super();
        this.field = field;
        this.message = message;
        this.reason = reason;
    }

    @JsonProperty("field")
    public String getField() {
        return field;
    }

    @JsonProperty("field")
    public void setField(String field) {
        this.field = field;
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

    @JsonIgnore
    public StatusCauseBuilder edit() {
        return new StatusCauseBuilder(this);
    }

    @JsonIgnore
    public StatusCauseBuilder toBuilder() {
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
        if (!(o instanceof StatusCause)) {
            return false;
        }
        StatusCause other = (StatusCause) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$field = this.getField();
        Object other$field = other.getField();
        if (this$field == null ? other$field != null : !this$field.equals(other$field)) {
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
        return other instanceof StatusCause;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $field = this.getField();
        result = result * prime + ($field == null ? 43 : $field.hashCode());
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
        return "StatusCause(" + "field=" + this.getField() + ", message=" + this.getMessage() + ", reason=" + this.getReason() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
