package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Long;
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
public class RunAsUserStrategyOptionsFluent<A extends io.fabric8.openshift.api.model.RunAsUserStrategyOptionsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String type;
  private Long uid;
  private Long uidRangeMax;
  private Long uidRangeMin;

  public RunAsUserStrategyOptionsFluent() {
  }
  
  public RunAsUserStrategyOptionsFluent(RunAsUserStrategyOptions instance) {
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
  
  protected void copyInstance(RunAsUserStrategyOptions instance) {
    instance = instance != null ? instance : new RunAsUserStrategyOptions();
    if (instance != null) {
        this.withType(instance.getType());
        this.withUid(instance.getUid());
        this.withUidRangeMax(instance.getUidRangeMax());
        this.withUidRangeMin(instance.getUidRangeMin());
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
    RunAsUserStrategyOptionsFluent that = (RunAsUserStrategyOptionsFluent) o;
    if (!(Objects.equals(type, that.type))) {
      return false;
    }
    if (!(Objects.equals(uid, that.uid))) {
      return false;
    }
    if (!(Objects.equals(uidRangeMax, that.uidRangeMax))) {
      return false;
    }
    if (!(Objects.equals(uidRangeMin, that.uidRangeMin))) {
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
  
  public String getType() {
    return this.type;
  }
  
  public Long getUid() {
    return this.uid;
  }
  
  public Long getUidRangeMax() {
    return this.uidRangeMax;
  }
  
  public Long getUidRangeMin() {
    return this.uidRangeMin;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public boolean hasUid() {
    return this.uid != null;
  }
  
  public boolean hasUidRangeMax() {
    return this.uidRangeMax != null;
  }
  
  public boolean hasUidRangeMin() {
    return this.uidRangeMin != null;
  }
  
  public int hashCode() {
    return Objects.hash(type, uid, uidRangeMax, uidRangeMin, additionalProperties);
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
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
        sb.append(",");
    }
    if (!(uid == null)) {
        sb.append("uid:");
        sb.append(uid);
        sb.append(",");
    }
    if (!(uidRangeMax == null)) {
        sb.append("uidRangeMax:");
        sb.append(uidRangeMax);
        sb.append(",");
    }
    if (!(uidRangeMin == null)) {
        sb.append("uidRangeMin:");
        sb.append(uidRangeMin);
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
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  
  public A withUid(Long uid) {
    this.uid = uid;
    return (A) this;
  }
  
  public A withUidRangeMax(Long uidRangeMax) {
    this.uidRangeMax = uidRangeMax;
    return (A) this;
  }
  
  public A withUidRangeMin(Long uidRangeMin) {
    this.uidRangeMin = uidRangeMin;
    return (A) this;
  }
  
}