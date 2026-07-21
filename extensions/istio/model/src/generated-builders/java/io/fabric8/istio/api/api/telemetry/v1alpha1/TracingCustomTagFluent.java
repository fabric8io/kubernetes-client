package io.fabric8.istio.api.api.telemetry.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.builder.VisitableBuilder;
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
public class TracingCustomTagFluent<A extends io.fabric8.istio.api.api.telemetry.v1alpha1.TracingCustomTagFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private VisitableBuilder<? extends IsTracingCustomTagType,?> type;

  public TracingCustomTagFluent() {
  }
  
  public TracingCustomTagFluent(TracingCustomTag instance) {
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
  
  public IsTracingCustomTagType buildType() {
    return this.type != null ? this.type.build() : null;
  }
  
  protected static <T>VisitableBuilder<T,?> builder(Object item) {
    switch (item.getClass().getName()) {
      case "TracingCustomTagHeader":
    
          return (VisitableBuilder<T,?>) new TracingCustomTagHeaderBuilder((TracingCustomTagHeader) item);
    
      case "TracingCustomTagLiteral":
    
          return (VisitableBuilder<T,?>) new TracingCustomTagLiteralBuilder((TracingCustomTagLiteral) item);
    
      case "TracingCustomTagFormatter":
    
          return (VisitableBuilder<T,?>) new TracingCustomTagFormatterBuilder((TracingCustomTagFormatter) item);
    
      case "TracingCustomTagEnvironment":
    
          return (VisitableBuilder<T,?>) new TracingCustomTagEnvironmentBuilder((TracingCustomTagEnvironment) item);
    
      default:
    
          return (VisitableBuilder<T,?>) builderOf(item);
    
    }
  }
  
  protected void copyInstance(TracingCustomTag instance) {
    instance = instance != null ? instance : new TracingCustomTag();
    if (instance != null) {
        this.withType(instance.getType());
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
    TracingCustomTagFluent that = (TracingCustomTagFluent) o;
    if (!(Objects.equals(type, that.type))) {
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
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(type, additionalProperties);
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
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
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
  
  public TracingCustomTagEnvironmentTypeNested<A> withNewTracingCustomTagEnvironmentType() {
    return new TracingCustomTagEnvironmentTypeNested(null);
  }
  
  public TracingCustomTagEnvironmentTypeNested<A> withNewTracingCustomTagEnvironmentTypeLike(TracingCustomTagEnvironment item) {
    return new TracingCustomTagEnvironmentTypeNested(item);
  }
  
  public TracingCustomTagFormatterTypeNested<A> withNewTracingCustomTagFormatterType() {
    return new TracingCustomTagFormatterTypeNested(null);
  }
  
  public TracingCustomTagFormatterTypeNested<A> withNewTracingCustomTagFormatterTypeLike(TracingCustomTagFormatter item) {
    return new TracingCustomTagFormatterTypeNested(item);
  }
  
  public TracingCustomTagHeaderTypeNested<A> withNewTracingCustomTagHeaderType() {
    return new TracingCustomTagHeaderTypeNested(null);
  }
  
  public TracingCustomTagHeaderTypeNested<A> withNewTracingCustomTagHeaderTypeLike(TracingCustomTagHeader item) {
    return new TracingCustomTagHeaderTypeNested(item);
  }
  
  public TracingCustomTagLiteralTypeNested<A> withNewTracingCustomTagLiteralType() {
    return new TracingCustomTagLiteralTypeNested(null);
  }
  
  public TracingCustomTagLiteralTypeNested<A> withNewTracingCustomTagLiteralTypeLike(TracingCustomTagLiteral item) {
    return new TracingCustomTagLiteralTypeNested(item);
  }
  
  public A withType(IsTracingCustomTagType type) {
    if (type == null) {
        this.type = null;
        this._visitables.remove("type");
        return (A) this;
    } else {
        VisitableBuilder<? extends IsTracingCustomTagType,?> builder = builder(type);
        this._visitables.get("type").clear();
        this._visitables.get("type").add(builder);
        this.type = builder;
        return (A) this;
    }
  }
  public class TracingCustomTagEnvironmentTypeNested<N> extends TracingCustomTagEnvironmentFluent<TracingCustomTagEnvironmentTypeNested<N>> implements Nested<N>{
  
    TracingCustomTagEnvironmentBuilder builder;
  
    TracingCustomTagEnvironmentTypeNested(TracingCustomTagEnvironment item) {
      this.builder = new TracingCustomTagEnvironmentBuilder(this, item);
    }
  
    public N and() {
      return (N) TracingCustomTagFluent.this.withType(builder.build());
    }
    
    public N endTracingCustomTagEnvironmentType() {
      return and();
    }
    
  }
  public class TracingCustomTagFormatterTypeNested<N> extends TracingCustomTagFormatterFluent<TracingCustomTagFormatterTypeNested<N>> implements Nested<N>{
  
    TracingCustomTagFormatterBuilder builder;
  
    TracingCustomTagFormatterTypeNested(TracingCustomTagFormatter item) {
      this.builder = new TracingCustomTagFormatterBuilder(this, item);
    }
  
    public N and() {
      return (N) TracingCustomTagFluent.this.withType(builder.build());
    }
    
    public N endTracingCustomTagFormatterType() {
      return and();
    }
    
  }
  public class TracingCustomTagHeaderTypeNested<N> extends TracingCustomTagHeaderFluent<TracingCustomTagHeaderTypeNested<N>> implements Nested<N>{
  
    TracingCustomTagHeaderBuilder builder;
  
    TracingCustomTagHeaderTypeNested(TracingCustomTagHeader item) {
      this.builder = new TracingCustomTagHeaderBuilder(this, item);
    }
  
    public N and() {
      return (N) TracingCustomTagFluent.this.withType(builder.build());
    }
    
    public N endTracingCustomTagHeaderType() {
      return and();
    }
    
  }
  public class TracingCustomTagLiteralTypeNested<N> extends TracingCustomTagLiteralFluent<TracingCustomTagLiteralTypeNested<N>> implements Nested<N>{
  
    TracingCustomTagLiteralBuilder builder;
  
    TracingCustomTagLiteralTypeNested(TracingCustomTagLiteral item) {
      this.builder = new TracingCustomTagLiteralBuilder(this, item);
    }
  
    public N and() {
      return (N) TracingCustomTagFluent.this.withType(builder.build());
    }
    
    public N endTracingCustomTagLiteralType() {
      return and();
    }
    
  }
}