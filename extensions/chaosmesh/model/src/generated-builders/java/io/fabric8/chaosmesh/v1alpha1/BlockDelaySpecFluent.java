package io.fabric8.chaosmesh.v1alpha1;

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
public class BlockDelaySpecFluent<A extends io.fabric8.chaosmesh.v1alpha1.BlockDelaySpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String correlation;
  private String jitter;
  private String latency;

  public BlockDelaySpecFluent() {
  }
  
  public BlockDelaySpecFluent(BlockDelaySpec instance) {
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
  
  protected void copyInstance(BlockDelaySpec instance) {
    instance = instance != null ? instance : new BlockDelaySpec();
    if (instance != null) {
        this.withCorrelation(instance.getCorrelation());
        this.withJitter(instance.getJitter());
        this.withLatency(instance.getLatency());
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
    BlockDelaySpecFluent that = (BlockDelaySpecFluent) o;
    if (!(Objects.equals(correlation, that.correlation))) {
      return false;
    }
    if (!(Objects.equals(jitter, that.jitter))) {
      return false;
    }
    if (!(Objects.equals(latency, that.latency))) {
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
  
  public String getCorrelation() {
    return this.correlation;
  }
  
  public String getJitter() {
    return this.jitter;
  }
  
  public String getLatency() {
    return this.latency;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCorrelation() {
    return this.correlation != null;
  }
  
  public boolean hasJitter() {
    return this.jitter != null;
  }
  
  public boolean hasLatency() {
    return this.latency != null;
  }
  
  public int hashCode() {
    return Objects.hash(correlation, jitter, latency, additionalProperties);
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
    if (!(correlation == null)) {
        sb.append("correlation:");
        sb.append(correlation);
        sb.append(",");
    }
    if (!(jitter == null)) {
        sb.append("jitter:");
        sb.append(jitter);
        sb.append(",");
    }
    if (!(latency == null)) {
        sb.append("latency:");
        sb.append(latency);
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
  
  public A withCorrelation(String correlation) {
    this.correlation = correlation;
    return (A) this;
  }
  
  public A withJitter(String jitter) {
    this.jitter = jitter;
    return (A) this;
  }
  
  public A withLatency(String latency) {
    this.latency = latency;
    return (A) this;
  }
  
}