
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * ImageStreamImportSpec defines what images should be imported.
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
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ImageStreamImportSpec implements Editable<ImageStreamImportSpecBuilder>, KubernetesResource
{

    @JsonProperty("images")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ImageImportSpec> images = new ArrayList<>();
    @JsonProperty("import")
    private Boolean _import;
    @JsonProperty("repository")
    private RepositoryImportSpec repository;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ImageStreamImportSpec() {
    }

    public ImageStreamImportSpec(List<ImageImportSpec> images, Boolean _import, RepositoryImportSpec repository) {
        super();
        this.images = images;
        this._import = _import;
        this.repository = repository;
    }

    /**
     * Images are a list of individual images to import.
     */
    @JsonProperty("images")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ImageImportSpec> getImages() {
        return images;
    }

    /**
     * Images are a list of individual images to import.
     */
    @JsonProperty("images")
    public void setImages(List<ImageImportSpec> images) {
        this.images = images;
    }

    /**
     * Import indicates whether to perform an import - if so, the specified tags are set on the spec and status of the image stream defined by the type meta.
     */
    @JsonProperty("import")
    public Boolean getImport() {
        return _import;
    }

    /**
     * Import indicates whether to perform an import - if so, the specified tags are set on the spec and status of the image stream defined by the type meta.
     */
    @JsonProperty("import")
    public void setImport(Boolean _import) {
        this._import = _import;
    }

    /**
     * ImageStreamImportSpec defines what images should be imported.
     */
    @JsonProperty("repository")
    public RepositoryImportSpec getRepository() {
        return repository;
    }

    /**
     * ImageStreamImportSpec defines what images should be imported.
     */
    @JsonProperty("repository")
    public void setRepository(RepositoryImportSpec repository) {
        this.repository = repository;
    }

    @JsonIgnore
    public ImageStreamImportSpecBuilder edit() {
        return new ImageStreamImportSpecBuilder(this);
    }

    @JsonIgnore
    public ImageStreamImportSpecBuilder toBuilder() {
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

}
