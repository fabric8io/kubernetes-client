
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
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
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

/**
 * Image is an immutable representation of a container image and its metadata at a point in time. Images are named by taking a hash of their contents (metadata and content) and any change in format, content, or metadata results in a new name. The images resource is primarily for use by cluster administrators and integrations like the cluster image registry - end users, instead, access images via the imagestreamtags or imagestreamimages resources. While image metadata is stored in the API, any integration that implements the container image registry API must provide its own storage for the raw manifest data, image config, and layer contents.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "dockerImageConfig",
    "dockerImageLayers",
    "dockerImageManifest",
    "dockerImageManifestMediaType",
    "dockerImageManifests",
    "dockerImageMetadata",
    "dockerImageMetadataVersion",
    "dockerImageReference",
    "dockerImageSignatures",
    "signatures"
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
@Version("v1")
@Group("image.openshift.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class Image implements Editable<ImageBuilder>, HasMetadata
{

    @JsonProperty("apiVersion")
    private String apiVersion = "image.openshift.io/v1";
    @JsonProperty("dockerImageConfig")
    private String dockerImageConfig;
    @JsonProperty("dockerImageLayers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ImageLayer> dockerImageLayers = new ArrayList<>();
    @JsonProperty("dockerImageManifest")
    private String dockerImageManifest;
    @JsonProperty("dockerImageManifestMediaType")
    private String dockerImageManifestMediaType;
    @JsonProperty("dockerImageManifests")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ImageManifest> dockerImageManifests = new ArrayList<>();
    @JsonProperty("dockerImageMetadata")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object dockerImageMetadata;
    @JsonProperty("dockerImageMetadataVersion")
    private String dockerImageMetadataVersion;
    @JsonProperty("dockerImageReference")
    private String dockerImageReference;
    @JsonProperty("dockerImageSignatures")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> dockerImageSignatures = new ArrayList<>();
    @JsonProperty("kind")
    private String kind = "Image";
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("signatures")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ImageSignature> signatures = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Image() {
    }

    public Image(String apiVersion, String dockerImageConfig, List<ImageLayer> dockerImageLayers, String dockerImageManifest, String dockerImageManifestMediaType, List<ImageManifest> dockerImageManifests, Object dockerImageMetadata, String dockerImageMetadataVersion, String dockerImageReference, List<String> dockerImageSignatures, String kind, ObjectMeta metadata, List<ImageSignature> signatures) {
        super();
        this.apiVersion = apiVersion;
        this.dockerImageConfig = dockerImageConfig;
        this.dockerImageLayers = dockerImageLayers;
        this.dockerImageManifest = dockerImageManifest;
        this.dockerImageManifestMediaType = dockerImageManifestMediaType;
        this.dockerImageManifests = dockerImageManifests;
        this.dockerImageMetadata = dockerImageMetadata;
        this.dockerImageMetadataVersion = dockerImageMetadataVersion;
        this.dockerImageReference = dockerImageReference;
        this.dockerImageSignatures = dockerImageSignatures;
        this.kind = kind;
        this.metadata = metadata;
        this.signatures = signatures;
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
     * dockerImageConfig is a JSON blob that the runtime uses to set up the container. This is a part of manifest schema v2. Will not be set when the image represents a manifest list.
     */
    @JsonProperty("dockerImageConfig")
    public String getDockerImageConfig() {
        return dockerImageConfig;
    }

    /**
     * dockerImageConfig is a JSON blob that the runtime uses to set up the container. This is a part of manifest schema v2. Will not be set when the image represents a manifest list.
     */
    @JsonProperty("dockerImageConfig")
    public void setDockerImageConfig(String dockerImageConfig) {
        this.dockerImageConfig = dockerImageConfig;
    }

    /**
     * dockerImageLayers represents the layers in the image. May not be set if the image does not define that data or if the image represents a manifest list.
     */
    @JsonProperty("dockerImageLayers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ImageLayer> getDockerImageLayers() {
        return dockerImageLayers;
    }

    /**
     * dockerImageLayers represents the layers in the image. May not be set if the image does not define that data or if the image represents a manifest list.
     */
    @JsonProperty("dockerImageLayers")
    public void setDockerImageLayers(List<ImageLayer> dockerImageLayers) {
        this.dockerImageLayers = dockerImageLayers;
    }

    /**
     * dockerImageManifest is the raw JSON of the manifest
     */
    @JsonProperty("dockerImageManifest")
    public String getDockerImageManifest() {
        return dockerImageManifest;
    }

    /**
     * dockerImageManifest is the raw JSON of the manifest
     */
    @JsonProperty("dockerImageManifest")
    public void setDockerImageManifest(String dockerImageManifest) {
        this.dockerImageManifest = dockerImageManifest;
    }

    /**
     * dockerImageManifestMediaType specifies the mediaType of manifest. This is a part of manifest schema v2.
     */
    @JsonProperty("dockerImageManifestMediaType")
    public String getDockerImageManifestMediaType() {
        return dockerImageManifestMediaType;
    }

    /**
     * dockerImageManifestMediaType specifies the mediaType of manifest. This is a part of manifest schema v2.
     */
    @JsonProperty("dockerImageManifestMediaType")
    public void setDockerImageManifestMediaType(String dockerImageManifestMediaType) {
        this.dockerImageManifestMediaType = dockerImageManifestMediaType;
    }

    /**
     * dockerImageManifests holds information about sub-manifests when the image represents a manifest list. When this field is present, no DockerImageLayers should be specified.
     */
    @JsonProperty("dockerImageManifests")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ImageManifest> getDockerImageManifests() {
        return dockerImageManifests;
    }

    /**
     * dockerImageManifests holds information about sub-manifests when the image represents a manifest list. When this field is present, no DockerImageLayers should be specified.
     */
    @JsonProperty("dockerImageManifests")
    public void setDockerImageManifests(List<ImageManifest> dockerImageManifests) {
        this.dockerImageManifests = dockerImageManifests;
    }

    /**
     * Image is an immutable representation of a container image and its metadata at a point in time. Images are named by taking a hash of their contents (metadata and content) and any change in format, content, or metadata results in a new name. The images resource is primarily for use by cluster administrators and integrations like the cluster image registry - end users, instead, access images via the imagestreamtags or imagestreamimages resources. While image metadata is stored in the API, any integration that implements the container image registry API must provide its own storage for the raw manifest data, image config, and layer contents.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("dockerImageMetadata")
    public Object getDockerImageMetadata() {
        return dockerImageMetadata;
    }

    /**
     * Image is an immutable representation of a container image and its metadata at a point in time. Images are named by taking a hash of their contents (metadata and content) and any change in format, content, or metadata results in a new name. The images resource is primarily for use by cluster administrators and integrations like the cluster image registry - end users, instead, access images via the imagestreamtags or imagestreamimages resources. While image metadata is stored in the API, any integration that implements the container image registry API must provide its own storage for the raw manifest data, image config, and layer contents.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("dockerImageMetadata")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setDockerImageMetadata(Object dockerImageMetadata) {
        this.dockerImageMetadata = dockerImageMetadata;
    }

    /**
     * dockerImageMetadataVersion conveys the version of the object, which if empty defaults to "1.0"
     */
    @JsonProperty("dockerImageMetadataVersion")
    public String getDockerImageMetadataVersion() {
        return dockerImageMetadataVersion;
    }

    /**
     * dockerImageMetadataVersion conveys the version of the object, which if empty defaults to "1.0"
     */
    @JsonProperty("dockerImageMetadataVersion")
    public void setDockerImageMetadataVersion(String dockerImageMetadataVersion) {
        this.dockerImageMetadataVersion = dockerImageMetadataVersion;
    }

    /**
     * dockerImageReference is the string that can be used to pull this image.
     */
    @JsonProperty("dockerImageReference")
    public String getDockerImageReference() {
        return dockerImageReference;
    }

    /**
     * dockerImageReference is the string that can be used to pull this image.
     */
    @JsonProperty("dockerImageReference")
    public void setDockerImageReference(String dockerImageReference) {
        this.dockerImageReference = dockerImageReference;
    }

    /**
     * dockerImageSignatures provides the signatures as opaque blobs. This is a part of manifest schema v1.
     */
    @JsonProperty("dockerImageSignatures")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getDockerImageSignatures() {
        return dockerImageSignatures;
    }

    /**
     * dockerImageSignatures provides the signatures as opaque blobs. This is a part of manifest schema v1.
     */
    @JsonProperty("dockerImageSignatures")
    public void setDockerImageSignatures(List<String> dockerImageSignatures) {
        this.dockerImageSignatures = dockerImageSignatures;
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
     * Image is an immutable representation of a container image and its metadata at a point in time. Images are named by taking a hash of their contents (metadata and content) and any change in format, content, or metadata results in a new name. The images resource is primarily for use by cluster administrators and integrations like the cluster image registry - end users, instead, access images via the imagestreamtags or imagestreamimages resources. While image metadata is stored in the API, any integration that implements the container image registry API must provide its own storage for the raw manifest data, image config, and layer contents.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * Image is an immutable representation of a container image and its metadata at a point in time. Images are named by taking a hash of their contents (metadata and content) and any change in format, content, or metadata results in a new name. The images resource is primarily for use by cluster administrators and integrations like the cluster image registry - end users, instead, access images via the imagestreamtags or imagestreamimages resources. While image metadata is stored in the API, any integration that implements the container image registry API must provide its own storage for the raw manifest data, image config, and layer contents.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * signatures holds all signatures of the image.
     */
    @JsonProperty("signatures")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ImageSignature> getSignatures() {
        return signatures;
    }

    /**
     * signatures holds all signatures of the image.
     */
    @JsonProperty("signatures")
    public void setSignatures(List<ImageSignature> signatures) {
        this.signatures = signatures;
    }

    @JsonIgnore
    public ImageBuilder edit() {
        return new ImageBuilder(this);
    }

    @JsonIgnore
    public ImageBuilder toBuilder() {
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
        if (!(o instanceof Image)) {
            return false;
        }
        Image other = (Image) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$apiVersion = this.getApiVersion();
        Object other$apiVersion = other.getApiVersion();
        if (this$apiVersion == null ? other$apiVersion != null : !this$apiVersion.equals(other$apiVersion)) {
            return false;
        }
        Object this$dockerImageConfig = this.getDockerImageConfig();
        Object other$dockerImageConfig = other.getDockerImageConfig();
        if (this$dockerImageConfig == null ? other$dockerImageConfig != null : !this$dockerImageConfig.equals(other$dockerImageConfig)) {
            return false;
        }
        Object this$dockerImageLayers = this.getDockerImageLayers();
        Object other$dockerImageLayers = other.getDockerImageLayers();
        if (this$dockerImageLayers == null ? other$dockerImageLayers != null : !this$dockerImageLayers.equals(other$dockerImageLayers)) {
            return false;
        }
        Object this$dockerImageManifest = this.getDockerImageManifest();
        Object other$dockerImageManifest = other.getDockerImageManifest();
        if (this$dockerImageManifest == null ? other$dockerImageManifest != null : !this$dockerImageManifest.equals(other$dockerImageManifest)) {
            return false;
        }
        Object this$dockerImageManifestMediaType = this.getDockerImageManifestMediaType();
        Object other$dockerImageManifestMediaType = other.getDockerImageManifestMediaType();
        if (this$dockerImageManifestMediaType == null ? other$dockerImageManifestMediaType != null : !this$dockerImageManifestMediaType.equals(other$dockerImageManifestMediaType)) {
            return false;
        }
        Object this$dockerImageManifests = this.getDockerImageManifests();
        Object other$dockerImageManifests = other.getDockerImageManifests();
        if (this$dockerImageManifests == null ? other$dockerImageManifests != null : !this$dockerImageManifests.equals(other$dockerImageManifests)) {
            return false;
        }
        Object this$dockerImageMetadata = this.getDockerImageMetadata();
        Object other$dockerImageMetadata = other.getDockerImageMetadata();
        if (this$dockerImageMetadata == null ? other$dockerImageMetadata != null : !this$dockerImageMetadata.equals(other$dockerImageMetadata)) {
            return false;
        }
        Object this$dockerImageMetadataVersion = this.getDockerImageMetadataVersion();
        Object other$dockerImageMetadataVersion = other.getDockerImageMetadataVersion();
        if (this$dockerImageMetadataVersion == null ? other$dockerImageMetadataVersion != null : !this$dockerImageMetadataVersion.equals(other$dockerImageMetadataVersion)) {
            return false;
        }
        Object this$dockerImageReference = this.getDockerImageReference();
        Object other$dockerImageReference = other.getDockerImageReference();
        if (this$dockerImageReference == null ? other$dockerImageReference != null : !this$dockerImageReference.equals(other$dockerImageReference)) {
            return false;
        }
        Object this$dockerImageSignatures = this.getDockerImageSignatures();
        Object other$dockerImageSignatures = other.getDockerImageSignatures();
        if (this$dockerImageSignatures == null ? other$dockerImageSignatures != null : !this$dockerImageSignatures.equals(other$dockerImageSignatures)) {
            return false;
        }
        Object this$kind = this.getKind();
        Object other$kind = other.getKind();
        if (this$kind == null ? other$kind != null : !this$kind.equals(other$kind)) {
            return false;
        }
        Object this$metadata = this.getMetadata();
        Object other$metadata = other.getMetadata();
        if (this$metadata == null ? other$metadata != null : !this$metadata.equals(other$metadata)) {
            return false;
        }
        Object this$signatures = this.getSignatures();
        Object other$signatures = other.getSignatures();
        if (this$signatures == null ? other$signatures != null : !this$signatures.equals(other$signatures)) {
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
        return other instanceof Image;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiVersion = this.getApiVersion();
        result = result * prime + ($apiVersion == null ? 43 : $apiVersion.hashCode());
        Object $dockerImageConfig = this.getDockerImageConfig();
        result = result * prime + ($dockerImageConfig == null ? 43 : $dockerImageConfig.hashCode());
        Object $dockerImageLayers = this.getDockerImageLayers();
        result = result * prime + ($dockerImageLayers == null ? 43 : $dockerImageLayers.hashCode());
        Object $dockerImageManifest = this.getDockerImageManifest();
        result = result * prime + ($dockerImageManifest == null ? 43 : $dockerImageManifest.hashCode());
        Object $dockerImageManifestMediaType = this.getDockerImageManifestMediaType();
        result = result * prime + ($dockerImageManifestMediaType == null ? 43 : $dockerImageManifestMediaType.hashCode());
        Object $dockerImageManifests = this.getDockerImageManifests();
        result = result * prime + ($dockerImageManifests == null ? 43 : $dockerImageManifests.hashCode());
        Object $dockerImageMetadata = this.getDockerImageMetadata();
        result = result * prime + ($dockerImageMetadata == null ? 43 : $dockerImageMetadata.hashCode());
        Object $dockerImageMetadataVersion = this.getDockerImageMetadataVersion();
        result = result * prime + ($dockerImageMetadataVersion == null ? 43 : $dockerImageMetadataVersion.hashCode());
        Object $dockerImageReference = this.getDockerImageReference();
        result = result * prime + ($dockerImageReference == null ? 43 : $dockerImageReference.hashCode());
        Object $dockerImageSignatures = this.getDockerImageSignatures();
        result = result * prime + ($dockerImageSignatures == null ? 43 : $dockerImageSignatures.hashCode());
        Object $kind = this.getKind();
        result = result * prime + ($kind == null ? 43 : $kind.hashCode());
        Object $metadata = this.getMetadata();
        result = result * prime + ($metadata == null ? 43 : $metadata.hashCode());
        Object $signatures = this.getSignatures();
        result = result * prime + ($signatures == null ? 43 : $signatures.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Image(" + "apiVersion=" + this.getApiVersion() + ", dockerImageConfig=" + this.getDockerImageConfig() + ", dockerImageLayers=" + this.getDockerImageLayers() + ", dockerImageManifest=" + this.getDockerImageManifest() + ", dockerImageManifestMediaType=" + this.getDockerImageManifestMediaType() + ", dockerImageManifests=" + this.getDockerImageManifests() + ", dockerImageMetadata=" + this.getDockerImageMetadata() + ", dockerImageMetadataVersion=" + this.getDockerImageMetadataVersion() + ", dockerImageReference=" + this.getDockerImageReference() + ", dockerImageSignatures=" + this.getDockerImageSignatures() + ", kind=" + this.getKind() + ", metadata=" + this.getMetadata() + ", signatures=" + this.getSignatures() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
