
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
 * ImageSignature holds a signature of an image. It allows to verify image identity and possibly other claims as long as the signature is trusted. Based on this information it is possible to restrict runnable images to those matching cluster-wide policy. Mandatory fields should be parsed by clients doing image verification. The others are parsed from signature's content by the server. They serve just an informative purpose.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "conditions",
    "content",
    "created",
    "imageIdentity",
    "issuedBy",
    "issuedTo",
    "signedClaims",
    "type"
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
public class ImageSignature implements Editable<ImageSignatureBuilder>, HasMetadata
{

    @JsonProperty("apiVersion")
    private String apiVersion = "image.openshift.io/v1";
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SignatureCondition> conditions = new ArrayList<>();
    @JsonProperty("content")
    private String content;
    @JsonProperty("created")
    private String created;
    @JsonProperty("imageIdentity")
    private String imageIdentity;
    @JsonProperty("issuedBy")
    private SignatureIssuer issuedBy;
    @JsonProperty("issuedTo")
    private SignatureSubject issuedTo;
    @JsonProperty("kind")
    private String kind = "ImageSignature";
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("signedClaims")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> signedClaims = new LinkedHashMap<>();
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ImageSignature() {
    }

    public ImageSignature(String apiVersion, List<SignatureCondition> conditions, String content, String created, String imageIdentity, SignatureIssuer issuedBy, SignatureSubject issuedTo, String kind, ObjectMeta metadata, Map<String, String> signedClaims, String type) {
        super();
        this.apiVersion = apiVersion;
        this.conditions = conditions;
        this.content = content;
        this.created = created;
        this.imageIdentity = imageIdentity;
        this.issuedBy = issuedBy;
        this.issuedTo = issuedTo;
        this.kind = kind;
        this.metadata = metadata;
        this.signedClaims = signedClaims;
        this.type = type;
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
     * conditions represent the latest available observations of a signature's current state.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SignatureCondition> getConditions() {
        return conditions;
    }

    /**
     * conditions represent the latest available observations of a signature's current state.
     */
    @JsonProperty("conditions")
    public void setConditions(List<SignatureCondition> conditions) {
        this.conditions = conditions;
    }

    /**
     * Required: An opaque binary string which is an image's signature.
     */
    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    /**
     * Required: An opaque binary string which is an image's signature.
     */
    @JsonProperty("content")
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * ImageSignature holds a signature of an image. It allows to verify image identity and possibly other claims as long as the signature is trusted. Based on this information it is possible to restrict runnable images to those matching cluster-wide policy. Mandatory fields should be parsed by clients doing image verification. The others are parsed from signature's content by the server. They serve just an informative purpose.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("created")
    public String getCreated() {
        return created;
    }

    /**
     * ImageSignature holds a signature of an image. It allows to verify image identity and possibly other claims as long as the signature is trusted. Based on this information it is possible to restrict runnable images to those matching cluster-wide policy. Mandatory fields should be parsed by clients doing image verification. The others are parsed from signature's content by the server. They serve just an informative purpose.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("created")
    public void setCreated(String created) {
        this.created = created;
    }

    /**
     * A human readable string representing image's identity. It could be a product name and version, or an image pull spec (e.g. "registry.access.redhat.com/rhel7/rhel:7.2").
     */
    @JsonProperty("imageIdentity")
    public String getImageIdentity() {
        return imageIdentity;
    }

    /**
     * A human readable string representing image's identity. It could be a product name and version, or an image pull spec (e.g. "registry.access.redhat.com/rhel7/rhel:7.2").
     */
    @JsonProperty("imageIdentity")
    public void setImageIdentity(String imageIdentity) {
        this.imageIdentity = imageIdentity;
    }

    /**
     * ImageSignature holds a signature of an image. It allows to verify image identity and possibly other claims as long as the signature is trusted. Based on this information it is possible to restrict runnable images to those matching cluster-wide policy. Mandatory fields should be parsed by clients doing image verification. The others are parsed from signature's content by the server. They serve just an informative purpose.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("issuedBy")
    public SignatureIssuer getIssuedBy() {
        return issuedBy;
    }

    /**
     * ImageSignature holds a signature of an image. It allows to verify image identity and possibly other claims as long as the signature is trusted. Based on this information it is possible to restrict runnable images to those matching cluster-wide policy. Mandatory fields should be parsed by clients doing image verification. The others are parsed from signature's content by the server. They serve just an informative purpose.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("issuedBy")
    public void setIssuedBy(SignatureIssuer issuedBy) {
        this.issuedBy = issuedBy;
    }

    /**
     * ImageSignature holds a signature of an image. It allows to verify image identity and possibly other claims as long as the signature is trusted. Based on this information it is possible to restrict runnable images to those matching cluster-wide policy. Mandatory fields should be parsed by clients doing image verification. The others are parsed from signature's content by the server. They serve just an informative purpose.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("issuedTo")
    public SignatureSubject getIssuedTo() {
        return issuedTo;
    }

    /**
     * ImageSignature holds a signature of an image. It allows to verify image identity and possibly other claims as long as the signature is trusted. Based on this information it is possible to restrict runnable images to those matching cluster-wide policy. Mandatory fields should be parsed by clients doing image verification. The others are parsed from signature's content by the server. They serve just an informative purpose.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("issuedTo")
    public void setIssuedTo(SignatureSubject issuedTo) {
        this.issuedTo = issuedTo;
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
     * ImageSignature holds a signature of an image. It allows to verify image identity and possibly other claims as long as the signature is trusted. Based on this information it is possible to restrict runnable images to those matching cluster-wide policy. Mandatory fields should be parsed by clients doing image verification. The others are parsed from signature's content by the server. They serve just an informative purpose.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * ImageSignature holds a signature of an image. It allows to verify image identity and possibly other claims as long as the signature is trusted. Based on this information it is possible to restrict runnable images to those matching cluster-wide policy. Mandatory fields should be parsed by clients doing image verification. The others are parsed from signature's content by the server. They serve just an informative purpose.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * Contains claims from the signature.
     */
    @JsonProperty("signedClaims")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getSignedClaims() {
        return signedClaims;
    }

    /**
     * Contains claims from the signature.
     */
    @JsonProperty("signedClaims")
    public void setSignedClaims(Map<String, String> signedClaims) {
        this.signedClaims = signedClaims;
    }

    /**
     * Required: Describes a type of stored blob.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Required: Describes a type of stored blob.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public ImageSignatureBuilder edit() {
        return new ImageSignatureBuilder(this);
    }

    @JsonIgnore
    public ImageSignatureBuilder toBuilder() {
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
        if (!(o instanceof ImageSignature)) {
            return false;
        }
        ImageSignature other = (ImageSignature) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$apiVersion = this.getApiVersion();
        Object other$apiVersion = other.getApiVersion();
        if (this$apiVersion == null ? other$apiVersion != null : !this$apiVersion.equals(other$apiVersion)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$content = this.getContent();
        Object other$content = other.getContent();
        if (this$content == null ? other$content != null : !this$content.equals(other$content)) {
            return false;
        }
        Object this$created = this.getCreated();
        Object other$created = other.getCreated();
        if (this$created == null ? other$created != null : !this$created.equals(other$created)) {
            return false;
        }
        Object this$imageIdentity = this.getImageIdentity();
        Object other$imageIdentity = other.getImageIdentity();
        if (this$imageIdentity == null ? other$imageIdentity != null : !this$imageIdentity.equals(other$imageIdentity)) {
            return false;
        }
        Object this$issuedBy = this.getIssuedBy();
        Object other$issuedBy = other.getIssuedBy();
        if (this$issuedBy == null ? other$issuedBy != null : !this$issuedBy.equals(other$issuedBy)) {
            return false;
        }
        Object this$issuedTo = this.getIssuedTo();
        Object other$issuedTo = other.getIssuedTo();
        if (this$issuedTo == null ? other$issuedTo != null : !this$issuedTo.equals(other$issuedTo)) {
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
        Object this$signedClaims = this.getSignedClaims();
        Object other$signedClaims = other.getSignedClaims();
        if (this$signedClaims == null ? other$signedClaims != null : !this$signedClaims.equals(other$signedClaims)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
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
        return other instanceof ImageSignature;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiVersion = this.getApiVersion();
        result = result * prime + ($apiVersion == null ? 43 : $apiVersion.hashCode());
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $content = this.getContent();
        result = result * prime + ($content == null ? 43 : $content.hashCode());
        Object $created = this.getCreated();
        result = result * prime + ($created == null ? 43 : $created.hashCode());
        Object $imageIdentity = this.getImageIdentity();
        result = result * prime + ($imageIdentity == null ? 43 : $imageIdentity.hashCode());
        Object $issuedBy = this.getIssuedBy();
        result = result * prime + ($issuedBy == null ? 43 : $issuedBy.hashCode());
        Object $issuedTo = this.getIssuedTo();
        result = result * prime + ($issuedTo == null ? 43 : $issuedTo.hashCode());
        Object $kind = this.getKind();
        result = result * prime + ($kind == null ? 43 : $kind.hashCode());
        Object $metadata = this.getMetadata();
        result = result * prime + ($metadata == null ? 43 : $metadata.hashCode());
        Object $signedClaims = this.getSignedClaims();
        result = result * prime + ($signedClaims == null ? 43 : $signedClaims.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ImageSignature(" + "apiVersion=" + this.getApiVersion() + ", conditions=" + this.getConditions() + ", content=" + this.getContent() + ", created=" + this.getCreated() + ", imageIdentity=" + this.getImageIdentity() + ", issuedBy=" + this.getIssuedBy() + ", issuedTo=" + this.getIssuedTo() + ", kind=" + this.getKind() + ", metadata=" + this.getMetadata() + ", signedClaims=" + this.getSignedClaims() + ", type=" + this.getType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
