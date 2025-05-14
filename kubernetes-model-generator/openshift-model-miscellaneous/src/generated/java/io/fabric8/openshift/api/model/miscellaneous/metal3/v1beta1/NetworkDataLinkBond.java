
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
    "mtu"
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
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NetworkDataLinkBond() {
    }

    public NetworkDataLinkBond(List<String> bondLinks, String bondMode, String bondXmitHashPolicy, String id, NetworkLinkEthernetMac macAddress, Integer mtu) {
        super();
        this.bondLinks = bondLinks;
        this.bondMode = bondMode;
        this.bondXmitHashPolicy = bondXmitHashPolicy;
        this.id = id;
        this.macAddress = macAddress;
        this.mtu = mtu;
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

}
