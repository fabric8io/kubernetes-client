package io.fabric8.knative.bindings.v1;

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
public class KafkaNetSpecFluent<A extends io.fabric8.knative.bindings.v1.KafkaNetSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private KafkaSASLSpecBuilder sasl;
  private KafkaTLSSpecBuilder tls;

  public KafkaNetSpecFluent() {
  }
  
  public KafkaNetSpecFluent(KafkaNetSpec instance) {
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
  
  public KafkaSASLSpec buildSasl() {
    return this.sasl != null ? this.sasl.build() : null;
  }
  
  public KafkaTLSSpec buildTls() {
    return this.tls != null ? this.tls.build() : null;
  }
  
  protected void copyInstance(KafkaNetSpec instance) {
    instance = instance != null ? instance : new KafkaNetSpec();
    if (instance != null) {
        this.withSasl(instance.getSasl());
        this.withTls(instance.getTls());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SaslNested<A> editOrNewSasl() {
    return this.withNewSaslLike(Optional.ofNullable(this.buildSasl()).orElse(new KafkaSASLSpecBuilder().build()));
  }
  
  public SaslNested<A> editOrNewSaslLike(KafkaSASLSpec item) {
    return this.withNewSaslLike(Optional.ofNullable(this.buildSasl()).orElse(item));
  }
  
  public TlsNested<A> editOrNewTls() {
    return this.withNewTlsLike(Optional.ofNullable(this.buildTls()).orElse(new KafkaTLSSpecBuilder().build()));
  }
  
  public TlsNested<A> editOrNewTlsLike(KafkaTLSSpec item) {
    return this.withNewTlsLike(Optional.ofNullable(this.buildTls()).orElse(item));
  }
  
  public SaslNested<A> editSasl() {
    return this.withNewSaslLike(Optional.ofNullable(this.buildSasl()).orElse(null));
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
    KafkaNetSpecFluent that = (KafkaNetSpecFluent) o;
    if (!(Objects.equals(sasl, that.sasl))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasSasl() {
    return this.sasl != null;
  }
  
  public boolean hasTls() {
    return this.tls != null;
  }
  
  public int hashCode() {
    return Objects.hash(sasl, tls, additionalProperties);
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
    if (!(sasl == null)) {
        sb.append("sasl:");
        sb.append(sasl);
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
  
  public SaslNested<A> withNewSasl() {
    return new SaslNested(null);
  }
  
  public SaslNested<A> withNewSaslLike(KafkaSASLSpec item) {
    return new SaslNested(item);
  }
  
  public TlsNested<A> withNewTls() {
    return new TlsNested(null);
  }
  
  public TlsNested<A> withNewTlsLike(KafkaTLSSpec item) {
    return new TlsNested(item);
  }
  
  public A withSasl(KafkaSASLSpec sasl) {
    this._visitables.remove("sasl");
    if (sasl != null) {
        this.sasl = new KafkaSASLSpecBuilder(sasl);
        this._visitables.get("sasl").add(this.sasl);
    } else {
        this.sasl = null;
        this._visitables.get("sasl").remove(this.sasl);
    }
    return (A) this;
  }
  
  public A withTls(KafkaTLSSpec tls) {
    this._visitables.remove("tls");
    if (tls != null) {
        this.tls = new KafkaTLSSpecBuilder(tls);
        this._visitables.get("tls").add(this.tls);
    } else {
        this.tls = null;
        this._visitables.get("tls").remove(this.tls);
    }
    return (A) this;
  }
  public class SaslNested<N> extends KafkaSASLSpecFluent<SaslNested<N>> implements Nested<N>{
  
    KafkaSASLSpecBuilder builder;
  
    SaslNested(KafkaSASLSpec item) {
      this.builder = new KafkaSASLSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) KafkaNetSpecFluent.this.withSasl(builder.build());
    }
    
    public N endSasl() {
      return and();
    }
    
  }
  public class TlsNested<N> extends KafkaTLSSpecFluent<TlsNested<N>> implements Nested<N>{
  
    KafkaTLSSpecBuilder builder;
  
    TlsNested(KafkaTLSSpec item) {
      this.builder = new KafkaTLSSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) KafkaNetSpecFluent.this.withTls(builder.build());
    }
    
    public N endTls() {
      return and();
    }
    
  }
}