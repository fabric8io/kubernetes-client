
package io.fabric8.certmanager.api.model.v1;

import java.util.LinkedHashMap;
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
    "server",
    "serverName"
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
    @JsonProperty("serverName")
    private String serverName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VaultIssuer() {
    }

    public VaultIssuer(VaultAuth auth, String caBundle, SecretKeySelector caBundleSecretRef, SecretKeySelector clientCertSecretRef, SecretKeySelector clientKeySecretRef, String namespace, String path, String server, String serverName) {
        super();
        this.auth = auth;
        this.caBundle = caBundle;
        this.caBundleSecretRef = caBundleSecretRef;
        this.clientCertSecretRef = clientCertSecretRef;
        this.clientKeySecretRef = clientKeySecretRef;
        this.namespace = namespace;
        this.path = path;
        this.server = server;
        this.serverName = serverName;
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

    /**
     * ServerName is used to verify the hostname on the returned certificates by the Vault server.
     */
    @JsonProperty("serverName")
    public String getServerName() {
        return serverName;
    }

    /**
     * ServerName is used to verify the hostname on the returned certificates by the Vault server.
     */
    @JsonProperty("serverName")
    public void setServerName(String serverName) {
        this.serverName = serverName;
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
        if (!(o instanceof VaultIssuer)) {
            return false;
        }
        VaultIssuer other = (VaultIssuer) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$auth = this.getAuth();
        Object other$auth = other.getAuth();
        if (this$auth == null ? other$auth != null : !this$auth.equals(other$auth)) {
            return false;
        }
        Object this$caBundle = this.getCaBundle();
        Object other$caBundle = other.getCaBundle();
        if (this$caBundle == null ? other$caBundle != null : !this$caBundle.equals(other$caBundle)) {
            return false;
        }
        Object this$caBundleSecretRef = this.getCaBundleSecretRef();
        Object other$caBundleSecretRef = other.getCaBundleSecretRef();
        if (this$caBundleSecretRef == null ? other$caBundleSecretRef != null : !this$caBundleSecretRef.equals(other$caBundleSecretRef)) {
            return false;
        }
        Object this$clientCertSecretRef = this.getClientCertSecretRef();
        Object other$clientCertSecretRef = other.getClientCertSecretRef();
        if (this$clientCertSecretRef == null ? other$clientCertSecretRef != null : !this$clientCertSecretRef.equals(other$clientCertSecretRef)) {
            return false;
        }
        Object this$clientKeySecretRef = this.getClientKeySecretRef();
        Object other$clientKeySecretRef = other.getClientKeySecretRef();
        if (this$clientKeySecretRef == null ? other$clientKeySecretRef != null : !this$clientKeySecretRef.equals(other$clientKeySecretRef)) {
            return false;
        }
        Object this$namespace = this.getNamespace();
        Object other$namespace = other.getNamespace();
        if (this$namespace == null ? other$namespace != null : !this$namespace.equals(other$namespace)) {
            return false;
        }
        Object this$path = this.getPath();
        Object other$path = other.getPath();
        if (this$path == null ? other$path != null : !this$path.equals(other$path)) {
            return false;
        }
        Object this$server = this.getServer();
        Object other$server = other.getServer();
        if (this$server == null ? other$server != null : !this$server.equals(other$server)) {
            return false;
        }
        Object this$serverName = this.getServerName();
        Object other$serverName = other.getServerName();
        if (this$serverName == null ? other$serverName != null : !this$serverName.equals(other$serverName)) {
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
        return other instanceof VaultIssuer;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $auth = this.getAuth();
        result = result * prime + ($auth == null ? 43 : $auth.hashCode());
        Object $caBundle = this.getCaBundle();
        result = result * prime + ($caBundle == null ? 43 : $caBundle.hashCode());
        Object $caBundleSecretRef = this.getCaBundleSecretRef();
        result = result * prime + ($caBundleSecretRef == null ? 43 : $caBundleSecretRef.hashCode());
        Object $clientCertSecretRef = this.getClientCertSecretRef();
        result = result * prime + ($clientCertSecretRef == null ? 43 : $clientCertSecretRef.hashCode());
        Object $clientKeySecretRef = this.getClientKeySecretRef();
        result = result * prime + ($clientKeySecretRef == null ? 43 : $clientKeySecretRef.hashCode());
        Object $namespace = this.getNamespace();
        result = result * prime + ($namespace == null ? 43 : $namespace.hashCode());
        Object $path = this.getPath();
        result = result * prime + ($path == null ? 43 : $path.hashCode());
        Object $server = this.getServer();
        result = result * prime + ($server == null ? 43 : $server.hashCode());
        Object $serverName = this.getServerName();
        result = result * prime + ($serverName == null ? 43 : $serverName.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "VaultIssuer(" + "auth=" + this.getAuth() + ", caBundle=" + this.getCaBundle() + ", caBundleSecretRef=" + this.getCaBundleSecretRef() + ", clientCertSecretRef=" + this.getClientCertSecretRef() + ", clientKeySecretRef=" + this.getClientKeySecretRef() + ", namespace=" + this.getNamespace() + ", path=" + this.getPath() + ", server=" + this.getServer() + ", serverName=" + this.getServerName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
