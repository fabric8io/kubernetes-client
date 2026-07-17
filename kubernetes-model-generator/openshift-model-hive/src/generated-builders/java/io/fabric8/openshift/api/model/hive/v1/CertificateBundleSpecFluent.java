package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceFluent;
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
public class CertificateBundleSpecFluent<A extends io.fabric8.openshift.api.model.hive.v1.CertificateBundleSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private LocalObjectReferenceBuilder certificateSecretRef;
  private Boolean generate;
  private String name;

  public CertificateBundleSpecFluent() {
  }
  
  public CertificateBundleSpecFluent(CertificateBundleSpec instance) {
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
  
  public LocalObjectReference buildCertificateSecretRef() {
    return this.certificateSecretRef != null ? this.certificateSecretRef.build() : null;
  }
  
  protected void copyInstance(CertificateBundleSpec instance) {
    instance = instance != null ? instance : new CertificateBundleSpec();
    if (instance != null) {
        this.withCertificateSecretRef(instance.getCertificateSecretRef());
        this.withGenerate(instance.getGenerate());
        this.withName(instance.getName());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CertificateSecretRefNested<A> editCertificateSecretRef() {
    return this.withNewCertificateSecretRefLike(Optional.ofNullable(this.buildCertificateSecretRef()).orElse(null));
  }
  
  public CertificateSecretRefNested<A> editOrNewCertificateSecretRef() {
    return this.withNewCertificateSecretRefLike(Optional.ofNullable(this.buildCertificateSecretRef()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public CertificateSecretRefNested<A> editOrNewCertificateSecretRefLike(LocalObjectReference item) {
    return this.withNewCertificateSecretRefLike(Optional.ofNullable(this.buildCertificateSecretRef()).orElse(item));
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
    CertificateBundleSpecFluent that = (CertificateBundleSpecFluent) o;
    if (!(Objects.equals(certificateSecretRef, that.certificateSecretRef))) {
      return false;
    }
    if (!(Objects.equals(generate, that.generate))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
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
  
  public Boolean getGenerate() {
    return this.generate;
  }
  
  public String getName() {
    return this.name;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCertificateSecretRef() {
    return this.certificateSecretRef != null;
  }
  
  public boolean hasGenerate() {
    return this.generate != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public int hashCode() {
    return Objects.hash(certificateSecretRef, generate, name, additionalProperties);
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
    if (!(certificateSecretRef == null)) {
        sb.append("certificateSecretRef:");
        sb.append(certificateSecretRef);
        sb.append(",");
    }
    if (!(generate == null)) {
        sb.append("generate:");
        sb.append(generate);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
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
  
  public A withCertificateSecretRef(LocalObjectReference certificateSecretRef) {
    this._visitables.remove("certificateSecretRef");
    if (certificateSecretRef != null) {
        this.certificateSecretRef = new LocalObjectReferenceBuilder(certificateSecretRef);
        this._visitables.get("certificateSecretRef").add(this.certificateSecretRef);
    } else {
        this.certificateSecretRef = null;
        this._visitables.get("certificateSecretRef").remove(this.certificateSecretRef);
    }
    return (A) this;
  }
  
  public A withGenerate() {
    return withGenerate(true);
  }
  
  public A withGenerate(Boolean generate) {
    this.generate = generate;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public CertificateSecretRefNested<A> withNewCertificateSecretRef() {
    return new CertificateSecretRefNested(null);
  }
  
  public A withNewCertificateSecretRef(String name) {
    return (A) this.withCertificateSecretRef(new LocalObjectReference(name));
  }
  
  public CertificateSecretRefNested<A> withNewCertificateSecretRefLike(LocalObjectReference item) {
    return new CertificateSecretRefNested(item);
  }
  public class CertificateSecretRefNested<N> extends LocalObjectReferenceFluent<CertificateSecretRefNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    CertificateSecretRefNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) CertificateBundleSpecFluent.this.withCertificateSecretRef(builder.build());
    }
    
    public N endCertificateSecretRef() {
      return and();
    }
    
  }
}