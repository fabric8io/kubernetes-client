
package io.fabric8.openshift.api.model.monitoring.v1alpha1;

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
 * DockerSwarmSDConfig configurations allow retrieving scrape targets from Docker Swarm engine. See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#dockerswarm_sd_config
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "authorization",
    "basicAuth",
    "enableHTTP2",
    "filters",
    "followRedirects",
    "host",
    "noProxy",
    "oauth2",
    "port",
    "proxyConnectHeader",
    "proxyFromEnvironment",
    "proxyUrl",
    "refreshInterval",
    "role",
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
public class DockerSwarmSDConfig implements Editable<DockerSwarmSDConfigBuilder>, KubernetesResource
{

    @JsonProperty("authorization")
    private SafeAuthorization authorization;
    @JsonProperty("basicAuth")
    private BasicAuth basicAuth;
    @JsonProperty("enableHTTP2")
    private Boolean enableHTTP2;
    @JsonProperty("filters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Filter> filters = new ArrayList<>();
    @JsonProperty("followRedirects")
    private Boolean followRedirects;
    @JsonProperty("host")
    private String host;
    @JsonProperty("noProxy")
    private String noProxy;
    @JsonProperty("oauth2")
    private OAuth2 oauth2;
    @JsonProperty("port")
    private Integer port;
    @JsonProperty("proxyConnectHeader")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, List<SecretKeySelector>> proxyConnectHeader = new LinkedHashMap<>();
    @JsonProperty("proxyFromEnvironment")
    private Boolean proxyFromEnvironment;
    @JsonProperty("proxyUrl")
    private String proxyUrl;
    @JsonProperty("refreshInterval")
    private String refreshInterval;
    @JsonProperty("role")
    private String role;
    @JsonProperty("tlsConfig")
    private SafeTLSConfig tlsConfig;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DockerSwarmSDConfig() {
    }

    public DockerSwarmSDConfig(SafeAuthorization authorization, BasicAuth basicAuth, Boolean enableHTTP2, List<Filter> filters, Boolean followRedirects, String host, String noProxy, OAuth2 oauth2, Integer port, Map<String, List<SecretKeySelector>> proxyConnectHeader, Boolean proxyFromEnvironment, String proxyUrl, String refreshInterval, String role, SafeTLSConfig tlsConfig) {
        super();
        this.authorization = authorization;
        this.basicAuth = basicAuth;
        this.enableHTTP2 = enableHTTP2;
        this.filters = filters;
        this.followRedirects = followRedirects;
        this.host = host;
        this.noProxy = noProxy;
        this.oauth2 = oauth2;
        this.port = port;
        this.proxyConnectHeader = proxyConnectHeader;
        this.proxyFromEnvironment = proxyFromEnvironment;
        this.proxyUrl = proxyUrl;
        this.refreshInterval = refreshInterval;
        this.role = role;
        this.tlsConfig = tlsConfig;
    }

    /**
     * DockerSwarmSDConfig configurations allow retrieving scrape targets from Docker Swarm engine. See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#dockerswarm_sd_config
     */
    @JsonProperty("authorization")
    public SafeAuthorization getAuthorization() {
        return authorization;
    }

    /**
     * DockerSwarmSDConfig configurations allow retrieving scrape targets from Docker Swarm engine. See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#dockerswarm_sd_config
     */
    @JsonProperty("authorization")
    public void setAuthorization(SafeAuthorization authorization) {
        this.authorization = authorization;
    }

    /**
     * DockerSwarmSDConfig configurations allow retrieving scrape targets from Docker Swarm engine. See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#dockerswarm_sd_config
     */
    @JsonProperty("basicAuth")
    public BasicAuth getBasicAuth() {
        return basicAuth;
    }

    /**
     * DockerSwarmSDConfig configurations allow retrieving scrape targets from Docker Swarm engine. See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#dockerswarm_sd_config
     */
    @JsonProperty("basicAuth")
    public void setBasicAuth(BasicAuth basicAuth) {
        this.basicAuth = basicAuth;
    }

    /**
     * Whether to enable HTTP2.
     */
    @JsonProperty("enableHTTP2")
    public Boolean getEnableHTTP2() {
        return enableHTTP2;
    }

    /**
     * Whether to enable HTTP2.
     */
    @JsonProperty("enableHTTP2")
    public void setEnableHTTP2(Boolean enableHTTP2) {
        this.enableHTTP2 = enableHTTP2;
    }

    /**
     * Optional filters to limit the discovery process to a subset of available resources. The available filters are listed in the upstream documentation: Services: https://docs.docker.com/engine/api/v1.40/#operation/ServiceList Tasks: https://docs.docker.com/engine/api/v1.40/#operation/TaskList Nodes: https://docs.docker.com/engine/api/v1.40/#operation/NodeList
     */
    @JsonProperty("filters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Filter> getFilters() {
        return filters;
    }

    /**
     * Optional filters to limit the discovery process to a subset of available resources. The available filters are listed in the upstream documentation: Services: https://docs.docker.com/engine/api/v1.40/#operation/ServiceList Tasks: https://docs.docker.com/engine/api/v1.40/#operation/TaskList Nodes: https://docs.docker.com/engine/api/v1.40/#operation/NodeList
     */
    @JsonProperty("filters")
    public void setFilters(List<Filter> filters) {
        this.filters = filters;
    }

    /**
     * Configure whether HTTP requests follow HTTP 3xx redirects.
     */
    @JsonProperty("followRedirects")
    public Boolean getFollowRedirects() {
        return followRedirects;
    }

    /**
     * Configure whether HTTP requests follow HTTP 3xx redirects.
     */
    @JsonProperty("followRedirects")
    public void setFollowRedirects(Boolean followRedirects) {
        this.followRedirects = followRedirects;
    }

    /**
     * Address of the Docker daemon
     */
    @JsonProperty("host")
    public String getHost() {
        return host;
    }

    /**
     * Address of the Docker daemon
     */
    @JsonProperty("host")
    public void setHost(String host) {
        this.host = host;
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
     * DockerSwarmSDConfig configurations allow retrieving scrape targets from Docker Swarm engine. See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#dockerswarm_sd_config
     */
    @JsonProperty("oauth2")
    public OAuth2 getOauth2() {
        return oauth2;
    }

    /**
     * DockerSwarmSDConfig configurations allow retrieving scrape targets from Docker Swarm engine. See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#dockerswarm_sd_config
     */
    @JsonProperty("oauth2")
    public void setOauth2(OAuth2 oauth2) {
        this.oauth2 = oauth2;
    }

    /**
     * The port to scrape metrics from, when `role` is nodes, and for discovered tasks and services that don't have published ports.
     */
    @JsonProperty("port")
    public Integer getPort() {
        return port;
    }

    /**
     * The port to scrape metrics from, when `role` is nodes, and for discovered tasks and services that don't have published ports.
     */
    @JsonProperty("port")
    public void setPort(Integer port) {
        this.port = port;
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
     * The time after which the service discovery data is refreshed.
     */
    @JsonProperty("refreshInterval")
    public String getRefreshInterval() {
        return refreshInterval;
    }

    /**
     * The time after which the service discovery data is refreshed.
     */
    @JsonProperty("refreshInterval")
    public void setRefreshInterval(String refreshInterval) {
        this.refreshInterval = refreshInterval;
    }

    /**
     * Role of the targets to retrieve. Must be `Services`, `Tasks`, or `Nodes`.
     */
    @JsonProperty("role")
    public String getRole() {
        return role;
    }

    /**
     * Role of the targets to retrieve. Must be `Services`, `Tasks`, or `Nodes`.
     */
    @JsonProperty("role")
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * DockerSwarmSDConfig configurations allow retrieving scrape targets from Docker Swarm engine. See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#dockerswarm_sd_config
     */
    @JsonProperty("tlsConfig")
    public SafeTLSConfig getTlsConfig() {
        return tlsConfig;
    }

    /**
     * DockerSwarmSDConfig configurations allow retrieving scrape targets from Docker Swarm engine. See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#dockerswarm_sd_config
     */
    @JsonProperty("tlsConfig")
    public void setTlsConfig(SafeTLSConfig tlsConfig) {
        this.tlsConfig = tlsConfig;
    }

    @JsonIgnore
    public DockerSwarmSDConfigBuilder edit() {
        return new DockerSwarmSDConfigBuilder(this);
    }

    @JsonIgnore
    public DockerSwarmSDConfigBuilder toBuilder() {
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
