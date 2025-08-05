
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
import io.sundr.transform.annotations.TemplateTransformation;
import io.sundr.transform.annotations.TemplateTransformations;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
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
@TemplateTransformations({
    @TemplateTransformation(value = "/manifest.vm", outputPath = "META-INF/services/io.fabric8.kubernetes.api.model.KubernetesResource", gather = true)
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

}
