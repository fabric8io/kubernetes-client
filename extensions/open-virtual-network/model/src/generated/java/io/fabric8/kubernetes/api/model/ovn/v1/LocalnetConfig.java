
package io.fabric8.kubernetes.api.model.ovn.v1;

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
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import tools.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "excludeSubnets",
    "ipam",
    "macSecurity",
    "mtu",
    "physicalNetworkName",
    "role",
    "subnets",
    "vlan"
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
public class LocalnetConfig implements Editable<LocalnetConfigBuilder>, KubernetesResource
{

    @JsonProperty("excludeSubnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> excludeSubnets = new ArrayList<>();
    @JsonProperty("ipam")
    private IPAMConfig ipam;
    @JsonProperty("macSecurity")
    private MACSecurityConfig macSecurity;
    @JsonProperty("mtu")
    private Integer mtu;
    @JsonProperty("physicalNetworkName")
    private String physicalNetworkName;
    @JsonProperty("role")
    private String role;
    @JsonProperty("subnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> subnets = new ArrayList<>();
    @JsonProperty("vlan")
    private VLANConfig vlan;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public LocalnetConfig() {
    }

    public LocalnetConfig(List<String> excludeSubnets, IPAMConfig ipam, MACSecurityConfig macSecurity, Integer mtu, String physicalNetworkName, String role, List<String> subnets, VLANConfig vlan) {
        super();
        this.excludeSubnets = excludeSubnets;
        this.ipam = ipam;
        this.macSecurity = macSecurity;
        this.mtu = mtu;
        this.physicalNetworkName = physicalNetworkName;
        this.role = role;
        this.subnets = subnets;
        this.vlan = vlan;
    }

    /**
     * excludeSubnets is a list of CIDRs to be removed from the specified CIDRs in `subnets`. The CIDRs in this list must be in range of at least one subnet specified in `subnets`. excludeSubnets is optional. When omitted no IP address is excluded and all IP addresses specified in `subnets` are subject to assignment. The format should match standard CIDR notation (for example, "10.128.0.0/16"). This field must be omitted if `subnets` is unset or `ipam.mode` is `Disabled` or `DHCP`. When `physicalNetworkName` points to OVS bridge mapping of a network with reserved IP addresses (which shouldn't be assigned by OVN-Kubernetes), the specified CIDRs will not be assigned. For example: Given: `subnets: "10.0.0.0/24"`, `excludeSubnets`: "10.0.0.200/30", the following addresses will not be assigned to pods: `10.0.0.201`, `10.0.0.202`.
     */
    @JsonProperty("excludeSubnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getExcludeSubnets() {
        return excludeSubnets;
    }

    /**
     * excludeSubnets is a list of CIDRs to be removed from the specified CIDRs in `subnets`. The CIDRs in this list must be in range of at least one subnet specified in `subnets`. excludeSubnets is optional. When omitted no IP address is excluded and all IP addresses specified in `subnets` are subject to assignment. The format should match standard CIDR notation (for example, "10.128.0.0/16"). This field must be omitted if `subnets` is unset or `ipam.mode` is `Disabled` or `DHCP`. When `physicalNetworkName` points to OVS bridge mapping of a network with reserved IP addresses (which shouldn't be assigned by OVN-Kubernetes), the specified CIDRs will not be assigned. For example: Given: `subnets: "10.0.0.0/24"`, `excludeSubnets`: "10.0.0.200/30", the following addresses will not be assigned to pods: `10.0.0.201`, `10.0.0.202`.
     */
    @JsonProperty("excludeSubnets")
    public void setExcludeSubnets(List<String> excludeSubnets) {
        this.excludeSubnets = excludeSubnets;
    }

    @JsonProperty("ipam")
    public IPAMConfig getIpam() {
        return ipam;
    }

    @JsonProperty("ipam")
    public void setIpam(IPAMConfig ipam) {
        this.ipam = ipam;
    }

    @JsonProperty("macSecurity")
    public MACSecurityConfig getMacSecurity() {
        return macSecurity;
    }

    @JsonProperty("macSecurity")
    public void setMacSecurity(MACSecurityConfig macSecurity) {
        this.macSecurity = macSecurity;
    }

    /**
     * mtu is the maximum transmission unit for a network. mtu is optional. When omitted, the configured value in OVN-Kubernetes (defaults to 1500 for localnet topology) is used for the network. Minimum value for IPv4 subnet is 576, and for IPv6 subnet is 1280. Maximum value is 65536. In a scenario `physicalNetworkName` points to OVS bridge mapping of a network configured with certain MTU settings, this field enables configuring the same MTU on pod interface, having the pod MTU aligned with the network MTU. Misaligned MTU across the stack (e.g.: pod has MTU X, node NIC has MTU Y), could result in network disruptions and bad performance.
     */
    @JsonProperty("mtu")
    public Integer getMtu() {
        return mtu;
    }

    /**
     * mtu is the maximum transmission unit for a network. mtu is optional. When omitted, the configured value in OVN-Kubernetes (defaults to 1500 for localnet topology) is used for the network. Minimum value for IPv4 subnet is 576, and for IPv6 subnet is 1280. Maximum value is 65536. In a scenario `physicalNetworkName` points to OVS bridge mapping of a network configured with certain MTU settings, this field enables configuring the same MTU on pod interface, having the pod MTU aligned with the network MTU. Misaligned MTU across the stack (e.g.: pod has MTU X, node NIC has MTU Y), could result in network disruptions and bad performance.
     */
    @JsonProperty("mtu")
    public void setMtu(Integer mtu) {
        this.mtu = mtu;
    }

    /**
     * physicalNetworkName points to the OVS bridge-mapping's network-name configured in the nodes, required. Min length is 1, max length is 253, cannot contain `,` or `:` characters. In case OVS bridge-mapping is defined by Kubernetes-nmstate with `NodeNetworkConfigurationPolicy` (NNCP), this field should point to the NNCP `spec.desiredState.ovn.bridge-mappings` item's `localnet` value.
     */
    @JsonProperty("physicalNetworkName")
    public String getPhysicalNetworkName() {
        return physicalNetworkName;
    }

    /**
     * physicalNetworkName points to the OVS bridge-mapping's network-name configured in the nodes, required. Min length is 1, max length is 253, cannot contain `,` or `:` characters. In case OVS bridge-mapping is defined by Kubernetes-nmstate with `NodeNetworkConfigurationPolicy` (NNCP), this field should point to the NNCP `spec.desiredState.ovn.bridge-mappings` item's `localnet` value.
     */
    @JsonProperty("physicalNetworkName")
    public void setPhysicalNetworkName(String physicalNetworkName) {
        this.physicalNetworkName = physicalNetworkName;
    }

    /**
     * role describes the network role in the pod, required. Controls whether the pod interface will act as primary or secondary. Localnet topology supports `Secondary` only. The network will be assigned to pods that have the `k8s.v1.cni.cncf.io/networks` annotation in place pointing to subject.
     */
    @JsonProperty("role")
    public String getRole() {
        return role;
    }

    /**
     * role describes the network role in the pod, required. Controls whether the pod interface will act as primary or secondary. Localnet topology supports `Secondary` only. The network will be assigned to pods that have the `k8s.v1.cni.cncf.io/networks` annotation in place pointing to subject.
     */
    @JsonProperty("role")
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * subnets is a list of subnets used for pods in this localnet network across the cluster. The list may be either 1 IPv4 subnet, 1 IPv6 subnet, or 1 of each IP family. When set, OVN-Kubernetes assigns an IP address from the specified CIDRs to the connected pod, eliminating the need for manual IP assignment or reliance on an external IPAM service (e.g., a DHCP server). subnets is optional. When omitted OVN-Kubernetes won't assign IP address automatically. Dual-stack clusters may set 2 subnets (one for each IP family), otherwise only 1 subnet is allowed. The format should match standard CIDR notation (for example, "10.128.0.0/16"). This field must be omitted if `ipam.mode` is `Disabled` or `DHCP`. When physicalNetworkName points to the OVS bridge mapping of a network that provides IPAM services, ipam.mode should be set to `Disabled` (users configure the pod IPs themselves) or `DHCP` (a DHCP server on that network assigns them). Both turn off OVN-Kubernetes IPAM and avoid conflicts with the existing IPAM services on this localnet network.
     */
    @JsonProperty("subnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getSubnets() {
        return subnets;
    }

    /**
     * subnets is a list of subnets used for pods in this localnet network across the cluster. The list may be either 1 IPv4 subnet, 1 IPv6 subnet, or 1 of each IP family. When set, OVN-Kubernetes assigns an IP address from the specified CIDRs to the connected pod, eliminating the need for manual IP assignment or reliance on an external IPAM service (e.g., a DHCP server). subnets is optional. When omitted OVN-Kubernetes won't assign IP address automatically. Dual-stack clusters may set 2 subnets (one for each IP family), otherwise only 1 subnet is allowed. The format should match standard CIDR notation (for example, "10.128.0.0/16"). This field must be omitted if `ipam.mode` is `Disabled` or `DHCP`. When physicalNetworkName points to the OVS bridge mapping of a network that provides IPAM services, ipam.mode should be set to `Disabled` (users configure the pod IPs themselves) or `DHCP` (a DHCP server on that network assigns them). Both turn off OVN-Kubernetes IPAM and avoid conflicts with the existing IPAM services on this localnet network.
     */
    @JsonProperty("subnets")
    public void setSubnets(List<String> subnets) {
        this.subnets = subnets;
    }

    @JsonProperty("vlan")
    public VLANConfig getVlan() {
        return vlan;
    }

    @JsonProperty("vlan")
    public void setVlan(VLANConfig vlan) {
        this.vlan = vlan;
    }

    @JsonIgnore
    public LocalnetConfigBuilder edit() {
        return new LocalnetConfigBuilder(this);
    }

    @JsonIgnore
    public LocalnetConfigBuilder toBuilder() {
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
