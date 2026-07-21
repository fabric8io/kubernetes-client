package io.fabric8.openclustermanagement.api.model.discovery.v1alpha1;

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
public class DiscoveryConfigSpecFluent<A extends io.fabric8.openclustermanagement.api.model.discovery.v1alpha1.DiscoveryConfigSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String credential;
  private FilterBuilder filters;

  public DiscoveryConfigSpecFluent() {
  }
  
  public DiscoveryConfigSpecFluent(DiscoveryConfigSpec instance) {
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
  
  public Filter buildFilters() {
    return this.filters != null ? this.filters.build() : null;
  }
  
  protected void copyInstance(DiscoveryConfigSpec instance) {
    instance = instance != null ? instance : new DiscoveryConfigSpec();
    if (instance != null) {
        this.withCredential(instance.getCredential());
        this.withFilters(instance.getFilters());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public FiltersNested<A> editFilters() {
    return this.withNewFiltersLike(Optional.ofNullable(this.buildFilters()).orElse(null));
  }
  
  public FiltersNested<A> editOrNewFilters() {
    return this.withNewFiltersLike(Optional.ofNullable(this.buildFilters()).orElse(new FilterBuilder().build()));
  }
  
  public FiltersNested<A> editOrNewFiltersLike(Filter item) {
    return this.withNewFiltersLike(Optional.ofNullable(this.buildFilters()).orElse(item));
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
    DiscoveryConfigSpecFluent that = (DiscoveryConfigSpecFluent) o;
    if (!(Objects.equals(credential, that.credential))) {
      return false;
    }
    if (!(Objects.equals(filters, that.filters))) {
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
  
  public String getCredential() {
    return this.credential;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCredential() {
    return this.credential != null;
  }
  
  public boolean hasFilters() {
    return this.filters != null;
  }
  
  public int hashCode() {
    return Objects.hash(credential, filters, additionalProperties);
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
    if (!(credential == null)) {
        sb.append("credential:");
        sb.append(credential);
        sb.append(",");
    }
    if (!(filters == null)) {
        sb.append("filters:");
        sb.append(filters);
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
  
  public A withCredential(String credential) {
    this.credential = credential;
    return (A) this;
  }
  
  public A withFilters(Filter filters) {
    this._visitables.remove("filters");
    if (filters != null) {
        this.filters = new FilterBuilder(filters);
        this._visitables.get("filters").add(this.filters);
    } else {
        this.filters = null;
        this._visitables.get("filters").remove(this.filters);
    }
    return (A) this;
  }
  
  public FiltersNested<A> withNewFilters() {
    return new FiltersNested(null);
  }
  
  public FiltersNested<A> withNewFiltersLike(Filter item) {
    return new FiltersNested(item);
  }
  public class FiltersNested<N> extends FilterFluent<FiltersNested<N>> implements Nested<N>{
  
    FilterBuilder builder;
  
    FiltersNested(Filter item) {
      this.builder = new FilterBuilder(this, item);
    }
  
    public N and() {
      return (N) DiscoveryConfigSpecFluent.this.withFilters(builder.build());
    }
    
    public N endFilters() {
      return and();
    }
    
  }
}