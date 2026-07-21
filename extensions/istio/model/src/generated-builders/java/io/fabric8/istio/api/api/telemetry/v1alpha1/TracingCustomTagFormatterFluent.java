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
public class TracingCustomTagFormatterFluent<A extends io.fabric8.istio.api.api.telemetry.v1alpha1.TracingCustomTagFormatterFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private TracingFormatterBuilder formatter;

  public TracingCustomTagFormatterFluent() {
  }
  
  public TracingCustomTagFormatterFluent(TracingCustomTagFormatter instance) {
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
  
  public TracingFormatter buildFormatter() {
    return this.formatter != null ? this.formatter.build() : null;
  }
  
  protected void copyInstance(TracingCustomTagFormatter instance) {
    instance = instance != null ? instance : new TracingCustomTagFormatter();
    if (instance != null) {
        this.withFormatter(instance.getFormatter());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public FormatterNested<A> editFormatter() {
    return this.withNewFormatterLike(Optional.ofNullable(this.buildFormatter()).orElse(null));
  }
  
  public FormatterNested<A> editOrNewFormatter() {
    return this.withNewFormatterLike(Optional.ofNullable(this.buildFormatter()).orElse(new TracingFormatterBuilder().build()));
  }
  
  public FormatterNested<A> editOrNewFormatterLike(TracingFormatter item) {
    return this.withNewFormatterLike(Optional.ofNullable(this.buildFormatter()).orElse(item));
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
    TracingCustomTagFormatterFluent that = (TracingCustomTagFormatterFluent) o;
    if (!(Objects.equals(formatter, that.formatter))) {
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
  
  public boolean hasFormatter() {
    return this.formatter != null;
  }
  
  public int hashCode() {
    return Objects.hash(formatter, additionalProperties);
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
    if (!(formatter == null)) {
        sb.append("formatter:");
        sb.append(formatter);
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
  
  public A withFormatter(TracingFormatter formatter) {
    this._visitables.remove("formatter");
    if (formatter != null) {
        this.formatter = new TracingFormatterBuilder(formatter);
        this._visitables.get("formatter").add(this.formatter);
    } else {
        this.formatter = null;
        this._visitables.get("formatter").remove(this.formatter);
    }
    return (A) this;
  }
  
  public FormatterNested<A> withNewFormatter() {
    return new FormatterNested(null);
  }
  
  public A withNewFormatter(String value) {
    return (A) this.withFormatter(new TracingFormatter(value));
  }
  
  public FormatterNested<A> withNewFormatterLike(TracingFormatter item) {
    return new FormatterNested(item);
  }
  public class FormatterNested<N> extends TracingFormatterFluent<FormatterNested<N>> implements Nested<N>{
  
    TracingFormatterBuilder builder;
  
    FormatterNested(TracingFormatter item) {
      this.builder = new TracingFormatterBuilder(this, item);
    }
  
    public N and() {
      return (N) TracingCustomTagFormatterFluent.this.withFormatter(builder.build());
    }
    
    public N endFormatter() {
      return and();
    }
    
  }
}