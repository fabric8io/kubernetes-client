
package io.fabric8.openshift.api.model.config.v1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * VSpherePlatformNodeNetworkingSpec holds the network CIDR(s) and port group name for including and excluding IP ranges in the cloud provider. This would be used for example when multiple network adapters are attached to a guest to help determine which IP address the cloud config manager should use for the external and internal node networking.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "excludeNetworkSubnetCidr",
    "network",
    "networkSubnetCidr"
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
public class VSpherePlatformNodeNetworkingSpec implements Editable<VSpherePlatformNodeNetworkingSpecBuilder>, KubernetesResource
{

    @JsonProperty("excludeNetworkSubnetCidr")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> excludeNetworkSubnetCidr = new ArrayList<>();
    @JsonProperty("network")
    private String network;
    @JsonProperty("networkSubnetCidr")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> networkSubnetCidr = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VSpherePlatformNodeNetworkingSpec() {
    }

    public VSpherePlatformNodeNetworkingSpec(List<String> excludeNetworkSubnetCidr, String network, List<String> networkSubnetCidr) {
        super();
        this.excludeNetworkSubnetCidr = excludeNetworkSubnetCidr;
        this.network = network;
        this.networkSubnetCidr = networkSubnetCidr;
    }

    /**
     * excludeNetworkSubnetCidr IP addresses in subnet ranges will be excluded when selecting the IP address from the VirtualMachine's VM for use in the status.addresses fields.
     */
    @JsonProperty("excludeNetworkSubnetCidr")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getExcludeNetworkSubnetCidr() {
        return excludeNetworkSubnetCidr;
    }

    /**
     * excludeNetworkSubnetCidr IP addresses in subnet ranges will be excluded when selecting the IP address from the VirtualMachine's VM for use in the status.addresses fields.
     */
    @JsonProperty("excludeNetworkSubnetCidr")
    public void setExcludeNetworkSubnetCidr(List<String> excludeNetworkSubnetCidr) {
        this.excludeNetworkSubnetCidr = excludeNetworkSubnetCidr;
    }

    /**
     * network VirtualMachine's VM Network names that will be used to when searching for status.addresses fields. Note that if internal.networkSubnetCIDR and external.networkSubnetCIDR are not set, then the vNIC associated to this network must only have a single IP address assigned to it. The available networks (port groups) can be listed using `govc ls 'network/&#42;'`
     */
    @JsonProperty("network")
    public String getNetwork() {
        return network;
    }

    /**
     * network VirtualMachine's VM Network names that will be used to when searching for status.addresses fields. Note that if internal.networkSubnetCIDR and external.networkSubnetCIDR are not set, then the vNIC associated to this network must only have a single IP address assigned to it. The available networks (port groups) can be listed using `govc ls 'network/&#42;'`
     */
    @JsonProperty("network")
    public void setNetwork(String network) {
        this.network = network;
    }

    /**
     * networkSubnetCidr IP address on VirtualMachine's network interfaces included in the fields' CIDRs that will be used in respective status.addresses fields.
     */
    @JsonProperty("networkSubnetCidr")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getNetworkSubnetCidr() {
        return networkSubnetCidr;
    }

    /**
     * networkSubnetCidr IP address on VirtualMachine's network interfaces included in the fields' CIDRs that will be used in respective status.addresses fields.
     */
    @JsonProperty("networkSubnetCidr")
    public void setNetworkSubnetCidr(List<String> networkSubnetCidr) {
        this.networkSubnetCidr = networkSubnetCidr;
    }

    @JsonIgnore
    public VSpherePlatformNodeNetworkingSpecBuilder edit() {
        return new VSpherePlatformNodeNetworkingSpecBuilder(this);
    }

    @JsonIgnore
    public VSpherePlatformNodeNetworkingSpecBuilder toBuilder() {
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
