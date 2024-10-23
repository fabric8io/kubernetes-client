
package io.fabric8.openshift.api.model.machine.v1beta1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
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
@Generated("jsonschema2pojo")
public class NetworkDeviceSpec implements Editable<NetworkDeviceSpecBuilder> , KubernetesResource
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
     * 
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

    @JsonProperty("addressesFromPools")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AddressesFromPool> getAddressesFromPools() {
        return addressesFromPools;
    }

    @JsonProperty("addressesFromPools")
    public void setAddressesFromPools(List<AddressesFromPool> addressesFromPools) {
        this.addressesFromPools = addressesFromPools;
    }

    @JsonProperty("gateway")
    public String getGateway() {
        return gateway;
    }

    @JsonProperty("gateway")
    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    @JsonProperty("ipAddrs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getIpAddrs() {
        return ipAddrs;
    }

    @JsonProperty("ipAddrs")
    public void setIpAddrs(List<String> ipAddrs) {
        this.ipAddrs = ipAddrs;
    }

    @JsonProperty("nameservers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getNameservers() {
        return nameservers;
    }

    @JsonProperty("nameservers")
    public void setNameservers(List<String> nameservers) {
        this.nameservers = nameservers;
    }

    @JsonProperty("networkName")
    public String getNetworkName() {
        return networkName;
    }

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
