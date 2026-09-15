
package io.fabric8.openshift.api.model.machine.v1beta1;

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
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * GCPEncryptionKeyReference describes the encryptionKey to use for a disk's encryption.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "kmsKey",
    "kmsKeyServiceAccount"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
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
public class GCPEncryptionKeyReference implements Editable<GCPEncryptionKeyReferenceBuilder>, KubernetesResource
{

    @JsonProperty("kmsKey")
    private GCPKMSKeyReference kmsKey;
    @JsonProperty("kmsKeyServiceAccount")
    private String kmsKeyServiceAccount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GCPEncryptionKeyReference() {
    }

    public GCPEncryptionKeyReference(GCPKMSKeyReference kmsKey, String kmsKeyServiceAccount) {
        super();
        this.kmsKey = kmsKey;
        this.kmsKeyServiceAccount = kmsKeyServiceAccount;
    }

    /**
     * GCPEncryptionKeyReference describes the encryptionKey to use for a disk's encryption.
     */
    @JsonProperty("kmsKey")
    public GCPKMSKeyReference getKmsKey() {
        return kmsKey;
    }

    /**
     * GCPEncryptionKeyReference describes the encryptionKey to use for a disk's encryption.
     */
    @JsonProperty("kmsKey")
    public void setKmsKey(GCPKMSKeyReference kmsKey) {
        this.kmsKey = kmsKey;
    }

    /**
     * kmsKeyServiceAccount is the service account being used for the encryption request for the given KMS key. If absent, the Compute Engine default service account is used. See https://cloud.google.com/compute/docs/access/service-accounts#compute_engine_service_account for details on the default service account.
     */
    @JsonProperty("kmsKeyServiceAccount")
    public String getKmsKeyServiceAccount() {
        return kmsKeyServiceAccount;
    }

    /**
     * kmsKeyServiceAccount is the service account being used for the encryption request for the given KMS key. If absent, the Compute Engine default service account is used. See https://cloud.google.com/compute/docs/access/service-accounts#compute_engine_service_account for details on the default service account.
     */
    @JsonProperty("kmsKeyServiceAccount")
    public void setKmsKeyServiceAccount(String kmsKeyServiceAccount) {
        this.kmsKeyServiceAccount = kmsKeyServiceAccount;
    }

    @JsonIgnore
    public GCPEncryptionKeyReferenceBuilder edit() {
        return new GCPEncryptionKeyReferenceBuilder(this);
    }

    @JsonIgnore
    public GCPEncryptionKeyReferenceBuilder toBuilder() {
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
        if (!(o instanceof GCPEncryptionKeyReference)) {
            return false;
        }
        GCPEncryptionKeyReference other = (GCPEncryptionKeyReference) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$kmsKey = this.getKmsKey();
        Object other$kmsKey = other.getKmsKey();
        if (this$kmsKey == null ? other$kmsKey != null : !this$kmsKey.equals(other$kmsKey)) {
            return false;
        }
        Object this$kmsKeyServiceAccount = this.getKmsKeyServiceAccount();
        Object other$kmsKeyServiceAccount = other.getKmsKeyServiceAccount();
        if (this$kmsKeyServiceAccount == null ? other$kmsKeyServiceAccount != null : !this$kmsKeyServiceAccount.equals(other$kmsKeyServiceAccount)) {
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
        return other instanceof GCPEncryptionKeyReference;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $kmsKey = this.getKmsKey();
        result = result * prime + ($kmsKey == null ? 43 : $kmsKey.hashCode());
        Object $kmsKeyServiceAccount = this.getKmsKeyServiceAccount();
        result = result * prime + ($kmsKeyServiceAccount == null ? 43 : $kmsKeyServiceAccount.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "GCPEncryptionKeyReference(" + "kmsKey=" + this.getKmsKey() + ", kmsKeyServiceAccount=" + this.getKmsKeyServiceAccount() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
