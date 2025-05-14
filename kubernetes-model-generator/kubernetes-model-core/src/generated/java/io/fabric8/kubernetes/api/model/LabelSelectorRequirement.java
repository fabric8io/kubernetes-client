
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * A label selector requirement is a selector that contains values, a key, and an operator that relates the key and values.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "key",
    "operator",
    "values"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class LabelSelectorRequirement implements Editable<LabelSelectorRequirementBuilder>, KubernetesResource
{

    @JsonProperty("key")
    private String key;
    @JsonProperty("operator")
    private String operator;
    @JsonProperty("values")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> values = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public LabelSelectorRequirement() {
    }

    public LabelSelectorRequirement(String key, String operator, List<String> values) {
        super();
        this.key = key;
        this.operator = operator;
        this.values = values;
    }

    /**
     * key is the label key that the selector applies to.
     */
    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    /**
     * key is the label key that the selector applies to.
     */
    @JsonProperty("key")
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * operator represents a key's relationship to a set of values. Valid operators are In, NotIn, Exists and DoesNotExist.
     */
    @JsonProperty("operator")
    public String getOperator() {
        return operator;
    }

    /**
     * operator represents a key's relationship to a set of values. Valid operators are In, NotIn, Exists and DoesNotExist.
     */
    @JsonProperty("operator")
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * values is an array of string values. If the operator is In or NotIn, the values array must be non-empty. If the operator is Exists or DoesNotExist, the values array must be empty. This array is replaced during a strategic merge patch.
     */
    @JsonProperty("values")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getValues() {
        return values;
    }

    /**
     * values is an array of string values. If the operator is In or NotIn, the values array must be non-empty. If the operator is Exists or DoesNotExist, the values array must be empty. This array is replaced during a strategic merge patch.
     */
    @JsonProperty("values")
    public void setValues(List<String> values) {
        this.values = values;
    }

    @JsonIgnore
    public LabelSelectorRequirementBuilder edit() {
        return new LabelSelectorRequirementBuilder(this);
    }

    @JsonIgnore
    public LabelSelectorRequirementBuilder toBuilder() {
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

}
