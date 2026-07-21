package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Long;
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
public class AddOnRegistrationDriverFluent<A extends io.fabric8.openclustermanagement.api.model.operator.v1.AddOnRegistrationDriverFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String authType;
  private TokenConfigBuilder token;

  public AddOnRegistrationDriverFluent() {
  }
  
  public AddOnRegistrationDriverFluent(AddOnRegistrationDriver instance) {
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
  
  public TokenConfig buildToken() {
    return this.token != null ? this.token.build() : null;
  }
  
  protected void copyInstance(AddOnRegistrationDriver instance) {
    instance = instance != null ? instance : new AddOnRegistrationDriver();
    if (instance != null) {
        this.withAuthType(instance.getAuthType());
        this.withToken(instance.getToken());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public TokenNested<A> editOrNewToken() {
    return this.withNewTokenLike(Optional.ofNullable(this.buildToken()).orElse(new TokenConfigBuilder().build()));
  }
  
  public TokenNested<A> editOrNewTokenLike(TokenConfig item) {
    return this.withNewTokenLike(Optional.ofNullable(this.buildToken()).orElse(item));
  }
  
  public TokenNested<A> editToken() {
    return this.withNewTokenLike(Optional.ofNullable(this.buildToken()).orElse(null));
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
    AddOnRegistrationDriverFluent that = (AddOnRegistrationDriverFluent) o;
    if (!(Objects.equals(authType, that.authType))) {
      return false;
    }
    if (!(Objects.equals(token, that.token))) {
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
  
  public String getAuthType() {
    return this.authType;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAuthType() {
    return this.authType != null;
  }
  
  public boolean hasToken() {
    return this.token != null;
  }
  
  public int hashCode() {
    return Objects.hash(authType, token, additionalProperties);
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
    if (!(authType == null)) {
        sb.append("authType:");
        sb.append(authType);
        sb.append(",");
    }
    if (!(token == null)) {
        sb.append("token:");
        sb.append(token);
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
  
  public A withAuthType(String authType) {
    this.authType = authType;
    return (A) this;
  }
  
  public TokenNested<A> withNewToken() {
    return new TokenNested(null);
  }
  
  public A withNewToken(Long expirationSeconds) {
    return (A) this.withToken(new TokenConfig(expirationSeconds));
  }
  
  public TokenNested<A> withNewTokenLike(TokenConfig item) {
    return new TokenNested(item);
  }
  
  public A withToken(TokenConfig token) {
    this._visitables.remove("token");
    if (token != null) {
        this.token = new TokenConfigBuilder(token);
        this._visitables.get("token").add(this.token);
    } else {
        this.token = null;
        this._visitables.get("token").remove(this.token);
    }
    return (A) this;
  }
  public class TokenNested<N> extends TokenConfigFluent<TokenNested<N>> implements Nested<N>{
  
    TokenConfigBuilder builder;
  
    TokenNested(TokenConfig item) {
      this.builder = new TokenConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) AddOnRegistrationDriverFluent.this.withToken(builder.build());
    }
    
    public N endToken() {
      return and();
    }
    
  }
}