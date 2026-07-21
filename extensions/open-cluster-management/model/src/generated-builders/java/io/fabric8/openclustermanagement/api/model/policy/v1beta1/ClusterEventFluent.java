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
public class ClusterEventFluent<A extends io.fabric8.openclustermanagement.api.model.policy.v1beta1.ClusterEventFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String automationStartTime;
  private String eventTime;

  public ClusterEventFluent() {
  }
  
  public ClusterEventFluent(ClusterEvent instance) {
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
  
  protected void copyInstance(ClusterEvent instance) {
    instance = instance != null ? instance : new ClusterEvent();
    if (instance != null) {
        this.withAutomationStartTime(instance.getAutomationStartTime());
        this.withEventTime(instance.getEventTime());
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
    ClusterEventFluent that = (ClusterEventFluent) o;
    if (!(Objects.equals(automationStartTime, that.automationStartTime))) {
      return false;
    }
    if (!(Objects.equals(eventTime, that.eventTime))) {
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
  
  public String getAutomationStartTime() {
    return this.automationStartTime;
  }
  
  public String getEventTime() {
    return this.eventTime;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAutomationStartTime() {
    return this.automationStartTime != null;
  }
  
  public boolean hasEventTime() {
    return this.eventTime != null;
  }
  
  public int hashCode() {
    return Objects.hash(automationStartTime, eventTime, additionalProperties);
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
    if (!(automationStartTime == null)) {
        sb.append("automationStartTime:");
        sb.append(automationStartTime);
        sb.append(",");
    }
    if (!(eventTime == null)) {
        sb.append("eventTime:");
        sb.append(eventTime);
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
  
  public A withAutomationStartTime(String automationStartTime) {
    this.automationStartTime = automationStartTime;
    return (A) this;
  }
  
  public A withEventTime(String eventTime) {
    this.eventTime = eventTime;
    return (A) this;
  }
  
}