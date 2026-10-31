package io.fabric8.kubernetes.api.model.lifecycle.v1alpha1;

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
public class ResponderStatusFluent<A extends io.fabric8.kubernetes.api.model.lifecycle.v1alpha1.ResponderStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String completionTime;
  private String expectedCompletionTime;
  private String heartbeatTime;
  private String message;
  private String name;
  private String startTime;

  public ResponderStatusFluent() {
  }
  
  public ResponderStatusFluent(ResponderStatus instance) {
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
  
  protected void copyInstance(ResponderStatus instance) {
    instance = instance != null ? instance : new ResponderStatus();
    if (instance != null) {
        this.withCompletionTime(instance.getCompletionTime());
        this.withExpectedCompletionTime(instance.getExpectedCompletionTime());
        this.withHeartbeatTime(instance.getHeartbeatTime());
        this.withMessage(instance.getMessage());
        this.withName(instance.getName());
        this.withStartTime(instance.getStartTime());
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
    ResponderStatusFluent that = (ResponderStatusFluent) o;
    if (!(Objects.equals(completionTime, that.completionTime))) {
      return false;
    }
    if (!(Objects.equals(expectedCompletionTime, that.expectedCompletionTime))) {
      return false;
    }
    if (!(Objects.equals(heartbeatTime, that.heartbeatTime))) {
      return false;
    }
    if (!(Objects.equals(message, that.message))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(startTime, that.startTime))) {
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
  
  public String getCompletionTime() {
    return this.completionTime;
  }
  
  public String getExpectedCompletionTime() {
    return this.expectedCompletionTime;
  }
  
  public String getHeartbeatTime() {
    return this.heartbeatTime;
  }
  
  public String getMessage() {
    return this.message;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getStartTime() {
    return this.startTime;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCompletionTime() {
    return this.completionTime != null;
  }
  
  public boolean hasExpectedCompletionTime() {
    return this.expectedCompletionTime != null;
  }
  
  public boolean hasHeartbeatTime() {
    return this.heartbeatTime != null;
  }
  
  public boolean hasMessage() {
    return this.message != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasStartTime() {
    return this.startTime != null;
  }
  
  public int hashCode() {
    return Objects.hash(completionTime, expectedCompletionTime, heartbeatTime, message, name, startTime, additionalProperties);
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
    if (!(completionTime == null)) {
        sb.append("completionTime:");
        sb.append(completionTime);
        sb.append(",");
    }
    if (!(expectedCompletionTime == null)) {
        sb.append("expectedCompletionTime:");
        sb.append(expectedCompletionTime);
        sb.append(",");
    }
    if (!(heartbeatTime == null)) {
        sb.append("heartbeatTime:");
        sb.append(heartbeatTime);
        sb.append(",");
    }
    if (!(message == null)) {
        sb.append("message:");
        sb.append(message);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(startTime == null)) {
        sb.append("startTime:");
        sb.append(startTime);
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
  
  public A withCompletionTime(String completionTime) {
    this.completionTime = completionTime;
    return (A) this;
  }
  
  public A withExpectedCompletionTime(String expectedCompletionTime) {
    this.expectedCompletionTime = expectedCompletionTime;
    return (A) this;
  }
  
  public A withHeartbeatTime(String heartbeatTime) {
    this.heartbeatTime = heartbeatTime;
    return (A) this;
  }
  
  public A withMessage(String message) {
    this.message = message;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withStartTime(String startTime) {
    this.startTime = startTime;
    return (A) this;
  }
  
}