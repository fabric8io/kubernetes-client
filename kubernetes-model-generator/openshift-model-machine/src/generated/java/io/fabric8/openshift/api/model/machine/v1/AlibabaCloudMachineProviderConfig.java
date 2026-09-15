
package io.fabric8.openshift.api.model.machine.v1;

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
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * AlibabaCloudMachineProviderConfig is the Schema for the alibabacloudmachineproviderconfig API Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "bandwidth",
    "credentialsSecret",
    "dataDisk",
    "imageId",
    "instanceType",
    "ramRoleName",
    "regionId",
    "resourceGroup",
    "securityGroups",
    "systemDisk",
    "tag",
    "tenancy",
    "userDataSecret",
    "vSwitch",
    "vpcId",
    "zoneId"
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
@Version("v1")
@Group("machine.openshift.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class AlibabaCloudMachineProviderConfig implements Editable<AlibabaCloudMachineProviderConfigBuilder>, HasMetadata, Namespaced
{

    @JsonProperty("apiVersion")
    private String apiVersion = "machine.openshift.io/v1";
    @JsonProperty("bandwidth")
    private BandwidthProperties bandwidth;
    @JsonProperty("credentialsSecret")
    private LocalObjectReference credentialsSecret;
    @JsonProperty("dataDisk")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DataDiskProperties> dataDisk = new ArrayList<>();
    @JsonProperty("imageId")
    private String imageId;
    @JsonProperty("instanceType")
    private String instanceType;
    @JsonProperty("kind")
    private String kind = "AlibabaCloudMachineProviderConfig";
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("ramRoleName")
    private String ramRoleName;
    @JsonProperty("regionId")
    private String regionId;
    @JsonProperty("resourceGroup")
    private AlibabaResourceReference resourceGroup;
    @JsonProperty("securityGroups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AlibabaResourceReference> securityGroups = new ArrayList<>();
    @JsonProperty("systemDisk")
    private SystemDiskProperties systemDisk;
    @JsonProperty("tag")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Tag> tag = new ArrayList<>();
    @JsonProperty("tenancy")
    private String tenancy;
    @JsonProperty("userDataSecret")
    private LocalObjectReference userDataSecret;
    @JsonProperty("vSwitch")
    private AlibabaResourceReference vSwitch;
    @JsonProperty("vpcId")
    private String vpcId;
    @JsonProperty("zoneId")
    private String zoneId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AlibabaCloudMachineProviderConfig() {
    }

    public AlibabaCloudMachineProviderConfig(String apiVersion, BandwidthProperties bandwidth, LocalObjectReference credentialsSecret, List<DataDiskProperties> dataDisk, String imageId, String instanceType, String kind, ObjectMeta metadata, String ramRoleName, String regionId, AlibabaResourceReference resourceGroup, List<AlibabaResourceReference> securityGroups, SystemDiskProperties systemDisk, List<Tag> tag, String tenancy, LocalObjectReference userDataSecret, AlibabaResourceReference vSwitch, String vpcId, String zoneId) {
        super();
        this.apiVersion = apiVersion;
        this.bandwidth = bandwidth;
        this.credentialsSecret = credentialsSecret;
        this.dataDisk = dataDisk;
        this.imageId = imageId;
        this.instanceType = instanceType;
        this.kind = kind;
        this.metadata = metadata;
        this.ramRoleName = ramRoleName;
        this.regionId = regionId;
        this.resourceGroup = resourceGroup;
        this.securityGroups = securityGroups;
        this.systemDisk = systemDisk;
        this.tag = tag;
        this.tenancy = tenancy;
        this.userDataSecret = userDataSecret;
        this.vSwitch = vSwitch;
        this.vpcId = vpcId;
        this.zoneId = zoneId;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     * AlibabaCloudMachineProviderConfig is the Schema for the alibabacloudmachineproviderconfig API Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("bandwidth")
    public BandwidthProperties getBandwidth() {
        return bandwidth;
    }

    /**
     * AlibabaCloudMachineProviderConfig is the Schema for the alibabacloudmachineproviderconfig API Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("bandwidth")
    public void setBandwidth(BandwidthProperties bandwidth) {
        this.bandwidth = bandwidth;
    }

    /**
     * AlibabaCloudMachineProviderConfig is the Schema for the alibabacloudmachineproviderconfig API Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("credentialsSecret")
    public LocalObjectReference getCredentialsSecret() {
        return credentialsSecret;
    }

    /**
     * AlibabaCloudMachineProviderConfig is the Schema for the alibabacloudmachineproviderconfig API Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("credentialsSecret")
    public void setCredentialsSecret(LocalObjectReference credentialsSecret) {
        this.credentialsSecret = credentialsSecret;
    }

    /**
     * DataDisks holds information regarding the extra disks attached to the instance
     */
    @JsonProperty("dataDisk")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DataDiskProperties> getDataDisk() {
        return dataDisk;
    }

    /**
     * DataDisks holds information regarding the extra disks attached to the instance
     */
    @JsonProperty("dataDisk")
    public void setDataDisk(List<DataDiskProperties> dataDisk) {
        this.dataDisk = dataDisk;
    }

    /**
     * The ID of the image used to create the instance.
     */
    @JsonProperty("imageId")
    public String getImageId() {
        return imageId;
    }

    /**
     * The ID of the image used to create the instance.
     */
    @JsonProperty("imageId")
    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    /**
     * The instance type of the instance.
     */
    @JsonProperty("instanceType")
    public String getInstanceType() {
        return instanceType;
    }

    /**
     * The instance type of the instance.
     */
    @JsonProperty("instanceType")
    public void setInstanceType(String instanceType) {
        this.instanceType = instanceType;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * AlibabaCloudMachineProviderConfig is the Schema for the alibabacloudmachineproviderconfig API Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * AlibabaCloudMachineProviderConfig is the Schema for the alibabacloudmachineproviderconfig API Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * ramRoleName is the name of the instance Resource Access Management (RAM) role. This allows the instance to perform API calls as this specified RAM role.
     */
    @JsonProperty("ramRoleName")
    public String getRamRoleName() {
        return ramRoleName;
    }

    /**
     * ramRoleName is the name of the instance Resource Access Management (RAM) role. This allows the instance to perform API calls as this specified RAM role.
     */
    @JsonProperty("ramRoleName")
    public void setRamRoleName(String ramRoleName) {
        this.ramRoleName = ramRoleName;
    }

    /**
     * The ID of the region in which to create the instance. You can call the DescribeRegions operation to query the most recent region list.
     */
    @JsonProperty("regionId")
    public String getRegionId() {
        return regionId;
    }

    /**
     * The ID of the region in which to create the instance. You can call the DescribeRegions operation to query the most recent region list.
     */
    @JsonProperty("regionId")
    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    /**
     * AlibabaCloudMachineProviderConfig is the Schema for the alibabacloudmachineproviderconfig API Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("resourceGroup")
    public AlibabaResourceReference getResourceGroup() {
        return resourceGroup;
    }

    /**
     * AlibabaCloudMachineProviderConfig is the Schema for the alibabacloudmachineproviderconfig API Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("resourceGroup")
    public void setResourceGroup(AlibabaResourceReference resourceGroup) {
        this.resourceGroup = resourceGroup;
    }

    /**
     * securityGroups is a list of security group references to assign to the instance. A reference holds either the security group ID, the resource name, or the required tags to search. When more than one security group is returned for a tag search, all the groups are associated with the instance up to the maximum number of security groups to which an instance can belong. For more information, see the "Security group limits" section in Limits. https://www.alibabacloud.com/help/en/doc-detail/25412.htm
     */
    @JsonProperty("securityGroups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AlibabaResourceReference> getSecurityGroups() {
        return securityGroups;
    }

    /**
     * securityGroups is a list of security group references to assign to the instance. A reference holds either the security group ID, the resource name, or the required tags to search. When more than one security group is returned for a tag search, all the groups are associated with the instance up to the maximum number of security groups to which an instance can belong. For more information, see the "Security group limits" section in Limits. https://www.alibabacloud.com/help/en/doc-detail/25412.htm
     */
    @JsonProperty("securityGroups")
    public void setSecurityGroups(List<AlibabaResourceReference> securityGroups) {
        this.securityGroups = securityGroups;
    }

    /**
     * AlibabaCloudMachineProviderConfig is the Schema for the alibabacloudmachineproviderconfig API Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("systemDisk")
    public SystemDiskProperties getSystemDisk() {
        return systemDisk;
    }

    /**
     * AlibabaCloudMachineProviderConfig is the Schema for the alibabacloudmachineproviderconfig API Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("systemDisk")
    public void setSystemDisk(SystemDiskProperties systemDisk) {
        this.systemDisk = systemDisk;
    }

    /**
     * Tags are the set of metadata to add to an instance.
     */
    @JsonProperty("tag")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Tag> getTag() {
        return tag;
    }

    /**
     * Tags are the set of metadata to add to an instance.
     */
    @JsonProperty("tag")
    public void setTag(List<Tag> tag) {
        this.tag = tag;
    }

    /**
     * tenancy specifies whether to create the instance on a dedicated host. Valid values:<br><p> <br><p> default: creates the instance on a non-dedicated host. host: creates the instance on a dedicated host. If you do not specify the DedicatedHostID parameter, Alibaba Cloud automatically selects a dedicated host for the instance. Empty value means no opinion and the platform chooses the a default, which is subject to change over time. Currently the default is `default`.
     */
    @JsonProperty("tenancy")
    public String getTenancy() {
        return tenancy;
    }

    /**
     * tenancy specifies whether to create the instance on a dedicated host. Valid values:<br><p> <br><p> default: creates the instance on a non-dedicated host. host: creates the instance on a dedicated host. If you do not specify the DedicatedHostID parameter, Alibaba Cloud automatically selects a dedicated host for the instance. Empty value means no opinion and the platform chooses the a default, which is subject to change over time. Currently the default is `default`.
     */
    @JsonProperty("tenancy")
    public void setTenancy(String tenancy) {
        this.tenancy = tenancy;
    }

    /**
     * AlibabaCloudMachineProviderConfig is the Schema for the alibabacloudmachineproviderconfig API Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("userDataSecret")
    public LocalObjectReference getUserDataSecret() {
        return userDataSecret;
    }

    /**
     * AlibabaCloudMachineProviderConfig is the Schema for the alibabacloudmachineproviderconfig API Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("userDataSecret")
    public void setUserDataSecret(LocalObjectReference userDataSecret) {
        this.userDataSecret = userDataSecret;
    }

    /**
     * AlibabaCloudMachineProviderConfig is the Schema for the alibabacloudmachineproviderconfig API Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("vSwitch")
    public AlibabaResourceReference getVSwitch() {
        return vSwitch;
    }

    /**
     * AlibabaCloudMachineProviderConfig is the Schema for the alibabacloudmachineproviderconfig API Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("vSwitch")
    public void setVSwitch(AlibabaResourceReference vSwitch) {
        this.vSwitch = vSwitch;
    }

    /**
     * The ID of the vpc
     */
    @JsonProperty("vpcId")
    public String getVpcId() {
        return vpcId;
    }

    /**
     * The ID of the vpc
     */
    @JsonProperty("vpcId")
    public void setVpcId(String vpcId) {
        this.vpcId = vpcId;
    }

    /**
     * The ID of the zone in which to create the instance. You can call the DescribeZones operation to query the most recent region list.
     */
    @JsonProperty("zoneId")
    public String getZoneId() {
        return zoneId;
    }

    /**
     * The ID of the zone in which to create the instance. You can call the DescribeZones operation to query the most recent region list.
     */
    @JsonProperty("zoneId")
    public void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }

    @JsonIgnore
    public AlibabaCloudMachineProviderConfigBuilder edit() {
        return new AlibabaCloudMachineProviderConfigBuilder(this);
    }

    @JsonIgnore
    public AlibabaCloudMachineProviderConfigBuilder toBuilder() {
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
        if (!(o instanceof AlibabaCloudMachineProviderConfig)) {
            return false;
        }
        AlibabaCloudMachineProviderConfig other = (AlibabaCloudMachineProviderConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$apiVersion = this.getApiVersion();
        Object other$apiVersion = other.getApiVersion();
        if (this$apiVersion == null ? other$apiVersion != null : !this$apiVersion.equals(other$apiVersion)) {
            return false;
        }
        Object this$bandwidth = this.getBandwidth();
        Object other$bandwidth = other.getBandwidth();
        if (this$bandwidth == null ? other$bandwidth != null : !this$bandwidth.equals(other$bandwidth)) {
            return false;
        }
        Object this$credentialsSecret = this.getCredentialsSecret();
        Object other$credentialsSecret = other.getCredentialsSecret();
        if (this$credentialsSecret == null ? other$credentialsSecret != null : !this$credentialsSecret.equals(other$credentialsSecret)) {
            return false;
        }
        Object this$dataDisk = this.getDataDisk();
        Object other$dataDisk = other.getDataDisk();
        if (this$dataDisk == null ? other$dataDisk != null : !this$dataDisk.equals(other$dataDisk)) {
            return false;
        }
        Object this$imageId = this.getImageId();
        Object other$imageId = other.getImageId();
        if (this$imageId == null ? other$imageId != null : !this$imageId.equals(other$imageId)) {
            return false;
        }
        Object this$instanceType = this.getInstanceType();
        Object other$instanceType = other.getInstanceType();
        if (this$instanceType == null ? other$instanceType != null : !this$instanceType.equals(other$instanceType)) {
            return false;
        }
        Object this$kind = this.getKind();
        Object other$kind = other.getKind();
        if (this$kind == null ? other$kind != null : !this$kind.equals(other$kind)) {
            return false;
        }
        Object this$metadata = this.getMetadata();
        Object other$metadata = other.getMetadata();
        if (this$metadata == null ? other$metadata != null : !this$metadata.equals(other$metadata)) {
            return false;
        }
        Object this$ramRoleName = this.getRamRoleName();
        Object other$ramRoleName = other.getRamRoleName();
        if (this$ramRoleName == null ? other$ramRoleName != null : !this$ramRoleName.equals(other$ramRoleName)) {
            return false;
        }
        Object this$regionId = this.getRegionId();
        Object other$regionId = other.getRegionId();
        if (this$regionId == null ? other$regionId != null : !this$regionId.equals(other$regionId)) {
            return false;
        }
        Object this$resourceGroup = this.getResourceGroup();
        Object other$resourceGroup = other.getResourceGroup();
        if (this$resourceGroup == null ? other$resourceGroup != null : !this$resourceGroup.equals(other$resourceGroup)) {
            return false;
        }
        Object this$securityGroups = this.getSecurityGroups();
        Object other$securityGroups = other.getSecurityGroups();
        if (this$securityGroups == null ? other$securityGroups != null : !this$securityGroups.equals(other$securityGroups)) {
            return false;
        }
        Object this$systemDisk = this.getSystemDisk();
        Object other$systemDisk = other.getSystemDisk();
        if (this$systemDisk == null ? other$systemDisk != null : !this$systemDisk.equals(other$systemDisk)) {
            return false;
        }
        Object this$tag = this.getTag();
        Object other$tag = other.getTag();
        if (this$tag == null ? other$tag != null : !this$tag.equals(other$tag)) {
            return false;
        }
        Object this$tenancy = this.getTenancy();
        Object other$tenancy = other.getTenancy();
        if (this$tenancy == null ? other$tenancy != null : !this$tenancy.equals(other$tenancy)) {
            return false;
        }
        Object this$userDataSecret = this.getUserDataSecret();
        Object other$userDataSecret = other.getUserDataSecret();
        if (this$userDataSecret == null ? other$userDataSecret != null : !this$userDataSecret.equals(other$userDataSecret)) {
            return false;
        }
        Object this$vSwitch = this.getVSwitch();
        Object other$vSwitch = other.getVSwitch();
        if (this$vSwitch == null ? other$vSwitch != null : !this$vSwitch.equals(other$vSwitch)) {
            return false;
        }
        Object this$vpcId = this.getVpcId();
        Object other$vpcId = other.getVpcId();
        if (this$vpcId == null ? other$vpcId != null : !this$vpcId.equals(other$vpcId)) {
            return false;
        }
        Object this$zoneId = this.getZoneId();
        Object other$zoneId = other.getZoneId();
        if (this$zoneId == null ? other$zoneId != null : !this$zoneId.equals(other$zoneId)) {
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
        return other instanceof AlibabaCloudMachineProviderConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiVersion = this.getApiVersion();
        result = result * prime + ($apiVersion == null ? 43 : $apiVersion.hashCode());
        Object $bandwidth = this.getBandwidth();
        result = result * prime + ($bandwidth == null ? 43 : $bandwidth.hashCode());
        Object $credentialsSecret = this.getCredentialsSecret();
        result = result * prime + ($credentialsSecret == null ? 43 : $credentialsSecret.hashCode());
        Object $dataDisk = this.getDataDisk();
        result = result * prime + ($dataDisk == null ? 43 : $dataDisk.hashCode());
        Object $imageId = this.getImageId();
        result = result * prime + ($imageId == null ? 43 : $imageId.hashCode());
        Object $instanceType = this.getInstanceType();
        result = result * prime + ($instanceType == null ? 43 : $instanceType.hashCode());
        Object $kind = this.getKind();
        result = result * prime + ($kind == null ? 43 : $kind.hashCode());
        Object $metadata = this.getMetadata();
        result = result * prime + ($metadata == null ? 43 : $metadata.hashCode());
        Object $ramRoleName = this.getRamRoleName();
        result = result * prime + ($ramRoleName == null ? 43 : $ramRoleName.hashCode());
        Object $regionId = this.getRegionId();
        result = result * prime + ($regionId == null ? 43 : $regionId.hashCode());
        Object $resourceGroup = this.getResourceGroup();
        result = result * prime + ($resourceGroup == null ? 43 : $resourceGroup.hashCode());
        Object $securityGroups = this.getSecurityGroups();
        result = result * prime + ($securityGroups == null ? 43 : $securityGroups.hashCode());
        Object $systemDisk = this.getSystemDisk();
        result = result * prime + ($systemDisk == null ? 43 : $systemDisk.hashCode());
        Object $tag = this.getTag();
        result = result * prime + ($tag == null ? 43 : $tag.hashCode());
        Object $tenancy = this.getTenancy();
        result = result * prime + ($tenancy == null ? 43 : $tenancy.hashCode());
        Object $userDataSecret = this.getUserDataSecret();
        result = result * prime + ($userDataSecret == null ? 43 : $userDataSecret.hashCode());
        Object $vSwitch = this.getVSwitch();
        result = result * prime + ($vSwitch == null ? 43 : $vSwitch.hashCode());
        Object $vpcId = this.getVpcId();
        result = result * prime + ($vpcId == null ? 43 : $vpcId.hashCode());
        Object $zoneId = this.getZoneId();
        result = result * prime + ($zoneId == null ? 43 : $zoneId.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AlibabaCloudMachineProviderConfig(" + "apiVersion=" + this.getApiVersion() + ", bandwidth=" + this.getBandwidth() + ", credentialsSecret=" + this.getCredentialsSecret() + ", dataDisk=" + this.getDataDisk() + ", imageId=" + this.getImageId() + ", instanceType=" + this.getInstanceType() + ", kind=" + this.getKind() + ", metadata=" + this.getMetadata() + ", ramRoleName=" + this.getRamRoleName() + ", regionId=" + this.getRegionId() + ", resourceGroup=" + this.getResourceGroup() + ", securityGroups=" + this.getSecurityGroups() + ", systemDisk=" + this.getSystemDisk() + ", tag=" + this.getTag() + ", tenancy=" + this.getTenancy() + ", userDataSecret=" + this.getUserDataSecret() + ", vSwitch=" + this.getVSwitch() + ", vpcId=" + this.getVpcId() + ", zoneId=" + this.getZoneId() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
