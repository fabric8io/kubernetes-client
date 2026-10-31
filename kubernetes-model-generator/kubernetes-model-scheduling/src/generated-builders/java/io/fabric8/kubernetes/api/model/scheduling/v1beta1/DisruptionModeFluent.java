package io.fabric8.kubernetes.api.model.scheduling.v1beta1;

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
public class DisruptionModeFluent<A extends io.fabric8.kubernetes.api.model.scheduling.v1beta1.DisruptionModeFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private AllDisruptionModeBuilder all;
  private SingleDisruptionModeBuilder single;

  public DisruptionModeFluent() {
  }
  
  public DisruptionModeFluent(DisruptionMode instance) {
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
  
  public AllDisruptionMode buildAll() {
    return this.all != null ? this.all.build() : null;
  }
  
  public SingleDisruptionMode buildSingle() {
    return this.single != null ? this.single.build() : null;
  }
  
  protected void copyInstance(DisruptionMode instance) {
    instance = instance != null ? instance : new DisruptionMode();
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
    return this.withNewAllLike(Optional.ofNullable(this.buildAll()).orElse(new AllDisruptionModeBuilder().build()));
  }
  
  public AllNested<A> editOrNewAllLike(AllDisruptionMode item) {
    return this.withNewAllLike(Optional.ofNullable(this.buildAll()).orElse(item));
  }
  
  public SingleNested<A> editOrNewSingle() {
    return this.withNewSingleLike(Optional.ofNullable(this.buildSingle()).orElse(new SingleDisruptionModeBuilder().build()));
  }
  
  public SingleNested<A> editOrNewSingleLike(SingleDisruptionMode item) {
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
    DisruptionModeFluent that = (DisruptionModeFluent) o;
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
  
  public A withAll(AllDisruptionMode all) {
    this._visitables.remove("all");
    if (all != null) {
        this.all = new AllDisruptionModeBuilder(all);
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
  
  public AllNested<A> withNewAllLike(AllDisruptionMode item) {
    return new AllNested(item);
  }
  
  public SingleNested<A> withNewSingle() {
    return new SingleNested(null);
  }
  
  public SingleNested<A> withNewSingleLike(SingleDisruptionMode item) {
    return new SingleNested(item);
  }
  
  public A withSingle(SingleDisruptionMode single) {
    this._visitables.remove("single");
    if (single != null) {
        this.single = new SingleDisruptionModeBuilder(single);
        this._visitables.get("single").add(this.single);
    } else {
        this.single = null;
        this._visitables.get("single").remove(this.single);
    }
    return (A) this;
  }
  public class AllNested<N> extends AllDisruptionModeFluent<AllNested<N>> implements Nested<N>{
  
    AllDisruptionModeBuilder builder;
  
    AllNested(AllDisruptionMode item) {
      this.builder = new AllDisruptionModeBuilder(this, item);
    }
  
    public N and() {
      return (N) DisruptionModeFluent.this.withAll(builder.build());
    }
    
    public N endAll() {
      return and();
    }
    
  }
  public class SingleNested<N> extends SingleDisruptionModeFluent<SingleNested<N>> implements Nested<N>{
  
    SingleDisruptionModeBuilder builder;
  
    SingleNested(SingleDisruptionMode item) {
      this.builder = new SingleDisruptionModeBuilder(this, item);
    }
  
    public N and() {
      return (N) DisruptionModeFluent.this.withSingle(builder.build());
    }
    
    public N endSingle() {
      return and();
    }
    
  }
}