
package io.fabric8.kubernetes.api.model.clusterapi.v1beta1;

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
 * NetworkDataLinkVlan represents a vlan link object.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "macAddress",
    "mtu",
    "vlanID",
    "vlanLink"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
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

    public NetworkDataLinkVlan(String id, NetworkLinkEthernetMac macAddress, Integer mtu, Integer vlanID, String vlanLink) {
        super();
        this.id = id;
        this.macAddress = macAddress;
        this.mtu = mtu;
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

}
