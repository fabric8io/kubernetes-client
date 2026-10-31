package io.fabric8.kubernetes.api.model.scheduling.v1alpha3;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class WorkloadPodGroupDisruptionModeFluent<A extends io.fabric8.kubernetes.api.model.scheduling.v1alpha3.WorkloadPodGroupDisruptionModeFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private WorkloadPodGroupAllDisruptionModeBuilder all;
  private WorkloadPodGroupSingleDisruptionModeBuilder single;

  public WorkloadPodGroupDisruptionModeFluent() {
  }
  
  public WorkloadPodGroupDisruptionModeFluent(WorkloadPodGroupDisruptionMode instance) {
    this.copyInstance(instance);
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
  
  public WorkloadPodGroupAllDisruptionMode buildAll() {
    return this.all != null ? this.all.build() : null;
  }
  
  public WorkloadPodGroupSingleDisruptionMode buildSingle() {
    return this.single != null ? this.single.build() : null;
  }
  
  protected void copyInstance(WorkloadPodGroupDisruptionMode instance) {
    instance = instance != null ? instance : new WorkloadPodGroupDisruptionMode();
    if (instance != null) {
        this.withAll(instance.getAll());
        this.withSingle(instance.getSingle());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AllNested<A> editAll() {
    return this.withNewAllLike(Optional.ofNullable(this.buildAll()).orElse(null));
  }
  
  public AllNested<A> editOrNewAll() {
    return this.withNewAllLike(Optional.ofNullable(this.buildAll()).orElse(new WorkloadPodGroupAllDisruptionModeBuilder().build()));
  }
  
  public AllNested<A> editOrNewAllLike(WorkloadPodGroupAllDisruptionMode item) {
    return this.withNewAllLike(Optional.ofNullable(this.buildAll()).orElse(item));
  }
  
  public SingleNested<A> editOrNewSingle() {
    return this.withNewSingleLike(Optional.ofNullable(this.buildSingle()).orElse(new WorkloadPodGroupSingleDisruptionModeBuilder().build()));
  }
  
  public SingleNested<A> editOrNewSingleLike(WorkloadPodGroupSingleDisruptionMode item) {
    return this.withNewSingleLike(Optional.ofNullable(this.buildSingle()).orElse(item));
  }
  
  public SingleNested<A> editSingle() {
    return this.withNewSingleLike(Optional.ofNullable(this.buildSingle()).orElse(null));
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
    WorkloadPodGroupDisruptionModeFluent that = (WorkloadPodGroupDisruptionModeFluent) o;
    if (!(Objects.equals(all, that.all))) {
      return false;
    }
    if (!(Objects.equals(single, that.single))) {
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
  
  public boolean hasAll() {
    return this.all != null;
  }
  
  public boolean hasSingle() {
    return this.single != null;
  }
  
  public int hashCode() {
    return Objects.hash(all, single, additionalProperties);
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
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(all == null)) {
        sb.append("all:");
        sb.append(all);
        sb.append(",");
    }
    if (!(single == null)) {
        sb.append("single:");
        sb.append(single);
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
  
  public A withAll(WorkloadPodGroupAllDisruptionMode all) {
    this._visitables.remove("all");
    if (all != null) {
        this.all = new WorkloadPodGroupAllDisruptionModeBuilder(all);
        this._visitables.get("all").add(this.all);
    } else {
        this.all = null;
        this._visitables.get("all").remove(this.all);
    }
    return (A) this;
  }
  
  public AllNested<A> withNewAll() {
    return new AllNested(null);
  }
  
  public AllNested<A> withNewAllLike(WorkloadPodGroupAllDisruptionMode item) {
    return new AllNested(item);
  }
  
  public SingleNested<A> withNewSingle() {
    return new SingleNested(null);
  }
  
  public SingleNested<A> withNewSingleLike(WorkloadPodGroupSingleDisruptionMode item) {
    return new SingleNested(item);
  }
  
  public A withSingle(WorkloadPodGroupSingleDisruptionMode single) {
    this._visitables.remove("single");
    if (single != null) {
        this.single = new WorkloadPodGroupSingleDisruptionModeBuilder(single);
        this._visitables.get("single").add(this.single);
    } else {
        this.single = null;
        this._visitables.get("single").remove(this.single);
    }
    return (A) this;
  }
  public class AllNested<N> extends WorkloadPodGroupAllDisruptionModeFluent<AllNested<N>> implements Nested<N>{
  
    WorkloadPodGroupAllDisruptionModeBuilder builder;
  
    AllNested(WorkloadPodGroupAllDisruptionMode item) {
      this.builder = new WorkloadPodGroupAllDisruptionModeBuilder(this, item);
    }
  
    public N and() {
      return (N) WorkloadPodGroupDisruptionModeFluent.this.withAll(builder.build());
    }
    
    public N endAll() {
      return and();
    }
    
  }
  public class SingleNested<N> extends WorkloadPodGroupSingleDisruptionModeFluent<SingleNested<N>> implements Nested<N>{
  
    WorkloadPodGroupSingleDisruptionModeBuilder builder;
  
    SingleNested(WorkloadPodGroupSingleDisruptionMode item) {
      this.builder = new WorkloadPodGroupSingleDisruptionModeBuilder(this, item);
    }
  
    public N and() {
      return (N) WorkloadPodGroupDisruptionModeFluent.this.withSingle(builder.build());
    }
    
    public N endSingle() {
      return and();
    }
    
  }
}