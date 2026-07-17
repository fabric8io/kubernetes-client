package io.fabric8.openshift.api.model.hive.openstack.v1;

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
public class PlatformFluent<A extends io.fabric8.openshift.api.model.hive.openstack.v1.PlatformFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private LocalObjectReferenceBuilder certificatesSecretRef;
  private String cloud;
  private LocalObjectReferenceBuilder credentialsSecretRef;
  private Boolean trunkSupport;

  public PlatformFluent() {
  }
  
  public PlatformFluent(Platform instance) {
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
  
  protected void copyInstance(Platform instance) {
    instance = instance != null ? instance : new Platform();
    if (instance != null) {
        this.withCertificatesSecretRef(instance.getCertificatesSecretRef());
        this.withCloud(instance.getCloud());
        this.withCredentialsSecretRef(instance.getCredentialsSecretRef());
        this.withTrunkSupport(instance.getTrunkSupport());
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
    PlatformFluent that = (PlatformFluent) o;
    if (!(Objects.equals(certificatesSecretRef, that.certificatesSecretRef))) {
      return false;
    }
    if (!(Objects.equals(cloud, that.cloud))) {
      return false;
    }
    if (!(Objects.equals(credentialsSecretRef, that.credentialsSecretRef))) {
      return false;
    }
    if (!(Objects.equals(trunkSupport, that.trunkSupport))) {
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
  
  public String getCloud() {
    return this.cloud;
  }
  
  public Boolean getTrunkSupport() {
    return this.trunkSupport;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCertificatesSecretRef() {
    return this.certificatesSecretRef != null;
  }
  
  public boolean hasCloud() {
    return this.cloud != null;
  }
  
  public boolean hasCredentialsSecretRef() {
    return this.credentialsSecretRef != null;
  }
  
  public boolean hasTrunkSupport() {
    return this.trunkSupport != null;
  }
  
  public int hashCode() {
    return Objects.hash(certificatesSecretRef, cloud, credentialsSecretRef, trunkSupport, additionalProperties);
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
    if (!(cloud == null)) {
        sb.append("cloud:");
        sb.append(cloud);
        sb.append(",");
    }
    if (!(credentialsSecretRef == null)) {
        sb.append("credentialsSecretRef:");
        sb.append(credentialsSecretRef);
        sb.append(",");
    }
    if (!(trunkSupport == null)) {
        sb.append("trunkSupport:");
        sb.append(trunkSupport);
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
  
  public A withCloud(String cloud) {
    this.cloud = cloud;
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
  
  public A withTrunkSupport() {
    return withTrunkSupport(true);
  }
  
  public A withTrunkSupport(Boolean trunkSupport) {
    this.trunkSupport = trunkSupport;
    return (A) this;
  }
  public class CertificatesSecretRefNested<N> extends LocalObjectReferenceFluent<CertificatesSecretRefNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    CertificatesSecretRefNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformFluent.this.withCertificatesSecretRef(builder.build());
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
      return (N) PlatformFluent.this.withCredentialsSecretRef(builder.build());
    }
    
    public N endCredentialsSecretRef() {
      return and();
    }
    
  }
}