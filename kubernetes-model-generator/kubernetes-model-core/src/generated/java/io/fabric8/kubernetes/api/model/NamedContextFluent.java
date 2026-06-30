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
public class NamedContextFluent<A extends io.fabric8.kubernetes.api.model.NamedContextFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ContextBuilder context;
  private String name;

  public NamedContextFluent() {
  }
  
  public NamedContextFluent(NamedContext instance) {
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
  
  public Context buildContext() {
    return this.context != null ? this.context.build() : null;
  }
  
  protected void copyInstance(NamedContext instance) {
    instance = instance != null ? instance : new NamedContext();
    if (instance != null) {
        this.withContext(instance.getContext());
        this.withName(instance.getName());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ContextNested<A> editContext() {
    return this.withNewContextLike(Optional.ofNullable(this.buildContext()).orElse(null));
  }
  
  public ContextNested<A> editOrNewContext() {
    return this.withNewContextLike(Optional.ofNullable(this.buildContext()).orElse(new ContextBuilder().build()));
  }
  
  public ContextNested<A> editOrNewContextLike(Context item) {
    return this.withNewContextLike(Optional.ofNullable(this.buildContext()).orElse(item));
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
    NamedContextFluent that = (NamedContextFluent) o;
    if (!(Objects.equals(context, that.context))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
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
  
  public String getName() {
    return this.name;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasContext() {
    return this.context != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public int hashCode() {
    return Objects.hash(context, name, additionalProperties);
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
    if (!(context == null)) {
        sb.append("context:");
        sb.append(context);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
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
  
  public A withContext(Context context) {
    this._visitables.remove("context");
    if (context != null) {
        this.context = new ContextBuilder(context);
        this._visitables.get("context").add(this.context);
    } else {
        this.context = null;
        this._visitables.get("context").remove(this.context);
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public ContextNested<A> withNewContext() {
    return new ContextNested(null);
  }
  
  public ContextNested<A> withNewContextLike(Context item) {
    return new ContextNested(item);
  }
  public class ContextNested<N> extends ContextFluent<ContextNested<N>> implements Nested<N>{
  
    ContextBuilder builder;
  
    ContextNested(Context item) {
      this.builder = new ContextBuilder(this, item);
    }
  
    public N and() {
      return (N) NamedContextFluent.this.withContext(builder.build());
    }
    
    public N endContext() {
      return and();
    }
    
  }
}