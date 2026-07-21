package io.fabric8.certmanager.api.model.v1;

import io.fabric8.certmanager.api.model.meta.v1.LocalObjectReference;
import io.fabric8.certmanager.api.model.meta.v1.LocalObjectReferenceBuilder;
import io.fabric8.certmanager.api.model.meta.v1.LocalObjectReferenceFluent;
import io.fabric8.certmanager.api.model.meta.v1.SecretKeySelector;
import io.fabric8.certmanager.api.model.meta.v1.SecretKeySelectorBuilder;
import io.fabric8.certmanager.api.model.meta.v1.SecretKeySelectorFluent;
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
public class VenafiTPPFluent<A extends io.fabric8.certmanager.api.model.v1.VenafiTPPFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String caBundle;
  private SecretKeySelectorBuilder caBundleSecretRef;
  private LocalObjectReferenceBuilder credentialsRef;
  private String url;

  public VenafiTPPFluent() {
  }
  
  public VenafiTPPFluent(VenafiTPP instance) {
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
  
  public SecretKeySelector buildCaBundleSecretRef() {
    return this.caBundleSecretRef != null ? this.caBundleSecretRef.build() : null;
  }
  
  public LocalObjectReference buildCredentialsRef() {
    return this.credentialsRef != null ? this.credentialsRef.build() : null;
  }
  
  protected void copyInstance(VenafiTPP instance) {
    instance = instance != null ? instance : new VenafiTPP();
    if (instance != null) {
        this.withCaBundle(instance.getCaBundle());
        this.withCaBundleSecretRef(instance.getCaBundleSecretRef());
        this.withCredentialsRef(instance.getCredentialsRef());
        this.withUrl(instance.getUrl());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CaBundleSecretRefNested<A> editCaBundleSecretRef() {
    return this.withNewCaBundleSecretRefLike(Optional.ofNullable(this.buildCaBundleSecretRef()).orElse(null));
  }
  
  public CredentialsRefNested<A> editCredentialsRef() {
    return this.withNewCredentialsRefLike(Optional.ofNullable(this.buildCredentialsRef()).orElse(null));
  }
  
  public CaBundleSecretRefNested<A> editOrNewCaBundleSecretRef() {
    return this.withNewCaBundleSecretRefLike(Optional.ofNullable(this.buildCaBundleSecretRef()).orElse(new SecretKeySelectorBuilder().build()));
  }
  
  public CaBundleSecretRefNested<A> editOrNewCaBundleSecretRefLike(SecretKeySelector item) {
    return this.withNewCaBundleSecretRefLike(Optional.ofNullable(this.buildCaBundleSecretRef()).orElse(item));
  }
  
  public CredentialsRefNested<A> editOrNewCredentialsRef() {
    return this.withNewCredentialsRefLike(Optional.ofNullable(this.buildCredentialsRef()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public CredentialsRefNested<A> editOrNewCredentialsRefLike(LocalObjectReference item) {
    return this.withNewCredentialsRefLike(Optional.ofNullable(this.buildCredentialsRef()).orElse(item));
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
    VenafiTPPFluent that = (VenafiTPPFluent) o;
    if (!(Objects.equals(caBundle, that.caBundle))) {
      return false;
    }
    if (!(Objects.equals(caBundleSecretRef, that.caBundleSecretRef))) {
      return false;
    }
    if (!(Objects.equals(credentialsRef, that.credentialsRef))) {
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
  
  public String getCaBundle() {
    return this.caBundle;
  }
  
  public String getUrl() {
    return this.url;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCaBundle() {
    return this.caBundle != null;
  }
  
  public boolean hasCaBundleSecretRef() {
    return this.caBundleSecretRef != null;
  }
  
  public boolean hasCredentialsRef() {
    return this.credentialsRef != null;
  }
  
  public boolean hasUrl() {
    return this.url != null;
  }
  
  public int hashCode() {
    return Objects.hash(caBundle, caBundleSecretRef, credentialsRef, url, additionalProperties);
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
    if (!(caBundle == null)) {
        sb.append("caBundle:");
        sb.append(caBundle);
        sb.append(",");
    }
    if (!(caBundleSecretRef == null)) {
        sb.append("caBundleSecretRef:");
        sb.append(caBundleSecretRef);
        sb.append(",");
    }
    if (!(credentialsRef == null)) {
        sb.append("credentialsRef:");
        sb.append(credentialsRef);
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
  
  public A withCaBundle(String caBundle) {
    this.caBundle = caBundle;
    return (A) this;
  }
  
  public A withCaBundleSecretRef(SecretKeySelector caBundleSecretRef) {
    this._visitables.remove("caBundleSecretRef");
    if (caBundleSecretRef != null) {
        this.caBundleSecretRef = new SecretKeySelectorBuilder(caBundleSecretRef);
        this._visitables.get("caBundleSecretRef").add(this.caBundleSecretRef);
    } else {
        this.caBundleSecretRef = null;
        this._visitables.get("caBundleSecretRef").remove(this.caBundleSecretRef);
    }
    return (A) this;
  }
  
  public A withCredentialsRef(LocalObjectReference credentialsRef) {
    this._visitables.remove("credentialsRef");
    if (credentialsRef != null) {
        this.credentialsRef = new LocalObjectReferenceBuilder(credentialsRef);
        this._visitables.get("credentialsRef").add(this.credentialsRef);
    } else {
        this.credentialsRef = null;
        this._visitables.get("credentialsRef").remove(this.credentialsRef);
    }
    return (A) this;
  }
  
  public CaBundleSecretRefNested<A> withNewCaBundleSecretRef() {
    return new CaBundleSecretRefNested(null);
  }
  
  public A withNewCaBundleSecretRef(String key,String name) {
    return (A) this.withCaBundleSecretRef(new SecretKeySelector(key, name));
  }
  
  public CaBundleSecretRefNested<A> withNewCaBundleSecretRefLike(SecretKeySelector item) {
    return new CaBundleSecretRefNested(item);
  }
  
  public CredentialsRefNested<A> withNewCredentialsRef() {
    return new CredentialsRefNested(null);
  }
  
  public A withNewCredentialsRef(String name) {
    return (A) this.withCredentialsRef(new LocalObjectReference(name));
  }
  
  public CredentialsRefNested<A> withNewCredentialsRefLike(LocalObjectReference item) {
    return new CredentialsRefNested(item);
  }
  
  public A withUrl(String url) {
    this.url = url;
    return (A) this;
  }
  public class CaBundleSecretRefNested<N> extends SecretKeySelectorFluent<CaBundleSecretRefNested<N>> implements Nested<N>{
  
    SecretKeySelectorBuilder builder;
  
    CaBundleSecretRefNested(SecretKeySelector item) {
      this.builder = new SecretKeySelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) VenafiTPPFluent.this.withCaBundleSecretRef(builder.build());
    }
    
    public N endCaBundleSecretRef() {
      return and();
    }
    
  }
  public class CredentialsRefNested<N> extends LocalObjectReferenceFluent<CredentialsRefNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    CredentialsRefNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) VenafiTPPFluent.this.withCredentialsRef(builder.build());
    }
    
    public N endCredentialsRef() {
      return and();
    }
    
  }
}