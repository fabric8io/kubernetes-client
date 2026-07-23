package io.fabric8.openshift.api.model.hive.aws.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
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
public class MachinePoolPlatformFluent<A extends io.fabric8.openshift.api.model.hive.aws.v1.MachinePoolPlatformFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> additionalSecurityGroupIDs = new ArrayList<String>();
  private EC2MetadataBuilder metadataService;
  private EC2RootVolumeBuilder rootVolume;
  private SpotMarketOptionsBuilder spotMarketOptions;
  private List<String> subnets = new ArrayList<String>();
  private String type;
  private Map<String,String> userTags;
  private List<String> zones = new ArrayList<String>();

  public MachinePoolPlatformFluent() {
  }
  
  public MachinePoolPlatformFluent(MachinePoolPlatform instance) {
    this.copyInstance(instance);
  }

  public A addAllToAdditionalSecurityGroupIDs(Collection<String> items) {
    if (this.additionalSecurityGroupIDs == null) {
      this.additionalSecurityGroupIDs = new ArrayList();
    }
    for (String item : items) {
      this.additionalSecurityGroupIDs.add(item);
    }
    return (A) this;
  }
  
  public A addAllToSubnets(Collection<String> items) {
    if (this.subnets == null) {
      this.subnets = new ArrayList();
    }
    for (String item : items) {
      this.subnets.add(item);
    }
    return (A) this;
  }
  
  public A addAllToZones(Collection<String> items) {
    if (this.zones == null) {
      this.zones = new ArrayList();
    }
    for (String item : items) {
      this.zones.add(item);
    }
    return (A) this;
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
  
  public A addToAdditionalSecurityGroupIDs(String... items) {
    if (this.additionalSecurityGroupIDs == null) {
      this.additionalSecurityGroupIDs = new ArrayList();
    }
    for (String item : items) {
      this.additionalSecurityGroupIDs.add(item);
    }
    return (A) this;
  }
  
  public A addToAdditionalSecurityGroupIDs(int index,String item) {
    if (this.additionalSecurityGroupIDs == null) {
      this.additionalSecurityGroupIDs = new ArrayList();
    }
    this.additionalSecurityGroupIDs.add(index, item);
    return (A) this;
  }
  
  public A addToSubnets(String... items) {
    if (this.subnets == null) {
      this.subnets = new ArrayList();
    }
    for (String item : items) {
      this.subnets.add(item);
    }
    return (A) this;
  }
  
  public A addToSubnets(int index,String item) {
    if (this.subnets == null) {
      this.subnets = new ArrayList();
    }
    this.subnets.add(index, item);
    return (A) this;
  }
  
  public A addToUserTags(Map<String,String> map) {
    if (this.userTags == null && map != null) {
      this.userTags = new LinkedHashMap();
    }
    if (map != null) {
      this.userTags.putAll(map);
    }
    return (A) this;
  }
  
  public A addToUserTags(String key,String value) {
    if (this.userTags == null && key != null && value != null) {
      this.userTags = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.userTags.put(key, value);
    }
    return (A) this;
  }
  
  public A addToZones(String... items) {
    if (this.zones == null) {
      this.zones = new ArrayList();
    }
    for (String item : items) {
      this.zones.add(item);
    }
    return (A) this;
  }
  
  public A addToZones(int index,String item) {
    if (this.zones == null) {
      this.zones = new ArrayList();
    }
    this.zones.add(index, item);
    return (A) this;
  }
  
  public EC2Metadata buildMetadataService() {
    return this.metadataService != null ? this.metadataService.build() : null;
  }
  
  public EC2RootVolume buildRootVolume() {
    return this.rootVolume != null ? this.rootVolume.build() : null;
  }
  
  public SpotMarketOptions buildSpotMarketOptions() {
    return this.spotMarketOptions != null ? this.spotMarketOptions.build() : null;
  }
  
  protected void copyInstance(MachinePoolPlatform instance) {
    instance = instance != null ? instance : new MachinePoolPlatform();
    if (instance != null) {
        this.withAdditionalSecurityGroupIDs(instance.getAdditionalSecurityGroupIDs());
        this.withMetadataService(instance.getMetadataService());
        this.withRootVolume(instance.getRootVolume());
        this.withSpotMarketOptions(instance.getSpotMarketOptions());
        this.withSubnets(instance.getSubnets());
        this.withType(instance.getType());
        this.withUserTags(instance.getUserTags());
        this.withZones(instance.getZones());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MetadataServiceNested<A> editMetadataService() {
    return this.withNewMetadataServiceLike(Optional.ofNullable(this.buildMetadataService()).orElse(null));
  }
  
  public MetadataServiceNested<A> editOrNewMetadataService() {
    return this.withNewMetadataServiceLike(Optional.ofNullable(this.buildMetadataService()).orElse(new EC2MetadataBuilder().build()));
  }
  
  public MetadataServiceNested<A> editOrNewMetadataServiceLike(EC2Metadata item) {
    return this.withNewMetadataServiceLike(Optional.ofNullable(this.buildMetadataService()).orElse(item));
  }
  
  public RootVolumeNested<A> editOrNewRootVolume() {
    return this.withNewRootVolumeLike(Optional.ofNullable(this.buildRootVolume()).orElse(new EC2RootVolumeBuilder().build()));
  }
  
  public RootVolumeNested<A> editOrNewRootVolumeLike(EC2RootVolume item) {
    return this.withNewRootVolumeLike(Optional.ofNullable(this.buildRootVolume()).orElse(item));
  }
  
  public SpotMarketOptionsNested<A> editOrNewSpotMarketOptions() {
    return this.withNewSpotMarketOptionsLike(Optional.ofNullable(this.buildSpotMarketOptions()).orElse(new SpotMarketOptionsBuilder().build()));
  }
  
  public SpotMarketOptionsNested<A> editOrNewSpotMarketOptionsLike(SpotMarketOptions item) {
    return this.withNewSpotMarketOptionsLike(Optional.ofNullable(this.buildSpotMarketOptions()).orElse(item));
  }
  
  public RootVolumeNested<A> editRootVolume() {
    return this.withNewRootVolumeLike(Optional.ofNullable(this.buildRootVolume()).orElse(null));
  }
  
  public SpotMarketOptionsNested<A> editSpotMarketOptions() {
    return this.withNewSpotMarketOptionsLike(Optional.ofNullable(this.buildSpotMarketOptions()).orElse(null));
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
    MachinePoolPlatformFluent that = (MachinePoolPlatformFluent) o;
    if (!(Objects.equals(additionalSecurityGroupIDs, that.additionalSecurityGroupIDs))) {
      return false;
    }
    if (!(Objects.equals(metadataService, that.metadataService))) {
      return false;
    }
    if (!(Objects.equals(rootVolume, that.rootVolume))) {
      return false;
    }
    if (!(Objects.equals(spotMarketOptions, that.spotMarketOptions))) {
      return false;
    }
    if (!(Objects.equals(subnets, that.subnets))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
      return false;
    }
    if (!(Objects.equals(userTags, that.userTags))) {
      return false;
    }
    if (!(Objects.equals(zones, that.zones))) {
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
  
  public String getAdditionalSecurityGroupID(int index) {
    return this.additionalSecurityGroupIDs.get(index);
  }
  
  public List<String> getAdditionalSecurityGroupIDs() {
    return this.additionalSecurityGroupIDs;
  }
  
  public String getFirstAdditionalSecurityGroupID() {
    return this.additionalSecurityGroupIDs.get(0);
  }
  
  public String getFirstSubnet() {
    return this.subnets.get(0);
  }
  
  public String getFirstZone() {
    return this.zones.get(0);
  }
  
  public String getLastAdditionalSecurityGroupID() {
    return this.additionalSecurityGroupIDs.get(additionalSecurityGroupIDs.size() - 1);
  }
  
  public String getLastSubnet() {
    return this.subnets.get(subnets.size() - 1);
  }
  
  public String getLastZone() {
    return this.zones.get(zones.size() - 1);
  }
  
  public String getMatchingAdditionalSecurityGroupID(Predicate<String> predicate) {
      for (String item : additionalSecurityGroupIDs) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingSubnet(Predicate<String> predicate) {
      for (String item : subnets) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingZone(Predicate<String> predicate) {
      for (String item : zones) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getSubnet(int index) {
    return this.subnets.get(index);
  }
  
  public List<String> getSubnets() {
    return this.subnets;
  }
  
  public String getType() {
    return this.type;
  }
  
  public Map<String,String> getUserTags() {
    return this.userTags;
  }
  
  public String getZone(int index) {
    return this.zones.get(index);
  }
  
  public List<String> getZones() {
    return this.zones;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAdditionalSecurityGroupIDs() {
    return this.additionalSecurityGroupIDs != null && !(this.additionalSecurityGroupIDs.isEmpty());
  }
  
  public boolean hasMatchingAdditionalSecurityGroupID(Predicate<String> predicate) {
      for (String item : additionalSecurityGroupIDs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingSubnet(Predicate<String> predicate) {
      for (String item : subnets) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingZone(Predicate<String> predicate) {
      for (String item : zones) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMetadataService() {
    return this.metadataService != null;
  }
  
  public boolean hasRootVolume() {
    return this.rootVolume != null;
  }
  
  public boolean hasSpotMarketOptions() {
    return this.spotMarketOptions != null;
  }
  
  public boolean hasSubnets() {
    return this.subnets != null && !(this.subnets.isEmpty());
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public boolean hasUserTags() {
    return this.userTags != null;
  }
  
  public boolean hasZones() {
    return this.zones != null && !(this.zones.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(additionalSecurityGroupIDs, metadataService, rootVolume, spotMarketOptions, subnets, type, userTags, zones, additionalProperties);
  }
  
  public A removeAllFromAdditionalSecurityGroupIDs(Collection<String> items) {
    if (this.additionalSecurityGroupIDs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.additionalSecurityGroupIDs.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromSubnets(Collection<String> items) {
    if (this.subnets == null) {
      return (A) this;
    }
    for (String item : items) {
      this.subnets.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromZones(Collection<String> items) {
    if (this.zones == null) {
      return (A) this;
    }
    for (String item : items) {
      this.zones.remove(item);
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
  
  public A removeFromAdditionalSecurityGroupIDs(String... items) {
    if (this.additionalSecurityGroupIDs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.additionalSecurityGroupIDs.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromSubnets(String... items) {
    if (this.subnets == null) {
      return (A) this;
    }
    for (String item : items) {
      this.subnets.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromUserTags(String key) {
    if (this.userTags == null) {
      return (A) this;
    }
    if (key != null && this.userTags != null) {
      this.userTags.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromUserTags(Map<String,String> map) {
    if (this.userTags == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.userTags != null) {
          this.userTags.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromZones(String... items) {
    if (this.zones == null) {
      return (A) this;
    }
    for (String item : items) {
      this.zones.remove(item);
    }
    return (A) this;
  }
  
  public A setToAdditionalSecurityGroupIDs(int index,String item) {
    if (this.additionalSecurityGroupIDs == null) {
      this.additionalSecurityGroupIDs = new ArrayList();
    }
    this.additionalSecurityGroupIDs.set(index, item);
    return (A) this;
  }
  
  public A setToSubnets(int index,String item) {
    if (this.subnets == null) {
      this.subnets = new ArrayList();
    }
    this.subnets.set(index, item);
    return (A) this;
  }
  
  public A setToZones(int index,String item) {
    if (this.zones == null) {
      this.zones = new ArrayList();
    }
    this.zones.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(additionalSecurityGroupIDs == null) && !(additionalSecurityGroupIDs.isEmpty())) {
        sb.append("additionalSecurityGroupIDs:");
        sb.append(additionalSecurityGroupIDs);
        sb.append(",");
    }
    if (!(metadataService == null)) {
        sb.append("metadataService:");
        sb.append(metadataService);
        sb.append(",");
    }
    if (!(rootVolume == null)) {
        sb.append("rootVolume:");
        sb.append(rootVolume);
        sb.append(",");
    }
    if (!(spotMarketOptions == null)) {
        sb.append("spotMarketOptions:");
        sb.append(spotMarketOptions);
        sb.append(",");
    }
    if (!(subnets == null) && !(subnets.isEmpty())) {
        sb.append("subnets:");
        sb.append(subnets);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
        sb.append(",");
    }
    if (!(userTags == null) && !(userTags.isEmpty())) {
        sb.append("userTags:");
        sb.append(userTags);
        sb.append(",");
    }
    if (!(zones == null) && !(zones.isEmpty())) {
        sb.append("zones:");
        sb.append(zones);
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
  
  public A withAdditionalSecurityGroupIDs(List<String> additionalSecurityGroupIDs) {
    if (additionalSecurityGroupIDs != null) {
        this.additionalSecurityGroupIDs = new ArrayList();
        for (String item : additionalSecurityGroupIDs) {
          this.addToAdditionalSecurityGroupIDs(item);
        }
    } else {
      this.additionalSecurityGroupIDs = null;
    }
    return (A) this;
  }
  
  public A withAdditionalSecurityGroupIDs(String... additionalSecurityGroupIDs) {
    if (this.additionalSecurityGroupIDs != null) {
        this.additionalSecurityGroupIDs.clear();
        _visitables.remove("additionalSecurityGroupIDs");
    }
    if (additionalSecurityGroupIDs != null) {
      for (String item : additionalSecurityGroupIDs) {
        this.addToAdditionalSecurityGroupIDs(item);
      }
    }
    return (A) this;
  }
  
  public A withMetadataService(EC2Metadata metadataService) {
    this._visitables.remove("metadataService");
    if (metadataService != null) {
        this.metadataService = new EC2MetadataBuilder(metadataService);
        this._visitables.get("metadataService").add(this.metadataService);
    } else {
        this.metadataService = null;
        this._visitables.get("metadataService").remove(this.metadataService);
    }
    return (A) this;
  }
  
  public MetadataServiceNested<A> withNewMetadataService() {
    return new MetadataServiceNested(null);
  }
  
  public A withNewMetadataService(String authentication) {
    return (A) this.withMetadataService(new EC2Metadata(authentication));
  }
  
  public MetadataServiceNested<A> withNewMetadataServiceLike(EC2Metadata item) {
    return new MetadataServiceNested(item);
  }
  
  public RootVolumeNested<A> withNewRootVolume() {
    return new RootVolumeNested(null);
  }
  
  public A withNewRootVolume(Integer iops,String kmsKeyARN,Integer size,String type) {
    return (A) this.withRootVolume(new EC2RootVolume(iops, kmsKeyARN, size, type));
  }
  
  public RootVolumeNested<A> withNewRootVolumeLike(EC2RootVolume item) {
    return new RootVolumeNested(item);
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
  
  public A withRootVolume(EC2RootVolume rootVolume) {
    this._visitables.remove("rootVolume");
    if (rootVolume != null) {
        this.rootVolume = new EC2RootVolumeBuilder(rootVolume);
        this._visitables.get("rootVolume").add(this.rootVolume);
    } else {
        this.rootVolume = null;
        this._visitables.get("rootVolume").remove(this.rootVolume);
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
  
  public A withSubnets(List<String> subnets) {
    if (subnets != null) {
        this.subnets = new ArrayList();
        for (String item : subnets) {
          this.addToSubnets(item);
        }
    } else {
      this.subnets = null;
    }
    return (A) this;
  }
  
  public A withSubnets(String... subnets) {
    if (this.subnets != null) {
        this.subnets.clear();
        _visitables.remove("subnets");
    }
    if (subnets != null) {
      for (String item : subnets) {
        this.addToSubnets(item);
      }
    }
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  
  public <K,V>A withUserTags(Map<String,String> userTags) {
    if (userTags == null) {
      this.userTags = null;
    } else {
      this.userTags = new LinkedHashMap(userTags);
    }
    return (A) this;
  }
  
  public A withZones(List<String> zones) {
    if (zones != null) {
        this.zones = new ArrayList();
        for (String item : zones) {
          this.addToZones(item);
        }
    } else {
      this.zones = null;
    }
    return (A) this;
  }
  
  public A withZones(String... zones) {
    if (this.zones != null) {
        this.zones.clear();
        _visitables.remove("zones");
    }
    if (zones != null) {
      for (String item : zones) {
        this.addToZones(item);
      }
    }
    return (A) this;
  }
  public class MetadataServiceNested<N> extends EC2MetadataFluent<MetadataServiceNested<N>> implements Nested<N>{
  
    EC2MetadataBuilder builder;
  
    MetadataServiceNested(EC2Metadata item) {
      this.builder = new EC2MetadataBuilder(this, item);
    }
  
    public N and() {
      return (N) MachinePoolPlatformFluent.this.withMetadataService(builder.build());
    }
    
    public N endMetadataService() {
      return and();
    }
    
  }
  public class RootVolumeNested<N> extends EC2RootVolumeFluent<RootVolumeNested<N>> implements Nested<N>{
  
    EC2RootVolumeBuilder builder;
  
    RootVolumeNested(EC2RootVolume item) {
      this.builder = new EC2RootVolumeBuilder(this, item);
    }
  
    public N and() {
      return (N) MachinePoolPlatformFluent.this.withRootVolume(builder.build());
    }
    
    public N endRootVolume() {
      return and();
    }
    
  }
  public class SpotMarketOptionsNested<N> extends SpotMarketOptionsFluent<SpotMarketOptionsNested<N>> implements Nested<N>{
  
    SpotMarketOptionsBuilder builder;
  
    SpotMarketOptionsNested(SpotMarketOptions item) {
      this.builder = new SpotMarketOptionsBuilder(this, item);
    }
  
    public N and() {
      return (N) MachinePoolPlatformFluent.this.withSpotMarketOptions(builder.build());
    }
    
    public N endSpotMarketOptions() {
      return and();
    }
    
  }
}