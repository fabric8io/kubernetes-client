package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class AlertingRuleStatusFluent<A extends io.fabric8.openshift.api.model.monitoring.v1.AlertingRuleStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Long observedGeneration;
  private PrometheusRuleRefBuilder prometheusRule;

  public AlertingRuleStatusFluent() {
  }
  
  public AlertingRuleStatusFluent(AlertingRuleStatus instance) {
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
  
  public PrometheusRuleRef buildPrometheusRule() {
    return this.prometheusRule != null ? this.prometheusRule.build() : null;
  }
  
  protected void copyInstance(AlertingRuleStatus instance) {
    instance = instance != null ? instance : new AlertingRuleStatus();
    if (instance != null) {
        this.withObservedGeneration(instance.getObservedGeneration());
        this.withPrometheusRule(instance.getPrometheusRule());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PrometheusRuleNested<A> editOrNewPrometheusRule() {
    return this.withNewPrometheusRuleLike(Optional.ofNullable(this.buildPrometheusRule()).orElse(new PrometheusRuleRefBuilder().build()));
  }
  
  public PrometheusRuleNested<A> editOrNewPrometheusRuleLike(PrometheusRuleRef item) {
    return this.withNewPrometheusRuleLike(Optional.ofNullable(this.buildPrometheusRule()).orElse(item));
  }
  
  public PrometheusRuleNested<A> editPrometheusRule() {
    return this.withNewPrometheusRuleLike(Optional.ofNullable(this.buildPrometheusRule()).orElse(null));
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
    AlertingRuleStatusFluent that = (AlertingRuleStatusFluent) o;
    if (!(Objects.equals(observedGeneration, that.observedGeneration))) {
      return false;
    }
    if (!(Objects.equals(prometheusRule, that.prometheusRule))) {
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
  
  public Long getObservedGeneration() {
    return this.observedGeneration;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasObservedGeneration() {
    return this.observedGeneration != null;
  }
  
  public boolean hasPrometheusRule() {
    return this.prometheusRule != null;
  }
  
  public int hashCode() {
    return Objects.hash(observedGeneration, prometheusRule, additionalProperties);
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
    if (!(observedGeneration == null)) {
        sb.append("observedGeneration:");
        sb.append(observedGeneration);
        sb.append(",");
    }
    if (!(prometheusRule == null)) {
        sb.append("prometheusRule:");
        sb.append(prometheusRule);
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
  
  public PrometheusRuleNested<A> withNewPrometheusRule() {
    return new PrometheusRuleNested(null);
  }
  
  public A withNewPrometheusRule(String name) {
    return (A) this.withPrometheusRule(new PrometheusRuleRef(name));
  }
  
  public PrometheusRuleNested<A> withNewPrometheusRuleLike(PrometheusRuleRef item) {
    return new PrometheusRuleNested(item);
  }
  
  public A withObservedGeneration(Long observedGeneration) {
    this.observedGeneration = observedGeneration;
    return (A) this;
  }
  
  public A withPrometheusRule(PrometheusRuleRef prometheusRule) {
    this._visitables.remove("prometheusRule");
    if (prometheusRule != null) {
        this.prometheusRule = new PrometheusRuleRefBuilder(prometheusRule);
        this._visitables.get("prometheusRule").add(this.prometheusRule);
    } else {
        this.prometheusRule = null;
        this._visitables.get("prometheusRule").remove(this.prometheusRule);
    }
    return (A) this;
  }
  public class PrometheusRuleNested<N> extends PrometheusRuleRefFluent<PrometheusRuleNested<N>> implements Nested<N>{
  
    PrometheusRuleRefBuilder builder;
  
    PrometheusRuleNested(PrometheusRuleRef item) {
      this.builder = new PrometheusRuleRefBuilder(this, item);
    }
  
    public N and() {
      return (N) AlertingRuleStatusFluent.this.withPrometheusRule(builder.build());
    }
    
    public N endPrometheusRule() {
      return and();
    }
    
  }
}