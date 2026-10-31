package io.fabric8.kubernetes.api.model.resource.v1alpha3;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Integer;
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
public class PartitionTypeStatusFluent<A extends io.fabric8.kubernetes.api.model.resource.v1alpha3.PartitionTypeStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer allocatable;
  private String attribute;
  private Integer total;
  private String type;

  public PartitionTypeStatusFluent() {
  }
  
  public PartitionTypeStatusFluent(PartitionTypeStatus instance) {
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
  
  protected void copyInstance(PartitionTypeStatus instance) {
    instance = instance != null ? instance : new PartitionTypeStatus();
    if (instance != null) {
        this.withAllocatable(instance.getAllocatable());
        this.withAttribute(instance.getAttribute());
        this.withTotal(instance.getTotal());
        this.withType(instance.getType());
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
    PartitionTypeStatusFluent that = (PartitionTypeStatusFluent) o;
    if (!(Objects.equals(allocatable, that.allocatable))) {
      return false;
    }
    if (!(Objects.equals(attribute, that.attribute))) {
      return false;
    }
    if (!(Objects.equals(total, that.total))) {
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
  
  public Integer getAllocatable() {
    return this.allocatable;
  }
  
  public String getAttribute() {
    return this.attribute;
  }
  
  public Integer getTotal() {
    return this.total;
  }
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAllocatable() {
    return this.allocatable != null;
  }
  
  public boolean hasAttribute() {
    return this.attribute != null;
  }
  
  public boolean hasTotal() {
    return this.total != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(allocatable, attribute, total, type, additionalProperties);
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
    if (!(allocatable == null)) {
        sb.append("allocatable:");
        sb.append(allocatable);
        sb.append(",");
    }
    if (!(attribute == null)) {
        sb.append("attribute:");
        sb.append(attribute);
        sb.append(",");
    }
    if (!(total == null)) {
        sb.append("total:");
        sb.append(total);
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
  
  public A withAllocatable(Integer allocatable) {
    this.allocatable = allocatable;
    return (A) this;
  }
  
  public A withAttribute(String attribute) {
    this.attribute = attribute;
    return (A) this;
  }
  
  public A withTotal(Integer total) {
    this.total = total;
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  
}