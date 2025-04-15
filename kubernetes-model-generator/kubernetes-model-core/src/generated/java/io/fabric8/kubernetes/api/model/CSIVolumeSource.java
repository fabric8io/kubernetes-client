
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
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
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
