
package io.fabric8.kubernetes.api.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "default",
    "defaultRequest",
    "max",
    "maxLimitRequestRatio",
    "min",
    "type"
})
@ToString
@EqualsAndHashCode
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
public class LimitRangeItem implements KubernetesResource
{

    @JsonProperty("default")
    private Map<String, io.fabric8.kubernetes.api.model.Quantity> _default;
    @JsonProperty("defaultRequest")
    private Map<String, io.fabric8.kubernetes.api.model.Quantity> defaultRequest;
    @JsonProperty("max")
    private Map<String, io.fabric8.kubernetes.api.model.Quantity> max;
    @JsonProperty("maxLimitRequestRatio")
    private Map<String, io.fabric8.kubernetes.api.model.Quantity> maxLimitRequestRatio;
    @JsonProperty("min")
    private Map<String, io.fabric8.kubernetes.api.model.Quantity> min;
    @JsonProperty("type")
    private java.lang.String type;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public LimitRangeItem() {
    }

    /**
     * 
     * @param _default
     * @param min
     * @param max
     * @param maxLimitRequestRatio
     * @param type
     * @param defaultRequest
     */
    public LimitRangeItem(Map<String, io.fabric8.kubernetes.api.model.Quantity> _default, Map<String, io.fabric8.kubernetes.api.model.Quantity> defaultRequest, Map<String, io.fabric8.kubernetes.api.model.Quantity> max, Map<String, io.fabric8.kubernetes.api.model.Quantity> maxLimitRequestRatio, Map<String, io.fabric8.kubernetes.api.model.Quantity> min, java.lang.String type) {
        super();
        this._default = _default;
        this.defaultRequest = defaultRequest;
        this.max = max;
        this.maxLimitRequestRatio = maxLimitRequestRatio;
        this.min = min;
        this.type = type;
    }

    @JsonProperty("default")
    public Map<String, io.fabric8.kubernetes.api.model.Quantity> getDefault() {
        return _default;
    }

    @JsonProperty("default")
    public void setDefault(Map<String, io.fabric8.kubernetes.api.model.Quantity> _default) {
        this._default = _default;
    }

    @JsonProperty("defaultRequest")
    public Map<String, io.fabric8.kubernetes.api.model.Quantity> getDefaultRequest() {
        return defaultRequest;
    }

    @JsonProperty("defaultRequest")
    public void setDefaultRequest(Map<String, io.fabric8.kubernetes.api.model.Quantity> defaultRequest) {
        this.defaultRequest = defaultRequest;
    }

    @JsonProperty("max")
    public Map<String, io.fabric8.kubernetes.api.model.Quantity> getMax() {
        return max;
    }

    @JsonProperty("max")
    public void setMax(Map<String, io.fabric8.kubernetes.api.model.Quantity> max) {
        this.max = max;
    }

    @JsonProperty("maxLimitRequestRatio")
    public Map<String, io.fabric8.kubernetes.api.model.Quantity> getMaxLimitRequestRatio() {
        return maxLimitRequestRatio;
    }

    @JsonProperty("maxLimitRequestRatio")
    public void setMaxLimitRequestRatio(Map<String, io.fabric8.kubernetes.api.model.Quantity> maxLimitRequestRatio) {
        this.maxLimitRequestRatio = maxLimitRequestRatio;
    }

    @JsonProperty("min")
    public Map<String, io.fabric8.kubernetes.api.model.Quantity> getMin() {
        return min;
    }

    @JsonProperty("min")
    public void setMin(Map<String, io.fabric8.kubernetes.api.model.Quantity> min) {
        this.min = min;
    }

    @JsonProperty("type")
    public java.lang.String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(java.lang.String type) {
        this.type = type;
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
