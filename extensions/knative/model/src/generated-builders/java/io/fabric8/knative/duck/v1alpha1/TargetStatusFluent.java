package io.fabric8.knative.duck.v1alpha1;

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
public class TargetStatusFluent<A extends io.fabric8.knative.duck.v1alpha1.TargetStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private TargetableBuilder targetable;

  public TargetStatusFluent() {
  }
  
  public TargetStatusFluent(TargetStatus instance) {
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
  
  public Targetable buildTargetable() {
    return this.targetable != null ? this.targetable.build() : null;
  }
  
  protected void copyInstance(TargetStatus instance) {
    instance = instance != null ? instance : new TargetStatus();
    if (instance != null) {
        this.withTargetable(instance.getTargetable());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public TargetableNested<A> editOrNewTargetable() {
    return this.withNewTargetableLike(Optional.ofNullable(this.buildTargetable()).orElse(new TargetableBuilder().build()));
  }
  
  public TargetableNested<A> editOrNewTargetableLike(Targetable item) {
    return this.withNewTargetableLike(Optional.ofNullable(this.buildTargetable()).orElse(item));
  }
  
  public TargetableNested<A> editTargetable() {
    return this.withNewTargetableLike(Optional.ofNullable(this.buildTargetable()).orElse(null));
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
    TargetStatusFluent that = (TargetStatusFluent) o;
    if (!(Objects.equals(targetable, that.targetable))) {
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
  
  public boolean hasTargetable() {
    return this.targetable != null;
  }
  
  public int hashCode() {
    return Objects.hash(targetable, additionalProperties);
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
    if (!(targetable == null)) {
        sb.append("targetable:");
        sb.append(targetable);
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
  
  public TargetableNested<A> withNewTargetable() {
    return new TargetableNested(null);
  }
  
  public A withNewTargetable(String domainInternal) {
    return (A) this.withTargetable(new Targetable(domainInternal));
  }
  
  public TargetableNested<A> withNewTargetableLike(Targetable item) {
    return new TargetableNested(item);
  }
  
  public A withTargetable(Targetable targetable) {
    this._visitables.remove("targetable");
    if (targetable != null) {
        this.targetable = new TargetableBuilder(targetable);
        this._visitables.get("targetable").add(this.targetable);
    } else {
        this.targetable = null;
        this._visitables.get("targetable").remove(this.targetable);
    }
    return (A) this;
  }
  public class TargetableNested<N> extends TargetableFluent<TargetableNested<N>> implements Nested<N>{
  
    TargetableBuilder builder;
  
    TargetableNested(Targetable item) {
      this.builder = new TargetableBuilder(this, item);
    }
  
    public N and() {
      return (N) TargetStatusFluent.this.withTargetable(builder.build());
    }
    
    public N endTargetable() {
      return and();
    }
    
  }
}