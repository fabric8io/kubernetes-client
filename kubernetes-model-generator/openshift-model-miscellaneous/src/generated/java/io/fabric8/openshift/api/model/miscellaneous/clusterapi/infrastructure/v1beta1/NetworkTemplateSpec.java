
package io.fabric8.openshift.api.model.miscellaneous.clusterapi.infrastructure.v1beta1;

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
 * NetworkTemplateSpec specifies a network template.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "additionalAPIServerLBPorts",
    "apiServerLB",
    "controlPlaneOutboundLB",
    "nodeOutboundLB",
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
public class NetworkTemplateSpec implements Editable<NetworkTemplateSpecBuilder>, KubernetesResource
{

    @JsonProperty("additionalAPIServerLBPorts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<LoadBalancerPort> additionalAPIServerLBPorts = new ArrayList<>();
    @JsonProperty("apiServerLB")
    private LoadBalancerClassSpec apiServerLB;
    @JsonProperty("controlPlaneOutboundLB")
    private LoadBalancerClassSpec controlPlaneOutboundLB;
    @JsonProperty("nodeOutboundLB")
    private LoadBalancerClassSpec nodeOutboundLB;
    @JsonProperty("privateDNSZoneName")
    private String privateDNSZoneName;
    @JsonProperty("privateDNSZoneResourceGroup")
    private String privateDNSZoneResourceGroup;
    @JsonProperty("subnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SubnetTemplateSpec> subnets = new ArrayList<>();
    @JsonProperty("vnet")
    private VnetTemplateSpec vnet;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NetworkTemplateSpec() {
    }

    public NetworkTemplateSpec(List<LoadBalancerPort> additionalAPIServerLBPorts, LoadBalancerClassSpec apiServerLB, LoadBalancerClassSpec controlPlaneOutboundLB, LoadBalancerClassSpec nodeOutboundLB, String privateDNSZoneName, String privateDNSZoneResourceGroup, List<SubnetTemplateSpec> subnets, VnetTemplateSpec vnet) {
        super();
        this.additionalAPIServerLBPorts = additionalAPIServerLBPorts;
        this.apiServerLB = apiServerLB;
        this.controlPlaneOutboundLB = controlPlaneOutboundLB;
        this.nodeOutboundLB = nodeOutboundLB;
        this.privateDNSZoneName = privateDNSZoneName;
        this.privateDNSZoneResourceGroup = privateDNSZoneResourceGroup;
        this.subnets = subnets;
        this.vnet = vnet;
    }

    /**
     * AdditionalAPIServerLBPorts is the configuration for the additional inbound control-plane load balancer ports Each port specified (e.g., 9345) creates an inbound rule where the frontend port and the backend port are the same.
     */
    @JsonProperty("additionalAPIServerLBPorts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<LoadBalancerPort> getAdditionalAPIServerLBPorts() {
        return additionalAPIServerLBPorts;
    }

    /**
     * AdditionalAPIServerLBPorts is the configuration for the additional inbound control-plane load balancer ports Each port specified (e.g., 9345) creates an inbound rule where the frontend port and the backend port are the same.
     */
    @JsonProperty("additionalAPIServerLBPorts")
    public void setAdditionalAPIServerLBPorts(List<LoadBalancerPort> additionalAPIServerLBPorts) {
        this.additionalAPIServerLBPorts = additionalAPIServerLBPorts;
    }

    /**
     * NetworkTemplateSpec specifies a network template.
     */
    @JsonProperty("apiServerLB")
    public LoadBalancerClassSpec getApiServerLB() {
        return apiServerLB;
    }

    /**
     * NetworkTemplateSpec specifies a network template.
     */
    @JsonProperty("apiServerLB")
    public void setApiServerLB(LoadBalancerClassSpec apiServerLB) {
        this.apiServerLB = apiServerLB;
    }

    /**
     * NetworkTemplateSpec specifies a network template.
     */
    @JsonProperty("controlPlaneOutboundLB")
    public LoadBalancerClassSpec getControlPlaneOutboundLB() {
        return controlPlaneOutboundLB;
    }

    /**
     * NetworkTemplateSpec specifies a network template.
     */
    @JsonProperty("controlPlaneOutboundLB")
    public void setControlPlaneOutboundLB(LoadBalancerClassSpec controlPlaneOutboundLB) {
        this.controlPlaneOutboundLB = controlPlaneOutboundLB;
    }

    /**
     * NetworkTemplateSpec specifies a network template.
     */
    @JsonProperty("nodeOutboundLB")
    public LoadBalancerClassSpec getNodeOutboundLB() {
        return nodeOutboundLB;
    }

    /**
     * NetworkTemplateSpec specifies a network template.
     */
    @JsonProperty("nodeOutboundLB")
    public void setNodeOutboundLB(LoadBalancerClassSpec nodeOutboundLB) {
        this.nodeOutboundLB = nodeOutboundLB;
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
    public List<SubnetTemplateSpec> getSubnets() {
        return subnets;
    }

    /**
     * Subnets is the configuration for the control-plane subnet and the node subnet.
     */
    @JsonProperty("subnets")
    public void setSubnets(List<SubnetTemplateSpec> subnets) {
        this.subnets = subnets;
    }

    /**
     * NetworkTemplateSpec specifies a network template.
     */
    @JsonProperty("vnet")
    public VnetTemplateSpec getVnet() {
        return vnet;
    }

    /**
     * NetworkTemplateSpec specifies a network template.
     */
    @JsonProperty("vnet")
    public void setVnet(VnetTemplateSpec vnet) {
        this.vnet = vnet;
    }

    @JsonIgnore
    public NetworkTemplateSpecBuilder edit() {
        return new NetworkTemplateSpecBuilder(this);
    }

    @JsonIgnore
    public NetworkTemplateSpecBuilder toBuilder() {
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
