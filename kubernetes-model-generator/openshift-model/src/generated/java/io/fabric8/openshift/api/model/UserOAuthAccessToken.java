
package io.fabric8.openshift.api.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import io.sundr.transform.annotations.TemplateTransformation;
import io.sundr.transform.annotations.TemplateTransformations;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

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
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@TemplateTransformations({
    @TemplateTransformation(value = "/manifest.vm", outputPath = "META-INF/services/io.fabric8.kubernetes.api.model.KubernetesResource", gather = true)
})
@Version("v1")
@Group("oauth.openshift.io")
@Generated("jsonschema2pojo")
public class UserOAuthAccessToken implements HasMetadata
{

    /**
     * 
     * (Required)
     * 
     */
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
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    private String kind = "UserOAuthAccessToken";
    @JsonProperty("metadata")
    private io.fabric8.kubernetes.api.model.ObjectMeta metadata;
    @JsonProperty("redirectURI")
    private String redirectURI;
    @JsonProperty("refreshToken")
    private String refreshToken;
    @JsonProperty("scopes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> scopes = new ArrayList<String>();
    @JsonProperty("userName")
    private String userName;
    @JsonProperty("userUID")
    private String userUID;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public UserOAuthAccessToken() {
    }

    public UserOAuthAccessToken(String apiVersion, String authorizeToken, String clientName, Long expiresIn, Integer inactivityTimeoutSeconds, String kind, io.fabric8.kubernetes.api.model.ObjectMeta metadata, String redirectURI, String refreshToken, List<String> scopes, String userName, String userUID) {
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
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    @JsonProperty("authorizeToken")
    public String getAuthorizeToken() {
        return authorizeToken;
    }

    @JsonProperty("authorizeToken")
    public void setAuthorizeToken(String authorizeToken) {
        this.authorizeToken = authorizeToken;
    }

    @JsonProperty("clientName")
    public String getClientName() {
        return clientName;
    }

    @JsonProperty("clientName")
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @JsonProperty("expiresIn")
    public Long getExpiresIn() {
        return expiresIn;
    }

    @JsonProperty("expiresIn")
    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

    @JsonProperty("inactivityTimeoutSeconds")
    public Integer getInactivityTimeoutSeconds() {
        return inactivityTimeoutSeconds;
    }

    @JsonProperty("inactivityTimeoutSeconds")
    public void setInactivityTimeoutSeconds(Integer inactivityTimeoutSeconds) {
        this.inactivityTimeoutSeconds = inactivityTimeoutSeconds;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty("metadata")
    public io.fabric8.kubernetes.api.model.ObjectMeta getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(io.fabric8.kubernetes.api.model.ObjectMeta metadata) {
        this.metadata = metadata;
    }

    @JsonProperty("redirectURI")
    public String getRedirectURI() {
        return redirectURI;
    }

    @JsonProperty("redirectURI")
    public void setRedirectURI(String redirectURI) {
        this.redirectURI = redirectURI;
    }

    @JsonProperty("refreshToken")
    public String getRefreshToken() {
        return refreshToken;
    }

    @JsonProperty("refreshToken")
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    @JsonProperty("scopes")
    public List<String> getScopes() {
        return scopes;
    }

    @JsonProperty("scopes")
    public void setScopes(List<String> scopes) {
        this.scopes = scopes;
    }

    @JsonProperty("userName")
    public String getUserName() {
        return userName;
    }

    @JsonProperty("userName")
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @JsonProperty("userUID")
    public String getUserUID() {
        return userUID;
    }

    @JsonProperty("userUID")
    public void setUserUID(String userUID) {
        this.userUID = userUID;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
