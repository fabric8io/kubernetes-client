package io.fabric8.istio.api.api.security.v1beta1;

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
public class AuthorizationPolicyProviderFluent<A extends io.fabric8.istio.api.api.security.v1beta1.AuthorizationPolicyProviderFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private AuthorizationPolicyExtensionProviderBuilder provider;

  public AuthorizationPolicyProviderFluent() {
  }
  
  public AuthorizationPolicyProviderFluent(AuthorizationPolicyProvider instance) {
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
  
  public AuthorizationPolicyExtensionProvider buildProvider() {
    return this.provider != null ? this.provider.build() : null;
  }
  
  protected void copyInstance(AuthorizationPolicyProvider instance) {
    instance = instance != null ? instance : new AuthorizationPolicyProvider();
    if (instance != null) {
        this.withProvider(instance.getProvider());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ProviderNested<A> editOrNewProvider() {
    return this.withNewProviderLike(Optional.ofNullable(this.buildProvider()).orElse(new AuthorizationPolicyExtensionProviderBuilder().build()));
  }
  
  public ProviderNested<A> editOrNewProviderLike(AuthorizationPolicyExtensionProvider item) {
    return this.withNewProviderLike(Optional.ofNullable(this.buildProvider()).orElse(item));
  }
  
  public ProviderNested<A> editProvider() {
    return this.withNewProviderLike(Optional.ofNullable(this.buildProvider()).orElse(null));
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
    AuthorizationPolicyProviderFluent that = (AuthorizationPolicyProviderFluent) o;
    if (!(Objects.equals(provider, that.provider))) {
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
  
  public boolean hasProvider() {
    return this.provider != null;
  }
  
  public int hashCode() {
    return Objects.hash(provider, additionalProperties);
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
    if (!(provider == null)) {
        sb.append("provider:");
        sb.append(provider);
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
  
  public ProviderNested<A> withNewProvider() {
    return new ProviderNested(null);
  }
  
  public A withNewProvider(String name) {
    return (A) this.withProvider(new AuthorizationPolicyExtensionProvider(name));
  }
  
  public ProviderNested<A> withNewProviderLike(AuthorizationPolicyExtensionProvider item) {
    return new ProviderNested(item);
  }
  
  public A withProvider(AuthorizationPolicyExtensionProvider provider) {
    this._visitables.remove("provider");
    if (provider != null) {
        this.provider = new AuthorizationPolicyExtensionProviderBuilder(provider);
        this._visitables.get("provider").add(this.provider);
    } else {
        this.provider = null;
        this._visitables.get("provider").remove(this.provider);
    }
    return (A) this;
  }
  public class ProviderNested<N> extends AuthorizationPolicyExtensionProviderFluent<ProviderNested<N>> implements Nested<N>{
  
    AuthorizationPolicyExtensionProviderBuilder builder;
  
    ProviderNested(AuthorizationPolicyExtensionProvider item) {
      this.builder = new AuthorizationPolicyExtensionProviderBuilder(this, item);
    }
  
    public N and() {
      return (N) AuthorizationPolicyProviderFluent.this.withProvider(builder.build());
    }
    
    public N endProvider() {
      return and();
    }
    
  }
}