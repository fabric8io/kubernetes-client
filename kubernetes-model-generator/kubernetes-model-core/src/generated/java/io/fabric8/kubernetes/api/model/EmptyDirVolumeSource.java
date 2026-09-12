
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof EmptyDirVolumeSource)) {
            return false;
        }
        EmptyDirVolumeSource other = (EmptyDirVolumeSource) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$medium = this.getMedium();
        Object other$medium = other.getMedium();
        if (this$medium == null ? other$medium != null : !this$medium.equals(other$medium)) {
            return false;
        }
        Object this$mode = this.getMode();
        Object other$mode = other.getMode();
        if (this$mode == null ? other$mode != null : !this$mode.equals(other$mode)) {
            return false;
        }
        Object this$sizeLimit = this.getSizeLimit();
        Object other$sizeLimit = other.getSizeLimit();
        if (this$sizeLimit == null ? other$sizeLimit != null : !this$sizeLimit.equals(other$sizeLimit)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof EmptyDirVolumeSource;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $medium = this.getMedium();
        result = result * prime + ($medium == null ? 43 : $medium.hashCode());
        Object $mode = this.getMode();
        result = result * prime + ($mode == null ? 43 : $mode.hashCode());
        Object $sizeLimit = this.getSizeLimit();
        result = result * prime + ($sizeLimit == null ? 43 : $sizeLimit.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "EmptyDirVolumeSource(" + "medium=" + this.getMedium() + ", mode=" + this.getMode() + ", sizeLimit=" + this.getSizeLimit() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
