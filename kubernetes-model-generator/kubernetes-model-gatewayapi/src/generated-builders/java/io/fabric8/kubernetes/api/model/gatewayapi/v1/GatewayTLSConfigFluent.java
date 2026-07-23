package io.fabric8.kubernetes.api.model.gatewayapi.v1;

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
public class GatewayTLSConfigFluent<A extends io.fabric8.kubernetes.api.model.gatewayapi.v1.GatewayTLSConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private GatewayBackendTLSBuilder backend;
  private FrontendTLSConfigBuilder frontend;

  public GatewayTLSConfigFluent() {
  }
  
  public GatewayTLSConfigFluent(GatewayTLSConfig instance) {
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
  
  public GatewayBackendTLS buildBackend() {
    return this.backend != null ? this.backend.build() : null;
  }
  
  public FrontendTLSConfig buildFrontend() {
    return this.frontend != null ? this.frontend.build() : null;
  }
  
  protected void copyInstance(GatewayTLSConfig instance) {
    instance = instance != null ? instance : new GatewayTLSConfig();
    if (instance != null) {
        this.withBackend(instance.getBackend());
        this.withFrontend(instance.getFrontend());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public BackendNested<A> editBackend() {
    return this.withNewBackendLike(Optional.ofNullable(this.buildBackend()).orElse(null));
  }
  
  public FrontendNested<A> editFrontend() {
    return this.withNewFrontendLike(Optional.ofNullable(this.buildFrontend()).orElse(null));
  }
  
  public BackendNested<A> editOrNewBackend() {
    return this.withNewBackendLike(Optional.ofNullable(this.buildBackend()).orElse(new GatewayBackendTLSBuilder().build()));
  }
  
  public BackendNested<A> editOrNewBackendLike(GatewayBackendTLS item) {
    return this.withNewBackendLike(Optional.ofNullable(this.buildBackend()).orElse(item));
  }
  
  public FrontendNested<A> editOrNewFrontend() {
    return this.withNewFrontendLike(Optional.ofNullable(this.buildFrontend()).orElse(new FrontendTLSConfigBuilder().build()));
  }
  
  public FrontendNested<A> editOrNewFrontendLike(FrontendTLSConfig item) {
    return this.withNewFrontendLike(Optional.ofNullable(this.buildFrontend()).orElse(item));
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
    GatewayTLSConfigFluent that = (GatewayTLSConfigFluent) o;
    if (!(Objects.equals(backend, that.backend))) {
      return false;
    }
    if (!(Objects.equals(frontend, that.frontend))) {
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
  
  public boolean hasBackend() {
    return this.backend != null;
  }
  
  public boolean hasFrontend() {
    return this.frontend != null;
  }
  
  public int hashCode() {
    return Objects.hash(backend, frontend, additionalProperties);
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
    if (!(frontend == null)) {
        sb.append("frontend:");
        sb.append(frontend);
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
  
  public A withBackend(GatewayBackendTLS backend) {
    this._visitables.remove("backend");
    if (backend != null) {
        this.backend = new GatewayBackendTLSBuilder(backend);
        this._visitables.get("backend").add(this.backend);
    } else {
        this.backend = null;
        this._visitables.get("backend").remove(this.backend);
    }
    return (A) this;
  }
  
  public A withFrontend(FrontendTLSConfig frontend) {
    this._visitables.remove("frontend");
    if (frontend != null) {
        this.frontend = new FrontendTLSConfigBuilder(frontend);
        this._visitables.get("frontend").add(this.frontend);
    } else {
        this.frontend = null;
        this._visitables.get("frontend").remove(this.frontend);
    }
    return (A) this;
  }
  
  public BackendNested<A> withNewBackend() {
    return new BackendNested(null);
  }
  
  public BackendNested<A> withNewBackendLike(GatewayBackendTLS item) {
    return new BackendNested(item);
  }
  
  public FrontendNested<A> withNewFrontend() {
    return new FrontendNested(null);
  }
  
  public FrontendNested<A> withNewFrontendLike(FrontendTLSConfig item) {
    return new FrontendNested(item);
  }
  public class BackendNested<N> extends GatewayBackendTLSFluent<BackendNested<N>> implements Nested<N>{
  
    GatewayBackendTLSBuilder builder;
  
    BackendNested(GatewayBackendTLS item) {
      this.builder = new GatewayBackendTLSBuilder(this, item);
    }
  
    public N and() {
      return (N) GatewayTLSConfigFluent.this.withBackend(builder.build());
    }
    
    public N endBackend() {
      return and();
    }
    
  }
  public class FrontendNested<N> extends FrontendTLSConfigFluent<FrontendNested<N>> implements Nested<N>{
  
    FrontendTLSConfigBuilder builder;
  
    FrontendNested(FrontendTLSConfig item) {
      this.builder = new FrontendTLSConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) GatewayTLSConfigFluent.this.withFrontend(builder.build());
    }
    
    public N endFrontend() {
      return and();
    }
    
  }
}