package io.fabric8.istio.api.api.telemetry.v1alpha1;

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
public class TracingCustomTagLiteralFluent<A extends io.fabric8.istio.api.api.telemetry.v1alpha1.TracingCustomTagLiteralFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private TracingLiteralBuilder literal;

  public TracingCustomTagLiteralFluent() {
  }
  
  public TracingCustomTagLiteralFluent(TracingCustomTagLiteral instance) {
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
  
  public TracingLiteral buildLiteral() {
    return this.literal != null ? this.literal.build() : null;
  }
  
  protected void copyInstance(TracingCustomTagLiteral instance) {
    instance = instance != null ? instance : new TracingCustomTagLiteral();
    if (instance != null) {
        this.withLiteral(instance.getLiteral());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public LiteralNested<A> editLiteral() {
    return this.withNewLiteralLike(Optional.ofNullable(this.buildLiteral()).orElse(null));
  }
  
  public LiteralNested<A> editOrNewLiteral() {
    return this.withNewLiteralLike(Optional.ofNullable(this.buildLiteral()).orElse(new TracingLiteralBuilder().build()));
  }
  
  public LiteralNested<A> editOrNewLiteralLike(TracingLiteral item) {
    return this.withNewLiteralLike(Optional.ofNullable(this.buildLiteral()).orElse(item));
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
    TracingCustomTagLiteralFluent that = (TracingCustomTagLiteralFluent) o;
    if (!(Objects.equals(literal, that.literal))) {
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
  
  public boolean hasLiteral() {
    return this.literal != null;
  }
  
  public int hashCode() {
    return Objects.hash(literal, additionalProperties);
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
    if (!(literal == null)) {
        sb.append("literal:");
        sb.append(literal);
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
  
  public A withLiteral(TracingLiteral literal) {
    this._visitables.remove("literal");
    if (literal != null) {
        this.literal = new TracingLiteralBuilder(literal);
        this._visitables.get("literal").add(this.literal);
    } else {
        this.literal = null;
        this._visitables.get("literal").remove(this.literal);
    }
    return (A) this;
  }
  
  public LiteralNested<A> withNewLiteral() {
    return new LiteralNested(null);
  }
  
  public A withNewLiteral(String value) {
    return (A) this.withLiteral(new TracingLiteral(value));
  }
  
  public LiteralNested<A> withNewLiteralLike(TracingLiteral item) {
    return new LiteralNested(item);
  }
  public class LiteralNested<N> extends TracingLiteralFluent<LiteralNested<N>> implements Nested<N>{
  
    TracingLiteralBuilder builder;
  
    LiteralNested(TracingLiteral item) {
      this.builder = new TracingLiteralBuilder(this, item);
    }
  
    public N and() {
      return (N) TracingCustomTagLiteralFluent.this.withLiteral(builder.build());
    }
    
    public N endLiteral() {
      return and();
    }
    
  }
}