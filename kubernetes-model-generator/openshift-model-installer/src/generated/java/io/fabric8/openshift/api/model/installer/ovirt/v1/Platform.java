
package io.fabric8.openshift.api.model.installer.ovirt.v1;

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
import io.fabric8.openshift.api.model.config.v1.OvirtPlatformLoadBalancer;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * Platform stores all the global configuration that all machinesets use.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "affinityGroups",
    "api_vip",
    "api_vips",
    "defaultMachinePlatform",
    "ingress_vip",
    "ingress_vips",
    "loadBalancer",
    "ovirt_cluster_id",
    "ovirt_network_name",
    "ovirt_storage_domain_id",
    "vnicProfileID"
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

    @JsonProperty("affinityGroups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AffinityGroup> affinityGroups = new ArrayList<>();
    @JsonProperty("api_vip")
    private String apiVip;
    @JsonProperty("api_vips")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> apiVips = new ArrayList<>();
    @JsonProperty("defaultMachinePlatform")
    private MachinePool defaultMachinePlatform;
    @JsonProperty("ingress_vip")
    private String ingressVip;
    @JsonProperty("ingress_vips")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> ingressVips = new ArrayList<>();
    @JsonProperty("loadBalancer")
    private OvirtPlatformLoadBalancer loadBalancer;
    @JsonProperty("ovirt_cluster_id")
    private String ovirtClusterId;
    @JsonProperty("ovirt_network_name")
    private String ovirtNetworkName;
    @JsonProperty("ovirt_storage_domain_id")
    private String ovirtStorageDomainId;
    @JsonProperty("vnicProfileID")
    private String vnicProfileID;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Platform() {
    }

    public Platform(List<AffinityGroup> affinityGroups, String apiVip, List<String> apiVips, MachinePool defaultMachinePlatform, String ingressVip, List<String> ingressVips, OvirtPlatformLoadBalancer loadBalancer, String ovirtClusterId, String ovirtNetworkName, String ovirtStorageDomainId, String vnicProfileID) {
        super();
        this.affinityGroups = affinityGroups;
        this.apiVip = apiVip;
        this.apiVips = apiVips;
        this.defaultMachinePlatform = defaultMachinePlatform;
        this.ingressVip = ingressVip;
        this.ingressVips = ingressVips;
        this.loadBalancer = loadBalancer;
        this.ovirtClusterId = ovirtClusterId;
        this.ovirtNetworkName = ovirtNetworkName;
        this.ovirtStorageDomainId = ovirtStorageDomainId;
        this.vnicProfileID = vnicProfileID;
    }

    /**
     * AffinityGroups contains the RHV affinity groups that the installer will create.
     */
    @JsonProperty("affinityGroups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AffinityGroup> getAffinityGroups() {
        return affinityGroups;
    }

    /**
     * AffinityGroups contains the RHV affinity groups that the installer will create.
     */
    @JsonProperty("affinityGroups")
    public void setAffinityGroups(List<AffinityGroup> affinityGroups) {
        this.affinityGroups = affinityGroups;
    }

    /**
     * DeprecatedAPIVIP is an IP which will be served by bootstrap and then pivoted masters, using keepalived Deprecated: Use APIVIPs
     */
    @JsonProperty("api_vip")
    public String getApiVip() {
        return apiVip;
    }

    /**
     * DeprecatedAPIVIP is an IP which will be served by bootstrap and then pivoted masters, using keepalived Deprecated: Use APIVIPs
     */
    @JsonProperty("api_vip")
    public void setApiVip(String apiVip) {
        this.apiVip = apiVip;
    }

    /**
     * APIVIPs contains the VIP(s) which will be served by bootstrap and then pivoted masters, using keepalived. In dual stack clusters it contains an IPv4 and IPv6 address, otherwise only one VIP
     */
    @JsonProperty("api_vips")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getApiVips() {
        return apiVips;
    }

    /**
     * APIVIPs contains the VIP(s) which will be served by bootstrap and then pivoted masters, using keepalived. In dual stack clusters it contains an IPv4 and IPv6 address, otherwise only one VIP
     */
    @JsonProperty("api_vips")
    public void setApiVips(List<String> apiVips) {
        this.apiVips = apiVips;
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
     * IngressIP is an external IP which routes to the default ingress controller. The IP is a suitable target of a wildcard DNS record used to resolve default route host names. Deprecated: Use IngressVIPs
     */
    @JsonProperty("ingress_vip")
    public String getIngressVip() {
        return ingressVip;
    }

    /**
     * IngressIP is an external IP which routes to the default ingress controller. The IP is a suitable target of a wildcard DNS record used to resolve default route host names. Deprecated: Use IngressVIPs
     */
    @JsonProperty("ingress_vip")
    public void setIngressVip(String ingressVip) {
        this.ingressVip = ingressVip;
    }

    /**
     * IngressVIPs are external IP(s) which route to the default ingress controller. The VIPs are suitable targets of wildcard DNS records used to resolve default route host names. In dual stack clusters it contains an IPv4 and IPv6 address, otherwise only one VIP
     */
    @JsonProperty("ingress_vips")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getIngressVips() {
        return ingressVips;
    }

    /**
     * IngressVIPs are external IP(s) which route to the default ingress controller. The VIPs are suitable targets of wildcard DNS records used to resolve default route host names. In dual stack clusters it contains an IPv4 and IPv6 address, otherwise only one VIP
     */
    @JsonProperty("ingress_vips")
    public void setIngressVips(List<String> ingressVips) {
        this.ingressVips = ingressVips;
    }

    /**
     * Platform stores all the global configuration that all machinesets use.
     */
    @JsonProperty("loadBalancer")
    public OvirtPlatformLoadBalancer getLoadBalancer() {
        return loadBalancer;
    }

    /**
     * Platform stores all the global configuration that all machinesets use.
     */
    @JsonProperty("loadBalancer")
    public void setLoadBalancer(OvirtPlatformLoadBalancer loadBalancer) {
        this.loadBalancer = loadBalancer;
    }

    /**
     * The target cluster under which all VMs will run
     */
    @JsonProperty("ovirt_cluster_id")
    public String getOvirtClusterId() {
        return ovirtClusterId;
    }

    /**
     * The target cluster under which all VMs will run
     */
    @JsonProperty("ovirt_cluster_id")
    public void setOvirtClusterId(String ovirtClusterId) {
        this.ovirtClusterId = ovirtClusterId;
    }

    /**
     * NetworkName is the target network of all the network interfaces of the nodes. When no ovirt_network_name is provided it defaults to `ovirtmgmt` network, which is a default network for every ovirt cluster.
     */
    @JsonProperty("ovirt_network_name")
    public String getOvirtNetworkName() {
        return ovirtNetworkName;
    }

    /**
     * NetworkName is the target network of all the network interfaces of the nodes. When no ovirt_network_name is provided it defaults to `ovirtmgmt` network, which is a default network for every ovirt cluster.
     */
    @JsonProperty("ovirt_network_name")
    public void setOvirtNetworkName(String ovirtNetworkName) {
        this.ovirtNetworkName = ovirtNetworkName;
    }

    /**
     * The target storage domain under which all VM disk would be created.
     */
    @JsonProperty("ovirt_storage_domain_id")
    public String getOvirtStorageDomainId() {
        return ovirtStorageDomainId;
    }

    /**
     * The target storage domain under which all VM disk would be created.
     */
    @JsonProperty("ovirt_storage_domain_id")
    public void setOvirtStorageDomainId(String ovirtStorageDomainId) {
        this.ovirtStorageDomainId = ovirtStorageDomainId;
    }

    /**
     * VNICProfileID defines the VNIC profile ID to use the the VM network interfaces. When no vnicProfileID is provided it will be set to the profile of the network. If there are multiple profiles for the network, the installer requires you to explicitly set the vnicProfileID.
     */
    @JsonProperty("vnicProfileID")
    public String getVnicProfileID() {
        return vnicProfileID;
    }

    /**
     * VNICProfileID defines the VNIC profile ID to use the the VM network interfaces. When no vnicProfileID is provided it will be set to the profile of the network. If there are multiple profiles for the network, the installer requires you to explicitly set the vnicProfileID.
     */
    @JsonProperty("vnicProfileID")
    public void setVnicProfileID(String vnicProfileID) {
        this.vnicProfileID = vnicProfileID;
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
        Object this$affinityGroups = this.getAffinityGroups();
        Object other$affinityGroups = other.getAffinityGroups();
        if (this$affinityGroups == null ? other$affinityGroups != null : !this$affinityGroups.equals(other$affinityGroups)) {
            return false;
        }
        Object this$apiVip = this.getApiVip();
        Object other$apiVip = other.getApiVip();
        if (this$apiVip == null ? other$apiVip != null : !this$apiVip.equals(other$apiVip)) {
            return false;
        }
        Object this$apiVips = this.getApiVips();
        Object other$apiVips = other.getApiVips();
        if (this$apiVips == null ? other$apiVips != null : !this$apiVips.equals(other$apiVips)) {
            return false;
        }
        Object this$defaultMachinePlatform = this.getDefaultMachinePlatform();
        Object other$defaultMachinePlatform = other.getDefaultMachinePlatform();
        if (this$defaultMachinePlatform == null ? other$defaultMachinePlatform != null : !this$defaultMachinePlatform.equals(other$defaultMachinePlatform)) {
            return false;
        }
        Object this$ingressVip = this.getIngressVip();
        Object other$ingressVip = other.getIngressVip();
        if (this$ingressVip == null ? other$ingressVip != null : !this$ingressVip.equals(other$ingressVip)) {
            return false;
        }
        Object this$ingressVips = this.getIngressVips();
        Object other$ingressVips = other.getIngressVips();
        if (this$ingressVips == null ? other$ingressVips != null : !this$ingressVips.equals(other$ingressVips)) {
            return false;
        }
        Object this$loadBalancer = this.getLoadBalancer();
        Object other$loadBalancer = other.getLoadBalancer();
        if (this$loadBalancer == null ? other$loadBalancer != null : !this$loadBalancer.equals(other$loadBalancer)) {
            return false;
        }
        Object this$ovirtClusterId = this.getOvirtClusterId();
        Object other$ovirtClusterId = other.getOvirtClusterId();
        if (this$ovirtClusterId == null ? other$ovirtClusterId != null : !this$ovirtClusterId.equals(other$ovirtClusterId)) {
            return false;
        }
        Object this$ovirtNetworkName = this.getOvirtNetworkName();
        Object other$ovirtNetworkName = other.getOvirtNetworkName();
        if (this$ovirtNetworkName == null ? other$ovirtNetworkName != null : !this$ovirtNetworkName.equals(other$ovirtNetworkName)) {
            return false;
        }
        Object this$ovirtStorageDomainId = this.getOvirtStorageDomainId();
        Object other$ovirtStorageDomainId = other.getOvirtStorageDomainId();
        if (this$ovirtStorageDomainId == null ? other$ovirtStorageDomainId != null : !this$ovirtStorageDomainId.equals(other$ovirtStorageDomainId)) {
            return false;
        }
        Object this$vnicProfileID = this.getVnicProfileID();
        Object other$vnicProfileID = other.getVnicProfileID();
        if (this$vnicProfileID == null ? other$vnicProfileID != null : !this$vnicProfileID.equals(other$vnicProfileID)) {
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
        Object $affinityGroups = this.getAffinityGroups();
        result = result * prime + ($affinityGroups == null ? 43 : $affinityGroups.hashCode());
        Object $apiVip = this.getApiVip();
        result = result * prime + ($apiVip == null ? 43 : $apiVip.hashCode());
        Object $apiVips = this.getApiVips();
        result = result * prime + ($apiVips == null ? 43 : $apiVips.hashCode());
        Object $defaultMachinePlatform = this.getDefaultMachinePlatform();
        result = result * prime + ($defaultMachinePlatform == null ? 43 : $defaultMachinePlatform.hashCode());
        Object $ingressVip = this.getIngressVip();
        result = result * prime + ($ingressVip == null ? 43 : $ingressVip.hashCode());
        Object $ingressVips = this.getIngressVips();
        result = result * prime + ($ingressVips == null ? 43 : $ingressVips.hashCode());
        Object $loadBalancer = this.getLoadBalancer();
        result = result * prime + ($loadBalancer == null ? 43 : $loadBalancer.hashCode());
        Object $ovirtClusterId = this.getOvirtClusterId();
        result = result * prime + ($ovirtClusterId == null ? 43 : $ovirtClusterId.hashCode());
        Object $ovirtNetworkName = this.getOvirtNetworkName();
        result = result * prime + ($ovirtNetworkName == null ? 43 : $ovirtNetworkName.hashCode());
        Object $ovirtStorageDomainId = this.getOvirtStorageDomainId();
        result = result * prime + ($ovirtStorageDomainId == null ? 43 : $ovirtStorageDomainId.hashCode());
        Object $vnicProfileID = this.getVnicProfileID();
        result = result * prime + ($vnicProfileID == null ? 43 : $vnicProfileID.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Platform(" + "affinityGroups=" + this.getAffinityGroups() + ", apiVip=" + this.getApiVip() + ", apiVips=" + this.getApiVips() + ", defaultMachinePlatform=" + this.getDefaultMachinePlatform() + ", ingressVip=" + this.getIngressVip() + ", ingressVips=" + this.getIngressVips() + ", loadBalancer=" + this.getLoadBalancer() + ", ovirtClusterId=" + this.getOvirtClusterId() + ", ovirtNetworkName=" + this.getOvirtNetworkName() + ", ovirtStorageDomainId=" + this.getOvirtStorageDomainId() + ", vnicProfileID=" + this.getVnicProfileID() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
