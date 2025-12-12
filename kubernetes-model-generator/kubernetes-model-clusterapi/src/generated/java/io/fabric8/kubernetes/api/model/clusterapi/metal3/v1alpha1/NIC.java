
package io.fabric8.kubernetes.api.model.clusterapi.metal3.v1alpha1;

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
 * NIC describes one network interface on the host.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ip",
    "mac",
    "model",
    "name",
    "pxe",
    "speedGbps",
    "vlanId",
    "vlans"
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
public class NIC implements Editable<NICBuilder>, KubernetesResource
{

    @JsonProperty("ip")
    private String ip;
    @JsonProperty("mac")
    private String mac;
    @JsonProperty("model")
    private String model;
    @JsonProperty("name")
    private String name;
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

    public NIC(String ip, String mac, String model, String name, Boolean pxe, Integer speedGbps, Integer vlanId, List<VLAN> vlans) {
        super();
        this.ip = ip;
        this.mac = mac;
        this.model = model;
        this.name = name;
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

}
