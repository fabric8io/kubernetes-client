package io.fabric8.autoscaling.api.model.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.model.Quantity;
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
public class GenericStartupBoostFluent<A extends io.fabric8.autoscaling.api.model.v1.GenericStartupBoostFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer durationSeconds;
  private Integer factor;
  private Quantity quantity;
  private String type;

  public GenericStartupBoostFluent() {
  }
  
  public GenericStartupBoostFluent(GenericStartupBoost instance) {
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
  
  protected void copyInstance(GenericStartupBoost instance) {
    instance = instance != null ? instance : new GenericStartupBoost();
    if (instance != null) {
        this.withDurationSeconds(instance.getDurationSeconds());
        this.withFactor(instance.getFactor());
        this.withQuantity(instance.getQuantity());
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
    GenericStartupBoostFluent that = (GenericStartupBoostFluent) o;
    if (!(Objects.equals(durationSeconds, that.durationSeconds))) {
      return false;
    }
    if (!(Objects.equals(factor, that.factor))) {
      return false;
    }
    if (!(Objects.equals(quantity, that.quantity))) {
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
  
  public Integer getDurationSeconds() {
    return this.durationSeconds;
  }
  
  public Integer getFactor() {
    return this.factor;
  }
  
  public Quantity getQuantity() {
    return this.quantity;
  }
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDurationSeconds() {
    return this.durationSeconds != null;
  }
  
  public boolean hasFactor() {
    return this.factor != null;
  }
  
  public boolean hasQuantity() {
    return this.quantity != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(durationSeconds, factor, quantity, type, additionalProperties);
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
    if (!(durationSeconds == null)) {
        sb.append("durationSeconds:");
        sb.append(durationSeconds);
        sb.append(",");
    }
    if (!(factor == null)) {
        sb.append("factor:");
        sb.append(factor);
        sb.append(",");
    }
    if (!(quantity == null)) {
        sb.append("quantity:");
        sb.append(quantity);
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
  
  public A withDurationSeconds(Integer durationSeconds) {
    this.durationSeconds = durationSeconds;
    return (A) this;
  }
  
  public A withFactor(Integer factor) {
    this.factor = factor;
    return (A) this;
  }
  
  public A withNewQuantity(String amount) {
    return (A) this.withQuantity(new Quantity(amount));
  }
  
  public A withNewQuantity(String amount,String format) {
    return (A) this.withQuantity(new Quantity(amount, format));
  }
  
  public A withQuantity(Quantity quantity) {
    this.quantity = quantity;
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  
}