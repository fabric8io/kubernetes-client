
package io.fabric8.istio.api.api.networking.v1alpha3;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "caCertCredentialName",
    "caCertificates",
    "caCrl",
    "cipherSuites",
    "credentialName",
    "credentialNames",
    "httpsRedirect",
    "maxProtocolVersion",
    "minProtocolVersion",
    "mode",
    "privateKey",
    "serverCertificate",
    "subjectAltNames",
    "tlsCertificates",
    "verifyCertificateHash",
    "verifyCertificateSpki"
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
public class ServerTLSSettings implements Editable<ServerTLSSettingsBuilder>, KubernetesResource
{

    @JsonProperty("caCertCredentialName")
    private String caCertCredentialName;
    @JsonProperty("caCertificates")
    private String caCertificates;
    @JsonProperty("caCrl")
    private String caCrl;
    @JsonProperty("cipherSuites")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> cipherSuites = new ArrayList<>();
    @JsonProperty("credentialName")
    private String credentialName;
    @JsonProperty("credentialNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> credentialNames = new ArrayList<>();
    @JsonProperty("httpsRedirect")
    private Boolean httpsRedirect;
    @JsonProperty("maxProtocolVersion")
    private ServerTLSSettingsTLSProtocol maxProtocolVersion;
    @JsonProperty("minProtocolVersion")
    private ServerTLSSettingsTLSProtocol minProtocolVersion;
    @JsonProperty("mode")
    private ServerTLSSettingsTLSmode mode;
    @JsonProperty("privateKey")
    private String privateKey;
    @JsonProperty("serverCertificate")
    private String serverCertificate;
    @JsonProperty("subjectAltNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> subjectAltNames = new ArrayList<>();
    @JsonProperty("tlsCertificates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ServerTLSSettingsTLSCertificate> tlsCertificates = new ArrayList<>();
    @JsonProperty("verifyCertificateHash")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> verifyCertificateHash = new ArrayList<>();
    @JsonProperty("verifyCertificateSpki")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> verifyCertificateSpki = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ServerTLSSettings() {
    }

    public ServerTLSSettings(String caCertCredentialName, String caCertificates, String caCrl, List<String> cipherSuites, String credentialName, List<String> credentialNames, Boolean httpsRedirect, ServerTLSSettingsTLSProtocol maxProtocolVersion, ServerTLSSettingsTLSProtocol minProtocolVersion, ServerTLSSettingsTLSmode mode, String privateKey, String serverCertificate, List<String> subjectAltNames, List<ServerTLSSettingsTLSCertificate> tlsCertificates, List<String> verifyCertificateHash, List<String> verifyCertificateSpki) {
        super();
        this.caCertCredentialName = caCertCredentialName;
        this.caCertificates = caCertificates;
        this.caCrl = caCrl;
        this.cipherSuites = cipherSuites;
        this.credentialName = credentialName;
        this.credentialNames = credentialNames;
        this.httpsRedirect = httpsRedirect;
        this.maxProtocolVersion = maxProtocolVersion;
        this.minProtocolVersion = minProtocolVersion;
        this.mode = mode;
        this.privateKey = privateKey;
        this.serverCertificate = serverCertificate;
        this.subjectAltNames = subjectAltNames;
        this.tlsCertificates = tlsCertificates;
        this.verifyCertificateHash = verifyCertificateHash;
        this.verifyCertificateSpki = verifyCertificateSpki;
    }

    /**
     * For mutual TLS, the name of the secret or the configmap that holds CA certificates. Takes precedence over CA certificates in the Secret referenced with `credentialName(s)`.
     */
    @JsonProperty("caCertCredentialName")
    public String getCaCertCredentialName() {
        return caCertCredentialName;
    }

    /**
     * For mutual TLS, the name of the secret or the configmap that holds CA certificates. Takes precedence over CA certificates in the Secret referenced with `credentialName(s)`.
     */
    @JsonProperty("caCertCredentialName")
    public void setCaCertCredentialName(String caCertCredentialName) {
        this.caCertCredentialName = caCertCredentialName;
    }

    /**
     * REQUIRED if mode is `MUTUAL` or `OPTIONAL_MUTUAL`. The path to a file containing certificate authority certificates to use in verifying a presented client side certificate.
     */
    @JsonProperty("caCertificates")
    public String getCaCertificates() {
        return caCertificates;
    }

    /**
     * REQUIRED if mode is `MUTUAL` or `OPTIONAL_MUTUAL`. The path to a file containing certificate authority certificates to use in verifying a presented client side certificate.
     */
    @JsonProperty("caCertificates")
    public void setCaCertificates(String caCertificates) {
        this.caCertificates = caCertificates;
    }

    /**
     * OPTIONAL: The path to the file containing the certificate revocation list (CRL) to use in verifying a presented client side certificate. `CRL` is a list of certificates that have been revoked by the CA (Certificate Authority) before their scheduled expiration date. If specified, the proxy will verify if the presented certificate is part of the revoked list of certificates. If omitted, the proxy will not verify the certificate against the `crl`.
     */
    @JsonProperty("caCrl")
    public String getCaCrl() {
        return caCrl;
    }

    /**
     * OPTIONAL: The path to the file containing the certificate revocation list (CRL) to use in verifying a presented client side certificate. `CRL` is a list of certificates that have been revoked by the CA (Certificate Authority) before their scheduled expiration date. If specified, the proxy will verify if the presented certificate is part of the revoked list of certificates. If omitted, the proxy will not verify the certificate against the `crl`.
     */
    @JsonProperty("caCrl")
    public void setCaCrl(String caCrl) {
        this.caCrl = caCrl;
    }

    /**
     * Optional: If specified, only support the specified cipher list. Otherwise default to the default cipher list supported by Envoy as specified [here](https://www.envoyproxy.io/docs/envoy/latest/api-v3/extensions/transport_sockets/tls/v3/common.proto). The supported list of ciphers are: &#42; `ECDHE-ECDSA-AES128-GCM-SHA256` &#42; `ECDHE-RSA-AES128-GCM-SHA256` &#42; `ECDHE-ECDSA-AES256-GCM-SHA384` &#42; `ECDHE-RSA-AES256-GCM-SHA384` &#42; `ECDHE-ECDSA-CHACHA20-POLY1305` &#42; `ECDHE-RSA-CHACHA20-POLY1305` &#42; `ECDHE-ECDSA-AES128-SHA` &#42; `ECDHE-RSA-AES128-SHA` &#42; `ECDHE-ECDSA-AES256-SHA` &#42; `ECDHE-RSA-AES256-SHA` &#42; `AES128-GCM-SHA256` &#42; `AES256-GCM-SHA384` &#42; `AES128-SHA` &#42; `AES256-SHA` &#42; `DES-CBC3-SHA`
     */
    @JsonProperty("cipherSuites")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getCipherSuites() {
        return cipherSuites;
    }

    /**
     * Optional: If specified, only support the specified cipher list. Otherwise default to the default cipher list supported by Envoy as specified [here](https://www.envoyproxy.io/docs/envoy/latest/api-v3/extensions/transport_sockets/tls/v3/common.proto). The supported list of ciphers are: &#42; `ECDHE-ECDSA-AES128-GCM-SHA256` &#42; `ECDHE-RSA-AES128-GCM-SHA256` &#42; `ECDHE-ECDSA-AES256-GCM-SHA384` &#42; `ECDHE-RSA-AES256-GCM-SHA384` &#42; `ECDHE-ECDSA-CHACHA20-POLY1305` &#42; `ECDHE-RSA-CHACHA20-POLY1305` &#42; `ECDHE-ECDSA-AES128-SHA` &#42; `ECDHE-RSA-AES128-SHA` &#42; `ECDHE-ECDSA-AES256-SHA` &#42; `ECDHE-RSA-AES256-SHA` &#42; `AES128-GCM-SHA256` &#42; `AES256-GCM-SHA384` &#42; `AES128-SHA` &#42; `AES256-SHA` &#42; `DES-CBC3-SHA`
     */
    @JsonProperty("cipherSuites")
    public void setCipherSuites(List<String> cipherSuites) {
        this.cipherSuites = cipherSuites;
    }

    /**
     * For gateways running on Kubernetes, the name of the secret that holds the TLS certs including the CA certificates. Applicable only on Kubernetes. An Opaque secret should contain the following keys and values: `tls.key: &lt;privateKey&gt;` and `tls.crt: &lt;serverCert&gt;` or `key: &lt;privateKey&gt;` and `cert: &lt;serverCert&gt;`. For mutual TLS, `cacert: &lt;CACertificate&gt;` and `crl: &lt;CertificateRevocationList&gt;` can be provided in the same secret or a separate secret named `&lt;secret&gt;-cacert`. A TLS secret for server certificates with an additional `tls.ocsp-staple` key for specifying OCSP staple information, `ca.crt` key for CA certificates and `ca.crl` for certificate revocation list is also supported. Only one of server certificates and CA certificate or credentialName can be specified.
     */
    @JsonProperty("credentialName")
    public String getCredentialName() {
        return credentialName;
    }

    /**
     * For gateways running on Kubernetes, the name of the secret that holds the TLS certs including the CA certificates. Applicable only on Kubernetes. An Opaque secret should contain the following keys and values: `tls.key: &lt;privateKey&gt;` and `tls.crt: &lt;serverCert&gt;` or `key: &lt;privateKey&gt;` and `cert: &lt;serverCert&gt;`. For mutual TLS, `cacert: &lt;CACertificate&gt;` and `crl: &lt;CertificateRevocationList&gt;` can be provided in the same secret or a separate secret named `&lt;secret&gt;-cacert`. A TLS secret for server certificates with an additional `tls.ocsp-staple` key for specifying OCSP staple information, `ca.crt` key for CA certificates and `ca.crl` for certificate revocation list is also supported. Only one of server certificates and CA certificate or credentialName can be specified.
     */
    @JsonProperty("credentialName")
    public void setCredentialName(String credentialName) {
        this.credentialName = credentialName;
    }

    /**
     * Same as CredentialName but for multiple certificates. Mainly used for specifying RSA and ECDSA certificates for the same server.
     */
    @JsonProperty("credentialNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getCredentialNames() {
        return credentialNames;
    }

    /**
     * Same as CredentialName but for multiple certificates. Mainly used for specifying RSA and ECDSA certificates for the same server.
     */
    @JsonProperty("credentialNames")
    public void setCredentialNames(List<String> credentialNames) {
        this.credentialNames = credentialNames;
    }

    /**
     * If set to true, the load balancer will send a 301 redirect for all http connections, asking the clients to use HTTPS.
     */
    @JsonProperty("httpsRedirect")
    public Boolean getHttpsRedirect() {
        return httpsRedirect;
    }

    /**
     * If set to true, the load balancer will send a 301 redirect for all http connections, asking the clients to use HTTPS.
     */
    @JsonProperty("httpsRedirect")
    public void setHttpsRedirect(Boolean httpsRedirect) {
        this.httpsRedirect = httpsRedirect;
    }

    @JsonProperty("maxProtocolVersion")
    public ServerTLSSettingsTLSProtocol getMaxProtocolVersion() {
        return maxProtocolVersion;
    }

    @JsonProperty("maxProtocolVersion")
    public void setMaxProtocolVersion(ServerTLSSettingsTLSProtocol maxProtocolVersion) {
        this.maxProtocolVersion = maxProtocolVersion;
    }

    @JsonProperty("minProtocolVersion")
    public ServerTLSSettingsTLSProtocol getMinProtocolVersion() {
        return minProtocolVersion;
    }

    @JsonProperty("minProtocolVersion")
    public void setMinProtocolVersion(ServerTLSSettingsTLSProtocol minProtocolVersion) {
        this.minProtocolVersion = minProtocolVersion;
    }

    @JsonProperty("mode")
    public ServerTLSSettingsTLSmode getMode() {
        return mode;
    }

    @JsonProperty("mode")
    public void setMode(ServerTLSSettingsTLSmode mode) {
        this.mode = mode;
    }

    /**
     * REQUIRED if mode is `SIMPLE` or `MUTUAL`. The path to the file holding the server's private key.
     */
    @JsonProperty("privateKey")
    public String getPrivateKey() {
        return privateKey;
    }

    /**
     * REQUIRED if mode is `SIMPLE` or `MUTUAL`. The path to the file holding the server's private key.
     */
    @JsonProperty("privateKey")
    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    /**
     * REQUIRED if mode is `SIMPLE` or `MUTUAL`. The path to the file holding the server-side TLS certificate to use.
     */
    @JsonProperty("serverCertificate")
    public String getServerCertificate() {
        return serverCertificate;
    }

    /**
     * REQUIRED if mode is `SIMPLE` or `MUTUAL`. The path to the file holding the server-side TLS certificate to use.
     */
    @JsonProperty("serverCertificate")
    public void setServerCertificate(String serverCertificate) {
        this.serverCertificate = serverCertificate;
    }

    /**
     * A list of alternate names to verify the subject identity in the certificate presented by the client. Requires TLS mode to be set to `MUTUAL`. When multiple certificates are provided via `credential_names` or `tls_certificates`, the subject alternate names are validated against the selected certificate.
     */
    @JsonProperty("subjectAltNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getSubjectAltNames() {
        return subjectAltNames;
    }

    /**
     * A list of alternate names to verify the subject identity in the certificate presented by the client. Requires TLS mode to be set to `MUTUAL`. When multiple certificates are provided via `credential_names` or `tls_certificates`, the subject alternate names are validated against the selected certificate.
     */
    @JsonProperty("subjectAltNames")
    public void setSubjectAltNames(List<String> subjectAltNames) {
        this.subjectAltNames = subjectAltNames;
    }

    /**
     * Only one of `server_certificate`, `private_key` or `credential_name` or `credential_names` or `tls_certificates` should be specified. This is mainly used for specifying RSA and ECDSA certificates for the same server.
     */
    @JsonProperty("tlsCertificates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ServerTLSSettingsTLSCertificate> getTlsCertificates() {
        return tlsCertificates;
    }

    /**
     * Only one of `server_certificate`, `private_key` or `credential_name` or `credential_names` or `tls_certificates` should be specified. This is mainly used for specifying RSA and ECDSA certificates for the same server.
     */
    @JsonProperty("tlsCertificates")
    public void setTlsCertificates(List<ServerTLSSettingsTLSCertificate> tlsCertificates) {
        this.tlsCertificates = tlsCertificates;
    }

    /**
     * An optional list of hex-encoded SHA-256 hashes of the authorized client certificates. Both simple and colon separated formats are acceptable. Note: When both verify_certificate_hash and verify_certificate_spki are specified, a hash matching either value will result in the certificate being accepted.
     */
    @JsonProperty("verifyCertificateHash")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getVerifyCertificateHash() {
        return verifyCertificateHash;
    }

    /**
     * An optional list of hex-encoded SHA-256 hashes of the authorized client certificates. Both simple and colon separated formats are acceptable. Note: When both verify_certificate_hash and verify_certificate_spki are specified, a hash matching either value will result in the certificate being accepted.
     */
    @JsonProperty("verifyCertificateHash")
    public void setVerifyCertificateHash(List<String> verifyCertificateHash) {
        this.verifyCertificateHash = verifyCertificateHash;
    }

    /**
     * An optional list of base64-encoded SHA-256 hashes of the SPKIs of authorized client certificates. Note: When both verify_certificate_hash and verify_certificate_spki are specified, a hash matching either value will result in the certificate being accepted.
     */
    @JsonProperty("verifyCertificateSpki")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getVerifyCertificateSpki() {
        return verifyCertificateSpki;
    }

    /**
     * An optional list of base64-encoded SHA-256 hashes of the SPKIs of authorized client certificates. Note: When both verify_certificate_hash and verify_certificate_spki are specified, a hash matching either value will result in the certificate being accepted.
     */
    @JsonProperty("verifyCertificateSpki")
    public void setVerifyCertificateSpki(List<String> verifyCertificateSpki) {
        this.verifyCertificateSpki = verifyCertificateSpki;
    }

    @JsonIgnore
    public ServerTLSSettingsBuilder edit() {
        return new ServerTLSSettingsBuilder(this);
    }

    @JsonIgnore
    public ServerTLSSettingsBuilder toBuilder() {
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
