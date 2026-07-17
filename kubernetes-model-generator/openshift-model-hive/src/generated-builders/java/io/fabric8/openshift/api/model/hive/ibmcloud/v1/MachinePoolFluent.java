package io.fabric8.openshift.api.model.hive.ibmcloud.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class MachinePoolFluent<A extends io.fabric8.openshift.api.model.hive.ibmcloud.v1.MachinePoolFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private BootVolumeBuilder bootVolume;
  private ArrayList<DedicatedHostBuilder> dedicatedHosts = new ArrayList<DedicatedHostBuilder>();
  private String type;
  private List<String> zones = new ArrayList<String>();

  public MachinePoolFluent() {
  }
  
  public MachinePoolFluent(MachinePool instance) {
    this.copyInstance(instance);
  }

  public A addAllToDedicatedHosts(Collection<DedicatedHost> items) {
    if (this.dedicatedHosts == null) {
      this.dedicatedHosts = new ArrayList();
    }
    for (DedicatedHost item : items) {
        DedicatedHostBuilder builder = new DedicatedHostBuilder(item);
        _visitables.get("dedicatedHosts").add(builder);
        this.dedicatedHosts.add(builder);
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
  
  public DedicatedHostsNested<A> addNewDedicatedHost() {
    return new DedicatedHostsNested(-1, null);
  }
  
  public A addNewDedicatedHost(String name,String profile) {
    return (A) this.addToDedicatedHosts(new DedicatedHost(name, profile));
  }
  
  public DedicatedHostsNested<A> addNewDedicatedHostLike(DedicatedHost item) {
    return new DedicatedHostsNested(-1, item);
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
  
  public A addToDedicatedHosts(DedicatedHost... items) {
    if (this.dedicatedHosts == null) {
      this.dedicatedHosts = new ArrayList();
    }
    for (DedicatedHost item : items) {
        DedicatedHostBuilder builder = new DedicatedHostBuilder(item);
        _visitables.get("dedicatedHosts").add(builder);
        this.dedicatedHosts.add(builder);
    }
    return (A) this;
  }
  
  public A addToDedicatedHosts(int index,DedicatedHost item) {
    if (this.dedicatedHosts == null) {
      this.dedicatedHosts = new ArrayList();
    }
    DedicatedHostBuilder builder = new DedicatedHostBuilder(item);
    if (index < 0 || index >= dedicatedHosts.size()) {
        _visitables.get("dedicatedHosts").add(builder);
        dedicatedHosts.add(builder);
    } else {
        _visitables.get("dedicatedHosts").add(builder);
        dedicatedHosts.add(index, builder);
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
  
  public BootVolume buildBootVolume() {
    return this.bootVolume != null ? this.bootVolume.build() : null;
  }
  
  public DedicatedHost buildDedicatedHost(int index) {
    return this.dedicatedHosts.get(index).build();
  }
  
  public List<DedicatedHost> buildDedicatedHosts() {
    return this.dedicatedHosts != null ? build(dedicatedHosts) : null;
  }
  
  public DedicatedHost buildFirstDedicatedHost() {
    return this.dedicatedHosts.get(0).build();
  }
  
  public DedicatedHost buildLastDedicatedHost() {
    return this.dedicatedHosts.get(dedicatedHosts.size() - 1).build();
  }
  
  public DedicatedHost buildMatchingDedicatedHost(Predicate<DedicatedHostBuilder> predicate) {
      for (DedicatedHostBuilder item : dedicatedHosts) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(MachinePool instance) {
    instance = instance != null ? instance : new MachinePool();
    if (instance != null) {
        this.withBootVolume(instance.getBootVolume());
        this.withDedicatedHosts(instance.getDedicatedHosts());
        this.withType(instance.getType());
        this.withZones(instance.getZones());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public BootVolumeNested<A> editBootVolume() {
    return this.withNewBootVolumeLike(Optional.ofNullable(this.buildBootVolume()).orElse(null));
  }
  
  public DedicatedHostsNested<A> editDedicatedHost(int index) {
    if (dedicatedHosts.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "dedicatedHosts"));
    }
    return this.setNewDedicatedHostLike(index, this.buildDedicatedHost(index));
  }
  
  public DedicatedHostsNested<A> editFirstDedicatedHost() {
    if (dedicatedHosts.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "dedicatedHosts"));
    }
    return this.setNewDedicatedHostLike(0, this.buildDedicatedHost(0));
  }
  
  public DedicatedHostsNested<A> editLastDedicatedHost() {
    int index = dedicatedHosts.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "dedicatedHosts"));
    }
    return this.setNewDedicatedHostLike(index, this.buildDedicatedHost(index));
  }
  
  public DedicatedHostsNested<A> editMatchingDedicatedHost(Predicate<DedicatedHostBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < dedicatedHosts.size();i++) {
      if (predicate.test(dedicatedHosts.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "dedicatedHosts"));
    }
    return this.setNewDedicatedHostLike(index, this.buildDedicatedHost(index));
  }
  
  public BootVolumeNested<A> editOrNewBootVolume() {
    return this.withNewBootVolumeLike(Optional.ofNullable(this.buildBootVolume()).orElse(new BootVolumeBuilder().build()));
  }
  
  public BootVolumeNested<A> editOrNewBootVolumeLike(BootVolume item) {
    return this.withNewBootVolumeLike(Optional.ofNullable(this.buildBootVolume()).orElse(item));
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
    if (!(Objects.equals(bootVolume, that.bootVolume))) {
      return false;
    }
    if (!(Objects.equals(dedicatedHosts, that.dedicatedHosts))) {
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
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getFirstZone() {
    return this.zones.get(0);
  }
  
  public String getLastZone() {
    return this.zones.get(zones.size() - 1);
  }
  
  public String getMatchingZone(Predicate<String> predicate) {
      for (String item : zones) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBootVolume() {
    return this.bootVolume != null;
  }
  
  public boolean hasDedicatedHosts() {
    return this.dedicatedHosts != null && !(this.dedicatedHosts.isEmpty());
  }
  
  public boolean hasMatchingDedicatedHost(Predicate<DedicatedHostBuilder> predicate) {
      for (DedicatedHostBuilder item : dedicatedHosts) {
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
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public boolean hasZones() {
    return this.zones != null && !(this.zones.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(bootVolume, dedicatedHosts, type, zones, additionalProperties);
  }
  
  public A removeAllFromDedicatedHosts(Collection<DedicatedHost> items) {
    if (this.dedicatedHosts == null) {
      return (A) this;
    }
    for (DedicatedHost item : items) {
        DedicatedHostBuilder builder = new DedicatedHostBuilder(item);
        _visitables.get("dedicatedHosts").remove(builder);
        this.dedicatedHosts.remove(builder);
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
  
  public A removeFromDedicatedHosts(DedicatedHost... items) {
    if (this.dedicatedHosts == null) {
      return (A) this;
    }
    for (DedicatedHost item : items) {
        DedicatedHostBuilder builder = new DedicatedHostBuilder(item);
        _visitables.get("dedicatedHosts").remove(builder);
        this.dedicatedHosts.remove(builder);
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
  
  public A removeMatchingFromDedicatedHosts(Predicate<DedicatedHostBuilder> predicate) {
    if (dedicatedHosts == null) {
      return (A) this;
    }
    Iterator<DedicatedHostBuilder> each = dedicatedHosts.iterator();
    List visitables = _visitables.get("dedicatedHosts");
    while (each.hasNext()) {
        DedicatedHostBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public DedicatedHostsNested<A> setNewDedicatedHostLike(int index,DedicatedHost item) {
    return new DedicatedHostsNested(index, item);
  }
  
  public A setToDedicatedHosts(int index,DedicatedHost item) {
    if (this.dedicatedHosts == null) {
      this.dedicatedHosts = new ArrayList();
    }
    DedicatedHostBuilder builder = new DedicatedHostBuilder(item);
    if (index < 0 || index >= dedicatedHosts.size()) {
        _visitables.get("dedicatedHosts").add(builder);
        dedicatedHosts.add(builder);
    } else {
        _visitables.get("dedicatedHosts").add(builder);
        dedicatedHosts.set(index, builder);
    }
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
    if (!(bootVolume == null)) {
        sb.append("bootVolume:");
        sb.append(bootVolume);
        sb.append(",");
    }
    if (!(dedicatedHosts == null) && !(dedicatedHosts.isEmpty())) {
        sb.append("dedicatedHosts:");
        sb.append(dedicatedHosts);
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
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withBootVolume(BootVolume bootVolume) {
    this._visitables.remove("bootVolume");
    if (bootVolume != null) {
        this.bootVolume = new BootVolumeBuilder(bootVolume);
        this._visitables.get("bootVolume").add(this.bootVolume);
    } else {
        this.bootVolume = null;
        this._visitables.get("bootVolume").remove(this.bootVolume);
    }
    return (A) this;
  }
  
  public A withDedicatedHosts(List<DedicatedHost> dedicatedHosts) {
    if (this.dedicatedHosts != null) {
      this._visitables.get("dedicatedHosts").clear();
    }
    if (dedicatedHosts != null) {
        this.dedicatedHosts = new ArrayList();
        for (DedicatedHost item : dedicatedHosts) {
          this.addToDedicatedHosts(item);
        }
    } else {
      this.dedicatedHosts = null;
    }
    return (A) this;
  }
  
  public A withDedicatedHosts(DedicatedHost... dedicatedHosts) {
    if (this.dedicatedHosts != null) {
        this.dedicatedHosts.clear();
        _visitables.remove("dedicatedHosts");
    }
    if (dedicatedHosts != null) {
      for (DedicatedHost item : dedicatedHosts) {
        this.addToDedicatedHosts(item);
      }
    }
    return (A) this;
  }
  
  public BootVolumeNested<A> withNewBootVolume() {
    return new BootVolumeNested(null);
  }
  
  public A withNewBootVolume(String encryptionKey) {
    return (A) this.withBootVolume(new BootVolume(encryptionKey));
  }
  
  public BootVolumeNested<A> withNewBootVolumeLike(BootVolume item) {
    return new BootVolumeNested(item);
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
  public class BootVolumeNested<N> extends BootVolumeFluent<BootVolumeNested<N>> implements Nested<N>{
  
    BootVolumeBuilder builder;
  
    BootVolumeNested(BootVolume item) {
      this.builder = new BootVolumeBuilder(this, item);
    }
  
    public N and() {
      return (N) MachinePoolFluent.this.withBootVolume(builder.build());
    }
    
    public N endBootVolume() {
      return and();
    }
    
  }
  public class DedicatedHostsNested<N> extends DedicatedHostFluent<DedicatedHostsNested<N>> implements Nested<N>{
  
    DedicatedHostBuilder builder;
    int index;
  
    DedicatedHostsNested(int index,DedicatedHost item) {
      this.index = index;
      this.builder = new DedicatedHostBuilder(this, item);
    }
  
    public N and() {
      return (N) MachinePoolFluent.this.setToDedicatedHosts(index, builder.build());
    }
    
    public N endDedicatedHost() {
      return and();
    }
    
  }
}