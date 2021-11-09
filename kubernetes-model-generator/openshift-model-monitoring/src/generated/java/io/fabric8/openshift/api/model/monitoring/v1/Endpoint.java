
package io.fabric8.openshift.api.model.monitoring.v1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    "basicAuth",
    "bearerTokenFile",
    "bearerTokenSecret",
    "honorLabels",
    "honorTimestamps",
    "interval",
    "metricRelabelings",
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
public class Endpoint implements KubernetesResource
{

    @JsonProperty("basicAuth")
    private BasicAuth basicAuth;
    @JsonProperty("bearerTokenFile")
    private java.lang.String bearerTokenFile;
    @JsonProperty("bearerTokenSecret")
    private SecretKeySelector bearerTokenSecret;
    @JsonProperty("honorLabels")
    private Boolean honorLabels;
    @JsonProperty("honorTimestamps")
    private Boolean honorTimestamps;
    @JsonProperty("interval")
    private java.lang.String interval;
    @JsonProperty("metricRelabelings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RelabelConfig> metricRelabelings = new ArrayList<RelabelConfig>();
    @JsonProperty("params")
    private Map<String, ArrayList<String>> params;
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
    private TLSConfig tlsConfig;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Endpoint() {
    }

    /**
     * 
     * @param bearerTokenSecret
     * @param honorTimestamps
     * @param scheme
     * @param scrapeTimeout
     * @param basicAuth
     * @param proxyUrl
     * @param metricRelabelings
     * @param params
     * @param targetPort
     * @param honorLabels
     * @param tlsConfig
     * @param path
     * @param relabelings
     * @param port
     * @param interval
     * @param bearerTokenFile
     */
    public Endpoint(BasicAuth basicAuth, java.lang.String bearerTokenFile, SecretKeySelector bearerTokenSecret, Boolean honorLabels, Boolean honorTimestamps, java.lang.String interval, List<RelabelConfig> metricRelabelings, Map<String, ArrayList<String>> params, java.lang.String path, java.lang.String port, java.lang.String proxyUrl, List<RelabelConfig> relabelings, java.lang.String scheme, java.lang.String scrapeTimeout, io.fabric8.kubernetes.api.model.IntOrString targetPort, TLSConfig tlsConfig) {
        super();
        this.basicAuth = basicAuth;
        this.bearerTokenFile = bearerTokenFile;
        this.bearerTokenSecret = bearerTokenSecret;
        this.honorLabels = honorLabels;
        this.honorTimestamps = honorTimestamps;
        this.interval = interval;
        this.metricRelabelings = metricRelabelings;
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

    @JsonProperty("basicAuth")
    public BasicAuth getBasicAuth() {
        return basicAuth;
    }

    @JsonProperty("basicAuth")
    public void setBasicAuth(BasicAuth basicAuth) {
        this.basicAuth = basicAuth;
    }

    @JsonProperty("bearerTokenFile")
    public java.lang.String getBearerTokenFile() {
        return bearerTokenFile;
    }

    @JsonProperty("bearerTokenFile")
    public void setBearerTokenFile(java.lang.String bearerTokenFile) {
        this.bearerTokenFile = bearerTokenFile;
    }

    @JsonProperty("bearerTokenSecret")
    public SecretKeySelector getBearerTokenSecret() {
        return bearerTokenSecret;
    }

    @JsonProperty("bearerTokenSecret")
    public void setBearerTokenSecret(SecretKeySelector bearerTokenSecret) {
        this.bearerTokenSecret = bearerTokenSecret;
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
    public TLSConfig getTlsConfig() {
        return tlsConfig;
    }

    @JsonProperty("tlsConfig")
    public void setTlsConfig(TLSConfig tlsConfig) {
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
