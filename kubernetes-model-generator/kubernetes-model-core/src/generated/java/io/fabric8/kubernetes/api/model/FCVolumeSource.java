
package io.fabric8.kubernetes.api.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
    "lun",
    "readOnly",
    "targetWWNs",
    "wwids"
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
public class FCVolumeSource implements KubernetesResource
{

    @JsonProperty("fsType")
    private String fsType;
    @JsonProperty("lun")
    private Integer lun;
    @JsonProperty("readOnly")
    private Boolean readOnly;
    @JsonProperty("targetWWNs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> targetWWNs = new ArrayList<String>();
    @JsonProperty("wwids")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> wwids = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
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

    @JsonProperty("fsType")
    public String getFsType() {
        return fsType;
    }

    @JsonProperty("fsType")
    public void setFsType(String fsType) {
        this.fsType = fsType;
    }

    @JsonProperty("lun")
    public Integer getLun() {
        return lun;
    }

    @JsonProperty("lun")
    public void setLun(Integer lun) {
        this.lun = lun;
    }

    @JsonProperty("readOnly")
    public Boolean getReadOnly() {
        return readOnly;
    }

    @JsonProperty("readOnly")
    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    @JsonProperty("targetWWNs")
    public List<String> getTargetWWNs() {
        return targetWWNs;
    }

    @JsonProperty("targetWWNs")
    public void setTargetWWNs(List<String> targetWWNs) {
        this.targetWWNs = targetWWNs;
    }

    @JsonProperty("wwids")
    public List<String> getWwids() {
        return wwids;
    }

    @JsonProperty("wwids")
    public void setWwids(List<String> wwids) {
        this.wwids = wwids;
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
