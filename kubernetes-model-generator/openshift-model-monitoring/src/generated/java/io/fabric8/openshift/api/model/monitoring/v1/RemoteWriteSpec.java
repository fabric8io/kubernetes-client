
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * RemoteWriteSpec defines the configuration to write samples from Prometheus to a remote endpoint.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "authorization",
    "azureAd",
    "basicAuth",
    "bearerToken",
    "bearerTokenFile",
    "enableHTTP2",
    "followRedirects",
    "headers",
    "messageVersion",
    "metadataConfig",
    "name",
    "noProxy",
    "oauth2",
    "proxyConnectHeader",
    "proxyFromEnvironment",
    "proxyUrl",
    "queueConfig",
    "remoteTimeout",
    "roundRobinDNS",
    "sendExemplars",
    "sendNativeHistograms",
    "sigv4",
    "tlsConfig",
    "url",
    "writeRelabelConfigs"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class RemoteWriteSpec implements Editable<RemoteWriteSpecBuilder>, KubernetesResource
{

    @JsonProperty("authorization")
    private Authorization authorization;
    @JsonProperty("azureAd")
    private AzureAD azureAd;
    @JsonProperty("basicAuth")
    private BasicAuth basicAuth;
    @JsonProperty("bearerToken")
    private String bearerToken;
    @JsonProperty("bearerTokenFile")
    private String bearerTokenFile;
    @JsonProperty("enableHTTP2")
    private Boolean enableHTTP2;
    @JsonProperty("followRedirects")
    private Boolean followRedirects;
    @JsonProperty("headers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> headers = new LinkedHashMap<>();
    @JsonProperty("messageVersion")
    private String messageVersion;
    @JsonProperty("metadataConfig")
    private MetadataConfig metadataConfig;
    @JsonProperty("name")
    private String name;
    @JsonProperty("noProxy")
    private String noProxy;
    @JsonProperty("oauth2")
    private OAuth2 oauth2;
    @JsonProperty("proxyConnectHeader")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, List<SecretKeySelector>> proxyConnectHeader = new LinkedHashMap<>();
    @JsonProperty("proxyFromEnvironment")
    private Boolean proxyFromEnvironment;
    @JsonProperty("proxyUrl")
    private String proxyUrl;
    @JsonProperty("queueConfig")
    private QueueConfig queueConfig;
    @JsonProperty("remoteTimeout")
    private String remoteTimeout;
    @JsonProperty("roundRobinDNS")
    private Boolean roundRobinDNS;
    @JsonProperty("sendExemplars")
    private Boolean sendExemplars;
    @JsonProperty("sendNativeHistograms")
    private Boolean sendNativeHistograms;
    @JsonProperty("sigv4")
    private Sigv4 sigv4;
    @JsonProperty("tlsConfig")
    private TLSConfig tlsConfig;
    @JsonProperty("url")
    private String url;
    @JsonProperty("writeRelabelConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RelabelConfig> writeRelabelConfigs = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RemoteWriteSpec() {
    }

    public RemoteWriteSpec(Authorization authorization, AzureAD azureAd, BasicAuth basicAuth, String bearerToken, String bearerTokenFile, Boolean enableHTTP2, Boolean followRedirects, Map<String, String> headers, String messageVersion, MetadataConfig metadataConfig, String name, String noProxy, OAuth2 oauth2, Map<String, List<SecretKeySelector>> proxyConnectHeader, Boolean proxyFromEnvironment, String proxyUrl, QueueConfig queueConfig, String remoteTimeout, Boolean roundRobinDNS, Boolean sendExemplars, Boolean sendNativeHistograms, Sigv4 sigv4, TLSConfig tlsConfig, String url, List<RelabelConfig> writeRelabelConfigs) {
        super();
        this.authorization = authorization;
        this.azureAd = azureAd;
        this.basicAuth = basicAuth;
        this.bearerToken = bearerToken;
        this.bearerTokenFile = bearerTokenFile;
        this.enableHTTP2 = enableHTTP2;
        this.followRedirects = followRedirects;
        this.headers = headers;
        this.messageVersion = messageVersion;
        this.metadataConfig = metadataConfig;
        this.name = name;
        this.noProxy = noProxy;
        this.oauth2 = oauth2;
        this.proxyConnectHeader = proxyConnectHeader;
        this.proxyFromEnvironment = proxyFromEnvironment;
        this.proxyUrl = proxyUrl;
        this.queueConfig = queueConfig;
        this.remoteTimeout = remoteTimeout;
        this.roundRobinDNS = roundRobinDNS;
        this.sendExemplars = sendExemplars;
        this.sendNativeHistograms = sendNativeHistograms;
        this.sigv4 = sigv4;
        this.tlsConfig = tlsConfig;
        this.url = url;
        this.writeRelabelConfigs = writeRelabelConfigs;
    }

    /**
     * RemoteWriteSpec defines the configuration to write samples from Prometheus to a remote endpoint.
     */
    @JsonProperty("authorization")
    public Authorization getAuthorization() {
        return authorization;
    }

    /**
     * RemoteWriteSpec defines the configuration to write samples from Prometheus to a remote endpoint.
     */
    @JsonProperty("authorization")
    public void setAuthorization(Authorization authorization) {
        this.authorization = authorization;
    }

    /**
     * RemoteWriteSpec defines the configuration to write samples from Prometheus to a remote endpoint.
     */
    @JsonProperty("azureAd")
    public AzureAD getAzureAd() {
        return azureAd;
    }

    /**
     * RemoteWriteSpec defines the configuration to write samples from Prometheus to a remote endpoint.
     */
    @JsonProperty("azureAd")
    public void setAzureAd(AzureAD azureAd) {
        this.azureAd = azureAd;
    }

    /**
     * RemoteWriteSpec defines the configuration to write samples from Prometheus to a remote endpoint.
     */
    @JsonProperty("basicAuth")
    public BasicAuth getBasicAuth() {
        return basicAuth;
    }

    /**
     * RemoteWriteSpec defines the configuration to write samples from Prometheus to a remote endpoint.
     */
    @JsonProperty("basicAuth")
    public void setBasicAuth(BasicAuth basicAuth) {
        this.basicAuth = basicAuth;
    }

    /**
     * &#42;Warning: this field shouldn't be used because the token value appears in clear-text. Prefer using `authorization`.&#42;<br><p> <br><p> Deprecated: this will be removed in a future release.
     */
    @JsonProperty("bearerToken")
    public String getBearerToken() {
        return bearerToken;
    }

    /**
     * &#42;Warning: this field shouldn't be used because the token value appears in clear-text. Prefer using `authorization`.&#42;<br><p> <br><p> Deprecated: this will be removed in a future release.
     */
    @JsonProperty("bearerToken")
    public void setBearerToken(String bearerToken) {
        this.bearerToken = bearerToken;
    }

    /**
     * File from which to read bearer token for the URL.<br><p> <br><p> Deprecated: this will be removed in a future release. Prefer using `authorization`.
     */
    @JsonProperty("bearerTokenFile")
    public String getBearerTokenFile() {
        return bearerTokenFile;
    }

    /**
     * File from which to read bearer token for the URL.<br><p> <br><p> Deprecated: this will be removed in a future release. Prefer using `authorization`.
     */
    @JsonProperty("bearerTokenFile")
    public void setBearerTokenFile(String bearerTokenFile) {
        this.bearerTokenFile = bearerTokenFile;
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
     * Configure whether HTTP requests follow HTTP 3xx redirects.<br><p> <br><p> It requires Prometheus &gt;= v2.26.0 or Thanos &gt;= v0.24.0.
     */
    @JsonProperty("followRedirects")
    public Boolean getFollowRedirects() {
        return followRedirects;
    }

    /**
     * Configure whether HTTP requests follow HTTP 3xx redirects.<br><p> <br><p> It requires Prometheus &gt;= v2.26.0 or Thanos &gt;= v0.24.0.
     */
    @JsonProperty("followRedirects")
    public void setFollowRedirects(Boolean followRedirects) {
        this.followRedirects = followRedirects;
    }

    /**
     * Custom HTTP headers to be sent along with each remote write request. Be aware that headers that are set by Prometheus itself can't be overwritten.<br><p> <br><p> It requires Prometheus &gt;= v2.25.0 or Thanos &gt;= v0.24.0.
     */
    @JsonProperty("headers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getHeaders() {
        return headers;
    }

    /**
     * Custom HTTP headers to be sent along with each remote write request. Be aware that headers that are set by Prometheus itself can't be overwritten.<br><p> <br><p> It requires Prometheus &gt;= v2.25.0 or Thanos &gt;= v0.24.0.
     */
    @JsonProperty("headers")
    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    /**
     * The Remote Write message's version to use when writing to the endpoint.<br><p> <br><p> `Version1.0` corresponds to the `prometheus.WriteRequest` protobuf message introduced in Remote Write 1.0. `Version2.0` corresponds to the `io.prometheus.write.v2.Request` protobuf message introduced in Remote Write 2.0.<br><p> <br><p> When `Version2.0` is selected, Prometheus will automatically be configured to append the metadata of scraped metrics to the WAL.<br><p> <br><p> Before setting this field, consult with your remote storage provider what message version it supports.<br><p> <br><p> It requires Prometheus &gt;= v2.54.0 or Thanos &gt;= v0.37.0.
     */
    @JsonProperty("messageVersion")
    public String getMessageVersion() {
        return messageVersion;
    }

    /**
     * The Remote Write message's version to use when writing to the endpoint.<br><p> <br><p> `Version1.0` corresponds to the `prometheus.WriteRequest` protobuf message introduced in Remote Write 1.0. `Version2.0` corresponds to the `io.prometheus.write.v2.Request` protobuf message introduced in Remote Write 2.0.<br><p> <br><p> When `Version2.0` is selected, Prometheus will automatically be configured to append the metadata of scraped metrics to the WAL.<br><p> <br><p> Before setting this field, consult with your remote storage provider what message version it supports.<br><p> <br><p> It requires Prometheus &gt;= v2.54.0 or Thanos &gt;= v0.37.0.
     */
    @JsonProperty("messageVersion")
    public void setMessageVersion(String messageVersion) {
        this.messageVersion = messageVersion;
    }

    /**
     * RemoteWriteSpec defines the configuration to write samples from Prometheus to a remote endpoint.
     */
    @JsonProperty("metadataConfig")
    public MetadataConfig getMetadataConfig() {
        return metadataConfig;
    }

    /**
     * RemoteWriteSpec defines the configuration to write samples from Prometheus to a remote endpoint.
     */
    @JsonProperty("metadataConfig")
    public void setMetadataConfig(MetadataConfig metadataConfig) {
        this.metadataConfig = metadataConfig;
    }

    /**
     * The name of the remote write queue, it must be unique if specified. The name is used in metrics and logging in order to differentiate queues.<br><p> <br><p> It requires Prometheus &gt;= v2.15.0 or Thanos &gt;= 0.24.0.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * The name of the remote write queue, it must be unique if specified. The name is used in metrics and logging in order to differentiate queues.<br><p> <br><p> It requires Prometheus &gt;= v2.15.0 or Thanos &gt;= 0.24.0.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * `noProxy` is a comma-separated string that can contain IPs, CIDR notation, domain names that should be excluded from proxying. IP and domain names can contain port numbers.<br><p> <br><p> It requires Prometheus &gt;= v2.43.0, Alertmanager &gt;= v0.25.0 or Thanos &gt;= v0.32.0.
     */
    @JsonProperty("noProxy")
    public String getNoProxy() {
        return noProxy;
    }

    /**
     * `noProxy` is a comma-separated string that can contain IPs, CIDR notation, domain names that should be excluded from proxying. IP and domain names can contain port numbers.<br><p> <br><p> It requires Prometheus &gt;= v2.43.0, Alertmanager &gt;= v0.25.0 or Thanos &gt;= v0.32.0.
     */
    @JsonProperty("noProxy")
    public void setNoProxy(String noProxy) {
        this.noProxy = noProxy;
    }

    /**
     * RemoteWriteSpec defines the configuration to write samples from Prometheus to a remote endpoint.
     */
    @JsonProperty("oauth2")
    public OAuth2 getOauth2() {
        return oauth2;
    }

    /**
     * RemoteWriteSpec defines the configuration to write samples from Prometheus to a remote endpoint.
     */
    @JsonProperty("oauth2")
    public void setOauth2(OAuth2 oauth2) {
        this.oauth2 = oauth2;
    }

    /**
     * ProxyConnectHeader optionally specifies headers to send to proxies during CONNECT requests.<br><p> <br><p> It requires Prometheus &gt;= v2.43.0, Alertmanager &gt;= v0.25.0 or Thanos &gt;= v0.32.0.
     */
    @JsonProperty("proxyConnectHeader")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, List<SecretKeySelector>> getProxyConnectHeader() {
        return proxyConnectHeader;
    }

    /**
     * ProxyConnectHeader optionally specifies headers to send to proxies during CONNECT requests.<br><p> <br><p> It requires Prometheus &gt;= v2.43.0, Alertmanager &gt;= v0.25.0 or Thanos &gt;= v0.32.0.
     */
    @JsonProperty("proxyConnectHeader")
    public void setProxyConnectHeader(Map<String, List<SecretKeySelector>> proxyConnectHeader) {
        this.proxyConnectHeader = proxyConnectHeader;
    }

    /**
     * Whether to use the proxy configuration defined by environment variables (HTTP_PROXY, HTTPS_PROXY, and NO_PROXY).<br><p> <br><p> It requires Prometheus &gt;= v2.43.0, Alertmanager &gt;= v0.25.0 or Thanos &gt;= v0.32.0.
     */
    @JsonProperty("proxyFromEnvironment")
    public Boolean getProxyFromEnvironment() {
        return proxyFromEnvironment;
    }

    /**
     * Whether to use the proxy configuration defined by environment variables (HTTP_PROXY, HTTPS_PROXY, and NO_PROXY).<br><p> <br><p> It requires Prometheus &gt;= v2.43.0, Alertmanager &gt;= v0.25.0 or Thanos &gt;= v0.32.0.
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
     * RemoteWriteSpec defines the configuration to write samples from Prometheus to a remote endpoint.
     */
    @JsonProperty("queueConfig")
    public QueueConfig getQueueConfig() {
        return queueConfig;
    }

    /**
     * RemoteWriteSpec defines the configuration to write samples from Prometheus to a remote endpoint.
     */
    @JsonProperty("queueConfig")
    public void setQueueConfig(QueueConfig queueConfig) {
        this.queueConfig = queueConfig;
    }

    /**
     * Timeout for requests to the remote write endpoint.
     */
    @JsonProperty("remoteTimeout")
    public String getRemoteTimeout() {
        return remoteTimeout;
    }

    /**
     * Timeout for requests to the remote write endpoint.
     */
    @JsonProperty("remoteTimeout")
    public void setRemoteTimeout(String remoteTimeout) {
        this.remoteTimeout = remoteTimeout;
    }

    /**
     * When enabled:<br><p>     - The remote-write mechanism will resolve the hostname via DNS.<br><p>     - It will randomly select one of the resolved IP addresses and connect to it.<br><p> <br><p> When disabled (default behavior):<br><p>     - The Go standard library will handle hostname resolution.<br><p>     - It will attempt connections to each resolved IP address sequentially.<br><p> <br><p> Note: The connection timeout applies to the entire resolution and connection process.<br><p>       If disabled, the timeout is distributed across all connection attempts.<br><p> <br><p> It requires Prometheus &gt;= v3.1.0 or Thanos &gt;= v0.38.0.
     */
    @JsonProperty("roundRobinDNS")
    public Boolean getRoundRobinDNS() {
        return roundRobinDNS;
    }

    /**
     * When enabled:<br><p>     - The remote-write mechanism will resolve the hostname via DNS.<br><p>     - It will randomly select one of the resolved IP addresses and connect to it.<br><p> <br><p> When disabled (default behavior):<br><p>     - The Go standard library will handle hostname resolution.<br><p>     - It will attempt connections to each resolved IP address sequentially.<br><p> <br><p> Note: The connection timeout applies to the entire resolution and connection process.<br><p>       If disabled, the timeout is distributed across all connection attempts.<br><p> <br><p> It requires Prometheus &gt;= v3.1.0 or Thanos &gt;= v0.38.0.
     */
    @JsonProperty("roundRobinDNS")
    public void setRoundRobinDNS(Boolean roundRobinDNS) {
        this.roundRobinDNS = roundRobinDNS;
    }

    /**
     * Enables sending of exemplars over remote write. Note that exemplar-storage itself must be enabled using the `spec.enableFeatures` option for exemplars to be scraped in the first place.<br><p> <br><p> It requires Prometheus &gt;= v2.27.0 or Thanos &gt;= v0.24.0.
     */
    @JsonProperty("sendExemplars")
    public Boolean getSendExemplars() {
        return sendExemplars;
    }

    /**
     * Enables sending of exemplars over remote write. Note that exemplar-storage itself must be enabled using the `spec.enableFeatures` option for exemplars to be scraped in the first place.<br><p> <br><p> It requires Prometheus &gt;= v2.27.0 or Thanos &gt;= v0.24.0.
     */
    @JsonProperty("sendExemplars")
    public void setSendExemplars(Boolean sendExemplars) {
        this.sendExemplars = sendExemplars;
    }

    /**
     * Enables sending of native histograms, also known as sparse histograms over remote write.<br><p> <br><p> It requires Prometheus &gt;= v2.40.0 or Thanos &gt;= v0.30.0.
     */
    @JsonProperty("sendNativeHistograms")
    public Boolean getSendNativeHistograms() {
        return sendNativeHistograms;
    }

    /**
     * Enables sending of native histograms, also known as sparse histograms over remote write.<br><p> <br><p> It requires Prometheus &gt;= v2.40.0 or Thanos &gt;= v0.30.0.
     */
    @JsonProperty("sendNativeHistograms")
    public void setSendNativeHistograms(Boolean sendNativeHistograms) {
        this.sendNativeHistograms = sendNativeHistograms;
    }

    /**
     * RemoteWriteSpec defines the configuration to write samples from Prometheus to a remote endpoint.
     */
    @JsonProperty("sigv4")
    public Sigv4 getSigv4() {
        return sigv4;
    }

    /**
     * RemoteWriteSpec defines the configuration to write samples from Prometheus to a remote endpoint.
     */
    @JsonProperty("sigv4")
    public void setSigv4(Sigv4 sigv4) {
        this.sigv4 = sigv4;
    }

    /**
     * RemoteWriteSpec defines the configuration to write samples from Prometheus to a remote endpoint.
     */
    @JsonProperty("tlsConfig")
    public TLSConfig getTlsConfig() {
        return tlsConfig;
    }

    /**
     * RemoteWriteSpec defines the configuration to write samples from Prometheus to a remote endpoint.
     */
    @JsonProperty("tlsConfig")
    public void setTlsConfig(TLSConfig tlsConfig) {
        this.tlsConfig = tlsConfig;
    }

    /**
     * The URL of the endpoint to send samples to.
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * The URL of the endpoint to send samples to.
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * The list of remote write relabel configurations.
     */
    @JsonProperty("writeRelabelConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RelabelConfig> getWriteRelabelConfigs() {
        return writeRelabelConfigs;
    }

    /**
     * The list of remote write relabel configurations.
     */
    @JsonProperty("writeRelabelConfigs")
    public void setWriteRelabelConfigs(List<RelabelConfig> writeRelabelConfigs) {
        this.writeRelabelConfigs = writeRelabelConfigs;
    }

    @JsonIgnore
    public RemoteWriteSpecBuilder edit() {
        return new RemoteWriteSpecBuilder(this);
    }

    @JsonIgnore
    public RemoteWriteSpecBuilder toBuilder() {
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
