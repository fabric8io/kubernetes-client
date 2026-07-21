package io.fabric8.volcano.api.model.batch.v1alpha1;

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
public class TaskStateFluent<A extends io.fabric8.volcano.api.model.batch.v1alpha1.TaskStateFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Map<String,Integer> phase;

  public TaskStateFluent() {
  }
  
  public TaskStateFluent(TaskState instance) {
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
  
  public A addToPhase(Map<String,Integer> map) {
    if (this.phase == null && map != null) {
      this.phase = new LinkedHashMap();
    }
    if (map != null) {
      this.phase.putAll(map);
    }
    return (A) this;
  }
  
  public A addToPhase(String key,Integer value) {
    if (this.phase == null && key != null && value != null) {
      this.phase = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.phase.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(TaskState instance) {
    instance = instance != null ? instance : new TaskState();
    if (instance != null) {
        this.withPhase(instance.getPhase());
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
    TaskStateFluent that = (TaskStateFluent) o;
    if (!(Objects.equals(phase, that.phase))) {
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
  
  public Map<String,Integer> getPhase() {
    return this.phase;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasPhase() {
    return this.phase != null;
  }
  
  public int hashCode() {
    return Objects.hash(phase, additionalProperties);
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
  
  public A removeFromPhase(String key) {
    if (this.phase == null) {
      return (A) this;
    }
    if (key != null && this.phase != null) {
      this.phase.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromPhase(Map<String,Integer> map) {
    if (this.phase == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.phase != null) {
          this.phase.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(phase == null) && !(phase.isEmpty())) {
        sb.append("phase:");
        sb.append(phase);
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
  
  public <K,V>A withPhase(Map<String,Integer> phase) {
    if (phase == null) {
      this.phase = null;
    } else {
      this.phase = new LinkedHashMap(phase);
    }
    return (A) this;
  }
  
}