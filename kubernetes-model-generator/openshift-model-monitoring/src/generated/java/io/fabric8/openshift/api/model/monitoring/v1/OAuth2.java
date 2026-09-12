
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
 * OAuth2 configures OAuth2 settings.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "clientId",
    "clientSecret",
    "endpointParams",
    "noProxy",
    "proxyConnectHeader",
    "proxyFromEnvironment",
    "proxyUrl",
    "scopes",
    "tlsConfig",
    "tokenUrl"
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
public class OAuth2 implements Editable<OAuth2Builder>, KubernetesResource
{

    @JsonProperty("clientId")
    private SecretOrConfigMap clientId;
    @JsonProperty("clientSecret")
    private SecretKeySelector clientSecret;
    @JsonProperty("endpointParams")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> endpointParams = new LinkedHashMap<>();
    @JsonProperty("noProxy")
    private String noProxy;
    @JsonProperty("proxyConnectHeader")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, List<SecretKeySelector>> proxyConnectHeader = new LinkedHashMap<>();
    @JsonProperty("proxyFromEnvironment")
    private Boolean proxyFromEnvironment;
    @JsonProperty("proxyUrl")
    private String proxyUrl;
    @JsonProperty("scopes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> scopes = new ArrayList<>();
    @JsonProperty("tlsConfig")
    private SafeTLSConfig tlsConfig;
    @JsonProperty("tokenUrl")
    private String tokenUrl;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public OAuth2() {
    }

    public OAuth2(SecretOrConfigMap clientId, SecretKeySelector clientSecret, Map<String, String> endpointParams, String noProxy, Map<String, List<SecretKeySelector>> proxyConnectHeader, Boolean proxyFromEnvironment, String proxyUrl, List<String> scopes, SafeTLSConfig tlsConfig, String tokenUrl) {
        super();
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.endpointParams = endpointParams;
        this.noProxy = noProxy;
        this.proxyConnectHeader = proxyConnectHeader;
        this.proxyFromEnvironment = proxyFromEnvironment;
        this.proxyUrl = proxyUrl;
        this.scopes = scopes;
        this.tlsConfig = tlsConfig;
        this.tokenUrl = tokenUrl;
    }

    /**
     * OAuth2 configures OAuth2 settings.
     */
    @JsonProperty("clientId")
    public SecretOrConfigMap getClientId() {
        return clientId;
    }

    /**
     * OAuth2 configures OAuth2 settings.
     */
    @JsonProperty("clientId")
    public void setClientId(SecretOrConfigMap clientId) {
        this.clientId = clientId;
    }

    /**
     * OAuth2 configures OAuth2 settings.
     */
    @JsonProperty("clientSecret")
    public SecretKeySelector getClientSecret() {
        return clientSecret;
    }

    /**
     * OAuth2 configures OAuth2 settings.
     */
    @JsonProperty("clientSecret")
    public void setClientSecret(SecretKeySelector clientSecret) {
        this.clientSecret = clientSecret;
    }

    /**
     * endpointParams configures the HTTP parameters to append to the token URL.
     */
    @JsonProperty("endpointParams")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getEndpointParams() {
        return endpointParams;
    }

    /**
     * endpointParams configures the HTTP parameters to append to the token URL.
     */
    @JsonProperty("endpointParams")
    public void setEndpointParams(Map<String, String> endpointParams) {
        this.endpointParams = endpointParams;
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
     * scopes defines the OAuth2 scopes used for the token request.
     */
    @JsonProperty("scopes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getScopes() {
        return scopes;
    }

    /**
     * scopes defines the OAuth2 scopes used for the token request.
     */
    @JsonProperty("scopes")
    public void setScopes(List<String> scopes) {
        this.scopes = scopes;
    }

    /**
     * OAuth2 configures OAuth2 settings.
     */
    @JsonProperty("tlsConfig")
    public SafeTLSConfig getTlsConfig() {
        return tlsConfig;
    }

    /**
     * OAuth2 configures OAuth2 settings.
     */
    @JsonProperty("tlsConfig")
    public void setTlsConfig(SafeTLSConfig tlsConfig) {
        this.tlsConfig = tlsConfig;
    }

    /**
     * tokenUrl defines the URL to fetch the token from.
     */
    @JsonProperty("tokenUrl")
    public String getTokenUrl() {
        return tokenUrl;
    }

    /**
     * tokenUrl defines the URL to fetch the token from.
     */
    @JsonProperty("tokenUrl")
    public void setTokenUrl(String tokenUrl) {
        this.tokenUrl = tokenUrl;
    }

    @JsonIgnore
    public OAuth2Builder edit() {
        return new OAuth2Builder(this);
    }

    @JsonIgnore
    public OAuth2Builder toBuilder() {
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
        if (!(o instanceof OAuth2)) {
            return false;
        }
        OAuth2 other = (OAuth2) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$clientId = this.getClientId();
        Object other$clientId = other.getClientId();
        if (this$clientId == null ? other$clientId != null : !this$clientId.equals(other$clientId)) {
            return false;
        }
        Object this$clientSecret = this.getClientSecret();
        Object other$clientSecret = other.getClientSecret();
        if (this$clientSecret == null ? other$clientSecret != null : !this$clientSecret.equals(other$clientSecret)) {
            return false;
        }
        Object this$endpointParams = this.getEndpointParams();
        Object other$endpointParams = other.getEndpointParams();
        if (this$endpointParams == null ? other$endpointParams != null : !this$endpointParams.equals(other$endpointParams)) {
            return false;
        }
        Object this$noProxy = this.getNoProxy();
        Object other$noProxy = other.getNoProxy();
        if (this$noProxy == null ? other$noProxy != null : !this$noProxy.equals(other$noProxy)) {
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
        Object this$scopes = this.getScopes();
        Object other$scopes = other.getScopes();
        if (this$scopes == null ? other$scopes != null : !this$scopes.equals(other$scopes)) {
            return false;
        }
        Object this$tlsConfig = this.getTlsConfig();
        Object other$tlsConfig = other.getTlsConfig();
        if (this$tlsConfig == null ? other$tlsConfig != null : !this$tlsConfig.equals(other$tlsConfig)) {
            return false;
        }
        Object this$tokenUrl = this.getTokenUrl();
        Object other$tokenUrl = other.getTokenUrl();
        if (this$tokenUrl == null ? other$tokenUrl != null : !this$tokenUrl.equals(other$tokenUrl)) {
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
        return other instanceof OAuth2;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $clientId = this.getClientId();
        result = result * prime + ($clientId == null ? 43 : $clientId.hashCode());
        Object $clientSecret = this.getClientSecret();
        result = result * prime + ($clientSecret == null ? 43 : $clientSecret.hashCode());
        Object $endpointParams = this.getEndpointParams();
        result = result * prime + ($endpointParams == null ? 43 : $endpointParams.hashCode());
        Object $noProxy = this.getNoProxy();
        result = result * prime + ($noProxy == null ? 43 : $noProxy.hashCode());
        Object $proxyConnectHeader = this.getProxyConnectHeader();
        result = result * prime + ($proxyConnectHeader == null ? 43 : $proxyConnectHeader.hashCode());
        Object $proxyFromEnvironment = this.getProxyFromEnvironment();
        result = result * prime + ($proxyFromEnvironment == null ? 43 : $proxyFromEnvironment.hashCode());
        Object $proxyUrl = this.getProxyUrl();
        result = result * prime + ($proxyUrl == null ? 43 : $proxyUrl.hashCode());
        Object $scopes = this.getScopes();
        result = result * prime + ($scopes == null ? 43 : $scopes.hashCode());
        Object $tlsConfig = this.getTlsConfig();
        result = result * prime + ($tlsConfig == null ? 43 : $tlsConfig.hashCode());
        Object $tokenUrl = this.getTokenUrl();
        result = result * prime + ($tokenUrl == null ? 43 : $tokenUrl.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "OAuth2(" + "clientId=" + this.getClientId() + ", clientSecret=" + this.getClientSecret() + ", endpointParams=" + this.getEndpointParams() + ", noProxy=" + this.getNoProxy() + ", proxyConnectHeader=" + this.getProxyConnectHeader() + ", proxyFromEnvironment=" + this.getProxyFromEnvironment() + ", proxyUrl=" + this.getProxyUrl() + ", scopes=" + this.getScopes() + ", tlsConfig=" + this.getTlsConfig() + ", tokenUrl=" + this.getTokenUrl() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
