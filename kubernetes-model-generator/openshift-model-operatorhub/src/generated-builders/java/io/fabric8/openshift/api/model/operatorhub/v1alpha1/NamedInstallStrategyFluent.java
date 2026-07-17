package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class NamedInstallStrategyFluent<A extends io.fabric8.openshift.api.model.operatorhub.v1alpha1.NamedInstallStrategyFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private StrategyDetailsDeploymentBuilder spec;
  private String strategy;

  public NamedInstallStrategyFluent() {
  }
  
  public NamedInstallStrategyFluent(NamedInstallStrategy instance) {
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
  
  public StrategyDetailsDeployment buildSpec() {
    return this.spec != null ? this.spec.build() : null;
  }
  
  protected void copyInstance(NamedInstallStrategy instance) {
    instance = instance != null ? instance : new NamedInstallStrategy();
    if (instance != null) {
        this.withSpec(instance.getSpec());
        this.withStrategy(instance.getStrategy());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SpecNested<A> editOrNewSpec() {
    return this.withNewSpecLike(Optional.ofNullable(this.buildSpec()).orElse(new StrategyDetailsDeploymentBuilder().build()));
  }
  
  public SpecNested<A> editOrNewSpecLike(StrategyDetailsDeployment item) {
    return this.withNewSpecLike(Optional.ofNullable(this.buildSpec()).orElse(item));
  }
  
  public SpecNested<A> editSpec() {
    return this.withNewSpecLike(Optional.ofNullable(this.buildSpec()).orElse(null));
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
    NamedInstallStrategyFluent that = (NamedInstallStrategyFluent) o;
    if (!(Objects.equals(spec, that.spec))) {
      return false;
    }
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
  
  public String getStrategy() {
    return this.strategy;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasSpec() {
    return this.spec != null;
  }
  
  public boolean hasStrategy() {
    return this.strategy != null;
  }
  
  public int hashCode() {
    return Objects.hash(spec, strategy, additionalProperties);
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
    if (!(spec == null)) {
        sb.append("spec:");
        sb.append(spec);
        sb.append(",");
    }
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
  
  public SpecNested<A> withNewSpec() {
    return new SpecNested(null);
  }
  
  public SpecNested<A> withNewSpecLike(StrategyDetailsDeployment item) {
    return new SpecNested(item);
  }
  
  public A withSpec(StrategyDetailsDeployment spec) {
    this._visitables.remove("spec");
    if (spec != null) {
        this.spec = new StrategyDetailsDeploymentBuilder(spec);
        this._visitables.get("spec").add(this.spec);
    } else {
        this.spec = null;
        this._visitables.get("spec").remove(this.spec);
    }
    return (A) this;
  }
  
  public A withStrategy(String strategy) {
    this.strategy = strategy;
    return (A) this;
  }
  public class SpecNested<N> extends StrategyDetailsDeploymentFluent<SpecNested<N>> implements Nested<N>{
  
    StrategyDetailsDeploymentBuilder builder;
  
    SpecNested(StrategyDetailsDeployment item) {
      this.builder = new StrategyDetailsDeploymentBuilder(this, item);
    }
  
    public N and() {
      return (N) NamedInstallStrategyFluent.this.withSpec(builder.build());
    }
    
    public N endSpec() {
      return and();
    }
    
  }
}