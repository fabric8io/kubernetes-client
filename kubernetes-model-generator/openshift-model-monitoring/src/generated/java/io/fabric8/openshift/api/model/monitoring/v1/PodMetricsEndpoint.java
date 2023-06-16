
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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.SecretKeySelector;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "authorization",
    "basicAuth",
    "bearerTokenSecret",
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
    "tlsConfig"
})
@ToString
@EqualsAndHashCode
@Setter
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
    @BuildableReference(io.fabric8.kubernetes.api.model.IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class PodMetricsEndpoint implements KubernetesResource
{

    @JsonProperty("authorization")
    private SafeAuthorization authorization;
    @JsonProperty("basicAuth")
    private BasicAuth basicAuth;
    @JsonProperty("bearerTokenSecret")
    private SecretKeySelector bearerTokenSecret;
    @JsonProperty("followRedirects")
    private Boolean followRedirects;
    @JsonProperty("honorLabels")
    private Boolean honorLabels;
    @JsonProperty("honorTimestamps")
    private Boolean honorTimestamps;
    @JsonProperty("interval")
    private java.lang.String interval;
    @JsonProperty("metricRelabelings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RelabelConfig> metricRelabelings = new ArrayList<RelabelConfig>();
    @JsonProperty("oauth2")
    private OAuth2 oauth2;
    @JsonProperty("params")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, ArrayList<String>> params = new LinkedHashMap<String, ArrayList<String>>();
    @JsonProperty("path")
    private java.lang.String path;
    @JsonProperty("port")
    private java.lang.String port;
    @JsonProperty("proxyUrl")
    private java.lang.String proxyUrl;
    @JsonProperty("relabelings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RelabelConfig> relabelings = new ArrayList<RelabelConfig>();
    @JsonProperty("scheme")
    private java.lang.String scheme;
    @JsonProperty("scrapeTimeout")
    private java.lang.String scrapeTimeout;
    @JsonProperty("targetPort")
    private io.fabric8.kubernetes.api.model.IntOrString targetPort;
    @JsonProperty("tlsConfig")
    private PodMetricsEndpointTLSConfig tlsConfig;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PodMetricsEndpoint() {
    }

    public PodMetricsEndpoint(SafeAuthorization authorization, BasicAuth basicAuth, SecretKeySelector bearerTokenSecret, Boolean followRedirects, Boolean honorLabels, Boolean honorTimestamps, java.lang.String interval, List<RelabelConfig> metricRelabelings, OAuth2 oauth2, Map<String, ArrayList<String>> params, java.lang.String path, java.lang.String port, java.lang.String proxyUrl, List<RelabelConfig> relabelings, java.lang.String scheme, java.lang.String scrapeTimeout, io.fabric8.kubernetes.api.model.IntOrString targetPort, PodMetricsEndpointTLSConfig tlsConfig) {
        super();
        this.authorization = authorization;
        this.basicAuth = basicAuth;
        this.bearerTokenSecret = bearerTokenSecret;
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
    }

    @JsonProperty("authorization")
    public SafeAuthorization getAuthorization() {
        return authorization;
    }

    @JsonProperty("authorization")
    public void setAuthorization(SafeAuthorization authorization) {
        this.authorization = authorization;
    }

    @JsonProperty("basicAuth")
    public BasicAuth getBasicAuth() {
        return basicAuth;
    }

    @JsonProperty("basicAuth")
    public void setBasicAuth(BasicAuth basicAuth) {
        this.basicAuth = basicAuth;
    }

    @JsonProperty("bearerTokenSecret")
    public SecretKeySelector getBearerTokenSecret() {
        return bearerTokenSecret;
    }

    @JsonProperty("bearerTokenSecret")
    public void setBearerTokenSecret(SecretKeySelector bearerTokenSecret) {
        this.bearerTokenSecret = bearerTokenSecret;
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
    public java.lang.String getInterval() {
        return interval;
    }

    @JsonProperty("interval")
    public void setInterval(java.lang.String interval) {
        this.interval = interval;
    }

    @JsonProperty("metricRelabelings")
    public List<RelabelConfig> getMetricRelabelings() {
        return metricRelabelings;
    }

    @JsonProperty("metricRelabelings")
    public void setMetricRelabelings(List<RelabelConfig> metricRelabelings) {
        this.metricRelabelings = metricRelabelings;
    }

    @JsonProperty("oauth2")
    public OAuth2 getOauth2() {
        return oauth2;
    }

    @JsonProperty("oauth2")
    public void setOauth2(OAuth2 oauth2) {
        this.oauth2 = oauth2;
    }

    @JsonProperty("params")
    public Map<String, ArrayList<String>> getParams() {
        return params;
    }

    @JsonProperty("params")
    public void setParams(Map<String, ArrayList<String>> params) {
        this.params = params;
    }

    @JsonProperty("path")
    public java.lang.String getPath() {
        return path;
    }

    @JsonProperty("path")
    public void setPath(java.lang.String path) {
        this.path = path;
    }

    @JsonProperty("port")
    public java.lang.String getPort() {
        return port;
    }

    @JsonProperty("port")
    public void setPort(java.lang.String port) {
        this.port = port;
    }

    @JsonProperty("proxyUrl")
    public java.lang.String getProxyUrl() {
        return proxyUrl;
    }

    @JsonProperty("proxyUrl")
    public void setProxyUrl(java.lang.String proxyUrl) {
        this.proxyUrl = proxyUrl;
    }

    @JsonProperty("relabelings")
    public List<RelabelConfig> getRelabelings() {
        return relabelings;
    }

    @JsonProperty("relabelings")
    public void setRelabelings(List<RelabelConfig> relabelings) {
        this.relabelings = relabelings;
    }

    @JsonProperty("scheme")
    public java.lang.String getScheme() {
        return scheme;
    }

    @JsonProperty("scheme")
    public void setScheme(java.lang.String scheme) {
        this.scheme = scheme;
    }

    @JsonProperty("scrapeTimeout")
    public java.lang.String getScrapeTimeout() {
        return scrapeTimeout;
    }

    @JsonProperty("scrapeTimeout")
    public void setScrapeTimeout(java.lang.String scrapeTimeout) {
        this.scrapeTimeout = scrapeTimeout;
    }

    @JsonProperty("targetPort")
    public io.fabric8.kubernetes.api.model.IntOrString getTargetPort() {
        return targetPort;
    }

    @JsonProperty("targetPort")
    public void setTargetPort(io.fabric8.kubernetes.api.model.IntOrString targetPort) {
        this.targetPort = targetPort;
    }

    @JsonProperty("tlsConfig")
    public PodMetricsEndpointTLSConfig getTlsConfig() {
        return tlsConfig;
    }

    @JsonProperty("tlsConfig")
    public void setTlsConfig(PodMetricsEndpointTLSConfig tlsConfig) {
        this.tlsConfig = tlsConfig;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
