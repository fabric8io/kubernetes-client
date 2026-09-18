
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof CertificateSigningRequestSpec)) {
            return false;
        }
        CertificateSigningRequestSpec other = (CertificateSigningRequestSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$extra = this.getExtra();
        Object other$extra = other.getExtra();
        if (this$extra == null ? other$extra != null : !this$extra.equals(other$extra)) {
            return false;
        }
        Object this$groups = this.getGroups();
        Object other$groups = other.getGroups();
        if (this$groups == null ? other$groups != null : !this$groups.equals(other$groups)) {
            return false;
        }
        Object this$request = this.getRequest();
        Object other$request = other.getRequest();
        if (this$request == null ? other$request != null : !this$request.equals(other$request)) {
            return false;
        }
        Object this$signerName = this.getSignerName();
        Object other$signerName = other.getSignerName();
        if (this$signerName == null ? other$signerName != null : !this$signerName.equals(other$signerName)) {
            return false;
        }
        Object this$uid = this.getUid();
        Object other$uid = other.getUid();
        if (this$uid == null ? other$uid != null : !this$uid.equals(other$uid)) {
            return false;
        }
        Object this$usages = this.getUsages();
        Object other$usages = other.getUsages();
        if (this$usages == null ? other$usages != null : !this$usages.equals(other$usages)) {
            return false;
        }
        Object this$username = this.getUsername();
        Object other$username = other.getUsername();
        if (this$username == null ? other$username != null : !this$username.equals(other$username)) {
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
        return other instanceof CertificateSigningRequestSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $extra = this.getExtra();
        result = result * prime + ($extra == null ? 43 : $extra.hashCode());
        Object $groups = this.getGroups();
        result = result * prime + ($groups == null ? 43 : $groups.hashCode());
        Object $request = this.getRequest();
        result = result * prime + ($request == null ? 43 : $request.hashCode());
        Object $signerName = this.getSignerName();
        result = result * prime + ($signerName == null ? 43 : $signerName.hashCode());
        Object $uid = this.getUid();
        result = result * prime + ($uid == null ? 43 : $uid.hashCode());
        Object $usages = this.getUsages();
        result = result * prime + ($usages == null ? 43 : $usages.hashCode());
        Object $username = this.getUsername();
        result = result * prime + ($username == null ? 43 : $username.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "CertificateSigningRequestSpec(" + "extra=" + this.getExtra() + ", groups=" + this.getGroups() + ", request=" + this.getRequest() + ", signerName=" + this.getSignerName() + ", uid=" + this.getUid() + ", usages=" + this.getUsages() + ", username=" + this.getUsername() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
