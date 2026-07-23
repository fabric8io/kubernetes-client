package io.fabric8.kubernetes.api.model.autoscaling.v2beta1;

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
public class ResourceMetricSourceFluent<A extends io.fabric8.kubernetes.api.model.autoscaling.v2beta1.ResourceMetricSourceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String name;
  private Integer targetAverageUtilization;
  private Quantity targetAverageValue;

  public ResourceMetricSourceFluent() {
  }
  
  public ResourceMetricSourceFluent(ResourceMetricSource instance) {
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
  
  protected void copyInstance(ResourceMetricSource instance) {
    instance = instance != null ? instance : new ResourceMetricSource();
    if (instance != null) {
        this.withName(instance.getName());
        this.withTargetAverageUtilization(instance.getTargetAverageUtilization());
        this.withTargetAverageValue(instance.getTargetAverageValue());
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
    ResourceMetricSourceFluent that = (ResourceMetricSourceFluent) o;
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(targetAverageUtilization, that.targetAverageUtilization))) {
      return false;
    }
    if (!(Objects.equals(targetAverageValue, that.targetAverageValue))) {
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
  
  public Integer getTargetAverageUtilization() {
    return this.targetAverageUtilization;
  }
  
  public Quantity getTargetAverageValue() {
    return this.targetAverageValue;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasTargetAverageUtilization() {
    return this.targetAverageUtilization != null;
  }
  
  public boolean hasTargetAverageValue() {
    return this.targetAverageValue != null;
  }
  
  public int hashCode() {
    return Objects.hash(name, targetAverageUtilization, targetAverageValue, additionalProperties);
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
    if (!(targetAverageUtilization == null)) {
        sb.append("targetAverageUtilization:");
        sb.append(targetAverageUtilization);
        sb.append(",");
    }
    if (!(targetAverageValue == null)) {
        sb.append("targetAverageValue:");
        sb.append(targetAverageValue);
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
  
  public A withNewTargetAverageValue(String amount) {
    return (A) this.withTargetAverageValue(new Quantity(amount));
  }
  
  public A withNewTargetAverageValue(String amount,String format) {
    return (A) this.withTargetAverageValue(new Quantity(amount, format));
  }
  
  public A withTargetAverageUtilization(Integer targetAverageUtilization) {
    this.targetAverageUtilization = targetAverageUtilization;
    return (A) this;
  }
  
  public A withTargetAverageValue(Quantity targetAverageValue) {
    this.targetAverageValue = targetAverageValue;
    return (A) this;
  }
  
}