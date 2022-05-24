
package io.fabric8.certmanager.api.model.acme.v1;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.certmanager.api.model.meta.v1.SecretKeySelector;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "accessTokenSecretRef",
    "clientSecretSecretRef",
    "clientTokenSecretRef",
    "serviceConsumerDomain"
})
@ToString
@EqualsAndHashCode
@Setter
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
public class ACMEIssuerDNS01ProviderAkamai implements KubernetesResource
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
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ACMEIssuerDNS01ProviderAkamai() {
    }

    /**
     * 
     * @param clientTokenSecretRef
     * @param clientSecretSecretRef
     * @param serviceConsumerDomain
     * @param accessTokenSecretRef
     */
    public ACMEIssuerDNS01ProviderAkamai(SecretKeySelector accessTokenSecretRef, SecretKeySelector clientSecretSecretRef, SecretKeySelector clientTokenSecretRef, String serviceConsumerDomain) {
        super();
        this.accessTokenSecretRef = accessTokenSecretRef;
        this.clientSecretSecretRef = clientSecretSecretRef;
        this.clientTokenSecretRef = clientTokenSecretRef;
        this.serviceConsumerDomain = serviceConsumerDomain;
    }

    @JsonProperty("accessTokenSecretRef")
    public SecretKeySelector getAccessTokenSecretRef() {
        return accessTokenSecretRef;
    }

    @JsonProperty("accessTokenSecretRef")
    public void setAccessTokenSecretRef(SecretKeySelector accessTokenSecretRef) {
        this.accessTokenSecretRef = accessTokenSecretRef;
    }

    @JsonProperty("clientSecretSecretRef")
    public SecretKeySelector getClientSecretSecretRef() {
        return clientSecretSecretRef;
    }

    @JsonProperty("clientSecretSecretRef")
    public void setClientSecretSecretRef(SecretKeySelector clientSecretSecretRef) {
        this.clientSecretSecretRef = clientSecretSecretRef;
    }

    @JsonProperty("clientTokenSecretRef")
    public SecretKeySelector getClientTokenSecretRef() {
        return clientTokenSecretRef;
    }

    @JsonProperty("clientTokenSecretRef")
    public void setClientTokenSecretRef(SecretKeySelector clientTokenSecretRef) {
        this.clientTokenSecretRef = clientTokenSecretRef;
    }

    @JsonProperty("serviceConsumerDomain")
    public String getServiceConsumerDomain() {
        return serviceConsumerDomain;
    }

    @JsonProperty("serviceConsumerDomain")
    public void setServiceConsumerDomain(String serviceConsumerDomain) {
        this.serviceConsumerDomain = serviceConsumerDomain;
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
