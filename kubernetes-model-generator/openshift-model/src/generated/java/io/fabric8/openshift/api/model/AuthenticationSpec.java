
package io.fabric8.openshift.api.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import lombok.ToString;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "oauthMetadata",
    "serviceAccountIssuer",
    "type",
    "webhookTokenAuthenticator",
    "webhookTokenAuthenticators"
})
@ToString
@EqualsAndHashCode
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
public class AuthenticationSpec implements KubernetesResource
{

    @JsonProperty("oauthMetadata")
    private ConfigMapNameReference oauthMetadata;
    @JsonProperty("serviceAccountIssuer")
    private String serviceAccountIssuer;
    @JsonProperty("type")
    private String type;
    @JsonProperty("webhookTokenAuthenticator")
    private WebhookTokenAuthenticator webhookTokenAuthenticator;
    @JsonProperty("webhookTokenAuthenticators")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DeprecatedWebhookTokenAuthenticator> webhookTokenAuthenticators = new ArrayList<DeprecatedWebhookTokenAuthenticator>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public AuthenticationSpec() {
    }

    /**
     * 
     * @param webhookTokenAuthenticators
     * @param serviceAccountIssuer
     * @param oauthMetadata
     * @param type
     * @param webhookTokenAuthenticator
     */
    public AuthenticationSpec(ConfigMapNameReference oauthMetadata, String serviceAccountIssuer, String type, WebhookTokenAuthenticator webhookTokenAuthenticator, List<DeprecatedWebhookTokenAuthenticator> webhookTokenAuthenticators) {
        super();
        this.oauthMetadata = oauthMetadata;
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

    @JsonProperty("serviceAccountIssuer")
    public String getServiceAccountIssuer() {
        return serviceAccountIssuer;
    }

    @JsonProperty("serviceAccountIssuer")
    public void setServiceAccountIssuer(String serviceAccountIssuer) {
        this.serviceAccountIssuer = serviceAccountIssuer;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

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

    @JsonProperty("webhookTokenAuthenticators")
    public List<DeprecatedWebhookTokenAuthenticator> getWebhookTokenAuthenticators() {
        return webhookTokenAuthenticators;
    }

    @JsonProperty("webhookTokenAuthenticators")
    public void setWebhookTokenAuthenticators(List<DeprecatedWebhookTokenAuthenticator> webhookTokenAuthenticators) {
        this.webhookTokenAuthenticators = webhookTokenAuthenticators;
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
