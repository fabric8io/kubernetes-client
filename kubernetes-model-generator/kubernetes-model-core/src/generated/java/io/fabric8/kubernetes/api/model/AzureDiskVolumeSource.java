
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
    "cachingMode",
    "diskName",
    "diskURI",
    "fsType",
    "readOnly"
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
public class AzureDiskVolumeSource implements KubernetesResource
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
     * 
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

    @JsonProperty("cachingMode")
    public String getCachingMode() {
        return cachingMode;
    }

    @JsonProperty("cachingMode")
    public void setCachingMode(String cachingMode) {
        this.cachingMode = cachingMode;
    }

    @JsonProperty("diskName")
    public String getDiskName() {
        return diskName;
    }

    @JsonProperty("diskName")
    public void setDiskName(String diskName) {
        this.diskName = diskName;
    }

    @JsonProperty("diskURI")
    public String getDiskURI() {
        return diskURI;
    }

    @JsonProperty("diskURI")
    public void setDiskURI(String diskURI) {
        this.diskURI = diskURI;
    }

    @JsonProperty("fsType")
    public String getFsType() {
        return fsType;
    }

    @JsonProperty("fsType")
    public void setFsType(String fsType) {
        this.fsType = fsType;
    }

    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty("readOnly")
    public Boolean getReadOnly() {
        return readOnly;
    }

    @JsonProperty("readOnly")
    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
