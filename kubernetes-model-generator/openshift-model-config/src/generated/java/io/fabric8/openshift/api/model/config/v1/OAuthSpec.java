
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
 * OAuthSpec contains desired cluster auth configuration
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "identityProviders",
    "templates",
    "tokenConfig"
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
public class OAuthSpec implements Editable<OAuthSpecBuilder>, KubernetesResource
{

    @JsonProperty("identityProviders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<IdentityProvider> identityProviders = new ArrayList<>();
    @JsonProperty("templates")
    private OAuthTemplates templates;
    @JsonProperty("tokenConfig")
    private TokenConfig tokenConfig;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public OAuthSpec() {
    }

    public OAuthSpec(List<IdentityProvider> identityProviders, OAuthTemplates templates, TokenConfig tokenConfig) {
        super();
        this.identityProviders = identityProviders;
        this.templates = templates;
        this.tokenConfig = tokenConfig;
    }

    /**
     * identityProviders is an ordered list of ways for a user to identify themselves. When this list is empty, no identities are provisioned for users.
     */
    @JsonProperty("identityProviders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<IdentityProvider> getIdentityProviders() {
        return identityProviders;
    }

    /**
     * identityProviders is an ordered list of ways for a user to identify themselves. When this list is empty, no identities are provisioned for users.
     */
    @JsonProperty("identityProviders")
    public void setIdentityProviders(List<IdentityProvider> identityProviders) {
        this.identityProviders = identityProviders;
    }

    /**
     * OAuthSpec contains desired cluster auth configuration
     */
    @JsonProperty("templates")
    public OAuthTemplates getTemplates() {
        return templates;
    }

    /**
     * OAuthSpec contains desired cluster auth configuration
     */
    @JsonProperty("templates")
    public void setTemplates(OAuthTemplates templates) {
        this.templates = templates;
    }

    /**
     * OAuthSpec contains desired cluster auth configuration
     */
    @JsonProperty("tokenConfig")
    public TokenConfig getTokenConfig() {
        return tokenConfig;
    }

    /**
     * OAuthSpec contains desired cluster auth configuration
     */
    @JsonProperty("tokenConfig")
    public void setTokenConfig(TokenConfig tokenConfig) {
        this.tokenConfig = tokenConfig;
    }

    @JsonIgnore
    public OAuthSpecBuilder edit() {
        return new OAuthSpecBuilder(this);
    }

    @JsonIgnore
    public OAuthSpecBuilder toBuilder() {
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
        if (!(o instanceof OAuthSpec)) {
            return false;
        }
        OAuthSpec other = (OAuthSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$identityProviders = this.getIdentityProviders();
        Object other$identityProviders = other.getIdentityProviders();
        if (this$identityProviders == null ? other$identityProviders != null : !this$identityProviders.equals(other$identityProviders)) {
            return false;
        }
        Object this$templates = this.getTemplates();
        Object other$templates = other.getTemplates();
        if (this$templates == null ? other$templates != null : !this$templates.equals(other$templates)) {
            return false;
        }
        Object this$tokenConfig = this.getTokenConfig();
        Object other$tokenConfig = other.getTokenConfig();
        if (this$tokenConfig == null ? other$tokenConfig != null : !this$tokenConfig.equals(other$tokenConfig)) {
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
        return other instanceof OAuthSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $identityProviders = this.getIdentityProviders();
        result = result * prime + ($identityProviders == null ? 43 : $identityProviders.hashCode());
        Object $templates = this.getTemplates();
        result = result * prime + ($templates == null ? 43 : $templates.hashCode());
        Object $tokenConfig = this.getTokenConfig();
        result = result * prime + ($tokenConfig == null ? 43 : $tokenConfig.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "OAuthSpec(" + "identityProviders=" + this.getIdentityProviders() + ", templates=" + this.getTemplates() + ", tokenConfig=" + this.getTokenConfig() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
