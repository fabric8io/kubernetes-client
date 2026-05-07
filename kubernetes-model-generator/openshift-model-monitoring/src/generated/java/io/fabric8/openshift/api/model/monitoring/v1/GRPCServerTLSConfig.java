
package io.fabric8.openshift.api.model.monitoring.v1;

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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.SecretKeySelector;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * GRPCServerTLSConfig defines TLS configuration for a gRPC server.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ca",
    "caFile",
    "cert",
    "certFile",
    "cipherSuites",
    "curves",
    "insecureSkipVerify",
    "keyFile",
    "keySecret",
    "maxVersion",
    "minVersion",
    "serverName"
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
public class GRPCServerTLSConfig implements Editable<GRPCServerTLSConfigBuilder>, KubernetesResource
{

    @JsonProperty("ca")
    private SecretOrConfigMap ca;
    @JsonProperty("caFile")
    private String caFile;
    @JsonProperty("cert")
    private SecretOrConfigMap cert;
    @JsonProperty("certFile")
    private String certFile;
    @JsonProperty("cipherSuites")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> cipherSuites = new ArrayList<>();
    @JsonProperty("curves")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> curves = new ArrayList<>();
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
    public GRPCServerTLSConfig() {
    }

    public GRPCServerTLSConfig(SecretOrConfigMap ca, String caFile, SecretOrConfigMap cert, String certFile, List<String> cipherSuites, List<String> curves, Boolean insecureSkipVerify, String keyFile, SecretKeySelector keySecret, String maxVersion, String minVersion, String serverName) {
        super();
        this.ca = ca;
        this.caFile = caFile;
        this.cert = cert;
        this.certFile = certFile;
        this.cipherSuites = cipherSuites;
        this.curves = curves;
        this.insecureSkipVerify = insecureSkipVerify;
        this.keyFile = keyFile;
        this.keySecret = keySecret;
        this.maxVersion = maxVersion;
        this.minVersion = minVersion;
        this.serverName = serverName;
    }

    /**
     * GRPCServerTLSConfig defines TLS configuration for a gRPC server.
     */
    @JsonProperty("ca")
    public SecretOrConfigMap getCa() {
        return ca;
    }

    /**
     * GRPCServerTLSConfig defines TLS configuration for a gRPC server.
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
     * GRPCServerTLSConfig defines TLS configuration for a gRPC server.
     */
    @JsonProperty("cert")
    public SecretOrConfigMap getCert() {
        return cert;
    }

    /**
     * GRPCServerTLSConfig defines TLS configuration for a gRPC server.
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
     * cipherSuites defines the list of supported cipher suites for TLS versions up to TLS 1.2.<br><p> <br><p> If not defined, the Go default cipher suites are used. Available cipher suites are documented in the Go documentation: https://golang.org/pkg/crypto/tls/#pkg-constants<br><p> <br><p> It requires Thanos &gt;= v0.42.0. Note that the operator doesn't verify if the Thanos version supports the provided values.
     */
    @JsonProperty("cipherSuites")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getCipherSuites() {
        return cipherSuites;
    }

    /**
     * cipherSuites defines the list of supported cipher suites for TLS versions up to TLS 1.2.<br><p> <br><p> If not defined, the Go default cipher suites are used. Available cipher suites are documented in the Go documentation: https://golang.org/pkg/crypto/tls/#pkg-constants<br><p> <br><p> It requires Thanos &gt;= v0.42.0. Note that the operator doesn't verify if the Thanos version supports the provided values.
     */
    @JsonProperty("cipherSuites")
    public void setCipherSuites(List<String> cipherSuites) {
        this.cipherSuites = cipherSuites;
    }

    /**
     * curves defines the list of preferred elliptic curves for TLS handshakes.<br><p> <br><p> If not defined, the Go default curves are used. Available curves are documented in the Go documentation: https://golang.org/pkg/crypto/tls/#CurveID<br><p> <br><p> It requires Thanos &gt;= v0.42.0. Note that the operator doesn't verify if the Thanos version supports the provided values.
     */
    @JsonProperty("curves")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getCurves() {
        return curves;
    }

    /**
     * curves defines the list of preferred elliptic curves for TLS handshakes.<br><p> <br><p> If not defined, the Go default curves are used. Available curves are documented in the Go documentation: https://golang.org/pkg/crypto/tls/#CurveID<br><p> <br><p> It requires Thanos &gt;= v0.42.0. Note that the operator doesn't verify if the Thanos version supports the provided values.
     */
    @JsonProperty("curves")
    public void setCurves(List<String> curves) {
        this.curves = curves;
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
     * GRPCServerTLSConfig defines TLS configuration for a gRPC server.
     */
    @JsonProperty("keySecret")
    public SecretKeySelector getKeySecret() {
        return keySecret;
    }

    /**
     * GRPCServerTLSConfig defines TLS configuration for a gRPC server.
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
    public GRPCServerTLSConfigBuilder edit() {
        return new GRPCServerTLSConfigBuilder(this);
    }

    @JsonIgnore
    public GRPCServerTLSConfigBuilder toBuilder() {
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
