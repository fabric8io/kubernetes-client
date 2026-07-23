package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Double;
import java.lang.Long;
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
public class TrafficPolicyRetryBudgetFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.TrafficPolicyRetryBudgetFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Long minRetryConcurrency;
  private Double percent;

  public TrafficPolicyRetryBudgetFluent() {
  }
  
  public TrafficPolicyRetryBudgetFluent(TrafficPolicyRetryBudget instance) {
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
  
  protected void copyInstance(TrafficPolicyRetryBudget instance) {
    instance = instance != null ? instance : new TrafficPolicyRetryBudget();
    if (instance != null) {
        this.withMinRetryConcurrency(instance.getMinRetryConcurrency());
        this.withPercent(instance.getPercent());
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
    TrafficPolicyRetryBudgetFluent that = (TrafficPolicyRetryBudgetFluent) o;
    if (!(Objects.equals(minRetryConcurrency, that.minRetryConcurrency))) {
      return false;
    }
    if (!(Objects.equals(percent, that.percent))) {
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
  
  public Long getMinRetryConcurrency() {
    return this.minRetryConcurrency;
  }
  
  public Double getPercent() {
    return this.percent;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMinRetryConcurrency() {
    return this.minRetryConcurrency != null;
  }
  
  public boolean hasPercent() {
    return this.percent != null;
  }
  
  public int hashCode() {
    return Objects.hash(minRetryConcurrency, percent, additionalProperties);
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
    if (!(minRetryConcurrency == null)) {
        sb.append("minRetryConcurrency:");
        sb.append(minRetryConcurrency);
        sb.append(",");
    }
    if (!(percent == null)) {
        sb.append("percent:");
        sb.append(percent);
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
  
  public A withMinRetryConcurrency(Long minRetryConcurrency) {
    this.minRetryConcurrency = minRetryConcurrency;
    return (A) this;
  }
  
  public A withPercent(Double percent) {
    this.percent = percent;
    return (A) this;
  }
  
}