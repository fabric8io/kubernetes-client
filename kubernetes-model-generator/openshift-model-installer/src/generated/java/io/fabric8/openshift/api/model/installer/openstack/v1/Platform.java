
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
import io.fabric8.kubernetes.api.builder.Editable;
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
public class Platform implements Editable<PlatformBuilder> , KubernetesResource
{

    @JsonProperty("apiFloatingIP")
    private String apiFloatingIP;
    @JsonProperty("apiVIP")
    private String apiVIP;
    @JsonProperty("apiVIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> apiVIPs = new ArrayList<String>();
    @JsonProperty("cloud")
    private String cloud;
    @JsonProperty("clusterOSImage")
    private String clusterOSImage;
    @JsonProperty("clusterOSImageProperties")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> clusterOSImageProperties = new LinkedHashMap<String, String>();
    @JsonProperty("computeFlavor")
    private String computeFlavor;
    @JsonProperty("defaultMachinePlatform")
    private MachinePool defaultMachinePlatform;
    @JsonProperty("externalDNS")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> externalDNS = new ArrayList<String>();
    @JsonProperty("externalNetwork")
    private String externalNetwork;
    @JsonProperty("ingressFloatingIP")
    private String ingressFloatingIP;
    @JsonProperty("ingressVIP")
    private String ingressVIP;
    @JsonProperty("ingressVIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> ingressVIPs = new ArrayList<String>();
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
     * 
     */
    public Platform() {
    }

    public Platform(String apiFloatingIP, String apiVIP, List<String> apiVIPs, String cloud, String clusterOSImage, Map<String, String> clusterOSImageProperties, String computeFlavor, MachinePool defaultMachinePlatform, List<String> externalDNS, String externalNetwork, String ingressFloatingIP, String ingressVIP, List<String> ingressVIPs, String lbFloatingIP, OpenStackPlatformLoadBalancer loadBalancer, String machinesSubnet, String octaviaSupport, String region, String trunkSupport) {
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
    public String getApiFloatingIP() {
        return apiFloatingIP;
    }

    @JsonProperty("apiFloatingIP")
    public void setApiFloatingIP(String apiFloatingIP) {
        this.apiFloatingIP = apiFloatingIP;
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getApiVIPs() {
        return apiVIPs;
    }

    @JsonProperty("apiVIPs")
    public void setApiVIPs(List<String> apiVIPs) {
        this.apiVIPs = apiVIPs;
    }

    @JsonProperty("cloud")
    public String getCloud() {
        return cloud;
    }

    @JsonProperty("cloud")
    public void setCloud(String cloud) {
        this.cloud = cloud;
    }

    @JsonProperty("clusterOSImage")
    public String getClusterOSImage() {
        return clusterOSImage;
    }

    @JsonProperty("clusterOSImage")
    public void setClusterOSImage(String clusterOSImage) {
        this.clusterOSImage = clusterOSImage;
    }

    @JsonProperty("clusterOSImageProperties")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getClusterOSImageProperties() {
        return clusterOSImageProperties;
    }

    @JsonProperty("clusterOSImageProperties")
    public void setClusterOSImageProperties(Map<String, String> clusterOSImageProperties) {
        this.clusterOSImageProperties = clusterOSImageProperties;
    }

    @JsonProperty("computeFlavor")
    public String getComputeFlavor() {
        return computeFlavor;
    }

    @JsonProperty("computeFlavor")
    public void setComputeFlavor(String computeFlavor) {
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getExternalDNS() {
        return externalDNS;
    }

    @JsonProperty("externalDNS")
    public void setExternalDNS(List<String> externalDNS) {
        this.externalDNS = externalDNS;
    }

    @JsonProperty("externalNetwork")
    public String getExternalNetwork() {
        return externalNetwork;
    }

    @JsonProperty("externalNetwork")
    public void setExternalNetwork(String externalNetwork) {
        this.externalNetwork = externalNetwork;
    }

    @JsonProperty("ingressFloatingIP")
    public String getIngressFloatingIP() {
        return ingressFloatingIP;
    }

    @JsonProperty("ingressFloatingIP")
    public void setIngressFloatingIP(String ingressFloatingIP) {
        this.ingressFloatingIP = ingressFloatingIP;
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getIngressVIPs() {
        return ingressVIPs;
    }

    @JsonProperty("ingressVIPs")
    public void setIngressVIPs(List<String> ingressVIPs) {
        this.ingressVIPs = ingressVIPs;
    }

    @JsonProperty("lbFloatingIP")
    public String getLbFloatingIP() {
        return lbFloatingIP;
    }

    @JsonProperty("lbFloatingIP")
    public void setLbFloatingIP(String lbFloatingIP) {
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
    public String getMachinesSubnet() {
        return machinesSubnet;
    }

    @JsonProperty("machinesSubnet")
    public void setMachinesSubnet(String machinesSubnet) {
        this.machinesSubnet = machinesSubnet;
    }

    @JsonProperty("octaviaSupport")
    public String getOctaviaSupport() {
        return octaviaSupport;
    }

    @JsonProperty("octaviaSupport")
    public void setOctaviaSupport(String octaviaSupport) {
        this.octaviaSupport = octaviaSupport;
    }

    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    @JsonProperty("trunkSupport")
    public String getTrunkSupport() {
        return trunkSupport;
    }

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
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
