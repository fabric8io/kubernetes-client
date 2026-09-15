
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
 * AzureDisk represents an Azure Data Disk mount on the host and bind mount to the pod.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "kind",
    "cachingMode",
    "diskName",
    "diskURI",
    "fsType",
    "readOnly"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class AzureDiskVolumeSource implements Editable<AzureDiskVolumeSourceBuilder>, KubernetesResource
{

    @JsonProperty("cachingMode")
    private String cachingMode;
    @JsonProperty("diskName")
    private String diskName;
    @JsonProperty("diskURI")
    private String diskURI;
    @JsonProperty("fsType")
    private String fsType;
    @JsonProperty("kind")
    private String kind;
    @JsonProperty("readOnly")
    private Boolean readOnly;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AzureDiskVolumeSource() {
    }

    public AzureDiskVolumeSource(String cachingMode, String diskName, String diskURI, String fsType, String kind, Boolean readOnly) {
        super();
        this.cachingMode = cachingMode;
        this.diskName = diskName;
        this.diskURI = diskURI;
        this.fsType = fsType;
        this.kind = kind;
        this.readOnly = readOnly;
    }

    /**
     * cachingMode is the Host Caching mode: None, Read Only, Read Write.
     */
    @JsonProperty("cachingMode")
    public String getCachingMode() {
        return cachingMode;
    }

    /**
     * cachingMode is the Host Caching mode: None, Read Only, Read Write.
     */
    @JsonProperty("cachingMode")
    public void setCachingMode(String cachingMode) {
        this.cachingMode = cachingMode;
    }

    /**
     * diskName is the Name of the data disk in the blob storage
     */
    @JsonProperty("diskName")
    public String getDiskName() {
        return diskName;
    }

    /**
     * diskName is the Name of the data disk in the blob storage
     */
    @JsonProperty("diskName")
    public void setDiskName(String diskName) {
        this.diskName = diskName;
    }

    /**
     * diskURI is the URI of data disk in the blob storage
     */
    @JsonProperty("diskURI")
    public String getDiskURI() {
        return diskURI;
    }

    /**
     * diskURI is the URI of data disk in the blob storage
     */
    @JsonProperty("diskURI")
    public void setDiskURI(String diskURI) {
        this.diskURI = diskURI;
    }

    /**
     * fsType is Filesystem type to mount. Must be a filesystem type supported by the host operating system. Ex. "ext4", "xfs", "ntfs". Implicitly inferred to be "ext4" if unspecified.
     */
    @JsonProperty("fsType")
    public String getFsType() {
        return fsType;
    }

    /**
     * fsType is Filesystem type to mount. Must be a filesystem type supported by the host operating system. Ex. "ext4", "xfs", "ntfs". Implicitly inferred to be "ext4" if unspecified.
     */
    @JsonProperty("fsType")
    public void setFsType(String fsType) {
        this.fsType = fsType;
    }

    /**
     * kind expected values are Shared: multiple blob disks per storage account  Dedicated: single blob disk per storage account  Managed: azure managed data disk (only in managed availability set). defaults to shared
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * kind expected values are Shared: multiple blob disks per storage account  Dedicated: single blob disk per storage account  Managed: azure managed data disk (only in managed availability set). defaults to shared
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * readOnly Defaults to false (read/write). ReadOnly here will force the ReadOnly setting in VolumeMounts.
     */
    @JsonProperty("readOnly")
    public Boolean getReadOnly() {
        return readOnly;
    }

    /**
     * readOnly Defaults to false (read/write). ReadOnly here will force the ReadOnly setting in VolumeMounts.
     */
    @JsonProperty("readOnly")
    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    @JsonIgnore
    public AzureDiskVolumeSourceBuilder edit() {
        return new AzureDiskVolumeSourceBuilder(this);
    }

    @JsonIgnore
    public AzureDiskVolumeSourceBuilder toBuilder() {
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
        if (!(o instanceof AzureDiskVolumeSource)) {
            return false;
        }
        AzureDiskVolumeSource other = (AzureDiskVolumeSource) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$cachingMode = this.getCachingMode();
        Object other$cachingMode = other.getCachingMode();
        if (this$cachingMode == null ? other$cachingMode != null : !this$cachingMode.equals(other$cachingMode)) {
            return false;
        }
        Object this$diskName = this.getDiskName();
        Object other$diskName = other.getDiskName();
        if (this$diskName == null ? other$diskName != null : !this$diskName.equals(other$diskName)) {
            return false;
        }
        Object this$diskURI = this.getDiskURI();
        Object other$diskURI = other.getDiskURI();
        if (this$diskURI == null ? other$diskURI != null : !this$diskURI.equals(other$diskURI)) {
            return false;
        }
        Object this$fsType = this.getFsType();
        Object other$fsType = other.getFsType();
        if (this$fsType == null ? other$fsType != null : !this$fsType.equals(other$fsType)) {
            return false;
        }
        Object this$kind = this.getKind();
        Object other$kind = other.getKind();
        if (this$kind == null ? other$kind != null : !this$kind.equals(other$kind)) {
            return false;
        }
        Object this$readOnly = this.getReadOnly();
        Object other$readOnly = other.getReadOnly();
        if (this$readOnly == null ? other$readOnly != null : !this$readOnly.equals(other$readOnly)) {
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
        return other instanceof AzureDiskVolumeSource;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $cachingMode = this.getCachingMode();
        result = result * prime + ($cachingMode == null ? 43 : $cachingMode.hashCode());
        Object $diskName = this.getDiskName();
        result = result * prime + ($diskName == null ? 43 : $diskName.hashCode());
        Object $diskURI = this.getDiskURI();
        result = result * prime + ($diskURI == null ? 43 : $diskURI.hashCode());
        Object $fsType = this.getFsType();
        result = result * prime + ($fsType == null ? 43 : $fsType.hashCode());
        Object $kind = this.getKind();
        result = result * prime + ($kind == null ? 43 : $kind.hashCode());
        Object $readOnly = this.getReadOnly();
        result = result * prime + ($readOnly == null ? 43 : $readOnly.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AzureDiskVolumeSource(" + "cachingMode=" + this.getCachingMode() + ", diskName=" + this.getDiskName() + ", diskURI=" + this.getDiskURI() + ", fsType=" + this.getFsType() + ", kind=" + this.getKind() + ", readOnly=" + this.getReadOnly() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
