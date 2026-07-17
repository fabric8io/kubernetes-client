package io.fabric8.openshift.api.model.config.v1;

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
public class BasicAuthIdentityProviderFluent<A extends io.fabric8.openshift.api.model.config.v1.BasicAuthIdentityProviderFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ConfigMapNameReferenceBuilder ca;
  private SecretNameReferenceBuilder tlsClientCert;
  private SecretNameReferenceBuilder tlsClientKey;
  private String url;

  public BasicAuthIdentityProviderFluent() {
  }
  
  public BasicAuthIdentityProviderFluent(BasicAuthIdentityProvider instance) {
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
  
  public ConfigMapNameReference buildCa() {
    return this.ca != null ? this.ca.build() : null;
  }
  
  public SecretNameReference buildTlsClientCert() {
    return this.tlsClientCert != null ? this.tlsClientCert.build() : null;
  }
  
  public SecretNameReference buildTlsClientKey() {
    return this.tlsClientKey != null ? this.tlsClientKey.build() : null;
  }
  
  protected void copyInstance(BasicAuthIdentityProvider instance) {
    instance = instance != null ? instance : new BasicAuthIdentityProvider();
    if (instance != null) {
        this.withCa(instance.getCa());
        this.withTlsClientCert(instance.getTlsClientCert());
        this.withTlsClientKey(instance.getTlsClientKey());
        this.withUrl(instance.getUrl());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CaNested<A> editCa() {
    return this.withNewCaLike(Optional.ofNullable(this.buildCa()).orElse(null));
  }
  
  public CaNested<A> editOrNewCa() {
    return this.withNewCaLike(Optional.ofNullable(this.buildCa()).orElse(new ConfigMapNameReferenceBuilder().build()));
  }
  
  public CaNested<A> editOrNewCaLike(ConfigMapNameReference item) {
    return this.withNewCaLike(Optional.ofNullable(this.buildCa()).orElse(item));
  }
  
  public TlsClientCertNested<A> editOrNewTlsClientCert() {
    return this.withNewTlsClientCertLike(Optional.ofNullable(this.buildTlsClientCert()).orElse(new SecretNameReferenceBuilder().build()));
  }
  
  public TlsClientCertNested<A> editOrNewTlsClientCertLike(SecretNameReference item) {
    return this.withNewTlsClientCertLike(Optional.ofNullable(this.buildTlsClientCert()).orElse(item));
  }
  
  public TlsClientKeyNested<A> editOrNewTlsClientKey() {
    return this.withNewTlsClientKeyLike(Optional.ofNullable(this.buildTlsClientKey()).orElse(new SecretNameReferenceBuilder().build()));
  }
  
  public TlsClientKeyNested<A> editOrNewTlsClientKeyLike(SecretNameReference item) {
    return this.withNewTlsClientKeyLike(Optional.ofNullable(this.buildTlsClientKey()).orElse(item));
  }
  
  public TlsClientCertNested<A> editTlsClientCert() {
    return this.withNewTlsClientCertLike(Optional.ofNullable(this.buildTlsClientCert()).orElse(null));
  }
  
  public TlsClientKeyNested<A> editTlsClientKey() {
    return this.withNewTlsClientKeyLike(Optional.ofNullable(this.buildTlsClientKey()).orElse(null));
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
    BasicAuthIdentityProviderFluent that = (BasicAuthIdentityProviderFluent) o;
    if (!(Objects.equals(ca, that.ca))) {
      return false;
    }
    if (!(Objects.equals(tlsClientCert, that.tlsClientCert))) {
      return false;
    }
    if (!(Objects.equals(tlsClientKey, that.tlsClientKey))) {
      return false;
    }
    if (!(Objects.equals(url, that.url))) {
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
  
  public String getUrl() {
    return this.url;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCa() {
    return this.ca != null;
  }
  
  public boolean hasTlsClientCert() {
    return this.tlsClientCert != null;
  }
  
  public boolean hasTlsClientKey() {
    return this.tlsClientKey != null;
  }
  
  public boolean hasUrl() {
    return this.url != null;
  }
  
  public int hashCode() {
    return Objects.hash(ca, tlsClientCert, tlsClientKey, url, additionalProperties);
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
    if (!(ca == null)) {
        sb.append("ca:");
        sb.append(ca);
        sb.append(",");
    }
    if (!(tlsClientCert == null)) {
        sb.append("tlsClientCert:");
        sb.append(tlsClientCert);
        sb.append(",");
    }
    if (!(tlsClientKey == null)) {
        sb.append("tlsClientKey:");
        sb.append(tlsClientKey);
        sb.append(",");
    }
    if (!(url == null)) {
        sb.append("url:");
        sb.append(url);
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
  
  public A withCa(ConfigMapNameReference ca) {
    this._visitables.remove("ca");
    if (ca != null) {
        this.ca = new ConfigMapNameReferenceBuilder(ca);
        this._visitables.get("ca").add(this.ca);
    } else {
        this.ca = null;
        this._visitables.get("ca").remove(this.ca);
    }
    return (A) this;
  }
  
  public CaNested<A> withNewCa() {
    return new CaNested(null);
  }
  
  public A withNewCa(String name) {
    return (A) this.withCa(new ConfigMapNameReference(name));
  }
  
  public CaNested<A> withNewCaLike(ConfigMapNameReference item) {
    return new CaNested(item);
  }
  
  public TlsClientCertNested<A> withNewTlsClientCert() {
    return new TlsClientCertNested(null);
  }
  
  public A withNewTlsClientCert(String name) {
    return (A) this.withTlsClientCert(new SecretNameReference(name));
  }
  
  public TlsClientCertNested<A> withNewTlsClientCertLike(SecretNameReference item) {
    return new TlsClientCertNested(item);
  }
  
  public TlsClientKeyNested<A> withNewTlsClientKey() {
    return new TlsClientKeyNested(null);
  }
  
  public A withNewTlsClientKey(String name) {
    return (A) this.withTlsClientKey(new SecretNameReference(name));
  }
  
  public TlsClientKeyNested<A> withNewTlsClientKeyLike(SecretNameReference item) {
    return new TlsClientKeyNested(item);
  }
  
  public A withTlsClientCert(SecretNameReference tlsClientCert) {
    this._visitables.remove("tlsClientCert");
    if (tlsClientCert != null) {
        this.tlsClientCert = new SecretNameReferenceBuilder(tlsClientCert);
        this._visitables.get("tlsClientCert").add(this.tlsClientCert);
    } else {
        this.tlsClientCert = null;
        this._visitables.get("tlsClientCert").remove(this.tlsClientCert);
    }
    return (A) this;
  }
  
  public A withTlsClientKey(SecretNameReference tlsClientKey) {
    this._visitables.remove("tlsClientKey");
    if (tlsClientKey != null) {
        this.tlsClientKey = new SecretNameReferenceBuilder(tlsClientKey);
        this._visitables.get("tlsClientKey").add(this.tlsClientKey);
    } else {
        this.tlsClientKey = null;
        this._visitables.get("tlsClientKey").remove(this.tlsClientKey);
    }
    return (A) this;
  }
  
  public A withUrl(String url) {
    this.url = url;
    return (A) this;
  }
  public class CaNested<N> extends ConfigMapNameReferenceFluent<CaNested<N>> implements Nested<N>{
  
    ConfigMapNameReferenceBuilder builder;
  
    CaNested(ConfigMapNameReference item) {
      this.builder = new ConfigMapNameReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) BasicAuthIdentityProviderFluent.this.withCa(builder.build());
    }
    
    public N endCa() {
      return and();
    }
    
  }
  public class TlsClientCertNested<N> extends SecretNameReferenceFluent<TlsClientCertNested<N>> implements Nested<N>{
  
    SecretNameReferenceBuilder builder;
  
    TlsClientCertNested(SecretNameReference item) {
      this.builder = new SecretNameReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) BasicAuthIdentityProviderFluent.this.withTlsClientCert(builder.build());
    }
    
    public N endTlsClientCert() {
      return and();
    }
    
  }
  public class TlsClientKeyNested<N> extends SecretNameReferenceFluent<TlsClientKeyNested<N>> implements Nested<N>{
  
    SecretNameReferenceBuilder builder;
  
    TlsClientKeyNested(SecretNameReference item) {
      this.builder = new SecretNameReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) BasicAuthIdentityProviderFluent.this.withTlsClientKey(builder.build());
    }
    
    public N endTlsClientKey() {
      return and();
    }
    
  }
}