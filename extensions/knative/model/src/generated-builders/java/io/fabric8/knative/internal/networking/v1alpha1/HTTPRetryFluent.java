package io.fabric8.knative.internal.networking.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.model.Duration;
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
public class HTTPRetryFluent<A extends io.fabric8.knative.internal.networking.v1alpha1.HTTPRetryFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer attempts;
  private Duration perTryTimeout;

  public HTTPRetryFluent() {
  }
  
  public HTTPRetryFluent(HTTPRetry instance) {
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
  
  protected void copyInstance(HTTPRetry instance) {
    instance = instance != null ? instance : new HTTPRetry();
    if (instance != null) {
        this.withAttempts(instance.getAttempts());
        this.withPerTryTimeout(instance.getPerTryTimeout());
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
    HTTPRetryFluent that = (HTTPRetryFluent) o;
    if (!(Objects.equals(attempts, that.attempts))) {
      return false;
    }
    if (!(Objects.equals(perTryTimeout, that.perTryTimeout))) {
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
  
  public Integer getAttempts() {
    return this.attempts;
  }
  
  public Duration getPerTryTimeout() {
    return this.perTryTimeout;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAttempts() {
    return this.attempts != null;
  }
  
  public boolean hasPerTryTimeout() {
    return this.perTryTimeout != null;
  }
  
  public int hashCode() {
    return Objects.hash(attempts, perTryTimeout, additionalProperties);
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
    if (!(attempts == null)) {
        sb.append("attempts:");
        sb.append(attempts);
        sb.append(",");
    }
    if (!(perTryTimeout == null)) {
        sb.append("perTryTimeout:");
        sb.append(perTryTimeout);
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
  
  public A withAttempts(Integer attempts) {
    this.attempts = attempts;
    return (A) this;
  }
  
  public A withPerTryTimeout(Duration perTryTimeout) {
    this.perTryTimeout = perTryTimeout;
    return (A) this;
  }
  
}