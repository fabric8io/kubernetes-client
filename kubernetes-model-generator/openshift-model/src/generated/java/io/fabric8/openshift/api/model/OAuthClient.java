
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
public class OAuthClient implements HasMetadata
{

    @JsonProperty("accessTokenInactivityTimeoutSeconds")
    private Integer accessTokenInactivityTimeoutSeconds;
    @JsonProperty("accessTokenMaxAgeSeconds")
    private Integer accessTokenMaxAgeSeconds;
    @JsonProperty("additionalSecrets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> additionalSecrets = new ArrayList<String>();
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    private String apiVersion = "oauth.openshift.io/v1";
    @JsonProperty("grantMethod")
    private String grantMethod;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    private String kind = "OAuthClient";
    @JsonProperty("metadata")
    private io.fabric8.kubernetes.api.model.ObjectMeta metadata;
    @JsonProperty("redirectURIs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> redirectURIs = new ArrayList<String>();
    @JsonProperty("respondWithChallenges")
    private Boolean respondWithChallenges;
    @JsonProperty("scopeRestrictions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ScopeRestriction> scopeRestrictions = new ArrayList<ScopeRestriction>();
    @JsonProperty("secret")
    private String secret;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public OAuthClient() {
    }

    public OAuthClient(Integer accessTokenInactivityTimeoutSeconds, Integer accessTokenMaxAgeSeconds, List<String> additionalSecrets, String apiVersion, String grantMethod, String kind, io.fabric8.kubernetes.api.model.ObjectMeta metadata, List<String> redirectURIs, Boolean respondWithChallenges, List<ScopeRestriction> scopeRestrictions, String secret) {
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

    @JsonProperty("accessTokenInactivityTimeoutSeconds")
    public Integer getAccessTokenInactivityTimeoutSeconds() {
        return accessTokenInactivityTimeoutSeconds;
    }

    @JsonProperty("accessTokenInactivityTimeoutSeconds")
    public void setAccessTokenInactivityTimeoutSeconds(Integer accessTokenInactivityTimeoutSeconds) {
        this.accessTokenInactivityTimeoutSeconds = accessTokenInactivityTimeoutSeconds;
    }

    @JsonProperty("accessTokenMaxAgeSeconds")
    public Integer getAccessTokenMaxAgeSeconds() {
        return accessTokenMaxAgeSeconds;
    }

    @JsonProperty("accessTokenMaxAgeSeconds")
    public void setAccessTokenMaxAgeSeconds(Integer accessTokenMaxAgeSeconds) {
        this.accessTokenMaxAgeSeconds = accessTokenMaxAgeSeconds;
    }

    @JsonProperty("additionalSecrets")
    public List<String> getAdditionalSecrets() {
        return additionalSecrets;
    }

    @JsonProperty("additionalSecrets")
    public void setAdditionalSecrets(List<String> additionalSecrets) {
        this.additionalSecrets = additionalSecrets;
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

    @JsonProperty("grantMethod")
    public String getGrantMethod() {
        return grantMethod;
    }

    @JsonProperty("grantMethod")
    public void setGrantMethod(String grantMethod) {
        this.grantMethod = grantMethod;
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

    @JsonProperty("redirectURIs")
    public List<String> getRedirectURIs() {
        return redirectURIs;
    }

    @JsonProperty("redirectURIs")
    public void setRedirectURIs(List<String> redirectURIs) {
        this.redirectURIs = redirectURIs;
    }

    @JsonProperty("respondWithChallenges")
    public Boolean getRespondWithChallenges() {
        return respondWithChallenges;
    }

    @JsonProperty("respondWithChallenges")
    public void setRespondWithChallenges(Boolean respondWithChallenges) {
        this.respondWithChallenges = respondWithChallenges;
    }

    @JsonProperty("scopeRestrictions")
    public List<ScopeRestriction> getScopeRestrictions() {
        return scopeRestrictions;
    }

    @JsonProperty("scopeRestrictions")
    public void setScopeRestrictions(List<ScopeRestriction> scopeRestrictions) {
        this.scopeRestrictions = scopeRestrictions;
    }

    @JsonProperty("secret")
    public String getSecret() {
        return secret;
    }

    @JsonProperty("secret")
    public void setSecret(String secret) {
        this.secret = secret;
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
