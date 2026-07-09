package io.fabric8.kubernetes.api.model.autoscaling.v2;

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
public class MetricTargetFluent<A extends io.fabric8.kubernetes.api.model.autoscaling.v2.MetricTargetFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer averageUtilization;
  private Quantity averageValue;
  private String type;
  private Quantity value;

  public MetricTargetFluent() {
  }
  
  public MetricTargetFluent(MetricTarget instance) {
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
  
  protected void copyInstance(MetricTarget instance) {
    instance = instance != null ? instance : new MetricTarget();
    if (instance != null) {
        this.withAverageUtilization(instance.getAverageUtilization());
        this.withAverageValue(instance.getAverageValue());
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
    MetricTargetFluent that = (MetricTargetFluent) o;
    if (!(Objects.equals(averageUtilization, that.averageUtilization))) {
      return false;
    }
    if (!(Objects.equals(averageValue, that.averageValue))) {
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
  
  public Integer getAverageUtilization() {
    return this.averageUtilization;
  }
  
  public Quantity getAverageValue() {
    return this.averageValue;
  }
  
  public String getType() {
    return this.type;
  }
  
  public Quantity getValue() {
    return this.value;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAverageUtilization() {
    return this.averageUtilization != null;
  }
  
  public boolean hasAverageValue() {
    return this.averageValue != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public boolean hasValue() {
    return this.value != null;
  }
  
  public int hashCode() {
    return Objects.hash(averageUtilization, averageValue, type, value, additionalProperties);
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
    if (!(averageUtilization == null)) {
        sb.append("averageUtilization:");
        sb.append(averageUtilization);
        sb.append(",");
    }
    if (!(averageValue == null)) {
        sb.append("averageValue:");
        sb.append(averageValue);
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
  
  public A withAverageUtilization(Integer averageUtilization) {
    this.averageUtilization = averageUtilization;
    return (A) this;
  }
  
  public A withAverageValue(Quantity averageValue) {
    this.averageValue = averageValue;
    return (A) this;
  }
  
  public A withNewAverageValue(String amount) {
    return (A) this.withAverageValue(new Quantity(amount));
  }
  
  public A withNewAverageValue(String amount,String format) {
    return (A) this.withAverageValue(new Quantity(amount, format));
  }
  
  public A withNewValue(String amount) {
    return (A) this.withValue(new Quantity(amount));
  }
  
  public A withNewValue(String amount,String format) {
    return (A) this.withValue(new Quantity(amount, format));
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  
  public A withValue(Quantity value) {
    this.value = value;
    return (A) this;
  }
  
}