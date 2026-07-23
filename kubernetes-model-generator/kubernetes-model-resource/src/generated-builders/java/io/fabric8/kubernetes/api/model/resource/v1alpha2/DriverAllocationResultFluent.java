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
public class DriverAllocationResultFluent<A extends io.fabric8.kubernetes.api.model.resource.v1alpha2.DriverAllocationResultFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private NamedResourcesAllocationResultBuilder namedResources;
  private Object vendorRequestParameters;

  public DriverAllocationResultFluent() {
  }
  
  public DriverAllocationResultFluent(DriverAllocationResult instance) {
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
  
  public NamedResourcesAllocationResult buildNamedResources() {
    return this.namedResources != null ? this.namedResources.build() : null;
  }
  
  protected void copyInstance(DriverAllocationResult instance) {
    instance = instance != null ? instance : new DriverAllocationResult();
    if (instance != null) {
        this.withNamedResources(instance.getNamedResources());
        this.withVendorRequestParameters(instance.getVendorRequestParameters());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public NamedResourcesNested<A> editNamedResources() {
    return this.withNewNamedResourcesLike(Optional.ofNullable(this.buildNamedResources()).orElse(null));
  }
  
  public NamedResourcesNested<A> editOrNewNamedResources() {
    return this.withNewNamedResourcesLike(Optional.ofNullable(this.buildNamedResources()).orElse(new NamedResourcesAllocationResultBuilder().build()));
  }
  
  public NamedResourcesNested<A> editOrNewNamedResourcesLike(NamedResourcesAllocationResult item) {
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
    DriverAllocationResultFluent that = (DriverAllocationResultFluent) o;
    if (!(Objects.equals(namedResources, that.namedResources))) {
      return false;
    }
    if (!(Objects.equals(vendorRequestParameters, that.vendorRequestParameters))) {
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
  
  public Object getVendorRequestParameters() {
    return this.vendorRequestParameters;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasNamedResources() {
    return this.namedResources != null;
  }
  
  public boolean hasVendorRequestParameters() {
    return this.vendorRequestParameters != null;
  }
  
  public int hashCode() {
    return Objects.hash(namedResources, vendorRequestParameters, additionalProperties);
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
    if (!(namedResources == null)) {
        sb.append("namedResources:");
        sb.append(namedResources);
        sb.append(",");
    }
    if (!(vendorRequestParameters == null)) {
        sb.append("vendorRequestParameters:");
        sb.append(vendorRequestParameters);
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
  
  public A withNamedResources(NamedResourcesAllocationResult namedResources) {
    this._visitables.remove("namedResources");
    if (namedResources != null) {
        this.namedResources = new NamedResourcesAllocationResultBuilder(namedResources);
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
  
  public A withNewNamedResources(String name) {
    return (A) this.withNamedResources(new NamedResourcesAllocationResult(name));
  }
  
  public NamedResourcesNested<A> withNewNamedResourcesLike(NamedResourcesAllocationResult item) {
    return new NamedResourcesNested(item);
  }
  
  public A withVendorRequestParameters(Object vendorRequestParameters) {
    this.vendorRequestParameters = vendorRequestParameters;
    return (A) this;
  }
  public class NamedResourcesNested<N> extends NamedResourcesAllocationResultFluent<NamedResourcesNested<N>> implements Nested<N>{
  
    NamedResourcesAllocationResultBuilder builder;
  
    NamedResourcesNested(NamedResourcesAllocationResult item) {
      this.builder = new NamedResourcesAllocationResultBuilder(this, item);
    }
  
    public N and() {
      return (N) DriverAllocationResultFluent.this.withNamedResources(builder.build());
    }
    
    public N endNamedResources() {
      return and();
    }
    
  }
}