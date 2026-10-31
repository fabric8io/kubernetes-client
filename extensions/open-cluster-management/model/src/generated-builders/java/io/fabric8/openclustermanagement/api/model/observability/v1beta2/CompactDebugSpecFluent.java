package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

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
public class CompactDebugSpecFluent<A extends io.fabric8.openclustermanagement.api.model.observability.v1beta2.CompactDebugSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer blockMetaFetchConcurrency;
  private Integer downsampleConcurrency;
  private String logLevel;
  private String waitInterval;

  public CompactDebugSpecFluent() {
  }
  
  public CompactDebugSpecFluent(CompactDebugSpec instance) {
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
  
  protected void copyInstance(CompactDebugSpec instance) {
    instance = instance != null ? instance : new CompactDebugSpec();
    if (instance != null) {
        this.withBlockMetaFetchConcurrency(instance.getBlockMetaFetchConcurrency());
        this.withDownsampleConcurrency(instance.getDownsampleConcurrency());
        this.withLogLevel(instance.getLogLevel());
        this.withWaitInterval(instance.getWaitInterval());
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
    CompactDebugSpecFluent that = (CompactDebugSpecFluent) o;
    if (!(Objects.equals(blockMetaFetchConcurrency, that.blockMetaFetchConcurrency))) {
      return false;
    }
    if (!(Objects.equals(downsampleConcurrency, that.downsampleConcurrency))) {
      return false;
    }
    if (!(Objects.equals(logLevel, that.logLevel))) {
      return false;
    }
    if (!(Objects.equals(waitInterval, that.waitInterval))) {
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
  
  public Integer getBlockMetaFetchConcurrency() {
    return this.blockMetaFetchConcurrency;
  }
  
  public Integer getDownsampleConcurrency() {
    return this.downsampleConcurrency;
  }
  
  public String getLogLevel() {
    return this.logLevel;
  }
  
  public String getWaitInterval() {
    return this.waitInterval;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBlockMetaFetchConcurrency() {
    return this.blockMetaFetchConcurrency != null;
  }
  
  public boolean hasDownsampleConcurrency() {
    return this.downsampleConcurrency != null;
  }
  
  public boolean hasLogLevel() {
    return this.logLevel != null;
  }
  
  public boolean hasWaitInterval() {
    return this.waitInterval != null;
  }
  
  public int hashCode() {
    return Objects.hash(blockMetaFetchConcurrency, downsampleConcurrency, logLevel, waitInterval, additionalProperties);
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
    if (!(blockMetaFetchConcurrency == null)) {
        sb.append("blockMetaFetchConcurrency:");
        sb.append(blockMetaFetchConcurrency);
        sb.append(",");
    }
    if (!(downsampleConcurrency == null)) {
        sb.append("downsampleConcurrency:");
        sb.append(downsampleConcurrency);
        sb.append(",");
    }
    if (!(logLevel == null)) {
        sb.append("logLevel:");
        sb.append(logLevel);
        sb.append(",");
    }
    if (!(waitInterval == null)) {
        sb.append("waitInterval:");
        sb.append(waitInterval);
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
  
  public A withBlockMetaFetchConcurrency(Integer blockMetaFetchConcurrency) {
    this.blockMetaFetchConcurrency = blockMetaFetchConcurrency;
    return (A) this;
  }
  
  public A withDownsampleConcurrency(Integer downsampleConcurrency) {
    this.downsampleConcurrency = downsampleConcurrency;
    return (A) this;
  }
  
  public A withLogLevel(String logLevel) {
    this.logLevel = logLevel;
    return (A) this;
  }
  
  public A withWaitInterval(String waitInterval) {
    this.waitInterval = waitInterval;
    return (A) this;
  }
  
}