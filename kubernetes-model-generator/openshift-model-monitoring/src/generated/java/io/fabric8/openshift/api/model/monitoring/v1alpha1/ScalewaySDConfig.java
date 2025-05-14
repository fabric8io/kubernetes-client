
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * ScalewaySDConfig configurations allow retrieving scrape targets from Scaleway instances and baremetal services. See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#scaleway_sd_config
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
     * Access key to use. https://console.scaleway.com/project/credentials
     */
    @JsonProperty("accessKey")
    public String getAccessKey() {
        return accessKey;
    }

    /**
     * Access key to use. https://console.scaleway.com/project/credentials
     */
    @JsonProperty("accessKey")
    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    /**
     * API URL to use when doing the server listing requests.
     */
    @JsonProperty("apiURL")
    public String getApiURL() {
        return apiURL;
    }

    /**
     * API URL to use when doing the server listing requests.
     */
    @JsonProperty("apiURL")
    public void setApiURL(String apiURL) {
        this.apiURL = apiURL;
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
     * Configure whether HTTP requests follow HTTP 3xx redirects.
     */
    @JsonProperty("followRedirects")
    public Boolean getFollowRedirects() {
        return followRedirects;
    }

    /**
     * Configure whether HTTP requests follow HTTP 3xx redirects.
     */
    @JsonProperty("followRedirects")
    public void setFollowRedirects(Boolean followRedirects) {
        this.followRedirects = followRedirects;
    }

    /**
     * NameFilter specify a name filter (works as a LIKE) to apply on the server listing request.
     */
    @JsonProperty("nameFilter")
    public String getNameFilter() {
        return nameFilter;
    }

    /**
     * NameFilter specify a name filter (works as a LIKE) to apply on the server listing request.
     */
    @JsonProperty("nameFilter")
    public void setNameFilter(String nameFilter) {
        this.nameFilter = nameFilter;
    }

    /**
     * `noProxy` is a comma-separated string that can contain IPs, CIDR notation, domain names that should be excluded from proxying. IP and domain names can contain port numbers.<br><p> <br><p> It requires Prometheus &gt;= v2.43.0 or Alertmanager &gt;= 0.25.0.
     */
    @JsonProperty("noProxy")
    public String getNoProxy() {
        return noProxy;
    }

    /**
     * `noProxy` is a comma-separated string that can contain IPs, CIDR notation, domain names that should be excluded from proxying. IP and domain names can contain port numbers.<br><p> <br><p> It requires Prometheus &gt;= v2.43.0 or Alertmanager &gt;= 0.25.0.
     */
    @JsonProperty("noProxy")
    public void setNoProxy(String noProxy) {
        this.noProxy = noProxy;
    }

    /**
     * The port to scrape metrics from.
     */
    @JsonProperty("port")
    public Integer getPort() {
        return port;
    }

    /**
     * The port to scrape metrics from.
     */
    @JsonProperty("port")
    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     * Project ID of the targets.
     */
    @JsonProperty("projectID")
    public String getProjectID() {
        return projectID;
    }

    /**
     * Project ID of the targets.
     */
    @JsonProperty("projectID")
    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }

    /**
     * ProxyConnectHeader optionally specifies headers to send to proxies during CONNECT requests.<br><p> <br><p> It requires Prometheus &gt;= v2.43.0 or Alertmanager &gt;= 0.25.0.
     */
    @JsonProperty("proxyConnectHeader")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, List<SecretKeySelector>> getProxyConnectHeader() {
        return proxyConnectHeader;
    }

    /**
     * ProxyConnectHeader optionally specifies headers to send to proxies during CONNECT requests.<br><p> <br><p> It requires Prometheus &gt;= v2.43.0 or Alertmanager &gt;= 0.25.0.
     */
    @JsonProperty("proxyConnectHeader")
    public void setProxyConnectHeader(Map<String, List<SecretKeySelector>> proxyConnectHeader) {
        this.proxyConnectHeader = proxyConnectHeader;
    }

    /**
     * Whether to use the proxy configuration defined by environment variables (HTTP_PROXY, HTTPS_PROXY, and NO_PROXY).<br><p> <br><p> It requires Prometheus &gt;= v2.43.0 or Alertmanager &gt;= 0.25.0.
     */
    @JsonProperty("proxyFromEnvironment")
    public Boolean getProxyFromEnvironment() {
        return proxyFromEnvironment;
    }

    /**
     * Whether to use the proxy configuration defined by environment variables (HTTP_PROXY, HTTPS_PROXY, and NO_PROXY).<br><p> <br><p> It requires Prometheus &gt;= v2.43.0 or Alertmanager &gt;= 0.25.0.
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
     * Refresh interval to re-read the list of instances.
     */
    @JsonProperty("refreshInterval")
    public String getRefreshInterval() {
        return refreshInterval;
    }

    /**
     * Refresh interval to re-read the list of instances.
     */
    @JsonProperty("refreshInterval")
    public void setRefreshInterval(String refreshInterval) {
        this.refreshInterval = refreshInterval;
    }

    /**
     * Service of the targets to retrieve. Must be `Instance` or `Baremetal`.
     */
    @JsonProperty("role")
    public String getRole() {
        return role;
    }

    /**
     * Service of the targets to retrieve. Must be `Instance` or `Baremetal`.
     */
    @JsonProperty("role")
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * ScalewaySDConfig configurations allow retrieving scrape targets from Scaleway instances and baremetal services. See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#scaleway_sd_config
     */
    @JsonProperty("secretKey")
    public SecretKeySelector getSecretKey() {
        return secretKey;
    }

    /**
     * ScalewaySDConfig configurations allow retrieving scrape targets from Scaleway instances and baremetal services. See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#scaleway_sd_config
     */
    @JsonProperty("secretKey")
    public void setSecretKey(SecretKeySelector secretKey) {
        this.secretKey = secretKey;
    }

    /**
     * TagsFilter specify a tag filter (a server needs to have all defined tags to be listed) to apply on the server listing request.
     */
    @JsonProperty("tagsFilter")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getTagsFilter() {
        return tagsFilter;
    }

    /**
     * TagsFilter specify a tag filter (a server needs to have all defined tags to be listed) to apply on the server listing request.
     */
    @JsonProperty("tagsFilter")
    public void setTagsFilter(List<String> tagsFilter) {
        this.tagsFilter = tagsFilter;
    }

    /**
     * ScalewaySDConfig configurations allow retrieving scrape targets from Scaleway instances and baremetal services. See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#scaleway_sd_config
     */
    @JsonProperty("tlsConfig")
    public SafeTLSConfig getTlsConfig() {
        return tlsConfig;
    }

    /**
     * ScalewaySDConfig configurations allow retrieving scrape targets from Scaleway instances and baremetal services. See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#scaleway_sd_config
     */
    @JsonProperty("tlsConfig")
    public void setTlsConfig(SafeTLSConfig tlsConfig) {
        this.tlsConfig = tlsConfig;
    }

    /**
     * Zone is the availability zone of your targets (e.g. fr-par-1).
     */
    @JsonProperty("zone")
    public String getZone() {
        return zone;
    }

    /**
     * Zone is the availability zone of your targets (e.g. fr-par-1).
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

}
