
package io.fabric8.openshift.api.model.installer.gcp.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
     * 
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

    @JsonProperty("network")
    public String getNetwork() {
        return network;
    }

    @JsonProperty("network")
    public void setNetwork(String network) {
        this.network = network;
    }

    @JsonProperty("networkProjectID")
    public String getNetworkProjectID() {
        return networkProjectID;
    }

    @JsonProperty("networkProjectID")
    public void setNetworkProjectID(String networkProjectID) {
        this.networkProjectID = networkProjectID;
    }

    @JsonProperty("projectID")
    public String getProjectID() {
        return projectID;
    }

    @JsonProperty("projectID")
    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }

    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    @JsonProperty("userLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<UserLabel> getUserLabels() {
        return userLabels;
    }

    @JsonProperty("userLabels")
    public void setUserLabels(List<UserLabel> userLabels) {
        this.userLabels = userLabels;
    }

    @JsonProperty("userProvisionedDNS")
    public String getUserProvisionedDNS() {
        return userProvisionedDNS;
    }

    @JsonProperty("userProvisionedDNS")
    public void setUserProvisionedDNS(String userProvisionedDNS) {
        this.userProvisionedDNS = userProvisionedDNS;
    }

    @JsonProperty("userTags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<UserTag> getUserTags() {
        return userTags;
    }

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
