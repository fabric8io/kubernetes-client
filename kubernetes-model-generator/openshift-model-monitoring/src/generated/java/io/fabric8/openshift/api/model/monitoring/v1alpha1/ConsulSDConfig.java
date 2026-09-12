
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
    "healthFilter",
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
    @JsonProperty("healthFilter")
    private String healthFilter;
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

    public ConsulSDConfig(Boolean allowStale, SafeAuthorization authorization, BasicAuth basicAuth, String datacenter, Boolean enableHTTP2, String filter, Boolean followRedirects, String healthFilter, String namespace, String noProxy, Map<String, String> nodeMeta, OAuth2 oauth2, String partition, String pathPrefix, Map<String, List<SecretKeySelector>> proxyConnectHeader, Boolean proxyFromEnvironment, String proxyUrl, String refreshInterval, String scheme, String server, List<String> services, String tagSeparator, List<String> tags, SafeTLSConfig tlsConfig, SecretKeySelector tokenRef) {
        super();
        this.allowStale = allowStale;
        this.authorization = authorization;
        this.basicAuth = basicAuth;
        this.datacenter = datacenter;
        this.enableHTTP2 = enableHTTP2;
        this.filter = filter;
        this.followRedirects = followRedirects;
        this.healthFilter = healthFilter;
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
     * allowStale Consul results (see https://www.consul.io/api/features/consistency.html). Will reduce load on Consul. If unset, Prometheus uses its default value.
     */
    @JsonProperty("allowStale")
    public Boolean getAllowStale() {
        return allowStale;
    }

    /**
     * allowStale Consul results (see https://www.consul.io/api/features/consistency.html). Will reduce load on Consul. If unset, Prometheus uses its default value.
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
     * datacenter defines the consul Datacenter name, if not provided it will use the local Consul Agent Datacenter.
     */
    @JsonProperty("datacenter")
    public String getDatacenter() {
        return datacenter;
    }

    /**
     * datacenter defines the consul Datacenter name, if not provided it will use the local Consul Agent Datacenter.
     */
    @JsonProperty("datacenter")
    public void setDatacenter(String datacenter) {
        this.datacenter = datacenter;
    }

    /**
     * enableHTTP2 defines whether to enable HTTP2.
     */
    @JsonProperty("enableHTTP2")
    public Boolean getEnableHTTP2() {
        return enableHTTP2;
    }

    /**
     * enableHTTP2 defines whether to enable HTTP2.
     */
    @JsonProperty("enableHTTP2")
    public void setEnableHTTP2(Boolean enableHTTP2) {
        this.enableHTTP2 = enableHTTP2;
    }

    /**
     * filter defines the filter expression used to filter the catalog results. See https://developer.hashicorp.com/consul/api-docs/catalog#filtering It requires Prometheus &gt;= 3.0.0.
     */
    @JsonProperty("filter")
    public String getFilter() {
        return filter;
    }

    /**
     * filter defines the filter expression used to filter the catalog results. See https://developer.hashicorp.com/consul/api-docs/catalog#filtering It requires Prometheus &gt;= 3.0.0.
     */
    @JsonProperty("filter")
    public void setFilter(String filter) {
        this.filter = filter;
    }

    /**
     * followRedirects defines whether HTTP requests follow HTTP 3xx redirects.
     */
    @JsonProperty("followRedirects")
    public Boolean getFollowRedirects() {
        return followRedirects;
    }

    /**
     * followRedirects defines whether HTTP requests follow HTTP 3xx redirects.
     */
    @JsonProperty("followRedirects")
    public void setFollowRedirects(Boolean followRedirects) {
        this.followRedirects = followRedirects;
    }

    /**
     * healthFilter defines the filter expression used to filter the health results. See https://developer.hashicorp.com/consul/api-docs/health#filtering It requires Prometheus &gt;= 3.11.2.
     */
    @JsonProperty("healthFilter")
    public String getHealthFilter() {
        return healthFilter;
    }

    /**
     * healthFilter defines the filter expression used to filter the health results. See https://developer.hashicorp.com/consul/api-docs/health#filtering It requires Prometheus &gt;= 3.11.2.
     */
    @JsonProperty("healthFilter")
    public void setHealthFilter(String healthFilter) {
        this.healthFilter = healthFilter;
    }

    /**
     * namespace are only supported in Consul Enterprise.<br><p> <br><p> It requires Prometheus &gt;= 2.28.0.
     */
    @JsonProperty("namespace")
    public String getNamespace() {
        return namespace;
    }

    /**
     * namespace are only supported in Consul Enterprise.<br><p> <br><p> It requires Prometheus &gt;= 2.28.0.
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
     * nodeMeta defines the node metadata key/value pairs to filter nodes for a given service. Starting with Consul 1.14, it is recommended to use `filter` with the `NodeMeta` selector instead.
     */
    @JsonProperty("nodeMeta")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getNodeMeta() {
        return nodeMeta;
    }

    /**
     * nodeMeta defines the node metadata key/value pairs to filter nodes for a given service. Starting with Consul 1.14, it is recommended to use `filter` with the `NodeMeta` selector instead.
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
     * partition defines the admin Partitions are only supported in Consul Enterprise.
     */
    @JsonProperty("partition")
    public String getPartition() {
        return partition;
    }

    /**
     * partition defines the admin Partitions are only supported in Consul Enterprise.
     */
    @JsonProperty("partition")
    public void setPartition(String partition) {
        this.partition = partition;
    }

    /**
     * pathPrefix defines the prefix for URIs for when consul is behind an API gateway (reverse proxy).<br><p> <br><p> It requires Prometheus &gt;= 2.45.0.
     */
    @JsonProperty("pathPrefix")
    public String getPathPrefix() {
        return pathPrefix;
    }

    /**
     * pathPrefix defines the prefix for URIs for when consul is behind an API gateway (reverse proxy).<br><p> <br><p> It requires Prometheus &gt;= 2.45.0.
     */
    @JsonProperty("pathPrefix")
    public void setPathPrefix(String pathPrefix) {
        this.pathPrefix = pathPrefix;
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
     * refreshInterval defines the time after which the provided names are refreshed. If not set, Prometheus uses its default value.
     */
    @JsonProperty("refreshInterval")
    public String getRefreshInterval() {
        return refreshInterval;
    }

    /**
     * refreshInterval defines the time after which the provided names are refreshed. If not set, Prometheus uses its default value.
     */
    @JsonProperty("refreshInterval")
    public void setRefreshInterval(String refreshInterval) {
        this.refreshInterval = refreshInterval;
    }

    /**
     * scheme defines the HTTP Scheme.
     */
    @JsonProperty("scheme")
    public String getScheme() {
        return scheme;
    }

    /**
     * scheme defines the HTTP Scheme.
     */
    @JsonProperty("scheme")
    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    /**
     * server defines the consul server address. A valid string consisting of a hostname or IP followed by an optional port number.
     */
    @JsonProperty("server")
    public String getServer() {
        return server;
    }

    /**
     * server defines the consul server address. A valid string consisting of a hostname or IP followed by an optional port number.
     */
    @JsonProperty("server")
    public void setServer(String server) {
        this.server = server;
    }

    /**
     * services defines a list of services for which targets are retrieved. If omitted, all services are scraped.
     */
    @JsonProperty("services")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getServices() {
        return services;
    }

    /**
     * services defines a list of services for which targets are retrieved. If omitted, all services are scraped.
     */
    @JsonProperty("services")
    public void setServices(List<String> services) {
        this.services = services;
    }

    /**
     * tagSeparator defines the string by which Consul tags are joined into the tag label. If unset, Prometheus uses its default value.
     */
    @JsonProperty("tagSeparator")
    public String getTagSeparator() {
        return tagSeparator;
    }

    /**
     * tagSeparator defines the string by which Consul tags are joined into the tag label. If unset, Prometheus uses its default value.
     */
    @JsonProperty("tagSeparator")
    public void setTagSeparator(String tagSeparator) {
        this.tagSeparator = tagSeparator;
    }

    /**
     * tags defines an optional list of tags used to filter nodes for a given service. Services must contain all tags in the list. Starting with Consul 1.14, it is recommended to use `filter` with the `ServiceTags` selector instead.
     */
    @JsonProperty("tags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getTags() {
        return tags;
    }

    /**
     * tags defines an optional list of tags used to filter nodes for a given service. Services must contain all tags in the list. Starting with Consul 1.14, it is recommended to use `filter` with the `ServiceTags` selector instead.
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ConsulSDConfig)) {
            return false;
        }
        ConsulSDConfig other = (ConsulSDConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$allowStale = this.getAllowStale();
        Object other$allowStale = other.getAllowStale();
        if (this$allowStale == null ? other$allowStale != null : !this$allowStale.equals(other$allowStale)) {
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
        Object this$datacenter = this.getDatacenter();
        Object other$datacenter = other.getDatacenter();
        if (this$datacenter == null ? other$datacenter != null : !this$datacenter.equals(other$datacenter)) {
            return false;
        }
        Object this$enableHTTP2 = this.getEnableHTTP2();
        Object other$enableHTTP2 = other.getEnableHTTP2();
        if (this$enableHTTP2 == null ? other$enableHTTP2 != null : !this$enableHTTP2.equals(other$enableHTTP2)) {
            return false;
        }
        Object this$filter = this.getFilter();
        Object other$filter = other.getFilter();
        if (this$filter == null ? other$filter != null : !this$filter.equals(other$filter)) {
            return false;
        }
        Object this$followRedirects = this.getFollowRedirects();
        Object other$followRedirects = other.getFollowRedirects();
        if (this$followRedirects == null ? other$followRedirects != null : !this$followRedirects.equals(other$followRedirects)) {
            return false;
        }
        Object this$healthFilter = this.getHealthFilter();
        Object other$healthFilter = other.getHealthFilter();
        if (this$healthFilter == null ? other$healthFilter != null : !this$healthFilter.equals(other$healthFilter)) {
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
        Object this$nodeMeta = this.getNodeMeta();
        Object other$nodeMeta = other.getNodeMeta();
        if (this$nodeMeta == null ? other$nodeMeta != null : !this$nodeMeta.equals(other$nodeMeta)) {
            return false;
        }
        Object this$oauth2 = this.getOauth2();
        Object other$oauth2 = other.getOauth2();
        if (this$oauth2 == null ? other$oauth2 != null : !this$oauth2.equals(other$oauth2)) {
            return false;
        }
        Object this$partition = this.getPartition();
        Object other$partition = other.getPartition();
        if (this$partition == null ? other$partition != null : !this$partition.equals(other$partition)) {
            return false;
        }
        Object this$pathPrefix = this.getPathPrefix();
        Object other$pathPrefix = other.getPathPrefix();
        if (this$pathPrefix == null ? other$pathPrefix != null : !this$pathPrefix.equals(other$pathPrefix)) {
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
        Object this$refreshInterval = this.getRefreshInterval();
        Object other$refreshInterval = other.getRefreshInterval();
        if (this$refreshInterval == null ? other$refreshInterval != null : !this$refreshInterval.equals(other$refreshInterval)) {
            return false;
        }
        Object this$scheme = this.getScheme();
        Object other$scheme = other.getScheme();
        if (this$scheme == null ? other$scheme != null : !this$scheme.equals(other$scheme)) {
            return false;
        }
        Object this$server = this.getServer();
        Object other$server = other.getServer();
        if (this$server == null ? other$server != null : !this$server.equals(other$server)) {
            return false;
        }
        Object this$services = this.getServices();
        Object other$services = other.getServices();
        if (this$services == null ? other$services != null : !this$services.equals(other$services)) {
            return false;
        }
        Object this$tagSeparator = this.getTagSeparator();
        Object other$tagSeparator = other.getTagSeparator();
        if (this$tagSeparator == null ? other$tagSeparator != null : !this$tagSeparator.equals(other$tagSeparator)) {
            return false;
        }
        Object this$tags = this.getTags();
        Object other$tags = other.getTags();
        if (this$tags == null ? other$tags != null : !this$tags.equals(other$tags)) {
            return false;
        }
        Object this$tlsConfig = this.getTlsConfig();
        Object other$tlsConfig = other.getTlsConfig();
        if (this$tlsConfig == null ? other$tlsConfig != null : !this$tlsConfig.equals(other$tlsConfig)) {
            return false;
        }
        Object this$tokenRef = this.getTokenRef();
        Object other$tokenRef = other.getTokenRef();
        if (this$tokenRef == null ? other$tokenRef != null : !this$tokenRef.equals(other$tokenRef)) {
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
        return other instanceof ConsulSDConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $allowStale = this.getAllowStale();
        result = result * prime + ($allowStale == null ? 43 : $allowStale.hashCode());
        Object $authorization = this.getAuthorization();
        result = result * prime + ($authorization == null ? 43 : $authorization.hashCode());
        Object $basicAuth = this.getBasicAuth();
        result = result * prime + ($basicAuth == null ? 43 : $basicAuth.hashCode());
        Object $datacenter = this.getDatacenter();
        result = result * prime + ($datacenter == null ? 43 : $datacenter.hashCode());
        Object $enableHTTP2 = this.getEnableHTTP2();
        result = result * prime + ($enableHTTP2 == null ? 43 : $enableHTTP2.hashCode());
        Object $filter = this.getFilter();
        result = result * prime + ($filter == null ? 43 : $filter.hashCode());
        Object $followRedirects = this.getFollowRedirects();
        result = result * prime + ($followRedirects == null ? 43 : $followRedirects.hashCode());
        Object $healthFilter = this.getHealthFilter();
        result = result * prime + ($healthFilter == null ? 43 : $healthFilter.hashCode());
        Object $namespace = this.getNamespace();
        result = result * prime + ($namespace == null ? 43 : $namespace.hashCode());
        Object $noProxy = this.getNoProxy();
        result = result * prime + ($noProxy == null ? 43 : $noProxy.hashCode());
        Object $nodeMeta = this.getNodeMeta();
        result = result * prime + ($nodeMeta == null ? 43 : $nodeMeta.hashCode());
        Object $oauth2 = this.getOauth2();
        result = result * prime + ($oauth2 == null ? 43 : $oauth2.hashCode());
        Object $partition = this.getPartition();
        result = result * prime + ($partition == null ? 43 : $partition.hashCode());
        Object $pathPrefix = this.getPathPrefix();
        result = result * prime + ($pathPrefix == null ? 43 : $pathPrefix.hashCode());
        Object $proxyConnectHeader = this.getProxyConnectHeader();
        result = result * prime + ($proxyConnectHeader == null ? 43 : $proxyConnectHeader.hashCode());
        Object $proxyFromEnvironment = this.getProxyFromEnvironment();
        result = result * prime + ($proxyFromEnvironment == null ? 43 : $proxyFromEnvironment.hashCode());
        Object $proxyUrl = this.getProxyUrl();
        result = result * prime + ($proxyUrl == null ? 43 : $proxyUrl.hashCode());
        Object $refreshInterval = this.getRefreshInterval();
        result = result * prime + ($refreshInterval == null ? 43 : $refreshInterval.hashCode());
        Object $scheme = this.getScheme();
        result = result * prime + ($scheme == null ? 43 : $scheme.hashCode());
        Object $server = this.getServer();
        result = result * prime + ($server == null ? 43 : $server.hashCode());
        Object $services = this.getServices();
        result = result * prime + ($services == null ? 43 : $services.hashCode());
        Object $tagSeparator = this.getTagSeparator();
        result = result * prime + ($tagSeparator == null ? 43 : $tagSeparator.hashCode());
        Object $tags = this.getTags();
        result = result * prime + ($tags == null ? 43 : $tags.hashCode());
        Object $tlsConfig = this.getTlsConfig();
        result = result * prime + ($tlsConfig == null ? 43 : $tlsConfig.hashCode());
        Object $tokenRef = this.getTokenRef();
        result = result * prime + ($tokenRef == null ? 43 : $tokenRef.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ConsulSDConfig(" + "allowStale=" + this.getAllowStale() + ", authorization=" + this.getAuthorization() + ", basicAuth=" + this.getBasicAuth() + ", datacenter=" + this.getDatacenter() + ", enableHTTP2=" + this.getEnableHTTP2() + ", filter=" + this.getFilter() + ", followRedirects=" + this.getFollowRedirects() + ", healthFilter=" + this.getHealthFilter() + ", namespace=" + this.getNamespace() + ", noProxy=" + this.getNoProxy() + ", nodeMeta=" + this.getNodeMeta() + ", oauth2=" + this.getOauth2() + ", partition=" + this.getPartition() + ", pathPrefix=" + this.getPathPrefix() + ", proxyConnectHeader=" + this.getProxyConnectHeader() + ", proxyFromEnvironment=" + this.getProxyFromEnvironment() + ", proxyUrl=" + this.getProxyUrl() + ", refreshInterval=" + this.getRefreshInterval() + ", scheme=" + this.getScheme() + ", server=" + this.getServer() + ", services=" + this.getServices() + ", tagSeparator=" + this.getTagSeparator() + ", tags=" + this.getTags() + ", tlsConfig=" + this.getTlsConfig() + ", tokenRef=" + this.getTokenRef() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
