package io.fabric8.openclustermanagement.api.model.apps.v1;

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
public class SubscriptionUnitStatusFluent<A extends io.fabric8.openclustermanagement.api.model.apps.v1.SubscriptionUnitStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String lastUpdateTime;
  private String message;
  private String phase;
  private String reason;
  private Object resourceStatus;

  public SubscriptionUnitStatusFluent() {
  }
  
  public SubscriptionUnitStatusFluent(SubscriptionUnitStatus instance) {
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
  
  protected void copyInstance(SubscriptionUnitStatus instance) {
    instance = instance != null ? instance : new SubscriptionUnitStatus();
    if (instance != null) {
        this.withLastUpdateTime(instance.getLastUpdateTime());
        this.withMessage(instance.getMessage());
        this.withPhase(instance.getPhase());
        this.withReason(instance.getReason());
        this.withResourceStatus(instance.getResourceStatus());
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
    SubscriptionUnitStatusFluent that = (SubscriptionUnitStatusFluent) o;
    if (!(Objects.equals(lastUpdateTime, that.lastUpdateTime))) {
      return false;
    }
    if (!(Objects.equals(message, that.message))) {
      return false;
    }
    if (!(Objects.equals(phase, that.phase))) {
      return false;
    }
    if (!(Objects.equals(reason, that.reason))) {
      return false;
    }
    if (!(Objects.equals(resourceStatus, that.resourceStatus))) {
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
  
  public String getLastUpdateTime() {
    return this.lastUpdateTime;
  }
  
  public String getMessage() {
    return this.message;
  }
  
  public String getPhase() {
    return this.phase;
  }
  
  public String getReason() {
    return this.reason;
  }
  
  public Object getResourceStatus() {
    return this.resourceStatus;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasLastUpdateTime() {
    return this.lastUpdateTime != null;
  }
  
  public boolean hasMessage() {
    return this.message != null;
  }
  
  public boolean hasPhase() {
    return this.phase != null;
  }
  
  public boolean hasReason() {
    return this.reason != null;
  }
  
  public boolean hasResourceStatus() {
    return this.resourceStatus != null;
  }
  
  public int hashCode() {
    return Objects.hash(lastUpdateTime, message, phase, reason, resourceStatus, additionalProperties);
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
    if (!(lastUpdateTime == null)) {
        sb.append("lastUpdateTime:");
        sb.append(lastUpdateTime);
        sb.append(",");
    }
    if (!(message == null)) {
        sb.append("message:");
        sb.append(message);
        sb.append(",");
    }
    if (!(phase == null)) {
        sb.append("phase:");
        sb.append(phase);
        sb.append(",");
    }
    if (!(reason == null)) {
        sb.append("reason:");
        sb.append(reason);
        sb.append(",");
    }
    if (!(resourceStatus == null)) {
        sb.append("resourceStatus:");
        sb.append(resourceStatus);
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
  
  public A withLastUpdateTime(String lastUpdateTime) {
    this.lastUpdateTime = lastUpdateTime;
    return (A) this;
  }
  
  public A withMessage(String message) {
    this.message = message;
    return (A) this;
  }
  
  public A withPhase(String phase) {
    this.phase = phase;
    return (A) this;
  }
  
  public A withReason(String reason) {
    this.reason = reason;
    return (A) this;
  }
  
  public A withResourceStatus(Object resourceStatus) {
    this.resourceStatus = resourceStatus;
    return (A) this;
  }
  
}