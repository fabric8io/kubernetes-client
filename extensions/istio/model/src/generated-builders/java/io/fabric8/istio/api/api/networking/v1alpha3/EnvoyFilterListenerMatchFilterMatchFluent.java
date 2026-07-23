package io.fabric8.istio.api.api.networking.v1alpha3;

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
public class EnvoyFilterListenerMatchFilterMatchFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.EnvoyFilterListenerMatchFilterMatchFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String name;
  private EnvoyFilterListenerMatchSubFilterMatchBuilder subFilter;

  public EnvoyFilterListenerMatchFilterMatchFluent() {
  }
  
  public EnvoyFilterListenerMatchFilterMatchFluent(EnvoyFilterListenerMatchFilterMatch instance) {
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
  
  public EnvoyFilterListenerMatchSubFilterMatch buildSubFilter() {
    return this.subFilter != null ? this.subFilter.build() : null;
  }
  
  protected void copyInstance(EnvoyFilterListenerMatchFilterMatch instance) {
    instance = instance != null ? instance : new EnvoyFilterListenerMatchFilterMatch();
    if (instance != null) {
        this.withName(instance.getName());
        this.withSubFilter(instance.getSubFilter());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SubFilterNested<A> editOrNewSubFilter() {
    return this.withNewSubFilterLike(Optional.ofNullable(this.buildSubFilter()).orElse(new EnvoyFilterListenerMatchSubFilterMatchBuilder().build()));
  }
  
  public SubFilterNested<A> editOrNewSubFilterLike(EnvoyFilterListenerMatchSubFilterMatch item) {
    return this.withNewSubFilterLike(Optional.ofNullable(this.buildSubFilter()).orElse(item));
  }
  
  public SubFilterNested<A> editSubFilter() {
    return this.withNewSubFilterLike(Optional.ofNullable(this.buildSubFilter()).orElse(null));
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
    EnvoyFilterListenerMatchFilterMatchFluent that = (EnvoyFilterListenerMatchFilterMatchFluent) o;
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(subFilter, that.subFilter))) {
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
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasSubFilter() {
    return this.subFilter != null;
  }
  
  public int hashCode() {
    return Objects.hash(name, subFilter, additionalProperties);
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
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(subFilter == null)) {
        sb.append("subFilter:");
        sb.append(subFilter);
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
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public SubFilterNested<A> withNewSubFilter() {
    return new SubFilterNested(null);
  }
  
  public A withNewSubFilter(String name) {
    return (A) this.withSubFilter(new EnvoyFilterListenerMatchSubFilterMatch(name));
  }
  
  public SubFilterNested<A> withNewSubFilterLike(EnvoyFilterListenerMatchSubFilterMatch item) {
    return new SubFilterNested(item);
  }
  
  public A withSubFilter(EnvoyFilterListenerMatchSubFilterMatch subFilter) {
    this._visitables.remove("subFilter");
    if (subFilter != null) {
        this.subFilter = new EnvoyFilterListenerMatchSubFilterMatchBuilder(subFilter);
        this._visitables.get("subFilter").add(this.subFilter);
    } else {
        this.subFilter = null;
        this._visitables.get("subFilter").remove(this.subFilter);
    }
    return (A) this;
  }
  public class SubFilterNested<N> extends EnvoyFilterListenerMatchSubFilterMatchFluent<SubFilterNested<N>> implements Nested<N>{
  
    EnvoyFilterListenerMatchSubFilterMatchBuilder builder;
  
    SubFilterNested(EnvoyFilterListenerMatchSubFilterMatch item) {
      this.builder = new EnvoyFilterListenerMatchSubFilterMatchBuilder(this, item);
    }
  
    public N and() {
      return (N) EnvoyFilterListenerMatchFilterMatchFluent.this.withSubFilter(builder.build());
    }
    
    public N endSubFilter() {
      return and();
    }
    
  }
}