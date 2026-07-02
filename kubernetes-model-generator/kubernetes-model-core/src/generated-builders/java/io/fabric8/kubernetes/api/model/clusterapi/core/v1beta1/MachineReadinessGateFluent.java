package io.fabric8.kubernetes.api.model.clusterapi.core.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
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
public class MachineReadinessGateFluent<A extends io.fabric8.kubernetes.api.model.clusterapi.core.v1beta1.MachineReadinessGateFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String conditionType;
  private String polarity;

  public MachineReadinessGateFluent() {
  }
  
  public MachineReadinessGateFluent(MachineReadinessGate instance) {
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
  
  protected void copyInstance(MachineReadinessGate instance) {
    instance = instance != null ? instance : new MachineReadinessGate();
    if (instance != null) {
        this.withConditionType(instance.getConditionType());
        this.withPolarity(instance.getPolarity());
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
    MachineReadinessGateFluent that = (MachineReadinessGateFluent) o;
    if (!(Objects.equals(conditionType, that.conditionType))) {
      return false;
    }
    if (!(Objects.equals(polarity, that.polarity))) {
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
  
  public String getConditionType() {
    return this.conditionType;
  }
  
  public String getPolarity() {
    return this.polarity;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConditionType() {
    return this.conditionType != null;
  }
  
  public boolean hasPolarity() {
    return this.polarity != null;
  }
  
  public int hashCode() {
    return Objects.hash(conditionType, polarity, additionalProperties);
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
    if (!(conditionType == null)) {
        sb.append("conditionType:");
        sb.append(conditionType);
        sb.append(",");
    }
    if (!(polarity == null)) {
        sb.append("polarity:");
        sb.append(polarity);
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
  
  public A withConditionType(String conditionType) {
    this.conditionType = conditionType;
    return (A) this;
  }
  
  public A withPolarity(String polarity) {
    this.polarity = polarity;
    return (A) this;
  }
  
}