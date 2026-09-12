
package io.fabric8.kubernetes.api.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
 * LimitRangeSpec defines a min/max usage limit for resources that match on kind.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "limits"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class LimitRangeSpec implements Editable<LimitRangeSpecBuilder>, KubernetesResource
{

    @JsonProperty("limits")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<LimitRangeItem> limits = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public LimitRangeSpec() {
    }

    public LimitRangeSpec(List<LimitRangeItem> limits) {
        super();
        this.limits = limits;
    }

    /**
     * Limits is the list of LimitRangeItem objects that are enforced.
     */
    @JsonProperty("limits")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<LimitRangeItem> getLimits() {
        return limits;
    }

    /**
     * Limits is the list of LimitRangeItem objects that are enforced.
     */
    @JsonProperty("limits")
    public void setLimits(List<LimitRangeItem> limits) {
        this.limits = limits;
    }

    @JsonIgnore
    public LimitRangeSpecBuilder edit() {
        return new LimitRangeSpecBuilder(this);
    }

    @JsonIgnore
    public LimitRangeSpecBuilder toBuilder() {
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
        if (!(o instanceof LimitRangeSpec)) {
            return false;
        }
        LimitRangeSpec other = (LimitRangeSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$limits = this.getLimits();
        Object other$limits = other.getLimits();
        if (this$limits == null ? other$limits != null : !this$limits.equals(other$limits)) {
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
        return other instanceof LimitRangeSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $limits = this.getLimits();
        result = result * prime + ($limits == null ? 43 : $limits.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "LimitRangeSpec(" + "limits=" + this.getLimits() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
