package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

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
public class SortOptionsFluent<A extends io.fabric8.kubernetes.api.model.kustomize.v1beta1.SortOptionsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private LegacySortOptionsBuilder legacySortOptions;
  private String order;

  public SortOptionsFluent() {
  }
  
  public SortOptionsFluent(SortOptions instance) {
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
  
  public LegacySortOptions buildLegacySortOptions() {
    return this.legacySortOptions != null ? this.legacySortOptions.build() : null;
  }
  
  protected void copyInstance(SortOptions instance) {
    instance = instance != null ? instance : new SortOptions();
    if (instance != null) {
        this.withLegacySortOptions(instance.getLegacySortOptions());
        this.withOrder(instance.getOrder());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public LegacySortOptionsNested<A> editLegacySortOptions() {
    return this.withNewLegacySortOptionsLike(Optional.ofNullable(this.buildLegacySortOptions()).orElse(null));
  }
  
  public LegacySortOptionsNested<A> editOrNewLegacySortOptions() {
    return this.withNewLegacySortOptionsLike(Optional.ofNullable(this.buildLegacySortOptions()).orElse(new LegacySortOptionsBuilder().build()));
  }
  
  public LegacySortOptionsNested<A> editOrNewLegacySortOptionsLike(LegacySortOptions item) {
    return this.withNewLegacySortOptionsLike(Optional.ofNullable(this.buildLegacySortOptions()).orElse(item));
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
    SortOptionsFluent that = (SortOptionsFluent) o;
    if (!(Objects.equals(legacySortOptions, that.legacySortOptions))) {
      return false;
    }
    if (!(Objects.equals(order, that.order))) {
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
  
  public String getOrder() {
    return this.order;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasLegacySortOptions() {
    return this.legacySortOptions != null;
  }
  
  public boolean hasOrder() {
    return this.order != null;
  }
  
  public int hashCode() {
    return Objects.hash(legacySortOptions, order, additionalProperties);
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
    if (!(legacySortOptions == null)) {
        sb.append("legacySortOptions:");
        sb.append(legacySortOptions);
        sb.append(",");
    }
    if (!(order == null)) {
        sb.append("order:");
        sb.append(order);
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
  
  public A withLegacySortOptions(LegacySortOptions legacySortOptions) {
    this._visitables.remove("legacySortOptions");
    if (legacySortOptions != null) {
        this.legacySortOptions = new LegacySortOptionsBuilder(legacySortOptions);
        this._visitables.get("legacySortOptions").add(this.legacySortOptions);
    } else {
        this.legacySortOptions = null;
        this._visitables.get("legacySortOptions").remove(this.legacySortOptions);
    }
    return (A) this;
  }
  
  public LegacySortOptionsNested<A> withNewLegacySortOptions() {
    return new LegacySortOptionsNested(null);
  }
  
  public LegacySortOptionsNested<A> withNewLegacySortOptionsLike(LegacySortOptions item) {
    return new LegacySortOptionsNested(item);
  }
  
  public A withOrder(String order) {
    this.order = order;
    return (A) this;
  }
  public class LegacySortOptionsNested<N> extends LegacySortOptionsFluent<LegacySortOptionsNested<N>> implements Nested<N>{
  
    LegacySortOptionsBuilder builder;
  
    LegacySortOptionsNested(LegacySortOptions item) {
      this.builder = new LegacySortOptionsBuilder(this, item);
    }
  
    public N and() {
      return (N) SortOptionsFluent.this.withLegacySortOptions(builder.build());
    }
    
    public N endLegacySortOptions() {
      return and();
    }
    
  }
}