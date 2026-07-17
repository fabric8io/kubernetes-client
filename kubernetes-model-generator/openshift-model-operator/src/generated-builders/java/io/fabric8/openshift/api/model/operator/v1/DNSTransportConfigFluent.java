package io.fabric8.openshift.api.model.operator.v1;

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
public class DNSTransportConfigFluent<A extends io.fabric8.openshift.api.model.operator.v1.DNSTransportConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private DNSOverTLSConfigBuilder tls;
  private String transport;

  public DNSTransportConfigFluent() {
  }
  
  public DNSTransportConfigFluent(DNSTransportConfig instance) {
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
  
  public DNSOverTLSConfig buildTls() {
    return this.tls != null ? this.tls.build() : null;
  }
  
  protected void copyInstance(DNSTransportConfig instance) {
    instance = instance != null ? instance : new DNSTransportConfig();
    if (instance != null) {
        this.withTls(instance.getTls());
        this.withTransport(instance.getTransport());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public TlsNested<A> editOrNewTls() {
    return this.withNewTlsLike(Optional.ofNullable(this.buildTls()).orElse(new DNSOverTLSConfigBuilder().build()));
  }
  
  public TlsNested<A> editOrNewTlsLike(DNSOverTLSConfig item) {
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
    DNSTransportConfigFluent that = (DNSTransportConfigFluent) o;
    if (!(Objects.equals(tls, that.tls))) {
      return false;
    }
    if (!(Objects.equals(transport, that.transport))) {
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
  
  public String getTransport() {
    return this.transport;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasTls() {
    return this.tls != null;
  }
  
  public boolean hasTransport() {
    return this.transport != null;
  }
  
  public int hashCode() {
    return Objects.hash(tls, transport, additionalProperties);
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
    if (!(tls == null)) {
        sb.append("tls:");
        sb.append(tls);
        sb.append(",");
    }
    if (!(transport == null)) {
        sb.append("transport:");
        sb.append(transport);
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
  
  public TlsNested<A> withNewTlsLike(DNSOverTLSConfig item) {
    return new TlsNested(item);
  }
  
  public A withTls(DNSOverTLSConfig tls) {
    this._visitables.remove("tls");
    if (tls != null) {
        this.tls = new DNSOverTLSConfigBuilder(tls);
        this._visitables.get("tls").add(this.tls);
    } else {
        this.tls = null;
        this._visitables.get("tls").remove(this.tls);
    }
    return (A) this;
  }
  
  public A withTransport(String transport) {
    this.transport = transport;
    return (A) this;
  }
  public class TlsNested<N> extends DNSOverTLSConfigFluent<TlsNested<N>> implements Nested<N>{
  
    DNSOverTLSConfigBuilder builder;
  
    TlsNested(DNSOverTLSConfig item) {
      this.builder = new DNSOverTLSConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) DNSTransportConfigFluent.this.withTls(builder.build());
    }
    
    public N endTls() {
      return and();
    }
    
  }
}