
package io.fabric8.openshift.api.model.installer.powervc.v1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Platform stores all the global configuration that all machinesets use.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiFloatingIP",
    "apiVIPs",
    "cloud",
    "clusterOSImage",
    "clusterOSImageProperties",
    "controlPlanePort",
    "defaultMachinePlatform",
    "externalDNS",
    "externalNetwork",
    "imageName",
    "ingressFloatingIP",
    "ingressVIPs",
    "loadBalancer"
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

    @JsonProperty("apiFloatingIP")
    private String apiFloatingIP;
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
    @JsonProperty("controlPlanePort")
    private PortTarget controlPlanePort;
    @JsonProperty("defaultMachinePlatform")
    private MachinePool defaultMachinePlatform;
    @JsonProperty("externalDNS")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> externalDNS = new ArrayList<>();
    @JsonProperty("externalNetwork")
    private String externalNetwork;
    @JsonProperty("imageName")
    private String imageName;
    @JsonProperty("ingressFloatingIP")
    private String ingressFloatingIP;
    @JsonProperty("ingressVIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> ingressVIPs = new ArrayList<>();
    @JsonProperty("loadBalancer")
    private OpenStackPlatformLoadBalancer loadBalancer;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Platform() {
    }

    public Platform(String apiFloatingIP, List<String> apiVIPs, String cloud, String clusterOSImage, Map<String, String> clusterOSImageProperties, PortTarget controlPlanePort, MachinePool defaultMachinePlatform, List<String> externalDNS, String externalNetwork, String imageName, String ingressFloatingIP, List<String> ingressVIPs, OpenStackPlatformLoadBalancer loadBalancer) {
        super();
        this.apiFloatingIP = apiFloatingIP;
        this.apiVIPs = apiVIPs;
        this.cloud = cloud;
        this.clusterOSImage = clusterOSImage;
        this.clusterOSImageProperties = clusterOSImageProperties;
        this.controlPlanePort = controlPlanePort;
        this.defaultMachinePlatform = defaultMachinePlatform;
        this.externalDNS = externalDNS;
        this.externalNetwork = externalNetwork;
        this.imageName = imageName;
        this.ingressFloatingIP = ingressFloatingIP;
        this.ingressVIPs = ingressVIPs;
        this.loadBalancer = loadBalancer;
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
     * Platform stores all the global configuration that all machinesets use.
     */
    @JsonProperty("imageName")
    public String getImageName() {
        return imageName;
    }

    /**
     * Platform stores all the global configuration that all machinesets use.
     */
    @JsonProperty("imageName")
    public void setImageName(String imageName) {
        this.imageName = imageName;
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

}
