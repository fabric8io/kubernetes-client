package io.fabric8.openshift.api.model;

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
public class RouteHTTPHeaderActionUnionFluent<A extends io.fabric8.openshift.api.model.RouteHTTPHeaderActionUnionFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private RouteSetHTTPHeaderBuilder set;
  private String type;

  public RouteHTTPHeaderActionUnionFluent() {
  }
  
  public RouteHTTPHeaderActionUnionFluent(RouteHTTPHeaderActionUnion instance) {
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
  
  public RouteSetHTTPHeader buildSet() {
    return this.set != null ? this.set.build() : null;
  }
  
  protected void copyInstance(RouteHTTPHeaderActionUnion instance) {
    instance = instance != null ? instance : new RouteHTTPHeaderActionUnion();
    if (instance != null) {
        this.withSet(instance.getSet());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SetNested<A> editOrNewSet() {
    return this.withNewSetLike(Optional.ofNullable(this.buildSet()).orElse(new RouteSetHTTPHeaderBuilder().build()));
  }
  
  public SetNested<A> editOrNewSetLike(RouteSetHTTPHeader item) {
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
    RouteHTTPHeaderActionUnionFluent that = (RouteHTTPHeaderActionUnionFluent) o;
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
    return (A) this.withSet(new RouteSetHTTPHeader(value));
  }
  
  public SetNested<A> withNewSetLike(RouteSetHTTPHeader item) {
    return new SetNested(item);
  }
  
  public A withSet(RouteSetHTTPHeader set) {
    this._visitables.remove("set");
    if (set != null) {
        this.set = new RouteSetHTTPHeaderBuilder(set);
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
  public class SetNested<N> extends RouteSetHTTPHeaderFluent<SetNested<N>> implements Nested<N>{
  
    RouteSetHTTPHeaderBuilder builder;
  
    SetNested(RouteSetHTTPHeader item) {
      this.builder = new RouteSetHTTPHeaderBuilder(this, item);
    }
  
    public N and() {
      return (N) RouteHTTPHeaderActionUnionFluent.this.withSet(builder.build());
    }
    
    public N endSet() {
      return and();
    }
    
  }
}