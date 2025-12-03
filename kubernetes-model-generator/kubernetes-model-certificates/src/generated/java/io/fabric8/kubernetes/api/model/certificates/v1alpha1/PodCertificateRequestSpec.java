
package io.fabric8.kubernetes.api.model.certificates.v1alpha1;

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
 * PodCertificateRequestSpec describes the certificate request.  All fields are immutable after creation.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "maxExpirationSeconds",
    "nodeName",
    "nodeUID",
    "pkixPublicKey",
    "podName",
    "podUID",
    "proofOfPossession",
    "serviceAccountName",
    "serviceAccountUID",
    "signerName"
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
public class PodCertificateRequestSpec implements Editable<PodCertificateRequestSpecBuilder>, KubernetesResource
{

    @JsonProperty("maxExpirationSeconds")
    private Integer maxExpirationSeconds;
    @JsonProperty("nodeName")
    private String nodeName;
    @JsonProperty("nodeUID")
    private String nodeUID;
    @JsonProperty("pkixPublicKey")
    private String pkixPublicKey;
    @JsonProperty("podName")
    private String podName;
    @JsonProperty("podUID")
    private String podUID;
    @JsonProperty("proofOfPossession")
    private String proofOfPossession;
    @JsonProperty("serviceAccountName")
    private String serviceAccountName;
    @JsonProperty("serviceAccountUID")
    private String serviceAccountUID;
    @JsonProperty("signerName")
    private String signerName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PodCertificateRequestSpec() {
    }

    public PodCertificateRequestSpec(Integer maxExpirationSeconds, String nodeName, String nodeUID, String pkixPublicKey, String podName, String podUID, String proofOfPossession, String serviceAccountName, String serviceAccountUID, String signerName) {
        super();
        this.maxExpirationSeconds = maxExpirationSeconds;
        this.nodeName = nodeName;
        this.nodeUID = nodeUID;
        this.pkixPublicKey = pkixPublicKey;
        this.podName = podName;
        this.podUID = podUID;
        this.proofOfPossession = proofOfPossession;
        this.serviceAccountName = serviceAccountName;
        this.serviceAccountUID = serviceAccountUID;
        this.signerName = signerName;
    }

    /**
     * maxExpirationSeconds is the maximum lifetime permitted for the certificate.<br><p> <br><p> If omitted, kube-apiserver will set it to 86400(24 hours). kube-apiserver will reject values shorter than 3600 (1 hour).  The maximum allowable value is 7862400 (91 days).<br><p> <br><p> The signer implementation is then free to issue a certificate with any lifetime &#42;shorter&#42; than MaxExpirationSeconds, but no shorter than 3600 seconds (1 hour).  This constraint is enforced by kube-apiserver. `kubernetes.io` signers will never issue certificates with a lifetime longer than 24 hours.
     */
    @JsonProperty("maxExpirationSeconds")
    public Integer getMaxExpirationSeconds() {
        return maxExpirationSeconds;
    }

    /**
     * maxExpirationSeconds is the maximum lifetime permitted for the certificate.<br><p> <br><p> If omitted, kube-apiserver will set it to 86400(24 hours). kube-apiserver will reject values shorter than 3600 (1 hour).  The maximum allowable value is 7862400 (91 days).<br><p> <br><p> The signer implementation is then free to issue a certificate with any lifetime &#42;shorter&#42; than MaxExpirationSeconds, but no shorter than 3600 seconds (1 hour).  This constraint is enforced by kube-apiserver. `kubernetes.io` signers will never issue certificates with a lifetime longer than 24 hours.
     */
    @JsonProperty("maxExpirationSeconds")
    public void setMaxExpirationSeconds(Integer maxExpirationSeconds) {
        this.maxExpirationSeconds = maxExpirationSeconds;
    }

    /**
     * nodeName is the name of the node the pod is assigned to.
     */
    @JsonProperty("nodeName")
    public String getNodeName() {
        return nodeName;
    }

    /**
     * nodeName is the name of the node the pod is assigned to.
     */
    @JsonProperty("nodeName")
    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    /**
     * nodeUID is the UID of the node the pod is assigned to.
     */
    @JsonProperty("nodeUID")
    public String getNodeUID() {
        return nodeUID;
    }

    /**
     * nodeUID is the UID of the node the pod is assigned to.
     */
    @JsonProperty("nodeUID")
    public void setNodeUID(String nodeUID) {
        this.nodeUID = nodeUID;
    }

    /**
     * pkixPublicKey is the PKIX-serialized public key the signer will issue the certificate to.<br><p> <br><p> The key must be one of RSA3072, RSA4096, ECDSAP256, ECDSAP384, ECDSAP521, or ED25519. Note that this list may be expanded in the future.<br><p> <br><p> Signer implementations do not need to support all key types supported by kube-apiserver and kubelet.  If a signer does not support the key type used for a given PodCertificateRequest, it must deny the request by setting a status.conditions entry with a type of "Denied" and a reason of "UnsupportedKeyType". It may also suggest a key type that it does support in the message field.
     */
    @JsonProperty("pkixPublicKey")
    public String getPkixPublicKey() {
        return pkixPublicKey;
    }

    /**
     * pkixPublicKey is the PKIX-serialized public key the signer will issue the certificate to.<br><p> <br><p> The key must be one of RSA3072, RSA4096, ECDSAP256, ECDSAP384, ECDSAP521, or ED25519. Note that this list may be expanded in the future.<br><p> <br><p> Signer implementations do not need to support all key types supported by kube-apiserver and kubelet.  If a signer does not support the key type used for a given PodCertificateRequest, it must deny the request by setting a status.conditions entry with a type of "Denied" and a reason of "UnsupportedKeyType". It may also suggest a key type that it does support in the message field.
     */
    @JsonProperty("pkixPublicKey")
    public void setPkixPublicKey(String pkixPublicKey) {
        this.pkixPublicKey = pkixPublicKey;
    }

    /**
     * podName is the name of the pod into which the certificate will be mounted.
     */
    @JsonProperty("podName")
    public String getPodName() {
        return podName;
    }

    /**
     * podName is the name of the pod into which the certificate will be mounted.
     */
    @JsonProperty("podName")
    public void setPodName(String podName) {
        this.podName = podName;
    }

    /**
     * podUID is the UID of the pod into which the certificate will be mounted.
     */
    @JsonProperty("podUID")
    public String getPodUID() {
        return podUID;
    }

    /**
     * podUID is the UID of the pod into which the certificate will be mounted.
     */
    @JsonProperty("podUID")
    public void setPodUID(String podUID) {
        this.podUID = podUID;
    }

    /**
     * proofOfPossession proves that the requesting kubelet holds the private key corresponding to pkixPublicKey.<br><p> <br><p> It is contructed by signing the ASCII bytes of the pod's UID using `pkixPublicKey`.<br><p> <br><p> kube-apiserver validates the proof of possession during creation of the PodCertificateRequest.<br><p> <br><p> If the key is an RSA key, then the signature is over the ASCII bytes of the pod UID, using RSASSA-PSS from RFC 8017 (as implemented by the golang function crypto/rsa.SignPSS with nil options).<br><p> <br><p> If the key is an ECDSA key, then the signature is as described by [SEC 1, Version 2.0](https://www.secg.org/sec1-v2.pdf) (as implemented by the golang library function crypto/ecdsa.SignASN1)<br><p> <br><p> If the key is an ED25519 key, the the signature is as described by the [ED25519 Specification](https://ed25519.cr.yp.to/) (as implemented by the golang library crypto/ed25519.Sign).
     */
    @JsonProperty("proofOfPossession")
    public String getProofOfPossession() {
        return proofOfPossession;
    }

    /**
     * proofOfPossession proves that the requesting kubelet holds the private key corresponding to pkixPublicKey.<br><p> <br><p> It is contructed by signing the ASCII bytes of the pod's UID using `pkixPublicKey`.<br><p> <br><p> kube-apiserver validates the proof of possession during creation of the PodCertificateRequest.<br><p> <br><p> If the key is an RSA key, then the signature is over the ASCII bytes of the pod UID, using RSASSA-PSS from RFC 8017 (as implemented by the golang function crypto/rsa.SignPSS with nil options).<br><p> <br><p> If the key is an ECDSA key, then the signature is as described by [SEC 1, Version 2.0](https://www.secg.org/sec1-v2.pdf) (as implemented by the golang library function crypto/ecdsa.SignASN1)<br><p> <br><p> If the key is an ED25519 key, the the signature is as described by the [ED25519 Specification](https://ed25519.cr.yp.to/) (as implemented by the golang library crypto/ed25519.Sign).
     */
    @JsonProperty("proofOfPossession")
    public void setProofOfPossession(String proofOfPossession) {
        this.proofOfPossession = proofOfPossession;
    }

    /**
     * serviceAccountName is the name of the service account the pod is running as.
     */
    @JsonProperty("serviceAccountName")
    public String getServiceAccountName() {
        return serviceAccountName;
    }

    /**
     * serviceAccountName is the name of the service account the pod is running as.
     */
    @JsonProperty("serviceAccountName")
    public void setServiceAccountName(String serviceAccountName) {
        this.serviceAccountName = serviceAccountName;
    }

    /**
     * serviceAccountUID is the UID of the service account the pod is running as.
     */
    @JsonProperty("serviceAccountUID")
    public String getServiceAccountUID() {
        return serviceAccountUID;
    }

    /**
     * serviceAccountUID is the UID of the service account the pod is running as.
     */
    @JsonProperty("serviceAccountUID")
    public void setServiceAccountUID(String serviceAccountUID) {
        this.serviceAccountUID = serviceAccountUID;
    }

    /**
     * signerName indicates the requested signer.<br><p> <br><p> All signer names beginning with `kubernetes.io` are reserved for use by the Kubernetes project.  There is currently one well-known signer documented by the Kubernetes project, `kubernetes.io/kube-apiserver-client-pod`, which will issue client certificates understood by kube-apiserver.  It is currently unimplemented.
     */
    @JsonProperty("signerName")
    public String getSignerName() {
        return signerName;
    }

    /**
     * signerName indicates the requested signer.<br><p> <br><p> All signer names beginning with `kubernetes.io` are reserved for use by the Kubernetes project.  There is currently one well-known signer documented by the Kubernetes project, `kubernetes.io/kube-apiserver-client-pod`, which will issue client certificates understood by kube-apiserver.  It is currently unimplemented.
     */
    @JsonProperty("signerName")
    public void setSignerName(String signerName) {
        this.signerName = signerName;
    }

    @JsonIgnore
    public PodCertificateRequestSpecBuilder edit() {
        return new PodCertificateRequestSpecBuilder(this);
    }

    @JsonIgnore
    public PodCertificateRequestSpecBuilder toBuilder() {
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
