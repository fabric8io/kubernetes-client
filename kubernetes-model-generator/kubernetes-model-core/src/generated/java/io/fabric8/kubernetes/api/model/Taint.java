
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
    "timeAdded",
    "value"
})
@ToString
@EqualsAndHashCode
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
public class Taint implements KubernetesResource
{

    @JsonProperty("effect")
    private java.lang.String effect;
    @JsonProperty("key")
    private java.lang.String key;
    @JsonProperty("timeAdded")
    private String timeAdded;
    @JsonProperty("value")
    private java.lang.String value;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Taint() {
    }

    /**
     * 
     * @param timeAdded
     * @param effect
     * @param value
     * @param key
     */
    public Taint(java.lang.String effect, java.lang.String key, String timeAdded, java.lang.String value) {
        super();
        this.effect = effect;
        this.key = key;
        this.timeAdded = timeAdded;
        this.value = value;
    }

    @JsonProperty("effect")
    public java.lang.String getEffect() {
        return effect;
    }

    @JsonProperty("effect")
    public void setEffect(java.lang.String effect) {
        this.effect = effect;
    }

    @JsonProperty("key")
    public java.lang.String getKey() {
        return key;
    }

    @JsonProperty("key")
    public void setKey(java.lang.String key) {
        this.key = key;
    }

    @JsonProperty("timeAdded")
    public String getTimeAdded() {
        return timeAdded;
    }

    @JsonProperty("timeAdded")
    public void setTimeAdded(String timeAdded) {
        this.timeAdded = timeAdded;
    }

    @JsonProperty("value")
    public java.lang.String getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(java.lang.String value) {
        this.value = value;
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
