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
public class WorkloadReferenceFluent<A extends io.fabric8.kubernetes.api.model.WorkloadReferenceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String name;
  private String podGroup;
  private String podGroupReplicaKey;

  public WorkloadReferenceFluent() {
  }
  
  public WorkloadReferenceFluent(WorkloadReference instance) {
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
  
  protected void copyInstance(WorkloadReference instance) {
    instance = instance != null ? instance : new WorkloadReference();
    if (instance != null) {
        this.withName(instance.getName());
        this.withPodGroup(instance.getPodGroup());
        this.withPodGroupReplicaKey(instance.getPodGroupReplicaKey());
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
    WorkloadReferenceFluent that = (WorkloadReferenceFluent) o;
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(podGroup, that.podGroup))) {
      return false;
    }
    if (!(Objects.equals(podGroupReplicaKey, that.podGroupReplicaKey))) {
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
  
  public String getPodGroup() {
    return this.podGroup;
  }
  
  public String getPodGroupReplicaKey() {
    return this.podGroupReplicaKey;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasPodGroup() {
    return this.podGroup != null;
  }
  
  public boolean hasPodGroupReplicaKey() {
    return this.podGroupReplicaKey != null;
  }
  
  public int hashCode() {
    return Objects.hash(name, podGroup, podGroupReplicaKey, additionalProperties);
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
    if (!(podGroup == null)) {
        sb.append("podGroup:");
        sb.append(podGroup);
        sb.append(",");
    }
    if (!(podGroupReplicaKey == null)) {
        sb.append("podGroupReplicaKey:");
        sb.append(podGroupReplicaKey);
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
  
  public A withPodGroup(String podGroup) {
    this.podGroup = podGroup;
    return (A) this;
  }
  
  public A withPodGroupReplicaKey(String podGroupReplicaKey) {
    this.podGroupReplicaKey = podGroupReplicaKey;
    return (A) this;
  }
  
}