
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
    "options",
    "readOnly",
    "secretRef"
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
public class FlexVolumeSource implements KubernetesResource
{

    @JsonProperty("driver")
    private java.lang.String driver;
    @JsonProperty("fsType")
    private java.lang.String fsType;
    @JsonProperty("options")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> options = new LinkedHashMap<String, String>();
    @JsonProperty("readOnly")
    private Boolean readOnly;
    @JsonProperty("secretRef")
    private LocalObjectReference secretRef;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public FlexVolumeSource() {
    }

    public FlexVolumeSource(java.lang.String driver, java.lang.String fsType, Map<String, String> options, Boolean readOnly, LocalObjectReference secretRef) {
        super();
        this.driver = driver;
        this.fsType = fsType;
        this.options = options;
        this.readOnly = readOnly;
        this.secretRef = secretRef;
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

    @JsonProperty("options")
    public Map<String, String> getOptions() {
        return options;
    }

    @JsonProperty("options")
    public void setOptions(Map<String, String> options) {
        this.options = options;
    }

    @JsonProperty("readOnly")
    public Boolean getReadOnly() {
        return readOnly;
    }

    @JsonProperty("readOnly")
    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    @JsonProperty("secretRef")
    public LocalObjectReference getSecretRef() {
        return secretRef;
    }

    @JsonProperty("secretRef")
    public void setSecretRef(LocalObjectReference secretRef) {
        this.secretRef = secretRef;
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
