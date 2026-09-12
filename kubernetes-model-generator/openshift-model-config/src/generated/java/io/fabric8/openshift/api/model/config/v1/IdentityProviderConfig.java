
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

/**
 * IdentityProviderConfig contains configuration for using a specific identity provider
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
    "openID",
    "requestHeader",
    "type"
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
public class IdentityProviderConfig implements Editable<IdentityProviderConfigBuilder>, KubernetesResource
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

    /**
     * IdentityProviderConfig contains configuration for using a specific identity provider
     */
    @JsonProperty("basicAuth")
    public BasicAuthIdentityProvider getBasicAuth() {
        return basicAuth;
    }

    /**
     * IdentityProviderConfig contains configuration for using a specific identity provider
     */
    @JsonProperty("basicAuth")
    public void setBasicAuth(BasicAuthIdentityProvider basicAuth) {
        this.basicAuth = basicAuth;
    }

    /**
     * IdentityProviderConfig contains configuration for using a specific identity provider
     */
    @JsonProperty("github")
    public GitHubIdentityProvider getGithub() {
        return github;
    }

    /**
     * IdentityProviderConfig contains configuration for using a specific identity provider
     */
    @JsonProperty("github")
    public void setGithub(GitHubIdentityProvider github) {
        this.github = github;
    }

    /**
     * IdentityProviderConfig contains configuration for using a specific identity provider
     */
    @JsonProperty("gitlab")
    public GitLabIdentityProvider getGitlab() {
        return gitlab;
    }

    /**
     * IdentityProviderConfig contains configuration for using a specific identity provider
     */
    @JsonProperty("gitlab")
    public void setGitlab(GitLabIdentityProvider gitlab) {
        this.gitlab = gitlab;
    }

    /**
     * IdentityProviderConfig contains configuration for using a specific identity provider
     */
    @JsonProperty("google")
    public GoogleIdentityProvider getGoogle() {
        return google;
    }

    /**
     * IdentityProviderConfig contains configuration for using a specific identity provider
     */
    @JsonProperty("google")
    public void setGoogle(GoogleIdentityProvider google) {
        this.google = google;
    }

    /**
     * IdentityProviderConfig contains configuration for using a specific identity provider
     */
    @JsonProperty("htpasswd")
    public HTPasswdIdentityProvider getHtpasswd() {
        return htpasswd;
    }

    /**
     * IdentityProviderConfig contains configuration for using a specific identity provider
     */
    @JsonProperty("htpasswd")
    public void setHtpasswd(HTPasswdIdentityProvider htpasswd) {
        this.htpasswd = htpasswd;
    }

    /**
     * IdentityProviderConfig contains configuration for using a specific identity provider
     */
    @JsonProperty("keystone")
    public KeystoneIdentityProvider getKeystone() {
        return keystone;
    }

    /**
     * IdentityProviderConfig contains configuration for using a specific identity provider
     */
    @JsonProperty("keystone")
    public void setKeystone(KeystoneIdentityProvider keystone) {
        this.keystone = keystone;
    }

    /**
     * IdentityProviderConfig contains configuration for using a specific identity provider
     */
    @JsonProperty("ldap")
    public LDAPIdentityProvider getLdap() {
        return ldap;
    }

    /**
     * IdentityProviderConfig contains configuration for using a specific identity provider
     */
    @JsonProperty("ldap")
    public void setLdap(LDAPIdentityProvider ldap) {
        this.ldap = ldap;
    }

    /**
     * IdentityProviderConfig contains configuration for using a specific identity provider
     */
    @JsonProperty("openID")
    public OpenIDIdentityProvider getOpenID() {
        return openID;
    }

    /**
     * IdentityProviderConfig contains configuration for using a specific identity provider
     */
    @JsonProperty("openID")
    public void setOpenID(OpenIDIdentityProvider openID) {
        this.openID = openID;
    }

    /**
     * IdentityProviderConfig contains configuration for using a specific identity provider
     */
    @JsonProperty("requestHeader")
    public RequestHeaderIdentityProvider getRequestHeader() {
        return requestHeader;
    }

    /**
     * IdentityProviderConfig contains configuration for using a specific identity provider
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
    public IdentityProviderConfigBuilder edit() {
        return new IdentityProviderConfigBuilder(this);
    }

    @JsonIgnore
    public IdentityProviderConfigBuilder toBuilder() {
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
        if (!(o instanceof IdentityProviderConfig)) {
            return false;
        }
        IdentityProviderConfig other = (IdentityProviderConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$basicAuth = this.getBasicAuth();
        Object other$basicAuth = other.getBasicAuth();
        if (this$basicAuth == null ? other$basicAuth != null : !this$basicAuth.equals(other$basicAuth)) {
            return false;
        }
        Object this$github = this.getGithub();
        Object other$github = other.getGithub();
        if (this$github == null ? other$github != null : !this$github.equals(other$github)) {
            return false;
        }
        Object this$gitlab = this.getGitlab();
        Object other$gitlab = other.getGitlab();
        if (this$gitlab == null ? other$gitlab != null : !this$gitlab.equals(other$gitlab)) {
            return false;
        }
        Object this$google = this.getGoogle();
        Object other$google = other.getGoogle();
        if (this$google == null ? other$google != null : !this$google.equals(other$google)) {
            return false;
        }
        Object this$htpasswd = this.getHtpasswd();
        Object other$htpasswd = other.getHtpasswd();
        if (this$htpasswd == null ? other$htpasswd != null : !this$htpasswd.equals(other$htpasswd)) {
            return false;
        }
        Object this$keystone = this.getKeystone();
        Object other$keystone = other.getKeystone();
        if (this$keystone == null ? other$keystone != null : !this$keystone.equals(other$keystone)) {
            return false;
        }
        Object this$ldap = this.getLdap();
        Object other$ldap = other.getLdap();
        if (this$ldap == null ? other$ldap != null : !this$ldap.equals(other$ldap)) {
            return false;
        }
        Object this$openID = this.getOpenID();
        Object other$openID = other.getOpenID();
        if (this$openID == null ? other$openID != null : !this$openID.equals(other$openID)) {
            return false;
        }
        Object this$requestHeader = this.getRequestHeader();
        Object other$requestHeader = other.getRequestHeader();
        if (this$requestHeader == null ? other$requestHeader != null : !this$requestHeader.equals(other$requestHeader)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
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
        return other instanceof IdentityProviderConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $basicAuth = this.getBasicAuth();
        result = result * prime + ($basicAuth == null ? 43 : $basicAuth.hashCode());
        Object $github = this.getGithub();
        result = result * prime + ($github == null ? 43 : $github.hashCode());
        Object $gitlab = this.getGitlab();
        result = result * prime + ($gitlab == null ? 43 : $gitlab.hashCode());
        Object $google = this.getGoogle();
        result = result * prime + ($google == null ? 43 : $google.hashCode());
        Object $htpasswd = this.getHtpasswd();
        result = result * prime + ($htpasswd == null ? 43 : $htpasswd.hashCode());
        Object $keystone = this.getKeystone();
        result = result * prime + ($keystone == null ? 43 : $keystone.hashCode());
        Object $ldap = this.getLdap();
        result = result * prime + ($ldap == null ? 43 : $ldap.hashCode());
        Object $openID = this.getOpenID();
        result = result * prime + ($openID == null ? 43 : $openID.hashCode());
        Object $requestHeader = this.getRequestHeader();
        result = result * prime + ($requestHeader == null ? 43 : $requestHeader.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "IdentityProviderConfig(" + "basicAuth=" + this.getBasicAuth() + ", github=" + this.getGithub() + ", gitlab=" + this.getGitlab() + ", google=" + this.getGoogle() + ", htpasswd=" + this.getHtpasswd() + ", keystone=" + this.getKeystone() + ", ldap=" + this.getLdap() + ", openID=" + this.getOpenID() + ", requestHeader=" + this.getRequestHeader() + ", type=" + this.getType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
