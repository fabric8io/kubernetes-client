
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

/**
 * CertificateSpec defines the desired state of Certificate.<br><p> <br><p> NOTE: The specification contains a lot of "requested" certificate attributes, it is important to note that the issuer can choose to ignore or change any of these requested attributes. How the issuer maps a certificate request to a signed certificate is the full responsibility of the issuer itself. For example, as an edge case, an issuer that inverts the isCA value is free to do so.<br><p> <br><p> A valid Certificate requires at least one of a CommonName, LiteralSubject, DNSName, or URI to be valid.
 */
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
public class CertificateSpec implements Editable<CertificateSpecBuilder>, KubernetesResource
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

    /**
     * Defines extra output formats of the private key and signed certificate chain to be written to this Certificate's target Secret.<br><p> <br><p> This is a Beta Feature enabled by default. It can be disabled with the `--feature-gates=AdditionalCertificateOutputFormats=false` option set on both the controller and webhook components.
     */
    @JsonProperty("additionalOutputFormats")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<CertificateAdditionalOutputFormat> getAdditionalOutputFormats() {
        return additionalOutputFormats;
    }

    /**
     * Defines extra output formats of the private key and signed certificate chain to be written to this Certificate's target Secret.<br><p> <br><p> This is a Beta Feature enabled by default. It can be disabled with the `--feature-gates=AdditionalCertificateOutputFormats=false` option set on both the controller and webhook components.
     */
    @JsonProperty("additionalOutputFormats")
    public void setAdditionalOutputFormats(List<CertificateAdditionalOutputFormat> additionalOutputFormats) {
        this.additionalOutputFormats = additionalOutputFormats;
    }

    /**
     * Requested common name X509 certificate subject attribute. More info: https://datatracker.ietf.org/doc/html/rfc5280#section-4.1.2.6 NOTE: TLS clients will ignore this value when any subject alternative name is set (see https://tools.ietf.org/html/rfc6125#section-6.4.4).<br><p> <br><p> Should have a length of 64 characters or fewer to avoid generating invalid CSRs. Cannot be set if the `literalSubject` field is set.
     */
    @JsonProperty("commonName")
    public String getCommonName() {
        return commonName;
    }

    /**
     * Requested common name X509 certificate subject attribute. More info: https://datatracker.ietf.org/doc/html/rfc5280#section-4.1.2.6 NOTE: TLS clients will ignore this value when any subject alternative name is set (see https://tools.ietf.org/html/rfc6125#section-6.4.4).<br><p> <br><p> Should have a length of 64 characters or fewer to avoid generating invalid CSRs. Cannot be set if the `literalSubject` field is set.
     */
    @JsonProperty("commonName")
    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    /**
     * Requested DNS subject alternative names.
     */
    @JsonProperty("dnsNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getDnsNames() {
        return dnsNames;
    }

    /**
     * Requested DNS subject alternative names.
     */
    @JsonProperty("dnsNames")
    public void setDnsNames(List<String> dnsNames) {
        this.dnsNames = dnsNames;
    }

    /**
     * CertificateSpec defines the desired state of Certificate.<br><p> <br><p> NOTE: The specification contains a lot of "requested" certificate attributes, it is important to note that the issuer can choose to ignore or change any of these requested attributes. How the issuer maps a certificate request to a signed certificate is the full responsibility of the issuer itself. For example, as an edge case, an issuer that inverts the isCA value is free to do so.<br><p> <br><p> A valid Certificate requires at least one of a CommonName, LiteralSubject, DNSName, or URI to be valid.
     */
    @JsonProperty("duration")
    public Duration getDuration() {
        return duration;
    }

    /**
     * CertificateSpec defines the desired state of Certificate.<br><p> <br><p> NOTE: The specification contains a lot of "requested" certificate attributes, it is important to note that the issuer can choose to ignore or change any of these requested attributes. How the issuer maps a certificate request to a signed certificate is the full responsibility of the issuer itself. For example, as an edge case, an issuer that inverts the isCA value is free to do so.<br><p> <br><p> A valid Certificate requires at least one of a CommonName, LiteralSubject, DNSName, or URI to be valid.
     */
    @JsonProperty("duration")
    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    /**
     * Requested email subject alternative names.
     */
    @JsonProperty("emailAddresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getEmailAddresses() {
        return emailAddresses;
    }

    /**
     * Requested email subject alternative names.
     */
    @JsonProperty("emailAddresses")
    public void setEmailAddresses(List<String> emailAddresses) {
        this.emailAddresses = emailAddresses;
    }

    /**
     * Whether the KeyUsage and ExtKeyUsage extensions should be set in the encoded CSR.<br><p> <br><p> This option defaults to true, and should only be disabled if the target issuer does not support CSRs with these X509 KeyUsage/ ExtKeyUsage extensions.
     */
    @JsonProperty("encodeUsagesInRequest")
    public Boolean getEncodeUsagesInRequest() {
        return encodeUsagesInRequest;
    }

    /**
     * Whether the KeyUsage and ExtKeyUsage extensions should be set in the encoded CSR.<br><p> <br><p> This option defaults to true, and should only be disabled if the target issuer does not support CSRs with these X509 KeyUsage/ ExtKeyUsage extensions.
     */
    @JsonProperty("encodeUsagesInRequest")
    public void setEncodeUsagesInRequest(Boolean encodeUsagesInRequest) {
        this.encodeUsagesInRequest = encodeUsagesInRequest;
    }

    /**
     * Requested IP address subject alternative names.
     */
    @JsonProperty("ipAddresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getIpAddresses() {
        return ipAddresses;
    }

    /**
     * Requested IP address subject alternative names.
     */
    @JsonProperty("ipAddresses")
    public void setIpAddresses(List<String> ipAddresses) {
        this.ipAddresses = ipAddresses;
    }

    /**
     * Requested basic constraints isCA value. The isCA value is used to set the `isCA` field on the created CertificateRequest resources. Note that the issuer may choose to ignore the requested isCA value, just like any other requested attribute.<br><p> <br><p> If true, this will automatically add the `cert sign` usage to the list of requested `usages`.
     */
    @JsonProperty("isCA")
    public Boolean getIsCA() {
        return isCA;
    }

    /**
     * Requested basic constraints isCA value. The isCA value is used to set the `isCA` field on the created CertificateRequest resources. Note that the issuer may choose to ignore the requested isCA value, just like any other requested attribute.<br><p> <br><p> If true, this will automatically add the `cert sign` usage to the list of requested `usages`.
     */
    @JsonProperty("isCA")
    public void setIsCA(Boolean isCA) {
        this.isCA = isCA;
    }

    /**
     * CertificateSpec defines the desired state of Certificate.<br><p> <br><p> NOTE: The specification contains a lot of "requested" certificate attributes, it is important to note that the issuer can choose to ignore or change any of these requested attributes. How the issuer maps a certificate request to a signed certificate is the full responsibility of the issuer itself. For example, as an edge case, an issuer that inverts the isCA value is free to do so.<br><p> <br><p> A valid Certificate requires at least one of a CommonName, LiteralSubject, DNSName, or URI to be valid.
     */
    @JsonProperty("issuerRef")
    public ObjectReference getIssuerRef() {
        return issuerRef;
    }

    /**
     * CertificateSpec defines the desired state of Certificate.<br><p> <br><p> NOTE: The specification contains a lot of "requested" certificate attributes, it is important to note that the issuer can choose to ignore or change any of these requested attributes. How the issuer maps a certificate request to a signed certificate is the full responsibility of the issuer itself. For example, as an edge case, an issuer that inverts the isCA value is free to do so.<br><p> <br><p> A valid Certificate requires at least one of a CommonName, LiteralSubject, DNSName, or URI to be valid.
     */
    @JsonProperty("issuerRef")
    public void setIssuerRef(ObjectReference issuerRef) {
        this.issuerRef = issuerRef;
    }

    /**
     * CertificateSpec defines the desired state of Certificate.<br><p> <br><p> NOTE: The specification contains a lot of "requested" certificate attributes, it is important to note that the issuer can choose to ignore or change any of these requested attributes. How the issuer maps a certificate request to a signed certificate is the full responsibility of the issuer itself. For example, as an edge case, an issuer that inverts the isCA value is free to do so.<br><p> <br><p> A valid Certificate requires at least one of a CommonName, LiteralSubject, DNSName, or URI to be valid.
     */
    @JsonProperty("keystores")
    public CertificateKeystores getKeystores() {
        return keystores;
    }

    /**
     * CertificateSpec defines the desired state of Certificate.<br><p> <br><p> NOTE: The specification contains a lot of "requested" certificate attributes, it is important to note that the issuer can choose to ignore or change any of these requested attributes. How the issuer maps a certificate request to a signed certificate is the full responsibility of the issuer itself. For example, as an edge case, an issuer that inverts the isCA value is free to do so.<br><p> <br><p> A valid Certificate requires at least one of a CommonName, LiteralSubject, DNSName, or URI to be valid.
     */
    @JsonProperty("keystores")
    public void setKeystores(CertificateKeystores keystores) {
        this.keystores = keystores;
    }

    /**
     * Requested X.509 certificate subject, represented using the LDAP "String Representation of a Distinguished Name" [1]. Important: the LDAP string format also specifies the order of the attributes in the subject, this is important when issuing certs for LDAP authentication. Example: `CN=foo,DC=corp,DC=example,DC=com` More info [1]: https://datatracker.ietf.org/doc/html/rfc4514 More info: https://github.com/cert-manager/cert-manager/issues/3203 More info: https://github.com/cert-manager/cert-manager/issues/4424<br><p> <br><p> Cannot be set if the `subject` or `commonName` field is set.
     */
    @JsonProperty("literalSubject")
    public String getLiteralSubject() {
        return literalSubject;
    }

    /**
     * Requested X.509 certificate subject, represented using the LDAP "String Representation of a Distinguished Name" [1]. Important: the LDAP string format also specifies the order of the attributes in the subject, this is important when issuing certs for LDAP authentication. Example: `CN=foo,DC=corp,DC=example,DC=com` More info [1]: https://datatracker.ietf.org/doc/html/rfc4514 More info: https://github.com/cert-manager/cert-manager/issues/3203 More info: https://github.com/cert-manager/cert-manager/issues/4424<br><p> <br><p> Cannot be set if the `subject` or `commonName` field is set.
     */
    @JsonProperty("literalSubject")
    public void setLiteralSubject(String literalSubject) {
        this.literalSubject = literalSubject;
    }

    /**
     * CertificateSpec defines the desired state of Certificate.<br><p> <br><p> NOTE: The specification contains a lot of "requested" certificate attributes, it is important to note that the issuer can choose to ignore or change any of these requested attributes. How the issuer maps a certificate request to a signed certificate is the full responsibility of the issuer itself. For example, as an edge case, an issuer that inverts the isCA value is free to do so.<br><p> <br><p> A valid Certificate requires at least one of a CommonName, LiteralSubject, DNSName, or URI to be valid.
     */
    @JsonProperty("nameConstraints")
    public NameConstraints getNameConstraints() {
        return nameConstraints;
    }

    /**
     * CertificateSpec defines the desired state of Certificate.<br><p> <br><p> NOTE: The specification contains a lot of "requested" certificate attributes, it is important to note that the issuer can choose to ignore or change any of these requested attributes. How the issuer maps a certificate request to a signed certificate is the full responsibility of the issuer itself. For example, as an edge case, an issuer that inverts the isCA value is free to do so.<br><p> <br><p> A valid Certificate requires at least one of a CommonName, LiteralSubject, DNSName, or URI to be valid.
     */
    @JsonProperty("nameConstraints")
    public void setNameConstraints(NameConstraints nameConstraints) {
        this.nameConstraints = nameConstraints;
    }

    /**
     * `otherNames` is an escape hatch for SAN that allows any type. We currently restrict the support to string like otherNames, cf RFC 5280 p 37 Any UTF8 String valued otherName can be passed with by setting the keys oid: x.x.x.x and UTF8Value: somevalue for `otherName`. Most commonly this would be UPN set with oid: 1.3.6.1.4.1.311.20.2.3 You should ensure that any OID passed is valid for the UTF8String type as we do not explicitly validate this.
     */
    @JsonProperty("otherNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<OtherName> getOtherNames() {
        return otherNames;
    }

    /**
     * `otherNames` is an escape hatch for SAN that allows any type. We currently restrict the support to string like otherNames, cf RFC 5280 p 37 Any UTF8 String valued otherName can be passed with by setting the keys oid: x.x.x.x and UTF8Value: somevalue for `otherName`. Most commonly this would be UPN set with oid: 1.3.6.1.4.1.311.20.2.3 You should ensure that any OID passed is valid for the UTF8String type as we do not explicitly validate this.
     */
    @JsonProperty("otherNames")
    public void setOtherNames(List<OtherName> otherNames) {
        this.otherNames = otherNames;
    }

    /**
     * CertificateSpec defines the desired state of Certificate.<br><p> <br><p> NOTE: The specification contains a lot of "requested" certificate attributes, it is important to note that the issuer can choose to ignore or change any of these requested attributes. How the issuer maps a certificate request to a signed certificate is the full responsibility of the issuer itself. For example, as an edge case, an issuer that inverts the isCA value is free to do so.<br><p> <br><p> A valid Certificate requires at least one of a CommonName, LiteralSubject, DNSName, or URI to be valid.
     */
    @JsonProperty("privateKey")
    public CertificatePrivateKey getPrivateKey() {
        return privateKey;
    }

    /**
     * CertificateSpec defines the desired state of Certificate.<br><p> <br><p> NOTE: The specification contains a lot of "requested" certificate attributes, it is important to note that the issuer can choose to ignore or change any of these requested attributes. How the issuer maps a certificate request to a signed certificate is the full responsibility of the issuer itself. For example, as an edge case, an issuer that inverts the isCA value is free to do so.<br><p> <br><p> A valid Certificate requires at least one of a CommonName, LiteralSubject, DNSName, or URI to be valid.
     */
    @JsonProperty("privateKey")
    public void setPrivateKey(CertificatePrivateKey privateKey) {
        this.privateKey = privateKey;
    }

    /**
     * CertificateSpec defines the desired state of Certificate.<br><p> <br><p> NOTE: The specification contains a lot of "requested" certificate attributes, it is important to note that the issuer can choose to ignore or change any of these requested attributes. How the issuer maps a certificate request to a signed certificate is the full responsibility of the issuer itself. For example, as an edge case, an issuer that inverts the isCA value is free to do so.<br><p> <br><p> A valid Certificate requires at least one of a CommonName, LiteralSubject, DNSName, or URI to be valid.
     */
    @JsonProperty("renewBefore")
    public Duration getRenewBefore() {
        return renewBefore;
    }

    /**
     * CertificateSpec defines the desired state of Certificate.<br><p> <br><p> NOTE: The specification contains a lot of "requested" certificate attributes, it is important to note that the issuer can choose to ignore or change any of these requested attributes. How the issuer maps a certificate request to a signed certificate is the full responsibility of the issuer itself. For example, as an edge case, an issuer that inverts the isCA value is free to do so.<br><p> <br><p> A valid Certificate requires at least one of a CommonName, LiteralSubject, DNSName, or URI to be valid.
     */
    @JsonProperty("renewBefore")
    public void setRenewBefore(Duration renewBefore) {
        this.renewBefore = renewBefore;
    }

    /**
     * `renewBeforePercentage` is like `renewBefore`, except it is a relative percentage rather than an absolute duration. For example, if a certificate is valid for 60 minutes, and  `renewBeforePercentage=25`, cert-manager will begin to attempt to renew the certificate 45 minutes after it was issued (i.e. when there are 15 minutes (25%) remaining until the certificate is no longer valid).<br><p> <br><p> NOTE: The actual lifetime of the issued certificate is used to determine the renewal time. If an issuer returns a certificate with a different lifetime than the one requested, cert-manager will use the lifetime of the issued certificate.<br><p> <br><p> Value must be an integer in the range (0,100). The minimum effective `renewBefore` derived from the `renewBeforePercentage` and `duration` fields is 5 minutes. Cannot be set if the `renewBefore` field is set.
     */
    @JsonProperty("renewBeforePercentage")
    public Integer getRenewBeforePercentage() {
        return renewBeforePercentage;
    }

    /**
     * `renewBeforePercentage` is like `renewBefore`, except it is a relative percentage rather than an absolute duration. For example, if a certificate is valid for 60 minutes, and  `renewBeforePercentage=25`, cert-manager will begin to attempt to renew the certificate 45 minutes after it was issued (i.e. when there are 15 minutes (25%) remaining until the certificate is no longer valid).<br><p> <br><p> NOTE: The actual lifetime of the issued certificate is used to determine the renewal time. If an issuer returns a certificate with a different lifetime than the one requested, cert-manager will use the lifetime of the issued certificate.<br><p> <br><p> Value must be an integer in the range (0,100). The minimum effective `renewBefore` derived from the `renewBeforePercentage` and `duration` fields is 5 minutes. Cannot be set if the `renewBefore` field is set.
     */
    @JsonProperty("renewBeforePercentage")
    public void setRenewBeforePercentage(Integer renewBeforePercentage) {
        this.renewBeforePercentage = renewBeforePercentage;
    }

    /**
     * The maximum number of CertificateRequest revisions that are maintained in the Certificate's history. Each revision represents a single `CertificateRequest` created by this Certificate, either when it was created, renewed, or Spec was changed. Revisions will be removed by oldest first if the number of revisions exceeds this number.<br><p> <br><p> If set, revisionHistoryLimit must be a value of `1` or greater. If unset (`nil`), revisions will not be garbage collected. Default value is `nil`.
     */
    @JsonProperty("revisionHistoryLimit")
    public Integer getRevisionHistoryLimit() {
        return revisionHistoryLimit;
    }

    /**
     * The maximum number of CertificateRequest revisions that are maintained in the Certificate's history. Each revision represents a single `CertificateRequest` created by this Certificate, either when it was created, renewed, or Spec was changed. Revisions will be removed by oldest first if the number of revisions exceeds this number.<br><p> <br><p> If set, revisionHistoryLimit must be a value of `1` or greater. If unset (`nil`), revisions will not be garbage collected. Default value is `nil`.
     */
    @JsonProperty("revisionHistoryLimit")
    public void setRevisionHistoryLimit(Integer revisionHistoryLimit) {
        this.revisionHistoryLimit = revisionHistoryLimit;
    }

    /**
     * Name of the Secret resource that will be automatically created and managed by this Certificate resource. It will be populated with a private key and certificate, signed by the denoted issuer. The Secret resource lives in the same namespace as the Certificate resource.
     */
    @JsonProperty("secretName")
    public String getSecretName() {
        return secretName;
    }

    /**
     * Name of the Secret resource that will be automatically created and managed by this Certificate resource. It will be populated with a private key and certificate, signed by the denoted issuer. The Secret resource lives in the same namespace as the Certificate resource.
     */
    @JsonProperty("secretName")
    public void setSecretName(String secretName) {
        this.secretName = secretName;
    }

    /**
     * CertificateSpec defines the desired state of Certificate.<br><p> <br><p> NOTE: The specification contains a lot of "requested" certificate attributes, it is important to note that the issuer can choose to ignore or change any of these requested attributes. How the issuer maps a certificate request to a signed certificate is the full responsibility of the issuer itself. For example, as an edge case, an issuer that inverts the isCA value is free to do so.<br><p> <br><p> A valid Certificate requires at least one of a CommonName, LiteralSubject, DNSName, or URI to be valid.
     */
    @JsonProperty("secretTemplate")
    public CertificateSecretTemplate getSecretTemplate() {
        return secretTemplate;
    }

    /**
     * CertificateSpec defines the desired state of Certificate.<br><p> <br><p> NOTE: The specification contains a lot of "requested" certificate attributes, it is important to note that the issuer can choose to ignore or change any of these requested attributes. How the issuer maps a certificate request to a signed certificate is the full responsibility of the issuer itself. For example, as an edge case, an issuer that inverts the isCA value is free to do so.<br><p> <br><p> A valid Certificate requires at least one of a CommonName, LiteralSubject, DNSName, or URI to be valid.
     */
    @JsonProperty("secretTemplate")
    public void setSecretTemplate(CertificateSecretTemplate secretTemplate) {
        this.secretTemplate = secretTemplate;
    }

    /**
     * CertificateSpec defines the desired state of Certificate.<br><p> <br><p> NOTE: The specification contains a lot of "requested" certificate attributes, it is important to note that the issuer can choose to ignore or change any of these requested attributes. How the issuer maps a certificate request to a signed certificate is the full responsibility of the issuer itself. For example, as an edge case, an issuer that inverts the isCA value is free to do so.<br><p> <br><p> A valid Certificate requires at least one of a CommonName, LiteralSubject, DNSName, or URI to be valid.
     */
    @JsonProperty("subject")
    public X509Subject getSubject() {
        return subject;
    }

    /**
     * CertificateSpec defines the desired state of Certificate.<br><p> <br><p> NOTE: The specification contains a lot of "requested" certificate attributes, it is important to note that the issuer can choose to ignore or change any of these requested attributes. How the issuer maps a certificate request to a signed certificate is the full responsibility of the issuer itself. For example, as an edge case, an issuer that inverts the isCA value is free to do so.<br><p> <br><p> A valid Certificate requires at least one of a CommonName, LiteralSubject, DNSName, or URI to be valid.
     */
    @JsonProperty("subject")
    public void setSubject(X509Subject subject) {
        this.subject = subject;
    }

    /**
     * Requested URI subject alternative names.
     */
    @JsonProperty("uris")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getUris() {
        return uris;
    }

    /**
     * Requested URI subject alternative names.
     */
    @JsonProperty("uris")
    public void setUris(List<String> uris) {
        this.uris = uris;
    }

    /**
     * Requested key usages and extended key usages. These usages are used to set the `usages` field on the created CertificateRequest resources. If `encodeUsagesInRequest` is unset or set to `true`, the usages will additionally be encoded in the `request` field which contains the CSR blob.<br><p> <br><p> If unset, defaults to `digital signature` and `key encipherment`.
     */
    @JsonProperty("usages")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getUsages() {
        return usages;
    }

    /**
     * Requested key usages and extended key usages. These usages are used to set the `usages` field on the created CertificateRequest resources. If `encodeUsagesInRequest` is unset or set to `true`, the usages will additionally be encoded in the `request` field which contains the CSR blob.<br><p> <br><p> If unset, defaults to `digital signature` and `key encipherment`.
     */
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
