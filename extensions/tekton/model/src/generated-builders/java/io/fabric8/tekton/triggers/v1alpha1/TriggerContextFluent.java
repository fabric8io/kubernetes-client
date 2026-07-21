package io.fabric8.tekton.triggers.v1alpha1;

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
public class TriggerContextFluent<A extends io.fabric8.tekton.triggers.v1alpha1.TriggerContextFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String eventId;
  private String eventUrl;
  private String triggerId;

  public TriggerContextFluent() {
  }
  
  public TriggerContextFluent(TriggerContext instance) {
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
  
  protected void copyInstance(TriggerContext instance) {
    instance = instance != null ? instance : new TriggerContext();
    if (instance != null) {
        this.withEventId(instance.getEventId());
        this.withEventUrl(instance.getEventUrl());
        this.withTriggerId(instance.getTriggerId());
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
    TriggerContextFluent that = (TriggerContextFluent) o;
    if (!(Objects.equals(eventId, that.eventId))) {
      return false;
    }
    if (!(Objects.equals(eventUrl, that.eventUrl))) {
      return false;
    }
    if (!(Objects.equals(triggerId, that.triggerId))) {
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
  
  public String getEventId() {
    return this.eventId;
  }
  
  public String getEventUrl() {
    return this.eventUrl;
  }
  
  public String getTriggerId() {
    return this.triggerId;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasEventId() {
    return this.eventId != null;
  }
  
  public boolean hasEventUrl() {
    return this.eventUrl != null;
  }
  
  public boolean hasTriggerId() {
    return this.triggerId != null;
  }
  
  public int hashCode() {
    return Objects.hash(eventId, eventUrl, triggerId, additionalProperties);
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
    if (!(eventId == null)) {
        sb.append("eventId:");
        sb.append(eventId);
        sb.append(",");
    }
    if (!(eventUrl == null)) {
        sb.append("eventUrl:");
        sb.append(eventUrl);
        sb.append(",");
    }
    if (!(triggerId == null)) {
        sb.append("triggerId:");
        sb.append(triggerId);
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
  
  public A withEventId(String eventId) {
    this.eventId = eventId;
    return (A) this;
  }
  
  public A withEventUrl(String eventUrl) {
    this.eventUrl = eventUrl;
    return (A) this;
  }
  
  public A withTriggerId(String triggerId) {
    this.triggerId = triggerId;
    return (A) this;
  }
  
}