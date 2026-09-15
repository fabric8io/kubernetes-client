
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
 * VolumeStatus represents the status of a mounted volume. At most one of its members must be specified.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "image"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class VolumeStatus implements Editable<VolumeStatusBuilder>, KubernetesResource
{

    @JsonProperty("image")
    private ImageVolumeStatus image;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VolumeStatus() {
    }

    public VolumeStatus(ImageVolumeStatus image) {
        super();
        this.image = image;
    }

    /**
     * VolumeStatus represents the status of a mounted volume. At most one of its members must be specified.
     */
    @JsonProperty("image")
    public ImageVolumeStatus getImage() {
        return image;
    }

    /**
     * VolumeStatus represents the status of a mounted volume. At most one of its members must be specified.
     */
    @JsonProperty("image")
    public void setImage(ImageVolumeStatus image) {
        this.image = image;
    }

    @JsonIgnore
    public VolumeStatusBuilder edit() {
        return new VolumeStatusBuilder(this);
    }

    @JsonIgnore
    public VolumeStatusBuilder toBuilder() {
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
        if (!(o instanceof VolumeStatus)) {
            return false;
        }
        VolumeStatus other = (VolumeStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$image = this.getImage();
        Object other$image = other.getImage();
        if (this$image == null ? other$image != null : !this$image.equals(other$image)) {
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
        return other instanceof VolumeStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $image = this.getImage();
        result = result * prime + ($image == null ? 43 : $image.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "VolumeStatus(" + "image=" + this.getImage() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
