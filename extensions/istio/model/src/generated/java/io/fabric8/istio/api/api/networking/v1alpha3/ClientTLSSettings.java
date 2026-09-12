
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

/**
 * SSL/TLS related settings for upstream connections. See Envoy's [TLS context](https://www.envoyproxy.io/docs/envoy/latest/api-v3/extensions/transport_sockets/tls/v3/common.proto.html#common-tls-configuration) for more details. These settings are common to both HTTP and TCP upstreams.<br><p> <br><p> For example, the following rule configures a client to use mutual TLS for connections to upstream database cluster.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: db-mtls<br><p> <br><p> spec:<br><p> <br><p> 	host: mydbserver.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  tls:<br><p> 	    mode: MUTUAL<br><p> 	    clientCertificate: /etc/certs/myclientcert.pem<br><p> 	    privateKey: /etc/certs/client_private_key.pem<br><p> 	    caCertificates: /etc/certs/rootcacerts.pem<br><p> <br><p> ```<br><p> <br><p> The following rule configures a client to use TLS when talking to a foreign service whose domain matches &#42;.foo.com.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: tls-foo<br><p> <br><p> spec:<br><p> <br><p> 	host: "&#42;.foo.com"<br><p> 	trafficPolicy:<br><p> 	  tls:<br><p> 	    mode: SIMPLE<br><p> <br><p> ```<br><p> <br><p> The following rule configures a client to use Istio mutual TLS when talking to rating services.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: ratings-istio-mtls<br><p> <br><p> spec:<br><p> <br><p> 	host: ratings.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  tls:<br><p> 	    mode: ISTIO_MUTUAL<br><p> <br><p> ```
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "caCertificates",
    "caCrl",
    "clientCertificate",
    "credentialName",
    "insecureSkipVerify",
    "mode",
    "privateKey",
    "sni",
    "subjectAltNames"
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
public class ClientTLSSettings implements Editable<ClientTLSSettingsBuilder>, KubernetesResource
{

    @JsonProperty("caCertificates")
    private String caCertificates;
    @JsonProperty("caCrl")
    private String caCrl;
    @JsonProperty("clientCertificate")
    private String clientCertificate;
    @JsonProperty("credentialName")
    private String credentialName;
    @JsonProperty("insecureSkipVerify")
    private Boolean insecureSkipVerify;
    @JsonProperty("mode")
    private ClientTLSSettingsTLSmode mode;
    @JsonProperty("privateKey")
    private String privateKey;
    @JsonProperty("sni")
    private String sni;
    @JsonProperty("subjectAltNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> subjectAltNames = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClientTLSSettings() {
    }

    public ClientTLSSettings(String caCertificates, String caCrl, String clientCertificate, String credentialName, Boolean insecureSkipVerify, ClientTLSSettingsTLSmode mode, String privateKey, String sni, List<String> subjectAltNames) {
        super();
        this.caCertificates = caCertificates;
        this.caCrl = caCrl;
        this.clientCertificate = clientCertificate;
        this.credentialName = credentialName;
        this.insecureSkipVerify = insecureSkipVerify;
        this.mode = mode;
        this.privateKey = privateKey;
        this.sni = sni;
        this.subjectAltNames = subjectAltNames;
    }

    /**
     * OPTIONAL: The path to the file containing certificate authority certificates to use in verifying a presented server certificate. If omitted, the proxy will verify the server's certificate using the OS CA certificates. Should be empty if mode is `ISTIO_MUTUAL`.
     */
    @JsonProperty("caCertificates")
    public String getCaCertificates() {
        return caCertificates;
    }

    /**
     * OPTIONAL: The path to the file containing certificate authority certificates to use in verifying a presented server certificate. If omitted, the proxy will verify the server's certificate using the OS CA certificates. Should be empty if mode is `ISTIO_MUTUAL`.
     */
    @JsonProperty("caCertificates")
    public void setCaCertificates(String caCertificates) {
        this.caCertificates = caCertificates;
    }

    /**
     * OPTIONAL: The path to the file containing the certificate revocation list (CRL) to use in verifying a presented server certificate. `CRL` is a list of certificates that have been revoked by the CA (Certificate Authority) before their scheduled expiration date. If specified, the proxy will verify if the presented certificate is part of the revoked list of certificates. If omitted, the proxy will not verify the certificate against the `crl`. Note that if `credentialName` is set, `CRL` cannot be specified using `caCrl`, rather it has to be specified inside the credential.
     */
    @JsonProperty("caCrl")
    public String getCaCrl() {
        return caCrl;
    }

    /**
     * OPTIONAL: The path to the file containing the certificate revocation list (CRL) to use in verifying a presented server certificate. `CRL` is a list of certificates that have been revoked by the CA (Certificate Authority) before their scheduled expiration date. If specified, the proxy will verify if the presented certificate is part of the revoked list of certificates. If omitted, the proxy will not verify the certificate against the `crl`. Note that if `credentialName` is set, `CRL` cannot be specified using `caCrl`, rather it has to be specified inside the credential.
     */
    @JsonProperty("caCrl")
    public void setCaCrl(String caCrl) {
        this.caCrl = caCrl;
    }

    /**
     * REQUIRED if mode is `MUTUAL`. The path to the file holding the client-side TLS certificate to use. Should be empty if mode is `ISTIO_MUTUAL`.
     */
    @JsonProperty("clientCertificate")
    public String getClientCertificate() {
        return clientCertificate;
    }

    /**
     * REQUIRED if mode is `MUTUAL`. The path to the file holding the client-side TLS certificate to use. Should be empty if mode is `ISTIO_MUTUAL`.
     */
    @JsonProperty("clientCertificate")
    public void setClientCertificate(String clientCertificate) {
        this.clientCertificate = clientCertificate;
    }

    /**
     * The name of the secret that holds the TLS certs for the client including the CA certificates. This secret must exist in the namespace of the proxy using the certificates. An Opaque secret should contain the following keys and values: `key: &lt;privateKey&gt;`, `cert: &lt;clientCert&gt;`, `cacert: &lt;CACertificate&gt;`, `crl: &lt;certificateRevocationList&gt;` Here CACertificate is used to verify the server certificate. For mutual TLS, `cacert: &lt;CACertificate&gt;` can be provided in the same secret or a separate secret named `&lt;secret&gt;-cacert`. A TLS secret for client certificates with an additional `ca.crt` key for CA certificates and `ca.crl` key for certificate revocation list(CRL) is also supported. Only one of client certificates and CA certificate or credentialName can be specified.<br><p> <br><p> &#42;&#42;NOTE:&#42;&#42; This field is applicable at sidecars only if `DestinationRule` has a `workloadSelector` specified. Otherwise the field will be applicable only at gateways, and sidecars will continue to use the certificate paths.
     */
    @JsonProperty("credentialName")
    public String getCredentialName() {
        return credentialName;
    }

    /**
     * The name of the secret that holds the TLS certs for the client including the CA certificates. This secret must exist in the namespace of the proxy using the certificates. An Opaque secret should contain the following keys and values: `key: &lt;privateKey&gt;`, `cert: &lt;clientCert&gt;`, `cacert: &lt;CACertificate&gt;`, `crl: &lt;certificateRevocationList&gt;` Here CACertificate is used to verify the server certificate. For mutual TLS, `cacert: &lt;CACertificate&gt;` can be provided in the same secret or a separate secret named `&lt;secret&gt;-cacert`. A TLS secret for client certificates with an additional `ca.crt` key for CA certificates and `ca.crl` key for certificate revocation list(CRL) is also supported. Only one of client certificates and CA certificate or credentialName can be specified.<br><p> <br><p> &#42;&#42;NOTE:&#42;&#42; This field is applicable at sidecars only if `DestinationRule` has a `workloadSelector` specified. Otherwise the field will be applicable only at gateways, and sidecars will continue to use the certificate paths.
     */
    @JsonProperty("credentialName")
    public void setCredentialName(String credentialName) {
        this.credentialName = credentialName;
    }

    /**
     * SSL/TLS related settings for upstream connections. See Envoy's [TLS context](https://www.envoyproxy.io/docs/envoy/latest/api-v3/extensions/transport_sockets/tls/v3/common.proto.html#common-tls-configuration) for more details. These settings are common to both HTTP and TCP upstreams.<br><p> <br><p> For example, the following rule configures a client to use mutual TLS for connections to upstream database cluster.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: db-mtls<br><p> <br><p> spec:<br><p> <br><p> 	host: mydbserver.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  tls:<br><p> 	    mode: MUTUAL<br><p> 	    clientCertificate: /etc/certs/myclientcert.pem<br><p> 	    privateKey: /etc/certs/client_private_key.pem<br><p> 	    caCertificates: /etc/certs/rootcacerts.pem<br><p> <br><p> ```<br><p> <br><p> The following rule configures a client to use TLS when talking to a foreign service whose domain matches &#42;.foo.com.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: tls-foo<br><p> <br><p> spec:<br><p> <br><p> 	host: "&#42;.foo.com"<br><p> 	trafficPolicy:<br><p> 	  tls:<br><p> 	    mode: SIMPLE<br><p> <br><p> ```<br><p> <br><p> The following rule configures a client to use Istio mutual TLS when talking to rating services.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: ratings-istio-mtls<br><p> <br><p> spec:<br><p> <br><p> 	host: ratings.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  tls:<br><p> 	    mode: ISTIO_MUTUAL<br><p> <br><p> ```
     */
    @JsonProperty("insecureSkipVerify")
    public Boolean getInsecureSkipVerify() {
        return insecureSkipVerify;
    }

    /**
     * SSL/TLS related settings for upstream connections. See Envoy's [TLS context](https://www.envoyproxy.io/docs/envoy/latest/api-v3/extensions/transport_sockets/tls/v3/common.proto.html#common-tls-configuration) for more details. These settings are common to both HTTP and TCP upstreams.<br><p> <br><p> For example, the following rule configures a client to use mutual TLS for connections to upstream database cluster.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: db-mtls<br><p> <br><p> spec:<br><p> <br><p> 	host: mydbserver.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  tls:<br><p> 	    mode: MUTUAL<br><p> 	    clientCertificate: /etc/certs/myclientcert.pem<br><p> 	    privateKey: /etc/certs/client_private_key.pem<br><p> 	    caCertificates: /etc/certs/rootcacerts.pem<br><p> <br><p> ```<br><p> <br><p> The following rule configures a client to use TLS when talking to a foreign service whose domain matches &#42;.foo.com.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: tls-foo<br><p> <br><p> spec:<br><p> <br><p> 	host: "&#42;.foo.com"<br><p> 	trafficPolicy:<br><p> 	  tls:<br><p> 	    mode: SIMPLE<br><p> <br><p> ```<br><p> <br><p> The following rule configures a client to use Istio mutual TLS when talking to rating services.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: ratings-istio-mtls<br><p> <br><p> spec:<br><p> <br><p> 	host: ratings.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  tls:<br><p> 	    mode: ISTIO_MUTUAL<br><p> <br><p> ```
     */
    @JsonProperty("insecureSkipVerify")
    public void setInsecureSkipVerify(Boolean insecureSkipVerify) {
        this.insecureSkipVerify = insecureSkipVerify;
    }

    /**
     * SSL/TLS related settings for upstream connections. See Envoy's [TLS context](https://www.envoyproxy.io/docs/envoy/latest/api-v3/extensions/transport_sockets/tls/v3/common.proto.html#common-tls-configuration) for more details. These settings are common to both HTTP and TCP upstreams.<br><p> <br><p> For example, the following rule configures a client to use mutual TLS for connections to upstream database cluster.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: db-mtls<br><p> <br><p> spec:<br><p> <br><p> 	host: mydbserver.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  tls:<br><p> 	    mode: MUTUAL<br><p> 	    clientCertificate: /etc/certs/myclientcert.pem<br><p> 	    privateKey: /etc/certs/client_private_key.pem<br><p> 	    caCertificates: /etc/certs/rootcacerts.pem<br><p> <br><p> ```<br><p> <br><p> The following rule configures a client to use TLS when talking to a foreign service whose domain matches &#42;.foo.com.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: tls-foo<br><p> <br><p> spec:<br><p> <br><p> 	host: "&#42;.foo.com"<br><p> 	trafficPolicy:<br><p> 	  tls:<br><p> 	    mode: SIMPLE<br><p> <br><p> ```<br><p> <br><p> The following rule configures a client to use Istio mutual TLS when talking to rating services.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: ratings-istio-mtls<br><p> <br><p> spec:<br><p> <br><p> 	host: ratings.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  tls:<br><p> 	    mode: ISTIO_MUTUAL<br><p> <br><p> ```
     */
    @JsonProperty("mode")
    public ClientTLSSettingsTLSmode getMode() {
        return mode;
    }

    /**
     * SSL/TLS related settings for upstream connections. See Envoy's [TLS context](https://www.envoyproxy.io/docs/envoy/latest/api-v3/extensions/transport_sockets/tls/v3/common.proto.html#common-tls-configuration) for more details. These settings are common to both HTTP and TCP upstreams.<br><p> <br><p> For example, the following rule configures a client to use mutual TLS for connections to upstream database cluster.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: db-mtls<br><p> <br><p> spec:<br><p> <br><p> 	host: mydbserver.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  tls:<br><p> 	    mode: MUTUAL<br><p> 	    clientCertificate: /etc/certs/myclientcert.pem<br><p> 	    privateKey: /etc/certs/client_private_key.pem<br><p> 	    caCertificates: /etc/certs/rootcacerts.pem<br><p> <br><p> ```<br><p> <br><p> The following rule configures a client to use TLS when talking to a foreign service whose domain matches &#42;.foo.com.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: tls-foo<br><p> <br><p> spec:<br><p> <br><p> 	host: "&#42;.foo.com"<br><p> 	trafficPolicy:<br><p> 	  tls:<br><p> 	    mode: SIMPLE<br><p> <br><p> ```<br><p> <br><p> The following rule configures a client to use Istio mutual TLS when talking to rating services.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: ratings-istio-mtls<br><p> <br><p> spec:<br><p> <br><p> 	host: ratings.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  tls:<br><p> 	    mode: ISTIO_MUTUAL<br><p> <br><p> ```
     */
    @JsonProperty("mode")
    public void setMode(ClientTLSSettingsTLSmode mode) {
        this.mode = mode;
    }

    /**
     * REQUIRED if mode is `MUTUAL`. The path to the file holding the client's private key. Should be empty if mode is `ISTIO_MUTUAL`.
     */
    @JsonProperty("privateKey")
    public String getPrivateKey() {
        return privateKey;
    }

    /**
     * REQUIRED if mode is `MUTUAL`. The path to the file holding the client's private key. Should be empty if mode is `ISTIO_MUTUAL`.
     */
    @JsonProperty("privateKey")
    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    /**
     * SNI string to present to the server during TLS handshake. If unspecified, SNI will be automatically set based on downstream HTTP host/authority header for SIMPLE and MUTUAL TLS modes.
     */
    @JsonProperty("sni")
    public String getSni() {
        return sni;
    }

    /**
     * SNI string to present to the server during TLS handshake. If unspecified, SNI will be automatically set based on downstream HTTP host/authority header for SIMPLE and MUTUAL TLS modes.
     */
    @JsonProperty("sni")
    public void setSni(String sni) {
        this.sni = sni;
    }

    /**
     * A list of alternate names to verify the subject identity in the certificate. If specified, the proxy will verify that the server certificate's subject alt name matches one of the specified values. If specified, this list overrides the value of `subjectAltNames` from the `ServiceEntry`. If unspecified, automatic validation of upstream presented certificate for new upstream connections will be done based on the downstream HTTP host/authority header.
     */
    @JsonProperty("subjectAltNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getSubjectAltNames() {
        return subjectAltNames;
    }

    /**
     * A list of alternate names to verify the subject identity in the certificate. If specified, the proxy will verify that the server certificate's subject alt name matches one of the specified values. If specified, this list overrides the value of `subjectAltNames` from the `ServiceEntry`. If unspecified, automatic validation of upstream presented certificate for new upstream connections will be done based on the downstream HTTP host/authority header.
     */
    @JsonProperty("subjectAltNames")
    public void setSubjectAltNames(List<String> subjectAltNames) {
        this.subjectAltNames = subjectAltNames;
    }

    @JsonIgnore
    public ClientTLSSettingsBuilder edit() {
        return new ClientTLSSettingsBuilder(this);
    }

    @JsonIgnore
    public ClientTLSSettingsBuilder toBuilder() {
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
        if (!(o instanceof ClientTLSSettings)) {
            return false;
        }
        ClientTLSSettings other = (ClientTLSSettings) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$caCertificates = this.getCaCertificates();
        Object other$caCertificates = other.getCaCertificates();
        if (this$caCertificates == null ? other$caCertificates != null : !this$caCertificates.equals(other$caCertificates)) {
            return false;
        }
        Object this$caCrl = this.getCaCrl();
        Object other$caCrl = other.getCaCrl();
        if (this$caCrl == null ? other$caCrl != null : !this$caCrl.equals(other$caCrl)) {
            return false;
        }
        Object this$clientCertificate = this.getClientCertificate();
        Object other$clientCertificate = other.getClientCertificate();
        if (this$clientCertificate == null ? other$clientCertificate != null : !this$clientCertificate.equals(other$clientCertificate)) {
            return false;
        }
        Object this$credentialName = this.getCredentialName();
        Object other$credentialName = other.getCredentialName();
        if (this$credentialName == null ? other$credentialName != null : !this$credentialName.equals(other$credentialName)) {
            return false;
        }
        Object this$insecureSkipVerify = this.getInsecureSkipVerify();
        Object other$insecureSkipVerify = other.getInsecureSkipVerify();
        if (this$insecureSkipVerify == null ? other$insecureSkipVerify != null : !this$insecureSkipVerify.equals(other$insecureSkipVerify)) {
            return false;
        }
        Object this$mode = this.getMode();
        Object other$mode = other.getMode();
        if (this$mode == null ? other$mode != null : !this$mode.equals(other$mode)) {
            return false;
        }
        Object this$privateKey = this.getPrivateKey();
        Object other$privateKey = other.getPrivateKey();
        if (this$privateKey == null ? other$privateKey != null : !this$privateKey.equals(other$privateKey)) {
            return false;
        }
        Object this$sni = this.getSni();
        Object other$sni = other.getSni();
        if (this$sni == null ? other$sni != null : !this$sni.equals(other$sni)) {
            return false;
        }
        Object this$subjectAltNames = this.getSubjectAltNames();
        Object other$subjectAltNames = other.getSubjectAltNames();
        if (this$subjectAltNames == null ? other$subjectAltNames != null : !this$subjectAltNames.equals(other$subjectAltNames)) {
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
        return other instanceof ClientTLSSettings;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $caCertificates = this.getCaCertificates();
        result = result * prime + ($caCertificates == null ? 43 : $caCertificates.hashCode());
        Object $caCrl = this.getCaCrl();
        result = result * prime + ($caCrl == null ? 43 : $caCrl.hashCode());
        Object $clientCertificate = this.getClientCertificate();
        result = result * prime + ($clientCertificate == null ? 43 : $clientCertificate.hashCode());
        Object $credentialName = this.getCredentialName();
        result = result * prime + ($credentialName == null ? 43 : $credentialName.hashCode());
        Object $insecureSkipVerify = this.getInsecureSkipVerify();
        result = result * prime + ($insecureSkipVerify == null ? 43 : $insecureSkipVerify.hashCode());
        Object $mode = this.getMode();
        result = result * prime + ($mode == null ? 43 : $mode.hashCode());
        Object $privateKey = this.getPrivateKey();
        result = result * prime + ($privateKey == null ? 43 : $privateKey.hashCode());
        Object $sni = this.getSni();
        result = result * prime + ($sni == null ? 43 : $sni.hashCode());
        Object $subjectAltNames = this.getSubjectAltNames();
        result = result * prime + ($subjectAltNames == null ? 43 : $subjectAltNames.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ClientTLSSettings(" + "caCertificates=" + this.getCaCertificates() + ", caCrl=" + this.getCaCrl() + ", clientCertificate=" + this.getClientCertificate() + ", credentialName=" + this.getCredentialName() + ", insecureSkipVerify=" + this.getInsecureSkipVerify() + ", mode=" + this.getMode() + ", privateKey=" + this.getPrivateKey() + ", sni=" + this.getSni() + ", subjectAltNames=" + this.getSubjectAltNames() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
