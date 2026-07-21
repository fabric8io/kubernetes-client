package io.fabric8.tekton.triggers.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
import java.lang.Long;
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
public class InterceptorResponseFluent<A extends io.fabric8.tekton.triggers.v1alpha1.InterceptorResponseFluent<A>> extends BaseFluent<A>{

  private Boolean _continue;
  private Map<String,Object> additionalProperties;
  private Map<String,Object> extensions;
  private StatusBuilder status;

  public InterceptorResponseFluent() {
  }
  
  public InterceptorResponseFluent(InterceptorResponse instance) {
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
  
  public A addToExtensions(Map<String,Object> map) {
    if (this.extensions == null && map != null) {
      this.extensions = new LinkedHashMap();
    }
    if (map != null) {
      this.extensions.putAll(map);
    }
    return (A) this;
  }
  
  public A addToExtensions(String key,Object value) {
    if (this.extensions == null && key != null && value != null) {
      this.extensions = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.extensions.put(key, value);
    }
    return (A) this;
  }
  
  public Status buildStatus() {
    return this.status != null ? this.status.build() : null;
  }
  
  protected void copyInstance(InterceptorResponse instance) {
    instance = instance != null ? instance : new InterceptorResponse();
    if (instance != null) {
        this.withContinue(instance.getContinue());
        this.withExtensions(instance.getExtensions());
        this.withStatus(instance.getStatus());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public StatusNested<A> editOrNewStatus() {
    return this.withNewStatusLike(Optional.ofNullable(this.buildStatus()).orElse(new StatusBuilder().build()));
  }
  
  public StatusNested<A> editOrNewStatusLike(Status item) {
    return this.withNewStatusLike(Optional.ofNullable(this.buildStatus()).orElse(item));
  }
  
  public StatusNested<A> editStatus() {
    return this.withNewStatusLike(Optional.ofNullable(this.buildStatus()).orElse(null));
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
    InterceptorResponseFluent that = (InterceptorResponseFluent) o;
    if (!(Objects.equals(_continue, that._continue))) {
      return false;
    }
    if (!(Objects.equals(extensions, that.extensions))) {
      return false;
    }
    if (!(Objects.equals(status, that.status))) {
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
  
  public Boolean getContinue() {
    return this._continue;
  }
  
  public Map<String,Object> getExtensions() {
    return this.extensions;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasContinue() {
    return this._continue != null;
  }
  
  public boolean hasExtensions() {
    return this.extensions != null;
  }
  
  public boolean hasStatus() {
    return this.status != null;
  }
  
  public int hashCode() {
    return Objects.hash(_continue, extensions, status, additionalProperties);
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
  
  public A removeFromExtensions(String key) {
    if (this.extensions == null) {
      return (A) this;
    }
    if (key != null && this.extensions != null) {
      this.extensions.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromExtensions(Map<String,Object> map) {
    if (this.extensions == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.extensions != null) {
          this.extensions.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(_continue == null)) {
        sb.append("_continue:");
        sb.append(_continue);
        sb.append(",");
    }
    if (!(extensions == null) && !(extensions.isEmpty())) {
        sb.append("extensions:");
        sb.append(extensions);
        sb.append(",");
    }
    if (!(status == null)) {
        sb.append("status:");
        sb.append(status);
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
  
  public A withContinue() {
    return withContinue(true);
  }
  
  public A withContinue(Boolean _continue) {
    this._continue = _continue;
    return (A) this;
  }
  
  public <K,V>A withExtensions(Map<String,Object> extensions) {
    if (extensions == null) {
      this.extensions = null;
    } else {
      this.extensions = new LinkedHashMap(extensions);
    }
    return (A) this;
  }
  
  public StatusNested<A> withNewStatus() {
    return new StatusNested(null);
  }
  
  public A withNewStatus(Long code,String message) {
    return (A) this.withStatus(new Status(code, message));
  }
  
  public StatusNested<A> withNewStatusLike(Status item) {
    return new StatusNested(item);
  }
  
  public A withStatus(Status status) {
    this._visitables.remove("status");
    if (status != null) {
        this.status = new StatusBuilder(status);
        this._visitables.get("status").add(this.status);
    } else {
        this.status = null;
        this._visitables.get("status").remove(this.status);
    }
    return (A) this;
  }
  public class StatusNested<N> extends StatusFluent<StatusNested<N>> implements Nested<N>{
  
    StatusBuilder builder;
  
    StatusNested(Status item) {
      this.builder = new StatusBuilder(this, item);
    }
  
    public N and() {
      return (N) InterceptorResponseFluent.this.withStatus(builder.build());
    }
    
    public N endStatus() {
      return and();
    }
    
  }
}