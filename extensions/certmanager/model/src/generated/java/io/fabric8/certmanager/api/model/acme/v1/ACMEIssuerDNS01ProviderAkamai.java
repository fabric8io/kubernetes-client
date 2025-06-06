
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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

}
