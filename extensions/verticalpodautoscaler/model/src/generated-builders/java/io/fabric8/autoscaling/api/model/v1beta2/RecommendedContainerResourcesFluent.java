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
public class RecommendedContainerResourcesFluent<A extends io.fabric8.autoscaling.api.model.v1beta2.RecommendedContainerResourcesFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String containerName;
  private Map<String,Quantity> lowerBound;
  private Map<String,Quantity> target;
  private Map<String,Quantity> uncappedTarget;
  private Map<String,Quantity> upperBound;

  public RecommendedContainerResourcesFluent() {
  }
  
  public RecommendedContainerResourcesFluent(RecommendedContainerResources instance) {
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
  
  public A addToLowerBound(Map<String,Quantity> map) {
    if (this.lowerBound == null && map != null) {
      this.lowerBound = new LinkedHashMap();
    }
    if (map != null) {
      this.lowerBound.putAll(map);
    }
    return (A) this;
  }
  
  public A addToLowerBound(String key,Quantity value) {
    if (this.lowerBound == null && key != null && value != null) {
      this.lowerBound = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.lowerBound.put(key, value);
    }
    return (A) this;
  }
  
  public A addToTarget(Map<String,Quantity> map) {
    if (this.target == null && map != null) {
      this.target = new LinkedHashMap();
    }
    if (map != null) {
      this.target.putAll(map);
    }
    return (A) this;
  }
  
  public A addToTarget(String key,Quantity value) {
    if (this.target == null && key != null && value != null) {
      this.target = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.target.put(key, value);
    }
    return (A) this;
  }
  
  public A addToUncappedTarget(Map<String,Quantity> map) {
    if (this.uncappedTarget == null && map != null) {
      this.uncappedTarget = new LinkedHashMap();
    }
    if (map != null) {
      this.uncappedTarget.putAll(map);
    }
    return (A) this;
  }
  
  public A addToUncappedTarget(String key,Quantity value) {
    if (this.uncappedTarget == null && key != null && value != null) {
      this.uncappedTarget = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.uncappedTarget.put(key, value);
    }
    return (A) this;
  }
  
  public A addToUpperBound(Map<String,Quantity> map) {
    if (this.upperBound == null && map != null) {
      this.upperBound = new LinkedHashMap();
    }
    if (map != null) {
      this.upperBound.putAll(map);
    }
    return (A) this;
  }
  
  public A addToUpperBound(String key,Quantity value) {
    if (this.upperBound == null && key != null && value != null) {
      this.upperBound = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.upperBound.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(RecommendedContainerResources instance) {
    instance = instance != null ? instance : new RecommendedContainerResources();
    if (instance != null) {
        this.withContainerName(instance.getContainerName());
        this.withLowerBound(instance.getLowerBound());
        this.withTarget(instance.getTarget());
        this.withUncappedTarget(instance.getUncappedTarget());
        this.withUpperBound(instance.getUpperBound());
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
    RecommendedContainerResourcesFluent that = (RecommendedContainerResourcesFluent) o;
    if (!(Objects.equals(containerName, that.containerName))) {
      return false;
    }
    if (!(Objects.equals(lowerBound, that.lowerBound))) {
      return false;
    }
    if (!(Objects.equals(target, that.target))) {
      return false;
    }
    if (!(Objects.equals(uncappedTarget, that.uncappedTarget))) {
      return false;
    }
    if (!(Objects.equals(upperBound, that.upperBound))) {
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
  
  public Map<String,Quantity> getLowerBound() {
    return this.lowerBound;
  }
  
  public Map<String,Quantity> getTarget() {
    return this.target;
  }
  
  public Map<String,Quantity> getUncappedTarget() {
    return this.uncappedTarget;
  }
  
  public Map<String,Quantity> getUpperBound() {
    return this.upperBound;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasContainerName() {
    return this.containerName != null;
  }
  
  public boolean hasLowerBound() {
    return this.lowerBound != null;
  }
  
  public boolean hasTarget() {
    return this.target != null;
  }
  
  public boolean hasUncappedTarget() {
    return this.uncappedTarget != null;
  }
  
  public boolean hasUpperBound() {
    return this.upperBound != null;
  }
  
  public int hashCode() {
    return Objects.hash(containerName, lowerBound, target, uncappedTarget, upperBound, additionalProperties);
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
  
  public A removeFromLowerBound(String key) {
    if (this.lowerBound == null) {
      return (A) this;
    }
    if (key != null && this.lowerBound != null) {
      this.lowerBound.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromLowerBound(Map<String,Quantity> map) {
    if (this.lowerBound == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.lowerBound != null) {
          this.lowerBound.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromTarget(String key) {
    if (this.target == null) {
      return (A) this;
    }
    if (key != null && this.target != null) {
      this.target.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromTarget(Map<String,Quantity> map) {
    if (this.target == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.target != null) {
          this.target.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromUncappedTarget(String key) {
    if (this.uncappedTarget == null) {
      return (A) this;
    }
    if (key != null && this.uncappedTarget != null) {
      this.uncappedTarget.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromUncappedTarget(Map<String,Quantity> map) {
    if (this.uncappedTarget == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.uncappedTarget != null) {
          this.uncappedTarget.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromUpperBound(String key) {
    if (this.upperBound == null) {
      return (A) this;
    }
    if (key != null && this.upperBound != null) {
      this.upperBound.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromUpperBound(Map<String,Quantity> map) {
    if (this.upperBound == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.upperBound != null) {
          this.upperBound.remove(key);
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
    if (!(lowerBound == null) && !(lowerBound.isEmpty())) {
        sb.append("lowerBound:");
        sb.append(lowerBound);
        sb.append(",");
    }
    if (!(target == null) && !(target.isEmpty())) {
        sb.append("target:");
        sb.append(target);
        sb.append(",");
    }
    if (!(uncappedTarget == null) && !(uncappedTarget.isEmpty())) {
        sb.append("uncappedTarget:");
        sb.append(uncappedTarget);
        sb.append(",");
    }
    if (!(upperBound == null) && !(upperBound.isEmpty())) {
        sb.append("upperBound:");
        sb.append(upperBound);
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
  
  public <K,V>A withLowerBound(Map<String,Quantity> lowerBound) {
    if (lowerBound == null) {
      this.lowerBound = null;
    } else {
      this.lowerBound = new LinkedHashMap(lowerBound);
    }
    return (A) this;
  }
  
  public <K,V>A withTarget(Map<String,Quantity> target) {
    if (target == null) {
      this.target = null;
    } else {
      this.target = new LinkedHashMap(target);
    }
    return (A) this;
  }
  
  public <K,V>A withUncappedTarget(Map<String,Quantity> uncappedTarget) {
    if (uncappedTarget == null) {
      this.uncappedTarget = null;
    } else {
      this.uncappedTarget = new LinkedHashMap(uncappedTarget);
    }
    return (A) this;
  }
  
  public <K,V>A withUpperBound(Map<String,Quantity> upperBound) {
    if (upperBound == null) {
      this.upperBound = null;
    } else {
      this.upperBound = new LinkedHashMap(upperBound);
    }
    return (A) this;
  }
  
}