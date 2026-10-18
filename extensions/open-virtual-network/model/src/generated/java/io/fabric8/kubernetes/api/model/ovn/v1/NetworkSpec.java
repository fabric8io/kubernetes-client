
package io.fabric8.kubernetes.api.model.ovn.v1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
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
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * NetworkSpec defines the desired state of UserDefinedNetworkSpec.
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "evpn",
    "layer2",
    "layer3",
    "localnet",
    "noOverlay",
    "topology",
    "transport"
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
public class NetworkSpec implements Editable<NetworkSpecBuilder>, KubernetesResource
{

    @JsonProperty("evpn")
    private EVPNConfig evpn;
    @JsonProperty("layer2")
    private Layer2Config layer2;
    @JsonProperty("layer3")
    private Layer3Config layer3;
    @JsonProperty("localnet")
    private LocalnetConfig localnet;
    @JsonProperty("noOverlay")
    private NoOverlayConfig noOverlay;
    @JsonProperty("topology")
    private String topology;
    @JsonProperty("transport")
    private String transport;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NetworkSpec() {
    }

    public NetworkSpec(EVPNConfig evpn, Layer2Config layer2, Layer3Config layer3, LocalnetConfig localnet, NoOverlayConfig noOverlay, String topology, String transport) {
        super();
        this.evpn = evpn;
        this.layer2 = layer2;
        this.layer3 = layer3;
        this.localnet = localnet;
        this.noOverlay = noOverlay;
        this.topology = topology;
        this.transport = transport;
    }

    /**
     * NetworkSpec defines the desired state of UserDefinedNetworkSpec.
     */
    @JsonProperty("evpn")
    public EVPNConfig getEvpn() {
        return evpn;
    }

    /**
     * NetworkSpec defines the desired state of UserDefinedNetworkSpec.
     */
    @JsonProperty("evpn")
    public void setEvpn(EVPNConfig evpn) {
        this.evpn = evpn;
    }

    /**
     * NetworkSpec defines the desired state of UserDefinedNetworkSpec.
     */
    @JsonProperty("layer2")
    public Layer2Config getLayer2() {
        return layer2;
    }

    /**
     * NetworkSpec defines the desired state of UserDefinedNetworkSpec.
     */
    @JsonProperty("layer2")
    public void setLayer2(Layer2Config layer2) {
        this.layer2 = layer2;
    }

    /**
     * NetworkSpec defines the desired state of UserDefinedNetworkSpec.
     */
    @JsonProperty("layer3")
    public Layer3Config getLayer3() {
        return layer3;
    }

    /**
     * NetworkSpec defines the desired state of UserDefinedNetworkSpec.
     */
    @JsonProperty("layer3")
    public void setLayer3(Layer3Config layer3) {
        this.layer3 = layer3;
    }

    /**
     * NetworkSpec defines the desired state of UserDefinedNetworkSpec.
     */
    @JsonProperty("localnet")
    public LocalnetConfig getLocalnet() {
        return localnet;
    }

    /**
     * NetworkSpec defines the desired state of UserDefinedNetworkSpec.
     */
    @JsonProperty("localnet")
    public void setLocalnet(LocalnetConfig localnet) {
        this.localnet = localnet;
    }

    /**
     * NetworkSpec defines the desired state of UserDefinedNetworkSpec.
     */
    @JsonProperty("noOverlay")
    public NoOverlayConfig getNoOverlay() {
        return noOverlay;
    }

    /**
     * NetworkSpec defines the desired state of UserDefinedNetworkSpec.
     */
    @JsonProperty("noOverlay")
    public void setNoOverlay(NoOverlayConfig noOverlay) {
        this.noOverlay = noOverlay;
    }

    /**
     * Topology describes network configuration.<br><p> <br><p> Allowed values are "Layer3", "Layer2" and "Localnet". Layer3 topology creates a layer 2 segment per node, each with a different subnet. Layer 3 routing is used to interconnect node subnets. Layer2 topology creates one logical switch shared by all nodes. Localnet topology is based on layer 2 topology, but also allows connecting to an existent (configured) physical network to provide north-south traffic to the workloads.
     */
    @JsonProperty("topology")
    public String getTopology() {
        return topology;
    }

    /**
     * Topology describes network configuration.<br><p> <br><p> Allowed values are "Layer3", "Layer2" and "Localnet". Layer3 topology creates a layer 2 segment per node, each with a different subnet. Layer 3 routing is used to interconnect node subnets. Layer2 topology creates one logical switch shared by all nodes. Localnet topology is based on layer 2 topology, but also allows connecting to an existent (configured) physical network to provide north-south traffic to the workloads.
     */
    @JsonProperty("topology")
    public void setTopology(String topology) {
        this.topology = topology;
    }

    /**
     * Transport describes the transport technology for pod-to-pod traffic. Allowed values are "NoOverlay" and "EVPN". - "NoOverlay": The network operates in no-overlay mode. - "EVPN": The network uses EVPN transport. When omitted, the network uses the default OVN overlay transport (e.g. Geneve, VXLAN) as configured by ovn-encap-type.
     */
    @JsonProperty("transport")
    public String getTransport() {
        return transport;
    }

    /**
     * Transport describes the transport technology for pod-to-pod traffic. Allowed values are "NoOverlay" and "EVPN". - "NoOverlay": The network operates in no-overlay mode. - "EVPN": The network uses EVPN transport. When omitted, the network uses the default OVN overlay transport (e.g. Geneve, VXLAN) as configured by ovn-encap-type.
     */
    @JsonProperty("transport")
    public void setTransport(String transport) {
        this.transport = transport;
    }

    @JsonIgnore
    public NetworkSpecBuilder edit() {
        return new NetworkSpecBuilder(this);
    }

    @JsonIgnore
    public NetworkSpecBuilder toBuilder() {
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
