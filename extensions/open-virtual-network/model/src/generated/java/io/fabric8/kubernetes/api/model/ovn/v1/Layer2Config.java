
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
    "defaultGatewayIPs",
    "infrastructureSubnets",
    "ipam",
    "joinSubnets",
    "macSecurity",
    "mtu",
    "reservedSubnets",
    "role",
    "subnets"
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
public class Layer2Config implements Editable<Layer2ConfigBuilder>, KubernetesResource
{

    @JsonProperty("defaultGatewayIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> defaultGatewayIPs = new ArrayList<>();
    @JsonProperty("infrastructureSubnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> infrastructureSubnets = new ArrayList<>();
    @JsonProperty("ipam")
    private IPAMConfig ipam;
    @JsonProperty("joinSubnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> joinSubnets = new ArrayList<>();
    @JsonProperty("macSecurity")
    private MACSecurityConfig macSecurity;
    @JsonProperty("mtu")
    private Integer mtu;
    @JsonProperty("reservedSubnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> reservedSubnets = new ArrayList<>();
    @JsonProperty("role")
    private String role;
    @JsonProperty("subnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> subnets = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Layer2Config() {
    }

    public Layer2Config(List<String> defaultGatewayIPs, List<String> infrastructureSubnets, IPAMConfig ipam, List<String> joinSubnets, MACSecurityConfig macSecurity, Integer mtu, List<String> reservedSubnets, String role, List<String> subnets) {
        super();
        this.defaultGatewayIPs = defaultGatewayIPs;
        this.infrastructureSubnets = infrastructureSubnets;
        this.ipam = ipam;
        this.joinSubnets = joinSubnets;
        this.macSecurity = macSecurity;
        this.mtu = mtu;
        this.reservedSubnets = reservedSubnets;
        this.role = role;
        this.subnets = subnets;
    }

    /**
     * defaultGatewayIPs specifies the default gateway IP used in the internal OVN topology.<br><p> <br><p> Dual-stack clusters may set 2 IPs (one for each IP family), otherwise only 1 IP is allowed. This field is only allowed for "Primary" network. It is not recommended to set this field without explicit need and understanding of the OVN network topology. When omitted, an IP from the subnets field is used.
     */
    @JsonProperty("defaultGatewayIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getDefaultGatewayIPs() {
        return defaultGatewayIPs;
    }

    /**
     * defaultGatewayIPs specifies the default gateway IP used in the internal OVN topology.<br><p> <br><p> Dual-stack clusters may set 2 IPs (one for each IP family), otherwise only 1 IP is allowed. This field is only allowed for "Primary" network. It is not recommended to set this field without explicit need and understanding of the OVN network topology. When omitted, an IP from the subnets field is used.
     */
    @JsonProperty("defaultGatewayIPs")
    public void setDefaultGatewayIPs(List<String> defaultGatewayIPs) {
        this.defaultGatewayIPs = defaultGatewayIPs;
    }

    /**
     * infrastructureSubnets specifies a list of internal CIDR ranges that OVN-Kubernetes will reserve for internal network infrastructure. Any IP addresses within these ranges cannot be assigned to workloads. When omitted, OVN-Kubernetes will automatically allocate IP addresses from `subnets` for its infrastructure needs. When there are not enough available IPs in the provided infrastructureSubnets, OVN-Kubernetes will automatically allocate IP addresses from subnets for its infrastructure needs. When `reservedSubnets` is also specified the CIDRs cannot overlap. When `defaultGatewayIPs` is also specified, the default gateway IPs must belong to one of the infrastructure subnet CIDRs. Each item should be in range of the specified CIDR(s) in `subnets`. The maximum number of entries allowed is 4. The format should match standard CIDR notation (for example, "10.128.0.0/16"). This field must be omitted if `subnets` is unset or `ipam.mode` is `Disabled`.
     */
    @JsonProperty("infrastructureSubnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getInfrastructureSubnets() {
        return infrastructureSubnets;
    }

    /**
     * infrastructureSubnets specifies a list of internal CIDR ranges that OVN-Kubernetes will reserve for internal network infrastructure. Any IP addresses within these ranges cannot be assigned to workloads. When omitted, OVN-Kubernetes will automatically allocate IP addresses from `subnets` for its infrastructure needs. When there are not enough available IPs in the provided infrastructureSubnets, OVN-Kubernetes will automatically allocate IP addresses from subnets for its infrastructure needs. When `reservedSubnets` is also specified the CIDRs cannot overlap. When `defaultGatewayIPs` is also specified, the default gateway IPs must belong to one of the infrastructure subnet CIDRs. Each item should be in range of the specified CIDR(s) in `subnets`. The maximum number of entries allowed is 4. The format should match standard CIDR notation (for example, "10.128.0.0/16"). This field must be omitted if `subnets` is unset or `ipam.mode` is `Disabled`.
     */
    @JsonProperty("infrastructureSubnets")
    public void setInfrastructureSubnets(List<String> infrastructureSubnets) {
        this.infrastructureSubnets = infrastructureSubnets;
    }

    @JsonProperty("ipam")
    public IPAMConfig getIpam() {
        return ipam;
    }

    @JsonProperty("ipam")
    public void setIpam(IPAMConfig ipam) {
        this.ipam = ipam;
    }

    /**
     * JoinSubnets are used inside the OVN network topology.<br><p> <br><p> Dual-stack clusters may set 2 subnets (one for each IP family), otherwise only 1 subnet is allowed. This field is only allowed for "Primary" network. It is not recommended to set this field without explicit need and understanding of the OVN network topology. When omitted, the platform will choose a reasonable default which is subject to change over time.
     */
    @JsonProperty("joinSubnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getJoinSubnets() {
        return joinSubnets;
    }

    /**
     * JoinSubnets are used inside the OVN network topology.<br><p> <br><p> Dual-stack clusters may set 2 subnets (one for each IP family), otherwise only 1 subnet is allowed. This field is only allowed for "Primary" network. It is not recommended to set this field without explicit need and understanding of the OVN network topology. When omitted, the platform will choose a reasonable default which is subject to change over time.
     */
    @JsonProperty("joinSubnets")
    public void setJoinSubnets(List<String> joinSubnets) {
        this.joinSubnets = joinSubnets;
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
     * MTU is the maximum transmission unit for a network. MTU is optional, if not provided, the globally configured value in OVN-Kubernetes (defaults to 1400) is used for the network.
     */
    @JsonProperty("mtu")
    public Integer getMtu() {
        return mtu;
    }

    /**
     * MTU is the maximum transmission unit for a network. MTU is optional, if not provided, the globally configured value in OVN-Kubernetes (defaults to 1400) is used for the network.
     */
    @JsonProperty("mtu")
    public void setMtu(Integer mtu) {
        this.mtu = mtu;
    }

    /**
     * reservedSubnets specifies a list of CIDRs reserved for static IP assignment, excluded from automatic allocation. reservedSubnets is optional. When omitted, all IP addresses in `subnets` are available for automatic assignment. IPs from these ranges can still be requested through static IP assignment. Each item should be in range of the specified CIDR(s) in `subnets`. The maximum number of entries allowed is 25. The format should match standard CIDR notation (for example, "10.128.0.0/16"). This field must be omitted if `subnets` is unset or `ipam.mode` is `Disabled`.
     */
    @JsonProperty("reservedSubnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getReservedSubnets() {
        return reservedSubnets;
    }

    /**
     * reservedSubnets specifies a list of CIDRs reserved for static IP assignment, excluded from automatic allocation. reservedSubnets is optional. When omitted, all IP addresses in `subnets` are available for automatic assignment. IPs from these ranges can still be requested through static IP assignment. Each item should be in range of the specified CIDR(s) in `subnets`. The maximum number of entries allowed is 25. The format should match standard CIDR notation (for example, "10.128.0.0/16"). This field must be omitted if `subnets` is unset or `ipam.mode` is `Disabled`.
     */
    @JsonProperty("reservedSubnets")
    public void setReservedSubnets(List<String> reservedSubnets) {
        this.reservedSubnets = reservedSubnets;
    }

    /**
     * Role describes the network role in the pod.<br><p> <br><p> Allowed value is "Secondary". Secondary network is only assigned to pods that use `k8s.v1.cni.cncf.io/networks` annotation to select given network.
     */
    @JsonProperty("role")
    public String getRole() {
        return role;
    }

    /**
     * Role describes the network role in the pod.<br><p> <br><p> Allowed value is "Secondary". Secondary network is only assigned to pods that use `k8s.v1.cni.cncf.io/networks` annotation to select given network.
     */
    @JsonProperty("role")
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Subnets are used for the pod network across the cluster. Dual-stack clusters may set 2 subnets (one for each IP family), otherwise only 1 subnet is allowed.<br><p> <br><p> The format should match standard CIDR notation (for example, "10.128.0.0/16"). This field must be omitted if `ipam.mode` is `Disabled`.
     */
    @JsonProperty("subnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getSubnets() {
        return subnets;
    }

    /**
     * Subnets are used for the pod network across the cluster. Dual-stack clusters may set 2 subnets (one for each IP family), otherwise only 1 subnet is allowed.<br><p> <br><p> The format should match standard CIDR notation (for example, "10.128.0.0/16"). This field must be omitted if `ipam.mode` is `Disabled`.
     */
    @JsonProperty("subnets")
    public void setSubnets(List<String> subnets) {
        this.subnets = subnets;
    }

    @JsonIgnore
    public Layer2ConfigBuilder edit() {
        return new Layer2ConfigBuilder(this);
    }

    @JsonIgnore
    public Layer2ConfigBuilder toBuilder() {
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
