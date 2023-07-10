
package io.fabric8.openshift.api.model.installer.openstack.v1;

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
import io.fabric8.openshift.api.model.config.v1.OpenStackPlatformLoadBalancer;
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
    "apiFloatingIP",
    "apiVIP",
    "apiVIPs",
    "cloud",
    "clusterOSImage",
    "clusterOSImageProperties",
    "computeFlavor",
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

    @JsonProperty("apiFloatingIP")
    private java.lang.String apiFloatingIP;
    @JsonProperty("apiVIP")
    private java.lang.String apiVIP;
    @JsonProperty("apiVIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> apiVIPs = new ArrayList<java.lang.String>();
    @JsonProperty("cloud")
    private java.lang.String cloud;
    @JsonProperty("clusterOSImage")
    private java.lang.String clusterOSImage;
    @JsonProperty("clusterOSImageProperties")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> clusterOSImageProperties = new LinkedHashMap<String, String>();
    @JsonProperty("computeFlavor")
    private java.lang.String computeFlavor;
    @JsonProperty("defaultMachinePlatform")
    private MachinePool defaultMachinePlatform;
    @JsonProperty("externalDNS")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> externalDNS = new ArrayList<java.lang.String>();
    @JsonProperty("externalNetwork")
    private java.lang.String externalNetwork;
    @JsonProperty("ingressFloatingIP")
    private java.lang.String ingressFloatingIP;
    @JsonProperty("ingressVIP")
    private java.lang.String ingressVIP;
    @JsonProperty("ingressVIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> ingressVIPs = new ArrayList<java.lang.String>();
    @JsonProperty("lbFloatingIP")
    private java.lang.String lbFloatingIP;
    @JsonProperty("loadBalancer")
    private OpenStackPlatformLoadBalancer loadBalancer;
    @JsonProperty("machinesSubnet")
    private java.lang.String machinesSubnet;
    @JsonProperty("octaviaSupport")
    private java.lang.String octaviaSupport;
    @JsonProperty("region")
    private java.lang.String region;
    @JsonProperty("trunkSupport")
    private java.lang.String trunkSupport;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Platform() {
    }

    public Platform(java.lang.String apiFloatingIP, java.lang.String apiVIP, List<java.lang.String> apiVIPs, java.lang.String cloud, java.lang.String clusterOSImage, Map<String, String> clusterOSImageProperties, java.lang.String computeFlavor, MachinePool defaultMachinePlatform, List<java.lang.String> externalDNS, java.lang.String externalNetwork, java.lang.String ingressFloatingIP, java.lang.String ingressVIP, List<java.lang.String> ingressVIPs, java.lang.String lbFloatingIP, OpenStackPlatformLoadBalancer loadBalancer, java.lang.String machinesSubnet, java.lang.String octaviaSupport, java.lang.String region, java.lang.String trunkSupport) {
        super();
        this.apiFloatingIP = apiFloatingIP;
        this.apiVIP = apiVIP;
        this.apiVIPs = apiVIPs;
        this.cloud = cloud;
        this.clusterOSImage = clusterOSImage;
        this.clusterOSImageProperties = clusterOSImageProperties;
        this.computeFlavor = computeFlavor;
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

    @JsonProperty("apiFloatingIP")
    public java.lang.String getApiFloatingIP() {
        return apiFloatingIP;
    }

    @JsonProperty("apiFloatingIP")
    public void setApiFloatingIP(java.lang.String apiFloatingIP) {
        this.apiFloatingIP = apiFloatingIP;
    }

    @JsonProperty("apiVIP")
    public java.lang.String getApiVIP() {
        return apiVIP;
    }

    @JsonProperty("apiVIP")
    public void setApiVIP(java.lang.String apiVIP) {
        this.apiVIP = apiVIP;
    }

    @JsonProperty("apiVIPs")
    public List<java.lang.String> getApiVIPs() {
        return apiVIPs;
    }

    @JsonProperty("apiVIPs")
    public void setApiVIPs(List<java.lang.String> apiVIPs) {
        this.apiVIPs = apiVIPs;
    }

    @JsonProperty("cloud")
    public java.lang.String getCloud() {
        return cloud;
    }

    @JsonProperty("cloud")
    public void setCloud(java.lang.String cloud) {
        this.cloud = cloud;
    }

    @JsonProperty("clusterOSImage")
    public java.lang.String getClusterOSImage() {
        return clusterOSImage;
    }

    @JsonProperty("clusterOSImage")
    public void setClusterOSImage(java.lang.String clusterOSImage) {
        this.clusterOSImage = clusterOSImage;
    }

    @JsonProperty("clusterOSImageProperties")
    public Map<String, String> getClusterOSImageProperties() {
        return clusterOSImageProperties;
    }

    @JsonProperty("clusterOSImageProperties")
    public void setClusterOSImageProperties(Map<String, String> clusterOSImageProperties) {
        this.clusterOSImageProperties = clusterOSImageProperties;
    }

    @JsonProperty("computeFlavor")
    public java.lang.String getComputeFlavor() {
        return computeFlavor;
    }

    @JsonProperty("computeFlavor")
    public void setComputeFlavor(java.lang.String computeFlavor) {
        this.computeFlavor = computeFlavor;
    }

    @JsonProperty("defaultMachinePlatform")
    public MachinePool getDefaultMachinePlatform() {
        return defaultMachinePlatform;
    }

    @JsonProperty("defaultMachinePlatform")
    public void setDefaultMachinePlatform(MachinePool defaultMachinePlatform) {
        this.defaultMachinePlatform = defaultMachinePlatform;
    }

    @JsonProperty("externalDNS")
    public List<java.lang.String> getExternalDNS() {
        return externalDNS;
    }

    @JsonProperty("externalDNS")
    public void setExternalDNS(List<java.lang.String> externalDNS) {
        this.externalDNS = externalDNS;
    }

    @JsonProperty("externalNetwork")
    public java.lang.String getExternalNetwork() {
        return externalNetwork;
    }

    @JsonProperty("externalNetwork")
    public void setExternalNetwork(java.lang.String externalNetwork) {
        this.externalNetwork = externalNetwork;
    }

    @JsonProperty("ingressFloatingIP")
    public java.lang.String getIngressFloatingIP() {
        return ingressFloatingIP;
    }

    @JsonProperty("ingressFloatingIP")
    public void setIngressFloatingIP(java.lang.String ingressFloatingIP) {
        this.ingressFloatingIP = ingressFloatingIP;
    }

    @JsonProperty("ingressVIP")
    public java.lang.String getIngressVIP() {
        return ingressVIP;
    }

    @JsonProperty("ingressVIP")
    public void setIngressVIP(java.lang.String ingressVIP) {
        this.ingressVIP = ingressVIP;
    }

    @JsonProperty("ingressVIPs")
    public List<java.lang.String> getIngressVIPs() {
        return ingressVIPs;
    }

    @JsonProperty("ingressVIPs")
    public void setIngressVIPs(List<java.lang.String> ingressVIPs) {
        this.ingressVIPs = ingressVIPs;
    }

    @JsonProperty("lbFloatingIP")
    public java.lang.String getLbFloatingIP() {
        return lbFloatingIP;
    }

    @JsonProperty("lbFloatingIP")
    public void setLbFloatingIP(java.lang.String lbFloatingIP) {
        this.lbFloatingIP = lbFloatingIP;
    }

    @JsonProperty("loadBalancer")
    public OpenStackPlatformLoadBalancer getLoadBalancer() {
        return loadBalancer;
    }

    @JsonProperty("loadBalancer")
    public void setLoadBalancer(OpenStackPlatformLoadBalancer loadBalancer) {
        this.loadBalancer = loadBalancer;
    }

    @JsonProperty("machinesSubnet")
    public java.lang.String getMachinesSubnet() {
        return machinesSubnet;
    }

    @JsonProperty("machinesSubnet")
    public void setMachinesSubnet(java.lang.String machinesSubnet) {
        this.machinesSubnet = machinesSubnet;
    }

    @JsonProperty("octaviaSupport")
    public java.lang.String getOctaviaSupport() {
        return octaviaSupport;
    }

    @JsonProperty("octaviaSupport")
    public void setOctaviaSupport(java.lang.String octaviaSupport) {
        this.octaviaSupport = octaviaSupport;
    }

    @JsonProperty("region")
    public java.lang.String getRegion() {
        return region;
    }

    @JsonProperty("region")
    public void setRegion(java.lang.String region) {
        this.region = region;
    }

    @JsonProperty("trunkSupport")
    public java.lang.String getTrunkSupport() {
        return trunkSupport;
    }

    @JsonProperty("trunkSupport")
    public void setTrunkSupport(java.lang.String trunkSupport) {
        this.trunkSupport = trunkSupport;
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
