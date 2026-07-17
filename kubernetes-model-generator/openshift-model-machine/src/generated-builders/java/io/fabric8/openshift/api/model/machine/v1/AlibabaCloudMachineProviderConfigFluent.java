package io.fabric8.openshift.api.model.machine.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceFluent;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaFluent;
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
public class AlibabaCloudMachineProviderConfigFluent<A extends io.fabric8.openshift.api.model.machine.v1.AlibabaCloudMachineProviderConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private BandwidthPropertiesBuilder bandwidth;
  private LocalObjectReferenceBuilder credentialsSecret;
  private ArrayList<DataDiskPropertiesBuilder> dataDisk = new ArrayList<DataDiskPropertiesBuilder>();
  private String imageId;
  private String instanceType;
  private String kind;
  private ObjectMetaBuilder metadata;
  private String ramRoleName;
  private String regionId;
  private AlibabaResourceReferenceBuilder resourceGroup;
  private ArrayList<AlibabaResourceReferenceBuilder> securityGroups = new ArrayList<AlibabaResourceReferenceBuilder>();
  private SystemDiskPropertiesBuilder systemDisk;
  private ArrayList<TagBuilder> tag = new ArrayList<TagBuilder>();
  private String tenancy;
  private LocalObjectReferenceBuilder userDataSecret;
  private AlibabaResourceReferenceBuilder vSwitch;
  private String vpcId;
  private String zoneId;

  public AlibabaCloudMachineProviderConfigFluent() {
  }
  
  public AlibabaCloudMachineProviderConfigFluent(AlibabaCloudMachineProviderConfig instance) {
    this.copyInstance(instance);
  }

  public A addAllToDataDisk(Collection<DataDiskProperties> items) {
    if (this.dataDisk == null) {
      this.dataDisk = new ArrayList();
    }
    for (DataDiskProperties item : items) {
        DataDiskPropertiesBuilder builder = new DataDiskPropertiesBuilder(item);
        _visitables.get("dataDisk").add(builder);
        this.dataDisk.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToSecurityGroups(Collection<AlibabaResourceReference> items) {
    if (this.securityGroups == null) {
      this.securityGroups = new ArrayList();
    }
    for (AlibabaResourceReference item : items) {
        AlibabaResourceReferenceBuilder builder = new AlibabaResourceReferenceBuilder(item);
        _visitables.get("securityGroups").add(builder);
        this.securityGroups.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToTag(Collection<Tag> items) {
    if (this.tag == null) {
      this.tag = new ArrayList();
    }
    for (Tag item : items) {
        TagBuilder builder = new TagBuilder(item);
        _visitables.get("tag").add(builder);
        this.tag.add(builder);
    }
    return (A) this;
  }
  
  public DataDiskNested<A> addNewDataDisk() {
    return new DataDiskNested(-1, null);
  }
  
  public DataDiskNested<A> addNewDataDiskLike(DataDiskProperties item) {
    return new DataDiskNested(-1, item);
  }
  
  public SecurityGroupsNested<A> addNewSecurityGroup() {
    return new SecurityGroupsNested(-1, null);
  }
  
  public SecurityGroupsNested<A> addNewSecurityGroupLike(AlibabaResourceReference item) {
    return new SecurityGroupsNested(-1, item);
  }
  
  public TagNested<A> addNewTag() {
    return new TagNested(-1, null);
  }
  
  public A addNewTag(String key,String value) {
    return (A) this.addToTag(new Tag(key, value));
  }
  
  public TagNested<A> addNewTagLike(Tag item) {
    return new TagNested(-1, item);
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
  
  public A addToDataDisk(DataDiskProperties... items) {
    if (this.dataDisk == null) {
      this.dataDisk = new ArrayList();
    }
    for (DataDiskProperties item : items) {
        DataDiskPropertiesBuilder builder = new DataDiskPropertiesBuilder(item);
        _visitables.get("dataDisk").add(builder);
        this.dataDisk.add(builder);
    }
    return (A) this;
  }
  
  public A addToDataDisk(int index,DataDiskProperties item) {
    if (this.dataDisk == null) {
      this.dataDisk = new ArrayList();
    }
    DataDiskPropertiesBuilder builder = new DataDiskPropertiesBuilder(item);
    if (index < 0 || index >= dataDisk.size()) {
        _visitables.get("dataDisk").add(builder);
        dataDisk.add(builder);
    } else {
        _visitables.get("dataDisk").add(builder);
        dataDisk.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToSecurityGroups(AlibabaResourceReference... items) {
    if (this.securityGroups == null) {
      this.securityGroups = new ArrayList();
    }
    for (AlibabaResourceReference item : items) {
        AlibabaResourceReferenceBuilder builder = new AlibabaResourceReferenceBuilder(item);
        _visitables.get("securityGroups").add(builder);
        this.securityGroups.add(builder);
    }
    return (A) this;
  }
  
  public A addToSecurityGroups(int index,AlibabaResourceReference item) {
    if (this.securityGroups == null) {
      this.securityGroups = new ArrayList();
    }
    AlibabaResourceReferenceBuilder builder = new AlibabaResourceReferenceBuilder(item);
    if (index < 0 || index >= securityGroups.size()) {
        _visitables.get("securityGroups").add(builder);
        securityGroups.add(builder);
    } else {
        _visitables.get("securityGroups").add(builder);
        securityGroups.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToTag(Tag... items) {
    if (this.tag == null) {
      this.tag = new ArrayList();
    }
    for (Tag item : items) {
        TagBuilder builder = new TagBuilder(item);
        _visitables.get("tag").add(builder);
        this.tag.add(builder);
    }
    return (A) this;
  }
  
  public A addToTag(int index,Tag item) {
    if (this.tag == null) {
      this.tag = new ArrayList();
    }
    TagBuilder builder = new TagBuilder(item);
    if (index < 0 || index >= tag.size()) {
        _visitables.get("tag").add(builder);
        tag.add(builder);
    } else {
        _visitables.get("tag").add(builder);
        tag.add(index, builder);
    }
    return (A) this;
  }
  
  public BandwidthProperties buildBandwidth() {
    return this.bandwidth != null ? this.bandwidth.build() : null;
  }
  
  public LocalObjectReference buildCredentialsSecret() {
    return this.credentialsSecret != null ? this.credentialsSecret.build() : null;
  }
  
  public List<DataDiskProperties> buildDataDisk() {
    return this.dataDisk != null ? build(dataDisk) : null;
  }
  
  public DataDiskProperties buildDataDisk(int index) {
    return this.dataDisk.get(index).build();
  }
  
  public DataDiskProperties buildFirstDataDisk() {
    return this.dataDisk.get(0).build();
  }
  
  public AlibabaResourceReference buildFirstSecurityGroup() {
    return this.securityGroups.get(0).build();
  }
  
  public Tag buildFirstTag() {
    return this.tag.get(0).build();
  }
  
  public DataDiskProperties buildLastDataDisk() {
    return this.dataDisk.get(dataDisk.size() - 1).build();
  }
  
  public AlibabaResourceReference buildLastSecurityGroup() {
    return this.securityGroups.get(securityGroups.size() - 1).build();
  }
  
  public Tag buildLastTag() {
    return this.tag.get(tag.size() - 1).build();
  }
  
  public DataDiskProperties buildMatchingDataDisk(Predicate<DataDiskPropertiesBuilder> predicate) {
      for (DataDiskPropertiesBuilder item : dataDisk) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public AlibabaResourceReference buildMatchingSecurityGroup(Predicate<AlibabaResourceReferenceBuilder> predicate) {
      for (AlibabaResourceReferenceBuilder item : securityGroups) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Tag buildMatchingTag(Predicate<TagBuilder> predicate) {
      for (TagBuilder item : tag) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ObjectMeta buildMetadata() {
    return this.metadata != null ? this.metadata.build() : null;
  }
  
  public AlibabaResourceReference buildResourceGroup() {
    return this.resourceGroup != null ? this.resourceGroup.build() : null;
  }
  
  public AlibabaResourceReference buildSecurityGroup(int index) {
    return this.securityGroups.get(index).build();
  }
  
  public List<AlibabaResourceReference> buildSecurityGroups() {
    return this.securityGroups != null ? build(securityGroups) : null;
  }
  
  public SystemDiskProperties buildSystemDisk() {
    return this.systemDisk != null ? this.systemDisk.build() : null;
  }
  
  public List<Tag> buildTag() {
    return this.tag != null ? build(tag) : null;
  }
  
  public Tag buildTag(int index) {
    return this.tag.get(index).build();
  }
  
  public LocalObjectReference buildUserDataSecret() {
    return this.userDataSecret != null ? this.userDataSecret.build() : null;
  }
  
  public AlibabaResourceReference buildVSwitch() {
    return this.vSwitch != null ? this.vSwitch.build() : null;
  }
  
  protected void copyInstance(AlibabaCloudMachineProviderConfig instance) {
    instance = instance != null ? instance : new AlibabaCloudMachineProviderConfig();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withBandwidth(instance.getBandwidth());
        this.withCredentialsSecret(instance.getCredentialsSecret());
        this.withDataDisk(instance.getDataDisk());
        this.withImageId(instance.getImageId());
        this.withInstanceType(instance.getInstanceType());
        this.withKind(instance.getKind());
        this.withMetadata(instance.getMetadata());
        this.withRamRoleName(instance.getRamRoleName());
        this.withRegionId(instance.getRegionId());
        this.withResourceGroup(instance.getResourceGroup());
        this.withSecurityGroups(instance.getSecurityGroups());
        this.withSystemDisk(instance.getSystemDisk());
        this.withTag(instance.getTag());
        this.withTenancy(instance.getTenancy());
        this.withUserDataSecret(instance.getUserDataSecret());
        this.withVSwitch(instance.getVSwitch());
        this.withVpcId(instance.getVpcId());
        this.withZoneId(instance.getZoneId());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public BandwidthNested<A> editBandwidth() {
    return this.withNewBandwidthLike(Optional.ofNullable(this.buildBandwidth()).orElse(null));
  }
  
  public CredentialsSecretNested<A> editCredentialsSecret() {
    return this.withNewCredentialsSecretLike(Optional.ofNullable(this.buildCredentialsSecret()).orElse(null));
  }
  
  public DataDiskNested<A> editDataDisk(int index) {
    if (dataDisk.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "dataDisk"));
    }
    return this.setNewDataDiskLike(index, this.buildDataDisk(index));
  }
  
  public DataDiskNested<A> editFirstDataDisk() {
    if (dataDisk.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "dataDisk"));
    }
    return this.setNewDataDiskLike(0, this.buildDataDisk(0));
  }
  
  public SecurityGroupsNested<A> editFirstSecurityGroup() {
    if (securityGroups.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "securityGroups"));
    }
    return this.setNewSecurityGroupLike(0, this.buildSecurityGroup(0));
  }
  
  public TagNested<A> editFirstTag() {
    if (tag.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "tag"));
    }
    return this.setNewTagLike(0, this.buildTag(0));
  }
  
  public DataDiskNested<A> editLastDataDisk() {
    int index = dataDisk.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "dataDisk"));
    }
    return this.setNewDataDiskLike(index, this.buildDataDisk(index));
  }
  
  public SecurityGroupsNested<A> editLastSecurityGroup() {
    int index = securityGroups.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "securityGroups"));
    }
    return this.setNewSecurityGroupLike(index, this.buildSecurityGroup(index));
  }
  
  public TagNested<A> editLastTag() {
    int index = tag.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "tag"));
    }
    return this.setNewTagLike(index, this.buildTag(index));
  }
  
  public DataDiskNested<A> editMatchingDataDisk(Predicate<DataDiskPropertiesBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < dataDisk.size();i++) {
      if (predicate.test(dataDisk.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "dataDisk"));
    }
    return this.setNewDataDiskLike(index, this.buildDataDisk(index));
  }
  
  public SecurityGroupsNested<A> editMatchingSecurityGroup(Predicate<AlibabaResourceReferenceBuilder> predicate) {
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
  
  public TagNested<A> editMatchingTag(Predicate<TagBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < tag.size();i++) {
      if (predicate.test(tag.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "tag"));
    }
    return this.setNewTagLike(index, this.buildTag(index));
  }
  
  public MetadataNested<A> editMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(null));
  }
  
  public BandwidthNested<A> editOrNewBandwidth() {
    return this.withNewBandwidthLike(Optional.ofNullable(this.buildBandwidth()).orElse(new BandwidthPropertiesBuilder().build()));
  }
  
  public BandwidthNested<A> editOrNewBandwidthLike(BandwidthProperties item) {
    return this.withNewBandwidthLike(Optional.ofNullable(this.buildBandwidth()).orElse(item));
  }
  
  public CredentialsSecretNested<A> editOrNewCredentialsSecret() {
    return this.withNewCredentialsSecretLike(Optional.ofNullable(this.buildCredentialsSecret()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public CredentialsSecretNested<A> editOrNewCredentialsSecretLike(LocalObjectReference item) {
    return this.withNewCredentialsSecretLike(Optional.ofNullable(this.buildCredentialsSecret()).orElse(item));
  }
  
  public MetadataNested<A> editOrNewMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(new ObjectMetaBuilder().build()));
  }
  
  public MetadataNested<A> editOrNewMetadataLike(ObjectMeta item) {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(item));
  }
  
  public ResourceGroupNested<A> editOrNewResourceGroup() {
    return this.withNewResourceGroupLike(Optional.ofNullable(this.buildResourceGroup()).orElse(new AlibabaResourceReferenceBuilder().build()));
  }
  
  public ResourceGroupNested<A> editOrNewResourceGroupLike(AlibabaResourceReference item) {
    return this.withNewResourceGroupLike(Optional.ofNullable(this.buildResourceGroup()).orElse(item));
  }
  
  public SystemDiskNested<A> editOrNewSystemDisk() {
    return this.withNewSystemDiskLike(Optional.ofNullable(this.buildSystemDisk()).orElse(new SystemDiskPropertiesBuilder().build()));
  }
  
  public SystemDiskNested<A> editOrNewSystemDiskLike(SystemDiskProperties item) {
    return this.withNewSystemDiskLike(Optional.ofNullable(this.buildSystemDisk()).orElse(item));
  }
  
  public UserDataSecretNested<A> editOrNewUserDataSecret() {
    return this.withNewUserDataSecretLike(Optional.ofNullable(this.buildUserDataSecret()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public UserDataSecretNested<A> editOrNewUserDataSecretLike(LocalObjectReference item) {
    return this.withNewUserDataSecretLike(Optional.ofNullable(this.buildUserDataSecret()).orElse(item));
  }
  
  public VSwitchNested<A> editOrNewVSwitch() {
    return this.withNewVSwitchLike(Optional.ofNullable(this.buildVSwitch()).orElse(new AlibabaResourceReferenceBuilder().build()));
  }
  
  public VSwitchNested<A> editOrNewVSwitchLike(AlibabaResourceReference item) {
    return this.withNewVSwitchLike(Optional.ofNullable(this.buildVSwitch()).orElse(item));
  }
  
  public ResourceGroupNested<A> editResourceGroup() {
    return this.withNewResourceGroupLike(Optional.ofNullable(this.buildResourceGroup()).orElse(null));
  }
  
  public SecurityGroupsNested<A> editSecurityGroup(int index) {
    if (securityGroups.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "securityGroups"));
    }
    return this.setNewSecurityGroupLike(index, this.buildSecurityGroup(index));
  }
  
  public SystemDiskNested<A> editSystemDisk() {
    return this.withNewSystemDiskLike(Optional.ofNullable(this.buildSystemDisk()).orElse(null));
  }
  
  public TagNested<A> editTag(int index) {
    if (tag.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "tag"));
    }
    return this.setNewTagLike(index, this.buildTag(index));
  }
  
  public UserDataSecretNested<A> editUserDataSecret() {
    return this.withNewUserDataSecretLike(Optional.ofNullable(this.buildUserDataSecret()).orElse(null));
  }
  
  public VSwitchNested<A> editVSwitch() {
    return this.withNewVSwitchLike(Optional.ofNullable(this.buildVSwitch()).orElse(null));
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
    AlibabaCloudMachineProviderConfigFluent that = (AlibabaCloudMachineProviderConfigFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(bandwidth, that.bandwidth))) {
      return false;
    }
    if (!(Objects.equals(credentialsSecret, that.credentialsSecret))) {
      return false;
    }
    if (!(Objects.equals(dataDisk, that.dataDisk))) {
      return false;
    }
    if (!(Objects.equals(imageId, that.imageId))) {
      return false;
    }
    if (!(Objects.equals(instanceType, that.instanceType))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(metadata, that.metadata))) {
      return false;
    }
    if (!(Objects.equals(ramRoleName, that.ramRoleName))) {
      return false;
    }
    if (!(Objects.equals(regionId, that.regionId))) {
      return false;
    }
    if (!(Objects.equals(resourceGroup, that.resourceGroup))) {
      return false;
    }
    if (!(Objects.equals(securityGroups, that.securityGroups))) {
      return false;
    }
    if (!(Objects.equals(systemDisk, that.systemDisk))) {
      return false;
    }
    if (!(Objects.equals(tag, that.tag))) {
      return false;
    }
    if (!(Objects.equals(tenancy, that.tenancy))) {
      return false;
    }
    if (!(Objects.equals(userDataSecret, that.userDataSecret))) {
      return false;
    }
    if (!(Objects.equals(vSwitch, that.vSwitch))) {
      return false;
    }
    if (!(Objects.equals(vpcId, that.vpcId))) {
      return false;
    }
    if (!(Objects.equals(zoneId, that.zoneId))) {
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
  
  public String getImageId() {
    return this.imageId;
  }
  
  public String getInstanceType() {
    return this.instanceType;
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public String getRamRoleName() {
    return this.ramRoleName;
  }
  
  public String getRegionId() {
    return this.regionId;
  }
  
  public String getTenancy() {
    return this.tenancy;
  }
  
  public String getVpcId() {
    return this.vpcId;
  }
  
  public String getZoneId() {
    return this.zoneId;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasBandwidth() {
    return this.bandwidth != null;
  }
  
  public boolean hasCredentialsSecret() {
    return this.credentialsSecret != null;
  }
  
  public boolean hasDataDisk() {
    return this.dataDisk != null && !(this.dataDisk.isEmpty());
  }
  
  public boolean hasImageId() {
    return this.imageId != null;
  }
  
  public boolean hasInstanceType() {
    return this.instanceType != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasMatchingDataDisk(Predicate<DataDiskPropertiesBuilder> predicate) {
      for (DataDiskPropertiesBuilder item : dataDisk) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingSecurityGroup(Predicate<AlibabaResourceReferenceBuilder> predicate) {
      for (AlibabaResourceReferenceBuilder item : securityGroups) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingTag(Predicate<TagBuilder> predicate) {
      for (TagBuilder item : tag) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMetadata() {
    return this.metadata != null;
  }
  
  public boolean hasRamRoleName() {
    return this.ramRoleName != null;
  }
  
  public boolean hasRegionId() {
    return this.regionId != null;
  }
  
  public boolean hasResourceGroup() {
    return this.resourceGroup != null;
  }
  
  public boolean hasSecurityGroups() {
    return this.securityGroups != null && !(this.securityGroups.isEmpty());
  }
  
  public boolean hasSystemDisk() {
    return this.systemDisk != null;
  }
  
  public boolean hasTag() {
    return this.tag != null && !(this.tag.isEmpty());
  }
  
  public boolean hasTenancy() {
    return this.tenancy != null;
  }
  
  public boolean hasUserDataSecret() {
    return this.userDataSecret != null;
  }
  
  public boolean hasVSwitch() {
    return this.vSwitch != null;
  }
  
  public boolean hasVpcId() {
    return this.vpcId != null;
  }
  
  public boolean hasZoneId() {
    return this.zoneId != null;
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, bandwidth, credentialsSecret, dataDisk, imageId, instanceType, kind, metadata, ramRoleName, regionId, resourceGroup, securityGroups, systemDisk, tag, tenancy, userDataSecret, vSwitch, vpcId, zoneId, additionalProperties);
  }
  
  public A removeAllFromDataDisk(Collection<DataDiskProperties> items) {
    if (this.dataDisk == null) {
      return (A) this;
    }
    for (DataDiskProperties item : items) {
        DataDiskPropertiesBuilder builder = new DataDiskPropertiesBuilder(item);
        _visitables.get("dataDisk").remove(builder);
        this.dataDisk.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromSecurityGroups(Collection<AlibabaResourceReference> items) {
    if (this.securityGroups == null) {
      return (A) this;
    }
    for (AlibabaResourceReference item : items) {
        AlibabaResourceReferenceBuilder builder = new AlibabaResourceReferenceBuilder(item);
        _visitables.get("securityGroups").remove(builder);
        this.securityGroups.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromTag(Collection<Tag> items) {
    if (this.tag == null) {
      return (A) this;
    }
    for (Tag item : items) {
        TagBuilder builder = new TagBuilder(item);
        _visitables.get("tag").remove(builder);
        this.tag.remove(builder);
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
  
  public A removeFromDataDisk(DataDiskProperties... items) {
    if (this.dataDisk == null) {
      return (A) this;
    }
    for (DataDiskProperties item : items) {
        DataDiskPropertiesBuilder builder = new DataDiskPropertiesBuilder(item);
        _visitables.get("dataDisk").remove(builder);
        this.dataDisk.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromSecurityGroups(AlibabaResourceReference... items) {
    if (this.securityGroups == null) {
      return (A) this;
    }
    for (AlibabaResourceReference item : items) {
        AlibabaResourceReferenceBuilder builder = new AlibabaResourceReferenceBuilder(item);
        _visitables.get("securityGroups").remove(builder);
        this.securityGroups.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromTag(Tag... items) {
    if (this.tag == null) {
      return (A) this;
    }
    for (Tag item : items) {
        TagBuilder builder = new TagBuilder(item);
        _visitables.get("tag").remove(builder);
        this.tag.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromDataDisk(Predicate<DataDiskPropertiesBuilder> predicate) {
    if (dataDisk == null) {
      return (A) this;
    }
    Iterator<DataDiskPropertiesBuilder> each = dataDisk.iterator();
    List visitables = _visitables.get("dataDisk");
    while (each.hasNext()) {
        DataDiskPropertiesBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromSecurityGroups(Predicate<AlibabaResourceReferenceBuilder> predicate) {
    if (securityGroups == null) {
      return (A) this;
    }
    Iterator<AlibabaResourceReferenceBuilder> each = securityGroups.iterator();
    List visitables = _visitables.get("securityGroups");
    while (each.hasNext()) {
        AlibabaResourceReferenceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromTag(Predicate<TagBuilder> predicate) {
    if (tag == null) {
      return (A) this;
    }
    Iterator<TagBuilder> each = tag.iterator();
    List visitables = _visitables.get("tag");
    while (each.hasNext()) {
        TagBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public DataDiskNested<A> setNewDataDiskLike(int index,DataDiskProperties item) {
    return new DataDiskNested(index, item);
  }
  
  public SecurityGroupsNested<A> setNewSecurityGroupLike(int index,AlibabaResourceReference item) {
    return new SecurityGroupsNested(index, item);
  }
  
  public TagNested<A> setNewTagLike(int index,Tag item) {
    return new TagNested(index, item);
  }
  
  public A setToDataDisk(int index,DataDiskProperties item) {
    if (this.dataDisk == null) {
      this.dataDisk = new ArrayList();
    }
    DataDiskPropertiesBuilder builder = new DataDiskPropertiesBuilder(item);
    if (index < 0 || index >= dataDisk.size()) {
        _visitables.get("dataDisk").add(builder);
        dataDisk.add(builder);
    } else {
        _visitables.get("dataDisk").add(builder);
        dataDisk.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToSecurityGroups(int index,AlibabaResourceReference item) {
    if (this.securityGroups == null) {
      this.securityGroups = new ArrayList();
    }
    AlibabaResourceReferenceBuilder builder = new AlibabaResourceReferenceBuilder(item);
    if (index < 0 || index >= securityGroups.size()) {
        _visitables.get("securityGroups").add(builder);
        securityGroups.add(builder);
    } else {
        _visitables.get("securityGroups").add(builder);
        securityGroups.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToTag(int index,Tag item) {
    if (this.tag == null) {
      this.tag = new ArrayList();
    }
    TagBuilder builder = new TagBuilder(item);
    if (index < 0 || index >= tag.size()) {
        _visitables.get("tag").add(builder);
        tag.add(builder);
    } else {
        _visitables.get("tag").add(builder);
        tag.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(apiVersion == null)) {
        sb.append("apiVersion:");
        sb.append(apiVersion);
        sb.append(",");
    }
    if (!(bandwidth == null)) {
        sb.append("bandwidth:");
        sb.append(bandwidth);
        sb.append(",");
    }
    if (!(credentialsSecret == null)) {
        sb.append("credentialsSecret:");
        sb.append(credentialsSecret);
        sb.append(",");
    }
    if (!(dataDisk == null) && !(dataDisk.isEmpty())) {
        sb.append("dataDisk:");
        sb.append(dataDisk);
        sb.append(",");
    }
    if (!(imageId == null)) {
        sb.append("imageId:");
        sb.append(imageId);
        sb.append(",");
    }
    if (!(instanceType == null)) {
        sb.append("instanceType:");
        sb.append(instanceType);
        sb.append(",");
    }
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
        sb.append(",");
    }
    if (!(metadata == null)) {
        sb.append("metadata:");
        sb.append(metadata);
        sb.append(",");
    }
    if (!(ramRoleName == null)) {
        sb.append("ramRoleName:");
        sb.append(ramRoleName);
        sb.append(",");
    }
    if (!(regionId == null)) {
        sb.append("regionId:");
        sb.append(regionId);
        sb.append(",");
    }
    if (!(resourceGroup == null)) {
        sb.append("resourceGroup:");
        sb.append(resourceGroup);
        sb.append(",");
    }
    if (!(securityGroups == null) && !(securityGroups.isEmpty())) {
        sb.append("securityGroups:");
        sb.append(securityGroups);
        sb.append(",");
    }
    if (!(systemDisk == null)) {
        sb.append("systemDisk:");
        sb.append(systemDisk);
        sb.append(",");
    }
    if (!(tag == null) && !(tag.isEmpty())) {
        sb.append("tag:");
        sb.append(tag);
        sb.append(",");
    }
    if (!(tenancy == null)) {
        sb.append("tenancy:");
        sb.append(tenancy);
        sb.append(",");
    }
    if (!(userDataSecret == null)) {
        sb.append("userDataSecret:");
        sb.append(userDataSecret);
        sb.append(",");
    }
    if (!(vSwitch == null)) {
        sb.append("vSwitch:");
        sb.append(vSwitch);
        sb.append(",");
    }
    if (!(vpcId == null)) {
        sb.append("vpcId:");
        sb.append(vpcId);
        sb.append(",");
    }
    if (!(zoneId == null)) {
        sb.append("zoneId:");
        sb.append(zoneId);
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
  
  public A withApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
    return (A) this;
  }
  
  public A withBandwidth(BandwidthProperties bandwidth) {
    this._visitables.remove("bandwidth");
    if (bandwidth != null) {
        this.bandwidth = new BandwidthPropertiesBuilder(bandwidth);
        this._visitables.get("bandwidth").add(this.bandwidth);
    } else {
        this.bandwidth = null;
        this._visitables.get("bandwidth").remove(this.bandwidth);
    }
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
  
  public A withDataDisk(List<DataDiskProperties> dataDisk) {
    if (this.dataDisk != null) {
      this._visitables.get("dataDisk").clear();
    }
    if (dataDisk != null) {
        this.dataDisk = new ArrayList();
        for (DataDiskProperties item : dataDisk) {
          this.addToDataDisk(item);
        }
    } else {
      this.dataDisk = null;
    }
    return (A) this;
  }
  
  public A withDataDisk(DataDiskProperties... dataDisk) {
    if (this.dataDisk != null) {
        this.dataDisk.clear();
        _visitables.remove("dataDisk");
    }
    if (dataDisk != null) {
      for (DataDiskProperties item : dataDisk) {
        this.addToDataDisk(item);
      }
    }
    return (A) this;
  }
  
  public A withImageId(String imageId) {
    this.imageId = imageId;
    return (A) this;
  }
  
  public A withInstanceType(String instanceType) {
    this.instanceType = instanceType;
    return (A) this;
  }
  
  public A withKind(String kind) {
    this.kind = kind;
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
  
  public BandwidthNested<A> withNewBandwidth() {
    return new BandwidthNested(null);
  }
  
  public A withNewBandwidth(Long internetMaxBandwidthIn,Long internetMaxBandwidthOut) {
    return (A) this.withBandwidth(new BandwidthProperties(internetMaxBandwidthIn, internetMaxBandwidthOut));
  }
  
  public BandwidthNested<A> withNewBandwidthLike(BandwidthProperties item) {
    return new BandwidthNested(item);
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
  
  public MetadataNested<A> withNewMetadata() {
    return new MetadataNested(null);
  }
  
  public MetadataNested<A> withNewMetadataLike(ObjectMeta item) {
    return new MetadataNested(item);
  }
  
  public ResourceGroupNested<A> withNewResourceGroup() {
    return new ResourceGroupNested(null);
  }
  
  public ResourceGroupNested<A> withNewResourceGroupLike(AlibabaResourceReference item) {
    return new ResourceGroupNested(item);
  }
  
  public SystemDiskNested<A> withNewSystemDisk() {
    return new SystemDiskNested(null);
  }
  
  public A withNewSystemDisk(String category,String name,String performanceLevel,Long size) {
    return (A) this.withSystemDisk(new SystemDiskProperties(category, name, performanceLevel, size));
  }
  
  public SystemDiskNested<A> withNewSystemDiskLike(SystemDiskProperties item) {
    return new SystemDiskNested(item);
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
  
  public VSwitchNested<A> withNewVSwitch() {
    return new VSwitchNested(null);
  }
  
  public VSwitchNested<A> withNewVSwitchLike(AlibabaResourceReference item) {
    return new VSwitchNested(item);
  }
  
  public A withRamRoleName(String ramRoleName) {
    this.ramRoleName = ramRoleName;
    return (A) this;
  }
  
  public A withRegionId(String regionId) {
    this.regionId = regionId;
    return (A) this;
  }
  
  public A withResourceGroup(AlibabaResourceReference resourceGroup) {
    this._visitables.remove("resourceGroup");
    if (resourceGroup != null) {
        this.resourceGroup = new AlibabaResourceReferenceBuilder(resourceGroup);
        this._visitables.get("resourceGroup").add(this.resourceGroup);
    } else {
        this.resourceGroup = null;
        this._visitables.get("resourceGroup").remove(this.resourceGroup);
    }
    return (A) this;
  }
  
  public A withSecurityGroups(List<AlibabaResourceReference> securityGroups) {
    if (this.securityGroups != null) {
      this._visitables.get("securityGroups").clear();
    }
    if (securityGroups != null) {
        this.securityGroups = new ArrayList();
        for (AlibabaResourceReference item : securityGroups) {
          this.addToSecurityGroups(item);
        }
    } else {
      this.securityGroups = null;
    }
    return (A) this;
  }
  
  public A withSecurityGroups(AlibabaResourceReference... securityGroups) {
    if (this.securityGroups != null) {
        this.securityGroups.clear();
        _visitables.remove("securityGroups");
    }
    if (securityGroups != null) {
      for (AlibabaResourceReference item : securityGroups) {
        this.addToSecurityGroups(item);
      }
    }
    return (A) this;
  }
  
  public A withSystemDisk(SystemDiskProperties systemDisk) {
    this._visitables.remove("systemDisk");
    if (systemDisk != null) {
        this.systemDisk = new SystemDiskPropertiesBuilder(systemDisk);
        this._visitables.get("systemDisk").add(this.systemDisk);
    } else {
        this.systemDisk = null;
        this._visitables.get("systemDisk").remove(this.systemDisk);
    }
    return (A) this;
  }
  
  public A withTag(List<Tag> tag) {
    if (this.tag != null) {
      this._visitables.get("tag").clear();
    }
    if (tag != null) {
        this.tag = new ArrayList();
        for (Tag item : tag) {
          this.addToTag(item);
        }
    } else {
      this.tag = null;
    }
    return (A) this;
  }
  
  public A withTag(Tag... tag) {
    if (this.tag != null) {
        this.tag.clear();
        _visitables.remove("tag");
    }
    if (tag != null) {
      for (Tag item : tag) {
        this.addToTag(item);
      }
    }
    return (A) this;
  }
  
  public A withTenancy(String tenancy) {
    this.tenancy = tenancy;
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
  
  public A withVSwitch(AlibabaResourceReference vSwitch) {
    this._visitables.remove("vSwitch");
    if (vSwitch != null) {
        this.vSwitch = new AlibabaResourceReferenceBuilder(vSwitch);
        this._visitables.get("vSwitch").add(this.vSwitch);
    } else {
        this.vSwitch = null;
        this._visitables.get("vSwitch").remove(this.vSwitch);
    }
    return (A) this;
  }
  
  public A withVpcId(String vpcId) {
    this.vpcId = vpcId;
    return (A) this;
  }
  
  public A withZoneId(String zoneId) {
    this.zoneId = zoneId;
    return (A) this;
  }
  public class BandwidthNested<N> extends BandwidthPropertiesFluent<BandwidthNested<N>> implements Nested<N>{
  
    BandwidthPropertiesBuilder builder;
  
    BandwidthNested(BandwidthProperties item) {
      this.builder = new BandwidthPropertiesBuilder(this, item);
    }
  
    public N and() {
      return (N) AlibabaCloudMachineProviderConfigFluent.this.withBandwidth(builder.build());
    }
    
    public N endBandwidth() {
      return and();
    }
    
  }
  public class CredentialsSecretNested<N> extends LocalObjectReferenceFluent<CredentialsSecretNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    CredentialsSecretNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) AlibabaCloudMachineProviderConfigFluent.this.withCredentialsSecret(builder.build());
    }
    
    public N endCredentialsSecret() {
      return and();
    }
    
  }
  public class DataDiskNested<N> extends DataDiskPropertiesFluent<DataDiskNested<N>> implements Nested<N>{
  
    DataDiskPropertiesBuilder builder;
    int index;
  
    DataDiskNested(int index,DataDiskProperties item) {
      this.index = index;
      this.builder = new DataDiskPropertiesBuilder(this, item);
    }
  
    public N and() {
      return (N) AlibabaCloudMachineProviderConfigFluent.this.setToDataDisk(index, builder.build());
    }
    
    public N endDataDisk() {
      return and();
    }
    
  }
  public class MetadataNested<N> extends ObjectMetaFluent<MetadataNested<N>> implements Nested<N>{
  
    ObjectMetaBuilder builder;
  
    MetadataNested(ObjectMeta item) {
      this.builder = new ObjectMetaBuilder(this, item);
    }
  
    public N and() {
      return (N) AlibabaCloudMachineProviderConfigFluent.this.withMetadata(builder.build());
    }
    
    public N endMetadata() {
      return and();
    }
    
  }
  public class ResourceGroupNested<N> extends AlibabaResourceReferenceFluent<ResourceGroupNested<N>> implements Nested<N>{
  
    AlibabaResourceReferenceBuilder builder;
  
    ResourceGroupNested(AlibabaResourceReference item) {
      this.builder = new AlibabaResourceReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) AlibabaCloudMachineProviderConfigFluent.this.withResourceGroup(builder.build());
    }
    
    public N endResourceGroup() {
      return and();
    }
    
  }
  public class SecurityGroupsNested<N> extends AlibabaResourceReferenceFluent<SecurityGroupsNested<N>> implements Nested<N>{
  
    AlibabaResourceReferenceBuilder builder;
    int index;
  
    SecurityGroupsNested(int index,AlibabaResourceReference item) {
      this.index = index;
      this.builder = new AlibabaResourceReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) AlibabaCloudMachineProviderConfigFluent.this.setToSecurityGroups(index, builder.build());
    }
    
    public N endSecurityGroup() {
      return and();
    }
    
  }
  public class SystemDiskNested<N> extends SystemDiskPropertiesFluent<SystemDiskNested<N>> implements Nested<N>{
  
    SystemDiskPropertiesBuilder builder;
  
    SystemDiskNested(SystemDiskProperties item) {
      this.builder = new SystemDiskPropertiesBuilder(this, item);
    }
  
    public N and() {
      return (N) AlibabaCloudMachineProviderConfigFluent.this.withSystemDisk(builder.build());
    }
    
    public N endSystemDisk() {
      return and();
    }
    
  }
  public class TagNested<N> extends TagFluent<TagNested<N>> implements Nested<N>{
  
    TagBuilder builder;
    int index;
  
    TagNested(int index,Tag item) {
      this.index = index;
      this.builder = new TagBuilder(this, item);
    }
  
    public N and() {
      return (N) AlibabaCloudMachineProviderConfigFluent.this.setToTag(index, builder.build());
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
      return (N) AlibabaCloudMachineProviderConfigFluent.this.withUserDataSecret(builder.build());
    }
    
    public N endUserDataSecret() {
      return and();
    }
    
  }
  public class VSwitchNested<N> extends AlibabaResourceReferenceFluent<VSwitchNested<N>> implements Nested<N>{
  
    AlibabaResourceReferenceBuilder builder;
  
    VSwitchNested(AlibabaResourceReference item) {
      this.builder = new AlibabaResourceReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) AlibabaCloudMachineProviderConfigFluent.this.withVSwitch(builder.build());
    }
    
    public N endVSwitch() {
      return and();
    }
    
  }
}