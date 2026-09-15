
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

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
import com.fasterxml.jackson.databind.JsonNode;
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
 * NetworkDataLinkBond represents a bond link object.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bondLinks",
    "bondMode",
    "bondXmitHashPolicy",
    "id",
    "macAddress",
    "mtu",
    "name",
    "parameters"
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
public class NetworkDataLinkBond implements Editable<NetworkDataLinkBondBuilder>, KubernetesResource
{

    @JsonProperty("bondLinks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> bondLinks = new ArrayList<>();
    @JsonProperty("bondMode")
    private String bondMode;
    @JsonProperty("bondXmitHashPolicy")
    private String bondXmitHashPolicy;
    @JsonProperty("id")
    private String id;
    @JsonProperty("macAddress")
    private NetworkLinkEthernetMac macAddress;
    @JsonProperty("mtu")
    private Integer mtu;
    @JsonProperty("name")
    private String name;
    @JsonProperty("parameters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, JsonNode> parameters = new LinkedHashMap<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NetworkDataLinkBond() {
    }

    public NetworkDataLinkBond(List<String> bondLinks, String bondMode, String bondXmitHashPolicy, String id, NetworkLinkEthernetMac macAddress, Integer mtu, String name, Map<String, JsonNode> parameters) {
        super();
        this.bondLinks = bondLinks;
        this.bondMode = bondMode;
        this.bondXmitHashPolicy = bondXmitHashPolicy;
        this.id = id;
        this.macAddress = macAddress;
        this.mtu = mtu;
        this.name = name;
        this.parameters = parameters;
    }

    /**
     * BondLinks is the list of links that are part of the bond.
     */
    @JsonProperty("bondLinks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getBondLinks() {
        return bondLinks;
    }

    /**
     * BondLinks is the list of links that are part of the bond.
     */
    @JsonProperty("bondLinks")
    public void setBondLinks(List<String> bondLinks) {
        this.bondLinks = bondLinks;
    }

    /**
     * BondMode is the mode of bond used. It can be one of balance-rr, active-backup, balance-xor, broadcast, balance-tlb, balance-alb, 802.3ad
     */
    @JsonProperty("bondMode")
    public String getBondMode() {
        return bondMode;
    }

    /**
     * BondMode is the mode of bond used. It can be one of balance-rr, active-backup, balance-xor, broadcast, balance-tlb, balance-alb, 802.3ad
     */
    @JsonProperty("bondMode")
    public void setBondMode(String bondMode) {
        this.bondMode = bondMode;
    }

    /**
     * Selects the transmit hash policy used for port selection in balance-xor and 802.3ad modes
     */
    @JsonProperty("bondXmitHashPolicy")
    public String getBondXmitHashPolicy() {
        return bondXmitHashPolicy;
    }

    /**
     * Selects the transmit hash policy used for port selection in balance-xor and 802.3ad modes
     */
    @JsonProperty("bondXmitHashPolicy")
    public void setBondXmitHashPolicy(String bondXmitHashPolicy) {
        this.bondXmitHashPolicy = bondXmitHashPolicy;
    }

    /**
     * Id is the ID of the interface (used for naming)
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * Id is the ID of the interface (used for naming)
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * NetworkDataLinkBond represents a bond link object.
     */
    @JsonProperty("macAddress")
    public NetworkLinkEthernetMac getMacAddress() {
        return macAddress;
    }

    /**
     * NetworkDataLinkBond represents a bond link object.
     */
    @JsonProperty("macAddress")
    public void setMacAddress(NetworkLinkEthernetMac macAddress) {
        this.macAddress = macAddress;
    }

    /**
     * MTU is the MTU of the interface
     */
    @JsonProperty("mtu")
    public Integer getMtu() {
        return mtu;
    }

    /**
     * MTU is the MTU of the interface
     */
    @JsonProperty("mtu")
    public void setMtu(Integer mtu) {
        this.mtu = mtu;
    }

    /**
     * Name is the interface name to be used by cloud-init. When combined with MACAddress, cloud-init will rename the interface matching the MAC to this name. When MACAddress is omitted, cloud-init will use this name directly.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name is the interface name to be used by cloud-init. When combined with MACAddress, cloud-init will rename the interface matching the MAC to this name. When MACAddress is omitted, cloud-init will use this name directly.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * params blob passed without any validation/modifications into cloud-init config
     */
    @JsonProperty("parameters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, JsonNode> getParameters() {
        return parameters;
    }

    /**
     * params blob passed without any validation/modifications into cloud-init config
     */
    @JsonProperty("parameters")
    public void setParameters(Map<String, JsonNode> parameters) {
        this.parameters = parameters;
    }

    @JsonIgnore
    public NetworkDataLinkBondBuilder edit() {
        return new NetworkDataLinkBondBuilder(this);
    }

    @JsonIgnore
    public NetworkDataLinkBondBuilder toBuilder() {
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
        if (!(o instanceof NetworkDataLinkBond)) {
            return false;
        }
        NetworkDataLinkBond other = (NetworkDataLinkBond) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$bondLinks = this.getBondLinks();
        Object other$bondLinks = other.getBondLinks();
        if (this$bondLinks == null ? other$bondLinks != null : !this$bondLinks.equals(other$bondLinks)) {
            return false;
        }
        Object this$bondMode = this.getBondMode();
        Object other$bondMode = other.getBondMode();
        if (this$bondMode == null ? other$bondMode != null : !this$bondMode.equals(other$bondMode)) {
            return false;
        }
        Object this$bondXmitHashPolicy = this.getBondXmitHashPolicy();
        Object other$bondXmitHashPolicy = other.getBondXmitHashPolicy();
        if (this$bondXmitHashPolicy == null ? other$bondXmitHashPolicy != null : !this$bondXmitHashPolicy.equals(other$bondXmitHashPolicy)) {
            return false;
        }
        Object this$id = this.getId();
        Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) {
            return false;
        }
        Object this$macAddress = this.getMacAddress();
        Object other$macAddress = other.getMacAddress();
        if (this$macAddress == null ? other$macAddress != null : !this$macAddress.equals(other$macAddress)) {
            return false;
        }
        Object this$mtu = this.getMtu();
        Object other$mtu = other.getMtu();
        if (this$mtu == null ? other$mtu != null : !this$mtu.equals(other$mtu)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$parameters = this.getParameters();
        Object other$parameters = other.getParameters();
        if (this$parameters == null ? other$parameters != null : !this$parameters.equals(other$parameters)) {
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
        return other instanceof NetworkDataLinkBond;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $bondLinks = this.getBondLinks();
        result = result * prime + ($bondLinks == null ? 43 : $bondLinks.hashCode());
        Object $bondMode = this.getBondMode();
        result = result * prime + ($bondMode == null ? 43 : $bondMode.hashCode());
        Object $bondXmitHashPolicy = this.getBondXmitHashPolicy();
        result = result * prime + ($bondXmitHashPolicy == null ? 43 : $bondXmitHashPolicy.hashCode());
        Object $id = this.getId();
        result = result * prime + ($id == null ? 43 : $id.hashCode());
        Object $macAddress = this.getMacAddress();
        result = result * prime + ($macAddress == null ? 43 : $macAddress.hashCode());
        Object $mtu = this.getMtu();
        result = result * prime + ($mtu == null ? 43 : $mtu.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $parameters = this.getParameters();
        result = result * prime + ($parameters == null ? 43 : $parameters.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NetworkDataLinkBond(" + "bondLinks=" + this.getBondLinks() + ", bondMode=" + this.getBondMode() + ", bondXmitHashPolicy=" + this.getBondXmitHashPolicy() + ", id=" + this.getId() + ", macAddress=" + this.getMacAddress() + ", mtu=" + this.getMtu() + ", name=" + this.getName() + ", parameters=" + this.getParameters() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
