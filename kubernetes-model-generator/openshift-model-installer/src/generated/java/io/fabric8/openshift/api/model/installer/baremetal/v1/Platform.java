
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Platform stores all the global configuration that all machinesets use.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVIP",
    "apiVIPs",
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
public class Platform implements Editable<PlatformBuilder>, KubernetesResource
{

    @JsonProperty("apiVIP")
    private String apiVIP;
    @JsonProperty("apiVIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> apiVIPs = new ArrayList<>();
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

    public Platform(String apiVIP, List<String> apiVIPs, String bootstrapExternalStaticDNS, String bootstrapExternalStaticGateway, String bootstrapExternalStaticIP, String bootstrapOSImage, String bootstrapProvisioningIP, String clusterOSImage, String clusterProvisioningIP, MachinePool defaultMachinePlatform, String externalBridge, String externalMACAddress, List<Host> hosts, String ingressVIP, List<String> ingressVIPs, String libvirtURI, BareMetalPlatformLoadBalancer loadBalancer, String provisioningBridge, Boolean provisioningDHCPExternal, String provisioningDHCPRange, String provisioningHostIP, String provisioningMACAddress, String provisioningNetwork, String provisioningNetworkCIDR, String provisioningNetworkInterface) {
        super();
        this.apiVIP = apiVIP;
        this.apiVIPs = apiVIPs;
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
