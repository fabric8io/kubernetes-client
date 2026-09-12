
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

/**
 * AlertmanagerEndpoints defines a selection of a single Endpoints object containing Alertmanager IPs to fire alerts against.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "alertRelabelings",
    "authorization",
    "basicAuth",
    "bearerTokenFile",
    "enableHttp2",
    "name",
    "namespace",
    "noProxy",
    "pathPrefix",
    "port",
    "proxyConnectHeader",
    "proxyFromEnvironment",
    "proxyUrl",
    "relabelings",
    "scheme",
    "sigv4",
    "timeout",
    "tlsConfig"
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
public class AlertmanagerEndpoints implements Editable<AlertmanagerEndpointsBuilder>, KubernetesResource
{

    @JsonProperty("alertRelabelings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RelabelConfig> alertRelabelings = new ArrayList<>();
    @JsonProperty("apiVersion")
    private String apiVersion;
    @JsonProperty("authorization")
    private SafeAuthorization authorization;
    @JsonProperty("basicAuth")
    private BasicAuth basicAuth;
    @JsonProperty("bearerTokenFile")
    private String bearerTokenFile;
    @JsonProperty("enableHttp2")
    private Boolean enableHttp2;
    @JsonProperty("name")
    private String name;
    @JsonProperty("namespace")
    private String namespace;
    @JsonProperty("noProxy")
    private String noProxy;
    @JsonProperty("pathPrefix")
    private String pathPrefix;
    @JsonProperty("port")
    private IntOrString port;
    @JsonProperty("proxyConnectHeader")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, List<SecretKeySelector>> proxyConnectHeader = new LinkedHashMap<>();
    @JsonProperty("proxyFromEnvironment")
    private Boolean proxyFromEnvironment;
    @JsonProperty("proxyUrl")
    private String proxyUrl;
    @JsonProperty("relabelings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RelabelConfig> relabelings = new ArrayList<>();
    @JsonProperty("scheme")
    private String scheme;
    @JsonProperty("sigv4")
    private Sigv4 sigv4;
    @JsonProperty("timeout")
    private String timeout;
    @JsonProperty("tlsConfig")
    private TLSConfig tlsConfig;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AlertmanagerEndpoints() {
    }

    public AlertmanagerEndpoints(List<RelabelConfig> alertRelabelings, String apiVersion, SafeAuthorization authorization, BasicAuth basicAuth, String bearerTokenFile, Boolean enableHttp2, String name, String namespace, String noProxy, String pathPrefix, IntOrString port, Map<String, List<SecretKeySelector>> proxyConnectHeader, Boolean proxyFromEnvironment, String proxyUrl, List<RelabelConfig> relabelings, String scheme, Sigv4 sigv4, String timeout, TLSConfig tlsConfig) {
        super();
        this.alertRelabelings = alertRelabelings;
        this.apiVersion = apiVersion;
        this.authorization = authorization;
        this.basicAuth = basicAuth;
        this.bearerTokenFile = bearerTokenFile;
        this.enableHttp2 = enableHttp2;
        this.name = name;
        this.namespace = namespace;
        this.noProxy = noProxy;
        this.pathPrefix = pathPrefix;
        this.port = port;
        this.proxyConnectHeader = proxyConnectHeader;
        this.proxyFromEnvironment = proxyFromEnvironment;
        this.proxyUrl = proxyUrl;
        this.relabelings = relabelings;
        this.scheme = scheme;
        this.sigv4 = sigv4;
        this.timeout = timeout;
        this.tlsConfig = tlsConfig;
    }

    /**
     * alertRelabelings defines the relabeling configs applied before sending alerts to a specific Alertmanager. It requires Prometheus &gt;= v2.51.0.
     */
    @JsonProperty("alertRelabelings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RelabelConfig> getAlertRelabelings() {
        return alertRelabelings;
    }

    /**
     * alertRelabelings defines the relabeling configs applied before sending alerts to a specific Alertmanager. It requires Prometheus &gt;= v2.51.0.
     */
    @JsonProperty("alertRelabelings")
    public void setAlertRelabelings(List<RelabelConfig> alertRelabelings) {
        this.alertRelabelings = alertRelabelings;
    }

    /**
     * apiVersion defines the version of the Alertmanager API that Prometheus uses to send alerts. It can be "V1" or "V2". The field has no effect for Prometheus &gt;= v3.0.0 because only the v2 API is supported.
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * apiVersion defines the version of the Alertmanager API that Prometheus uses to send alerts. It can be "V1" or "V2". The field has no effect for Prometheus &gt;= v3.0.0 because only the v2 API is supported.
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     * AlertmanagerEndpoints defines a selection of a single Endpoints object containing Alertmanager IPs to fire alerts against.
     */
    @JsonProperty("authorization")
    public SafeAuthorization getAuthorization() {
        return authorization;
    }

    /**
     * AlertmanagerEndpoints defines a selection of a single Endpoints object containing Alertmanager IPs to fire alerts against.
     */
    @JsonProperty("authorization")
    public void setAuthorization(SafeAuthorization authorization) {
        this.authorization = authorization;
    }

    /**
     * AlertmanagerEndpoints defines a selection of a single Endpoints object containing Alertmanager IPs to fire alerts against.
     */
    @JsonProperty("basicAuth")
    public BasicAuth getBasicAuth() {
        return basicAuth;
    }

    /**
     * AlertmanagerEndpoints defines a selection of a single Endpoints object containing Alertmanager IPs to fire alerts against.
     */
    @JsonProperty("basicAuth")
    public void setBasicAuth(BasicAuth basicAuth) {
        this.basicAuth = basicAuth;
    }

    /**
     * bearerTokenFile defines the file to read bearer token for Alertmanager.<br><p> <br><p> Cannot be set at the same time as `basicAuth`, `authorization`, or `sigv4`.<br><p> <br><p> Deprecated: this will be removed in a future release. Prefer using `authorization`.
     */
    @JsonProperty("bearerTokenFile")
    public String getBearerTokenFile() {
        return bearerTokenFile;
    }

    /**
     * bearerTokenFile defines the file to read bearer token for Alertmanager.<br><p> <br><p> Cannot be set at the same time as `basicAuth`, `authorization`, or `sigv4`.<br><p> <br><p> Deprecated: this will be removed in a future release. Prefer using `authorization`.
     */
    @JsonProperty("bearerTokenFile")
    public void setBearerTokenFile(String bearerTokenFile) {
        this.bearerTokenFile = bearerTokenFile;
    }

    /**
     * enableHttp2 defines whether to enable HTTP2.
     */
    @JsonProperty("enableHttp2")
    public Boolean getEnableHttp2() {
        return enableHttp2;
    }

    /**
     * enableHttp2 defines whether to enable HTTP2.
     */
    @JsonProperty("enableHttp2")
    public void setEnableHttp2(Boolean enableHttp2) {
        this.enableHttp2 = enableHttp2;
    }

    /**
     * name of the Endpoints object in the namespace.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name of the Endpoints object in the namespace.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * namespace of the Endpoints object.<br><p> <br><p> If not set, the object will be discovered in the namespace of the Prometheus object.
     */
    @JsonProperty("namespace")
    public String getNamespace() {
        return namespace;
    }

    /**
     * namespace of the Endpoints object.<br><p> <br><p> If not set, the object will be discovered in the namespace of the Prometheus object.
     */
    @JsonProperty("namespace")
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    /**
     * noProxy defines a comma-separated string that can contain IPs, CIDR notation, domain names that should be excluded from proxying. IP and domain names can contain port numbers.<br><p> <br><p> It requires Prometheus &gt;= v2.43.0, Alertmanager &gt;= v0.25.0 or Thanos &gt;= v0.32.0.
     */
    @JsonProperty("noProxy")
    public String getNoProxy() {
        return noProxy;
    }

    /**
     * noProxy defines a comma-separated string that can contain IPs, CIDR notation, domain names that should be excluded from proxying. IP and domain names can contain port numbers.<br><p> <br><p> It requires Prometheus &gt;= v2.43.0, Alertmanager &gt;= v0.25.0 or Thanos &gt;= v0.32.0.
     */
    @JsonProperty("noProxy")
    public void setNoProxy(String noProxy) {
        this.noProxy = noProxy;
    }

    /**
     * pathPrefix defines the prefix for the HTTP path alerts are pushed to.
     */
    @JsonProperty("pathPrefix")
    public String getPathPrefix() {
        return pathPrefix;
    }

    /**
     * pathPrefix defines the prefix for the HTTP path alerts are pushed to.
     */
    @JsonProperty("pathPrefix")
    public void setPathPrefix(String pathPrefix) {
        this.pathPrefix = pathPrefix;
    }

    /**
     * AlertmanagerEndpoints defines a selection of a single Endpoints object containing Alertmanager IPs to fire alerts against.
     */
    @JsonProperty("port")
    public IntOrString getPort() {
        return port;
    }

    /**
     * AlertmanagerEndpoints defines a selection of a single Endpoints object containing Alertmanager IPs to fire alerts against.
     */
    @JsonProperty("port")
    public void setPort(IntOrString port) {
        this.port = port;
    }

    /**
     * proxyConnectHeader optionally specifies headers to send to proxies during CONNECT requests.<br><p> <br><p> It requires Prometheus &gt;= v2.43.0, Alertmanager &gt;= v0.25.0 or Thanos &gt;= v0.32.0.
     */
    @JsonProperty("proxyConnectHeader")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, List<SecretKeySelector>> getProxyConnectHeader() {
        return proxyConnectHeader;
    }

    /**
     * proxyConnectHeader optionally specifies headers to send to proxies during CONNECT requests.<br><p> <br><p> It requires Prometheus &gt;= v2.43.0, Alertmanager &gt;= v0.25.0 or Thanos &gt;= v0.32.0.
     */
    @JsonProperty("proxyConnectHeader")
    public void setProxyConnectHeader(Map<String, List<SecretKeySelector>> proxyConnectHeader) {
        this.proxyConnectHeader = proxyConnectHeader;
    }

    /**
     * proxyFromEnvironment defines whether to use the proxy configuration defined by environment variables (HTTP_PROXY, HTTPS_PROXY, and NO_PROXY).<br><p> <br><p> It requires Prometheus &gt;= v2.43.0, Alertmanager &gt;= v0.25.0 or Thanos &gt;= v0.32.0.
     */
    @JsonProperty("proxyFromEnvironment")
    public Boolean getProxyFromEnvironment() {
        return proxyFromEnvironment;
    }

    /**
     * proxyFromEnvironment defines whether to use the proxy configuration defined by environment variables (HTTP_PROXY, HTTPS_PROXY, and NO_PROXY).<br><p> <br><p> It requires Prometheus &gt;= v2.43.0, Alertmanager &gt;= v0.25.0 or Thanos &gt;= v0.32.0.
     */
    @JsonProperty("proxyFromEnvironment")
    public void setProxyFromEnvironment(Boolean proxyFromEnvironment) {
        this.proxyFromEnvironment = proxyFromEnvironment;
    }

    /**
     * proxyUrl defines the HTTP proxy server to use.
     */
    @JsonProperty("proxyUrl")
    public String getProxyUrl() {
        return proxyUrl;
    }

    /**
     * proxyUrl defines the HTTP proxy server to use.
     */
    @JsonProperty("proxyUrl")
    public void setProxyUrl(String proxyUrl) {
        this.proxyUrl = proxyUrl;
    }

    /**
     * relabelings defines the relabel configuration applied to the discovered Alertmanagers.
     */
    @JsonProperty("relabelings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RelabelConfig> getRelabelings() {
        return relabelings;
    }

    /**
     * relabelings defines the relabel configuration applied to the discovered Alertmanagers.
     */
    @JsonProperty("relabelings")
    public void setRelabelings(List<RelabelConfig> relabelings) {
        this.relabelings = relabelings;
    }

    /**
     * scheme defines the HTTP scheme to use when sending alerts.
     */
    @JsonProperty("scheme")
    public String getScheme() {
        return scheme;
    }

    /**
     * scheme defines the HTTP scheme to use when sending alerts.
     */
    @JsonProperty("scheme")
    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    /**
     * AlertmanagerEndpoints defines a selection of a single Endpoints object containing Alertmanager IPs to fire alerts against.
     */
    @JsonProperty("sigv4")
    public Sigv4 getSigv4() {
        return sigv4;
    }

    /**
     * AlertmanagerEndpoints defines a selection of a single Endpoints object containing Alertmanager IPs to fire alerts against.
     */
    @JsonProperty("sigv4")
    public void setSigv4(Sigv4 sigv4) {
        this.sigv4 = sigv4;
    }

    /**
     * timeout defines a per-target Alertmanager timeout when pushing alerts.
     */
    @JsonProperty("timeout")
    public String getTimeout() {
        return timeout;
    }

    /**
     * timeout defines a per-target Alertmanager timeout when pushing alerts.
     */
    @JsonProperty("timeout")
    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    /**
     * AlertmanagerEndpoints defines a selection of a single Endpoints object containing Alertmanager IPs to fire alerts against.
     */
    @JsonProperty("tlsConfig")
    public TLSConfig getTlsConfig() {
        return tlsConfig;
    }

    /**
     * AlertmanagerEndpoints defines a selection of a single Endpoints object containing Alertmanager IPs to fire alerts against.
     */
    @JsonProperty("tlsConfig")
    public void setTlsConfig(TLSConfig tlsConfig) {
        this.tlsConfig = tlsConfig;
    }

    @JsonIgnore
    public AlertmanagerEndpointsBuilder edit() {
        return new AlertmanagerEndpointsBuilder(this);
    }

    @JsonIgnore
    public AlertmanagerEndpointsBuilder toBuilder() {
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
        if (!(o instanceof AlertmanagerEndpoints)) {
            return false;
        }
        AlertmanagerEndpoints other = (AlertmanagerEndpoints) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$alertRelabelings = this.getAlertRelabelings();
        Object other$alertRelabelings = other.getAlertRelabelings();
        if (this$alertRelabelings == null ? other$alertRelabelings != null : !this$alertRelabelings.equals(other$alertRelabelings)) {
            return false;
        }
        Object this$apiVersion = this.getApiVersion();
        Object other$apiVersion = other.getApiVersion();
        if (this$apiVersion == null ? other$apiVersion != null : !this$apiVersion.equals(other$apiVersion)) {
            return false;
        }
        Object this$authorization = this.getAuthorization();
        Object other$authorization = other.getAuthorization();
        if (this$authorization == null ? other$authorization != null : !this$authorization.equals(other$authorization)) {
            return false;
        }
        Object this$basicAuth = this.getBasicAuth();
        Object other$basicAuth = other.getBasicAuth();
        if (this$basicAuth == null ? other$basicAuth != null : !this$basicAuth.equals(other$basicAuth)) {
            return false;
        }
        Object this$bearerTokenFile = this.getBearerTokenFile();
        Object other$bearerTokenFile = other.getBearerTokenFile();
        if (this$bearerTokenFile == null ? other$bearerTokenFile != null : !this$bearerTokenFile.equals(other$bearerTokenFile)) {
            return false;
        }
        Object this$enableHttp2 = this.getEnableHttp2();
        Object other$enableHttp2 = other.getEnableHttp2();
        if (this$enableHttp2 == null ? other$enableHttp2 != null : !this$enableHttp2.equals(other$enableHttp2)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$namespace = this.getNamespace();
        Object other$namespace = other.getNamespace();
        if (this$namespace == null ? other$namespace != null : !this$namespace.equals(other$namespace)) {
            return false;
        }
        Object this$noProxy = this.getNoProxy();
        Object other$noProxy = other.getNoProxy();
        if (this$noProxy == null ? other$noProxy != null : !this$noProxy.equals(other$noProxy)) {
            return false;
        }
        Object this$pathPrefix = this.getPathPrefix();
        Object other$pathPrefix = other.getPathPrefix();
        if (this$pathPrefix == null ? other$pathPrefix != null : !this$pathPrefix.equals(other$pathPrefix)) {
            return false;
        }
        Object this$port = this.getPort();
        Object other$port = other.getPort();
        if (this$port == null ? other$port != null : !this$port.equals(other$port)) {
            return false;
        }
        Object this$proxyConnectHeader = this.getProxyConnectHeader();
        Object other$proxyConnectHeader = other.getProxyConnectHeader();
        if (this$proxyConnectHeader == null ? other$proxyConnectHeader != null : !this$proxyConnectHeader.equals(other$proxyConnectHeader)) {
            return false;
        }
        Object this$proxyFromEnvironment = this.getProxyFromEnvironment();
        Object other$proxyFromEnvironment = other.getProxyFromEnvironment();
        if (this$proxyFromEnvironment == null ? other$proxyFromEnvironment != null : !this$proxyFromEnvironment.equals(other$proxyFromEnvironment)) {
            return false;
        }
        Object this$proxyUrl = this.getProxyUrl();
        Object other$proxyUrl = other.getProxyUrl();
        if (this$proxyUrl == null ? other$proxyUrl != null : !this$proxyUrl.equals(other$proxyUrl)) {
            return false;
        }
        Object this$relabelings = this.getRelabelings();
        Object other$relabelings = other.getRelabelings();
        if (this$relabelings == null ? other$relabelings != null : !this$relabelings.equals(other$relabelings)) {
            return false;
        }
        Object this$scheme = this.getScheme();
        Object other$scheme = other.getScheme();
        if (this$scheme == null ? other$scheme != null : !this$scheme.equals(other$scheme)) {
            return false;
        }
        Object this$sigv4 = this.getSigv4();
        Object other$sigv4 = other.getSigv4();
        if (this$sigv4 == null ? other$sigv4 != null : !this$sigv4.equals(other$sigv4)) {
            return false;
        }
        Object this$timeout = this.getTimeout();
        Object other$timeout = other.getTimeout();
        if (this$timeout == null ? other$timeout != null : !this$timeout.equals(other$timeout)) {
            return false;
        }
        Object this$tlsConfig = this.getTlsConfig();
        Object other$tlsConfig = other.getTlsConfig();
        if (this$tlsConfig == null ? other$tlsConfig != null : !this$tlsConfig.equals(other$tlsConfig)) {
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
        return other instanceof AlertmanagerEndpoints;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $alertRelabelings = this.getAlertRelabelings();
        result = result * prime + ($alertRelabelings == null ? 43 : $alertRelabelings.hashCode());
        Object $apiVersion = this.getApiVersion();
        result = result * prime + ($apiVersion == null ? 43 : $apiVersion.hashCode());
        Object $authorization = this.getAuthorization();
        result = result * prime + ($authorization == null ? 43 : $authorization.hashCode());
        Object $basicAuth = this.getBasicAuth();
        result = result * prime + ($basicAuth == null ? 43 : $basicAuth.hashCode());
        Object $bearerTokenFile = this.getBearerTokenFile();
        result = result * prime + ($bearerTokenFile == null ? 43 : $bearerTokenFile.hashCode());
        Object $enableHttp2 = this.getEnableHttp2();
        result = result * prime + ($enableHttp2 == null ? 43 : $enableHttp2.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $namespace = this.getNamespace();
        result = result * prime + ($namespace == null ? 43 : $namespace.hashCode());
        Object $noProxy = this.getNoProxy();
        result = result * prime + ($noProxy == null ? 43 : $noProxy.hashCode());
        Object $pathPrefix = this.getPathPrefix();
        result = result * prime + ($pathPrefix == null ? 43 : $pathPrefix.hashCode());
        Object $port = this.getPort();
        result = result * prime + ($port == null ? 43 : $port.hashCode());
        Object $proxyConnectHeader = this.getProxyConnectHeader();
        result = result * prime + ($proxyConnectHeader == null ? 43 : $proxyConnectHeader.hashCode());
        Object $proxyFromEnvironment = this.getProxyFromEnvironment();
        result = result * prime + ($proxyFromEnvironment == null ? 43 : $proxyFromEnvironment.hashCode());
        Object $proxyUrl = this.getProxyUrl();
        result = result * prime + ($proxyUrl == null ? 43 : $proxyUrl.hashCode());
        Object $relabelings = this.getRelabelings();
        result = result * prime + ($relabelings == null ? 43 : $relabelings.hashCode());
        Object $scheme = this.getScheme();
        result = result * prime + ($scheme == null ? 43 : $scheme.hashCode());
        Object $sigv4 = this.getSigv4();
        result = result * prime + ($sigv4 == null ? 43 : $sigv4.hashCode());
        Object $timeout = this.getTimeout();
        result = result * prime + ($timeout == null ? 43 : $timeout.hashCode());
        Object $tlsConfig = this.getTlsConfig();
        result = result * prime + ($tlsConfig == null ? 43 : $tlsConfig.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AlertmanagerEndpoints(" + "alertRelabelings=" + this.getAlertRelabelings() + ", apiVersion=" + this.getApiVersion() + ", authorization=" + this.getAuthorization() + ", basicAuth=" + this.getBasicAuth() + ", bearerTokenFile=" + this.getBearerTokenFile() + ", enableHttp2=" + this.getEnableHttp2() + ", name=" + this.getName() + ", namespace=" + this.getNamespace() + ", noProxy=" + this.getNoProxy() + ", pathPrefix=" + this.getPathPrefix() + ", port=" + this.getPort() + ", proxyConnectHeader=" + this.getProxyConnectHeader() + ", proxyFromEnvironment=" + this.getProxyFromEnvironment() + ", proxyUrl=" + this.getProxyUrl() + ", relabelings=" + this.getRelabelings() + ", scheme=" + this.getScheme() + ", sigv4=" + this.getSigv4() + ", timeout=" + this.getTimeout() + ", tlsConfig=" + this.getTlsConfig() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
