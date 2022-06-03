
package io.fabric8.certmanager.api.model.v1beta1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.Duration;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "commonName",
    "dnsNames",
    "duration",
    "emailSANs",
    "encodeUsagesInRequest",
    "ipAddresses",
    "isCA",
    "issuerRef",
    "keystores",
    "privateKey",
    "renewBefore",
    "secretName",
    "subject",
    "uriSANs",
    "usages"
})
@ToString
@EqualsAndHashCode
@Setter
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
public class CertificateSpec implements KubernetesResource
{

    @JsonProperty("commonName")
    private String commonName;
    @JsonProperty("dnsNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> dnsNames = new ArrayList<String>();
    @JsonProperty("duration")
    private Duration duration;
    @JsonProperty("emailSANs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> emailSANs = new ArrayList<String>();
    @JsonProperty("encodeUsagesInRequest")
    private Boolean encodeUsagesInRequest;
    @JsonProperty("ipAddresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> ipAddresses = new ArrayList<String>();
    @JsonProperty("isCA")
    private java.lang.Boolean isCA;
    @JsonProperty("issuerRef")
    private io.fabric8.certmanager.api.model.meta.v1.ObjectReference issuerRef;
    @JsonProperty("keystores")
    private CertificateKeystores keystores;
    @JsonProperty("privateKey")
    private CertificatePrivateKey privateKey;
    @JsonProperty("renewBefore")
    private Duration renewBefore;
    @JsonProperty("secretName")
    private String secretName;
    @JsonProperty("subject")
    private X509Subject subject;
    @JsonProperty("uriSANs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> uriSANs = new ArrayList<String>();
    @JsonProperty("usages")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> usages = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public CertificateSpec() {
    }

    /**
     * 
     * @param commonName
     * @param secretName
     * @param dnsNames
     * @param keystores
     * @param subject
     * @param issuerRef
     * @param encodeUsagesInRequest
     * @param emailSANs
     * @param duration
     * @param uriSANs
     * @param privateKey
     * @param renewBefore
     * @param isCA
     * @param ipAddresses
     * @param usages
     */
    public CertificateSpec(String commonName, List<String> dnsNames, Duration duration, List<String> emailSANs, Boolean encodeUsagesInRequest, List<String> ipAddresses, java.lang.Boolean isCA, io.fabric8.certmanager.api.model.meta.v1.ObjectReference issuerRef, CertificateKeystores keystores, CertificatePrivateKey privateKey, Duration renewBefore, String secretName, X509Subject subject, List<String> uriSANs, List<String> usages) {
        super();
        this.commonName = commonName;
        this.dnsNames = dnsNames;
        this.duration = duration;
        this.emailSANs = emailSANs;
        this.encodeUsagesInRequest = encodeUsagesInRequest;
        this.ipAddresses = ipAddresses;
        this.isCA = isCA;
        this.issuerRef = issuerRef;
        this.keystores = keystores;
        this.privateKey = privateKey;
        this.renewBefore = renewBefore;
        this.secretName = secretName;
        this.subject = subject;
        this.uriSANs = uriSANs;
        this.usages = usages;
    }

    @JsonProperty("commonName")
    public String getCommonName() {
        return commonName;
    }

    @JsonProperty("commonName")
    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    @JsonProperty("dnsNames")
    public List<String> getDnsNames() {
        return dnsNames;
    }

    @JsonProperty("dnsNames")
    public void setDnsNames(List<String> dnsNames) {
        this.dnsNames = dnsNames;
    }

    @JsonProperty("duration")
    public Duration getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    @JsonProperty("emailSANs")
    public List<String> getEmailSANs() {
        return emailSANs;
    }

    @JsonProperty("emailSANs")
    public void setEmailSANs(List<String> emailSANs) {
        this.emailSANs = emailSANs;
    }

    @JsonProperty("encodeUsagesInRequest")
    public Boolean getEncodeUsagesInRequest() {
        return encodeUsagesInRequest;
    }

    @JsonProperty("encodeUsagesInRequest")
    public void setEncodeUsagesInRequest(Boolean encodeUsagesInRequest) {
        this.encodeUsagesInRequest = encodeUsagesInRequest;
    }

    @JsonProperty("ipAddresses")
    public List<String> getIpAddresses() {
        return ipAddresses;
    }

    @JsonProperty("ipAddresses")
    public void setIpAddresses(List<String> ipAddresses) {
        this.ipAddresses = ipAddresses;
    }

    @JsonProperty("isCA")
    public java.lang.Boolean getIsCA() {
        return isCA;
    }

    @JsonProperty("isCA")
    public void setIsCA(java.lang.Boolean isCA) {
        this.isCA = isCA;
    }

    @JsonProperty("issuerRef")
    public io.fabric8.certmanager.api.model.meta.v1.ObjectReference getIssuerRef() {
        return issuerRef;
    }

    @JsonProperty("issuerRef")
    public void setIssuerRef(io.fabric8.certmanager.api.model.meta.v1.ObjectReference issuerRef) {
        this.issuerRef = issuerRef;
    }

    @JsonProperty("keystores")
    public CertificateKeystores getKeystores() {
        return keystores;
    }

    @JsonProperty("keystores")
    public void setKeystores(CertificateKeystores keystores) {
        this.keystores = keystores;
    }

    @JsonProperty("privateKey")
    public CertificatePrivateKey getPrivateKey() {
        return privateKey;
    }

    @JsonProperty("privateKey")
    public void setPrivateKey(CertificatePrivateKey privateKey) {
        this.privateKey = privateKey;
    }

    @JsonProperty("renewBefore")
    public Duration getRenewBefore() {
        return renewBefore;
    }

    @JsonProperty("renewBefore")
    public void setRenewBefore(Duration renewBefore) {
        this.renewBefore = renewBefore;
    }

    @JsonProperty("secretName")
    public String getSecretName() {
        return secretName;
    }

    @JsonProperty("secretName")
    public void setSecretName(String secretName) {
        this.secretName = secretName;
    }

    @JsonProperty("subject")
    public X509Subject getSubject() {
        return subject;
    }

    @JsonProperty("subject")
    public void setSubject(X509Subject subject) {
        this.subject = subject;
    }

    @JsonProperty("uriSANs")
    public List<String> getUriSANs() {
        return uriSANs;
    }

    @JsonProperty("uriSANs")
    public void setUriSANs(List<String> uriSANs) {
        this.uriSANs = uriSANs;
    }

    @JsonProperty("usages")
    public List<String> getUsages() {
        return usages;
    }

    @JsonProperty("usages")
    public void setUsages(List<String> usages) {
        this.usages = usages;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
