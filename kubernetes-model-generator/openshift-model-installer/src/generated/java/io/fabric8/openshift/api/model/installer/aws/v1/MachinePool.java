
package io.fabric8.openshift.api.model.installer.aws.v1;

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

/**
 * MachinePool stores the configuration for a machine pool installed on AWS.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "additionalSecurityGroupIDs",
    "amiID",
    "cpuOptions",
    "iamProfile",
    "iamRole",
    "metadataService",
    "rootVolume",
    "type",
    "zones"
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
public class MachinePool implements Editable<MachinePoolBuilder>, KubernetesResource
{

    @JsonProperty("additionalSecurityGroupIDs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> additionalSecurityGroupIDs = new ArrayList<>();
    @JsonProperty("amiID")
    private String amiID;
    @JsonProperty("cpuOptions")
    private CPUOptions cpuOptions;
    @JsonProperty("iamProfile")
    private String iamProfile;
    @JsonProperty("iamRole")
    private String iamRole;
    @JsonProperty("metadataService")
    private EC2Metadata metadataService;
    @JsonProperty("rootVolume")
    private EC2RootVolume rootVolume;
    @JsonProperty("type")
    private String type;
    @JsonProperty("zones")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> zones = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachinePool() {
    }

    public MachinePool(List<String> additionalSecurityGroupIDs, String amiID, CPUOptions cpuOptions, String iamProfile, String iamRole, EC2Metadata metadataService, EC2RootVolume rootVolume, String type, List<String> zones) {
        super();
        this.additionalSecurityGroupIDs = additionalSecurityGroupIDs;
        this.amiID = amiID;
        this.cpuOptions = cpuOptions;
        this.iamProfile = iamProfile;
        this.iamRole = iamRole;
        this.metadataService = metadataService;
        this.rootVolume = rootVolume;
        this.type = type;
        this.zones = zones;
    }

    /**
     * AdditionalSecurityGroupIDs contains IDs of additional security groups for machines, where each ID is presented in the format sg-xxxx.
     */
    @JsonProperty("additionalSecurityGroupIDs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAdditionalSecurityGroupIDs() {
        return additionalSecurityGroupIDs;
    }

    /**
     * AdditionalSecurityGroupIDs contains IDs of additional security groups for machines, where each ID is presented in the format sg-xxxx.
     */
    @JsonProperty("additionalSecurityGroupIDs")
    public void setAdditionalSecurityGroupIDs(List<String> additionalSecurityGroupIDs) {
        this.additionalSecurityGroupIDs = additionalSecurityGroupIDs;
    }

    /**
     * AMIID is the AMI that should be used to boot the ec2 instance. If set, the AMI should belong to the same region as the cluster.
     */
    @JsonProperty("amiID")
    public String getAmiID() {
        return amiID;
    }

    /**
     * AMIID is the AMI that should be used to boot the ec2 instance. If set, the AMI should belong to the same region as the cluster.
     */
    @JsonProperty("amiID")
    public void setAmiID(String amiID) {
        this.amiID = amiID;
    }

    /**
     * MachinePool stores the configuration for a machine pool installed on AWS.
     */
    @JsonProperty("cpuOptions")
    public CPUOptions getCpuOptions() {
        return cpuOptions;
    }

    /**
     * MachinePool stores the configuration for a machine pool installed on AWS.
     */
    @JsonProperty("cpuOptions")
    public void setCpuOptions(CPUOptions cpuOptions) {
        this.cpuOptions = cpuOptions;
    }

    /**
     * IAMProfile is the name of the IAM instance profile to use for the machine. Leave unset to have the installer create the IAM Profile on your behalf. Cannot be specified together with iamRole.
     */
    @JsonProperty("iamProfile")
    public String getIamProfile() {
        return iamProfile;
    }

    /**
     * IAMProfile is the name of the IAM instance profile to use for the machine. Leave unset to have the installer create the IAM Profile on your behalf. Cannot be specified together with iamRole.
     */
    @JsonProperty("iamProfile")
    public void setIamProfile(String iamProfile) {
        this.iamProfile = iamProfile;
    }

    /**
     * IAMRole is the name of the IAM Role to use for the instance profile of the machine. Leave unset to have the installer create the IAM Role on your behalf. Cannot be specified together with iamProfile.
     */
    @JsonProperty("iamRole")
    public String getIamRole() {
        return iamRole;
    }

    /**
     * IAMRole is the name of the IAM Role to use for the instance profile of the machine. Leave unset to have the installer create the IAM Role on your behalf. Cannot be specified together with iamProfile.
     */
    @JsonProperty("iamRole")
    public void setIamRole(String iamRole) {
        this.iamRole = iamRole;
    }

    /**
     * MachinePool stores the configuration for a machine pool installed on AWS.
     */
    @JsonProperty("metadataService")
    public EC2Metadata getMetadataService() {
        return metadataService;
    }

    /**
     * MachinePool stores the configuration for a machine pool installed on AWS.
     */
    @JsonProperty("metadataService")
    public void setMetadataService(EC2Metadata metadataService) {
        this.metadataService = metadataService;
    }

    /**
     * MachinePool stores the configuration for a machine pool installed on AWS.
     */
    @JsonProperty("rootVolume")
    public EC2RootVolume getRootVolume() {
        return rootVolume;
    }

    /**
     * MachinePool stores the configuration for a machine pool installed on AWS.
     */
    @JsonProperty("rootVolume")
    public void setRootVolume(EC2RootVolume rootVolume) {
        this.rootVolume = rootVolume;
    }

    /**
     * InstanceType defines the ec2 instance type. eg. m4-large
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * InstanceType defines the ec2 instance type. eg. m4-large
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Zones is list of availability zones that can be used.
     */
    @JsonProperty("zones")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getZones() {
        return zones;
    }

    /**
     * Zones is list of availability zones that can be used.
     */
    @JsonProperty("zones")
    public void setZones(List<String> zones) {
        this.zones = zones;
    }

    @JsonIgnore
    public MachinePoolBuilder edit() {
        return new MachinePoolBuilder(this);
    }

    @JsonIgnore
    public MachinePoolBuilder toBuilder() {
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
        if (!(o instanceof MachinePool)) {
            return false;
        }
        MachinePool other = (MachinePool) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$additionalSecurityGroupIDs = this.getAdditionalSecurityGroupIDs();
        Object other$additionalSecurityGroupIDs = other.getAdditionalSecurityGroupIDs();
        if (this$additionalSecurityGroupIDs == null ? other$additionalSecurityGroupIDs != null : !this$additionalSecurityGroupIDs.equals(other$additionalSecurityGroupIDs)) {
            return false;
        }
        Object this$amiID = this.getAmiID();
        Object other$amiID = other.getAmiID();
        if (this$amiID == null ? other$amiID != null : !this$amiID.equals(other$amiID)) {
            return false;
        }
        Object this$cpuOptions = this.getCpuOptions();
        Object other$cpuOptions = other.getCpuOptions();
        if (this$cpuOptions == null ? other$cpuOptions != null : !this$cpuOptions.equals(other$cpuOptions)) {
            return false;
        }
        Object this$iamProfile = this.getIamProfile();
        Object other$iamProfile = other.getIamProfile();
        if (this$iamProfile == null ? other$iamProfile != null : !this$iamProfile.equals(other$iamProfile)) {
            return false;
        }
        Object this$iamRole = this.getIamRole();
        Object other$iamRole = other.getIamRole();
        if (this$iamRole == null ? other$iamRole != null : !this$iamRole.equals(other$iamRole)) {
            return false;
        }
        Object this$metadataService = this.getMetadataService();
        Object other$metadataService = other.getMetadataService();
        if (this$metadataService == null ? other$metadataService != null : !this$metadataService.equals(other$metadataService)) {
            return false;
        }
        Object this$rootVolume = this.getRootVolume();
        Object other$rootVolume = other.getRootVolume();
        if (this$rootVolume == null ? other$rootVolume != null : !this$rootVolume.equals(other$rootVolume)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
            return false;
        }
        Object this$zones = this.getZones();
        Object other$zones = other.getZones();
        if (this$zones == null ? other$zones != null : !this$zones.equals(other$zones)) {
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
        return other instanceof MachinePool;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $additionalSecurityGroupIDs = this.getAdditionalSecurityGroupIDs();
        result = result * prime + ($additionalSecurityGroupIDs == null ? 43 : $additionalSecurityGroupIDs.hashCode());
        Object $amiID = this.getAmiID();
        result = result * prime + ($amiID == null ? 43 : $amiID.hashCode());
        Object $cpuOptions = this.getCpuOptions();
        result = result * prime + ($cpuOptions == null ? 43 : $cpuOptions.hashCode());
        Object $iamProfile = this.getIamProfile();
        result = result * prime + ($iamProfile == null ? 43 : $iamProfile.hashCode());
        Object $iamRole = this.getIamRole();
        result = result * prime + ($iamRole == null ? 43 : $iamRole.hashCode());
        Object $metadataService = this.getMetadataService();
        result = result * prime + ($metadataService == null ? 43 : $metadataService.hashCode());
        Object $rootVolume = this.getRootVolume();
        result = result * prime + ($rootVolume == null ? 43 : $rootVolume.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $zones = this.getZones();
        result = result * prime + ($zones == null ? 43 : $zones.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "MachinePool(" + "additionalSecurityGroupIDs=" + this.getAdditionalSecurityGroupIDs() + ", amiID=" + this.getAmiID() + ", cpuOptions=" + this.getCpuOptions() + ", iamProfile=" + this.getIamProfile() + ", iamRole=" + this.getIamRole() + ", metadataService=" + this.getMetadataService() + ", rootVolume=" + this.getRootVolume() + ", type=" + this.getType() + ", zones=" + this.getZones() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
