
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
 * ImageManifest represents sub-manifests of a manifest list. The Digest field points to a regular Image object.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "architecture",
    "digest",
    "manifestSize",
    "mediaType",
    "os",
    "variant"
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
public class ImageManifest implements Editable<ImageManifestBuilder>, KubernetesResource
{

    @JsonProperty("architecture")
    private String architecture;
    @JsonProperty("digest")
    private String digest;
    @JsonProperty("manifestSize")
    private Long manifestSize;
    @JsonProperty("mediaType")
    private String mediaType;
    @JsonProperty("os")
    private String os;
    @JsonProperty("variant")
    private String variant;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ImageManifest() {
    }

    public ImageManifest(String architecture, String digest, Long manifestSize, String mediaType, String os, String variant) {
        super();
        this.architecture = architecture;
        this.digest = digest;
        this.manifestSize = manifestSize;
        this.mediaType = mediaType;
        this.os = os;
        this.variant = variant;
    }

    /**
     * architecture specifies the supported CPU architecture, for example `amd64` or `ppc64le`.
     */
    @JsonProperty("architecture")
    public String getArchitecture() {
        return architecture;
    }

    /**
     * architecture specifies the supported CPU architecture, for example `amd64` or `ppc64le`.
     */
    @JsonProperty("architecture")
    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }

    /**
     * digest is the unique identifier for the manifest. It refers to an Image object.
     */
    @JsonProperty("digest")
    public String getDigest() {
        return digest;
    }

    /**
     * digest is the unique identifier for the manifest. It refers to an Image object.
     */
    @JsonProperty("digest")
    public void setDigest(String digest) {
        this.digest = digest;
    }

    /**
     * manifestSize represents the size of the raw object contents, in bytes.
     */
    @JsonProperty("manifestSize")
    public Long getManifestSize() {
        return manifestSize;
    }

    /**
     * manifestSize represents the size of the raw object contents, in bytes.
     */
    @JsonProperty("manifestSize")
    public void setManifestSize(Long manifestSize) {
        this.manifestSize = manifestSize;
    }

    /**
     * mediaType defines the type of the manifest, possible values are application/vnd.oci.image.manifest.v1+json, application/vnd.docker.distribution.manifest.v2+json or application/vnd.docker.distribution.manifest.v1+json.
     */
    @JsonProperty("mediaType")
    public String getMediaType() {
        return mediaType;
    }

    /**
     * mediaType defines the type of the manifest, possible values are application/vnd.oci.image.manifest.v1+json, application/vnd.docker.distribution.manifest.v2+json or application/vnd.docker.distribution.manifest.v1+json.
     */
    @JsonProperty("mediaType")
    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    /**
     * os specifies the operating system, for example `linux`.
     */
    @JsonProperty("os")
    public String getOs() {
        return os;
    }

    /**
     * os specifies the operating system, for example `linux`.
     */
    @JsonProperty("os")
    public void setOs(String os) {
        this.os = os;
    }

    /**
     * variant is an optional field repreenting a variant of the CPU, for example v6 to specify a particular CPU variant of the ARM CPU.
     */
    @JsonProperty("variant")
    public String getVariant() {
        return variant;
    }

    /**
     * variant is an optional field repreenting a variant of the CPU, for example v6 to specify a particular CPU variant of the ARM CPU.
     */
    @JsonProperty("variant")
    public void setVariant(String variant) {
        this.variant = variant;
    }

    @JsonIgnore
    public ImageManifestBuilder edit() {
        return new ImageManifestBuilder(this);
    }

    @JsonIgnore
    public ImageManifestBuilder toBuilder() {
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
        if (!(o instanceof ImageManifest)) {
            return false;
        }
        ImageManifest other = (ImageManifest) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$architecture = this.getArchitecture();
        Object other$architecture = other.getArchitecture();
        if (this$architecture == null ? other$architecture != null : !this$architecture.equals(other$architecture)) {
            return false;
        }
        Object this$digest = this.getDigest();
        Object other$digest = other.getDigest();
        if (this$digest == null ? other$digest != null : !this$digest.equals(other$digest)) {
            return false;
        }
        Object this$manifestSize = this.getManifestSize();
        Object other$manifestSize = other.getManifestSize();
        if (this$manifestSize == null ? other$manifestSize != null : !this$manifestSize.equals(other$manifestSize)) {
            return false;
        }
        Object this$mediaType = this.getMediaType();
        Object other$mediaType = other.getMediaType();
        if (this$mediaType == null ? other$mediaType != null : !this$mediaType.equals(other$mediaType)) {
            return false;
        }
        Object this$os = this.getOs();
        Object other$os = other.getOs();
        if (this$os == null ? other$os != null : !this$os.equals(other$os)) {
            return false;
        }
        Object this$variant = this.getVariant();
        Object other$variant = other.getVariant();
        if (this$variant == null ? other$variant != null : !this$variant.equals(other$variant)) {
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
        return other instanceof ImageManifest;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $architecture = this.getArchitecture();
        result = result * prime + ($architecture == null ? 43 : $architecture.hashCode());
        Object $digest = this.getDigest();
        result = result * prime + ($digest == null ? 43 : $digest.hashCode());
        Object $manifestSize = this.getManifestSize();
        result = result * prime + ($manifestSize == null ? 43 : $manifestSize.hashCode());
        Object $mediaType = this.getMediaType();
        result = result * prime + ($mediaType == null ? 43 : $mediaType.hashCode());
        Object $os = this.getOs();
        result = result * prime + ($os == null ? 43 : $os.hashCode());
        Object $variant = this.getVariant();
        result = result * prime + ($variant == null ? 43 : $variant.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ImageManifest(" + "architecture=" + this.getArchitecture() + ", digest=" + this.getDigest() + ", manifestSize=" + this.getManifestSize() + ", mediaType=" + this.getMediaType() + ", os=" + this.getOs() + ", variant=" + this.getVariant() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
