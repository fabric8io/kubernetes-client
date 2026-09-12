
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
 * SleepAction describes a "sleep" action.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "seconds"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class SleepAction implements Editable<SleepActionBuilder>, KubernetesResource
{

    @JsonProperty("seconds")
    private Long seconds;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SleepAction() {
    }

    public SleepAction(Long seconds) {
        super();
        this.seconds = seconds;
    }

    /**
     * Seconds is the number of seconds to sleep.
     */
    @JsonProperty("seconds")
    public Long getSeconds() {
        return seconds;
    }

    /**
     * Seconds is the number of seconds to sleep.
     */
    @JsonProperty("seconds")
    public void setSeconds(Long seconds) {
        this.seconds = seconds;
    }

    @JsonIgnore
    public SleepActionBuilder edit() {
        return new SleepActionBuilder(this);
    }

    @JsonIgnore
    public SleepActionBuilder toBuilder() {
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
        if (!(o instanceof SleepAction)) {
            return false;
        }
        SleepAction other = (SleepAction) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$seconds = this.getSeconds();
        Object other$seconds = other.getSeconds();
        if (this$seconds == null ? other$seconds != null : !this$seconds.equals(other$seconds)) {
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
        return other instanceof SleepAction;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $seconds = this.getSeconds();
        result = result * prime + ($seconds == null ? 43 : $seconds.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "SleepAction(" + "seconds=" + this.getSeconds() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
