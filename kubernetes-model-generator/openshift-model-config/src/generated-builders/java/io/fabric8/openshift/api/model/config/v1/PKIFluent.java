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
public class PKIFluent<A extends io.fabric8.openshift.api.model.config.v1.PKIFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String caIntermediatesData;
  private String caRootsData;
  private PKICertificateSubjectBuilder pkiCertificateSubject;

  public PKIFluent() {
  }
  
  public PKIFluent(PKI instance) {
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
  
  public PKICertificateSubject buildPkiCertificateSubject() {
    return this.pkiCertificateSubject != null ? this.pkiCertificateSubject.build() : null;
  }
  
  protected void copyInstance(PKI instance) {
    instance = instance != null ? instance : new PKI();
    if (instance != null) {
        this.withCaIntermediatesData(instance.getCaIntermediatesData());
        this.withCaRootsData(instance.getCaRootsData());
        this.withPkiCertificateSubject(instance.getPkiCertificateSubject());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PkiCertificateSubjectNested<A> editOrNewPkiCertificateSubject() {
    return this.withNewPkiCertificateSubjectLike(Optional.ofNullable(this.buildPkiCertificateSubject()).orElse(new PKICertificateSubjectBuilder().build()));
  }
  
  public PkiCertificateSubjectNested<A> editOrNewPkiCertificateSubjectLike(PKICertificateSubject item) {
    return this.withNewPkiCertificateSubjectLike(Optional.ofNullable(this.buildPkiCertificateSubject()).orElse(item));
  }
  
  public PkiCertificateSubjectNested<A> editPkiCertificateSubject() {
    return this.withNewPkiCertificateSubjectLike(Optional.ofNullable(this.buildPkiCertificateSubject()).orElse(null));
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
    PKIFluent that = (PKIFluent) o;
    if (!(Objects.equals(caIntermediatesData, that.caIntermediatesData))) {
      return false;
    }
    if (!(Objects.equals(caRootsData, that.caRootsData))) {
      return false;
    }
    if (!(Objects.equals(pkiCertificateSubject, that.pkiCertificateSubject))) {
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
  
  public String getCaIntermediatesData() {
    return this.caIntermediatesData;
  }
  
  public String getCaRootsData() {
    return this.caRootsData;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCaIntermediatesData() {
    return this.caIntermediatesData != null;
  }
  
  public boolean hasCaRootsData() {
    return this.caRootsData != null;
  }
  
  public boolean hasPkiCertificateSubject() {
    return this.pkiCertificateSubject != null;
  }
  
  public int hashCode() {
    return Objects.hash(caIntermediatesData, caRootsData, pkiCertificateSubject, additionalProperties);
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
    if (!(caIntermediatesData == null)) {
        sb.append("caIntermediatesData:");
        sb.append(caIntermediatesData);
        sb.append(",");
    }
    if (!(caRootsData == null)) {
        sb.append("caRootsData:");
        sb.append(caRootsData);
        sb.append(",");
    }
    if (!(pkiCertificateSubject == null)) {
        sb.append("pkiCertificateSubject:");
        sb.append(pkiCertificateSubject);
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
  
  public A withCaIntermediatesData(String caIntermediatesData) {
    this.caIntermediatesData = caIntermediatesData;
    return (A) this;
  }
  
  public A withCaRootsData(String caRootsData) {
    this.caRootsData = caRootsData;
    return (A) this;
  }
  
  public PkiCertificateSubjectNested<A> withNewPkiCertificateSubject() {
    return new PkiCertificateSubjectNested(null);
  }
  
  public A withNewPkiCertificateSubject(String email,String hostname) {
    return (A) this.withPkiCertificateSubject(new PKICertificateSubject(email, hostname));
  }
  
  public PkiCertificateSubjectNested<A> withNewPkiCertificateSubjectLike(PKICertificateSubject item) {
    return new PkiCertificateSubjectNested(item);
  }
  
  public A withPkiCertificateSubject(PKICertificateSubject pkiCertificateSubject) {
    this._visitables.remove("pkiCertificateSubject");
    if (pkiCertificateSubject != null) {
        this.pkiCertificateSubject = new PKICertificateSubjectBuilder(pkiCertificateSubject);
        this._visitables.get("pkiCertificateSubject").add(this.pkiCertificateSubject);
    } else {
        this.pkiCertificateSubject = null;
        this._visitables.get("pkiCertificateSubject").remove(this.pkiCertificateSubject);
    }
    return (A) this;
  }
  public class PkiCertificateSubjectNested<N> extends PKICertificateSubjectFluent<PkiCertificateSubjectNested<N>> implements Nested<N>{
  
    PKICertificateSubjectBuilder builder;
  
    PkiCertificateSubjectNested(PKICertificateSubject item) {
      this.builder = new PKICertificateSubjectBuilder(this, item);
    }
  
    public N and() {
      return (N) PKIFluent.this.withPkiCertificateSubject(builder.build());
    }
    
    public N endPkiCertificateSubject() {
      return and();
    }
    
  }
}