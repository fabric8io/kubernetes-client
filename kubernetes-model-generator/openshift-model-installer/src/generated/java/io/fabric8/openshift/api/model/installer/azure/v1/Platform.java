
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
    private String armEndpoint;
    @JsonProperty("baseDomainResourceGroupName")
    private String baseDomainResourceGroupName;
    @JsonProperty("cloudName")
    private String cloudName;
    @JsonProperty("clusterOSImage")
    private String clusterOSImage;
    @JsonProperty("computeSubnet")
    private String computeSubnet;
    @JsonProperty("controlPlaneSubnet")
    private String controlPlaneSubnet;
    @JsonProperty("defaultMachinePlatform")
    private MachinePool defaultMachinePlatform;
    @JsonProperty("networkResourceGroupName")
    private String networkResourceGroupName;
    @JsonProperty("outboundType")
    private String outboundType;
    @JsonProperty("region")
    private String region;
    @JsonProperty("resourceGroupName")
    private String resourceGroupName;
    @JsonProperty("virtualNetwork")
    private String virtualNetwork;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Platform() {
    }

    public Platform(String armEndpoint, String baseDomainResourceGroupName, String cloudName, String clusterOSImage, String computeSubnet, String controlPlaneSubnet, MachinePool defaultMachinePlatform, String networkResourceGroupName, String outboundType, String region, String resourceGroupName, String virtualNetwork) {
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
        this.virtualNetwork = virtualNetwork;
    }

    @JsonProperty("armEndpoint")
    public String getArmEndpoint() {
        return armEndpoint;
    }

    @JsonProperty("armEndpoint")
    public void setArmEndpoint(String armEndpoint) {
        this.armEndpoint = armEndpoint;
    }

    @JsonProperty("baseDomainResourceGroupName")
    public String getBaseDomainResourceGroupName() {
        return baseDomainResourceGroupName;
    }

    @JsonProperty("baseDomainResourceGroupName")
    public void setBaseDomainResourceGroupName(String baseDomainResourceGroupName) {
        this.baseDomainResourceGroupName = baseDomainResourceGroupName;
    }

    @JsonProperty("cloudName")
    public String getCloudName() {
        return cloudName;
    }

    @JsonProperty("cloudName")
    public void setCloudName(String cloudName) {
        this.cloudName = cloudName;
    }

    @JsonProperty("clusterOSImage")
    public String getClusterOSImage() {
        return clusterOSImage;
    }

    @JsonProperty("clusterOSImage")
    public void setClusterOSImage(String clusterOSImage) {
        this.clusterOSImage = clusterOSImage;
    }

    @JsonProperty("computeSubnet")
    public String getComputeSubnet() {
        return computeSubnet;
    }

    @JsonProperty("computeSubnet")
    public void setComputeSubnet(String computeSubnet) {
        this.computeSubnet = computeSubnet;
    }

    @JsonProperty("controlPlaneSubnet")
    public String getControlPlaneSubnet() {
        return controlPlaneSubnet;
    }

    @JsonProperty("controlPlaneSubnet")
    public void setControlPlaneSubnet(String controlPlaneSubnet) {
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
    public String getNetworkResourceGroupName() {
        return networkResourceGroupName;
    }

    @JsonProperty("networkResourceGroupName")
    public void setNetworkResourceGroupName(String networkResourceGroupName) {
        this.networkResourceGroupName = networkResourceGroupName;
    }

    @JsonProperty("outboundType")
    public String getOutboundType() {
        return outboundType;
    }

    @JsonProperty("outboundType")
    public void setOutboundType(String outboundType) {
        this.outboundType = outboundType;
    }

    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    @JsonProperty("resourceGroupName")
    public String getResourceGroupName() {
        return resourceGroupName;
    }

    @JsonProperty("resourceGroupName")
    public void setResourceGroupName(String resourceGroupName) {
        this.resourceGroupName = resourceGroupName;
    }

    @JsonProperty("virtualNetwork")
    public String getVirtualNetwork() {
        return virtualNetwork;
    }

    @JsonProperty("virtualNetwork")
    public void setVirtualNetwork(String virtualNetwork) {
        this.virtualNetwork = virtualNetwork;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
