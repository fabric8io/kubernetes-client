package io.fabric8.knative.bindings.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
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
public class KafkaTLSSpecFluent<A extends io.fabric8.knative.bindings.v1beta1.KafkaTLSSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private SecretValueFromSourceBuilder caCert;
  private SecretValueFromSourceBuilder cert;
  private Boolean enable;
  private SecretValueFromSourceBuilder key;

  public KafkaTLSSpecFluent() {
  }
  
  public KafkaTLSSpecFluent(KafkaTLSSpec instance) {
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
  
  public SecretValueFromSource buildCaCert() {
    return this.caCert != null ? this.caCert.build() : null;
  }
  
  public SecretValueFromSource buildCert() {
    return this.cert != null ? this.cert.build() : null;
  }
  
  public SecretValueFromSource buildKey() {
    return this.key != null ? this.key.build() : null;
  }
  
  protected void copyInstance(KafkaTLSSpec instance) {
    instance = instance != null ? instance : new KafkaTLSSpec();
    if (instance != null) {
        this.withCaCert(instance.getCaCert());
        this.withCert(instance.getCert());
        this.withEnable(instance.getEnable());
        this.withKey(instance.getKey());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CaCertNested<A> editCaCert() {
    return this.withNewCaCertLike(Optional.ofNullable(this.buildCaCert()).orElse(null));
  }
  
  public CertNested<A> editCert() {
    return this.withNewCertLike(Optional.ofNullable(this.buildCert()).orElse(null));
  }
  
  public KeyNested<A> editKey() {
    return this.withNewKeyLike(Optional.ofNullable(this.buildKey()).orElse(null));
  }
  
  public CaCertNested<A> editOrNewCaCert() {
    return this.withNewCaCertLike(Optional.ofNullable(this.buildCaCert()).orElse(new SecretValueFromSourceBuilder().build()));
  }
  
  public CaCertNested<A> editOrNewCaCertLike(SecretValueFromSource item) {
    return this.withNewCaCertLike(Optional.ofNullable(this.buildCaCert()).orElse(item));
  }
  
  public CertNested<A> editOrNewCert() {
    return this.withNewCertLike(Optional.ofNullable(this.buildCert()).orElse(new SecretValueFromSourceBuilder().build()));
  }
  
  public CertNested<A> editOrNewCertLike(SecretValueFromSource item) {
    return this.withNewCertLike(Optional.ofNullable(this.buildCert()).orElse(item));
  }
  
  public KeyNested<A> editOrNewKey() {
    return this.withNewKeyLike(Optional.ofNullable(this.buildKey()).orElse(new SecretValueFromSourceBuilder().build()));
  }
  
  public KeyNested<A> editOrNewKeyLike(SecretValueFromSource item) {
    return this.withNewKeyLike(Optional.ofNullable(this.buildKey()).orElse(item));
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
    KafkaTLSSpecFluent that = (KafkaTLSSpecFluent) o;
    if (!(Objects.equals(caCert, that.caCert))) {
      return false;
    }
    if (!(Objects.equals(cert, that.cert))) {
      return false;
    }
    if (!(Objects.equals(enable, that.enable))) {
      return false;
    }
    if (!(Objects.equals(key, that.key))) {
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
  
  public Boolean getEnable() {
    return this.enable;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCaCert() {
    return this.caCert != null;
  }
  
  public boolean hasCert() {
    return this.cert != null;
  }
  
  public boolean hasEnable() {
    return this.enable != null;
  }
  
  public boolean hasKey() {
    return this.key != null;
  }
  
  public int hashCode() {
    return Objects.hash(caCert, cert, enable, key, additionalProperties);
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
    if (!(caCert == null)) {
        sb.append("caCert:");
        sb.append(caCert);
        sb.append(",");
    }
    if (!(cert == null)) {
        sb.append("cert:");
        sb.append(cert);
        sb.append(",");
    }
    if (!(enable == null)) {
        sb.append("enable:");
        sb.append(enable);
        sb.append(",");
    }
    if (!(key == null)) {
        sb.append("key:");
        sb.append(key);
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
  
  public A withCaCert(SecretValueFromSource caCert) {
    this._visitables.remove("caCert");
    if (caCert != null) {
        this.caCert = new SecretValueFromSourceBuilder(caCert);
        this._visitables.get("caCert").add(this.caCert);
    } else {
        this.caCert = null;
        this._visitables.get("caCert").remove(this.caCert);
    }
    return (A) this;
  }
  
  public A withCert(SecretValueFromSource cert) {
    this._visitables.remove("cert");
    if (cert != null) {
        this.cert = new SecretValueFromSourceBuilder(cert);
        this._visitables.get("cert").add(this.cert);
    } else {
        this.cert = null;
        this._visitables.get("cert").remove(this.cert);
    }
    return (A) this;
  }
  
  public A withEnable() {
    return withEnable(true);
  }
  
  public A withEnable(Boolean enable) {
    this.enable = enable;
    return (A) this;
  }
  
  public A withKey(SecretValueFromSource key) {
    this._visitables.remove("key");
    if (key != null) {
        this.key = new SecretValueFromSourceBuilder(key);
        this._visitables.get("key").add(this.key);
    } else {
        this.key = null;
        this._visitables.get("key").remove(this.key);
    }
    return (A) this;
  }
  
  public CaCertNested<A> withNewCaCert() {
    return new CaCertNested(null);
  }
  
  public CaCertNested<A> withNewCaCertLike(SecretValueFromSource item) {
    return new CaCertNested(item);
  }
  
  public CertNested<A> withNewCert() {
    return new CertNested(null);
  }
  
  public CertNested<A> withNewCertLike(SecretValueFromSource item) {
    return new CertNested(item);
  }
  
  public KeyNested<A> withNewKey() {
    return new KeyNested(null);
  }
  
  public KeyNested<A> withNewKeyLike(SecretValueFromSource item) {
    return new KeyNested(item);
  }
  public class CaCertNested<N> extends SecretValueFromSourceFluent<CaCertNested<N>> implements Nested<N>{
  
    SecretValueFromSourceBuilder builder;
  
    CaCertNested(SecretValueFromSource item) {
      this.builder = new SecretValueFromSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) KafkaTLSSpecFluent.this.withCaCert(builder.build());
    }
    
    public N endCaCert() {
      return and();
    }
    
  }
  public class CertNested<N> extends SecretValueFromSourceFluent<CertNested<N>> implements Nested<N>{
  
    SecretValueFromSourceBuilder builder;
  
    CertNested(SecretValueFromSource item) {
      this.builder = new SecretValueFromSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) KafkaTLSSpecFluent.this.withCert(builder.build());
    }
    
    public N endCert() {
      return and();
    }
    
  }
  public class KeyNested<N> extends SecretValueFromSourceFluent<KeyNested<N>> implements Nested<N>{
  
    SecretValueFromSourceBuilder builder;
  
    KeyNested(SecretValueFromSource item) {
      this.builder = new SecretValueFromSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) KafkaTLSSpecFluent.this.withKey(builder.build());
    }
    
    public N endKey() {
      return and();
    }
    
  }
}