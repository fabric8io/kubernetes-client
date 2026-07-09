package io.fabric8.kubernetes.api.model.resource.v1alpha2;

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
public class ResourceFilterFluent<A extends io.fabric8.kubernetes.api.model.resource.v1alpha2.ResourceFilterFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String driverName;
  private NamedResourcesFilterBuilder namedResources;

  public ResourceFilterFluent() {
  }
  
  public ResourceFilterFluent(ResourceFilter instance) {
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
  
  public NamedResourcesFilter buildNamedResources() {
    return this.namedResources != null ? this.namedResources.build() : null;
  }
  
  protected void copyInstance(ResourceFilter instance) {
    instance = instance != null ? instance : new ResourceFilter();
    if (instance != null) {
        this.withDriverName(instance.getDriverName());
        this.withNamedResources(instance.getNamedResources());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public NamedResourcesNested<A> editNamedResources() {
    return this.withNewNamedResourcesLike(Optional.ofNullable(this.buildNamedResources()).orElse(null));
  }
  
  public NamedResourcesNested<A> editOrNewNamedResources() {
    return this.withNewNamedResourcesLike(Optional.ofNullable(this.buildNamedResources()).orElse(new NamedResourcesFilterBuilder().build()));
  }
  
  public NamedResourcesNested<A> editOrNewNamedResourcesLike(NamedResourcesFilter item) {
    return this.withNewNamedResourcesLike(Optional.ofNullable(this.buildNamedResources()).orElse(item));
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
    ResourceFilterFluent that = (ResourceFilterFluent) o;
    if (!(Objects.equals(driverName, that.driverName))) {
      return false;
    }
    if (!(Objects.equals(namedResources, that.namedResources))) {
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
  
  public String getDriverName() {
    return this.driverName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDriverName() {
    return this.driverName != null;
  }
  
  public boolean hasNamedResources() {
    return this.namedResources != null;
  }
  
  public int hashCode() {
    return Objects.hash(driverName, namedResources, additionalProperties);
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
    if (!(driverName == null)) {
        sb.append("driverName:");
        sb.append(driverName);
        sb.append(",");
    }
    if (!(namedResources == null)) {
        sb.append("namedResources:");
        sb.append(namedResources);
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
  
  public A withDriverName(String driverName) {
    this.driverName = driverName;
    return (A) this;
  }
  
  public A withNamedResources(NamedResourcesFilter namedResources) {
    this._visitables.remove("namedResources");
    if (namedResources != null) {
        this.namedResources = new NamedResourcesFilterBuilder(namedResources);
        this._visitables.get("namedResources").add(this.namedResources);
    } else {
        this.namedResources = null;
        this._visitables.get("namedResources").remove(this.namedResources);
    }
    return (A) this;
  }
  
  public NamedResourcesNested<A> withNewNamedResources() {
    return new NamedResourcesNested(null);
  }
  
  public A withNewNamedResources(String selector) {
    return (A) this.withNamedResources(new NamedResourcesFilter(selector));
  }
  
  public NamedResourcesNested<A> withNewNamedResourcesLike(NamedResourcesFilter item) {
    return new NamedResourcesNested(item);
  }
  public class NamedResourcesNested<N> extends NamedResourcesFilterFluent<NamedResourcesNested<N>> implements Nested<N>{
  
    NamedResourcesFilterBuilder builder;
  
    NamedResourcesNested(NamedResourcesFilter item) {
      this.builder = new NamedResourcesFilterBuilder(this, item);
    }
  
    public N and() {
      return (N) ResourceFilterFluent.this.withNamedResources(builder.build());
    }
    
    public N endNamedResources() {
      return and();
    }
    
  }
}