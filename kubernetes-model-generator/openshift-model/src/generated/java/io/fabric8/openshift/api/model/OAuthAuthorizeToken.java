
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
 * OAuthAuthorizeToken describes an OAuth authorization token<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "clientName",
    "codeChallenge",
    "codeChallengeMethod",
    "expiresIn",
    "redirectURI",
    "scopes",
    "state",
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
public class OAuthAuthorizeToken implements Editable<OAuthAuthorizeTokenBuilder>, HasMetadata
{

    @JsonProperty("apiVersion")
    private String apiVersion = "oauth.openshift.io/v1";
    @JsonProperty("clientName")
    private String clientName;
    @JsonProperty("codeChallenge")
    private String codeChallenge;
    @JsonProperty("codeChallengeMethod")
    private String codeChallengeMethod;
    @JsonProperty("expiresIn")
    private Long expiresIn;
    @JsonProperty("kind")
    private String kind = "OAuthAuthorizeToken";
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("redirectURI")
    private String redirectURI;
    @JsonProperty("scopes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> scopes = new ArrayList<>();
    @JsonProperty("state")
    private String state;
    @JsonProperty("userName")
    private String userName;
    @JsonProperty("userUID")
    private String userUID;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public OAuthAuthorizeToken() {
    }

    public OAuthAuthorizeToken(String apiVersion, String clientName, String codeChallenge, String codeChallengeMethod, Long expiresIn, String kind, ObjectMeta metadata, String redirectURI, List<String> scopes, String state, String userName, String userUID) {
        super();
        this.apiVersion = apiVersion;
        this.clientName = clientName;
        this.codeChallenge = codeChallenge;
        this.codeChallengeMethod = codeChallengeMethod;
        this.expiresIn = expiresIn;
        this.kind = kind;
        this.metadata = metadata;
        this.redirectURI = redirectURI;
        this.scopes = scopes;
        this.state = state;
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
     * codeChallenge is the optional code_challenge associated with this authorization code, as described in rfc7636
     */
    @JsonProperty("codeChallenge")
    public String getCodeChallenge() {
        return codeChallenge;
    }

    /**
     * codeChallenge is the optional code_challenge associated with this authorization code, as described in rfc7636
     */
    @JsonProperty("codeChallenge")
    public void setCodeChallenge(String codeChallenge) {
        this.codeChallenge = codeChallenge;
    }

    /**
     * codeChallengeMethod is the optional code_challenge_method associated with this authorization code, as described in rfc7636
     */
    @JsonProperty("codeChallengeMethod")
    public String getCodeChallengeMethod() {
        return codeChallengeMethod;
    }

    /**
     * codeChallengeMethod is the optional code_challenge_method associated with this authorization code, as described in rfc7636
     */
    @JsonProperty("codeChallengeMethod")
    public void setCodeChallengeMethod(String codeChallengeMethod) {
        this.codeChallengeMethod = codeChallengeMethod;
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
     * OAuthAuthorizeToken describes an OAuth authorization token<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * OAuthAuthorizeToken describes an OAuth authorization token<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
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
     * state data from request
     */
    @JsonProperty("state")
    public String getState() {
        return state;
    }

    /**
     * state data from request
     */
    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
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
     * userUID is the unique UID associated with this token. UserUID and UserName must both match for this token to be valid.
     */
    @JsonProperty("userUID")
    public String getUserUID() {
        return userUID;
    }

    /**
     * userUID is the unique UID associated with this token. UserUID and UserName must both match for this token to be valid.
     */
    @JsonProperty("userUID")
    public void setUserUID(String userUID) {
        this.userUID = userUID;
    }

    @JsonIgnore
    public OAuthAuthorizeTokenBuilder edit() {
        return new OAuthAuthorizeTokenBuilder(this);
    }

    @JsonIgnore
    public OAuthAuthorizeTokenBuilder toBuilder() {
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
        if (!(o instanceof OAuthAuthorizeToken)) {
            return false;
        }
        OAuthAuthorizeToken other = (OAuthAuthorizeToken) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$apiVersion = this.getApiVersion();
        Object other$apiVersion = other.getApiVersion();
        if (this$apiVersion == null ? other$apiVersion != null : !this$apiVersion.equals(other$apiVersion)) {
            return false;
        }
        Object this$clientName = this.getClientName();
        Object other$clientName = other.getClientName();
        if (this$clientName == null ? other$clientName != null : !this$clientName.equals(other$clientName)) {
            return false;
        }
        Object this$codeChallenge = this.getCodeChallenge();
        Object other$codeChallenge = other.getCodeChallenge();
        if (this$codeChallenge == null ? other$codeChallenge != null : !this$codeChallenge.equals(other$codeChallenge)) {
            return false;
        }
        Object this$codeChallengeMethod = this.getCodeChallengeMethod();
        Object other$codeChallengeMethod = other.getCodeChallengeMethod();
        if (this$codeChallengeMethod == null ? other$codeChallengeMethod != null : !this$codeChallengeMethod.equals(other$codeChallengeMethod)) {
            return false;
        }
        Object this$expiresIn = this.getExpiresIn();
        Object other$expiresIn = other.getExpiresIn();
        if (this$expiresIn == null ? other$expiresIn != null : !this$expiresIn.equals(other$expiresIn)) {
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
        Object this$scopes = this.getScopes();
        Object other$scopes = other.getScopes();
        if (this$scopes == null ? other$scopes != null : !this$scopes.equals(other$scopes)) {
            return false;
        }
        Object this$state = this.getState();
        Object other$state = other.getState();
        if (this$state == null ? other$state != null : !this$state.equals(other$state)) {
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
        return other instanceof OAuthAuthorizeToken;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiVersion = this.getApiVersion();
        result = result * prime + ($apiVersion == null ? 43 : $apiVersion.hashCode());
        Object $clientName = this.getClientName();
        result = result * prime + ($clientName == null ? 43 : $clientName.hashCode());
        Object $codeChallenge = this.getCodeChallenge();
        result = result * prime + ($codeChallenge == null ? 43 : $codeChallenge.hashCode());
        Object $codeChallengeMethod = this.getCodeChallengeMethod();
        result = result * prime + ($codeChallengeMethod == null ? 43 : $codeChallengeMethod.hashCode());
        Object $expiresIn = this.getExpiresIn();
        result = result * prime + ($expiresIn == null ? 43 : $expiresIn.hashCode());
        Object $kind = this.getKind();
        result = result * prime + ($kind == null ? 43 : $kind.hashCode());
        Object $metadata = this.getMetadata();
        result = result * prime + ($metadata == null ? 43 : $metadata.hashCode());
        Object $redirectURI = this.getRedirectURI();
        result = result * prime + ($redirectURI == null ? 43 : $redirectURI.hashCode());
        Object $scopes = this.getScopes();
        result = result * prime + ($scopes == null ? 43 : $scopes.hashCode());
        Object $state = this.getState();
        result = result * prime + ($state == null ? 43 : $state.hashCode());
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
        return "OAuthAuthorizeToken(" + "apiVersion=" + this.getApiVersion() + ", clientName=" + this.getClientName() + ", codeChallenge=" + this.getCodeChallenge() + ", codeChallengeMethod=" + this.getCodeChallengeMethod() + ", expiresIn=" + this.getExpiresIn() + ", kind=" + this.getKind() + ", metadata=" + this.getMetadata() + ", redirectURI=" + this.getRedirectURI() + ", scopes=" + this.getScopes() + ", state=" + this.getState() + ", userName=" + this.getUserName() + ", userUID=" + this.getUserUID() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
