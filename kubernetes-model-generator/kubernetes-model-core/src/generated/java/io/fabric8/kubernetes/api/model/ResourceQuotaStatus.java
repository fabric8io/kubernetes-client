
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
    "hard",
    "used"
})
@ToString
@EqualsAndHashCode
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
public class ResourceQuotaStatus implements KubernetesResource
{

    @JsonProperty("hard")
    private Map<String, io.fabric8.kubernetes.api.model.Quantity> hard;
    @JsonProperty("used")
    private Map<String, io.fabric8.kubernetes.api.model.Quantity> used;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ResourceQuotaStatus() {
    }

    /**
     * 
     * @param hard
     * @param used
     */
    public ResourceQuotaStatus(Map<String, io.fabric8.kubernetes.api.model.Quantity> hard, Map<String, io.fabric8.kubernetes.api.model.Quantity> used) {
        super();
        this.hard = hard;
        this.used = used;
    }

    @JsonProperty("hard")
    public Map<String, io.fabric8.kubernetes.api.model.Quantity> getHard() {
        return hard;
    }

    @JsonProperty("hard")
    public void setHard(Map<String, io.fabric8.kubernetes.api.model.Quantity> hard) {
        this.hard = hard;
    }

    @JsonProperty("used")
    public Map<String, io.fabric8.kubernetes.api.model.Quantity> getUsed() {
        return used;
    }

    @JsonProperty("used")
    public void setUsed(Map<String, io.fabric8.kubernetes.api.model.Quantity> used) {
        this.used = used;
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
