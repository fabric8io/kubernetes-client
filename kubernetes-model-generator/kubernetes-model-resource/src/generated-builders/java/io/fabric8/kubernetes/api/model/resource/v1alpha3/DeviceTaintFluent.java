package io.fabric8.kubernetes.api.model.resource.v1alpha3;

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
public class DeviceTaintFluent<A extends io.fabric8.kubernetes.api.model.resource.v1alpha3.DeviceTaintFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String effect;
  private String key;
  private String timeAdded;
  private String value;

  public DeviceTaintFluent() {
  }
  
  public DeviceTaintFluent(DeviceTaint instance) {
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
  
  protected void copyInstance(DeviceTaint instance) {
    instance = instance != null ? instance : new DeviceTaint();
    if (instance != null) {
        this.withEffect(instance.getEffect());
        this.withKey(instance.getKey());
        this.withTimeAdded(instance.getTimeAdded());
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
    DeviceTaintFluent that = (DeviceTaintFluent) o;
    if (!(Objects.equals(effect, that.effect))) {
      return false;
    }
    if (!(Objects.equals(key, that.key))) {
      return false;
    }
    if (!(Objects.equals(timeAdded, that.timeAdded))) {
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
  
  public String getEffect() {
    return this.effect;
  }
  
  public String getKey() {
    return this.key;
  }
  
  public String getTimeAdded() {
    return this.timeAdded;
  }
  
  public String getValue() {
    return this.value;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasEffect() {
    return this.effect != null;
  }
  
  public boolean hasKey() {
    return this.key != null;
  }
  
  public boolean hasTimeAdded() {
    return this.timeAdded != null;
  }
  
  public boolean hasValue() {
    return this.value != null;
  }
  
  public int hashCode() {
    return Objects.hash(effect, key, timeAdded, value, additionalProperties);
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
    if (!(effect == null)) {
        sb.append("effect:");
        sb.append(effect);
        sb.append(",");
    }
    if (!(key == null)) {
        sb.append("key:");
        sb.append(key);
        sb.append(",");
    }
    if (!(timeAdded == null)) {
        sb.append("timeAdded:");
        sb.append(timeAdded);
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
  
  public A withEffect(String effect) {
    this.effect = effect;
    return (A) this;
  }
  
  public A withKey(String key) {
    this.key = key;
    return (A) this;
  }
  
  public A withTimeAdded(String timeAdded) {
    this.timeAdded = timeAdded;
    return (A) this;
  }
  
  public A withValue(String value) {
    this.value = value;
    return (A) this;
  }
  
}