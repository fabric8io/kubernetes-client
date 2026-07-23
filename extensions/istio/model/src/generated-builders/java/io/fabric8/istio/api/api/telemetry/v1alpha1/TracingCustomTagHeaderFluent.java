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
public class TracingCustomTagHeaderFluent<A extends io.fabric8.istio.api.api.telemetry.v1alpha1.TracingCustomTagHeaderFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private TracingRequestHeaderBuilder header;

  public TracingCustomTagHeaderFluent() {
  }
  
  public TracingCustomTagHeaderFluent(TracingCustomTagHeader instance) {
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
  
  public TracingRequestHeader buildHeader() {
    return this.header != null ? this.header.build() : null;
  }
  
  protected void copyInstance(TracingCustomTagHeader instance) {
    instance = instance != null ? instance : new TracingCustomTagHeader();
    if (instance != null) {
        this.withHeader(instance.getHeader());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public HeaderNested<A> editHeader() {
    return this.withNewHeaderLike(Optional.ofNullable(this.buildHeader()).orElse(null));
  }
  
  public HeaderNested<A> editOrNewHeader() {
    return this.withNewHeaderLike(Optional.ofNullable(this.buildHeader()).orElse(new TracingRequestHeaderBuilder().build()));
  }
  
  public HeaderNested<A> editOrNewHeaderLike(TracingRequestHeader item) {
    return this.withNewHeaderLike(Optional.ofNullable(this.buildHeader()).orElse(item));
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
    TracingCustomTagHeaderFluent that = (TracingCustomTagHeaderFluent) o;
    if (!(Objects.equals(header, that.header))) {
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
  
  public boolean hasHeader() {
    return this.header != null;
  }
  
  public int hashCode() {
    return Objects.hash(header, additionalProperties);
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
    if (!(header == null)) {
        sb.append("header:");
        sb.append(header);
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
  
  public A withHeader(TracingRequestHeader header) {
    this._visitables.remove("header");
    if (header != null) {
        this.header = new TracingRequestHeaderBuilder(header);
        this._visitables.get("header").add(this.header);
    } else {
        this.header = null;
        this._visitables.get("header").remove(this.header);
    }
    return (A) this;
  }
  
  public HeaderNested<A> withNewHeader() {
    return new HeaderNested(null);
  }
  
  public A withNewHeader(String defaultValue,String name) {
    return (A) this.withHeader(new TracingRequestHeader(defaultValue, name));
  }
  
  public HeaderNested<A> withNewHeaderLike(TracingRequestHeader item) {
    return new HeaderNested(item);
  }
  public class HeaderNested<N> extends TracingRequestHeaderFluent<HeaderNested<N>> implements Nested<N>{
  
    TracingRequestHeaderBuilder builder;
  
    HeaderNested(TracingRequestHeader item) {
      this.builder = new TracingRequestHeaderBuilder(this, item);
    }
  
    public N and() {
      return (N) TracingCustomTagHeaderFluent.this.withHeader(builder.build());
    }
    
    public N endHeader() {
      return and();
    }
    
  }
}