package io.fabric8.openshift.api.model.operator.v1;

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
public class IngressControllerHTTPHeaderActionUnionFluent<A extends io.fabric8.openshift.api.model.operator.v1.IngressControllerHTTPHeaderActionUnionFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private IngressControllerSetHTTPHeaderBuilder set;
  private String type;

  public IngressControllerHTTPHeaderActionUnionFluent() {
  }
  
  public IngressControllerHTTPHeaderActionUnionFluent(IngressControllerHTTPHeaderActionUnion instance) {
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
  
  public IngressControllerSetHTTPHeader buildSet() {
    return this.set != null ? this.set.build() : null;
  }
  
  protected void copyInstance(IngressControllerHTTPHeaderActionUnion instance) {
    instance = instance != null ? instance : new IngressControllerHTTPHeaderActionUnion();
    if (instance != null) {
        this.withSet(instance.getSet());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SetNested<A> editOrNewSet() {
    return this.withNewSetLike(Optional.ofNullable(this.buildSet()).orElse(new IngressControllerSetHTTPHeaderBuilder().build()));
  }
  
  public SetNested<A> editOrNewSetLike(IngressControllerSetHTTPHeader item) {
    return this.withNewSetLike(Optional.ofNullable(this.buildSet()).orElse(item));
  }
  
  public SetNested<A> editSet() {
    return this.withNewSetLike(Optional.ofNullable(this.buildSet()).orElse(null));
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
    IngressControllerHTTPHeaderActionUnionFluent that = (IngressControllerHTTPHeaderActionUnionFluent) o;
    if (!(Objects.equals(set, that.set))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
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
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasSet() {
    return this.set != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(set, type, additionalProperties);
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
    if (!(set == null)) {
        sb.append("set:");
        sb.append(set);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
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
  
  public SetNested<A> withNewSet() {
    return new SetNested(null);
  }
  
  public A withNewSet(String value) {
    return (A) this.withSet(new IngressControllerSetHTTPHeader(value));
  }
  
  public SetNested<A> withNewSetLike(IngressControllerSetHTTPHeader item) {
    return new SetNested(item);
  }
  
  public A withSet(IngressControllerSetHTTPHeader set) {
    this._visitables.remove("set");
    if (set != null) {
        this.set = new IngressControllerSetHTTPHeaderBuilder(set);
        this._visitables.get("set").add(this.set);
    } else {
        this.set = null;
        this._visitables.get("set").remove(this.set);
    }
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class SetNested<N> extends IngressControllerSetHTTPHeaderFluent<SetNested<N>> implements Nested<N>{
  
    IngressControllerSetHTTPHeaderBuilder builder;
  
    SetNested(IngressControllerSetHTTPHeader item) {
      this.builder = new IngressControllerSetHTTPHeaderBuilder(this, item);
    }
  
    public N and() {
      return (N) IngressControllerHTTPHeaderActionUnionFluent.this.withSet(builder.build());
    }
    
    public N endSet() {
      return and();
    }
    
  }
}