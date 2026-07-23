package io.fabric8.openclustermanagement.api.model.policy.v1beta1;

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
public class PolicyAutomationStatusFluent<A extends io.fabric8.openclustermanagement.api.model.policy.v1beta1.PolicyAutomationStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Map<String,ClusterEvent> clustersWithEvent;

  public PolicyAutomationStatusFluent() {
  }
  
  public PolicyAutomationStatusFluent(PolicyAutomationStatus instance) {
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
  
  public A addToClustersWithEvent(Map<String,ClusterEvent> map) {
    if (this.clustersWithEvent == null && map != null) {
      this.clustersWithEvent = new LinkedHashMap();
    }
    if (map != null) {
      this.clustersWithEvent.putAll(map);
    }
    return (A) this;
  }
  
  public A addToClustersWithEvent(String key,ClusterEvent value) {
    if (this.clustersWithEvent == null && key != null && value != null) {
      this.clustersWithEvent = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.clustersWithEvent.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(PolicyAutomationStatus instance) {
    instance = instance != null ? instance : new PolicyAutomationStatus();
    if (instance != null) {
        this.withClustersWithEvent(instance.getClustersWithEvent());
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
    PolicyAutomationStatusFluent that = (PolicyAutomationStatusFluent) o;
    if (!(Objects.equals(clustersWithEvent, that.clustersWithEvent))) {
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
  
  public Map<String,ClusterEvent> getClustersWithEvent() {
    return this.clustersWithEvent;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClustersWithEvent() {
    return this.clustersWithEvent != null;
  }
  
  public int hashCode() {
    return Objects.hash(clustersWithEvent, additionalProperties);
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
  
  public A removeFromClustersWithEvent(String key) {
    if (this.clustersWithEvent == null) {
      return (A) this;
    }
    if (key != null && this.clustersWithEvent != null) {
      this.clustersWithEvent.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromClustersWithEvent(Map<String,ClusterEvent> map) {
    if (this.clustersWithEvent == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.clustersWithEvent != null) {
          this.clustersWithEvent.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(clustersWithEvent == null) && !(clustersWithEvent.isEmpty())) {
        sb.append("clustersWithEvent:");
        sb.append(clustersWithEvent);
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
  
  public <K,V>A withClustersWithEvent(Map<String,ClusterEvent> clustersWithEvent) {
    if (clustersWithEvent == null) {
      this.clustersWithEvent = null;
    } else {
      this.clustersWithEvent = new LinkedHashMap(clustersWithEvent);
    }
    return (A) this;
  }
  
}