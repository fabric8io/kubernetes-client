
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
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * ImageStreamImportStatus contains information about the status of an image stream import.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "images",
    "import",
    "repository"
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
public class ImageStreamImportStatus implements Editable<ImageStreamImportStatusBuilder>, KubernetesResource
{

    @JsonProperty("images")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ImageImportStatus> images = new ArrayList<>();
    @JsonProperty("import")
    private ImageStream _import;
    @JsonProperty("repository")
    private RepositoryImportStatus repository;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ImageStreamImportStatus() {
    }

    public ImageStreamImportStatus(List<ImageImportStatus> images, ImageStream _import, RepositoryImportStatus repository) {
        super();
        this.images = images;
        this._import = _import;
        this.repository = repository;
    }

    /**
     * images is set with the result of importing spec.images
     */
    @JsonProperty("images")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ImageImportStatus> getImages() {
        return images;
    }

    /**
     * images is set with the result of importing spec.images
     */
    @JsonProperty("images")
    public void setImages(List<ImageImportStatus> images) {
        this.images = images;
    }

    /**
     * ImageStreamImportStatus contains information about the status of an image stream import.
     */
    @JsonProperty("import")
    public ImageStream getImport() {
        return _import;
    }

    /**
     * ImageStreamImportStatus contains information about the status of an image stream import.
     */
    @JsonProperty("import")
    public void setImport(ImageStream _import) {
        this._import = _import;
    }

    /**
     * ImageStreamImportStatus contains information about the status of an image stream import.
     */
    @JsonProperty("repository")
    public RepositoryImportStatus getRepository() {
        return repository;
    }

    /**
     * ImageStreamImportStatus contains information about the status of an image stream import.
     */
    @JsonProperty("repository")
    public void setRepository(RepositoryImportStatus repository) {
        this.repository = repository;
    }

    @JsonIgnore
    public ImageStreamImportStatusBuilder edit() {
        return new ImageStreamImportStatusBuilder(this);
    }

    @JsonIgnore
    public ImageStreamImportStatusBuilder toBuilder() {
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
        if (!(o instanceof ImageStreamImportStatus)) {
            return false;
        }
        ImageStreamImportStatus other = (ImageStreamImportStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$images = this.getImages();
        Object other$images = other.getImages();
        if (this$images == null ? other$images != null : !this$images.equals(other$images)) {
            return false;
        }
        Object this$_import = this.getImport();
        Object other$_import = other.getImport();
        if (this$_import == null ? other$_import != null : !this$_import.equals(other$_import)) {
            return false;
        }
        Object this$repository = this.getRepository();
        Object other$repository = other.getRepository();
        if (this$repository == null ? other$repository != null : !this$repository.equals(other$repository)) {
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
        return other instanceof ImageStreamImportStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $images = this.getImages();
        result = result * prime + ($images == null ? 43 : $images.hashCode());
        Object $_import = this.getImport();
        result = result * prime + ($_import == null ? 43 : $_import.hashCode());
        Object $repository = this.getRepository();
        result = result * prime + ($repository == null ? 43 : $repository.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ImageStreamImportStatus(" + "images=" + this.getImages() + ", _import=" + this.getImport() + ", repository=" + this.getRepository() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
