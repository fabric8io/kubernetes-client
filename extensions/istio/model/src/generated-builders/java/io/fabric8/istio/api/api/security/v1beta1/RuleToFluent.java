package io.fabric8.istio.api.api.security.v1beta1;

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
public class RuleToFluent<A extends io.fabric8.istio.api.api.security.v1beta1.RuleToFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private OperationBuilder operation;

  public RuleToFluent() {
  }
  
  public RuleToFluent(RuleTo instance) {
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
  
  public Operation buildOperation() {
    return this.operation != null ? this.operation.build() : null;
  }
  
  protected void copyInstance(RuleTo instance) {
    instance = instance != null ? instance : new RuleTo();
    if (instance != null) {
        this.withOperation(instance.getOperation());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public OperationNested<A> editOperation() {
    return this.withNewOperationLike(Optional.ofNullable(this.buildOperation()).orElse(null));
  }
  
  public OperationNested<A> editOrNewOperation() {
    return this.withNewOperationLike(Optional.ofNullable(this.buildOperation()).orElse(new OperationBuilder().build()));
  }
  
  public OperationNested<A> editOrNewOperationLike(Operation item) {
    return this.withNewOperationLike(Optional.ofNullable(this.buildOperation()).orElse(item));
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
    RuleToFluent that = (RuleToFluent) o;
    if (!(Objects.equals(operation, that.operation))) {
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
  
  public boolean hasOperation() {
    return this.operation != null;
  }
  
  public int hashCode() {
    return Objects.hash(operation, additionalProperties);
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
    if (!(operation == null)) {
        sb.append("operation:");
        sb.append(operation);
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
  
  public OperationNested<A> withNewOperation() {
    return new OperationNested(null);
  }
  
  public OperationNested<A> withNewOperationLike(Operation item) {
    return new OperationNested(item);
  }
  
  public A withOperation(Operation operation) {
    this._visitables.remove("operation");
    if (operation != null) {
        this.operation = new OperationBuilder(operation);
        this._visitables.get("operation").add(this.operation);
    } else {
        this.operation = null;
        this._visitables.get("operation").remove(this.operation);
    }
    return (A) this;
  }
  public class OperationNested<N> extends OperationFluent<OperationNested<N>> implements Nested<N>{
  
    OperationBuilder builder;
  
    OperationNested(Operation item) {
      this.builder = new OperationBuilder(this, item);
    }
  
    public N and() {
      return (N) RuleToFluent.this.withOperation(builder.build());
    }
    
    public N endOperation() {
      return and();
    }
    
  }
}