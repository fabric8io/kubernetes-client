
package io.fabric8.openshift.api.model.monitoring.v1;

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
 * RemoteReadSpec defines the configuration for Prometheus to read back samples from a remote endpoint.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "authorization",
    "basicAuth",
    "bearerToken",
    "bearerTokenFile",
    "filterExternalLabels",
    "followRedirects",
    "headers",
    "name",
    "noProxy",
    "oauth2",
    "proxyConnectHeader",
    "proxyFromEnvironment",
    "proxyUrl",
    "readRecent",
    "remoteTimeout",
    "requiredMatchers",
    "tlsConfig",
    "url"
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
public class RemoteReadSpec implements Editable<RemoteReadSpecBuilder>, KubernetesResource
{

    @JsonProperty("authorization")
    private Authorization authorization;
    @JsonProperty("basicAuth")
    private BasicAuth basicAuth;
    @JsonProperty("bearerToken")
    private String bearerToken;
    @JsonProperty("bearerTokenFile")
    private String bearerTokenFile;
    @JsonProperty("filterExternalLabels")
    private Boolean filterExternalLabels;
    @JsonProperty("followRedirects")
    private Boolean followRedirects;
    @JsonProperty("headers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> headers = new LinkedHashMap<>();
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
    @JsonProperty("readRecent")
    private Boolean readRecent;
    @JsonProperty("remoteTimeout")
    private String remoteTimeout;
    @JsonProperty("requiredMatchers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> requiredMatchers = new LinkedHashMap<>();
    @JsonProperty("tlsConfig")
    private TLSConfig tlsConfig;
    @JsonProperty("url")
    private String url;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RemoteReadSpec() {
    }

    public RemoteReadSpec(Authorization authorization, BasicAuth basicAuth, String bearerToken, String bearerTokenFile, Boolean filterExternalLabels, Boolean followRedirects, Map<String, String> headers, String name, String noProxy, OAuth2 oauth2, Map<String, List<SecretKeySelector>> proxyConnectHeader, Boolean proxyFromEnvironment, String proxyUrl, Boolean readRecent, String remoteTimeout, Map<String, String> requiredMatchers, TLSConfig tlsConfig, String url) {
        super();
        this.authorization = authorization;
        this.basicAuth = basicAuth;
        this.bearerToken = bearerToken;
        this.bearerTokenFile = bearerTokenFile;
        this.filterExternalLabels = filterExternalLabels;
        this.followRedirects = followRedirects;
        this.headers = headers;
        this.name = name;
        this.noProxy = noProxy;
        this.oauth2 = oauth2;
        this.proxyConnectHeader = proxyConnectHeader;
        this.proxyFromEnvironment = proxyFromEnvironment;
        this.proxyUrl = proxyUrl;
        this.readRecent = readRecent;
        this.remoteTimeout = remoteTimeout;
        this.requiredMatchers = requiredMatchers;
        this.tlsConfig = tlsConfig;
        this.url = url;
    }

    /**
     * RemoteReadSpec defines the configuration for Prometheus to read back samples from a remote endpoint.
     */
    @JsonProperty("authorization")
    public Authorization getAuthorization() {
        return authorization;
    }

    /**
     * RemoteReadSpec defines the configuration for Prometheus to read back samples from a remote endpoint.
     */
    @JsonProperty("authorization")
    public void setAuthorization(Authorization authorization) {
        this.authorization = authorization;
    }

    /**
     * RemoteReadSpec defines the configuration for Prometheus to read back samples from a remote endpoint.
     */
    @JsonProperty("basicAuth")
    public BasicAuth getBasicAuth() {
        return basicAuth;
    }

    /**
     * RemoteReadSpec defines the configuration for Prometheus to read back samples from a remote endpoint.
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
     * bearerTokenFile defines the file from which to read the bearer token for the URL.<br><p> <br><p> Deprecated: this will be removed in a future release. Prefer using `authorization`.
     */
    @JsonProperty("bearerTokenFile")
    public String getBearerTokenFile() {
        return bearerTokenFile;
    }

    /**
     * bearerTokenFile defines the file from which to read the bearer token for the URL.<br><p> <br><p> Deprecated: this will be removed in a future release. Prefer using `authorization`.
     */
    @JsonProperty("bearerTokenFile")
    public void setBearerTokenFile(String bearerTokenFile) {
        this.bearerTokenFile = bearerTokenFile;
    }

    /**
     * filterExternalLabels defines whether to use the external labels as selectors for the remote read endpoint.<br><p> <br><p> It requires Prometheus &gt;= v2.34.0.
     */
    @JsonProperty("filterExternalLabels")
    public Boolean getFilterExternalLabels() {
        return filterExternalLabels;
    }

    /**
     * filterExternalLabels defines whether to use the external labels as selectors for the remote read endpoint.<br><p> <br><p> It requires Prometheus &gt;= v2.34.0.
     */
    @JsonProperty("filterExternalLabels")
    public void setFilterExternalLabels(Boolean filterExternalLabels) {
        this.filterExternalLabels = filterExternalLabels;
    }

    /**
     * followRedirects defines whether HTTP requests follow HTTP 3xx redirects.<br><p> <br><p> It requires Prometheus &gt;= v2.26.0.
     */
    @JsonProperty("followRedirects")
    public Boolean getFollowRedirects() {
        return followRedirects;
    }

    /**
     * followRedirects defines whether HTTP requests follow HTTP 3xx redirects.<br><p> <br><p> It requires Prometheus &gt;= v2.26.0.
     */
    @JsonProperty("followRedirects")
    public void setFollowRedirects(Boolean followRedirects) {
        this.followRedirects = followRedirects;
    }

    /**
     * headers defines the custom HTTP headers to be sent along with each remote read request. Be aware that headers that are set by Prometheus itself can't be overwritten. Only valid in Prometheus versions 2.26.0 and newer.
     */
    @JsonProperty("headers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getHeaders() {
        return headers;
    }

    /**
     * headers defines the custom HTTP headers to be sent along with each remote read request. Be aware that headers that are set by Prometheus itself can't be overwritten. Only valid in Prometheus versions 2.26.0 and newer.
     */
    @JsonProperty("headers")
    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    /**
     * name of the remote read queue, it must be unique if specified. The name is used in metrics and logging in order to differentiate read configurations.<br><p> <br><p> It requires Prometheus &gt;= v2.15.0.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name of the remote read queue, it must be unique if specified. The name is used in metrics and logging in order to differentiate read configurations.<br><p> <br><p> It requires Prometheus &gt;= v2.15.0.
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
     * RemoteReadSpec defines the configuration for Prometheus to read back samples from a remote endpoint.
     */
    @JsonProperty("oauth2")
    public OAuth2 getOauth2() {
        return oauth2;
    }

    /**
     * RemoteReadSpec defines the configuration for Prometheus to read back samples from a remote endpoint.
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
     * readRecent defines whether reads should be made for queries for time ranges that the local storage should have complete data for.
     */
    @JsonProperty("readRecent")
    public Boolean getReadRecent() {
        return readRecent;
    }

    /**
     * readRecent defines whether reads should be made for queries for time ranges that the local storage should have complete data for.
     */
    @JsonProperty("readRecent")
    public void setReadRecent(Boolean readRecent) {
        this.readRecent = readRecent;
    }

    /**
     * remoteTimeout defines the timeout for requests to the remote read endpoint.
     */
    @JsonProperty("remoteTimeout")
    public String getRemoteTimeout() {
        return remoteTimeout;
    }

    /**
     * remoteTimeout defines the timeout for requests to the remote read endpoint.
     */
    @JsonProperty("remoteTimeout")
    public void setRemoteTimeout(String remoteTimeout) {
        this.remoteTimeout = remoteTimeout;
    }

    /**
     * requiredMatchers defines an optional list of equality matchers which have to be present in a selector to query the remote read endpoint.
     */
    @JsonProperty("requiredMatchers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getRequiredMatchers() {
        return requiredMatchers;
    }

    /**
     * requiredMatchers defines an optional list of equality matchers which have to be present in a selector to query the remote read endpoint.
     */
    @JsonProperty("requiredMatchers")
    public void setRequiredMatchers(Map<String, String> requiredMatchers) {
        this.requiredMatchers = requiredMatchers;
    }

    /**
     * RemoteReadSpec defines the configuration for Prometheus to read back samples from a remote endpoint.
     */
    @JsonProperty("tlsConfig")
    public TLSConfig getTlsConfig() {
        return tlsConfig;
    }

    /**
     * RemoteReadSpec defines the configuration for Prometheus to read back samples from a remote endpoint.
     */
    @JsonProperty("tlsConfig")
    public void setTlsConfig(TLSConfig tlsConfig) {
        this.tlsConfig = tlsConfig;
    }

    /**
     * url defines the URL of the endpoint to query from.
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * url defines the URL of the endpoint to query from.
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonIgnore
    public RemoteReadSpecBuilder edit() {
        return new RemoteReadSpecBuilder(this);
    }

    @JsonIgnore
    public RemoteReadSpecBuilder toBuilder() {
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
        if (!(o instanceof RemoteReadSpec)) {
            return false;
        }
        RemoteReadSpec other = (RemoteReadSpec) o;
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
        Object this$filterExternalLabels = this.getFilterExternalLabels();
        Object other$filterExternalLabels = other.getFilterExternalLabels();
        if (this$filterExternalLabels == null ? other$filterExternalLabels != null : !this$filterExternalLabels.equals(other$filterExternalLabels)) {
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
        Object this$readRecent = this.getReadRecent();
        Object other$readRecent = other.getReadRecent();
        if (this$readRecent == null ? other$readRecent != null : !this$readRecent.equals(other$readRecent)) {
            return false;
        }
        Object this$remoteTimeout = this.getRemoteTimeout();
        Object other$remoteTimeout = other.getRemoteTimeout();
        if (this$remoteTimeout == null ? other$remoteTimeout != null : !this$remoteTimeout.equals(other$remoteTimeout)) {
            return false;
        }
        Object this$requiredMatchers = this.getRequiredMatchers();
        Object other$requiredMatchers = other.getRequiredMatchers();
        if (this$requiredMatchers == null ? other$requiredMatchers != null : !this$requiredMatchers.equals(other$requiredMatchers)) {
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
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof RemoteReadSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $authorization = this.getAuthorization();
        result = result * prime + ($authorization == null ? 43 : $authorization.hashCode());
        Object $basicAuth = this.getBasicAuth();
        result = result * prime + ($basicAuth == null ? 43 : $basicAuth.hashCode());
        Object $bearerToken = this.getBearerToken();
        result = result * prime + ($bearerToken == null ? 43 : $bearerToken.hashCode());
        Object $bearerTokenFile = this.getBearerTokenFile();
        result = result * prime + ($bearerTokenFile == null ? 43 : $bearerTokenFile.hashCode());
        Object $filterExternalLabels = this.getFilterExternalLabels();
        result = result * prime + ($filterExternalLabels == null ? 43 : $filterExternalLabels.hashCode());
        Object $followRedirects = this.getFollowRedirects();
        result = result * prime + ($followRedirects == null ? 43 : $followRedirects.hashCode());
        Object $headers = this.getHeaders();
        result = result * prime + ($headers == null ? 43 : $headers.hashCode());
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
        Object $readRecent = this.getReadRecent();
        result = result * prime + ($readRecent == null ? 43 : $readRecent.hashCode());
        Object $remoteTimeout = this.getRemoteTimeout();
        result = result * prime + ($remoteTimeout == null ? 43 : $remoteTimeout.hashCode());
        Object $requiredMatchers = this.getRequiredMatchers();
        result = result * prime + ($requiredMatchers == null ? 43 : $requiredMatchers.hashCode());
        Object $tlsConfig = this.getTlsConfig();
        result = result * prime + ($tlsConfig == null ? 43 : $tlsConfig.hashCode());
        Object $url = this.getUrl();
        result = result * prime + ($url == null ? 43 : $url.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "RemoteReadSpec(" + "authorization=" + this.getAuthorization() + ", basicAuth=" + this.getBasicAuth() + ", bearerToken=" + this.getBearerToken() + ", bearerTokenFile=" + this.getBearerTokenFile() + ", filterExternalLabels=" + this.getFilterExternalLabels() + ", followRedirects=" + this.getFollowRedirects() + ", headers=" + this.getHeaders() + ", name=" + this.getName() + ", noProxy=" + this.getNoProxy() + ", oauth2=" + this.getOauth2() + ", proxyConnectHeader=" + this.getProxyConnectHeader() + ", proxyFromEnvironment=" + this.getProxyFromEnvironment() + ", proxyUrl=" + this.getProxyUrl() + ", readRecent=" + this.getReadRecent() + ", remoteTimeout=" + this.getRemoteTimeout() + ", requiredMatchers=" + this.getRequiredMatchers() + ", tlsConfig=" + this.getTlsConfig() + ", url=" + this.getUrl() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
