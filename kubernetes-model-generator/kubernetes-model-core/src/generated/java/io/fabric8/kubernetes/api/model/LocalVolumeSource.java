
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
 * Local represents directly-attached storage with node affinity
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "fsType",
    "path"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class LocalVolumeSource implements Editable<LocalVolumeSourceBuilder>, KubernetesResource
{

    @JsonProperty("fsType")
    private String fsType;
    @JsonProperty("path")
    private String path;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public LocalVolumeSource() {
    }

    public LocalVolumeSource(String fsType, String path) {
        super();
        this.fsType = fsType;
        this.path = path;
    }

    /**
     * fsType is the filesystem type to mount. It applies only when the Path is a block device. Must be a filesystem type supported by the host operating system. Ex. "ext4", "xfs", "ntfs". The default value is to auto-select a filesystem if unspecified.
     */
    @JsonProperty("fsType")
    public String getFsType() {
        return fsType;
    }

    /**
     * fsType is the filesystem type to mount. It applies only when the Path is a block device. Must be a filesystem type supported by the host operating system. Ex. "ext4", "xfs", "ntfs". The default value is to auto-select a filesystem if unspecified.
     */
    @JsonProperty("fsType")
    public void setFsType(String fsType) {
        this.fsType = fsType;
    }

    /**
     * path of the full path to the volume on the node. It can be either a directory or block device (disk, partition, ...).
     */
    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    /**
     * path of the full path to the volume on the node. It can be either a directory or block device (disk, partition, ...).
     */
    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    @JsonIgnore
    public LocalVolumeSourceBuilder edit() {
        return new LocalVolumeSourceBuilder(this);
    }

    @JsonIgnore
    public LocalVolumeSourceBuilder toBuilder() {
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
        if (!(o instanceof LocalVolumeSource)) {
            return false;
        }
        LocalVolumeSource other = (LocalVolumeSource) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$fsType = this.getFsType();
        Object other$fsType = other.getFsType();
        if (this$fsType == null ? other$fsType != null : !this$fsType.equals(other$fsType)) {
            return false;
        }
        Object this$path = this.getPath();
        Object other$path = other.getPath();
        if (this$path == null ? other$path != null : !this$path.equals(other$path)) {
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
        return other instanceof LocalVolumeSource;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $fsType = this.getFsType();
        result = result * prime + ($fsType == null ? 43 : $fsType.hashCode());
        Object $path = this.getPath();
        result = result * prime + ($path == null ? 43 : $path.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "LocalVolumeSource(" + "fsType=" + this.getFsType() + ", path=" + this.getPath() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
