
package io.fabric8.openshift.api.model.installer.baremetal.v1;

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
import io.fabric8.openshift.api.model.config.v1.BareMetalPlatformLoadBalancer;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * Platform stores all the global configuration that all machinesets use.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "additionalNTPServers",
    "apiVIP",
    "apiVIPs",
    "bmcVerifyCA",
    "bootstrapExternalStaticDNS",
    "bootstrapExternalStaticGateway",
    "bootstrapExternalStaticIP",
    "bootstrapOSImage",
    "bootstrapProvisioningIP",
    "clusterOSImage",
    "clusterProvisioningIP",
    "defaultMachinePlatform",
    "externalBridge",
    "externalMACAddress",
    "hosts",
    "ingressVIP",
    "ingressVIPs",
    "libvirtURI",
    "loadBalancer",
    "provisioningBridge",
    "provisioningDHCPExternal",
    "provisioningDHCPRange",
    "provisioningHostIP",
    "provisioningMACAddress",
    "provisioningNetwork",
    "provisioningNetworkCIDR",
    "provisioningNetworkInterface"
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

    @JsonProperty("additionalNTPServers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> additionalNTPServers = new ArrayList<>();
    @JsonProperty("apiVIP")
    private String apiVIP;
    @JsonProperty("apiVIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> apiVIPs = new ArrayList<>();
    @JsonProperty("bmcVerifyCA")
    private String bmcVerifyCA;
    @JsonProperty("bootstrapExternalStaticDNS")
    private String bootstrapExternalStaticDNS;
    @JsonProperty("bootstrapExternalStaticGateway")
    private String bootstrapExternalStaticGateway;
    @JsonProperty("bootstrapExternalStaticIP")
    private String bootstrapExternalStaticIP;
    @JsonProperty("bootstrapOSImage")
    private String bootstrapOSImage;
    @JsonProperty("bootstrapProvisioningIP")
    private String bootstrapProvisioningIP;
    @JsonProperty("clusterOSImage")
    private String clusterOSImage;
    @JsonProperty("clusterProvisioningIP")
    private String clusterProvisioningIP;
    @JsonProperty("defaultMachinePlatform")
    private MachinePool defaultMachinePlatform;
    @JsonProperty("externalBridge")
    private String externalBridge;
    @JsonProperty("externalMACAddress")
    private String externalMACAddress;
    @JsonProperty("hosts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Host> hosts = new ArrayList<>();
    @JsonProperty("ingressVIP")
    private String ingressVIP;
    @JsonProperty("ingressVIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> ingressVIPs = new ArrayList<>();
    @JsonProperty("libvirtURI")
    private String libvirtURI;
    @JsonProperty("loadBalancer")
    private BareMetalPlatformLoadBalancer loadBalancer;
    @JsonProperty("provisioningBridge")
    private String provisioningBridge;
    @JsonProperty("provisioningDHCPExternal")
    private Boolean provisioningDHCPExternal;
    @JsonProperty("provisioningDHCPRange")
    private String provisioningDHCPRange;
    @JsonProperty("provisioningHostIP")
    private String provisioningHostIP;
    @JsonProperty("provisioningMACAddress")
    private String provisioningMACAddress;
    @JsonProperty("provisioningNetwork")
    private String provisioningNetwork;
    @JsonProperty("provisioningNetworkCIDR")
    private String provisioningNetworkCIDR;
    @JsonProperty("provisioningNetworkInterface")
    private String provisioningNetworkInterface;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Platform() {
    }

    public Platform(List<String> additionalNTPServers, String apiVIP, List<String> apiVIPs, String bmcVerifyCA, String bootstrapExternalStaticDNS, String bootstrapExternalStaticGateway, String bootstrapExternalStaticIP, String bootstrapOSImage, String bootstrapProvisioningIP, String clusterOSImage, String clusterProvisioningIP, MachinePool defaultMachinePlatform, String externalBridge, String externalMACAddress, List<Host> hosts, String ingressVIP, List<String> ingressVIPs, String libvirtURI, BareMetalPlatformLoadBalancer loadBalancer, String provisioningBridge, Boolean provisioningDHCPExternal, String provisioningDHCPRange, String provisioningHostIP, String provisioningMACAddress, String provisioningNetwork, String provisioningNetworkCIDR, String provisioningNetworkInterface) {
        super();
        this.additionalNTPServers = additionalNTPServers;
        this.apiVIP = apiVIP;
        this.apiVIPs = apiVIPs;
        this.bmcVerifyCA = bmcVerifyCA;
        this.bootstrapExternalStaticDNS = bootstrapExternalStaticDNS;
        this.bootstrapExternalStaticGateway = bootstrapExternalStaticGateway;
        this.bootstrapExternalStaticIP = bootstrapExternalStaticIP;
        this.bootstrapOSImage = bootstrapOSImage;
        this.bootstrapProvisioningIP = bootstrapProvisioningIP;
        this.clusterOSImage = clusterOSImage;
        this.clusterProvisioningIP = clusterProvisioningIP;
        this.defaultMachinePlatform = defaultMachinePlatform;
        this.externalBridge = externalBridge;
        this.externalMACAddress = externalMACAddress;
        this.hosts = hosts;
        this.ingressVIP = ingressVIP;
        this.ingressVIPs = ingressVIPs;
        this.libvirtURI = libvirtURI;
        this.loadBalancer = loadBalancer;
        this.provisioningBridge = provisioningBridge;
        this.provisioningDHCPExternal = provisioningDHCPExternal;
        this.provisioningDHCPRange = provisioningDHCPRange;
        this.provisioningHostIP = provisioningHostIP;
        this.provisioningMACAddress = provisioningMACAddress;
        this.provisioningNetwork = provisioningNetwork;
        this.provisioningNetworkCIDR = provisioningNetworkCIDR;
        this.provisioningNetworkInterface = provisioningNetworkInterface;
    }

    /**
     * AdditionalNTPServers defines a list of additional NTP servers to use for provisioning
     */
    @JsonProperty("additionalNTPServers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAdditionalNTPServers() {
        return additionalNTPServers;
    }

    /**
     * AdditionalNTPServers defines a list of additional NTP servers to use for provisioning
     */
    @JsonProperty("additionalNTPServers")
    public void setAdditionalNTPServers(List<String> additionalNTPServers) {
        this.additionalNTPServers = additionalNTPServers;
    }

    /**
     * DeprecatedAPIVIP is the VIP to use for internal API communication Deprecated: Use APIVIPs
     */
    @JsonProperty("apiVIP")
    public String getApiVIP() {
        return apiVIP;
    }

    /**
     * DeprecatedAPIVIP is the VIP to use for internal API communication Deprecated: Use APIVIPs
     */
    @JsonProperty("apiVIP")
    public void setApiVIP(String apiVIP) {
        this.apiVIP = apiVIP;
    }

    /**
     * APIVIPs contains the VIP(s) to use for internal API communication. In dual stack clusters it contains an IPv4 and IPv6 address, otherwise only one VIP
     */
    @JsonProperty("apiVIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getApiVIPs() {
        return apiVIPs;
    }

    /**
     * APIVIPs contains the VIP(s) to use for internal API communication. In dual stack clusters it contains an IPv4 and IPv6 address, otherwise only one VIP
     */
    @JsonProperty("apiVIPs")
    public void setApiVIPs(List<String> apiVIPs) {
        this.apiVIPs = apiVIPs;
    }

    /**
     * Platform stores all the global configuration that all machinesets use.
     */
    @JsonProperty("bmcVerifyCA")
    public String getBmcVerifyCA() {
        return bmcVerifyCA;
    }

    /**
     * Platform stores all the global configuration that all machinesets use.
     */
    @JsonProperty("bmcVerifyCA")
    public void setBmcVerifyCA(String bmcVerifyCA) {
        this.bmcVerifyCA = bmcVerifyCA;
    }

    /**
     * BootstrapExternalStaticDNS is the static network DNS of the bootstrap node. This can be useful in environments without a DHCP server.
     */
    @JsonProperty("bootstrapExternalStaticDNS")
    public String getBootstrapExternalStaticDNS() {
        return bootstrapExternalStaticDNS;
    }

    /**
     * BootstrapExternalStaticDNS is the static network DNS of the bootstrap node. This can be useful in environments without a DHCP server.
     */
    @JsonProperty("bootstrapExternalStaticDNS")
    public void setBootstrapExternalStaticDNS(String bootstrapExternalStaticDNS) {
        this.bootstrapExternalStaticDNS = bootstrapExternalStaticDNS;
    }

    /**
     * BootstrapExternalStaticGateway is the static network gateway of the bootstrap node. This can be useful in environments without a DHCP server.
     */
    @JsonProperty("bootstrapExternalStaticGateway")
    public String getBootstrapExternalStaticGateway() {
        return bootstrapExternalStaticGateway;
    }

    /**
     * BootstrapExternalStaticGateway is the static network gateway of the bootstrap node. This can be useful in environments without a DHCP server.
     */
    @JsonProperty("bootstrapExternalStaticGateway")
    public void setBootstrapExternalStaticGateway(String bootstrapExternalStaticGateway) {
        this.bootstrapExternalStaticGateway = bootstrapExternalStaticGateway;
    }

    /**
     * BootstrapExternalStaticIP is the static IP address of the bootstrap node. This can be useful in environments without a DHCP server.
     */
    @JsonProperty("bootstrapExternalStaticIP")
    public String getBootstrapExternalStaticIP() {
        return bootstrapExternalStaticIP;
    }

    /**
     * BootstrapExternalStaticIP is the static IP address of the bootstrap node. This can be useful in environments without a DHCP server.
     */
    @JsonProperty("bootstrapExternalStaticIP")
    public void setBootstrapExternalStaticIP(String bootstrapExternalStaticIP) {
        this.bootstrapExternalStaticIP = bootstrapExternalStaticIP;
    }

    /**
     * BootstrapOSImage is a URL to override the default OS image for the bootstrap node. The URL must contain a sha256 hash of the image e.g https://mirror.example.com/images/qemu.qcow2.gz?sha256=a07bd...
     */
    @JsonProperty("bootstrapOSImage")
    public String getBootstrapOSImage() {
        return bootstrapOSImage;
    }

    /**
     * BootstrapOSImage is a URL to override the default OS image for the bootstrap node. The URL must contain a sha256 hash of the image e.g https://mirror.example.com/images/qemu.qcow2.gz?sha256=a07bd...
     */
    @JsonProperty("bootstrapOSImage")
    public void setBootstrapOSImage(String bootstrapOSImage) {
        this.bootstrapOSImage = bootstrapOSImage;
    }

    /**
     * BootstrapProvisioningIP is the IP used on the bootstrap VM to bring up provisioning services that are used to create the control-plane machines
     */
    @JsonProperty("bootstrapProvisioningIP")
    public String getBootstrapProvisioningIP() {
        return bootstrapProvisioningIP;
    }

    /**
     * BootstrapProvisioningIP is the IP used on the bootstrap VM to bring up provisioning services that are used to create the control-plane machines
     */
    @JsonProperty("bootstrapProvisioningIP")
    public void setBootstrapProvisioningIP(String bootstrapProvisioningIP) {
        this.bootstrapProvisioningIP = bootstrapProvisioningIP;
    }

    /**
     * ClusterOSImage is a URL to override the default OS image for cluster nodes. The URL must contain a sha256 hash of the image e.g https://mirror.example.com/images/metal.qcow2.gz?sha256=3b5a8...
     */
    @JsonProperty("clusterOSImage")
    public String getClusterOSImage() {
        return clusterOSImage;
    }

    /**
     * ClusterOSImage is a URL to override the default OS image for cluster nodes. The URL must contain a sha256 hash of the image e.g https://mirror.example.com/images/metal.qcow2.gz?sha256=3b5a8...
     */
    @JsonProperty("clusterOSImage")
    public void setClusterOSImage(String clusterOSImage) {
        this.clusterOSImage = clusterOSImage;
    }

    /**
     * ClusterProvisioningIP is the IP on the dedicated provisioning network where the baremetal-operator pod runs provisioning services, and an http server to cache some downloaded content e.g RHCOS/IPA images
     */
    @JsonProperty("clusterProvisioningIP")
    public String getClusterProvisioningIP() {
        return clusterProvisioningIP;
    }

    /**
     * ClusterProvisioningIP is the IP on the dedicated provisioning network where the baremetal-operator pod runs provisioning services, and an http server to cache some downloaded content e.g RHCOS/IPA images
     */
    @JsonProperty("clusterProvisioningIP")
    public void setClusterProvisioningIP(String clusterProvisioningIP) {
        this.clusterProvisioningIP = clusterProvisioningIP;
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
     * External bridge is used for external communication.
     */
    @JsonProperty("externalBridge")
    public String getExternalBridge() {
        return externalBridge;
    }

    /**
     * External bridge is used for external communication.
     */
    @JsonProperty("externalBridge")
    public void setExternalBridge(String externalBridge) {
        this.externalBridge = externalBridge;
    }

    /**
     * ExternalMACAddress is used to allow setting a static unicast MAC address for the bootstrap host on the external network. Consider using the QEMU vendor prefix `52:54:00`. If left blank, libvirt will generate one for you.
     */
    @JsonProperty("externalMACAddress")
    public String getExternalMACAddress() {
        return externalMACAddress;
    }

    /**
     * ExternalMACAddress is used to allow setting a static unicast MAC address for the bootstrap host on the external network. Consider using the QEMU vendor prefix `52:54:00`. If left blank, libvirt will generate one for you.
     */
    @JsonProperty("externalMACAddress")
    public void setExternalMACAddress(String externalMACAddress) {
        this.externalMACAddress = externalMACAddress;
    }

    /**
     * Hosts is the information needed to create the objects in Ironic.
     */
    @JsonProperty("hosts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Host> getHosts() {
        return hosts;
    }

    /**
     * Hosts is the information needed to create the objects in Ironic.
     */
    @JsonProperty("hosts")
    public void setHosts(List<Host> hosts) {
        this.hosts = hosts;
    }

    /**
     * DeprecatedIngressVIP is the VIP to use for ingress traffic Deprecated: Use IngressVIPs
     */
    @JsonProperty("ingressVIP")
    public String getIngressVIP() {
        return ingressVIP;
    }

    /**
     * DeprecatedIngressVIP is the VIP to use for ingress traffic Deprecated: Use IngressVIPs
     */
    @JsonProperty("ingressVIP")
    public void setIngressVIP(String ingressVIP) {
        this.ingressVIP = ingressVIP;
    }

    /**
     * IngressVIPs contains the VIP(s) to use for ingress traffic. In dual stack clusters it contains an IPv4 and IPv6 address, otherwise only one VIP
     */
    @JsonProperty("ingressVIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getIngressVIPs() {
        return ingressVIPs;
    }

    /**
     * IngressVIPs contains the VIP(s) to use for ingress traffic. In dual stack clusters it contains an IPv4 and IPv6 address, otherwise only one VIP
     */
    @JsonProperty("ingressVIPs")
    public void setIngressVIPs(List<String> ingressVIPs) {
        this.ingressVIPs = ingressVIPs;
    }

    /**
     * LibvirtURI is the identifier for the libvirtd connection.  It must be reachable from the host where the installer is run. Default is qemu:///system
     */
    @JsonProperty("libvirtURI")
    public String getLibvirtURI() {
        return libvirtURI;
    }

    /**
     * LibvirtURI is the identifier for the libvirtd connection.  It must be reachable from the host where the installer is run. Default is qemu:///system
     */
    @JsonProperty("libvirtURI")
    public void setLibvirtURI(String libvirtURI) {
        this.libvirtURI = libvirtURI;
    }

    /**
     * Platform stores all the global configuration that all machinesets use.
     */
    @JsonProperty("loadBalancer")
    public BareMetalPlatformLoadBalancer getLoadBalancer() {
        return loadBalancer;
    }

    /**
     * Platform stores all the global configuration that all machinesets use.
     */
    @JsonProperty("loadBalancer")
    public void setLoadBalancer(BareMetalPlatformLoadBalancer loadBalancer) {
        this.loadBalancer = loadBalancer;
    }

    /**
     * Provisioning bridge is used for provisioning nodes, on the host that will run the bootstrap VM.
     */
    @JsonProperty("provisioningBridge")
    public String getProvisioningBridge() {
        return provisioningBridge;
    }

    /**
     * Provisioning bridge is used for provisioning nodes, on the host that will run the bootstrap VM.
     */
    @JsonProperty("provisioningBridge")
    public void setProvisioningBridge(String provisioningBridge) {
        this.provisioningBridge = provisioningBridge;
    }

    /**
     * DeprecatedProvisioningDHCPExternal indicates that DHCP is provided by an external service. This parameter is replaced by ProvisioningNetwork being set to "Unmanaged".
     */
    @JsonProperty("provisioningDHCPExternal")
    public Boolean getProvisioningDHCPExternal() {
        return provisioningDHCPExternal;
    }

    /**
     * DeprecatedProvisioningDHCPExternal indicates that DHCP is provided by an external service. This parameter is replaced by ProvisioningNetwork being set to "Unmanaged".
     */
    @JsonProperty("provisioningDHCPExternal")
    public void setProvisioningDHCPExternal(Boolean provisioningDHCPExternal) {
        this.provisioningDHCPExternal = provisioningDHCPExternal;
    }

    /**
     * ProvisioningDHCPRange is used to provide DHCP services to hosts for provisioning.
     */
    @JsonProperty("provisioningDHCPRange")
    public String getProvisioningDHCPRange() {
        return provisioningDHCPRange;
    }

    /**
     * ProvisioningDHCPRange is used to provide DHCP services to hosts for provisioning.
     */
    @JsonProperty("provisioningDHCPRange")
    public void setProvisioningDHCPRange(String provisioningDHCPRange) {
        this.provisioningDHCPRange = provisioningDHCPRange;
    }

    /**
     * DeprecatedProvisioningHostIP is the deprecated version of clusterProvisioningIP. When the baremetal platform was initially added to the installer, the JSON field for ClusterProvisioningIP was incorrectly set to "provisioningHostIP."  This field is here to allow backwards-compatibility.
     */
    @JsonProperty("provisioningHostIP")
    public String getProvisioningHostIP() {
        return provisioningHostIP;
    }

    /**
     * DeprecatedProvisioningHostIP is the deprecated version of clusterProvisioningIP. When the baremetal platform was initially added to the installer, the JSON field for ClusterProvisioningIP was incorrectly set to "provisioningHostIP."  This field is here to allow backwards-compatibility.
     */
    @JsonProperty("provisioningHostIP")
    public void setProvisioningHostIP(String provisioningHostIP) {
        this.provisioningHostIP = provisioningHostIP;
    }

    /**
     * ProvisioningMACAddress is used to allow setting a static unicast MAC address for the bootstrap host on the provisioning network. Consider using the QEMU vendor prefix `52:54:00`. If left blank, libvirt will generate one for you.
     */
    @JsonProperty("provisioningMACAddress")
    public String getProvisioningMACAddress() {
        return provisioningMACAddress;
    }

    /**
     * ProvisioningMACAddress is used to allow setting a static unicast MAC address for the bootstrap host on the provisioning network. Consider using the QEMU vendor prefix `52:54:00`. If left blank, libvirt will generate one for you.
     */
    @JsonProperty("provisioningMACAddress")
    public void setProvisioningMACAddress(String provisioningMACAddress) {
        this.provisioningMACAddress = provisioningMACAddress;
    }

    /**
     * ProvisioningNetwork is used to indicate if we will have a provisioning network, and how it will be managed.
     */
    @JsonProperty("provisioningNetwork")
    public String getProvisioningNetwork() {
        return provisioningNetwork;
    }

    /**
     * ProvisioningNetwork is used to indicate if we will have a provisioning network, and how it will be managed.
     */
    @JsonProperty("provisioningNetwork")
    public void setProvisioningNetwork(String provisioningNetwork) {
        this.provisioningNetwork = provisioningNetwork;
    }

    /**
     * Platform stores all the global configuration that all machinesets use.
     */
    @JsonProperty("provisioningNetworkCIDR")
    public String getProvisioningNetworkCIDR() {
        return provisioningNetworkCIDR;
    }

    /**
     * Platform stores all the global configuration that all machinesets use.
     */
    @JsonProperty("provisioningNetworkCIDR")
    public void setProvisioningNetworkCIDR(String provisioningNetworkCIDR) {
        this.provisioningNetworkCIDR = provisioningNetworkCIDR;
    }

    /**
     * ProvisioningNetworkInterface is the name of the network interface on a control plane baremetal host that is connected to the provisioning network.
     */
    @JsonProperty("provisioningNetworkInterface")
    public String getProvisioningNetworkInterface() {
        return provisioningNetworkInterface;
    }

    /**
     * ProvisioningNetworkInterface is the name of the network interface on a control plane baremetal host that is connected to the provisioning network.
     */
    @JsonProperty("provisioningNetworkInterface")
    public void setProvisioningNetworkInterface(String provisioningNetworkInterface) {
        this.provisioningNetworkInterface = provisioningNetworkInterface;
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
        Object this$additionalNTPServers = this.getAdditionalNTPServers();
        Object other$additionalNTPServers = other.getAdditionalNTPServers();
        if (this$additionalNTPServers == null ? other$additionalNTPServers != null : !this$additionalNTPServers.equals(other$additionalNTPServers)) {
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
        Object this$bmcVerifyCA = this.getBmcVerifyCA();
        Object other$bmcVerifyCA = other.getBmcVerifyCA();
        if (this$bmcVerifyCA == null ? other$bmcVerifyCA != null : !this$bmcVerifyCA.equals(other$bmcVerifyCA)) {
            return false;
        }
        Object this$bootstrapExternalStaticDNS = this.getBootstrapExternalStaticDNS();
        Object other$bootstrapExternalStaticDNS = other.getBootstrapExternalStaticDNS();
        if (this$bootstrapExternalStaticDNS == null ? other$bootstrapExternalStaticDNS != null : !this$bootstrapExternalStaticDNS.equals(other$bootstrapExternalStaticDNS)) {
            return false;
        }
        Object this$bootstrapExternalStaticGateway = this.getBootstrapExternalStaticGateway();
        Object other$bootstrapExternalStaticGateway = other.getBootstrapExternalStaticGateway();
        if (this$bootstrapExternalStaticGateway == null ? other$bootstrapExternalStaticGateway != null : !this$bootstrapExternalStaticGateway.equals(other$bootstrapExternalStaticGateway)) {
            return false;
        }
        Object this$bootstrapExternalStaticIP = this.getBootstrapExternalStaticIP();
        Object other$bootstrapExternalStaticIP = other.getBootstrapExternalStaticIP();
        if (this$bootstrapExternalStaticIP == null ? other$bootstrapExternalStaticIP != null : !this$bootstrapExternalStaticIP.equals(other$bootstrapExternalStaticIP)) {
            return false;
        }
        Object this$bootstrapOSImage = this.getBootstrapOSImage();
        Object other$bootstrapOSImage = other.getBootstrapOSImage();
        if (this$bootstrapOSImage == null ? other$bootstrapOSImage != null : !this$bootstrapOSImage.equals(other$bootstrapOSImage)) {
            return false;
        }
        Object this$bootstrapProvisioningIP = this.getBootstrapProvisioningIP();
        Object other$bootstrapProvisioningIP = other.getBootstrapProvisioningIP();
        if (this$bootstrapProvisioningIP == null ? other$bootstrapProvisioningIP != null : !this$bootstrapProvisioningIP.equals(other$bootstrapProvisioningIP)) {
            return false;
        }
        Object this$clusterOSImage = this.getClusterOSImage();
        Object other$clusterOSImage = other.getClusterOSImage();
        if (this$clusterOSImage == null ? other$clusterOSImage != null : !this$clusterOSImage.equals(other$clusterOSImage)) {
            return false;
        }
        Object this$clusterProvisioningIP = this.getClusterProvisioningIP();
        Object other$clusterProvisioningIP = other.getClusterProvisioningIP();
        if (this$clusterProvisioningIP == null ? other$clusterProvisioningIP != null : !this$clusterProvisioningIP.equals(other$clusterProvisioningIP)) {
            return false;
        }
        Object this$defaultMachinePlatform = this.getDefaultMachinePlatform();
        Object other$defaultMachinePlatform = other.getDefaultMachinePlatform();
        if (this$defaultMachinePlatform == null ? other$defaultMachinePlatform != null : !this$defaultMachinePlatform.equals(other$defaultMachinePlatform)) {
            return false;
        }
        Object this$externalBridge = this.getExternalBridge();
        Object other$externalBridge = other.getExternalBridge();
        if (this$externalBridge == null ? other$externalBridge != null : !this$externalBridge.equals(other$externalBridge)) {
            return false;
        }
        Object this$externalMACAddress = this.getExternalMACAddress();
        Object other$externalMACAddress = other.getExternalMACAddress();
        if (this$externalMACAddress == null ? other$externalMACAddress != null : !this$externalMACAddress.equals(other$externalMACAddress)) {
            return false;
        }
        Object this$hosts = this.getHosts();
        Object other$hosts = other.getHosts();
        if (this$hosts == null ? other$hosts != null : !this$hosts.equals(other$hosts)) {
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
        Object this$libvirtURI = this.getLibvirtURI();
        Object other$libvirtURI = other.getLibvirtURI();
        if (this$libvirtURI == null ? other$libvirtURI != null : !this$libvirtURI.equals(other$libvirtURI)) {
            return false;
        }
        Object this$loadBalancer = this.getLoadBalancer();
        Object other$loadBalancer = other.getLoadBalancer();
        if (this$loadBalancer == null ? other$loadBalancer != null : !this$loadBalancer.equals(other$loadBalancer)) {
            return false;
        }
        Object this$provisioningBridge = this.getProvisioningBridge();
        Object other$provisioningBridge = other.getProvisioningBridge();
        if (this$provisioningBridge == null ? other$provisioningBridge != null : !this$provisioningBridge.equals(other$provisioningBridge)) {
            return false;
        }
        Object this$provisioningDHCPExternal = this.getProvisioningDHCPExternal();
        Object other$provisioningDHCPExternal = other.getProvisioningDHCPExternal();
        if (this$provisioningDHCPExternal == null ? other$provisioningDHCPExternal != null : !this$provisioningDHCPExternal.equals(other$provisioningDHCPExternal)) {
            return false;
        }
        Object this$provisioningDHCPRange = this.getProvisioningDHCPRange();
        Object other$provisioningDHCPRange = other.getProvisioningDHCPRange();
        if (this$provisioningDHCPRange == null ? other$provisioningDHCPRange != null : !this$provisioningDHCPRange.equals(other$provisioningDHCPRange)) {
            return false;
        }
        Object this$provisioningHostIP = this.getProvisioningHostIP();
        Object other$provisioningHostIP = other.getProvisioningHostIP();
        if (this$provisioningHostIP == null ? other$provisioningHostIP != null : !this$provisioningHostIP.equals(other$provisioningHostIP)) {
            return false;
        }
        Object this$provisioningMACAddress = this.getProvisioningMACAddress();
        Object other$provisioningMACAddress = other.getProvisioningMACAddress();
        if (this$provisioningMACAddress == null ? other$provisioningMACAddress != null : !this$provisioningMACAddress.equals(other$provisioningMACAddress)) {
            return false;
        }
        Object this$provisioningNetwork = this.getProvisioningNetwork();
        Object other$provisioningNetwork = other.getProvisioningNetwork();
        if (this$provisioningNetwork == null ? other$provisioningNetwork != null : !this$provisioningNetwork.equals(other$provisioningNetwork)) {
            return false;
        }
        Object this$provisioningNetworkCIDR = this.getProvisioningNetworkCIDR();
        Object other$provisioningNetworkCIDR = other.getProvisioningNetworkCIDR();
        if (this$provisioningNetworkCIDR == null ? other$provisioningNetworkCIDR != null : !this$provisioningNetworkCIDR.equals(other$provisioningNetworkCIDR)) {
            return false;
        }
        Object this$provisioningNetworkInterface = this.getProvisioningNetworkInterface();
        Object other$provisioningNetworkInterface = other.getProvisioningNetworkInterface();
        if (this$provisioningNetworkInterface == null ? other$provisioningNetworkInterface != null : !this$provisioningNetworkInterface.equals(other$provisioningNetworkInterface)) {
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
        Object $additionalNTPServers = this.getAdditionalNTPServers();
        result = result * prime + ($additionalNTPServers == null ? 43 : $additionalNTPServers.hashCode());
        Object $apiVIP = this.getApiVIP();
        result = result * prime + ($apiVIP == null ? 43 : $apiVIP.hashCode());
        Object $apiVIPs = this.getApiVIPs();
        result = result * prime + ($apiVIPs == null ? 43 : $apiVIPs.hashCode());
        Object $bmcVerifyCA = this.getBmcVerifyCA();
        result = result * prime + ($bmcVerifyCA == null ? 43 : $bmcVerifyCA.hashCode());
        Object $bootstrapExternalStaticDNS = this.getBootstrapExternalStaticDNS();
        result = result * prime + ($bootstrapExternalStaticDNS == null ? 43 : $bootstrapExternalStaticDNS.hashCode());
        Object $bootstrapExternalStaticGateway = this.getBootstrapExternalStaticGateway();
        result = result * prime + ($bootstrapExternalStaticGateway == null ? 43 : $bootstrapExternalStaticGateway.hashCode());
        Object $bootstrapExternalStaticIP = this.getBootstrapExternalStaticIP();
        result = result * prime + ($bootstrapExternalStaticIP == null ? 43 : $bootstrapExternalStaticIP.hashCode());
        Object $bootstrapOSImage = this.getBootstrapOSImage();
        result = result * prime + ($bootstrapOSImage == null ? 43 : $bootstrapOSImage.hashCode());
        Object $bootstrapProvisioningIP = this.getBootstrapProvisioningIP();
        result = result * prime + ($bootstrapProvisioningIP == null ? 43 : $bootstrapProvisioningIP.hashCode());
        Object $clusterOSImage = this.getClusterOSImage();
        result = result * prime + ($clusterOSImage == null ? 43 : $clusterOSImage.hashCode());
        Object $clusterProvisioningIP = this.getClusterProvisioningIP();
        result = result * prime + ($clusterProvisioningIP == null ? 43 : $clusterProvisioningIP.hashCode());
        Object $defaultMachinePlatform = this.getDefaultMachinePlatform();
        result = result * prime + ($defaultMachinePlatform == null ? 43 : $defaultMachinePlatform.hashCode());
        Object $externalBridge = this.getExternalBridge();
        result = result * prime + ($externalBridge == null ? 43 : $externalBridge.hashCode());
        Object $externalMACAddress = this.getExternalMACAddress();
        result = result * prime + ($externalMACAddress == null ? 43 : $externalMACAddress.hashCode());
        Object $hosts = this.getHosts();
        result = result * prime + ($hosts == null ? 43 : $hosts.hashCode());
        Object $ingressVIP = this.getIngressVIP();
        result = result * prime + ($ingressVIP == null ? 43 : $ingressVIP.hashCode());
        Object $ingressVIPs = this.getIngressVIPs();
        result = result * prime + ($ingressVIPs == null ? 43 : $ingressVIPs.hashCode());
        Object $libvirtURI = this.getLibvirtURI();
        result = result * prime + ($libvirtURI == null ? 43 : $libvirtURI.hashCode());
        Object $loadBalancer = this.getLoadBalancer();
        result = result * prime + ($loadBalancer == null ? 43 : $loadBalancer.hashCode());
        Object $provisioningBridge = this.getProvisioningBridge();
        result = result * prime + ($provisioningBridge == null ? 43 : $provisioningBridge.hashCode());
        Object $provisioningDHCPExternal = this.getProvisioningDHCPExternal();
        result = result * prime + ($provisioningDHCPExternal == null ? 43 : $provisioningDHCPExternal.hashCode());
        Object $provisioningDHCPRange = this.getProvisioningDHCPRange();
        result = result * prime + ($provisioningDHCPRange == null ? 43 : $provisioningDHCPRange.hashCode());
        Object $provisioningHostIP = this.getProvisioningHostIP();
        result = result * prime + ($provisioningHostIP == null ? 43 : $provisioningHostIP.hashCode());
        Object $provisioningMACAddress = this.getProvisioningMACAddress();
        result = result * prime + ($provisioningMACAddress == null ? 43 : $provisioningMACAddress.hashCode());
        Object $provisioningNetwork = this.getProvisioningNetwork();
        result = result * prime + ($provisioningNetwork == null ? 43 : $provisioningNetwork.hashCode());
        Object $provisioningNetworkCIDR = this.getProvisioningNetworkCIDR();
        result = result * prime + ($provisioningNetworkCIDR == null ? 43 : $provisioningNetworkCIDR.hashCode());
        Object $provisioningNetworkInterface = this.getProvisioningNetworkInterface();
        result = result * prime + ($provisioningNetworkInterface == null ? 43 : $provisioningNetworkInterface.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Platform(" + "additionalNTPServers=" + this.getAdditionalNTPServers() + ", apiVIP=" + this.getApiVIP() + ", apiVIPs=" + this.getApiVIPs() + ", bmcVerifyCA=" + this.getBmcVerifyCA() + ", bootstrapExternalStaticDNS=" + this.getBootstrapExternalStaticDNS() + ", bootstrapExternalStaticGateway=" + this.getBootstrapExternalStaticGateway() + ", bootstrapExternalStaticIP=" + this.getBootstrapExternalStaticIP() + ", bootstrapOSImage=" + this.getBootstrapOSImage() + ", bootstrapProvisioningIP=" + this.getBootstrapProvisioningIP() + ", clusterOSImage=" + this.getClusterOSImage() + ", clusterProvisioningIP=" + this.getClusterProvisioningIP() + ", defaultMachinePlatform=" + this.getDefaultMachinePlatform() + ", externalBridge=" + this.getExternalBridge() + ", externalMACAddress=" + this.getExternalMACAddress() + ", hosts=" + this.getHosts() + ", ingressVIP=" + this.getIngressVIP() + ", ingressVIPs=" + this.getIngressVIPs() + ", libvirtURI=" + this.getLibvirtURI() + ", loadBalancer=" + this.getLoadBalancer() + ", provisioningBridge=" + this.getProvisioningBridge() + ", provisioningDHCPExternal=" + this.getProvisioningDHCPExternal() + ", provisioningDHCPRange=" + this.getProvisioningDHCPRange() + ", provisioningHostIP=" + this.getProvisioningHostIP() + ", provisioningMACAddress=" + this.getProvisioningMACAddress() + ", provisioningNetwork=" + this.getProvisioningNetwork() + ", provisioningNetworkCIDR=" + this.getProvisioningNetworkCIDR() + ", provisioningNetworkInterface=" + this.getProvisioningNetworkInterface() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
