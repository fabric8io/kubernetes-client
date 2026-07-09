package io.fabric8.kubernetes.api.model.networking.v1beta1;

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
public class HTTPIngressPathFluent<A extends io.fabric8.kubernetes.api.model.networking.v1beta1.HTTPIngressPathFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private IngressBackendBuilder backend;
  private String path;
  private String pathType;

  public HTTPIngressPathFluent() {
  }
  
  public HTTPIngressPathFluent(HTTPIngressPath instance) {
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
  
  public IngressBackend buildBackend() {
    return this.backend != null ? this.backend.build() : null;
  }
  
  protected void copyInstance(HTTPIngressPath instance) {
    instance = instance != null ? instance : new HTTPIngressPath();
    if (instance != null) {
        this.withBackend(instance.getBackend());
        this.withPath(instance.getPath());
        this.withPathType(instance.getPathType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public BackendNested<A> editBackend() {
    return this.withNewBackendLike(Optional.ofNullable(this.buildBackend()).orElse(null));
  }
  
  public BackendNested<A> editOrNewBackend() {
    return this.withNewBackendLike(Optional.ofNullable(this.buildBackend()).orElse(new IngressBackendBuilder().build()));
  }
  
  public BackendNested<A> editOrNewBackendLike(IngressBackend item) {
    return this.withNewBackendLike(Optional.ofNullable(this.buildBackend()).orElse(item));
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
    HTTPIngressPathFluent that = (HTTPIngressPathFluent) o;
    if (!(Objects.equals(backend, that.backend))) {
      return false;
    }
    if (!(Objects.equals(path, that.path))) {
      return false;
    }
    if (!(Objects.equals(pathType, that.pathType))) {
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
  
  public String getPath() {
    return this.path;
  }
  
  public String getPathType() {
    return this.pathType;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBackend() {
    return this.backend != null;
  }
  
  public boolean hasPath() {
    return this.path != null;
  }
  
  public boolean hasPathType() {
    return this.pathType != null;
  }
  
  public int hashCode() {
    return Objects.hash(backend, path, pathType, additionalProperties);
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
    if (!(backend == null)) {
        sb.append("backend:");
        sb.append(backend);
        sb.append(",");
    }
    if (!(path == null)) {
        sb.append("path:");
        sb.append(path);
        sb.append(",");
    }
    if (!(pathType == null)) {
        sb.append("pathType:");
        sb.append(pathType);
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
  
  public A withBackend(IngressBackend backend) {
    this._visitables.remove("backend");
    if (backend != null) {
        this.backend = new IngressBackendBuilder(backend);
        this._visitables.get("backend").add(this.backend);
    } else {
        this.backend = null;
        this._visitables.get("backend").remove(this.backend);
    }
    return (A) this;
  }
  
  public BackendNested<A> withNewBackend() {
    return new BackendNested(null);
  }
  
  public BackendNested<A> withNewBackendLike(IngressBackend item) {
    return new BackendNested(item);
  }
  
  public A withPath(String path) {
    this.path = path;
    return (A) this;
  }
  
  public A withPathType(String pathType) {
    this.pathType = pathType;
    return (A) this;
  }
  public class BackendNested<N> extends IngressBackendFluent<BackendNested<N>> implements Nested<N>{
  
    IngressBackendBuilder builder;
  
    BackendNested(IngressBackend item) {
      this.builder = new IngressBackendBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPIngressPathFluent.this.withBackend(builder.build());
    }
    
    public N endBackend() {
      return and();
    }
    
  }
}