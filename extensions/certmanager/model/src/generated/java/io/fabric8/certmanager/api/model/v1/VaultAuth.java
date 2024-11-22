
package io.fabric8.certmanager.api.model.v1;

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
    "appRole",
    "clientCertificate",
    "kubernetes",
    "tokenSecretRef"
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
public class VaultAuth implements Editable<VaultAuthBuilder> , KubernetesResource
{

    @JsonProperty("appRole")
    private VaultAppRole appRole;
    @JsonProperty("clientCertificate")
    private VaultClientCertificateAuth clientCertificate;
    @JsonProperty("kubernetes")
    private VaultKubernetesAuth kubernetes;
    @JsonProperty("tokenSecretRef")
    private SecretKeySelector tokenSecretRef;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public VaultAuth() {
    }

    public VaultAuth(VaultAppRole appRole, VaultClientCertificateAuth clientCertificate, VaultKubernetesAuth kubernetes, SecretKeySelector tokenSecretRef) {
        super();
        this.appRole = appRole;
        this.clientCertificate = clientCertificate;
        this.kubernetes = kubernetes;
        this.tokenSecretRef = tokenSecretRef;
    }

    @JsonProperty("appRole")
    public VaultAppRole getAppRole() {
        return appRole;
    }

    @JsonProperty("appRole")
    public void setAppRole(VaultAppRole appRole) {
        this.appRole = appRole;
    }

    @JsonProperty("clientCertificate")
    public VaultClientCertificateAuth getClientCertificate() {
        return clientCertificate;
    }

    @JsonProperty("clientCertificate")
    public void setClientCertificate(VaultClientCertificateAuth clientCertificate) {
        this.clientCertificate = clientCertificate;
    }

    @JsonProperty("kubernetes")
    public VaultKubernetesAuth getKubernetes() {
        return kubernetes;
    }

    @JsonProperty("kubernetes")
    public void setKubernetes(VaultKubernetesAuth kubernetes) {
        this.kubernetes = kubernetes;
    }

    @JsonProperty("tokenSecretRef")
    public SecretKeySelector getTokenSecretRef() {
        return tokenSecretRef;
    }

    @JsonProperty("tokenSecretRef")
    public void setTokenSecretRef(SecretKeySelector tokenSecretRef) {
        this.tokenSecretRef = tokenSecretRef;
    }

    @JsonIgnore
    public VaultAuthBuilder edit() {
        return new VaultAuthBuilder(this);
    }

    @JsonIgnore
    public VaultAuthBuilder toBuilder() {
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
