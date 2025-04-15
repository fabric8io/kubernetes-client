
package io.fabric8.kubernetes.api.model;

import java.util.LinkedHashMap;
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
 * VolumeMountStatus shows status of volume mounts.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "mountPath",
    "name",
    "readOnly",
    "recursiveReadOnly"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class VolumeMountStatus implements Editable<VolumeMountStatusBuilder>, KubernetesResource
{

    @JsonProperty("mountPath")
    private String mountPath;
    @JsonProperty("name")
    private String name;
    @JsonProperty("readOnly")
    private Boolean readOnly;
    @JsonProperty("recursiveReadOnly")
    private String recursiveReadOnly;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VolumeMountStatus() {
    }

    public VolumeMountStatus(String mountPath, String name, Boolean readOnly, String recursiveReadOnly) {
        super();
        this.mountPath = mountPath;
        this.name = name;
        this.readOnly = readOnly;
        this.recursiveReadOnly = recursiveReadOnly;
    }

    /**
     * MountPath corresponds to the original VolumeMount.
     */
    @JsonProperty("mountPath")
    public String getMountPath() {
        return mountPath;
    }

    /**
     * MountPath corresponds to the original VolumeMount.
     */
    @JsonProperty("mountPath")
    public void setMountPath(String mountPath) {
        this.mountPath = mountPath;
    }

    /**
     * Name corresponds to the name of the original VolumeMount.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name corresponds to the name of the original VolumeMount.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * ReadOnly corresponds to the original VolumeMount.
     */
    @JsonProperty("readOnly")
    public Boolean getReadOnly() {
        return readOnly;
    }

    /**
     * ReadOnly corresponds to the original VolumeMount.
     */
    @JsonProperty("readOnly")
    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    /**
     * RecursiveReadOnly must be set to Disabled, Enabled, or unspecified (for non-readonly mounts). An IfPossible value in the original VolumeMount must be translated to Disabled or Enabled, depending on the mount result.
     */
    @JsonProperty("recursiveReadOnly")
    public String getRecursiveReadOnly() {
        return recursiveReadOnly;
    }

    /**
     * RecursiveReadOnly must be set to Disabled, Enabled, or unspecified (for non-readonly mounts). An IfPossible value in the original VolumeMount must be translated to Disabled or Enabled, depending on the mount result.
     */
    @JsonProperty("recursiveReadOnly")
    public void setRecursiveReadOnly(String recursiveReadOnly) {
        this.recursiveReadOnly = recursiveReadOnly;
    }

    @JsonIgnore
    public VolumeMountStatusBuilder edit() {
        return new VolumeMountStatusBuilder(this);
    }

    @JsonIgnore
    public VolumeMountStatusBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
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
