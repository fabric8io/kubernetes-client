package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Integer;
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
public class CloudEventDeliveryStateFluent<A extends io.fabric8.tekton.v1beta1.CloudEventDeliveryStateFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String condition;
  private String message;
  private Integer retryCount;
  private String sentAt;

  public CloudEventDeliveryStateFluent() {
  }
  
  public CloudEventDeliveryStateFluent(CloudEventDeliveryState instance) {
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
  
  protected void copyInstance(CloudEventDeliveryState instance) {
    instance = instance != null ? instance : new CloudEventDeliveryState();
    if (instance != null) {
        this.withCondition(instance.getCondition());
        this.withMessage(instance.getMessage());
        this.withRetryCount(instance.getRetryCount());
        this.withSentAt(instance.getSentAt());
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
    CloudEventDeliveryStateFluent that = (CloudEventDeliveryStateFluent) o;
    if (!(Objects.equals(condition, that.condition))) {
      return false;
    }
    if (!(Objects.equals(message, that.message))) {
      return false;
    }
    if (!(Objects.equals(retryCount, that.retryCount))) {
      return false;
    }
    if (!(Objects.equals(sentAt, that.sentAt))) {
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
  
  public String getCondition() {
    return this.condition;
  }
  
  public String getMessage() {
    return this.message;
  }
  
  public Integer getRetryCount() {
    return this.retryCount;
  }
  
  public String getSentAt() {
    return this.sentAt;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCondition() {
    return this.condition != null;
  }
  
  public boolean hasMessage() {
    return this.message != null;
  }
  
  public boolean hasRetryCount() {
    return this.retryCount != null;
  }
  
  public boolean hasSentAt() {
    return this.sentAt != null;
  }
  
  public int hashCode() {
    return Objects.hash(condition, message, retryCount, sentAt, additionalProperties);
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
    if (!(condition == null)) {
        sb.append("condition:");
        sb.append(condition);
        sb.append(",");
    }
    if (!(message == null)) {
        sb.append("message:");
        sb.append(message);
        sb.append(",");
    }
    if (!(retryCount == null)) {
        sb.append("retryCount:");
        sb.append(retryCount);
        sb.append(",");
    }
    if (!(sentAt == null)) {
        sb.append("sentAt:");
        sb.append(sentAt);
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
  
  public A withCondition(String condition) {
    this.condition = condition;
    return (A) this;
  }
  
  public A withMessage(String message) {
    this.message = message;
    return (A) this;
  }
  
  public A withRetryCount(Integer retryCount) {
    this.retryCount = retryCount;
    return (A) this;
  }
  
  public A withSentAt(String sentAt) {
    this.sentAt = sentAt;
    return (A) this;
  }
  
}