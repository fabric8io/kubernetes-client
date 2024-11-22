
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
    "default",
    "defaultRequest",
    "max",
    "maxLimitRequestRatio",
    "min",
    "type"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class LimitRangeItem implements Editable<LimitRangeItemBuilder> , KubernetesResource
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
     * 
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

    @JsonProperty("default")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Quantity> getDefault() {
        return _default;
    }

    @JsonProperty("default")
    public void setDefault(Map<String, Quantity> _default) {
        this._default = _default;
    }

    @JsonProperty("defaultRequest")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Quantity> getDefaultRequest() {
        return defaultRequest;
    }

    @JsonProperty("defaultRequest")
    public void setDefaultRequest(Map<String, Quantity> defaultRequest) {
        this.defaultRequest = defaultRequest;
    }

    @JsonProperty("max")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Quantity> getMax() {
        return max;
    }

    @JsonProperty("max")
    public void setMax(Map<String, Quantity> max) {
        this.max = max;
    }

    @JsonProperty("maxLimitRequestRatio")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Quantity> getMaxLimitRequestRatio() {
        return maxLimitRequestRatio;
    }

    @JsonProperty("maxLimitRequestRatio")
    public void setMaxLimitRequestRatio(Map<String, Quantity> maxLimitRequestRatio) {
        this.maxLimitRequestRatio = maxLimitRequestRatio;
    }

    @JsonProperty("min")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Quantity> getMin() {
        return min;
    }

    @JsonProperty("min")
    public void setMin(Map<String, Quantity> min) {
        this.min = min;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

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
