
package io.fabric8.kubernetes.api.model.clusterapi.v1beta1;

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
 * NetworkDataLink contains list of different link objects.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bonds",
    "ethernets",
    "vlans"
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
public class NetworkDataLink implements Editable<NetworkDataLinkBuilder>, KubernetesResource
{

    @JsonProperty("bonds")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NetworkDataLinkBond> bonds = new ArrayList<>();
    @JsonProperty("ethernets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NetworkDataLinkEthernet> ethernets = new ArrayList<>();
    @JsonProperty("vlans")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NetworkDataLinkVlan> vlans = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NetworkDataLink() {
    }

    public NetworkDataLink(List<NetworkDataLinkBond> bonds, List<NetworkDataLinkEthernet> ethernets, List<NetworkDataLinkVlan> vlans) {
        super();
        this.bonds = bonds;
        this.ethernets = ethernets;
        this.vlans = vlans;
    }

    /**
     * Bonds contains a list of Bond links
     */
    @JsonProperty("bonds")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NetworkDataLinkBond> getBonds() {
        return bonds;
    }

    /**
     * Bonds contains a list of Bond links
     */
    @JsonProperty("bonds")
    public void setBonds(List<NetworkDataLinkBond> bonds) {
        this.bonds = bonds;
    }

    /**
     * Ethernets contains a list of Ethernet links
     */
    @JsonProperty("ethernets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NetworkDataLinkEthernet> getEthernets() {
        return ethernets;
    }

    /**
     * Ethernets contains a list of Ethernet links
     */
    @JsonProperty("ethernets")
    public void setEthernets(List<NetworkDataLinkEthernet> ethernets) {
        this.ethernets = ethernets;
    }

    /**
     * Vlans contains a list of Vlan links
     */
    @JsonProperty("vlans")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NetworkDataLinkVlan> getVlans() {
        return vlans;
    }

    /**
     * Vlans contains a list of Vlan links
     */
    @JsonProperty("vlans")
    public void setVlans(List<NetworkDataLinkVlan> vlans) {
        this.vlans = vlans;
    }

    @JsonIgnore
    public NetworkDataLinkBuilder edit() {
        return new NetworkDataLinkBuilder(this);
    }

    @JsonIgnore
    public NetworkDataLinkBuilder toBuilder() {
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
