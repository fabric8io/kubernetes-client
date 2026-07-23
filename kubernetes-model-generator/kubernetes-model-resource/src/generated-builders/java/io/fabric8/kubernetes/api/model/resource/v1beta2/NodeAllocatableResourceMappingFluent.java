package io.fabric8.kubernetes.api.model.resource.v1beta2;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.model.Quantity;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class NodeAllocatableResourceMappingFluent<A extends io.fabric8.kubernetes.api.model.resource.v1beta2.NodeAllocatableResourceMappingFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Quantity allocationMultiplier;
  private String capacityKey;

  public NodeAllocatableResourceMappingFluent() {
  }
  
  public NodeAllocatableResourceMappingFluent(NodeAllocatableResourceMapping instance) {
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
  
  protected void copyInstance(NodeAllocatableResourceMapping instance) {
    instance = instance != null ? instance : new NodeAllocatableResourceMapping();
    if (instance != null) {
        this.withAllocationMultiplier(instance.getAllocationMultiplier());
        this.withCapacityKey(instance.getCapacityKey());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
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
    NodeAllocatableResourceMappingFluent that = (NodeAllocatableResourceMappingFluent) o;
    if (!(Objects.equals(allocationMultiplier, that.allocationMultiplier))) {
      return false;
    }
    if (!(Objects.equals(capacityKey, that.capacityKey))) {
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
  
  public Quantity getAllocationMultiplier() {
    return this.allocationMultiplier;
  }
  
  public String getCapacityKey() {
    return this.capacityKey;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAllocationMultiplier() {
    return this.allocationMultiplier != null;
  }
  
  public boolean hasCapacityKey() {
    return this.capacityKey != null;
  }
  
  public int hashCode() {
    return Objects.hash(allocationMultiplier, capacityKey, additionalProperties);
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
    if (!(allocationMultiplier == null)) {
        sb.append("allocationMultiplier:");
        sb.append(allocationMultiplier);
        sb.append(",");
    }
    if (!(capacityKey == null)) {
        sb.append("capacityKey:");
        sb.append(capacityKey);
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
  
  public A withAllocationMultiplier(Quantity allocationMultiplier) {
    this.allocationMultiplier = allocationMultiplier;
    return (A) this;
  }
  
  public A withCapacityKey(String capacityKey) {
    this.capacityKey = capacityKey;
    return (A) this;
  }
  
  public A withNewAllocationMultiplier(String amount) {
    return (A) this.withAllocationMultiplier(new Quantity(amount));
  }
  
  public A withNewAllocationMultiplier(String amount,String format) {
    return (A) this.withAllocationMultiplier(new Quantity(amount, format));
  }
  
}