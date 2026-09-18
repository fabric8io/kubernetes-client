
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
 * ACMEIssuerDNS01ProviderDigitalOcean is a structure containing the DNS configuration for DigitalOcean Domains
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "tokenSecretRef"
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
public class ACMEIssuerDNS01ProviderDigitalOcean implements Editable<ACMEIssuerDNS01ProviderDigitalOceanBuilder>, KubernetesResource
{

    @JsonProperty("tokenSecretRef")
    private SecretKeySelector tokenSecretRef;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ACMEIssuerDNS01ProviderDigitalOcean() {
    }

    public ACMEIssuerDNS01ProviderDigitalOcean(SecretKeySelector tokenSecretRef) {
        super();
        this.tokenSecretRef = tokenSecretRef;
    }

    /**
     * ACMEIssuerDNS01ProviderDigitalOcean is a structure containing the DNS configuration for DigitalOcean Domains
     */
    @JsonProperty("tokenSecretRef")
    public SecretKeySelector getTokenSecretRef() {
        return tokenSecretRef;
    }

    /**
     * ACMEIssuerDNS01ProviderDigitalOcean is a structure containing the DNS configuration for DigitalOcean Domains
     */
    @JsonProperty("tokenSecretRef")
    public void setTokenSecretRef(SecretKeySelector tokenSecretRef) {
        this.tokenSecretRef = tokenSecretRef;
    }

    @JsonIgnore
    public ACMEIssuerDNS01ProviderDigitalOceanBuilder edit() {
        return new ACMEIssuerDNS01ProviderDigitalOceanBuilder(this);
    }

    @JsonIgnore
    public ACMEIssuerDNS01ProviderDigitalOceanBuilder toBuilder() {
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
        if (!(o instanceof ACMEIssuerDNS01ProviderDigitalOcean)) {
            return false;
        }
        ACMEIssuerDNS01ProviderDigitalOcean other = (ACMEIssuerDNS01ProviderDigitalOcean) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$tokenSecretRef = this.getTokenSecretRef();
        Object other$tokenSecretRef = other.getTokenSecretRef();
        if (this$tokenSecretRef == null ? other$tokenSecretRef != null : !this$tokenSecretRef.equals(other$tokenSecretRef)) {
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
        return other instanceof ACMEIssuerDNS01ProviderDigitalOcean;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $tokenSecretRef = this.getTokenSecretRef();
        result = result * prime + ($tokenSecretRef == null ? 43 : $tokenSecretRef.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ACMEIssuerDNS01ProviderDigitalOcean(" + "tokenSecretRef=" + this.getTokenSecretRef() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
