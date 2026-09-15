
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
 * VolumeMountStatus shows status of volume mounts.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "mountPath",
    "name",
    "readOnly",
    "recursiveReadOnly",
    "volumeStatus"
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
    @JsonProperty("volumeStatus")
    private VolumeStatus volumeStatus;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VolumeMountStatus() {
    }

    public VolumeMountStatus(String mountPath, String name, Boolean readOnly, String recursiveReadOnly, VolumeStatus volumeStatus) {
        super();
        this.mountPath = mountPath;
        this.name = name;
        this.readOnly = readOnly;
        this.recursiveReadOnly = recursiveReadOnly;
        this.volumeStatus = volumeStatus;
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

    /**
     * VolumeMountStatus shows status of volume mounts.
     */
    @JsonProperty("volumeStatus")
    public VolumeStatus getVolumeStatus() {
        return volumeStatus;
    }

    /**
     * VolumeMountStatus shows status of volume mounts.
     */
    @JsonProperty("volumeStatus")
    public void setVolumeStatus(VolumeStatus volumeStatus) {
        this.volumeStatus = volumeStatus;
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
        if (!(o instanceof VolumeMountStatus)) {
            return false;
        }
        VolumeMountStatus other = (VolumeMountStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$mountPath = this.getMountPath();
        Object other$mountPath = other.getMountPath();
        if (this$mountPath == null ? other$mountPath != null : !this$mountPath.equals(other$mountPath)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$readOnly = this.getReadOnly();
        Object other$readOnly = other.getReadOnly();
        if (this$readOnly == null ? other$readOnly != null : !this$readOnly.equals(other$readOnly)) {
            return false;
        }
        Object this$recursiveReadOnly = this.getRecursiveReadOnly();
        Object other$recursiveReadOnly = other.getRecursiveReadOnly();
        if (this$recursiveReadOnly == null ? other$recursiveReadOnly != null : !this$recursiveReadOnly.equals(other$recursiveReadOnly)) {
            return false;
        }
        Object this$volumeStatus = this.getVolumeStatus();
        Object other$volumeStatus = other.getVolumeStatus();
        if (this$volumeStatus == null ? other$volumeStatus != null : !this$volumeStatus.equals(other$volumeStatus)) {
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
        return other instanceof VolumeMountStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $mountPath = this.getMountPath();
        result = result * prime + ($mountPath == null ? 43 : $mountPath.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $readOnly = this.getReadOnly();
        result = result * prime + ($readOnly == null ? 43 : $readOnly.hashCode());
        Object $recursiveReadOnly = this.getRecursiveReadOnly();
        result = result * prime + ($recursiveReadOnly == null ? 43 : $recursiveReadOnly.hashCode());
        Object $volumeStatus = this.getVolumeStatus();
        result = result * prime + ($volumeStatus == null ? 43 : $volumeStatus.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "VolumeMountStatus(" + "mountPath=" + this.getMountPath() + ", name=" + this.getName() + ", readOnly=" + this.getReadOnly() + ", recursiveReadOnly=" + this.getRecursiveReadOnly() + ", volumeStatus=" + this.getVolumeStatus() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
