
package io.fabric8.openshift.api.model.installer.ibmcloud.v1;

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
import io.fabric8.openshift.api.model.config.v1.IBMCloudServiceEndpoint;
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
    "computeSubnets",
    "controlPlaneSubnets",
    "defaultMachinePlatform",
    "networkResourceGroupName",
    "region",
    "resourceGroupName",
    "serviceEndpoints",
    "vpcName"
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

    @JsonProperty("computeSubnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> computeSubnets = new ArrayList<>();
    @JsonProperty("controlPlaneSubnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> controlPlaneSubnets = new ArrayList<>();
    @JsonProperty("defaultMachinePlatform")
    private MachinePool defaultMachinePlatform;
    @JsonProperty("networkResourceGroupName")
    private String networkResourceGroupName;
    @JsonProperty("region")
    private String region;
    @JsonProperty("resourceGroupName")
    private String resourceGroupName;
    @JsonProperty("serviceEndpoints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<IBMCloudServiceEndpoint> serviceEndpoints = new ArrayList<>();
    @JsonProperty("vpcName")
    private String vpcName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Platform() {
    }

    public Platform(List<String> computeSubnets, List<String> controlPlaneSubnets, MachinePool defaultMachinePlatform, String networkResourceGroupName, String region, String resourceGroupName, List<IBMCloudServiceEndpoint> serviceEndpoints, String vpcName) {
        super();
        this.computeSubnets = computeSubnets;
        this.controlPlaneSubnets = controlPlaneSubnets;
        this.defaultMachinePlatform = defaultMachinePlatform;
        this.networkResourceGroupName = networkResourceGroupName;
        this.region = region;
        this.resourceGroupName = resourceGroupName;
        this.serviceEndpoints = serviceEndpoints;
        this.vpcName = vpcName;
    }

    /**
     * ComputeSubnets are the names of already existing subnets where the cluster compute nodes should be created.
     */
    @JsonProperty("computeSubnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getComputeSubnets() {
        return computeSubnets;
    }

    /**
     * ComputeSubnets are the names of already existing subnets where the cluster compute nodes should be created.
     */
    @JsonProperty("computeSubnets")
    public void setComputeSubnets(List<String> computeSubnets) {
        this.computeSubnets = computeSubnets;
    }

    /**
     * ControlPlaneSubnets are the names of already existing subnets where the cluster control plane nodes should be created.
     */
    @JsonProperty("controlPlaneSubnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getControlPlaneSubnets() {
        return controlPlaneSubnets;
    }

    /**
     * ControlPlaneSubnets are the names of already existing subnets where the cluster control plane nodes should be created.
     */
    @JsonProperty("controlPlaneSubnets")
    public void setControlPlaneSubnets(List<String> controlPlaneSubnets) {
        this.controlPlaneSubnets = controlPlaneSubnets;
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
     * NetworkResourceGroupName is the name of an already existing resource group where an existing VPC and set of Subnets exist, to be used during cluster creation.
     */
    @JsonProperty("networkResourceGroupName")
    public String getNetworkResourceGroupName() {
        return networkResourceGroupName;
    }

    /**
     * NetworkResourceGroupName is the name of an already existing resource group where an existing VPC and set of Subnets exist, to be used during cluster creation.
     */
    @JsonProperty("networkResourceGroupName")
    public void setNetworkResourceGroupName(String networkResourceGroupName) {
        this.networkResourceGroupName = networkResourceGroupName;
    }

    /**
     * Region specifies the IBM Cloud region where the cluster will be created.
     */
    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    /**
     * Region specifies the IBM Cloud region where the cluster will be created.
     */
    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * ResourceGroupName is the name of an already existing resource group where the cluster should be installed. If empty, a new resource group will be created for the cluster.
     */
    @JsonProperty("resourceGroupName")
    public String getResourceGroupName() {
        return resourceGroupName;
    }

    /**
     * ResourceGroupName is the name of an already existing resource group where the cluster should be installed. If empty, a new resource group will be created for the cluster.
     */
    @JsonProperty("resourceGroupName")
    public void setResourceGroupName(String resourceGroupName) {
        this.resourceGroupName = resourceGroupName;
    }

    /**
     * ServiceEndpoints is a list which contains custom endpoints to override default service endpoints of IBM Cloud Services. There must only be one ServiceEndpoint for a service (no duplicates).
     */
    @JsonProperty("serviceEndpoints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<IBMCloudServiceEndpoint> getServiceEndpoints() {
        return serviceEndpoints;
    }

    /**
     * ServiceEndpoints is a list which contains custom endpoints to override default service endpoints of IBM Cloud Services. There must only be one ServiceEndpoint for a service (no duplicates).
     */
    @JsonProperty("serviceEndpoints")
    public void setServiceEndpoints(List<IBMCloudServiceEndpoint> serviceEndpoints) {
        this.serviceEndpoints = serviceEndpoints;
    }

    /**
     * VPCName is the name of an already existing VPC to be used during cluster creation.
     */
    @JsonProperty("vpcName")
    public String getVpcName() {
        return vpcName;
    }

    /**
     * VPCName is the name of an already existing VPC to be used during cluster creation.
     */
    @JsonProperty("vpcName")
    public void setVpcName(String vpcName) {
        this.vpcName = vpcName;
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
