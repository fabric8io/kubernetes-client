package io.fabric8.certmanager.api.model.v1;

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
public class VenafiCloudFluent<A extends io.fabric8.certmanager.api.model.v1.VenafiCloudFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private SecretKeySelectorBuilder apiTokenSecretRef;
  private String url;

  public VenafiCloudFluent() {
  }
  
  public VenafiCloudFluent(VenafiCloud instance) {
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
  
  public SecretKeySelector buildApiTokenSecretRef() {
    return this.apiTokenSecretRef != null ? this.apiTokenSecretRef.build() : null;
  }
  
  protected void copyInstance(VenafiCloud instance) {
    instance = instance != null ? instance : new VenafiCloud();
    if (instance != null) {
        this.withApiTokenSecretRef(instance.getApiTokenSecretRef());
        this.withUrl(instance.getUrl());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ApiTokenSecretRefNested<A> editApiTokenSecretRef() {
    return this.withNewApiTokenSecretRefLike(Optional.ofNullable(this.buildApiTokenSecretRef()).orElse(null));
  }
  
  public ApiTokenSecretRefNested<A> editOrNewApiTokenSecretRef() {
    return this.withNewApiTokenSecretRefLike(Optional.ofNullable(this.buildApiTokenSecretRef()).orElse(new SecretKeySelectorBuilder().build()));
  }
  
  public ApiTokenSecretRefNested<A> editOrNewApiTokenSecretRefLike(SecretKeySelector item) {
    return this.withNewApiTokenSecretRefLike(Optional.ofNullable(this.buildApiTokenSecretRef()).orElse(item));
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
    VenafiCloudFluent that = (VenafiCloudFluent) o;
    if (!(Objects.equals(apiTokenSecretRef, that.apiTokenSecretRef))) {
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
  
  public String getUrl() {
    return this.url;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiTokenSecretRef() {
    return this.apiTokenSecretRef != null;
  }
  
  public boolean hasUrl() {
    return this.url != null;
  }
  
  public int hashCode() {
    return Objects.hash(apiTokenSecretRef, url, additionalProperties);
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
    if (!(apiTokenSecretRef == null)) {
        sb.append("apiTokenSecretRef:");
        sb.append(apiTokenSecretRef);
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
  
  public A withApiTokenSecretRef(SecretKeySelector apiTokenSecretRef) {
    this._visitables.remove("apiTokenSecretRef");
    if (apiTokenSecretRef != null) {
        this.apiTokenSecretRef = new SecretKeySelectorBuilder(apiTokenSecretRef);
        this._visitables.get("apiTokenSecretRef").add(this.apiTokenSecretRef);
    } else {
        this.apiTokenSecretRef = null;
        this._visitables.get("apiTokenSecretRef").remove(this.apiTokenSecretRef);
    }
    return (A) this;
  }
  
  public ApiTokenSecretRefNested<A> withNewApiTokenSecretRef() {
    return new ApiTokenSecretRefNested(null);
  }
  
  public A withNewApiTokenSecretRef(String key,String name) {
    return (A) this.withApiTokenSecretRef(new SecretKeySelector(key, name));
  }
  
  public ApiTokenSecretRefNested<A> withNewApiTokenSecretRefLike(SecretKeySelector item) {
    return new ApiTokenSecretRefNested(item);
  }
  
  public A withUrl(String url) {
    this.url = url;
    return (A) this;
  }
  public class ApiTokenSecretRefNested<N> extends SecretKeySelectorFluent<ApiTokenSecretRefNested<N>> implements Nested<N>{
  
    SecretKeySelectorBuilder builder;
  
    ApiTokenSecretRefNested(SecretKeySelector item) {
      this.builder = new SecretKeySelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) VenafiCloudFluent.this.withApiTokenSecretRef(builder.build());
    }
    
    public N endApiTokenSecretRef() {
      return and();
    }
    
  }
}