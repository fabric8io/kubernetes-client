
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
 * Represents a vSphere volume resource.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "fsType",
    "storagePolicyID",
    "storagePolicyName",
    "volumePath"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class VsphereVirtualDiskVolumeSource implements Editable<VsphereVirtualDiskVolumeSourceBuilder>, KubernetesResource
{

    @JsonProperty("fsType")
    private String fsType;
    @JsonProperty("storagePolicyID")
    private String storagePolicyID;
    @JsonProperty("storagePolicyName")
    private String storagePolicyName;
    @JsonProperty("volumePath")
    private String volumePath;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VsphereVirtualDiskVolumeSource() {
    }

    public VsphereVirtualDiskVolumeSource(String fsType, String storagePolicyID, String storagePolicyName, String volumePath) {
        super();
        this.fsType = fsType;
        this.storagePolicyID = storagePolicyID;
        this.storagePolicyName = storagePolicyName;
        this.volumePath = volumePath;
    }

    /**
     * fsType is filesystem type to mount. Must be a filesystem type supported by the host operating system. Ex. "ext4", "xfs", "ntfs". Implicitly inferred to be "ext4" if unspecified.
     */
    @JsonProperty("fsType")
    public String getFsType() {
        return fsType;
    }

    /**
     * fsType is filesystem type to mount. Must be a filesystem type supported by the host operating system. Ex. "ext4", "xfs", "ntfs". Implicitly inferred to be "ext4" if unspecified.
     */
    @JsonProperty("fsType")
    public void setFsType(String fsType) {
        this.fsType = fsType;
    }

    /**
     * storagePolicyID is the storage Policy Based Management (SPBM) profile ID associated with the StoragePolicyName.
     */
    @JsonProperty("storagePolicyID")
    public String getStoragePolicyID() {
        return storagePolicyID;
    }

    /**
     * storagePolicyID is the storage Policy Based Management (SPBM) profile ID associated with the StoragePolicyName.
     */
    @JsonProperty("storagePolicyID")
    public void setStoragePolicyID(String storagePolicyID) {
        this.storagePolicyID = storagePolicyID;
    }

    /**
     * storagePolicyName is the storage Policy Based Management (SPBM) profile name.
     */
    @JsonProperty("storagePolicyName")
    public String getStoragePolicyName() {
        return storagePolicyName;
    }

    /**
     * storagePolicyName is the storage Policy Based Management (SPBM) profile name.
     */
    @JsonProperty("storagePolicyName")
    public void setStoragePolicyName(String storagePolicyName) {
        this.storagePolicyName = storagePolicyName;
    }

    /**
     * volumePath is the path that identifies vSphere volume vmdk
     */
    @JsonProperty("volumePath")
    public String getVolumePath() {
        return volumePath;
    }

    /**
     * volumePath is the path that identifies vSphere volume vmdk
     */
    @JsonProperty("volumePath")
    public void setVolumePath(String volumePath) {
        this.volumePath = volumePath;
    }

    @JsonIgnore
    public VsphereVirtualDiskVolumeSourceBuilder edit() {
        return new VsphereVirtualDiskVolumeSourceBuilder(this);
    }

    @JsonIgnore
    public VsphereVirtualDiskVolumeSourceBuilder toBuilder() {
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
        if (!(o instanceof VsphereVirtualDiskVolumeSource)) {
            return false;
        }
        VsphereVirtualDiskVolumeSource other = (VsphereVirtualDiskVolumeSource) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$fsType = this.getFsType();
        Object other$fsType = other.getFsType();
        if (this$fsType == null ? other$fsType != null : !this$fsType.equals(other$fsType)) {
            return false;
        }
        Object this$storagePolicyID = this.getStoragePolicyID();
        Object other$storagePolicyID = other.getStoragePolicyID();
        if (this$storagePolicyID == null ? other$storagePolicyID != null : !this$storagePolicyID.equals(other$storagePolicyID)) {
            return false;
        }
        Object this$storagePolicyName = this.getStoragePolicyName();
        Object other$storagePolicyName = other.getStoragePolicyName();
        if (this$storagePolicyName == null ? other$storagePolicyName != null : !this$storagePolicyName.equals(other$storagePolicyName)) {
            return false;
        }
        Object this$volumePath = this.getVolumePath();
        Object other$volumePath = other.getVolumePath();
        if (this$volumePath == null ? other$volumePath != null : !this$volumePath.equals(other$volumePath)) {
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
        return other instanceof VsphereVirtualDiskVolumeSource;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $fsType = this.getFsType();
        result = result * prime + ($fsType == null ? 43 : $fsType.hashCode());
        Object $storagePolicyID = this.getStoragePolicyID();
        result = result * prime + ($storagePolicyID == null ? 43 : $storagePolicyID.hashCode());
        Object $storagePolicyName = this.getStoragePolicyName();
        result = result * prime + ($storagePolicyName == null ? 43 : $storagePolicyName.hashCode());
        Object $volumePath = this.getVolumePath();
        result = result * prime + ($volumePath == null ? 43 : $volumePath.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "VsphereVirtualDiskVolumeSource(" + "fsType=" + this.getFsType() + ", storagePolicyID=" + this.getStoragePolicyID() + ", storagePolicyName=" + this.getStoragePolicyName() + ", volumePath=" + this.getVolumePath() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
