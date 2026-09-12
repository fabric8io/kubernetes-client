
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
 * GitLabIdentityProvider provides identities for users authenticating using GitLab credentials
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ca",
    "clientID",
    "clientSecret",
    "url"
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
public class GitLabIdentityProvider implements Editable<GitLabIdentityProviderBuilder>, KubernetesResource
{

    @JsonProperty("ca")
    private ConfigMapNameReference ca;
    @JsonProperty("clientID")
    private String clientID;
    @JsonProperty("clientSecret")
    private SecretNameReference clientSecret;
    @JsonProperty("url")
    private String url;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GitLabIdentityProvider() {
    }

    public GitLabIdentityProvider(ConfigMapNameReference ca, String clientID, SecretNameReference clientSecret, String url) {
        super();
        this.ca = ca;
        this.clientID = clientID;
        this.clientSecret = clientSecret;
        this.url = url;
    }

    /**
     * GitLabIdentityProvider provides identities for users authenticating using GitLab credentials
     */
    @JsonProperty("ca")
    public ConfigMapNameReference getCa() {
        return ca;
    }

    /**
     * GitLabIdentityProvider provides identities for users authenticating using GitLab credentials
     */
    @JsonProperty("ca")
    public void setCa(ConfigMapNameReference ca) {
        this.ca = ca;
    }

    /**
     * clientID is the oauth client ID
     */
    @JsonProperty("clientID")
    public String getClientID() {
        return clientID;
    }

    /**
     * clientID is the oauth client ID
     */
    @JsonProperty("clientID")
    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    /**
     * GitLabIdentityProvider provides identities for users authenticating using GitLab credentials
     */
    @JsonProperty("clientSecret")
    public SecretNameReference getClientSecret() {
        return clientSecret;
    }

    /**
     * GitLabIdentityProvider provides identities for users authenticating using GitLab credentials
     */
    @JsonProperty("clientSecret")
    public void setClientSecret(SecretNameReference clientSecret) {
        this.clientSecret = clientSecret;
    }

    /**
     * url is the oauth server base URL
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * url is the oauth server base URL
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonIgnore
    public GitLabIdentityProviderBuilder edit() {
        return new GitLabIdentityProviderBuilder(this);
    }

    @JsonIgnore
    public GitLabIdentityProviderBuilder toBuilder() {
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
        if (!(o instanceof GitLabIdentityProvider)) {
            return false;
        }
        GitLabIdentityProvider other = (GitLabIdentityProvider) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$ca = this.getCa();
        Object other$ca = other.getCa();
        if (this$ca == null ? other$ca != null : !this$ca.equals(other$ca)) {
            return false;
        }
        Object this$clientID = this.getClientID();
        Object other$clientID = other.getClientID();
        if (this$clientID == null ? other$clientID != null : !this$clientID.equals(other$clientID)) {
            return false;
        }
        Object this$clientSecret = this.getClientSecret();
        Object other$clientSecret = other.getClientSecret();
        if (this$clientSecret == null ? other$clientSecret != null : !this$clientSecret.equals(other$clientSecret)) {
            return false;
        }
        Object this$url = this.getUrl();
        Object other$url = other.getUrl();
        if (this$url == null ? other$url != null : !this$url.equals(other$url)) {
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
        return other instanceof GitLabIdentityProvider;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $ca = this.getCa();
        result = result * prime + ($ca == null ? 43 : $ca.hashCode());
        Object $clientID = this.getClientID();
        result = result * prime + ($clientID == null ? 43 : $clientID.hashCode());
        Object $clientSecret = this.getClientSecret();
        result = result * prime + ($clientSecret == null ? 43 : $clientSecret.hashCode());
        Object $url = this.getUrl();
        result = result * prime + ($url == null ? 43 : $url.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "GitLabIdentityProvider(" + "ca=" + this.getCa() + ", clientID=" + this.getClientID() + ", clientSecret=" + this.getClientSecret() + ", url=" + this.getUrl() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
