
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
import lombok.ToString;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "basicAuth",
    "bearerToken",
    "bearerTokenFile",
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
    private String bearerToken;
    @JsonProperty("bearerTokenFile")
    private String bearerTokenFile;
    @JsonProperty("name")
    private String name;
    @JsonProperty("proxyUrl")
    private String proxyUrl;
    @JsonProperty("queueConfig")
    private QueueConfig queueConfig;
    @JsonProperty("remoteTimeout")
    private String remoteTimeout;
    @JsonProperty("tlsConfig")
    private TLSConfig tlsConfig;
    @JsonProperty("url")
    private String url;
    @JsonProperty("writeRelabelConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RelabelConfig> writeRelabelConfigs = new ArrayList<RelabelConfig>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public RemoteWriteSpec() {
    }

    /**
     * 
     * @param bearerToken
     * @param remoteTimeout
     * @param queueConfig
     * @param writeRelabelConfigs
     * @param basicAuth
     * @param proxyUrl
     * @param name
     * @param bearerTokenFile
     * @param url
     * @param tlsConfig
     */
    public RemoteWriteSpec(BasicAuth basicAuth, String bearerToken, String bearerTokenFile, String name, String proxyUrl, QueueConfig queueConfig, String remoteTimeout, TLSConfig tlsConfig, String url, List<RelabelConfig> writeRelabelConfigs) {
        super();
        this.basicAuth = basicAuth;
        this.bearerToken = bearerToken;
        this.bearerTokenFile = bearerTokenFile;
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
    public String getBearerToken() {
        return bearerToken;
    }

    @JsonProperty("bearerToken")
    public void setBearerToken(String bearerToken) {
        this.bearerToken = bearerToken;
    }

    @JsonProperty("bearerTokenFile")
    public String getBearerTokenFile() {
        return bearerTokenFile;
    }

    @JsonProperty("bearerTokenFile")
    public void setBearerTokenFile(String bearerTokenFile) {
        this.bearerTokenFile = bearerTokenFile;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("proxyUrl")
    public String getProxyUrl() {
        return proxyUrl;
    }

    @JsonProperty("proxyUrl")
    public void setProxyUrl(String proxyUrl) {
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
    public String getRemoteTimeout() {
        return remoteTimeout;
    }

    @JsonProperty("remoteTimeout")
    public void setRemoteTimeout(String remoteTimeout) {
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
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
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
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
