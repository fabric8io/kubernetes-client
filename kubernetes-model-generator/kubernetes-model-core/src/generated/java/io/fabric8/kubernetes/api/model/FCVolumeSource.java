
package io.fabric8.kubernetes.api.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
 * Represents a Fibre Channel volume. Fibre Channel volumes can only be mounted as read/write once. Fibre Channel volumes support ownership management and SELinux relabeling.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "fsType",
    "lun",
    "readOnly",
    "targetWWNs",
    "wwids"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class FCVolumeSource implements Editable<FCVolumeSourceBuilder>, KubernetesResource
{

    @JsonProperty("fsType")
    private String fsType;
    @JsonProperty("lun")
    private Integer lun;
    @JsonProperty("readOnly")
    private Boolean readOnly;
    @JsonProperty("targetWWNs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> targetWWNs = new ArrayList<>();
    @JsonProperty("wwids")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> wwids = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public FCVolumeSource() {
    }

    public FCVolumeSource(String fsType, Integer lun, Boolean readOnly, List<String> targetWWNs, List<String> wwids) {
        super();
        this.fsType = fsType;
        this.lun = lun;
        this.readOnly = readOnly;
        this.targetWWNs = targetWWNs;
        this.wwids = wwids;
    }

    /**
     * fsType is the filesystem type to mount. Must be a filesystem type supported by the host operating system. Ex. "ext4", "xfs", "ntfs". Implicitly inferred to be "ext4" if unspecified.
     */
    @JsonProperty("fsType")
    public String getFsType() {
        return fsType;
    }

    /**
     * fsType is the filesystem type to mount. Must be a filesystem type supported by the host operating system. Ex. "ext4", "xfs", "ntfs". Implicitly inferred to be "ext4" if unspecified.
     */
    @JsonProperty("fsType")
    public void setFsType(String fsType) {
        this.fsType = fsType;
    }

    /**
     * lun is Optional: FC target lun number
     */
    @JsonProperty("lun")
    public Integer getLun() {
        return lun;
    }

    /**
     * lun is Optional: FC target lun number
     */
    @JsonProperty("lun")
    public void setLun(Integer lun) {
        this.lun = lun;
    }

    /**
     * readOnly is Optional: Defaults to false (read/write). ReadOnly here will force the ReadOnly setting in VolumeMounts.
     */
    @JsonProperty("readOnly")
    public Boolean getReadOnly() {
        return readOnly;
    }

    /**
     * readOnly is Optional: Defaults to false (read/write). ReadOnly here will force the ReadOnly setting in VolumeMounts.
     */
    @JsonProperty("readOnly")
    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    /**
     * targetWWNs is Optional: FC target worldwide names (WWNs)
     */
    @JsonProperty("targetWWNs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getTargetWWNs() {
        return targetWWNs;
    }

    /**
     * targetWWNs is Optional: FC target worldwide names (WWNs)
     */
    @JsonProperty("targetWWNs")
    public void setTargetWWNs(List<String> targetWWNs) {
        this.targetWWNs = targetWWNs;
    }

    /**
     * wwids Optional: FC volume world wide identifiers (wwids) Either wwids or combination of targetWWNs and lun must be set, but not both simultaneously.
     */
    @JsonProperty("wwids")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getWwids() {
        return wwids;
    }

    /**
     * wwids Optional: FC volume world wide identifiers (wwids) Either wwids or combination of targetWWNs and lun must be set, but not both simultaneously.
     */
    @JsonProperty("wwids")
    public void setWwids(List<String> wwids) {
        this.wwids = wwids;
    }

    @JsonIgnore
    public FCVolumeSourceBuilder edit() {
        return new FCVolumeSourceBuilder(this);
    }

    @JsonIgnore
    public FCVolumeSourceBuilder toBuilder() {
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
        if (!(o instanceof FCVolumeSource)) {
            return false;
        }
        FCVolumeSource other = (FCVolumeSource) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$fsType = this.getFsType();
        Object other$fsType = other.getFsType();
        if (this$fsType == null ? other$fsType != null : !this$fsType.equals(other$fsType)) {
            return false;
        }
        Object this$lun = this.getLun();
        Object other$lun = other.getLun();
        if (this$lun == null ? other$lun != null : !this$lun.equals(other$lun)) {
            return false;
        }
        Object this$readOnly = this.getReadOnly();
        Object other$readOnly = other.getReadOnly();
        if (this$readOnly == null ? other$readOnly != null : !this$readOnly.equals(other$readOnly)) {
            return false;
        }
        Object this$targetWWNs = this.getTargetWWNs();
        Object other$targetWWNs = other.getTargetWWNs();
        if (this$targetWWNs == null ? other$targetWWNs != null : !this$targetWWNs.equals(other$targetWWNs)) {
            return false;
        }
        Object this$wwids = this.getWwids();
        Object other$wwids = other.getWwids();
        if (this$wwids == null ? other$wwids != null : !this$wwids.equals(other$wwids)) {
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
        return other instanceof FCVolumeSource;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $fsType = this.getFsType();
        result = result * prime + ($fsType == null ? 43 : $fsType.hashCode());
        Object $lun = this.getLun();
        result = result * prime + ($lun == null ? 43 : $lun.hashCode());
        Object $readOnly = this.getReadOnly();
        result = result * prime + ($readOnly == null ? 43 : $readOnly.hashCode());
        Object $targetWWNs = this.getTargetWWNs();
        result = result * prime + ($targetWWNs == null ? 43 : $targetWWNs.hashCode());
        Object $wwids = this.getWwids();
        result = result * prime + ($wwids == null ? 43 : $wwids.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "FCVolumeSource(" + "fsType=" + this.getFsType() + ", lun=" + this.getLun() + ", readOnly=" + this.getReadOnly() + ", targetWWNs=" + this.getTargetWWNs() + ", wwids=" + this.getWwids() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
