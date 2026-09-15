
package io.fabric8.openshift.api.model.monitoring.v1alpha1;

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
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.SecretKeySelector;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.openshift.api.model.monitoring.v1.SafeTLSConfig;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * ScalewaySDConfig configurations allow retrieving scrape targets from Scaleway instances and baremetal services. See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#scaleway_sd_config<br><p> <br><p> Note: The `_file` variants of credential fields (e.g. `secret_key_file`) from the Prometheus configuration are not supported. Use Kubernetes secrets via `secretKey` instead.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "accessKey",
    "apiURL",
    "enableHTTP2",
    "followRedirects",
    "nameFilter",
    "noProxy",
    "port",
    "projectID",
    "proxyConnectHeader",
    "proxyFromEnvironment",
    "proxyUrl",
    "refreshInterval",
    "role",
    "secretKey",
    "tagsFilter",
    "tlsConfig",
    "zone"
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
public class ScalewaySDConfig implements Editable<ScalewaySDConfigBuilder>, KubernetesResource
{

    @JsonProperty("accessKey")
    private String accessKey;
    @JsonProperty("apiURL")
    private String apiURL;
    @JsonProperty("enableHTTP2")
    private Boolean enableHTTP2;
    @JsonProperty("followRedirects")
    private Boolean followRedirects;
    @JsonProperty("nameFilter")
    private String nameFilter;
    @JsonProperty("noProxy")
    private String noProxy;
    @JsonProperty("port")
    private Integer port;
    @JsonProperty("projectID")
    private String projectID;
    @JsonProperty("proxyConnectHeader")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, List<SecretKeySelector>> proxyConnectHeader = new LinkedHashMap<>();
    @JsonProperty("proxyFromEnvironment")
    private Boolean proxyFromEnvironment;
    @JsonProperty("proxyUrl")
    private String proxyUrl;
    @JsonProperty("refreshInterval")
    private String refreshInterval;
    @JsonProperty("role")
    private String role;
    @JsonProperty("secretKey")
    private SecretKeySelector secretKey;
    @JsonProperty("tagsFilter")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> tagsFilter = new ArrayList<>();
    @JsonProperty("tlsConfig")
    private SafeTLSConfig tlsConfig;
    @JsonProperty("zone")
    private String zone;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ScalewaySDConfig() {
    }

    public ScalewaySDConfig(String accessKey, String apiURL, Boolean enableHTTP2, Boolean followRedirects, String nameFilter, String noProxy, Integer port, String projectID, Map<String, List<SecretKeySelector>> proxyConnectHeader, Boolean proxyFromEnvironment, String proxyUrl, String refreshInterval, String role, SecretKeySelector secretKey, List<String> tagsFilter, SafeTLSConfig tlsConfig, String zone) {
        super();
        this.accessKey = accessKey;
        this.apiURL = apiURL;
        this.enableHTTP2 = enableHTTP2;
        this.followRedirects = followRedirects;
        this.nameFilter = nameFilter;
        this.noProxy = noProxy;
        this.port = port;
        this.projectID = projectID;
        this.proxyConnectHeader = proxyConnectHeader;
        this.proxyFromEnvironment = proxyFromEnvironment;
        this.proxyUrl = proxyUrl;
        this.refreshInterval = refreshInterval;
        this.role = role;
        this.secretKey = secretKey;
        this.tagsFilter = tagsFilter;
        this.tlsConfig = tlsConfig;
        this.zone = zone;
    }

    /**
     * accessKey defines the access key to use. https://console.scaleway.com/project/credentials
     */
    @JsonProperty("accessKey")
    public String getAccessKey() {
        return accessKey;
    }

    /**
     * accessKey defines the access key to use. https://console.scaleway.com/project/credentials
     */
    @JsonProperty("accessKey")
    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    /**
     * apiURL defines the API URL to use when doing the server listing requests.
     */
    @JsonProperty("apiURL")
    public String getApiURL() {
        return apiURL;
    }

    /**
     * apiURL defines the API URL to use when doing the server listing requests.
     */
    @JsonProperty("apiURL")
    public void setApiURL(String apiURL) {
        this.apiURL = apiURL;
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
     * nameFilter defines a name filter (works as a LIKE) to apply on the server listing request.
     */
    @JsonProperty("nameFilter")
    public String getNameFilter() {
        return nameFilter;
    }

    /**
     * nameFilter defines a name filter (works as a LIKE) to apply on the server listing request.
     */
    @JsonProperty("nameFilter")
    public void setNameFilter(String nameFilter) {
        this.nameFilter = nameFilter;
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
     * port defines the port to scrape metrics from. If using the public IP address, this must
     */
    @JsonProperty("port")
    public Integer getPort() {
        return port;
    }

    /**
     * port defines the port to scrape metrics from. If using the public IP address, this must
     */
    @JsonProperty("port")
    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     * projectID defines the Project ID of the targets.
     */
    @JsonProperty("projectID")
    public String getProjectID() {
        return projectID;
    }

    /**
     * projectID defines the Project ID of the targets.
     */
    @JsonProperty("projectID")
    public void setProjectID(String projectID) {
        this.projectID = projectID;
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
     * role defines the service of the targets to retrieve. Must be `Instance` or `Baremetal`.
     */
    @JsonProperty("role")
    public String getRole() {
        return role;
    }

    /**
     * role defines the service of the targets to retrieve. Must be `Instance` or `Baremetal`.
     */
    @JsonProperty("role")
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * ScalewaySDConfig configurations allow retrieving scrape targets from Scaleway instances and baremetal services. See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#scaleway_sd_config<br><p> <br><p> Note: The `_file` variants of credential fields (e.g. `secret_key_file`) from the Prometheus configuration are not supported. Use Kubernetes secrets via `secretKey` instead.
     */
    @JsonProperty("secretKey")
    public SecretKeySelector getSecretKey() {
        return secretKey;
    }

    /**
     * ScalewaySDConfig configurations allow retrieving scrape targets from Scaleway instances and baremetal services. See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#scaleway_sd_config<br><p> <br><p> Note: The `_file` variants of credential fields (e.g. `secret_key_file`) from the Prometheus configuration are not supported. Use Kubernetes secrets via `secretKey` instead.
     */
    @JsonProperty("secretKey")
    public void setSecretKey(SecretKeySelector secretKey) {
        this.secretKey = secretKey;
    }

    /**
     * tagsFilter defines a tag filter (a server needs to have all defined tags to be listed) to apply on the server listing request.
     */
    @JsonProperty("tagsFilter")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getTagsFilter() {
        return tagsFilter;
    }

    /**
     * tagsFilter defines a tag filter (a server needs to have all defined tags to be listed) to apply on the server listing request.
     */
    @JsonProperty("tagsFilter")
    public void setTagsFilter(List<String> tagsFilter) {
        this.tagsFilter = tagsFilter;
    }

    /**
     * ScalewaySDConfig configurations allow retrieving scrape targets from Scaleway instances and baremetal services. See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#scaleway_sd_config<br><p> <br><p> Note: The `_file` variants of credential fields (e.g. `secret_key_file`) from the Prometheus configuration are not supported. Use Kubernetes secrets via `secretKey` instead.
     */
    @JsonProperty("tlsConfig")
    public SafeTLSConfig getTlsConfig() {
        return tlsConfig;
    }

    /**
     * ScalewaySDConfig configurations allow retrieving scrape targets from Scaleway instances and baremetal services. See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#scaleway_sd_config<br><p> <br><p> Note: The `_file` variants of credential fields (e.g. `secret_key_file`) from the Prometheus configuration are not supported. Use Kubernetes secrets via `secretKey` instead.
     */
    @JsonProperty("tlsConfig")
    public void setTlsConfig(SafeTLSConfig tlsConfig) {
        this.tlsConfig = tlsConfig;
    }

    /**
     * zone defines the availability zone of your targets (e.g. fr-par-1).
     */
    @JsonProperty("zone")
    public String getZone() {
        return zone;
    }

    /**
     * zone defines the availability zone of your targets (e.g. fr-par-1).
     */
    @JsonProperty("zone")
    public void setZone(String zone) {
        this.zone = zone;
    }

    @JsonIgnore
    public ScalewaySDConfigBuilder edit() {
        return new ScalewaySDConfigBuilder(this);
    }

    @JsonIgnore
    public ScalewaySDConfigBuilder toBuilder() {
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
        if (!(o instanceof ScalewaySDConfig)) {
            return false;
        }
        ScalewaySDConfig other = (ScalewaySDConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$accessKey = this.getAccessKey();
        Object other$accessKey = other.getAccessKey();
        if (this$accessKey == null ? other$accessKey != null : !this$accessKey.equals(other$accessKey)) {
            return false;
        }
        Object this$apiURL = this.getApiURL();
        Object other$apiURL = other.getApiURL();
        if (this$apiURL == null ? other$apiURL != null : !this$apiURL.equals(other$apiURL)) {
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
        Object this$nameFilter = this.getNameFilter();
        Object other$nameFilter = other.getNameFilter();
        if (this$nameFilter == null ? other$nameFilter != null : !this$nameFilter.equals(other$nameFilter)) {
            return false;
        }
        Object this$noProxy = this.getNoProxy();
        Object other$noProxy = other.getNoProxy();
        if (this$noProxy == null ? other$noProxy != null : !this$noProxy.equals(other$noProxy)) {
            return false;
        }
        Object this$port = this.getPort();
        Object other$port = other.getPort();
        if (this$port == null ? other$port != null : !this$port.equals(other$port)) {
            return false;
        }
        Object this$projectID = this.getProjectID();
        Object other$projectID = other.getProjectID();
        if (this$projectID == null ? other$projectID != null : !this$projectID.equals(other$projectID)) {
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
        Object this$role = this.getRole();
        Object other$role = other.getRole();
        if (this$role == null ? other$role != null : !this$role.equals(other$role)) {
            return false;
        }
        Object this$secretKey = this.getSecretKey();
        Object other$secretKey = other.getSecretKey();
        if (this$secretKey == null ? other$secretKey != null : !this$secretKey.equals(other$secretKey)) {
            return false;
        }
        Object this$tagsFilter = this.getTagsFilter();
        Object other$tagsFilter = other.getTagsFilter();
        if (this$tagsFilter == null ? other$tagsFilter != null : !this$tagsFilter.equals(other$tagsFilter)) {
            return false;
        }
        Object this$tlsConfig = this.getTlsConfig();
        Object other$tlsConfig = other.getTlsConfig();
        if (this$tlsConfig == null ? other$tlsConfig != null : !this$tlsConfig.equals(other$tlsConfig)) {
            return false;
        }
        Object this$zone = this.getZone();
        Object other$zone = other.getZone();
        if (this$zone == null ? other$zone != null : !this$zone.equals(other$zone)) {
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
        return other instanceof ScalewaySDConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $accessKey = this.getAccessKey();
        result = result * prime + ($accessKey == null ? 43 : $accessKey.hashCode());
        Object $apiURL = this.getApiURL();
        result = result * prime + ($apiURL == null ? 43 : $apiURL.hashCode());
        Object $enableHTTP2 = this.getEnableHTTP2();
        result = result * prime + ($enableHTTP2 == null ? 43 : $enableHTTP2.hashCode());
        Object $followRedirects = this.getFollowRedirects();
        result = result * prime + ($followRedirects == null ? 43 : $followRedirects.hashCode());
        Object $nameFilter = this.getNameFilter();
        result = result * prime + ($nameFilter == null ? 43 : $nameFilter.hashCode());
        Object $noProxy = this.getNoProxy();
        result = result * prime + ($noProxy == null ? 43 : $noProxy.hashCode());
        Object $port = this.getPort();
        result = result * prime + ($port == null ? 43 : $port.hashCode());
        Object $projectID = this.getProjectID();
        result = result * prime + ($projectID == null ? 43 : $projectID.hashCode());
        Object $proxyConnectHeader = this.getProxyConnectHeader();
        result = result * prime + ($proxyConnectHeader == null ? 43 : $proxyConnectHeader.hashCode());
        Object $proxyFromEnvironment = this.getProxyFromEnvironment();
        result = result * prime + ($proxyFromEnvironment == null ? 43 : $proxyFromEnvironment.hashCode());
        Object $proxyUrl = this.getProxyUrl();
        result = result * prime + ($proxyUrl == null ? 43 : $proxyUrl.hashCode());
        Object $refreshInterval = this.getRefreshInterval();
        result = result * prime + ($refreshInterval == null ? 43 : $refreshInterval.hashCode());
        Object $role = this.getRole();
        result = result * prime + ($role == null ? 43 : $role.hashCode());
        Object $secretKey = this.getSecretKey();
        result = result * prime + ($secretKey == null ? 43 : $secretKey.hashCode());
        Object $tagsFilter = this.getTagsFilter();
        result = result * prime + ($tagsFilter == null ? 43 : $tagsFilter.hashCode());
        Object $tlsConfig = this.getTlsConfig();
        result = result * prime + ($tlsConfig == null ? 43 : $tlsConfig.hashCode());
        Object $zone = this.getZone();
        result = result * prime + ($zone == null ? 43 : $zone.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ScalewaySDConfig(" + "accessKey=" + this.getAccessKey() + ", apiURL=" + this.getApiURL() + ", enableHTTP2=" + this.getEnableHTTP2() + ", followRedirects=" + this.getFollowRedirects() + ", nameFilter=" + this.getNameFilter() + ", noProxy=" + this.getNoProxy() + ", port=" + this.getPort() + ", projectID=" + this.getProjectID() + ", proxyConnectHeader=" + this.getProxyConnectHeader() + ", proxyFromEnvironment=" + this.getProxyFromEnvironment() + ", proxyUrl=" + this.getProxyUrl() + ", refreshInterval=" + this.getRefreshInterval() + ", role=" + this.getRole() + ", secretKey=" + this.getSecretKey() + ", tagsFilter=" + this.getTagsFilter() + ", tlsConfig=" + this.getTlsConfig() + ", zone=" + this.getZone() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
