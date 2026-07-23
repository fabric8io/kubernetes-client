package io.fabric8.knative.sources.v1alpha1;

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
public class TimerFluent<A extends io.fabric8.knative.sources.v1alpha1.TimerFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String contentType;
  private String message;
  private Integer period;
  private Integer repeatCount;

  public TimerFluent() {
  }
  
  public TimerFluent(Timer instance) {
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
  
  protected void copyInstance(Timer instance) {
    instance = instance != null ? instance : new Timer();
    if (instance != null) {
        this.withContentType(instance.getContentType());
        this.withMessage(instance.getMessage());
        this.withPeriod(instance.getPeriod());
        this.withRepeatCount(instance.getRepeatCount());
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
    TimerFluent that = (TimerFluent) o;
    if (!(Objects.equals(contentType, that.contentType))) {
      return false;
    }
    if (!(Objects.equals(message, that.message))) {
      return false;
    }
    if (!(Objects.equals(period, that.period))) {
      return false;
    }
    if (!(Objects.equals(repeatCount, that.repeatCount))) {
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
  
  public String getContentType() {
    return this.contentType;
  }
  
  public String getMessage() {
    return this.message;
  }
  
  public Integer getPeriod() {
    return this.period;
  }
  
  public Integer getRepeatCount() {
    return this.repeatCount;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasContentType() {
    return this.contentType != null;
  }
  
  public boolean hasMessage() {
    return this.message != null;
  }
  
  public boolean hasPeriod() {
    return this.period != null;
  }
  
  public boolean hasRepeatCount() {
    return this.repeatCount != null;
  }
  
  public int hashCode() {
    return Objects.hash(contentType, message, period, repeatCount, additionalProperties);
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
    if (!(contentType == null)) {
        sb.append("contentType:");
        sb.append(contentType);
        sb.append(",");
    }
    if (!(message == null)) {
        sb.append("message:");
        sb.append(message);
        sb.append(",");
    }
    if (!(period == null)) {
        sb.append("period:");
        sb.append(period);
        sb.append(",");
    }
    if (!(repeatCount == null)) {
        sb.append("repeatCount:");
        sb.append(repeatCount);
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
  
  public A withContentType(String contentType) {
    this.contentType = contentType;
    return (A) this;
  }
  
  public A withMessage(String message) {
    this.message = message;
    return (A) this;
  }
  
  public A withPeriod(Integer period) {
    this.period = period;
    return (A) this;
  }
  
  public A withRepeatCount(Integer repeatCount) {
    this.repeatCount = repeatCount;
    return (A) this;
  }
  
}