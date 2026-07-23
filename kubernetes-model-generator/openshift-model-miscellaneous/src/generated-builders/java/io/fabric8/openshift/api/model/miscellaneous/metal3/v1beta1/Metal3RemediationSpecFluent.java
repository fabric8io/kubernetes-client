package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
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
public class Metal3RemediationSpecFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1.Metal3RemediationSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private RemediationStrategyBuilder strategy;

  public Metal3RemediationSpecFluent() {
  }
  
  public Metal3RemediationSpecFluent(Metal3RemediationSpec instance) {
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
  
  public RemediationStrategy buildStrategy() {
    return this.strategy != null ? this.strategy.build() : null;
  }
  
  protected void copyInstance(Metal3RemediationSpec instance) {
    instance = instance != null ? instance : new Metal3RemediationSpec();
    if (instance != null) {
        this.withStrategy(instance.getStrategy());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public StrategyNested<A> editOrNewStrategy() {
    return this.withNewStrategyLike(Optional.ofNullable(this.buildStrategy()).orElse(new RemediationStrategyBuilder().build()));
  }
  
  public StrategyNested<A> editOrNewStrategyLike(RemediationStrategy item) {
    return this.withNewStrategyLike(Optional.ofNullable(this.buildStrategy()).orElse(item));
  }
  
  public StrategyNested<A> editStrategy() {
    return this.withNewStrategyLike(Optional.ofNullable(this.buildStrategy()).orElse(null));
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
    Metal3RemediationSpecFluent that = (Metal3RemediationSpecFluent) o;
    if (!(Objects.equals(strategy, that.strategy))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasStrategy() {
    return this.strategy != null;
  }
  
  public int hashCode() {
    return Objects.hash(strategy, additionalProperties);
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
    if (!(strategy == null)) {
        sb.append("strategy:");
        sb.append(strategy);
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
  
  public StrategyNested<A> withNewStrategy() {
    return new StrategyNested(null);
  }
  
  public A withNewStrategy(Integer retryLimit,String timeout,String type) {
    return (A) this.withStrategy(new RemediationStrategy(retryLimit, timeout, type));
  }
  
  public StrategyNested<A> withNewStrategyLike(RemediationStrategy item) {
    return new StrategyNested(item);
  }
  
  public A withStrategy(RemediationStrategy strategy) {
    this._visitables.remove("strategy");
    if (strategy != null) {
        this.strategy = new RemediationStrategyBuilder(strategy);
        this._visitables.get("strategy").add(this.strategy);
    } else {
        this.strategy = null;
        this._visitables.get("strategy").remove(this.strategy);
    }
    return (A) this;
  }
  public class StrategyNested<N> extends RemediationStrategyFluent<StrategyNested<N>> implements Nested<N>{
  
    RemediationStrategyBuilder builder;
  
    StrategyNested(RemediationStrategy item) {
      this.builder = new RemediationStrategyBuilder(this, item);
    }
  
    public N and() {
      return (N) Metal3RemediationSpecFluent.this.withStrategy(builder.build());
    }
    
    public N endStrategy() {
      return and();
    }
    
  }
}