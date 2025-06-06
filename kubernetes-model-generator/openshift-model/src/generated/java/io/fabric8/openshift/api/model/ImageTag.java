
package io.fabric8.openshift.api.model;

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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import io.sundr.transform.annotations.TemplateTransformation;
import io.sundr.transform.annotations.TemplateTransformations;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * ImageTag represents a single tag within an image stream and includes the spec, the status history, and the currently referenced image (if any) of the provided tag. This type replaces the ImageStreamTag by providing a full view of the tag. ImageTags are returned for every spec or status tag present on the image stream. If no tag exists in either form a not found error will be returned by the API. A create operation will succeed if no spec tag has already been defined and the spec field is set. Delete will remove both spec and status elements from the image stream.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "image",
    "spec",
    "status"
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
@TemplateTransformations({
    @TemplateTransformation(value = "/manifest.vm", outputPath = "META-INF/services/io.fabric8.kubernetes.api.model.KubernetesResource", gather = true)
})
@Version("v1")
@Group("image.openshift.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ImageTag implements Editable<ImageTagBuilder>, HasMetadata, Namespaced
{

    @JsonProperty("apiVersion")
    private String apiVersion = "image.openshift.io/v1";
    @JsonProperty("image")
    private Image image;
    @JsonProperty("kind")
    private String kind = "ImageTag";
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("spec")
    private TagReference spec;
    @JsonProperty("status")
    private NamedTagEventList status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ImageTag() {
    }

    public ImageTag(String apiVersion, Image image, String kind, ObjectMeta metadata, TagReference spec, NamedTagEventList status) {
        super();
        this.apiVersion = apiVersion;
        this.image = image;
        this.kind = kind;
        this.metadata = metadata;
        this.spec = spec;
        this.status = status;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     * ImageTag represents a single tag within an image stream and includes the spec, the status history, and the currently referenced image (if any) of the provided tag. This type replaces the ImageStreamTag by providing a full view of the tag. ImageTags are returned for every spec or status tag present on the image stream. If no tag exists in either form a not found error will be returned by the API. A create operation will succeed if no spec tag has already been defined and the spec field is set. Delete will remove both spec and status elements from the image stream.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("image")
    public Image getImage() {
        return image;
    }

    /**
     * ImageTag represents a single tag within an image stream and includes the spec, the status history, and the currently referenced image (if any) of the provided tag. This type replaces the ImageStreamTag by providing a full view of the tag. ImageTags are returned for every spec or status tag present on the image stream. If no tag exists in either form a not found error will be returned by the API. A create operation will succeed if no spec tag has already been defined and the spec field is set. Delete will remove both spec and status elements from the image stream.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("image")
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * ImageTag represents a single tag within an image stream and includes the spec, the status history, and the currently referenced image (if any) of the provided tag. This type replaces the ImageStreamTag by providing a full view of the tag. ImageTags are returned for every spec or status tag present on the image stream. If no tag exists in either form a not found error will be returned by the API. A create operation will succeed if no spec tag has already been defined and the spec field is set. Delete will remove both spec and status elements from the image stream.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * ImageTag represents a single tag within an image stream and includes the spec, the status history, and the currently referenced image (if any) of the provided tag. This type replaces the ImageStreamTag by providing a full view of the tag. ImageTags are returned for every spec or status tag present on the image stream. If no tag exists in either form a not found error will be returned by the API. A create operation will succeed if no spec tag has already been defined and the spec field is set. Delete will remove both spec and status elements from the image stream.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * ImageTag represents a single tag within an image stream and includes the spec, the status history, and the currently referenced image (if any) of the provided tag. This type replaces the ImageStreamTag by providing a full view of the tag. ImageTags are returned for every spec or status tag present on the image stream. If no tag exists in either form a not found error will be returned by the API. A create operation will succeed if no spec tag has already been defined and the spec field is set. Delete will remove both spec and status elements from the image stream.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("spec")
    public TagReference getSpec() {
        return spec;
    }

    /**
     * ImageTag represents a single tag within an image stream and includes the spec, the status history, and the currently referenced image (if any) of the provided tag. This type replaces the ImageStreamTag by providing a full view of the tag. ImageTags are returned for every spec or status tag present on the image stream. If no tag exists in either form a not found error will be returned by the API. A create operation will succeed if no spec tag has already been defined and the spec field is set. Delete will remove both spec and status elements from the image stream.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("spec")
    public void setSpec(TagReference spec) {
        this.spec = spec;
    }

    /**
     * ImageTag represents a single tag within an image stream and includes the spec, the status history, and the currently referenced image (if any) of the provided tag. This type replaces the ImageStreamTag by providing a full view of the tag. ImageTags are returned for every spec or status tag present on the image stream. If no tag exists in either form a not found error will be returned by the API. A create operation will succeed if no spec tag has already been defined and the spec field is set. Delete will remove both spec and status elements from the image stream.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("status")
    public NamedTagEventList getStatus() {
        return status;
    }

    /**
     * ImageTag represents a single tag within an image stream and includes the spec, the status history, and the currently referenced image (if any) of the provided tag. This type replaces the ImageStreamTag by providing a full view of the tag. ImageTags are returned for every spec or status tag present on the image stream. If no tag exists in either form a not found error will be returned by the API. A create operation will succeed if no spec tag has already been defined and the spec field is set. Delete will remove both spec and status elements from the image stream.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("status")
    public void setStatus(NamedTagEventList status) {
        this.status = status;
    }

    @JsonIgnore
    public ImageTagBuilder edit() {
        return new ImageTagBuilder(this);
    }

    @JsonIgnore
    public ImageTagBuilder toBuilder() {
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
