
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
 * Represents a Flocker volume mounted by the Flocker agent. One and only one of datasetName and datasetUUID should be set. Flocker volumes do not support ownership management or SELinux relabeling.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "datasetName",
    "datasetUUID"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class FlockerVolumeSource implements Editable<FlockerVolumeSourceBuilder>, KubernetesResource
{

    @JsonProperty("datasetName")
    private String datasetName;
    @JsonProperty("datasetUUID")
    private String datasetUUID;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public FlockerVolumeSource() {
    }

    public FlockerVolumeSource(String datasetName, String datasetUUID) {
        super();
        this.datasetName = datasetName;
        this.datasetUUID = datasetUUID;
    }

    /**
     * datasetName is Name of the dataset stored as metadata -&gt; name on the dataset for Flocker should be considered as deprecated
     */
    @JsonProperty("datasetName")
    public String getDatasetName() {
        return datasetName;
    }

    /**
     * datasetName is Name of the dataset stored as metadata -&gt; name on the dataset for Flocker should be considered as deprecated
     */
    @JsonProperty("datasetName")
    public void setDatasetName(String datasetName) {
        this.datasetName = datasetName;
    }

    /**
     * datasetUUID is the UUID of the dataset. This is unique identifier of a Flocker dataset
     */
    @JsonProperty("datasetUUID")
    public String getDatasetUUID() {
        return datasetUUID;
    }

    /**
     * datasetUUID is the UUID of the dataset. This is unique identifier of a Flocker dataset
     */
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
        if (!(o instanceof FlockerVolumeSource)) {
            return false;
        }
        FlockerVolumeSource other = (FlockerVolumeSource) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$datasetName = this.getDatasetName();
        Object other$datasetName = other.getDatasetName();
        if (this$datasetName == null ? other$datasetName != null : !this$datasetName.equals(other$datasetName)) {
            return false;
        }
        Object this$datasetUUID = this.getDatasetUUID();
        Object other$datasetUUID = other.getDatasetUUID();
        if (this$datasetUUID == null ? other$datasetUUID != null : !this$datasetUUID.equals(other$datasetUUID)) {
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
        return other instanceof FlockerVolumeSource;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $datasetName = this.getDatasetName();
        result = result * prime + ($datasetName == null ? 43 : $datasetName.hashCode());
        Object $datasetUUID = this.getDatasetUUID();
        result = result * prime + ($datasetUUID == null ? 43 : $datasetUUID.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "FlockerVolumeSource(" + "datasetName=" + this.getDatasetName() + ", datasetUUID=" + this.getDatasetUUID() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
