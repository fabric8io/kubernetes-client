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
public class TracingCustomTagEnvironmentFluent<A extends io.fabric8.istio.api.api.telemetry.v1alpha1.TracingCustomTagEnvironmentFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private TracingEnvironmentBuilder environment;

  public TracingCustomTagEnvironmentFluent() {
  }
  
  public TracingCustomTagEnvironmentFluent(TracingCustomTagEnvironment instance) {
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
  
  public TracingEnvironment buildEnvironment() {
    return this.environment != null ? this.environment.build() : null;
  }
  
  protected void copyInstance(TracingCustomTagEnvironment instance) {
    instance = instance != null ? instance : new TracingCustomTagEnvironment();
    if (instance != null) {
        this.withEnvironment(instance.getEnvironment());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public EnvironmentNested<A> editEnvironment() {
    return this.withNewEnvironmentLike(Optional.ofNullable(this.buildEnvironment()).orElse(null));
  }
  
  public EnvironmentNested<A> editOrNewEnvironment() {
    return this.withNewEnvironmentLike(Optional.ofNullable(this.buildEnvironment()).orElse(new TracingEnvironmentBuilder().build()));
  }
  
  public EnvironmentNested<A> editOrNewEnvironmentLike(TracingEnvironment item) {
    return this.withNewEnvironmentLike(Optional.ofNullable(this.buildEnvironment()).orElse(item));
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
    TracingCustomTagEnvironmentFluent that = (TracingCustomTagEnvironmentFluent) o;
    if (!(Objects.equals(environment, that.environment))) {
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
  
  public boolean hasEnvironment() {
    return this.environment != null;
  }
  
  public int hashCode() {
    return Objects.hash(environment, additionalProperties);
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
    if (!(environment == null)) {
        sb.append("environment:");
        sb.append(environment);
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
  
  public A withEnvironment(TracingEnvironment environment) {
    this._visitables.remove("environment");
    if (environment != null) {
        this.environment = new TracingEnvironmentBuilder(environment);
        this._visitables.get("environment").add(this.environment);
    } else {
        this.environment = null;
        this._visitables.get("environment").remove(this.environment);
    }
    return (A) this;
  }
  
  public EnvironmentNested<A> withNewEnvironment() {
    return new EnvironmentNested(null);
  }
  
  public A withNewEnvironment(String defaultValue,String name) {
    return (A) this.withEnvironment(new TracingEnvironment(defaultValue, name));
  }
  
  public EnvironmentNested<A> withNewEnvironmentLike(TracingEnvironment item) {
    return new EnvironmentNested(item);
  }
  public class EnvironmentNested<N> extends TracingEnvironmentFluent<EnvironmentNested<N>> implements Nested<N>{
  
    TracingEnvironmentBuilder builder;
  
    EnvironmentNested(TracingEnvironment item) {
      this.builder = new TracingEnvironmentBuilder(this, item);
    }
  
    public N and() {
      return (N) TracingCustomTagEnvironmentFluent.this.withEnvironment(builder.build());
    }
    
    public N endEnvironment() {
      return and();
    }
    
  }
}