
package io.fabric8.openshift.api.model.config.v1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
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
import io.fabric8.kubernetes.api.model.ObjectReference;
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
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class IdentityProviderConfig implements Editable<IdentityProviderConfigBuilder> , KubernetesResource
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
     * 
     */
    public IdentityProviderConfig() {
    }

    public IdentityProviderConfig(BasicAuthIdentityProvider basicAuth, GitHubIdentityProvider github, GitLabIdentityProvider gitlab, GoogleIdentityProvider google, HTPasswdIdentityProvider htpasswd, KeystoneIdentityProvider keystone, LDAPIdentityProvider ldap, OpenIDIdentityProvider openID, RequestHeaderIdentityProvider requestHeader, String type) {
        super();
        this.basicAuth = basicAuth;
        this.github = github;
        this.gitlab = gitlab;
        this.google = google;
        this.htpasswd = htpasswd;
        this.keystone = keystone;
        this.ldap = ldap;
        this.openID = openID;
        this.requestHeader = requestHeader;
        this.type = type;
    }

    @JsonProperty("basicAuth")
    public BasicAuthIdentityProvider getBasicAuth() {
        return basicAuth;
    }

    @JsonProperty("basicAuth")
    public void setBasicAuth(BasicAuthIdentityProvider basicAuth) {
        this.basicAuth = basicAuth;
    }

    @JsonProperty("github")
    public GitHubIdentityProvider getGithub() {
        return github;
    }

    @JsonProperty("github")
    public void setGithub(GitHubIdentityProvider github) {
        this.github = github;
    }

    @JsonProperty("gitlab")
    public GitLabIdentityProvider getGitlab() {
        return gitlab;
    }

    @JsonProperty("gitlab")
    public void setGitlab(GitLabIdentityProvider gitlab) {
        this.gitlab = gitlab;
    }

    @JsonProperty("google")
    public GoogleIdentityProvider getGoogle() {
        return google;
    }

    @JsonProperty("google")
    public void setGoogle(GoogleIdentityProvider google) {
        this.google = google;
    }

    @JsonProperty("htpasswd")
    public HTPasswdIdentityProvider getHtpasswd() {
        return htpasswd;
    }

    @JsonProperty("htpasswd")
    public void setHtpasswd(HTPasswdIdentityProvider htpasswd) {
        this.htpasswd = htpasswd;
    }

    @JsonProperty("keystone")
    public KeystoneIdentityProvider getKeystone() {
        return keystone;
    }

    @JsonProperty("keystone")
    public void setKeystone(KeystoneIdentityProvider keystone) {
        this.keystone = keystone;
    }

    @JsonProperty("ldap")
    public LDAPIdentityProvider getLdap() {
        return ldap;
    }

    @JsonProperty("ldap")
    public void setLdap(LDAPIdentityProvider ldap) {
        this.ldap = ldap;
    }

    @JsonProperty("openID")
    public OpenIDIdentityProvider getOpenID() {
        return openID;
    }

    @JsonProperty("openID")
    public void setOpenID(OpenIDIdentityProvider openID) {
        this.openID = openID;
    }

    @JsonProperty("requestHeader")
    public RequestHeaderIdentityProvider getRequestHeader() {
        return requestHeader;
    }

    @JsonProperty("requestHeader")
    public void setRequestHeader(RequestHeaderIdentityProvider requestHeader) {
        this.requestHeader = requestHeader;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public IdentityProviderConfigBuilder edit() {
        return new IdentityProviderConfigBuilder(this);
    }

    @JsonIgnore
    public IdentityProviderConfigBuilder toBuilder() {
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
