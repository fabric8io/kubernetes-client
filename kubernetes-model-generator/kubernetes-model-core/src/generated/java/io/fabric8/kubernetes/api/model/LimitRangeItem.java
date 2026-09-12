
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
 * LimitRangeItem defines a min/max usage limit for any resource that matches on kind.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "default",
    "defaultRequest",
    "max",
    "maxLimitRequestRatio",
    "min",
    "type"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class LimitRangeItem implements Editable<LimitRangeItemBuilder>, KubernetesResource
{

    @JsonProperty("default")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Quantity> _default = new LinkedHashMap<>();
    @JsonProperty("defaultRequest")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Quantity> defaultRequest = new LinkedHashMap<>();
    @JsonProperty("max")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Quantity> max = new LinkedHashMap<>();
    @JsonProperty("maxLimitRequestRatio")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Quantity> maxLimitRequestRatio = new LinkedHashMap<>();
    @JsonProperty("min")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Quantity> min = new LinkedHashMap<>();
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public LimitRangeItem() {
    }

    public LimitRangeItem(Map<String, Quantity> _default, Map<String, Quantity> defaultRequest, Map<String, Quantity> max, Map<String, Quantity> maxLimitRequestRatio, Map<String, Quantity> min, String type) {
        super();
        this._default = _default;
        this.defaultRequest = defaultRequest;
        this.max = max;
        this.maxLimitRequestRatio = maxLimitRequestRatio;
        this.min = min;
        this.type = type;
    }

    /**
     * Default resource requirement limit value by resource name if resource limit is omitted.
     */
    @JsonProperty("default")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Quantity> getDefault() {
        return _default;
    }

    /**
     * Default resource requirement limit value by resource name if resource limit is omitted.
     */
    @JsonProperty("default")
    public void setDefault(Map<String, Quantity> _default) {
        this._default = _default;
    }

    /**
     * DefaultRequest is the default resource requirement request value by resource name if resource request is omitted.
     */
    @JsonProperty("defaultRequest")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Quantity> getDefaultRequest() {
        return defaultRequest;
    }

    /**
     * DefaultRequest is the default resource requirement request value by resource name if resource request is omitted.
     */
    @JsonProperty("defaultRequest")
    public void setDefaultRequest(Map<String, Quantity> defaultRequest) {
        this.defaultRequest = defaultRequest;
    }

    /**
     * Max usage constraints on this kind by resource name.
     */
    @JsonProperty("max")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Quantity> getMax() {
        return max;
    }

    /**
     * Max usage constraints on this kind by resource name.
     */
    @JsonProperty("max")
    public void setMax(Map<String, Quantity> max) {
        this.max = max;
    }

    /**
     * MaxLimitRequestRatio if specified, the named resource must have a request and limit that are both non-zero where limit divided by request is less than or equal to the enumerated value; this represents the max burst for the named resource.
     */
    @JsonProperty("maxLimitRequestRatio")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Quantity> getMaxLimitRequestRatio() {
        return maxLimitRequestRatio;
    }

    /**
     * MaxLimitRequestRatio if specified, the named resource must have a request and limit that are both non-zero where limit divided by request is less than or equal to the enumerated value; this represents the max burst for the named resource.
     */
    @JsonProperty("maxLimitRequestRatio")
    public void setMaxLimitRequestRatio(Map<String, Quantity> maxLimitRequestRatio) {
        this.maxLimitRequestRatio = maxLimitRequestRatio;
    }

    /**
     * Min usage constraints on this kind by resource name.
     */
    @JsonProperty("min")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Quantity> getMin() {
        return min;
    }

    /**
     * Min usage constraints on this kind by resource name.
     */
    @JsonProperty("min")
    public void setMin(Map<String, Quantity> min) {
        this.min = min;
    }

    /**
     * Type of resource that this limit applies to.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Type of resource that this limit applies to.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public LimitRangeItemBuilder edit() {
        return new LimitRangeItemBuilder(this);
    }

    @JsonIgnore
    public LimitRangeItemBuilder toBuilder() {
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
        if (!(o instanceof LimitRangeItem)) {
            return false;
        }
        LimitRangeItem other = (LimitRangeItem) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$_default = this.getDefault();
        Object other$_default = other.getDefault();
        if (this$_default == null ? other$_default != null : !this$_default.equals(other$_default)) {
            return false;
        }
        Object this$defaultRequest = this.getDefaultRequest();
        Object other$defaultRequest = other.getDefaultRequest();
        if (this$defaultRequest == null ? other$defaultRequest != null : !this$defaultRequest.equals(other$defaultRequest)) {
            return false;
        }
        Object this$max = this.getMax();
        Object other$max = other.getMax();
        if (this$max == null ? other$max != null : !this$max.equals(other$max)) {
            return false;
        }
        Object this$maxLimitRequestRatio = this.getMaxLimitRequestRatio();
        Object other$maxLimitRequestRatio = other.getMaxLimitRequestRatio();
        if (this$maxLimitRequestRatio == null ? other$maxLimitRequestRatio != null : !this$maxLimitRequestRatio.equals(other$maxLimitRequestRatio)) {
            return false;
        }
        Object this$min = this.getMin();
        Object other$min = other.getMin();
        if (this$min == null ? other$min != null : !this$min.equals(other$min)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
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
        return other instanceof LimitRangeItem;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $_default = this.getDefault();
        result = result * prime + ($_default == null ? 43 : $_default.hashCode());
        Object $defaultRequest = this.getDefaultRequest();
        result = result * prime + ($defaultRequest == null ? 43 : $defaultRequest.hashCode());
        Object $max = this.getMax();
        result = result * prime + ($max == null ? 43 : $max.hashCode());
        Object $maxLimitRequestRatio = this.getMaxLimitRequestRatio();
        result = result * prime + ($maxLimitRequestRatio == null ? 43 : $maxLimitRequestRatio.hashCode());
        Object $min = this.getMin();
        result = result * prime + ($min == null ? 43 : $min.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "LimitRangeItem(" + "_default=" + this.getDefault() + ", defaultRequest=" + this.getDefaultRequest() + ", max=" + this.getMax() + ", maxLimitRequestRatio=" + this.getMaxLimitRequestRatio() + ", min=" + this.getMin() + ", type=" + this.getType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
