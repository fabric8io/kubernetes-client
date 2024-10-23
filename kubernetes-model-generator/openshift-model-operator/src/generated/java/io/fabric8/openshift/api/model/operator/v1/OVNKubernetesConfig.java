
package io.fabric8.openshift.api.model.operator.v1;

import java.util.LinkedHashMap;
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
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
@Generated("jsonschema2pojo")
public class OVNKubernetesConfig implements Editable<OVNKubernetesConfigBuilder> , KubernetesResource
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
     * 
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

    @JsonProperty("egressIPConfig")
    public EgressIPConfig getEgressIPConfig() {
        return egressIPConfig;
    }

    @JsonProperty("egressIPConfig")
    public void setEgressIPConfig(EgressIPConfig egressIPConfig) {
        this.egressIPConfig = egressIPConfig;
    }

    @JsonProperty("gatewayConfig")
    public GatewayConfig getGatewayConfig() {
        return gatewayConfig;
    }

    @JsonProperty("gatewayConfig")
    public void setGatewayConfig(GatewayConfig gatewayConfig) {
        this.gatewayConfig = gatewayConfig;
    }

    @JsonProperty("genevePort")
    public Long getGenevePort() {
        return genevePort;
    }

    @JsonProperty("genevePort")
    public void setGenevePort(Long genevePort) {
        this.genevePort = genevePort;
    }

    @JsonProperty("hybridOverlayConfig")
    public HybridOverlayConfig getHybridOverlayConfig() {
        return hybridOverlayConfig;
    }

    @JsonProperty("hybridOverlayConfig")
    public void setHybridOverlayConfig(HybridOverlayConfig hybridOverlayConfig) {
        this.hybridOverlayConfig = hybridOverlayConfig;
    }

    @JsonProperty("ipsecConfig")
    public IPsecConfig getIpsecConfig() {
        return ipsecConfig;
    }

    @JsonProperty("ipsecConfig")
    public void setIpsecConfig(IPsecConfig ipsecConfig) {
        this.ipsecConfig = ipsecConfig;
    }

    @JsonProperty("ipv4")
    public IPv4OVNKubernetesConfig getIpv4() {
        return ipv4;
    }

    @JsonProperty("ipv4")
    public void setIpv4(IPv4OVNKubernetesConfig ipv4) {
        this.ipv4 = ipv4;
    }

    @JsonProperty("ipv6")
    public IPv6OVNKubernetesConfig getIpv6() {
        return ipv6;
    }

    @JsonProperty("ipv6")
    public void setIpv6(IPv6OVNKubernetesConfig ipv6) {
        this.ipv6 = ipv6;
    }

    @JsonProperty("mtu")
    public Long getMtu() {
        return mtu;
    }

    @JsonProperty("mtu")
    public void setMtu(Long mtu) {
        this.mtu = mtu;
    }

    @JsonProperty("policyAuditConfig")
    public PolicyAuditConfig getPolicyAuditConfig() {
        return policyAuditConfig;
    }

    @JsonProperty("policyAuditConfig")
    public void setPolicyAuditConfig(PolicyAuditConfig policyAuditConfig) {
        this.policyAuditConfig = policyAuditConfig;
    }

    @JsonProperty("routeAdvertisements")
    public String getRouteAdvertisements() {
        return routeAdvertisements;
    }

    @JsonProperty("routeAdvertisements")
    public void setRouteAdvertisements(String routeAdvertisements) {
        this.routeAdvertisements = routeAdvertisements;
    }

    @JsonProperty("v4InternalSubnet")
    public String getV4InternalSubnet() {
        return v4InternalSubnet;
    }

    @JsonProperty("v4InternalSubnet")
    public void setV4InternalSubnet(String v4InternalSubnet) {
        this.v4InternalSubnet = v4InternalSubnet;
    }

    @JsonProperty("v6InternalSubnet")
    public String getV6InternalSubnet() {
        return v6InternalSubnet;
    }

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
