
package io.fabric8.openshift.api.model.config.v1;

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
    "oauthMetadata",
    "oidcProviders",
    "serviceAccountIssuer",
    "type",
    "webhookTokenAuthenticator",
    "webhookTokenAuthenticators"
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
     * OIDCProviders are OIDC identity providers that can issue tokens for this cluster Can only be set if "Type" is set to "OIDC".<br><p> <br><p> At most one provider can be configured.
     */
    @JsonProperty("oidcProviders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<OIDCProvider> getOidcProviders() {
        return oidcProviders;
    }

    /**
     * OIDCProviders are OIDC identity providers that can issue tokens for this cluster Can only be set if "Type" is set to "OIDC".<br><p> <br><p> At most one provider can be configured.
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
