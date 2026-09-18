
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
 * ACMEIssuerDNS01ProviderAkamai is a structure containing the DNS configuration for Akamai DNS—Zone Record Management API
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "accessTokenSecretRef",
    "clientSecretSecretRef",
    "clientTokenSecretRef",
    "serviceConsumerDomain"
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
public class ACMEIssuerDNS01ProviderAkamai implements Editable<ACMEIssuerDNS01ProviderAkamaiBuilder>, KubernetesResource
{

    @JsonProperty("accessTokenSecretRef")
    private SecretKeySelector accessTokenSecretRef;
    @JsonProperty("clientSecretSecretRef")
    private SecretKeySelector clientSecretSecretRef;
    @JsonProperty("clientTokenSecretRef")
    private SecretKeySelector clientTokenSecretRef;
    @JsonProperty("serviceConsumerDomain")
    private String serviceConsumerDomain;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ACMEIssuerDNS01ProviderAkamai() {
    }

    public ACMEIssuerDNS01ProviderAkamai(SecretKeySelector accessTokenSecretRef, SecretKeySelector clientSecretSecretRef, SecretKeySelector clientTokenSecretRef, String serviceConsumerDomain) {
        super();
        this.accessTokenSecretRef = accessTokenSecretRef;
        this.clientSecretSecretRef = clientSecretSecretRef;
        this.clientTokenSecretRef = clientTokenSecretRef;
        this.serviceConsumerDomain = serviceConsumerDomain;
    }

    /**
     * ACMEIssuerDNS01ProviderAkamai is a structure containing the DNS configuration for Akamai DNS—Zone Record Management API
     */
    @JsonProperty("accessTokenSecretRef")
    public SecretKeySelector getAccessTokenSecretRef() {
        return accessTokenSecretRef;
    }

    /**
     * ACMEIssuerDNS01ProviderAkamai is a structure containing the DNS configuration for Akamai DNS—Zone Record Management API
     */
    @JsonProperty("accessTokenSecretRef")
    public void setAccessTokenSecretRef(SecretKeySelector accessTokenSecretRef) {
        this.accessTokenSecretRef = accessTokenSecretRef;
    }

    /**
     * ACMEIssuerDNS01ProviderAkamai is a structure containing the DNS configuration for Akamai DNS—Zone Record Management API
     */
    @JsonProperty("clientSecretSecretRef")
    public SecretKeySelector getClientSecretSecretRef() {
        return clientSecretSecretRef;
    }

    /**
     * ACMEIssuerDNS01ProviderAkamai is a structure containing the DNS configuration for Akamai DNS—Zone Record Management API
     */
    @JsonProperty("clientSecretSecretRef")
    public void setClientSecretSecretRef(SecretKeySelector clientSecretSecretRef) {
        this.clientSecretSecretRef = clientSecretSecretRef;
    }

    /**
     * ACMEIssuerDNS01ProviderAkamai is a structure containing the DNS configuration for Akamai DNS—Zone Record Management API
     */
    @JsonProperty("clientTokenSecretRef")
    public SecretKeySelector getClientTokenSecretRef() {
        return clientTokenSecretRef;
    }

    /**
     * ACMEIssuerDNS01ProviderAkamai is a structure containing the DNS configuration for Akamai DNS—Zone Record Management API
     */
    @JsonProperty("clientTokenSecretRef")
    public void setClientTokenSecretRef(SecretKeySelector clientTokenSecretRef) {
        this.clientTokenSecretRef = clientTokenSecretRef;
    }

    /**
     * ACMEIssuerDNS01ProviderAkamai is a structure containing the DNS configuration for Akamai DNS—Zone Record Management API
     */
    @JsonProperty("serviceConsumerDomain")
    public String getServiceConsumerDomain() {
        return serviceConsumerDomain;
    }

    /**
     * ACMEIssuerDNS01ProviderAkamai is a structure containing the DNS configuration for Akamai DNS—Zone Record Management API
     */
    @JsonProperty("serviceConsumerDomain")
    public void setServiceConsumerDomain(String serviceConsumerDomain) {
        this.serviceConsumerDomain = serviceConsumerDomain;
    }

    @JsonIgnore
    public ACMEIssuerDNS01ProviderAkamaiBuilder edit() {
        return new ACMEIssuerDNS01ProviderAkamaiBuilder(this);
    }

    @JsonIgnore
    public ACMEIssuerDNS01ProviderAkamaiBuilder toBuilder() {
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
        if (!(o instanceof ACMEIssuerDNS01ProviderAkamai)) {
            return false;
        }
        ACMEIssuerDNS01ProviderAkamai other = (ACMEIssuerDNS01ProviderAkamai) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$accessTokenSecretRef = this.getAccessTokenSecretRef();
        Object other$accessTokenSecretRef = other.getAccessTokenSecretRef();
        if (this$accessTokenSecretRef == null ? other$accessTokenSecretRef != null : !this$accessTokenSecretRef.equals(other$accessTokenSecretRef)) {
            return false;
        }
        Object this$clientSecretSecretRef = this.getClientSecretSecretRef();
        Object other$clientSecretSecretRef = other.getClientSecretSecretRef();
        if (this$clientSecretSecretRef == null ? other$clientSecretSecretRef != null : !this$clientSecretSecretRef.equals(other$clientSecretSecretRef)) {
            return false;
        }
        Object this$clientTokenSecretRef = this.getClientTokenSecretRef();
        Object other$clientTokenSecretRef = other.getClientTokenSecretRef();
        if (this$clientTokenSecretRef == null ? other$clientTokenSecretRef != null : !this$clientTokenSecretRef.equals(other$clientTokenSecretRef)) {
            return false;
        }
        Object this$serviceConsumerDomain = this.getServiceConsumerDomain();
        Object other$serviceConsumerDomain = other.getServiceConsumerDomain();
        if (this$serviceConsumerDomain == null ? other$serviceConsumerDomain != null : !this$serviceConsumerDomain.equals(other$serviceConsumerDomain)) {
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
        return other instanceof ACMEIssuerDNS01ProviderAkamai;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $accessTokenSecretRef = this.getAccessTokenSecretRef();
        result = result * prime + ($accessTokenSecretRef == null ? 43 : $accessTokenSecretRef.hashCode());
        Object $clientSecretSecretRef = this.getClientSecretSecretRef();
        result = result * prime + ($clientSecretSecretRef == null ? 43 : $clientSecretSecretRef.hashCode());
        Object $clientTokenSecretRef = this.getClientTokenSecretRef();
        result = result * prime + ($clientTokenSecretRef == null ? 43 : $clientTokenSecretRef.hashCode());
        Object $serviceConsumerDomain = this.getServiceConsumerDomain();
        result = result * prime + ($serviceConsumerDomain == null ? 43 : $serviceConsumerDomain.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ACMEIssuerDNS01ProviderAkamai(" + "accessTokenSecretRef=" + this.getAccessTokenSecretRef() + ", clientSecretSecretRef=" + this.getClientSecretSecretRef() + ", clientTokenSecretRef=" + this.getClientTokenSecretRef() + ", serviceConsumerDomain=" + this.getServiceConsumerDomain() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
