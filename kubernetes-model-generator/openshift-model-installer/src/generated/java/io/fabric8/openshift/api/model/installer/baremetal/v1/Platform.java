
package io.fabric8.openshift.api.model.installer.baremetal.v1;

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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.openshift.api.model.config.v1.BareMetalPlatformLoadBalancer;
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
    "apiVIP",
    "apiVIPs",
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
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class Platform implements KubernetesResource
{

    @JsonProperty("apiVIP")
    private String apiVIP;
    @JsonProperty("apiVIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> apiVIPs = new ArrayList<String>();
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
    private List<Host> hosts = new ArrayList<Host>();
    @JsonProperty("ingressVIP")
    private String ingressVIP;
    @JsonProperty("ingressVIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> ingressVIPs = new ArrayList<String>();
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
     * 
     */
    public Platform() {
    }

    public Platform(String apiVIP, List<String> apiVIPs, String bootstrapExternalStaticGateway, String bootstrapExternalStaticIP, String bootstrapOSImage, String bootstrapProvisioningIP, String clusterOSImage, String clusterProvisioningIP, MachinePool defaultMachinePlatform, String externalBridge, String externalMACAddress, List<Host> hosts, String ingressVIP, List<String> ingressVIPs, String libvirtURI, BareMetalPlatformLoadBalancer loadBalancer, String provisioningBridge, Boolean provisioningDHCPExternal, String provisioningDHCPRange, String provisioningHostIP, String provisioningMACAddress, String provisioningNetwork, String provisioningNetworkCIDR, String provisioningNetworkInterface) {
        super();
        this.apiVIP = apiVIP;
        this.apiVIPs = apiVIPs;
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

    @JsonProperty("apiVIP")
    public String getApiVIP() {
        return apiVIP;
    }

    @JsonProperty("apiVIP")
    public void setApiVIP(String apiVIP) {
        this.apiVIP = apiVIP;
    }

    @JsonProperty("apiVIPs")
    public List<String> getApiVIPs() {
        return apiVIPs;
    }

    @JsonProperty("apiVIPs")
    public void setApiVIPs(List<String> apiVIPs) {
        this.apiVIPs = apiVIPs;
    }

    @JsonProperty("bootstrapExternalStaticGateway")
    public String getBootstrapExternalStaticGateway() {
        return bootstrapExternalStaticGateway;
    }

    @JsonProperty("bootstrapExternalStaticGateway")
    public void setBootstrapExternalStaticGateway(String bootstrapExternalStaticGateway) {
        this.bootstrapExternalStaticGateway = bootstrapExternalStaticGateway;
    }

    @JsonProperty("bootstrapExternalStaticIP")
    public String getBootstrapExternalStaticIP() {
        return bootstrapExternalStaticIP;
    }

    @JsonProperty("bootstrapExternalStaticIP")
    public void setBootstrapExternalStaticIP(String bootstrapExternalStaticIP) {
        this.bootstrapExternalStaticIP = bootstrapExternalStaticIP;
    }

    @JsonProperty("bootstrapOSImage")
    public String getBootstrapOSImage() {
        return bootstrapOSImage;
    }

    @JsonProperty("bootstrapOSImage")
    public void setBootstrapOSImage(String bootstrapOSImage) {
        this.bootstrapOSImage = bootstrapOSImage;
    }

    @JsonProperty("bootstrapProvisioningIP")
    public String getBootstrapProvisioningIP() {
        return bootstrapProvisioningIP;
    }

    @JsonProperty("bootstrapProvisioningIP")
    public void setBootstrapProvisioningIP(String bootstrapProvisioningIP) {
        this.bootstrapProvisioningIP = bootstrapProvisioningIP;
    }

    @JsonProperty("clusterOSImage")
    public String getClusterOSImage() {
        return clusterOSImage;
    }

    @JsonProperty("clusterOSImage")
    public void setClusterOSImage(String clusterOSImage) {
        this.clusterOSImage = clusterOSImage;
    }

    @JsonProperty("clusterProvisioningIP")
    public String getClusterProvisioningIP() {
        return clusterProvisioningIP;
    }

    @JsonProperty("clusterProvisioningIP")
    public void setClusterProvisioningIP(String clusterProvisioningIP) {
        this.clusterProvisioningIP = clusterProvisioningIP;
    }

    @JsonProperty("defaultMachinePlatform")
    public MachinePool getDefaultMachinePlatform() {
        return defaultMachinePlatform;
    }

    @JsonProperty("defaultMachinePlatform")
    public void setDefaultMachinePlatform(MachinePool defaultMachinePlatform) {
        this.defaultMachinePlatform = defaultMachinePlatform;
    }

    @JsonProperty("externalBridge")
    public String getExternalBridge() {
        return externalBridge;
    }

    @JsonProperty("externalBridge")
    public void setExternalBridge(String externalBridge) {
        this.externalBridge = externalBridge;
    }

    @JsonProperty("externalMACAddress")
    public String getExternalMACAddress() {
        return externalMACAddress;
    }

    @JsonProperty("externalMACAddress")
    public void setExternalMACAddress(String externalMACAddress) {
        this.externalMACAddress = externalMACAddress;
    }

    @JsonProperty("hosts")
    public List<Host> getHosts() {
        return hosts;
    }

    @JsonProperty("hosts")
    public void setHosts(List<Host> hosts) {
        this.hosts = hosts;
    }

    @JsonProperty("ingressVIP")
    public String getIngressVIP() {
        return ingressVIP;
    }

    @JsonProperty("ingressVIP")
    public void setIngressVIP(String ingressVIP) {
        this.ingressVIP = ingressVIP;
    }

    @JsonProperty("ingressVIPs")
    public List<String> getIngressVIPs() {
        return ingressVIPs;
    }

    @JsonProperty("ingressVIPs")
    public void setIngressVIPs(List<String> ingressVIPs) {
        this.ingressVIPs = ingressVIPs;
    }

    @JsonProperty("libvirtURI")
    public String getLibvirtURI() {
        return libvirtURI;
    }

    @JsonProperty("libvirtURI")
    public void setLibvirtURI(String libvirtURI) {
        this.libvirtURI = libvirtURI;
    }

    @JsonProperty("loadBalancer")
    public BareMetalPlatformLoadBalancer getLoadBalancer() {
        return loadBalancer;
    }

    @JsonProperty("loadBalancer")
    public void setLoadBalancer(BareMetalPlatformLoadBalancer loadBalancer) {
        this.loadBalancer = loadBalancer;
    }

    @JsonProperty("provisioningBridge")
    public String getProvisioningBridge() {
        return provisioningBridge;
    }

    @JsonProperty("provisioningBridge")
    public void setProvisioningBridge(String provisioningBridge) {
        this.provisioningBridge = provisioningBridge;
    }

    @JsonProperty("provisioningDHCPExternal")
    public Boolean getProvisioningDHCPExternal() {
        return provisioningDHCPExternal;
    }

    @JsonProperty("provisioningDHCPExternal")
    public void setProvisioningDHCPExternal(Boolean provisioningDHCPExternal) {
        this.provisioningDHCPExternal = provisioningDHCPExternal;
    }

    @JsonProperty("provisioningDHCPRange")
    public String getProvisioningDHCPRange() {
        return provisioningDHCPRange;
    }

    @JsonProperty("provisioningDHCPRange")
    public void setProvisioningDHCPRange(String provisioningDHCPRange) {
        this.provisioningDHCPRange = provisioningDHCPRange;
    }

    @JsonProperty("provisioningHostIP")
    public String getProvisioningHostIP() {
        return provisioningHostIP;
    }

    @JsonProperty("provisioningHostIP")
    public void setProvisioningHostIP(String provisioningHostIP) {
        this.provisioningHostIP = provisioningHostIP;
    }

    @JsonProperty("provisioningMACAddress")
    public String getProvisioningMACAddress() {
        return provisioningMACAddress;
    }

    @JsonProperty("provisioningMACAddress")
    public void setProvisioningMACAddress(String provisioningMACAddress) {
        this.provisioningMACAddress = provisioningMACAddress;
    }

    @JsonProperty("provisioningNetwork")
    public String getProvisioningNetwork() {
        return provisioningNetwork;
    }

    @JsonProperty("provisioningNetwork")
    public void setProvisioningNetwork(String provisioningNetwork) {
        this.provisioningNetwork = provisioningNetwork;
    }

    @JsonProperty("provisioningNetworkCIDR")
    public String getProvisioningNetworkCIDR() {
        return provisioningNetworkCIDR;
    }

    @JsonProperty("provisioningNetworkCIDR")
    public void setProvisioningNetworkCIDR(String provisioningNetworkCIDR) {
        this.provisioningNetworkCIDR = provisioningNetworkCIDR;
    }

    @JsonProperty("provisioningNetworkInterface")
    public String getProvisioningNetworkInterface() {
        return provisioningNetworkInterface;
    }

    @JsonProperty("provisioningNetworkInterface")
    public void setProvisioningNetworkInterface(String provisioningNetworkInterface) {
        this.provisioningNetworkInterface = provisioningNetworkInterface;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
