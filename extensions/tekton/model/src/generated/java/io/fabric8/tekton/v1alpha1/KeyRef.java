
package io.fabric8.tekton.v1alpha1;

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
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.SecretReference;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * KeyRef defines the reference to a public key
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "data",
    "hashAlgorithm",
    "kms",
    "secretRef"
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
public class KeyRef implements Editable<KeyRefBuilder>, KubernetesResource
{

    @JsonProperty("data")
    private String data;
    @JsonProperty("hashAlgorithm")
    private String hashAlgorithm;
    @JsonProperty("kms")
    private String kms;
    @JsonProperty("secretRef")
    private SecretReference secretRef;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public KeyRef() {
    }

    public KeyRef(String data, String hashAlgorithm, String kms, SecretReference secretRef) {
        super();
        this.data = data;
        this.hashAlgorithm = hashAlgorithm;
        this.kms = kms;
        this.secretRef = secretRef;
    }

    /**
     * Data contains the inline public key.
     */
    @JsonProperty("data")
    public String getData() {
        return data;
    }

    /**
     * Data contains the inline public key.
     */
    @JsonProperty("data")
    public void setData(String data) {
        this.data = data;
    }

    /**
     * HashAlgorithm always defaults to sha256 if the algorithm hasn't been explicitly set
     */
    @JsonProperty("hashAlgorithm")
    public String getHashAlgorithm() {
        return hashAlgorithm;
    }

    /**
     * HashAlgorithm always defaults to sha256 if the algorithm hasn't been explicitly set
     */
    @JsonProperty("hashAlgorithm")
    public void setHashAlgorithm(String hashAlgorithm) {
        this.hashAlgorithm = hashAlgorithm;
    }

    /**
     * KMS contains the KMS url of the public key Supported formats differ based on the KMS system used. One example of a KMS url could be: gcpkms://projects/[PROJECT]/locations/[LOCATION]&gt;/keyRings/[KEYRING]/cryptoKeys/[KEY]/cryptoKeyVersions/[KEY_VERSION] For more examples please refer https://docs.sigstore.dev/cosign/kms_support. Note that the KMS is not supported yet.
     */
    @JsonProperty("kms")
    public String getKms() {
        return kms;
    }

    /**
     * KMS contains the KMS url of the public key Supported formats differ based on the KMS system used. One example of a KMS url could be: gcpkms://projects/[PROJECT]/locations/[LOCATION]&gt;/keyRings/[KEYRING]/cryptoKeys/[KEY]/cryptoKeyVersions/[KEY_VERSION] For more examples please refer https://docs.sigstore.dev/cosign/kms_support. Note that the KMS is not supported yet.
     */
    @JsonProperty("kms")
    public void setKms(String kms) {
        this.kms = kms;
    }

    /**
     * KeyRef defines the reference to a public key
     */
    @JsonProperty("secretRef")
    public SecretReference getSecretRef() {
        return secretRef;
    }

    /**
     * KeyRef defines the reference to a public key
     */
    @JsonProperty("secretRef")
    public void setSecretRef(SecretReference secretRef) {
        this.secretRef = secretRef;
    }

    @JsonIgnore
    public KeyRefBuilder edit() {
        return new KeyRefBuilder(this);
    }

    @JsonIgnore
    public KeyRefBuilder toBuilder() {
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
