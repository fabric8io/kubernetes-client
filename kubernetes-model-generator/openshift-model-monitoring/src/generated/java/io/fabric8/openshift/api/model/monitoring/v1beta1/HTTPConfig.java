
package io.fabric8.openshift.api.model.monitoring.v1beta1;

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
import io.fabric8.kubernetes.api.model.SecretKeySelector;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.openshift.api.model.monitoring.v1.BasicAuth;
import io.fabric8.openshift.api.model.monitoring.v1.OAuth2;
import io.fabric8.openshift.api.model.monitoring.v1.SafeAuthorization;
import io.fabric8.openshift.api.model.monitoring.v1.SafeTLSConfig;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * HTTPConfig defines a client HTTP configuration. See https://prometheus.io/docs/alerting/latest/configuration/#http_config
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "authorization",
    "basicAuth",
    "bearerTokenSecret",
    "enableHttp2",
    "followRedirects",
    "noProxy",
    "oauth2",
    "proxyConnectHeader",
    "proxyFromEnvironment",
    "proxyURL",
    "proxyUrl",
    "tlsConfig"
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
public class HTTPConfig implements Editable<HTTPConfigBuilder>, KubernetesResource
{

    @JsonProperty("authorization")
    private SafeAuthorization authorization;
    @JsonProperty("basicAuth")
    private BasicAuth basicAuth;
    @JsonProperty("bearerTokenSecret")
    private SecretKeySelector bearerTokenSecret;
    @JsonProperty("enableHttp2")
    private Boolean enableHttp2;
    @JsonProperty("followRedirects")
    private Boolean followRedirects;
    @JsonProperty("noProxy")
    private String noProxy;
    @JsonProperty("oauth2")
    private OAuth2 oauth2;
    @JsonProperty("proxyConnectHeader")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, List<SecretKeySelector>> proxyConnectHeader = new LinkedHashMap<>();
    @JsonProperty("proxyFromEnvironment")
    private Boolean proxyFromEnvironment;
    @JsonProperty("proxyURL")
    private String proxyURL;
    @JsonProperty("proxyUrl")
    private String proxyUrl;
    @JsonProperty("tlsConfig")
    private SafeTLSConfig tlsConfig;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HTTPConfig() {
    }

    public HTTPConfig(SafeAuthorization authorization, BasicAuth basicAuth, SecretKeySelector bearerTokenSecret, Boolean enableHttp2, Boolean followRedirects, String noProxy, OAuth2 oauth2, Map<String, List<SecretKeySelector>> proxyConnectHeader, Boolean proxyFromEnvironment, String proxyURL, String proxyUrl, SafeTLSConfig tlsConfig) {
        super();
        this.authorization = authorization;
        this.basicAuth = basicAuth;
        this.bearerTokenSecret = bearerTokenSecret;
        this.enableHttp2 = enableHttp2;
        this.followRedirects = followRedirects;
        this.noProxy = noProxy;
        this.oauth2 = oauth2;
        this.proxyConnectHeader = proxyConnectHeader;
        this.proxyFromEnvironment = proxyFromEnvironment;
        this.proxyURL = proxyURL;
        this.proxyUrl = proxyUrl;
        this.tlsConfig = tlsConfig;
    }

    /**
     * HTTPConfig defines a client HTTP configuration. See https://prometheus.io/docs/alerting/latest/configuration/#http_config
     */
    @JsonProperty("authorization")
    public SafeAuthorization getAuthorization() {
        return authorization;
    }

    /**
     * HTTPConfig defines a client HTTP configuration. See https://prometheus.io/docs/alerting/latest/configuration/#http_config
     */
    @JsonProperty("authorization")
    public void setAuthorization(SafeAuthorization authorization) {
        this.authorization = authorization;
    }

    /**
     * HTTPConfig defines a client HTTP configuration. See https://prometheus.io/docs/alerting/latest/configuration/#http_config
     */
    @JsonProperty("basicAuth")
    public BasicAuth getBasicAuth() {
        return basicAuth;
    }

    /**
     * HTTPConfig defines a client HTTP configuration. See https://prometheus.io/docs/alerting/latest/configuration/#http_config
     */
    @JsonProperty("basicAuth")
    public void setBasicAuth(BasicAuth basicAuth) {
        this.basicAuth = basicAuth;
    }

    /**
     * HTTPConfig defines a client HTTP configuration. See https://prometheus.io/docs/alerting/latest/configuration/#http_config
     */
    @JsonProperty("bearerTokenSecret")
    public SecretKeySelector getBearerTokenSecret() {
        return bearerTokenSecret;
    }

    /**
     * HTTPConfig defines a client HTTP configuration. See https://prometheus.io/docs/alerting/latest/configuration/#http_config
     */
    @JsonProperty("bearerTokenSecret")
    public void setBearerTokenSecret(SecretKeySelector bearerTokenSecret) {
        this.bearerTokenSecret = bearerTokenSecret;
    }

    /**
     * enableHttp2 can be used to disable HTTP2.
     */
    @JsonProperty("enableHttp2")
    public Boolean getEnableHttp2() {
        return enableHttp2;
    }

    /**
     * enableHttp2 can be used to disable HTTP2.
     */
    @JsonProperty("enableHttp2")
    public void setEnableHttp2(Boolean enableHttp2) {
        this.enableHttp2 = enableHttp2;
    }

    /**
     * followRedirects defines whether HTTP requests follow HTTP 3xx redirects. When true, the client will automatically follow redirect responses.
     */
    @JsonProperty("followRedirects")
    public Boolean getFollowRedirects() {
        return followRedirects;
    }

    /**
     * followRedirects defines whether HTTP requests follow HTTP 3xx redirects. When true, the client will automatically follow redirect responses.
     */
    @JsonProperty("followRedirects")
    public void setFollowRedirects(Boolean followRedirects) {
        this.followRedirects = followRedirects;
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
     * HTTPConfig defines a client HTTP configuration. See https://prometheus.io/docs/alerting/latest/configuration/#http_config
     */
    @JsonProperty("oauth2")
    public OAuth2 getOauth2() {
        return oauth2;
    }

    /**
     * HTTPConfig defines a client HTTP configuration. See https://prometheus.io/docs/alerting/latest/configuration/#http_config
     */
    @JsonProperty("oauth2")
    public void setOauth2(OAuth2 oauth2) {
        this.oauth2 = oauth2;
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
     * proxyURL defines an optional proxy URL for HTTP requests. If defined, this field takes precedence over `proxyUrl`.
     */
    @JsonProperty("proxyURL")
    public String getProxyURL() {
        return proxyURL;
    }

    /**
     * proxyURL defines an optional proxy URL for HTTP requests. If defined, this field takes precedence over `proxyUrl`.
     */
    @JsonProperty("proxyURL")
    public void setProxyURL(String proxyURL) {
        this.proxyURL = proxyURL;
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
     * HTTPConfig defines a client HTTP configuration. See https://prometheus.io/docs/alerting/latest/configuration/#http_config
     */
    @JsonProperty("tlsConfig")
    public SafeTLSConfig getTlsConfig() {
        return tlsConfig;
    }

    /**
     * HTTPConfig defines a client HTTP configuration. See https://prometheus.io/docs/alerting/latest/configuration/#http_config
     */
    @JsonProperty("tlsConfig")
    public void setTlsConfig(SafeTLSConfig tlsConfig) {
        this.tlsConfig = tlsConfig;
    }

    @JsonIgnore
    public HTTPConfigBuilder edit() {
        return new HTTPConfigBuilder(this);
    }

    @JsonIgnore
    public HTTPConfigBuilder toBuilder() {
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
        if (!(o instanceof HTTPConfig)) {
            return false;
        }
        HTTPConfig other = (HTTPConfig) o;
        if (!other.canEqual(this)) {
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
        Object this$bearerTokenSecret = this.getBearerTokenSecret();
        Object other$bearerTokenSecret = other.getBearerTokenSecret();
        if (this$bearerTokenSecret == null ? other$bearerTokenSecret != null : !this$bearerTokenSecret.equals(other$bearerTokenSecret)) {
            return false;
        }
        Object this$enableHttp2 = this.getEnableHttp2();
        Object other$enableHttp2 = other.getEnableHttp2();
        if (this$enableHttp2 == null ? other$enableHttp2 != null : !this$enableHttp2.equals(other$enableHttp2)) {
            return false;
        }
        Object this$followRedirects = this.getFollowRedirects();
        Object other$followRedirects = other.getFollowRedirects();
        if (this$followRedirects == null ? other$followRedirects != null : !this$followRedirects.equals(other$followRedirects)) {
            return false;
        }
        Object this$noProxy = this.getNoProxy();
        Object other$noProxy = other.getNoProxy();
        if (this$noProxy == null ? other$noProxy != null : !this$noProxy.equals(other$noProxy)) {
            return false;
        }
        Object this$oauth2 = this.getOauth2();
        Object other$oauth2 = other.getOauth2();
        if (this$oauth2 == null ? other$oauth2 != null : !this$oauth2.equals(other$oauth2)) {
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
        Object this$proxyURL = this.getProxyURL();
        Object other$proxyURL = other.getProxyURL();
        if (this$proxyURL == null ? other$proxyURL != null : !this$proxyURL.equals(other$proxyURL)) {
            return false;
        }
        Object this$proxyUrl = this.getProxyUrl();
        Object other$proxyUrl = other.getProxyUrl();
        if (this$proxyUrl == null ? other$proxyUrl != null : !this$proxyUrl.equals(other$proxyUrl)) {
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
        return other instanceof HTTPConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $authorization = this.getAuthorization();
        result = result * prime + ($authorization == null ? 43 : $authorization.hashCode());
        Object $basicAuth = this.getBasicAuth();
        result = result * prime + ($basicAuth == null ? 43 : $basicAuth.hashCode());
        Object $bearerTokenSecret = this.getBearerTokenSecret();
        result = result * prime + ($bearerTokenSecret == null ? 43 : $bearerTokenSecret.hashCode());
        Object $enableHttp2 = this.getEnableHttp2();
        result = result * prime + ($enableHttp2 == null ? 43 : $enableHttp2.hashCode());
        Object $followRedirects = this.getFollowRedirects();
        result = result * prime + ($followRedirects == null ? 43 : $followRedirects.hashCode());
        Object $noProxy = this.getNoProxy();
        result = result * prime + ($noProxy == null ? 43 : $noProxy.hashCode());
        Object $oauth2 = this.getOauth2();
        result = result * prime + ($oauth2 == null ? 43 : $oauth2.hashCode());
        Object $proxyConnectHeader = this.getProxyConnectHeader();
        result = result * prime + ($proxyConnectHeader == null ? 43 : $proxyConnectHeader.hashCode());
        Object $proxyFromEnvironment = this.getProxyFromEnvironment();
        result = result * prime + ($proxyFromEnvironment == null ? 43 : $proxyFromEnvironment.hashCode());
        Object $proxyURL = this.getProxyURL();
        result = result * prime + ($proxyURL == null ? 43 : $proxyURL.hashCode());
        Object $proxyUrl = this.getProxyUrl();
        result = result * prime + ($proxyUrl == null ? 43 : $proxyUrl.hashCode());
        Object $tlsConfig = this.getTlsConfig();
        result = result * prime + ($tlsConfig == null ? 43 : $tlsConfig.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "HTTPConfig(" + "authorization=" + this.getAuthorization() + ", basicAuth=" + this.getBasicAuth() + ", bearerTokenSecret=" + this.getBearerTokenSecret() + ", enableHttp2=" + this.getEnableHttp2() + ", followRedirects=" + this.getFollowRedirects() + ", noProxy=" + this.getNoProxy() + ", oauth2=" + this.getOauth2() + ", proxyConnectHeader=" + this.getProxyConnectHeader() + ", proxyFromEnvironment=" + this.getProxyFromEnvironment() + ", proxyURL=" + this.getProxyURL() + ", proxyUrl=" + this.getProxyUrl() + ", tlsConfig=" + this.getTlsConfig() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
