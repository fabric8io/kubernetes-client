package io.fabric8.kubernetes.api.model.apps;

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
public class StatefulSetPersistentVolumeClaimRetentionPolicyFluent<A extends io.fabric8.kubernetes.api.model.apps.StatefulSetPersistentVolumeClaimRetentionPolicyFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String whenDeleted;
  private String whenScaled;

  public StatefulSetPersistentVolumeClaimRetentionPolicyFluent() {
  }
  
  public StatefulSetPersistentVolumeClaimRetentionPolicyFluent(StatefulSetPersistentVolumeClaimRetentionPolicy instance) {
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
  
  protected void copyInstance(StatefulSetPersistentVolumeClaimRetentionPolicy instance) {
    instance = instance != null ? instance : new StatefulSetPersistentVolumeClaimRetentionPolicy();
    if (instance != null) {
        this.withWhenDeleted(instance.getWhenDeleted());
        this.withWhenScaled(instance.getWhenScaled());
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
    StatefulSetPersistentVolumeClaimRetentionPolicyFluent that = (StatefulSetPersistentVolumeClaimRetentionPolicyFluent) o;
    if (!(Objects.equals(whenDeleted, that.whenDeleted))) {
      return false;
    }
    if (!(Objects.equals(whenScaled, that.whenScaled))) {
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
  
  public String getWhenDeleted() {
    return this.whenDeleted;
  }
  
  public String getWhenScaled() {
    return this.whenScaled;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasWhenDeleted() {
    return this.whenDeleted != null;
  }
  
  public boolean hasWhenScaled() {
    return this.whenScaled != null;
  }
  
  public int hashCode() {
    return Objects.hash(whenDeleted, whenScaled, additionalProperties);
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
    if (!(whenDeleted == null)) {
        sb.append("whenDeleted:");
        sb.append(whenDeleted);
        sb.append(",");
    }
    if (!(whenScaled == null)) {
        sb.append("whenScaled:");
        sb.append(whenScaled);
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
  
  public A withWhenDeleted(String whenDeleted) {
    this.whenDeleted = whenDeleted;
    return (A) this;
  }
  
  public A withWhenScaled(String whenScaled) {
    this.whenScaled = whenScaled;
    return (A) this;
  }
  
}