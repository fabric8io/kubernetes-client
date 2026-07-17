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
public class AlertmanagerLimitsSpecFluent<A extends io.fabric8.openshift.api.model.monitoring.v1.AlertmanagerLimitsSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String maxPerSilenceBytes;
  private Integer maxSilences;

  public AlertmanagerLimitsSpecFluent() {
  }
  
  public AlertmanagerLimitsSpecFluent(AlertmanagerLimitsSpec instance) {
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
  
  protected void copyInstance(AlertmanagerLimitsSpec instance) {
    instance = instance != null ? instance : new AlertmanagerLimitsSpec();
    if (instance != null) {
        this.withMaxPerSilenceBytes(instance.getMaxPerSilenceBytes());
        this.withMaxSilences(instance.getMaxSilences());
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
    AlertmanagerLimitsSpecFluent that = (AlertmanagerLimitsSpecFluent) o;
    if (!(Objects.equals(maxPerSilenceBytes, that.maxPerSilenceBytes))) {
      return false;
    }
    if (!(Objects.equals(maxSilences, that.maxSilences))) {
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
  
  public String getMaxPerSilenceBytes() {
    return this.maxPerSilenceBytes;
  }
  
  public Integer getMaxSilences() {
    return this.maxSilences;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMaxPerSilenceBytes() {
    return this.maxPerSilenceBytes != null;
  }
  
  public boolean hasMaxSilences() {
    return this.maxSilences != null;
  }
  
  public int hashCode() {
    return Objects.hash(maxPerSilenceBytes, maxSilences, additionalProperties);
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
    if (!(maxPerSilenceBytes == null)) {
        sb.append("maxPerSilenceBytes:");
        sb.append(maxPerSilenceBytes);
        sb.append(",");
    }
    if (!(maxSilences == null)) {
        sb.append("maxSilences:");
        sb.append(maxSilences);
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
  
  public A withMaxPerSilenceBytes(String maxPerSilenceBytes) {
    this.maxPerSilenceBytes = maxPerSilenceBytes;
    return (A) this;
  }
  
  public A withMaxSilences(Integer maxSilences) {
    this.maxSilences = maxSilences;
    return (A) this;
  }
  
}