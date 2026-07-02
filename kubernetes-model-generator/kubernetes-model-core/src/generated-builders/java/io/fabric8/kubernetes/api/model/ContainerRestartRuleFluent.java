package io.fabric8.kubernetes.api.model;

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
public class ContainerRestartRuleFluent<A extends io.fabric8.kubernetes.api.model.ContainerRestartRuleFluent<A>> extends BaseFluent<A>{

  private String action;
  private Map<String,Object> additionalProperties;
  private ContainerRestartRuleOnExitCodesBuilder exitCodes;

  public ContainerRestartRuleFluent() {
  }
  
  public ContainerRestartRuleFluent(ContainerRestartRule instance) {
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
  
  public ContainerRestartRuleOnExitCodes buildExitCodes() {
    return this.exitCodes != null ? this.exitCodes.build() : null;
  }
  
  protected void copyInstance(ContainerRestartRule instance) {
    instance = instance != null ? instance : new ContainerRestartRule();
    if (instance != null) {
        this.withAction(instance.getAction());
        this.withExitCodes(instance.getExitCodes());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ExitCodesNested<A> editExitCodes() {
    return this.withNewExitCodesLike(Optional.ofNullable(this.buildExitCodes()).orElse(null));
  }
  
  public ExitCodesNested<A> editOrNewExitCodes() {
    return this.withNewExitCodesLike(Optional.ofNullable(this.buildExitCodes()).orElse(new ContainerRestartRuleOnExitCodesBuilder().build()));
  }
  
  public ExitCodesNested<A> editOrNewExitCodesLike(ContainerRestartRuleOnExitCodes item) {
    return this.withNewExitCodesLike(Optional.ofNullable(this.buildExitCodes()).orElse(item));
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
    ContainerRestartRuleFluent that = (ContainerRestartRuleFluent) o;
    if (!(Objects.equals(action, that.action))) {
      return false;
    }
    if (!(Objects.equals(exitCodes, that.exitCodes))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public String getAction() {
    return this.action;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public boolean hasAction() {
    return this.action != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasExitCodes() {
    return this.exitCodes != null;
  }
  
  public int hashCode() {
    return Objects.hash(action, exitCodes, additionalProperties);
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
    if (!(action == null)) {
        sb.append("action:");
        sb.append(action);
        sb.append(",");
    }
    if (!(exitCodes == null)) {
        sb.append("exitCodes:");
        sb.append(exitCodes);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAction(String action) {
    this.action = action;
    return (A) this;
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withExitCodes(ContainerRestartRuleOnExitCodes exitCodes) {
    this._visitables.remove("exitCodes");
    if (exitCodes != null) {
        this.exitCodes = new ContainerRestartRuleOnExitCodesBuilder(exitCodes);
        this._visitables.get("exitCodes").add(this.exitCodes);
    } else {
        this.exitCodes = null;
        this._visitables.get("exitCodes").remove(this.exitCodes);
    }
    return (A) this;
  }
  
  public ExitCodesNested<A> withNewExitCodes() {
    return new ExitCodesNested(null);
  }
  
  public ExitCodesNested<A> withNewExitCodesLike(ContainerRestartRuleOnExitCodes item) {
    return new ExitCodesNested(item);
  }
  public class ExitCodesNested<N> extends ContainerRestartRuleOnExitCodesFluent<ExitCodesNested<N>> implements Nested<N>{
  
    ContainerRestartRuleOnExitCodesBuilder builder;
  
    ExitCodesNested(ContainerRestartRuleOnExitCodes item) {
      this.builder = new ContainerRestartRuleOnExitCodesBuilder(this, item);
    }
  
    public N and() {
      return (N) ContainerRestartRuleFluent.this.withExitCodes(builder.build());
    }
    
    public N endExitCodes() {
      return and();
    }
    
  }
}