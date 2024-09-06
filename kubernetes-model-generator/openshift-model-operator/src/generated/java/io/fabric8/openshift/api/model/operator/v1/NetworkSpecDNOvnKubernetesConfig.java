
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
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class NetworkSpecDNOvnKubernetesConfig implements Editable<NetworkSpecDNOvnKubernetesConfigBuilder> , KubernetesResource
{

    @JsonProperty("egressIPConfig")
    private NetworkSpecDNOKCEgressIPConfig egressIPConfig;
    @JsonProperty("gatewayConfig")
    private NetworkSpecDNOKCGatewayConfig gatewayConfig;
    @JsonProperty("genevePort")
    private Integer genevePort;
    @JsonProperty("hybridOverlayConfig")
    private NetworkSpecDNOKCHybridOverlayConfig hybridOverlayConfig;
    @JsonProperty("ipsecConfig")
    private NetworkSpecDNOKCIpsecConfig ipsecConfig;
    @JsonProperty("ipv4")
    private NetworkSpecDNOKCIpv4 ipv4;
    @JsonProperty("ipv6")
    private NetworkSpecDNOKCIpv6 ipv6;
    @JsonProperty("mtu")
    private Integer mtu;
    @JsonProperty("policyAuditConfig")
    private NetworkSpecDNOKCPolicyAuditConfig policyAuditConfig;
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
    public NetworkSpecDNOvnKubernetesConfig() {
    }

    public NetworkSpecDNOvnKubernetesConfig(NetworkSpecDNOKCEgressIPConfig egressIPConfig, NetworkSpecDNOKCGatewayConfig gatewayConfig, Integer genevePort, NetworkSpecDNOKCHybridOverlayConfig hybridOverlayConfig, NetworkSpecDNOKCIpsecConfig ipsecConfig, NetworkSpecDNOKCIpv4 ipv4, NetworkSpecDNOKCIpv6 ipv6, Integer mtu, NetworkSpecDNOKCPolicyAuditConfig policyAuditConfig, String v4InternalSubnet, String v6InternalSubnet) {
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
        this.v4InternalSubnet = v4InternalSubnet;
        this.v6InternalSubnet = v6InternalSubnet;
    }

    @JsonProperty("egressIPConfig")
    public NetworkSpecDNOKCEgressIPConfig getEgressIPConfig() {
        return egressIPConfig;
    }

    @JsonProperty("egressIPConfig")
    public void setEgressIPConfig(NetworkSpecDNOKCEgressIPConfig egressIPConfig) {
        this.egressIPConfig = egressIPConfig;
    }

    @JsonProperty("gatewayConfig")
    public NetworkSpecDNOKCGatewayConfig getGatewayConfig() {
        return gatewayConfig;
    }

    @JsonProperty("gatewayConfig")
    public void setGatewayConfig(NetworkSpecDNOKCGatewayConfig gatewayConfig) {
        this.gatewayConfig = gatewayConfig;
    }

    @JsonProperty("genevePort")
    public Integer getGenevePort() {
        return genevePort;
    }

    @JsonProperty("genevePort")
    public void setGenevePort(Integer genevePort) {
        this.genevePort = genevePort;
    }

    @JsonProperty("hybridOverlayConfig")
    public NetworkSpecDNOKCHybridOverlayConfig getHybridOverlayConfig() {
        return hybridOverlayConfig;
    }

    @JsonProperty("hybridOverlayConfig")
    public void setHybridOverlayConfig(NetworkSpecDNOKCHybridOverlayConfig hybridOverlayConfig) {
        this.hybridOverlayConfig = hybridOverlayConfig;
    }

    @JsonProperty("ipsecConfig")
    public NetworkSpecDNOKCIpsecConfig getIpsecConfig() {
        return ipsecConfig;
    }

    @JsonProperty("ipsecConfig")
    public void setIpsecConfig(NetworkSpecDNOKCIpsecConfig ipsecConfig) {
        this.ipsecConfig = ipsecConfig;
    }

    @JsonProperty("ipv4")
    public NetworkSpecDNOKCIpv4 getIpv4() {
        return ipv4;
    }

    @JsonProperty("ipv4")
    public void setIpv4(NetworkSpecDNOKCIpv4 ipv4) {
        this.ipv4 = ipv4;
    }

    @JsonProperty("ipv6")
    public NetworkSpecDNOKCIpv6 getIpv6() {
        return ipv6;
    }

    @JsonProperty("ipv6")
    public void setIpv6(NetworkSpecDNOKCIpv6 ipv6) {
        this.ipv6 = ipv6;
    }

    @JsonProperty("mtu")
    public Integer getMtu() {
        return mtu;
    }

    @JsonProperty("mtu")
    public void setMtu(Integer mtu) {
        this.mtu = mtu;
    }

    @JsonProperty("policyAuditConfig")
    public NetworkSpecDNOKCPolicyAuditConfig getPolicyAuditConfig() {
        return policyAuditConfig;
    }

    @JsonProperty("policyAuditConfig")
    public void setPolicyAuditConfig(NetworkSpecDNOKCPolicyAuditConfig policyAuditConfig) {
        this.policyAuditConfig = policyAuditConfig;
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
    public NetworkSpecDNOvnKubernetesConfigBuilder edit() {
        return new NetworkSpecDNOvnKubernetesConfigBuilder(this);
    }

    @JsonIgnore
    public NetworkSpecDNOvnKubernetesConfigBuilder toBuilder() {
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
