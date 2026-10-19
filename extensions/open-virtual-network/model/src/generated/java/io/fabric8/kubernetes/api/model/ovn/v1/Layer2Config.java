
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Layer2Config)) {
            return false;
        }
        Layer2Config other = (Layer2Config) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$ipamLifecycle = this.getIpamLifecycle();
        Object other$ipamLifecycle = other.getIpamLifecycle();
        if (this$ipamLifecycle == null ? other$ipamLifecycle != null : !this$ipamLifecycle.equals(other$ipamLifecycle)) {
            return false;
        }
        Object this$joinSubnets = this.getJoinSubnets();
        Object other$joinSubnets = other.getJoinSubnets();
        if (this$joinSubnets == null ? other$joinSubnets != null : !this$joinSubnets.equals(other$joinSubnets)) {
            return false;
        }
        Object this$mtu = this.getMtu();
        Object other$mtu = other.getMtu();
        if (this$mtu == null ? other$mtu != null : !this$mtu.equals(other$mtu)) {
            return false;
        }
        Object this$role = this.getRole();
        Object other$role = other.getRole();
        if (this$role == null ? other$role != null : !this$role.equals(other$role)) {
            return false;
        }
        Object this$subnets = this.getSubnets();
        Object other$subnets = other.getSubnets();
        if (this$subnets == null ? other$subnets != null : !this$subnets.equals(other$subnets)) {
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
        return other instanceof Layer2Config;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $ipamLifecycle = this.getIpamLifecycle();
        result = result * prime + ($ipamLifecycle == null ? 43 : $ipamLifecycle.hashCode());
        Object $joinSubnets = this.getJoinSubnets();
        result = result * prime + ($joinSubnets == null ? 43 : $joinSubnets.hashCode());
        Object $mtu = this.getMtu();
        result = result * prime + ($mtu == null ? 43 : $mtu.hashCode());
        Object $role = this.getRole();
        result = result * prime + ($role == null ? 43 : $role.hashCode());
        Object $subnets = this.getSubnets();
        result = result * prime + ($subnets == null ? 43 : $subnets.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Layer2Config(" + "ipamLifecycle=" + this.getIpamLifecycle() + ", joinSubnets=" + this.getJoinSubnets() + ", mtu=" + this.getMtu() + ", role=" + this.getRole() + ", subnets=" + this.getSubnets() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
