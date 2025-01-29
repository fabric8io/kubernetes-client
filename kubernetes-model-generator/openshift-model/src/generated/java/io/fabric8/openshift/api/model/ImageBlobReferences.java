
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
 * ImageBlobReferences describes the blob references within an image.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "config",
    "imageMissing",
    "layers",
    "manifests"
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
public class ImageBlobReferences implements Editable<ImageBlobReferencesBuilder>, KubernetesResource
{

    @JsonProperty("config")
    private String config;
    @JsonProperty("imageMissing")
    private Boolean imageMissing;
    @JsonProperty("layers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> layers = new ArrayList<>();
    @JsonProperty("manifests")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> manifests = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ImageBlobReferences() {
    }

    public ImageBlobReferences(String config, Boolean imageMissing, List<String> layers, List<String> manifests) {
        super();
        this.config = config;
        this.imageMissing = imageMissing;
        this.layers = layers;
        this.manifests = manifests;
    }

    /**
     * config, if set, is the blob that contains the image config. Some images do not have separate config blobs and this field will be set to nil if so.
     */
    @JsonProperty("config")
    public String getConfig() {
        return config;
    }

    /**
     * config, if set, is the blob that contains the image config. Some images do not have separate config blobs and this field will be set to nil if so.
     */
    @JsonProperty("config")
    public void setConfig(String config) {
        this.config = config;
    }

    /**
     * imageMissing is true if the image is referenced by the image stream but the image object has been deleted from the API by an administrator. When this field is set, layers and config fields may be empty and callers that depend on the image metadata should consider the image to be unavailable for download or viewing.
     */
    @JsonProperty("imageMissing")
    public Boolean getImageMissing() {
        return imageMissing;
    }

    /**
     * imageMissing is true if the image is referenced by the image stream but the image object has been deleted from the API by an administrator. When this field is set, layers and config fields may be empty and callers that depend on the image metadata should consider the image to be unavailable for download or viewing.
     */
    @JsonProperty("imageMissing")
    public void setImageMissing(Boolean imageMissing) {
        this.imageMissing = imageMissing;
    }

    /**
     * layers is the list of blobs that compose this image, from base layer to top layer. All layers referenced by this array will be defined in the blobs map. Some images may have zero layers.
     */
    @JsonProperty("layers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getLayers() {
        return layers;
    }

    /**
     * layers is the list of blobs that compose this image, from base layer to top layer. All layers referenced by this array will be defined in the blobs map. Some images may have zero layers.
     */
    @JsonProperty("layers")
    public void setLayers(List<String> layers) {
        this.layers = layers;
    }

    /**
     * manifests is the list of other image names that this image points to. For a single architecture image, it is empty. For a multi-arch image, it consists of the digests of single architecture images, such images shouldn't have layers nor config.
     */
    @JsonProperty("manifests")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getManifests() {
        return manifests;
    }

    /**
     * manifests is the list of other image names that this image points to. For a single architecture image, it is empty. For a multi-arch image, it consists of the digests of single architecture images, such images shouldn't have layers nor config.
     */
    @JsonProperty("manifests")
    public void setManifests(List<String> manifests) {
        this.manifests = manifests;
    }

    @JsonIgnore
    public ImageBlobReferencesBuilder edit() {
        return new ImageBlobReferencesBuilder(this);
    }

    @JsonIgnore
    public ImageBlobReferencesBuilder toBuilder() {
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
