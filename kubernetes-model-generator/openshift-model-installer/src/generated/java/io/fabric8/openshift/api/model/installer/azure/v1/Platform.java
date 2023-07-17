
package io.fabric8.openshift.api.model.installer.azure.v1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "armEndpoint",
    "baseDomainResourceGroupName",
    "cloudName",
    "clusterOSImage",
    "computeSubnet",
    "controlPlaneSubnet",
    "defaultMachinePlatform",
    "networkResourceGroupName",
    "outboundType",
    "region",
    "resourceGroupName",
    "userTags",
    "virtualNetwork"
})
@ToString
@EqualsAndHashCode
@Setter
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class Platform implements KubernetesResource
{

    @JsonProperty("armEndpoint")
    private java.lang.String armEndpoint;
    @JsonProperty("baseDomainResourceGroupName")
    private java.lang.String baseDomainResourceGroupName;
    @JsonProperty("cloudName")
    private java.lang.String cloudName;
    @JsonProperty("clusterOSImage")
    private java.lang.String clusterOSImage;
    @JsonProperty("computeSubnet")
    private java.lang.String computeSubnet;
    @JsonProperty("controlPlaneSubnet")
    private java.lang.String controlPlaneSubnet;
    @JsonProperty("defaultMachinePlatform")
    private MachinePool defaultMachinePlatform;
    @JsonProperty("networkResourceGroupName")
    private java.lang.String networkResourceGroupName;
    @JsonProperty("outboundType")
    private java.lang.String outboundType;
    @JsonProperty("region")
    private java.lang.String region;
    @JsonProperty("resourceGroupName")
    private java.lang.String resourceGroupName;
    @JsonProperty("userTags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> userTags = new LinkedHashMap<String, String>();
    @JsonProperty("virtualNetwork")
    private java.lang.String virtualNetwork;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Platform() {
    }

    public Platform(java.lang.String armEndpoint, java.lang.String baseDomainResourceGroupName, java.lang.String cloudName, java.lang.String clusterOSImage, java.lang.String computeSubnet, java.lang.String controlPlaneSubnet, MachinePool defaultMachinePlatform, java.lang.String networkResourceGroupName, java.lang.String outboundType, java.lang.String region, java.lang.String resourceGroupName, Map<String, String> userTags, java.lang.String virtualNetwork) {
        super();
        this.armEndpoint = armEndpoint;
        this.baseDomainResourceGroupName = baseDomainResourceGroupName;
        this.cloudName = cloudName;
        this.clusterOSImage = clusterOSImage;
        this.computeSubnet = computeSubnet;
        this.controlPlaneSubnet = controlPlaneSubnet;
        this.defaultMachinePlatform = defaultMachinePlatform;
        this.networkResourceGroupName = networkResourceGroupName;
        this.outboundType = outboundType;
        this.region = region;
        this.resourceGroupName = resourceGroupName;
        this.userTags = userTags;
        this.virtualNetwork = virtualNetwork;
    }

    @JsonProperty("armEndpoint")
    public java.lang.String getArmEndpoint() {
        return armEndpoint;
    }

    @JsonProperty("armEndpoint")
    public void setArmEndpoint(java.lang.String armEndpoint) {
        this.armEndpoint = armEndpoint;
    }

    @JsonProperty("baseDomainResourceGroupName")
    public java.lang.String getBaseDomainResourceGroupName() {
        return baseDomainResourceGroupName;
    }

    @JsonProperty("baseDomainResourceGroupName")
    public void setBaseDomainResourceGroupName(java.lang.String baseDomainResourceGroupName) {
        this.baseDomainResourceGroupName = baseDomainResourceGroupName;
    }

    @JsonProperty("cloudName")
    public java.lang.String getCloudName() {
        return cloudName;
    }

    @JsonProperty("cloudName")
    public void setCloudName(java.lang.String cloudName) {
        this.cloudName = cloudName;
    }

    @JsonProperty("clusterOSImage")
    public java.lang.String getClusterOSImage() {
        return clusterOSImage;
    }

    @JsonProperty("clusterOSImage")
    public void setClusterOSImage(java.lang.String clusterOSImage) {
        this.clusterOSImage = clusterOSImage;
    }

    @JsonProperty("computeSubnet")
    public java.lang.String getComputeSubnet() {
        return computeSubnet;
    }

    @JsonProperty("computeSubnet")
    public void setComputeSubnet(java.lang.String computeSubnet) {
        this.computeSubnet = computeSubnet;
    }

    @JsonProperty("controlPlaneSubnet")
    public java.lang.String getControlPlaneSubnet() {
        return controlPlaneSubnet;
    }

    @JsonProperty("controlPlaneSubnet")
    public void setControlPlaneSubnet(java.lang.String controlPlaneSubnet) {
        this.controlPlaneSubnet = controlPlaneSubnet;
    }

    @JsonProperty("defaultMachinePlatform")
    public MachinePool getDefaultMachinePlatform() {
        return defaultMachinePlatform;
    }

    @JsonProperty("defaultMachinePlatform")
    public void setDefaultMachinePlatform(MachinePool defaultMachinePlatform) {
        this.defaultMachinePlatform = defaultMachinePlatform;
    }

    @JsonProperty("networkResourceGroupName")
    public java.lang.String getNetworkResourceGroupName() {
        return networkResourceGroupName;
    }

    @JsonProperty("networkResourceGroupName")
    public void setNetworkResourceGroupName(java.lang.String networkResourceGroupName) {
        this.networkResourceGroupName = networkResourceGroupName;
    }

    @JsonProperty("outboundType")
    public java.lang.String getOutboundType() {
        return outboundType;
    }

    @JsonProperty("outboundType")
    public void setOutboundType(java.lang.String outboundType) {
        this.outboundType = outboundType;
    }

    @JsonProperty("region")
    public java.lang.String getRegion() {
        return region;
    }

    @JsonProperty("region")
    public void setRegion(java.lang.String region) {
        this.region = region;
    }

    @JsonProperty("resourceGroupName")
    public java.lang.String getResourceGroupName() {
        return resourceGroupName;
    }

    @JsonProperty("resourceGroupName")
    public void setResourceGroupName(java.lang.String resourceGroupName) {
        this.resourceGroupName = resourceGroupName;
    }

    @JsonProperty("userTags")
    public Map<String, String> getUserTags() {
        return userTags;
    }

    @JsonProperty("userTags")
    public void setUserTags(Map<String, String> userTags) {
        this.userTags = userTags;
    }

    @JsonProperty("virtualNetwork")
    public java.lang.String getVirtualNetwork() {
        return virtualNetwork;
    }

    @JsonProperty("virtualNetwork")
    public void setVirtualNetwork(java.lang.String virtualNetwork) {
        this.virtualNetwork = virtualNetwork;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
