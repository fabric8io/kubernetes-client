
package io.fabric8.openshift.api.model.operator.v1;

import java.util.LinkedHashMap;
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
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * ovnKubernetesConfig contains the configuration parameters for networks using the ovn-kubernetes network project
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "egressIPConfig",
    "gatewayConfig",
    "genevePort",
    "hybridOverlayConfig",
    "ipsecConfig",
    "ipv4",
    "ipv6",
    "mtu",
    "policyAuditConfig",
    "routeAdvertisements",
    "v4InternalSubnet",
    "v6InternalSubnet"
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
public class OVNKubernetesConfig implements Editable<OVNKubernetesConfigBuilder>, KubernetesResource
{

    @JsonProperty("egressIPConfig")
    private EgressIPConfig egressIPConfig;
    @JsonProperty("gatewayConfig")
    private GatewayConfig gatewayConfig;
    @JsonProperty("genevePort")
    private Long genevePort;
    @JsonProperty("hybridOverlayConfig")
    private HybridOverlayConfig hybridOverlayConfig;
    @JsonProperty("ipsecConfig")
    private IPsecConfig ipsecConfig;
    @JsonProperty("ipv4")
    private IPv4OVNKubernetesConfig ipv4;
    @JsonProperty("ipv6")
    private IPv6OVNKubernetesConfig ipv6;
    @JsonProperty("mtu")
    private Long mtu;
    @JsonProperty("policyAuditConfig")
    private PolicyAuditConfig policyAuditConfig;
    @JsonProperty("routeAdvertisements")
    private String routeAdvertisements;
    @JsonProperty("v4InternalSubnet")
    private String v4InternalSubnet;
    @JsonProperty("v6InternalSubnet")
    private String v6InternalSubnet;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public OVNKubernetesConfig() {
    }

    public OVNKubernetesConfig(EgressIPConfig egressIPConfig, GatewayConfig gatewayConfig, Long genevePort, HybridOverlayConfig hybridOverlayConfig, IPsecConfig ipsecConfig, IPv4OVNKubernetesConfig ipv4, IPv6OVNKubernetesConfig ipv6, Long mtu, PolicyAuditConfig policyAuditConfig, String routeAdvertisements, String v4InternalSubnet, String v6InternalSubnet) {
        super();
        this.egressIPConfig = egressIPConfig;
        this.gatewayConfig = gatewayConfig;
        this.genevePort = genevePort;
        this.hybridOverlayConfig = hybridOverlayConfig;
        this.ipsecConfig = ipsecConfig;
        this.ipv4 = ipv4;
        this.ipv6 = ipv6;
        this.mtu = mtu;
        this.policyAuditConfig = policyAuditConfig;
        this.routeAdvertisements = routeAdvertisements;
        this.v4InternalSubnet = v4InternalSubnet;
        this.v6InternalSubnet = v6InternalSubnet;
    }

    /**
     * ovnKubernetesConfig contains the configuration parameters for networks using the ovn-kubernetes network project
     */
    @JsonProperty("egressIPConfig")
    public EgressIPConfig getEgressIPConfig() {
        return egressIPConfig;
    }

    /**
     * ovnKubernetesConfig contains the configuration parameters for networks using the ovn-kubernetes network project
     */
    @JsonProperty("egressIPConfig")
    public void setEgressIPConfig(EgressIPConfig egressIPConfig) {
        this.egressIPConfig = egressIPConfig;
    }

    /**
     * ovnKubernetesConfig contains the configuration parameters for networks using the ovn-kubernetes network project
     */
    @JsonProperty("gatewayConfig")
    public GatewayConfig getGatewayConfig() {
        return gatewayConfig;
    }

    /**
     * ovnKubernetesConfig contains the configuration parameters for networks using the ovn-kubernetes network project
     */
    @JsonProperty("gatewayConfig")
    public void setGatewayConfig(GatewayConfig gatewayConfig) {
        this.gatewayConfig = gatewayConfig;
    }

    /**
     * geneve port is the UDP port to be used by geneve encapulation. Default is 6081
     */
    @JsonProperty("genevePort")
    public Long getGenevePort() {
        return genevePort;
    }

    /**
     * geneve port is the UDP port to be used by geneve encapulation. Default is 6081
     */
    @JsonProperty("genevePort")
    public void setGenevePort(Long genevePort) {
        this.genevePort = genevePort;
    }

    /**
     * ovnKubernetesConfig contains the configuration parameters for networks using the ovn-kubernetes network project
     */
    @JsonProperty("hybridOverlayConfig")
    public HybridOverlayConfig getHybridOverlayConfig() {
        return hybridOverlayConfig;
    }

    /**
     * ovnKubernetesConfig contains the configuration parameters for networks using the ovn-kubernetes network project
     */
    @JsonProperty("hybridOverlayConfig")
    public void setHybridOverlayConfig(HybridOverlayConfig hybridOverlayConfig) {
        this.hybridOverlayConfig = hybridOverlayConfig;
    }

    /**
     * ovnKubernetesConfig contains the configuration parameters for networks using the ovn-kubernetes network project
     */
    @JsonProperty("ipsecConfig")
    public IPsecConfig getIpsecConfig() {
        return ipsecConfig;
    }

    /**
     * ovnKubernetesConfig contains the configuration parameters for networks using the ovn-kubernetes network project
     */
    @JsonProperty("ipsecConfig")
    public void setIpsecConfig(IPsecConfig ipsecConfig) {
        this.ipsecConfig = ipsecConfig;
    }

    /**
     * ovnKubernetesConfig contains the configuration parameters for networks using the ovn-kubernetes network project
     */
    @JsonProperty("ipv4")
    public IPv4OVNKubernetesConfig getIpv4() {
        return ipv4;
    }

    /**
     * ovnKubernetesConfig contains the configuration parameters for networks using the ovn-kubernetes network project
     */
    @JsonProperty("ipv4")
    public void setIpv4(IPv4OVNKubernetesConfig ipv4) {
        this.ipv4 = ipv4;
    }

    /**
     * ovnKubernetesConfig contains the configuration parameters for networks using the ovn-kubernetes network project
     */
    @JsonProperty("ipv6")
    public IPv6OVNKubernetesConfig getIpv6() {
        return ipv6;
    }

    /**
     * ovnKubernetesConfig contains the configuration parameters for networks using the ovn-kubernetes network project
     */
    @JsonProperty("ipv6")
    public void setIpv6(IPv6OVNKubernetesConfig ipv6) {
        this.ipv6 = ipv6;
    }

    /**
     * mtu is the MTU to use for the tunnel interface. This must be 100 bytes smaller than the uplink mtu. Default is 1400
     */
    @JsonProperty("mtu")
    public Long getMtu() {
        return mtu;
    }

    /**
     * mtu is the MTU to use for the tunnel interface. This must be 100 bytes smaller than the uplink mtu. Default is 1400
     */
    @JsonProperty("mtu")
    public void setMtu(Long mtu) {
        this.mtu = mtu;
    }

    /**
     * ovnKubernetesConfig contains the configuration parameters for networks using the ovn-kubernetes network project
     */
    @JsonProperty("policyAuditConfig")
    public PolicyAuditConfig getPolicyAuditConfig() {
        return policyAuditConfig;
    }

    /**
     * ovnKubernetesConfig contains the configuration parameters for networks using the ovn-kubernetes network project
     */
    @JsonProperty("policyAuditConfig")
    public void setPolicyAuditConfig(PolicyAuditConfig policyAuditConfig) {
        this.policyAuditConfig = policyAuditConfig;
    }

    /**
     * routeAdvertisements determines if the functionality to advertise cluster network routes through a dynamic routing protocol, such as BGP, is enabled or not. This functionality is configured through the ovn-kubernetes RouteAdvertisements CRD. Requires the 'FRR' routing capability provider to be enabled as an additional routing capability. Allowed values are "Enabled", "Disabled" and ommited. When omitted, this means the user has no opinion and the platform is left to choose reasonable defaults. These defaults are subject to change over time. The current default is "Disabled".
     */
    @JsonProperty("routeAdvertisements")
    public String getRouteAdvertisements() {
        return routeAdvertisements;
    }

    /**
     * routeAdvertisements determines if the functionality to advertise cluster network routes through a dynamic routing protocol, such as BGP, is enabled or not. This functionality is configured through the ovn-kubernetes RouteAdvertisements CRD. Requires the 'FRR' routing capability provider to be enabled as an additional routing capability. Allowed values are "Enabled", "Disabled" and ommited. When omitted, this means the user has no opinion and the platform is left to choose reasonable defaults. These defaults are subject to change over time. The current default is "Disabled".
     */
    @JsonProperty("routeAdvertisements")
    public void setRouteAdvertisements(String routeAdvertisements) {
        this.routeAdvertisements = routeAdvertisements;
    }

    /**
     * v4InternalSubnet is a v4 subnet used internally by ovn-kubernetes in case the default one is being already used by something else. It must not overlap with any other subnet being used by OpenShift or by the node network. The size of the subnet must be larger than the number of nodes. Default is 100.64.0.0/16
     */
    @JsonProperty("v4InternalSubnet")
    public String getV4InternalSubnet() {
        return v4InternalSubnet;
    }

    /**
     * v4InternalSubnet is a v4 subnet used internally by ovn-kubernetes in case the default one is being already used by something else. It must not overlap with any other subnet being used by OpenShift or by the node network. The size of the subnet must be larger than the number of nodes. Default is 100.64.0.0/16
     */
    @JsonProperty("v4InternalSubnet")
    public void setV4InternalSubnet(String v4InternalSubnet) {
        this.v4InternalSubnet = v4InternalSubnet;
    }

    /**
     * v6InternalSubnet is a v6 subnet used internally by ovn-kubernetes in case the default one is being already used by something else. It must not overlap with any other subnet being used by OpenShift or by the node network. The size of the subnet must be larger than the number of nodes. Default is fd98::/64
     */
    @JsonProperty("v6InternalSubnet")
    public String getV6InternalSubnet() {
        return v6InternalSubnet;
    }

    /**
     * v6InternalSubnet is a v6 subnet used internally by ovn-kubernetes in case the default one is being already used by something else. It must not overlap with any other subnet being used by OpenShift or by the node network. The size of the subnet must be larger than the number of nodes. Default is fd98::/64
     */
    @JsonProperty("v6InternalSubnet")
    public void setV6InternalSubnet(String v6InternalSubnet) {
        this.v6InternalSubnet = v6InternalSubnet;
    }

    @JsonIgnore
    public OVNKubernetesConfigBuilder edit() {
        return new OVNKubernetesConfigBuilder(this);
    }

    @JsonIgnore
    public OVNKubernetesConfigBuilder toBuilder() {
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
        if (!(o instanceof OVNKubernetesConfig)) {
            return false;
        }
        OVNKubernetesConfig other = (OVNKubernetesConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$egressIPConfig = this.getEgressIPConfig();
        Object other$egressIPConfig = other.getEgressIPConfig();
        if (this$egressIPConfig == null ? other$egressIPConfig != null : !this$egressIPConfig.equals(other$egressIPConfig)) {
            return false;
        }
        Object this$gatewayConfig = this.getGatewayConfig();
        Object other$gatewayConfig = other.getGatewayConfig();
        if (this$gatewayConfig == null ? other$gatewayConfig != null : !this$gatewayConfig.equals(other$gatewayConfig)) {
            return false;
        }
        Object this$genevePort = this.getGenevePort();
        Object other$genevePort = other.getGenevePort();
        if (this$genevePort == null ? other$genevePort != null : !this$genevePort.equals(other$genevePort)) {
            return false;
        }
        Object this$hybridOverlayConfig = this.getHybridOverlayConfig();
        Object other$hybridOverlayConfig = other.getHybridOverlayConfig();
        if (this$hybridOverlayConfig == null ? other$hybridOverlayConfig != null : !this$hybridOverlayConfig.equals(other$hybridOverlayConfig)) {
            return false;
        }
        Object this$ipsecConfig = this.getIpsecConfig();
        Object other$ipsecConfig = other.getIpsecConfig();
        if (this$ipsecConfig == null ? other$ipsecConfig != null : !this$ipsecConfig.equals(other$ipsecConfig)) {
            return false;
        }
        Object this$ipv4 = this.getIpv4();
        Object other$ipv4 = other.getIpv4();
        if (this$ipv4 == null ? other$ipv4 != null : !this$ipv4.equals(other$ipv4)) {
            return false;
        }
        Object this$ipv6 = this.getIpv6();
        Object other$ipv6 = other.getIpv6();
        if (this$ipv6 == null ? other$ipv6 != null : !this$ipv6.equals(other$ipv6)) {
            return false;
        }
        Object this$mtu = this.getMtu();
        Object other$mtu = other.getMtu();
        if (this$mtu == null ? other$mtu != null : !this$mtu.equals(other$mtu)) {
            return false;
        }
        Object this$policyAuditConfig = this.getPolicyAuditConfig();
        Object other$policyAuditConfig = other.getPolicyAuditConfig();
        if (this$policyAuditConfig == null ? other$policyAuditConfig != null : !this$policyAuditConfig.equals(other$policyAuditConfig)) {
            return false;
        }
        Object this$routeAdvertisements = this.getRouteAdvertisements();
        Object other$routeAdvertisements = other.getRouteAdvertisements();
        if (this$routeAdvertisements == null ? other$routeAdvertisements != null : !this$routeAdvertisements.equals(other$routeAdvertisements)) {
            return false;
        }
        Object this$v4InternalSubnet = this.getV4InternalSubnet();
        Object other$v4InternalSubnet = other.getV4InternalSubnet();
        if (this$v4InternalSubnet == null ? other$v4InternalSubnet != null : !this$v4InternalSubnet.equals(other$v4InternalSubnet)) {
            return false;
        }
        Object this$v6InternalSubnet = this.getV6InternalSubnet();
        Object other$v6InternalSubnet = other.getV6InternalSubnet();
        if (this$v6InternalSubnet == null ? other$v6InternalSubnet != null : !this$v6InternalSubnet.equals(other$v6InternalSubnet)) {
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
        return other instanceof OVNKubernetesConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $egressIPConfig = this.getEgressIPConfig();
        result = result * prime + ($egressIPConfig == null ? 43 : $egressIPConfig.hashCode());
        Object $gatewayConfig = this.getGatewayConfig();
        result = result * prime + ($gatewayConfig == null ? 43 : $gatewayConfig.hashCode());
        Object $genevePort = this.getGenevePort();
        result = result * prime + ($genevePort == null ? 43 : $genevePort.hashCode());
        Object $hybridOverlayConfig = this.getHybridOverlayConfig();
        result = result * prime + ($hybridOverlayConfig == null ? 43 : $hybridOverlayConfig.hashCode());
        Object $ipsecConfig = this.getIpsecConfig();
        result = result * prime + ($ipsecConfig == null ? 43 : $ipsecConfig.hashCode());
        Object $ipv4 = this.getIpv4();
        result = result * prime + ($ipv4 == null ? 43 : $ipv4.hashCode());
        Object $ipv6 = this.getIpv6();
        result = result * prime + ($ipv6 == null ? 43 : $ipv6.hashCode());
        Object $mtu = this.getMtu();
        result = result * prime + ($mtu == null ? 43 : $mtu.hashCode());
        Object $policyAuditConfig = this.getPolicyAuditConfig();
        result = result * prime + ($policyAuditConfig == null ? 43 : $policyAuditConfig.hashCode());
        Object $routeAdvertisements = this.getRouteAdvertisements();
        result = result * prime + ($routeAdvertisements == null ? 43 : $routeAdvertisements.hashCode());
        Object $v4InternalSubnet = this.getV4InternalSubnet();
        result = result * prime + ($v4InternalSubnet == null ? 43 : $v4InternalSubnet.hashCode());
        Object $v6InternalSubnet = this.getV6InternalSubnet();
        result = result * prime + ($v6InternalSubnet == null ? 43 : $v6InternalSubnet.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "OVNKubernetesConfig(" + "egressIPConfig=" + this.getEgressIPConfig() + ", gatewayConfig=" + this.getGatewayConfig() + ", genevePort=" + this.getGenevePort() + ", hybridOverlayConfig=" + this.getHybridOverlayConfig() + ", ipsecConfig=" + this.getIpsecConfig() + ", ipv4=" + this.getIpv4() + ", ipv6=" + this.getIpv6() + ", mtu=" + this.getMtu() + ", policyAuditConfig=" + this.getPolicyAuditConfig() + ", routeAdvertisements=" + this.getRouteAdvertisements() + ", v4InternalSubnet=" + this.getV4InternalSubnet() + ", v6InternalSubnet=" + this.getV6InternalSubnet() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
