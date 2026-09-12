
package io.fabric8.openshift.api.model.config.v1;

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
 * GitHubIdentityProvider provides identities for users authenticating using GitHub credentials
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ca",
    "clientID",
    "clientSecret",
    "hostname",
    "organizations",
    "teams"
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
public class GitHubIdentityProvider implements Editable<GitHubIdentityProviderBuilder>, KubernetesResource
{

    @JsonProperty("ca")
    private ConfigMapNameReference ca;
    @JsonProperty("clientID")
    private String clientID;
    @JsonProperty("clientSecret")
    private SecretNameReference clientSecret;
    @JsonProperty("hostname")
    private String hostname;
    @JsonProperty("organizations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> organizations = new ArrayList<>();
    @JsonProperty("teams")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> teams = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GitHubIdentityProvider() {
    }

    public GitHubIdentityProvider(ConfigMapNameReference ca, String clientID, SecretNameReference clientSecret, String hostname, List<String> organizations, List<String> teams) {
        super();
        this.ca = ca;
        this.clientID = clientID;
        this.clientSecret = clientSecret;
        this.hostname = hostname;
        this.organizations = organizations;
        this.teams = teams;
    }

    /**
     * GitHubIdentityProvider provides identities for users authenticating using GitHub credentials
     */
    @JsonProperty("ca")
    public ConfigMapNameReference getCa() {
        return ca;
    }

    /**
     * GitHubIdentityProvider provides identities for users authenticating using GitHub credentials
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
     * GitHubIdentityProvider provides identities for users authenticating using GitHub credentials
     */
    @JsonProperty("clientSecret")
    public SecretNameReference getClientSecret() {
        return clientSecret;
    }

    /**
     * GitHubIdentityProvider provides identities for users authenticating using GitHub credentials
     */
    @JsonProperty("clientSecret")
    public void setClientSecret(SecretNameReference clientSecret) {
        this.clientSecret = clientSecret;
    }

    /**
     * hostname is the optional domain (e.g. "mycompany.com") for use with a hosted instance of GitHub Enterprise. It must match the GitHub Enterprise settings value configured at /setup/settings#hostname.
     */
    @JsonProperty("hostname")
    public String getHostname() {
        return hostname;
    }

    /**
     * hostname is the optional domain (e.g. "mycompany.com") for use with a hosted instance of GitHub Enterprise. It must match the GitHub Enterprise settings value configured at /setup/settings#hostname.
     */
    @JsonProperty("hostname")
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    /**
     * organizations optionally restricts which organizations are allowed to log in
     */
    @JsonProperty("organizations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getOrganizations() {
        return organizations;
    }

    /**
     * organizations optionally restricts which organizations are allowed to log in
     */
    @JsonProperty("organizations")
    public void setOrganizations(List<String> organizations) {
        this.organizations = organizations;
    }

    /**
     * teams optionally restricts which teams are allowed to log in. Format is &lt;org&gt;/&lt;team&gt;.
     */
    @JsonProperty("teams")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getTeams() {
        return teams;
    }

    /**
     * teams optionally restricts which teams are allowed to log in. Format is &lt;org&gt;/&lt;team&gt;.
     */
    @JsonProperty("teams")
    public void setTeams(List<String> teams) {
        this.teams = teams;
    }

    @JsonIgnore
    public GitHubIdentityProviderBuilder edit() {
        return new GitHubIdentityProviderBuilder(this);
    }

    @JsonIgnore
    public GitHubIdentityProviderBuilder toBuilder() {
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
        if (!(o instanceof GitHubIdentityProvider)) {
            return false;
        }
        GitHubIdentityProvider other = (GitHubIdentityProvider) o;
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
        Object this$hostname = this.getHostname();
        Object other$hostname = other.getHostname();
        if (this$hostname == null ? other$hostname != null : !this$hostname.equals(other$hostname)) {
            return false;
        }
        Object this$organizations = this.getOrganizations();
        Object other$organizations = other.getOrganizations();
        if (this$organizations == null ? other$organizations != null : !this$organizations.equals(other$organizations)) {
            return false;
        }
        Object this$teams = this.getTeams();
        Object other$teams = other.getTeams();
        if (this$teams == null ? other$teams != null : !this$teams.equals(other$teams)) {
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
        return other instanceof GitHubIdentityProvider;
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
        Object $hostname = this.getHostname();
        result = result * prime + ($hostname == null ? 43 : $hostname.hashCode());
        Object $organizations = this.getOrganizations();
        result = result * prime + ($organizations == null ? 43 : $organizations.hashCode());
        Object $teams = this.getTeams();
        result = result * prime + ($teams == null ? 43 : $teams.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "GitHubIdentityProvider(" + "ca=" + this.getCa() + ", clientID=" + this.getClientID() + ", clientSecret=" + this.getClientSecret() + ", hostname=" + this.getHostname() + ", organizations=" + this.getOrganizations() + ", teams=" + this.getTeams() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
