
package io.fabric8.certmanager.api.model.v1;

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
import io.fabric8.certmanager.api.model.meta.v1.IssuerReference;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.Duration;
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
 * CertificateRequestSpec defines the desired state of CertificateRequest<br><p> <br><p> NOTE: It is important to note that the issuer can choose to ignore or change any of the requested attributes. How the issuer maps a certificate request to a signed certificate is the full responsibility of the issuer itself. For example, as an edge case, an issuer that inverts the isCA value is free to do so.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "duration",
    "extra",
    "groups",
    "isCA",
    "issuerRef",
    "request",
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
public class CertificateRequestSpec implements Editable<CertificateRequestSpecBuilder>, KubernetesResource
{

    @JsonProperty("duration")
    private Duration duration;
    @JsonProperty("extra")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, List<String>> extra = new LinkedHashMap<>();
    @JsonProperty("groups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> groups = new ArrayList<>();
    @JsonProperty("isCA")
    private Boolean isCA;
    @JsonProperty("issuerRef")
    private IssuerReference issuerRef;
    @JsonProperty("request")
    private String request;
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
    public CertificateRequestSpec() {
    }

    public CertificateRequestSpec(Duration duration, Map<String, List<String>> extra, List<String> groups, Boolean isCA, IssuerReference issuerRef, String request, String uid, List<String> usages, String username) {
        super();
        this.duration = duration;
        this.extra = extra;
        this.groups = groups;
        this.isCA = isCA;
        this.issuerRef = issuerRef;
        this.request = request;
        this.uid = uid;
        this.usages = usages;
        this.username = username;
    }

    /**
     * CertificateRequestSpec defines the desired state of CertificateRequest<br><p> <br><p> NOTE: It is important to note that the issuer can choose to ignore or change any of the requested attributes. How the issuer maps a certificate request to a signed certificate is the full responsibility of the issuer itself. For example, as an edge case, an issuer that inverts the isCA value is free to do so.
     */
    @JsonProperty("duration")
    public Duration getDuration() {
        return duration;
    }

    /**
     * CertificateRequestSpec defines the desired state of CertificateRequest<br><p> <br><p> NOTE: It is important to note that the issuer can choose to ignore or change any of the requested attributes. How the issuer maps a certificate request to a signed certificate is the full responsibility of the issuer itself. For example, as an edge case, an issuer that inverts the isCA value is free to do so.
     */
    @JsonProperty("duration")
    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    /**
     * Extra contains extra attributes of the user that created the CertificateRequest. Populated by the cert-manager webhook on creation and immutable.
     */
    @JsonProperty("extra")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, List<String>> getExtra() {
        return extra;
    }

    /**
     * Extra contains extra attributes of the user that created the CertificateRequest. Populated by the cert-manager webhook on creation and immutable.
     */
    @JsonProperty("extra")
    public void setExtra(Map<String, List<String>> extra) {
        this.extra = extra;
    }

    /**
     * Groups contains group membership of the user that created the CertificateRequest. Populated by the cert-manager webhook on creation and immutable.
     */
    @JsonProperty("groups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getGroups() {
        return groups;
    }

    /**
     * Groups contains group membership of the user that created the CertificateRequest. Populated by the cert-manager webhook on creation and immutable.
     */
    @JsonProperty("groups")
    public void setGroups(List<String> groups) {
        this.groups = groups;
    }

    /**
     * Requested basic constraints isCA value. Note that the issuer may choose to ignore the requested isCA value, just like any other requested attribute.<br><p> <br><p> NOTE: If the CSR in the `Request` field has a BasicConstraints extension, it must have the same isCA value as specified here.<br><p> <br><p> If true, this will automatically add the `cert sign` usage to the list of requested `usages`.
     */
    @JsonProperty("isCA")
    public Boolean getIsCA() {
        return isCA;
    }

    /**
     * Requested basic constraints isCA value. Note that the issuer may choose to ignore the requested isCA value, just like any other requested attribute.<br><p> <br><p> NOTE: If the CSR in the `Request` field has a BasicConstraints extension, it must have the same isCA value as specified here.<br><p> <br><p> If true, this will automatically add the `cert sign` usage to the list of requested `usages`.
     */
    @JsonProperty("isCA")
    public void setIsCA(Boolean isCA) {
        this.isCA = isCA;
    }

    /**
     * CertificateRequestSpec defines the desired state of CertificateRequest<br><p> <br><p> NOTE: It is important to note that the issuer can choose to ignore or change any of the requested attributes. How the issuer maps a certificate request to a signed certificate is the full responsibility of the issuer itself. For example, as an edge case, an issuer that inverts the isCA value is free to do so.
     */
    @JsonProperty("issuerRef")
    public IssuerReference getIssuerRef() {
        return issuerRef;
    }

    /**
     * CertificateRequestSpec defines the desired state of CertificateRequest<br><p> <br><p> NOTE: It is important to note that the issuer can choose to ignore or change any of the requested attributes. How the issuer maps a certificate request to a signed certificate is the full responsibility of the issuer itself. For example, as an edge case, an issuer that inverts the isCA value is free to do so.
     */
    @JsonProperty("issuerRef")
    public void setIssuerRef(IssuerReference issuerRef) {
        this.issuerRef = issuerRef;
    }

    /**
     * The PEM-encoded X.509 certificate signing request to be submitted to the issuer for signing.<br><p> <br><p> If the CSR has a BasicConstraints extension, its isCA attribute must match the `isCA` value of this CertificateRequest. If the CSR has a KeyUsage extension, its key usages must match the key usages in the `usages` field of this CertificateRequest. If the CSR has a ExtKeyUsage extension, its extended key usages must match the extended key usages in the `usages` field of this CertificateRequest.
     */
    @JsonProperty("request")
    public String getRequest() {
        return request;
    }

    /**
     * The PEM-encoded X.509 certificate signing request to be submitted to the issuer for signing.<br><p> <br><p> If the CSR has a BasicConstraints extension, its isCA attribute must match the `isCA` value of this CertificateRequest. If the CSR has a KeyUsage extension, its key usages must match the key usages in the `usages` field of this CertificateRequest. If the CSR has a ExtKeyUsage extension, its extended key usages must match the extended key usages in the `usages` field of this CertificateRequest.
     */
    @JsonProperty("request")
    public void setRequest(String request) {
        this.request = request;
    }

    /**
     * UID contains the uid of the user that created the CertificateRequest. Populated by the cert-manager webhook on creation and immutable.
     */
    @JsonProperty("uid")
    public String getUid() {
        return uid;
    }

    /**
     * UID contains the uid of the user that created the CertificateRequest. Populated by the cert-manager webhook on creation and immutable.
     */
    @JsonProperty("uid")
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * Requested key usages and extended key usages.<br><p> <br><p> NOTE: If the CSR in the `Request` field has uses the KeyUsage or ExtKeyUsage extension, these extensions must have the same values as specified here without any additional values.<br><p> <br><p> If unset, defaults to `digital signature` and `key encipherment`.
     */
    @JsonProperty("usages")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getUsages() {
        return usages;
    }

    /**
     * Requested key usages and extended key usages.<br><p> <br><p> NOTE: If the CSR in the `Request` field has uses the KeyUsage or ExtKeyUsage extension, these extensions must have the same values as specified here without any additional values.<br><p> <br><p> If unset, defaults to `digital signature` and `key encipherment`.
     */
    @JsonProperty("usages")
    public void setUsages(List<String> usages) {
        this.usages = usages;
    }

    /**
     * Username contains the name of the user that created the CertificateRequest. Populated by the cert-manager webhook on creation and immutable.
     */
    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    /**
     * Username contains the name of the user that created the CertificateRequest. Populated by the cert-manager webhook on creation and immutable.
     */
    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonIgnore
    public CertificateRequestSpecBuilder edit() {
        return new CertificateRequestSpecBuilder(this);
    }

    @JsonIgnore
    public CertificateRequestSpecBuilder toBuilder() {
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
        if (!(o instanceof CertificateRequestSpec)) {
            return false;
        }
        CertificateRequestSpec other = (CertificateRequestSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$duration = this.getDuration();
        Object other$duration = other.getDuration();
        if (this$duration == null ? other$duration != null : !this$duration.equals(other$duration)) {
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
        Object this$isCA = this.getIsCA();
        Object other$isCA = other.getIsCA();
        if (this$isCA == null ? other$isCA != null : !this$isCA.equals(other$isCA)) {
            return false;
        }
        Object this$issuerRef = this.getIssuerRef();
        Object other$issuerRef = other.getIssuerRef();
        if (this$issuerRef == null ? other$issuerRef != null : !this$issuerRef.equals(other$issuerRef)) {
            return false;
        }
        Object this$request = this.getRequest();
        Object other$request = other.getRequest();
        if (this$request == null ? other$request != null : !this$request.equals(other$request)) {
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
        return other instanceof CertificateRequestSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $duration = this.getDuration();
        result = result * prime + ($duration == null ? 43 : $duration.hashCode());
        Object $extra = this.getExtra();
        result = result * prime + ($extra == null ? 43 : $extra.hashCode());
        Object $groups = this.getGroups();
        result = result * prime + ($groups == null ? 43 : $groups.hashCode());
        Object $isCA = this.getIsCA();
        result = result * prime + ($isCA == null ? 43 : $isCA.hashCode());
        Object $issuerRef = this.getIssuerRef();
        result = result * prime + ($issuerRef == null ? 43 : $issuerRef.hashCode());
        Object $request = this.getRequest();
        result = result * prime + ($request == null ? 43 : $request.hashCode());
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
        return "CertificateRequestSpec(" + "duration=" + this.getDuration() + ", extra=" + this.getExtra() + ", groups=" + this.getGroups() + ", isCA=" + this.getIsCA() + ", issuerRef=" + this.getIssuerRef() + ", request=" + this.getRequest() + ", uid=" + this.getUid() + ", usages=" + this.getUsages() + ", username=" + this.getUsername() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
