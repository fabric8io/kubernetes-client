package io.fabric8.openshift.api.model.operator.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
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
public class LoggingConfigFluent<A extends io.fabric8.openshift.api.model.operator.v1alpha1.LoggingConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Long level;
  private String vmodule;

  public LoggingConfigFluent() {
  }
  
  public LoggingConfigFluent(LoggingConfig instance) {
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
  
  protected void copyInstance(LoggingConfig instance) {
    instance = instance != null ? instance : new LoggingConfig();
    if (instance != null) {
        this.withLevel(instance.getLevel());
        this.withVmodule(instance.getVmodule());
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
    LoggingConfigFluent that = (LoggingConfigFluent) o;
    if (!(Objects.equals(level, that.level))) {
      return false;
    }
    if (!(Objects.equals(vmodule, that.vmodule))) {
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
  
  public Long getLevel() {
    return this.level;
  }
  
  public String getVmodule() {
    return this.vmodule;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasLevel() {
    return this.level != null;
  }
  
  public boolean hasVmodule() {
    return this.vmodule != null;
  }
  
  public int hashCode() {
    return Objects.hash(level, vmodule, additionalProperties);
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
    if (!(level == null)) {
        sb.append("level:");
        sb.append(level);
        sb.append(",");
    }
    if (!(vmodule == null)) {
        sb.append("vmodule:");
        sb.append(vmodule);
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
  
  public A withLevel(Long level) {
    this.level = level;
    return (A) this;
  }
  
  public A withVmodule(String vmodule) {
    this.vmodule = vmodule;
    return (A) this;
  }
  
}