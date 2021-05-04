
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
    "postStart",
    "preStop"
})
@ToString
@EqualsAndHashCode
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
public class Lifecycle implements KubernetesResource
{

    @JsonProperty("postStart")
    private Handler postStart;
    @JsonProperty("preStop")
    private Handler preStop;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Lifecycle() {
    }

    /**
     * 
     * @param postStart
     * @param preStop
     */
    public Lifecycle(Handler postStart, Handler preStop) {
        super();
        this.postStart = postStart;
        this.preStop = preStop;
    }

    @JsonProperty("postStart")
    public Handler getPostStart() {
        return postStart;
    }

    @JsonProperty("postStart")
    public void setPostStart(Handler postStart) {
        this.postStart = postStart;
    }

    @JsonProperty("preStop")
    public Handler getPreStop() {
        return preStop;
    }

    @JsonProperty("preStop")
    public void setPreStop(Handler preStop) {
        this.preStop = preStop;
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
