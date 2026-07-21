package io.fabric8.openclustermanagement.api.model.policy.v1;

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
public class ComplianceHistoryFluent<A extends io.fabric8.openclustermanagement.api.model.policy.v1.ComplianceHistoryFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String eventName;
  private String lastTimestamp;
  private String message;

  public ComplianceHistoryFluent() {
  }
  
  public ComplianceHistoryFluent(ComplianceHistory instance) {
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
  
  protected void copyInstance(ComplianceHistory instance) {
    instance = instance != null ? instance : new ComplianceHistory();
    if (instance != null) {
        this.withEventName(instance.getEventName());
        this.withLastTimestamp(instance.getLastTimestamp());
        this.withMessage(instance.getMessage());
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
    ComplianceHistoryFluent that = (ComplianceHistoryFluent) o;
    if (!(Objects.equals(eventName, that.eventName))) {
      return false;
    }
    if (!(Objects.equals(lastTimestamp, that.lastTimestamp))) {
      return false;
    }
    if (!(Objects.equals(message, that.message))) {
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
  
  public String getEventName() {
    return this.eventName;
  }
  
  public String getLastTimestamp() {
    return this.lastTimestamp;
  }
  
  public String getMessage() {
    return this.message;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasEventName() {
    return this.eventName != null;
  }
  
  public boolean hasLastTimestamp() {
    return this.lastTimestamp != null;
  }
  
  public boolean hasMessage() {
    return this.message != null;
  }
  
  public int hashCode() {
    return Objects.hash(eventName, lastTimestamp, message, additionalProperties);
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
    if (!(eventName == null)) {
        sb.append("eventName:");
        sb.append(eventName);
        sb.append(",");
    }
    if (!(lastTimestamp == null)) {
        sb.append("lastTimestamp:");
        sb.append(lastTimestamp);
        sb.append(",");
    }
    if (!(message == null)) {
        sb.append("message:");
        sb.append(message);
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
  
  public A withEventName(String eventName) {
    this.eventName = eventName;
    return (A) this;
  }
  
  public A withLastTimestamp(String lastTimestamp) {
    this.lastTimestamp = lastTimestamp;
    return (A) this;
  }
  
  public A withMessage(String message) {
    this.message = message;
    return (A) this;
  }
  
}