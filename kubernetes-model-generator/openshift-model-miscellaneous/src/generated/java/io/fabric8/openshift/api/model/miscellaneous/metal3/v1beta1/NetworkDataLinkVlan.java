
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

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
 * NetworkDataLinkVlan represents a vlan link object.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "macAddress",
    "mtu",
    "name",
    "vlanID",
    "vlanLink"
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
public class NetworkDataLinkVlan implements Editable<NetworkDataLinkVlanBuilder>, KubernetesResource
{

    @JsonProperty("id")
    private String id;
    @JsonProperty("macAddress")
    private NetworkLinkEthernetMac macAddress;
    @JsonProperty("mtu")
    private Integer mtu;
    @JsonProperty("name")
    private String name;
    @JsonProperty("vlanID")
    private Integer vlanID;
    @JsonProperty("vlanLink")
    private String vlanLink;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NetworkDataLinkVlan() {
    }

    public NetworkDataLinkVlan(String id, NetworkLinkEthernetMac macAddress, Integer mtu, String name, Integer vlanID, String vlanLink) {
        super();
        this.id = id;
        this.macAddress = macAddress;
        this.mtu = mtu;
        this.name = name;
        this.vlanID = vlanID;
        this.vlanLink = vlanLink;
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
     * NetworkDataLinkVlan represents a vlan link object.
     */
    @JsonProperty("macAddress")
    public NetworkLinkEthernetMac getMacAddress() {
        return macAddress;
    }

    /**
     * NetworkDataLinkVlan represents a vlan link object.
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
     * VlanID is the Vlan ID
     */
    @JsonProperty("vlanID")
    public Integer getVlanID() {
        return vlanID;
    }

    /**
     * VlanID is the Vlan ID
     */
    @JsonProperty("vlanID")
    public void setVlanID(Integer vlanID) {
        this.vlanID = vlanID;
    }

    /**
     * VlanLink is the name of the link on which the vlan should be added
     */
    @JsonProperty("vlanLink")
    public String getVlanLink() {
        return vlanLink;
    }

    /**
     * VlanLink is the name of the link on which the vlan should be added
     */
    @JsonProperty("vlanLink")
    public void setVlanLink(String vlanLink) {
        this.vlanLink = vlanLink;
    }

    @JsonIgnore
    public NetworkDataLinkVlanBuilder edit() {
        return new NetworkDataLinkVlanBuilder(this);
    }

    @JsonIgnore
    public NetworkDataLinkVlanBuilder toBuilder() {
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
        if (!(o instanceof NetworkDataLinkVlan)) {
            return false;
        }
        NetworkDataLinkVlan other = (NetworkDataLinkVlan) o;
        if (!other.canEqual(this)) {
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
        Object this$vlanID = this.getVlanID();
        Object other$vlanID = other.getVlanID();
        if (this$vlanID == null ? other$vlanID != null : !this$vlanID.equals(other$vlanID)) {
            return false;
        }
        Object this$vlanLink = this.getVlanLink();
        Object other$vlanLink = other.getVlanLink();
        if (this$vlanLink == null ? other$vlanLink != null : !this$vlanLink.equals(other$vlanLink)) {
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
        return other instanceof NetworkDataLinkVlan;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $id = this.getId();
        result = result * prime + ($id == null ? 43 : $id.hashCode());
        Object $macAddress = this.getMacAddress();
        result = result * prime + ($macAddress == null ? 43 : $macAddress.hashCode());
        Object $mtu = this.getMtu();
        result = result * prime + ($mtu == null ? 43 : $mtu.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $vlanID = this.getVlanID();
        result = result * prime + ($vlanID == null ? 43 : $vlanID.hashCode());
        Object $vlanLink = this.getVlanLink();
        result = result * prime + ($vlanLink == null ? 43 : $vlanLink.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NetworkDataLinkVlan(" + "id=" + this.getId() + ", macAddress=" + this.getMacAddress() + ", mtu=" + this.getMtu() + ", name=" + this.getName() + ", vlanID=" + this.getVlanID() + ", vlanLink=" + this.getVlanLink() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
