
package io.fabric8.openshift.api.model.machine.v1beta1;

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
@Version("v1beta1")
@Group("machine.openshift.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class AWSMachineProviderConfig implements Editable<AWSMachineProviderConfigBuilder>, HasMetadata, Namespaced
{

    @JsonProperty("ami")
    private AWSResourceReference ami;
    /**
     * (Required)
     */
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
    /**
     * (Required)
     */
    @JsonProperty("kind")
    private String kind = "AWSMachineProviderConfig";
    @JsonProperty("loadBalancers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<LoadBalancerReference> loadBalancers = new ArrayList<>();
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

    public AWSMachineProviderConfig(AWSResourceReference ami, String apiVersion, List<BlockDeviceMappingSpec> blockDevices, String capacityReservationId, LocalObjectReference credentialsSecret, Long deviceIndex, AWSResourceReference iamInstanceProfile, String instanceType, String keyName, String kind, List<LoadBalancerReference> loadBalancers, ObjectMeta metadata, MetadataServiceOptions metadataServiceOptions, String networkInterfaceType, Placement placement, String placementGroupName, Integer placementGroupPartition, Boolean publicIp, List<AWSResourceReference> securityGroups, SpotMarketOptions spotMarketOptions, AWSResourceReference subnet, List<TagSpecification> tags, LocalObjectReference userDataSecret) {
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

    @JsonProperty("ami")
    public AWSResourceReference getAmi() {
        return ami;
    }

    @JsonProperty("ami")
    public void setAmi(AWSResourceReference ami) {
        this.ami = ami;
    }

    /**
     * (Required)
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * (Required)
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    @JsonProperty("blockDevices")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<BlockDeviceMappingSpec> getBlockDevices() {
        return blockDevices;
    }

    @JsonProperty("blockDevices")
    public void setBlockDevices(List<BlockDeviceMappingSpec> blockDevices) {
        this.blockDevices = blockDevices;
    }

    @JsonProperty("capacityReservationId")
    public String getCapacityReservationId() {
        return capacityReservationId;
    }

    @JsonProperty("capacityReservationId")
    public void setCapacityReservationId(String capacityReservationId) {
        this.capacityReservationId = capacityReservationId;
    }

    @JsonProperty("credentialsSecret")
    public LocalObjectReference getCredentialsSecret() {
        return credentialsSecret;
    }

    @JsonProperty("credentialsSecret")
    public void setCredentialsSecret(LocalObjectReference credentialsSecret) {
        this.credentialsSecret = credentialsSecret;
    }

    @JsonProperty("deviceIndex")
    public Long getDeviceIndex() {
        return deviceIndex;
    }

    @JsonProperty("deviceIndex")
    public void setDeviceIndex(Long deviceIndex) {
        this.deviceIndex = deviceIndex;
    }

    @JsonProperty("iamInstanceProfile")
    public AWSResourceReference getIamInstanceProfile() {
        return iamInstanceProfile;
    }

    @JsonProperty("iamInstanceProfile")
    public void setIamInstanceProfile(AWSResourceReference iamInstanceProfile) {
        this.iamInstanceProfile = iamInstanceProfile;
    }

    @JsonProperty("instanceType")
    public String getInstanceType() {
        return instanceType;
    }

    @JsonProperty("instanceType")
    public void setInstanceType(String instanceType) {
        this.instanceType = instanceType;
    }

    @JsonProperty("keyName")
    public String getKeyName() {
        return keyName;
    }

    @JsonProperty("keyName")
    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    /**
     * (Required)
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * (Required)
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty("loadBalancers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<LoadBalancerReference> getLoadBalancers() {
        return loadBalancers;
    }

    @JsonProperty("loadBalancers")
    public void setLoadBalancers(List<LoadBalancerReference> loadBalancers) {
        this.loadBalancers = loadBalancers;
    }

    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    @JsonProperty("metadataServiceOptions")
    public MetadataServiceOptions getMetadataServiceOptions() {
        return metadataServiceOptions;
    }

    @JsonProperty("metadataServiceOptions")
    public void setMetadataServiceOptions(MetadataServiceOptions metadataServiceOptions) {
        this.metadataServiceOptions = metadataServiceOptions;
    }

    @JsonProperty("networkInterfaceType")
    public String getNetworkInterfaceType() {
        return networkInterfaceType;
    }

    @JsonProperty("networkInterfaceType")
    public void setNetworkInterfaceType(String networkInterfaceType) {
        this.networkInterfaceType = networkInterfaceType;
    }

    @JsonProperty("placement")
    public Placement getPlacement() {
        return placement;
    }

    @JsonProperty("placement")
    public void setPlacement(Placement placement) {
        this.placement = placement;
    }

    @JsonProperty("placementGroupName")
    public String getPlacementGroupName() {
        return placementGroupName;
    }

    @JsonProperty("placementGroupName")
    public void setPlacementGroupName(String placementGroupName) {
        this.placementGroupName = placementGroupName;
    }

    @JsonProperty("placementGroupPartition")
    public Integer getPlacementGroupPartition() {
        return placementGroupPartition;
    }

    @JsonProperty("placementGroupPartition")
    public void setPlacementGroupPartition(Integer placementGroupPartition) {
        this.placementGroupPartition = placementGroupPartition;
    }

    @JsonProperty("publicIp")
    public Boolean getPublicIp() {
        return publicIp;
    }

    @JsonProperty("publicIp")
    public void setPublicIp(Boolean publicIp) {
        this.publicIp = publicIp;
    }

    @JsonProperty("securityGroups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AWSResourceReference> getSecurityGroups() {
        return securityGroups;
    }

    @JsonProperty("securityGroups")
    public void setSecurityGroups(List<AWSResourceReference> securityGroups) {
        this.securityGroups = securityGroups;
    }

    @JsonProperty("spotMarketOptions")
    public SpotMarketOptions getSpotMarketOptions() {
        return spotMarketOptions;
    }

    @JsonProperty("spotMarketOptions")
    public void setSpotMarketOptions(SpotMarketOptions spotMarketOptions) {
        this.spotMarketOptions = spotMarketOptions;
    }

    @JsonProperty("subnet")
    public AWSResourceReference getSubnet() {
        return subnet;
    }

    @JsonProperty("subnet")
    public void setSubnet(AWSResourceReference subnet) {
        this.subnet = subnet;
    }

    @JsonProperty("tags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TagSpecification> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<TagSpecification> tags) {
        this.tags = tags;
    }

    @JsonProperty("userDataSecret")
    public LocalObjectReference getUserDataSecret() {
        return userDataSecret;
    }

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
