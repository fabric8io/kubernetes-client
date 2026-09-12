
package io.fabric8.kubernetes.api.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
 * Describe a container image
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "names",
    "sizeBytes"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ContainerImage implements Editable<ContainerImageBuilder>, KubernetesResource
{

    @JsonProperty("names")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> names = new ArrayList<>();
    @JsonProperty("sizeBytes")
    private Long sizeBytes;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ContainerImage() {
    }

    public ContainerImage(List<String> names, Long sizeBytes) {
        super();
        this.names = names;
        this.sizeBytes = sizeBytes;
    }

    /**
     * Names by which this image is known. e.g. ["kubernetes.example/hyperkube:v1.0.7", "cloud-vendor.registry.example/cloud-vendor/hyperkube:v1.0.7"]
     */
    @JsonProperty("names")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getNames() {
        return names;
    }

    /**
     * Names by which this image is known. e.g. ["kubernetes.example/hyperkube:v1.0.7", "cloud-vendor.registry.example/cloud-vendor/hyperkube:v1.0.7"]
     */
    @JsonProperty("names")
    public void setNames(List<String> names) {
        this.names = names;
    }

    /**
     * The size of the image in bytes.
     */
    @JsonProperty("sizeBytes")
    public Long getSizeBytes() {
        return sizeBytes;
    }

    /**
     * The size of the image in bytes.
     */
    @JsonProperty("sizeBytes")
    public void setSizeBytes(Long sizeBytes) {
        this.sizeBytes = sizeBytes;
    }

    @JsonIgnore
    public ContainerImageBuilder edit() {
        return new ContainerImageBuilder(this);
    }

    @JsonIgnore
    public ContainerImageBuilder toBuilder() {
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
        if (!(o instanceof ContainerImage)) {
            return false;
        }
        ContainerImage other = (ContainerImage) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$names = this.getNames();
        Object other$names = other.getNames();
        if (this$names == null ? other$names != null : !this$names.equals(other$names)) {
            return false;
        }
        Object this$sizeBytes = this.getSizeBytes();
        Object other$sizeBytes = other.getSizeBytes();
        if (this$sizeBytes == null ? other$sizeBytes != null : !this$sizeBytes.equals(other$sizeBytes)) {
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
        return other instanceof ContainerImage;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $names = this.getNames();
        result = result * prime + ($names == null ? 43 : $names.hashCode());
        Object $sizeBytes = this.getSizeBytes();
        result = result * prime + ($sizeBytes == null ? 43 : $sizeBytes.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ContainerImage(" + "names=" + this.getNames() + ", sizeBytes=" + this.getSizeBytes() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
