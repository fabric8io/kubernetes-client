
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
 * Platform stores all the global configuration that all machinesets use.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "armEndpoint",
    "baseDomainResourceGroupName",
    "cloudName",
    "clusterOSImage",
    "computeSubnet",
    "controlPlaneSubnet",
    "customerManagedKey",
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
public class Platform implements Editable<PlatformBuilder>, KubernetesResource
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
    @JsonProperty("customerManagedKey")
    private CustomerManagedKey customerManagedKey;
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
    @JsonProperty("userTags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> userTags = new LinkedHashMap<>();
    @JsonProperty("virtualNetwork")
    private String virtualNetwork;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Platform() {
    }

    public Platform(String armEndpoint, String baseDomainResourceGroupName, String cloudName, String clusterOSImage, String computeSubnet, String controlPlaneSubnet, CustomerManagedKey customerManagedKey, MachinePool defaultMachinePlatform, String networkResourceGroupName, String outboundType, String region, String resourceGroupName, Map<String, String> userTags, String virtualNetwork) {
        super();
        this.armEndpoint = armEndpoint;
        this.baseDomainResourceGroupName = baseDomainResourceGroupName;
        this.cloudName = cloudName;
        this.clusterOSImage = clusterOSImage;
        this.computeSubnet = computeSubnet;
        this.controlPlaneSubnet = controlPlaneSubnet;
        this.customerManagedKey = customerManagedKey;
        this.defaultMachinePlatform = defaultMachinePlatform;
        this.networkResourceGroupName = networkResourceGroupName;
        this.outboundType = outboundType;
        this.region = region;
        this.resourceGroupName = resourceGroupName;
        this.userTags = userTags;
        this.virtualNetwork = virtualNetwork;
    }

    /**
     * ARMEndpoint is the endpoint for the Azure API when installing on Azure Stack.
     */
    @JsonProperty("armEndpoint")
    public String getArmEndpoint() {
        return armEndpoint;
    }

    /**
     * ARMEndpoint is the endpoint for the Azure API when installing on Azure Stack.
     */
    @JsonProperty("armEndpoint")
    public void setArmEndpoint(String armEndpoint) {
        this.armEndpoint = armEndpoint;
    }

    /**
     * BaseDomainResourceGroupName specifies the resource group where the Azure DNS zone for the base domain is found. This field is optional when creating a private cluster, otherwise required.
     */
    @JsonProperty("baseDomainResourceGroupName")
    public String getBaseDomainResourceGroupName() {
        return baseDomainResourceGroupName;
    }

    /**
     * BaseDomainResourceGroupName specifies the resource group where the Azure DNS zone for the base domain is found. This field is optional when creating a private cluster, otherwise required.
     */
    @JsonProperty("baseDomainResourceGroupName")
    public void setBaseDomainResourceGroupName(String baseDomainResourceGroupName) {
        this.baseDomainResourceGroupName = baseDomainResourceGroupName;
    }

    /**
     * cloudName is the name of the Azure cloud environment which can be used to configure the Azure SDK with the appropriate Azure API endpoints. If empty, the value is equal to "AzurePublicCloud".
     */
    @JsonProperty("cloudName")
    public String getCloudName() {
        return cloudName;
    }

    /**
     * cloudName is the name of the Azure cloud environment which can be used to configure the Azure SDK with the appropriate Azure API endpoints. If empty, the value is equal to "AzurePublicCloud".
     */
    @JsonProperty("cloudName")
    public void setCloudName(String cloudName) {
        this.cloudName = cloudName;
    }

    /**
     * ClusterOSImage is the url of a storage blob in the Azure Stack environment containing an RHCOS VHD. This field is required for Azure Stack and not applicable to Azure.
     */
    @JsonProperty("clusterOSImage")
    public String getClusterOSImage() {
        return clusterOSImage;
    }

    /**
     * ClusterOSImage is the url of a storage blob in the Azure Stack environment containing an RHCOS VHD. This field is required for Azure Stack and not applicable to Azure.
     */
    @JsonProperty("clusterOSImage")
    public void setClusterOSImage(String clusterOSImage) {
        this.clusterOSImage = clusterOSImage;
    }

    /**
     * ComputeSubnet specifies an existing subnet for use by compute nodes
     */
    @JsonProperty("computeSubnet")
    public String getComputeSubnet() {
        return computeSubnet;
    }

    /**
     * ComputeSubnet specifies an existing subnet for use by compute nodes
     */
    @JsonProperty("computeSubnet")
    public void setComputeSubnet(String computeSubnet) {
        this.computeSubnet = computeSubnet;
    }

    /**
     * ControlPlaneSubnet specifies an existing subnet for use by the control plane nodes
     */
    @JsonProperty("controlPlaneSubnet")
    public String getControlPlaneSubnet() {
        return controlPlaneSubnet;
    }

    /**
     * ControlPlaneSubnet specifies an existing subnet for use by the control plane nodes
     */
    @JsonProperty("controlPlaneSubnet")
    public void setControlPlaneSubnet(String controlPlaneSubnet) {
        this.controlPlaneSubnet = controlPlaneSubnet;
    }

    /**
     * Platform stores all the global configuration that all machinesets use.
     */
    @JsonProperty("customerManagedKey")
    public CustomerManagedKey getCustomerManagedKey() {
        return customerManagedKey;
    }

    /**
     * Platform stores all the global configuration that all machinesets use.
     */
    @JsonProperty("customerManagedKey")
    public void setCustomerManagedKey(CustomerManagedKey customerManagedKey) {
        this.customerManagedKey = customerManagedKey;
    }

    /**
     * Platform stores all the global configuration that all machinesets use.
     */
    @JsonProperty("defaultMachinePlatform")
    public MachinePool getDefaultMachinePlatform() {
        return defaultMachinePlatform;
    }

    /**
     * Platform stores all the global configuration that all machinesets use.
     */
    @JsonProperty("defaultMachinePlatform")
    public void setDefaultMachinePlatform(MachinePool defaultMachinePlatform) {
        this.defaultMachinePlatform = defaultMachinePlatform;
    }

    /**
     * NetworkResourceGroupName specifies the network resource group that contains an existing VNet
     */
    @JsonProperty("networkResourceGroupName")
    public String getNetworkResourceGroupName() {
        return networkResourceGroupName;
    }

    /**
     * NetworkResourceGroupName specifies the network resource group that contains an existing VNet
     */
    @JsonProperty("networkResourceGroupName")
    public void setNetworkResourceGroupName(String networkResourceGroupName) {
        this.networkResourceGroupName = networkResourceGroupName;
    }

    /**
     * OutboundType is a strategy for how egress from cluster is achieved. When not specified default is "Loadbalancer". "NatGateway" is only available in TechPreview.
     */
    @JsonProperty("outboundType")
    public String getOutboundType() {
        return outboundType;
    }

    /**
     * OutboundType is a strategy for how egress from cluster is achieved. When not specified default is "Loadbalancer". "NatGateway" is only available in TechPreview.
     */
    @JsonProperty("outboundType")
    public void setOutboundType(String outboundType) {
        this.outboundType = outboundType;
    }

    /**
     * Region specifies the Azure region where the cluster will be created.
     */
    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    /**
     * Region specifies the Azure region where the cluster will be created.
     */
    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * ResourceGroupName is the name of an already existing resource group where the cluster should be installed. This resource group should only be used for this specific cluster and the cluster components will assume ownership of all resources in the resource group. Destroying the cluster using installer will delete this resource group. This resource group must be empty with no other resources when trying to use it for creating a cluster. If empty, a new resource group will created for the cluster.
     */
    @JsonProperty("resourceGroupName")
    public String getResourceGroupName() {
        return resourceGroupName;
    }

    /**
     * ResourceGroupName is the name of an already existing resource group where the cluster should be installed. This resource group should only be used for this specific cluster and the cluster components will assume ownership of all resources in the resource group. Destroying the cluster using installer will delete this resource group. This resource group must be empty with no other resources when trying to use it for creating a cluster. If empty, a new resource group will created for the cluster.
     */
    @JsonProperty("resourceGroupName")
    public void setResourceGroupName(String resourceGroupName) {
        this.resourceGroupName = resourceGroupName;
    }

    /**
     * UserTags has additional keys and values that the installer will add as tags to all resources that it creates on AzurePublicCloud alone. Resources created by the cluster itself may not include these tags.
     */
    @JsonProperty("userTags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getUserTags() {
        return userTags;
    }

    /**
     * UserTags has additional keys and values that the installer will add as tags to all resources that it creates on AzurePublicCloud alone. Resources created by the cluster itself may not include these tags.
     */
    @JsonProperty("userTags")
    public void setUserTags(Map<String, String> userTags) {
        this.userTags = userTags;
    }

    /**
     * VirtualNetwork specifies the name of an existing VNet for the installer to use
     */
    @JsonProperty("virtualNetwork")
    public String getVirtualNetwork() {
        return virtualNetwork;
    }

    /**
     * VirtualNetwork specifies the name of an existing VNet for the installer to use
     */
    @JsonProperty("virtualNetwork")
    public void setVirtualNetwork(String virtualNetwork) {
        this.virtualNetwork = virtualNetwork;
    }

    @JsonIgnore
    public PlatformBuilder edit() {
        return new PlatformBuilder(this);
    }

    @JsonIgnore
    public PlatformBuilder toBuilder() {
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
