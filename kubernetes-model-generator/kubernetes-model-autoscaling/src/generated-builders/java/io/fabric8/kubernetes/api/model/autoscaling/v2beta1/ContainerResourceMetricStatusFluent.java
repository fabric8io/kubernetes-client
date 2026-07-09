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
public class ContainerResourceMetricStatusFluent<A extends io.fabric8.kubernetes.api.model.autoscaling.v2beta1.ContainerResourceMetricStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String container;
  private Integer currentAverageUtilization;
  private Quantity currentAverageValue;
  private String name;

  public ContainerResourceMetricStatusFluent() {
  }
  
  public ContainerResourceMetricStatusFluent(ContainerResourceMetricStatus instance) {
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
  
  protected void copyInstance(ContainerResourceMetricStatus instance) {
    instance = instance != null ? instance : new ContainerResourceMetricStatus();
    if (instance != null) {
        this.withContainer(instance.getContainer());
        this.withCurrentAverageUtilization(instance.getCurrentAverageUtilization());
        this.withCurrentAverageValue(instance.getCurrentAverageValue());
        this.withName(instance.getName());
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
    ContainerResourceMetricStatusFluent that = (ContainerResourceMetricStatusFluent) o;
    if (!(Objects.equals(container, that.container))) {
      return false;
    }
    if (!(Objects.equals(currentAverageUtilization, that.currentAverageUtilization))) {
      return false;
    }
    if (!(Objects.equals(currentAverageValue, that.currentAverageValue))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
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
  
  public String getContainer() {
    return this.container;
  }
  
  public Integer getCurrentAverageUtilization() {
    return this.currentAverageUtilization;
  }
  
  public Quantity getCurrentAverageValue() {
    return this.currentAverageValue;
  }
  
  public String getName() {
    return this.name;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasContainer() {
    return this.container != null;
  }
  
  public boolean hasCurrentAverageUtilization() {
    return this.currentAverageUtilization != null;
  }
  
  public boolean hasCurrentAverageValue() {
    return this.currentAverageValue != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public int hashCode() {
    return Objects.hash(container, currentAverageUtilization, currentAverageValue, name, additionalProperties);
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
    if (!(container == null)) {
        sb.append("container:");
        sb.append(container);
        sb.append(",");
    }
    if (!(currentAverageUtilization == null)) {
        sb.append("currentAverageUtilization:");
        sb.append(currentAverageUtilization);
        sb.append(",");
    }
    if (!(currentAverageValue == null)) {
        sb.append("currentAverageValue:");
        sb.append(currentAverageValue);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
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
  
  public A withContainer(String container) {
    this.container = container;
    return (A) this;
  }
  
  public A withCurrentAverageUtilization(Integer currentAverageUtilization) {
    this.currentAverageUtilization = currentAverageUtilization;
    return (A) this;
  }
  
  public A withCurrentAverageValue(Quantity currentAverageValue) {
    this.currentAverageValue = currentAverageValue;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withNewCurrentAverageValue(String amount) {
    return (A) this.withCurrentAverageValue(new Quantity(amount));
  }
  
  public A withNewCurrentAverageValue(String amount,String format) {
    return (A) this.withCurrentAverageValue(new Quantity(amount, format));
  }
  
}