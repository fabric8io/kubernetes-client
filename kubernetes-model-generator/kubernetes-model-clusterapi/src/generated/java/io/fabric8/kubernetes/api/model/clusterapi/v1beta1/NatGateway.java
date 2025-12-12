
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
 * NatGateway defines an Azure NAT gateway. NAT gateway resources are part of Vnet NAT and provide outbound Internet connectivity for subnets of a virtual network.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "ip",
    "name",
    "zones"
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
public class NatGateway implements Editable<NatGatewayBuilder>, KubernetesResource
{

    @JsonProperty("id")
    private String id;
    @JsonProperty("ip")
    private PublicIPSpec ip;
    @JsonProperty("name")
    private String name;
    @JsonProperty("zones")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> zones = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NatGateway() {
    }

    public NatGateway(String id, PublicIPSpec ip, String name, List<String> zones) {
        super();
        this.id = id;
        this.ip = ip;
        this.name = name;
        this.zones = zones;
    }

    /**
     * ID is the Azure resource ID of the NAT gateway. READ-ONLY
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * ID is the Azure resource ID of the NAT gateway. READ-ONLY
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * NatGateway defines an Azure NAT gateway. NAT gateway resources are part of Vnet NAT and provide outbound Internet connectivity for subnets of a virtual network.
     */
    @JsonProperty("ip")
    public PublicIPSpec getIp() {
        return ip;
    }

    /**
     * NatGateway defines an Azure NAT gateway. NAT gateway resources are part of Vnet NAT and provide outbound Internet connectivity for subnets of a virtual network.
     */
    @JsonProperty("ip")
    public void setIp(PublicIPSpec ip) {
        this.ip = ip;
    }

    /**
     * NatGateway defines an Azure NAT gateway. NAT gateway resources are part of Vnet NAT and provide outbound Internet connectivity for subnets of a virtual network.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * NatGateway defines an Azure NAT gateway. NAT gateway resources are part of Vnet NAT and provide outbound Internet connectivity for subnets of a virtual network.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Zones mentions the list of zones the NAT gateway should be a part of.
     */
    @JsonProperty("zones")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getZones() {
        return zones;
    }

    /**
     * Zones mentions the list of zones the NAT gateway should be a part of.
     */
    @JsonProperty("zones")
    public void setZones(List<String> zones) {
        this.zones = zones;
    }

    @JsonIgnore
    public NatGatewayBuilder edit() {
        return new NatGatewayBuilder(this);
    }

    @JsonIgnore
    public NatGatewayBuilder toBuilder() {
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
