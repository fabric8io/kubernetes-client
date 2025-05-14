
package io.fabric8.openshift.api.model.machine.v1beta1;

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
 * NetworkDeviceSpec defines the network configuration for a virtual machine's network device.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "addressesFromPools",
    "gateway",
    "ipAddrs",
    "nameservers",
    "networkName"
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
public class NetworkDeviceSpec implements Editable<NetworkDeviceSpecBuilder>, KubernetesResource
{

    @JsonProperty("addressesFromPools")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AddressesFromPool> addressesFromPools = new ArrayList<>();
    @JsonProperty("gateway")
    private String gateway;
    @JsonProperty("ipAddrs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> ipAddrs = new ArrayList<>();
    @JsonProperty("nameservers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> nameservers = new ArrayList<>();
    @JsonProperty("networkName")
    private String networkName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NetworkDeviceSpec() {
    }

    public NetworkDeviceSpec(List<AddressesFromPool> addressesFromPools, String gateway, List<String> ipAddrs, List<String> nameservers, String networkName) {
        super();
        this.addressesFromPools = addressesFromPools;
        this.gateway = gateway;
        this.ipAddrs = ipAddrs;
        this.nameservers = nameservers;
        this.networkName = networkName;
    }

    /**
     * addressesFromPools is a list of references to IP pool types and instances which are handled by an external controller. addressesFromPool configurations provided via addressesFromPools defer IP address assignment to an external controller. IP addresses provided via ipAddrs, however, are intended to allow explicit assignment of a machine's IP address. If both addressesFromPool and ipAddrs are empty or not defined, DHCP will assign an IP address. If both ipAddrs and addressesFromPools are defined, the IP addresses associated with ipAddrs will be applied first followed by IP addresses from addressesFromPools.
     */
    @JsonProperty("addressesFromPools")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AddressesFromPool> getAddressesFromPools() {
        return addressesFromPools;
    }

    /**
     * addressesFromPools is a list of references to IP pool types and instances which are handled by an external controller. addressesFromPool configurations provided via addressesFromPools defer IP address assignment to an external controller. IP addresses provided via ipAddrs, however, are intended to allow explicit assignment of a machine's IP address. If both addressesFromPool and ipAddrs are empty or not defined, DHCP will assign an IP address. If both ipAddrs and addressesFromPools are defined, the IP addresses associated with ipAddrs will be applied first followed by IP addresses from addressesFromPools.
     */
    @JsonProperty("addressesFromPools")
    public void setAddressesFromPools(List<AddressesFromPool> addressesFromPools) {
        this.addressesFromPools = addressesFromPools;
    }

    /**
     * gateway is an IPv4 or IPv6 address which represents the subnet gateway, for example, 192.168.1.1.
     */
    @JsonProperty("gateway")
    public String getGateway() {
        return gateway;
    }

    /**
     * gateway is an IPv4 or IPv6 address which represents the subnet gateway, for example, 192.168.1.1.
     */
    @JsonProperty("gateway")
    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    /**
     * ipAddrs is a list of one or more IPv4 and/or IPv6 addresses and CIDR to assign to this device, for example, 192.168.1.100/24. IP addresses provided via ipAddrs are intended to allow explicit assignment of a machine's IP address. IP pool configurations provided via addressesFromPool, however, defer IP address assignment to an external controller. If both addressesFromPool and ipAddrs are empty or not defined, DHCP will be used to assign an IP address. If both ipAddrs and addressesFromPools are defined, the IP addresses associated with ipAddrs will be applied first followed by IP addresses from addressesFromPools.
     */
    @JsonProperty("ipAddrs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getIpAddrs() {
        return ipAddrs;
    }

    /**
     * ipAddrs is a list of one or more IPv4 and/or IPv6 addresses and CIDR to assign to this device, for example, 192.168.1.100/24. IP addresses provided via ipAddrs are intended to allow explicit assignment of a machine's IP address. IP pool configurations provided via addressesFromPool, however, defer IP address assignment to an external controller. If both addressesFromPool and ipAddrs are empty or not defined, DHCP will be used to assign an IP address. If both ipAddrs and addressesFromPools are defined, the IP addresses associated with ipAddrs will be applied first followed by IP addresses from addressesFromPools.
     */
    @JsonProperty("ipAddrs")
    public void setIpAddrs(List<String> ipAddrs) {
        this.ipAddrs = ipAddrs;
    }

    /**
     * nameservers is a list of IPv4 and/or IPv6 addresses used as DNS nameservers, for example, 8.8.8.8. a nameserver is not provided by a fulfilled IPAddressClaim. If DHCP is not the source of IP addresses for this network device, nameservers should include a valid nameserver.
     */
    @JsonProperty("nameservers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getNameservers() {
        return nameservers;
    }

    /**
     * nameservers is a list of IPv4 and/or IPv6 addresses used as DNS nameservers, for example, 8.8.8.8. a nameserver is not provided by a fulfilled IPAddressClaim. If DHCP is not the source of IP addresses for this network device, nameservers should include a valid nameserver.
     */
    @JsonProperty("nameservers")
    public void setNameservers(List<String> nameservers) {
        this.nameservers = nameservers;
    }

    /**
     * networkName is the name of the vSphere network or port group to which the network device will be connected, for example, port-group-1. When not provided, the vCenter API will attempt to select a default network. The available networks (port groups) can be listed using `govc ls 'network/&#42;'`
     */
    @JsonProperty("networkName")
    public String getNetworkName() {
        return networkName;
    }

    /**
     * networkName is the name of the vSphere network or port group to which the network device will be connected, for example, port-group-1. When not provided, the vCenter API will attempt to select a default network. The available networks (port groups) can be listed using `govc ls 'network/&#42;'`
     */
    @JsonProperty("networkName")
    public void setNetworkName(String networkName) {
        this.networkName = networkName;
    }

    @JsonIgnore
    public NetworkDeviceSpecBuilder edit() {
        return new NetworkDeviceSpecBuilder(this);
    }

    @JsonIgnore
    public NetworkDeviceSpecBuilder toBuilder() {
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
