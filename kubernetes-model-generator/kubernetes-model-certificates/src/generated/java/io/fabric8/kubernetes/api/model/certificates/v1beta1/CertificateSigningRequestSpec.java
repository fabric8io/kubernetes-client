
package io.fabric8.kubernetes.api.model.certificates.v1beta1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
 * This information is immutable after the request is created. Only the Request and Usages fields can be set on creation, other fields are derived by Kubernetes and cannot be modified by users.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
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

    public CertificateSigningRequestSpec(Map<String, List<String>> extra, List<String> groups, String request, String signerName, String uid, List<String> usages, String username) {
        super();
        this.extra = extra;
        this.groups = groups;
        this.request = request;
        this.signerName = signerName;
        this.uid = uid;
        this.usages = usages;
        this.username = username;
    }

    /**
     * Extra information about the requesting user. See user.Info interface for details.
     */
    @JsonProperty("extra")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, List<String>> getExtra() {
        return extra;
    }

    /**
     * Extra information about the requesting user. See user.Info interface for details.
     */
    @JsonProperty("extra")
    public void setExtra(Map<String, List<String>> extra) {
        this.extra = extra;
    }

    /**
     * Group information about the requesting user. See user.Info interface for details.
     */
    @JsonProperty("groups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getGroups() {
        return groups;
    }

    /**
     * Group information about the requesting user. See user.Info interface for details.
     */
    @JsonProperty("groups")
    public void setGroups(List<String> groups) {
        this.groups = groups;
    }

    /**
     * Base64-encoded PKCS#10 CSR data
     */
    @JsonProperty("request")
    public String getRequest() {
        return request;
    }

    /**
     * Base64-encoded PKCS#10 CSR data
     */
    @JsonProperty("request")
    public void setRequest(String request) {
        this.request = request;
    }

    /**
     * Requested signer for the request. It is a qualified name in the form: `scope-hostname.io/name`. If empty, it will be defaulted:<br><p>  1. If it's a kubelet client certificate, it is assigned<br><p>     "kubernetes.io/kube-apiserver-client-kubelet".<br><p>  2. If it's a kubelet serving certificate, it is assigned<br><p>     "kubernetes.io/kubelet-serving".<br><p>  3. Otherwise, it is assigned "kubernetes.io/legacy-unknown".<br><p> Distribution of trust for signers happens out of band. You can select on this field using `spec.signerName`.
     */
    @JsonProperty("signerName")
    public String getSignerName() {
        return signerName;
    }

    /**
     * Requested signer for the request. It is a qualified name in the form: `scope-hostname.io/name`. If empty, it will be defaulted:<br><p>  1. If it's a kubelet client certificate, it is assigned<br><p>     "kubernetes.io/kube-apiserver-client-kubelet".<br><p>  2. If it's a kubelet serving certificate, it is assigned<br><p>     "kubernetes.io/kubelet-serving".<br><p>  3. Otherwise, it is assigned "kubernetes.io/legacy-unknown".<br><p> Distribution of trust for signers happens out of band. You can select on this field using `spec.signerName`.
     */
    @JsonProperty("signerName")
    public void setSignerName(String signerName) {
        this.signerName = signerName;
    }

    /**
     * UID information about the requesting user. See user.Info interface for details.
     */
    @JsonProperty("uid")
    public String getUid() {
        return uid;
    }

    /**
     * UID information about the requesting user. See user.Info interface for details.
     */
    @JsonProperty("uid")
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * allowedUsages specifies a set of usage contexts the key will be valid for. See: https://tools.ietf.org/html/rfc5280#section-4.2.1.3<br><p>      https://tools.ietf.org/html/rfc5280#section-4.2.1.12<br><p> Valid values are:<br><p>  "signing",<br><p>  "digital signature",<br><p>  "content commitment",<br><p>  "key encipherment",<br><p>  "key agreement",<br><p>  "data encipherment",<br><p>  "cert sign",<br><p>  "crl sign",<br><p>  "encipher only",<br><p>  "decipher only",<br><p>  "any",<br><p>  "server auth",<br><p>  "client auth",<br><p>  "code signing",<br><p>  "email protection",<br><p>  "s/mime",<br><p>  "ipsec end system",<br><p>  "ipsec tunnel",<br><p>  "ipsec user",<br><p>  "timestamping",<br><p>  "ocsp signing",<br><p>  "microsoft sgc",<br><p>  "netscape sgc"
     */
    @JsonProperty("usages")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getUsages() {
        return usages;
    }

    /**
     * allowedUsages specifies a set of usage contexts the key will be valid for. See: https://tools.ietf.org/html/rfc5280#section-4.2.1.3<br><p>      https://tools.ietf.org/html/rfc5280#section-4.2.1.12<br><p> Valid values are:<br><p>  "signing",<br><p>  "digital signature",<br><p>  "content commitment",<br><p>  "key encipherment",<br><p>  "key agreement",<br><p>  "data encipherment",<br><p>  "cert sign",<br><p>  "crl sign",<br><p>  "encipher only",<br><p>  "decipher only",<br><p>  "any",<br><p>  "server auth",<br><p>  "client auth",<br><p>  "code signing",<br><p>  "email protection",<br><p>  "s/mime",<br><p>  "ipsec end system",<br><p>  "ipsec tunnel",<br><p>  "ipsec user",<br><p>  "timestamping",<br><p>  "ocsp signing",<br><p>  "microsoft sgc",<br><p>  "netscape sgc"
     */
    @JsonProperty("usages")
    public void setUsages(List<String> usages) {
        this.usages = usages;
    }

    /**
     * Information about the requesting user. See user.Info interface for details.
     */
    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    /**
     * Information about the requesting user. See user.Info interface for details.
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
