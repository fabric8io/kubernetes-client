
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
 * CertificatePrivateKey contains configuration options for private keys used by the Certificate controller. These include the key algorithm and size, the used encoding and the rotation policy.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "algorithm",
    "encoding",
    "rotationPolicy",
    "size"
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
public class CertificatePrivateKey implements Editable<CertificatePrivateKeyBuilder>, KubernetesResource
{

    @JsonProperty("algorithm")
    private String algorithm;
    @JsonProperty("encoding")
    private String encoding;
    @JsonProperty("rotationPolicy")
    private String rotationPolicy;
    @JsonProperty("size")
    private Integer size;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CertificatePrivateKey() {
    }

    public CertificatePrivateKey(String algorithm, String encoding, String rotationPolicy, Integer size) {
        super();
        this.algorithm = algorithm;
        this.encoding = encoding;
        this.rotationPolicy = rotationPolicy;
        this.size = size;
    }

    /**
     * Algorithm is the private key algorithm of the corresponding private key for this certificate.<br><p> <br><p> If provided, allowed values are either `RSA`, `ECDSA` or `Ed25519`. If `algorithm` is specified and `size` is not provided, key size of 2048 will be used for `RSA` key algorithm and key size of 256 will be used for `ECDSA` key algorithm. key size is ignored when using the `Ed25519` key algorithm.
     */
    @JsonProperty("algorithm")
    public String getAlgorithm() {
        return algorithm;
    }

    /**
     * Algorithm is the private key algorithm of the corresponding private key for this certificate.<br><p> <br><p> If provided, allowed values are either `RSA`, `ECDSA` or `Ed25519`. If `algorithm` is specified and `size` is not provided, key size of 2048 will be used for `RSA` key algorithm and key size of 256 will be used for `ECDSA` key algorithm. key size is ignored when using the `Ed25519` key algorithm.
     */
    @JsonProperty("algorithm")
    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    /**
     * The private key cryptography standards (PKCS) encoding for this certificate's private key to be encoded in.<br><p> <br><p> If provided, allowed values are `PKCS1` and `PKCS8` standing for PKCS#1 and PKCS#8, respectively. Defaults to `PKCS1` if not specified.
     */
    @JsonProperty("encoding")
    public String getEncoding() {
        return encoding;
    }

    /**
     * The private key cryptography standards (PKCS) encoding for this certificate's private key to be encoded in.<br><p> <br><p> If provided, allowed values are `PKCS1` and `PKCS8` standing for PKCS#1 and PKCS#8, respectively. Defaults to `PKCS1` if not specified.
     */
    @JsonProperty("encoding")
    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    /**
     * RotationPolicy controls how private keys should be regenerated when a re-issuance is being processed.<br><p> <br><p> If set to `Never`, a private key will only be generated if one does not already exist in the target `spec.secretName`. If one does exist but it does not have the correct algorithm or size, a warning will be raised to await user intervention. If set to `Always`, a private key matching the specified requirements will be generated whenever a re-issuance occurs. Default is `Never` for backward compatibility.
     */
    @JsonProperty("rotationPolicy")
    public String getRotationPolicy() {
        return rotationPolicy;
    }

    /**
     * RotationPolicy controls how private keys should be regenerated when a re-issuance is being processed.<br><p> <br><p> If set to `Never`, a private key will only be generated if one does not already exist in the target `spec.secretName`. If one does exist but it does not have the correct algorithm or size, a warning will be raised to await user intervention. If set to `Always`, a private key matching the specified requirements will be generated whenever a re-issuance occurs. Default is `Never` for backward compatibility.
     */
    @JsonProperty("rotationPolicy")
    public void setRotationPolicy(String rotationPolicy) {
        this.rotationPolicy = rotationPolicy;
    }

    /**
     * Size is the key bit size of the corresponding private key for this certificate.<br><p> <br><p> If `algorithm` is set to `RSA`, valid values are `2048`, `4096` or `8192`, and will default to `2048` if not specified. If `algorithm` is set to `ECDSA`, valid values are `256`, `384` or `521`, and will default to `256` if not specified. If `algorithm` is set to `Ed25519`, Size is ignored. No other values are allowed.
     */
    @JsonProperty("size")
    public Integer getSize() {
        return size;
    }

    /**
     * Size is the key bit size of the corresponding private key for this certificate.<br><p> <br><p> If `algorithm` is set to `RSA`, valid values are `2048`, `4096` or `8192`, and will default to `2048` if not specified. If `algorithm` is set to `ECDSA`, valid values are `256`, `384` or `521`, and will default to `256` if not specified. If `algorithm` is set to `Ed25519`, Size is ignored. No other values are allowed.
     */
    @JsonProperty("size")
    public void setSize(Integer size) {
        this.size = size;
    }

    @JsonIgnore
    public CertificatePrivateKeyBuilder edit() {
        return new CertificatePrivateKeyBuilder(this);
    }

    @JsonIgnore
    public CertificatePrivateKeyBuilder toBuilder() {
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
