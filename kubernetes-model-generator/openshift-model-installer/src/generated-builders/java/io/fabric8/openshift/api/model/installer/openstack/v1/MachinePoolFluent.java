package io.fabric8.openshift.api.model.installer.openstack.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class MachinePoolFluent<A extends io.fabric8.openshift.api.model.installer.openstack.v1.MachinePoolFluent<A>> extends BaseFluent<A>{

  private List<String> additionalNetworkIDs = new ArrayList<String>();
  private Map<String,Object> additionalProperties;
  private List<String> additionalSecurityGroupIDs = new ArrayList<String>();
  private RootVolumeBuilder rootVolume;
  private String serverGroupPolicy;
  private String type;
  private List<String> zones = new ArrayList<String>();

  public MachinePoolFluent() {
  }
  
  public MachinePoolFluent(MachinePool instance) {
    this.copyInstance(instance);
  }

  public A addAllToAdditionalNetworkIDs(Collection<String> items) {
    if (this.additionalNetworkIDs == null) {
      this.additionalNetworkIDs = new ArrayList();
    }
    for (String item : items) {
      this.additionalNetworkIDs.add(item);
    }
    return (A) this;
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
  
  public A addAllToZones(Collection<String> items) {
    if (this.zones == null) {
      this.zones = new ArrayList();
    }
    for (String item : items) {
      this.zones.add(item);
    }
    return (A) this;
  }
  
  public A addToAdditionalNetworkIDs(String... items) {
    if (this.additionalNetworkIDs == null) {
      this.additionalNetworkIDs = new ArrayList();
    }
    for (String item : items) {
      this.additionalNetworkIDs.add(item);
    }
    return (A) this;
  }
  
  public A addToAdditionalNetworkIDs(int index,String item) {
    if (this.additionalNetworkIDs == null) {
      this.additionalNetworkIDs = new ArrayList();
    }
    this.additionalNetworkIDs.add(index, item);
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
  
  public RootVolume buildRootVolume() {
    return this.rootVolume != null ? this.rootVolume.build() : null;
  }
  
  protected void copyInstance(MachinePool instance) {
    instance = instance != null ? instance : new MachinePool();
    if (instance != null) {
        this.withAdditionalNetworkIDs(instance.getAdditionalNetworkIDs());
        this.withAdditionalSecurityGroupIDs(instance.getAdditionalSecurityGroupIDs());
        this.withRootVolume(instance.getRootVolume());
        this.withServerGroupPolicy(instance.getServerGroupPolicy());
        this.withType(instance.getType());
        this.withZones(instance.getZones());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RootVolumeNested<A> editOrNewRootVolume() {
    return this.withNewRootVolumeLike(Optional.ofNullable(this.buildRootVolume()).orElse(new RootVolumeBuilder().build()));
  }
  
  public RootVolumeNested<A> editOrNewRootVolumeLike(RootVolume item) {
    return this.withNewRootVolumeLike(Optional.ofNullable(this.buildRootVolume()).orElse(item));
  }
  
  public RootVolumeNested<A> editRootVolume() {
    return this.withNewRootVolumeLike(Optional.ofNullable(this.buildRootVolume()).orElse(null));
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
    MachinePoolFluent that = (MachinePoolFluent) o;
    if (!(Objects.equals(additionalNetworkIDs, that.additionalNetworkIDs))) {
      return false;
    }
    if (!(Objects.equals(additionalSecurityGroupIDs, that.additionalSecurityGroupIDs))) {
      return false;
    }
    if (!(Objects.equals(rootVolume, that.rootVolume))) {
      return false;
    }
    if (!(Objects.equals(serverGroupPolicy, that.serverGroupPolicy))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
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
  
  public String getAdditionalNetworkID(int index) {
    return this.additionalNetworkIDs.get(index);
  }
  
  public List<String> getAdditionalNetworkIDs() {
    return this.additionalNetworkIDs;
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
  
  public String getFirstAdditionalNetworkID() {
    return this.additionalNetworkIDs.get(0);
  }
  
  public String getFirstAdditionalSecurityGroupID() {
    return this.additionalSecurityGroupIDs.get(0);
  }
  
  public String getFirstZone() {
    return this.zones.get(0);
  }
  
  public String getLastAdditionalNetworkID() {
    return this.additionalNetworkIDs.get(additionalNetworkIDs.size() - 1);
  }
  
  public String getLastAdditionalSecurityGroupID() {
    return this.additionalSecurityGroupIDs.get(additionalSecurityGroupIDs.size() - 1);
  }
  
  public String getLastZone() {
    return this.zones.get(zones.size() - 1);
  }
  
  public String getMatchingAdditionalNetworkID(Predicate<String> predicate) {
      for (String item : additionalNetworkIDs) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingAdditionalSecurityGroupID(Predicate<String> predicate) {
      for (String item : additionalSecurityGroupIDs) {
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
  
  public String getServerGroupPolicy() {
    return this.serverGroupPolicy;
  }
  
  public String getType() {
    return this.type;
  }
  
  public String getZone(int index) {
    return this.zones.get(index);
  }
  
  public List<String> getZones() {
    return this.zones;
  }
  
  public boolean hasAdditionalNetworkIDs() {
    return this.additionalNetworkIDs != null && !(this.additionalNetworkIDs.isEmpty());
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAdditionalSecurityGroupIDs() {
    return this.additionalSecurityGroupIDs != null && !(this.additionalSecurityGroupIDs.isEmpty());
  }
  
  public boolean hasMatchingAdditionalNetworkID(Predicate<String> predicate) {
      for (String item : additionalNetworkIDs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingAdditionalSecurityGroupID(Predicate<String> predicate) {
      for (String item : additionalSecurityGroupIDs) {
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
  
  public boolean hasRootVolume() {
    return this.rootVolume != null;
  }
  
  public boolean hasServerGroupPolicy() {
    return this.serverGroupPolicy != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public boolean hasZones() {
    return this.zones != null && !(this.zones.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(additionalNetworkIDs, additionalSecurityGroupIDs, rootVolume, serverGroupPolicy, type, zones, additionalProperties);
  }
  
  public A removeAllFromAdditionalNetworkIDs(Collection<String> items) {
    if (this.additionalNetworkIDs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.additionalNetworkIDs.remove(item);
    }
    return (A) this;
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
  
  public A removeAllFromZones(Collection<String> items) {
    if (this.zones == null) {
      return (A) this;
    }
    for (String item : items) {
      this.zones.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalNetworkIDs(String... items) {
    if (this.additionalNetworkIDs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.additionalNetworkIDs.remove(item);
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
  
  public A removeFromZones(String... items) {
    if (this.zones == null) {
      return (A) this;
    }
    for (String item : items) {
      this.zones.remove(item);
    }
    return (A) this;
  }
  
  public A setToAdditionalNetworkIDs(int index,String item) {
    if (this.additionalNetworkIDs == null) {
      this.additionalNetworkIDs = new ArrayList();
    }
    this.additionalNetworkIDs.set(index, item);
    return (A) this;
  }
  
  public A setToAdditionalSecurityGroupIDs(int index,String item) {
    if (this.additionalSecurityGroupIDs == null) {
      this.additionalSecurityGroupIDs = new ArrayList();
    }
    this.additionalSecurityGroupIDs.set(index, item);
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
    if (!(additionalNetworkIDs == null) && !(additionalNetworkIDs.isEmpty())) {
        sb.append("additionalNetworkIDs:");
        sb.append(additionalNetworkIDs);
        sb.append(",");
    }
    if (!(additionalSecurityGroupIDs == null) && !(additionalSecurityGroupIDs.isEmpty())) {
        sb.append("additionalSecurityGroupIDs:");
        sb.append(additionalSecurityGroupIDs);
        sb.append(",");
    }
    if (!(rootVolume == null)) {
        sb.append("rootVolume:");
        sb.append(rootVolume);
        sb.append(",");
    }
    if (!(serverGroupPolicy == null)) {
        sb.append("serverGroupPolicy:");
        sb.append(serverGroupPolicy);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
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
  
  public A withAdditionalNetworkIDs(List<String> additionalNetworkIDs) {
    if (additionalNetworkIDs != null) {
        this.additionalNetworkIDs = new ArrayList();
        for (String item : additionalNetworkIDs) {
          this.addToAdditionalNetworkIDs(item);
        }
    } else {
      this.additionalNetworkIDs = null;
    }
    return (A) this;
  }
  
  public A withAdditionalNetworkIDs(String... additionalNetworkIDs) {
    if (this.additionalNetworkIDs != null) {
        this.additionalNetworkIDs.clear();
        _visitables.remove("additionalNetworkIDs");
    }
    if (additionalNetworkIDs != null) {
      for (String item : additionalNetworkIDs) {
        this.addToAdditionalNetworkIDs(item);
      }
    }
    return (A) this;
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
  
  public RootVolumeNested<A> withNewRootVolume() {
    return new RootVolumeNested(null);
  }
  
  public RootVolumeNested<A> withNewRootVolumeLike(RootVolume item) {
    return new RootVolumeNested(item);
  }
  
  public A withRootVolume(RootVolume rootVolume) {
    this._visitables.remove("rootVolume");
    if (rootVolume != null) {
        this.rootVolume = new RootVolumeBuilder(rootVolume);
        this._visitables.get("rootVolume").add(this.rootVolume);
    } else {
        this.rootVolume = null;
        this._visitables.get("rootVolume").remove(this.rootVolume);
    }
    return (A) this;
  }
  
  public A withServerGroupPolicy(String serverGroupPolicy) {
    this.serverGroupPolicy = serverGroupPolicy;
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
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
  public class RootVolumeNested<N> extends RootVolumeFluent<RootVolumeNested<N>> implements Nested<N>{
  
    RootVolumeBuilder builder;
  
    RootVolumeNested(RootVolume item) {
      this.builder = new RootVolumeBuilder(this, item);
    }
  
    public N and() {
      return (N) MachinePoolFluent.this.withRootVolume(builder.build());
    }
    
    public N endRootVolume() {
      return and();
    }
    
  }
}