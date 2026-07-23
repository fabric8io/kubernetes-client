package io.fabric8.openshift.api.model.monitoring.v1;

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
public class PrometheusRuleExcludeConfigFluent<A extends io.fabric8.openshift.api.model.monitoring.v1.PrometheusRuleExcludeConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String ruleName;
  private String ruleNamespace;

  public PrometheusRuleExcludeConfigFluent() {
  }
  
  public PrometheusRuleExcludeConfigFluent(PrometheusRuleExcludeConfig instance) {
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
  
  protected void copyInstance(PrometheusRuleExcludeConfig instance) {
    instance = instance != null ? instance : new PrometheusRuleExcludeConfig();
    if (instance != null) {
        this.withRuleName(instance.getRuleName());
        this.withRuleNamespace(instance.getRuleNamespace());
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
    PrometheusRuleExcludeConfigFluent that = (PrometheusRuleExcludeConfigFluent) o;
    if (!(Objects.equals(ruleName, that.ruleName))) {
      return false;
    }
    if (!(Objects.equals(ruleNamespace, that.ruleNamespace))) {
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
  
  public String getRuleName() {
    return this.ruleName;
  }
  
  public String getRuleNamespace() {
    return this.ruleNamespace;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasRuleName() {
    return this.ruleName != null;
  }
  
  public boolean hasRuleNamespace() {
    return this.ruleNamespace != null;
  }
  
  public int hashCode() {
    return Objects.hash(ruleName, ruleNamespace, additionalProperties);
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
    if (!(ruleName == null)) {
        sb.append("ruleName:");
        sb.append(ruleName);
        sb.append(",");
    }
    if (!(ruleNamespace == null)) {
        sb.append("ruleNamespace:");
        sb.append(ruleNamespace);
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
  
  public A withRuleName(String ruleName) {
    this.ruleName = ruleName;
    return (A) this;
  }
  
  public A withRuleNamespace(String ruleNamespace) {
    this.ruleNamespace = ruleNamespace;
    return (A) this;
  }
  
}