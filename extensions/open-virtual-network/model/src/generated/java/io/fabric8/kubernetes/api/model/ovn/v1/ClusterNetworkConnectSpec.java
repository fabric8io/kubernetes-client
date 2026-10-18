
package io.fabric8.kubernetes.api.model.ovn.v1;

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
 * ClusterNetworkConnectSpec defines the desired state of ClusterNetworkConnect.
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "connectSubnets",
    "connectivity",
    "networkSelectors"
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
public class ClusterNetworkConnectSpec implements Editable<ClusterNetworkConnectSpecBuilder>, KubernetesResource
{

    @JsonProperty("connectSubnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ConnectSubnet> connectSubnets = new ArrayList<>();
    @JsonProperty("connectivity")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> connectivity = new ArrayList<>();
    @JsonProperty("networkSelectors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NetworkSelector> networkSelectors = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterNetworkConnectSpec() {
    }

    public ClusterNetworkConnectSpec(List<ConnectSubnet> connectSubnets, List<String> connectivity, List<NetworkSelector> networkSelectors) {
        super();
        this.connectSubnets = connectSubnets;
        this.connectivity = connectivity;
        this.networkSelectors = networkSelectors;
    }

    /**
     * connectSubnets specifies the subnets used for interconnecting the selected networks. This creates a shared subnet space that connected networks can use to communicate. Can have at most 1 CIDR for each IP family (IPv4 and IPv6). Must not overlap with:<br><p>  any of the pod subnets used by the selected networks.<br><p>  any of the transit subnets used by the selected networks.<br><p>  any of the service CIDR range used in the cluster.<br><p>  any of the join subnet of the selected networks to be connected.<br><p>  any of the masquerade subnet range used in the cluster.<br><p>  any of the node subnets chosen by the platform.<br><p>  any of other connect subnets for other ClusterNetworkConnects that might be selecting same networks.<br><p> <br><p> Does not have a default value for the above reason so that user takes care in setting non-overlapping subnets.
     */
    @JsonProperty("connectSubnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ConnectSubnet> getConnectSubnets() {
        return connectSubnets;
    }

    /**
     * connectSubnets specifies the subnets used for interconnecting the selected networks. This creates a shared subnet space that connected networks can use to communicate. Can have at most 1 CIDR for each IP family (IPv4 and IPv6). Must not overlap with:<br><p>  any of the pod subnets used by the selected networks.<br><p>  any of the transit subnets used by the selected networks.<br><p>  any of the service CIDR range used in the cluster.<br><p>  any of the join subnet of the selected networks to be connected.<br><p>  any of the masquerade subnet range used in the cluster.<br><p>  any of the node subnets chosen by the platform.<br><p>  any of other connect subnets for other ClusterNetworkConnects that might be selecting same networks.<br><p> <br><p> Does not have a default value for the above reason so that user takes care in setting non-overlapping subnets.
     */
    @JsonProperty("connectSubnets")
    public void setConnectSubnets(List<ConnectSubnet> connectSubnets) {
        this.connectSubnets = connectSubnets;
    }

    /**
     * connectivity specifies which connectivity types should be enabled for the connected networks.
     */
    @JsonProperty("connectivity")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getConnectivity() {
        return connectivity;
    }

    /**
     * connectivity specifies which connectivity types should be enabled for the connected networks.
     */
    @JsonProperty("connectivity")
    public void setConnectivity(List<String> connectivity) {
        this.connectivity = connectivity;
    }

    /**
     * networkSelectors selects the networks to be connected together. This can match User Defined Networks (UDNs) and/or Cluster User Defined Networks (CUDNs). Only ClusterUserDefinedNetworkSelector and PrimaryUserDefinedNetworkSelector can be selected.
     */
    @JsonProperty("networkSelectors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NetworkSelector> getNetworkSelectors() {
        return networkSelectors;
    }

    /**
     * networkSelectors selects the networks to be connected together. This can match User Defined Networks (UDNs) and/or Cluster User Defined Networks (CUDNs). Only ClusterUserDefinedNetworkSelector and PrimaryUserDefinedNetworkSelector can be selected.
     */
    @JsonProperty("networkSelectors")
    public void setNetworkSelectors(List<NetworkSelector> networkSelectors) {
        this.networkSelectors = networkSelectors;
    }

    @JsonIgnore
    public ClusterNetworkConnectSpecBuilder edit() {
        return new ClusterNetworkConnectSpecBuilder(this);
    }

    @JsonIgnore
    public ClusterNetworkConnectSpecBuilder toBuilder() {
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
