
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

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
 * NetworkInterface defines the network configuration for a specific interface.
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "hostNetworkAttachment",
    "macAddress",
    "name",
    "switchPort"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class NetworkInterface implements Editable<NetworkInterfaceBuilder>, KubernetesResource
{

    @JsonProperty("hostNetworkAttachment")
    private HostNetworkAttachmentRef hostNetworkAttachment;
    @JsonProperty("macAddress")
    private String macAddress;
    @JsonProperty("name")
    private String name;
    @JsonProperty("switchPort")
    private SwitchPort switchPort;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NetworkInterface() {
    }

    public NetworkInterface(HostNetworkAttachmentRef hostNetworkAttachment, String macAddress, String name, SwitchPort switchPort) {
        super();
        this.hostNetworkAttachment = hostNetworkAttachment;
        this.macAddress = macAddress;
        this.name = name;
        this.switchPort = switchPort;
    }

    /**
     * NetworkInterface defines the network configuration for a specific interface.
     */
    @JsonProperty("hostNetworkAttachment")
    public HostNetworkAttachmentRef getHostNetworkAttachment() {
        return hostNetworkAttachment;
    }

    /**
     * NetworkInterface defines the network configuration for a specific interface.
     */
    @JsonProperty("hostNetworkAttachment")
    public void setHostNetworkAttachment(HostNetworkAttachmentRef hostNetworkAttachment) {
        this.hostNetworkAttachment = hostNetworkAttachment;
    }

    /**
     * MAC address of the network interface.  This must match the MAC address of a NIC discovered during inspection (see HardwareData resource). Mutually exclusive with Name.
     */
    @JsonProperty("macAddress")
    public String getMacAddress() {
        return macAddress;
    }

    /**
     * MAC address of the network interface.  This must match the MAC address of a NIC discovered during inspection (see HardwareData resource). Mutually exclusive with Name.
     */
    @JsonProperty("macAddress")
    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    /**
     * Name of the network interface (e.g., "eth0", "ens1f0") This must match the name of a NIC discovered during inspection (see HardwareData resource). Mutually exclusive with MACAddress.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name of the network interface (e.g., "eth0", "ens1f0") This must match the name of a NIC discovered during inspection (see HardwareData resource). Mutually exclusive with MACAddress.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * NetworkInterface defines the network configuration for a specific interface.
     */
    @JsonProperty("switchPort")
    public SwitchPort getSwitchPort() {
        return switchPort;
    }

    /**
     * NetworkInterface defines the network configuration for a specific interface.
     */
    @JsonProperty("switchPort")
    public void setSwitchPort(SwitchPort switchPort) {
        this.switchPort = switchPort;
    }

    @JsonIgnore
    public NetworkInterfaceBuilder edit() {
        return new NetworkInterfaceBuilder(this);
    }

    @JsonIgnore
    public NetworkInterfaceBuilder toBuilder() {
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
