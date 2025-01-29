
package io.fabric8.openshift.api.model.machineconfiguration.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
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
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.openshift.api.model.config.v1.DNS;
import io.fabric8.openshift.api.model.config.v1.Infrastructure;
import io.fabric8.openshift.api.model.config.v1.ProxyStatus;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * ControllerConfigSpec is the spec for ControllerConfig resource.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "additionalTrustBundle",
    "baseOSContainerImage",
    "baseOSExtensionsContainerImage",
    "cloudProviderCAData",
    "cloudProviderConfig",
    "clusterDNSIP",
    "dns",
    "etcdDiscoveryDomain",
    "imageRegistryBundleData",
    "imageRegistryBundleUserData",
    "images",
    "infra",
    "internalRegistryPullSecret",
    "ipFamilies",
    "kubeAPIServerServingCAData",
    "network",
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
public class ControllerConfigSpec implements Editable<ControllerConfigSpecBuilder>, KubernetesResource
{

    @JsonProperty("additionalTrustBundle")
    private String additionalTrustBundle;
    @JsonProperty("baseOSContainerImage")
    private String baseOSContainerImage;
    @JsonProperty("baseOSExtensionsContainerImage")
    private String baseOSExtensionsContainerImage;
    @JsonProperty("cloudProviderCAData")
    private String cloudProviderCAData;
    @JsonProperty("cloudProviderConfig")
    private String cloudProviderConfig;
    @JsonProperty("clusterDNSIP")
    private String clusterDNSIP;
    @JsonProperty("dns")
    private DNS dns;
    @JsonProperty("etcdDiscoveryDomain")
    private String etcdDiscoveryDomain;
    @JsonProperty("imageRegistryBundleData")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ImageRegistryBundle> imageRegistryBundleData = new ArrayList<>();
    @JsonProperty("imageRegistryBundleUserData")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ImageRegistryBundle> imageRegistryBundleUserData = new ArrayList<>();
    @JsonProperty("images")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> images = new LinkedHashMap<>();
    @JsonProperty("infra")
    private Infrastructure infra;
    @JsonProperty("internalRegistryPullSecret")
    private String internalRegistryPullSecret;
    @JsonProperty("ipFamilies")
    private String ipFamilies;
    @JsonProperty("kubeAPIServerServingCAData")
    private String kubeAPIServerServingCAData;
    @JsonProperty("network")
    private NetworkInfo network;
    @JsonProperty("networkType")
    private String networkType;
    @JsonProperty("osImageURL")
    private String osImageURL;
    @JsonProperty("platform")
    private String platform;
    @JsonProperty("proxy")
    private ProxyStatus proxy;
    @JsonProperty("pullSecret")
    private ObjectReference pullSecret;
    @JsonProperty("releaseImage")
    private String releaseImage;
    @JsonProperty("rootCAData")
    private String rootCAData;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ControllerConfigSpec() {
    }

    public ControllerConfigSpec(String additionalTrustBundle, String baseOSContainerImage, String baseOSExtensionsContainerImage, String cloudProviderCAData, String cloudProviderConfig, String clusterDNSIP, DNS dns, String etcdDiscoveryDomain, List<ImageRegistryBundle> imageRegistryBundleData, List<ImageRegistryBundle> imageRegistryBundleUserData, Map<String, String> images, Infrastructure infra, String internalRegistryPullSecret, String ipFamilies, String kubeAPIServerServingCAData, NetworkInfo network, String networkType, String osImageURL, String platform, ProxyStatus proxy, ObjectReference pullSecret, String releaseImage, String rootCAData) {
        super();
        this.additionalTrustBundle = additionalTrustBundle;
        this.baseOSContainerImage = baseOSContainerImage;
        this.baseOSExtensionsContainerImage = baseOSExtensionsContainerImage;
        this.cloudProviderCAData = cloudProviderCAData;
        this.cloudProviderConfig = cloudProviderConfig;
        this.clusterDNSIP = clusterDNSIP;
        this.dns = dns;
        this.etcdDiscoveryDomain = etcdDiscoveryDomain;
        this.imageRegistryBundleData = imageRegistryBundleData;
        this.imageRegistryBundleUserData = imageRegistryBundleUserData;
        this.images = images;
        this.infra = infra;
        this.internalRegistryPullSecret = internalRegistryPullSecret;
        this.ipFamilies = ipFamilies;
        this.kubeAPIServerServingCAData = kubeAPIServerServingCAData;
        this.network = network;
        this.networkType = networkType;
        this.osImageURL = osImageURL;
        this.platform = platform;
        this.proxy = proxy;
        this.pullSecret = pullSecret;
        this.releaseImage = releaseImage;
        this.rootCAData = rootCAData;
    }

    /**
     * additionalTrustBundle is a certificate bundle that will be added to the nodes trusted certificate store.
     */
    @JsonProperty("additionalTrustBundle")
    public String getAdditionalTrustBundle() {
        return additionalTrustBundle;
    }

    /**
     * additionalTrustBundle is a certificate bundle that will be added to the nodes trusted certificate store.
     */
    @JsonProperty("additionalTrustBundle")
    public void setAdditionalTrustBundle(String additionalTrustBundle) {
        this.additionalTrustBundle = additionalTrustBundle;
    }

    /**
     * BaseOSContainerImage is the new-format container image for operating system updates.
     */
    @JsonProperty("baseOSContainerImage")
    public String getBaseOSContainerImage() {
        return baseOSContainerImage;
    }

    /**
     * BaseOSContainerImage is the new-format container image for operating system updates.
     */
    @JsonProperty("baseOSContainerImage")
    public void setBaseOSContainerImage(String baseOSContainerImage) {
        this.baseOSContainerImage = baseOSContainerImage;
    }

    /**
     * BaseOSExtensionsContainerImage is the matching extensions container for the new-format container
     */
    @JsonProperty("baseOSExtensionsContainerImage")
    public String getBaseOSExtensionsContainerImage() {
        return baseOSExtensionsContainerImage;
    }

    /**
     * BaseOSExtensionsContainerImage is the matching extensions container for the new-format container
     */
    @JsonProperty("baseOSExtensionsContainerImage")
    public void setBaseOSExtensionsContainerImage(String baseOSExtensionsContainerImage) {
        this.baseOSExtensionsContainerImage = baseOSExtensionsContainerImage;
    }

    /**
     * cloudProvider specifies the cloud provider CA data
     */
    @JsonProperty("cloudProviderCAData")
    public String getCloudProviderCAData() {
        return cloudProviderCAData;
    }

    /**
     * cloudProvider specifies the cloud provider CA data
     */
    @JsonProperty("cloudProviderCAData")
    public void setCloudProviderCAData(String cloudProviderCAData) {
        this.cloudProviderCAData = cloudProviderCAData;
    }

    /**
     * cloudProviderConfig is the configuration for the given cloud provider
     */
    @JsonProperty("cloudProviderConfig")
    public String getCloudProviderConfig() {
        return cloudProviderConfig;
    }

    /**
     * cloudProviderConfig is the configuration for the given cloud provider
     */
    @JsonProperty("cloudProviderConfig")
    public void setCloudProviderConfig(String cloudProviderConfig) {
        this.cloudProviderConfig = cloudProviderConfig;
    }

    /**
     * clusterDNSIP is the cluster DNS IP address
     */
    @JsonProperty("clusterDNSIP")
    public String getClusterDNSIP() {
        return clusterDNSIP;
    }

    /**
     * clusterDNSIP is the cluster DNS IP address
     */
    @JsonProperty("clusterDNSIP")
    public void setClusterDNSIP(String clusterDNSIP) {
        this.clusterDNSIP = clusterDNSIP;
    }

    /**
     * ControllerConfigSpec is the spec for ControllerConfig resource.
     */
    @JsonProperty("dns")
    public DNS getDns() {
        return dns;
    }

    /**
     * ControllerConfigSpec is the spec for ControllerConfig resource.
     */
    @JsonProperty("dns")
    public void setDns(DNS dns) {
        this.dns = dns;
    }

    /**
     * etcdDiscoveryDomain is deprecated, use Infra.Status.EtcdDiscoveryDomain instead
     */
    @JsonProperty("etcdDiscoveryDomain")
    public String getEtcdDiscoveryDomain() {
        return etcdDiscoveryDomain;
    }

    /**
     * etcdDiscoveryDomain is deprecated, use Infra.Status.EtcdDiscoveryDomain instead
     */
    @JsonProperty("etcdDiscoveryDomain")
    public void setEtcdDiscoveryDomain(String etcdDiscoveryDomain) {
        this.etcdDiscoveryDomain = etcdDiscoveryDomain;
    }

    /**
     * imageRegistryBundleData is the ImageRegistryData
     */
    @JsonProperty("imageRegistryBundleData")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ImageRegistryBundle> getImageRegistryBundleData() {
        return imageRegistryBundleData;
    }

    /**
     * imageRegistryBundleData is the ImageRegistryData
     */
    @JsonProperty("imageRegistryBundleData")
    public void setImageRegistryBundleData(List<ImageRegistryBundle> imageRegistryBundleData) {
        this.imageRegistryBundleData = imageRegistryBundleData;
    }

    /**
     * imageRegistryBundleUserData is Image Registry Data provided by the user
     */
    @JsonProperty("imageRegistryBundleUserData")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ImageRegistryBundle> getImageRegistryBundleUserData() {
        return imageRegistryBundleUserData;
    }

    /**
     * imageRegistryBundleUserData is Image Registry Data provided by the user
     */
    @JsonProperty("imageRegistryBundleUserData")
    public void setImageRegistryBundleUserData(List<ImageRegistryBundle> imageRegistryBundleUserData) {
        this.imageRegistryBundleUserData = imageRegistryBundleUserData;
    }

    /**
     * images is map of images that are used by the controller to render templates under ./templates/
     */
    @JsonProperty("images")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getImages() {
        return images;
    }

    /**
     * images is map of images that are used by the controller to render templates under ./templates/
     */
    @JsonProperty("images")
    public void setImages(Map<String, String> images) {
        this.images = images;
    }

    /**
     * ControllerConfigSpec is the spec for ControllerConfig resource.
     */
    @JsonProperty("infra")
    public Infrastructure getInfra() {
        return infra;
    }

    /**
     * ControllerConfigSpec is the spec for ControllerConfig resource.
     */
    @JsonProperty("infra")
    public void setInfra(Infrastructure infra) {
        this.infra = infra;
    }

    /**
     * internalRegistryPullSecret is the pull secret for the internal registry, used by rpm-ostree to pull images from the internal registry if present
     */
    @JsonProperty("internalRegistryPullSecret")
    public String getInternalRegistryPullSecret() {
        return internalRegistryPullSecret;
    }

    /**
     * internalRegistryPullSecret is the pull secret for the internal registry, used by rpm-ostree to pull images from the internal registry if present
     */
    @JsonProperty("internalRegistryPullSecret")
    public void setInternalRegistryPullSecret(String internalRegistryPullSecret) {
        this.internalRegistryPullSecret = internalRegistryPullSecret;
    }

    /**
     * ipFamilies indicates the IP families in use by the cluster network
     */
    @JsonProperty("ipFamilies")
    public String getIpFamilies() {
        return ipFamilies;
    }

    /**
     * ipFamilies indicates the IP families in use by the cluster network
     */
    @JsonProperty("ipFamilies")
    public void setIpFamilies(String ipFamilies) {
        this.ipFamilies = ipFamilies;
    }

    /**
     * kubeAPIServerServingCAData managed Kubelet to API Server Cert... Rotated automatically
     */
    @JsonProperty("kubeAPIServerServingCAData")
    public String getKubeAPIServerServingCAData() {
        return kubeAPIServerServingCAData;
    }

    /**
     * kubeAPIServerServingCAData managed Kubelet to API Server Cert... Rotated automatically
     */
    @JsonProperty("kubeAPIServerServingCAData")
    public void setKubeAPIServerServingCAData(String kubeAPIServerServingCAData) {
        this.kubeAPIServerServingCAData = kubeAPIServerServingCAData;
    }

    /**
     * ControllerConfigSpec is the spec for ControllerConfig resource.
     */
    @JsonProperty("network")
    public NetworkInfo getNetwork() {
        return network;
    }

    /**
     * ControllerConfigSpec is the spec for ControllerConfig resource.
     */
    @JsonProperty("network")
    public void setNetwork(NetworkInfo network) {
        this.network = network;
    }

    /**
     * networkType holds the type of network the cluster is using XXX: this is temporary and will be dropped as soon as possible in favor of a better support to start network related services the proper way. Nobody is also changing this once the cluster is up and running the first time, so, disallow regeneration if this changes.
     */
    @JsonProperty("networkType")
    public String getNetworkType() {
        return networkType;
    }

    /**
     * networkType holds the type of network the cluster is using XXX: this is temporary and will be dropped as soon as possible in favor of a better support to start network related services the proper way. Nobody is also changing this once the cluster is up and running the first time, so, disallow regeneration if this changes.
     */
    @JsonProperty("networkType")
    public void setNetworkType(String networkType) {
        this.networkType = networkType;
    }

    /**
     * OSImageURL is the old-format container image that contains the OS update payload.
     */
    @JsonProperty("osImageURL")
    public String getOsImageURL() {
        return osImageURL;
    }

    /**
     * OSImageURL is the old-format container image that contains the OS update payload.
     */
    @JsonProperty("osImageURL")
    public void setOsImageURL(String osImageURL) {
        this.osImageURL = osImageURL;
    }

    /**
     * platform is deprecated, use Infra.Status.PlatformStatus.Type instead
     */
    @JsonProperty("platform")
    public String getPlatform() {
        return platform;
    }

    /**
     * platform is deprecated, use Infra.Status.PlatformStatus.Type instead
     */
    @JsonProperty("platform")
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    /**
     * ControllerConfigSpec is the spec for ControllerConfig resource.
     */
    @JsonProperty("proxy")
    public ProxyStatus getProxy() {
        return proxy;
    }

    /**
     * ControllerConfigSpec is the spec for ControllerConfig resource.
     */
    @JsonProperty("proxy")
    public void setProxy(ProxyStatus proxy) {
        this.proxy = proxy;
    }

    /**
     * ControllerConfigSpec is the spec for ControllerConfig resource.
     */
    @JsonProperty("pullSecret")
    public ObjectReference getPullSecret() {
        return pullSecret;
    }

    /**
     * ControllerConfigSpec is the spec for ControllerConfig resource.
     */
    @JsonProperty("pullSecret")
    public void setPullSecret(ObjectReference pullSecret) {
        this.pullSecret = pullSecret;
    }

    /**
     * releaseImage is the image used when installing the cluster
     */
    @JsonProperty("releaseImage")
    public String getReleaseImage() {
        return releaseImage;
    }

    /**
     * releaseImage is the image used when installing the cluster
     */
    @JsonProperty("releaseImage")
    public void setReleaseImage(String releaseImage) {
        this.releaseImage = releaseImage;
    }

    /**
     * rootCAData specifies the root CA data
     */
    @JsonProperty("rootCAData")
    public String getRootCAData() {
        return rootCAData;
    }

    /**
     * rootCAData specifies the root CA data
     */
    @JsonProperty("rootCAData")
    public void setRootCAData(String rootCAData) {
        this.rootCAData = rootCAData;
    }

    @JsonIgnore
    public ControllerConfigSpecBuilder edit() {
        return new ControllerConfigSpecBuilder(this);
    }

    @JsonIgnore
    public ControllerConfigSpecBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
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
