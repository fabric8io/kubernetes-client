
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
 * Represents an empty directory for a pod. Empty directory volumes support ownership management and SELinux relabeling.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "medium",
    "mode",
    "sizeLimit"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class EmptyDirVolumeSource implements Editable<EmptyDirVolumeSourceBuilder>, KubernetesResource
{

    @JsonProperty("medium")
    private String medium;
    @JsonProperty("mode")
    private Integer mode;
    @JsonProperty("sizeLimit")
    private Quantity sizeLimit;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public EmptyDirVolumeSource() {
    }

    public EmptyDirVolumeSource(String medium, Integer mode, Quantity sizeLimit) {
        super();
        this.medium = medium;
        this.mode = mode;
        this.sizeLimit = sizeLimit;
    }

    /**
     * medium represents what type of storage medium should back this directory. The default is "" which means to use the node's default medium. Must be an empty string (default) or Memory. More info: https://kubernetes.io/docs/concepts/storage/volumes#emptydir
     */
    @JsonProperty("medium")
    public String getMedium() {
        return medium;
    }

    /**
     * medium represents what type of storage medium should back this directory. The default is "" which means to use the node's default medium. Must be an empty string (default) or Memory. More info: https://kubernetes.io/docs/concepts/storage/volumes#emptydir
     */
    @JsonProperty("medium")
    public void setMedium(String medium) {
        this.medium = medium;
    }

    /**
     * mode specifies the permission bits for the emptyDir directory, in numeric notation (e.g., 0755, 01777). Must be a value between 0000 and 01777. If not specified, defaults to 0777. This might be in conflict with other options that affect the file mode, like fsGroup. If fsGroup is specified, the fsGroup permissions will override the mode specified here. This field has no effect on Windows. This field is alpha and requires EmptyDirVolumeMode featuregate to be enabled.
     */
    @JsonProperty("mode")
    public Integer getMode() {
        return mode;
    }

    /**
     * mode specifies the permission bits for the emptyDir directory, in numeric notation (e.g., 0755, 01777). Must be a value between 0000 and 01777. If not specified, defaults to 0777. This might be in conflict with other options that affect the file mode, like fsGroup. If fsGroup is specified, the fsGroup permissions will override the mode specified here. This field has no effect on Windows. This field is alpha and requires EmptyDirVolumeMode featuregate to be enabled.
     */
    @JsonProperty("mode")
    public void setMode(Integer mode) {
        this.mode = mode;
    }

    /**
     * Represents an empty directory for a pod. Empty directory volumes support ownership management and SELinux relabeling.
     */
    @JsonProperty("sizeLimit")
    public Quantity getSizeLimit() {
        return sizeLimit;
    }

    /**
     * Represents an empty directory for a pod. Empty directory volumes support ownership management and SELinux relabeling.
     */
    @JsonProperty("sizeLimit")
    public void setSizeLimit(Quantity sizeLimit) {
        this.sizeLimit = sizeLimit;
    }

    @JsonIgnore
    public EmptyDirVolumeSourceBuilder edit() {
        return new EmptyDirVolumeSourceBuilder(this);
    }

    @JsonIgnore
    public EmptyDirVolumeSourceBuilder toBuilder() {
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
