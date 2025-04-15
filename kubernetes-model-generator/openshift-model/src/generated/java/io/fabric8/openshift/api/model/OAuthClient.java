
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
import io.fabric8.kubernetes.api.model.LocalObjectReference;
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
@TemplateTransformations({
    @TemplateTransformation(value = "/manifest.vm", outputPath = "META-INF/services/io.fabric8.kubernetes.api.model.KubernetesResource", gather = true)
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
     * AccessTokenInactivityTimeoutSeconds overrides the default token inactivity timeout for tokens granted to this client. The value represents the maximum amount of time that can occur between consecutive uses of the token. Tokens become invalid if they are not used within this temporal window. The user will need to acquire a new token to regain access once a token times out. This value needs to be set only if the default set in configuration is not appropriate for this client. Valid values are: - 0: Tokens for this client never time out - X: Tokens time out if there is no activity for X seconds The current minimum allowed value for X is 300 (5 minutes)<br><p> <br><p> WARNING: existing tokens' timeout will not be affected (lowered) by changing this value
     */
    @JsonProperty("accessTokenInactivityTimeoutSeconds")
    public Integer getAccessTokenInactivityTimeoutSeconds() {
        return accessTokenInactivityTimeoutSeconds;
    }

    /**
     * AccessTokenInactivityTimeoutSeconds overrides the default token inactivity timeout for tokens granted to this client. The value represents the maximum amount of time that can occur between consecutive uses of the token. Tokens become invalid if they are not used within this temporal window. The user will need to acquire a new token to regain access once a token times out. This value needs to be set only if the default set in configuration is not appropriate for this client. Valid values are: - 0: Tokens for this client never time out - X: Tokens time out if there is no activity for X seconds The current minimum allowed value for X is 300 (5 minutes)<br><p> <br><p> WARNING: existing tokens' timeout will not be affected (lowered) by changing this value
     */
    @JsonProperty("accessTokenInactivityTimeoutSeconds")
    public void setAccessTokenInactivityTimeoutSeconds(Integer accessTokenInactivityTimeoutSeconds) {
        this.accessTokenInactivityTimeoutSeconds = accessTokenInactivityTimeoutSeconds;
    }

    /**
     * AccessTokenMaxAgeSeconds overrides the default access token max age for tokens granted to this client. 0 means no expiration.
     */
    @JsonProperty("accessTokenMaxAgeSeconds")
    public Integer getAccessTokenMaxAgeSeconds() {
        return accessTokenMaxAgeSeconds;
    }

    /**
     * AccessTokenMaxAgeSeconds overrides the default access token max age for tokens granted to this client. 0 means no expiration.
     */
    @JsonProperty("accessTokenMaxAgeSeconds")
    public void setAccessTokenMaxAgeSeconds(Integer accessTokenMaxAgeSeconds) {
        this.accessTokenMaxAgeSeconds = accessTokenMaxAgeSeconds;
    }

    /**
     * AdditionalSecrets holds other secrets that may be used to identify the client.  This is useful for rotation and for service account token validation
     */
    @JsonProperty("additionalSecrets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAdditionalSecrets() {
        return additionalSecrets;
    }

    /**
     * AdditionalSecrets holds other secrets that may be used to identify the client.  This is useful for rotation and for service account token validation
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
     * GrantMethod is a required field which determines how to handle grants for this client. Valid grant handling methods are:<br><p>  - auto:   always approves grant requests, useful for trusted clients<br><p>  - prompt: prompts the end user for approval of grant requests, useful for third-party clients
     */
    @JsonProperty("grantMethod")
    public String getGrantMethod() {
        return grantMethod;
    }

    /**
     * GrantMethod is a required field which determines how to handle grants for this client. Valid grant handling methods are:<br><p>  - auto:   always approves grant requests, useful for trusted clients<br><p>  - prompt: prompts the end user for approval of grant requests, useful for third-party clients
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
     * RedirectURIs is the valid redirection URIs associated with a client
     */
    @JsonProperty("redirectURIs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getRedirectURIs() {
        return redirectURIs;
    }

    /**
     * RedirectURIs is the valid redirection URIs associated with a client
     */
    @JsonProperty("redirectURIs")
    public void setRedirectURIs(List<String> redirectURIs) {
        this.redirectURIs = redirectURIs;
    }

    /**
     * RespondWithChallenges indicates whether the client wants authentication needed responses made in the form of challenges instead of redirects
     */
    @JsonProperty("respondWithChallenges")
    public Boolean getRespondWithChallenges() {
        return respondWithChallenges;
    }

    /**
     * RespondWithChallenges indicates whether the client wants authentication needed responses made in the form of challenges instead of redirects
     */
    @JsonProperty("respondWithChallenges")
    public void setRespondWithChallenges(Boolean respondWithChallenges) {
        this.respondWithChallenges = respondWithChallenges;
    }

    /**
     * ScopeRestrictions describes which scopes this client can request.  Each requested scope is checked against each restriction.  If any restriction matches, then the scope is allowed. If no restriction matches, then the scope is denied.
     */
    @JsonProperty("scopeRestrictions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ScopeRestriction> getScopeRestrictions() {
        return scopeRestrictions;
    }

    /**
     * ScopeRestrictions describes which scopes this client can request.  Each requested scope is checked against each restriction.  If any restriction matches, then the scope is allowed. If no restriction matches, then the scope is denied.
     */
    @JsonProperty("scopeRestrictions")
    public void setScopeRestrictions(List<ScopeRestriction> scopeRestrictions) {
        this.scopeRestrictions = scopeRestrictions;
    }

    /**
     * Secret is the unique secret associated with a client
     */
    @JsonProperty("secret")
    public String getSecret() {
        return secret;
    }

    /**
     * Secret is the unique secret associated with a client
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
