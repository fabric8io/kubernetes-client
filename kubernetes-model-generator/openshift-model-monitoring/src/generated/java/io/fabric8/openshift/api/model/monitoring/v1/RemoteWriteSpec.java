
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
     * bearerToken is deprecated: this will be removed in a future release. &#42;Warning: this field shouldn't be used because the token value appears in clear-text. Prefer using `authorization`.&#42;
     */
    @JsonProperty("bearerToken")
    public String getBearerToken() {
        return bearerToken;
    }

    /**
     * bearerToken is deprecated: this will be removed in a future release. &#42;Warning: this field shouldn't be used because the token value appears in clear-text. Prefer using `authorization`.&#42;
     */
    @JsonProperty("bearerToken")
    public void setBearerToken(String bearerToken) {
        this.bearerToken = bearerToken;
    }

    /**
     * bearerTokenFile defines the file from which to read bearer token for the URL.<br><p> <br><p> Deprecated: this will be removed in a future release. Prefer using `authorization`.
     */
    @JsonProperty("bearerTokenFile")
    public String getBearerTokenFile() {
        return bearerTokenFile;
    }

    /**
     * bearerTokenFile defines the file from which to read bearer token for the URL.<br><p> <br><p> Deprecated: this will be removed in a future release. Prefer using `authorization`.
     */
    @JsonProperty("bearerTokenFile")
    public void setBearerTokenFile(String bearerTokenFile) {
        this.bearerTokenFile = bearerTokenFile;
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
     * followRedirects defines whether HTTP requests follow HTTP 3xx redirects.<br><p> <br><p> It requires Prometheus &gt;= v2.26.0 or Thanos &gt;= v0.24.0.
     */
    @JsonProperty("followRedirects")
    public Boolean getFollowRedirects() {
        return followRedirects;
    }

    /**
     * followRedirects defines whether HTTP requests follow HTTP 3xx redirects.<br><p> <br><p> It requires Prometheus &gt;= v2.26.0 or Thanos &gt;= v0.24.0.
     */
    @JsonProperty("followRedirects")
    public void setFollowRedirects(Boolean followRedirects) {
        this.followRedirects = followRedirects;
    }

    /**
     * headers defines the custom HTTP headers to be sent along with each remote write request. Be aware that headers that are set by Prometheus itself can't be overwritten.<br><p> <br><p> It requires Prometheus &gt;= v2.25.0 or Thanos &gt;= v0.24.0.
     */
    @JsonProperty("headers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getHeaders() {
        return headers;
    }

    /**
     * headers defines the custom HTTP headers to be sent along with each remote write request. Be aware that headers that are set by Prometheus itself can't be overwritten.<br><p> <br><p> It requires Prometheus &gt;= v2.25.0 or Thanos &gt;= v0.24.0.
     */
    @JsonProperty("headers")
    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    /**
     * messageVersion defines the Remote Write message's version to use when writing to the endpoint.<br><p> <br><p> `Version1.0` corresponds to the `prometheus.WriteRequest` protobuf message introduced in Remote Write 1.0. `Version2.0` corresponds to the `io.prometheus.write.v2.Request` protobuf message introduced in Remote Write 2.0.<br><p> <br><p> When `Version2.0` is selected, Prometheus will automatically be configured to append the metadata of scraped metrics to the WAL.<br><p> <br><p> Before setting this field, consult with your remote storage provider what message version it supports.<br><p> <br><p> It requires Prometheus &gt;= v2.54.0 or Thanos &gt;= v0.37.0.
     */
    @JsonProperty("messageVersion")
    public String getMessageVersion() {
        return messageVersion;
    }

    /**
     * messageVersion defines the Remote Write message's version to use when writing to the endpoint.<br><p> <br><p> `Version1.0` corresponds to the `prometheus.WriteRequest` protobuf message introduced in Remote Write 1.0. `Version2.0` corresponds to the `io.prometheus.write.v2.Request` protobuf message introduced in Remote Write 2.0.<br><p> <br><p> When `Version2.0` is selected, Prometheus will automatically be configured to append the metadata of scraped metrics to the WAL.<br><p> <br><p> Before setting this field, consult with your remote storage provider what message version it supports.<br><p> <br><p> It requires Prometheus &gt;= v2.54.0 or Thanos &gt;= v0.37.0.
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
     * name of the remote write queue, it must be unique if specified. The name is used in metrics and logging in order to differentiate queues.<br><p> <br><p> It requires Prometheus &gt;= v2.15.0 or Thanos &gt;= 0.24.0.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name of the remote write queue, it must be unique if specified. The name is used in metrics and logging in order to differentiate queues.<br><p> <br><p> It requires Prometheus &gt;= v2.15.0 or Thanos &gt;= 0.24.0.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
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
     * remoteTimeout defines the timeout for requests to the remote write endpoint.
     */
    @JsonProperty("remoteTimeout")
    public String getRemoteTimeout() {
        return remoteTimeout;
    }

    /**
     * remoteTimeout defines the timeout for requests to the remote write endpoint.
     */
    @JsonProperty("remoteTimeout")
    public void setRemoteTimeout(String remoteTimeout) {
        this.remoteTimeout = remoteTimeout;
    }

    /**
     * roundRobinDNS controls the DNS resolution behavior for remote-write connections. When enabled:<br><p>   - The remote-write mechanism will resolve the hostname via DNS.<br><p>   - It will randomly select one of the resolved IP addresses and connect to it.<br><p> <br><p> When disabled (default behavior):<br><p>   - The Go standard library will handle hostname resolution.<br><p>   - It will attempt connections to each resolved IP address sequentially.<br><p> <br><p> Note: The connection timeout applies to the entire resolution and connection process.<br><p> <br><p> 	If disabled, the timeout is distributed across all connection attempts.<br><p> <br><p> It requires Prometheus &gt;= v3.1.0 or Thanos &gt;= v0.38.0.
     */
    @JsonProperty("roundRobinDNS")
    public Boolean getRoundRobinDNS() {
        return roundRobinDNS;
    }

    /**
     * roundRobinDNS controls the DNS resolution behavior for remote-write connections. When enabled:<br><p>   - The remote-write mechanism will resolve the hostname via DNS.<br><p>   - It will randomly select one of the resolved IP addresses and connect to it.<br><p> <br><p> When disabled (default behavior):<br><p>   - The Go standard library will handle hostname resolution.<br><p>   - It will attempt connections to each resolved IP address sequentially.<br><p> <br><p> Note: The connection timeout applies to the entire resolution and connection process.<br><p> <br><p> 	If disabled, the timeout is distributed across all connection attempts.<br><p> <br><p> It requires Prometheus &gt;= v3.1.0 or Thanos &gt;= v0.38.0.
     */
    @JsonProperty("roundRobinDNS")
    public void setRoundRobinDNS(Boolean roundRobinDNS) {
        this.roundRobinDNS = roundRobinDNS;
    }

    /**
     * sendExemplars enables sending of exemplars over remote write. Note that exemplar-storage itself must be enabled using the `spec.enableFeatures` option for exemplars to be scraped in the first place.<br><p> <br><p> It requires Prometheus &gt;= v2.27.0 or Thanos &gt;= v0.24.0.
     */
    @JsonProperty("sendExemplars")
    public Boolean getSendExemplars() {
        return sendExemplars;
    }

    /**
     * sendExemplars enables sending of exemplars over remote write. Note that exemplar-storage itself must be enabled using the `spec.enableFeatures` option for exemplars to be scraped in the first place.<br><p> <br><p> It requires Prometheus &gt;= v2.27.0 or Thanos &gt;= v0.24.0.
     */
    @JsonProperty("sendExemplars")
    public void setSendExemplars(Boolean sendExemplars) {
        this.sendExemplars = sendExemplars;
    }

    /**
     * sendNativeHistograms enables sending of native histograms, also known as sparse histograms over remote write.<br><p> <br><p> It requires Prometheus &gt;= v2.40.0 or Thanos &gt;= v0.30.0.
     */
    @JsonProperty("sendNativeHistograms")
    public Boolean getSendNativeHistograms() {
        return sendNativeHistograms;
    }

    /**
     * sendNativeHistograms enables sending of native histograms, also known as sparse histograms over remote write.<br><p> <br><p> It requires Prometheus &gt;= v2.40.0 or Thanos &gt;= v0.30.0.
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
     * url defines the URL of the endpoint to send samples to.<br><p> <br><p> It must use the HTTP or HTTPS scheme.
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * url defines the URL of the endpoint to send samples to.<br><p> <br><p> It must use the HTTP or HTTPS scheme.
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * writeRelabelConfigs defines the list of remote write relabel configurations.
     */
    @JsonProperty("writeRelabelConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RelabelConfig> getWriteRelabelConfigs() {
        return writeRelabelConfigs;
    }

    /**
     * writeRelabelConfigs defines the list of remote write relabel configurations.
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof RemoteWriteSpec)) {
            return false;
        }
        RemoteWriteSpec other = (RemoteWriteSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$authorization = this.getAuthorization();
        Object other$authorization = other.getAuthorization();
        if (this$authorization == null ? other$authorization != null : !this$authorization.equals(other$authorization)) {
            return false;
        }
        Object this$azureAd = this.getAzureAd();
        Object other$azureAd = other.getAzureAd();
        if (this$azureAd == null ? other$azureAd != null : !this$azureAd.equals(other$azureAd)) {
            return false;
        }
        Object this$basicAuth = this.getBasicAuth();
        Object other$basicAuth = other.getBasicAuth();
        if (this$basicAuth == null ? other$basicAuth != null : !this$basicAuth.equals(other$basicAuth)) {
            return false;
        }
        Object this$bearerToken = this.getBearerToken();
        Object other$bearerToken = other.getBearerToken();
        if (this$bearerToken == null ? other$bearerToken != null : !this$bearerToken.equals(other$bearerToken)) {
            return false;
        }
        Object this$bearerTokenFile = this.getBearerTokenFile();
        Object other$bearerTokenFile = other.getBearerTokenFile();
        if (this$bearerTokenFile == null ? other$bearerTokenFile != null : !this$bearerTokenFile.equals(other$bearerTokenFile)) {
            return false;
        }
        Object this$enableHTTP2 = this.getEnableHTTP2();
        Object other$enableHTTP2 = other.getEnableHTTP2();
        if (this$enableHTTP2 == null ? other$enableHTTP2 != null : !this$enableHTTP2.equals(other$enableHTTP2)) {
            return false;
        }
        Object this$followRedirects = this.getFollowRedirects();
        Object other$followRedirects = other.getFollowRedirects();
        if (this$followRedirects == null ? other$followRedirects != null : !this$followRedirects.equals(other$followRedirects)) {
            return false;
        }
        Object this$headers = this.getHeaders();
        Object other$headers = other.getHeaders();
        if (this$headers == null ? other$headers != null : !this$headers.equals(other$headers)) {
            return false;
        }
        Object this$messageVersion = this.getMessageVersion();
        Object other$messageVersion = other.getMessageVersion();
        if (this$messageVersion == null ? other$messageVersion != null : !this$messageVersion.equals(other$messageVersion)) {
            return false;
        }
        Object this$metadataConfig = this.getMetadataConfig();
        Object other$metadataConfig = other.getMetadataConfig();
        if (this$metadataConfig == null ? other$metadataConfig != null : !this$metadataConfig.equals(other$metadataConfig)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
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
        Object this$queueConfig = this.getQueueConfig();
        Object other$queueConfig = other.getQueueConfig();
        if (this$queueConfig == null ? other$queueConfig != null : !this$queueConfig.equals(other$queueConfig)) {
            return false;
        }
        Object this$remoteTimeout = this.getRemoteTimeout();
        Object other$remoteTimeout = other.getRemoteTimeout();
        if (this$remoteTimeout == null ? other$remoteTimeout != null : !this$remoteTimeout.equals(other$remoteTimeout)) {
            return false;
        }
        Object this$roundRobinDNS = this.getRoundRobinDNS();
        Object other$roundRobinDNS = other.getRoundRobinDNS();
        if (this$roundRobinDNS == null ? other$roundRobinDNS != null : !this$roundRobinDNS.equals(other$roundRobinDNS)) {
            return false;
        }
        Object this$sendExemplars = this.getSendExemplars();
        Object other$sendExemplars = other.getSendExemplars();
        if (this$sendExemplars == null ? other$sendExemplars != null : !this$sendExemplars.equals(other$sendExemplars)) {
            return false;
        }
        Object this$sendNativeHistograms = this.getSendNativeHistograms();
        Object other$sendNativeHistograms = other.getSendNativeHistograms();
        if (this$sendNativeHistograms == null ? other$sendNativeHistograms != null : !this$sendNativeHistograms.equals(other$sendNativeHistograms)) {
            return false;
        }
        Object this$sigv4 = this.getSigv4();
        Object other$sigv4 = other.getSigv4();
        if (this$sigv4 == null ? other$sigv4 != null : !this$sigv4.equals(other$sigv4)) {
            return false;
        }
        Object this$tlsConfig = this.getTlsConfig();
        Object other$tlsConfig = other.getTlsConfig();
        if (this$tlsConfig == null ? other$tlsConfig != null : !this$tlsConfig.equals(other$tlsConfig)) {
            return false;
        }
        Object this$url = this.getUrl();
        Object other$url = other.getUrl();
        if (this$url == null ? other$url != null : !this$url.equals(other$url)) {
            return false;
        }
        Object this$writeRelabelConfigs = this.getWriteRelabelConfigs();
        Object other$writeRelabelConfigs = other.getWriteRelabelConfigs();
        if (this$writeRelabelConfigs == null ? other$writeRelabelConfigs != null : !this$writeRelabelConfigs.equals(other$writeRelabelConfigs)) {
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
        return other instanceof RemoteWriteSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $authorization = this.getAuthorization();
        result = result * prime + ($authorization == null ? 43 : $authorization.hashCode());
        Object $azureAd = this.getAzureAd();
        result = result * prime + ($azureAd == null ? 43 : $azureAd.hashCode());
        Object $basicAuth = this.getBasicAuth();
        result = result * prime + ($basicAuth == null ? 43 : $basicAuth.hashCode());
        Object $bearerToken = this.getBearerToken();
        result = result * prime + ($bearerToken == null ? 43 : $bearerToken.hashCode());
        Object $bearerTokenFile = this.getBearerTokenFile();
        result = result * prime + ($bearerTokenFile == null ? 43 : $bearerTokenFile.hashCode());
        Object $enableHTTP2 = this.getEnableHTTP2();
        result = result * prime + ($enableHTTP2 == null ? 43 : $enableHTTP2.hashCode());
        Object $followRedirects = this.getFollowRedirects();
        result = result * prime + ($followRedirects == null ? 43 : $followRedirects.hashCode());
        Object $headers = this.getHeaders();
        result = result * prime + ($headers == null ? 43 : $headers.hashCode());
        Object $messageVersion = this.getMessageVersion();
        result = result * prime + ($messageVersion == null ? 43 : $messageVersion.hashCode());
        Object $metadataConfig = this.getMetadataConfig();
        result = result * prime + ($metadataConfig == null ? 43 : $metadataConfig.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $noProxy = this.getNoProxy();
        result = result * prime + ($noProxy == null ? 43 : $noProxy.hashCode());
        Object $oauth2 = this.getOauth2();
        result = result * prime + ($oauth2 == null ? 43 : $oauth2.hashCode());
        Object $proxyConnectHeader = this.getProxyConnectHeader();
        result = result * prime + ($proxyConnectHeader == null ? 43 : $proxyConnectHeader.hashCode());
        Object $proxyFromEnvironment = this.getProxyFromEnvironment();
        result = result * prime + ($proxyFromEnvironment == null ? 43 : $proxyFromEnvironment.hashCode());
        Object $proxyUrl = this.getProxyUrl();
        result = result * prime + ($proxyUrl == null ? 43 : $proxyUrl.hashCode());
        Object $queueConfig = this.getQueueConfig();
        result = result * prime + ($queueConfig == null ? 43 : $queueConfig.hashCode());
        Object $remoteTimeout = this.getRemoteTimeout();
        result = result * prime + ($remoteTimeout == null ? 43 : $remoteTimeout.hashCode());
        Object $roundRobinDNS = this.getRoundRobinDNS();
        result = result * prime + ($roundRobinDNS == null ? 43 : $roundRobinDNS.hashCode());
        Object $sendExemplars = this.getSendExemplars();
        result = result * prime + ($sendExemplars == null ? 43 : $sendExemplars.hashCode());
        Object $sendNativeHistograms = this.getSendNativeHistograms();
        result = result * prime + ($sendNativeHistograms == null ? 43 : $sendNativeHistograms.hashCode());
        Object $sigv4 = this.getSigv4();
        result = result * prime + ($sigv4 == null ? 43 : $sigv4.hashCode());
        Object $tlsConfig = this.getTlsConfig();
        result = result * prime + ($tlsConfig == null ? 43 : $tlsConfig.hashCode());
        Object $url = this.getUrl();
        result = result * prime + ($url == null ? 43 : $url.hashCode());
        Object $writeRelabelConfigs = this.getWriteRelabelConfigs();
        result = result * prime + ($writeRelabelConfigs == null ? 43 : $writeRelabelConfigs.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "RemoteWriteSpec(" + "authorization=" + this.getAuthorization() + ", azureAd=" + this.getAzureAd() + ", basicAuth=" + this.getBasicAuth() + ", bearerToken=" + this.getBearerToken() + ", bearerTokenFile=" + this.getBearerTokenFile() + ", enableHTTP2=" + this.getEnableHTTP2() + ", followRedirects=" + this.getFollowRedirects() + ", headers=" + this.getHeaders() + ", messageVersion=" + this.getMessageVersion() + ", metadataConfig=" + this.getMetadataConfig() + ", name=" + this.getName() + ", noProxy=" + this.getNoProxy() + ", oauth2=" + this.getOauth2() + ", proxyConnectHeader=" + this.getProxyConnectHeader() + ", proxyFromEnvironment=" + this.getProxyFromEnvironment() + ", proxyUrl=" + this.getProxyUrl() + ", queueConfig=" + this.getQueueConfig() + ", remoteTimeout=" + this.getRemoteTimeout() + ", roundRobinDNS=" + this.getRoundRobinDNS() + ", sendExemplars=" + this.getSendExemplars() + ", sendNativeHistograms=" + this.getSendNativeHistograms() + ", sigv4=" + this.getSigv4() + ", tlsConfig=" + this.getTlsConfig() + ", url=" + this.getUrl() + ", writeRelabelConfigs=" + this.getWriteRelabelConfigs() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
