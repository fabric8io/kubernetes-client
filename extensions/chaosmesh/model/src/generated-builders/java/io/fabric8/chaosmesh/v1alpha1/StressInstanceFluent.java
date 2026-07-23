package io.fabric8.chaosmesh.v1alpha1;

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
public class StressInstanceFluent<A extends io.fabric8.chaosmesh.v1alpha1.StressInstanceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String memoryStartTime;
  private String memoryUid;
  private String startTime;
  private String uid;

  public StressInstanceFluent() {
  }
  
  public StressInstanceFluent(StressInstance instance) {
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
  
  protected void copyInstance(StressInstance instance) {
    instance = instance != null ? instance : new StressInstance();
    if (instance != null) {
        this.withMemoryStartTime(instance.getMemoryStartTime());
        this.withMemoryUid(instance.getMemoryUid());
        this.withStartTime(instance.getStartTime());
        this.withUid(instance.getUid());
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
    StressInstanceFluent that = (StressInstanceFluent) o;
    if (!(Objects.equals(memoryStartTime, that.memoryStartTime))) {
      return false;
    }
    if (!(Objects.equals(memoryUid, that.memoryUid))) {
      return false;
    }
    if (!(Objects.equals(startTime, that.startTime))) {
      return false;
    }
    if (!(Objects.equals(uid, that.uid))) {
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
  
  public String getMemoryStartTime() {
    return this.memoryStartTime;
  }
  
  public String getMemoryUid() {
    return this.memoryUid;
  }
  
  public String getStartTime() {
    return this.startTime;
  }
  
  public String getUid() {
    return this.uid;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMemoryStartTime() {
    return this.memoryStartTime != null;
  }
  
  public boolean hasMemoryUid() {
    return this.memoryUid != null;
  }
  
  public boolean hasStartTime() {
    return this.startTime != null;
  }
  
  public boolean hasUid() {
    return this.uid != null;
  }
  
  public int hashCode() {
    return Objects.hash(memoryStartTime, memoryUid, startTime, uid, additionalProperties);
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
    if (!(memoryStartTime == null)) {
        sb.append("memoryStartTime:");
        sb.append(memoryStartTime);
        sb.append(",");
    }
    if (!(memoryUid == null)) {
        sb.append("memoryUid:");
        sb.append(memoryUid);
        sb.append(",");
    }
    if (!(startTime == null)) {
        sb.append("startTime:");
        sb.append(startTime);
        sb.append(",");
    }
    if (!(uid == null)) {
        sb.append("uid:");
        sb.append(uid);
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
  
  public A withMemoryStartTime(String memoryStartTime) {
    this.memoryStartTime = memoryStartTime;
    return (A) this;
  }
  
  public A withMemoryUid(String memoryUid) {
    this.memoryUid = memoryUid;
    return (A) this;
  }
  
  public A withStartTime(String startTime) {
    this.startTime = startTime;
    return (A) this;
  }
  
  public A withUid(String uid) {
    this.uid = uid;
    return (A) this;
  }
  
}