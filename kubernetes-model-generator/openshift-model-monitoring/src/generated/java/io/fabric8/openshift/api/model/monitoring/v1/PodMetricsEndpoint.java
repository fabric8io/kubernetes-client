
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
import io.fabric8.kubernetes.api.model.ObjectReference;
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
 * PodMetricsEndpoint defines an endpoint serving Prometheus metrics to be scraped by Prometheus.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "authorization",
    "basicAuth",
    "bearerTokenSecret",
    "enableHttp2",
    "filterRunning",
    "followRedirects",
    "honorLabels",
    "honorTimestamps",
    "interval",
    "metricRelabelings",
    "oauth2",
    "params",
    "path",
    "port",
    "portNumber",
    "proxyUrl",
    "relabelings",
    "scheme",
    "scrapeTimeout",
    "targetPort",
    "tlsConfig",
    "trackTimestampsStaleness"
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
public class PodMetricsEndpoint implements Editable<PodMetricsEndpointBuilder>, KubernetesResource
{

    @JsonProperty("authorization")
    private SafeAuthorization authorization;
    @JsonProperty("basicAuth")
    private BasicAuth basicAuth;
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
    @JsonProperty("oauth2")
    private OAuth2 oauth2;
    @JsonProperty("params")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, List<String>> params = new LinkedHashMap<>();
    @JsonProperty("path")
    private String path;
    @JsonProperty("port")
    private String port;
    @JsonProperty("portNumber")
    private Integer portNumber;
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
    private SafeTLSConfig tlsConfig;
    @JsonProperty("trackTimestampsStaleness")
    private Boolean trackTimestampsStaleness;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PodMetricsEndpoint() {
    }

    public PodMetricsEndpoint(SafeAuthorization authorization, BasicAuth basicAuth, SecretKeySelector bearerTokenSecret, Boolean enableHttp2, Boolean filterRunning, Boolean followRedirects, Boolean honorLabels, Boolean honorTimestamps, String interval, List<RelabelConfig> metricRelabelings, OAuth2 oauth2, Map<String, List<String>> params, String path, String port, Integer portNumber, String proxyUrl, List<RelabelConfig> relabelings, String scheme, String scrapeTimeout, IntOrString targetPort, SafeTLSConfig tlsConfig, Boolean trackTimestampsStaleness) {
        super();
        this.authorization = authorization;
        this.basicAuth = basicAuth;
        this.bearerTokenSecret = bearerTokenSecret;
        this.enableHttp2 = enableHttp2;
        this.filterRunning = filterRunning;
        this.followRedirects = followRedirects;
        this.honorLabels = honorLabels;
        this.honorTimestamps = honorTimestamps;
        this.interval = interval;
        this.metricRelabelings = metricRelabelings;
        this.oauth2 = oauth2;
        this.params = params;
        this.path = path;
        this.port = port;
        this.portNumber = portNumber;
        this.proxyUrl = proxyUrl;
        this.relabelings = relabelings;
        this.scheme = scheme;
        this.scrapeTimeout = scrapeTimeout;
        this.targetPort = targetPort;
        this.tlsConfig = tlsConfig;
        this.trackTimestampsStaleness = trackTimestampsStaleness;
    }

    /**
     * PodMetricsEndpoint defines an endpoint serving Prometheus metrics to be scraped by Prometheus.
     */
    @JsonProperty("authorization")
    public SafeAuthorization getAuthorization() {
        return authorization;
    }

    /**
     * PodMetricsEndpoint defines an endpoint serving Prometheus metrics to be scraped by Prometheus.
     */
    @JsonProperty("authorization")
    public void setAuthorization(SafeAuthorization authorization) {
        this.authorization = authorization;
    }

    /**
     * PodMetricsEndpoint defines an endpoint serving Prometheus metrics to be scraped by Prometheus.
     */
    @JsonProperty("basicAuth")
    public BasicAuth getBasicAuth() {
        return basicAuth;
    }

    /**
     * PodMetricsEndpoint defines an endpoint serving Prometheus metrics to be scraped by Prometheus.
     */
    @JsonProperty("basicAuth")
    public void setBasicAuth(BasicAuth basicAuth) {
        this.basicAuth = basicAuth;
    }

    /**
     * PodMetricsEndpoint defines an endpoint serving Prometheus metrics to be scraped by Prometheus.
     */
    @JsonProperty("bearerTokenSecret")
    public SecretKeySelector getBearerTokenSecret() {
        return bearerTokenSecret;
    }

    /**
     * PodMetricsEndpoint defines an endpoint serving Prometheus metrics to be scraped by Prometheus.
     */
    @JsonProperty("bearerTokenSecret")
    public void setBearerTokenSecret(SecretKeySelector bearerTokenSecret) {
        this.bearerTokenSecret = bearerTokenSecret;
    }

    /**
     * `enableHttp2` can be used to disable HTTP2 when scraping the target.
     */
    @JsonProperty("enableHttp2")
    public Boolean getEnableHttp2() {
        return enableHttp2;
    }

    /**
     * `enableHttp2` can be used to disable HTTP2 when scraping the target.
     */
    @JsonProperty("enableHttp2")
    public void setEnableHttp2(Boolean enableHttp2) {
        this.enableHttp2 = enableHttp2;
    }

    /**
     * When true, the pods which are not running (e.g. either in Failed or Succeeded state) are dropped during the target discovery.<br><p> <br><p> If unset, the filtering is enabled.<br><p> <br><p> More info: https://kubernetes.io/docs/concepts/workloads/pods/pod-lifecycle/#pod-phase
     */
    @JsonProperty("filterRunning")
    public Boolean getFilterRunning() {
        return filterRunning;
    }

    /**
     * When true, the pods which are not running (e.g. either in Failed or Succeeded state) are dropped during the target discovery.<br><p> <br><p> If unset, the filtering is enabled.<br><p> <br><p> More info: https://kubernetes.io/docs/concepts/workloads/pods/pod-lifecycle/#pod-phase
     */
    @JsonProperty("filterRunning")
    public void setFilterRunning(Boolean filterRunning) {
        this.filterRunning = filterRunning;
    }

    /**
     * `followRedirects` defines whether the scrape requests should follow HTTP 3xx redirects.
     */
    @JsonProperty("followRedirects")
    public Boolean getFollowRedirects() {
        return followRedirects;
    }

    /**
     * `followRedirects` defines whether the scrape requests should follow HTTP 3xx redirects.
     */
    @JsonProperty("followRedirects")
    public void setFollowRedirects(Boolean followRedirects) {
        this.followRedirects = followRedirects;
    }

    /**
     * When true, `honorLabels` preserves the metric's labels when they collide with the target's labels.
     */
    @JsonProperty("honorLabels")
    public Boolean getHonorLabels() {
        return honorLabels;
    }

    /**
     * When true, `honorLabels` preserves the metric's labels when they collide with the target's labels.
     */
    @JsonProperty("honorLabels")
    public void setHonorLabels(Boolean honorLabels) {
        this.honorLabels = honorLabels;
    }

    /**
     * `honorTimestamps` controls whether Prometheus preserves the timestamps when exposed by the target.
     */
    @JsonProperty("honorTimestamps")
    public Boolean getHonorTimestamps() {
        return honorTimestamps;
    }

    /**
     * `honorTimestamps` controls whether Prometheus preserves the timestamps when exposed by the target.
     */
    @JsonProperty("honorTimestamps")
    public void setHonorTimestamps(Boolean honorTimestamps) {
        this.honorTimestamps = honorTimestamps;
    }

    /**
     * Interval at which Prometheus scrapes the metrics from the target.<br><p> <br><p> If empty, Prometheus uses the global scrape interval.
     */
    @JsonProperty("interval")
    public String getInterval() {
        return interval;
    }

    /**
     * Interval at which Prometheus scrapes the metrics from the target.<br><p> <br><p> If empty, Prometheus uses the global scrape interval.
     */
    @JsonProperty("interval")
    public void setInterval(String interval) {
        this.interval = interval;
    }

    /**
     * `metricRelabelings` configures the relabeling rules to apply to the samples before ingestion.
     */
    @JsonProperty("metricRelabelings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RelabelConfig> getMetricRelabelings() {
        return metricRelabelings;
    }

    /**
     * `metricRelabelings` configures the relabeling rules to apply to the samples before ingestion.
     */
    @JsonProperty("metricRelabelings")
    public void setMetricRelabelings(List<RelabelConfig> metricRelabelings) {
        this.metricRelabelings = metricRelabelings;
    }

    /**
     * PodMetricsEndpoint defines an endpoint serving Prometheus metrics to be scraped by Prometheus.
     */
    @JsonProperty("oauth2")
    public OAuth2 getOauth2() {
        return oauth2;
    }

    /**
     * PodMetricsEndpoint defines an endpoint serving Prometheus metrics to be scraped by Prometheus.
     */
    @JsonProperty("oauth2")
    public void setOauth2(OAuth2 oauth2) {
        this.oauth2 = oauth2;
    }

    /**
     * `params` define optional HTTP URL parameters.
     */
    @JsonProperty("params")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, List<String>> getParams() {
        return params;
    }

    /**
     * `params` define optional HTTP URL parameters.
     */
    @JsonProperty("params")
    public void setParams(Map<String, List<String>> params) {
        this.params = params;
    }

    /**
     * HTTP path from which to scrape for metrics.<br><p> <br><p> If empty, Prometheus uses the default value (e.g. `/metrics`).
     */
    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    /**
     * HTTP path from which to scrape for metrics.<br><p> <br><p> If empty, Prometheus uses the default value (e.g. `/metrics`).
     */
    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * The `Pod` port name which exposes the endpoint.<br><p> <br><p> It takes precedence over the `portNumber` and `targetPort` fields.
     */
    @JsonProperty("port")
    public String getPort() {
        return port;
    }

    /**
     * The `Pod` port name which exposes the endpoint.<br><p> <br><p> It takes precedence over the `portNumber` and `targetPort` fields.
     */
    @JsonProperty("port")
    public void setPort(String port) {
        this.port = port;
    }

    /**
     * The `Pod` port number which exposes the endpoint.
     */
    @JsonProperty("portNumber")
    public Integer getPortNumber() {
        return portNumber;
    }

    /**
     * The `Pod` port number which exposes the endpoint.
     */
    @JsonProperty("portNumber")
    public void setPortNumber(Integer portNumber) {
        this.portNumber = portNumber;
    }

    /**
     * `proxyURL` configures the HTTP Proxy URL (e.g. "http://proxyserver:2195") to go through when scraping the target.
     */
    @JsonProperty("proxyUrl")
    public String getProxyUrl() {
        return proxyUrl;
    }

    /**
     * `proxyURL` configures the HTTP Proxy URL (e.g. "http://proxyserver:2195") to go through when scraping the target.
     */
    @JsonProperty("proxyUrl")
    public void setProxyUrl(String proxyUrl) {
        this.proxyUrl = proxyUrl;
    }

    /**
     * `relabelings` configures the relabeling rules to apply the target's metadata labels.<br><p> <br><p> The Operator automatically adds relabelings for a few standard Kubernetes fields.<br><p> <br><p> The original scrape job's name is available via the `__tmp_prometheus_job_name` label.<br><p> <br><p> More info: https://prometheus.io/docs/prometheus/latest/configuration/configuration/#relabel_config
     */
    @JsonProperty("relabelings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RelabelConfig> getRelabelings() {
        return relabelings;
    }

    /**
     * `relabelings` configures the relabeling rules to apply the target's metadata labels.<br><p> <br><p> The Operator automatically adds relabelings for a few standard Kubernetes fields.<br><p> <br><p> The original scrape job's name is available via the `__tmp_prometheus_job_name` label.<br><p> <br><p> More info: https://prometheus.io/docs/prometheus/latest/configuration/configuration/#relabel_config
     */
    @JsonProperty("relabelings")
    public void setRelabelings(List<RelabelConfig> relabelings) {
        this.relabelings = relabelings;
    }

    /**
     * HTTP scheme to use for scraping.<br><p> <br><p> `http` and `https` are the expected values unless you rewrite the `__scheme__` label via relabeling.<br><p> <br><p> If empty, Prometheus uses the default value `http`.
     */
    @JsonProperty("scheme")
    public String getScheme() {
        return scheme;
    }

    /**
     * HTTP scheme to use for scraping.<br><p> <br><p> `http` and `https` are the expected values unless you rewrite the `__scheme__` label via relabeling.<br><p> <br><p> If empty, Prometheus uses the default value `http`.
     */
    @JsonProperty("scheme")
    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    /**
     * Timeout after which Prometheus considers the scrape to be failed.<br><p> <br><p> If empty, Prometheus uses the global scrape timeout unless it is less than the target's scrape interval value in which the latter is used.
     */
    @JsonProperty("scrapeTimeout")
    public String getScrapeTimeout() {
        return scrapeTimeout;
    }

    /**
     * Timeout after which Prometheus considers the scrape to be failed.<br><p> <br><p> If empty, Prometheus uses the global scrape timeout unless it is less than the target's scrape interval value in which the latter is used.
     */
    @JsonProperty("scrapeTimeout")
    public void setScrapeTimeout(String scrapeTimeout) {
        this.scrapeTimeout = scrapeTimeout;
    }

    /**
     * PodMetricsEndpoint defines an endpoint serving Prometheus metrics to be scraped by Prometheus.
     */
    @JsonProperty("targetPort")
    public IntOrString getTargetPort() {
        return targetPort;
    }

    /**
     * PodMetricsEndpoint defines an endpoint serving Prometheus metrics to be scraped by Prometheus.
     */
    @JsonProperty("targetPort")
    public void setTargetPort(IntOrString targetPort) {
        this.targetPort = targetPort;
    }

    /**
     * PodMetricsEndpoint defines an endpoint serving Prometheus metrics to be scraped by Prometheus.
     */
    @JsonProperty("tlsConfig")
    public SafeTLSConfig getTlsConfig() {
        return tlsConfig;
    }

    /**
     * PodMetricsEndpoint defines an endpoint serving Prometheus metrics to be scraped by Prometheus.
     */
    @JsonProperty("tlsConfig")
    public void setTlsConfig(SafeTLSConfig tlsConfig) {
        this.tlsConfig = tlsConfig;
    }

    /**
     * `trackTimestampsStaleness` defines whether Prometheus tracks staleness of the metrics that have an explicit timestamp present in scraped data. Has no effect if `honorTimestamps` is false.<br><p> <br><p> It requires Prometheus &gt;= v2.48.0.
     */
    @JsonProperty("trackTimestampsStaleness")
    public Boolean getTrackTimestampsStaleness() {
        return trackTimestampsStaleness;
    }

    /**
     * `trackTimestampsStaleness` defines whether Prometheus tracks staleness of the metrics that have an explicit timestamp present in scraped data. Has no effect if `honorTimestamps` is false.<br><p> <br><p> It requires Prometheus &gt;= v2.48.0.
     */
    @JsonProperty("trackTimestampsStaleness")
    public void setTrackTimestampsStaleness(Boolean trackTimestampsStaleness) {
        this.trackTimestampsStaleness = trackTimestampsStaleness;
    }

    @JsonIgnore
    public PodMetricsEndpointBuilder edit() {
        return new PodMetricsEndpointBuilder(this);
    }

    @JsonIgnore
    public PodMetricsEndpointBuilder toBuilder() {
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
