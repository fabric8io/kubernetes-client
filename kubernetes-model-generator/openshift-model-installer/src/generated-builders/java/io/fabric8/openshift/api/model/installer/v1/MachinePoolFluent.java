package io.fabric8.openshift.api.model.installer.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class MachinePoolFluent<A extends io.fabric8.openshift.api.model.installer.v1.MachinePoolFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String architecture;
  private ArrayList<DiskBuilder> diskSetup = new ArrayList<DiskBuilder>();
  private FencingBuilder fencing;
  private String hyperthreading;
  private String name;
  private MachinePoolPlatformBuilder platform;
  private Long replicas;

  public MachinePoolFluent() {
  }
  
  public MachinePoolFluent(MachinePool instance) {
    this.copyInstance(instance);
  }

  public A addAllToDiskSetup(Collection<Disk> items) {
    if (this.diskSetup == null) {
      this.diskSetup = new ArrayList();
    }
    for (Disk item : items) {
        DiskBuilder builder = new DiskBuilder(item);
        _visitables.get("diskSetup").add(builder);
        this.diskSetup.add(builder);
    }
    return (A) this;
  }
  
  public DiskSetupNested<A> addNewDiskSetup() {
    return new DiskSetupNested(-1, null);
  }
  
  public DiskSetupNested<A> addNewDiskSetupLike(Disk item) {
    return new DiskSetupNested(-1, item);
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
  
  public A addToDiskSetup(Disk... items) {
    if (this.diskSetup == null) {
      this.diskSetup = new ArrayList();
    }
    for (Disk item : items) {
        DiskBuilder builder = new DiskBuilder(item);
        _visitables.get("diskSetup").add(builder);
        this.diskSetup.add(builder);
    }
    return (A) this;
  }
  
  public A addToDiskSetup(int index,Disk item) {
    if (this.diskSetup == null) {
      this.diskSetup = new ArrayList();
    }
    DiskBuilder builder = new DiskBuilder(item);
    if (index < 0 || index >= diskSetup.size()) {
        _visitables.get("diskSetup").add(builder);
        diskSetup.add(builder);
    } else {
        _visitables.get("diskSetup").add(builder);
        diskSetup.add(index, builder);
    }
    return (A) this;
  }
  
  public List<Disk> buildDiskSetup() {
    return this.diskSetup != null ? build(diskSetup) : null;
  }
  
  public Disk buildDiskSetup(int index) {
    return this.diskSetup.get(index).build();
  }
  
  public Fencing buildFencing() {
    return this.fencing != null ? this.fencing.build() : null;
  }
  
  public Disk buildFirstDiskSetup() {
    return this.diskSetup.get(0).build();
  }
  
  public Disk buildLastDiskSetup() {
    return this.diskSetup.get(diskSetup.size() - 1).build();
  }
  
  public Disk buildMatchingDiskSetup(Predicate<DiskBuilder> predicate) {
      for (DiskBuilder item : diskSetup) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public MachinePoolPlatform buildPlatform() {
    return this.platform != null ? this.platform.build() : null;
  }
  
  protected void copyInstance(MachinePool instance) {
    instance = instance != null ? instance : new MachinePool();
    if (instance != null) {
        this.withArchitecture(instance.getArchitecture());
        this.withDiskSetup(instance.getDiskSetup());
        this.withFencing(instance.getFencing());
        this.withHyperthreading(instance.getHyperthreading());
        this.withName(instance.getName());
        this.withPlatform(instance.getPlatform());
        this.withReplicas(instance.getReplicas());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DiskSetupNested<A> editDiskSetup(int index) {
    if (diskSetup.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "diskSetup"));
    }
    return this.setNewDiskSetupLike(index, this.buildDiskSetup(index));
  }
  
  public FencingNested<A> editFencing() {
    return this.withNewFencingLike(Optional.ofNullable(this.buildFencing()).orElse(null));
  }
  
  public DiskSetupNested<A> editFirstDiskSetup() {
    if (diskSetup.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "diskSetup"));
    }
    return this.setNewDiskSetupLike(0, this.buildDiskSetup(0));
  }
  
  public DiskSetupNested<A> editLastDiskSetup() {
    int index = diskSetup.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "diskSetup"));
    }
    return this.setNewDiskSetupLike(index, this.buildDiskSetup(index));
  }
  
  public DiskSetupNested<A> editMatchingDiskSetup(Predicate<DiskBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < diskSetup.size();i++) {
      if (predicate.test(diskSetup.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "diskSetup"));
    }
    return this.setNewDiskSetupLike(index, this.buildDiskSetup(index));
  }
  
  public FencingNested<A> editOrNewFencing() {
    return this.withNewFencingLike(Optional.ofNullable(this.buildFencing()).orElse(new FencingBuilder().build()));
  }
  
  public FencingNested<A> editOrNewFencingLike(Fencing item) {
    return this.withNewFencingLike(Optional.ofNullable(this.buildFencing()).orElse(item));
  }
  
  public PlatformNested<A> editOrNewPlatform() {
    return this.withNewPlatformLike(Optional.ofNullable(this.buildPlatform()).orElse(new MachinePoolPlatformBuilder().build()));
  }
  
  public PlatformNested<A> editOrNewPlatformLike(MachinePoolPlatform item) {
    return this.withNewPlatformLike(Optional.ofNullable(this.buildPlatform()).orElse(item));
  }
  
  public PlatformNested<A> editPlatform() {
    return this.withNewPlatformLike(Optional.ofNullable(this.buildPlatform()).orElse(null));
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
    if (!(Objects.equals(architecture, that.architecture))) {
      return false;
    }
    if (!(Objects.equals(diskSetup, that.diskSetup))) {
      return false;
    }
    if (!(Objects.equals(fencing, that.fencing))) {
      return false;
    }
    if (!(Objects.equals(hyperthreading, that.hyperthreading))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(platform, that.platform))) {
      return false;
    }
    if (!(Objects.equals(replicas, that.replicas))) {
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
  
  public String getArchitecture() {
    return this.architecture;
  }
  
  public String getHyperthreading() {
    return this.hyperthreading;
  }
  
  public String getName() {
    return this.name;
  }
  
  public Long getReplicas() {
    return this.replicas;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasArchitecture() {
    return this.architecture != null;
  }
  
  public boolean hasDiskSetup() {
    return this.diskSetup != null && !(this.diskSetup.isEmpty());
  }
  
  public boolean hasFencing() {
    return this.fencing != null;
  }
  
  public boolean hasHyperthreading() {
    return this.hyperthreading != null;
  }
  
  public boolean hasMatchingDiskSetup(Predicate<DiskBuilder> predicate) {
      for (DiskBuilder item : diskSetup) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasPlatform() {
    return this.platform != null;
  }
  
  public boolean hasReplicas() {
    return this.replicas != null;
  }
  
  public int hashCode() {
    return Objects.hash(architecture, diskSetup, fencing, hyperthreading, name, platform, replicas, additionalProperties);
  }
  
  public A removeAllFromDiskSetup(Collection<Disk> items) {
    if (this.diskSetup == null) {
      return (A) this;
    }
    for (Disk item : items) {
        DiskBuilder builder = new DiskBuilder(item);
        _visitables.get("diskSetup").remove(builder);
        this.diskSetup.remove(builder);
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
  
  public A removeFromDiskSetup(Disk... items) {
    if (this.diskSetup == null) {
      return (A) this;
    }
    for (Disk item : items) {
        DiskBuilder builder = new DiskBuilder(item);
        _visitables.get("diskSetup").remove(builder);
        this.diskSetup.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromDiskSetup(Predicate<DiskBuilder> predicate) {
    if (diskSetup == null) {
      return (A) this;
    }
    Iterator<DiskBuilder> each = diskSetup.iterator();
    List visitables = _visitables.get("diskSetup");
    while (each.hasNext()) {
        DiskBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public DiskSetupNested<A> setNewDiskSetupLike(int index,Disk item) {
    return new DiskSetupNested(index, item);
  }
  
  public A setToDiskSetup(int index,Disk item) {
    if (this.diskSetup == null) {
      this.diskSetup = new ArrayList();
    }
    DiskBuilder builder = new DiskBuilder(item);
    if (index < 0 || index >= diskSetup.size()) {
        _visitables.get("diskSetup").add(builder);
        diskSetup.add(builder);
    } else {
        _visitables.get("diskSetup").add(builder);
        diskSetup.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(architecture == null)) {
        sb.append("architecture:");
        sb.append(architecture);
        sb.append(",");
    }
    if (!(diskSetup == null) && !(diskSetup.isEmpty())) {
        sb.append("diskSetup:");
        sb.append(diskSetup);
        sb.append(",");
    }
    if (!(fencing == null)) {
        sb.append("fencing:");
        sb.append(fencing);
        sb.append(",");
    }
    if (!(hyperthreading == null)) {
        sb.append("hyperthreading:");
        sb.append(hyperthreading);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(platform == null)) {
        sb.append("platform:");
        sb.append(platform);
        sb.append(",");
    }
    if (!(replicas == null)) {
        sb.append("replicas:");
        sb.append(replicas);
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
  
  public A withArchitecture(String architecture) {
    this.architecture = architecture;
    return (A) this;
  }
  
  public A withDiskSetup(List<Disk> diskSetup) {
    if (this.diskSetup != null) {
      this._visitables.get("diskSetup").clear();
    }
    if (diskSetup != null) {
        this.diskSetup = new ArrayList();
        for (Disk item : diskSetup) {
          this.addToDiskSetup(item);
        }
    } else {
      this.diskSetup = null;
    }
    return (A) this;
  }
  
  public A withDiskSetup(Disk... diskSetup) {
    if (this.diskSetup != null) {
        this.diskSetup.clear();
        _visitables.remove("diskSetup");
    }
    if (diskSetup != null) {
      for (Disk item : diskSetup) {
        this.addToDiskSetup(item);
      }
    }
    return (A) this;
  }
  
  public A withFencing(Fencing fencing) {
    this._visitables.remove("fencing");
    if (fencing != null) {
        this.fencing = new FencingBuilder(fencing);
        this._visitables.get("fencing").add(this.fencing);
    } else {
        this.fencing = null;
        this._visitables.get("fencing").remove(this.fencing);
    }
    return (A) this;
  }
  
  public A withHyperthreading(String hyperthreading) {
    this.hyperthreading = hyperthreading;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public FencingNested<A> withNewFencing() {
    return new FencingNested(null);
  }
  
  public FencingNested<A> withNewFencingLike(Fencing item) {
    return new FencingNested(item);
  }
  
  public PlatformNested<A> withNewPlatform() {
    return new PlatformNested(null);
  }
  
  public PlatformNested<A> withNewPlatformLike(MachinePoolPlatform item) {
    return new PlatformNested(item);
  }
  
  public A withPlatform(MachinePoolPlatform platform) {
    this._visitables.remove("platform");
    if (platform != null) {
        this.platform = new MachinePoolPlatformBuilder(platform);
        this._visitables.get("platform").add(this.platform);
    } else {
        this.platform = null;
        this._visitables.get("platform").remove(this.platform);
    }
    return (A) this;
  }
  
  public A withReplicas(Long replicas) {
    this.replicas = replicas;
    return (A) this;
  }
  public class DiskSetupNested<N> extends DiskFluent<DiskSetupNested<N>> implements Nested<N>{
  
    DiskBuilder builder;
    int index;
  
    DiskSetupNested(int index,Disk item) {
      this.index = index;
      this.builder = new DiskBuilder(this, item);
    }
  
    public N and() {
      return (N) MachinePoolFluent.this.setToDiskSetup(index, builder.build());
    }
    
    public N endDiskSetup() {
      return and();
    }
    
  }
  public class FencingNested<N> extends FencingFluent<FencingNested<N>> implements Nested<N>{
  
    FencingBuilder builder;
  
    FencingNested(Fencing item) {
      this.builder = new FencingBuilder(this, item);
    }
  
    public N and() {
      return (N) MachinePoolFluent.this.withFencing(builder.build());
    }
    
    public N endFencing() {
      return and();
    }
    
  }
  public class PlatformNested<N> extends MachinePoolPlatformFluent<PlatformNested<N>> implements Nested<N>{
  
    MachinePoolPlatformBuilder builder;
  
    PlatformNested(MachinePoolPlatform item) {
      this.builder = new MachinePoolPlatformBuilder(this, item);
    }
  
    public N and() {
      return (N) MachinePoolFluent.this.withPlatform(builder.build());
    }
    
    public N endPlatform() {
      return and();
    }
    
  }
}