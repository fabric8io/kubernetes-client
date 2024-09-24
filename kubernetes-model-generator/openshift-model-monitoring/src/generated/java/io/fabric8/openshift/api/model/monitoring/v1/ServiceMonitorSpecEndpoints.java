
package io.fabric8.openshift.api.model.monitoring.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
    "oauth2",
    "params",
    "path",
    "port",
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class ServiceMonitorSpecEndpoints implements Editable<ServiceMonitorSpecEndpointsBuilder> , KubernetesResource
{

    @JsonProperty("authorization")
    private ServiceMonitorSpecEAuthorization authorization;
    @JsonProperty("basicAuth")
    private ServiceMonitorSpecEBasicAuth basicAuth;
    @JsonProperty("bearerTokenFile")
    private String bearerTokenFile;
    @JsonProperty("bearerTokenSecret")
    private ServiceMonitorSpecEBearerTokenSecret bearerTokenSecret;
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
    private List<ServiceMonitorSpecEMetricRelabelings> metricRelabelings = new ArrayList<>();
    @JsonProperty("oauth2")
    private ServiceMonitorSpecEOauth2 oauth2;
    @JsonProperty("params")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, List<String>> params = new LinkedHashMap<>();
    @JsonProperty("path")
    private String path;
    @JsonProperty("port")
    private String port;
    @JsonProperty("proxyUrl")
    private String proxyUrl;
    @JsonProperty("relabelings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ServiceMonitorSpecERelabelings> relabelings = new ArrayList<>();
    @JsonProperty("scheme")
    private String scheme;
    @JsonProperty("scrapeTimeout")
    private String scrapeTimeout;
    @JsonProperty("targetPort")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object targetPort;
    @JsonProperty("tlsConfig")
    private ServiceMonitorSpecETlsConfig tlsConfig;
    @JsonProperty("trackTimestampsStaleness")
    private Boolean trackTimestampsStaleness;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ServiceMonitorSpecEndpoints() {
    }

    public ServiceMonitorSpecEndpoints(ServiceMonitorSpecEAuthorization authorization, ServiceMonitorSpecEBasicAuth basicAuth, String bearerTokenFile, ServiceMonitorSpecEBearerTokenSecret bearerTokenSecret, Boolean enableHttp2, Boolean filterRunning, Boolean followRedirects, Boolean honorLabels, Boolean honorTimestamps, String interval, List<ServiceMonitorSpecEMetricRelabelings> metricRelabelings, ServiceMonitorSpecEOauth2 oauth2, Map<String, List<String>> params, String path, String port, String proxyUrl, List<ServiceMonitorSpecERelabelings> relabelings, String scheme, String scrapeTimeout, Object targetPort, ServiceMonitorSpecETlsConfig tlsConfig, Boolean trackTimestampsStaleness) {
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
        this.oauth2 = oauth2;
        this.params = params;
        this.path = path;
        this.port = port;
        this.proxyUrl = proxyUrl;
        this.relabelings = relabelings;
        this.scheme = scheme;
        this.scrapeTimeout = scrapeTimeout;
        this.targetPort = targetPort;
        this.tlsConfig = tlsConfig;
        this.trackTimestampsStaleness = trackTimestampsStaleness;
    }

    @JsonProperty("authorization")
    public ServiceMonitorSpecEAuthorization getAuthorization() {
        return authorization;
    }

    @JsonProperty("authorization")
    public void setAuthorization(ServiceMonitorSpecEAuthorization authorization) {
        this.authorization = authorization;
    }

    @JsonProperty("basicAuth")
    public ServiceMonitorSpecEBasicAuth getBasicAuth() {
        return basicAuth;
    }

    @JsonProperty("basicAuth")
    public void setBasicAuth(ServiceMonitorSpecEBasicAuth basicAuth) {
        this.basicAuth = basicAuth;
    }

    @JsonProperty("bearerTokenFile")
    public String getBearerTokenFile() {
        return bearerTokenFile;
    }

    @JsonProperty("bearerTokenFile")
    public void setBearerTokenFile(String bearerTokenFile) {
        this.bearerTokenFile = bearerTokenFile;
    }

    @JsonProperty("bearerTokenSecret")
    public ServiceMonitorSpecEBearerTokenSecret getBearerTokenSecret() {
        return bearerTokenSecret;
    }

    @JsonProperty("bearerTokenSecret")
    public void setBearerTokenSecret(ServiceMonitorSpecEBearerTokenSecret bearerTokenSecret) {
        this.bearerTokenSecret = bearerTokenSecret;
    }

    @JsonProperty("enableHttp2")
    public Boolean getEnableHttp2() {
        return enableHttp2;
    }

    @JsonProperty("enableHttp2")
    public void setEnableHttp2(Boolean enableHttp2) {
        this.enableHttp2 = enableHttp2;
    }

    @JsonProperty("filterRunning")
    public Boolean getFilterRunning() {
        return filterRunning;
    }

    @JsonProperty("filterRunning")
    public void setFilterRunning(Boolean filterRunning) {
        this.filterRunning = filterRunning;
    }

    @JsonProperty("followRedirects")
    public Boolean getFollowRedirects() {
        return followRedirects;
    }

    @JsonProperty("followRedirects")
    public void setFollowRedirects(Boolean followRedirects) {
        this.followRedirects = followRedirects;
    }

    @JsonProperty("honorLabels")
    public Boolean getHonorLabels() {
        return honorLabels;
    }

    @JsonProperty("honorLabels")
    public void setHonorLabels(Boolean honorLabels) {
        this.honorLabels = honorLabels;
    }

    @JsonProperty("honorTimestamps")
    public Boolean getHonorTimestamps() {
        return honorTimestamps;
    }

    @JsonProperty("honorTimestamps")
    public void setHonorTimestamps(Boolean honorTimestamps) {
        this.honorTimestamps = honorTimestamps;
    }

    @JsonProperty("interval")
    public String getInterval() {
        return interval;
    }

    @JsonProperty("interval")
    public void setInterval(String interval) {
        this.interval = interval;
    }

    @JsonProperty("metricRelabelings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ServiceMonitorSpecEMetricRelabelings> getMetricRelabelings() {
        return metricRelabelings;
    }

    @JsonProperty("metricRelabelings")
    public void setMetricRelabelings(List<ServiceMonitorSpecEMetricRelabelings> metricRelabelings) {
        this.metricRelabelings = metricRelabelings;
    }

    @JsonProperty("oauth2")
    public ServiceMonitorSpecEOauth2 getOauth2() {
        return oauth2;
    }

    @JsonProperty("oauth2")
    public void setOauth2(ServiceMonitorSpecEOauth2 oauth2) {
        this.oauth2 = oauth2;
    }

    @JsonProperty("params")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, List<String>> getParams() {
        return params;
    }

    @JsonProperty("params")
    public void setParams(Map<String, List<String>> params) {
        this.params = params;
    }

    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    @JsonProperty("port")
    public String getPort() {
        return port;
    }

    @JsonProperty("port")
    public void setPort(String port) {
        this.port = port;
    }

    @JsonProperty("proxyUrl")
    public String getProxyUrl() {
        return proxyUrl;
    }

    @JsonProperty("proxyUrl")
    public void setProxyUrl(String proxyUrl) {
        this.proxyUrl = proxyUrl;
    }

    @JsonProperty("relabelings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ServiceMonitorSpecERelabelings> getRelabelings() {
        return relabelings;
    }

    @JsonProperty("relabelings")
    public void setRelabelings(List<ServiceMonitorSpecERelabelings> relabelings) {
        this.relabelings = relabelings;
    }

    @JsonProperty("scheme")
    public String getScheme() {
        return scheme;
    }

    @JsonProperty("scheme")
    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    @JsonProperty("scrapeTimeout")
    public String getScrapeTimeout() {
        return scrapeTimeout;
    }

    @JsonProperty("scrapeTimeout")
    public void setScrapeTimeout(String scrapeTimeout) {
        this.scrapeTimeout = scrapeTimeout;
    }

    @JsonProperty("targetPort")
    public Object getTargetPort() {
        return targetPort;
    }

    @JsonProperty("targetPort")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setTargetPort(Object targetPort) {
        this.targetPort = targetPort;
    }

    @JsonProperty("tlsConfig")
    public ServiceMonitorSpecETlsConfig getTlsConfig() {
        return tlsConfig;
    }

    @JsonProperty("tlsConfig")
    public void setTlsConfig(ServiceMonitorSpecETlsConfig tlsConfig) {
        this.tlsConfig = tlsConfig;
    }

    @JsonProperty("trackTimestampsStaleness")
    public Boolean getTrackTimestampsStaleness() {
        return trackTimestampsStaleness;
    }

    @JsonProperty("trackTimestampsStaleness")
    public void setTrackTimestampsStaleness(Boolean trackTimestampsStaleness) {
        this.trackTimestampsStaleness = trackTimestampsStaleness;
    }

    @JsonIgnore
    public ServiceMonitorSpecEndpointsBuilder edit() {
        return new ServiceMonitorSpecEndpointsBuilder(this);
    }

    @JsonIgnore
    public ServiceMonitorSpecEndpointsBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
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
