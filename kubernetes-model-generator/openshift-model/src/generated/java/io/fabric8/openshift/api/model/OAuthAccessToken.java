
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
import io.sundr.transform.annotations.TemplateTransformation;
import io.sundr.transform.annotations.TemplateTransformations;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * OAuthAccessToken describes an OAuth access token. The name of a token must be prefixed with a `sha256~` string, must not contain "/" or "%" characters and must be at least 32 characters long.<br><p> <br><p> The name of the token is constructed from the actual token by sha256-hashing it and using URL-safe unpadded base64-encoding (as described in RFC4648) on the hashed result.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "authorizeToken",
    "clientName",
    "expiresIn",
    "inactivityTimeoutSeconds",
    "redirectURI",
    "refreshToken",
    "scopes",
    "userName",
    "userUID"
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
@Group("oauth.openshift.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class OAuthAccessToken implements Editable<OAuthAccessTokenBuilder>, HasMetadata
{

    @JsonProperty("apiVersion")
    private String apiVersion = "oauth.openshift.io/v1";
    @JsonProperty("authorizeToken")
    private String authorizeToken;
    @JsonProperty("clientName")
    private String clientName;
    @JsonProperty("expiresIn")
    private Long expiresIn;
    @JsonProperty("inactivityTimeoutSeconds")
    private Integer inactivityTimeoutSeconds;
    @JsonProperty("kind")
    private String kind = "OAuthAccessToken";
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("redirectURI")
    private String redirectURI;
    @JsonProperty("refreshToken")
    private String refreshToken;
    @JsonProperty("scopes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> scopes = new ArrayList<>();
    @JsonProperty("userName")
    private String userName;
    @JsonProperty("userUID")
    private String userUID;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public OAuthAccessToken() {
    }

    public OAuthAccessToken(String apiVersion, String authorizeToken, String clientName, Long expiresIn, Integer inactivityTimeoutSeconds, String kind, ObjectMeta metadata, String redirectURI, String refreshToken, List<String> scopes, String userName, String userUID) {
        super();
        this.apiVersion = apiVersion;
        this.authorizeToken = authorizeToken;
        this.clientName = clientName;
        this.expiresIn = expiresIn;
        this.inactivityTimeoutSeconds = inactivityTimeoutSeconds;
        this.kind = kind;
        this.metadata = metadata;
        this.redirectURI = redirectURI;
        this.refreshToken = refreshToken;
        this.scopes = scopes;
        this.userName = userName;
        this.userUID = userUID;
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
     * AuthorizeToken contains the token that authorized this token
     */
    @JsonProperty("authorizeToken")
    public String getAuthorizeToken() {
        return authorizeToken;
    }

    /**
     * AuthorizeToken contains the token that authorized this token
     */
    @JsonProperty("authorizeToken")
    public void setAuthorizeToken(String authorizeToken) {
        this.authorizeToken = authorizeToken;
    }

    /**
     * ClientName references the client that created this token.
     */
    @JsonProperty("clientName")
    public String getClientName() {
        return clientName;
    }

    /**
     * ClientName references the client that created this token.
     */
    @JsonProperty("clientName")
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * ExpiresIn is the seconds from CreationTime before this token expires.
     */
    @JsonProperty("expiresIn")
    public Long getExpiresIn() {
        return expiresIn;
    }

    /**
     * ExpiresIn is the seconds from CreationTime before this token expires.
     */
    @JsonProperty("expiresIn")
    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

    /**
     * InactivityTimeoutSeconds is the value in seconds, from the CreationTimestamp, after which this token can no longer be used. The value is automatically incremented when the token is used.
     */
    @JsonProperty("inactivityTimeoutSeconds")
    public Integer getInactivityTimeoutSeconds() {
        return inactivityTimeoutSeconds;
    }

    /**
     * InactivityTimeoutSeconds is the value in seconds, from the CreationTimestamp, after which this token can no longer be used. The value is automatically incremented when the token is used.
     */
    @JsonProperty("inactivityTimeoutSeconds")
    public void setInactivityTimeoutSeconds(Integer inactivityTimeoutSeconds) {
        this.inactivityTimeoutSeconds = inactivityTimeoutSeconds;
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
     * OAuthAccessToken describes an OAuth access token. The name of a token must be prefixed with a `sha256~` string, must not contain "/" or "%" characters and must be at least 32 characters long.<br><p> <br><p> The name of the token is constructed from the actual token by sha256-hashing it and using URL-safe unpadded base64-encoding (as described in RFC4648) on the hashed result.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * OAuthAccessToken describes an OAuth access token. The name of a token must be prefixed with a `sha256~` string, must not contain "/" or "%" characters and must be at least 32 characters long.<br><p> <br><p> The name of the token is constructed from the actual token by sha256-hashing it and using URL-safe unpadded base64-encoding (as described in RFC4648) on the hashed result.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * RedirectURI is the redirection associated with the token.
     */
    @JsonProperty("redirectURI")
    public String getRedirectURI() {
        return redirectURI;
    }

    /**
     * RedirectURI is the redirection associated with the token.
     */
    @JsonProperty("redirectURI")
    public void setRedirectURI(String redirectURI) {
        this.redirectURI = redirectURI;
    }

    /**
     * RefreshToken is the value by which this token can be renewed. Can be blank.
     */
    @JsonProperty("refreshToken")
    public String getRefreshToken() {
        return refreshToken;
    }

    /**
     * RefreshToken is the value by which this token can be renewed. Can be blank.
     */
    @JsonProperty("refreshToken")
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    /**
     * Scopes is an array of the requested scopes.
     */
    @JsonProperty("scopes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getScopes() {
        return scopes;
    }

    /**
     * Scopes is an array of the requested scopes.
     */
    @JsonProperty("scopes")
    public void setScopes(List<String> scopes) {
        this.scopes = scopes;
    }

    /**
     * UserName is the user name associated with this token
     */
    @JsonProperty("userName")
    public String getUserName() {
        return userName;
    }

    /**
     * UserName is the user name associated with this token
     */
    @JsonProperty("userName")
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * UserUID is the unique UID associated with this token
     */
    @JsonProperty("userUID")
    public String getUserUID() {
        return userUID;
    }

    /**
     * UserUID is the unique UID associated with this token
     */
    @JsonProperty("userUID")
    public void setUserUID(String userUID) {
        this.userUID = userUID;
    }

    @JsonIgnore
    public OAuthAccessTokenBuilder edit() {
        return new OAuthAccessTokenBuilder(this);
    }

    @JsonIgnore
    public OAuthAccessTokenBuilder toBuilder() {
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
