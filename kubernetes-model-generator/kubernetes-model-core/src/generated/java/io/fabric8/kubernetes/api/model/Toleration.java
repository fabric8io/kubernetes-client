
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
    "effect",
    "key",
    "operator",
    "tolerationSeconds",
    "value"
})
@ToString
@EqualsAndHashCode
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
public class Toleration implements KubernetesResource
{

    @JsonProperty("effect")
    private String effect;
    @JsonProperty("key")
    private String key;
    @JsonProperty("operator")
    private String operator;
    @JsonProperty("tolerationSeconds")
    private Long tolerationSeconds;
    @JsonProperty("value")
    private String value;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Toleration() {
    }

    /**
     * 
     * @param effect
     * @param tolerationSeconds
     * @param value
     * @param key
     * @param operator
     */
    public Toleration(String effect, String key, String operator, Long tolerationSeconds, String value) {
        super();
        this.effect = effect;
        this.key = key;
        this.operator = operator;
        this.tolerationSeconds = tolerationSeconds;
        this.value = value;
    }

    @JsonProperty("effect")
    public String getEffect() {
        return effect;
    }

    @JsonProperty("effect")
    public void setEffect(String effect) {
        this.effect = effect;
    }

    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    @JsonProperty("key")
    public void setKey(String key) {
        this.key = key;
    }

    @JsonProperty("operator")
    public String getOperator() {
        return operator;
    }

    @JsonProperty("operator")
    public void setOperator(String operator) {
        this.operator = operator;
    }

    @JsonProperty("tolerationSeconds")
    public Long getTolerationSeconds() {
        return tolerationSeconds;
    }

    @JsonProperty("tolerationSeconds")
    public void setTolerationSeconds(Long tolerationSeconds) {
        this.tolerationSeconds = tolerationSeconds;
    }

    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
