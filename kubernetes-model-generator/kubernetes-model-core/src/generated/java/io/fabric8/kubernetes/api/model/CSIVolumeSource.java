
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
    "driver",
    "fsType",
    "nodePublishSecretRef",
    "readOnly",
    "volumeAttributes"
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
public class CSIVolumeSource implements KubernetesResource
{

    @JsonProperty("driver")
    private java.lang.String driver;
    @JsonProperty("fsType")
    private java.lang.String fsType;
    @JsonProperty("nodePublishSecretRef")
    private LocalObjectReference nodePublishSecretRef;
    @JsonProperty("readOnly")
    private Boolean readOnly;
    @JsonProperty("volumeAttributes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> volumeAttributes = new LinkedHashMap<String, String>();
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public CSIVolumeSource() {
    }

    public CSIVolumeSource(java.lang.String driver, java.lang.String fsType, LocalObjectReference nodePublishSecretRef, Boolean readOnly, Map<String, String> volumeAttributes) {
        super();
        this.driver = driver;
        this.fsType = fsType;
        this.nodePublishSecretRef = nodePublishSecretRef;
        this.readOnly = readOnly;
        this.volumeAttributes = volumeAttributes;
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

    @JsonProperty("nodePublishSecretRef")
    public LocalObjectReference getNodePublishSecretRef() {
        return nodePublishSecretRef;
    }

    @JsonProperty("nodePublishSecretRef")
    public void setNodePublishSecretRef(LocalObjectReference nodePublishSecretRef) {
        this.nodePublishSecretRef = nodePublishSecretRef;
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

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
