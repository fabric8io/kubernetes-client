
package io.fabric8.openshift.api.model.installer.powervs.v1;

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
    "cloudConnectionName",
    "clusterOSImage",
    "defaultMachinePlatform",
    "powervsResourceGroup",
    "pvsNetworkName",
    "region",
    "serviceInstanceID",
    "userID",
    "vpcName",
    "vpcRegion",
    "vpcSubnets",
    "zone"
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

    @JsonProperty("cloudConnectionName")
    private String cloudConnectionName;
    @JsonProperty("clusterOSImage")
    private String clusterOSImage;
    @JsonProperty("defaultMachinePlatform")
    private MachinePool defaultMachinePlatform;
    @JsonProperty("powervsResourceGroup")
    private String powervsResourceGroup;
    @JsonProperty("pvsNetworkName")
    private String pvsNetworkName;
    @JsonProperty("region")
    private String region;
    @JsonProperty("serviceInstanceID")
    private String serviceInstanceID;
    @JsonProperty("userID")
    private String userID;
    @JsonProperty("vpcName")
    private String vpcName;
    @JsonProperty("vpcRegion")
    private String vpcRegion;
    @JsonProperty("vpcSubnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> vpcSubnets = new ArrayList<String>();
    @JsonProperty("zone")
    private String zone;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Platform() {
    }

    public Platform(String cloudConnectionName, String clusterOSImage, MachinePool defaultMachinePlatform, String powervsResourceGroup, String pvsNetworkName, String region, String serviceInstanceID, String userID, String vpcName, String vpcRegion, List<String> vpcSubnets, String zone) {
        super();
        this.cloudConnectionName = cloudConnectionName;
        this.clusterOSImage = clusterOSImage;
        this.defaultMachinePlatform = defaultMachinePlatform;
        this.powervsResourceGroup = powervsResourceGroup;
        this.pvsNetworkName = pvsNetworkName;
        this.region = region;
        this.serviceInstanceID = serviceInstanceID;
        this.userID = userID;
        this.vpcName = vpcName;
        this.vpcRegion = vpcRegion;
        this.vpcSubnets = vpcSubnets;
        this.zone = zone;
    }

    @JsonProperty("cloudConnectionName")
    public String getCloudConnectionName() {
        return cloudConnectionName;
    }

    @JsonProperty("cloudConnectionName")
    public void setCloudConnectionName(String cloudConnectionName) {
        this.cloudConnectionName = cloudConnectionName;
    }

    @JsonProperty("clusterOSImage")
    public String getClusterOSImage() {
        return clusterOSImage;
    }

    @JsonProperty("clusterOSImage")
    public void setClusterOSImage(String clusterOSImage) {
        this.clusterOSImage = clusterOSImage;
    }

    @JsonProperty("defaultMachinePlatform")
    public MachinePool getDefaultMachinePlatform() {
        return defaultMachinePlatform;
    }

    @JsonProperty("defaultMachinePlatform")
    public void setDefaultMachinePlatform(MachinePool defaultMachinePlatform) {
        this.defaultMachinePlatform = defaultMachinePlatform;
    }

    @JsonProperty("powervsResourceGroup")
    public String getPowervsResourceGroup() {
        return powervsResourceGroup;
    }

    @JsonProperty("powervsResourceGroup")
    public void setPowervsResourceGroup(String powervsResourceGroup) {
        this.powervsResourceGroup = powervsResourceGroup;
    }

    @JsonProperty("pvsNetworkName")
    public String getPvsNetworkName() {
        return pvsNetworkName;
    }

    @JsonProperty("pvsNetworkName")
    public void setPvsNetworkName(String pvsNetworkName) {
        this.pvsNetworkName = pvsNetworkName;
    }

    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    @JsonProperty("serviceInstanceID")
    public String getServiceInstanceID() {
        return serviceInstanceID;
    }

    @JsonProperty("serviceInstanceID")
    public void setServiceInstanceID(String serviceInstanceID) {
        this.serviceInstanceID = serviceInstanceID;
    }

    @JsonProperty("userID")
    public String getUserID() {
        return userID;
    }

    @JsonProperty("userID")
    public void setUserID(String userID) {
        this.userID = userID;
    }

    @JsonProperty("vpcName")
    public String getVpcName() {
        return vpcName;
    }

    @JsonProperty("vpcName")
    public void setVpcName(String vpcName) {
        this.vpcName = vpcName;
    }

    @JsonProperty("vpcRegion")
    public String getVpcRegion() {
        return vpcRegion;
    }

    @JsonProperty("vpcRegion")
    public void setVpcRegion(String vpcRegion) {
        this.vpcRegion = vpcRegion;
    }

    @JsonProperty("vpcSubnets")
    public List<String> getVpcSubnets() {
        return vpcSubnets;
    }

    @JsonProperty("vpcSubnets")
    public void setVpcSubnets(List<String> vpcSubnets) {
        this.vpcSubnets = vpcSubnets;
    }

    @JsonProperty("zone")
    public String getZone() {
        return zone;
    }

    @JsonProperty("zone")
    public void setZone(String zone) {
        this.zone = zone;
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
