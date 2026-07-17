package io.fabric8.openshift.api.model.machine.v1alpha1;

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
public class SecurityGroupParamFluent<A extends io.fabric8.openshift.api.model.machine.v1alpha1.SecurityGroupParamFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private SecurityGroupFilterBuilder filter;
  private String name;
  private String uuid;

  public SecurityGroupParamFluent() {
  }
  
  public SecurityGroupParamFluent(SecurityGroupParam instance) {
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
  
  public SecurityGroupFilter buildFilter() {
    return this.filter != null ? this.filter.build() : null;
  }
  
  protected void copyInstance(SecurityGroupParam instance) {
    instance = instance != null ? instance : new SecurityGroupParam();
    if (instance != null) {
        this.withFilter(instance.getFilter());
        this.withName(instance.getName());
        this.withUuid(instance.getUuid());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public FilterNested<A> editFilter() {
    return this.withNewFilterLike(Optional.ofNullable(this.buildFilter()).orElse(null));
  }
  
  public FilterNested<A> editOrNewFilter() {
    return this.withNewFilterLike(Optional.ofNullable(this.buildFilter()).orElse(new SecurityGroupFilterBuilder().build()));
  }
  
  public FilterNested<A> editOrNewFilterLike(SecurityGroupFilter item) {
    return this.withNewFilterLike(Optional.ofNullable(this.buildFilter()).orElse(item));
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
    SecurityGroupParamFluent that = (SecurityGroupParamFluent) o;
    if (!(Objects.equals(filter, that.filter))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(uuid, that.uuid))) {
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
  
  public String getUuid() {
    return this.uuid;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasFilter() {
    return this.filter != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasUuid() {
    return this.uuid != null;
  }
  
  public int hashCode() {
    return Objects.hash(filter, name, uuid, additionalProperties);
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
    if (!(filter == null)) {
        sb.append("filter:");
        sb.append(filter);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(uuid == null)) {
        sb.append("uuid:");
        sb.append(uuid);
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
  
  public A withFilter(SecurityGroupFilter filter) {
    this._visitables.remove("filter");
    if (filter != null) {
        this.filter = new SecurityGroupFilterBuilder(filter);
        this._visitables.get("filter").add(this.filter);
    } else {
        this.filter = null;
        this._visitables.get("filter").remove(this.filter);
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public FilterNested<A> withNewFilter() {
    return new FilterNested(null);
  }
  
  public FilterNested<A> withNewFilterLike(SecurityGroupFilter item) {
    return new FilterNested(item);
  }
  
  public A withUuid(String uuid) {
    this.uuid = uuid;
    return (A) this;
  }
  public class FilterNested<N> extends SecurityGroupFilterFluent<FilterNested<N>> implements Nested<N>{
  
    SecurityGroupFilterBuilder builder;
  
    FilterNested(SecurityGroupFilter item) {
      this.builder = new SecurityGroupFilterBuilder(this, item);
    }
  
    public N and() {
      return (N) SecurityGroupParamFluent.this.withFilter(builder.build());
    }
    
    public N endFilter() {
      return and();
    }
    
  }
}