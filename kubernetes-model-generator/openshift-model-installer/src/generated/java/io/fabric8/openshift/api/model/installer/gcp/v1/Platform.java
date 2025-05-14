
package io.fabric8.openshift.api.model.installer.gcp.v1;

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
 * Platform stores all the global configuration that all machinesets use.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "computeSubnet",
    "controlPlaneSubnet",
    "defaultMachinePlatform",
    "network",
    "networkProjectID",
    "projectID",
    "region",
    "userLabels",
    "userProvisionedDNS",
    "userTags"
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

    @JsonProperty("computeSubnet")
    private String computeSubnet;
    @JsonProperty("controlPlaneSubnet")
    private String controlPlaneSubnet;
    @JsonProperty("defaultMachinePlatform")
    private MachinePool defaultMachinePlatform;
    @JsonProperty("network")
    private String network;
    @JsonProperty("networkProjectID")
    private String networkProjectID;
    @JsonProperty("projectID")
    private String projectID;
    @JsonProperty("region")
    private String region;
    @JsonProperty("userLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<UserLabel> userLabels = new ArrayList<>();
    @JsonProperty("userProvisionedDNS")
    private String userProvisionedDNS;
    @JsonProperty("userTags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<UserTag> userTags = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Platform() {
    }

    public Platform(String computeSubnet, String controlPlaneSubnet, MachinePool defaultMachinePlatform, String network, String networkProjectID, String projectID, String region, List<UserLabel> userLabels, String userProvisionedDNS, List<UserTag> userTags) {
        super();
        this.computeSubnet = computeSubnet;
        this.controlPlaneSubnet = controlPlaneSubnet;
        this.defaultMachinePlatform = defaultMachinePlatform;
        this.network = network;
        this.networkProjectID = networkProjectID;
        this.projectID = projectID;
        this.region = region;
        this.userLabels = userLabels;
        this.userProvisionedDNS = userProvisionedDNS;
        this.userTags = userTags;
    }

    /**
     * ComputeSubnet is an existing subnet where the compute nodes will be deployed. The value should be the name of the subnet.
     */
    @JsonProperty("computeSubnet")
    public String getComputeSubnet() {
        return computeSubnet;
    }

    /**
     * ComputeSubnet is an existing subnet where the compute nodes will be deployed. The value should be the name of the subnet.
     */
    @JsonProperty("computeSubnet")
    public void setComputeSubnet(String computeSubnet) {
        this.computeSubnet = computeSubnet;
    }

    /**
     * ControlPlaneSubnet is an existing subnet where the control plane will be deployed. The value should be the name of the subnet.
     */
    @JsonProperty("controlPlaneSubnet")
    public String getControlPlaneSubnet() {
        return controlPlaneSubnet;
    }

    /**
     * ControlPlaneSubnet is an existing subnet where the control plane will be deployed. The value should be the name of the subnet.
     */
    @JsonProperty("controlPlaneSubnet")
    public void setControlPlaneSubnet(String controlPlaneSubnet) {
        this.controlPlaneSubnet = controlPlaneSubnet;
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
     * Network specifies an existing VPC where the cluster should be created rather than provisioning a new one.
     */
    @JsonProperty("network")
    public String getNetwork() {
        return network;
    }

    /**
     * Network specifies an existing VPC where the cluster should be created rather than provisioning a new one.
     */
    @JsonProperty("network")
    public void setNetwork(String network) {
        this.network = network;
    }

    /**
     * NetworkProjectID specifies which project the network and subnets exist in when they are not in the main ProjectID.
     */
    @JsonProperty("networkProjectID")
    public String getNetworkProjectID() {
        return networkProjectID;
    }

    /**
     * NetworkProjectID specifies which project the network and subnets exist in when they are not in the main ProjectID.
     */
    @JsonProperty("networkProjectID")
    public void setNetworkProjectID(String networkProjectID) {
        this.networkProjectID = networkProjectID;
    }

    /**
     * ProjectID is the the project that will be used for the cluster.
     */
    @JsonProperty("projectID")
    public String getProjectID() {
        return projectID;
    }

    /**
     * ProjectID is the the project that will be used for the cluster.
     */
    @JsonProperty("projectID")
    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }

    /**
     * Region specifies the GCP region where the cluster will be created.
     */
    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    /**
     * Region specifies the GCP region where the cluster will be created.
     */
    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * userLabels has additional keys and values that the installer will add as labels to all resources that it creates on GCP. Resources created by the cluster itself may not include these labels.
     */
    @JsonProperty("userLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<UserLabel> getUserLabels() {
        return userLabels;
    }

    /**
     * userLabels has additional keys and values that the installer will add as labels to all resources that it creates on GCP. Resources created by the cluster itself may not include these labels.
     */
    @JsonProperty("userLabels")
    public void setUserLabels(List<UserLabel> userLabels) {
        this.userLabels = userLabels;
    }

    /**
     * UserProvisionedDNS indicates if the customer is providing their own DNS solution in place of the default provisioned by the Installer.
     */
    @JsonProperty("userProvisionedDNS")
    public String getUserProvisionedDNS() {
        return userProvisionedDNS;
    }

    /**
     * UserProvisionedDNS indicates if the customer is providing their own DNS solution in place of the default provisioned by the Installer.
     */
    @JsonProperty("userProvisionedDNS")
    public void setUserProvisionedDNS(String userProvisionedDNS) {
        this.userProvisionedDNS = userProvisionedDNS;
    }

    /**
     * userTags has additional keys and values that the installer will add as tags to all resources that it creates on GCP. Resources created by the cluster itself may not include these tags. Tag key and tag value should be the shortnames of the tag key and tag value resource.
     */
    @JsonProperty("userTags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<UserTag> getUserTags() {
        return userTags;
    }

    /**
     * userTags has additional keys and values that the installer will add as tags to all resources that it creates on GCP. Resources created by the cluster itself may not include these tags. Tag key and tag value should be the shortnames of the tag key and tag value resource.
     */
    @JsonProperty("userTags")
    public void setUserTags(List<UserTag> userTags) {
        this.userTags = userTags;
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
