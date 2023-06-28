
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
    "fsType",
    "partition",
    "pdName",
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
public class GCEPersistentDiskVolumeSource implements KubernetesResource
{

    @JsonProperty("fsType")
    private String fsType;
    @JsonProperty("partition")
    private Integer partition;
    @JsonProperty("pdName")
    private String pdName;
    @JsonProperty("readOnly")
    private Boolean readOnly;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public GCEPersistentDiskVolumeSource() {
    }

    public GCEPersistentDiskVolumeSource(String fsType, Integer partition, String pdName, Boolean readOnly) {
        super();
        this.fsType = fsType;
        this.partition = partition;
        this.pdName = pdName;
        this.readOnly = readOnly;
    }

    @JsonProperty("fsType")
    public String getFsType() {
        return fsType;
    }

    @JsonProperty("fsType")
    public void setFsType(String fsType) {
        this.fsType = fsType;
    }

    @JsonProperty("partition")
    public Integer getPartition() {
        return partition;
    }

    @JsonProperty("partition")
    public void setPartition(Integer partition) {
        this.partition = partition;
    }

    @JsonProperty("pdName")
    public String getPdName() {
        return pdName;
    }

    @JsonProperty("pdName")
    public void setPdName(String pdName) {
        this.pdName = pdName;
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
