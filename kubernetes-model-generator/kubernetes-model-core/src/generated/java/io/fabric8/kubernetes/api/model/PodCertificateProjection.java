
package io.fabric8.kubernetes.api.model;

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
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * PodCertificateProjection provides a private key and X.509 certificate in the pod filesystem.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "certificateChainPath",
    "credentialBundlePath",
    "keyPath",
    "keyType",
    "maxExpirationSeconds",
    "signerName"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class PodCertificateProjection implements Editable<PodCertificateProjectionBuilder>, KubernetesResource
{

    @JsonProperty("certificateChainPath")
    private String certificateChainPath;
    @JsonProperty("credentialBundlePath")
    private String credentialBundlePath;
    @JsonProperty("keyPath")
    private String keyPath;
    @JsonProperty("keyType")
    private String keyType;
    @JsonProperty("maxExpirationSeconds")
    private Integer maxExpirationSeconds;
    @JsonProperty("signerName")
    private String signerName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PodCertificateProjection() {
    }

    public PodCertificateProjection(String certificateChainPath, String credentialBundlePath, String keyPath, String keyType, Integer maxExpirationSeconds, String signerName) {
        super();
        this.certificateChainPath = certificateChainPath;
        this.credentialBundlePath = credentialBundlePath;
        this.keyPath = keyPath;
        this.keyType = keyType;
        this.maxExpirationSeconds = maxExpirationSeconds;
        this.signerName = signerName;
    }

    /**
     * Write the certificate chain at this path in the projected volume.<br><p> <br><p> Most applications should use credentialBundlePath.  When using keyPath and certificateChainPath, your application needs to check that the key and leaf certificate are consistent, because it is possible to read the files mid-rotation.
     */
    @JsonProperty("certificateChainPath")
    public String getCertificateChainPath() {
        return certificateChainPath;
    }

    /**
     * Write the certificate chain at this path in the projected volume.<br><p> <br><p> Most applications should use credentialBundlePath.  When using keyPath and certificateChainPath, your application needs to check that the key and leaf certificate are consistent, because it is possible to read the files mid-rotation.
     */
    @JsonProperty("certificateChainPath")
    public void setCertificateChainPath(String certificateChainPath) {
        this.certificateChainPath = certificateChainPath;
    }

    /**
     * Write the credential bundle at this path in the projected volume.<br><p> <br><p> The credential bundle is a single file that contains multiple PEM blocks. The first PEM block is a PRIVATE KEY block, containing a PKCS#8 private key.<br><p> <br><p> The remaining blocks are CERTIFICATE blocks, containing the issued certificate chain from the signer (leaf and any intermediates).<br><p> <br><p> Using credentialBundlePath lets your Pod's application code make a single atomic read that retrieves a consistent key and certificate chain.  If you project them to separate files, your application code will need to additionally check that the leaf certificate was issued to the key.
     */
    @JsonProperty("credentialBundlePath")
    public String getCredentialBundlePath() {
        return credentialBundlePath;
    }

    /**
     * Write the credential bundle at this path in the projected volume.<br><p> <br><p> The credential bundle is a single file that contains multiple PEM blocks. The first PEM block is a PRIVATE KEY block, containing a PKCS#8 private key.<br><p> <br><p> The remaining blocks are CERTIFICATE blocks, containing the issued certificate chain from the signer (leaf and any intermediates).<br><p> <br><p> Using credentialBundlePath lets your Pod's application code make a single atomic read that retrieves a consistent key and certificate chain.  If you project them to separate files, your application code will need to additionally check that the leaf certificate was issued to the key.
     */
    @JsonProperty("credentialBundlePath")
    public void setCredentialBundlePath(String credentialBundlePath) {
        this.credentialBundlePath = credentialBundlePath;
    }

    /**
     * Write the key at this path in the projected volume.<br><p> <br><p> Most applications should use credentialBundlePath.  When using keyPath and certificateChainPath, your application needs to check that the key and leaf certificate are consistent, because it is possible to read the files mid-rotation.
     */
    @JsonProperty("keyPath")
    public String getKeyPath() {
        return keyPath;
    }

    /**
     * Write the key at this path in the projected volume.<br><p> <br><p> Most applications should use credentialBundlePath.  When using keyPath and certificateChainPath, your application needs to check that the key and leaf certificate are consistent, because it is possible to read the files mid-rotation.
     */
    @JsonProperty("keyPath")
    public void setKeyPath(String keyPath) {
        this.keyPath = keyPath;
    }

    /**
     * The type of keypair Kubelet will generate for the pod.<br><p> <br><p> Valid values are "RSA3072", "RSA4096", "ECDSAP256", "ECDSAP384", "ECDSAP521", and "ED25519".
     */
    @JsonProperty("keyType")
    public String getKeyType() {
        return keyType;
    }

    /**
     * The type of keypair Kubelet will generate for the pod.<br><p> <br><p> Valid values are "RSA3072", "RSA4096", "ECDSAP256", "ECDSAP384", "ECDSAP521", and "ED25519".
     */
    @JsonProperty("keyType")
    public void setKeyType(String keyType) {
        this.keyType = keyType;
    }

    /**
     * maxExpirationSeconds is the maximum lifetime permitted for the certificate.<br><p> <br><p> Kubelet copies this value verbatim into the PodCertificateRequests it generates for this projection.<br><p> <br><p> If omitted, kube-apiserver will set it to 86400(24 hours). kube-apiserver will reject values shorter than 3600 (1 hour).  The maximum allowable value is 7862400 (91 days).<br><p> <br><p> The signer implementation is then free to issue a certificate with any lifetime &#42;shorter&#42; than MaxExpirationSeconds, but no shorter than 3600 seconds (1 hour).  This constraint is enforced by kube-apiserver. `kubernetes.io` signers will never issue certificates with a lifetime longer than 24 hours.
     */
    @JsonProperty("maxExpirationSeconds")
    public Integer getMaxExpirationSeconds() {
        return maxExpirationSeconds;
    }

    /**
     * maxExpirationSeconds is the maximum lifetime permitted for the certificate.<br><p> <br><p> Kubelet copies this value verbatim into the PodCertificateRequests it generates for this projection.<br><p> <br><p> If omitted, kube-apiserver will set it to 86400(24 hours). kube-apiserver will reject values shorter than 3600 (1 hour).  The maximum allowable value is 7862400 (91 days).<br><p> <br><p> The signer implementation is then free to issue a certificate with any lifetime &#42;shorter&#42; than MaxExpirationSeconds, but no shorter than 3600 seconds (1 hour).  This constraint is enforced by kube-apiserver. `kubernetes.io` signers will never issue certificates with a lifetime longer than 24 hours.
     */
    @JsonProperty("maxExpirationSeconds")
    public void setMaxExpirationSeconds(Integer maxExpirationSeconds) {
        this.maxExpirationSeconds = maxExpirationSeconds;
    }

    /**
     * Kubelet's generated CSRs will be addressed to this signer.
     */
    @JsonProperty("signerName")
    public String getSignerName() {
        return signerName;
    }

    /**
     * Kubelet's generated CSRs will be addressed to this signer.
     */
    @JsonProperty("signerName")
    public void setSignerName(String signerName) {
        this.signerName = signerName;
    }

    @JsonIgnore
    public PodCertificateProjectionBuilder edit() {
        return new PodCertificateProjectionBuilder(this);
    }

    @JsonIgnore
    public PodCertificateProjectionBuilder toBuilder() {
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
