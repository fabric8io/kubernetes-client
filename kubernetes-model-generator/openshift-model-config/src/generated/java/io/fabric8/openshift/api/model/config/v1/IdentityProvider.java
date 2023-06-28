
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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
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
@Setter
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class IdentityProvider implements KubernetesResource
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
     * 
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

    @JsonProperty("mappingMethod")
    public String getMappingMethod() {
        return mappingMethod;
    }

    @JsonProperty("mappingMethod")
    public void setMappingMethod(String mappingMethod) {
        this.mappingMethod = mappingMethod;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
