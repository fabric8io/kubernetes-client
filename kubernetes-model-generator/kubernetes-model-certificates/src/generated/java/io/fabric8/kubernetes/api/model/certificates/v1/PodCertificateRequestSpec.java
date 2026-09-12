
package io.fabric8.kubernetes.api.model.certificates.v1;

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

/**
 * PodCertificateRequestSpec describes the certificate request.  All fields are immutable after creation.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "maxExpirationSeconds",
    "nodeName",
    "nodeUID",
    "podName",
    "podUID",
    "serviceAccountName",
    "serviceAccountUID",
    "signerName",
    "stubPKCS10Request",
    "unverifiedUserAnnotations"
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
    @JsonProperty("podName")
    private String podName;
    @JsonProperty("podUID")
    private String podUID;
    @JsonProperty("serviceAccountName")
    private String serviceAccountName;
    @JsonProperty("serviceAccountUID")
    private String serviceAccountUID;
    @JsonProperty("signerName")
    private String signerName;
    @JsonProperty("stubPKCS10Request")
    private String stubPKCS10Request;
    @JsonProperty("unverifiedUserAnnotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> unverifiedUserAnnotations = new LinkedHashMap<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PodCertificateRequestSpec() {
    }

    public PodCertificateRequestSpec(Integer maxExpirationSeconds, String nodeName, String nodeUID, String podName, String podUID, String serviceAccountName, String serviceAccountUID, String signerName, String stubPKCS10Request, Map<String, String> unverifiedUserAnnotations) {
        super();
        this.maxExpirationSeconds = maxExpirationSeconds;
        this.nodeName = nodeName;
        this.nodeUID = nodeUID;
        this.podName = podName;
        this.podUID = podUID;
        this.serviceAccountName = serviceAccountName;
        this.serviceAccountUID = serviceAccountUID;
        this.signerName = signerName;
        this.stubPKCS10Request = stubPKCS10Request;
        this.unverifiedUserAnnotations = unverifiedUserAnnotations;
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

    /**
     * A PKCS#10 certificate signing request (DER-serialized) generated by Kubelet using the subject private key.<br><p> <br><p> Most signer implementations will ignore the contents of the CSR except to extract the subject public key. The API server automatically verifies the CSR signature during admission, so the signer does not need to repeat the verification.  CSRs generated by kubelet are completely empty.<br><p> <br><p> The subject public key must be one of RSA3072, RSA4096, ECDSAP256, ECDSAP384, ECDSAP521, or ED25519. Note that this list may be expanded in the future.<br><p> <br><p> Signer implementations do not need to support all key types supported by kube-apiserver and kubelet.  If a signer does not support the key type used for a given PodCertificateRequest, it must deny the request by setting a status.conditions entry with a type of "Denied" and a reason of "UnsupportedKeyType". It may also suggest a key type that it does support in the message field.
     */
    @JsonProperty("stubPKCS10Request")
    public String getStubPKCS10Request() {
        return stubPKCS10Request;
    }

    /**
     * A PKCS#10 certificate signing request (DER-serialized) generated by Kubelet using the subject private key.<br><p> <br><p> Most signer implementations will ignore the contents of the CSR except to extract the subject public key. The API server automatically verifies the CSR signature during admission, so the signer does not need to repeat the verification.  CSRs generated by kubelet are completely empty.<br><p> <br><p> The subject public key must be one of RSA3072, RSA4096, ECDSAP256, ECDSAP384, ECDSAP521, or ED25519. Note that this list may be expanded in the future.<br><p> <br><p> Signer implementations do not need to support all key types supported by kube-apiserver and kubelet.  If a signer does not support the key type used for a given PodCertificateRequest, it must deny the request by setting a status.conditions entry with a type of "Denied" and a reason of "UnsupportedKeyType". It may also suggest a key type that it does support in the message field.
     */
    @JsonProperty("stubPKCS10Request")
    public void setStubPKCS10Request(String stubPKCS10Request) {
        this.stubPKCS10Request = stubPKCS10Request;
    }

    /**
     * unverifiedUserAnnotations allow pod authors to pass additional information to the signer implementation.  Kubernetes does not restrict or validate this metadata in any way.<br><p> <br><p> Entries are subject to the same validation as object metadata annotations, with the addition that all keys must be domain-prefixed. No restrictions are placed on values, except an overall size limitation on the entire field.<br><p> <br><p> Signers should document the keys and values they support.  Signers should deny requests that contain keys they do not recognize.
     */
    @JsonProperty("unverifiedUserAnnotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getUnverifiedUserAnnotations() {
        return unverifiedUserAnnotations;
    }

    /**
     * unverifiedUserAnnotations allow pod authors to pass additional information to the signer implementation.  Kubernetes does not restrict or validate this metadata in any way.<br><p> <br><p> Entries are subject to the same validation as object metadata annotations, with the addition that all keys must be domain-prefixed. No restrictions are placed on values, except an overall size limitation on the entire field.<br><p> <br><p> Signers should document the keys and values they support.  Signers should deny requests that contain keys they do not recognize.
     */
    @JsonProperty("unverifiedUserAnnotations")
    public void setUnverifiedUserAnnotations(Map<String, String> unverifiedUserAnnotations) {
        this.unverifiedUserAnnotations = unverifiedUserAnnotations;
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof PodCertificateRequestSpec)) {
            return false;
        }
        PodCertificateRequestSpec other = (PodCertificateRequestSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$maxExpirationSeconds = this.getMaxExpirationSeconds();
        Object other$maxExpirationSeconds = other.getMaxExpirationSeconds();
        if (this$maxExpirationSeconds == null ? other$maxExpirationSeconds != null : !this$maxExpirationSeconds.equals(other$maxExpirationSeconds)) {
            return false;
        }
        Object this$nodeName = this.getNodeName();
        Object other$nodeName = other.getNodeName();
        if (this$nodeName == null ? other$nodeName != null : !this$nodeName.equals(other$nodeName)) {
            return false;
        }
        Object this$nodeUID = this.getNodeUID();
        Object other$nodeUID = other.getNodeUID();
        if (this$nodeUID == null ? other$nodeUID != null : !this$nodeUID.equals(other$nodeUID)) {
            return false;
        }
        Object this$podName = this.getPodName();
        Object other$podName = other.getPodName();
        if (this$podName == null ? other$podName != null : !this$podName.equals(other$podName)) {
            return false;
        }
        Object this$podUID = this.getPodUID();
        Object other$podUID = other.getPodUID();
        if (this$podUID == null ? other$podUID != null : !this$podUID.equals(other$podUID)) {
            return false;
        }
        Object this$serviceAccountName = this.getServiceAccountName();
        Object other$serviceAccountName = other.getServiceAccountName();
        if (this$serviceAccountName == null ? other$serviceAccountName != null : !this$serviceAccountName.equals(other$serviceAccountName)) {
            return false;
        }
        Object this$serviceAccountUID = this.getServiceAccountUID();
        Object other$serviceAccountUID = other.getServiceAccountUID();
        if (this$serviceAccountUID == null ? other$serviceAccountUID != null : !this$serviceAccountUID.equals(other$serviceAccountUID)) {
            return false;
        }
        Object this$signerName = this.getSignerName();
        Object other$signerName = other.getSignerName();
        if (this$signerName == null ? other$signerName != null : !this$signerName.equals(other$signerName)) {
            return false;
        }
        Object this$stubPKCS10Request = this.getStubPKCS10Request();
        Object other$stubPKCS10Request = other.getStubPKCS10Request();
        if (this$stubPKCS10Request == null ? other$stubPKCS10Request != null : !this$stubPKCS10Request.equals(other$stubPKCS10Request)) {
            return false;
        }
        Object this$unverifiedUserAnnotations = this.getUnverifiedUserAnnotations();
        Object other$unverifiedUserAnnotations = other.getUnverifiedUserAnnotations();
        if (this$unverifiedUserAnnotations == null ? other$unverifiedUserAnnotations != null : !this$unverifiedUserAnnotations.equals(other$unverifiedUserAnnotations)) {
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
        return other instanceof PodCertificateRequestSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $maxExpirationSeconds = this.getMaxExpirationSeconds();
        result = result * prime + ($maxExpirationSeconds == null ? 43 : $maxExpirationSeconds.hashCode());
        Object $nodeName = this.getNodeName();
        result = result * prime + ($nodeName == null ? 43 : $nodeName.hashCode());
        Object $nodeUID = this.getNodeUID();
        result = result * prime + ($nodeUID == null ? 43 : $nodeUID.hashCode());
        Object $podName = this.getPodName();
        result = result * prime + ($podName == null ? 43 : $podName.hashCode());
        Object $podUID = this.getPodUID();
        result = result * prime + ($podUID == null ? 43 : $podUID.hashCode());
        Object $serviceAccountName = this.getServiceAccountName();
        result = result * prime + ($serviceAccountName == null ? 43 : $serviceAccountName.hashCode());
        Object $serviceAccountUID = this.getServiceAccountUID();
        result = result * prime + ($serviceAccountUID == null ? 43 : $serviceAccountUID.hashCode());
        Object $signerName = this.getSignerName();
        result = result * prime + ($signerName == null ? 43 : $signerName.hashCode());
        Object $stubPKCS10Request = this.getStubPKCS10Request();
        result = result * prime + ($stubPKCS10Request == null ? 43 : $stubPKCS10Request.hashCode());
        Object $unverifiedUserAnnotations = this.getUnverifiedUserAnnotations();
        result = result * prime + ($unverifiedUserAnnotations == null ? 43 : $unverifiedUserAnnotations.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PodCertificateRequestSpec(" + "maxExpirationSeconds=" + this.getMaxExpirationSeconds() + ", nodeName=" + this.getNodeName() + ", nodeUID=" + this.getNodeUID() + ", podName=" + this.getPodName() + ", podUID=" + this.getPodUID() + ", serviceAccountName=" + this.getServiceAccountName() + ", serviceAccountUID=" + this.getServiceAccountUID() + ", signerName=" + this.getSignerName() + ", stubPKCS10Request=" + this.getStubPKCS10Request() + ", unverifiedUserAnnotations=" + this.getUnverifiedUserAnnotations() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
