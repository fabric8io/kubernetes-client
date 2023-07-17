
package io.fabric8.openshift.api.model.monitoring.v1;

import java.util.LinkedHashMap;
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
    "authorization",
    "basicAuth",
    "bearerToken",
    "bearerTokenFile",
    "headers",
    "name",
    "oauth2",
    "proxyUrl",
    "readRecent",
    "remoteTimeout",
    "requiredMatchers",
    "tlsConfig",
    "url"
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
@Generated("jsonschema2pojo")
public class RemoteReadSpec implements KubernetesResource
{

    @JsonProperty("authorization")
    private Authorization authorization;
    @JsonProperty("basicAuth")
    private BasicAuth basicAuth;
    @JsonProperty("bearerToken")
    private java.lang.String bearerToken;
    @JsonProperty("bearerTokenFile")
    private java.lang.String bearerTokenFile;
    @JsonProperty("headers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> headers = new LinkedHashMap<String, String>();
    @JsonProperty("name")
    private java.lang.String name;
    @JsonProperty("oauth2")
    private OAuth2 oauth2;
    @JsonProperty("proxyUrl")
    private java.lang.String proxyUrl;
    @JsonProperty("readRecent")
    private Boolean readRecent;
    @JsonProperty("remoteTimeout")
    private java.lang.String remoteTimeout;
    @JsonProperty("requiredMatchers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> requiredMatchers = new LinkedHashMap<String, String>();
    @JsonProperty("tlsConfig")
    private TLSConfig tlsConfig;
    @JsonProperty("url")
    private java.lang.String url;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public RemoteReadSpec() {
    }

    public RemoteReadSpec(Authorization authorization, BasicAuth basicAuth, java.lang.String bearerToken, java.lang.String bearerTokenFile, Map<String, String> headers, java.lang.String name, OAuth2 oauth2, java.lang.String proxyUrl, Boolean readRecent, java.lang.String remoteTimeout, Map<String, String> requiredMatchers, TLSConfig tlsConfig, java.lang.String url) {
        super();
        this.authorization = authorization;
        this.basicAuth = basicAuth;
        this.bearerToken = bearerToken;
        this.bearerTokenFile = bearerTokenFile;
        this.headers = headers;
        this.name = name;
        this.oauth2 = oauth2;
        this.proxyUrl = proxyUrl;
        this.readRecent = readRecent;
        this.remoteTimeout = remoteTimeout;
        this.requiredMatchers = requiredMatchers;
        this.tlsConfig = tlsConfig;
        this.url = url;
    }

    @JsonProperty("authorization")
    public Authorization getAuthorization() {
        return authorization;
    }

    @JsonProperty("authorization")
    public void setAuthorization(Authorization authorization) {
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

    @JsonProperty("name")
    public java.lang.String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(java.lang.String name) {
        this.name = name;
    }

    @JsonProperty("oauth2")
    public OAuth2 getOauth2() {
        return oauth2;
    }

    @JsonProperty("oauth2")
    public void setOauth2(OAuth2 oauth2) {
        this.oauth2 = oauth2;
    }

    @JsonProperty("proxyUrl")
    public java.lang.String getProxyUrl() {
        return proxyUrl;
    }

    @JsonProperty("proxyUrl")
    public void setProxyUrl(java.lang.String proxyUrl) {
        this.proxyUrl = proxyUrl;
    }

    @JsonProperty("readRecent")
    public Boolean getReadRecent() {
        return readRecent;
    }

    @JsonProperty("readRecent")
    public void setReadRecent(Boolean readRecent) {
        this.readRecent = readRecent;
    }

    @JsonProperty("remoteTimeout")
    public java.lang.String getRemoteTimeout() {
        return remoteTimeout;
    }

    @JsonProperty("remoteTimeout")
    public void setRemoteTimeout(java.lang.String remoteTimeout) {
        this.remoteTimeout = remoteTimeout;
    }

    @JsonProperty("requiredMatchers")
    public Map<String, String> getRequiredMatchers() {
        return requiredMatchers;
    }

    @JsonProperty("requiredMatchers")
    public void setRequiredMatchers(Map<String, String> requiredMatchers) {
        this.requiredMatchers = requiredMatchers;
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

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
