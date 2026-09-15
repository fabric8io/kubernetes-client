
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
 * EC2SDConfig allow retrieving scrape targets from AWS EC2 instances. The private IP address is used by default, but may be changed to the public IP address with relabeling. The IAM credentials used must have the ec2:DescribeInstances permission to discover scrape targets See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#ec2_sd_config<br><p> <br><p> The EC2 service discovery requires AWS API keys or role ARN for authentication. BasicAuth, Authorization and OAuth2 fields are not present on purpose.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "accessKey",
    "enableHTTP2",
    "filters",
    "followRedirects",
    "noProxy",
    "port",
    "proxyConnectHeader",
    "proxyFromEnvironment",
    "proxyUrl",
    "refreshInterval",
    "region",
    "roleARN",
    "secretKey",
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
public class EC2SDConfig implements Editable<EC2SDConfigBuilder>, KubernetesResource
{

    @JsonProperty("accessKey")
    private SecretKeySelector accessKey;
    @JsonProperty("enableHTTP2")
    private Boolean enableHTTP2;
    @JsonProperty("filters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Filter> filters = new ArrayList<>();
    @JsonProperty("followRedirects")
    private Boolean followRedirects;
    @JsonProperty("noProxy")
    private String noProxy;
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
    @JsonProperty("region")
    private String region;
    @JsonProperty("roleARN")
    private String roleARN;
    @JsonProperty("secretKey")
    private SecretKeySelector secretKey;
    @JsonProperty("tlsConfig")
    private SafeTLSConfig tlsConfig;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public EC2SDConfig() {
    }

    public EC2SDConfig(SecretKeySelector accessKey, Boolean enableHTTP2, List<Filter> filters, Boolean followRedirects, String noProxy, Integer port, Map<String, List<SecretKeySelector>> proxyConnectHeader, Boolean proxyFromEnvironment, String proxyUrl, String refreshInterval, String region, String roleARN, SecretKeySelector secretKey, SafeTLSConfig tlsConfig) {
        super();
        this.accessKey = accessKey;
        this.enableHTTP2 = enableHTTP2;
        this.filters = filters;
        this.followRedirects = followRedirects;
        this.noProxy = noProxy;
        this.port = port;
        this.proxyConnectHeader = proxyConnectHeader;
        this.proxyFromEnvironment = proxyFromEnvironment;
        this.proxyUrl = proxyUrl;
        this.refreshInterval = refreshInterval;
        this.region = region;
        this.roleARN = roleARN;
        this.secretKey = secretKey;
        this.tlsConfig = tlsConfig;
    }

    /**
     * EC2SDConfig allow retrieving scrape targets from AWS EC2 instances. The private IP address is used by default, but may be changed to the public IP address with relabeling. The IAM credentials used must have the ec2:DescribeInstances permission to discover scrape targets See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#ec2_sd_config<br><p> <br><p> The EC2 service discovery requires AWS API keys or role ARN for authentication. BasicAuth, Authorization and OAuth2 fields are not present on purpose.
     */
    @JsonProperty("accessKey")
    public SecretKeySelector getAccessKey() {
        return accessKey;
    }

    /**
     * EC2SDConfig allow retrieving scrape targets from AWS EC2 instances. The private IP address is used by default, but may be changed to the public IP address with relabeling. The IAM credentials used must have the ec2:DescribeInstances permission to discover scrape targets See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#ec2_sd_config<br><p> <br><p> The EC2 service discovery requires AWS API keys or role ARN for authentication. BasicAuth, Authorization and OAuth2 fields are not present on purpose.
     */
    @JsonProperty("accessKey")
    public void setAccessKey(SecretKeySelector accessKey) {
        this.accessKey = accessKey;
    }

    /**
     * enableHTTP2 defines whether to enable HTTP2. It requires Prometheus &gt;= v2.41.0
     */
    @JsonProperty("enableHTTP2")
    public Boolean getEnableHTTP2() {
        return enableHTTP2;
    }

    /**
     * enableHTTP2 defines whether to enable HTTP2. It requires Prometheus &gt;= v2.41.0
     */
    @JsonProperty("enableHTTP2")
    public void setEnableHTTP2(Boolean enableHTTP2) {
        this.enableHTTP2 = enableHTTP2;
    }

    /**
     * filters can be used optionally to filter the instance list by other criteria. Available filter criteria can be found here: https://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_DescribeInstances.html Filter API documentation: https://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_Filter.html It requires Prometheus &gt;= v2.3.0
     */
    @JsonProperty("filters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Filter> getFilters() {
        return filters;
    }

    /**
     * filters can be used optionally to filter the instance list by other criteria. Available filter criteria can be found here: https://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_DescribeInstances.html Filter API documentation: https://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_Filter.html It requires Prometheus &gt;= v2.3.0
     */
    @JsonProperty("filters")
    public void setFilters(List<Filter> filters) {
        this.filters = filters;
    }

    /**
     * followRedirects defines whether HTTP requests follow HTTP 3xx redirects. It requires Prometheus &gt;= v2.41.0
     */
    @JsonProperty("followRedirects")
    public Boolean getFollowRedirects() {
        return followRedirects;
    }

    /**
     * followRedirects defines whether HTTP requests follow HTTP 3xx redirects. It requires Prometheus &gt;= v2.41.0
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
     * region defines the AWS region.
     */
    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    /**
     * region defines the AWS region.
     */
    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * roleARN defines an alternative to using AWS API keys.
     */
    @JsonProperty("roleARN")
    public String getRoleARN() {
        return roleARN;
    }

    /**
     * roleARN defines an alternative to using AWS API keys.
     */
    @JsonProperty("roleARN")
    public void setRoleARN(String roleARN) {
        this.roleARN = roleARN;
    }

    /**
     * EC2SDConfig allow retrieving scrape targets from AWS EC2 instances. The private IP address is used by default, but may be changed to the public IP address with relabeling. The IAM credentials used must have the ec2:DescribeInstances permission to discover scrape targets See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#ec2_sd_config<br><p> <br><p> The EC2 service discovery requires AWS API keys or role ARN for authentication. BasicAuth, Authorization and OAuth2 fields are not present on purpose.
     */
    @JsonProperty("secretKey")
    public SecretKeySelector getSecretKey() {
        return secretKey;
    }

    /**
     * EC2SDConfig allow retrieving scrape targets from AWS EC2 instances. The private IP address is used by default, but may be changed to the public IP address with relabeling. The IAM credentials used must have the ec2:DescribeInstances permission to discover scrape targets See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#ec2_sd_config<br><p> <br><p> The EC2 service discovery requires AWS API keys or role ARN for authentication. BasicAuth, Authorization and OAuth2 fields are not present on purpose.
     */
    @JsonProperty("secretKey")
    public void setSecretKey(SecretKeySelector secretKey) {
        this.secretKey = secretKey;
    }

    /**
     * EC2SDConfig allow retrieving scrape targets from AWS EC2 instances. The private IP address is used by default, but may be changed to the public IP address with relabeling. The IAM credentials used must have the ec2:DescribeInstances permission to discover scrape targets See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#ec2_sd_config<br><p> <br><p> The EC2 service discovery requires AWS API keys or role ARN for authentication. BasicAuth, Authorization and OAuth2 fields are not present on purpose.
     */
    @JsonProperty("tlsConfig")
    public SafeTLSConfig getTlsConfig() {
        return tlsConfig;
    }

    /**
     * EC2SDConfig allow retrieving scrape targets from AWS EC2 instances. The private IP address is used by default, but may be changed to the public IP address with relabeling. The IAM credentials used must have the ec2:DescribeInstances permission to discover scrape targets See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#ec2_sd_config<br><p> <br><p> The EC2 service discovery requires AWS API keys or role ARN for authentication. BasicAuth, Authorization and OAuth2 fields are not present on purpose.
     */
    @JsonProperty("tlsConfig")
    public void setTlsConfig(SafeTLSConfig tlsConfig) {
        this.tlsConfig = tlsConfig;
    }

    @JsonIgnore
    public EC2SDConfigBuilder edit() {
        return new EC2SDConfigBuilder(this);
    }

    @JsonIgnore
    public EC2SDConfigBuilder toBuilder() {
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
        if (!(o instanceof EC2SDConfig)) {
            return false;
        }
        EC2SDConfig other = (EC2SDConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$accessKey = this.getAccessKey();
        Object other$accessKey = other.getAccessKey();
        if (this$accessKey == null ? other$accessKey != null : !this$accessKey.equals(other$accessKey)) {
            return false;
        }
        Object this$enableHTTP2 = this.getEnableHTTP2();
        Object other$enableHTTP2 = other.getEnableHTTP2();
        if (this$enableHTTP2 == null ? other$enableHTTP2 != null : !this$enableHTTP2.equals(other$enableHTTP2)) {
            return false;
        }
        Object this$filters = this.getFilters();
        Object other$filters = other.getFilters();
        if (this$filters == null ? other$filters != null : !this$filters.equals(other$filters)) {
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
        Object this$region = this.getRegion();
        Object other$region = other.getRegion();
        if (this$region == null ? other$region != null : !this$region.equals(other$region)) {
            return false;
        }
        Object this$roleARN = this.getRoleARN();
        Object other$roleARN = other.getRoleARN();
        if (this$roleARN == null ? other$roleARN != null : !this$roleARN.equals(other$roleARN)) {
            return false;
        }
        Object this$secretKey = this.getSecretKey();
        Object other$secretKey = other.getSecretKey();
        if (this$secretKey == null ? other$secretKey != null : !this$secretKey.equals(other$secretKey)) {
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
        return other instanceof EC2SDConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $accessKey = this.getAccessKey();
        result = result * prime + ($accessKey == null ? 43 : $accessKey.hashCode());
        Object $enableHTTP2 = this.getEnableHTTP2();
        result = result * prime + ($enableHTTP2 == null ? 43 : $enableHTTP2.hashCode());
        Object $filters = this.getFilters();
        result = result * prime + ($filters == null ? 43 : $filters.hashCode());
        Object $followRedirects = this.getFollowRedirects();
        result = result * prime + ($followRedirects == null ? 43 : $followRedirects.hashCode());
        Object $noProxy = this.getNoProxy();
        result = result * prime + ($noProxy == null ? 43 : $noProxy.hashCode());
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
        Object $region = this.getRegion();
        result = result * prime + ($region == null ? 43 : $region.hashCode());
        Object $roleARN = this.getRoleARN();
        result = result * prime + ($roleARN == null ? 43 : $roleARN.hashCode());
        Object $secretKey = this.getSecretKey();
        result = result * prime + ($secretKey == null ? 43 : $secretKey.hashCode());
        Object $tlsConfig = this.getTlsConfig();
        result = result * prime + ($tlsConfig == null ? 43 : $tlsConfig.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "EC2SDConfig(" + "accessKey=" + this.getAccessKey() + ", enableHTTP2=" + this.getEnableHTTP2() + ", filters=" + this.getFilters() + ", followRedirects=" + this.getFollowRedirects() + ", noProxy=" + this.getNoProxy() + ", port=" + this.getPort() + ", proxyConnectHeader=" + this.getProxyConnectHeader() + ", proxyFromEnvironment=" + this.getProxyFromEnvironment() + ", proxyUrl=" + this.getProxyUrl() + ", refreshInterval=" + this.getRefreshInterval() + ", region=" + this.getRegion() + ", roleARN=" + this.getRoleARN() + ", secretKey=" + this.getSecretKey() + ", tlsConfig=" + this.getTlsConfig() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
