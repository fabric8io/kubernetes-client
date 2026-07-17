package io.fabric8.openshift.api.model.monitoring.v1;

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
public class QuerySpecFluent<A extends io.fabric8.openshift.api.model.monitoring.v1.QuerySpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String lookbackDelta;
  private Integer maxConcurrency;
  private Integer maxSamples;
  private String timeout;

  public QuerySpecFluent() {
  }
  
  public QuerySpecFluent(QuerySpec instance) {
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
  
  protected void copyInstance(QuerySpec instance) {
    instance = instance != null ? instance : new QuerySpec();
    if (instance != null) {
        this.withLookbackDelta(instance.getLookbackDelta());
        this.withMaxConcurrency(instance.getMaxConcurrency());
        this.withMaxSamples(instance.getMaxSamples());
        this.withTimeout(instance.getTimeout());
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
    QuerySpecFluent that = (QuerySpecFluent) o;
    if (!(Objects.equals(lookbackDelta, that.lookbackDelta))) {
      return false;
    }
    if (!(Objects.equals(maxConcurrency, that.maxConcurrency))) {
      return false;
    }
    if (!(Objects.equals(maxSamples, that.maxSamples))) {
      return false;
    }
    if (!(Objects.equals(timeout, that.timeout))) {
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
  
  public String getLookbackDelta() {
    return this.lookbackDelta;
  }
  
  public Integer getMaxConcurrency() {
    return this.maxConcurrency;
  }
  
  public Integer getMaxSamples() {
    return this.maxSamples;
  }
  
  public String getTimeout() {
    return this.timeout;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasLookbackDelta() {
    return this.lookbackDelta != null;
  }
  
  public boolean hasMaxConcurrency() {
    return this.maxConcurrency != null;
  }
  
  public boolean hasMaxSamples() {
    return this.maxSamples != null;
  }
  
  public boolean hasTimeout() {
    return this.timeout != null;
  }
  
  public int hashCode() {
    return Objects.hash(lookbackDelta, maxConcurrency, maxSamples, timeout, additionalProperties);
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
    if (!(lookbackDelta == null)) {
        sb.append("lookbackDelta:");
        sb.append(lookbackDelta);
        sb.append(",");
    }
    if (!(maxConcurrency == null)) {
        sb.append("maxConcurrency:");
        sb.append(maxConcurrency);
        sb.append(",");
    }
    if (!(maxSamples == null)) {
        sb.append("maxSamples:");
        sb.append(maxSamples);
        sb.append(",");
    }
    if (!(timeout == null)) {
        sb.append("timeout:");
        sb.append(timeout);
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
  
  public A withLookbackDelta(String lookbackDelta) {
    this.lookbackDelta = lookbackDelta;
    return (A) this;
  }
  
  public A withMaxConcurrency(Integer maxConcurrency) {
    this.maxConcurrency = maxConcurrency;
    return (A) this;
  }
  
  public A withMaxSamples(Integer maxSamples) {
    this.maxSamples = maxSamples;
    return (A) this;
  }
  
  public A withTimeout(String timeout) {
    this.timeout = timeout;
    return (A) this;
  }
  
}