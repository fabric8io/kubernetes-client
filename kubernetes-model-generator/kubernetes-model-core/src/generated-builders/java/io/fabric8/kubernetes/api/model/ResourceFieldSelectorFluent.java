package io.fabric8.kubernetes.api.model;

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
public class ResourceFieldSelectorFluent<A extends io.fabric8.kubernetes.api.model.ResourceFieldSelectorFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String containerName;
  private QuantityBuilder divisor;
  private String resource;

  public ResourceFieldSelectorFluent() {
  }
  
  public ResourceFieldSelectorFluent(ResourceFieldSelector instance) {
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
  
  public Quantity buildDivisor() {
    return this.divisor != null ? this.divisor.build() : null;
  }
  
  protected void copyInstance(ResourceFieldSelector instance) {
    instance = instance != null ? instance : new ResourceFieldSelector();
    if (instance != null) {
        this.withContainerName(instance.getContainerName());
        this.withDivisor(instance.getDivisor());
        this.withResource(instance.getResource());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DivisorNested<A> editDivisor() {
    return this.withNewDivisorLike(Optional.ofNullable(this.buildDivisor()).orElse(null));
  }
  
  public DivisorNested<A> editOrNewDivisor() {
    return this.withNewDivisorLike(Optional.ofNullable(this.buildDivisor()).orElse(new QuantityBuilder().build()));
  }
  
  public DivisorNested<A> editOrNewDivisorLike(Quantity item) {
    return this.withNewDivisorLike(Optional.ofNullable(this.buildDivisor()).orElse(item));
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
    ResourceFieldSelectorFluent that = (ResourceFieldSelectorFluent) o;
    if (!(Objects.equals(containerName, that.containerName))) {
      return false;
    }
    if (!(Objects.equals(divisor, that.divisor))) {
      return false;
    }
    if (!(Objects.equals(resource, that.resource))) {
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
  
  public String getContainerName() {
    return this.containerName;
  }
  
  public String getResource() {
    return this.resource;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasContainerName() {
    return this.containerName != null;
  }
  
  public boolean hasDivisor() {
    return this.divisor != null;
  }
  
  public boolean hasResource() {
    return this.resource != null;
  }
  
  public int hashCode() {
    return Objects.hash(containerName, divisor, resource, additionalProperties);
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
    if (!(containerName == null)) {
        sb.append("containerName:");
        sb.append(containerName);
        sb.append(",");
    }
    if (!(divisor == null)) {
        sb.append("divisor:");
        sb.append(divisor);
        sb.append(",");
    }
    if (!(resource == null)) {
        sb.append("resource:");
        sb.append(resource);
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
  
  public A withContainerName(String containerName) {
    this.containerName = containerName;
    return (A) this;
  }
  
  public A withDivisor(Quantity divisor) {
    this._visitables.remove("divisor");
    if (divisor != null) {
        this.divisor = new QuantityBuilder(divisor);
        this._visitables.get("divisor").add(this.divisor);
    } else {
        this.divisor = null;
        this._visitables.get("divisor").remove(this.divisor);
    }
    return (A) this;
  }
  
  public DivisorNested<A> withNewDivisor() {
    return new DivisorNested(null);
  }
  
  public A withNewDivisor(String amount) {
    return (A) this.withDivisor(new Quantity(amount));
  }
  
  public A withNewDivisor(String amount,String format) {
    return (A) this.withDivisor(new Quantity(amount, format));
  }
  
  public DivisorNested<A> withNewDivisorLike(Quantity item) {
    return new DivisorNested(item);
  }
  
  public A withResource(String resource) {
    this.resource = resource;
    return (A) this;
  }
  public class DivisorNested<N> extends QuantityFluent<DivisorNested<N>> implements Nested<N>{
  
    QuantityBuilder builder;
  
    DivisorNested(Quantity item) {
      this.builder = new QuantityBuilder(this, item);
    }
  
    public N and() {
      return (N) ResourceFieldSelectorFluent.this.withDivisor(builder.build());
    }
    
    public N endDivisor() {
      return and();
    }
    
  }
}