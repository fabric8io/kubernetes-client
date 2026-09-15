
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
 * UserOAuthAccessToken is a virtual resource to mirror OAuthAccessTokens to the user the access token was issued for
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
public class UserOAuthAccessToken implements Editable<UserOAuthAccessTokenBuilder>, HasMetadata
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
    private String kind = "UserOAuthAccessToken";
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
    public UserOAuthAccessToken() {
    }

    public UserOAuthAccessToken(String apiVersion, String authorizeToken, String clientName, Long expiresIn, Integer inactivityTimeoutSeconds, String kind, ObjectMeta metadata, String redirectURI, String refreshToken, List<String> scopes, String userName, String userUID) {
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
     * authorizeToken contains the token that authorized this token
     */
    @JsonProperty("authorizeToken")
    public String getAuthorizeToken() {
        return authorizeToken;
    }

    /**
     * authorizeToken contains the token that authorized this token
     */
    @JsonProperty("authorizeToken")
    public void setAuthorizeToken(String authorizeToken) {
        this.authorizeToken = authorizeToken;
    }

    /**
     * clientName references the client that created this token.
     */
    @JsonProperty("clientName")
    public String getClientName() {
        return clientName;
    }

    /**
     * clientName references the client that created this token.
     */
    @JsonProperty("clientName")
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * expiresIn is the seconds from CreationTime before this token expires.
     */
    @JsonProperty("expiresIn")
    public Long getExpiresIn() {
        return expiresIn;
    }

    /**
     * expiresIn is the seconds from CreationTime before this token expires.
     */
    @JsonProperty("expiresIn")
    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

    /**
     * inactivityTimeoutSeconds is the value in seconds, from the CreationTimestamp, after which this token can no longer be used. The value is automatically incremented when the token is used.
     */
    @JsonProperty("inactivityTimeoutSeconds")
    public Integer getInactivityTimeoutSeconds() {
        return inactivityTimeoutSeconds;
    }

    /**
     * inactivityTimeoutSeconds is the value in seconds, from the CreationTimestamp, after which this token can no longer be used. The value is automatically incremented when the token is used.
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
     * UserOAuthAccessToken is a virtual resource to mirror OAuthAccessTokens to the user the access token was issued for
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * UserOAuthAccessToken is a virtual resource to mirror OAuthAccessTokens to the user the access token was issued for
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * redirectURI is the redirection associated with the token.
     */
    @JsonProperty("redirectURI")
    public String getRedirectURI() {
        return redirectURI;
    }

    /**
     * redirectURI is the redirection associated with the token.
     */
    @JsonProperty("redirectURI")
    public void setRedirectURI(String redirectURI) {
        this.redirectURI = redirectURI;
    }

    /**
     * refreshToken is the value by which this token can be renewed. Can be blank.
     */
    @JsonProperty("refreshToken")
    public String getRefreshToken() {
        return refreshToken;
    }

    /**
     * refreshToken is the value by which this token can be renewed. Can be blank.
     */
    @JsonProperty("refreshToken")
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    /**
     * scopes is an array of the requested scopes.
     */
    @JsonProperty("scopes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getScopes() {
        return scopes;
    }

    /**
     * scopes is an array of the requested scopes.
     */
    @JsonProperty("scopes")
    public void setScopes(List<String> scopes) {
        this.scopes = scopes;
    }

    /**
     * userName is the user name associated with this token
     */
    @JsonProperty("userName")
    public String getUserName() {
        return userName;
    }

    /**
     * userName is the user name associated with this token
     */
    @JsonProperty("userName")
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * userUID is the unique UID associated with this token
     */
    @JsonProperty("userUID")
    public String getUserUID() {
        return userUID;
    }

    /**
     * userUID is the unique UID associated with this token
     */
    @JsonProperty("userUID")
    public void setUserUID(String userUID) {
        this.userUID = userUID;
    }

    @JsonIgnore
    public UserOAuthAccessTokenBuilder edit() {
        return new UserOAuthAccessTokenBuilder(this);
    }

    @JsonIgnore
    public UserOAuthAccessTokenBuilder toBuilder() {
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
        if (!(o instanceof UserOAuthAccessToken)) {
            return false;
        }
        UserOAuthAccessToken other = (UserOAuthAccessToken) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$apiVersion = this.getApiVersion();
        Object other$apiVersion = other.getApiVersion();
        if (this$apiVersion == null ? other$apiVersion != null : !this$apiVersion.equals(other$apiVersion)) {
            return false;
        }
        Object this$authorizeToken = this.getAuthorizeToken();
        Object other$authorizeToken = other.getAuthorizeToken();
        if (this$authorizeToken == null ? other$authorizeToken != null : !this$authorizeToken.equals(other$authorizeToken)) {
            return false;
        }
        Object this$clientName = this.getClientName();
        Object other$clientName = other.getClientName();
        if (this$clientName == null ? other$clientName != null : !this$clientName.equals(other$clientName)) {
            return false;
        }
        Object this$expiresIn = this.getExpiresIn();
        Object other$expiresIn = other.getExpiresIn();
        if (this$expiresIn == null ? other$expiresIn != null : !this$expiresIn.equals(other$expiresIn)) {
            return false;
        }
        Object this$inactivityTimeoutSeconds = this.getInactivityTimeoutSeconds();
        Object other$inactivityTimeoutSeconds = other.getInactivityTimeoutSeconds();
        if (this$inactivityTimeoutSeconds == null ? other$inactivityTimeoutSeconds != null : !this$inactivityTimeoutSeconds.equals(other$inactivityTimeoutSeconds)) {
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
        Object this$redirectURI = this.getRedirectURI();
        Object other$redirectURI = other.getRedirectURI();
        if (this$redirectURI == null ? other$redirectURI != null : !this$redirectURI.equals(other$redirectURI)) {
            return false;
        }
        Object this$refreshToken = this.getRefreshToken();
        Object other$refreshToken = other.getRefreshToken();
        if (this$refreshToken == null ? other$refreshToken != null : !this$refreshToken.equals(other$refreshToken)) {
            return false;
        }
        Object this$scopes = this.getScopes();
        Object other$scopes = other.getScopes();
        if (this$scopes == null ? other$scopes != null : !this$scopes.equals(other$scopes)) {
            return false;
        }
        Object this$userName = this.getUserName();
        Object other$userName = other.getUserName();
        if (this$userName == null ? other$userName != null : !this$userName.equals(other$userName)) {
            return false;
        }
        Object this$userUID = this.getUserUID();
        Object other$userUID = other.getUserUID();
        if (this$userUID == null ? other$userUID != null : !this$userUID.equals(other$userUID)) {
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
        return other instanceof UserOAuthAccessToken;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiVersion = this.getApiVersion();
        result = result * prime + ($apiVersion == null ? 43 : $apiVersion.hashCode());
        Object $authorizeToken = this.getAuthorizeToken();
        result = result * prime + ($authorizeToken == null ? 43 : $authorizeToken.hashCode());
        Object $clientName = this.getClientName();
        result = result * prime + ($clientName == null ? 43 : $clientName.hashCode());
        Object $expiresIn = this.getExpiresIn();
        result = result * prime + ($expiresIn == null ? 43 : $expiresIn.hashCode());
        Object $inactivityTimeoutSeconds = this.getInactivityTimeoutSeconds();
        result = result * prime + ($inactivityTimeoutSeconds == null ? 43 : $inactivityTimeoutSeconds.hashCode());
        Object $kind = this.getKind();
        result = result * prime + ($kind == null ? 43 : $kind.hashCode());
        Object $metadata = this.getMetadata();
        result = result * prime + ($metadata == null ? 43 : $metadata.hashCode());
        Object $redirectURI = this.getRedirectURI();
        result = result * prime + ($redirectURI == null ? 43 : $redirectURI.hashCode());
        Object $refreshToken = this.getRefreshToken();
        result = result * prime + ($refreshToken == null ? 43 : $refreshToken.hashCode());
        Object $scopes = this.getScopes();
        result = result * prime + ($scopes == null ? 43 : $scopes.hashCode());
        Object $userName = this.getUserName();
        result = result * prime + ($userName == null ? 43 : $userName.hashCode());
        Object $userUID = this.getUserUID();
        result = result * prime + ($userUID == null ? 43 : $userUID.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "UserOAuthAccessToken(" + "apiVersion=" + this.getApiVersion() + ", authorizeToken=" + this.getAuthorizeToken() + ", clientName=" + this.getClientName() + ", expiresIn=" + this.getExpiresIn() + ", inactivityTimeoutSeconds=" + this.getInactivityTimeoutSeconds() + ", kind=" + this.getKind() + ", metadata=" + this.getMetadata() + ", redirectURI=" + this.getRedirectURI() + ", refreshToken=" + this.getRefreshToken() + ", scopes=" + this.getScopes() + ", userName=" + this.getUserName() + ", userUID=" + this.getUserUID() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
