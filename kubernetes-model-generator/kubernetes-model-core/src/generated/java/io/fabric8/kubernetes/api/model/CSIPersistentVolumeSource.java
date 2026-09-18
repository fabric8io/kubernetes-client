
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
 * Represents storage that is managed by an external CSI volume driver
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "controllerExpandSecretRef",
    "controllerPublishSecretRef",
    "driver",
    "fsType",
    "nodeExpandSecretRef",
    "nodePublishSecretRef",
    "nodeStageSecretRef",
    "readOnly",
    "volumeAttributes",
    "volumeHandle"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class CSIPersistentVolumeSource implements Editable<CSIPersistentVolumeSourceBuilder>, KubernetesResource
{

    @JsonProperty("controllerExpandSecretRef")
    private SecretReference controllerExpandSecretRef;
    @JsonProperty("controllerPublishSecretRef")
    private SecretReference controllerPublishSecretRef;
    @JsonProperty("driver")
    private String driver;
    @JsonProperty("fsType")
    private String fsType;
    @JsonProperty("nodeExpandSecretRef")
    private SecretReference nodeExpandSecretRef;
    @JsonProperty("nodePublishSecretRef")
    private SecretReference nodePublishSecretRef;
    @JsonProperty("nodeStageSecretRef")
    private SecretReference nodeStageSecretRef;
    @JsonProperty("readOnly")
    private Boolean readOnly;
    @JsonProperty("volumeAttributes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> volumeAttributes = new LinkedHashMap<>();
    @JsonProperty("volumeHandle")
    private String volumeHandle;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CSIPersistentVolumeSource() {
    }

    public CSIPersistentVolumeSource(SecretReference controllerExpandSecretRef, SecretReference controllerPublishSecretRef, String driver, String fsType, SecretReference nodeExpandSecretRef, SecretReference nodePublishSecretRef, SecretReference nodeStageSecretRef, Boolean readOnly, Map<String, String> volumeAttributes, String volumeHandle) {
        super();
        this.controllerExpandSecretRef = controllerExpandSecretRef;
        this.controllerPublishSecretRef = controllerPublishSecretRef;
        this.driver = driver;
        this.fsType = fsType;
        this.nodeExpandSecretRef = nodeExpandSecretRef;
        this.nodePublishSecretRef = nodePublishSecretRef;
        this.nodeStageSecretRef = nodeStageSecretRef;
        this.readOnly = readOnly;
        this.volumeAttributes = volumeAttributes;
        this.volumeHandle = volumeHandle;
    }

    /**
     * Represents storage that is managed by an external CSI volume driver
     */
    @JsonProperty("controllerExpandSecretRef")
    public SecretReference getControllerExpandSecretRef() {
        return controllerExpandSecretRef;
    }

    /**
     * Represents storage that is managed by an external CSI volume driver
     */
    @JsonProperty("controllerExpandSecretRef")
    public void setControllerExpandSecretRef(SecretReference controllerExpandSecretRef) {
        this.controllerExpandSecretRef = controllerExpandSecretRef;
    }

    /**
     * Represents storage that is managed by an external CSI volume driver
     */
    @JsonProperty("controllerPublishSecretRef")
    public SecretReference getControllerPublishSecretRef() {
        return controllerPublishSecretRef;
    }

    /**
     * Represents storage that is managed by an external CSI volume driver
     */
    @JsonProperty("controllerPublishSecretRef")
    public void setControllerPublishSecretRef(SecretReference controllerPublishSecretRef) {
        this.controllerPublishSecretRef = controllerPublishSecretRef;
    }

    /**
     * driver is the name of the driver to use for this volume. Required.
     */
    @JsonProperty("driver")
    public String getDriver() {
        return driver;
    }

    /**
     * driver is the name of the driver to use for this volume. Required.
     */
    @JsonProperty("driver")
    public void setDriver(String driver) {
        this.driver = driver;
    }

    /**
     * fsType to mount. Must be a filesystem type supported by the host operating system. Ex. "ext4", "xfs", "ntfs".
     */
    @JsonProperty("fsType")
    public String getFsType() {
        return fsType;
    }

    /**
     * fsType to mount. Must be a filesystem type supported by the host operating system. Ex. "ext4", "xfs", "ntfs".
     */
    @JsonProperty("fsType")
    public void setFsType(String fsType) {
        this.fsType = fsType;
    }

    /**
     * Represents storage that is managed by an external CSI volume driver
     */
    @JsonProperty("nodeExpandSecretRef")
    public SecretReference getNodeExpandSecretRef() {
        return nodeExpandSecretRef;
    }

    /**
     * Represents storage that is managed by an external CSI volume driver
     */
    @JsonProperty("nodeExpandSecretRef")
    public void setNodeExpandSecretRef(SecretReference nodeExpandSecretRef) {
        this.nodeExpandSecretRef = nodeExpandSecretRef;
    }

    /**
     * Represents storage that is managed by an external CSI volume driver
     */
    @JsonProperty("nodePublishSecretRef")
    public SecretReference getNodePublishSecretRef() {
        return nodePublishSecretRef;
    }

    /**
     * Represents storage that is managed by an external CSI volume driver
     */
    @JsonProperty("nodePublishSecretRef")
    public void setNodePublishSecretRef(SecretReference nodePublishSecretRef) {
        this.nodePublishSecretRef = nodePublishSecretRef;
    }

    /**
     * Represents storage that is managed by an external CSI volume driver
     */
    @JsonProperty("nodeStageSecretRef")
    public SecretReference getNodeStageSecretRef() {
        return nodeStageSecretRef;
    }

    /**
     * Represents storage that is managed by an external CSI volume driver
     */
    @JsonProperty("nodeStageSecretRef")
    public void setNodeStageSecretRef(SecretReference nodeStageSecretRef) {
        this.nodeStageSecretRef = nodeStageSecretRef;
    }

    /**
     * readOnly value to pass to ControllerPublishVolumeRequest. Defaults to false (read/write).
     */
    @JsonProperty("readOnly")
    public Boolean getReadOnly() {
        return readOnly;
    }

    /**
     * readOnly value to pass to ControllerPublishVolumeRequest. Defaults to false (read/write).
     */
    @JsonProperty("readOnly")
    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    /**
     * volumeAttributes of the volume to publish.
     */
    @JsonProperty("volumeAttributes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getVolumeAttributes() {
        return volumeAttributes;
    }

    /**
     * volumeAttributes of the volume to publish.
     */
    @JsonProperty("volumeAttributes")
    public void setVolumeAttributes(Map<String, String> volumeAttributes) {
        this.volumeAttributes = volumeAttributes;
    }

    /**
     * volumeHandle is the unique volume name returned by the CSI volume plugin’s CreateVolume to refer to the volume on all subsequent calls. Required.
     */
    @JsonProperty("volumeHandle")
    public String getVolumeHandle() {
        return volumeHandle;
    }

    /**
     * volumeHandle is the unique volume name returned by the CSI volume plugin’s CreateVolume to refer to the volume on all subsequent calls. Required.
     */
    @JsonProperty("volumeHandle")
    public void setVolumeHandle(String volumeHandle) {
        this.volumeHandle = volumeHandle;
    }

    @JsonIgnore
    public CSIPersistentVolumeSourceBuilder edit() {
        return new CSIPersistentVolumeSourceBuilder(this);
    }

    @JsonIgnore
    public CSIPersistentVolumeSourceBuilder toBuilder() {
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
        if (!(o instanceof CSIPersistentVolumeSource)) {
            return false;
        }
        CSIPersistentVolumeSource other = (CSIPersistentVolumeSource) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$controllerExpandSecretRef = this.getControllerExpandSecretRef();
        Object other$controllerExpandSecretRef = other.getControllerExpandSecretRef();
        if (this$controllerExpandSecretRef == null ? other$controllerExpandSecretRef != null : !this$controllerExpandSecretRef.equals(other$controllerExpandSecretRef)) {
            return false;
        }
        Object this$controllerPublishSecretRef = this.getControllerPublishSecretRef();
        Object other$controllerPublishSecretRef = other.getControllerPublishSecretRef();
        if (this$controllerPublishSecretRef == null ? other$controllerPublishSecretRef != null : !this$controllerPublishSecretRef.equals(other$controllerPublishSecretRef)) {
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
        Object this$nodeExpandSecretRef = this.getNodeExpandSecretRef();
        Object other$nodeExpandSecretRef = other.getNodeExpandSecretRef();
        if (this$nodeExpandSecretRef == null ? other$nodeExpandSecretRef != null : !this$nodeExpandSecretRef.equals(other$nodeExpandSecretRef)) {
            return false;
        }
        Object this$nodePublishSecretRef = this.getNodePublishSecretRef();
        Object other$nodePublishSecretRef = other.getNodePublishSecretRef();
        if (this$nodePublishSecretRef == null ? other$nodePublishSecretRef != null : !this$nodePublishSecretRef.equals(other$nodePublishSecretRef)) {
            return false;
        }
        Object this$nodeStageSecretRef = this.getNodeStageSecretRef();
        Object other$nodeStageSecretRef = other.getNodeStageSecretRef();
        if (this$nodeStageSecretRef == null ? other$nodeStageSecretRef != null : !this$nodeStageSecretRef.equals(other$nodeStageSecretRef)) {
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
        Object this$volumeHandle = this.getVolumeHandle();
        Object other$volumeHandle = other.getVolumeHandle();
        if (this$volumeHandle == null ? other$volumeHandle != null : !this$volumeHandle.equals(other$volumeHandle)) {
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
        return other instanceof CSIPersistentVolumeSource;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $controllerExpandSecretRef = this.getControllerExpandSecretRef();
        result = result * prime + ($controllerExpandSecretRef == null ? 43 : $controllerExpandSecretRef.hashCode());
        Object $controllerPublishSecretRef = this.getControllerPublishSecretRef();
        result = result * prime + ($controllerPublishSecretRef == null ? 43 : $controllerPublishSecretRef.hashCode());
        Object $driver = this.getDriver();
        result = result * prime + ($driver == null ? 43 : $driver.hashCode());
        Object $fsType = this.getFsType();
        result = result * prime + ($fsType == null ? 43 : $fsType.hashCode());
        Object $nodeExpandSecretRef = this.getNodeExpandSecretRef();
        result = result * prime + ($nodeExpandSecretRef == null ? 43 : $nodeExpandSecretRef.hashCode());
        Object $nodePublishSecretRef = this.getNodePublishSecretRef();
        result = result * prime + ($nodePublishSecretRef == null ? 43 : $nodePublishSecretRef.hashCode());
        Object $nodeStageSecretRef = this.getNodeStageSecretRef();
        result = result * prime + ($nodeStageSecretRef == null ? 43 : $nodeStageSecretRef.hashCode());
        Object $readOnly = this.getReadOnly();
        result = result * prime + ($readOnly == null ? 43 : $readOnly.hashCode());
        Object $volumeAttributes = this.getVolumeAttributes();
        result = result * prime + ($volumeAttributes == null ? 43 : $volumeAttributes.hashCode());
        Object $volumeHandle = this.getVolumeHandle();
        result = result * prime + ($volumeHandle == null ? 43 : $volumeHandle.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "CSIPersistentVolumeSource(" + "controllerExpandSecretRef=" + this.getControllerExpandSecretRef() + ", controllerPublishSecretRef=" + this.getControllerPublishSecretRef() + ", driver=" + this.getDriver() + ", fsType=" + this.getFsType() + ", nodeExpandSecretRef=" + this.getNodeExpandSecretRef() + ", nodePublishSecretRef=" + this.getNodePublishSecretRef() + ", nodeStageSecretRef=" + this.getNodeStageSecretRef() + ", readOnly=" + this.getReadOnly() + ", volumeAttributes=" + this.getVolumeAttributes() + ", volumeHandle=" + this.getVolumeHandle() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
