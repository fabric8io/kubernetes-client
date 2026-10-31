package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceFluent;
import io.fabric8.openshift.api.model.hive.nutanix.v1.PrismEndpoint;
import io.fabric8.openshift.api.model.hive.nutanix.v1.PrismEndpointBuilder;
import io.fabric8.openshift.api.model.hive.nutanix.v1.PrismEndpointFluent;
import java.lang.Integer;
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
public class NutanixClusterDeprovisionFluent<A extends io.fabric8.openshift.api.model.hive.v1.NutanixClusterDeprovisionFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private LocalObjectReferenceBuilder certificatesSecretRef;
  private LocalObjectReferenceBuilder credentialsSecretRef;
  private PrismEndpointBuilder prismCentral;

  public NutanixClusterDeprovisionFluent() {
  }
  
  public NutanixClusterDeprovisionFluent(NutanixClusterDeprovision instance) {
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
  
  public LocalObjectReference buildCertificatesSecretRef() {
    return this.certificatesSecretRef != null ? this.certificatesSecretRef.build() : null;
  }
  
  public LocalObjectReference buildCredentialsSecretRef() {
    return this.credentialsSecretRef != null ? this.credentialsSecretRef.build() : null;
  }
  
  public PrismEndpoint buildPrismCentral() {
    return this.prismCentral != null ? this.prismCentral.build() : null;
  }
  
  protected void copyInstance(NutanixClusterDeprovision instance) {
    instance = instance != null ? instance : new NutanixClusterDeprovision();
    if (instance != null) {
        this.withCertificatesSecretRef(instance.getCertificatesSecretRef());
        this.withCredentialsSecretRef(instance.getCredentialsSecretRef());
        this.withPrismCentral(instance.getPrismCentral());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CertificatesSecretRefNested<A> editCertificatesSecretRef() {
    return this.withNewCertificatesSecretRefLike(Optional.ofNullable(this.buildCertificatesSecretRef()).orElse(null));
  }
  
  public CredentialsSecretRefNested<A> editCredentialsSecretRef() {
    return this.withNewCredentialsSecretRefLike(Optional.ofNullable(this.buildCredentialsSecretRef()).orElse(null));
  }
  
  public CertificatesSecretRefNested<A> editOrNewCertificatesSecretRef() {
    return this.withNewCertificatesSecretRefLike(Optional.ofNullable(this.buildCertificatesSecretRef()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public CertificatesSecretRefNested<A> editOrNewCertificatesSecretRefLike(LocalObjectReference item) {
    return this.withNewCertificatesSecretRefLike(Optional.ofNullable(this.buildCertificatesSecretRef()).orElse(item));
  }
  
  public CredentialsSecretRefNested<A> editOrNewCredentialsSecretRef() {
    return this.withNewCredentialsSecretRefLike(Optional.ofNullable(this.buildCredentialsSecretRef()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public CredentialsSecretRefNested<A> editOrNewCredentialsSecretRefLike(LocalObjectReference item) {
    return this.withNewCredentialsSecretRefLike(Optional.ofNullable(this.buildCredentialsSecretRef()).orElse(item));
  }
  
  public PrismCentralNested<A> editOrNewPrismCentral() {
    return this.withNewPrismCentralLike(Optional.ofNullable(this.buildPrismCentral()).orElse(new PrismEndpointBuilder().build()));
  }
  
  public PrismCentralNested<A> editOrNewPrismCentralLike(PrismEndpoint item) {
    return this.withNewPrismCentralLike(Optional.ofNullable(this.buildPrismCentral()).orElse(item));
  }
  
  public PrismCentralNested<A> editPrismCentral() {
    return this.withNewPrismCentralLike(Optional.ofNullable(this.buildPrismCentral()).orElse(null));
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
    NutanixClusterDeprovisionFluent that = (NutanixClusterDeprovisionFluent) o;
    if (!(Objects.equals(certificatesSecretRef, that.certificatesSecretRef))) {
      return false;
    }
    if (!(Objects.equals(credentialsSecretRef, that.credentialsSecretRef))) {
      return false;
    }
    if (!(Objects.equals(prismCentral, that.prismCentral))) {
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
  
  public boolean hasCertificatesSecretRef() {
    return this.certificatesSecretRef != null;
  }
  
  public boolean hasCredentialsSecretRef() {
    return this.credentialsSecretRef != null;
  }
  
  public boolean hasPrismCentral() {
    return this.prismCentral != null;
  }
  
  public int hashCode() {
    return Objects.hash(certificatesSecretRef, credentialsSecretRef, prismCentral, additionalProperties);
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
    if (!(certificatesSecretRef == null)) {
        sb.append("certificatesSecretRef:");
        sb.append(certificatesSecretRef);
        sb.append(",");
    }
    if (!(credentialsSecretRef == null)) {
        sb.append("credentialsSecretRef:");
        sb.append(credentialsSecretRef);
        sb.append(",");
    }
    if (!(prismCentral == null)) {
        sb.append("prismCentral:");
        sb.append(prismCentral);
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
  
  public A withCertificatesSecretRef(LocalObjectReference certificatesSecretRef) {
    this._visitables.remove("certificatesSecretRef");
    if (certificatesSecretRef != null) {
        this.certificatesSecretRef = new LocalObjectReferenceBuilder(certificatesSecretRef);
        this._visitables.get("certificatesSecretRef").add(this.certificatesSecretRef);
    } else {
        this.certificatesSecretRef = null;
        this._visitables.get("certificatesSecretRef").remove(this.certificatesSecretRef);
    }
    return (A) this;
  }
  
  public A withCredentialsSecretRef(LocalObjectReference credentialsSecretRef) {
    this._visitables.remove("credentialsSecretRef");
    if (credentialsSecretRef != null) {
        this.credentialsSecretRef = new LocalObjectReferenceBuilder(credentialsSecretRef);
        this._visitables.get("credentialsSecretRef").add(this.credentialsSecretRef);
    } else {
        this.credentialsSecretRef = null;
        this._visitables.get("credentialsSecretRef").remove(this.credentialsSecretRef);
    }
    return (A) this;
  }
  
  public CertificatesSecretRefNested<A> withNewCertificatesSecretRef() {
    return new CertificatesSecretRefNested(null);
  }
  
  public A withNewCertificatesSecretRef(String name) {
    return (A) this.withCertificatesSecretRef(new LocalObjectReference(name));
  }
  
  public CertificatesSecretRefNested<A> withNewCertificatesSecretRefLike(LocalObjectReference item) {
    return new CertificatesSecretRefNested(item);
  }
  
  public CredentialsSecretRefNested<A> withNewCredentialsSecretRef() {
    return new CredentialsSecretRefNested(null);
  }
  
  public A withNewCredentialsSecretRef(String name) {
    return (A) this.withCredentialsSecretRef(new LocalObjectReference(name));
  }
  
  public CredentialsSecretRefNested<A> withNewCredentialsSecretRefLike(LocalObjectReference item) {
    return new CredentialsSecretRefNested(item);
  }
  
  public PrismCentralNested<A> withNewPrismCentral() {
    return new PrismCentralNested(null);
  }
  
  public A withNewPrismCentral(String address,Integer port) {
    return (A) this.withPrismCentral(new PrismEndpoint(address, port));
  }
  
  public PrismCentralNested<A> withNewPrismCentralLike(PrismEndpoint item) {
    return new PrismCentralNested(item);
  }
  
  public A withPrismCentral(PrismEndpoint prismCentral) {
    this._visitables.remove("prismCentral");
    if (prismCentral != null) {
        this.prismCentral = new PrismEndpointBuilder(prismCentral);
        this._visitables.get("prismCentral").add(this.prismCentral);
    } else {
        this.prismCentral = null;
        this._visitables.get("prismCentral").remove(this.prismCentral);
    }
    return (A) this;
  }
  public class CertificatesSecretRefNested<N> extends LocalObjectReferenceFluent<CertificatesSecretRefNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    CertificatesSecretRefNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) NutanixClusterDeprovisionFluent.this.withCertificatesSecretRef(builder.build());
    }
    
    public N endCertificatesSecretRef() {
      return and();
    }
    
  }
  public class CredentialsSecretRefNested<N> extends LocalObjectReferenceFluent<CredentialsSecretRefNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    CredentialsSecretRefNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) NutanixClusterDeprovisionFluent.this.withCredentialsSecretRef(builder.build());
    }
    
    public N endCredentialsSecretRef() {
      return and();
    }
    
  }
  public class PrismCentralNested<N> extends PrismEndpointFluent<PrismCentralNested<N>> implements Nested<N>{
  
    PrismEndpointBuilder builder;
  
    PrismCentralNested(PrismEndpoint item) {
      this.builder = new PrismEndpointBuilder(this, item);
    }
  
    public N and() {
      return (N) NutanixClusterDeprovisionFluent.this.withPrismCentral(builder.build());
    }
    
    public N endPrismCentral() {
      return and();
    }
    
  }
}