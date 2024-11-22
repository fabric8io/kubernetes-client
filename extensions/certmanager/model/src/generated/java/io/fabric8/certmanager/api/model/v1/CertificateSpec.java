
package io.fabric8.certmanager.api.model.v1;

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
import io.fabric8.certmanager.api.model.meta.v1.ObjectReference;
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "additionalOutputFormats",
    "commonName",
    "dnsNames",
    "duration",
    "emailAddresses",
    "encodeUsagesInRequest",
    "ipAddresses",
    "isCA",
    "issuerRef",
    "keystores",
    "literalSubject",
    "nameConstraints",
    "otherNames",
    "privateKey",
    "renewBefore",
    "renewBeforePercentage",
    "revisionHistoryLimit",
    "secretName",
    "secretTemplate",
    "subject",
    "uris",
    "usages"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class CertificateSpec implements Editable<CertificateSpecBuilder> , KubernetesResource
{

    @JsonProperty("additionalOutputFormats")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<CertificateAdditionalOutputFormat> additionalOutputFormats = new ArrayList<>();
    @JsonProperty("commonName")
    private String commonName;
    @JsonProperty("dnsNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> dnsNames = new ArrayList<>();
    @JsonProperty("duration")
    private Duration duration;
    @JsonProperty("emailAddresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> emailAddresses = new ArrayList<>();
    @JsonProperty("encodeUsagesInRequest")
    private Boolean encodeUsagesInRequest;
    @JsonProperty("ipAddresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> ipAddresses = new ArrayList<>();
    @JsonProperty("isCA")
    private Boolean isCA;
    @JsonProperty("issuerRef")
    private ObjectReference issuerRef;
    @JsonProperty("keystores")
    private CertificateKeystores keystores;
    @JsonProperty("literalSubject")
    private String literalSubject;
    @JsonProperty("nameConstraints")
    private NameConstraints nameConstraints;
    @JsonProperty("otherNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<OtherName> otherNames = new ArrayList<>();
    @JsonProperty("privateKey")
    private CertificatePrivateKey privateKey;
    @JsonProperty("renewBefore")
    private Duration renewBefore;
    @JsonProperty("renewBeforePercentage")
    private Integer renewBeforePercentage;
    @JsonProperty("revisionHistoryLimit")
    private Integer revisionHistoryLimit;
    @JsonProperty("secretName")
    private String secretName;
    @JsonProperty("secretTemplate")
    private CertificateSecretTemplate secretTemplate;
    @JsonProperty("subject")
    private X509Subject subject;
    @JsonProperty("uris")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> uris = new ArrayList<>();
    @JsonProperty("usages")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> usages = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public CertificateSpec() {
    }

    public CertificateSpec(List<CertificateAdditionalOutputFormat> additionalOutputFormats, String commonName, List<String> dnsNames, Duration duration, List<String> emailAddresses, Boolean encodeUsagesInRequest, List<String> ipAddresses, Boolean isCA, ObjectReference issuerRef, CertificateKeystores keystores, String literalSubject, NameConstraints nameConstraints, List<OtherName> otherNames, CertificatePrivateKey privateKey, Duration renewBefore, Integer renewBeforePercentage, Integer revisionHistoryLimit, String secretName, CertificateSecretTemplate secretTemplate, X509Subject subject, List<String> uris, List<String> usages) {
        super();
        this.additionalOutputFormats = additionalOutputFormats;
        this.commonName = commonName;
        this.dnsNames = dnsNames;
        this.duration = duration;
        this.emailAddresses = emailAddresses;
        this.encodeUsagesInRequest = encodeUsagesInRequest;
        this.ipAddresses = ipAddresses;
        this.isCA = isCA;
        this.issuerRef = issuerRef;
        this.keystores = keystores;
        this.literalSubject = literalSubject;
        this.nameConstraints = nameConstraints;
        this.otherNames = otherNames;
        this.privateKey = privateKey;
        this.renewBefore = renewBefore;
        this.renewBeforePercentage = renewBeforePercentage;
        this.revisionHistoryLimit = revisionHistoryLimit;
        this.secretName = secretName;
        this.secretTemplate = secretTemplate;
        this.subject = subject;
        this.uris = uris;
        this.usages = usages;
    }

    @JsonProperty("additionalOutputFormats")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<CertificateAdditionalOutputFormat> getAdditionalOutputFormats() {
        return additionalOutputFormats;
    }

    @JsonProperty("additionalOutputFormats")
    public void setAdditionalOutputFormats(List<CertificateAdditionalOutputFormat> additionalOutputFormats) {
        this.additionalOutputFormats = additionalOutputFormats;
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
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

    @JsonProperty("emailAddresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getEmailAddresses() {
        return emailAddresses;
    }

    @JsonProperty("emailAddresses")
    public void setEmailAddresses(List<String> emailAddresses) {
        this.emailAddresses = emailAddresses;
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getIpAddresses() {
        return ipAddresses;
    }

    @JsonProperty("ipAddresses")
    public void setIpAddresses(List<String> ipAddresses) {
        this.ipAddresses = ipAddresses;
    }

    @JsonProperty("isCA")
    public Boolean getIsCA() {
        return isCA;
    }

    @JsonProperty("isCA")
    public void setIsCA(Boolean isCA) {
        this.isCA = isCA;
    }

    @JsonProperty("issuerRef")
    public ObjectReference getIssuerRef() {
        return issuerRef;
    }

    @JsonProperty("issuerRef")
    public void setIssuerRef(ObjectReference issuerRef) {
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

    @JsonProperty("literalSubject")
    public String getLiteralSubject() {
        return literalSubject;
    }

    @JsonProperty("literalSubject")
    public void setLiteralSubject(String literalSubject) {
        this.literalSubject = literalSubject;
    }

    @JsonProperty("nameConstraints")
    public NameConstraints getNameConstraints() {
        return nameConstraints;
    }

    @JsonProperty("nameConstraints")
    public void setNameConstraints(NameConstraints nameConstraints) {
        this.nameConstraints = nameConstraints;
    }

    @JsonProperty("otherNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<OtherName> getOtherNames() {
        return otherNames;
    }

    @JsonProperty("otherNames")
    public void setOtherNames(List<OtherName> otherNames) {
        this.otherNames = otherNames;
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

    @JsonProperty("renewBeforePercentage")
    public Integer getRenewBeforePercentage() {
        return renewBeforePercentage;
    }

    @JsonProperty("renewBeforePercentage")
    public void setRenewBeforePercentage(Integer renewBeforePercentage) {
        this.renewBeforePercentage = renewBeforePercentage;
    }

    @JsonProperty("revisionHistoryLimit")
    public Integer getRevisionHistoryLimit() {
        return revisionHistoryLimit;
    }

    @JsonProperty("revisionHistoryLimit")
    public void setRevisionHistoryLimit(Integer revisionHistoryLimit) {
        this.revisionHistoryLimit = revisionHistoryLimit;
    }

    @JsonProperty("secretName")
    public String getSecretName() {
        return secretName;
    }

    @JsonProperty("secretName")
    public void setSecretName(String secretName) {
        this.secretName = secretName;
    }

    @JsonProperty("secretTemplate")
    public CertificateSecretTemplate getSecretTemplate() {
        return secretTemplate;
    }

    @JsonProperty("secretTemplate")
    public void setSecretTemplate(CertificateSecretTemplate secretTemplate) {
        this.secretTemplate = secretTemplate;
    }

    @JsonProperty("subject")
    public X509Subject getSubject() {
        return subject;
    }

    @JsonProperty("subject")
    public void setSubject(X509Subject subject) {
        this.subject = subject;
    }

    @JsonProperty("uris")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getUris() {
        return uris;
    }

    @JsonProperty("uris")
    public void setUris(List<String> uris) {
        this.uris = uris;
    }

    @JsonProperty("usages")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getUsages() {
        return usages;
    }

    @JsonProperty("usages")
    public void setUsages(List<String> usages) {
        this.usages = usages;
    }

    @JsonIgnore
    public CertificateSpecBuilder edit() {
        return new CertificateSpecBuilder(this);
    }

    @JsonIgnore
    public CertificateSpecBuilder toBuilder() {
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
