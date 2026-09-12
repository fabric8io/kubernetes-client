
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "oauthMetadata",
    "oidcProviders",
    "serviceAccountIssuer",
    "type",
    "webhookTokenAuthenticator",
    "webhookTokenAuthenticators"
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
public class AuthenticationSpec implements Editable<AuthenticationSpecBuilder>, KubernetesResource
{

    @JsonProperty("oauthMetadata")
    private ConfigMapNameReference oauthMetadata;
    @JsonProperty("oidcProviders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<OIDCProvider> oidcProviders = new ArrayList<>();
    @JsonProperty("serviceAccountIssuer")
    private String serviceAccountIssuer;
    @JsonProperty("type")
    private String type;
    @JsonProperty("webhookTokenAuthenticator")
    private WebhookTokenAuthenticator webhookTokenAuthenticator;
    @JsonProperty("webhookTokenAuthenticators")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DeprecatedWebhookTokenAuthenticator> webhookTokenAuthenticators = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AuthenticationSpec() {
    }

    public AuthenticationSpec(ConfigMapNameReference oauthMetadata, List<OIDCProvider> oidcProviders, String serviceAccountIssuer, String type, WebhookTokenAuthenticator webhookTokenAuthenticator, List<DeprecatedWebhookTokenAuthenticator> webhookTokenAuthenticators) {
        super();
        this.oauthMetadata = oauthMetadata;
        this.oidcProviders = oidcProviders;
        this.serviceAccountIssuer = serviceAccountIssuer;
        this.type = type;
        this.webhookTokenAuthenticator = webhookTokenAuthenticator;
        this.webhookTokenAuthenticators = webhookTokenAuthenticators;
    }

    @JsonProperty("oauthMetadata")
    public ConfigMapNameReference getOauthMetadata() {
        return oauthMetadata;
    }

    @JsonProperty("oauthMetadata")
    public void setOauthMetadata(ConfigMapNameReference oauthMetadata) {
        this.oauthMetadata = oauthMetadata;
    }

    /**
     * oidcProviders are OIDC identity providers that can issue tokens for this cluster Can only be set if "Type" is set to "OIDC".<br><p> <br><p> At most one provider can be configured.
     */
    @JsonProperty("oidcProviders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<OIDCProvider> getOidcProviders() {
        return oidcProviders;
    }

    /**
     * oidcProviders are OIDC identity providers that can issue tokens for this cluster Can only be set if "Type" is set to "OIDC".<br><p> <br><p> At most one provider can be configured.
     */
    @JsonProperty("oidcProviders")
    public void setOidcProviders(List<OIDCProvider> oidcProviders) {
        this.oidcProviders = oidcProviders;
    }

    /**
     * serviceAccountIssuer is the identifier of the bound service account token issuer. The default is https://kubernetes.default.svc WARNING: Updating this field will not result in immediate invalidation of all bound tokens with the previous issuer value. Instead, the tokens issued by previous service account issuer will continue to be trusted for a time period chosen by the platform (currently set to 24h). This time period is subject to change over time. This allows internal components to transition to use new service account issuer without service distruption.
     */
    @JsonProperty("serviceAccountIssuer")
    public String getServiceAccountIssuer() {
        return serviceAccountIssuer;
    }

    /**
     * serviceAccountIssuer is the identifier of the bound service account token issuer. The default is https://kubernetes.default.svc WARNING: Updating this field will not result in immediate invalidation of all bound tokens with the previous issuer value. Instead, the tokens issued by previous service account issuer will continue to be trusted for a time period chosen by the platform (currently set to 24h). This time period is subject to change over time. This allows internal components to transition to use new service account issuer without service distruption.
     */
    @JsonProperty("serviceAccountIssuer")
    public void setServiceAccountIssuer(String serviceAccountIssuer) {
        this.serviceAccountIssuer = serviceAccountIssuer;
    }

    /**
     * type identifies the cluster managed, user facing authentication mode in use. Specifically, it manages the component that responds to login attempts. The default is IntegratedOAuth.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type identifies the cluster managed, user facing authentication mode in use. Specifically, it manages the component that responds to login attempts. The default is IntegratedOAuth.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("webhookTokenAuthenticator")
    public WebhookTokenAuthenticator getWebhookTokenAuthenticator() {
        return webhookTokenAuthenticator;
    }

    @JsonProperty("webhookTokenAuthenticator")
    public void setWebhookTokenAuthenticator(WebhookTokenAuthenticator webhookTokenAuthenticator) {
        this.webhookTokenAuthenticator = webhookTokenAuthenticator;
    }

    /**
     * webhookTokenAuthenticators is DEPRECATED, setting it has no effect.
     */
    @JsonProperty("webhookTokenAuthenticators")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DeprecatedWebhookTokenAuthenticator> getWebhookTokenAuthenticators() {
        return webhookTokenAuthenticators;
    }

    /**
     * webhookTokenAuthenticators is DEPRECATED, setting it has no effect.
     */
    @JsonProperty("webhookTokenAuthenticators")
    public void setWebhookTokenAuthenticators(List<DeprecatedWebhookTokenAuthenticator> webhookTokenAuthenticators) {
        this.webhookTokenAuthenticators = webhookTokenAuthenticators;
    }

    @JsonIgnore
    public AuthenticationSpecBuilder edit() {
        return new AuthenticationSpecBuilder(this);
    }

    @JsonIgnore
    public AuthenticationSpecBuilder toBuilder() {
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
        if (!(o instanceof AuthenticationSpec)) {
            return false;
        }
        AuthenticationSpec other = (AuthenticationSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$oauthMetadata = this.getOauthMetadata();
        Object other$oauthMetadata = other.getOauthMetadata();
        if (this$oauthMetadata == null ? other$oauthMetadata != null : !this$oauthMetadata.equals(other$oauthMetadata)) {
            return false;
        }
        Object this$oidcProviders = this.getOidcProviders();
        Object other$oidcProviders = other.getOidcProviders();
        if (this$oidcProviders == null ? other$oidcProviders != null : !this$oidcProviders.equals(other$oidcProviders)) {
            return false;
        }
        Object this$serviceAccountIssuer = this.getServiceAccountIssuer();
        Object other$serviceAccountIssuer = other.getServiceAccountIssuer();
        if (this$serviceAccountIssuer == null ? other$serviceAccountIssuer != null : !this$serviceAccountIssuer.equals(other$serviceAccountIssuer)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
            return false;
        }
        Object this$webhookTokenAuthenticator = this.getWebhookTokenAuthenticator();
        Object other$webhookTokenAuthenticator = other.getWebhookTokenAuthenticator();
        if (this$webhookTokenAuthenticator == null ? other$webhookTokenAuthenticator != null : !this$webhookTokenAuthenticator.equals(other$webhookTokenAuthenticator)) {
            return false;
        }
        Object this$webhookTokenAuthenticators = this.getWebhookTokenAuthenticators();
        Object other$webhookTokenAuthenticators = other.getWebhookTokenAuthenticators();
        if (this$webhookTokenAuthenticators == null ? other$webhookTokenAuthenticators != null : !this$webhookTokenAuthenticators.equals(other$webhookTokenAuthenticators)) {
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
        return other instanceof AuthenticationSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $oauthMetadata = this.getOauthMetadata();
        result = result * prime + ($oauthMetadata == null ? 43 : $oauthMetadata.hashCode());
        Object $oidcProviders = this.getOidcProviders();
        result = result * prime + ($oidcProviders == null ? 43 : $oidcProviders.hashCode());
        Object $serviceAccountIssuer = this.getServiceAccountIssuer();
        result = result * prime + ($serviceAccountIssuer == null ? 43 : $serviceAccountIssuer.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $webhookTokenAuthenticator = this.getWebhookTokenAuthenticator();
        result = result * prime + ($webhookTokenAuthenticator == null ? 43 : $webhookTokenAuthenticator.hashCode());
        Object $webhookTokenAuthenticators = this.getWebhookTokenAuthenticators();
        result = result * prime + ($webhookTokenAuthenticators == null ? 43 : $webhookTokenAuthenticators.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AuthenticationSpec(" + "oauthMetadata=" + this.getOauthMetadata() + ", oidcProviders=" + this.getOidcProviders() + ", serviceAccountIssuer=" + this.getServiceAccountIssuer() + ", type=" + this.getType() + ", webhookTokenAuthenticator=" + this.getWebhookTokenAuthenticator() + ", webhookTokenAuthenticators=" + this.getWebhookTokenAuthenticators() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
