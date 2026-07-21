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
public class CertificateKeystoresFluent<A extends io.fabric8.certmanager.api.model.v1.CertificateKeystoresFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private JKSKeystoreBuilder jks;
  private PKCS12KeystoreBuilder pkcs12;

  public CertificateKeystoresFluent() {
  }
  
  public CertificateKeystoresFluent(CertificateKeystores instance) {
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
  
  public JKSKeystore buildJks() {
    return this.jks != null ? this.jks.build() : null;
  }
  
  public PKCS12Keystore buildPkcs12() {
    return this.pkcs12 != null ? this.pkcs12.build() : null;
  }
  
  protected void copyInstance(CertificateKeystores instance) {
    instance = instance != null ? instance : new CertificateKeystores();
    if (instance != null) {
        this.withJks(instance.getJks());
        this.withPkcs12(instance.getPkcs12());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public JksNested<A> editJks() {
    return this.withNewJksLike(Optional.ofNullable(this.buildJks()).orElse(null));
  }
  
  public JksNested<A> editOrNewJks() {
    return this.withNewJksLike(Optional.ofNullable(this.buildJks()).orElse(new JKSKeystoreBuilder().build()));
  }
  
  public JksNested<A> editOrNewJksLike(JKSKeystore item) {
    return this.withNewJksLike(Optional.ofNullable(this.buildJks()).orElse(item));
  }
  
  public Pkcs12Nested<A> editOrNewPkcs12() {
    return this.withNewPkcs12Like(Optional.ofNullable(this.buildPkcs12()).orElse(new PKCS12KeystoreBuilder().build()));
  }
  
  public Pkcs12Nested<A> editOrNewPkcs12Like(PKCS12Keystore item) {
    return this.withNewPkcs12Like(Optional.ofNullable(this.buildPkcs12()).orElse(item));
  }
  
  public Pkcs12Nested<A> editPkcs12() {
    return this.withNewPkcs12Like(Optional.ofNullable(this.buildPkcs12()).orElse(null));
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
    CertificateKeystoresFluent that = (CertificateKeystoresFluent) o;
    if (!(Objects.equals(jks, that.jks))) {
      return false;
    }
    if (!(Objects.equals(pkcs12, that.pkcs12))) {
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
  
  public boolean hasJks() {
    return this.jks != null;
  }
  
  public boolean hasPkcs12() {
    return this.pkcs12 != null;
  }
  
  public int hashCode() {
    return Objects.hash(jks, pkcs12, additionalProperties);
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
    if (!(jks == null)) {
        sb.append("jks:");
        sb.append(jks);
        sb.append(",");
    }
    if (!(pkcs12 == null)) {
        sb.append("pkcs12:");
        sb.append(pkcs12);
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
  
  public A withJks(JKSKeystore jks) {
    this._visitables.remove("jks");
    if (jks != null) {
        this.jks = new JKSKeystoreBuilder(jks);
        this._visitables.get("jks").add(this.jks);
    } else {
        this.jks = null;
        this._visitables.get("jks").remove(this.jks);
    }
    return (A) this;
  }
  
  public JksNested<A> withNewJks() {
    return new JksNested(null);
  }
  
  public JksNested<A> withNewJksLike(JKSKeystore item) {
    return new JksNested(item);
  }
  
  public Pkcs12Nested<A> withNewPkcs12() {
    return new Pkcs12Nested(null);
  }
  
  public Pkcs12Nested<A> withNewPkcs12Like(PKCS12Keystore item) {
    return new Pkcs12Nested(item);
  }
  
  public A withPkcs12(PKCS12Keystore pkcs12) {
    this._visitables.remove("pkcs12");
    if (pkcs12 != null) {
        this.pkcs12 = new PKCS12KeystoreBuilder(pkcs12);
        this._visitables.get("pkcs12").add(this.pkcs12);
    } else {
        this.pkcs12 = null;
        this._visitables.get("pkcs12").remove(this.pkcs12);
    }
    return (A) this;
  }
  public class JksNested<N> extends JKSKeystoreFluent<JksNested<N>> implements Nested<N>{
  
    JKSKeystoreBuilder builder;
  
    JksNested(JKSKeystore item) {
      this.builder = new JKSKeystoreBuilder(this, item);
    }
  
    public N and() {
      return (N) CertificateKeystoresFluent.this.withJks(builder.build());
    }
    
    public N endJks() {
      return and();
    }
    
  }
  public class Pkcs12Nested<N> extends PKCS12KeystoreFluent<Pkcs12Nested<N>> implements Nested<N>{
  
    PKCS12KeystoreBuilder builder;
  
    Pkcs12Nested(PKCS12Keystore item) {
      this.builder = new PKCS12KeystoreBuilder(this, item);
    }
  
    public N and() {
      return (N) CertificateKeystoresFluent.this.withPkcs12(builder.build());
    }
    
    public N endPkcs12() {
      return and();
    }
    
  }
}