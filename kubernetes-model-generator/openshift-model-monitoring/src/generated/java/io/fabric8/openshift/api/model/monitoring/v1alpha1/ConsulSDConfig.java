
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
 * ConsulSDConfig defines a Consul service discovery configuration See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#consul_sd_config
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "allowStale",
    "authorization",
    "basicAuth",
    "datacenter",
    "enableHTTP2",
    "filter",
    "followRedirects",
    "namespace",
    "noProxy",
    "nodeMeta",
    "oauth2",
    "partition",
    "pathPrefix",
    "proxyConnectHeader",
    "proxyFromEnvironment",
    "proxyUrl",
    "refreshInterval",
    "scheme",
    "server",
    "services",
    "tagSeparator",
    "tags",
    "tlsConfig",
    "tokenRef"
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
public class ConsulSDConfig implements Editable<ConsulSDConfigBuilder>, KubernetesResource
{

    @JsonProperty("allowStale")
    private Boolean allowStale;
    @JsonProperty("authorization")
    private SafeAuthorization authorization;
    @JsonProperty("basicAuth")
    private BasicAuth basicAuth;
    @JsonProperty("datacenter")
    private String datacenter;
    @JsonProperty("enableHTTP2")
    private Boolean enableHTTP2;
    @JsonProperty("filter")
    private String filter;
    @JsonProperty("followRedirects")
    private Boolean followRedirects;
    @JsonProperty("namespace")
    private String namespace;
    @JsonProperty("noProxy")
    private String noProxy;
    @JsonProperty("nodeMeta")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> nodeMeta = new LinkedHashMap<>();
    @JsonProperty("oauth2")
    private OAuth2 oauth2;
    @JsonProperty("partition")
    private String partition;
    @JsonProperty("pathPrefix")
    private String pathPrefix;
    @JsonProperty("proxyConnectHeader")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, List<SecretKeySelector>> proxyConnectHeader = new LinkedHashMap<>();
    @JsonProperty("proxyFromEnvironment")
    private Boolean proxyFromEnvironment;
    @JsonProperty("proxyUrl")
    private String proxyUrl;
    @JsonProperty("refreshInterval")
    private String refreshInterval;
    @JsonProperty("scheme")
    private String scheme;
    @JsonProperty("server")
    private String server;
    @JsonProperty("services")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> services = new ArrayList<>();
    @JsonProperty("tagSeparator")
    private String tagSeparator;
    @JsonProperty("tags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> tags = new ArrayList<>();
    @JsonProperty("tlsConfig")
    private SafeTLSConfig tlsConfig;
    @JsonProperty("tokenRef")
    private SecretKeySelector tokenRef;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ConsulSDConfig() {
    }

    public ConsulSDConfig(Boolean allowStale, SafeAuthorization authorization, BasicAuth basicAuth, String datacenter, Boolean enableHTTP2, String filter, Boolean followRedirects, String namespace, String noProxy, Map<String, String> nodeMeta, OAuth2 oauth2, String partition, String pathPrefix, Map<String, List<SecretKeySelector>> proxyConnectHeader, Boolean proxyFromEnvironment, String proxyUrl, String refreshInterval, String scheme, String server, List<String> services, String tagSeparator, List<String> tags, SafeTLSConfig tlsConfig, SecretKeySelector tokenRef) {
        super();
        this.allowStale = allowStale;
        this.authorization = authorization;
        this.basicAuth = basicAuth;
        this.datacenter = datacenter;
        this.enableHTTP2 = enableHTTP2;
        this.filter = filter;
        this.followRedirects = followRedirects;
        this.namespace = namespace;
        this.noProxy = noProxy;
        this.nodeMeta = nodeMeta;
        this.oauth2 = oauth2;
        this.partition = partition;
        this.pathPrefix = pathPrefix;
        this.proxyConnectHeader = proxyConnectHeader;
        this.proxyFromEnvironment = proxyFromEnvironment;
        this.proxyUrl = proxyUrl;
        this.refreshInterval = refreshInterval;
        this.scheme = scheme;
        this.server = server;
        this.services = services;
        this.tagSeparator = tagSeparator;
        this.tags = tags;
        this.tlsConfig = tlsConfig;
        this.tokenRef = tokenRef;
    }

    /**
     * Allow stale Consul results (see https://www.consul.io/api/features/consistency.html). Will reduce load on Consul. If unset, Prometheus uses its default value.
     */
    @JsonProperty("allowStale")
    public Boolean getAllowStale() {
        return allowStale;
    }

    /**
     * Allow stale Consul results (see https://www.consul.io/api/features/consistency.html). Will reduce load on Consul. If unset, Prometheus uses its default value.
     */
    @JsonProperty("allowStale")
    public void setAllowStale(Boolean allowStale) {
        this.allowStale = allowStale;
    }

    /**
     * ConsulSDConfig defines a Consul service discovery configuration See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#consul_sd_config
     */
    @JsonProperty("authorization")
    public SafeAuthorization getAuthorization() {
        return authorization;
    }

    /**
     * ConsulSDConfig defines a Consul service discovery configuration See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#consul_sd_config
     */
    @JsonProperty("authorization")
    public void setAuthorization(SafeAuthorization authorization) {
        this.authorization = authorization;
    }

    /**
     * ConsulSDConfig defines a Consul service discovery configuration See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#consul_sd_config
     */
    @JsonProperty("basicAuth")
    public BasicAuth getBasicAuth() {
        return basicAuth;
    }

    /**
     * ConsulSDConfig defines a Consul service discovery configuration See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#consul_sd_config
     */
    @JsonProperty("basicAuth")
    public void setBasicAuth(BasicAuth basicAuth) {
        this.basicAuth = basicAuth;
    }

    /**
     * Consul Datacenter name, if not provided it will use the local Consul Agent Datacenter.
     */
    @JsonProperty("datacenter")
    public String getDatacenter() {
        return datacenter;
    }

    /**
     * Consul Datacenter name, if not provided it will use the local Consul Agent Datacenter.
     */
    @JsonProperty("datacenter")
    public void setDatacenter(String datacenter) {
        this.datacenter = datacenter;
    }

    /**
     * Whether to enable HTTP2. If unset, Prometheus uses its default value.
     */
    @JsonProperty("enableHTTP2")
    public Boolean getEnableHTTP2() {
        return enableHTTP2;
    }

    /**
     * Whether to enable HTTP2. If unset, Prometheus uses its default value.
     */
    @JsonProperty("enableHTTP2")
    public void setEnableHTTP2(Boolean enableHTTP2) {
        this.enableHTTP2 = enableHTTP2;
    }

    /**
     * Filter expression used to filter the catalog results. See https://www.consul.io/api-docs/catalog#list-services It requires Prometheus &gt;= 3.0.0.
     */
    @JsonProperty("filter")
    public String getFilter() {
        return filter;
    }

    /**
     * Filter expression used to filter the catalog results. See https://www.consul.io/api-docs/catalog#list-services It requires Prometheus &gt;= 3.0.0.
     */
    @JsonProperty("filter")
    public void setFilter(String filter) {
        this.filter = filter;
    }

    /**
     * Configure whether HTTP requests follow HTTP 3xx redirects. If unset, Prometheus uses its default value.
     */
    @JsonProperty("followRedirects")
    public Boolean getFollowRedirects() {
        return followRedirects;
    }

    /**
     * Configure whether HTTP requests follow HTTP 3xx redirects. If unset, Prometheus uses its default value.
     */
    @JsonProperty("followRedirects")
    public void setFollowRedirects(Boolean followRedirects) {
        this.followRedirects = followRedirects;
    }

    /**
     * Namespaces are only supported in Consul Enterprise.<br><p> <br><p> It requires Prometheus &gt;= 2.28.0.
     */
    @JsonProperty("namespace")
    public String getNamespace() {
        return namespace;
    }

    /**
     * Namespaces are only supported in Consul Enterprise.<br><p> <br><p> It requires Prometheus &gt;= 2.28.0.
     */
    @JsonProperty("namespace")
    public void setNamespace(String namespace) {
        this.namespace = namespace;
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
     * Node metadata key/value pairs to filter nodes for a given service. Starting with Consul 1.14, it is recommended to use `filter` with the `NodeMeta` selector instead.
     */
    @JsonProperty("nodeMeta")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getNodeMeta() {
        return nodeMeta;
    }

    /**
     * Node metadata key/value pairs to filter nodes for a given service. Starting with Consul 1.14, it is recommended to use `filter` with the `NodeMeta` selector instead.
     */
    @JsonProperty("nodeMeta")
    public void setNodeMeta(Map<String, String> nodeMeta) {
        this.nodeMeta = nodeMeta;
    }

    /**
     * ConsulSDConfig defines a Consul service discovery configuration See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#consul_sd_config
     */
    @JsonProperty("oauth2")
    public OAuth2 getOauth2() {
        return oauth2;
    }

    /**
     * ConsulSDConfig defines a Consul service discovery configuration See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#consul_sd_config
     */
    @JsonProperty("oauth2")
    public void setOauth2(OAuth2 oauth2) {
        this.oauth2 = oauth2;
    }

    /**
     * Admin Partitions are only supported in Consul Enterprise.
     */
    @JsonProperty("partition")
    public String getPartition() {
        return partition;
    }

    /**
     * Admin Partitions are only supported in Consul Enterprise.
     */
    @JsonProperty("partition")
    public void setPartition(String partition) {
        this.partition = partition;
    }

    /**
     * Prefix for URIs for when consul is behind an API gateway (reverse proxy).<br><p> <br><p> It requires Prometheus &gt;= 2.45.0.
     */
    @JsonProperty("pathPrefix")
    public String getPathPrefix() {
        return pathPrefix;
    }

    /**
     * Prefix for URIs for when consul is behind an API gateway (reverse proxy).<br><p> <br><p> It requires Prometheus &gt;= 2.45.0.
     */
    @JsonProperty("pathPrefix")
    public void setPathPrefix(String pathPrefix) {
        this.pathPrefix = pathPrefix;
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
     * The time after which the provided names are refreshed. On large setup it might be a good idea to increase this value because the catalog will change all the time. If unset, Prometheus uses its default value.
     */
    @JsonProperty("refreshInterval")
    public String getRefreshInterval() {
        return refreshInterval;
    }

    /**
     * The time after which the provided names are refreshed. On large setup it might be a good idea to increase this value because the catalog will change all the time. If unset, Prometheus uses its default value.
     */
    @JsonProperty("refreshInterval")
    public void setRefreshInterval(String refreshInterval) {
        this.refreshInterval = refreshInterval;
    }

    /**
     * HTTP Scheme default "http"
     */
    @JsonProperty("scheme")
    public String getScheme() {
        return scheme;
    }

    /**
     * HTTP Scheme default "http"
     */
    @JsonProperty("scheme")
    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    /**
     * Consul server address. A valid string consisting of a hostname or IP followed by an optional port number.
     */
    @JsonProperty("server")
    public String getServer() {
        return server;
    }

    /**
     * Consul server address. A valid string consisting of a hostname or IP followed by an optional port number.
     */
    @JsonProperty("server")
    public void setServer(String server) {
        this.server = server;
    }

    /**
     * A list of services for which targets are retrieved. If omitted, all services are scraped.
     */
    @JsonProperty("services")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getServices() {
        return services;
    }

    /**
     * A list of services for which targets are retrieved. If omitted, all services are scraped.
     */
    @JsonProperty("services")
    public void setServices(List<String> services) {
        this.services = services;
    }

    /**
     * The string by which Consul tags are joined into the tag label. If unset, Prometheus uses its default value.
     */
    @JsonProperty("tagSeparator")
    public String getTagSeparator() {
        return tagSeparator;
    }

    /**
     * The string by which Consul tags are joined into the tag label. If unset, Prometheus uses its default value.
     */
    @JsonProperty("tagSeparator")
    public void setTagSeparator(String tagSeparator) {
        this.tagSeparator = tagSeparator;
    }

    /**
     * An optional list of tags used to filter nodes for a given service. Services must contain all tags in the list. Starting with Consul 1.14, it is recommended to use `filter` with the `ServiceTags` selector instead.
     */
    @JsonProperty("tags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getTags() {
        return tags;
    }

    /**
     * An optional list of tags used to filter nodes for a given service. Services must contain all tags in the list. Starting with Consul 1.14, it is recommended to use `filter` with the `ServiceTags` selector instead.
     */
    @JsonProperty("tags")
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    /**
     * ConsulSDConfig defines a Consul service discovery configuration See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#consul_sd_config
     */
    @JsonProperty("tlsConfig")
    public SafeTLSConfig getTlsConfig() {
        return tlsConfig;
    }

    /**
     * ConsulSDConfig defines a Consul service discovery configuration See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#consul_sd_config
     */
    @JsonProperty("tlsConfig")
    public void setTlsConfig(SafeTLSConfig tlsConfig) {
        this.tlsConfig = tlsConfig;
    }

    /**
     * ConsulSDConfig defines a Consul service discovery configuration See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#consul_sd_config
     */
    @JsonProperty("tokenRef")
    public SecretKeySelector getTokenRef() {
        return tokenRef;
    }

    /**
     * ConsulSDConfig defines a Consul service discovery configuration See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#consul_sd_config
     */
    @JsonProperty("tokenRef")
    public void setTokenRef(SecretKeySelector tokenRef) {
        this.tokenRef = tokenRef;
    }

    @JsonIgnore
    public ConsulSDConfigBuilder edit() {
        return new ConsulSDConfigBuilder(this);
    }

    @JsonIgnore
    public ConsulSDConfigBuilder toBuilder() {
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
