
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
 * FlexVolume represents a generic volume resource that is provisioned/attached using an exec based plugin.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "driver",
    "fsType",
    "options",
    "readOnly",
    "secretRef"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class FlexVolumeSource implements Editable<FlexVolumeSourceBuilder>, KubernetesResource
{

    @JsonProperty("driver")
    private String driver;
    @JsonProperty("fsType")
    private String fsType;
    @JsonProperty("options")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> options = new LinkedHashMap<>();
    @JsonProperty("readOnly")
    private Boolean readOnly;
    @JsonProperty("secretRef")
    private LocalObjectReference secretRef;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public FlexVolumeSource() {
    }

    public FlexVolumeSource(String driver, String fsType, Map<String, String> options, Boolean readOnly, LocalObjectReference secretRef) {
        super();
        this.driver = driver;
        this.fsType = fsType;
        this.options = options;
        this.readOnly = readOnly;
        this.secretRef = secretRef;
    }

    /**
     * driver is the name of the driver to use for this volume.
     */
    @JsonProperty("driver")
    public String getDriver() {
        return driver;
    }

    /**
     * driver is the name of the driver to use for this volume.
     */
    @JsonProperty("driver")
    public void setDriver(String driver) {
        this.driver = driver;
    }

    /**
     * fsType is the filesystem type to mount. Must be a filesystem type supported by the host operating system. Ex. "ext4", "xfs", "ntfs". The default filesystem depends on FlexVolume script.
     */
    @JsonProperty("fsType")
    public String getFsType() {
        return fsType;
    }

    /**
     * fsType is the filesystem type to mount. Must be a filesystem type supported by the host operating system. Ex. "ext4", "xfs", "ntfs". The default filesystem depends on FlexVolume script.
     */
    @JsonProperty("fsType")
    public void setFsType(String fsType) {
        this.fsType = fsType;
    }

    /**
     * options is Optional: this field holds extra command options if any.
     */
    @JsonProperty("options")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getOptions() {
        return options;
    }

    /**
     * options is Optional: this field holds extra command options if any.
     */
    @JsonProperty("options")
    public void setOptions(Map<String, String> options) {
        this.options = options;
    }

    /**
     * readOnly is Optional: defaults to false (read/write). ReadOnly here will force the ReadOnly setting in VolumeMounts.
     */
    @JsonProperty("readOnly")
    public Boolean getReadOnly() {
        return readOnly;
    }

    /**
     * readOnly is Optional: defaults to false (read/write). ReadOnly here will force the ReadOnly setting in VolumeMounts.
     */
    @JsonProperty("readOnly")
    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    /**
     * FlexVolume represents a generic volume resource that is provisioned/attached using an exec based plugin.
     */
    @JsonProperty("secretRef")
    public LocalObjectReference getSecretRef() {
        return secretRef;
    }

    /**
     * FlexVolume represents a generic volume resource that is provisioned/attached using an exec based plugin.
     */
    @JsonProperty("secretRef")
    public void setSecretRef(LocalObjectReference secretRef) {
        this.secretRef = secretRef;
    }

    @JsonIgnore
    public FlexVolumeSourceBuilder edit() {
        return new FlexVolumeSourceBuilder(this);
    }

    @JsonIgnore
    public FlexVolumeSourceBuilder toBuilder() {
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
        if (!(o instanceof FlexVolumeSource)) {
            return false;
        }
        FlexVolumeSource other = (FlexVolumeSource) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$driver = this.getDriver();
        Object other$driver = other.getDriver();
        if (this$driver == null ? other$driver != null : !this$driver.equals(other$driver)) {
            return false;
        }
        Object this$fsType = this.getFsType();
        Object other$fsType = other.getFsType();
        if (this$fsType == null ? other$fsType != null : !this$fsType.equals(other$fsType)) {
            return false;
        }
        Object this$options = this.getOptions();
        Object other$options = other.getOptions();
        if (this$options == null ? other$options != null : !this$options.equals(other$options)) {
            return false;
        }
        Object this$readOnly = this.getReadOnly();
        Object other$readOnly = other.getReadOnly();
        if (this$readOnly == null ? other$readOnly != null : !this$readOnly.equals(other$readOnly)) {
            return false;
        }
        Object this$secretRef = this.getSecretRef();
        Object other$secretRef = other.getSecretRef();
        if (this$secretRef == null ? other$secretRef != null : !this$secretRef.equals(other$secretRef)) {
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
        return other instanceof FlexVolumeSource;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $driver = this.getDriver();
        result = result * prime + ($driver == null ? 43 : $driver.hashCode());
        Object $fsType = this.getFsType();
        result = result * prime + ($fsType == null ? 43 : $fsType.hashCode());
        Object $options = this.getOptions();
        result = result * prime + ($options == null ? 43 : $options.hashCode());
        Object $readOnly = this.getReadOnly();
        result = result * prime + ($readOnly == null ? 43 : $readOnly.hashCode());
        Object $secretRef = this.getSecretRef();
        result = result * prime + ($secretRef == null ? 43 : $secretRef.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "FlexVolumeSource(" + "driver=" + this.getDriver() + ", fsType=" + this.getFsType() + ", options=" + this.getOptions() + ", readOnly=" + this.getReadOnly() + ", secretRef=" + this.getSecretRef() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
