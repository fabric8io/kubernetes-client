
package io.fabric8.certmanager.api.model.v1;

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
 * VaultAuth is configuration used to authenticate with a Vault server. The order of precedence is [`tokenSecretRef`, `appRole`, `clientCertificate` or `kubernetes`].
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "appRole",
    "clientCertificate",
    "kubernetes",
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
public class VaultAuth implements Editable<VaultAuthBuilder>, KubernetesResource
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

    /**
     * VaultAuth is configuration used to authenticate with a Vault server. The order of precedence is [`tokenSecretRef`, `appRole`, `clientCertificate` or `kubernetes`].
     */
    @JsonProperty("appRole")
    public VaultAppRole getAppRole() {
        return appRole;
    }

    /**
     * VaultAuth is configuration used to authenticate with a Vault server. The order of precedence is [`tokenSecretRef`, `appRole`, `clientCertificate` or `kubernetes`].
     */
    @JsonProperty("appRole")
    public void setAppRole(VaultAppRole appRole) {
        this.appRole = appRole;
    }

    /**
     * VaultAuth is configuration used to authenticate with a Vault server. The order of precedence is [`tokenSecretRef`, `appRole`, `clientCertificate` or `kubernetes`].
     */
    @JsonProperty("clientCertificate")
    public VaultClientCertificateAuth getClientCertificate() {
        return clientCertificate;
    }

    /**
     * VaultAuth is configuration used to authenticate with a Vault server. The order of precedence is [`tokenSecretRef`, `appRole`, `clientCertificate` or `kubernetes`].
     */
    @JsonProperty("clientCertificate")
    public void setClientCertificate(VaultClientCertificateAuth clientCertificate) {
        this.clientCertificate = clientCertificate;
    }

    /**
     * VaultAuth is configuration used to authenticate with a Vault server. The order of precedence is [`tokenSecretRef`, `appRole`, `clientCertificate` or `kubernetes`].
     */
    @JsonProperty("kubernetes")
    public VaultKubernetesAuth getKubernetes() {
        return kubernetes;
    }

    /**
     * VaultAuth is configuration used to authenticate with a Vault server. The order of precedence is [`tokenSecretRef`, `appRole`, `clientCertificate` or `kubernetes`].
     */
    @JsonProperty("kubernetes")
    public void setKubernetes(VaultKubernetesAuth kubernetes) {
        this.kubernetes = kubernetes;
    }

    /**
     * VaultAuth is configuration used to authenticate with a Vault server. The order of precedence is [`tokenSecretRef`, `appRole`, `clientCertificate` or `kubernetes`].
     */
    @JsonProperty("tokenSecretRef")
    public SecretKeySelector getTokenSecretRef() {
        return tokenSecretRef;
    }

    /**
     * VaultAuth is configuration used to authenticate with a Vault server. The order of precedence is [`tokenSecretRef`, `appRole`, `clientCertificate` or `kubernetes`].
     */
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
        if (!(o instanceof VaultAuth)) {
            return false;
        }
        VaultAuth other = (VaultAuth) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$appRole = this.getAppRole();
        Object other$appRole = other.getAppRole();
        if (this$appRole == null ? other$appRole != null : !this$appRole.equals(other$appRole)) {
            return false;
        }
        Object this$clientCertificate = this.getClientCertificate();
        Object other$clientCertificate = other.getClientCertificate();
        if (this$clientCertificate == null ? other$clientCertificate != null : !this$clientCertificate.equals(other$clientCertificate)) {
            return false;
        }
        Object this$kubernetes = this.getKubernetes();
        Object other$kubernetes = other.getKubernetes();
        if (this$kubernetes == null ? other$kubernetes != null : !this$kubernetes.equals(other$kubernetes)) {
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
        return other instanceof VaultAuth;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $appRole = this.getAppRole();
        result = result * prime + ($appRole == null ? 43 : $appRole.hashCode());
        Object $clientCertificate = this.getClientCertificate();
        result = result * prime + ($clientCertificate == null ? 43 : $clientCertificate.hashCode());
        Object $kubernetes = this.getKubernetes();
        result = result * prime + ($kubernetes == null ? 43 : $kubernetes.hashCode());
        Object $tokenSecretRef = this.getTokenSecretRef();
        result = result * prime + ($tokenSecretRef == null ? 43 : $tokenSecretRef.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "VaultAuth(" + "appRole=" + this.getAppRole() + ", clientCertificate=" + this.getClientCertificate() + ", kubernetes=" + this.getKubernetes() + ", tokenSecretRef=" + this.getTokenSecretRef() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
