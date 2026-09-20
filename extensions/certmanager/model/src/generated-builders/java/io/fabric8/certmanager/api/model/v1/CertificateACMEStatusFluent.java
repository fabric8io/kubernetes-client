package io.fabric8.certmanager.api.model.v1;

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
public class CertificateACMEStatusFluent<A extends io.fabric8.certmanager.api.model.v1.CertificateACMEStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private CertificateACMEARIStatusBuilder ari;

  public CertificateACMEStatusFluent() {
  }
  
  public CertificateACMEStatusFluent(CertificateACMEStatus instance) {
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
  
  public CertificateACMEARIStatus buildAri() {
    return this.ari != null ? this.ari.build() : null;
  }
  
  protected void copyInstance(CertificateACMEStatus instance) {
    instance = instance != null ? instance : new CertificateACMEStatus();
    if (instance != null) {
        this.withAri(instance.getAri());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AriNested<A> editAri() {
    return this.withNewAriLike(Optional.ofNullable(this.buildAri()).orElse(null));
  }
  
  public AriNested<A> editOrNewAri() {
    return this.withNewAriLike(Optional.ofNullable(this.buildAri()).orElse(new CertificateACMEARIStatusBuilder().build()));
  }
  
  public AriNested<A> editOrNewAriLike(CertificateACMEARIStatus item) {
    return this.withNewAriLike(Optional.ofNullable(this.buildAri()).orElse(item));
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
    CertificateACMEStatusFluent that = (CertificateACMEStatusFluent) o;
    if (!(Objects.equals(ari, that.ari))) {
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
  
  public boolean hasAri() {
    return this.ari != null;
  }
  
  public int hashCode() {
    return Objects.hash(ari, additionalProperties);
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
    if (!(ari == null)) {
        sb.append("ari:");
        sb.append(ari);
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
  
  public A withAri(CertificateACMEARIStatus ari) {
    this._visitables.remove("ari");
    if (ari != null) {
        this.ari = new CertificateACMEARIStatusBuilder(ari);
        this._visitables.get("ari").add(this.ari);
    } else {
        this.ari = null;
        this._visitables.get("ari").remove(this.ari);
    }
    return (A) this;
  }
  
  public AriNested<A> withNewAri() {
    return new AriNested(null);
  }
  
  public AriNested<A> withNewAriLike(CertificateACMEARIStatus item) {
    return new AriNested(item);
  }
  public class AriNested<N> extends CertificateACMEARIStatusFluent<AriNested<N>> implements Nested<N>{
  
    CertificateACMEARIStatusBuilder builder;
  
    AriNested(CertificateACMEARIStatus item) {
      this.builder = new CertificateACMEARIStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) CertificateACMEStatusFluent.this.withAri(builder.build());
    }
    
    public N endAri() {
      return and();
    }
    
  }
}