package io.fabric8.kubernetes.api.model.resource.v1;

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
public class NodeAllocatableMappingFluent<A extends io.fabric8.kubernetes.api.model.resource.v1.NodeAllocatableMappingFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String capacityKey;
  private Quantity capacityMultiplier;
  private Quantity deviceMultiplier;

  public NodeAllocatableMappingFluent() {
  }
  
  public NodeAllocatableMappingFluent(NodeAllocatableMapping instance) {
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
  
  protected void copyInstance(NodeAllocatableMapping instance) {
    instance = instance != null ? instance : new NodeAllocatableMapping();
    if (instance != null) {
        this.withCapacityKey(instance.getCapacityKey());
        this.withCapacityMultiplier(instance.getCapacityMultiplier());
        this.withDeviceMultiplier(instance.getDeviceMultiplier());
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
    NodeAllocatableMappingFluent that = (NodeAllocatableMappingFluent) o;
    if (!(Objects.equals(capacityKey, that.capacityKey))) {
      return false;
    }
    if (!(Objects.equals(capacityMultiplier, that.capacityMultiplier))) {
      return false;
    }
    if (!(Objects.equals(deviceMultiplier, that.deviceMultiplier))) {
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
  
  public String getCapacityKey() {
    return this.capacityKey;
  }
  
  public Quantity getCapacityMultiplier() {
    return this.capacityMultiplier;
  }
  
  public Quantity getDeviceMultiplier() {
    return this.deviceMultiplier;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCapacityKey() {
    return this.capacityKey != null;
  }
  
  public boolean hasCapacityMultiplier() {
    return this.capacityMultiplier != null;
  }
  
  public boolean hasDeviceMultiplier() {
    return this.deviceMultiplier != null;
  }
  
  public int hashCode() {
    return Objects.hash(capacityKey, capacityMultiplier, deviceMultiplier, additionalProperties);
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
    if (!(capacityKey == null)) {
        sb.append("capacityKey:");
        sb.append(capacityKey);
        sb.append(",");
    }
    if (!(capacityMultiplier == null)) {
        sb.append("capacityMultiplier:");
        sb.append(capacityMultiplier);
        sb.append(",");
    }
    if (!(deviceMultiplier == null)) {
        sb.append("deviceMultiplier:");
        sb.append(deviceMultiplier);
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
  
  public A withCapacityKey(String capacityKey) {
    this.capacityKey = capacityKey;
    return (A) this;
  }
  
  public A withCapacityMultiplier(Quantity capacityMultiplier) {
    this.capacityMultiplier = capacityMultiplier;
    return (A) this;
  }
  
  public A withDeviceMultiplier(Quantity deviceMultiplier) {
    this.deviceMultiplier = deviceMultiplier;
    return (A) this;
  }
  
  public A withNewCapacityMultiplier(String amount) {
    return (A) this.withCapacityMultiplier(new Quantity(amount));
  }
  
  public A withNewCapacityMultiplier(String amount,String format) {
    return (A) this.withCapacityMultiplier(new Quantity(amount, format));
  }
  
  public A withNewDeviceMultiplier(String amount) {
    return (A) this.withDeviceMultiplier(new Quantity(amount));
  }
  
  public A withNewDeviceMultiplier(String amount,String format) {
    return (A) this.withDeviceMultiplier(new Quantity(amount, format));
  }
  
}