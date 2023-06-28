
package io.fabric8.kubernetes.api.model;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
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
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("jsonschema2pojo")
public class CSIPersistentVolumeSource implements KubernetesResource
{

    @JsonProperty("controllerExpandSecretRef")
    private SecretReference controllerExpandSecretRef;
    @JsonProperty("controllerPublishSecretRef")
    private SecretReference controllerPublishSecretRef;
    @JsonProperty("driver")
    private java.lang.String driver;
    @JsonProperty("fsType")
    private java.lang.String fsType;
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
    private Map<String, String> volumeAttributes = new LinkedHashMap<String, String>();
    @JsonProperty("volumeHandle")
    private java.lang.String volumeHandle;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public CSIPersistentVolumeSource() {
    }

    public CSIPersistentVolumeSource(SecretReference controllerExpandSecretRef, SecretReference controllerPublishSecretRef, java.lang.String driver, java.lang.String fsType, SecretReference nodeExpandSecretRef, SecretReference nodePublishSecretRef, SecretReference nodeStageSecretRef, Boolean readOnly, Map<String, String> volumeAttributes, java.lang.String volumeHandle) {
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

    @JsonProperty("controllerExpandSecretRef")
    public SecretReference getControllerExpandSecretRef() {
        return controllerExpandSecretRef;
    }

    @JsonProperty("controllerExpandSecretRef")
    public void setControllerExpandSecretRef(SecretReference controllerExpandSecretRef) {
        this.controllerExpandSecretRef = controllerExpandSecretRef;
    }

    @JsonProperty("controllerPublishSecretRef")
    public SecretReference getControllerPublishSecretRef() {
        return controllerPublishSecretRef;
    }

    @JsonProperty("controllerPublishSecretRef")
    public void setControllerPublishSecretRef(SecretReference controllerPublishSecretRef) {
        this.controllerPublishSecretRef = controllerPublishSecretRef;
    }

    @JsonProperty("driver")
    public java.lang.String getDriver() {
        return driver;
    }

    @JsonProperty("driver")
    public void setDriver(java.lang.String driver) {
        this.driver = driver;
    }

    @JsonProperty("fsType")
    public java.lang.String getFsType() {
        return fsType;
    }

    @JsonProperty("fsType")
    public void setFsType(java.lang.String fsType) {
        this.fsType = fsType;
    }

    @JsonProperty("nodeExpandSecretRef")
    public SecretReference getNodeExpandSecretRef() {
        return nodeExpandSecretRef;
    }

    @JsonProperty("nodeExpandSecretRef")
    public void setNodeExpandSecretRef(SecretReference nodeExpandSecretRef) {
        this.nodeExpandSecretRef = nodeExpandSecretRef;
    }

    @JsonProperty("nodePublishSecretRef")
    public SecretReference getNodePublishSecretRef() {
        return nodePublishSecretRef;
    }

    @JsonProperty("nodePublishSecretRef")
    public void setNodePublishSecretRef(SecretReference nodePublishSecretRef) {
        this.nodePublishSecretRef = nodePublishSecretRef;
    }

    @JsonProperty("nodeStageSecretRef")
    public SecretReference getNodeStageSecretRef() {
        return nodeStageSecretRef;
    }

    @JsonProperty("nodeStageSecretRef")
    public void setNodeStageSecretRef(SecretReference nodeStageSecretRef) {
        this.nodeStageSecretRef = nodeStageSecretRef;
    }

    @JsonProperty("readOnly")
    public Boolean getReadOnly() {
        return readOnly;
    }

    @JsonProperty("readOnly")
    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    @JsonProperty("volumeAttributes")
    public Map<String, String> getVolumeAttributes() {
        return volumeAttributes;
    }

    @JsonProperty("volumeAttributes")
    public void setVolumeAttributes(Map<String, String> volumeAttributes) {
        this.volumeAttributes = volumeAttributes;
    }

    @JsonProperty("volumeHandle")
    public java.lang.String getVolumeHandle() {
        return volumeHandle;
    }

    @JsonProperty("volumeHandle")
    public void setVolumeHandle(java.lang.String volumeHandle) {
        this.volumeHandle = volumeHandle;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
