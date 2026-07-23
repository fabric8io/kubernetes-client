package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

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
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class RAIDConfigFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1.RAIDConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<HardwareRAIDVolumeBuilder> hardwareRAIDVolumes = new ArrayList<HardwareRAIDVolumeBuilder>();
  private ArrayList<SoftwareRAIDVolumeBuilder> softwareRAIDVolumes = new ArrayList<SoftwareRAIDVolumeBuilder>();

  public RAIDConfigFluent() {
  }
  
  public RAIDConfigFluent(RAIDConfig instance) {
    this.copyInstance(instance);
  }

  public A addAllToHardwareRAIDVolumes(Collection<HardwareRAIDVolume> items) {
    if (this.hardwareRAIDVolumes == null) {
      this.hardwareRAIDVolumes = new ArrayList();
    }
    for (HardwareRAIDVolume item : items) {
        HardwareRAIDVolumeBuilder builder = new HardwareRAIDVolumeBuilder(item);
        _visitables.get("hardwareRAIDVolumes").add(builder);
        this.hardwareRAIDVolumes.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToSoftwareRAIDVolumes(Collection<SoftwareRAIDVolume> items) {
    if (this.softwareRAIDVolumes == null) {
      this.softwareRAIDVolumes = new ArrayList();
    }
    for (SoftwareRAIDVolume item : items) {
        SoftwareRAIDVolumeBuilder builder = new SoftwareRAIDVolumeBuilder(item);
        _visitables.get("softwareRAIDVolumes").add(builder);
        this.softwareRAIDVolumes.add(builder);
    }
    return (A) this;
  }
  
  public HardwareRAIDVolumesNested<A> addNewHardwareRAIDVolume() {
    return new HardwareRAIDVolumesNested(-1, null);
  }
  
  public HardwareRAIDVolumesNested<A> addNewHardwareRAIDVolumeLike(HardwareRAIDVolume item) {
    return new HardwareRAIDVolumesNested(-1, item);
  }
  
  public SoftwareRAIDVolumesNested<A> addNewSoftwareRAIDVolume() {
    return new SoftwareRAIDVolumesNested(-1, null);
  }
  
  public SoftwareRAIDVolumesNested<A> addNewSoftwareRAIDVolumeLike(SoftwareRAIDVolume item) {
    return new SoftwareRAIDVolumesNested(-1, item);
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
  
  public A addToHardwareRAIDVolumes(HardwareRAIDVolume... items) {
    if (this.hardwareRAIDVolumes == null) {
      this.hardwareRAIDVolumes = new ArrayList();
    }
    for (HardwareRAIDVolume item : items) {
        HardwareRAIDVolumeBuilder builder = new HardwareRAIDVolumeBuilder(item);
        _visitables.get("hardwareRAIDVolumes").add(builder);
        this.hardwareRAIDVolumes.add(builder);
    }
    return (A) this;
  }
  
  public A addToHardwareRAIDVolumes(int index,HardwareRAIDVolume item) {
    if (this.hardwareRAIDVolumes == null) {
      this.hardwareRAIDVolumes = new ArrayList();
    }
    HardwareRAIDVolumeBuilder builder = new HardwareRAIDVolumeBuilder(item);
    if (index < 0 || index >= hardwareRAIDVolumes.size()) {
        _visitables.get("hardwareRAIDVolumes").add(builder);
        hardwareRAIDVolumes.add(builder);
    } else {
        _visitables.get("hardwareRAIDVolumes").add(builder);
        hardwareRAIDVolumes.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToSoftwareRAIDVolumes(SoftwareRAIDVolume... items) {
    if (this.softwareRAIDVolumes == null) {
      this.softwareRAIDVolumes = new ArrayList();
    }
    for (SoftwareRAIDVolume item : items) {
        SoftwareRAIDVolumeBuilder builder = new SoftwareRAIDVolumeBuilder(item);
        _visitables.get("softwareRAIDVolumes").add(builder);
        this.softwareRAIDVolumes.add(builder);
    }
    return (A) this;
  }
  
  public A addToSoftwareRAIDVolumes(int index,SoftwareRAIDVolume item) {
    if (this.softwareRAIDVolumes == null) {
      this.softwareRAIDVolumes = new ArrayList();
    }
    SoftwareRAIDVolumeBuilder builder = new SoftwareRAIDVolumeBuilder(item);
    if (index < 0 || index >= softwareRAIDVolumes.size()) {
        _visitables.get("softwareRAIDVolumes").add(builder);
        softwareRAIDVolumes.add(builder);
    } else {
        _visitables.get("softwareRAIDVolumes").add(builder);
        softwareRAIDVolumes.add(index, builder);
    }
    return (A) this;
  }
  
  public HardwareRAIDVolume buildFirstHardwareRAIDVolume() {
    return this.hardwareRAIDVolumes.get(0).build();
  }
  
  public SoftwareRAIDVolume buildFirstSoftwareRAIDVolume() {
    return this.softwareRAIDVolumes.get(0).build();
  }
  
  public HardwareRAIDVolume buildHardwareRAIDVolume(int index) {
    return this.hardwareRAIDVolumes.get(index).build();
  }
  
  public List<HardwareRAIDVolume> buildHardwareRAIDVolumes() {
    return this.hardwareRAIDVolumes != null ? build(hardwareRAIDVolumes) : null;
  }
  
  public HardwareRAIDVolume buildLastHardwareRAIDVolume() {
    return this.hardwareRAIDVolumes.get(hardwareRAIDVolumes.size() - 1).build();
  }
  
  public SoftwareRAIDVolume buildLastSoftwareRAIDVolume() {
    return this.softwareRAIDVolumes.get(softwareRAIDVolumes.size() - 1).build();
  }
  
  public HardwareRAIDVolume buildMatchingHardwareRAIDVolume(Predicate<HardwareRAIDVolumeBuilder> predicate) {
      for (HardwareRAIDVolumeBuilder item : hardwareRAIDVolumes) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public SoftwareRAIDVolume buildMatchingSoftwareRAIDVolume(Predicate<SoftwareRAIDVolumeBuilder> predicate) {
      for (SoftwareRAIDVolumeBuilder item : softwareRAIDVolumes) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public SoftwareRAIDVolume buildSoftwareRAIDVolume(int index) {
    return this.softwareRAIDVolumes.get(index).build();
  }
  
  public List<SoftwareRAIDVolume> buildSoftwareRAIDVolumes() {
    return this.softwareRAIDVolumes != null ? build(softwareRAIDVolumes) : null;
  }
  
  protected void copyInstance(RAIDConfig instance) {
    instance = instance != null ? instance : new RAIDConfig();
    if (instance != null) {
        this.withHardwareRAIDVolumes(instance.getHardwareRAIDVolumes());
        this.withSoftwareRAIDVolumes(instance.getSoftwareRAIDVolumes());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public HardwareRAIDVolumesNested<A> editFirstHardwareRAIDVolume() {
    if (hardwareRAIDVolumes.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "hardwareRAIDVolumes"));
    }
    return this.setNewHardwareRAIDVolumeLike(0, this.buildHardwareRAIDVolume(0));
  }
  
  public SoftwareRAIDVolumesNested<A> editFirstSoftwareRAIDVolume() {
    if (softwareRAIDVolumes.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "softwareRAIDVolumes"));
    }
    return this.setNewSoftwareRAIDVolumeLike(0, this.buildSoftwareRAIDVolume(0));
  }
  
  public HardwareRAIDVolumesNested<A> editHardwareRAIDVolume(int index) {
    if (hardwareRAIDVolumes.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "hardwareRAIDVolumes"));
    }
    return this.setNewHardwareRAIDVolumeLike(index, this.buildHardwareRAIDVolume(index));
  }
  
  public HardwareRAIDVolumesNested<A> editLastHardwareRAIDVolume() {
    int index = hardwareRAIDVolumes.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "hardwareRAIDVolumes"));
    }
    return this.setNewHardwareRAIDVolumeLike(index, this.buildHardwareRAIDVolume(index));
  }
  
  public SoftwareRAIDVolumesNested<A> editLastSoftwareRAIDVolume() {
    int index = softwareRAIDVolumes.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "softwareRAIDVolumes"));
    }
    return this.setNewSoftwareRAIDVolumeLike(index, this.buildSoftwareRAIDVolume(index));
  }
  
  public HardwareRAIDVolumesNested<A> editMatchingHardwareRAIDVolume(Predicate<HardwareRAIDVolumeBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < hardwareRAIDVolumes.size();i++) {
      if (predicate.test(hardwareRAIDVolumes.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "hardwareRAIDVolumes"));
    }
    return this.setNewHardwareRAIDVolumeLike(index, this.buildHardwareRAIDVolume(index));
  }
  
  public SoftwareRAIDVolumesNested<A> editMatchingSoftwareRAIDVolume(Predicate<SoftwareRAIDVolumeBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < softwareRAIDVolumes.size();i++) {
      if (predicate.test(softwareRAIDVolumes.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "softwareRAIDVolumes"));
    }
    return this.setNewSoftwareRAIDVolumeLike(index, this.buildSoftwareRAIDVolume(index));
  }
  
  public SoftwareRAIDVolumesNested<A> editSoftwareRAIDVolume(int index) {
    if (softwareRAIDVolumes.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "softwareRAIDVolumes"));
    }
    return this.setNewSoftwareRAIDVolumeLike(index, this.buildSoftwareRAIDVolume(index));
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
    RAIDConfigFluent that = (RAIDConfigFluent) o;
    if (!(Objects.equals(hardwareRAIDVolumes, that.hardwareRAIDVolumes))) {
      return false;
    }
    if (!(Objects.equals(softwareRAIDVolumes, that.softwareRAIDVolumes))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasHardwareRAIDVolumes() {
    return this.hardwareRAIDVolumes != null && !(this.hardwareRAIDVolumes.isEmpty());
  }
  
  public boolean hasMatchingHardwareRAIDVolume(Predicate<HardwareRAIDVolumeBuilder> predicate) {
      for (HardwareRAIDVolumeBuilder item : hardwareRAIDVolumes) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingSoftwareRAIDVolume(Predicate<SoftwareRAIDVolumeBuilder> predicate) {
      for (SoftwareRAIDVolumeBuilder item : softwareRAIDVolumes) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasSoftwareRAIDVolumes() {
    return this.softwareRAIDVolumes != null && !(this.softwareRAIDVolumes.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(hardwareRAIDVolumes, softwareRAIDVolumes, additionalProperties);
  }
  
  public A removeAllFromHardwareRAIDVolumes(Collection<HardwareRAIDVolume> items) {
    if (this.hardwareRAIDVolumes == null) {
      return (A) this;
    }
    for (HardwareRAIDVolume item : items) {
        HardwareRAIDVolumeBuilder builder = new HardwareRAIDVolumeBuilder(item);
        _visitables.get("hardwareRAIDVolumes").remove(builder);
        this.hardwareRAIDVolumes.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromSoftwareRAIDVolumes(Collection<SoftwareRAIDVolume> items) {
    if (this.softwareRAIDVolumes == null) {
      return (A) this;
    }
    for (SoftwareRAIDVolume item : items) {
        SoftwareRAIDVolumeBuilder builder = new SoftwareRAIDVolumeBuilder(item);
        _visitables.get("softwareRAIDVolumes").remove(builder);
        this.softwareRAIDVolumes.remove(builder);
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
  
  public A removeFromHardwareRAIDVolumes(HardwareRAIDVolume... items) {
    if (this.hardwareRAIDVolumes == null) {
      return (A) this;
    }
    for (HardwareRAIDVolume item : items) {
        HardwareRAIDVolumeBuilder builder = new HardwareRAIDVolumeBuilder(item);
        _visitables.get("hardwareRAIDVolumes").remove(builder);
        this.hardwareRAIDVolumes.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromSoftwareRAIDVolumes(SoftwareRAIDVolume... items) {
    if (this.softwareRAIDVolumes == null) {
      return (A) this;
    }
    for (SoftwareRAIDVolume item : items) {
        SoftwareRAIDVolumeBuilder builder = new SoftwareRAIDVolumeBuilder(item);
        _visitables.get("softwareRAIDVolumes").remove(builder);
        this.softwareRAIDVolumes.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromHardwareRAIDVolumes(Predicate<HardwareRAIDVolumeBuilder> predicate) {
    if (hardwareRAIDVolumes == null) {
      return (A) this;
    }
    Iterator<HardwareRAIDVolumeBuilder> each = hardwareRAIDVolumes.iterator();
    List visitables = _visitables.get("hardwareRAIDVolumes");
    while (each.hasNext()) {
        HardwareRAIDVolumeBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromSoftwareRAIDVolumes(Predicate<SoftwareRAIDVolumeBuilder> predicate) {
    if (softwareRAIDVolumes == null) {
      return (A) this;
    }
    Iterator<SoftwareRAIDVolumeBuilder> each = softwareRAIDVolumes.iterator();
    List visitables = _visitables.get("softwareRAIDVolumes");
    while (each.hasNext()) {
        SoftwareRAIDVolumeBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public HardwareRAIDVolumesNested<A> setNewHardwareRAIDVolumeLike(int index,HardwareRAIDVolume item) {
    return new HardwareRAIDVolumesNested(index, item);
  }
  
  public SoftwareRAIDVolumesNested<A> setNewSoftwareRAIDVolumeLike(int index,SoftwareRAIDVolume item) {
    return new SoftwareRAIDVolumesNested(index, item);
  }
  
  public A setToHardwareRAIDVolumes(int index,HardwareRAIDVolume item) {
    if (this.hardwareRAIDVolumes == null) {
      this.hardwareRAIDVolumes = new ArrayList();
    }
    HardwareRAIDVolumeBuilder builder = new HardwareRAIDVolumeBuilder(item);
    if (index < 0 || index >= hardwareRAIDVolumes.size()) {
        _visitables.get("hardwareRAIDVolumes").add(builder);
        hardwareRAIDVolumes.add(builder);
    } else {
        _visitables.get("hardwareRAIDVolumes").add(builder);
        hardwareRAIDVolumes.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToSoftwareRAIDVolumes(int index,SoftwareRAIDVolume item) {
    if (this.softwareRAIDVolumes == null) {
      this.softwareRAIDVolumes = new ArrayList();
    }
    SoftwareRAIDVolumeBuilder builder = new SoftwareRAIDVolumeBuilder(item);
    if (index < 0 || index >= softwareRAIDVolumes.size()) {
        _visitables.get("softwareRAIDVolumes").add(builder);
        softwareRAIDVolumes.add(builder);
    } else {
        _visitables.get("softwareRAIDVolumes").add(builder);
        softwareRAIDVolumes.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(hardwareRAIDVolumes == null) && !(hardwareRAIDVolumes.isEmpty())) {
        sb.append("hardwareRAIDVolumes:");
        sb.append(hardwareRAIDVolumes);
        sb.append(",");
    }
    if (!(softwareRAIDVolumes == null) && !(softwareRAIDVolumes.isEmpty())) {
        sb.append("softwareRAIDVolumes:");
        sb.append(softwareRAIDVolumes);
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
  
  public A withHardwareRAIDVolumes(List<HardwareRAIDVolume> hardwareRAIDVolumes) {
    if (this.hardwareRAIDVolumes != null) {
      this._visitables.get("hardwareRAIDVolumes").clear();
    }
    if (hardwareRAIDVolumes != null) {
        this.hardwareRAIDVolumes = new ArrayList();
        for (HardwareRAIDVolume item : hardwareRAIDVolumes) {
          this.addToHardwareRAIDVolumes(item);
        }
    } else {
      this.hardwareRAIDVolumes = null;
    }
    return (A) this;
  }
  
  public A withHardwareRAIDVolumes(HardwareRAIDVolume... hardwareRAIDVolumes) {
    if (this.hardwareRAIDVolumes != null) {
        this.hardwareRAIDVolumes.clear();
        _visitables.remove("hardwareRAIDVolumes");
    }
    if (hardwareRAIDVolumes != null) {
      for (HardwareRAIDVolume item : hardwareRAIDVolumes) {
        this.addToHardwareRAIDVolumes(item);
      }
    }
    return (A) this;
  }
  
  public A withSoftwareRAIDVolumes(List<SoftwareRAIDVolume> softwareRAIDVolumes) {
    if (this.softwareRAIDVolumes != null) {
      this._visitables.get("softwareRAIDVolumes").clear();
    }
    if (softwareRAIDVolumes != null) {
        this.softwareRAIDVolumes = new ArrayList();
        for (SoftwareRAIDVolume item : softwareRAIDVolumes) {
          this.addToSoftwareRAIDVolumes(item);
        }
    } else {
      this.softwareRAIDVolumes = null;
    }
    return (A) this;
  }
  
  public A withSoftwareRAIDVolumes(SoftwareRAIDVolume... softwareRAIDVolumes) {
    if (this.softwareRAIDVolumes != null) {
        this.softwareRAIDVolumes.clear();
        _visitables.remove("softwareRAIDVolumes");
    }
    if (softwareRAIDVolumes != null) {
      for (SoftwareRAIDVolume item : softwareRAIDVolumes) {
        this.addToSoftwareRAIDVolumes(item);
      }
    }
    return (A) this;
  }
  public class HardwareRAIDVolumesNested<N> extends HardwareRAIDVolumeFluent<HardwareRAIDVolumesNested<N>> implements Nested<N>{
  
    HardwareRAIDVolumeBuilder builder;
    int index;
  
    HardwareRAIDVolumesNested(int index,HardwareRAIDVolume item) {
      this.index = index;
      this.builder = new HardwareRAIDVolumeBuilder(this, item);
    }
  
    public N and() {
      return (N) RAIDConfigFluent.this.setToHardwareRAIDVolumes(index, builder.build());
    }
    
    public N endHardwareRAIDVolume() {
      return and();
    }
    
  }
  public class SoftwareRAIDVolumesNested<N> extends SoftwareRAIDVolumeFluent<SoftwareRAIDVolumesNested<N>> implements Nested<N>{
  
    SoftwareRAIDVolumeBuilder builder;
    int index;
  
    SoftwareRAIDVolumesNested(int index,SoftwareRAIDVolume item) {
      this.index = index;
      this.builder = new SoftwareRAIDVolumeBuilder(this, item);
    }
  
    public N and() {
      return (N) RAIDConfigFluent.this.setToSoftwareRAIDVolumes(index, builder.build());
    }
    
    public N endSoftwareRAIDVolume() {
      return and();
    }
    
  }
}