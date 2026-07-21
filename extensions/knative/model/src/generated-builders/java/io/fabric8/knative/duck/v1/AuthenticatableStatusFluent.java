package io.fabric8.knative.duck.v1;

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
public class AuthenticatableStatusFluent<A extends io.fabric8.knative.duck.v1.AuthenticatableStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private AuthStatusBuilder auth;

  public AuthenticatableStatusFluent() {
  }
  
  public AuthenticatableStatusFluent(AuthenticatableStatus instance) {
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
  
  public AuthStatus buildAuth() {
    return this.auth != null ? this.auth.build() : null;
  }
  
  protected void copyInstance(AuthenticatableStatus instance) {
    instance = instance != null ? instance : new AuthenticatableStatus();
    if (instance != null) {
        this.withAuth(instance.getAuth());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AuthNested<A> editAuth() {
    return this.withNewAuthLike(Optional.ofNullable(this.buildAuth()).orElse(null));
  }
  
  public AuthNested<A> editOrNewAuth() {
    return this.withNewAuthLike(Optional.ofNullable(this.buildAuth()).orElse(new AuthStatusBuilder().build()));
  }
  
  public AuthNested<A> editOrNewAuthLike(AuthStatus item) {
    return this.withNewAuthLike(Optional.ofNullable(this.buildAuth()).orElse(item));
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
    AuthenticatableStatusFluent that = (AuthenticatableStatusFluent) o;
    if (!(Objects.equals(auth, that.auth))) {
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
  
  public boolean hasAuth() {
    return this.auth != null;
  }
  
  public int hashCode() {
    return Objects.hash(auth, additionalProperties);
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
    if (!(auth == null)) {
        sb.append("auth:");
        sb.append(auth);
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
  
  public A withAuth(AuthStatus auth) {
    this._visitables.remove("auth");
    if (auth != null) {
        this.auth = new AuthStatusBuilder(auth);
        this._visitables.get("auth").add(this.auth);
    } else {
        this.auth = null;
        this._visitables.get("auth").remove(this.auth);
    }
    return (A) this;
  }
  
  public AuthNested<A> withNewAuth() {
    return new AuthNested(null);
  }
  
  public AuthNested<A> withNewAuthLike(AuthStatus item) {
    return new AuthNested(item);
  }
  public class AuthNested<N> extends AuthStatusFluent<AuthNested<N>> implements Nested<N>{
  
    AuthStatusBuilder builder;
  
    AuthNested(AuthStatus item) {
      this.builder = new AuthStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) AuthenticatableStatusFluent.this.withAuth(builder.build());
    }
    
    public N endAuth() {
      return and();
    }
    
  }
}