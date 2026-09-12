
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
 * Represents a source location of a volume to mount, managed by an external CSI driver
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "driver",
    "fsType",
    "nodePublishSecretRef",
    "readOnly",
    "volumeAttributes"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class CSIVolumeSource implements Editable<CSIVolumeSourceBuilder>, KubernetesResource
{

    @JsonProperty("driver")
    private String driver;
    @JsonProperty("fsType")
    private String fsType;
    @JsonProperty("nodePublishSecretRef")
    private LocalObjectReference nodePublishSecretRef;
    @JsonProperty("readOnly")
    private Boolean readOnly;
    @JsonProperty("volumeAttributes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> volumeAttributes = new LinkedHashMap<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CSIVolumeSource() {
    }

    public CSIVolumeSource(String driver, String fsType, LocalObjectReference nodePublishSecretRef, Boolean readOnly, Map<String, String> volumeAttributes) {
        super();
        this.driver = driver;
        this.fsType = fsType;
        this.nodePublishSecretRef = nodePublishSecretRef;
        this.readOnly = readOnly;
        this.volumeAttributes = volumeAttributes;
    }

    /**
     * driver is the name of the CSI driver that handles this volume. Consult with your admin for the correct name as registered in the cluster.
     */
    @JsonProperty("driver")
    public String getDriver() {
        return driver;
    }

    /**
     * driver is the name of the CSI driver that handles this volume. Consult with your admin for the correct name as registered in the cluster.
     */
    @JsonProperty("driver")
    public void setDriver(String driver) {
        this.driver = driver;
    }

    /**
     * fsType to mount. Ex. "ext4", "xfs", "ntfs". If not provided, the empty value is passed to the associated CSI driver which will determine the default filesystem to apply.
     */
    @JsonProperty("fsType")
    public String getFsType() {
        return fsType;
    }

    /**
     * fsType to mount. Ex. "ext4", "xfs", "ntfs". If not provided, the empty value is passed to the associated CSI driver which will determine the default filesystem to apply.
     */
    @JsonProperty("fsType")
    public void setFsType(String fsType) {
        this.fsType = fsType;
    }

    /**
     * Represents a source location of a volume to mount, managed by an external CSI driver
     */
    @JsonProperty("nodePublishSecretRef")
    public LocalObjectReference getNodePublishSecretRef() {
        return nodePublishSecretRef;
    }

    /**
     * Represents a source location of a volume to mount, managed by an external CSI driver
     */
    @JsonProperty("nodePublishSecretRef")
    public void setNodePublishSecretRef(LocalObjectReference nodePublishSecretRef) {
        this.nodePublishSecretRef = nodePublishSecretRef;
    }

    /**
     * readOnly specifies a read-only configuration for the volume. Defaults to false (read/write).
     */
    @JsonProperty("readOnly")
    public Boolean getReadOnly() {
        return readOnly;
    }

    /**
     * readOnly specifies a read-only configuration for the volume. Defaults to false (read/write).
     */
    @JsonProperty("readOnly")
    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    /**
     * volumeAttributes stores driver-specific properties that are passed to the CSI driver. Consult your driver's documentation for supported values.
     */
    @JsonProperty("volumeAttributes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getVolumeAttributes() {
        return volumeAttributes;
    }

    /**
     * volumeAttributes stores driver-specific properties that are passed to the CSI driver. Consult your driver's documentation for supported values.
     */
    @JsonProperty("volumeAttributes")
    public void setVolumeAttributes(Map<String, String> volumeAttributes) {
        this.volumeAttributes = volumeAttributes;
    }

    @JsonIgnore
    public CSIVolumeSourceBuilder edit() {
        return new CSIVolumeSourceBuilder(this);
    }

    @JsonIgnore
    public CSIVolumeSourceBuilder toBuilder() {
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
        if (!(o instanceof CSIVolumeSource)) {
            return false;
        }
        CSIVolumeSource other = (CSIVolumeSource) o;
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
        Object this$nodePublishSecretRef = this.getNodePublishSecretRef();
        Object other$nodePublishSecretRef = other.getNodePublishSecretRef();
        if (this$nodePublishSecretRef == null ? other$nodePublishSecretRef != null : !this$nodePublishSecretRef.equals(other$nodePublishSecretRef)) {
            return false;
        }
        Object this$readOnly = this.getReadOnly();
        Object other$readOnly = other.getReadOnly();
        if (this$readOnly == null ? other$readOnly != null : !this$readOnly.equals(other$readOnly)) {
            return false;
        }
        Object this$volumeAttributes = this.getVolumeAttributes();
        Object other$volumeAttributes = other.getVolumeAttributes();
        if (this$volumeAttributes == null ? other$volumeAttributes != null : !this$volumeAttributes.equals(other$volumeAttributes)) {
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
        return other instanceof CSIVolumeSource;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $driver = this.getDriver();
        result = result * prime + ($driver == null ? 43 : $driver.hashCode());
        Object $fsType = this.getFsType();
        result = result * prime + ($fsType == null ? 43 : $fsType.hashCode());
        Object $nodePublishSecretRef = this.getNodePublishSecretRef();
        result = result * prime + ($nodePublishSecretRef == null ? 43 : $nodePublishSecretRef.hashCode());
        Object $readOnly = this.getReadOnly();
        result = result * prime + ($readOnly == null ? 43 : $readOnly.hashCode());
        Object $volumeAttributes = this.getVolumeAttributes();
        result = result * prime + ($volumeAttributes == null ? 43 : $volumeAttributes.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "CSIVolumeSource(" + "driver=" + this.getDriver() + ", fsType=" + this.getFsType() + ", nodePublishSecretRef=" + this.getNodePublishSecretRef() + ", readOnly=" + this.getReadOnly() + ", volumeAttributes=" + this.getVolumeAttributes() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
