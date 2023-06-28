
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "genevePort",
    "hybridOverlayConfig",
    "ipsecConfig",
    "mtu",
    "policyAuditConfig"
})
@ToString
@EqualsAndHashCode
@Setter
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
public class OVNKubernetesConfig implements KubernetesResource
{

    @JsonProperty("genevePort")
    private Integer genevePort;
    @JsonProperty("hybridOverlayConfig")
    private HybridOverlayConfig hybridOverlayConfig;
    @JsonProperty("ipsecConfig")
    private IPsecConfig ipsecConfig;
    @JsonProperty("mtu")
    private Integer mtu;
    @JsonProperty("policyAuditConfig")
    private PolicyAuditConfig policyAuditConfig;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public OVNKubernetesConfig() {
    }

    public OVNKubernetesConfig(Integer genevePort, HybridOverlayConfig hybridOverlayConfig, IPsecConfig ipsecConfig, Integer mtu, PolicyAuditConfig policyAuditConfig) {
        super();
        this.genevePort = genevePort;
        this.hybridOverlayConfig = hybridOverlayConfig;
        this.ipsecConfig = ipsecConfig;
        this.mtu = mtu;
        this.policyAuditConfig = policyAuditConfig;
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

    @JsonProperty("mtu")
    public Integer getMtu() {
        return mtu;
    }

    @JsonProperty("mtu")
    public void setMtu(Integer mtu) {
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
