
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
    "mountPath",
    "mountPropagation",
    "name",
    "readOnly",
    "subPath",
    "subPathExpr"
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
public class VolumeMount implements KubernetesResource
{

    @JsonProperty("mountPath")
    private String mountPath;
    @JsonProperty("mountPropagation")
    private String mountPropagation;
    @JsonProperty("name")
    private String name;
    @JsonProperty("readOnly")
    private Boolean readOnly;
    @JsonProperty("subPath")
    private String subPath;
    @JsonProperty("subPathExpr")
    private String subPathExpr;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public VolumeMount() {
    }

    public VolumeMount(String mountPath, String mountPropagation, String name, Boolean readOnly, String subPath, String subPathExpr) {
        super();
        this.mountPath = mountPath;
        this.mountPropagation = mountPropagation;
        this.name = name;
        this.readOnly = readOnly;
        this.subPath = subPath;
        this.subPathExpr = subPathExpr;
    }

    @JsonProperty("mountPath")
    public String getMountPath() {
        return mountPath;
    }

    @JsonProperty("mountPath")
    public void setMountPath(String mountPath) {
        this.mountPath = mountPath;
    }

    @JsonProperty("mountPropagation")
    public String getMountPropagation() {
        return mountPropagation;
    }

    @JsonProperty("mountPropagation")
    public void setMountPropagation(String mountPropagation) {
        this.mountPropagation = mountPropagation;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("readOnly")
    public Boolean getReadOnly() {
        return readOnly;
    }

    @JsonProperty("readOnly")
    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    @JsonProperty("subPath")
    public String getSubPath() {
        return subPath;
    }

    @JsonProperty("subPath")
    public void setSubPath(String subPath) {
        this.subPath = subPath;
    }

    @JsonProperty("subPathExpr")
    public String getSubPathExpr() {
        return subPathExpr;
    }

    @JsonProperty("subPathExpr")
    public void setSubPathExpr(String subPathExpr) {
        this.subPathExpr = subPathExpr;
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
