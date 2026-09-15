
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
 * Identity records a successful authentication of a user with an identity provider. The information about the source of authentication is stored on the identity, and the identity is then associated with a single user object. Multiple identities can reference a single user. Information retrieved from the authentication provider is stored in the extra field using a schema determined by the provider.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "extra",
    "providerName",
    "providerUserName",
    "user"
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
@Group("user.openshift.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class Identity implements Editable<IdentityBuilder>, HasMetadata
{

    @JsonProperty("apiVersion")
    private String apiVersion = "user.openshift.io/v1";
    @JsonProperty("extra")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> extra = new LinkedHashMap<>();
    @JsonProperty("kind")
    private String kind = "Identity";
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("providerName")
    private String providerName;
    @JsonProperty("providerUserName")
    private String providerUserName;
    @JsonProperty("user")
    private ObjectReference user;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Identity() {
    }

    public Identity(String apiVersion, Map<String, String> extra, String kind, ObjectMeta metadata, String providerName, String providerUserName, ObjectReference user) {
        super();
        this.apiVersion = apiVersion;
        this.extra = extra;
        this.kind = kind;
        this.metadata = metadata;
        this.providerName = providerName;
        this.providerUserName = providerUserName;
        this.user = user;
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
     * extra holds extra information about this identity
     */
    @JsonProperty("extra")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getExtra() {
        return extra;
    }

    /**
     * extra holds extra information about this identity
     */
    @JsonProperty("extra")
    public void setExtra(Map<String, String> extra) {
        this.extra = extra;
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
     * Identity records a successful authentication of a user with an identity provider. The information about the source of authentication is stored on the identity, and the identity is then associated with a single user object. Multiple identities can reference a single user. Information retrieved from the authentication provider is stored in the extra field using a schema determined by the provider.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * Identity records a successful authentication of a user with an identity provider. The information about the source of authentication is stored on the identity, and the identity is then associated with a single user object. Multiple identities can reference a single user. Information retrieved from the authentication provider is stored in the extra field using a schema determined by the provider.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * providerName is the source of identity information
     */
    @JsonProperty("providerName")
    public String getProviderName() {
        return providerName;
    }

    /**
     * providerName is the source of identity information
     */
    @JsonProperty("providerName")
    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    /**
     * providerUserName uniquely represents this identity in the scope of the provider
     */
    @JsonProperty("providerUserName")
    public String getProviderUserName() {
        return providerUserName;
    }

    /**
     * providerUserName uniquely represents this identity in the scope of the provider
     */
    @JsonProperty("providerUserName")
    public void setProviderUserName(String providerUserName) {
        this.providerUserName = providerUserName;
    }

    /**
     * Identity records a successful authentication of a user with an identity provider. The information about the source of authentication is stored on the identity, and the identity is then associated with a single user object. Multiple identities can reference a single user. Information retrieved from the authentication provider is stored in the extra field using a schema determined by the provider.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("user")
    public ObjectReference getUser() {
        return user;
    }

    /**
     * Identity records a successful authentication of a user with an identity provider. The information about the source of authentication is stored on the identity, and the identity is then associated with a single user object. Multiple identities can reference a single user. Information retrieved from the authentication provider is stored in the extra field using a schema determined by the provider.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("user")
    public void setUser(ObjectReference user) {
        this.user = user;
    }

    @JsonIgnore
    public IdentityBuilder edit() {
        return new IdentityBuilder(this);
    }

    @JsonIgnore
    public IdentityBuilder toBuilder() {
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
        if (!(o instanceof Identity)) {
            return false;
        }
        Identity other = (Identity) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$apiVersion = this.getApiVersion();
        Object other$apiVersion = other.getApiVersion();
        if (this$apiVersion == null ? other$apiVersion != null : !this$apiVersion.equals(other$apiVersion)) {
            return false;
        }
        Object this$extra = this.getExtra();
        Object other$extra = other.getExtra();
        if (this$extra == null ? other$extra != null : !this$extra.equals(other$extra)) {
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
        Object this$providerName = this.getProviderName();
        Object other$providerName = other.getProviderName();
        if (this$providerName == null ? other$providerName != null : !this$providerName.equals(other$providerName)) {
            return false;
        }
        Object this$providerUserName = this.getProviderUserName();
        Object other$providerUserName = other.getProviderUserName();
        if (this$providerUserName == null ? other$providerUserName != null : !this$providerUserName.equals(other$providerUserName)) {
            return false;
        }
        Object this$user = this.getUser();
        Object other$user = other.getUser();
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) {
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
        return other instanceof Identity;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiVersion = this.getApiVersion();
        result = result * prime + ($apiVersion == null ? 43 : $apiVersion.hashCode());
        Object $extra = this.getExtra();
        result = result * prime + ($extra == null ? 43 : $extra.hashCode());
        Object $kind = this.getKind();
        result = result * prime + ($kind == null ? 43 : $kind.hashCode());
        Object $metadata = this.getMetadata();
        result = result * prime + ($metadata == null ? 43 : $metadata.hashCode());
        Object $providerName = this.getProviderName();
        result = result * prime + ($providerName == null ? 43 : $providerName.hashCode());
        Object $providerUserName = this.getProviderUserName();
        result = result * prime + ($providerUserName == null ? 43 : $providerUserName.hashCode());
        Object $user = this.getUser();
        result = result * prime + ($user == null ? 43 : $user.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Identity(" + "apiVersion=" + this.getApiVersion() + ", extra=" + this.getExtra() + ", kind=" + this.getKind() + ", metadata=" + this.getMetadata() + ", providerName=" + this.getProviderName() + ", providerUserName=" + this.getProviderUserName() + ", user=" + this.getUser() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
