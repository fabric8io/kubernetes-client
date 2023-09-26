
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
import io.fabric8.kubernetes.api.builder.Editable;
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
    "datasetName",
    "datasetUUID"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("jsonschema2pojo")
public class FlockerVolumeSource implements Editable<FlockerVolumeSourceBuilder> , KubernetesResource
{

    @JsonProperty("datasetName")
    private String datasetName;
    @JsonProperty("datasetUUID")
    private String datasetUUID;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public FlockerVolumeSource() {
    }

    public FlockerVolumeSource(String datasetName, String datasetUUID) {
        super();
        this.datasetName = datasetName;
        this.datasetUUID = datasetUUID;
    }

    @JsonProperty("datasetName")
    public String getDatasetName() {
        return datasetName;
    }

    @JsonProperty("datasetName")
    public void setDatasetName(String datasetName) {
        this.datasetName = datasetName;
    }

    @JsonProperty("datasetUUID")
    public String getDatasetUUID() {
        return datasetUUID;
    }

    @JsonProperty("datasetUUID")
    public void setDatasetUUID(String datasetUUID) {
        this.datasetUUID = datasetUUID;
    }

    @JsonIgnore
    public FlockerVolumeSourceBuilder edit() {
        return new FlockerVolumeSourceBuilder(this);
    }

    @JsonIgnore
    public FlockerVolumeSourceBuilder toBuilder() {
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

}
