
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
 * OAuthClient describes an OAuth client<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "accessTokenInactivityTimeoutSeconds",
    "accessTokenMaxAgeSeconds",
    "additionalSecrets",
    "grantMethod",
    "redirectURIs",
    "respondWithChallenges",
    "scopeRestrictions",
    "secret"
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
@Group("oauth.openshift.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class OAuthClient implements Editable<OAuthClientBuilder>, HasMetadata
{

    @JsonProperty("accessTokenInactivityTimeoutSeconds")
    private Integer accessTokenInactivityTimeoutSeconds;
    @JsonProperty("accessTokenMaxAgeSeconds")
    private Integer accessTokenMaxAgeSeconds;
    @JsonProperty("additionalSecrets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> additionalSecrets = new ArrayList<>();
    @JsonProperty("apiVersion")
    private String apiVersion = "oauth.openshift.io/v1";
    @JsonProperty("grantMethod")
    private String grantMethod;
    @JsonProperty("kind")
    private String kind = "OAuthClient";
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("redirectURIs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> redirectURIs = new ArrayList<>();
    @JsonProperty("respondWithChallenges")
    private Boolean respondWithChallenges;
    @JsonProperty("scopeRestrictions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ScopeRestriction> scopeRestrictions = new ArrayList<>();
    @JsonProperty("secret")
    private String secret;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public OAuthClient() {
    }

    public OAuthClient(Integer accessTokenInactivityTimeoutSeconds, Integer accessTokenMaxAgeSeconds, List<String> additionalSecrets, String apiVersion, String grantMethod, String kind, ObjectMeta metadata, List<String> redirectURIs, Boolean respondWithChallenges, List<ScopeRestriction> scopeRestrictions, String secret) {
        super();
        this.accessTokenInactivityTimeoutSeconds = accessTokenInactivityTimeoutSeconds;
        this.accessTokenMaxAgeSeconds = accessTokenMaxAgeSeconds;
        this.additionalSecrets = additionalSecrets;
        this.apiVersion = apiVersion;
        this.grantMethod = grantMethod;
        this.kind = kind;
        this.metadata = metadata;
        this.redirectURIs = redirectURIs;
        this.respondWithChallenges = respondWithChallenges;
        this.scopeRestrictions = scopeRestrictions;
        this.secret = secret;
    }

    /**
     * accessTokenInactivityTimeoutSeconds overrides the default token inactivity timeout for tokens granted to this client. The value represents the maximum amount of time that can occur between consecutive uses of the token. Tokens become invalid if they are not used within this temporal window. The user will need to acquire a new token to regain access once a token times out. This value needs to be set only if the default set in configuration is not appropriate for this client. Valid values are: - 0: Tokens for this client never time out - X: Tokens time out if there is no activity for X seconds The current minimum allowed value for X is 300 (5 minutes)<br><p> <br><p> WARNING: existing tokens' timeout will not be affected (lowered) by changing this value
     */
    @JsonProperty("accessTokenInactivityTimeoutSeconds")
    public Integer getAccessTokenInactivityTimeoutSeconds() {
        return accessTokenInactivityTimeoutSeconds;
    }

    /**
     * accessTokenInactivityTimeoutSeconds overrides the default token inactivity timeout for tokens granted to this client. The value represents the maximum amount of time that can occur between consecutive uses of the token. Tokens become invalid if they are not used within this temporal window. The user will need to acquire a new token to regain access once a token times out. This value needs to be set only if the default set in configuration is not appropriate for this client. Valid values are: - 0: Tokens for this client never time out - X: Tokens time out if there is no activity for X seconds The current minimum allowed value for X is 300 (5 minutes)<br><p> <br><p> WARNING: existing tokens' timeout will not be affected (lowered) by changing this value
     */
    @JsonProperty("accessTokenInactivityTimeoutSeconds")
    public void setAccessTokenInactivityTimeoutSeconds(Integer accessTokenInactivityTimeoutSeconds) {
        this.accessTokenInactivityTimeoutSeconds = accessTokenInactivityTimeoutSeconds;
    }

    /**
     * accessTokenMaxAgeSeconds overrides the default access token max age for tokens granted to this client. 0 means no expiration.
     */
    @JsonProperty("accessTokenMaxAgeSeconds")
    public Integer getAccessTokenMaxAgeSeconds() {
        return accessTokenMaxAgeSeconds;
    }

    /**
     * accessTokenMaxAgeSeconds overrides the default access token max age for tokens granted to this client. 0 means no expiration.
     */
    @JsonProperty("accessTokenMaxAgeSeconds")
    public void setAccessTokenMaxAgeSeconds(Integer accessTokenMaxAgeSeconds) {
        this.accessTokenMaxAgeSeconds = accessTokenMaxAgeSeconds;
    }

    /**
     * additionalSecrets holds other secrets that may be used to identify the client.  This is useful for rotation and for service account token validation
     */
    @JsonProperty("additionalSecrets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAdditionalSecrets() {
        return additionalSecrets;
    }

    /**
     * additionalSecrets holds other secrets that may be used to identify the client.  This is useful for rotation and for service account token validation
     */
    @JsonProperty("additionalSecrets")
    public void setAdditionalSecrets(List<String> additionalSecrets) {
        this.additionalSecrets = additionalSecrets;
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
     * grantMethod is a required field which determines how to handle grants for this client. Valid grant handling methods are:<br><p>  - auto:   always approves grant requests, useful for trusted clients<br><p>  - prompt: prompts the end user for approval of grant requests, useful for third-party clients
     */
    @JsonProperty("grantMethod")
    public String getGrantMethod() {
        return grantMethod;
    }

    /**
     * grantMethod is a required field which determines how to handle grants for this client. Valid grant handling methods are:<br><p>  - auto:   always approves grant requests, useful for trusted clients<br><p>  - prompt: prompts the end user for approval of grant requests, useful for third-party clients
     */
    @JsonProperty("grantMethod")
    public void setGrantMethod(String grantMethod) {
        this.grantMethod = grantMethod;
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
     * OAuthClient describes an OAuth client<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * OAuthClient describes an OAuth client<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * redirectURIs is the valid redirection URIs associated with a client
     */
    @JsonProperty("redirectURIs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getRedirectURIs() {
        return redirectURIs;
    }

    /**
     * redirectURIs is the valid redirection URIs associated with a client
     */
    @JsonProperty("redirectURIs")
    public void setRedirectURIs(List<String> redirectURIs) {
        this.redirectURIs = redirectURIs;
    }

    /**
     * respondWithChallenges indicates whether the client wants authentication needed responses made in the form of challenges instead of redirects
     */
    @JsonProperty("respondWithChallenges")
    public Boolean getRespondWithChallenges() {
        return respondWithChallenges;
    }

    /**
     * respondWithChallenges indicates whether the client wants authentication needed responses made in the form of challenges instead of redirects
     */
    @JsonProperty("respondWithChallenges")
    public void setRespondWithChallenges(Boolean respondWithChallenges) {
        this.respondWithChallenges = respondWithChallenges;
    }

    /**
     * scopeRestrictions describes which scopes this client can request.  Each requested scope is checked against each restriction.  If any restriction matches, then the scope is allowed. If no restriction matches, then the scope is denied.
     */
    @JsonProperty("scopeRestrictions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ScopeRestriction> getScopeRestrictions() {
        return scopeRestrictions;
    }

    /**
     * scopeRestrictions describes which scopes this client can request.  Each requested scope is checked against each restriction.  If any restriction matches, then the scope is allowed. If no restriction matches, then the scope is denied.
     */
    @JsonProperty("scopeRestrictions")
    public void setScopeRestrictions(List<ScopeRestriction> scopeRestrictions) {
        this.scopeRestrictions = scopeRestrictions;
    }

    /**
     * secret is the unique secret associated with a client
     */
    @JsonProperty("secret")
    public String getSecret() {
        return secret;
    }

    /**
     * secret is the unique secret associated with a client
     */
    @JsonProperty("secret")
    public void setSecret(String secret) {
        this.secret = secret;
    }

    @JsonIgnore
    public OAuthClientBuilder edit() {
        return new OAuthClientBuilder(this);
    }

    @JsonIgnore
    public OAuthClientBuilder toBuilder() {
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
        if (!(o instanceof OAuthClient)) {
            return false;
        }
        OAuthClient other = (OAuthClient) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$accessTokenInactivityTimeoutSeconds = this.getAccessTokenInactivityTimeoutSeconds();
        Object other$accessTokenInactivityTimeoutSeconds = other.getAccessTokenInactivityTimeoutSeconds();
        if (this$accessTokenInactivityTimeoutSeconds == null ? other$accessTokenInactivityTimeoutSeconds != null : !this$accessTokenInactivityTimeoutSeconds.equals(other$accessTokenInactivityTimeoutSeconds)) {
            return false;
        }
        Object this$accessTokenMaxAgeSeconds = this.getAccessTokenMaxAgeSeconds();
        Object other$accessTokenMaxAgeSeconds = other.getAccessTokenMaxAgeSeconds();
        if (this$accessTokenMaxAgeSeconds == null ? other$accessTokenMaxAgeSeconds != null : !this$accessTokenMaxAgeSeconds.equals(other$accessTokenMaxAgeSeconds)) {
            return false;
        }
        Object this$additionalSecrets = this.getAdditionalSecrets();
        Object other$additionalSecrets = other.getAdditionalSecrets();
        if (this$additionalSecrets == null ? other$additionalSecrets != null : !this$additionalSecrets.equals(other$additionalSecrets)) {
            return false;
        }
        Object this$apiVersion = this.getApiVersion();
        Object other$apiVersion = other.getApiVersion();
        if (this$apiVersion == null ? other$apiVersion != null : !this$apiVersion.equals(other$apiVersion)) {
            return false;
        }
        Object this$grantMethod = this.getGrantMethod();
        Object other$grantMethod = other.getGrantMethod();
        if (this$grantMethod == null ? other$grantMethod != null : !this$grantMethod.equals(other$grantMethod)) {
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
        Object this$redirectURIs = this.getRedirectURIs();
        Object other$redirectURIs = other.getRedirectURIs();
        if (this$redirectURIs == null ? other$redirectURIs != null : !this$redirectURIs.equals(other$redirectURIs)) {
            return false;
        }
        Object this$respondWithChallenges = this.getRespondWithChallenges();
        Object other$respondWithChallenges = other.getRespondWithChallenges();
        if (this$respondWithChallenges == null ? other$respondWithChallenges != null : !this$respondWithChallenges.equals(other$respondWithChallenges)) {
            return false;
        }
        Object this$scopeRestrictions = this.getScopeRestrictions();
        Object other$scopeRestrictions = other.getScopeRestrictions();
        if (this$scopeRestrictions == null ? other$scopeRestrictions != null : !this$scopeRestrictions.equals(other$scopeRestrictions)) {
            return false;
        }
        Object this$secret = this.getSecret();
        Object other$secret = other.getSecret();
        if (this$secret == null ? other$secret != null : !this$secret.equals(other$secret)) {
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
        return other instanceof OAuthClient;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $accessTokenInactivityTimeoutSeconds = this.getAccessTokenInactivityTimeoutSeconds();
        result = result * prime + ($accessTokenInactivityTimeoutSeconds == null ? 43 : $accessTokenInactivityTimeoutSeconds.hashCode());
        Object $accessTokenMaxAgeSeconds = this.getAccessTokenMaxAgeSeconds();
        result = result * prime + ($accessTokenMaxAgeSeconds == null ? 43 : $accessTokenMaxAgeSeconds.hashCode());
        Object $additionalSecrets = this.getAdditionalSecrets();
        result = result * prime + ($additionalSecrets == null ? 43 : $additionalSecrets.hashCode());
        Object $apiVersion = this.getApiVersion();
        result = result * prime + ($apiVersion == null ? 43 : $apiVersion.hashCode());
        Object $grantMethod = this.getGrantMethod();
        result = result * prime + ($grantMethod == null ? 43 : $grantMethod.hashCode());
        Object $kind = this.getKind();
        result = result * prime + ($kind == null ? 43 : $kind.hashCode());
        Object $metadata = this.getMetadata();
        result = result * prime + ($metadata == null ? 43 : $metadata.hashCode());
        Object $redirectURIs = this.getRedirectURIs();
        result = result * prime + ($redirectURIs == null ? 43 : $redirectURIs.hashCode());
        Object $respondWithChallenges = this.getRespondWithChallenges();
        result = result * prime + ($respondWithChallenges == null ? 43 : $respondWithChallenges.hashCode());
        Object $scopeRestrictions = this.getScopeRestrictions();
        result = result * prime + ($scopeRestrictions == null ? 43 : $scopeRestrictions.hashCode());
        Object $secret = this.getSecret();
        result = result * prime + ($secret == null ? 43 : $secret.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "OAuthClient(" + "accessTokenInactivityTimeoutSeconds=" + this.getAccessTokenInactivityTimeoutSeconds() + ", accessTokenMaxAgeSeconds=" + this.getAccessTokenMaxAgeSeconds() + ", additionalSecrets=" + this.getAdditionalSecrets() + ", apiVersion=" + this.getApiVersion() + ", grantMethod=" + this.getGrantMethod() + ", kind=" + this.getKind() + ", metadata=" + this.getMetadata() + ", redirectURIs=" + this.getRedirectURIs() + ", respondWithChallenges=" + this.getRespondWithChallenges() + ", scopeRestrictions=" + this.getScopeRestrictions() + ", secret=" + this.getSecret() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
