
package io.fabric8.certmanager.api.model.v1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
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
 * Configures an issuer to sign certificates using a HashiCorp Vault PKI backend.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "auth",
    "caBundle",
    "caBundleSecretRef",
    "clientCertSecretRef",
    "clientKeySecretRef",
    "namespace",
    "path",
    "server"
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
public class VaultIssuer implements Editable<VaultIssuerBuilder>, KubernetesResource
{

    @JsonProperty("auth")
    private VaultAuth auth;
    @JsonProperty("caBundle")
    private String caBundle;
    @JsonProperty("caBundleSecretRef")
    private SecretKeySelector caBundleSecretRef;
    @JsonProperty("clientCertSecretRef")
    private SecretKeySelector clientCertSecretRef;
    @JsonProperty("clientKeySecretRef")
    private SecretKeySelector clientKeySecretRef;
    @JsonProperty("namespace")
    private String namespace;
    @JsonProperty("path")
    private String path;
    @JsonProperty("server")
    private String server;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VaultIssuer() {
    }

    public VaultIssuer(VaultAuth auth, String caBundle, SecretKeySelector caBundleSecretRef, SecretKeySelector clientCertSecretRef, SecretKeySelector clientKeySecretRef, String namespace, String path, String server) {
        super();
        this.auth = auth;
        this.caBundle = caBundle;
        this.caBundleSecretRef = caBundleSecretRef;
        this.clientCertSecretRef = clientCertSecretRef;
        this.clientKeySecretRef = clientKeySecretRef;
        this.namespace = namespace;
        this.path = path;
        this.server = server;
    }

    /**
     * Configures an issuer to sign certificates using a HashiCorp Vault PKI backend.
     */
    @JsonProperty("auth")
    public VaultAuth getAuth() {
        return auth;
    }

    /**
     * Configures an issuer to sign certificates using a HashiCorp Vault PKI backend.
     */
    @JsonProperty("auth")
    public void setAuth(VaultAuth auth) {
        this.auth = auth;
    }

    /**
     * Base64-encoded bundle of PEM CAs which will be used to validate the certificate chain presented by Vault. Only used if using HTTPS to connect to Vault and ignored for HTTP connections. Mutually exclusive with CABundleSecretRef. If neither CABundle nor CABundleSecretRef are defined, the certificate bundle in the cert-manager controller container is used to validate the TLS connection.
     */
    @JsonProperty("caBundle")
    public String getCaBundle() {
        return caBundle;
    }

    /**
     * Base64-encoded bundle of PEM CAs which will be used to validate the certificate chain presented by Vault. Only used if using HTTPS to connect to Vault and ignored for HTTP connections. Mutually exclusive with CABundleSecretRef. If neither CABundle nor CABundleSecretRef are defined, the certificate bundle in the cert-manager controller container is used to validate the TLS connection.
     */
    @JsonProperty("caBundle")
    public void setCaBundle(String caBundle) {
        this.caBundle = caBundle;
    }

    /**
     * Configures an issuer to sign certificates using a HashiCorp Vault PKI backend.
     */
    @JsonProperty("caBundleSecretRef")
    public SecretKeySelector getCaBundleSecretRef() {
        return caBundleSecretRef;
    }

    /**
     * Configures an issuer to sign certificates using a HashiCorp Vault PKI backend.
     */
    @JsonProperty("caBundleSecretRef")
    public void setCaBundleSecretRef(SecretKeySelector caBundleSecretRef) {
        this.caBundleSecretRef = caBundleSecretRef;
    }

    /**
     * Configures an issuer to sign certificates using a HashiCorp Vault PKI backend.
     */
    @JsonProperty("clientCertSecretRef")
    public SecretKeySelector getClientCertSecretRef() {
        return clientCertSecretRef;
    }

    /**
     * Configures an issuer to sign certificates using a HashiCorp Vault PKI backend.
     */
    @JsonProperty("clientCertSecretRef")
    public void setClientCertSecretRef(SecretKeySelector clientCertSecretRef) {
        this.clientCertSecretRef = clientCertSecretRef;
    }

    /**
     * Configures an issuer to sign certificates using a HashiCorp Vault PKI backend.
     */
    @JsonProperty("clientKeySecretRef")
    public SecretKeySelector getClientKeySecretRef() {
        return clientKeySecretRef;
    }

    /**
     * Configures an issuer to sign certificates using a HashiCorp Vault PKI backend.
     */
    @JsonProperty("clientKeySecretRef")
    public void setClientKeySecretRef(SecretKeySelector clientKeySecretRef) {
        this.clientKeySecretRef = clientKeySecretRef;
    }

    /**
     * Name of the vault namespace. Namespaces is a set of features within Vault Enterprise that allows Vault environments to support Secure Multi-tenancy. e.g: "ns1" More about namespaces can be found here https://www.vaultproject.io/docs/enterprise/namespaces
     */
    @JsonProperty("namespace")
    public String getNamespace() {
        return namespace;
    }

    /**
     * Name of the vault namespace. Namespaces is a set of features within Vault Enterprise that allows Vault environments to support Secure Multi-tenancy. e.g: "ns1" More about namespaces can be found here https://www.vaultproject.io/docs/enterprise/namespaces
     */
    @JsonProperty("namespace")
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    /**
     * Path is the mount path of the Vault PKI backend's `sign` endpoint, e.g: "my_pki_mount/sign/my-role-name".
     */
    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    /**
     * Path is the mount path of the Vault PKI backend's `sign` endpoint, e.g: "my_pki_mount/sign/my-role-name".
     */
    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Server is the connection address for the Vault server, e.g: "https://vault.example.com:8200".
     */
    @JsonProperty("server")
    public String getServer() {
        return server;
    }

    /**
     * Server is the connection address for the Vault server, e.g: "https://vault.example.com:8200".
     */
    @JsonProperty("server")
    public void setServer(String server) {
        this.server = server;
    }

    @JsonIgnore
    public VaultIssuerBuilder edit() {
        return new VaultIssuerBuilder(this);
    }

    @JsonIgnore
    public VaultIssuerBuilder toBuilder() {
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
