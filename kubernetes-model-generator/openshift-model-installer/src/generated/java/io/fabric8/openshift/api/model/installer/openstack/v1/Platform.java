
package io.fabric8.openshift.api.model.installer.openstack.v1;

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
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.openshift.api.model.config.v1.OpenStackPlatformLoadBalancer;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * Platform stores all the global configuration that all machinesets use.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiFloatingIP",
    "apiVIP",
    "apiVIPs",
    "cloud",
    "clusterOSImage",
    "clusterOSImageProperties",
    "computeFlavor",
    "controlPlanePort",
    "defaultMachinePlatform",
    "externalDNS",
    "externalNetwork",
    "ingressFloatingIP",
    "ingressVIP",
    "ingressVIPs",
    "lbFloatingIP",
    "loadBalancer",
    "machinesSubnet",
    "octaviaSupport",
    "region",
    "trunkSupport"
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
public class Platform implements Editable<PlatformBuilder>, KubernetesResource
{

    @JsonProperty("apiFloatingIP")
    private String apiFloatingIP;
    @JsonProperty("apiVIP")
    private String apiVIP;
    @JsonProperty("apiVIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> apiVIPs = new ArrayList<>();
    @JsonProperty("cloud")
    private String cloud;
    @JsonProperty("clusterOSImage")
    private String clusterOSImage;
    @JsonProperty("clusterOSImageProperties")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> clusterOSImageProperties = new LinkedHashMap<>();
    @JsonProperty("computeFlavor")
    private String computeFlavor;
    @JsonProperty("controlPlanePort")
    private PortTarget controlPlanePort;
    @JsonProperty("defaultMachinePlatform")
    private MachinePool defaultMachinePlatform;
    @JsonProperty("externalDNS")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> externalDNS = new ArrayList<>();
    @JsonProperty("externalNetwork")
    private String externalNetwork;
    @JsonProperty("ingressFloatingIP")
    private String ingressFloatingIP;
    @JsonProperty("ingressVIP")
    private String ingressVIP;
    @JsonProperty("ingressVIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> ingressVIPs = new ArrayList<>();
    @JsonProperty("lbFloatingIP")
    private String lbFloatingIP;
    @JsonProperty("loadBalancer")
    private OpenStackPlatformLoadBalancer loadBalancer;
    @JsonProperty("machinesSubnet")
    private String machinesSubnet;
    @JsonProperty("octaviaSupport")
    private String octaviaSupport;
    @JsonProperty("region")
    private String region;
    @JsonProperty("trunkSupport")
    private String trunkSupport;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Platform() {
    }

    public Platform(String apiFloatingIP, String apiVIP, List<String> apiVIPs, String cloud, String clusterOSImage, Map<String, String> clusterOSImageProperties, String computeFlavor, PortTarget controlPlanePort, MachinePool defaultMachinePlatform, List<String> externalDNS, String externalNetwork, String ingressFloatingIP, String ingressVIP, List<String> ingressVIPs, String lbFloatingIP, OpenStackPlatformLoadBalancer loadBalancer, String machinesSubnet, String octaviaSupport, String region, String trunkSupport) {
        super();
        this.apiFloatingIP = apiFloatingIP;
        this.apiVIP = apiVIP;
        this.apiVIPs = apiVIPs;
        this.cloud = cloud;
        this.clusterOSImage = clusterOSImage;
        this.clusterOSImageProperties = clusterOSImageProperties;
        this.computeFlavor = computeFlavor;
        this.controlPlanePort = controlPlanePort;
        this.defaultMachinePlatform = defaultMachinePlatform;
        this.externalDNS = externalDNS;
        this.externalNetwork = externalNetwork;
        this.ingressFloatingIP = ingressFloatingIP;
        this.ingressVIP = ingressVIP;
        this.ingressVIPs = ingressVIPs;
        this.lbFloatingIP = lbFloatingIP;
        this.loadBalancer = loadBalancer;
        this.machinesSubnet = machinesSubnet;
        this.octaviaSupport = octaviaSupport;
        this.region = region;
        this.trunkSupport = trunkSupport;
    }

    /**
     * APIFloatingIP is the IP address of an available floating IP in your OpenStack cluster to associate with the OpenShift API load balancer.
     */
    @JsonProperty("apiFloatingIP")
    public String getApiFloatingIP() {
        return apiFloatingIP;
    }

    /**
     * APIFloatingIP is the IP address of an available floating IP in your OpenStack cluster to associate with the OpenShift API load balancer.
     */
    @JsonProperty("apiFloatingIP")
    public void setApiFloatingIP(String apiFloatingIP) {
        this.apiFloatingIP = apiFloatingIP;
    }

    /**
     * DeprecatedAPIVIP is the static IP on the nodes subnet that the api port for openshift will be assigned Default: will be set to the 5 on the first entry in the machineNetwork CIDR Deprecated: Use APIVIPs
     */
    @JsonProperty("apiVIP")
    public String getApiVIP() {
        return apiVIP;
    }

    /**
     * DeprecatedAPIVIP is the static IP on the nodes subnet that the api port for openshift will be assigned Default: will be set to the 5 on the first entry in the machineNetwork CIDR Deprecated: Use APIVIPs
     */
    @JsonProperty("apiVIP")
    public void setApiVIP(String apiVIP) {
        this.apiVIP = apiVIP;
    }

    /**
     * APIVIPs contains the VIP(s) on the nodes subnet that the api port for openshift will be assigned. In dual stack clusters it contains an IPv4 and IPv6 address, otherwise only one VIP Default: will be set to the 5 on the first entry in the machineNetwork CIDR
     */
    @JsonProperty("apiVIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getApiVIPs() {
        return apiVIPs;
    }

    /**
     * APIVIPs contains the VIP(s) on the nodes subnet that the api port for openshift will be assigned. In dual stack clusters it contains an IPv4 and IPv6 address, otherwise only one VIP Default: will be set to the 5 on the first entry in the machineNetwork CIDR
     */
    @JsonProperty("apiVIPs")
    public void setApiVIPs(List<String> apiVIPs) {
        this.apiVIPs = apiVIPs;
    }

    /**
     * Cloud is the name of OpenStack cloud to use from clouds.yaml.
     */
    @JsonProperty("cloud")
    public String getCloud() {
        return cloud;
    }

    /**
     * Cloud is the name of OpenStack cloud to use from clouds.yaml.
     */
    @JsonProperty("cloud")
    public void setCloud(String cloud) {
        this.cloud = cloud;
    }

    /**
     * ClusterOSImage is either a URL with `http(s)` or `file` scheme to override the default OS image for cluster nodes, or an existing Glance image name.
     */
    @JsonProperty("clusterOSImage")
    public String getClusterOSImage() {
        return clusterOSImage;
    }

    /**
     * ClusterOSImage is either a URL with `http(s)` or `file` scheme to override the default OS image for cluster nodes, or an existing Glance image name.
     */
    @JsonProperty("clusterOSImage")
    public void setClusterOSImage(String clusterOSImage) {
        this.clusterOSImage = clusterOSImage;
    }

    /**
     * ClusterOSImageProperties is a list of properties to be added to the metadata of the uploaded Glance ClusterOSImage. Default: the default is to not set any properties.
     */
    @JsonProperty("clusterOSImageProperties")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getClusterOSImageProperties() {
        return clusterOSImageProperties;
    }

    /**
     * ClusterOSImageProperties is a list of properties to be added to the metadata of the uploaded Glance ClusterOSImage. Default: the default is to not set any properties.
     */
    @JsonProperty("clusterOSImageProperties")
    public void setClusterOSImageProperties(Map<String, String> clusterOSImageProperties) {
        this.clusterOSImageProperties = clusterOSImageProperties;
    }

    /**
     * DeprecatedFlavorName is the name of the flavor to use for instances in this cluster. Deprecated: use FlavorName in DefaultMachinePlatform to define default flavor.
     */
    @JsonProperty("computeFlavor")
    public String getComputeFlavor() {
        return computeFlavor;
    }

    /**
     * DeprecatedFlavorName is the name of the flavor to use for instances in this cluster. Deprecated: use FlavorName in DefaultMachinePlatform to define default flavor.
     */
    @JsonProperty("computeFlavor")
    public void setComputeFlavor(String computeFlavor) {
        this.computeFlavor = computeFlavor;
    }

    /**
     * Platform stores all the global configuration that all machinesets use.
     */
    @JsonProperty("controlPlanePort")
    public PortTarget getControlPlanePort() {
        return controlPlanePort;
    }

    /**
     * Platform stores all the global configuration that all machinesets use.
     */
    @JsonProperty("controlPlanePort")
    public void setControlPlanePort(PortTarget controlPlanePort) {
        this.controlPlanePort = controlPlanePort;
    }

    /**
     * Platform stores all the global configuration that all machinesets use.
     */
    @JsonProperty("defaultMachinePlatform")
    public MachinePool getDefaultMachinePlatform() {
        return defaultMachinePlatform;
    }

    /**
     * Platform stores all the global configuration that all machinesets use.
     */
    @JsonProperty("defaultMachinePlatform")
    public void setDefaultMachinePlatform(MachinePool defaultMachinePlatform) {
        this.defaultMachinePlatform = defaultMachinePlatform;
    }

    /**
     * ExternalDNS holds the IP addresses of dns servers that will be added to the dns resolution of all instances in the cluster.
     */
    @JsonProperty("externalDNS")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getExternalDNS() {
        return externalDNS;
    }

    /**
     * ExternalDNS holds the IP addresses of dns servers that will be added to the dns resolution of all instances in the cluster.
     */
    @JsonProperty("externalDNS")
    public void setExternalDNS(List<String> externalDNS) {
        this.externalDNS = externalDNS;
    }

    /**
     * ExternalNetwork is name of the external network in your OpenStack cluster.
     */
    @JsonProperty("externalNetwork")
    public String getExternalNetwork() {
        return externalNetwork;
    }

    /**
     * ExternalNetwork is name of the external network in your OpenStack cluster.
     */
    @JsonProperty("externalNetwork")
    public void setExternalNetwork(String externalNetwork) {
        this.externalNetwork = externalNetwork;
    }

    /**
     * IngressFloatingIP is the ID of an available floating IP in your OpenStack cluster that will be associated with the OpenShift ingress port
     */
    @JsonProperty("ingressFloatingIP")
    public String getIngressFloatingIP() {
        return ingressFloatingIP;
    }

    /**
     * IngressFloatingIP is the ID of an available floating IP in your OpenStack cluster that will be associated with the OpenShift ingress port
     */
    @JsonProperty("ingressFloatingIP")
    public void setIngressFloatingIP(String ingressFloatingIP) {
        this.ingressFloatingIP = ingressFloatingIP;
    }

    /**
     * DeprecatedIngressVIP is the static IP on the nodes subnet that the apps port for openshift will be assigned Default: will be set to the 7 on the first entry in the machineNetwork CIDR Deprecated: Use IngressVIPs
     */
    @JsonProperty("ingressVIP")
    public String getIngressVIP() {
        return ingressVIP;
    }

    /**
     * DeprecatedIngressVIP is the static IP on the nodes subnet that the apps port for openshift will be assigned Default: will be set to the 7 on the first entry in the machineNetwork CIDR Deprecated: Use IngressVIPs
     */
    @JsonProperty("ingressVIP")
    public void setIngressVIP(String ingressVIP) {
        this.ingressVIP = ingressVIP;
    }

    /**
     * IngressVIPs contains the VIP(s) on the nodes subnet that the apps port for openshift will be assigned. In dual stack clusters it contains an IPv4 and IPv6 address, otherwise only one VIP Default: will be set to the 7 on the first entry in the machineNetwork CIDR
     */
    @JsonProperty("ingressVIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getIngressVIPs() {
        return ingressVIPs;
    }

    /**
     * IngressVIPs contains the VIP(s) on the nodes subnet that the apps port for openshift will be assigned. In dual stack clusters it contains an IPv4 and IPv6 address, otherwise only one VIP Default: will be set to the 7 on the first entry in the machineNetwork CIDR
     */
    @JsonProperty("ingressVIPs")
    public void setIngressVIPs(List<String> ingressVIPs) {
        this.ingressVIPs = ingressVIPs;
    }

    /**
     * LbFloatingIP is the IP address of an available floating IP in your OpenStack cluster to associate with the OpenShift load balancer. Deprecated: this value has been renamed to apiFloatingIP.
     */
    @JsonProperty("lbFloatingIP")
    public String getLbFloatingIP() {
        return lbFloatingIP;
    }

    /**
     * LbFloatingIP is the IP address of an available floating IP in your OpenStack cluster to associate with the OpenShift load balancer. Deprecated: this value has been renamed to apiFloatingIP.
     */
    @JsonProperty("lbFloatingIP")
    public void setLbFloatingIP(String lbFloatingIP) {
        this.lbFloatingIP = lbFloatingIP;
    }

    /**
     * Platform stores all the global configuration that all machinesets use.
     */
    @JsonProperty("loadBalancer")
    public OpenStackPlatformLoadBalancer getLoadBalancer() {
        return loadBalancer;
    }

    /**
     * Platform stores all the global configuration that all machinesets use.
     */
    @JsonProperty("loadBalancer")
    public void setLoadBalancer(OpenStackPlatformLoadBalancer loadBalancer) {
        this.loadBalancer = loadBalancer;
    }

    /**
     * DeprecatedMachinesSubnet is a string of the UUIDv4 of an openstack subnet. This subnet will be used by all nodes created by the installer. By setting this, the installer will no longer create a network and subnet. The subnet and network specified in MachinesSubnet will not be deleted or modified by the installer. Deprecated: Use ControlPlanePort
     */
    @JsonProperty("machinesSubnet")
    public String getMachinesSubnet() {
        return machinesSubnet;
    }

    /**
     * DeprecatedMachinesSubnet is a string of the UUIDv4 of an openstack subnet. This subnet will be used by all nodes created by the installer. By setting this, the installer will no longer create a network and subnet. The subnet and network specified in MachinesSubnet will not be deleted or modified by the installer. Deprecated: Use ControlPlanePort
     */
    @JsonProperty("machinesSubnet")
    public void setMachinesSubnet(String machinesSubnet) {
        this.machinesSubnet = machinesSubnet;
    }

    /**
     * OctaviaSupport holds a `0` or `1` value that indicates whether your OpenStack cluster supports Octavia Loadbalancing. Deprecated: this value is set by the installer automatically.
     */
    @JsonProperty("octaviaSupport")
    public String getOctaviaSupport() {
        return octaviaSupport;
    }

    /**
     * OctaviaSupport holds a `0` or `1` value that indicates whether your OpenStack cluster supports Octavia Loadbalancing. Deprecated: this value is set by the installer automatically.
     */
    @JsonProperty("octaviaSupport")
    public void setOctaviaSupport(String octaviaSupport) {
        this.octaviaSupport = octaviaSupport;
    }

    /**
     * Region specifies the OpenStack region where the cluster will be created. Deprecated: this value is not used by the installer.
     */
    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    /**
     * Region specifies the OpenStack region where the cluster will be created. Deprecated: this value is not used by the installer.
     */
    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * TrunkSupport holds a `0` or `1` value that indicates whether or not to use trunk ports in your OpenShift cluster. Deprecated: the machine manifest should be used to specify that trunk should be used.
     */
    @JsonProperty("trunkSupport")
    public String getTrunkSupport() {
        return trunkSupport;
    }

    /**
     * TrunkSupport holds a `0` or `1` value that indicates whether or not to use trunk ports in your OpenShift cluster. Deprecated: the machine manifest should be used to specify that trunk should be used.
     */
    @JsonProperty("trunkSupport")
    public void setTrunkSupport(String trunkSupport) {
        this.trunkSupport = trunkSupport;
    }

    @JsonIgnore
    public PlatformBuilder edit() {
        return new PlatformBuilder(this);
    }

    @JsonIgnore
    public PlatformBuilder toBuilder() {
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
        if (!(o instanceof Platform)) {
            return false;
        }
        Platform other = (Platform) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$apiFloatingIP = this.getApiFloatingIP();
        Object other$apiFloatingIP = other.getApiFloatingIP();
        if (this$apiFloatingIP == null ? other$apiFloatingIP != null : !this$apiFloatingIP.equals(other$apiFloatingIP)) {
            return false;
        }
        Object this$apiVIP = this.getApiVIP();
        Object other$apiVIP = other.getApiVIP();
        if (this$apiVIP == null ? other$apiVIP != null : !this$apiVIP.equals(other$apiVIP)) {
            return false;
        }
        Object this$apiVIPs = this.getApiVIPs();
        Object other$apiVIPs = other.getApiVIPs();
        if (this$apiVIPs == null ? other$apiVIPs != null : !this$apiVIPs.equals(other$apiVIPs)) {
            return false;
        }
        Object this$cloud = this.getCloud();
        Object other$cloud = other.getCloud();
        if (this$cloud == null ? other$cloud != null : !this$cloud.equals(other$cloud)) {
            return false;
        }
        Object this$clusterOSImage = this.getClusterOSImage();
        Object other$clusterOSImage = other.getClusterOSImage();
        if (this$clusterOSImage == null ? other$clusterOSImage != null : !this$clusterOSImage.equals(other$clusterOSImage)) {
            return false;
        }
        Object this$clusterOSImageProperties = this.getClusterOSImageProperties();
        Object other$clusterOSImageProperties = other.getClusterOSImageProperties();
        if (this$clusterOSImageProperties == null ? other$clusterOSImageProperties != null : !this$clusterOSImageProperties.equals(other$clusterOSImageProperties)) {
            return false;
        }
        Object this$computeFlavor = this.getComputeFlavor();
        Object other$computeFlavor = other.getComputeFlavor();
        if (this$computeFlavor == null ? other$computeFlavor != null : !this$computeFlavor.equals(other$computeFlavor)) {
            return false;
        }
        Object this$controlPlanePort = this.getControlPlanePort();
        Object other$controlPlanePort = other.getControlPlanePort();
        if (this$controlPlanePort == null ? other$controlPlanePort != null : !this$controlPlanePort.equals(other$controlPlanePort)) {
            return false;
        }
        Object this$defaultMachinePlatform = this.getDefaultMachinePlatform();
        Object other$defaultMachinePlatform = other.getDefaultMachinePlatform();
        if (this$defaultMachinePlatform == null ? other$defaultMachinePlatform != null : !this$defaultMachinePlatform.equals(other$defaultMachinePlatform)) {
            return false;
        }
        Object this$externalDNS = this.getExternalDNS();
        Object other$externalDNS = other.getExternalDNS();
        if (this$externalDNS == null ? other$externalDNS != null : !this$externalDNS.equals(other$externalDNS)) {
            return false;
        }
        Object this$externalNetwork = this.getExternalNetwork();
        Object other$externalNetwork = other.getExternalNetwork();
        if (this$externalNetwork == null ? other$externalNetwork != null : !this$externalNetwork.equals(other$externalNetwork)) {
            return false;
        }
        Object this$ingressFloatingIP = this.getIngressFloatingIP();
        Object other$ingressFloatingIP = other.getIngressFloatingIP();
        if (this$ingressFloatingIP == null ? other$ingressFloatingIP != null : !this$ingressFloatingIP.equals(other$ingressFloatingIP)) {
            return false;
        }
        Object this$ingressVIP = this.getIngressVIP();
        Object other$ingressVIP = other.getIngressVIP();
        if (this$ingressVIP == null ? other$ingressVIP != null : !this$ingressVIP.equals(other$ingressVIP)) {
            return false;
        }
        Object this$ingressVIPs = this.getIngressVIPs();
        Object other$ingressVIPs = other.getIngressVIPs();
        if (this$ingressVIPs == null ? other$ingressVIPs != null : !this$ingressVIPs.equals(other$ingressVIPs)) {
            return false;
        }
        Object this$lbFloatingIP = this.getLbFloatingIP();
        Object other$lbFloatingIP = other.getLbFloatingIP();
        if (this$lbFloatingIP == null ? other$lbFloatingIP != null : !this$lbFloatingIP.equals(other$lbFloatingIP)) {
            return false;
        }
        Object this$loadBalancer = this.getLoadBalancer();
        Object other$loadBalancer = other.getLoadBalancer();
        if (this$loadBalancer == null ? other$loadBalancer != null : !this$loadBalancer.equals(other$loadBalancer)) {
            return false;
        }
        Object this$machinesSubnet = this.getMachinesSubnet();
        Object other$machinesSubnet = other.getMachinesSubnet();
        if (this$machinesSubnet == null ? other$machinesSubnet != null : !this$machinesSubnet.equals(other$machinesSubnet)) {
            return false;
        }
        Object this$octaviaSupport = this.getOctaviaSupport();
        Object other$octaviaSupport = other.getOctaviaSupport();
        if (this$octaviaSupport == null ? other$octaviaSupport != null : !this$octaviaSupport.equals(other$octaviaSupport)) {
            return false;
        }
        Object this$region = this.getRegion();
        Object other$region = other.getRegion();
        if (this$region == null ? other$region != null : !this$region.equals(other$region)) {
            return false;
        }
        Object this$trunkSupport = this.getTrunkSupport();
        Object other$trunkSupport = other.getTrunkSupport();
        if (this$trunkSupport == null ? other$trunkSupport != null : !this$trunkSupport.equals(other$trunkSupport)) {
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
        return other instanceof Platform;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiFloatingIP = this.getApiFloatingIP();
        result = result * prime + ($apiFloatingIP == null ? 43 : $apiFloatingIP.hashCode());
        Object $apiVIP = this.getApiVIP();
        result = result * prime + ($apiVIP == null ? 43 : $apiVIP.hashCode());
        Object $apiVIPs = this.getApiVIPs();
        result = result * prime + ($apiVIPs == null ? 43 : $apiVIPs.hashCode());
        Object $cloud = this.getCloud();
        result = result * prime + ($cloud == null ? 43 : $cloud.hashCode());
        Object $clusterOSImage = this.getClusterOSImage();
        result = result * prime + ($clusterOSImage == null ? 43 : $clusterOSImage.hashCode());
        Object $clusterOSImageProperties = this.getClusterOSImageProperties();
        result = result * prime + ($clusterOSImageProperties == null ? 43 : $clusterOSImageProperties.hashCode());
        Object $computeFlavor = this.getComputeFlavor();
        result = result * prime + ($computeFlavor == null ? 43 : $computeFlavor.hashCode());
        Object $controlPlanePort = this.getControlPlanePort();
        result = result * prime + ($controlPlanePort == null ? 43 : $controlPlanePort.hashCode());
        Object $defaultMachinePlatform = this.getDefaultMachinePlatform();
        result = result * prime + ($defaultMachinePlatform == null ? 43 : $defaultMachinePlatform.hashCode());
        Object $externalDNS = this.getExternalDNS();
        result = result * prime + ($externalDNS == null ? 43 : $externalDNS.hashCode());
        Object $externalNetwork = this.getExternalNetwork();
        result = result * prime + ($externalNetwork == null ? 43 : $externalNetwork.hashCode());
        Object $ingressFloatingIP = this.getIngressFloatingIP();
        result = result * prime + ($ingressFloatingIP == null ? 43 : $ingressFloatingIP.hashCode());
        Object $ingressVIP = this.getIngressVIP();
        result = result * prime + ($ingressVIP == null ? 43 : $ingressVIP.hashCode());
        Object $ingressVIPs = this.getIngressVIPs();
        result = result * prime + ($ingressVIPs == null ? 43 : $ingressVIPs.hashCode());
        Object $lbFloatingIP = this.getLbFloatingIP();
        result = result * prime + ($lbFloatingIP == null ? 43 : $lbFloatingIP.hashCode());
        Object $loadBalancer = this.getLoadBalancer();
        result = result * prime + ($loadBalancer == null ? 43 : $loadBalancer.hashCode());
        Object $machinesSubnet = this.getMachinesSubnet();
        result = result * prime + ($machinesSubnet == null ? 43 : $machinesSubnet.hashCode());
        Object $octaviaSupport = this.getOctaviaSupport();
        result = result * prime + ($octaviaSupport == null ? 43 : $octaviaSupport.hashCode());
        Object $region = this.getRegion();
        result = result * prime + ($region == null ? 43 : $region.hashCode());
        Object $trunkSupport = this.getTrunkSupport();
        result = result * prime + ($trunkSupport == null ? 43 : $trunkSupport.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Platform(" + "apiFloatingIP=" + this.getApiFloatingIP() + ", apiVIP=" + this.getApiVIP() + ", apiVIPs=" + this.getApiVIPs() + ", cloud=" + this.getCloud() + ", clusterOSImage=" + this.getClusterOSImage() + ", clusterOSImageProperties=" + this.getClusterOSImageProperties() + ", computeFlavor=" + this.getComputeFlavor() + ", controlPlanePort=" + this.getControlPlanePort() + ", defaultMachinePlatform=" + this.getDefaultMachinePlatform() + ", externalDNS=" + this.getExternalDNS() + ", externalNetwork=" + this.getExternalNetwork() + ", ingressFloatingIP=" + this.getIngressFloatingIP() + ", ingressVIP=" + this.getIngressVIP() + ", ingressVIPs=" + this.getIngressVIPs() + ", lbFloatingIP=" + this.getLbFloatingIP() + ", loadBalancer=" + this.getLoadBalancer() + ", machinesSubnet=" + this.getMachinesSubnet() + ", octaviaSupport=" + this.getOctaviaSupport() + ", region=" + this.getRegion() + ", trunkSupport=" + this.getTrunkSupport() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
