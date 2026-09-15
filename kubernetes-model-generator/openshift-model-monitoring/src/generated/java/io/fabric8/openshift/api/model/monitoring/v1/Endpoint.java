
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
 * Endpoint defines an endpoint serving Prometheus metrics to be scraped by Prometheus.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "authorization",
    "basicAuth",
    "bearerTokenFile",
    "bearerTokenSecret",
    "enableHttp2",
    "filterRunning",
    "followRedirects",
    "honorLabels",
    "honorTimestamps",
    "interval",
    "metricRelabelings",
    "noProxy",
    "oauth2",
    "params",
    "path",
    "port",
    "proxyConnectHeader",
    "proxyFromEnvironment",
    "proxyUrl",
    "relabelings",
    "scheme",
    "scrapeTimeout",
    "targetPort",
    "tlsConfig",
    "trackTimestampsStaleness"
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
public class Endpoint implements Editable<EndpointBuilder>, KubernetesResource
{

    @JsonProperty("authorization")
    private SafeAuthorization authorization;
    @JsonProperty("basicAuth")
    private BasicAuth basicAuth;
    @JsonProperty("bearerTokenFile")
    private String bearerTokenFile;
    @JsonProperty("bearerTokenSecret")
    private SecretKeySelector bearerTokenSecret;
    @JsonProperty("enableHttp2")
    private Boolean enableHttp2;
    @JsonProperty("filterRunning")
    private Boolean filterRunning;
    @JsonProperty("followRedirects")
    private Boolean followRedirects;
    @JsonProperty("honorLabels")
    private Boolean honorLabels;
    @JsonProperty("honorTimestamps")
    private Boolean honorTimestamps;
    @JsonProperty("interval")
    private String interval;
    @JsonProperty("metricRelabelings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RelabelConfig> metricRelabelings = new ArrayList<>();
    @JsonProperty("noProxy")
    private String noProxy;
    @JsonProperty("oauth2")
    private OAuth2 oauth2;
    @JsonProperty("params")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, List<String>> params = new LinkedHashMap<>();
    @JsonProperty("path")
    private String path;
    @JsonProperty("port")
    private String port;
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
    @JsonProperty("scrapeTimeout")
    private String scrapeTimeout;
    @JsonProperty("targetPort")
    private IntOrString targetPort;
    @JsonProperty("tlsConfig")
    private TLSConfig tlsConfig;
    @JsonProperty("trackTimestampsStaleness")
    private Boolean trackTimestampsStaleness;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Endpoint() {
    }

    public Endpoint(SafeAuthorization authorization, BasicAuth basicAuth, String bearerTokenFile, SecretKeySelector bearerTokenSecret, Boolean enableHttp2, Boolean filterRunning, Boolean followRedirects, Boolean honorLabels, Boolean honorTimestamps, String interval, List<RelabelConfig> metricRelabelings, String noProxy, OAuth2 oauth2, Map<String, List<String>> params, String path, String port, Map<String, List<SecretKeySelector>> proxyConnectHeader, Boolean proxyFromEnvironment, String proxyUrl, List<RelabelConfig> relabelings, String scheme, String scrapeTimeout, IntOrString targetPort, TLSConfig tlsConfig, Boolean trackTimestampsStaleness) {
        super();
        this.authorization = authorization;
        this.basicAuth = basicAuth;
        this.bearerTokenFile = bearerTokenFile;
        this.bearerTokenSecret = bearerTokenSecret;
        this.enableHttp2 = enableHttp2;
        this.filterRunning = filterRunning;
        this.followRedirects = followRedirects;
        this.honorLabels = honorLabels;
        this.honorTimestamps = honorTimestamps;
        this.interval = interval;
        this.metricRelabelings = metricRelabelings;
        this.noProxy = noProxy;
        this.oauth2 = oauth2;
        this.params = params;
        this.path = path;
        this.port = port;
        this.proxyConnectHeader = proxyConnectHeader;
        this.proxyFromEnvironment = proxyFromEnvironment;
        this.proxyUrl = proxyUrl;
        this.relabelings = relabelings;
        this.scheme = scheme;
        this.scrapeTimeout = scrapeTimeout;
        this.targetPort = targetPort;
        this.tlsConfig = tlsConfig;
        this.trackTimestampsStaleness = trackTimestampsStaleness;
    }

    /**
     * Endpoint defines an endpoint serving Prometheus metrics to be scraped by Prometheus.
     */
    @JsonProperty("authorization")
    public SafeAuthorization getAuthorization() {
        return authorization;
    }

    /**
     * Endpoint defines an endpoint serving Prometheus metrics to be scraped by Prometheus.
     */
    @JsonProperty("authorization")
    public void setAuthorization(SafeAuthorization authorization) {
        this.authorization = authorization;
    }

    /**
     * Endpoint defines an endpoint serving Prometheus metrics to be scraped by Prometheus.
     */
    @JsonProperty("basicAuth")
    public BasicAuth getBasicAuth() {
        return basicAuth;
    }

    /**
     * Endpoint defines an endpoint serving Prometheus metrics to be scraped by Prometheus.
     */
    @JsonProperty("basicAuth")
    public void setBasicAuth(BasicAuth basicAuth) {
        this.basicAuth = basicAuth;
    }

    /**
     * bearerTokenFile defines the file to read bearer token for scraping the target.<br><p> <br><p> Deprecated: use `authorization` instead.
     */
    @JsonProperty("bearerTokenFile")
    public String getBearerTokenFile() {
        return bearerTokenFile;
    }

    /**
     * bearerTokenFile defines the file to read bearer token for scraping the target.<br><p> <br><p> Deprecated: use `authorization` instead.
     */
    @JsonProperty("bearerTokenFile")
    public void setBearerTokenFile(String bearerTokenFile) {
        this.bearerTokenFile = bearerTokenFile;
    }

    /**
     * Endpoint defines an endpoint serving Prometheus metrics to be scraped by Prometheus.
     */
    @JsonProperty("bearerTokenSecret")
    public SecretKeySelector getBearerTokenSecret() {
        return bearerTokenSecret;
    }

    /**
     * Endpoint defines an endpoint serving Prometheus metrics to be scraped by Prometheus.
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
     * filterRunning when true, the pods which are not running (e.g. either in Failed or Succeeded state) are dropped during the target discovery.<br><p> <br><p> If unset, the filtering is enabled.<br><p> <br><p> More info: https://kubernetes.io/docs/concepts/workloads/pods/pod-lifecycle/#pod-phase
     */
    @JsonProperty("filterRunning")
    public Boolean getFilterRunning() {
        return filterRunning;
    }

    /**
     * filterRunning when true, the pods which are not running (e.g. either in Failed or Succeeded state) are dropped during the target discovery.<br><p> <br><p> If unset, the filtering is enabled.<br><p> <br><p> More info: https://kubernetes.io/docs/concepts/workloads/pods/pod-lifecycle/#pod-phase
     */
    @JsonProperty("filterRunning")
    public void setFilterRunning(Boolean filterRunning) {
        this.filterRunning = filterRunning;
    }

    /**
     * followRedirects defines whether the client should follow HTTP 3xx redirects.
     */
    @JsonProperty("followRedirects")
    public Boolean getFollowRedirects() {
        return followRedirects;
    }

    /**
     * followRedirects defines whether the client should follow HTTP 3xx redirects.
     */
    @JsonProperty("followRedirects")
    public void setFollowRedirects(Boolean followRedirects) {
        this.followRedirects = followRedirects;
    }

    /**
     * honorLabels defines when true the metric's labels when they collide with the target's labels.
     */
    @JsonProperty("honorLabels")
    public Boolean getHonorLabels() {
        return honorLabels;
    }

    /**
     * honorLabels defines when true the metric's labels when they collide with the target's labels.
     */
    @JsonProperty("honorLabels")
    public void setHonorLabels(Boolean honorLabels) {
        this.honorLabels = honorLabels;
    }

    /**
     * honorTimestamps defines whether Prometheus preserves the timestamps when exposed by the target.
     */
    @JsonProperty("honorTimestamps")
    public Boolean getHonorTimestamps() {
        return honorTimestamps;
    }

    /**
     * honorTimestamps defines whether Prometheus preserves the timestamps when exposed by the target.
     */
    @JsonProperty("honorTimestamps")
    public void setHonorTimestamps(Boolean honorTimestamps) {
        this.honorTimestamps = honorTimestamps;
    }

    /**
     * interval at which Prometheus scrapes the metrics from the target.<br><p> <br><p> If empty, Prometheus uses the global scrape interval.
     */
    @JsonProperty("interval")
    public String getInterval() {
        return interval;
    }

    /**
     * interval at which Prometheus scrapes the metrics from the target.<br><p> <br><p> If empty, Prometheus uses the global scrape interval.
     */
    @JsonProperty("interval")
    public void setInterval(String interval) {
        this.interval = interval;
    }

    /**
     * metricRelabelings defines the relabeling rules to apply to the samples before ingestion.
     */
    @JsonProperty("metricRelabelings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RelabelConfig> getMetricRelabelings() {
        return metricRelabelings;
    }

    /**
     * metricRelabelings defines the relabeling rules to apply to the samples before ingestion.
     */
    @JsonProperty("metricRelabelings")
    public void setMetricRelabelings(List<RelabelConfig> metricRelabelings) {
        this.metricRelabelings = metricRelabelings;
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
     * Endpoint defines an endpoint serving Prometheus metrics to be scraped by Prometheus.
     */
    @JsonProperty("oauth2")
    public OAuth2 getOauth2() {
        return oauth2;
    }

    /**
     * Endpoint defines an endpoint serving Prometheus metrics to be scraped by Prometheus.
     */
    @JsonProperty("oauth2")
    public void setOauth2(OAuth2 oauth2) {
        this.oauth2 = oauth2;
    }

    /**
     * params define optional HTTP URL parameters.
     */
    @JsonProperty("params")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, List<String>> getParams() {
        return params;
    }

    /**
     * params define optional HTTP URL parameters.
     */
    @JsonProperty("params")
    public void setParams(Map<String, List<String>> params) {
        this.params = params;
    }

    /**
     * path defines the HTTP path from which to scrape for metrics.<br><p> <br><p> If empty, Prometheus uses the default value (e.g. `/metrics`).
     */
    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    /**
     * path defines the HTTP path from which to scrape for metrics.<br><p> <br><p> If empty, Prometheus uses the default value (e.g. `/metrics`).
     */
    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * port defines the name of the Service port which this endpoint refers to.<br><p> <br><p> It takes precedence over `targetPort`.
     */
    @JsonProperty("port")
    public String getPort() {
        return port;
    }

    /**
     * port defines the name of the Service port which this endpoint refers to.<br><p> <br><p> It takes precedence over `targetPort`.
     */
    @JsonProperty("port")
    public void setPort(String port) {
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
     * relabelings defines the relabeling rules to apply the target's metadata labels.<br><p> <br><p> The Operator automatically adds relabelings for a few standard Kubernetes fields.<br><p> <br><p> The original scrape job's name is available via the `__tmp_prometheus_job_name` label.<br><p> <br><p> More info: https://prometheus.io/docs/prometheus/latest/configuration/configuration/#relabel_config
     */
    @JsonProperty("relabelings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RelabelConfig> getRelabelings() {
        return relabelings;
    }

    /**
     * relabelings defines the relabeling rules to apply the target's metadata labels.<br><p> <br><p> The Operator automatically adds relabelings for a few standard Kubernetes fields.<br><p> <br><p> The original scrape job's name is available via the `__tmp_prometheus_job_name` label.<br><p> <br><p> More info: https://prometheus.io/docs/prometheus/latest/configuration/configuration/#relabel_config
     */
    @JsonProperty("relabelings")
    public void setRelabelings(List<RelabelConfig> relabelings) {
        this.relabelings = relabelings;
    }

    /**
     * scheme defines the HTTP scheme to use when scraping the metrics.
     */
    @JsonProperty("scheme")
    public String getScheme() {
        return scheme;
    }

    /**
     * scheme defines the HTTP scheme to use when scraping the metrics.
     */
    @JsonProperty("scheme")
    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    /**
     * scrapeTimeout defines the timeout after which Prometheus considers the scrape to be failed.<br><p> <br><p> If empty, Prometheus uses the global scrape timeout unless it is less than the target's scrape interval value in which the latter is used. The value cannot be greater than the scrape interval otherwise the operator will reject the resource.
     */
    @JsonProperty("scrapeTimeout")
    public String getScrapeTimeout() {
        return scrapeTimeout;
    }

    /**
     * scrapeTimeout defines the timeout after which Prometheus considers the scrape to be failed.<br><p> <br><p> If empty, Prometheus uses the global scrape timeout unless it is less than the target's scrape interval value in which the latter is used. The value cannot be greater than the scrape interval otherwise the operator will reject the resource.
     */
    @JsonProperty("scrapeTimeout")
    public void setScrapeTimeout(String scrapeTimeout) {
        this.scrapeTimeout = scrapeTimeout;
    }

    /**
     * Endpoint defines an endpoint serving Prometheus metrics to be scraped by Prometheus.
     */
    @JsonProperty("targetPort")
    public IntOrString getTargetPort() {
        return targetPort;
    }

    /**
     * Endpoint defines an endpoint serving Prometheus metrics to be scraped by Prometheus.
     */
    @JsonProperty("targetPort")
    public void setTargetPort(IntOrString targetPort) {
        this.targetPort = targetPort;
    }

    /**
     * Endpoint defines an endpoint serving Prometheus metrics to be scraped by Prometheus.
     */
    @JsonProperty("tlsConfig")
    public TLSConfig getTlsConfig() {
        return tlsConfig;
    }

    /**
     * Endpoint defines an endpoint serving Prometheus metrics to be scraped by Prometheus.
     */
    @JsonProperty("tlsConfig")
    public void setTlsConfig(TLSConfig tlsConfig) {
        this.tlsConfig = tlsConfig;
    }

    /**
     * trackTimestampsStaleness defines whether Prometheus tracks staleness of the metrics that have an explicit timestamp present in scraped data. Has no effect if `honorTimestamps` is false.<br><p> <br><p> It requires Prometheus &gt;= v2.48.0.
     */
    @JsonProperty("trackTimestampsStaleness")
    public Boolean getTrackTimestampsStaleness() {
        return trackTimestampsStaleness;
    }

    /**
     * trackTimestampsStaleness defines whether Prometheus tracks staleness of the metrics that have an explicit timestamp present in scraped data. Has no effect if `honorTimestamps` is false.<br><p> <br><p> It requires Prometheus &gt;= v2.48.0.
     */
    @JsonProperty("trackTimestampsStaleness")
    public void setTrackTimestampsStaleness(Boolean trackTimestampsStaleness) {
        this.trackTimestampsStaleness = trackTimestampsStaleness;
    }

    @JsonIgnore
    public EndpointBuilder edit() {
        return new EndpointBuilder(this);
    }

    @JsonIgnore
    public EndpointBuilder toBuilder() {
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
        if (!(o instanceof Endpoint)) {
            return false;
        }
        Endpoint other = (Endpoint) o;
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
        Object this$bearerTokenFile = this.getBearerTokenFile();
        Object other$bearerTokenFile = other.getBearerTokenFile();
        if (this$bearerTokenFile == null ? other$bearerTokenFile != null : !this$bearerTokenFile.equals(other$bearerTokenFile)) {
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
        Object this$filterRunning = this.getFilterRunning();
        Object other$filterRunning = other.getFilterRunning();
        if (this$filterRunning == null ? other$filterRunning != null : !this$filterRunning.equals(other$filterRunning)) {
            return false;
        }
        Object this$followRedirects = this.getFollowRedirects();
        Object other$followRedirects = other.getFollowRedirects();
        if (this$followRedirects == null ? other$followRedirects != null : !this$followRedirects.equals(other$followRedirects)) {
            return false;
        }
        Object this$honorLabels = this.getHonorLabels();
        Object other$honorLabels = other.getHonorLabels();
        if (this$honorLabels == null ? other$honorLabels != null : !this$honorLabels.equals(other$honorLabels)) {
            return false;
        }
        Object this$honorTimestamps = this.getHonorTimestamps();
        Object other$honorTimestamps = other.getHonorTimestamps();
        if (this$honorTimestamps == null ? other$honorTimestamps != null : !this$honorTimestamps.equals(other$honorTimestamps)) {
            return false;
        }
        Object this$interval = this.getInterval();
        Object other$interval = other.getInterval();
        if (this$interval == null ? other$interval != null : !this$interval.equals(other$interval)) {
            return false;
        }
        Object this$metricRelabelings = this.getMetricRelabelings();
        Object other$metricRelabelings = other.getMetricRelabelings();
        if (this$metricRelabelings == null ? other$metricRelabelings != null : !this$metricRelabelings.equals(other$metricRelabelings)) {
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
        Object this$params = this.getParams();
        Object other$params = other.getParams();
        if (this$params == null ? other$params != null : !this$params.equals(other$params)) {
            return false;
        }
        Object this$path = this.getPath();
        Object other$path = other.getPath();
        if (this$path == null ? other$path != null : !this$path.equals(other$path)) {
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
        Object this$scrapeTimeout = this.getScrapeTimeout();
        Object other$scrapeTimeout = other.getScrapeTimeout();
        if (this$scrapeTimeout == null ? other$scrapeTimeout != null : !this$scrapeTimeout.equals(other$scrapeTimeout)) {
            return false;
        }
        Object this$targetPort = this.getTargetPort();
        Object other$targetPort = other.getTargetPort();
        if (this$targetPort == null ? other$targetPort != null : !this$targetPort.equals(other$targetPort)) {
            return false;
        }
        Object this$tlsConfig = this.getTlsConfig();
        Object other$tlsConfig = other.getTlsConfig();
        if (this$tlsConfig == null ? other$tlsConfig != null : !this$tlsConfig.equals(other$tlsConfig)) {
            return false;
        }
        Object this$trackTimestampsStaleness = this.getTrackTimestampsStaleness();
        Object other$trackTimestampsStaleness = other.getTrackTimestampsStaleness();
        if (this$trackTimestampsStaleness == null ? other$trackTimestampsStaleness != null : !this$trackTimestampsStaleness.equals(other$trackTimestampsStaleness)) {
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
        return other instanceof Endpoint;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $authorization = this.getAuthorization();
        result = result * prime + ($authorization == null ? 43 : $authorization.hashCode());
        Object $basicAuth = this.getBasicAuth();
        result = result * prime + ($basicAuth == null ? 43 : $basicAuth.hashCode());
        Object $bearerTokenFile = this.getBearerTokenFile();
        result = result * prime + ($bearerTokenFile == null ? 43 : $bearerTokenFile.hashCode());
        Object $bearerTokenSecret = this.getBearerTokenSecret();
        result = result * prime + ($bearerTokenSecret == null ? 43 : $bearerTokenSecret.hashCode());
        Object $enableHttp2 = this.getEnableHttp2();
        result = result * prime + ($enableHttp2 == null ? 43 : $enableHttp2.hashCode());
        Object $filterRunning = this.getFilterRunning();
        result = result * prime + ($filterRunning == null ? 43 : $filterRunning.hashCode());
        Object $followRedirects = this.getFollowRedirects();
        result = result * prime + ($followRedirects == null ? 43 : $followRedirects.hashCode());
        Object $honorLabels = this.getHonorLabels();
        result = result * prime + ($honorLabels == null ? 43 : $honorLabels.hashCode());
        Object $honorTimestamps = this.getHonorTimestamps();
        result = result * prime + ($honorTimestamps == null ? 43 : $honorTimestamps.hashCode());
        Object $interval = this.getInterval();
        result = result * prime + ($interval == null ? 43 : $interval.hashCode());
        Object $metricRelabelings = this.getMetricRelabelings();
        result = result * prime + ($metricRelabelings == null ? 43 : $metricRelabelings.hashCode());
        Object $noProxy = this.getNoProxy();
        result = result * prime + ($noProxy == null ? 43 : $noProxy.hashCode());
        Object $oauth2 = this.getOauth2();
        result = result * prime + ($oauth2 == null ? 43 : $oauth2.hashCode());
        Object $params = this.getParams();
        result = result * prime + ($params == null ? 43 : $params.hashCode());
        Object $path = this.getPath();
        result = result * prime + ($path == null ? 43 : $path.hashCode());
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
        Object $scrapeTimeout = this.getScrapeTimeout();
        result = result * prime + ($scrapeTimeout == null ? 43 : $scrapeTimeout.hashCode());
        Object $targetPort = this.getTargetPort();
        result = result * prime + ($targetPort == null ? 43 : $targetPort.hashCode());
        Object $tlsConfig = this.getTlsConfig();
        result = result * prime + ($tlsConfig == null ? 43 : $tlsConfig.hashCode());
        Object $trackTimestampsStaleness = this.getTrackTimestampsStaleness();
        result = result * prime + ($trackTimestampsStaleness == null ? 43 : $trackTimestampsStaleness.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Endpoint(" + "authorization=" + this.getAuthorization() + ", basicAuth=" + this.getBasicAuth() + ", bearerTokenFile=" + this.getBearerTokenFile() + ", bearerTokenSecret=" + this.getBearerTokenSecret() + ", enableHttp2=" + this.getEnableHttp2() + ", filterRunning=" + this.getFilterRunning() + ", followRedirects=" + this.getFollowRedirects() + ", honorLabels=" + this.getHonorLabels() + ", honorTimestamps=" + this.getHonorTimestamps() + ", interval=" + this.getInterval() + ", metricRelabelings=" + this.getMetricRelabelings() + ", noProxy=" + this.getNoProxy() + ", oauth2=" + this.getOauth2() + ", params=" + this.getParams() + ", path=" + this.getPath() + ", port=" + this.getPort() + ", proxyConnectHeader=" + this.getProxyConnectHeader() + ", proxyFromEnvironment=" + this.getProxyFromEnvironment() + ", proxyUrl=" + this.getProxyUrl() + ", relabelings=" + this.getRelabelings() + ", scheme=" + this.getScheme() + ", scrapeTimeout=" + this.getScrapeTimeout() + ", targetPort=" + this.getTargetPort() + ", tlsConfig=" + this.getTlsConfig() + ", trackTimestampsStaleness=" + this.getTrackTimestampsStaleness() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
