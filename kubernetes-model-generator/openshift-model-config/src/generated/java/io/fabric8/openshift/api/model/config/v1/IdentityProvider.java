
package io.fabric8.openshift.api.model.config.v1;

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
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * IdentityProvider provides identities for users authenticating using credentials
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "basicAuth",
    "github",
    "gitlab",
    "google",
    "htpasswd",
    "keystone",
    "ldap",
    "mappingMethod",
    "name",
    "openID",
    "requestHeader",
    "type"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class IdentityProvider implements Editable<IdentityProviderBuilder>, KubernetesResource
{

    @JsonProperty("basicAuth")
    private BasicAuthIdentityProvider basicAuth;
    @JsonProperty("github")
    private GitHubIdentityProvider github;
    @JsonProperty("gitlab")
    private GitLabIdentityProvider gitlab;
    @JsonProperty("google")
    private GoogleIdentityProvider google;
    @JsonProperty("htpasswd")
    private HTPasswdIdentityProvider htpasswd;
    @JsonProperty("keystone")
    private KeystoneIdentityProvider keystone;
    @JsonProperty("ldap")
    private LDAPIdentityProvider ldap;
    @JsonProperty("mappingMethod")
    private String mappingMethod;
    @JsonProperty("name")
    private String name;
    @JsonProperty("openID")
    private OpenIDIdentityProvider openID;
    @JsonProperty("requestHeader")
    private RequestHeaderIdentityProvider requestHeader;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public IdentityProvider() {
    }

    public IdentityProvider(BasicAuthIdentityProvider basicAuth, GitHubIdentityProvider github, GitLabIdentityProvider gitlab, GoogleIdentityProvider google, HTPasswdIdentityProvider htpasswd, KeystoneIdentityProvider keystone, LDAPIdentityProvider ldap, String mappingMethod, String name, OpenIDIdentityProvider openID, RequestHeaderIdentityProvider requestHeader, String type) {
        super();
        this.basicAuth = basicAuth;
        this.github = github;
        this.gitlab = gitlab;
        this.google = google;
        this.htpasswd = htpasswd;
        this.keystone = keystone;
        this.ldap = ldap;
        this.mappingMethod = mappingMethod;
        this.name = name;
        this.openID = openID;
        this.requestHeader = requestHeader;
        this.type = type;
    }

    /**
     * IdentityProvider provides identities for users authenticating using credentials
     */
    @JsonProperty("basicAuth")
    public BasicAuthIdentityProvider getBasicAuth() {
        return basicAuth;
    }

    /**
     * IdentityProvider provides identities for users authenticating using credentials
     */
    @JsonProperty("basicAuth")
    public void setBasicAuth(BasicAuthIdentityProvider basicAuth) {
        this.basicAuth = basicAuth;
    }

    /**
     * IdentityProvider provides identities for users authenticating using credentials
     */
    @JsonProperty("github")
    public GitHubIdentityProvider getGithub() {
        return github;
    }

    /**
     * IdentityProvider provides identities for users authenticating using credentials
     */
    @JsonProperty("github")
    public void setGithub(GitHubIdentityProvider github) {
        this.github = github;
    }

    /**
     * IdentityProvider provides identities for users authenticating using credentials
     */
    @JsonProperty("gitlab")
    public GitLabIdentityProvider getGitlab() {
        return gitlab;
    }

    /**
     * IdentityProvider provides identities for users authenticating using credentials
     */
    @JsonProperty("gitlab")
    public void setGitlab(GitLabIdentityProvider gitlab) {
        this.gitlab = gitlab;
    }

    /**
     * IdentityProvider provides identities for users authenticating using credentials
     */
    @JsonProperty("google")
    public GoogleIdentityProvider getGoogle() {
        return google;
    }

    /**
     * IdentityProvider provides identities for users authenticating using credentials
     */
    @JsonProperty("google")
    public void setGoogle(GoogleIdentityProvider google) {
        this.google = google;
    }

    /**
     * IdentityProvider provides identities for users authenticating using credentials
     */
    @JsonProperty("htpasswd")
    public HTPasswdIdentityProvider getHtpasswd() {
        return htpasswd;
    }

    /**
     * IdentityProvider provides identities for users authenticating using credentials
     */
    @JsonProperty("htpasswd")
    public void setHtpasswd(HTPasswdIdentityProvider htpasswd) {
        this.htpasswd = htpasswd;
    }

    /**
     * IdentityProvider provides identities for users authenticating using credentials
     */
    @JsonProperty("keystone")
    public KeystoneIdentityProvider getKeystone() {
        return keystone;
    }

    /**
     * IdentityProvider provides identities for users authenticating using credentials
     */
    @JsonProperty("keystone")
    public void setKeystone(KeystoneIdentityProvider keystone) {
        this.keystone = keystone;
    }

    /**
     * IdentityProvider provides identities for users authenticating using credentials
     */
    @JsonProperty("ldap")
    public LDAPIdentityProvider getLdap() {
        return ldap;
    }

    /**
     * IdentityProvider provides identities for users authenticating using credentials
     */
    @JsonProperty("ldap")
    public void setLdap(LDAPIdentityProvider ldap) {
        this.ldap = ldap;
    }

    /**
     * mappingMethod determines how identities from this provider are mapped to users Defaults to "claim"
     */
    @JsonProperty("mappingMethod")
    public String getMappingMethod() {
        return mappingMethod;
    }

    /**
     * mappingMethod determines how identities from this provider are mapped to users Defaults to "claim"
     */
    @JsonProperty("mappingMethod")
    public void setMappingMethod(String mappingMethod) {
        this.mappingMethod = mappingMethod;
    }

    /**
     * name is used to qualify the identities returned by this provider. - It MUST be unique and not shared by any other identity provider used - It MUST be a valid path segment: name cannot equal "." or ".." or contain "/" or "%" or ":"<br><p>   Ref: https://godoc.org/github.com/openshift/origin/pkg/user/apis/user/validation#ValidateIdentityProviderName
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name is used to qualify the identities returned by this provider. - It MUST be unique and not shared by any other identity provider used - It MUST be a valid path segment: name cannot equal "." or ".." or contain "/" or "%" or ":"<br><p>   Ref: https://godoc.org/github.com/openshift/origin/pkg/user/apis/user/validation#ValidateIdentityProviderName
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * IdentityProvider provides identities for users authenticating using credentials
     */
    @JsonProperty("openID")
    public OpenIDIdentityProvider getOpenID() {
        return openID;
    }

    /**
     * IdentityProvider provides identities for users authenticating using credentials
     */
    @JsonProperty("openID")
    public void setOpenID(OpenIDIdentityProvider openID) {
        this.openID = openID;
    }

    /**
     * IdentityProvider provides identities for users authenticating using credentials
     */
    @JsonProperty("requestHeader")
    public RequestHeaderIdentityProvider getRequestHeader() {
        return requestHeader;
    }

    /**
     * IdentityProvider provides identities for users authenticating using credentials
     */
    @JsonProperty("requestHeader")
    public void setRequestHeader(RequestHeaderIdentityProvider requestHeader) {
        this.requestHeader = requestHeader;
    }

    /**
     * type identifies the identity provider type for this entry.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type identifies the identity provider type for this entry.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public IdentityProviderBuilder edit() {
        return new IdentityProviderBuilder(this);
    }

    @JsonIgnore
    public IdentityProviderBuilder toBuilder() {
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
