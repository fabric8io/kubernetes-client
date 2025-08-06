
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
import io.sundr.transform.annotations.TemplateTransformation;
import io.sundr.transform.annotations.TemplateTransformations;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
@TemplateTransformations({
    @TemplateTransformation(value = "/manifest.vm", outputPath = "META-INF/services/io.fabric8.kubernetes.api.model.KubernetesResource", gather = true)
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

}
