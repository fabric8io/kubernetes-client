package io.fabric8.kubernetes.api.model;

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
public class ModifyVolumeStatusFluent<A extends io.fabric8.kubernetes.api.model.ModifyVolumeStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String status;
  private String targetVolumeAttributesClassName;

  public ModifyVolumeStatusFluent() {
  }
  
  public ModifyVolumeStatusFluent(ModifyVolumeStatus instance) {
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
  
  protected void copyInstance(ModifyVolumeStatus instance) {
    instance = instance != null ? instance : new ModifyVolumeStatus();
    if (instance != null) {
        this.withStatus(instance.getStatus());
        this.withTargetVolumeAttributesClassName(instance.getTargetVolumeAttributesClassName());
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
    ModifyVolumeStatusFluent that = (ModifyVolumeStatusFluent) o;
    if (!(Objects.equals(status, that.status))) {
      return false;
    }
    if (!(Objects.equals(targetVolumeAttributesClassName, that.targetVolumeAttributesClassName))) {
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
  
  public String getStatus() {
    return this.status;
  }
  
  public String getTargetVolumeAttributesClassName() {
    return this.targetVolumeAttributesClassName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasStatus() {
    return this.status != null;
  }
  
  public boolean hasTargetVolumeAttributesClassName() {
    return this.targetVolumeAttributesClassName != null;
  }
  
  public int hashCode() {
    return Objects.hash(status, targetVolumeAttributesClassName, additionalProperties);
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
    if (!(status == null)) {
        sb.append("status:");
        sb.append(status);
        sb.append(",");
    }
    if (!(targetVolumeAttributesClassName == null)) {
        sb.append("targetVolumeAttributesClassName:");
        sb.append(targetVolumeAttributesClassName);
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
  
  public A withStatus(String status) {
    this.status = status;
    return (A) this;
  }
  
  public A withTargetVolumeAttributesClassName(String targetVolumeAttributesClassName) {
    this.targetVolumeAttributesClassName = targetVolumeAttributesClassName;
    return (A) this;
  }
  
}