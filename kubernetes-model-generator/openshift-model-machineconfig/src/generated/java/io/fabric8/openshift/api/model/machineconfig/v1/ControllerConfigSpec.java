
package io.fabric8.openshift.api.model.machineconfig.v1;

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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.openshift.api.model.config.v1.DNS;
import io.fabric8.openshift.api.model.config.v1.Infrastructure;
import io.fabric8.openshift.api.model.config.v1.ProxyStatus;
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
    "additionalTrustBundle",
    "cloudProviderCAData",
    "cloudProviderConfig",
    "clusterDNSIP",
    "dns",
    "etcdDiscoveryDomain",
    "images",
    "infra",
    "ipFamilies",
    "kubeAPIServerServingCAData",
    "networkType",
    "osImageURL",
    "platform",
    "proxy",
    "pullSecret",
    "releaseImage",
    "rootCAData"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class ControllerConfigSpec implements KubernetesResource
{

    @JsonProperty("additionalTrustBundle")
    private java.lang.String additionalTrustBundle;
    @JsonProperty("cloudProviderCAData")
    private java.lang.String cloudProviderCAData;
    @JsonProperty("cloudProviderConfig")
    private java.lang.String cloudProviderConfig;
    @JsonProperty("clusterDNSIP")
    private java.lang.String clusterDNSIP;
    @JsonProperty("dns")
    private DNS dns;
    @JsonProperty("etcdDiscoveryDomain")
    private java.lang.String etcdDiscoveryDomain;
    @JsonProperty("images")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> images = new LinkedHashMap<String, String>();
    @JsonProperty("infra")
    private Infrastructure infra;
    @JsonProperty("ipFamilies")
    private java.lang.String ipFamilies;
    @JsonProperty("kubeAPIServerServingCAData")
    private java.lang.String kubeAPIServerServingCAData;
    @JsonProperty("networkType")
    private java.lang.String networkType;
    @JsonProperty("osImageURL")
    private java.lang.String osImageURL;
    @JsonProperty("platform")
    private java.lang.String platform;
    @JsonProperty("proxy")
    private ProxyStatus proxy;
    @JsonProperty("pullSecret")
    private io.fabric8.kubernetes.api.model.ObjectReference pullSecret;
    @JsonProperty("releaseImage")
    private java.lang.String releaseImage;
    @JsonProperty("rootCAData")
    private java.lang.String rootCAData;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ControllerConfigSpec() {
    }

    public ControllerConfigSpec(java.lang.String additionalTrustBundle, java.lang.String cloudProviderCAData, java.lang.String cloudProviderConfig, java.lang.String clusterDNSIP, DNS dns, java.lang.String etcdDiscoveryDomain, Map<String, String> images, Infrastructure infra, java.lang.String ipFamilies, java.lang.String kubeAPIServerServingCAData, java.lang.String networkType, java.lang.String osImageURL, java.lang.String platform, ProxyStatus proxy, io.fabric8.kubernetes.api.model.ObjectReference pullSecret, java.lang.String releaseImage, java.lang.String rootCAData) {
        super();
        this.additionalTrustBundle = additionalTrustBundle;
        this.cloudProviderCAData = cloudProviderCAData;
        this.cloudProviderConfig = cloudProviderConfig;
        this.clusterDNSIP = clusterDNSIP;
        this.dns = dns;
        this.etcdDiscoveryDomain = etcdDiscoveryDomain;
        this.images = images;
        this.infra = infra;
        this.ipFamilies = ipFamilies;
        this.kubeAPIServerServingCAData = kubeAPIServerServingCAData;
        this.networkType = networkType;
        this.osImageURL = osImageURL;
        this.platform = platform;
        this.proxy = proxy;
        this.pullSecret = pullSecret;
        this.releaseImage = releaseImage;
        this.rootCAData = rootCAData;
    }

    @JsonProperty("additionalTrustBundle")
    public java.lang.String getAdditionalTrustBundle() {
        return additionalTrustBundle;
    }

    @JsonProperty("additionalTrustBundle")
    public void setAdditionalTrustBundle(java.lang.String additionalTrustBundle) {
        this.additionalTrustBundle = additionalTrustBundle;
    }

    @JsonProperty("cloudProviderCAData")
    public java.lang.String getCloudProviderCAData() {
        return cloudProviderCAData;
    }

    @JsonProperty("cloudProviderCAData")
    public void setCloudProviderCAData(java.lang.String cloudProviderCAData) {
        this.cloudProviderCAData = cloudProviderCAData;
    }

    @JsonProperty("cloudProviderConfig")
    public java.lang.String getCloudProviderConfig() {
        return cloudProviderConfig;
    }

    @JsonProperty("cloudProviderConfig")
    public void setCloudProviderConfig(java.lang.String cloudProviderConfig) {
        this.cloudProviderConfig = cloudProviderConfig;
    }

    @JsonProperty("clusterDNSIP")
    public java.lang.String getClusterDNSIP() {
        return clusterDNSIP;
    }

    @JsonProperty("clusterDNSIP")
    public void setClusterDNSIP(java.lang.String clusterDNSIP) {
        this.clusterDNSIP = clusterDNSIP;
    }

    @JsonProperty("dns")
    public DNS getDns() {
        return dns;
    }

    @JsonProperty("dns")
    public void setDns(DNS dns) {
        this.dns = dns;
    }

    @JsonProperty("etcdDiscoveryDomain")
    public java.lang.String getEtcdDiscoveryDomain() {
        return etcdDiscoveryDomain;
    }

    @JsonProperty("etcdDiscoveryDomain")
    public void setEtcdDiscoveryDomain(java.lang.String etcdDiscoveryDomain) {
        this.etcdDiscoveryDomain = etcdDiscoveryDomain;
    }

    @JsonProperty("images")
    public Map<String, String> getImages() {
        return images;
    }

    @JsonProperty("images")
    public void setImages(Map<String, String> images) {
        this.images = images;
    }

    @JsonProperty("infra")
    public Infrastructure getInfra() {
        return infra;
    }

    @JsonProperty("infra")
    public void setInfra(Infrastructure infra) {
        this.infra = infra;
    }

    @JsonProperty("ipFamilies")
    public java.lang.String getIpFamilies() {
        return ipFamilies;
    }

    @JsonProperty("ipFamilies")
    public void setIpFamilies(java.lang.String ipFamilies) {
        this.ipFamilies = ipFamilies;
    }

    @JsonProperty("kubeAPIServerServingCAData")
    public java.lang.String getKubeAPIServerServingCAData() {
        return kubeAPIServerServingCAData;
    }

    @JsonProperty("kubeAPIServerServingCAData")
    public void setKubeAPIServerServingCAData(java.lang.String kubeAPIServerServingCAData) {
        this.kubeAPIServerServingCAData = kubeAPIServerServingCAData;
    }

    @JsonProperty("networkType")
    public java.lang.String getNetworkType() {
        return networkType;
    }

    @JsonProperty("networkType")
    public void setNetworkType(java.lang.String networkType) {
        this.networkType = networkType;
    }

    @JsonProperty("osImageURL")
    public java.lang.String getOsImageURL() {
        return osImageURL;
    }

    @JsonProperty("osImageURL")
    public void setOsImageURL(java.lang.String osImageURL) {
        this.osImageURL = osImageURL;
    }

    @JsonProperty("platform")
    public java.lang.String getPlatform() {
        return platform;
    }

    @JsonProperty("platform")
    public void setPlatform(java.lang.String platform) {
        this.platform = platform;
    }

    @JsonProperty("proxy")
    public ProxyStatus getProxy() {
        return proxy;
    }

    @JsonProperty("proxy")
    public void setProxy(ProxyStatus proxy) {
        this.proxy = proxy;
    }

    @JsonProperty("pullSecret")
    public io.fabric8.kubernetes.api.model.ObjectReference getPullSecret() {
        return pullSecret;
    }

    @JsonProperty("pullSecret")
    public void setPullSecret(io.fabric8.kubernetes.api.model.ObjectReference pullSecret) {
        this.pullSecret = pullSecret;
    }

    @JsonProperty("releaseImage")
    public java.lang.String getReleaseImage() {
        return releaseImage;
    }

    @JsonProperty("releaseImage")
    public void setReleaseImage(java.lang.String releaseImage) {
        this.releaseImage = releaseImage;
    }

    @JsonProperty("rootCAData")
    public java.lang.String getRootCAData() {
        return rootCAData;
    }

    @JsonProperty("rootCAData")
    public void setRootCAData(java.lang.String rootCAData) {
        this.rootCAData = rootCAData;
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
