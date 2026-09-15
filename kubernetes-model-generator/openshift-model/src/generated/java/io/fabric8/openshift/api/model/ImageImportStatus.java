
package io.fabric8.openshift.api.model;

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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * ImageImportStatus describes the result of an image import.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "image",
    "manifests",
    "status",
    "tag"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ImageImportStatus implements Editable<ImageImportStatusBuilder>, KubernetesResource
{

    @JsonProperty("image")
    private Image image;
    @JsonProperty("manifests")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Image> manifests = new ArrayList<>();
    @JsonProperty("status")
    private Status status;
    @JsonProperty("tag")
    private String tag;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ImageImportStatus() {
    }

    public ImageImportStatus(Image image, List<Image> manifests, Status status, String tag) {
        super();
        this.image = image;
        this.manifests = manifests;
        this.status = status;
        this.tag = tag;
    }

    /**
     * ImageImportStatus describes the result of an image import.
     */
    @JsonProperty("image")
    public Image getImage() {
        return image;
    }

    /**
     * ImageImportStatus describes the result of an image import.
     */
    @JsonProperty("image")
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * manifests holds sub-manifests metadata when importing a manifest list
     */
    @JsonProperty("manifests")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Image> getManifests() {
        return manifests;
    }

    /**
     * manifests holds sub-manifests metadata when importing a manifest list
     */
    @JsonProperty("manifests")
    public void setManifests(List<Image> manifests) {
        this.manifests = manifests;
    }

    /**
     * ImageImportStatus describes the result of an image import.
     */
    @JsonProperty("status")
    public Status getStatus() {
        return status;
    }

    /**
     * ImageImportStatus describes the result of an image import.
     */
    @JsonProperty("status")
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * tag is the tag this image was located under, if any
     */
    @JsonProperty("tag")
    public String getTag() {
        return tag;
    }

    /**
     * tag is the tag this image was located under, if any
     */
    @JsonProperty("tag")
    public void setTag(String tag) {
        this.tag = tag;
    }

    @JsonIgnore
    public ImageImportStatusBuilder edit() {
        return new ImageImportStatusBuilder(this);
    }

    @JsonIgnore
    public ImageImportStatusBuilder toBuilder() {
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
        if (!(o instanceof ImageImportStatus)) {
            return false;
        }
        ImageImportStatus other = (ImageImportStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$image = this.getImage();
        Object other$image = other.getImage();
        if (this$image == null ? other$image != null : !this$image.equals(other$image)) {
            return false;
        }
        Object this$manifests = this.getManifests();
        Object other$manifests = other.getManifests();
        if (this$manifests == null ? other$manifests != null : !this$manifests.equals(other$manifests)) {
            return false;
        }
        Object this$status = this.getStatus();
        Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) {
            return false;
        }
        Object this$tag = this.getTag();
        Object other$tag = other.getTag();
        if (this$tag == null ? other$tag != null : !this$tag.equals(other$tag)) {
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
        return other instanceof ImageImportStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $image = this.getImage();
        result = result * prime + ($image == null ? 43 : $image.hashCode());
        Object $manifests = this.getManifests();
        result = result * prime + ($manifests == null ? 43 : $manifests.hashCode());
        Object $status = this.getStatus();
        result = result * prime + ($status == null ? 43 : $status.hashCode());
        Object $tag = this.getTag();
        result = result * prime + ($tag == null ? 43 : $tag.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ImageImportStatus(" + "image=" + this.getImage() + ", manifests=" + this.getManifests() + ", status=" + this.getStatus() + ", tag=" + this.getTag() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
