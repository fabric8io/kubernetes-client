
package io.fabric8.openshift.api.model.installer.nutanix.v1;

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
import io.fabric8.openshift.api.model.config.v1.NutanixPlatformLoadBalancer;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

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
    "preloadedOSImageName",
    "prismAPICallTimeout",
    "prismCentral",
    "prismElements",
    "subnetUUIDs"
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
    @JsonProperty("preloadedOSImageName")
    private String preloadedOSImageName;
    @JsonProperty("prismAPICallTimeout")
    private Integer prismAPICallTimeout;
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

    public Platform(String apiVIP, List<String> apiVIPs, String clusterOSImage, MachinePool defaultMachinePlatform, List<FailureDomain> failureDomains, String ingressVIP, List<String> ingressVIPs, NutanixPlatformLoadBalancer loadBalancer, String preloadedOSImageName, Integer prismAPICallTimeout, PrismCentral prismCentral, List<PrismElement> prismElements, List<String> subnetUUIDs) {
        super();
        this.apiVIP = apiVIP;
        this.apiVIPs = apiVIPs;
        this.clusterOSImage = clusterOSImage;
        this.defaultMachinePlatform = defaultMachinePlatform;
        this.failureDomains = failureDomains;
        this.ingressVIP = ingressVIP;
        this.ingressVIPs = ingressVIPs;
        this.loadBalancer = loadBalancer;
        this.preloadedOSImageName = preloadedOSImageName;
        this.prismAPICallTimeout = prismAPICallTimeout;
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
     * PreloadedOSImageName uses the named preloaded RHCOS image from PC/PE, instead of create and upload a new image for each cluster.
     */
    @JsonProperty("preloadedOSImageName")
    public String getPreloadedOSImageName() {
        return preloadedOSImageName;
    }

    /**
     * PreloadedOSImageName uses the named preloaded RHCOS image from PC/PE, instead of create and upload a new image for each cluster.
     */
    @JsonProperty("preloadedOSImageName")
    public void setPreloadedOSImageName(String preloadedOSImageName) {
        this.preloadedOSImageName = preloadedOSImageName;
    }

    /**
     * PrismAPICallTimeout sets the timeout (in minutes) for the prism-api calls. If not configured, the default value of 10 minutes will be used as the prism-api call timeout.
     */
    @JsonProperty("prismAPICallTimeout")
    public Integer getPrismAPICallTimeout() {
        return prismAPICallTimeout;
    }

    /**
     * PrismAPICallTimeout sets the timeout (in minutes) for the prism-api calls. If not configured, the default value of 10 minutes will be used as the prism-api call timeout.
     */
    @JsonProperty("prismAPICallTimeout")
    public void setPrismAPICallTimeout(Integer prismAPICallTimeout) {
        this.prismAPICallTimeout = prismAPICallTimeout;
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
        Object this$clusterOSImage = this.getClusterOSImage();
        Object other$clusterOSImage = other.getClusterOSImage();
        if (this$clusterOSImage == null ? other$clusterOSImage != null : !this$clusterOSImage.equals(other$clusterOSImage)) {
            return false;
        }
        Object this$defaultMachinePlatform = this.getDefaultMachinePlatform();
        Object other$defaultMachinePlatform = other.getDefaultMachinePlatform();
        if (this$defaultMachinePlatform == null ? other$defaultMachinePlatform != null : !this$defaultMachinePlatform.equals(other$defaultMachinePlatform)) {
            return false;
        }
        Object this$failureDomains = this.getFailureDomains();
        Object other$failureDomains = other.getFailureDomains();
        if (this$failureDomains == null ? other$failureDomains != null : !this$failureDomains.equals(other$failureDomains)) {
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
        Object this$loadBalancer = this.getLoadBalancer();
        Object other$loadBalancer = other.getLoadBalancer();
        if (this$loadBalancer == null ? other$loadBalancer != null : !this$loadBalancer.equals(other$loadBalancer)) {
            return false;
        }
        Object this$preloadedOSImageName = this.getPreloadedOSImageName();
        Object other$preloadedOSImageName = other.getPreloadedOSImageName();
        if (this$preloadedOSImageName == null ? other$preloadedOSImageName != null : !this$preloadedOSImageName.equals(other$preloadedOSImageName)) {
            return false;
        }
        Object this$prismAPICallTimeout = this.getPrismAPICallTimeout();
        Object other$prismAPICallTimeout = other.getPrismAPICallTimeout();
        if (this$prismAPICallTimeout == null ? other$prismAPICallTimeout != null : !this$prismAPICallTimeout.equals(other$prismAPICallTimeout)) {
            return false;
        }
        Object this$prismCentral = this.getPrismCentral();
        Object other$prismCentral = other.getPrismCentral();
        if (this$prismCentral == null ? other$prismCentral != null : !this$prismCentral.equals(other$prismCentral)) {
            return false;
        }
        Object this$prismElements = this.getPrismElements();
        Object other$prismElements = other.getPrismElements();
        if (this$prismElements == null ? other$prismElements != null : !this$prismElements.equals(other$prismElements)) {
            return false;
        }
        Object this$subnetUUIDs = this.getSubnetUUIDs();
        Object other$subnetUUIDs = other.getSubnetUUIDs();
        if (this$subnetUUIDs == null ? other$subnetUUIDs != null : !this$subnetUUIDs.equals(other$subnetUUIDs)) {
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
        Object $apiVIP = this.getApiVIP();
        result = result * prime + ($apiVIP == null ? 43 : $apiVIP.hashCode());
        Object $apiVIPs = this.getApiVIPs();
        result = result * prime + ($apiVIPs == null ? 43 : $apiVIPs.hashCode());
        Object $clusterOSImage = this.getClusterOSImage();
        result = result * prime + ($clusterOSImage == null ? 43 : $clusterOSImage.hashCode());
        Object $defaultMachinePlatform = this.getDefaultMachinePlatform();
        result = result * prime + ($defaultMachinePlatform == null ? 43 : $defaultMachinePlatform.hashCode());
        Object $failureDomains = this.getFailureDomains();
        result = result * prime + ($failureDomains == null ? 43 : $failureDomains.hashCode());
        Object $ingressVIP = this.getIngressVIP();
        result = result * prime + ($ingressVIP == null ? 43 : $ingressVIP.hashCode());
        Object $ingressVIPs = this.getIngressVIPs();
        result = result * prime + ($ingressVIPs == null ? 43 : $ingressVIPs.hashCode());
        Object $loadBalancer = this.getLoadBalancer();
        result = result * prime + ($loadBalancer == null ? 43 : $loadBalancer.hashCode());
        Object $preloadedOSImageName = this.getPreloadedOSImageName();
        result = result * prime + ($preloadedOSImageName == null ? 43 : $preloadedOSImageName.hashCode());
        Object $prismAPICallTimeout = this.getPrismAPICallTimeout();
        result = result * prime + ($prismAPICallTimeout == null ? 43 : $prismAPICallTimeout.hashCode());
        Object $prismCentral = this.getPrismCentral();
        result = result * prime + ($prismCentral == null ? 43 : $prismCentral.hashCode());
        Object $prismElements = this.getPrismElements();
        result = result * prime + ($prismElements == null ? 43 : $prismElements.hashCode());
        Object $subnetUUIDs = this.getSubnetUUIDs();
        result = result * prime + ($subnetUUIDs == null ? 43 : $subnetUUIDs.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Platform(" + "apiVIP=" + this.getApiVIP() + ", apiVIPs=" + this.getApiVIPs() + ", clusterOSImage=" + this.getClusterOSImage() + ", defaultMachinePlatform=" + this.getDefaultMachinePlatform() + ", failureDomains=" + this.getFailureDomains() + ", ingressVIP=" + this.getIngressVIP() + ", ingressVIPs=" + this.getIngressVIPs() + ", loadBalancer=" + this.getLoadBalancer() + ", preloadedOSImageName=" + this.getPreloadedOSImageName() + ", prismAPICallTimeout=" + this.getPrismAPICallTimeout() + ", prismCentral=" + this.getPrismCentral() + ", prismElements=" + this.getPrismElements() + ", subnetUUIDs=" + this.getSubnetUUIDs() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
