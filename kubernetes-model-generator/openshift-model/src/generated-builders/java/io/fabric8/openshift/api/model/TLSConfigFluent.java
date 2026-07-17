package io.fabric8.openshift.api.model;

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
public class TLSConfigFluent<A extends io.fabric8.openshift.api.model.TLSConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String caCertificate;
  private String certificate;
  private String destinationCACertificate;
  private LocalObjectReferenceBuilder externalCertificate;
  private String insecureEdgeTerminationPolicy;
  private String key;
  private String termination;

  public TLSConfigFluent() {
  }
  
  public TLSConfigFluent(TLSConfig instance) {
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
  
  public LocalObjectReference buildExternalCertificate() {
    return this.externalCertificate != null ? this.externalCertificate.build() : null;
  }
  
  protected void copyInstance(TLSConfig instance) {
    instance = instance != null ? instance : new TLSConfig();
    if (instance != null) {
        this.withCaCertificate(instance.getCaCertificate());
        this.withCertificate(instance.getCertificate());
        this.withDestinationCACertificate(instance.getDestinationCACertificate());
        this.withExternalCertificate(instance.getExternalCertificate());
        this.withInsecureEdgeTerminationPolicy(instance.getInsecureEdgeTerminationPolicy());
        this.withKey(instance.getKey());
        this.withTermination(instance.getTermination());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ExternalCertificateNested<A> editExternalCertificate() {
    return this.withNewExternalCertificateLike(Optional.ofNullable(this.buildExternalCertificate()).orElse(null));
  }
  
  public ExternalCertificateNested<A> editOrNewExternalCertificate() {
    return this.withNewExternalCertificateLike(Optional.ofNullable(this.buildExternalCertificate()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public ExternalCertificateNested<A> editOrNewExternalCertificateLike(LocalObjectReference item) {
    return this.withNewExternalCertificateLike(Optional.ofNullable(this.buildExternalCertificate()).orElse(item));
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
    TLSConfigFluent that = (TLSConfigFluent) o;
    if (!(Objects.equals(caCertificate, that.caCertificate))) {
      return false;
    }
    if (!(Objects.equals(certificate, that.certificate))) {
      return false;
    }
    if (!(Objects.equals(destinationCACertificate, that.destinationCACertificate))) {
      return false;
    }
    if (!(Objects.equals(externalCertificate, that.externalCertificate))) {
      return false;
    }
    if (!(Objects.equals(insecureEdgeTerminationPolicy, that.insecureEdgeTerminationPolicy))) {
      return false;
    }
    if (!(Objects.equals(key, that.key))) {
      return false;
    }
    if (!(Objects.equals(termination, that.termination))) {
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
  
  public String getCaCertificate() {
    return this.caCertificate;
  }
  
  public String getCertificate() {
    return this.certificate;
  }
  
  public String getDestinationCACertificate() {
    return this.destinationCACertificate;
  }
  
  public String getInsecureEdgeTerminationPolicy() {
    return this.insecureEdgeTerminationPolicy;
  }
  
  public String getKey() {
    return this.key;
  }
  
  public String getTermination() {
    return this.termination;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCaCertificate() {
    return this.caCertificate != null;
  }
  
  public boolean hasCertificate() {
    return this.certificate != null;
  }
  
  public boolean hasDestinationCACertificate() {
    return this.destinationCACertificate != null;
  }
  
  public boolean hasExternalCertificate() {
    return this.externalCertificate != null;
  }
  
  public boolean hasInsecureEdgeTerminationPolicy() {
    return this.insecureEdgeTerminationPolicy != null;
  }
  
  public boolean hasKey() {
    return this.key != null;
  }
  
  public boolean hasTermination() {
    return this.termination != null;
  }
  
  public int hashCode() {
    return Objects.hash(caCertificate, certificate, destinationCACertificate, externalCertificate, insecureEdgeTerminationPolicy, key, termination, additionalProperties);
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
    if (!(caCertificate == null)) {
        sb.append("caCertificate:");
        sb.append(caCertificate);
        sb.append(",");
    }
    if (!(certificate == null)) {
        sb.append("certificate:");
        sb.append(certificate);
        sb.append(",");
    }
    if (!(destinationCACertificate == null)) {
        sb.append("destinationCACertificate:");
        sb.append(destinationCACertificate);
        sb.append(",");
    }
    if (!(externalCertificate == null)) {
        sb.append("externalCertificate:");
        sb.append(externalCertificate);
        sb.append(",");
    }
    if (!(insecureEdgeTerminationPolicy == null)) {
        sb.append("insecureEdgeTerminationPolicy:");
        sb.append(insecureEdgeTerminationPolicy);
        sb.append(",");
    }
    if (!(key == null)) {
        sb.append("key:");
        sb.append(key);
        sb.append(",");
    }
    if (!(termination == null)) {
        sb.append("termination:");
        sb.append(termination);
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
  
  public A withCaCertificate(String caCertificate) {
    this.caCertificate = caCertificate;
    return (A) this;
  }
  
  public A withCertificate(String certificate) {
    this.certificate = certificate;
    return (A) this;
  }
  
  public A withDestinationCACertificate(String destinationCACertificate) {
    this.destinationCACertificate = destinationCACertificate;
    return (A) this;
  }
  
  public A withExternalCertificate(LocalObjectReference externalCertificate) {
    this._visitables.remove("externalCertificate");
    if (externalCertificate != null) {
        this.externalCertificate = new LocalObjectReferenceBuilder(externalCertificate);
        this._visitables.get("externalCertificate").add(this.externalCertificate);
    } else {
        this.externalCertificate = null;
        this._visitables.get("externalCertificate").remove(this.externalCertificate);
    }
    return (A) this;
  }
  
  public A withInsecureEdgeTerminationPolicy(String insecureEdgeTerminationPolicy) {
    this.insecureEdgeTerminationPolicy = insecureEdgeTerminationPolicy;
    return (A) this;
  }
  
  public A withKey(String key) {
    this.key = key;
    return (A) this;
  }
  
  public ExternalCertificateNested<A> withNewExternalCertificate() {
    return new ExternalCertificateNested(null);
  }
  
  public A withNewExternalCertificate(String name) {
    return (A) this.withExternalCertificate(new LocalObjectReference(name));
  }
  
  public ExternalCertificateNested<A> withNewExternalCertificateLike(LocalObjectReference item) {
    return new ExternalCertificateNested(item);
  }
  
  public A withTermination(String termination) {
    this.termination = termination;
    return (A) this;
  }
  public class ExternalCertificateNested<N> extends LocalObjectReferenceFluent<ExternalCertificateNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    ExternalCertificateNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) TLSConfigFluent.this.withExternalCertificate(builder.build());
    }
    
    public N endExternalCertificate() {
      return and();
    }
    
  }
}