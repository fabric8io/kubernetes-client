
package io.fabric8.openshift.api.model;

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
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
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
     * Images is set with the result of importing spec.images
     */
    @JsonProperty("images")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ImageImportStatus> getImages() {
        return images;
    }

    /**
     * Images is set with the result of importing spec.images
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

}
