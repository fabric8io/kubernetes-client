package io.fabric8.openshift.api.model;

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
public class BuildVolumeFluent<A extends io.fabric8.openshift.api.model.BuildVolumeFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<BuildVolumeMountBuilder> mounts = new ArrayList<BuildVolumeMountBuilder>();
  private String name;
  private BuildVolumeSourceBuilder source;

  public BuildVolumeFluent() {
  }
  
  public BuildVolumeFluent(BuildVolume instance) {
    this.copyInstance(instance);
  }

  public A addAllToMounts(Collection<BuildVolumeMount> items) {
    if (this.mounts == null) {
      this.mounts = new ArrayList();
    }
    for (BuildVolumeMount item : items) {
        BuildVolumeMountBuilder builder = new BuildVolumeMountBuilder(item);
        _visitables.get("mounts").add(builder);
        this.mounts.add(builder);
    }
    return (A) this;
  }
  
  public MountsNested<A> addNewMount() {
    return new MountsNested(-1, null);
  }
  
  public A addNewMount(String destinationPath) {
    return (A) this.addToMounts(new BuildVolumeMount(destinationPath));
  }
  
  public MountsNested<A> addNewMountLike(BuildVolumeMount item) {
    return new MountsNested(-1, item);
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
  
  public A addToMounts(BuildVolumeMount... items) {
    if (this.mounts == null) {
      this.mounts = new ArrayList();
    }
    for (BuildVolumeMount item : items) {
        BuildVolumeMountBuilder builder = new BuildVolumeMountBuilder(item);
        _visitables.get("mounts").add(builder);
        this.mounts.add(builder);
    }
    return (A) this;
  }
  
  public A addToMounts(int index,BuildVolumeMount item) {
    if (this.mounts == null) {
      this.mounts = new ArrayList();
    }
    BuildVolumeMountBuilder builder = new BuildVolumeMountBuilder(item);
    if (index < 0 || index >= mounts.size()) {
        _visitables.get("mounts").add(builder);
        mounts.add(builder);
    } else {
        _visitables.get("mounts").add(builder);
        mounts.add(index, builder);
    }
    return (A) this;
  }
  
  public BuildVolumeMount buildFirstMount() {
    return this.mounts.get(0).build();
  }
  
  public BuildVolumeMount buildLastMount() {
    return this.mounts.get(mounts.size() - 1).build();
  }
  
  public BuildVolumeMount buildMatchingMount(Predicate<BuildVolumeMountBuilder> predicate) {
      for (BuildVolumeMountBuilder item : mounts) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public BuildVolumeMount buildMount(int index) {
    return this.mounts.get(index).build();
  }
  
  public List<BuildVolumeMount> buildMounts() {
    return this.mounts != null ? build(mounts) : null;
  }
  
  public BuildVolumeSource buildSource() {
    return this.source != null ? this.source.build() : null;
  }
  
  protected void copyInstance(BuildVolume instance) {
    instance = instance != null ? instance : new BuildVolume();
    if (instance != null) {
        this.withMounts(instance.getMounts());
        this.withName(instance.getName());
        this.withSource(instance.getSource());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MountsNested<A> editFirstMount() {
    if (mounts.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "mounts"));
    }
    return this.setNewMountLike(0, this.buildMount(0));
  }
  
  public MountsNested<A> editLastMount() {
    int index = mounts.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "mounts"));
    }
    return this.setNewMountLike(index, this.buildMount(index));
  }
  
  public MountsNested<A> editMatchingMount(Predicate<BuildVolumeMountBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < mounts.size();i++) {
      if (predicate.test(mounts.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "mounts"));
    }
    return this.setNewMountLike(index, this.buildMount(index));
  }
  
  public MountsNested<A> editMount(int index) {
    if (mounts.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "mounts"));
    }
    return this.setNewMountLike(index, this.buildMount(index));
  }
  
  public SourceNested<A> editOrNewSource() {
    return this.withNewSourceLike(Optional.ofNullable(this.buildSource()).orElse(new BuildVolumeSourceBuilder().build()));
  }
  
  public SourceNested<A> editOrNewSourceLike(BuildVolumeSource item) {
    return this.withNewSourceLike(Optional.ofNullable(this.buildSource()).orElse(item));
  }
  
  public SourceNested<A> editSource() {
    return this.withNewSourceLike(Optional.ofNullable(this.buildSource()).orElse(null));
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
    BuildVolumeFluent that = (BuildVolumeFluent) o;
    if (!(Objects.equals(mounts, that.mounts))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(source, that.source))) {
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
  
  public String getName() {
    return this.name;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingMount(Predicate<BuildVolumeMountBuilder> predicate) {
      for (BuildVolumeMountBuilder item : mounts) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMounts() {
    return this.mounts != null && !(this.mounts.isEmpty());
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasSource() {
    return this.source != null;
  }
  
  public int hashCode() {
    return Objects.hash(mounts, name, source, additionalProperties);
  }
  
  public A removeAllFromMounts(Collection<BuildVolumeMount> items) {
    if (this.mounts == null) {
      return (A) this;
    }
    for (BuildVolumeMount item : items) {
        BuildVolumeMountBuilder builder = new BuildVolumeMountBuilder(item);
        _visitables.get("mounts").remove(builder);
        this.mounts.remove(builder);
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
  
  public A removeFromMounts(BuildVolumeMount... items) {
    if (this.mounts == null) {
      return (A) this;
    }
    for (BuildVolumeMount item : items) {
        BuildVolumeMountBuilder builder = new BuildVolumeMountBuilder(item);
        _visitables.get("mounts").remove(builder);
        this.mounts.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromMounts(Predicate<BuildVolumeMountBuilder> predicate) {
    if (mounts == null) {
      return (A) this;
    }
    Iterator<BuildVolumeMountBuilder> each = mounts.iterator();
    List visitables = _visitables.get("mounts");
    while (each.hasNext()) {
        BuildVolumeMountBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public MountsNested<A> setNewMountLike(int index,BuildVolumeMount item) {
    return new MountsNested(index, item);
  }
  
  public A setToMounts(int index,BuildVolumeMount item) {
    if (this.mounts == null) {
      this.mounts = new ArrayList();
    }
    BuildVolumeMountBuilder builder = new BuildVolumeMountBuilder(item);
    if (index < 0 || index >= mounts.size()) {
        _visitables.get("mounts").add(builder);
        mounts.add(builder);
    } else {
        _visitables.get("mounts").add(builder);
        mounts.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(mounts == null) && !(mounts.isEmpty())) {
        sb.append("mounts:");
        sb.append(mounts);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(source == null)) {
        sb.append("source:");
        sb.append(source);
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
  
  public A withMounts(List<BuildVolumeMount> mounts) {
    if (this.mounts != null) {
      this._visitables.get("mounts").clear();
    }
    if (mounts != null) {
        this.mounts = new ArrayList();
        for (BuildVolumeMount item : mounts) {
          this.addToMounts(item);
        }
    } else {
      this.mounts = null;
    }
    return (A) this;
  }
  
  public A withMounts(BuildVolumeMount... mounts) {
    if (this.mounts != null) {
        this.mounts.clear();
        _visitables.remove("mounts");
    }
    if (mounts != null) {
      for (BuildVolumeMount item : mounts) {
        this.addToMounts(item);
      }
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public SourceNested<A> withNewSource() {
    return new SourceNested(null);
  }
  
  public SourceNested<A> withNewSourceLike(BuildVolumeSource item) {
    return new SourceNested(item);
  }
  
  public A withSource(BuildVolumeSource source) {
    this._visitables.remove("source");
    if (source != null) {
        this.source = new BuildVolumeSourceBuilder(source);
        this._visitables.get("source").add(this.source);
    } else {
        this.source = null;
        this._visitables.get("source").remove(this.source);
    }
    return (A) this;
  }
  public class MountsNested<N> extends BuildVolumeMountFluent<MountsNested<N>> implements Nested<N>{
  
    BuildVolumeMountBuilder builder;
    int index;
  
    MountsNested(int index,BuildVolumeMount item) {
      this.index = index;
      this.builder = new BuildVolumeMountBuilder(this, item);
    }
  
    public N and() {
      return (N) BuildVolumeFluent.this.setToMounts(index, builder.build());
    }
    
    public N endMount() {
      return and();
    }
    
  }
  public class SourceNested<N> extends BuildVolumeSourceFluent<SourceNested<N>> implements Nested<N>{
  
    BuildVolumeSourceBuilder builder;
  
    SourceNested(BuildVolumeSource item) {
      this.builder = new BuildVolumeSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) BuildVolumeFluent.this.withSource(builder.build());
    }
    
    public N endSource() {
      return and();
    }
    
  }
}