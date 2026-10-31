package io.fabric8.kubernetes.api.model.resource.v1alpha3;

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
public class ShareableCapacityStatusFluent<A extends io.fabric8.kubernetes.api.model.resource.v1alpha3.ShareableCapacityStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Quantity available;
  private Quantity consumed;
  private String name;
  private Quantity total;

  public ShareableCapacityStatusFluent() {
  }
  
  public ShareableCapacityStatusFluent(ShareableCapacityStatus instance) {
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
  
  protected void copyInstance(ShareableCapacityStatus instance) {
    instance = instance != null ? instance : new ShareableCapacityStatus();
    if (instance != null) {
        this.withAvailable(instance.getAvailable());
        this.withConsumed(instance.getConsumed());
        this.withName(instance.getName());
        this.withTotal(instance.getTotal());
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
    ShareableCapacityStatusFluent that = (ShareableCapacityStatusFluent) o;
    if (!(Objects.equals(available, that.available))) {
      return false;
    }
    if (!(Objects.equals(consumed, that.consumed))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(total, that.total))) {
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
  
  public Quantity getAvailable() {
    return this.available;
  }
  
  public Quantity getConsumed() {
    return this.consumed;
  }
  
  public String getName() {
    return this.name;
  }
  
  public Quantity getTotal() {
    return this.total;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAvailable() {
    return this.available != null;
  }
  
  public boolean hasConsumed() {
    return this.consumed != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasTotal() {
    return this.total != null;
  }
  
  public int hashCode() {
    return Objects.hash(available, consumed, name, total, additionalProperties);
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
    if (!(available == null)) {
        sb.append("available:");
        sb.append(available);
        sb.append(",");
    }
    if (!(consumed == null)) {
        sb.append("consumed:");
        sb.append(consumed);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(total == null)) {
        sb.append("total:");
        sb.append(total);
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
  
  public A withAvailable(Quantity available) {
    this.available = available;
    return (A) this;
  }
  
  public A withConsumed(Quantity consumed) {
    this.consumed = consumed;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withNewAvailable(String amount) {
    return (A) this.withAvailable(new Quantity(amount));
  }
  
  public A withNewAvailable(String amount,String format) {
    return (A) this.withAvailable(new Quantity(amount, format));
  }
  
  public A withNewConsumed(String amount) {
    return (A) this.withConsumed(new Quantity(amount));
  }
  
  public A withNewConsumed(String amount,String format) {
    return (A) this.withConsumed(new Quantity(amount, format));
  }
  
  public A withNewTotal(String amount) {
    return (A) this.withTotal(new Quantity(amount));
  }
  
  public A withNewTotal(String amount,String format) {
    return (A) this.withTotal(new Quantity(amount, format));
  }
  
  public A withTotal(Quantity total) {
    this.total = total;
    return (A) this;
  }
  
}