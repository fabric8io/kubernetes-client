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
public class NodeAllocatableMappedResourcesFluent<A extends io.fabric8.kubernetes.api.model.NodeAllocatableMappedResourcesFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String name;
  private QuantityBuilder quantity;

  public NodeAllocatableMappedResourcesFluent() {
  }
  
  public NodeAllocatableMappedResourcesFluent(NodeAllocatableMappedResources instance) {
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
  
  public Quantity buildQuantity() {
    return this.quantity != null ? this.quantity.build() : null;
  }
  
  protected void copyInstance(NodeAllocatableMappedResources instance) {
    instance = instance != null ? instance : new NodeAllocatableMappedResources();
    if (instance != null) {
        this.withName(instance.getName());
        this.withQuantity(instance.getQuantity());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public QuantityNested<A> editOrNewQuantity() {
    return this.withNewQuantityLike(Optional.ofNullable(this.buildQuantity()).orElse(new QuantityBuilder().build()));
  }
  
  public QuantityNested<A> editOrNewQuantityLike(Quantity item) {
    return this.withNewQuantityLike(Optional.ofNullable(this.buildQuantity()).orElse(item));
  }
  
  public QuantityNested<A> editQuantity() {
    return this.withNewQuantityLike(Optional.ofNullable(this.buildQuantity()).orElse(null));
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
    NodeAllocatableMappedResourcesFluent that = (NodeAllocatableMappedResourcesFluent) o;
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(quantity, that.quantity))) {
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
  
  public boolean hasQuantity() {
    return this.quantity != null;
  }
  
  public int hashCode() {
    return Objects.hash(name, quantity, additionalProperties);
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
    if (!(quantity == null)) {
        sb.append("quantity:");
        sb.append(quantity);
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
  
  public QuantityNested<A> withNewQuantity() {
    return new QuantityNested(null);
  }
  
  public A withNewQuantity(String amount) {
    return (A) this.withQuantity(new Quantity(amount));
  }
  
  public A withNewQuantity(String amount,String format) {
    return (A) this.withQuantity(new Quantity(amount, format));
  }
  
  public QuantityNested<A> withNewQuantityLike(Quantity item) {
    return new QuantityNested(item);
  }
  
  public A withQuantity(Quantity quantity) {
    this._visitables.remove("quantity");
    if (quantity != null) {
        this.quantity = new QuantityBuilder(quantity);
        this._visitables.get("quantity").add(this.quantity);
    } else {
        this.quantity = null;
        this._visitables.get("quantity").remove(this.quantity);
    }
    return (A) this;
  }
  public class QuantityNested<N> extends QuantityFluent<QuantityNested<N>> implements Nested<N>{
  
    QuantityBuilder builder;
  
    QuantityNested(Quantity item) {
      this.builder = new QuantityBuilder(this, item);
    }
  
    public N and() {
      return (N) NodeAllocatableMappedResourcesFluent.this.withQuantity(builder.build());
    }
    
    public N endQuantity() {
      return and();
    }
    
  }
}