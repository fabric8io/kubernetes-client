
package io.fabric8.certmanager.api.model.acme.v1;

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
import io.fabric8.certmanager.api.model.meta.v1.SecretKeySelector;
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

/**
 * ACMEIssuerDNS01ProviderCloudflare is a structure containing the DNS configuration for Cloudflare. One of `apiKeySecretRef` or `apiTokenSecretRef` must be provided.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiKeySecretRef",
    "apiTokenSecretRef",
    "email"
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
public class ACMEIssuerDNS01ProviderCloudflare implements Editable<ACMEIssuerDNS01ProviderCloudflareBuilder>, KubernetesResource
{

    @JsonProperty("apiKeySecretRef")
    private SecretKeySelector apiKeySecretRef;
    @JsonProperty("apiTokenSecretRef")
    private SecretKeySelector apiTokenSecretRef;
    @JsonProperty("email")
    private String email;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ACMEIssuerDNS01ProviderCloudflare() {
    }

    public ACMEIssuerDNS01ProviderCloudflare(SecretKeySelector apiKeySecretRef, SecretKeySelector apiTokenSecretRef, String email) {
        super();
        this.apiKeySecretRef = apiKeySecretRef;
        this.apiTokenSecretRef = apiTokenSecretRef;
        this.email = email;
    }

    /**
     * ACMEIssuerDNS01ProviderCloudflare is a structure containing the DNS configuration for Cloudflare. One of `apiKeySecretRef` or `apiTokenSecretRef` must be provided.
     */
    @JsonProperty("apiKeySecretRef")
    public SecretKeySelector getApiKeySecretRef() {
        return apiKeySecretRef;
    }

    /**
     * ACMEIssuerDNS01ProviderCloudflare is a structure containing the DNS configuration for Cloudflare. One of `apiKeySecretRef` or `apiTokenSecretRef` must be provided.
     */
    @JsonProperty("apiKeySecretRef")
    public void setApiKeySecretRef(SecretKeySelector apiKeySecretRef) {
        this.apiKeySecretRef = apiKeySecretRef;
    }

    /**
     * ACMEIssuerDNS01ProviderCloudflare is a structure containing the DNS configuration for Cloudflare. One of `apiKeySecretRef` or `apiTokenSecretRef` must be provided.
     */
    @JsonProperty("apiTokenSecretRef")
    public SecretKeySelector getApiTokenSecretRef() {
        return apiTokenSecretRef;
    }

    /**
     * ACMEIssuerDNS01ProviderCloudflare is a structure containing the DNS configuration for Cloudflare. One of `apiKeySecretRef` or `apiTokenSecretRef` must be provided.
     */
    @JsonProperty("apiTokenSecretRef")
    public void setApiTokenSecretRef(SecretKeySelector apiTokenSecretRef) {
        this.apiTokenSecretRef = apiTokenSecretRef;
    }

    /**
     * Email of the account, only required when using API key based authentication.
     */
    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    /**
     * Email of the account, only required when using API key based authentication.
     */
    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonIgnore
    public ACMEIssuerDNS01ProviderCloudflareBuilder edit() {
        return new ACMEIssuerDNS01ProviderCloudflareBuilder(this);
    }

    @JsonIgnore
    public ACMEIssuerDNS01ProviderCloudflareBuilder toBuilder() {
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
        if (!(o instanceof ACMEIssuerDNS01ProviderCloudflare)) {
            return false;
        }
        ACMEIssuerDNS01ProviderCloudflare other = (ACMEIssuerDNS01ProviderCloudflare) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$apiKeySecretRef = this.getApiKeySecretRef();
        Object other$apiKeySecretRef = other.getApiKeySecretRef();
        if (this$apiKeySecretRef == null ? other$apiKeySecretRef != null : !this$apiKeySecretRef.equals(other$apiKeySecretRef)) {
            return false;
        }
        Object this$apiTokenSecretRef = this.getApiTokenSecretRef();
        Object other$apiTokenSecretRef = other.getApiTokenSecretRef();
        if (this$apiTokenSecretRef == null ? other$apiTokenSecretRef != null : !this$apiTokenSecretRef.equals(other$apiTokenSecretRef)) {
            return false;
        }
        Object this$email = this.getEmail();
        Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) {
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
        return other instanceof ACMEIssuerDNS01ProviderCloudflare;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiKeySecretRef = this.getApiKeySecretRef();
        result = result * prime + ($apiKeySecretRef == null ? 43 : $apiKeySecretRef.hashCode());
        Object $apiTokenSecretRef = this.getApiTokenSecretRef();
        result = result * prime + ($apiTokenSecretRef == null ? 43 : $apiTokenSecretRef.hashCode());
        Object $email = this.getEmail();
        result = result * prime + ($email == null ? 43 : $email.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ACMEIssuerDNS01ProviderCloudflare(" + "apiKeySecretRef=" + this.getApiKeySecretRef() + ", apiTokenSecretRef=" + this.getApiTokenSecretRef() + ", email=" + this.getEmail() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
