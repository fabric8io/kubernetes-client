
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
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

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
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("jsonschema2pojo")
public class Lifecycle implements KubernetesResource
{

    @JsonProperty("postStart")
    private LifecycleHandler postStart;
    @JsonProperty("preStop")
    private LifecycleHandler preStop;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Lifecycle() {
    }

    public Lifecycle(LifecycleHandler postStart, LifecycleHandler preStop) {
        super();
        this.postStart = postStart;
        this.preStop = preStop;
    }

    @JsonProperty("postStart")
    public LifecycleHandler getPostStart() {
        return postStart;
    }

    @JsonProperty("postStart")
    public void setPostStart(LifecycleHandler postStart) {
        this.postStart = postStart;
    }

    @JsonProperty("preStop")
    public LifecycleHandler getPreStop() {
        return preStop;
    }

    @JsonProperty("preStop")
    public void setPreStop(LifecycleHandler preStop) {
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
