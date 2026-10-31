package io.fabric8.certmanager.api.model.v1;

import io.fabric8.certmanager.api.model.meta.v1.LocalObjectReference;
import io.fabric8.certmanager.api.model.meta.v1.LocalObjectReferenceBuilder;
import io.fabric8.certmanager.api.model.meta.v1.LocalObjectReferenceFluent;
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
public class VenafiNGTSFluent<A extends io.fabric8.certmanager.api.model.v1.VenafiNGTSFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private LocalObjectReferenceBuilder credentialsRef;
  private String tokenEndpoint;
  private String tsgID;
  private String url;

  public VenafiNGTSFluent() {
  }
  
  public VenafiNGTSFluent(VenafiNGTS instance) {
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
  
  public LocalObjectReference buildCredentialsRef() {
    return this.credentialsRef != null ? this.credentialsRef.build() : null;
  }
  
  protected void copyInstance(VenafiNGTS instance) {
    instance = instance != null ? instance : new VenafiNGTS();
    if (instance != null) {
        this.withCredentialsRef(instance.getCredentialsRef());
        this.withTokenEndpoint(instance.getTokenEndpoint());
        this.withTsgID(instance.getTsgID());
        this.withUrl(instance.getUrl());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CredentialsRefNested<A> editCredentialsRef() {
    return this.withNewCredentialsRefLike(Optional.ofNullable(this.buildCredentialsRef()).orElse(null));
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
    VenafiNGTSFluent that = (VenafiNGTSFluent) o;
    if (!(Objects.equals(credentialsRef, that.credentialsRef))) {
      return false;
    }
    if (!(Objects.equals(tokenEndpoint, that.tokenEndpoint))) {
      return false;
    }
    if (!(Objects.equals(tsgID, that.tsgID))) {
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
  
  public String getTokenEndpoint() {
    return this.tokenEndpoint;
  }
  
  public String getTsgID() {
    return this.tsgID;
  }
  
  public String getUrl() {
    return this.url;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCredentialsRef() {
    return this.credentialsRef != null;
  }
  
  public boolean hasTokenEndpoint() {
    return this.tokenEndpoint != null;
  }
  
  public boolean hasTsgID() {
    return this.tsgID != null;
  }
  
  public boolean hasUrl() {
    return this.url != null;
  }
  
  public int hashCode() {
    return Objects.hash(credentialsRef, tokenEndpoint, tsgID, url, additionalProperties);
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
    if (!(credentialsRef == null)) {
        sb.append("credentialsRef:");
        sb.append(credentialsRef);
        sb.append(",");
    }
    if (!(tokenEndpoint == null)) {
        sb.append("tokenEndpoint:");
        sb.append(tokenEndpoint);
        sb.append(",");
    }
    if (!(tsgID == null)) {
        sb.append("tsgID:");
        sb.append(tsgID);
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
  
  public CredentialsRefNested<A> withNewCredentialsRef() {
    return new CredentialsRefNested(null);
  }
  
  public A withNewCredentialsRef(String name) {
    return (A) this.withCredentialsRef(new LocalObjectReference(name));
  }
  
  public CredentialsRefNested<A> withNewCredentialsRefLike(LocalObjectReference item) {
    return new CredentialsRefNested(item);
  }
  
  public A withTokenEndpoint(String tokenEndpoint) {
    this.tokenEndpoint = tokenEndpoint;
    return (A) this;
  }
  
  public A withTsgID(String tsgID) {
    this.tsgID = tsgID;
    return (A) this;
  }
  
  public A withUrl(String url) {
    this.url = url;
    return (A) this;
  }
  public class CredentialsRefNested<N> extends LocalObjectReferenceFluent<CredentialsRefNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    CredentialsRefNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) VenafiNGTSFluent.this.withCredentialsRef(builder.build());
    }
    
    public N endCredentialsRef() {
      return and();
    }
    
  }
}