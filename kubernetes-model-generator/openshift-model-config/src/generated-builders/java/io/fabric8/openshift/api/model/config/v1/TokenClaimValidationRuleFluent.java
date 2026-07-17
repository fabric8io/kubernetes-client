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
public class TokenClaimValidationRuleFluent<A extends io.fabric8.openshift.api.model.config.v1.TokenClaimValidationRuleFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private TokenRequiredClaimBuilder requiredClaim;
  private String type;

  public TokenClaimValidationRuleFluent() {
  }
  
  public TokenClaimValidationRuleFluent(TokenClaimValidationRule instance) {
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
  
  public TokenRequiredClaim buildRequiredClaim() {
    return this.requiredClaim != null ? this.requiredClaim.build() : null;
  }
  
  protected void copyInstance(TokenClaimValidationRule instance) {
    instance = instance != null ? instance : new TokenClaimValidationRule();
    if (instance != null) {
        this.withRequiredClaim(instance.getRequiredClaim());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RequiredClaimNested<A> editOrNewRequiredClaim() {
    return this.withNewRequiredClaimLike(Optional.ofNullable(this.buildRequiredClaim()).orElse(new TokenRequiredClaimBuilder().build()));
  }
  
  public RequiredClaimNested<A> editOrNewRequiredClaimLike(TokenRequiredClaim item) {
    return this.withNewRequiredClaimLike(Optional.ofNullable(this.buildRequiredClaim()).orElse(item));
  }
  
  public RequiredClaimNested<A> editRequiredClaim() {
    return this.withNewRequiredClaimLike(Optional.ofNullable(this.buildRequiredClaim()).orElse(null));
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
    TokenClaimValidationRuleFluent that = (TokenClaimValidationRuleFluent) o;
    if (!(Objects.equals(requiredClaim, that.requiredClaim))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
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
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasRequiredClaim() {
    return this.requiredClaim != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(requiredClaim, type, additionalProperties);
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
    if (!(requiredClaim == null)) {
        sb.append("requiredClaim:");
        sb.append(requiredClaim);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
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
  
  public RequiredClaimNested<A> withNewRequiredClaim() {
    return new RequiredClaimNested(null);
  }
  
  public A withNewRequiredClaim(String claim,String requiredValue) {
    return (A) this.withRequiredClaim(new TokenRequiredClaim(claim, requiredValue));
  }
  
  public RequiredClaimNested<A> withNewRequiredClaimLike(TokenRequiredClaim item) {
    return new RequiredClaimNested(item);
  }
  
  public A withRequiredClaim(TokenRequiredClaim requiredClaim) {
    this._visitables.remove("requiredClaim");
    if (requiredClaim != null) {
        this.requiredClaim = new TokenRequiredClaimBuilder(requiredClaim);
        this._visitables.get("requiredClaim").add(this.requiredClaim);
    } else {
        this.requiredClaim = null;
        this._visitables.get("requiredClaim").remove(this.requiredClaim);
    }
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class RequiredClaimNested<N> extends TokenRequiredClaimFluent<RequiredClaimNested<N>> implements Nested<N>{
  
    TokenRequiredClaimBuilder builder;
  
    RequiredClaimNested(TokenRequiredClaim item) {
      this.builder = new TokenRequiredClaimBuilder(this, item);
    }
  
    public N and() {
      return (N) TokenClaimValidationRuleFluent.this.withRequiredClaim(builder.build());
    }
    
    public N endRequiredClaim() {
      return and();
    }
    
  }
}