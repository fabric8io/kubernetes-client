package io.fabric8.kubernetes.api.model.autoscaling.v2beta2;

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
public class HPAScalingPolicyFluent<A extends io.fabric8.kubernetes.api.model.autoscaling.v2beta2.HPAScalingPolicyFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer periodSeconds;
  private String type;
  private Integer value;

  public HPAScalingPolicyFluent() {
  }
  
  public HPAScalingPolicyFluent(HPAScalingPolicy instance) {
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
  
  protected void copyInstance(HPAScalingPolicy instance) {
    instance = instance != null ? instance : new HPAScalingPolicy();
    if (instance != null) {
        this.withPeriodSeconds(instance.getPeriodSeconds());
        this.withType(instance.getType());
        this.withValue(instance.getValue());
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
    HPAScalingPolicyFluent that = (HPAScalingPolicyFluent) o;
    if (!(Objects.equals(periodSeconds, that.periodSeconds))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
      return false;
    }
    if (!(Objects.equals(value, that.value))) {
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
  
  public Integer getPeriodSeconds() {
    return this.periodSeconds;
  }
  
  public String getType() {
    return this.type;
  }
  
  public Integer getValue() {
    return this.value;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasPeriodSeconds() {
    return this.periodSeconds != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public boolean hasValue() {
    return this.value != null;
  }
  
  public int hashCode() {
    return Objects.hash(periodSeconds, type, value, additionalProperties);
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
    if (!(periodSeconds == null)) {
        sb.append("periodSeconds:");
        sb.append(periodSeconds);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
        sb.append(",");
    }
    if (!(value == null)) {
        sb.append("value:");
        sb.append(value);
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
  
  public A withPeriodSeconds(Integer periodSeconds) {
    this.periodSeconds = periodSeconds;
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  
  public A withValue(Integer value) {
    this.value = value;
    return (A) this;
  }
  
}