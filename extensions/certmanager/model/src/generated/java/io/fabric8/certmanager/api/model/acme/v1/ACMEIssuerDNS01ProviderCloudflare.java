
package io.fabric8.certmanager.api.model.acme.v1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiKeySecretRef",
    "apiTokenSecretRef",
    "email"
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
public class ACMEIssuerDNS01ProviderCloudflare implements Editable<ACMEIssuerDNS01ProviderCloudflareBuilder> , KubernetesResource
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
     * 
     */
    public ACMEIssuerDNS01ProviderCloudflare() {
    }

    public ACMEIssuerDNS01ProviderCloudflare(SecretKeySelector apiKeySecretRef, SecretKeySelector apiTokenSecretRef, String email) {
        super();
        this.apiKeySecretRef = apiKeySecretRef;
        this.apiTokenSecretRef = apiTokenSecretRef;
        this.email = email;
    }

    @JsonProperty("apiKeySecretRef")
    public SecretKeySelector getApiKeySecretRef() {
        return apiKeySecretRef;
    }

    @JsonProperty("apiKeySecretRef")
    public void setApiKeySecretRef(SecretKeySelector apiKeySecretRef) {
        this.apiKeySecretRef = apiKeySecretRef;
    }

    @JsonProperty("apiTokenSecretRef")
    public SecretKeySelector getApiTokenSecretRef() {
        return apiTokenSecretRef;
    }

    @JsonProperty("apiTokenSecretRef")
    public void setApiTokenSecretRef(SecretKeySelector apiTokenSecretRef) {
        this.apiTokenSecretRef = apiTokenSecretRef;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

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
