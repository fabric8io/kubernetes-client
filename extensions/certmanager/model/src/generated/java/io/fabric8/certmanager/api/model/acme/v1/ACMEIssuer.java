
package io.fabric8.certmanager.api.model.acme.v1;

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
import io.fabric8.certmanager.api.model.meta.v1.SecretKeySelector;
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
 * ACMEIssuer contains the specification for an ACME issuer. This uses the RFC8555 specification to obtain certificates by completing 'challenges' to prove ownership of domain identifiers. Earlier draft versions of the ACME specification are not supported.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "caBundle",
    "disableAccountKeyGeneration",
    "email",
    "enableDurationFeature",
    "externalAccountBinding",
    "preferredChain",
    "privateKeySecretRef",
    "profile",
    "server",
    "skipTLSVerify",
    "solvers"
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
public class ACMEIssuer implements Editable<ACMEIssuerBuilder>, KubernetesResource
{

    @JsonProperty("caBundle")
    private String caBundle;
    @JsonProperty("disableAccountKeyGeneration")
    private Boolean disableAccountKeyGeneration;
    @JsonProperty("email")
    private String email;
    @JsonProperty("enableDurationFeature")
    private Boolean enableDurationFeature;
    @JsonProperty("externalAccountBinding")
    private ACMEExternalAccountBinding externalAccountBinding;
    @JsonProperty("preferredChain")
    private String preferredChain;
    @JsonProperty("privateKeySecretRef")
    private SecretKeySelector privateKeySecretRef;
    @JsonProperty("profile")
    private String profile;
    @JsonProperty("server")
    private String server;
    @JsonProperty("skipTLSVerify")
    private Boolean skipTLSVerify;
    @JsonProperty("solvers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ACMEChallengeSolver> solvers = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ACMEIssuer() {
    }

    public ACMEIssuer(String caBundle, Boolean disableAccountKeyGeneration, String email, Boolean enableDurationFeature, ACMEExternalAccountBinding externalAccountBinding, String preferredChain, SecretKeySelector privateKeySecretRef, String profile, String server, Boolean skipTLSVerify, List<ACMEChallengeSolver> solvers) {
        super();
        this.caBundle = caBundle;
        this.disableAccountKeyGeneration = disableAccountKeyGeneration;
        this.email = email;
        this.enableDurationFeature = enableDurationFeature;
        this.externalAccountBinding = externalAccountBinding;
        this.preferredChain = preferredChain;
        this.privateKeySecretRef = privateKeySecretRef;
        this.profile = profile;
        this.server = server;
        this.skipTLSVerify = skipTLSVerify;
        this.solvers = solvers;
    }

    /**
     * Base64-encoded bundle of PEM CAs which can be used to validate the certificate chain presented by the ACME server. Mutually exclusive with SkipTLSVerify; prefer using CABundle to prevent various kinds of security vulnerabilities. If CABundle and SkipTLSVerify are unset, the system certificate bundle inside the container is used to validate the TLS connection.
     */
    @JsonProperty("caBundle")
    public String getCaBundle() {
        return caBundle;
    }

    /**
     * Base64-encoded bundle of PEM CAs which can be used to validate the certificate chain presented by the ACME server. Mutually exclusive with SkipTLSVerify; prefer using CABundle to prevent various kinds of security vulnerabilities. If CABundle and SkipTLSVerify are unset, the system certificate bundle inside the container is used to validate the TLS connection.
     */
    @JsonProperty("caBundle")
    public void setCaBundle(String caBundle) {
        this.caBundle = caBundle;
    }

    /**
     * Enables or disables generating a new ACME account key. If true, the Issuer resource will &#42;not&#42; request a new account but will expect the account key to be supplied via an existing secret. If false, the cert-manager system will generate a new ACME account key for the Issuer. Defaults to false.
     */
    @JsonProperty("disableAccountKeyGeneration")
    public Boolean getDisableAccountKeyGeneration() {
        return disableAccountKeyGeneration;
    }

    /**
     * Enables or disables generating a new ACME account key. If true, the Issuer resource will &#42;not&#42; request a new account but will expect the account key to be supplied via an existing secret. If false, the cert-manager system will generate a new ACME account key for the Issuer. Defaults to false.
     */
    @JsonProperty("disableAccountKeyGeneration")
    public void setDisableAccountKeyGeneration(Boolean disableAccountKeyGeneration) {
        this.disableAccountKeyGeneration = disableAccountKeyGeneration;
    }

    /**
     * Email is the email address to be associated with the ACME account. This field is optional, but it is strongly recommended to be set. It will be used to contact you in case of issues with your account or certificates, including expiry notification emails. This field may be updated after the account is initially registered.
     */
    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    /**
     * Email is the email address to be associated with the ACME account. This field is optional, but it is strongly recommended to be set. It will be used to contact you in case of issues with your account or certificates, including expiry notification emails. This field may be updated after the account is initially registered.
     */
    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Enables requesting a Not After date on certificates that matches the duration of the certificate. This is not supported by all ACME servers like Let's Encrypt. If set to true when the ACME server does not support it, it will create an error on the Order. Defaults to false.
     */
    @JsonProperty("enableDurationFeature")
    public Boolean getEnableDurationFeature() {
        return enableDurationFeature;
    }

    /**
     * Enables requesting a Not After date on certificates that matches the duration of the certificate. This is not supported by all ACME servers like Let's Encrypt. If set to true when the ACME server does not support it, it will create an error on the Order. Defaults to false.
     */
    @JsonProperty("enableDurationFeature")
    public void setEnableDurationFeature(Boolean enableDurationFeature) {
        this.enableDurationFeature = enableDurationFeature;
    }

    /**
     * ACMEIssuer contains the specification for an ACME issuer. This uses the RFC8555 specification to obtain certificates by completing 'challenges' to prove ownership of domain identifiers. Earlier draft versions of the ACME specification are not supported.
     */
    @JsonProperty("externalAccountBinding")
    public ACMEExternalAccountBinding getExternalAccountBinding() {
        return externalAccountBinding;
    }

    /**
     * ACMEIssuer contains the specification for an ACME issuer. This uses the RFC8555 specification to obtain certificates by completing 'challenges' to prove ownership of domain identifiers. Earlier draft versions of the ACME specification are not supported.
     */
    @JsonProperty("externalAccountBinding")
    public void setExternalAccountBinding(ACMEExternalAccountBinding externalAccountBinding) {
        this.externalAccountBinding = externalAccountBinding;
    }

    /**
     * PreferredChain is the chain to use if the ACME server outputs multiple. PreferredChain is no guarantee that this one gets delivered by the ACME endpoint. For example, for Let's Encrypt's DST cross-sign you would use: "DST Root CA X3" or "ISRG Root X1" for the newer Let's Encrypt root CA. This value picks the first certificate bundle in the combined set of ACME default and alternative chains that has a root-most certificate with this value as its issuer's commonname.
     */
    @JsonProperty("preferredChain")
    public String getPreferredChain() {
        return preferredChain;
    }

    /**
     * PreferredChain is the chain to use if the ACME server outputs multiple. PreferredChain is no guarantee that this one gets delivered by the ACME endpoint. For example, for Let's Encrypt's DST cross-sign you would use: "DST Root CA X3" or "ISRG Root X1" for the newer Let's Encrypt root CA. This value picks the first certificate bundle in the combined set of ACME default and alternative chains that has a root-most certificate with this value as its issuer's commonname.
     */
    @JsonProperty("preferredChain")
    public void setPreferredChain(String preferredChain) {
        this.preferredChain = preferredChain;
    }

    /**
     * ACMEIssuer contains the specification for an ACME issuer. This uses the RFC8555 specification to obtain certificates by completing 'challenges' to prove ownership of domain identifiers. Earlier draft versions of the ACME specification are not supported.
     */
    @JsonProperty("privateKeySecretRef")
    public SecretKeySelector getPrivateKeySecretRef() {
        return privateKeySecretRef;
    }

    /**
     * ACMEIssuer contains the specification for an ACME issuer. This uses the RFC8555 specification to obtain certificates by completing 'challenges' to prove ownership of domain identifiers. Earlier draft versions of the ACME specification are not supported.
     */
    @JsonProperty("privateKeySecretRef")
    public void setPrivateKeySecretRef(SecretKeySelector privateKeySecretRef) {
        this.privateKeySecretRef = privateKeySecretRef;
    }

    /**
     * Profile allows requesting a certificate profile from the ACME server. Supported profiles are listed by the server's ACME directory URL.
     */
    @JsonProperty("profile")
    public String getProfile() {
        return profile;
    }

    /**
     * Profile allows requesting a certificate profile from the ACME server. Supported profiles are listed by the server's ACME directory URL.
     */
    @JsonProperty("profile")
    public void setProfile(String profile) {
        this.profile = profile;
    }

    /**
     * Server is the URL used to access the ACME server's 'directory' endpoint. For example, for Let's Encrypt's staging endpoint, you would use: "https://acme-staging-v02.api.letsencrypt.org/directory". Only ACME v2 endpoints (i.e. RFC 8555) are supported.
     */
    @JsonProperty("server")
    public String getServer() {
        return server;
    }

    /**
     * Server is the URL used to access the ACME server's 'directory' endpoint. For example, for Let's Encrypt's staging endpoint, you would use: "https://acme-staging-v02.api.letsencrypt.org/directory". Only ACME v2 endpoints (i.e. RFC 8555) are supported.
     */
    @JsonProperty("server")
    public void setServer(String server) {
        this.server = server;
    }

    /**
     * INSECURE: Enables or disables validation of the ACME server TLS certificate. If true, requests to the ACME server will not have the TLS certificate chain validated. Mutually exclusive with CABundle; prefer using CABundle to prevent various kinds of security vulnerabilities. Only enable this option in development environments. If CABundle and SkipTLSVerify are unset, the system certificate bundle inside the container is used to validate the TLS connection. Defaults to false.
     */
    @JsonProperty("skipTLSVerify")
    public Boolean getSkipTLSVerify() {
        return skipTLSVerify;
    }

    /**
     * INSECURE: Enables or disables validation of the ACME server TLS certificate. If true, requests to the ACME server will not have the TLS certificate chain validated. Mutually exclusive with CABundle; prefer using CABundle to prevent various kinds of security vulnerabilities. Only enable this option in development environments. If CABundle and SkipTLSVerify are unset, the system certificate bundle inside the container is used to validate the TLS connection. Defaults to false.
     */
    @JsonProperty("skipTLSVerify")
    public void setSkipTLSVerify(Boolean skipTLSVerify) {
        this.skipTLSVerify = skipTLSVerify;
    }

    /**
     * Solvers is a list of challenge solvers that will be used to solve ACME challenges for the matching domains. Solver configurations must be provided in order to obtain certificates from an ACME server. For more information, see: https://cert-manager.io/docs/configuration/acme/
     */
    @JsonProperty("solvers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ACMEChallengeSolver> getSolvers() {
        return solvers;
    }

    /**
     * Solvers is a list of challenge solvers that will be used to solve ACME challenges for the matching domains. Solver configurations must be provided in order to obtain certificates from an ACME server. For more information, see: https://cert-manager.io/docs/configuration/acme/
     */
    @JsonProperty("solvers")
    public void setSolvers(List<ACMEChallengeSolver> solvers) {
        this.solvers = solvers;
    }

    @JsonIgnore
    public ACMEIssuerBuilder edit() {
        return new ACMEIssuerBuilder(this);
    }

    @JsonIgnore
    public ACMEIssuerBuilder toBuilder() {
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
