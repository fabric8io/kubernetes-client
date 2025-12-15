
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

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
 * NetworkSpec specifies what the Azure networking resources should look like.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "additionalAPIServerLBPorts",
    "apiServerLB",
    "controlPlaneOutboundLB",
    "nodeOutboundLB",
    "privateDNSZone",
    "privateDNSZoneName",
    "privateDNSZoneResourceGroup",
    "subnets",
    "vnet"
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

    @JsonProperty("additionalAPIServerLBPorts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<LoadBalancerPort> additionalAPIServerLBPorts = new ArrayList<>();
    @JsonProperty("apiServerLB")
    private LoadBalancerSpec apiServerLB;
    @JsonProperty("controlPlaneOutboundLB")
    private LoadBalancerSpec controlPlaneOutboundLB;
    @JsonProperty("nodeOutboundLB")
    private LoadBalancerSpec nodeOutboundLB;
    @JsonProperty("privateDNSZone")
    private String privateDNSZone;
    @JsonProperty("privateDNSZoneName")
    private String privateDNSZoneName;
    @JsonProperty("privateDNSZoneResourceGroup")
    private String privateDNSZoneResourceGroup;
    @JsonProperty("subnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SubnetSpec> subnets = new ArrayList<>();
    @JsonProperty("vnet")
    private VnetSpec vnet;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NetworkSpec() {
    }

    public NetworkSpec(List<LoadBalancerPort> additionalAPIServerLBPorts, LoadBalancerSpec apiServerLB, LoadBalancerSpec controlPlaneOutboundLB, LoadBalancerSpec nodeOutboundLB, String privateDNSZone, String privateDNSZoneName, String privateDNSZoneResourceGroup, List<SubnetSpec> subnets, VnetSpec vnet) {
        super();
        this.additionalAPIServerLBPorts = additionalAPIServerLBPorts;
        this.apiServerLB = apiServerLB;
        this.controlPlaneOutboundLB = controlPlaneOutboundLB;
        this.nodeOutboundLB = nodeOutboundLB;
        this.privateDNSZone = privateDNSZone;
        this.privateDNSZoneName = privateDNSZoneName;
        this.privateDNSZoneResourceGroup = privateDNSZoneResourceGroup;
        this.subnets = subnets;
        this.vnet = vnet;
    }

    /**
     * AdditionalAPIServerLBPorts specifies extra inbound ports for the APIServer load balancer. Each port specified (e.g., 9345) creates an inbound rule where the frontend port and the backend port are the same.
     */
    @JsonProperty("additionalAPIServerLBPorts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<LoadBalancerPort> getAdditionalAPIServerLBPorts() {
        return additionalAPIServerLBPorts;
    }

    /**
     * AdditionalAPIServerLBPorts specifies extra inbound ports for the APIServer load balancer. Each port specified (e.g., 9345) creates an inbound rule where the frontend port and the backend port are the same.
     */
    @JsonProperty("additionalAPIServerLBPorts")
    public void setAdditionalAPIServerLBPorts(List<LoadBalancerPort> additionalAPIServerLBPorts) {
        this.additionalAPIServerLBPorts = additionalAPIServerLBPorts;
    }

    /**
     * NetworkSpec specifies what the Azure networking resources should look like.
     */
    @JsonProperty("apiServerLB")
    public LoadBalancerSpec getApiServerLB() {
        return apiServerLB;
    }

    /**
     * NetworkSpec specifies what the Azure networking resources should look like.
     */
    @JsonProperty("apiServerLB")
    public void setApiServerLB(LoadBalancerSpec apiServerLB) {
        this.apiServerLB = apiServerLB;
    }

    /**
     * NetworkSpec specifies what the Azure networking resources should look like.
     */
    @JsonProperty("controlPlaneOutboundLB")
    public LoadBalancerSpec getControlPlaneOutboundLB() {
        return controlPlaneOutboundLB;
    }

    /**
     * NetworkSpec specifies what the Azure networking resources should look like.
     */
    @JsonProperty("controlPlaneOutboundLB")
    public void setControlPlaneOutboundLB(LoadBalancerSpec controlPlaneOutboundLB) {
        this.controlPlaneOutboundLB = controlPlaneOutboundLB;
    }

    /**
     * NetworkSpec specifies what the Azure networking resources should look like.
     */
    @JsonProperty("nodeOutboundLB")
    public LoadBalancerSpec getNodeOutboundLB() {
        return nodeOutboundLB;
    }

    /**
     * NetworkSpec specifies what the Azure networking resources should look like.
     */
    @JsonProperty("nodeOutboundLB")
    public void setNodeOutboundLB(LoadBalancerSpec nodeOutboundLB) {
        this.nodeOutboundLB = nodeOutboundLB;
    }

    /**
     * PrivateDNSZone enables private dns zone creation modes for a private cluster. When unspecified, it defaults to PrivateDNSZoneModeSystem which creates a private DNS zone.
     */
    @JsonProperty("privateDNSZone")
    public String getPrivateDNSZone() {
        return privateDNSZone;
    }

    /**
     * PrivateDNSZone enables private dns zone creation modes for a private cluster. When unspecified, it defaults to PrivateDNSZoneModeSystem which creates a private DNS zone.
     */
    @JsonProperty("privateDNSZone")
    public void setPrivateDNSZone(String privateDNSZone) {
        this.privateDNSZone = privateDNSZone;
    }

    /**
     * PrivateDNSZoneName defines the zone name for the Azure Private DNS.
     */
    @JsonProperty("privateDNSZoneName")
    public String getPrivateDNSZoneName() {
        return privateDNSZoneName;
    }

    /**
     * PrivateDNSZoneName defines the zone name for the Azure Private DNS.
     */
    @JsonProperty("privateDNSZoneName")
    public void setPrivateDNSZoneName(String privateDNSZoneName) {
        this.privateDNSZoneName = privateDNSZoneName;
    }

    /**
     * PrivateDNSZoneResourceGroup defines the resource group to be used for Azure Private DNS Zone. If not specified, the resource group of the cluster will be used to create the Azure Private DNS Zone.
     */
    @JsonProperty("privateDNSZoneResourceGroup")
    public String getPrivateDNSZoneResourceGroup() {
        return privateDNSZoneResourceGroup;
    }

    /**
     * PrivateDNSZoneResourceGroup defines the resource group to be used for Azure Private DNS Zone. If not specified, the resource group of the cluster will be used to create the Azure Private DNS Zone.
     */
    @JsonProperty("privateDNSZoneResourceGroup")
    public void setPrivateDNSZoneResourceGroup(String privateDNSZoneResourceGroup) {
        this.privateDNSZoneResourceGroup = privateDNSZoneResourceGroup;
    }

    /**
     * Subnets is the configuration for the control-plane subnet and the node subnet.
     */
    @JsonProperty("subnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SubnetSpec> getSubnets() {
        return subnets;
    }

    /**
     * Subnets is the configuration for the control-plane subnet and the node subnet.
     */
    @JsonProperty("subnets")
    public void setSubnets(List<SubnetSpec> subnets) {
        this.subnets = subnets;
    }

    /**
     * NetworkSpec specifies what the Azure networking resources should look like.
     */
    @JsonProperty("vnet")
    public VnetSpec getVnet() {
        return vnet;
    }

    /**
     * NetworkSpec specifies what the Azure networking resources should look like.
     */
    @JsonProperty("vnet")
    public void setVnet(VnetSpec vnet) {
        this.vnet = vnet;
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
