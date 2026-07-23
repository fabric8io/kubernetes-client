package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
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
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class SoftwareRAIDVolumeFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1.SoftwareRAIDVolumeFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String level;
  private ArrayList<RootDeviceHintsBuilder> physicalDisks = new ArrayList<RootDeviceHintsBuilder>();
  private Integer sizeGibibytes;

  public SoftwareRAIDVolumeFluent() {
  }
  
  public SoftwareRAIDVolumeFluent(SoftwareRAIDVolume instance) {
    this.copyInstance(instance);
  }

  public A addAllToPhysicalDisks(Collection<RootDeviceHints> items) {
    if (this.physicalDisks == null) {
      this.physicalDisks = new ArrayList();
    }
    for (RootDeviceHints item : items) {
        RootDeviceHintsBuilder builder = new RootDeviceHintsBuilder(item);
        _visitables.get("physicalDisks").add(builder);
        this.physicalDisks.add(builder);
    }
    return (A) this;
  }
  
  public PhysicalDisksNested<A> addNewPhysicalDisk() {
    return new PhysicalDisksNested(-1, null);
  }
  
  public PhysicalDisksNested<A> addNewPhysicalDiskLike(RootDeviceHints item) {
    return new PhysicalDisksNested(-1, item);
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
  
  public A addToPhysicalDisks(RootDeviceHints... items) {
    if (this.physicalDisks == null) {
      this.physicalDisks = new ArrayList();
    }
    for (RootDeviceHints item : items) {
        RootDeviceHintsBuilder builder = new RootDeviceHintsBuilder(item);
        _visitables.get("physicalDisks").add(builder);
        this.physicalDisks.add(builder);
    }
    return (A) this;
  }
  
  public A addToPhysicalDisks(int index,RootDeviceHints item) {
    if (this.physicalDisks == null) {
      this.physicalDisks = new ArrayList();
    }
    RootDeviceHintsBuilder builder = new RootDeviceHintsBuilder(item);
    if (index < 0 || index >= physicalDisks.size()) {
        _visitables.get("physicalDisks").add(builder);
        physicalDisks.add(builder);
    } else {
        _visitables.get("physicalDisks").add(builder);
        physicalDisks.add(index, builder);
    }
    return (A) this;
  }
  
  public RootDeviceHints buildFirstPhysicalDisk() {
    return this.physicalDisks.get(0).build();
  }
  
  public RootDeviceHints buildLastPhysicalDisk() {
    return this.physicalDisks.get(physicalDisks.size() - 1).build();
  }
  
  public RootDeviceHints buildMatchingPhysicalDisk(Predicate<RootDeviceHintsBuilder> predicate) {
      for (RootDeviceHintsBuilder item : physicalDisks) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public RootDeviceHints buildPhysicalDisk(int index) {
    return this.physicalDisks.get(index).build();
  }
  
  public List<RootDeviceHints> buildPhysicalDisks() {
    return this.physicalDisks != null ? build(physicalDisks) : null;
  }
  
  protected void copyInstance(SoftwareRAIDVolume instance) {
    instance = instance != null ? instance : new SoftwareRAIDVolume();
    if (instance != null) {
        this.withLevel(instance.getLevel());
        this.withPhysicalDisks(instance.getPhysicalDisks());
        this.withSizeGibibytes(instance.getSizeGibibytes());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PhysicalDisksNested<A> editFirstPhysicalDisk() {
    if (physicalDisks.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "physicalDisks"));
    }
    return this.setNewPhysicalDiskLike(0, this.buildPhysicalDisk(0));
  }
  
  public PhysicalDisksNested<A> editLastPhysicalDisk() {
    int index = physicalDisks.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "physicalDisks"));
    }
    return this.setNewPhysicalDiskLike(index, this.buildPhysicalDisk(index));
  }
  
  public PhysicalDisksNested<A> editMatchingPhysicalDisk(Predicate<RootDeviceHintsBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < physicalDisks.size();i++) {
      if (predicate.test(physicalDisks.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "physicalDisks"));
    }
    return this.setNewPhysicalDiskLike(index, this.buildPhysicalDisk(index));
  }
  
  public PhysicalDisksNested<A> editPhysicalDisk(int index) {
    if (physicalDisks.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "physicalDisks"));
    }
    return this.setNewPhysicalDiskLike(index, this.buildPhysicalDisk(index));
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
    SoftwareRAIDVolumeFluent that = (SoftwareRAIDVolumeFluent) o;
    if (!(Objects.equals(level, that.level))) {
      return false;
    }
    if (!(Objects.equals(physicalDisks, that.physicalDisks))) {
      return false;
    }
    if (!(Objects.equals(sizeGibibytes, that.sizeGibibytes))) {
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
  
  public String getLevel() {
    return this.level;
  }
  
  public Integer getSizeGibibytes() {
    return this.sizeGibibytes;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasLevel() {
    return this.level != null;
  }
  
  public boolean hasMatchingPhysicalDisk(Predicate<RootDeviceHintsBuilder> predicate) {
      for (RootDeviceHintsBuilder item : physicalDisks) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPhysicalDisks() {
    return this.physicalDisks != null && !(this.physicalDisks.isEmpty());
  }
  
  public boolean hasSizeGibibytes() {
    return this.sizeGibibytes != null;
  }
  
  public int hashCode() {
    return Objects.hash(level, physicalDisks, sizeGibibytes, additionalProperties);
  }
  
  public A removeAllFromPhysicalDisks(Collection<RootDeviceHints> items) {
    if (this.physicalDisks == null) {
      return (A) this;
    }
    for (RootDeviceHints item : items) {
        RootDeviceHintsBuilder builder = new RootDeviceHintsBuilder(item);
        _visitables.get("physicalDisks").remove(builder);
        this.physicalDisks.remove(builder);
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
  
  public A removeFromPhysicalDisks(RootDeviceHints... items) {
    if (this.physicalDisks == null) {
      return (A) this;
    }
    for (RootDeviceHints item : items) {
        RootDeviceHintsBuilder builder = new RootDeviceHintsBuilder(item);
        _visitables.get("physicalDisks").remove(builder);
        this.physicalDisks.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromPhysicalDisks(Predicate<RootDeviceHintsBuilder> predicate) {
    if (physicalDisks == null) {
      return (A) this;
    }
    Iterator<RootDeviceHintsBuilder> each = physicalDisks.iterator();
    List visitables = _visitables.get("physicalDisks");
    while (each.hasNext()) {
        RootDeviceHintsBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public PhysicalDisksNested<A> setNewPhysicalDiskLike(int index,RootDeviceHints item) {
    return new PhysicalDisksNested(index, item);
  }
  
  public A setToPhysicalDisks(int index,RootDeviceHints item) {
    if (this.physicalDisks == null) {
      this.physicalDisks = new ArrayList();
    }
    RootDeviceHintsBuilder builder = new RootDeviceHintsBuilder(item);
    if (index < 0 || index >= physicalDisks.size()) {
        _visitables.get("physicalDisks").add(builder);
        physicalDisks.add(builder);
    } else {
        _visitables.get("physicalDisks").add(builder);
        physicalDisks.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(level == null)) {
        sb.append("level:");
        sb.append(level);
        sb.append(",");
    }
    if (!(physicalDisks == null) && !(physicalDisks.isEmpty())) {
        sb.append("physicalDisks:");
        sb.append(physicalDisks);
        sb.append(",");
    }
    if (!(sizeGibibytes == null)) {
        sb.append("sizeGibibytes:");
        sb.append(sizeGibibytes);
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
  
  public A withLevel(String level) {
    this.level = level;
    return (A) this;
  }
  
  public A withPhysicalDisks(List<RootDeviceHints> physicalDisks) {
    if (this.physicalDisks != null) {
      this._visitables.get("physicalDisks").clear();
    }
    if (physicalDisks != null) {
        this.physicalDisks = new ArrayList();
        for (RootDeviceHints item : physicalDisks) {
          this.addToPhysicalDisks(item);
        }
    } else {
      this.physicalDisks = null;
    }
    return (A) this;
  }
  
  public A withPhysicalDisks(RootDeviceHints... physicalDisks) {
    if (this.physicalDisks != null) {
        this.physicalDisks.clear();
        _visitables.remove("physicalDisks");
    }
    if (physicalDisks != null) {
      for (RootDeviceHints item : physicalDisks) {
        this.addToPhysicalDisks(item);
      }
    }
    return (A) this;
  }
  
  public A withSizeGibibytes(Integer sizeGibibytes) {
    this.sizeGibibytes = sizeGibibytes;
    return (A) this;
  }
  public class PhysicalDisksNested<N> extends RootDeviceHintsFluent<PhysicalDisksNested<N>> implements Nested<N>{
  
    RootDeviceHintsBuilder builder;
    int index;
  
    PhysicalDisksNested(int index,RootDeviceHints item) {
      this.index = index;
      this.builder = new RootDeviceHintsBuilder(this, item);
    }
  
    public N and() {
      return (N) SoftwareRAIDVolumeFluent.this.setToPhysicalDisks(index, builder.build());
    }
    
    public N endPhysicalDisk() {
      return and();
    }
    
  }
}