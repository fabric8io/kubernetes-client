
package io.fabric8.openshift.api.model.monitoring.v1alpha1;

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
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.SecretKeySelector;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.openshift.api.model.monitoring.v1.BasicAuth;
import io.fabric8.openshift.api.model.monitoring.v1.OAuth2;
import io.fabric8.openshift.api.model.monitoring.v1.SafeAuthorization;
import io.fabric8.openshift.api.model.monitoring.v1.SafeTLSConfig;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * AzureSDConfig allow retrieving scrape targets from Azure VMs. See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#azure_sd_config
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "authenticationMethod",
    "authorization",
    "basicAuth",
    "clientID",
    "clientSecret",
    "enableHTTP2",
    "environment",
    "followRedirects",
    "noProxy",
    "oauth2",
    "port",
    "proxyConnectHeader",
    "proxyFromEnvironment",
    "proxyUrl",
    "refreshInterval",
    "resourceGroup",
    "subscriptionID",
    "tenantID",
    "tlsConfig"
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
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class AzureSDConfig implements Editable<AzureSDConfigBuilder>, KubernetesResource
{

    @JsonProperty("authenticationMethod")
    private String authenticationMethod;
    @JsonProperty("authorization")
    private SafeAuthorization authorization;
    @JsonProperty("basicAuth")
    private BasicAuth basicAuth;
    @JsonProperty("clientID")
    private String clientID;
    @JsonProperty("clientSecret")
    private SecretKeySelector clientSecret;
    @JsonProperty("enableHTTP2")
    private Boolean enableHTTP2;
    @JsonProperty("environment")
    private String environment;
    @JsonProperty("followRedirects")
    private Boolean followRedirects;
    @JsonProperty("noProxy")
    private String noProxy;
    @JsonProperty("oauth2")
    private OAuth2 oauth2;
    @JsonProperty("port")
    private Integer port;
    @JsonProperty("proxyConnectHeader")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, List<SecretKeySelector>> proxyConnectHeader = new LinkedHashMap<>();
    @JsonProperty("proxyFromEnvironment")
    private Boolean proxyFromEnvironment;
    @JsonProperty("proxyUrl")
    private String proxyUrl;
    @JsonProperty("refreshInterval")
    private String refreshInterval;
    @JsonProperty("resourceGroup")
    private String resourceGroup;
    @JsonProperty("subscriptionID")
    private String subscriptionID;
    @JsonProperty("tenantID")
    private String tenantID;
    @JsonProperty("tlsConfig")
    private SafeTLSConfig tlsConfig;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AzureSDConfig() {
    }

    public AzureSDConfig(String authenticationMethod, SafeAuthorization authorization, BasicAuth basicAuth, String clientID, SecretKeySelector clientSecret, Boolean enableHTTP2, String environment, Boolean followRedirects, String noProxy, OAuth2 oauth2, Integer port, Map<String, List<SecretKeySelector>> proxyConnectHeader, Boolean proxyFromEnvironment, String proxyUrl, String refreshInterval, String resourceGroup, String subscriptionID, String tenantID, SafeTLSConfig tlsConfig) {
        super();
        this.authenticationMethod = authenticationMethod;
        this.authorization = authorization;
        this.basicAuth = basicAuth;
        this.clientID = clientID;
        this.clientSecret = clientSecret;
        this.enableHTTP2 = enableHTTP2;
        this.environment = environment;
        this.followRedirects = followRedirects;
        this.noProxy = noProxy;
        this.oauth2 = oauth2;
        this.port = port;
        this.proxyConnectHeader = proxyConnectHeader;
        this.proxyFromEnvironment = proxyFromEnvironment;
        this.proxyUrl = proxyUrl;
        this.refreshInterval = refreshInterval;
        this.resourceGroup = resourceGroup;
        this.subscriptionID = subscriptionID;
        this.tenantID = tenantID;
        this.tlsConfig = tlsConfig;
    }

    /**
     * authenticationMethod defines the authentication method, either `OAuth` or `ManagedIdentity` or `SDK`. See https://docs.microsoft.com/en-us/azure/active-directory/managed-identities-azure-resources/overview SDK authentication method uses environment variables by default. See https://learn.microsoft.com/en-us/azure/developer/go/azure-sdk-authentication
     */
    @JsonProperty("authenticationMethod")
    public String getAuthenticationMethod() {
        return authenticationMethod;
    }

    /**
     * authenticationMethod defines the authentication method, either `OAuth` or `ManagedIdentity` or `SDK`. See https://docs.microsoft.com/en-us/azure/active-directory/managed-identities-azure-resources/overview SDK authentication method uses environment variables by default. See https://learn.microsoft.com/en-us/azure/developer/go/azure-sdk-authentication
     */
    @JsonProperty("authenticationMethod")
    public void setAuthenticationMethod(String authenticationMethod) {
        this.authenticationMethod = authenticationMethod;
    }

    /**
     * AzureSDConfig allow retrieving scrape targets from Azure VMs. See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#azure_sd_config
     */
    @JsonProperty("authorization")
    public SafeAuthorization getAuthorization() {
        return authorization;
    }

    /**
     * AzureSDConfig allow retrieving scrape targets from Azure VMs. See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#azure_sd_config
     */
    @JsonProperty("authorization")
    public void setAuthorization(SafeAuthorization authorization) {
        this.authorization = authorization;
    }

    /**
     * AzureSDConfig allow retrieving scrape targets from Azure VMs. See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#azure_sd_config
     */
    @JsonProperty("basicAuth")
    public BasicAuth getBasicAuth() {
        return basicAuth;
    }

    /**
     * AzureSDConfig allow retrieving scrape targets from Azure VMs. See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#azure_sd_config
     */
    @JsonProperty("basicAuth")
    public void setBasicAuth(BasicAuth basicAuth) {
        this.basicAuth = basicAuth;
    }

    /**
     * clientID defines client ID. Only required with the OAuth authentication method.
     */
    @JsonProperty("clientID")
    public String getClientID() {
        return clientID;
    }

    /**
     * clientID defines client ID. Only required with the OAuth authentication method.
     */
    @JsonProperty("clientID")
    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    /**
     * AzureSDConfig allow retrieving scrape targets from Azure VMs. See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#azure_sd_config
     */
    @JsonProperty("clientSecret")
    public SecretKeySelector getClientSecret() {
        return clientSecret;
    }

    /**
     * AzureSDConfig allow retrieving scrape targets from Azure VMs. See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#azure_sd_config
     */
    @JsonProperty("clientSecret")
    public void setClientSecret(SecretKeySelector clientSecret) {
        this.clientSecret = clientSecret;
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
     * environment defines the Azure environment.
     */
    @JsonProperty("environment")
    public String getEnvironment() {
        return environment;
    }

    /**
     * environment defines the Azure environment.
     */
    @JsonProperty("environment")
    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    /**
     * followRedirects defines whether HTTP requests follow HTTP 3xx redirects.
     */
    @JsonProperty("followRedirects")
    public Boolean getFollowRedirects() {
        return followRedirects;
    }

    /**
     * followRedirects defines whether HTTP requests follow HTTP 3xx redirects.
     */
    @JsonProperty("followRedirects")
    public void setFollowRedirects(Boolean followRedirects) {
        this.followRedirects = followRedirects;
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
     * AzureSDConfig allow retrieving scrape targets from Azure VMs. See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#azure_sd_config
     */
    @JsonProperty("oauth2")
    public OAuth2 getOauth2() {
        return oauth2;
    }

    /**
     * AzureSDConfig allow retrieving scrape targets from Azure VMs. See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#azure_sd_config
     */
    @JsonProperty("oauth2")
    public void setOauth2(OAuth2 oauth2) {
        this.oauth2 = oauth2;
    }

    /**
     * port defines the port to scrape metrics from. If using the public IP address, this must instead be specified in the relabeling rule.
     */
    @JsonProperty("port")
    public Integer getPort() {
        return port;
    }

    /**
     * port defines the port to scrape metrics from. If using the public IP address, this must instead be specified in the relabeling rule.
     */
    @JsonProperty("port")
    public void setPort(Integer port) {
        this.port = port;
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
     * refreshInterval defines the time after which the provided names are refreshed. If not set, Prometheus uses its default value.
     */
    @JsonProperty("refreshInterval")
    public String getRefreshInterval() {
        return refreshInterval;
    }

    /**
     * refreshInterval defines the time after which the provided names are refreshed. If not set, Prometheus uses its default value.
     */
    @JsonProperty("refreshInterval")
    public void setRefreshInterval(String refreshInterval) {
        this.refreshInterval = refreshInterval;
    }

    /**
     * resourceGroup defines resource group name. Limits discovery to this resource group. Requires  Prometheus v2.35.0 and above
     */
    @JsonProperty("resourceGroup")
    public String getResourceGroup() {
        return resourceGroup;
    }

    /**
     * resourceGroup defines resource group name. Limits discovery to this resource group. Requires  Prometheus v2.35.0 and above
     */
    @JsonProperty("resourceGroup")
    public void setResourceGroup(String resourceGroup) {
        this.resourceGroup = resourceGroup;
    }

    /**
     * subscriptionID defines subscription ID. Always required.
     */
    @JsonProperty("subscriptionID")
    public String getSubscriptionID() {
        return subscriptionID;
    }

    /**
     * subscriptionID defines subscription ID. Always required.
     */
    @JsonProperty("subscriptionID")
    public void setSubscriptionID(String subscriptionID) {
        this.subscriptionID = subscriptionID;
    }

    /**
     * tenantID defines tenant ID. Only required with the OAuth authentication method.
     */
    @JsonProperty("tenantID")
    public String getTenantID() {
        return tenantID;
    }

    /**
     * tenantID defines tenant ID. Only required with the OAuth authentication method.
     */
    @JsonProperty("tenantID")
    public void setTenantID(String tenantID) {
        this.tenantID = tenantID;
    }

    /**
     * AzureSDConfig allow retrieving scrape targets from Azure VMs. See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#azure_sd_config
     */
    @JsonProperty("tlsConfig")
    public SafeTLSConfig getTlsConfig() {
        return tlsConfig;
    }

    /**
     * AzureSDConfig allow retrieving scrape targets from Azure VMs. See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#azure_sd_config
     */
    @JsonProperty("tlsConfig")
    public void setTlsConfig(SafeTLSConfig tlsConfig) {
        this.tlsConfig = tlsConfig;
    }

    @JsonIgnore
    public AzureSDConfigBuilder edit() {
        return new AzureSDConfigBuilder(this);
    }

    @JsonIgnore
    public AzureSDConfigBuilder toBuilder() {
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
        if (!(o instanceof AzureSDConfig)) {
            return false;
        }
        AzureSDConfig other = (AzureSDConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$authenticationMethod = this.getAuthenticationMethod();
        Object other$authenticationMethod = other.getAuthenticationMethod();
        if (this$authenticationMethod == null ? other$authenticationMethod != null : !this$authenticationMethod.equals(other$authenticationMethod)) {
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
        Object this$clientID = this.getClientID();
        Object other$clientID = other.getClientID();
        if (this$clientID == null ? other$clientID != null : !this$clientID.equals(other$clientID)) {
            return false;
        }
        Object this$clientSecret = this.getClientSecret();
        Object other$clientSecret = other.getClientSecret();
        if (this$clientSecret == null ? other$clientSecret != null : !this$clientSecret.equals(other$clientSecret)) {
            return false;
        }
        Object this$enableHTTP2 = this.getEnableHTTP2();
        Object other$enableHTTP2 = other.getEnableHTTP2();
        if (this$enableHTTP2 == null ? other$enableHTTP2 != null : !this$enableHTTP2.equals(other$enableHTTP2)) {
            return false;
        }
        Object this$environment = this.getEnvironment();
        Object other$environment = other.getEnvironment();
        if (this$environment == null ? other$environment != null : !this$environment.equals(other$environment)) {
            return false;
        }
        Object this$followRedirects = this.getFollowRedirects();
        Object other$followRedirects = other.getFollowRedirects();
        if (this$followRedirects == null ? other$followRedirects != null : !this$followRedirects.equals(other$followRedirects)) {
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
        Object this$port = this.getPort();
        Object other$port = other.getPort();
        if (this$port == null ? other$port != null : !this$port.equals(other$port)) {
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
        Object this$refreshInterval = this.getRefreshInterval();
        Object other$refreshInterval = other.getRefreshInterval();
        if (this$refreshInterval == null ? other$refreshInterval != null : !this$refreshInterval.equals(other$refreshInterval)) {
            return false;
        }
        Object this$resourceGroup = this.getResourceGroup();
        Object other$resourceGroup = other.getResourceGroup();
        if (this$resourceGroup == null ? other$resourceGroup != null : !this$resourceGroup.equals(other$resourceGroup)) {
            return false;
        }
        Object this$subscriptionID = this.getSubscriptionID();
        Object other$subscriptionID = other.getSubscriptionID();
        if (this$subscriptionID == null ? other$subscriptionID != null : !this$subscriptionID.equals(other$subscriptionID)) {
            return false;
        }
        Object this$tenantID = this.getTenantID();
        Object other$tenantID = other.getTenantID();
        if (this$tenantID == null ? other$tenantID != null : !this$tenantID.equals(other$tenantID)) {
            return false;
        }
        Object this$tlsConfig = this.getTlsConfig();
        Object other$tlsConfig = other.getTlsConfig();
        if (this$tlsConfig == null ? other$tlsConfig != null : !this$tlsConfig.equals(other$tlsConfig)) {
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
        return other instanceof AzureSDConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $authenticationMethod = this.getAuthenticationMethod();
        result = result * prime + ($authenticationMethod == null ? 43 : $authenticationMethod.hashCode());
        Object $authorization = this.getAuthorization();
        result = result * prime + ($authorization == null ? 43 : $authorization.hashCode());
        Object $basicAuth = this.getBasicAuth();
        result = result * prime + ($basicAuth == null ? 43 : $basicAuth.hashCode());
        Object $clientID = this.getClientID();
        result = result * prime + ($clientID == null ? 43 : $clientID.hashCode());
        Object $clientSecret = this.getClientSecret();
        result = result * prime + ($clientSecret == null ? 43 : $clientSecret.hashCode());
        Object $enableHTTP2 = this.getEnableHTTP2();
        result = result * prime + ($enableHTTP2 == null ? 43 : $enableHTTP2.hashCode());
        Object $environment = this.getEnvironment();
        result = result * prime + ($environment == null ? 43 : $environment.hashCode());
        Object $followRedirects = this.getFollowRedirects();
        result = result * prime + ($followRedirects == null ? 43 : $followRedirects.hashCode());
        Object $noProxy = this.getNoProxy();
        result = result * prime + ($noProxy == null ? 43 : $noProxy.hashCode());
        Object $oauth2 = this.getOauth2();
        result = result * prime + ($oauth2 == null ? 43 : $oauth2.hashCode());
        Object $port = this.getPort();
        result = result * prime + ($port == null ? 43 : $port.hashCode());
        Object $proxyConnectHeader = this.getProxyConnectHeader();
        result = result * prime + ($proxyConnectHeader == null ? 43 : $proxyConnectHeader.hashCode());
        Object $proxyFromEnvironment = this.getProxyFromEnvironment();
        result = result * prime + ($proxyFromEnvironment == null ? 43 : $proxyFromEnvironment.hashCode());
        Object $proxyUrl = this.getProxyUrl();
        result = result * prime + ($proxyUrl == null ? 43 : $proxyUrl.hashCode());
        Object $refreshInterval = this.getRefreshInterval();
        result = result * prime + ($refreshInterval == null ? 43 : $refreshInterval.hashCode());
        Object $resourceGroup = this.getResourceGroup();
        result = result * prime + ($resourceGroup == null ? 43 : $resourceGroup.hashCode());
        Object $subscriptionID = this.getSubscriptionID();
        result = result * prime + ($subscriptionID == null ? 43 : $subscriptionID.hashCode());
        Object $tenantID = this.getTenantID();
        result = result * prime + ($tenantID == null ? 43 : $tenantID.hashCode());
        Object $tlsConfig = this.getTlsConfig();
        result = result * prime + ($tlsConfig == null ? 43 : $tlsConfig.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AzureSDConfig(" + "authenticationMethod=" + this.getAuthenticationMethod() + ", authorization=" + this.getAuthorization() + ", basicAuth=" + this.getBasicAuth() + ", clientID=" + this.getClientID() + ", clientSecret=" + this.getClientSecret() + ", enableHTTP2=" + this.getEnableHTTP2() + ", environment=" + this.getEnvironment() + ", followRedirects=" + this.getFollowRedirects() + ", noProxy=" + this.getNoProxy() + ", oauth2=" + this.getOauth2() + ", port=" + this.getPort() + ", proxyConnectHeader=" + this.getProxyConnectHeader() + ", proxyFromEnvironment=" + this.getProxyFromEnvironment() + ", proxyUrl=" + this.getProxyUrl() + ", refreshInterval=" + this.getRefreshInterval() + ", resourceGroup=" + this.getResourceGroup() + ", subscriptionID=" + this.getSubscriptionID() + ", tenantID=" + this.getTenantID() + ", tlsConfig=" + this.getTlsConfig() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
