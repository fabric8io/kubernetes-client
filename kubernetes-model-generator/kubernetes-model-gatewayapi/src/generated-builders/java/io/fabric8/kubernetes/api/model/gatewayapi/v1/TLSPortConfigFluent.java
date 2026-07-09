package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
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
public class TLSPortConfigFluent<A extends io.fabric8.kubernetes.api.model.gatewayapi.v1.TLSPortConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer port;
  private TLSConfigBuilder tls;

  public TLSPortConfigFluent() {
  }
  
  public TLSPortConfigFluent(TLSPortConfig instance) {
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
  
  public TLSConfig buildTls() {
    return this.tls != null ? this.tls.build() : null;
  }
  
  protected void copyInstance(TLSPortConfig instance) {
    instance = instance != null ? instance : new TLSPortConfig();
    if (instance != null) {
        this.withPort(instance.getPort());
        this.withTls(instance.getTls());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public TlsNested<A> editOrNewTls() {
    return this.withNewTlsLike(Optional.ofNullable(this.buildTls()).orElse(new TLSConfigBuilder().build()));
  }
  
  public TlsNested<A> editOrNewTlsLike(TLSConfig item) {
    return this.withNewTlsLike(Optional.ofNullable(this.buildTls()).orElse(item));
  }
  
  public TlsNested<A> editTls() {
    return this.withNewTlsLike(Optional.ofNullable(this.buildTls()).orElse(null));
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
    TLSPortConfigFluent that = (TLSPortConfigFluent) o;
    if (!(Objects.equals(port, that.port))) {
      return false;
    }
    if (!(Objects.equals(tls, that.tls))) {
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
  
  public Integer getPort() {
    return this.port;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasPort() {
    return this.port != null;
  }
  
  public boolean hasTls() {
    return this.tls != null;
  }
  
  public int hashCode() {
    return Objects.hash(port, tls, additionalProperties);
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
    if (!(port == null)) {
        sb.append("port:");
        sb.append(port);
        sb.append(",");
    }
    if (!(tls == null)) {
        sb.append("tls:");
        sb.append(tls);
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
  
  public TlsNested<A> withNewTls() {
    return new TlsNested(null);
  }
  
  public TlsNested<A> withNewTlsLike(TLSConfig item) {
    return new TlsNested(item);
  }
  
  public A withPort(Integer port) {
    this.port = port;
    return (A) this;
  }
  
  public A withTls(TLSConfig tls) {
    this._visitables.remove("tls");
    if (tls != null) {
        this.tls = new TLSConfigBuilder(tls);
        this._visitables.get("tls").add(this.tls);
    } else {
        this.tls = null;
        this._visitables.get("tls").remove(this.tls);
    }
    return (A) this;
  }
  public class TlsNested<N> extends TLSConfigFluent<TlsNested<N>> implements Nested<N>{
  
    TLSConfigBuilder builder;
  
    TlsNested(TLSConfig item) {
      this.builder = new TLSConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) TLSPortConfigFluent.this.withTls(builder.build());
    }
    
    public N endTls() {
      return and();
    }
    
  }
}