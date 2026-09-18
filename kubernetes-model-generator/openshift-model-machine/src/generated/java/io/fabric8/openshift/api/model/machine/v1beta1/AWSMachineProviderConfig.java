
package io.fabric8.openshift.api.model.machine.v1beta1;

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
 * AWSMachineProviderConfig is the Schema for the awsmachineproviderconfigs API Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "ami",
    "blockDevices",
    "capacityReservationId",
    "credentialsSecret",
    "deviceIndex",
    "iamInstanceProfile",
    "instanceType",
    "keyName",
    "loadBalancers",
    "marketType",
    "metadataServiceOptions",
    "networkInterfaceType",
    "placement",
    "placementGroupName",
    "placementGroupPartition",
    "publicIp",
    "securityGroups",
    "spotMarketOptions",
    "subnet",
    "tags",
    "userDataSecret"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
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
@Version("v1beta1")
@Group("machine.openshift.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class AWSMachineProviderConfig implements Editable<AWSMachineProviderConfigBuilder>, HasMetadata, Namespaced
{

    @JsonProperty("ami")
    private AWSResourceReference ami;
    @JsonProperty("apiVersion")
    private String apiVersion = "machine.openshift.io/v1beta1";
    @JsonProperty("blockDevices")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<BlockDeviceMappingSpec> blockDevices = new ArrayList<>();
    @JsonProperty("capacityReservationId")
    private String capacityReservationId;
    @JsonProperty("credentialsSecret")
    private LocalObjectReference credentialsSecret;
    @JsonProperty("deviceIndex")
    private Long deviceIndex;
    @JsonProperty("iamInstanceProfile")
    private AWSResourceReference iamInstanceProfile;
    @JsonProperty("instanceType")
    private String instanceType;
    @JsonProperty("keyName")
    private String keyName;
    @JsonProperty("kind")
    private String kind = "AWSMachineProviderConfig";
    @JsonProperty("loadBalancers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<LoadBalancerReference> loadBalancers = new ArrayList<>();
    @JsonProperty("marketType")
    private String marketType;
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("metadataServiceOptions")
    private MetadataServiceOptions metadataServiceOptions;
    @JsonProperty("networkInterfaceType")
    private String networkInterfaceType;
    @JsonProperty("placement")
    private Placement placement;
    @JsonProperty("placementGroupName")
    private String placementGroupName;
    @JsonProperty("placementGroupPartition")
    private Integer placementGroupPartition;
    @JsonProperty("publicIp")
    private Boolean publicIp;
    @JsonProperty("securityGroups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AWSResourceReference> securityGroups = new ArrayList<>();
    @JsonProperty("spotMarketOptions")
    private SpotMarketOptions spotMarketOptions;
    @JsonProperty("subnet")
    private AWSResourceReference subnet;
    @JsonProperty("tags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TagSpecification> tags = new ArrayList<>();
    @JsonProperty("userDataSecret")
    private LocalObjectReference userDataSecret;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AWSMachineProviderConfig() {
    }

    public AWSMachineProviderConfig(AWSResourceReference ami, String apiVersion, List<BlockDeviceMappingSpec> blockDevices, String capacityReservationId, LocalObjectReference credentialsSecret, Long deviceIndex, AWSResourceReference iamInstanceProfile, String instanceType, String keyName, String kind, List<LoadBalancerReference> loadBalancers, String marketType, ObjectMeta metadata, MetadataServiceOptions metadataServiceOptions, String networkInterfaceType, Placement placement, String placementGroupName, Integer placementGroupPartition, Boolean publicIp, List<AWSResourceReference> securityGroups, SpotMarketOptions spotMarketOptions, AWSResourceReference subnet, List<TagSpecification> tags, LocalObjectReference userDataSecret) {
        super();
        this.ami = ami;
        this.apiVersion = apiVersion;
        this.blockDevices = blockDevices;
        this.capacityReservationId = capacityReservationId;
        this.credentialsSecret = credentialsSecret;
        this.deviceIndex = deviceIndex;
        this.iamInstanceProfile = iamInstanceProfile;
        this.instanceType = instanceType;
        this.keyName = keyName;
        this.kind = kind;
        this.loadBalancers = loadBalancers;
        this.marketType = marketType;
        this.metadata = metadata;
        this.metadataServiceOptions = metadataServiceOptions;
        this.networkInterfaceType = networkInterfaceType;
        this.placement = placement;
        this.placementGroupName = placementGroupName;
        this.placementGroupPartition = placementGroupPartition;
        this.publicIp = publicIp;
        this.securityGroups = securityGroups;
        this.spotMarketOptions = spotMarketOptions;
        this.subnet = subnet;
        this.tags = tags;
        this.userDataSecret = userDataSecret;
    }

    /**
     * AWSMachineProviderConfig is the Schema for the awsmachineproviderconfigs API Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("ami")
    public AWSResourceReference getAmi() {
        return ami;
    }

    /**
     * AWSMachineProviderConfig is the Schema for the awsmachineproviderconfigs API Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("ami")
    public void setAmi(AWSResourceReference ami) {
        this.ami = ami;
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
     * blockDevices is the set of block device mapping associated to this instance, block device without a name will be used as a root device and only one device without a name is allowed https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/block-device-mapping-concepts.html
     */
    @JsonProperty("blockDevices")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<BlockDeviceMappingSpec> getBlockDevices() {
        return blockDevices;
    }

    /**
     * blockDevices is the set of block device mapping associated to this instance, block device without a name will be used as a root device and only one device without a name is allowed https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/block-device-mapping-concepts.html
     */
    @JsonProperty("blockDevices")
    public void setBlockDevices(List<BlockDeviceMappingSpec> blockDevices) {
        this.blockDevices = blockDevices;
    }

    /**
     * capacityReservationId specifies the target Capacity Reservation into which the instance should be launched. The field size should be greater than 0 and the field input must start with cr-&#42;&#42;&#42;
     */
    @JsonProperty("capacityReservationId")
    public String getCapacityReservationId() {
        return capacityReservationId;
    }

    /**
     * capacityReservationId specifies the target Capacity Reservation into which the instance should be launched. The field size should be greater than 0 and the field input must start with cr-&#42;&#42;&#42;
     */
    @JsonProperty("capacityReservationId")
    public void setCapacityReservationId(String capacityReservationId) {
        this.capacityReservationId = capacityReservationId;
    }

    /**
     * AWSMachineProviderConfig is the Schema for the awsmachineproviderconfigs API Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("credentialsSecret")
    public LocalObjectReference getCredentialsSecret() {
        return credentialsSecret;
    }

    /**
     * AWSMachineProviderConfig is the Schema for the awsmachineproviderconfigs API Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("credentialsSecret")
    public void setCredentialsSecret(LocalObjectReference credentialsSecret) {
        this.credentialsSecret = credentialsSecret;
    }

    /**
     * deviceIndex is the index of the device on the instance for the network interface attachment. Defaults to 0.
     */
    @JsonProperty("deviceIndex")
    public Long getDeviceIndex() {
        return deviceIndex;
    }

    /**
     * deviceIndex is the index of the device on the instance for the network interface attachment. Defaults to 0.
     */
    @JsonProperty("deviceIndex")
    public void setDeviceIndex(Long deviceIndex) {
        this.deviceIndex = deviceIndex;
    }

    /**
     * AWSMachineProviderConfig is the Schema for the awsmachineproviderconfigs API Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("iamInstanceProfile")
    public AWSResourceReference getIamInstanceProfile() {
        return iamInstanceProfile;
    }

    /**
     * AWSMachineProviderConfig is the Schema for the awsmachineproviderconfigs API Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("iamInstanceProfile")
    public void setIamInstanceProfile(AWSResourceReference iamInstanceProfile) {
        this.iamInstanceProfile = iamInstanceProfile;
    }

    /**
     * instanceType is the type of instance to create. Example: m4.xlarge
     */
    @JsonProperty("instanceType")
    public String getInstanceType() {
        return instanceType;
    }

    /**
     * instanceType is the type of instance to create. Example: m4.xlarge
     */
    @JsonProperty("instanceType")
    public void setInstanceType(String instanceType) {
        this.instanceType = instanceType;
    }

    /**
     * keyName is the name of the KeyPair to use for SSH
     */
    @JsonProperty("keyName")
    public String getKeyName() {
        return keyName;
    }

    /**
     * keyName is the name of the KeyPair to use for SSH
     */
    @JsonProperty("keyName")
    public void setKeyName(String keyName) {
        this.keyName = keyName;
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
     * loadBalancers is the set of load balancers to which the new instance should be added once it is created.
     */
    @JsonProperty("loadBalancers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<LoadBalancerReference> getLoadBalancers() {
        return loadBalancers;
    }

    /**
     * loadBalancers is the set of load balancers to which the new instance should be added once it is created.
     */
    @JsonProperty("loadBalancers")
    public void setLoadBalancers(List<LoadBalancerReference> loadBalancers) {
        this.loadBalancers = loadBalancers;
    }

    /**
     * marketType specifies the type of market for the EC2 instance. Valid values are OnDemand, Spot, CapacityBlock and omitted.<br><p> <br><p> Defaults to OnDemand. When SpotMarketOptions is provided, the marketType defaults to "Spot".<br><p> <br><p> When set to OnDemand the instance runs as a standard OnDemand instance. When set to Spot the instance runs as a Spot instance. When set to CapacityBlock the instance utilizes pre-purchased compute capacity (capacity blocks) with AWS Capacity Reservations. If this value is selected, capacityReservationID must be specified to identify the target reservation.
     */
    @JsonProperty("marketType")
    public String getMarketType() {
        return marketType;
    }

    /**
     * marketType specifies the type of market for the EC2 instance. Valid values are OnDemand, Spot, CapacityBlock and omitted.<br><p> <br><p> Defaults to OnDemand. When SpotMarketOptions is provided, the marketType defaults to "Spot".<br><p> <br><p> When set to OnDemand the instance runs as a standard OnDemand instance. When set to Spot the instance runs as a Spot instance. When set to CapacityBlock the instance utilizes pre-purchased compute capacity (capacity blocks) with AWS Capacity Reservations. If this value is selected, capacityReservationID must be specified to identify the target reservation.
     */
    @JsonProperty("marketType")
    public void setMarketType(String marketType) {
        this.marketType = marketType;
    }

    /**
     * AWSMachineProviderConfig is the Schema for the awsmachineproviderconfigs API Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * AWSMachineProviderConfig is the Schema for the awsmachineproviderconfigs API Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * AWSMachineProviderConfig is the Schema for the awsmachineproviderconfigs API Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("metadataServiceOptions")
    public MetadataServiceOptions getMetadataServiceOptions() {
        return metadataServiceOptions;
    }

    /**
     * AWSMachineProviderConfig is the Schema for the awsmachineproviderconfigs API Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("metadataServiceOptions")
    public void setMetadataServiceOptions(MetadataServiceOptions metadataServiceOptions) {
        this.metadataServiceOptions = metadataServiceOptions;
    }

    /**
     * networkInterfaceType specifies the type of network interface to be used for the primary network interface. Valid values are "ENA", "EFA", and omitted, which means no opinion and the platform chooses a good default which may change over time. The current default value is "ENA". Please visit https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/efa.html to learn more about the AWS Elastic Fabric Adapter interface option.
     */
    @JsonProperty("networkInterfaceType")
    public String getNetworkInterfaceType() {
        return networkInterfaceType;
    }

    /**
     * networkInterfaceType specifies the type of network interface to be used for the primary network interface. Valid values are "ENA", "EFA", and omitted, which means no opinion and the platform chooses a good default which may change over time. The current default value is "ENA". Please visit https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/efa.html to learn more about the AWS Elastic Fabric Adapter interface option.
     */
    @JsonProperty("networkInterfaceType")
    public void setNetworkInterfaceType(String networkInterfaceType) {
        this.networkInterfaceType = networkInterfaceType;
    }

    /**
     * AWSMachineProviderConfig is the Schema for the awsmachineproviderconfigs API Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("placement")
    public Placement getPlacement() {
        return placement;
    }

    /**
     * AWSMachineProviderConfig is the Schema for the awsmachineproviderconfigs API Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("placement")
    public void setPlacement(Placement placement) {
        this.placement = placement;
    }

    /**
     * placementGroupName specifies the name of the placement group in which to launch the instance. The placement group must already be created and may use any placement strategy. When omitted, no placement group is used when creating the EC2 instance.
     */
    @JsonProperty("placementGroupName")
    public String getPlacementGroupName() {
        return placementGroupName;
    }

    /**
     * placementGroupName specifies the name of the placement group in which to launch the instance. The placement group must already be created and may use any placement strategy. When omitted, no placement group is used when creating the EC2 instance.
     */
    @JsonProperty("placementGroupName")
    public void setPlacementGroupName(String placementGroupName) {
        this.placementGroupName = placementGroupName;
    }

    /**
     * placementGroupPartition is the partition number within the placement group in which to launch the instance. This must be an integer value between 1 and 7. It is only valid if the placement group, referred in `PlacementGroupName` was created with strategy set to partition.
     */
    @JsonProperty("placementGroupPartition")
    public Integer getPlacementGroupPartition() {
        return placementGroupPartition;
    }

    /**
     * placementGroupPartition is the partition number within the placement group in which to launch the instance. This must be an integer value between 1 and 7. It is only valid if the placement group, referred in `PlacementGroupName` was created with strategy set to partition.
     */
    @JsonProperty("placementGroupPartition")
    public void setPlacementGroupPartition(Integer placementGroupPartition) {
        this.placementGroupPartition = placementGroupPartition;
    }

    /**
     * publicIp specifies whether the instance should get a public IP. If not present, it should use the default of its subnet.
     */
    @JsonProperty("publicIp")
    public Boolean getPublicIp() {
        return publicIp;
    }

    /**
     * publicIp specifies whether the instance should get a public IP. If not present, it should use the default of its subnet.
     */
    @JsonProperty("publicIp")
    public void setPublicIp(Boolean publicIp) {
        this.publicIp = publicIp;
    }

    /**
     * securityGroups is an array of references to security groups that should be applied to the instance.
     */
    @JsonProperty("securityGroups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AWSResourceReference> getSecurityGroups() {
        return securityGroups;
    }

    /**
     * securityGroups is an array of references to security groups that should be applied to the instance.
     */
    @JsonProperty("securityGroups")
    public void setSecurityGroups(List<AWSResourceReference> securityGroups) {
        this.securityGroups = securityGroups;
    }

    /**
     * AWSMachineProviderConfig is the Schema for the awsmachineproviderconfigs API Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("spotMarketOptions")
    public SpotMarketOptions getSpotMarketOptions() {
        return spotMarketOptions;
    }

    /**
     * AWSMachineProviderConfig is the Schema for the awsmachineproviderconfigs API Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("spotMarketOptions")
    public void setSpotMarketOptions(SpotMarketOptions spotMarketOptions) {
        this.spotMarketOptions = spotMarketOptions;
    }

    /**
     * AWSMachineProviderConfig is the Schema for the awsmachineproviderconfigs API Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("subnet")
    public AWSResourceReference getSubnet() {
        return subnet;
    }

    /**
     * AWSMachineProviderConfig is the Schema for the awsmachineproviderconfigs API Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("subnet")
    public void setSubnet(AWSResourceReference subnet) {
        this.subnet = subnet;
    }

    /**
     * tags is the set of tags to add to apply to an instance, in addition to the ones added by default by the actuator. These tags are additive. The actuator will ensure these tags are present, but will not remove any other tags that may exist on the instance.
     */
    @JsonProperty("tags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TagSpecification> getTags() {
        return tags;
    }

    /**
     * tags is the set of tags to add to apply to an instance, in addition to the ones added by default by the actuator. These tags are additive. The actuator will ensure these tags are present, but will not remove any other tags that may exist on the instance.
     */
    @JsonProperty("tags")
    public void setTags(List<TagSpecification> tags) {
        this.tags = tags;
    }

    /**
     * AWSMachineProviderConfig is the Schema for the awsmachineproviderconfigs API Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("userDataSecret")
    public LocalObjectReference getUserDataSecret() {
        return userDataSecret;
    }

    /**
     * AWSMachineProviderConfig is the Schema for the awsmachineproviderconfigs API Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("userDataSecret")
    public void setUserDataSecret(LocalObjectReference userDataSecret) {
        this.userDataSecret = userDataSecret;
    }

    @JsonIgnore
    public AWSMachineProviderConfigBuilder edit() {
        return new AWSMachineProviderConfigBuilder(this);
    }

    @JsonIgnore
    public AWSMachineProviderConfigBuilder toBuilder() {
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
        if (!(o instanceof AWSMachineProviderConfig)) {
            return false;
        }
        AWSMachineProviderConfig other = (AWSMachineProviderConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$ami = this.getAmi();
        Object other$ami = other.getAmi();
        if (this$ami == null ? other$ami != null : !this$ami.equals(other$ami)) {
            return false;
        }
        Object this$apiVersion = this.getApiVersion();
        Object other$apiVersion = other.getApiVersion();
        if (this$apiVersion == null ? other$apiVersion != null : !this$apiVersion.equals(other$apiVersion)) {
            return false;
        }
        Object this$blockDevices = this.getBlockDevices();
        Object other$blockDevices = other.getBlockDevices();
        if (this$blockDevices == null ? other$blockDevices != null : !this$blockDevices.equals(other$blockDevices)) {
            return false;
        }
        Object this$capacityReservationId = this.getCapacityReservationId();
        Object other$capacityReservationId = other.getCapacityReservationId();
        if (this$capacityReservationId == null ? other$capacityReservationId != null : !this$capacityReservationId.equals(other$capacityReservationId)) {
            return false;
        }
        Object this$credentialsSecret = this.getCredentialsSecret();
        Object other$credentialsSecret = other.getCredentialsSecret();
        if (this$credentialsSecret == null ? other$credentialsSecret != null : !this$credentialsSecret.equals(other$credentialsSecret)) {
            return false;
        }
        Object this$deviceIndex = this.getDeviceIndex();
        Object other$deviceIndex = other.getDeviceIndex();
        if (this$deviceIndex == null ? other$deviceIndex != null : !this$deviceIndex.equals(other$deviceIndex)) {
            return false;
        }
        Object this$iamInstanceProfile = this.getIamInstanceProfile();
        Object other$iamInstanceProfile = other.getIamInstanceProfile();
        if (this$iamInstanceProfile == null ? other$iamInstanceProfile != null : !this$iamInstanceProfile.equals(other$iamInstanceProfile)) {
            return false;
        }
        Object this$instanceType = this.getInstanceType();
        Object other$instanceType = other.getInstanceType();
        if (this$instanceType == null ? other$instanceType != null : !this$instanceType.equals(other$instanceType)) {
            return false;
        }
        Object this$keyName = this.getKeyName();
        Object other$keyName = other.getKeyName();
        if (this$keyName == null ? other$keyName != null : !this$keyName.equals(other$keyName)) {
            return false;
        }
        Object this$kind = this.getKind();
        Object other$kind = other.getKind();
        if (this$kind == null ? other$kind != null : !this$kind.equals(other$kind)) {
            return false;
        }
        Object this$loadBalancers = this.getLoadBalancers();
        Object other$loadBalancers = other.getLoadBalancers();
        if (this$loadBalancers == null ? other$loadBalancers != null : !this$loadBalancers.equals(other$loadBalancers)) {
            return false;
        }
        Object this$marketType = this.getMarketType();
        Object other$marketType = other.getMarketType();
        if (this$marketType == null ? other$marketType != null : !this$marketType.equals(other$marketType)) {
            return false;
        }
        Object this$metadata = this.getMetadata();
        Object other$metadata = other.getMetadata();
        if (this$metadata == null ? other$metadata != null : !this$metadata.equals(other$metadata)) {
            return false;
        }
        Object this$metadataServiceOptions = this.getMetadataServiceOptions();
        Object other$metadataServiceOptions = other.getMetadataServiceOptions();
        if (this$metadataServiceOptions == null ? other$metadataServiceOptions != null : !this$metadataServiceOptions.equals(other$metadataServiceOptions)) {
            return false;
        }
        Object this$networkInterfaceType = this.getNetworkInterfaceType();
        Object other$networkInterfaceType = other.getNetworkInterfaceType();
        if (this$networkInterfaceType == null ? other$networkInterfaceType != null : !this$networkInterfaceType.equals(other$networkInterfaceType)) {
            return false;
        }
        Object this$placement = this.getPlacement();
        Object other$placement = other.getPlacement();
        if (this$placement == null ? other$placement != null : !this$placement.equals(other$placement)) {
            return false;
        }
        Object this$placementGroupName = this.getPlacementGroupName();
        Object other$placementGroupName = other.getPlacementGroupName();
        if (this$placementGroupName == null ? other$placementGroupName != null : !this$placementGroupName.equals(other$placementGroupName)) {
            return false;
        }
        Object this$placementGroupPartition = this.getPlacementGroupPartition();
        Object other$placementGroupPartition = other.getPlacementGroupPartition();
        if (this$placementGroupPartition == null ? other$placementGroupPartition != null : !this$placementGroupPartition.equals(other$placementGroupPartition)) {
            return false;
        }
        Object this$publicIp = this.getPublicIp();
        Object other$publicIp = other.getPublicIp();
        if (this$publicIp == null ? other$publicIp != null : !this$publicIp.equals(other$publicIp)) {
            return false;
        }
        Object this$securityGroups = this.getSecurityGroups();
        Object other$securityGroups = other.getSecurityGroups();
        if (this$securityGroups == null ? other$securityGroups != null : !this$securityGroups.equals(other$securityGroups)) {
            return false;
        }
        Object this$spotMarketOptions = this.getSpotMarketOptions();
        Object other$spotMarketOptions = other.getSpotMarketOptions();
        if (this$spotMarketOptions == null ? other$spotMarketOptions != null : !this$spotMarketOptions.equals(other$spotMarketOptions)) {
            return false;
        }
        Object this$subnet = this.getSubnet();
        Object other$subnet = other.getSubnet();
        if (this$subnet == null ? other$subnet != null : !this$subnet.equals(other$subnet)) {
            return false;
        }
        Object this$tags = this.getTags();
        Object other$tags = other.getTags();
        if (this$tags == null ? other$tags != null : !this$tags.equals(other$tags)) {
            return false;
        }
        Object this$userDataSecret = this.getUserDataSecret();
        Object other$userDataSecret = other.getUserDataSecret();
        if (this$userDataSecret == null ? other$userDataSecret != null : !this$userDataSecret.equals(other$userDataSecret)) {
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
        return other instanceof AWSMachineProviderConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $ami = this.getAmi();
        result = result * prime + ($ami == null ? 43 : $ami.hashCode());
        Object $apiVersion = this.getApiVersion();
        result = result * prime + ($apiVersion == null ? 43 : $apiVersion.hashCode());
        Object $blockDevices = this.getBlockDevices();
        result = result * prime + ($blockDevices == null ? 43 : $blockDevices.hashCode());
        Object $capacityReservationId = this.getCapacityReservationId();
        result = result * prime + ($capacityReservationId == null ? 43 : $capacityReservationId.hashCode());
        Object $credentialsSecret = this.getCredentialsSecret();
        result = result * prime + ($credentialsSecret == null ? 43 : $credentialsSecret.hashCode());
        Object $deviceIndex = this.getDeviceIndex();
        result = result * prime + ($deviceIndex == null ? 43 : $deviceIndex.hashCode());
        Object $iamInstanceProfile = this.getIamInstanceProfile();
        result = result * prime + ($iamInstanceProfile == null ? 43 : $iamInstanceProfile.hashCode());
        Object $instanceType = this.getInstanceType();
        result = result * prime + ($instanceType == null ? 43 : $instanceType.hashCode());
        Object $keyName = this.getKeyName();
        result = result * prime + ($keyName == null ? 43 : $keyName.hashCode());
        Object $kind = this.getKind();
        result = result * prime + ($kind == null ? 43 : $kind.hashCode());
        Object $loadBalancers = this.getLoadBalancers();
        result = result * prime + ($loadBalancers == null ? 43 : $loadBalancers.hashCode());
        Object $marketType = this.getMarketType();
        result = result * prime + ($marketType == null ? 43 : $marketType.hashCode());
        Object $metadata = this.getMetadata();
        result = result * prime + ($metadata == null ? 43 : $metadata.hashCode());
        Object $metadataServiceOptions = this.getMetadataServiceOptions();
        result = result * prime + ($metadataServiceOptions == null ? 43 : $metadataServiceOptions.hashCode());
        Object $networkInterfaceType = this.getNetworkInterfaceType();
        result = result * prime + ($networkInterfaceType == null ? 43 : $networkInterfaceType.hashCode());
        Object $placement = this.getPlacement();
        result = result * prime + ($placement == null ? 43 : $placement.hashCode());
        Object $placementGroupName = this.getPlacementGroupName();
        result = result * prime + ($placementGroupName == null ? 43 : $placementGroupName.hashCode());
        Object $placementGroupPartition = this.getPlacementGroupPartition();
        result = result * prime + ($placementGroupPartition == null ? 43 : $placementGroupPartition.hashCode());
        Object $publicIp = this.getPublicIp();
        result = result * prime + ($publicIp == null ? 43 : $publicIp.hashCode());
        Object $securityGroups = this.getSecurityGroups();
        result = result * prime + ($securityGroups == null ? 43 : $securityGroups.hashCode());
        Object $spotMarketOptions = this.getSpotMarketOptions();
        result = result * prime + ($spotMarketOptions == null ? 43 : $spotMarketOptions.hashCode());
        Object $subnet = this.getSubnet();
        result = result * prime + ($subnet == null ? 43 : $subnet.hashCode());
        Object $tags = this.getTags();
        result = result * prime + ($tags == null ? 43 : $tags.hashCode());
        Object $userDataSecret = this.getUserDataSecret();
        result = result * prime + ($userDataSecret == null ? 43 : $userDataSecret.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AWSMachineProviderConfig(" + "ami=" + this.getAmi() + ", apiVersion=" + this.getApiVersion() + ", blockDevices=" + this.getBlockDevices() + ", capacityReservationId=" + this.getCapacityReservationId() + ", credentialsSecret=" + this.getCredentialsSecret() + ", deviceIndex=" + this.getDeviceIndex() + ", iamInstanceProfile=" + this.getIamInstanceProfile() + ", instanceType=" + this.getInstanceType() + ", keyName=" + this.getKeyName() + ", kind=" + this.getKind() + ", loadBalancers=" + this.getLoadBalancers() + ", marketType=" + this.getMarketType() + ", metadata=" + this.getMetadata() + ", metadataServiceOptions=" + this.getMetadataServiceOptions() + ", networkInterfaceType=" + this.getNetworkInterfaceType() + ", placement=" + this.getPlacement() + ", placementGroupName=" + this.getPlacementGroupName() + ", placementGroupPartition=" + this.getPlacementGroupPartition() + ", publicIp=" + this.getPublicIp() + ", securityGroups=" + this.getSecurityGroups() + ", spotMarketOptions=" + this.getSpotMarketOptions() + ", subnet=" + this.getSubnet() + ", tags=" + this.getTags() + ", userDataSecret=" + this.getUserDataSecret() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
