package io.fabric8.autoscaling.api.model.v1beta2;

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
public class ContainerResourcePolicyFluent<A extends io.fabric8.autoscaling.api.model.v1beta2.ContainerResourcePolicyFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String containerName;
  private Map<String,Quantity> maxAllowed;
  private Map<String,Quantity> minAllowed;
  private String mode;

  public ContainerResourcePolicyFluent() {
  }
  
  public ContainerResourcePolicyFluent(ContainerResourcePolicy instance) {
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
  
  public A addToMaxAllowed(Map<String,Quantity> map) {
    if (this.maxAllowed == null && map != null) {
      this.maxAllowed = new LinkedHashMap();
    }
    if (map != null) {
      this.maxAllowed.putAll(map);
    }
    return (A) this;
  }
  
  public A addToMaxAllowed(String key,Quantity value) {
    if (this.maxAllowed == null && key != null && value != null) {
      this.maxAllowed = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.maxAllowed.put(key, value);
    }
    return (A) this;
  }
  
  public A addToMinAllowed(Map<String,Quantity> map) {
    if (this.minAllowed == null && map != null) {
      this.minAllowed = new LinkedHashMap();
    }
    if (map != null) {
      this.minAllowed.putAll(map);
    }
    return (A) this;
  }
  
  public A addToMinAllowed(String key,Quantity value) {
    if (this.minAllowed == null && key != null && value != null) {
      this.minAllowed = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.minAllowed.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(ContainerResourcePolicy instance) {
    instance = instance != null ? instance : new ContainerResourcePolicy();
    if (instance != null) {
        this.withContainerName(instance.getContainerName());
        this.withMaxAllowed(instance.getMaxAllowed());
        this.withMinAllowed(instance.getMinAllowed());
        this.withMode(instance.getMode());
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
    ContainerResourcePolicyFluent that = (ContainerResourcePolicyFluent) o;
    if (!(Objects.equals(containerName, that.containerName))) {
      return false;
    }
    if (!(Objects.equals(maxAllowed, that.maxAllowed))) {
      return false;
    }
    if (!(Objects.equals(minAllowed, that.minAllowed))) {
      return false;
    }
    if (!(Objects.equals(mode, that.mode))) {
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
  
  public String getContainerName() {
    return this.containerName;
  }
  
  public Map<String,Quantity> getMaxAllowed() {
    return this.maxAllowed;
  }
  
  public Map<String,Quantity> getMinAllowed() {
    return this.minAllowed;
  }
  
  public String getMode() {
    return this.mode;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasContainerName() {
    return this.containerName != null;
  }
  
  public boolean hasMaxAllowed() {
    return this.maxAllowed != null;
  }
  
  public boolean hasMinAllowed() {
    return this.minAllowed != null;
  }
  
  public boolean hasMode() {
    return this.mode != null;
  }
  
  public int hashCode() {
    return Objects.hash(containerName, maxAllowed, minAllowed, mode, additionalProperties);
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
  
  public A removeFromMaxAllowed(String key) {
    if (this.maxAllowed == null) {
      return (A) this;
    }
    if (key != null && this.maxAllowed != null) {
      this.maxAllowed.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromMaxAllowed(Map<String,Quantity> map) {
    if (this.maxAllowed == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.maxAllowed != null) {
          this.maxAllowed.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromMinAllowed(String key) {
    if (this.minAllowed == null) {
      return (A) this;
    }
    if (key != null && this.minAllowed != null) {
      this.minAllowed.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromMinAllowed(Map<String,Quantity> map) {
    if (this.minAllowed == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.minAllowed != null) {
          this.minAllowed.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(containerName == null)) {
        sb.append("containerName:");
        sb.append(containerName);
        sb.append(",");
    }
    if (!(maxAllowed == null) && !(maxAllowed.isEmpty())) {
        sb.append("maxAllowed:");
        sb.append(maxAllowed);
        sb.append(",");
    }
    if (!(minAllowed == null) && !(minAllowed.isEmpty())) {
        sb.append("minAllowed:");
        sb.append(minAllowed);
        sb.append(",");
    }
    if (!(mode == null)) {
        sb.append("mode:");
        sb.append(mode);
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
  
  public A withContainerName(String containerName) {
    this.containerName = containerName;
    return (A) this;
  }
  
  public <K,V>A withMaxAllowed(Map<String,Quantity> maxAllowed) {
    if (maxAllowed == null) {
      this.maxAllowed = null;
    } else {
      this.maxAllowed = new LinkedHashMap(maxAllowed);
    }
    return (A) this;
  }
  
  public <K,V>A withMinAllowed(Map<String,Quantity> minAllowed) {
    if (minAllowed == null) {
      this.minAllowed = null;
    } else {
      this.minAllowed = new LinkedHashMap(minAllowed);
    }
    return (A) this;
  }
  
  public A withMode(String mode) {
    this.mode = mode;
    return (A) this;
  }
  
}