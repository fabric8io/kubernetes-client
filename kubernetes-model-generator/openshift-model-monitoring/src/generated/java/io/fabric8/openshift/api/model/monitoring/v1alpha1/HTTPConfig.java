
package io.fabric8.openshift.api.model.monitoring.v1alpha1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * HTTPConfig defines a client HTTP configuration. See https://prometheus.io/docs/alerting/latest/configuration/#http_config
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "authorization",
    "basicAuth",
    "bearerTokenSecret",
    "followRedirects",
    "noProxy",
    "oauth2",
    "proxyConnectHeader",
    "proxyFromEnvironment",
    "proxyURL",
    "proxyUrl",
    "tlsConfig"
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
public class HTTPConfig implements Editable<HTTPConfigBuilder>, KubernetesResource
{

    @JsonProperty("authorization")
    private SafeAuthorization authorization;
    @JsonProperty("basicAuth")
    private BasicAuth basicAuth;
    @JsonProperty("bearerTokenSecret")
    private SecretKeySelector bearerTokenSecret;
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

    public HTTPConfig(SafeAuthorization authorization, BasicAuth basicAuth, SecretKeySelector bearerTokenSecret, Boolean followRedirects, String noProxy, OAuth2 oauth2, Map<String, List<SecretKeySelector>> proxyConnectHeader, Boolean proxyFromEnvironment, String proxyURL, String proxyUrl, SafeTLSConfig tlsConfig) {
        super();
        this.authorization = authorization;
        this.basicAuth = basicAuth;
        this.bearerTokenSecret = bearerTokenSecret;
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
     * FollowRedirects specifies whether the client should follow HTTP 3xx redirects.
     */
    @JsonProperty("followRedirects")
    public Boolean getFollowRedirects() {
        return followRedirects;
    }

    /**
     * FollowRedirects specifies whether the client should follow HTTP 3xx redirects.
     */
    @JsonProperty("followRedirects")
    public void setFollowRedirects(Boolean followRedirects) {
        this.followRedirects = followRedirects;
    }

    /**
     * `noProxy` is a comma-separated string that can contain IPs, CIDR notation, domain names that should be excluded from proxying. IP and domain names can contain port numbers.<br><p> <br><p> It requires Prometheus &gt;= v2.43.0 or Alertmanager &gt;= 0.25.0.
     */
    @JsonProperty("noProxy")
    public String getNoProxy() {
        return noProxy;
    }

    /**
     * `noProxy` is a comma-separated string that can contain IPs, CIDR notation, domain names that should be excluded from proxying. IP and domain names can contain port numbers.<br><p> <br><p> It requires Prometheus &gt;= v2.43.0 or Alertmanager &gt;= 0.25.0.
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
     * ProxyConnectHeader optionally specifies headers to send to proxies during CONNECT requests.<br><p> <br><p> It requires Prometheus &gt;= v2.43.0 or Alertmanager &gt;= 0.25.0.
     */
    @JsonProperty("proxyConnectHeader")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, List<SecretKeySelector>> getProxyConnectHeader() {
        return proxyConnectHeader;
    }

    /**
     * ProxyConnectHeader optionally specifies headers to send to proxies during CONNECT requests.<br><p> <br><p> It requires Prometheus &gt;= v2.43.0 or Alertmanager &gt;= 0.25.0.
     */
    @JsonProperty("proxyConnectHeader")
    public void setProxyConnectHeader(Map<String, List<SecretKeySelector>> proxyConnectHeader) {
        this.proxyConnectHeader = proxyConnectHeader;
    }

    /**
     * Whether to use the proxy configuration defined by environment variables (HTTP_PROXY, HTTPS_PROXY, and NO_PROXY).<br><p> <br><p> It requires Prometheus &gt;= v2.43.0 or Alertmanager &gt;= 0.25.0.
     */
    @JsonProperty("proxyFromEnvironment")
    public Boolean getProxyFromEnvironment() {
        return proxyFromEnvironment;
    }

    /**
     * Whether to use the proxy configuration defined by environment variables (HTTP_PROXY, HTTPS_PROXY, and NO_PROXY).<br><p> <br><p> It requires Prometheus &gt;= v2.43.0 or Alertmanager &gt;= 0.25.0.
     */
    @JsonProperty("proxyFromEnvironment")
    public void setProxyFromEnvironment(Boolean proxyFromEnvironment) {
        this.proxyFromEnvironment = proxyFromEnvironment;
    }

    /**
     * Optional proxy URL.<br><p> <br><p> If defined, this field takes precedence over `proxyUrl`.
     */
    @JsonProperty("proxyURL")
    public String getProxyURL() {
        return proxyURL;
    }

    /**
     * Optional proxy URL.<br><p> <br><p> If defined, this field takes precedence over `proxyUrl`.
     */
    @JsonProperty("proxyURL")
    public void setProxyURL(String proxyURL) {
        this.proxyURL = proxyURL;
    }

    /**
     * `proxyURL` defines the HTTP proxy server to use.
     */
    @JsonProperty("proxyUrl")
    public String getProxyUrl() {
        return proxyUrl;
    }

    /**
     * `proxyURL` defines the HTTP proxy server to use.
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

}
