
package io.fabric8.kubernetes.api.model.certificates.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
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
 * CertificateSigningRequestSpec contains the certificate request.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "expirationSeconds",
    "extra",
    "groups",
    "request",
    "signerName",
    "uid",
    "usages",
    "username"
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
public class CertificateSigningRequestSpec implements Editable<CertificateSigningRequestSpecBuilder>, KubernetesResource
{

    @JsonProperty("expirationSeconds")
    private Integer expirationSeconds;
    @JsonProperty("extra")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, List<String>> extra = new LinkedHashMap<>();
    @JsonProperty("groups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> groups = new ArrayList<>();
    @JsonProperty("request")
    private String request;
    @JsonProperty("signerName")
    private String signerName;
    @JsonProperty("uid")
    private String uid;
    @JsonProperty("usages")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> usages = new ArrayList<>();
    @JsonProperty("username")
    private String username;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CertificateSigningRequestSpec() {
    }

    public CertificateSigningRequestSpec(Integer expirationSeconds, Map<String, List<String>> extra, List<String> groups, String request, String signerName, String uid, List<String> usages, String username) {
        super();
        this.expirationSeconds = expirationSeconds;
        this.extra = extra;
        this.groups = groups;
        this.request = request;
        this.signerName = signerName;
        this.uid = uid;
        this.usages = usages;
        this.username = username;
    }

    /**
     * expirationSeconds is the requested duration of validity of the issued certificate. The certificate signer may issue a certificate with a different validity duration so a client must check the delta between the notBefore and and notAfter fields in the issued certificate to determine the actual duration.<br><p> <br><p> The v1.22+ in-tree implementations of the well-known Kubernetes signers will honor this field as long as the requested duration is not greater than the maximum duration they will honor per the --cluster-signing-duration CLI flag to the Kubernetes controller manager.<br><p> <br><p> Certificate signers may not honor this field for various reasons:<br><p> <br><p>   1. Old signer that is unaware of the field (such as the in-tree<br><p>      implementations prior to v1.22)<br><p>   2. Signer whose configured maximum is shorter than the requested duration<br><p>   3. Signer whose configured minimum is longer than the requested duration<br><p> <br><p> The minimum valid value for expirationSeconds is 600, i.e. 10 minutes.
     */
    @JsonProperty("expirationSeconds")
    public Integer getExpirationSeconds() {
        return expirationSeconds;
    }

    /**
     * expirationSeconds is the requested duration of validity of the issued certificate. The certificate signer may issue a certificate with a different validity duration so a client must check the delta between the notBefore and and notAfter fields in the issued certificate to determine the actual duration.<br><p> <br><p> The v1.22+ in-tree implementations of the well-known Kubernetes signers will honor this field as long as the requested duration is not greater than the maximum duration they will honor per the --cluster-signing-duration CLI flag to the Kubernetes controller manager.<br><p> <br><p> Certificate signers may not honor this field for various reasons:<br><p> <br><p>   1. Old signer that is unaware of the field (such as the in-tree<br><p>      implementations prior to v1.22)<br><p>   2. Signer whose configured maximum is shorter than the requested duration<br><p>   3. Signer whose configured minimum is longer than the requested duration<br><p> <br><p> The minimum valid value for expirationSeconds is 600, i.e. 10 minutes.
     */
    @JsonProperty("expirationSeconds")
    public void setExpirationSeconds(Integer expirationSeconds) {
        this.expirationSeconds = expirationSeconds;
    }

    /**
     * extra contains extra attributes of the user that created the CertificateSigningRequest. Populated by the API server on creation and immutable.
     */
    @JsonProperty("extra")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, List<String>> getExtra() {
        return extra;
    }

    /**
     * extra contains extra attributes of the user that created the CertificateSigningRequest. Populated by the API server on creation and immutable.
     */
    @JsonProperty("extra")
    public void setExtra(Map<String, List<String>> extra) {
        this.extra = extra;
    }

    /**
     * groups contains group membership of the user that created the CertificateSigningRequest. Populated by the API server on creation and immutable.
     */
    @JsonProperty("groups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getGroups() {
        return groups;
    }

    /**
     * groups contains group membership of the user that created the CertificateSigningRequest. Populated by the API server on creation and immutable.
     */
    @JsonProperty("groups")
    public void setGroups(List<String> groups) {
        this.groups = groups;
    }

    /**
     * request contains an x509 certificate signing request encoded in a "CERTIFICATE REQUEST" PEM block. When serialized as JSON or YAML, the data is additionally base64-encoded.
     */
    @JsonProperty("request")
    public String getRequest() {
        return request;
    }

    /**
     * request contains an x509 certificate signing request encoded in a "CERTIFICATE REQUEST" PEM block. When serialized as JSON or YAML, the data is additionally base64-encoded.
     */
    @JsonProperty("request")
    public void setRequest(String request) {
        this.request = request;
    }

    /**
     * signerName indicates the requested signer, and is a qualified name.<br><p> <br><p> List/watch requests for CertificateSigningRequests can filter on this field using a "spec.signerName=NAME" fieldSelector.<br><p> <br><p> Well-known Kubernetes signers are:<br><p>  1. "kubernetes.io/kube-apiserver-client": issues client certificates that can be used to authenticate to kube-apiserver.<br><p>   Requests for this signer are never auto-approved by kube-controller-manager, can be issued by the "csrsigning" controller in kube-controller-manager.<br><p>  2. "kubernetes.io/kube-apiserver-client-kubelet": issues client certificates that kubelets use to authenticate to kube-apiserver.<br><p>   Requests for this signer can be auto-approved by the "csrapproving" controller in kube-controller-manager, and can be issued by the "csrsigning" controller in kube-controller-manager.<br><p>  3. "kubernetes.io/kubelet-serving" issues serving certificates that kubelets use to serve TLS endpoints, which kube-apiserver can connect to securely.<br><p>   Requests for this signer are never auto-approved by kube-controller-manager, and can be issued by the "csrsigning" controller in kube-controller-manager.<br><p> <br><p> More details are available at https://k8s.io/docs/reference/access-authn-authz/certificate-signing-requests/#kubernetes-signers<br><p> <br><p> Custom signerNames can also be specified. The signer defines:<br><p>  1. Trust distribution: how trust (CA bundles) are distributed.<br><p>  2. Permitted subjects: and behavior when a disallowed subject is requested.<br><p>  3. Required, permitted, or forbidden x509 extensions in the request (including whether subjectAltNames are allowed, which types, restrictions on allowed values) and behavior when a disallowed extension is requested.<br><p>  4. Required, permitted, or forbidden key usages / extended key usages.<br><p>  5. Expiration/certificate lifetime: whether it is fixed by the signer, configurable by the admin.<br><p>  6. Whether or not requests for CA certificates are allowed.
     */
    @JsonProperty("signerName")
    public String getSignerName() {
        return signerName;
    }

    /**
     * signerName indicates the requested signer, and is a qualified name.<br><p> <br><p> List/watch requests for CertificateSigningRequests can filter on this field using a "spec.signerName=NAME" fieldSelector.<br><p> <br><p> Well-known Kubernetes signers are:<br><p>  1. "kubernetes.io/kube-apiserver-client": issues client certificates that can be used to authenticate to kube-apiserver.<br><p>   Requests for this signer are never auto-approved by kube-controller-manager, can be issued by the "csrsigning" controller in kube-controller-manager.<br><p>  2. "kubernetes.io/kube-apiserver-client-kubelet": issues client certificates that kubelets use to authenticate to kube-apiserver.<br><p>   Requests for this signer can be auto-approved by the "csrapproving" controller in kube-controller-manager, and can be issued by the "csrsigning" controller in kube-controller-manager.<br><p>  3. "kubernetes.io/kubelet-serving" issues serving certificates that kubelets use to serve TLS endpoints, which kube-apiserver can connect to securely.<br><p>   Requests for this signer are never auto-approved by kube-controller-manager, and can be issued by the "csrsigning" controller in kube-controller-manager.<br><p> <br><p> More details are available at https://k8s.io/docs/reference/access-authn-authz/certificate-signing-requests/#kubernetes-signers<br><p> <br><p> Custom signerNames can also be specified. The signer defines:<br><p>  1. Trust distribution: how trust (CA bundles) are distributed.<br><p>  2. Permitted subjects: and behavior when a disallowed subject is requested.<br><p>  3. Required, permitted, or forbidden x509 extensions in the request (including whether subjectAltNames are allowed, which types, restrictions on allowed values) and behavior when a disallowed extension is requested.<br><p>  4. Required, permitted, or forbidden key usages / extended key usages.<br><p>  5. Expiration/certificate lifetime: whether it is fixed by the signer, configurable by the admin.<br><p>  6. Whether or not requests for CA certificates are allowed.
     */
    @JsonProperty("signerName")
    public void setSignerName(String signerName) {
        this.signerName = signerName;
    }

    /**
     * uid contains the uid of the user that created the CertificateSigningRequest. Populated by the API server on creation and immutable.
     */
    @JsonProperty("uid")
    public String getUid() {
        return uid;
    }

    /**
     * uid contains the uid of the user that created the CertificateSigningRequest. Populated by the API server on creation and immutable.
     */
    @JsonProperty("uid")
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * usages specifies a set of key usages requested in the issued certificate.<br><p> <br><p> Requests for TLS client certificates typically request: "digital signature", "key encipherment", "client auth".<br><p> <br><p> Requests for TLS serving certificates typically request: "key encipherment", "digital signature", "server auth".<br><p> <br><p> Valid values are:<br><p>  "signing", "digital signature", "content commitment",<br><p>  "key encipherment", "key agreement", "data encipherment",<br><p>  "cert sign", "crl sign", "encipher only", "decipher only", "any",<br><p>  "server auth", "client auth",<br><p>  "code signing", "email protection", "s/mime",<br><p>  "ipsec end system", "ipsec tunnel", "ipsec user",<br><p>  "timestamping", "ocsp signing", "microsoft sgc", "netscape sgc"
     */
    @JsonProperty("usages")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getUsages() {
        return usages;
    }

    /**
     * usages specifies a set of key usages requested in the issued certificate.<br><p> <br><p> Requests for TLS client certificates typically request: "digital signature", "key encipherment", "client auth".<br><p> <br><p> Requests for TLS serving certificates typically request: "key encipherment", "digital signature", "server auth".<br><p> <br><p> Valid values are:<br><p>  "signing", "digital signature", "content commitment",<br><p>  "key encipherment", "key agreement", "data encipherment",<br><p>  "cert sign", "crl sign", "encipher only", "decipher only", "any",<br><p>  "server auth", "client auth",<br><p>  "code signing", "email protection", "s/mime",<br><p>  "ipsec end system", "ipsec tunnel", "ipsec user",<br><p>  "timestamping", "ocsp signing", "microsoft sgc", "netscape sgc"
     */
    @JsonProperty("usages")
    public void setUsages(List<String> usages) {
        this.usages = usages;
    }

    /**
     * username contains the name of the user that created the CertificateSigningRequest. Populated by the API server on creation and immutable.
     */
    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    /**
     * username contains the name of the user that created the CertificateSigningRequest. Populated by the API server on creation and immutable.
     */
    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonIgnore
    public CertificateSigningRequestSpecBuilder edit() {
        return new CertificateSigningRequestSpecBuilder(this);
    }

    @JsonIgnore
    public CertificateSigningRequestSpecBuilder toBuilder() {
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
