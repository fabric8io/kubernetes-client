
package io.fabric8.openshift.api.model.monitoring.v1;

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
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.SecretKeySelector;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * TLSConfig defines full TLS configuration.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ca",
    "caFile",
    "cert",
    "certFile",
    "insecureSkipVerify",
    "keyFile",
    "keySecret",
    "maxVersion",
    "minVersion",
    "serverName"
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
public class TLSConfig implements Editable<TLSConfigBuilder>, KubernetesResource
{

    @JsonProperty("ca")
    private SecretOrConfigMap ca;
    @JsonProperty("caFile")
    private String caFile;
    @JsonProperty("cert")
    private SecretOrConfigMap cert;
    @JsonProperty("certFile")
    private String certFile;
    @JsonProperty("insecureSkipVerify")
    private Boolean insecureSkipVerify;
    @JsonProperty("keyFile")
    private String keyFile;
    @JsonProperty("keySecret")
    private SecretKeySelector keySecret;
    @JsonProperty("maxVersion")
    private String maxVersion;
    @JsonProperty("minVersion")
    private String minVersion;
    @JsonProperty("serverName")
    private String serverName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public TLSConfig() {
    }

    public TLSConfig(SecretOrConfigMap ca, String caFile, SecretOrConfigMap cert, String certFile, Boolean insecureSkipVerify, String keyFile, SecretKeySelector keySecret, String maxVersion, String minVersion, String serverName) {
        super();
        this.ca = ca;
        this.caFile = caFile;
        this.cert = cert;
        this.certFile = certFile;
        this.insecureSkipVerify = insecureSkipVerify;
        this.keyFile = keyFile;
        this.keySecret = keySecret;
        this.maxVersion = maxVersion;
        this.minVersion = minVersion;
        this.serverName = serverName;
    }

    /**
     * TLSConfig defines full TLS configuration.
     */
    @JsonProperty("ca")
    public SecretOrConfigMap getCa() {
        return ca;
    }

    /**
     * TLSConfig defines full TLS configuration.
     */
    @JsonProperty("ca")
    public void setCa(SecretOrConfigMap ca) {
        this.ca = ca;
    }

    /**
     * caFile defines the path to the CA cert in the Prometheus container to use for the targets.
     */
    @JsonProperty("caFile")
    public String getCaFile() {
        return caFile;
    }

    /**
     * caFile defines the path to the CA cert in the Prometheus container to use for the targets.
     */
    @JsonProperty("caFile")
    public void setCaFile(String caFile) {
        this.caFile = caFile;
    }

    /**
     * TLSConfig defines full TLS configuration.
     */
    @JsonProperty("cert")
    public SecretOrConfigMap getCert() {
        return cert;
    }

    /**
     * TLSConfig defines full TLS configuration.
     */
    @JsonProperty("cert")
    public void setCert(SecretOrConfigMap cert) {
        this.cert = cert;
    }

    /**
     * certFile defines the path to the client cert file in the Prometheus container for the targets.
     */
    @JsonProperty("certFile")
    public String getCertFile() {
        return certFile;
    }

    /**
     * certFile defines the path to the client cert file in the Prometheus container for the targets.
     */
    @JsonProperty("certFile")
    public void setCertFile(String certFile) {
        this.certFile = certFile;
    }

    /**
     * insecureSkipVerify defines how to disable target certificate validation.
     */
    @JsonProperty("insecureSkipVerify")
    public Boolean getInsecureSkipVerify() {
        return insecureSkipVerify;
    }

    /**
     * insecureSkipVerify defines how to disable target certificate validation.
     */
    @JsonProperty("insecureSkipVerify")
    public void setInsecureSkipVerify(Boolean insecureSkipVerify) {
        this.insecureSkipVerify = insecureSkipVerify;
    }

    /**
     * keyFile defines the path to the client key file in the Prometheus container for the targets.
     */
    @JsonProperty("keyFile")
    public String getKeyFile() {
        return keyFile;
    }

    /**
     * keyFile defines the path to the client key file in the Prometheus container for the targets.
     */
    @JsonProperty("keyFile")
    public void setKeyFile(String keyFile) {
        this.keyFile = keyFile;
    }

    /**
     * TLSConfig defines full TLS configuration.
     */
    @JsonProperty("keySecret")
    public SecretKeySelector getKeySecret() {
        return keySecret;
    }

    /**
     * TLSConfig defines full TLS configuration.
     */
    @JsonProperty("keySecret")
    public void setKeySecret(SecretKeySelector keySecret) {
        this.keySecret = keySecret;
    }

    /**
     * maxVersion defines the maximum acceptable TLS version.<br><p> <br><p> It requires Prometheus &gt;= v2.41.0 or Thanos &gt;= v0.31.0.
     */
    @JsonProperty("maxVersion")
    public String getMaxVersion() {
        return maxVersion;
    }

    /**
     * maxVersion defines the maximum acceptable TLS version.<br><p> <br><p> It requires Prometheus &gt;= v2.41.0 or Thanos &gt;= v0.31.0.
     */
    @JsonProperty("maxVersion")
    public void setMaxVersion(String maxVersion) {
        this.maxVersion = maxVersion;
    }

    /**
     * minVersion defines the minimum acceptable TLS version.<br><p> <br><p> It requires Prometheus &gt;= v2.35.0 or Thanos &gt;= v0.28.0.
     */
    @JsonProperty("minVersion")
    public String getMinVersion() {
        return minVersion;
    }

    /**
     * minVersion defines the minimum acceptable TLS version.<br><p> <br><p> It requires Prometheus &gt;= v2.35.0 or Thanos &gt;= v0.28.0.
     */
    @JsonProperty("minVersion")
    public void setMinVersion(String minVersion) {
        this.minVersion = minVersion;
    }

    /**
     * serverName is used to verify the hostname for the targets.
     */
    @JsonProperty("serverName")
    public String getServerName() {
        return serverName;
    }

    /**
     * serverName is used to verify the hostname for the targets.
     */
    @JsonProperty("serverName")
    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    @JsonIgnore
    public TLSConfigBuilder edit() {
        return new TLSConfigBuilder(this);
    }

    @JsonIgnore
    public TLSConfigBuilder toBuilder() {
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
        if (!(o instanceof TLSConfig)) {
            return false;
        }
        TLSConfig other = (TLSConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$ca = this.getCa();
        Object other$ca = other.getCa();
        if (this$ca == null ? other$ca != null : !this$ca.equals(other$ca)) {
            return false;
        }
        Object this$caFile = this.getCaFile();
        Object other$caFile = other.getCaFile();
        if (this$caFile == null ? other$caFile != null : !this$caFile.equals(other$caFile)) {
            return false;
        }
        Object this$cert = this.getCert();
        Object other$cert = other.getCert();
        if (this$cert == null ? other$cert != null : !this$cert.equals(other$cert)) {
            return false;
        }
        Object this$certFile = this.getCertFile();
        Object other$certFile = other.getCertFile();
        if (this$certFile == null ? other$certFile != null : !this$certFile.equals(other$certFile)) {
            return false;
        }
        Object this$insecureSkipVerify = this.getInsecureSkipVerify();
        Object other$insecureSkipVerify = other.getInsecureSkipVerify();
        if (this$insecureSkipVerify == null ? other$insecureSkipVerify != null : !this$insecureSkipVerify.equals(other$insecureSkipVerify)) {
            return false;
        }
        Object this$keyFile = this.getKeyFile();
        Object other$keyFile = other.getKeyFile();
        if (this$keyFile == null ? other$keyFile != null : !this$keyFile.equals(other$keyFile)) {
            return false;
        }
        Object this$keySecret = this.getKeySecret();
        Object other$keySecret = other.getKeySecret();
        if (this$keySecret == null ? other$keySecret != null : !this$keySecret.equals(other$keySecret)) {
            return false;
        }
        Object this$maxVersion = this.getMaxVersion();
        Object other$maxVersion = other.getMaxVersion();
        if (this$maxVersion == null ? other$maxVersion != null : !this$maxVersion.equals(other$maxVersion)) {
            return false;
        }
        Object this$minVersion = this.getMinVersion();
        Object other$minVersion = other.getMinVersion();
        if (this$minVersion == null ? other$minVersion != null : !this$minVersion.equals(other$minVersion)) {
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
        return other instanceof TLSConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $ca = this.getCa();
        result = result * prime + ($ca == null ? 43 : $ca.hashCode());
        Object $caFile = this.getCaFile();
        result = result * prime + ($caFile == null ? 43 : $caFile.hashCode());
        Object $cert = this.getCert();
        result = result * prime + ($cert == null ? 43 : $cert.hashCode());
        Object $certFile = this.getCertFile();
        result = result * prime + ($certFile == null ? 43 : $certFile.hashCode());
        Object $insecureSkipVerify = this.getInsecureSkipVerify();
        result = result * prime + ($insecureSkipVerify == null ? 43 : $insecureSkipVerify.hashCode());
        Object $keyFile = this.getKeyFile();
        result = result * prime + ($keyFile == null ? 43 : $keyFile.hashCode());
        Object $keySecret = this.getKeySecret();
        result = result * prime + ($keySecret == null ? 43 : $keySecret.hashCode());
        Object $maxVersion = this.getMaxVersion();
        result = result * prime + ($maxVersion == null ? 43 : $maxVersion.hashCode());
        Object $minVersion = this.getMinVersion();
        result = result * prime + ($minVersion == null ? 43 : $minVersion.hashCode());
        Object $serverName = this.getServerName();
        result = result * prime + ($serverName == null ? 43 : $serverName.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "TLSConfig(" + "ca=" + this.getCa() + ", caFile=" + this.getCaFile() + ", cert=" + this.getCert() + ", certFile=" + this.getCertFile() + ", insecureSkipVerify=" + this.getInsecureSkipVerify() + ", keyFile=" + this.getKeyFile() + ", keySecret=" + this.getKeySecret() + ", maxVersion=" + this.getMaxVersion() + ", minVersion=" + this.getMinVersion() + ", serverName=" + this.getServerName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
