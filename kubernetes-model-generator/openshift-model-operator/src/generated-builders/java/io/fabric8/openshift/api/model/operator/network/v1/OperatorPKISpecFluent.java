package io.fabric8.openshift.api.model.operator.network.v1;

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
public class OperatorPKISpecFluent<A extends io.fabric8.openshift.api.model.operator.network.v1.OperatorPKISpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private CertSpecBuilder targetCert;

  public OperatorPKISpecFluent() {
  }
  
  public OperatorPKISpecFluent(OperatorPKISpec instance) {
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
  
  public CertSpec buildTargetCert() {
    return this.targetCert != null ? this.targetCert.build() : null;
  }
  
  protected void copyInstance(OperatorPKISpec instance) {
    instance = instance != null ? instance : new OperatorPKISpec();
    if (instance != null) {
        this.withTargetCert(instance.getTargetCert());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public TargetCertNested<A> editOrNewTargetCert() {
    return this.withNewTargetCertLike(Optional.ofNullable(this.buildTargetCert()).orElse(new CertSpecBuilder().build()));
  }
  
  public TargetCertNested<A> editOrNewTargetCertLike(CertSpec item) {
    return this.withNewTargetCertLike(Optional.ofNullable(this.buildTargetCert()).orElse(item));
  }
  
  public TargetCertNested<A> editTargetCert() {
    return this.withNewTargetCertLike(Optional.ofNullable(this.buildTargetCert()).orElse(null));
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
    OperatorPKISpecFluent that = (OperatorPKISpecFluent) o;
    if (!(Objects.equals(targetCert, that.targetCert))) {
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
  
  public boolean hasTargetCert() {
    return this.targetCert != null;
  }
  
  public int hashCode() {
    return Objects.hash(targetCert, additionalProperties);
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
    if (!(targetCert == null)) {
        sb.append("targetCert:");
        sb.append(targetCert);
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
  
  public TargetCertNested<A> withNewTargetCert() {
    return new TargetCertNested(null);
  }
  
  public A withNewTargetCert(String commonName) {
    return (A) this.withTargetCert(new CertSpec(commonName));
  }
  
  public TargetCertNested<A> withNewTargetCertLike(CertSpec item) {
    return new TargetCertNested(item);
  }
  
  public A withTargetCert(CertSpec targetCert) {
    this._visitables.remove("targetCert");
    if (targetCert != null) {
        this.targetCert = new CertSpecBuilder(targetCert);
        this._visitables.get("targetCert").add(this.targetCert);
    } else {
        this.targetCert = null;
        this._visitables.get("targetCert").remove(this.targetCert);
    }
    return (A) this;
  }
  public class TargetCertNested<N> extends CertSpecFluent<TargetCertNested<N>> implements Nested<N>{
  
    CertSpecBuilder builder;
  
    TargetCertNested(CertSpec item) {
      this.builder = new CertSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) OperatorPKISpecFluent.this.withTargetCert(builder.build());
    }
    
    public N endTargetCert() {
      return and();
    }
    
  }
}