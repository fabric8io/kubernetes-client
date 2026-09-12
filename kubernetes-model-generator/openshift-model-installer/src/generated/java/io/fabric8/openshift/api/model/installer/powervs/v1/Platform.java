
package io.fabric8.openshift.api.model.installer.powervs.v1;

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
import io.fabric8.openshift.api.model.config.v1.PowerVSServiceEndpoint;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * Platform stores all the global configuration that all machinesets use.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "clusterOSImage",
    "defaultMachinePlatform",
    "powervsResourceGroup",
    "region",
    "serviceEndpoints",
    "serviceInstanceGUID",
    "tgName",
    "userID",
    "vpcName",
    "vpcRegion",
    "vpcSubnets",
    "zone"
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

    @JsonProperty("clusterOSImage")
    private String clusterOSImage;
    @JsonProperty("defaultMachinePlatform")
    private MachinePool defaultMachinePlatform;
    @JsonProperty("powervsResourceGroup")
    private String powervsResourceGroup;
    @JsonProperty("region")
    private String region;
    @JsonProperty("serviceEndpoints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PowerVSServiceEndpoint> serviceEndpoints = new ArrayList<>();
    @JsonProperty("serviceInstanceGUID")
    private String serviceInstanceGUID;
    @JsonProperty("tgName")
    private String tgName;
    @JsonProperty("userID")
    private String userID;
    @JsonProperty("vpcName")
    private String vpcName;
    @JsonProperty("vpcRegion")
    private String vpcRegion;
    @JsonProperty("vpcSubnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> vpcSubnets = new ArrayList<>();
    @JsonProperty("zone")
    private String zone;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Platform() {
    }

    public Platform(String clusterOSImage, MachinePool defaultMachinePlatform, String powervsResourceGroup, String region, List<PowerVSServiceEndpoint> serviceEndpoints, String serviceInstanceGUID, String tgName, String userID, String vpcName, String vpcRegion, List<String> vpcSubnets, String zone) {
        super();
        this.clusterOSImage = clusterOSImage;
        this.defaultMachinePlatform = defaultMachinePlatform;
        this.powervsResourceGroup = powervsResourceGroup;
        this.region = region;
        this.serviceEndpoints = serviceEndpoints;
        this.serviceInstanceGUID = serviceInstanceGUID;
        this.tgName = tgName;
        this.userID = userID;
        this.vpcName = vpcName;
        this.vpcRegion = vpcRegion;
        this.vpcSubnets = vpcSubnets;
        this.zone = zone;
    }

    /**
     * ClusterOSImage is a pre-created Power VS boot image that overrides the default image for cluster nodes.
     */
    @JsonProperty("clusterOSImage")
    public String getClusterOSImage() {
        return clusterOSImage;
    }

    /**
     * ClusterOSImage is a pre-created Power VS boot image that overrides the default image for cluster nodes.
     */
    @JsonProperty("clusterOSImage")
    public void setClusterOSImage(String clusterOSImage) {
        this.clusterOSImage = clusterOSImage;
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
     * PowerVSResourceGroup is the resource group in which Power VS resources will be created.
     */
    @JsonProperty("powervsResourceGroup")
    public String getPowervsResourceGroup() {
        return powervsResourceGroup;
    }

    /**
     * PowerVSResourceGroup is the resource group in which Power VS resources will be created.
     */
    @JsonProperty("powervsResourceGroup")
    public void setPowervsResourceGroup(String powervsResourceGroup) {
        this.powervsResourceGroup = powervsResourceGroup;
    }

    /**
     * Region specifies the IBM Cloud colo region where the cluster will be created.
     */
    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    /**
     * Region specifies the IBM Cloud colo region where the cluster will be created.
     */
    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * ServiceEndpoints is a list which contains custom endpoints to override default service endpoints of IBM Cloud Services. There must only be one ServiceEndpoint for a service (no duplicates).
     */
    @JsonProperty("serviceEndpoints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PowerVSServiceEndpoint> getServiceEndpoints() {
        return serviceEndpoints;
    }

    /**
     * ServiceEndpoints is a list which contains custom endpoints to override default service endpoints of IBM Cloud Services. There must only be one ServiceEndpoint for a service (no duplicates).
     */
    @JsonProperty("serviceEndpoints")
    public void setServiceEndpoints(List<PowerVSServiceEndpoint> serviceEndpoints) {
        this.serviceEndpoints = serviceEndpoints;
    }

    /**
     * ServiceInstanceGUID is the GUID of the Power IAAS instance created from the IBM Cloud Catalog before the cluster is completed.  Leave unset to allow the installer to create a service instance during cluster creation.
     */
    @JsonProperty("serviceInstanceGUID")
    public String getServiceInstanceGUID() {
        return serviceInstanceGUID;
    }

    /**
     * ServiceInstanceGUID is the GUID of the Power IAAS instance created from the IBM Cloud Catalog before the cluster is completed.  Leave unset to allow the installer to create a service instance during cluster creation.
     */
    @JsonProperty("serviceInstanceGUID")
    public void setServiceInstanceGUID(String serviceInstanceGUID) {
        this.serviceInstanceGUID = serviceInstanceGUID;
    }

    /**
     * tgName is the name or id of a pre-created TransitGateway inside IBM Cloud.
     */
    @JsonProperty("tgName")
    public String getTgName() {
        return tgName;
    }

    /**
     * tgName is the name or id of a pre-created TransitGateway inside IBM Cloud.
     */
    @JsonProperty("tgName")
    public void setTgName(String tgName) {
        this.tgName = tgName;
    }

    /**
     * UserID is the login for the user's IBM Cloud account.
     */
    @JsonProperty("userID")
    public String getUserID() {
        return userID;
    }

    /**
     * UserID is the login for the user's IBM Cloud account.
     */
    @JsonProperty("userID")
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * vpcName is the name or id of a pre-created VPC inside IBM Cloud.
     */
    @JsonProperty("vpcName")
    public String getVpcName() {
        return vpcName;
    }

    /**
     * vpcName is the name or id of a pre-created VPC inside IBM Cloud.
     */
    @JsonProperty("vpcName")
    public void setVpcName(String vpcName) {
        this.vpcName = vpcName;
    }

    /**
     * VPCRegion specifies the IBM Cloud region in which to create VPC resources. Leave unset to allow installer to select the closest VPC region.
     */
    @JsonProperty("vpcRegion")
    public String getVpcRegion() {
        return vpcRegion;
    }

    /**
     * VPCRegion specifies the IBM Cloud region in which to create VPC resources. Leave unset to allow installer to select the closest VPC region.
     */
    @JsonProperty("vpcRegion")
    public void setVpcRegion(String vpcRegion) {
        this.vpcRegion = vpcRegion;
    }

    /**
     * VPCSubnets specifies existing subnets (by ID) where cluster resources will be created.  Leave unset to have the installer create subnets in a new VPC on your behalf.
     */
    @JsonProperty("vpcSubnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getVpcSubnets() {
        return vpcSubnets;
    }

    /**
     * VPCSubnets specifies existing subnets (by ID) where cluster resources will be created.  Leave unset to have the installer create subnets in a new VPC on your behalf.
     */
    @JsonProperty("vpcSubnets")
    public void setVpcSubnets(List<String> vpcSubnets) {
        this.vpcSubnets = vpcSubnets;
    }

    /**
     * Zone specifies the IBM Cloud colo region where the cluster will be created. At this time, only single-zone clusters are supported.
     */
    @JsonProperty("zone")
    public String getZone() {
        return zone;
    }

    /**
     * Zone specifies the IBM Cloud colo region where the cluster will be created. At this time, only single-zone clusters are supported.
     */
    @JsonProperty("zone")
    public void setZone(String zone) {
        this.zone = zone;
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Platform)) {
            return false;
        }
        Platform other = (Platform) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$clusterOSImage = this.getClusterOSImage();
        Object other$clusterOSImage = other.getClusterOSImage();
        if (this$clusterOSImage == null ? other$clusterOSImage != null : !this$clusterOSImage.equals(other$clusterOSImage)) {
            return false;
        }
        Object this$defaultMachinePlatform = this.getDefaultMachinePlatform();
        Object other$defaultMachinePlatform = other.getDefaultMachinePlatform();
        if (this$defaultMachinePlatform == null ? other$defaultMachinePlatform != null : !this$defaultMachinePlatform.equals(other$defaultMachinePlatform)) {
            return false;
        }
        Object this$powervsResourceGroup = this.getPowervsResourceGroup();
        Object other$powervsResourceGroup = other.getPowervsResourceGroup();
        if (this$powervsResourceGroup == null ? other$powervsResourceGroup != null : !this$powervsResourceGroup.equals(other$powervsResourceGroup)) {
            return false;
        }
        Object this$region = this.getRegion();
        Object other$region = other.getRegion();
        if (this$region == null ? other$region != null : !this$region.equals(other$region)) {
            return false;
        }
        Object this$serviceEndpoints = this.getServiceEndpoints();
        Object other$serviceEndpoints = other.getServiceEndpoints();
        if (this$serviceEndpoints == null ? other$serviceEndpoints != null : !this$serviceEndpoints.equals(other$serviceEndpoints)) {
            return false;
        }
        Object this$serviceInstanceGUID = this.getServiceInstanceGUID();
        Object other$serviceInstanceGUID = other.getServiceInstanceGUID();
        if (this$serviceInstanceGUID == null ? other$serviceInstanceGUID != null : !this$serviceInstanceGUID.equals(other$serviceInstanceGUID)) {
            return false;
        }
        Object this$tgName = this.getTgName();
        Object other$tgName = other.getTgName();
        if (this$tgName == null ? other$tgName != null : !this$tgName.equals(other$tgName)) {
            return false;
        }
        Object this$userID = this.getUserID();
        Object other$userID = other.getUserID();
        if (this$userID == null ? other$userID != null : !this$userID.equals(other$userID)) {
            return false;
        }
        Object this$vpcName = this.getVpcName();
        Object other$vpcName = other.getVpcName();
        if (this$vpcName == null ? other$vpcName != null : !this$vpcName.equals(other$vpcName)) {
            return false;
        }
        Object this$vpcRegion = this.getVpcRegion();
        Object other$vpcRegion = other.getVpcRegion();
        if (this$vpcRegion == null ? other$vpcRegion != null : !this$vpcRegion.equals(other$vpcRegion)) {
            return false;
        }
        Object this$vpcSubnets = this.getVpcSubnets();
        Object other$vpcSubnets = other.getVpcSubnets();
        if (this$vpcSubnets == null ? other$vpcSubnets != null : !this$vpcSubnets.equals(other$vpcSubnets)) {
            return false;
        }
        Object this$zone = this.getZone();
        Object other$zone = other.getZone();
        if (this$zone == null ? other$zone != null : !this$zone.equals(other$zone)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof Platform;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $clusterOSImage = this.getClusterOSImage();
        result = result * prime + ($clusterOSImage == null ? 43 : $clusterOSImage.hashCode());
        Object $defaultMachinePlatform = this.getDefaultMachinePlatform();
        result = result * prime + ($defaultMachinePlatform == null ? 43 : $defaultMachinePlatform.hashCode());
        Object $powervsResourceGroup = this.getPowervsResourceGroup();
        result = result * prime + ($powervsResourceGroup == null ? 43 : $powervsResourceGroup.hashCode());
        Object $region = this.getRegion();
        result = result * prime + ($region == null ? 43 : $region.hashCode());
        Object $serviceEndpoints = this.getServiceEndpoints();
        result = result * prime + ($serviceEndpoints == null ? 43 : $serviceEndpoints.hashCode());
        Object $serviceInstanceGUID = this.getServiceInstanceGUID();
        result = result * prime + ($serviceInstanceGUID == null ? 43 : $serviceInstanceGUID.hashCode());
        Object $tgName = this.getTgName();
        result = result * prime + ($tgName == null ? 43 : $tgName.hashCode());
        Object $userID = this.getUserID();
        result = result * prime + ($userID == null ? 43 : $userID.hashCode());
        Object $vpcName = this.getVpcName();
        result = result * prime + ($vpcName == null ? 43 : $vpcName.hashCode());
        Object $vpcRegion = this.getVpcRegion();
        result = result * prime + ($vpcRegion == null ? 43 : $vpcRegion.hashCode());
        Object $vpcSubnets = this.getVpcSubnets();
        result = result * prime + ($vpcSubnets == null ? 43 : $vpcSubnets.hashCode());
        Object $zone = this.getZone();
        result = result * prime + ($zone == null ? 43 : $zone.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Platform(" + "clusterOSImage=" + this.getClusterOSImage() + ", defaultMachinePlatform=" + this.getDefaultMachinePlatform() + ", powervsResourceGroup=" + this.getPowervsResourceGroup() + ", region=" + this.getRegion() + ", serviceEndpoints=" + this.getServiceEndpoints() + ", serviceInstanceGUID=" + this.getServiceInstanceGUID() + ", tgName=" + this.getTgName() + ", userID=" + this.getUserID() + ", vpcName=" + this.getVpcName() + ", vpcRegion=" + this.getVpcRegion() + ", vpcSubnets=" + this.getVpcSubnets() + ", zone=" + this.getZone() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
