
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

@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cidr",
    "networkPrefix"
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
public class ConnectSubnet implements Editable<ConnectSubnetBuilder>, KubernetesResource
{

    @JsonProperty("cidr")
    private String cidr;
    @JsonProperty("networkPrefix")
    private Integer networkPrefix;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ConnectSubnet() {
    }

    public ConnectSubnet(String cidr, Integer networkPrefix) {
        super();
        this.cidr = cidr;
        this.networkPrefix = networkPrefix;
    }

    /**
     * CIDR specifies ConnectSubnet, which is split into smaller subnets for every connected network. This CIDR should be containing 2&#42;((Number of L3 networks&#42;Max Number of Nodes)+Number of L2 networks) IPs. Example: cidr= "192.168.0.0/16", networkPrefix=24 and if the cluster has 128 nodes that means that you can connect 256 layer3 networks and 0 layer2 networks OR 255 layer3 networks and 128 layer2 networks.<br><p> <br><p> CIDR also restricts the maximum number of networks that can be connected together based on what CIDR range is picked. So choosing a large enough CIDR for future use cases is important.<br><p> <br><p> The largest CIDR that can be used for this field is /16 (65536 IPs) because OVN has a limit of 32K(2^15) tunnel keys per router. So we will only ever have 32K /31 or /127 slices which is 2^16 IPs. Having a CIDR greater than /16 will not be utilized fully for the same reason.
     */
    @JsonProperty("cidr")
    public String getCidr() {
        return cidr;
    }

    /**
     * CIDR specifies ConnectSubnet, which is split into smaller subnets for every connected network. This CIDR should be containing 2&#42;((Number of L3 networks&#42;Max Number of Nodes)+Number of L2 networks) IPs. Example: cidr= "192.168.0.0/16", networkPrefix=24 and if the cluster has 128 nodes that means that you can connect 256 layer3 networks and 0 layer2 networks OR 255 layer3 networks and 128 layer2 networks.<br><p> <br><p> CIDR also restricts the maximum number of networks that can be connected together based on what CIDR range is picked. So choosing a large enough CIDR for future use cases is important.<br><p> <br><p> The largest CIDR that can be used for this field is /16 (65536 IPs) because OVN has a limit of 32K(2^15) tunnel keys per router. So we will only ever have 32K /31 or /127 slices which is 2^16 IPs. Having a CIDR greater than /16 will not be utilized fully for the same reason.
     */
    @JsonProperty("cidr")
    public void setCidr(String cidr) {
        this.cidr = cidr;
    }

    /**
     * NetworkPrefix specifies the prefix length for every connected network. This prefix length should be strictly longer than the length of the CIDR prefix.<br><p> <br><p> For example, if the CIDR is 10.0.0.0/16 and the networkPrefix is 24, then the connect subnet for each connected layer3 network will be 10.0.0.0/24, 10.0.1.0/24, 10.0.2.0/24 etc.<br><p> <br><p> For layer2 networks we will allocate the next available /networkPrefix range that is then split into /31 or /127 slices for each layer2 network A good practice is to set this to a value that ensures it contains more than twice the number of maximum nodes planned to be deployed in the cluster. Each node gets a /31 subnet for the layer3 networks, hence networkPrefix should contain enough IPs for 4 times the maximum nodes planned Example - recommended values: if you plan to deploy 10 nodes, set the networkPrefix to /26 (40+ IPs) if you plan to deploy 100 nodes, set the networkPrefix to /23 (400+ IPs) if you plan to deploy 1000 nodes, set the networkPrefix to /20 (4000+ IPs) if you plan to deploy 5000 nodes, set the networkPrefix to /17 (20000+ IPs) This field restricts the maximum number of nodes that can be deployed in the cluster and hence its good to plan this value carefully along with the CIDR.
     */
    @JsonProperty("networkPrefix")
    public Integer getNetworkPrefix() {
        return networkPrefix;
    }

    /**
     * NetworkPrefix specifies the prefix length for every connected network. This prefix length should be strictly longer than the length of the CIDR prefix.<br><p> <br><p> For example, if the CIDR is 10.0.0.0/16 and the networkPrefix is 24, then the connect subnet for each connected layer3 network will be 10.0.0.0/24, 10.0.1.0/24, 10.0.2.0/24 etc.<br><p> <br><p> For layer2 networks we will allocate the next available /networkPrefix range that is then split into /31 or /127 slices for each layer2 network A good practice is to set this to a value that ensures it contains more than twice the number of maximum nodes planned to be deployed in the cluster. Each node gets a /31 subnet for the layer3 networks, hence networkPrefix should contain enough IPs for 4 times the maximum nodes planned Example - recommended values: if you plan to deploy 10 nodes, set the networkPrefix to /26 (40+ IPs) if you plan to deploy 100 nodes, set the networkPrefix to /23 (400+ IPs) if you plan to deploy 1000 nodes, set the networkPrefix to /20 (4000+ IPs) if you plan to deploy 5000 nodes, set the networkPrefix to /17 (20000+ IPs) This field restricts the maximum number of nodes that can be deployed in the cluster and hence its good to plan this value carefully along with the CIDR.
     */
    @JsonProperty("networkPrefix")
    public void setNetworkPrefix(Integer networkPrefix) {
        this.networkPrefix = networkPrefix;
    }

    @JsonIgnore
    public ConnectSubnetBuilder edit() {
        return new ConnectSubnetBuilder(this);
    }

    @JsonIgnore
    public ConnectSubnetBuilder toBuilder() {
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
