
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * NIC describes one network interface on the host.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ip",
    "lldp",
    "mac",
    "model",
    "name",
    "pciAddress",
    "pxe",
    "speedGbps",
    "vlanId",
    "vlans"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class NIC implements Editable<NICBuilder>, KubernetesResource
{

    @JsonProperty("ip")
    private String ip;
    @JsonProperty("lldp")
    private LLDP lldp;
    @JsonProperty("mac")
    private String mac;
    @JsonProperty("model")
    private String model;
    @JsonProperty("name")
    private String name;
    @JsonProperty("pciAddress")
    private String pciAddress;
    @JsonProperty("pxe")
    private Boolean pxe;
    @JsonProperty("speedGbps")
    private Integer speedGbps;
    @JsonProperty("vlanId")
    private Integer vlanId;
    @JsonProperty("vlans")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<VLAN> vlans = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NIC() {
    }

    public NIC(String ip, LLDP lldp, String mac, String model, String name, String pciAddress, Boolean pxe, Integer speedGbps, Integer vlanId, List<VLAN> vlans) {
        super();
        this.ip = ip;
        this.lldp = lldp;
        this.mac = mac;
        this.model = model;
        this.name = name;
        this.pciAddress = pciAddress;
        this.pxe = pxe;
        this.speedGbps = speedGbps;
        this.vlanId = vlanId;
        this.vlans = vlans;
    }

    /**
     * The IP address of the interface. This will be an IPv4 or IPv6 address if one is present.  If both IPv4 and IPv6 addresses are present in a dual-stack environment, two nics will be output, one with each IP.
     */
    @JsonProperty("ip")
    public String getIp() {
        return ip;
    }

    /**
     * The IP address of the interface. This will be an IPv4 or IPv6 address if one is present.  If both IPv4 and IPv6 addresses are present in a dual-stack environment, two nics will be output, one with each IP.
     */
    @JsonProperty("ip")
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * NIC describes one network interface on the host.
     */
    @JsonProperty("lldp")
    public LLDP getLldp() {
        return lldp;
    }

    /**
     * NIC describes one network interface on the host.
     */
    @JsonProperty("lldp")
    public void setLldp(LLDP lldp) {
        this.lldp = lldp;
    }

    /**
     * The device MAC address
     */
    @JsonProperty("mac")
    public String getMac() {
        return mac;
    }

    /**
     * The device MAC address
     */
    @JsonProperty("mac")
    public void setMac(String mac) {
        this.mac = mac;
    }

    /**
     * The vendor and product IDs of the NIC, e.g. "0x8086 0x1572"
     */
    @JsonProperty("model")
    public String getModel() {
        return model;
    }

    /**
     * The vendor and product IDs of the NIC, e.g. "0x8086 0x1572"
     */
    @JsonProperty("model")
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * The name of the network interface, e.g. "en0"
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * The name of the network interface, e.g. "en0"
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * The NIC PCI address
     */
    @JsonProperty("pciAddress")
    public String getPciAddress() {
        return pciAddress;
    }

    /**
     * The NIC PCI address
     */
    @JsonProperty("pciAddress")
    public void setPciAddress(String pciAddress) {
        this.pciAddress = pciAddress;
    }

    /**
     * Whether the NIC is PXE Bootable
     */
    @JsonProperty("pxe")
    public Boolean getPxe() {
        return pxe;
    }

    /**
     * Whether the NIC is PXE Bootable
     */
    @JsonProperty("pxe")
    public void setPxe(Boolean pxe) {
        this.pxe = pxe;
    }

    /**
     * The speed of the device in Gigabits per second
     */
    @JsonProperty("speedGbps")
    public Integer getSpeedGbps() {
        return speedGbps;
    }

    /**
     * The speed of the device in Gigabits per second
     */
    @JsonProperty("speedGbps")
    public void setSpeedGbps(Integer speedGbps) {
        this.speedGbps = speedGbps;
    }

    /**
     * The untagged VLAN ID
     */
    @JsonProperty("vlanId")
    public Integer getVlanId() {
        return vlanId;
    }

    /**
     * The untagged VLAN ID
     */
    @JsonProperty("vlanId")
    public void setVlanId(Integer vlanId) {
        this.vlanId = vlanId;
    }

    /**
     * The VLANs available
     */
    @JsonProperty("vlans")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<VLAN> getVlans() {
        return vlans;
    }

    /**
     * The VLANs available
     */
    @JsonProperty("vlans")
    public void setVlans(List<VLAN> vlans) {
        this.vlans = vlans;
    }

    @JsonIgnore
    public NICBuilder edit() {
        return new NICBuilder(this);
    }

    @JsonIgnore
    public NICBuilder toBuilder() {
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
        if (!(o instanceof NIC)) {
            return false;
        }
        NIC other = (NIC) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$ip = this.getIp();
        Object other$ip = other.getIp();
        if (this$ip == null ? other$ip != null : !this$ip.equals(other$ip)) {
            return false;
        }
        Object this$lldp = this.getLldp();
        Object other$lldp = other.getLldp();
        if (this$lldp == null ? other$lldp != null : !this$lldp.equals(other$lldp)) {
            return false;
        }
        Object this$mac = this.getMac();
        Object other$mac = other.getMac();
        if (this$mac == null ? other$mac != null : !this$mac.equals(other$mac)) {
            return false;
        }
        Object this$model = this.getModel();
        Object other$model = other.getModel();
        if (this$model == null ? other$model != null : !this$model.equals(other$model)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$pciAddress = this.getPciAddress();
        Object other$pciAddress = other.getPciAddress();
        if (this$pciAddress == null ? other$pciAddress != null : !this$pciAddress.equals(other$pciAddress)) {
            return false;
        }
        Object this$pxe = this.getPxe();
        Object other$pxe = other.getPxe();
        if (this$pxe == null ? other$pxe != null : !this$pxe.equals(other$pxe)) {
            return false;
        }
        Object this$speedGbps = this.getSpeedGbps();
        Object other$speedGbps = other.getSpeedGbps();
        if (this$speedGbps == null ? other$speedGbps != null : !this$speedGbps.equals(other$speedGbps)) {
            return false;
        }
        Object this$vlanId = this.getVlanId();
        Object other$vlanId = other.getVlanId();
        if (this$vlanId == null ? other$vlanId != null : !this$vlanId.equals(other$vlanId)) {
            return false;
        }
        Object this$vlans = this.getVlans();
        Object other$vlans = other.getVlans();
        if (this$vlans == null ? other$vlans != null : !this$vlans.equals(other$vlans)) {
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
        return other instanceof NIC;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $ip = this.getIp();
        result = result * prime + ($ip == null ? 43 : $ip.hashCode());
        Object $lldp = this.getLldp();
        result = result * prime + ($lldp == null ? 43 : $lldp.hashCode());
        Object $mac = this.getMac();
        result = result * prime + ($mac == null ? 43 : $mac.hashCode());
        Object $model = this.getModel();
        result = result * prime + ($model == null ? 43 : $model.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $pciAddress = this.getPciAddress();
        result = result * prime + ($pciAddress == null ? 43 : $pciAddress.hashCode());
        Object $pxe = this.getPxe();
        result = result * prime + ($pxe == null ? 43 : $pxe.hashCode());
        Object $speedGbps = this.getSpeedGbps();
        result = result * prime + ($speedGbps == null ? 43 : $speedGbps.hashCode());
        Object $vlanId = this.getVlanId();
        result = result * prime + ($vlanId == null ? 43 : $vlanId.hashCode());
        Object $vlans = this.getVlans();
        result = result * prime + ($vlans == null ? 43 : $vlans.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NIC(" + "ip=" + this.getIp() + ", lldp=" + this.getLldp() + ", mac=" + this.getMac() + ", model=" + this.getModel() + ", name=" + this.getName() + ", pciAddress=" + this.getPciAddress() + ", pxe=" + this.getPxe() + ", speedGbps=" + this.getSpeedGbps() + ", vlanId=" + this.getVlanId() + ", vlans=" + this.getVlans() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
