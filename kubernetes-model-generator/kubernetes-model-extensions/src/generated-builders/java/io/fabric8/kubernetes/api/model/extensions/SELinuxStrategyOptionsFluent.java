package io.fabric8.kubernetes.api.model.extensions;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.model.SELinuxOptions;
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
public class SELinuxStrategyOptionsFluent<A extends io.fabric8.kubernetes.api.model.extensions.SELinuxStrategyOptionsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String rule;
  private SELinuxOptions seLinuxOptions;

  public SELinuxStrategyOptionsFluent() {
  }
  
  public SELinuxStrategyOptionsFluent(SELinuxStrategyOptions instance) {
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
  
  protected void copyInstance(SELinuxStrategyOptions instance) {
    instance = instance != null ? instance : new SELinuxStrategyOptions();
    if (instance != null) {
        this.withRule(instance.getRule());
        this.withSeLinuxOptions(instance.getSeLinuxOptions());
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
    SELinuxStrategyOptionsFluent that = (SELinuxStrategyOptionsFluent) o;
    if (!(Objects.equals(rule, that.rule))) {
      return false;
    }
    if (!(Objects.equals(seLinuxOptions, that.seLinuxOptions))) {
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
  
  public String getRule() {
    return this.rule;
  }
  
  public SELinuxOptions getSeLinuxOptions() {
    return this.seLinuxOptions;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasRule() {
    return this.rule != null;
  }
  
  public boolean hasSeLinuxOptions() {
    return this.seLinuxOptions != null;
  }
  
  public int hashCode() {
    return Objects.hash(rule, seLinuxOptions, additionalProperties);
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
    if (!(rule == null)) {
        sb.append("rule:");
        sb.append(rule);
        sb.append(",");
    }
    if (!(seLinuxOptions == null)) {
        sb.append("seLinuxOptions:");
        sb.append(seLinuxOptions);
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
  
  public A withNewSeLinuxOptions(String level,String role,String type,String user) {
    return (A) this.withSeLinuxOptions(new SELinuxOptions(level, role, type, user));
  }
  
  public A withRule(String rule) {
    this.rule = rule;
    return (A) this;
  }
  
  public A withSeLinuxOptions(SELinuxOptions seLinuxOptions) {
    this.seLinuxOptions = seLinuxOptions;
    return (A) this;
  }
  
}