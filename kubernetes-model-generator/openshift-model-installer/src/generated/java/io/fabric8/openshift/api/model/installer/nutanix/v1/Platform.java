
package io.fabric8.openshift.api.model.installer.nutanix.v1;

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
import io.fabric8.openshift.api.model.config.v1.NutanixPlatformLoadBalancer;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Platform stores any global configuration used for Nutanix platforms.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVIP",
    "apiVIPs",
    "clusterOSImage",
    "defaultMachinePlatform",
    "failureDomains",
    "ingressVIP",
    "ingressVIPs",
    "loadBalancer",
    "prismCentral",
    "prismElements",
    "subnetUUIDs"
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
    @JsonProperty("clusterOSImage")
    private String clusterOSImage;
    @JsonProperty("defaultMachinePlatform")
    private MachinePool defaultMachinePlatform;
    @JsonProperty("failureDomains")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<FailureDomain> failureDomains = new ArrayList<>();
    @JsonProperty("ingressVIP")
    private String ingressVIP;
    @JsonProperty("ingressVIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> ingressVIPs = new ArrayList<>();
    @JsonProperty("loadBalancer")
    private NutanixPlatformLoadBalancer loadBalancer;
    @JsonProperty("prismCentral")
    private PrismCentral prismCentral;
    @JsonProperty("prismElements")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PrismElement> prismElements = new ArrayList<>();
    @JsonProperty("subnetUUIDs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> subnetUUIDs = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Platform() {
    }

    public Platform(String apiVIP, List<String> apiVIPs, String clusterOSImage, MachinePool defaultMachinePlatform, List<FailureDomain> failureDomains, String ingressVIP, List<String> ingressVIPs, NutanixPlatformLoadBalancer loadBalancer, PrismCentral prismCentral, List<PrismElement> prismElements, List<String> subnetUUIDs) {
        super();
        this.apiVIP = apiVIP;
        this.apiVIPs = apiVIPs;
        this.clusterOSImage = clusterOSImage;
        this.defaultMachinePlatform = defaultMachinePlatform;
        this.failureDomains = failureDomains;
        this.ingressVIP = ingressVIP;
        this.ingressVIPs = ingressVIPs;
        this.loadBalancer = loadBalancer;
        this.prismCentral = prismCentral;
        this.prismElements = prismElements;
        this.subnetUUIDs = subnetUUIDs;
    }

    /**
     * DeprecatedAPIVIP is the virtual IP address for the api endpoint Deprecated: use APIVIPs
     */
    @JsonProperty("apiVIP")
    public String getApiVIP() {
        return apiVIP;
    }

    /**
     * DeprecatedAPIVIP is the virtual IP address for the api endpoint Deprecated: use APIVIPs
     */
    @JsonProperty("apiVIP")
    public void setApiVIP(String apiVIP) {
        this.apiVIP = apiVIP;
    }

    /**
     * APIVIPs contains the VIP(s) for the api endpoint. In dual stack clusters it contains an IPv4 and IPv6 address, otherwise only one VIP
     */
    @JsonProperty("apiVIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getApiVIPs() {
        return apiVIPs;
    }

    /**
     * APIVIPs contains the VIP(s) for the api endpoint. In dual stack clusters it contains an IPv4 and IPv6 address, otherwise only one VIP
     */
    @JsonProperty("apiVIPs")
    public void setApiVIPs(List<String> apiVIPs) {
        this.apiVIPs = apiVIPs;
    }

    /**
     * ClusterOSImage overrides the url provided in rhcos.json to download the RHCOS Image.
     */
    @JsonProperty("clusterOSImage")
    public String getClusterOSImage() {
        return clusterOSImage;
    }

    /**
     * ClusterOSImage overrides the url provided in rhcos.json to download the RHCOS Image.
     */
    @JsonProperty("clusterOSImage")
    public void setClusterOSImage(String clusterOSImage) {
        this.clusterOSImage = clusterOSImage;
    }

    /**
     * Platform stores any global configuration used for Nutanix platforms.
     */
    @JsonProperty("defaultMachinePlatform")
    public MachinePool getDefaultMachinePlatform() {
        return defaultMachinePlatform;
    }

    /**
     * Platform stores any global configuration used for Nutanix platforms.
     */
    @JsonProperty("defaultMachinePlatform")
    public void setDefaultMachinePlatform(MachinePool defaultMachinePlatform) {
        this.defaultMachinePlatform = defaultMachinePlatform;
    }

    /**
     * FailureDomains configures failure domains for the Nutanix platform.
     */
    @JsonProperty("failureDomains")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<FailureDomain> getFailureDomains() {
        return failureDomains;
    }

    /**
     * FailureDomains configures failure domains for the Nutanix platform.
     */
    @JsonProperty("failureDomains")
    public void setFailureDomains(List<FailureDomain> failureDomains) {
        this.failureDomains = failureDomains;
    }

    /**
     * DeprecatedIngressVIP is the virtual IP address for ingress Deprecated: use IngressVIPs
     */
    @JsonProperty("ingressVIP")
    public String getIngressVIP() {
        return ingressVIP;
    }

    /**
     * DeprecatedIngressVIP is the virtual IP address for ingress Deprecated: use IngressVIPs
     */
    @JsonProperty("ingressVIP")
    public void setIngressVIP(String ingressVIP) {
        this.ingressVIP = ingressVIP;
    }

    /**
     * IngressVIPs contains the VIP(s) for ingress. In dual stack clusters it contains an IPv4 and IPv6 address, otherwise only one VIP
     */
    @JsonProperty("ingressVIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getIngressVIPs() {
        return ingressVIPs;
    }

    /**
     * IngressVIPs contains the VIP(s) for ingress. In dual stack clusters it contains an IPv4 and IPv6 address, otherwise only one VIP
     */
    @JsonProperty("ingressVIPs")
    public void setIngressVIPs(List<String> ingressVIPs) {
        this.ingressVIPs = ingressVIPs;
    }

    /**
     * Platform stores any global configuration used for Nutanix platforms.
     */
    @JsonProperty("loadBalancer")
    public NutanixPlatformLoadBalancer getLoadBalancer() {
        return loadBalancer;
    }

    /**
     * Platform stores any global configuration used for Nutanix platforms.
     */
    @JsonProperty("loadBalancer")
    public void setLoadBalancer(NutanixPlatformLoadBalancer loadBalancer) {
        this.loadBalancer = loadBalancer;
    }

    /**
     * Platform stores any global configuration used for Nutanix platforms.
     */
    @JsonProperty("prismCentral")
    public PrismCentral getPrismCentral() {
        return prismCentral;
    }

    /**
     * Platform stores any global configuration used for Nutanix platforms.
     */
    @JsonProperty("prismCentral")
    public void setPrismCentral(PrismCentral prismCentral) {
        this.prismCentral = prismCentral;
    }

    /**
     * PrismElements holds a list of Prism Elements (clusters). A Prism Element encompasses all Nutanix resources (VMs, subnets, etc.) used to host the OpenShift cluster. Currently only a single Prism Element may be defined. This serves as the default Prism-Element.
     */
    @JsonProperty("prismElements")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PrismElement> getPrismElements() {
        return prismElements;
    }

    /**
     * PrismElements holds a list of Prism Elements (clusters). A Prism Element encompasses all Nutanix resources (VMs, subnets, etc.) used to host the OpenShift cluster. Currently only a single Prism Element may be defined. This serves as the default Prism-Element.
     */
    @JsonProperty("prismElements")
    public void setPrismElements(List<PrismElement> prismElements) {
        this.prismElements = prismElements;
    }

    /**
     * SubnetUUIDs identifies the network subnets to be used by the cluster. Currently we only support one subnet for an OpenShift cluster.
     */
    @JsonProperty("subnetUUIDs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getSubnetUUIDs() {
        return subnetUUIDs;
    }

    /**
     * SubnetUUIDs identifies the network subnets to be used by the cluster. Currently we only support one subnet for an OpenShift cluster.
     */
    @JsonProperty("subnetUUIDs")
    public void setSubnetUUIDs(List<String> subnetUUIDs) {
        this.subnetUUIDs = subnetUUIDs;
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
