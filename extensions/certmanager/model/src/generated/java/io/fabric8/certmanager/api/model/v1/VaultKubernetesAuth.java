
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
 * Authenticate against Vault using a Kubernetes ServiceAccount token stored in a Secret.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "mountPath",
    "role",
    "secretRef",
    "serviceAccountRef"
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
public class VaultKubernetesAuth implements Editable<VaultKubernetesAuthBuilder>, KubernetesResource
{

    @JsonProperty("mountPath")
    private String mountPath;
    @JsonProperty("role")
    private String role;
    @JsonProperty("secretRef")
    private SecretKeySelector secretRef;
    @JsonProperty("serviceAccountRef")
    private ServiceAccountRef serviceAccountRef;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VaultKubernetesAuth() {
    }

    public VaultKubernetesAuth(String mountPath, String role, SecretKeySelector secretRef, ServiceAccountRef serviceAccountRef) {
        super();
        this.mountPath = mountPath;
        this.role = role;
        this.secretRef = secretRef;
        this.serviceAccountRef = serviceAccountRef;
    }

    /**
     * The Vault mountPath here is the mount path to use when authenticating with Vault. For example, setting a value to `/v1/auth/foo`, will use the path `/v1/auth/foo/login` to authenticate with Vault. If unspecified, the default value "/v1/auth/kubernetes" will be used.
     */
    @JsonProperty("mountPath")
    public String getMountPath() {
        return mountPath;
    }

    /**
     * The Vault mountPath here is the mount path to use when authenticating with Vault. For example, setting a value to `/v1/auth/foo`, will use the path `/v1/auth/foo/login` to authenticate with Vault. If unspecified, the default value "/v1/auth/kubernetes" will be used.
     */
    @JsonProperty("mountPath")
    public void setMountPath(String mountPath) {
        this.mountPath = mountPath;
    }

    /**
     * A required field containing the Vault Role to assume. A Role binds a Kubernetes ServiceAccount with a set of Vault policies.
     */
    @JsonProperty("role")
    public String getRole() {
        return role;
    }

    /**
     * A required field containing the Vault Role to assume. A Role binds a Kubernetes ServiceAccount with a set of Vault policies.
     */
    @JsonProperty("role")
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Authenticate against Vault using a Kubernetes ServiceAccount token stored in a Secret.
     */
    @JsonProperty("secretRef")
    public SecretKeySelector getSecretRef() {
        return secretRef;
    }

    /**
     * Authenticate against Vault using a Kubernetes ServiceAccount token stored in a Secret.
     */
    @JsonProperty("secretRef")
    public void setSecretRef(SecretKeySelector secretRef) {
        this.secretRef = secretRef;
    }

    /**
     * Authenticate against Vault using a Kubernetes ServiceAccount token stored in a Secret.
     */
    @JsonProperty("serviceAccountRef")
    public ServiceAccountRef getServiceAccountRef() {
        return serviceAccountRef;
    }

    /**
     * Authenticate against Vault using a Kubernetes ServiceAccount token stored in a Secret.
     */
    @JsonProperty("serviceAccountRef")
    public void setServiceAccountRef(ServiceAccountRef serviceAccountRef) {
        this.serviceAccountRef = serviceAccountRef;
    }

    @JsonIgnore
    public VaultKubernetesAuthBuilder edit() {
        return new VaultKubernetesAuthBuilder(this);
    }

    @JsonIgnore
    public VaultKubernetesAuthBuilder toBuilder() {
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
        if (!(o instanceof VaultKubernetesAuth)) {
            return false;
        }
        VaultKubernetesAuth other = (VaultKubernetesAuth) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$mountPath = this.getMountPath();
        Object other$mountPath = other.getMountPath();
        if (this$mountPath == null ? other$mountPath != null : !this$mountPath.equals(other$mountPath)) {
            return false;
        }
        Object this$role = this.getRole();
        Object other$role = other.getRole();
        if (this$role == null ? other$role != null : !this$role.equals(other$role)) {
            return false;
        }
        Object this$secretRef = this.getSecretRef();
        Object other$secretRef = other.getSecretRef();
        if (this$secretRef == null ? other$secretRef != null : !this$secretRef.equals(other$secretRef)) {
            return false;
        }
        Object this$serviceAccountRef = this.getServiceAccountRef();
        Object other$serviceAccountRef = other.getServiceAccountRef();
        if (this$serviceAccountRef == null ? other$serviceAccountRef != null : !this$serviceAccountRef.equals(other$serviceAccountRef)) {
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
        return other instanceof VaultKubernetesAuth;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $mountPath = this.getMountPath();
        result = result * prime + ($mountPath == null ? 43 : $mountPath.hashCode());
        Object $role = this.getRole();
        result = result * prime + ($role == null ? 43 : $role.hashCode());
        Object $secretRef = this.getSecretRef();
        result = result * prime + ($secretRef == null ? 43 : $secretRef.hashCode());
        Object $serviceAccountRef = this.getServiceAccountRef();
        result = result * prime + ($serviceAccountRef == null ? 43 : $serviceAccountRef.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "VaultKubernetesAuth(" + "mountPath=" + this.getMountPath() + ", role=" + this.getRole() + ", secretRef=" + this.getSecretRef() + ", serviceAccountRef=" + this.getServiceAccountRef() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
