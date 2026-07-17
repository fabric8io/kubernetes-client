package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceFluent;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaFluent;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class AWSMachineProviderConfigFluent<A extends io.fabric8.openshift.api.model.machine.v1beta1.AWSMachineProviderConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private AWSResourceReferenceBuilder ami;
  private String apiVersion;
  private ArrayList<BlockDeviceMappingSpecBuilder> blockDevices = new ArrayList<BlockDeviceMappingSpecBuilder>();
  private String capacityReservationId;
  private LocalObjectReferenceBuilder credentialsSecret;
  private Long deviceIndex;
  private AWSResourceReferenceBuilder iamInstanceProfile;
  private String instanceType;
  private String keyName;
  private String kind;
  private ArrayList<LoadBalancerReferenceBuilder> loadBalancers = new ArrayList<LoadBalancerReferenceBuilder>();
  private String marketType;
  private ObjectMetaBuilder metadata;
  private MetadataServiceOptionsBuilder metadataServiceOptions;
  private String networkInterfaceType;
  private PlacementBuilder placement;
  private String placementGroupName;
  private Integer placementGroupPartition;
  private Boolean publicIp;
  private ArrayList<AWSResourceReferenceBuilder> securityGroups = new ArrayList<AWSResourceReferenceBuilder>();
  private SpotMarketOptionsBuilder spotMarketOptions;
  private AWSResourceReferenceBuilder subnet;
  private ArrayList<TagSpecificationBuilder> tags = new ArrayList<TagSpecificationBuilder>();
  private LocalObjectReferenceBuilder userDataSecret;

  public AWSMachineProviderConfigFluent() {
  }
  
  public AWSMachineProviderConfigFluent(AWSMachineProviderConfig instance) {
    this.copyInstance(instance);
  }

  public A addAllToBlockDevices(Collection<BlockDeviceMappingSpec> items) {
    if (this.blockDevices == null) {
      this.blockDevices = new ArrayList();
    }
    for (BlockDeviceMappingSpec item : items) {
        BlockDeviceMappingSpecBuilder builder = new BlockDeviceMappingSpecBuilder(item);
        _visitables.get("blockDevices").add(builder);
        this.blockDevices.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToLoadBalancers(Collection<LoadBalancerReference> items) {
    if (this.loadBalancers == null) {
      this.loadBalancers = new ArrayList();
    }
    for (LoadBalancerReference item : items) {
        LoadBalancerReferenceBuilder builder = new LoadBalancerReferenceBuilder(item);
        _visitables.get("loadBalancers").add(builder);
        this.loadBalancers.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToSecurityGroups(Collection<AWSResourceReference> items) {
    if (this.securityGroups == null) {
      this.securityGroups = new ArrayList();
    }
    for (AWSResourceReference item : items) {
        AWSResourceReferenceBuilder builder = new AWSResourceReferenceBuilder(item);
        _visitables.get("securityGroups").add(builder);
        this.securityGroups.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToTags(Collection<TagSpecification> items) {
    if (this.tags == null) {
      this.tags = new ArrayList();
    }
    for (TagSpecification item : items) {
        TagSpecificationBuilder builder = new TagSpecificationBuilder(item);
        _visitables.get("tags").add(builder);
        this.tags.add(builder);
    }
    return (A) this;
  }
  
  public BlockDevicesNested<A> addNewBlockDevice() {
    return new BlockDevicesNested(-1, null);
  }
  
  public BlockDevicesNested<A> addNewBlockDeviceLike(BlockDeviceMappingSpec item) {
    return new BlockDevicesNested(-1, item);
  }
  
  public LoadBalancersNested<A> addNewLoadBalancer() {
    return new LoadBalancersNested(-1, null);
  }
  
  public A addNewLoadBalancer(String name,String type) {
    return (A) this.addToLoadBalancers(new LoadBalancerReference(name, type));
  }
  
  public LoadBalancersNested<A> addNewLoadBalancerLike(LoadBalancerReference item) {
    return new LoadBalancersNested(-1, item);
  }
  
  public SecurityGroupsNested<A> addNewSecurityGroup() {
    return new SecurityGroupsNested(-1, null);
  }
  
  public SecurityGroupsNested<A> addNewSecurityGroupLike(AWSResourceReference item) {
    return new SecurityGroupsNested(-1, item);
  }
  
  public TagsNested<A> addNewTag() {
    return new TagsNested(-1, null);
  }
  
  public A addNewTag(String name,String value) {
    return (A) this.addToTags(new TagSpecification(name, value));
  }
  
  public TagsNested<A> addNewTagLike(TagSpecification item) {
    return new TagsNested(-1, item);
  }
  
  public A addToAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null && map != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (map != null) {
      this.additionalProperties.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAdditionalProperties(String key,Object value) {
    if (this.additionalProperties == null && key != null && value != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.additionalProperties.put(key, value);
    }
    return (A) this;
  }
  
  public A addToBlockDevices(BlockDeviceMappingSpec... items) {
    if (this.blockDevices == null) {
      this.blockDevices = new ArrayList();
    }
    for (BlockDeviceMappingSpec item : items) {
        BlockDeviceMappingSpecBuilder builder = new BlockDeviceMappingSpecBuilder(item);
        _visitables.get("blockDevices").add(builder);
        this.blockDevices.add(builder);
    }
    return (A) this;
  }
  
  public A addToBlockDevices(int index,BlockDeviceMappingSpec item) {
    if (this.blockDevices == null) {
      this.blockDevices = new ArrayList();
    }
    BlockDeviceMappingSpecBuilder builder = new BlockDeviceMappingSpecBuilder(item);
    if (index < 0 || index >= blockDevices.size()) {
        _visitables.get("blockDevices").add(builder);
        blockDevices.add(builder);
    } else {
        _visitables.get("blockDevices").add(builder);
        blockDevices.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToLoadBalancers(LoadBalancerReference... items) {
    if (this.loadBalancers == null) {
      this.loadBalancers = new ArrayList();
    }
    for (LoadBalancerReference item : items) {
        LoadBalancerReferenceBuilder builder = new LoadBalancerReferenceBuilder(item);
        _visitables.get("loadBalancers").add(builder);
        this.loadBalancers.add(builder);
    }
    return (A) this;
  }
  
  public A addToLoadBalancers(int index,LoadBalancerReference item) {
    if (this.loadBalancers == null) {
      this.loadBalancers = new ArrayList();
    }
    LoadBalancerReferenceBuilder builder = new LoadBalancerReferenceBuilder(item);
    if (index < 0 || index >= loadBalancers.size()) {
        _visitables.get("loadBalancers").add(builder);
        loadBalancers.add(builder);
    } else {
        _visitables.get("loadBalancers").add(builder);
        loadBalancers.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToSecurityGroups(AWSResourceReference... items) {
    if (this.securityGroups == null) {
      this.securityGroups = new ArrayList();
    }
    for (AWSResourceReference item : items) {
        AWSResourceReferenceBuilder builder = new AWSResourceReferenceBuilder(item);
        _visitables.get("securityGroups").add(builder);
        this.securityGroups.add(builder);
    }
    return (A) this;
  }
  
  public A addToSecurityGroups(int index,AWSResourceReference item) {
    if (this.securityGroups == null) {
      this.securityGroups = new ArrayList();
    }
    AWSResourceReferenceBuilder builder = new AWSResourceReferenceBuilder(item);
    if (index < 0 || index >= securityGroups.size()) {
        _visitables.get("securityGroups").add(builder);
        securityGroups.add(builder);
    } else {
        _visitables.get("securityGroups").add(builder);
        securityGroups.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToTags(TagSpecification... items) {
    if (this.tags == null) {
      this.tags = new ArrayList();
    }
    for (TagSpecification item : items) {
        TagSpecificationBuilder builder = new TagSpecificationBuilder(item);
        _visitables.get("tags").add(builder);
        this.tags.add(builder);
    }
    return (A) this;
  }
  
  public A addToTags(int index,TagSpecification item) {
    if (this.tags == null) {
      this.tags = new ArrayList();
    }
    TagSpecificationBuilder builder = new TagSpecificationBuilder(item);
    if (index < 0 || index >= tags.size()) {
        _visitables.get("tags").add(builder);
        tags.add(builder);
    } else {
        _visitables.get("tags").add(builder);
        tags.add(index, builder);
    }
    return (A) this;
  }
  
  public AWSResourceReference buildAmi() {
    return this.ami != null ? this.ami.build() : null;
  }
  
  public BlockDeviceMappingSpec buildBlockDevice(int index) {
    return this.blockDevices.get(index).build();
  }
  
  public List<BlockDeviceMappingSpec> buildBlockDevices() {
    return this.blockDevices != null ? build(blockDevices) : null;
  }
  
  public LocalObjectReference buildCredentialsSecret() {
    return this.credentialsSecret != null ? this.credentialsSecret.build() : null;
  }
  
  public BlockDeviceMappingSpec buildFirstBlockDevice() {
    return this.blockDevices.get(0).build();
  }
  
  public LoadBalancerReference buildFirstLoadBalancer() {
    return this.loadBalancers.get(0).build();
  }
  
  public AWSResourceReference buildFirstSecurityGroup() {
    return this.securityGroups.get(0).build();
  }
  
  public TagSpecification buildFirstTag() {
    return this.tags.get(0).build();
  }
  
  public AWSResourceReference buildIamInstanceProfile() {
    return this.iamInstanceProfile != null ? this.iamInstanceProfile.build() : null;
  }
  
  public BlockDeviceMappingSpec buildLastBlockDevice() {
    return this.blockDevices.get(blockDevices.size() - 1).build();
  }
  
  public LoadBalancerReference buildLastLoadBalancer() {
    return this.loadBalancers.get(loadBalancers.size() - 1).build();
  }
  
  public AWSResourceReference buildLastSecurityGroup() {
    return this.securityGroups.get(securityGroups.size() - 1).build();
  }
  
  public TagSpecification buildLastTag() {
    return this.tags.get(tags.size() - 1).build();
  }
  
  public LoadBalancerReference buildLoadBalancer(int index) {
    return this.loadBalancers.get(index).build();
  }
  
  public List<LoadBalancerReference> buildLoadBalancers() {
    return this.loadBalancers != null ? build(loadBalancers) : null;
  }
  
  public BlockDeviceMappingSpec buildMatchingBlockDevice(Predicate<BlockDeviceMappingSpecBuilder> predicate) {
      for (BlockDeviceMappingSpecBuilder item : blockDevices) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public LoadBalancerReference buildMatchingLoadBalancer(Predicate<LoadBalancerReferenceBuilder> predicate) {
      for (LoadBalancerReferenceBuilder item : loadBalancers) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public AWSResourceReference buildMatchingSecurityGroup(Predicate<AWSResourceReferenceBuilder> predicate) {
      for (AWSResourceReferenceBuilder item : securityGroups) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public TagSpecification buildMatchingTag(Predicate<TagSpecificationBuilder> predicate) {
      for (TagSpecificationBuilder item : tags) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ObjectMeta buildMetadata() {
    return this.metadata != null ? this.metadata.build() : null;
  }
  
  public MetadataServiceOptions buildMetadataServiceOptions() {
    return this.metadataServiceOptions != null ? this.metadataServiceOptions.build() : null;
  }
  
  public Placement buildPlacement() {
    return this.placement != null ? this.placement.build() : null;
  }
  
  public AWSResourceReference buildSecurityGroup(int index) {
    return this.securityGroups.get(index).build();
  }
  
  public List<AWSResourceReference> buildSecurityGroups() {
    return this.securityGroups != null ? build(securityGroups) : null;
  }
  
  public SpotMarketOptions buildSpotMarketOptions() {
    return this.spotMarketOptions != null ? this.spotMarketOptions.build() : null;
  }
  
  public AWSResourceReference buildSubnet() {
    return this.subnet != null ? this.subnet.build() : null;
  }
  
  public TagSpecification buildTag(int index) {
    return this.tags.get(index).build();
  }
  
  public List<TagSpecification> buildTags() {
    return this.tags != null ? build(tags) : null;
  }
  
  public LocalObjectReference buildUserDataSecret() {
    return this.userDataSecret != null ? this.userDataSecret.build() : null;
  }
  
  protected void copyInstance(AWSMachineProviderConfig instance) {
    instance = instance != null ? instance : new AWSMachineProviderConfig();
    if (instance != null) {
        this.withAmi(instance.getAmi());
        this.withApiVersion(instance.getApiVersion());
        this.withBlockDevices(instance.getBlockDevices());
        this.withCapacityReservationId(instance.getCapacityReservationId());
        this.withCredentialsSecret(instance.getCredentialsSecret());
        this.withDeviceIndex(instance.getDeviceIndex());
        this.withIamInstanceProfile(instance.getIamInstanceProfile());
        this.withInstanceType(instance.getInstanceType());
        this.withKeyName(instance.getKeyName());
        this.withKind(instance.getKind());
        this.withLoadBalancers(instance.getLoadBalancers());
        this.withMarketType(instance.getMarketType());
        this.withMetadata(instance.getMetadata());
        this.withMetadataServiceOptions(instance.getMetadataServiceOptions());
        this.withNetworkInterfaceType(instance.getNetworkInterfaceType());
        this.withPlacement(instance.getPlacement());
        this.withPlacementGroupName(instance.getPlacementGroupName());
        this.withPlacementGroupPartition(instance.getPlacementGroupPartition());
        this.withPublicIp(instance.getPublicIp());
        this.withSecurityGroups(instance.getSecurityGroups());
        this.withSpotMarketOptions(instance.getSpotMarketOptions());
        this.withSubnet(instance.getSubnet());
        this.withTags(instance.getTags());
        this.withUserDataSecret(instance.getUserDataSecret());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AmiNested<A> editAmi() {
    return this.withNewAmiLike(Optional.ofNullable(this.buildAmi()).orElse(null));
  }
  
  public BlockDevicesNested<A> editBlockDevice(int index) {
    if (blockDevices.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "blockDevices"));
    }
    return this.setNewBlockDeviceLike(index, this.buildBlockDevice(index));
  }
  
  public CredentialsSecretNested<A> editCredentialsSecret() {
    return this.withNewCredentialsSecretLike(Optional.ofNullable(this.buildCredentialsSecret()).orElse(null));
  }
  
  public BlockDevicesNested<A> editFirstBlockDevice() {
    if (blockDevices.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "blockDevices"));
    }
    return this.setNewBlockDeviceLike(0, this.buildBlockDevice(0));
  }
  
  public LoadBalancersNested<A> editFirstLoadBalancer() {
    if (loadBalancers.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "loadBalancers"));
    }
    return this.setNewLoadBalancerLike(0, this.buildLoadBalancer(0));
  }
  
  public SecurityGroupsNested<A> editFirstSecurityGroup() {
    if (securityGroups.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "securityGroups"));
    }
    return this.setNewSecurityGroupLike(0, this.buildSecurityGroup(0));
  }
  
  public TagsNested<A> editFirstTag() {
    if (tags.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "tags"));
    }
    return this.setNewTagLike(0, this.buildTag(0));
  }
  
  public IamInstanceProfileNested<A> editIamInstanceProfile() {
    return this.withNewIamInstanceProfileLike(Optional.ofNullable(this.buildIamInstanceProfile()).orElse(null));
  }
  
  public BlockDevicesNested<A> editLastBlockDevice() {
    int index = blockDevices.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "blockDevices"));
    }
    return this.setNewBlockDeviceLike(index, this.buildBlockDevice(index));
  }
  
  public LoadBalancersNested<A> editLastLoadBalancer() {
    int index = loadBalancers.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "loadBalancers"));
    }
    return this.setNewLoadBalancerLike(index, this.buildLoadBalancer(index));
  }
  
  public SecurityGroupsNested<A> editLastSecurityGroup() {
    int index = securityGroups.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "securityGroups"));
    }
    return this.setNewSecurityGroupLike(index, this.buildSecurityGroup(index));
  }
  
  public TagsNested<A> editLastTag() {
    int index = tags.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "tags"));
    }
    return this.setNewTagLike(index, this.buildTag(index));
  }
  
  public LoadBalancersNested<A> editLoadBalancer(int index) {
    if (loadBalancers.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "loadBalancers"));
    }
    return this.setNewLoadBalancerLike(index, this.buildLoadBalancer(index));
  }
  
  public BlockDevicesNested<A> editMatchingBlockDevice(Predicate<BlockDeviceMappingSpecBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < blockDevices.size();i++) {
      if (predicate.test(blockDevices.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "blockDevices"));
    }
    return this.setNewBlockDeviceLike(index, this.buildBlockDevice(index));
  }
  
  public LoadBalancersNested<A> editMatchingLoadBalancer(Predicate<LoadBalancerReferenceBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < loadBalancers.size();i++) {
      if (predicate.test(loadBalancers.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "loadBalancers"));
    }
    return this.setNewLoadBalancerLike(index, this.buildLoadBalancer(index));
  }
  
  public SecurityGroupsNested<A> editMatchingSecurityGroup(Predicate<AWSResourceReferenceBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < securityGroups.size();i++) {
      if (predicate.test(securityGroups.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "securityGroups"));
    }
    return this.setNewSecurityGroupLike(index, this.buildSecurityGroup(index));
  }
  
  public TagsNested<A> editMatchingTag(Predicate<TagSpecificationBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < tags.size();i++) {
      if (predicate.test(tags.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "tags"));
    }
    return this.setNewTagLike(index, this.buildTag(index));
  }
  
  public MetadataNested<A> editMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(null));
  }
  
  public MetadataServiceOptionsNested<A> editMetadataServiceOptions() {
    return this.withNewMetadataServiceOptionsLike(Optional.ofNullable(this.buildMetadataServiceOptions()).orElse(null));
  }
  
  public AmiNested<A> editOrNewAmi() {
    return this.withNewAmiLike(Optional.ofNullable(this.buildAmi()).orElse(new AWSResourceReferenceBuilder().build()));
  }
  
  public AmiNested<A> editOrNewAmiLike(AWSResourceReference item) {
    return this.withNewAmiLike(Optional.ofNullable(this.buildAmi()).orElse(item));
  }
  
  public CredentialsSecretNested<A> editOrNewCredentialsSecret() {
    return this.withNewCredentialsSecretLike(Optional.ofNullable(this.buildCredentialsSecret()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public CredentialsSecretNested<A> editOrNewCredentialsSecretLike(LocalObjectReference item) {
    return this.withNewCredentialsSecretLike(Optional.ofNullable(this.buildCredentialsSecret()).orElse(item));
  }
  
  public IamInstanceProfileNested<A> editOrNewIamInstanceProfile() {
    return this.withNewIamInstanceProfileLike(Optional.ofNullable(this.buildIamInstanceProfile()).orElse(new AWSResourceReferenceBuilder().build()));
  }
  
  public IamInstanceProfileNested<A> editOrNewIamInstanceProfileLike(AWSResourceReference item) {
    return this.withNewIamInstanceProfileLike(Optional.ofNullable(this.buildIamInstanceProfile()).orElse(item));
  }
  
  public MetadataNested<A> editOrNewMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(new ObjectMetaBuilder().build()));
  }
  
  public MetadataNested<A> editOrNewMetadataLike(ObjectMeta item) {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(item));
  }
  
  public MetadataServiceOptionsNested<A> editOrNewMetadataServiceOptions() {
    return this.withNewMetadataServiceOptionsLike(Optional.ofNullable(this.buildMetadataServiceOptions()).orElse(new MetadataServiceOptionsBuilder().build()));
  }
  
  public MetadataServiceOptionsNested<A> editOrNewMetadataServiceOptionsLike(MetadataServiceOptions item) {
    return this.withNewMetadataServiceOptionsLike(Optional.ofNullable(this.buildMetadataServiceOptions()).orElse(item));
  }
  
  public PlacementNested<A> editOrNewPlacement() {
    return this.withNewPlacementLike(Optional.ofNullable(this.buildPlacement()).orElse(new PlacementBuilder().build()));
  }
  
  public PlacementNested<A> editOrNewPlacementLike(Placement item) {
    return this.withNewPlacementLike(Optional.ofNullable(this.buildPlacement()).orElse(item));
  }
  
  public SpotMarketOptionsNested<A> editOrNewSpotMarketOptions() {
    return this.withNewSpotMarketOptionsLike(Optional.ofNullable(this.buildSpotMarketOptions()).orElse(new SpotMarketOptionsBuilder().build()));
  }
  
  public SpotMarketOptionsNested<A> editOrNewSpotMarketOptionsLike(SpotMarketOptions item) {
    return this.withNewSpotMarketOptionsLike(Optional.ofNullable(this.buildSpotMarketOptions()).orElse(item));
  }
  
  public SubnetNested<A> editOrNewSubnet() {
    return this.withNewSubnetLike(Optional.ofNullable(this.buildSubnet()).orElse(new AWSResourceReferenceBuilder().build()));
  }
  
  public SubnetNested<A> editOrNewSubnetLike(AWSResourceReference item) {
    return this.withNewSubnetLike(Optional.ofNullable(this.buildSubnet()).orElse(item));
  }
  
  public UserDataSecretNested<A> editOrNewUserDataSecret() {
    return this.withNewUserDataSecretLike(Optional.ofNullable(this.buildUserDataSecret()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public UserDataSecretNested<A> editOrNewUserDataSecretLike(LocalObjectReference item) {
    return this.withNewUserDataSecretLike(Optional.ofNullable(this.buildUserDataSecret()).orElse(item));
  }
  
  public PlacementNested<A> editPlacement() {
    return this.withNewPlacementLike(Optional.ofNullable(this.buildPlacement()).orElse(null));
  }
  
  public SecurityGroupsNested<A> editSecurityGroup(int index) {
    if (securityGroups.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "securityGroups"));
    }
    return this.setNewSecurityGroupLike(index, this.buildSecurityGroup(index));
  }
  
  public SpotMarketOptionsNested<A> editSpotMarketOptions() {
    return this.withNewSpotMarketOptionsLike(Optional.ofNullable(this.buildSpotMarketOptions()).orElse(null));
  }
  
  public SubnetNested<A> editSubnet() {
    return this.withNewSubnetLike(Optional.ofNullable(this.buildSubnet()).orElse(null));
  }
  
  public TagsNested<A> editTag(int index) {
    if (tags.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "tags"));
    }
    return this.setNewTagLike(index, this.buildTag(index));
  }
  
  public UserDataSecretNested<A> editUserDataSecret() {
    return this.withNewUserDataSecretLike(Optional.ofNullable(this.buildUserDataSecret()).orElse(null));
  }
  
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    if (!(super.equals(o))) {
      return false;
    }
    AWSMachineProviderConfigFluent that = (AWSMachineProviderConfigFluent) o;
    if (!(Objects.equals(ami, that.ami))) {
      return false;
    }
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(blockDevices, that.blockDevices))) {
      return false;
    }
    if (!(Objects.equals(capacityReservationId, that.capacityReservationId))) {
      return false;
    }
    if (!(Objects.equals(credentialsSecret, that.credentialsSecret))) {
      return false;
    }
    if (!(Objects.equals(deviceIndex, that.deviceIndex))) {
      return false;
    }
    if (!(Objects.equals(iamInstanceProfile, that.iamInstanceProfile))) {
      return false;
    }
    if (!(Objects.equals(instanceType, that.instanceType))) {
      return false;
    }
    if (!(Objects.equals(keyName, that.keyName))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(loadBalancers, that.loadBalancers))) {
      return false;
    }
    if (!(Objects.equals(marketType, that.marketType))) {
      return false;
    }
    if (!(Objects.equals(metadata, that.metadata))) {
      return false;
    }
    if (!(Objects.equals(metadataServiceOptions, that.metadataServiceOptions))) {
      return false;
    }
    if (!(Objects.equals(networkInterfaceType, that.networkInterfaceType))) {
      return false;
    }
    if (!(Objects.equals(placement, that.placement))) {
      return false;
    }
    if (!(Objects.equals(placementGroupName, that.placementGroupName))) {
      return false;
    }
    if (!(Objects.equals(placementGroupPartition, that.placementGroupPartition))) {
      return false;
    }
    if (!(Objects.equals(publicIp, that.publicIp))) {
      return false;
    }
    if (!(Objects.equals(securityGroups, that.securityGroups))) {
      return false;
    }
    if (!(Objects.equals(spotMarketOptions, that.spotMarketOptions))) {
      return false;
    }
    if (!(Objects.equals(subnet, that.subnet))) {
      return false;
    }
    if (!(Objects.equals(tags, that.tags))) {
      return false;
    }
    if (!(Objects.equals(userDataSecret, that.userDataSecret))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getApiVersion() {
    return this.apiVersion;
  }
  
  public String getCapacityReservationId() {
    return this.capacityReservationId;
  }
  
  public Long getDeviceIndex() {
    return this.deviceIndex;
  }
  
  public String getInstanceType() {
    return this.instanceType;
  }
  
  public String getKeyName() {
    return this.keyName;
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public String getMarketType() {
    return this.marketType;
  }
  
  public String getNetworkInterfaceType() {
    return this.networkInterfaceType;
  }
  
  public String getPlacementGroupName() {
    return this.placementGroupName;
  }
  
  public Integer getPlacementGroupPartition() {
    return this.placementGroupPartition;
  }
  
  public Boolean getPublicIp() {
    return this.publicIp;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAmi() {
    return this.ami != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasBlockDevices() {
    return this.blockDevices != null && !(this.blockDevices.isEmpty());
  }
  
  public boolean hasCapacityReservationId() {
    return this.capacityReservationId != null;
  }
  
  public boolean hasCredentialsSecret() {
    return this.credentialsSecret != null;
  }
  
  public boolean hasDeviceIndex() {
    return this.deviceIndex != null;
  }
  
  public boolean hasIamInstanceProfile() {
    return this.iamInstanceProfile != null;
  }
  
  public boolean hasInstanceType() {
    return this.instanceType != null;
  }
  
  public boolean hasKeyName() {
    return this.keyName != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasLoadBalancers() {
    return this.loadBalancers != null && !(this.loadBalancers.isEmpty());
  }
  
  public boolean hasMarketType() {
    return this.marketType != null;
  }
  
  public boolean hasMatchingBlockDevice(Predicate<BlockDeviceMappingSpecBuilder> predicate) {
      for (BlockDeviceMappingSpecBuilder item : blockDevices) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingLoadBalancer(Predicate<LoadBalancerReferenceBuilder> predicate) {
      for (LoadBalancerReferenceBuilder item : loadBalancers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingSecurityGroup(Predicate<AWSResourceReferenceBuilder> predicate) {
      for (AWSResourceReferenceBuilder item : securityGroups) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingTag(Predicate<TagSpecificationBuilder> predicate) {
      for (TagSpecificationBuilder item : tags) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMetadata() {
    return this.metadata != null;
  }
  
  public boolean hasMetadataServiceOptions() {
    return this.metadataServiceOptions != null;
  }
  
  public boolean hasNetworkInterfaceType() {
    return this.networkInterfaceType != null;
  }
  
  public boolean hasPlacement() {
    return this.placement != null;
  }
  
  public boolean hasPlacementGroupName() {
    return this.placementGroupName != null;
  }
  
  public boolean hasPlacementGroupPartition() {
    return this.placementGroupPartition != null;
  }
  
  public boolean hasPublicIp() {
    return this.publicIp != null;
  }
  
  public boolean hasSecurityGroups() {
    return this.securityGroups != null && !(this.securityGroups.isEmpty());
  }
  
  public boolean hasSpotMarketOptions() {
    return this.spotMarketOptions != null;
  }
  
  public boolean hasSubnet() {
    return this.subnet != null;
  }
  
  public boolean hasTags() {
    return this.tags != null && !(this.tags.isEmpty());
  }
  
  public boolean hasUserDataSecret() {
    return this.userDataSecret != null;
  }
  
  public int hashCode() {
    return Objects.hash(ami, apiVersion, blockDevices, capacityReservationId, credentialsSecret, deviceIndex, iamInstanceProfile, instanceType, keyName, kind, loadBalancers, marketType, metadata, metadataServiceOptions, networkInterfaceType, placement, placementGroupName, placementGroupPartition, publicIp, securityGroups, spotMarketOptions, subnet, tags, userDataSecret, additionalProperties);
  }
  
  public A removeAllFromBlockDevices(Collection<BlockDeviceMappingSpec> items) {
    if (this.blockDevices == null) {
      return (A) this;
    }
    for (BlockDeviceMappingSpec item : items) {
        BlockDeviceMappingSpecBuilder builder = new BlockDeviceMappingSpecBuilder(item);
        _visitables.get("blockDevices").remove(builder);
        this.blockDevices.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromLoadBalancers(Collection<LoadBalancerReference> items) {
    if (this.loadBalancers == null) {
      return (A) this;
    }
    for (LoadBalancerReference item : items) {
        LoadBalancerReferenceBuilder builder = new LoadBalancerReferenceBuilder(item);
        _visitables.get("loadBalancers").remove(builder);
        this.loadBalancers.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromSecurityGroups(Collection<AWSResourceReference> items) {
    if (this.securityGroups == null) {
      return (A) this;
    }
    for (AWSResourceReference item : items) {
        AWSResourceReferenceBuilder builder = new AWSResourceReferenceBuilder(item);
        _visitables.get("securityGroups").remove(builder);
        this.securityGroups.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromTags(Collection<TagSpecification> items) {
    if (this.tags == null) {
      return (A) this;
    }
    for (TagSpecification item : items) {
        TagSpecificationBuilder builder = new TagSpecificationBuilder(item);
        _visitables.get("tags").remove(builder);
        this.tags.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(String key) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (key != null && this.additionalProperties != null) {
      this.additionalProperties.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.additionalProperties != null) {
          this.additionalProperties.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromBlockDevices(BlockDeviceMappingSpec... items) {
    if (this.blockDevices == null) {
      return (A) this;
    }
    for (BlockDeviceMappingSpec item : items) {
        BlockDeviceMappingSpecBuilder builder = new BlockDeviceMappingSpecBuilder(item);
        _visitables.get("blockDevices").remove(builder);
        this.blockDevices.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromLoadBalancers(LoadBalancerReference... items) {
    if (this.loadBalancers == null) {
      return (A) this;
    }
    for (LoadBalancerReference item : items) {
        LoadBalancerReferenceBuilder builder = new LoadBalancerReferenceBuilder(item);
        _visitables.get("loadBalancers").remove(builder);
        this.loadBalancers.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromSecurityGroups(AWSResourceReference... items) {
    if (this.securityGroups == null) {
      return (A) this;
    }
    for (AWSResourceReference item : items) {
        AWSResourceReferenceBuilder builder = new AWSResourceReferenceBuilder(item);
        _visitables.get("securityGroups").remove(builder);
        this.securityGroups.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromTags(TagSpecification... items) {
    if (this.tags == null) {
      return (A) this;
    }
    for (TagSpecification item : items) {
        TagSpecificationBuilder builder = new TagSpecificationBuilder(item);
        _visitables.get("tags").remove(builder);
        this.tags.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromBlockDevices(Predicate<BlockDeviceMappingSpecBuilder> predicate) {
    if (blockDevices == null) {
      return (A) this;
    }
    Iterator<BlockDeviceMappingSpecBuilder> each = blockDevices.iterator();
    List visitables = _visitables.get("blockDevices");
    while (each.hasNext()) {
        BlockDeviceMappingSpecBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromLoadBalancers(Predicate<LoadBalancerReferenceBuilder> predicate) {
    if (loadBalancers == null) {
      return (A) this;
    }
    Iterator<LoadBalancerReferenceBuilder> each = loadBalancers.iterator();
    List visitables = _visitables.get("loadBalancers");
    while (each.hasNext()) {
        LoadBalancerReferenceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromSecurityGroups(Predicate<AWSResourceReferenceBuilder> predicate) {
    if (securityGroups == null) {
      return (A) this;
    }
    Iterator<AWSResourceReferenceBuilder> each = securityGroups.iterator();
    List visitables = _visitables.get("securityGroups");
    while (each.hasNext()) {
        AWSResourceReferenceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromTags(Predicate<TagSpecificationBuilder> predicate) {
    if (tags == null) {
      return (A) this;
    }
    Iterator<TagSpecificationBuilder> each = tags.iterator();
    List visitables = _visitables.get("tags");
    while (each.hasNext()) {
        TagSpecificationBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public BlockDevicesNested<A> setNewBlockDeviceLike(int index,BlockDeviceMappingSpec item) {
    return new BlockDevicesNested(index, item);
  }
  
  public LoadBalancersNested<A> setNewLoadBalancerLike(int index,LoadBalancerReference item) {
    return new LoadBalancersNested(index, item);
  }
  
  public SecurityGroupsNested<A> setNewSecurityGroupLike(int index,AWSResourceReference item) {
    return new SecurityGroupsNested(index, item);
  }
  
  public TagsNested<A> setNewTagLike(int index,TagSpecification item) {
    return new TagsNested(index, item);
  }
  
  public A setToBlockDevices(int index,BlockDeviceMappingSpec item) {
    if (this.blockDevices == null) {
      this.blockDevices = new ArrayList();
    }
    BlockDeviceMappingSpecBuilder builder = new BlockDeviceMappingSpecBuilder(item);
    if (index < 0 || index >= blockDevices.size()) {
        _visitables.get("blockDevices").add(builder);
        blockDevices.add(builder);
    } else {
        _visitables.get("blockDevices").add(builder);
        blockDevices.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToLoadBalancers(int index,LoadBalancerReference item) {
    if (this.loadBalancers == null) {
      this.loadBalancers = new ArrayList();
    }
    LoadBalancerReferenceBuilder builder = new LoadBalancerReferenceBuilder(item);
    if (index < 0 || index >= loadBalancers.size()) {
        _visitables.get("loadBalancers").add(builder);
        loadBalancers.add(builder);
    } else {
        _visitables.get("loadBalancers").add(builder);
        loadBalancers.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToSecurityGroups(int index,AWSResourceReference item) {
    if (this.securityGroups == null) {
      this.securityGroups = new ArrayList();
    }
    AWSResourceReferenceBuilder builder = new AWSResourceReferenceBuilder(item);
    if (index < 0 || index >= securityGroups.size()) {
        _visitables.get("securityGroups").add(builder);
        securityGroups.add(builder);
    } else {
        _visitables.get("securityGroups").add(builder);
        securityGroups.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToTags(int index,TagSpecification item) {
    if (this.tags == null) {
      this.tags = new ArrayList();
    }
    TagSpecificationBuilder builder = new TagSpecificationBuilder(item);
    if (index < 0 || index >= tags.size()) {
        _visitables.get("tags").add(builder);
        tags.add(builder);
    } else {
        _visitables.get("tags").add(builder);
        tags.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(ami == null)) {
        sb.append("ami:");
        sb.append(ami);
        sb.append(",");
    }
    if (!(apiVersion == null)) {
        sb.append("apiVersion:");
        sb.append(apiVersion);
        sb.append(",");
    }
    if (!(blockDevices == null) && !(blockDevices.isEmpty())) {
        sb.append("blockDevices:");
        sb.append(blockDevices);
        sb.append(",");
    }
    if (!(capacityReservationId == null)) {
        sb.append("capacityReservationId:");
        sb.append(capacityReservationId);
        sb.append(",");
    }
    if (!(credentialsSecret == null)) {
        sb.append("credentialsSecret:");
        sb.append(credentialsSecret);
        sb.append(",");
    }
    if (!(deviceIndex == null)) {
        sb.append("deviceIndex:");
        sb.append(deviceIndex);
        sb.append(",");
    }
    if (!(iamInstanceProfile == null)) {
        sb.append("iamInstanceProfile:");
        sb.append(iamInstanceProfile);
        sb.append(",");
    }
    if (!(instanceType == null)) {
        sb.append("instanceType:");
        sb.append(instanceType);
        sb.append(",");
    }
    if (!(keyName == null)) {
        sb.append("keyName:");
        sb.append(keyName);
        sb.append(",");
    }
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
        sb.append(",");
    }
    if (!(loadBalancers == null) && !(loadBalancers.isEmpty())) {
        sb.append("loadBalancers:");
        sb.append(loadBalancers);
        sb.append(",");
    }
    if (!(marketType == null)) {
        sb.append("marketType:");
        sb.append(marketType);
        sb.append(",");
    }
    if (!(metadata == null)) {
        sb.append("metadata:");
        sb.append(metadata);
        sb.append(",");
    }
    if (!(metadataServiceOptions == null)) {
        sb.append("metadataServiceOptions:");
        sb.append(metadataServiceOptions);
        sb.append(",");
    }
    if (!(networkInterfaceType == null)) {
        sb.append("networkInterfaceType:");
        sb.append(networkInterfaceType);
        sb.append(",");
    }
    if (!(placement == null)) {
        sb.append("placement:");
        sb.append(placement);
        sb.append(",");
    }
    if (!(placementGroupName == null)) {
        sb.append("placementGroupName:");
        sb.append(placementGroupName);
        sb.append(",");
    }
    if (!(placementGroupPartition == null)) {
        sb.append("placementGroupPartition:");
        sb.append(placementGroupPartition);
        sb.append(",");
    }
    if (!(publicIp == null)) {
        sb.append("publicIp:");
        sb.append(publicIp);
        sb.append(",");
    }
    if (!(securityGroups == null) && !(securityGroups.isEmpty())) {
        sb.append("securityGroups:");
        sb.append(securityGroups);
        sb.append(",");
    }
    if (!(spotMarketOptions == null)) {
        sb.append("spotMarketOptions:");
        sb.append(spotMarketOptions);
        sb.append(",");
    }
    if (!(subnet == null)) {
        sb.append("subnet:");
        sb.append(subnet);
        sb.append(",");
    }
    if (!(tags == null) && !(tags.isEmpty())) {
        sb.append("tags:");
        sb.append(tags);
        sb.append(",");
    }
    if (!(userDataSecret == null)) {
        sb.append("userDataSecret:");
        sb.append(userDataSecret);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withAmi(AWSResourceReference ami) {
    this._visitables.remove("ami");
    if (ami != null) {
        this.ami = new AWSResourceReferenceBuilder(ami);
        this._visitables.get("ami").add(this.ami);
    } else {
        this.ami = null;
        this._visitables.get("ami").remove(this.ami);
    }
    return (A) this;
  }
  
  public A withApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
    return (A) this;
  }
  
  public A withBlockDevices(List<BlockDeviceMappingSpec> blockDevices) {
    if (this.blockDevices != null) {
      this._visitables.get("blockDevices").clear();
    }
    if (blockDevices != null) {
        this.blockDevices = new ArrayList();
        for (BlockDeviceMappingSpec item : blockDevices) {
          this.addToBlockDevices(item);
        }
    } else {
      this.blockDevices = null;
    }
    return (A) this;
  }
  
  public A withBlockDevices(BlockDeviceMappingSpec... blockDevices) {
    if (this.blockDevices != null) {
        this.blockDevices.clear();
        _visitables.remove("blockDevices");
    }
    if (blockDevices != null) {
      for (BlockDeviceMappingSpec item : blockDevices) {
        this.addToBlockDevices(item);
      }
    }
    return (A) this;
  }
  
  public A withCapacityReservationId(String capacityReservationId) {
    this.capacityReservationId = capacityReservationId;
    return (A) this;
  }
  
  public A withCredentialsSecret(LocalObjectReference credentialsSecret) {
    this._visitables.remove("credentialsSecret");
    if (credentialsSecret != null) {
        this.credentialsSecret = new LocalObjectReferenceBuilder(credentialsSecret);
        this._visitables.get("credentialsSecret").add(this.credentialsSecret);
    } else {
        this.credentialsSecret = null;
        this._visitables.get("credentialsSecret").remove(this.credentialsSecret);
    }
    return (A) this;
  }
  
  public A withDeviceIndex(Long deviceIndex) {
    this.deviceIndex = deviceIndex;
    return (A) this;
  }
  
  public A withIamInstanceProfile(AWSResourceReference iamInstanceProfile) {
    this._visitables.remove("iamInstanceProfile");
    if (iamInstanceProfile != null) {
        this.iamInstanceProfile = new AWSResourceReferenceBuilder(iamInstanceProfile);
        this._visitables.get("iamInstanceProfile").add(this.iamInstanceProfile);
    } else {
        this.iamInstanceProfile = null;
        this._visitables.get("iamInstanceProfile").remove(this.iamInstanceProfile);
    }
    return (A) this;
  }
  
  public A withInstanceType(String instanceType) {
    this.instanceType = instanceType;
    return (A) this;
  }
  
  public A withKeyName(String keyName) {
    this.keyName = keyName;
    return (A) this;
  }
  
  public A withKind(String kind) {
    this.kind = kind;
    return (A) this;
  }
  
  public A withLoadBalancers(List<LoadBalancerReference> loadBalancers) {
    if (this.loadBalancers != null) {
      this._visitables.get("loadBalancers").clear();
    }
    if (loadBalancers != null) {
        this.loadBalancers = new ArrayList();
        for (LoadBalancerReference item : loadBalancers) {
          this.addToLoadBalancers(item);
        }
    } else {
      this.loadBalancers = null;
    }
    return (A) this;
  }
  
  public A withLoadBalancers(LoadBalancerReference... loadBalancers) {
    if (this.loadBalancers != null) {
        this.loadBalancers.clear();
        _visitables.remove("loadBalancers");
    }
    if (loadBalancers != null) {
      for (LoadBalancerReference item : loadBalancers) {
        this.addToLoadBalancers(item);
      }
    }
    return (A) this;
  }
  
  public A withMarketType(String marketType) {
    this.marketType = marketType;
    return (A) this;
  }
  
  public A withMetadata(ObjectMeta metadata) {
    this._visitables.remove("metadata");
    if (metadata != null) {
        this.metadata = new ObjectMetaBuilder(metadata);
        this._visitables.get("metadata").add(this.metadata);
    } else {
        this.metadata = null;
        this._visitables.get("metadata").remove(this.metadata);
    }
    return (A) this;
  }
  
  public A withMetadataServiceOptions(MetadataServiceOptions metadataServiceOptions) {
    this._visitables.remove("metadataServiceOptions");
    if (metadataServiceOptions != null) {
        this.metadataServiceOptions = new MetadataServiceOptionsBuilder(metadataServiceOptions);
        this._visitables.get("metadataServiceOptions").add(this.metadataServiceOptions);
    } else {
        this.metadataServiceOptions = null;
        this._visitables.get("metadataServiceOptions").remove(this.metadataServiceOptions);
    }
    return (A) this;
  }
  
  public A withNetworkInterfaceType(String networkInterfaceType) {
    this.networkInterfaceType = networkInterfaceType;
    return (A) this;
  }
  
  public AmiNested<A> withNewAmi() {
    return new AmiNested(null);
  }
  
  public AmiNested<A> withNewAmiLike(AWSResourceReference item) {
    return new AmiNested(item);
  }
  
  public CredentialsSecretNested<A> withNewCredentialsSecret() {
    return new CredentialsSecretNested(null);
  }
  
  public A withNewCredentialsSecret(String name) {
    return (A) this.withCredentialsSecret(new LocalObjectReference(name));
  }
  
  public CredentialsSecretNested<A> withNewCredentialsSecretLike(LocalObjectReference item) {
    return new CredentialsSecretNested(item);
  }
  
  public IamInstanceProfileNested<A> withNewIamInstanceProfile() {
    return new IamInstanceProfileNested(null);
  }
  
  public IamInstanceProfileNested<A> withNewIamInstanceProfileLike(AWSResourceReference item) {
    return new IamInstanceProfileNested(item);
  }
  
  public MetadataNested<A> withNewMetadata() {
    return new MetadataNested(null);
  }
  
  public MetadataNested<A> withNewMetadataLike(ObjectMeta item) {
    return new MetadataNested(item);
  }
  
  public MetadataServiceOptionsNested<A> withNewMetadataServiceOptions() {
    return new MetadataServiceOptionsNested(null);
  }
  
  public A withNewMetadataServiceOptions(String authentication) {
    return (A) this.withMetadataServiceOptions(new MetadataServiceOptions(authentication));
  }
  
  public MetadataServiceOptionsNested<A> withNewMetadataServiceOptionsLike(MetadataServiceOptions item) {
    return new MetadataServiceOptionsNested(item);
  }
  
  public PlacementNested<A> withNewPlacement() {
    return new PlacementNested(null);
  }
  
  public A withNewPlacement(String availabilityZone,String region,String tenancy) {
    return (A) this.withPlacement(new Placement(availabilityZone, region, tenancy));
  }
  
  public PlacementNested<A> withNewPlacementLike(Placement item) {
    return new PlacementNested(item);
  }
  
  public SpotMarketOptionsNested<A> withNewSpotMarketOptions() {
    return new SpotMarketOptionsNested(null);
  }
  
  public A withNewSpotMarketOptions(String maxPrice) {
    return (A) this.withSpotMarketOptions(new SpotMarketOptions(maxPrice));
  }
  
  public SpotMarketOptionsNested<A> withNewSpotMarketOptionsLike(SpotMarketOptions item) {
    return new SpotMarketOptionsNested(item);
  }
  
  public SubnetNested<A> withNewSubnet() {
    return new SubnetNested(null);
  }
  
  public SubnetNested<A> withNewSubnetLike(AWSResourceReference item) {
    return new SubnetNested(item);
  }
  
  public UserDataSecretNested<A> withNewUserDataSecret() {
    return new UserDataSecretNested(null);
  }
  
  public A withNewUserDataSecret(String name) {
    return (A) this.withUserDataSecret(new LocalObjectReference(name));
  }
  
  public UserDataSecretNested<A> withNewUserDataSecretLike(LocalObjectReference item) {
    return new UserDataSecretNested(item);
  }
  
  public A withPlacement(Placement placement) {
    this._visitables.remove("placement");
    if (placement != null) {
        this.placement = new PlacementBuilder(placement);
        this._visitables.get("placement").add(this.placement);
    } else {
        this.placement = null;
        this._visitables.get("placement").remove(this.placement);
    }
    return (A) this;
  }
  
  public A withPlacementGroupName(String placementGroupName) {
    this.placementGroupName = placementGroupName;
    return (A) this;
  }
  
  public A withPlacementGroupPartition(Integer placementGroupPartition) {
    this.placementGroupPartition = placementGroupPartition;
    return (A) this;
  }
  
  public A withPublicIp() {
    return withPublicIp(true);
  }
  
  public A withPublicIp(Boolean publicIp) {
    this.publicIp = publicIp;
    return (A) this;
  }
  
  public A withSecurityGroups(List<AWSResourceReference> securityGroups) {
    if (this.securityGroups != null) {
      this._visitables.get("securityGroups").clear();
    }
    if (securityGroups != null) {
        this.securityGroups = new ArrayList();
        for (AWSResourceReference item : securityGroups) {
          this.addToSecurityGroups(item);
        }
    } else {
      this.securityGroups = null;
    }
    return (A) this;
  }
  
  public A withSecurityGroups(AWSResourceReference... securityGroups) {
    if (this.securityGroups != null) {
        this.securityGroups.clear();
        _visitables.remove("securityGroups");
    }
    if (securityGroups != null) {
      for (AWSResourceReference item : securityGroups) {
        this.addToSecurityGroups(item);
      }
    }
    return (A) this;
  }
  
  public A withSpotMarketOptions(SpotMarketOptions spotMarketOptions) {
    this._visitables.remove("spotMarketOptions");
    if (spotMarketOptions != null) {
        this.spotMarketOptions = new SpotMarketOptionsBuilder(spotMarketOptions);
        this._visitables.get("spotMarketOptions").add(this.spotMarketOptions);
    } else {
        this.spotMarketOptions = null;
        this._visitables.get("spotMarketOptions").remove(this.spotMarketOptions);
    }
    return (A) this;
  }
  
  public A withSubnet(AWSResourceReference subnet) {
    this._visitables.remove("subnet");
    if (subnet != null) {
        this.subnet = new AWSResourceReferenceBuilder(subnet);
        this._visitables.get("subnet").add(this.subnet);
    } else {
        this.subnet = null;
        this._visitables.get("subnet").remove(this.subnet);
    }
    return (A) this;
  }
  
  public A withTags(List<TagSpecification> tags) {
    if (this.tags != null) {
      this._visitables.get("tags").clear();
    }
    if (tags != null) {
        this.tags = new ArrayList();
        for (TagSpecification item : tags) {
          this.addToTags(item);
        }
    } else {
      this.tags = null;
    }
    return (A) this;
  }
  
  public A withTags(TagSpecification... tags) {
    if (this.tags != null) {
        this.tags.clear();
        _visitables.remove("tags");
    }
    if (tags != null) {
      for (TagSpecification item : tags) {
        this.addToTags(item);
      }
    }
    return (A) this;
  }
  
  public A withUserDataSecret(LocalObjectReference userDataSecret) {
    this._visitables.remove("userDataSecret");
    if (userDataSecret != null) {
        this.userDataSecret = new LocalObjectReferenceBuilder(userDataSecret);
        this._visitables.get("userDataSecret").add(this.userDataSecret);
    } else {
        this.userDataSecret = null;
        this._visitables.get("userDataSecret").remove(this.userDataSecret);
    }
    return (A) this;
  }
  public class AmiNested<N> extends AWSResourceReferenceFluent<AmiNested<N>> implements Nested<N>{
  
    AWSResourceReferenceBuilder builder;
  
    AmiNested(AWSResourceReference item) {
      this.builder = new AWSResourceReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) AWSMachineProviderConfigFluent.this.withAmi(builder.build());
    }
    
    public N endAmi() {
      return and();
    }
    
  }
  public class BlockDevicesNested<N> extends BlockDeviceMappingSpecFluent<BlockDevicesNested<N>> implements Nested<N>{
  
    BlockDeviceMappingSpecBuilder builder;
    int index;
  
    BlockDevicesNested(int index,BlockDeviceMappingSpec item) {
      this.index = index;
      this.builder = new BlockDeviceMappingSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) AWSMachineProviderConfigFluent.this.setToBlockDevices(index, builder.build());
    }
    
    public N endBlockDevice() {
      return and();
    }
    
  }
  public class CredentialsSecretNested<N> extends LocalObjectReferenceFluent<CredentialsSecretNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    CredentialsSecretNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) AWSMachineProviderConfigFluent.this.withCredentialsSecret(builder.build());
    }
    
    public N endCredentialsSecret() {
      return and();
    }
    
  }
  public class IamInstanceProfileNested<N> extends AWSResourceReferenceFluent<IamInstanceProfileNested<N>> implements Nested<N>{
  
    AWSResourceReferenceBuilder builder;
  
    IamInstanceProfileNested(AWSResourceReference item) {
      this.builder = new AWSResourceReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) AWSMachineProviderConfigFluent.this.withIamInstanceProfile(builder.build());
    }
    
    public N endIamInstanceProfile() {
      return and();
    }
    
  }
  public class LoadBalancersNested<N> extends LoadBalancerReferenceFluent<LoadBalancersNested<N>> implements Nested<N>{
  
    LoadBalancerReferenceBuilder builder;
    int index;
  
    LoadBalancersNested(int index,LoadBalancerReference item) {
      this.index = index;
      this.builder = new LoadBalancerReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) AWSMachineProviderConfigFluent.this.setToLoadBalancers(index, builder.build());
    }
    
    public N endLoadBalancer() {
      return and();
    }
    
  }
  public class MetadataNested<N> extends ObjectMetaFluent<MetadataNested<N>> implements Nested<N>{
  
    ObjectMetaBuilder builder;
  
    MetadataNested(ObjectMeta item) {
      this.builder = new ObjectMetaBuilder(this, item);
    }
  
    public N and() {
      return (N) AWSMachineProviderConfigFluent.this.withMetadata(builder.build());
    }
    
    public N endMetadata() {
      return and();
    }
    
  }
  public class MetadataServiceOptionsNested<N> extends MetadataServiceOptionsFluent<MetadataServiceOptionsNested<N>> implements Nested<N>{
  
    MetadataServiceOptionsBuilder builder;
  
    MetadataServiceOptionsNested(MetadataServiceOptions item) {
      this.builder = new MetadataServiceOptionsBuilder(this, item);
    }
  
    public N and() {
      return (N) AWSMachineProviderConfigFluent.this.withMetadataServiceOptions(builder.build());
    }
    
    public N endMetadataServiceOptions() {
      return and();
    }
    
  }
  public class PlacementNested<N> extends PlacementFluent<PlacementNested<N>> implements Nested<N>{
  
    PlacementBuilder builder;
  
    PlacementNested(Placement item) {
      this.builder = new PlacementBuilder(this, item);
    }
  
    public N and() {
      return (N) AWSMachineProviderConfigFluent.this.withPlacement(builder.build());
    }
    
    public N endPlacement() {
      return and();
    }
    
  }
  public class SecurityGroupsNested<N> extends AWSResourceReferenceFluent<SecurityGroupsNested<N>> implements Nested<N>{
  
    AWSResourceReferenceBuilder builder;
    int index;
  
    SecurityGroupsNested(int index,AWSResourceReference item) {
      this.index = index;
      this.builder = new AWSResourceReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) AWSMachineProviderConfigFluent.this.setToSecurityGroups(index, builder.build());
    }
    
    public N endSecurityGroup() {
      return and();
    }
    
  }
  public class SpotMarketOptionsNested<N> extends SpotMarketOptionsFluent<SpotMarketOptionsNested<N>> implements Nested<N>{
  
    SpotMarketOptionsBuilder builder;
  
    SpotMarketOptionsNested(SpotMarketOptions item) {
      this.builder = new SpotMarketOptionsBuilder(this, item);
    }
  
    public N and() {
      return (N) AWSMachineProviderConfigFluent.this.withSpotMarketOptions(builder.build());
    }
    
    public N endSpotMarketOptions() {
      return and();
    }
    
  }
  public class SubnetNested<N> extends AWSResourceReferenceFluent<SubnetNested<N>> implements Nested<N>{
  
    AWSResourceReferenceBuilder builder;
  
    SubnetNested(AWSResourceReference item) {
      this.builder = new AWSResourceReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) AWSMachineProviderConfigFluent.this.withSubnet(builder.build());
    }
    
    public N endSubnet() {
      return and();
    }
    
  }
  public class TagsNested<N> extends TagSpecificationFluent<TagsNested<N>> implements Nested<N>{
  
    TagSpecificationBuilder builder;
    int index;
  
    TagsNested(int index,TagSpecification item) {
      this.index = index;
      this.builder = new TagSpecificationBuilder(this, item);
    }
  
    public N and() {
      return (N) AWSMachineProviderConfigFluent.this.setToTags(index, builder.build());
    }
    
    public N endTag() {
      return and();
    }
    
  }
  public class UserDataSecretNested<N> extends LocalObjectReferenceFluent<UserDataSecretNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    UserDataSecretNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) AWSMachineProviderConfigFluent.this.withUserDataSecret(builder.build());
    }
    
    public N endUserDataSecret() {
      return and();
    }
    
  }
}