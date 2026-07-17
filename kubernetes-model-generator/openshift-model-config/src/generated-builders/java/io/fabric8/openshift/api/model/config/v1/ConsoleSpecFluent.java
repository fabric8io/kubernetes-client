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
public class ConsoleSpecFluent<A extends io.fabric8.openshift.api.model.config.v1.ConsoleSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ConsoleAuthenticationBuilder authentication;

  public ConsoleSpecFluent() {
  }
  
  public ConsoleSpecFluent(ConsoleSpec instance) {
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
  
  public ConsoleAuthentication buildAuthentication() {
    return this.authentication != null ? this.authentication.build() : null;
  }
  
  protected void copyInstance(ConsoleSpec instance) {
    instance = instance != null ? instance : new ConsoleSpec();
    if (instance != null) {
        this.withAuthentication(instance.getAuthentication());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AuthenticationNested<A> editAuthentication() {
    return this.withNewAuthenticationLike(Optional.ofNullable(this.buildAuthentication()).orElse(null));
  }
  
  public AuthenticationNested<A> editOrNewAuthentication() {
    return this.withNewAuthenticationLike(Optional.ofNullable(this.buildAuthentication()).orElse(new ConsoleAuthenticationBuilder().build()));
  }
  
  public AuthenticationNested<A> editOrNewAuthenticationLike(ConsoleAuthentication item) {
    return this.withNewAuthenticationLike(Optional.ofNullable(this.buildAuthentication()).orElse(item));
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
    ConsoleSpecFluent that = (ConsoleSpecFluent) o;
    if (!(Objects.equals(authentication, that.authentication))) {
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
  
  public boolean hasAuthentication() {
    return this.authentication != null;
  }
  
  public int hashCode() {
    return Objects.hash(authentication, additionalProperties);
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
    if (!(authentication == null)) {
        sb.append("authentication:");
        sb.append(authentication);
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
  
  public A withAuthentication(ConsoleAuthentication authentication) {
    this._visitables.remove("authentication");
    if (authentication != null) {
        this.authentication = new ConsoleAuthenticationBuilder(authentication);
        this._visitables.get("authentication").add(this.authentication);
    } else {
        this.authentication = null;
        this._visitables.get("authentication").remove(this.authentication);
    }
    return (A) this;
  }
  
  public AuthenticationNested<A> withNewAuthentication() {
    return new AuthenticationNested(null);
  }
  
  public A withNewAuthentication(String logoutRedirect) {
    return (A) this.withAuthentication(new ConsoleAuthentication(logoutRedirect));
  }
  
  public AuthenticationNested<A> withNewAuthenticationLike(ConsoleAuthentication item) {
    return new AuthenticationNested(item);
  }
  public class AuthenticationNested<N> extends ConsoleAuthenticationFluent<AuthenticationNested<N>> implements Nested<N>{
  
    ConsoleAuthenticationBuilder builder;
  
    AuthenticationNested(ConsoleAuthentication item) {
      this.builder = new ConsoleAuthenticationBuilder(this, item);
    }
  
    public N and() {
      return (N) ConsoleSpecFluent.this.withAuthentication(builder.build());
    }
    
    public N endAuthentication() {
      return and();
    }
    
  }
}