
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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

}
