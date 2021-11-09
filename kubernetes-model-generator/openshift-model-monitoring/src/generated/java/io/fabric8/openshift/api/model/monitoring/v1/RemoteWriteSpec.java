
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
    "bearerToken",
    "bearerTokenFile",
    "headers",
    "metadataConfig",
    "name",
    "proxyUrl",
    "queueConfig",
    "remoteTimeout",
    "tlsConfig",
    "url",
    "writeRelabelConfigs"
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
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
public class RemoteWriteSpec implements KubernetesResource
{

    @JsonProperty("basicAuth")
    private BasicAuth basicAuth;
    @JsonProperty("bearerToken")
    private java.lang.String bearerToken;
    @JsonProperty("bearerTokenFile")
    private java.lang.String bearerTokenFile;
    @JsonProperty("headers")
    private Map<String, String> headers;
    @JsonProperty("metadataConfig")
    private MetadataConfig metadataConfig;
    @JsonProperty("name")
    private java.lang.String name;
    @JsonProperty("proxyUrl")
    private java.lang.String proxyUrl;
    @JsonProperty("queueConfig")
    private QueueConfig queueConfig;
    @JsonProperty("remoteTimeout")
    private java.lang.String remoteTimeout;
    @JsonProperty("tlsConfig")
    private TLSConfig tlsConfig;
    @JsonProperty("url")
    private java.lang.String url;
    @JsonProperty("writeRelabelConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RelabelConfig> writeRelabelConfigs = new ArrayList<RelabelConfig>();
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public RemoteWriteSpec() {
    }

    /**
     * 
     * @param headers
     * @param bearerToken
     * @param remoteTimeout
     * @param queueConfig
     * @param writeRelabelConfigs
     * @param basicAuth
     * @param proxyUrl
     * @param name
     * @param bearerTokenFile
     * @param url
     * @param metadataConfig
     * @param tlsConfig
     */
    public RemoteWriteSpec(BasicAuth basicAuth, java.lang.String bearerToken, java.lang.String bearerTokenFile, Map<String, String> headers, MetadataConfig metadataConfig, java.lang.String name, java.lang.String proxyUrl, QueueConfig queueConfig, java.lang.String remoteTimeout, TLSConfig tlsConfig, java.lang.String url, List<RelabelConfig> writeRelabelConfigs) {
        super();
        this.basicAuth = basicAuth;
        this.bearerToken = bearerToken;
        this.bearerTokenFile = bearerTokenFile;
        this.headers = headers;
        this.metadataConfig = metadataConfig;
        this.name = name;
        this.proxyUrl = proxyUrl;
        this.queueConfig = queueConfig;
        this.remoteTimeout = remoteTimeout;
        this.tlsConfig = tlsConfig;
        this.url = url;
        this.writeRelabelConfigs = writeRelabelConfigs;
    }

    @JsonProperty("basicAuth")
    public BasicAuth getBasicAuth() {
        return basicAuth;
    }

    @JsonProperty("basicAuth")
    public void setBasicAuth(BasicAuth basicAuth) {
        this.basicAuth = basicAuth;
    }

    @JsonProperty("bearerToken")
    public java.lang.String getBearerToken() {
        return bearerToken;
    }

    @JsonProperty("bearerToken")
    public void setBearerToken(java.lang.String bearerToken) {
        this.bearerToken = bearerToken;
    }

    @JsonProperty("bearerTokenFile")
    public java.lang.String getBearerTokenFile() {
        return bearerTokenFile;
    }

    @JsonProperty("bearerTokenFile")
    public void setBearerTokenFile(java.lang.String bearerTokenFile) {
        this.bearerTokenFile = bearerTokenFile;
    }

    @JsonProperty("headers")
    public Map<String, String> getHeaders() {
        return headers;
    }

    @JsonProperty("headers")
    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    @JsonProperty("metadataConfig")
    public MetadataConfig getMetadataConfig() {
        return metadataConfig;
    }

    @JsonProperty("metadataConfig")
    public void setMetadataConfig(MetadataConfig metadataConfig) {
        this.metadataConfig = metadataConfig;
    }

    @JsonProperty("name")
    public java.lang.String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(java.lang.String name) {
        this.name = name;
    }

    @JsonProperty("proxyUrl")
    public java.lang.String getProxyUrl() {
        return proxyUrl;
    }

    @JsonProperty("proxyUrl")
    public void setProxyUrl(java.lang.String proxyUrl) {
        this.proxyUrl = proxyUrl;
    }

    @JsonProperty("queueConfig")
    public QueueConfig getQueueConfig() {
        return queueConfig;
    }

    @JsonProperty("queueConfig")
    public void setQueueConfig(QueueConfig queueConfig) {
        this.queueConfig = queueConfig;
    }

    @JsonProperty("remoteTimeout")
    public java.lang.String getRemoteTimeout() {
        return remoteTimeout;
    }

    @JsonProperty("remoteTimeout")
    public void setRemoteTimeout(java.lang.String remoteTimeout) {
        this.remoteTimeout = remoteTimeout;
    }

    @JsonProperty("tlsConfig")
    public TLSConfig getTlsConfig() {
        return tlsConfig;
    }

    @JsonProperty("tlsConfig")
    public void setTlsConfig(TLSConfig tlsConfig) {
        this.tlsConfig = tlsConfig;
    }

    @JsonProperty("url")
    public java.lang.String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(java.lang.String url) {
        this.url = url;
    }

    @JsonProperty("writeRelabelConfigs")
    public List<RelabelConfig> getWriteRelabelConfigs() {
        return writeRelabelConfigs;
    }

    @JsonProperty("writeRelabelConfigs")
    public void setWriteRelabelConfigs(List<RelabelConfig> writeRelabelConfigs) {
        this.writeRelabelConfigs = writeRelabelConfigs;
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
