
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
    "fieldRef",
    "mode",
    "path",
    "resourceFieldRef"
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
public class DownwardAPIVolumeFile implements KubernetesResource
{

    @JsonProperty("fieldRef")
    private ObjectFieldSelector fieldRef;
    @JsonProperty("mode")
    private Integer mode;
    @JsonProperty("path")
    private String path;
    @JsonProperty("resourceFieldRef")
    private ResourceFieldSelector resourceFieldRef;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public DownwardAPIVolumeFile() {
    }

    public DownwardAPIVolumeFile(ObjectFieldSelector fieldRef, Integer mode, String path, ResourceFieldSelector resourceFieldRef) {
        super();
        this.fieldRef = fieldRef;
        this.mode = mode;
        this.path = path;
        this.resourceFieldRef = resourceFieldRef;
    }

    @JsonProperty("fieldRef")
    public ObjectFieldSelector getFieldRef() {
        return fieldRef;
    }

    @JsonProperty("fieldRef")
    public void setFieldRef(ObjectFieldSelector fieldRef) {
        this.fieldRef = fieldRef;
    }

    @JsonProperty("mode")
    public Integer getMode() {
        return mode;
    }

    @JsonProperty("mode")
    public void setMode(Integer mode) {
        this.mode = mode;
    }

    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    @JsonProperty("resourceFieldRef")
    public ResourceFieldSelector getResourceFieldRef() {
        return resourceFieldRef;
    }

    @JsonProperty("resourceFieldRef")
    public void setResourceFieldRef(ResourceFieldSelector resourceFieldRef) {
        this.resourceFieldRef = resourceFieldRef;
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
