package io.fabric8.openshift.api.model.autoscaling.v1;

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
public class ClusterAutoscalerSpecScaleUpFluent<A extends io.fabric8.openshift.api.model.autoscaling.v1.ClusterAutoscalerSpecScaleUpFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String newPodScaleUpDelay;

  public ClusterAutoscalerSpecScaleUpFluent() {
  }
  
  public ClusterAutoscalerSpecScaleUpFluent(ClusterAutoscalerSpecScaleUp instance) {
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
  
  protected void copyInstance(ClusterAutoscalerSpecScaleUp instance) {
    instance = instance != null ? instance : new ClusterAutoscalerSpecScaleUp();
    if (instance != null) {
        this.withNewPodScaleUpDelay(instance.getNewPodScaleUpDelay());
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
    ClusterAutoscalerSpecScaleUpFluent that = (ClusterAutoscalerSpecScaleUpFluent) o;
    if (!(Objects.equals(newPodScaleUpDelay, that.newPodScaleUpDelay))) {
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
  
  public String getNewPodScaleUpDelay() {
    return this.newPodScaleUpDelay;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasNewPodScaleUpDelay() {
    return this.newPodScaleUpDelay != null;
  }
  
  public int hashCode() {
    return Objects.hash(newPodScaleUpDelay, additionalProperties);
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
    if (!(newPodScaleUpDelay == null)) {
        sb.append("newPodScaleUpDelay:");
        sb.append(newPodScaleUpDelay);
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
  
  public A withNewPodScaleUpDelay(String newPodScaleUpDelay) {
    this.newPodScaleUpDelay = newPodScaleUpDelay;
    return (A) this;
  }
  
}