
package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

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
import io.fabric8.kubernetes.api.model.KubernetesResource;
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
    "options",
    "patch",
    "path",
    "target"
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
public class Patch implements KubernetesResource
{

    @JsonProperty("options")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Boolean> options = new LinkedHashMap<String, Boolean>();
    @JsonProperty("patch")
    private java.lang.String patch;
    @JsonProperty("path")
    private java.lang.String path;
    @JsonProperty("target")
    private Selector target;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Patch() {
    }

    public Patch(Map<String, Boolean> options, java.lang.String patch, java.lang.String path, Selector target) {
        super();
        this.options = options;
        this.patch = patch;
        this.path = path;
        this.target = target;
    }

    @JsonProperty("options")
    public Map<String, Boolean> getOptions() {
        return options;
    }

    @JsonProperty("options")
    public void setOptions(Map<String, Boolean> options) {
        this.options = options;
    }

    @JsonProperty("patch")
    public java.lang.String getPatch() {
        return patch;
    }

    @JsonProperty("patch")
    public void setPatch(java.lang.String patch) {
        this.patch = patch;
    }

    @JsonProperty("path")
    public java.lang.String getPath() {
        return path;
    }

    @JsonProperty("path")
    public void setPath(java.lang.String path) {
        this.path = path;
    }

    @JsonProperty("target")
    public Selector getTarget() {
        return target;
    }

    @JsonProperty("target")
    public void setTarget(Selector target) {
        this.target = target;
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
