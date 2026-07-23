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
public class PolicyFluent<A extends io.fabric8.openshift.api.model.config.v1.PolicyFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private PolicyRootOfTrustBuilder rootOfTrust;
  private PolicyIdentityBuilder signedIdentity;

  public PolicyFluent() {
  }
  
  public PolicyFluent(Policy instance) {
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
  
  public PolicyRootOfTrust buildRootOfTrust() {
    return this.rootOfTrust != null ? this.rootOfTrust.build() : null;
  }
  
  public PolicyIdentity buildSignedIdentity() {
    return this.signedIdentity != null ? this.signedIdentity.build() : null;
  }
  
  protected void copyInstance(Policy instance) {
    instance = instance != null ? instance : new Policy();
    if (instance != null) {
        this.withRootOfTrust(instance.getRootOfTrust());
        this.withSignedIdentity(instance.getSignedIdentity());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RootOfTrustNested<A> editOrNewRootOfTrust() {
    return this.withNewRootOfTrustLike(Optional.ofNullable(this.buildRootOfTrust()).orElse(new PolicyRootOfTrustBuilder().build()));
  }
  
  public RootOfTrustNested<A> editOrNewRootOfTrustLike(PolicyRootOfTrust item) {
    return this.withNewRootOfTrustLike(Optional.ofNullable(this.buildRootOfTrust()).orElse(item));
  }
  
  public SignedIdentityNested<A> editOrNewSignedIdentity() {
    return this.withNewSignedIdentityLike(Optional.ofNullable(this.buildSignedIdentity()).orElse(new PolicyIdentityBuilder().build()));
  }
  
  public SignedIdentityNested<A> editOrNewSignedIdentityLike(PolicyIdentity item) {
    return this.withNewSignedIdentityLike(Optional.ofNullable(this.buildSignedIdentity()).orElse(item));
  }
  
  public RootOfTrustNested<A> editRootOfTrust() {
    return this.withNewRootOfTrustLike(Optional.ofNullable(this.buildRootOfTrust()).orElse(null));
  }
  
  public SignedIdentityNested<A> editSignedIdentity() {
    return this.withNewSignedIdentityLike(Optional.ofNullable(this.buildSignedIdentity()).orElse(null));
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
    PolicyFluent that = (PolicyFluent) o;
    if (!(Objects.equals(rootOfTrust, that.rootOfTrust))) {
      return false;
    }
    if (!(Objects.equals(signedIdentity, that.signedIdentity))) {
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
  
  public boolean hasRootOfTrust() {
    return this.rootOfTrust != null;
  }
  
  public boolean hasSignedIdentity() {
    return this.signedIdentity != null;
  }
  
  public int hashCode() {
    return Objects.hash(rootOfTrust, signedIdentity, additionalProperties);
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
    if (!(rootOfTrust == null)) {
        sb.append("rootOfTrust:");
        sb.append(rootOfTrust);
        sb.append(",");
    }
    if (!(signedIdentity == null)) {
        sb.append("signedIdentity:");
        sb.append(signedIdentity);
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
  
  public RootOfTrustNested<A> withNewRootOfTrust() {
    return new RootOfTrustNested(null);
  }
  
  public RootOfTrustNested<A> withNewRootOfTrustLike(PolicyRootOfTrust item) {
    return new RootOfTrustNested(item);
  }
  
  public SignedIdentityNested<A> withNewSignedIdentity() {
    return new SignedIdentityNested(null);
  }
  
  public SignedIdentityNested<A> withNewSignedIdentityLike(PolicyIdentity item) {
    return new SignedIdentityNested(item);
  }
  
  public A withRootOfTrust(PolicyRootOfTrust rootOfTrust) {
    this._visitables.remove("rootOfTrust");
    if (rootOfTrust != null) {
        this.rootOfTrust = new PolicyRootOfTrustBuilder(rootOfTrust);
        this._visitables.get("rootOfTrust").add(this.rootOfTrust);
    } else {
        this.rootOfTrust = null;
        this._visitables.get("rootOfTrust").remove(this.rootOfTrust);
    }
    return (A) this;
  }
  
  public A withSignedIdentity(PolicyIdentity signedIdentity) {
    this._visitables.remove("signedIdentity");
    if (signedIdentity != null) {
        this.signedIdentity = new PolicyIdentityBuilder(signedIdentity);
        this._visitables.get("signedIdentity").add(this.signedIdentity);
    } else {
        this.signedIdentity = null;
        this._visitables.get("signedIdentity").remove(this.signedIdentity);
    }
    return (A) this;
  }
  public class RootOfTrustNested<N> extends PolicyRootOfTrustFluent<RootOfTrustNested<N>> implements Nested<N>{
  
    PolicyRootOfTrustBuilder builder;
  
    RootOfTrustNested(PolicyRootOfTrust item) {
      this.builder = new PolicyRootOfTrustBuilder(this, item);
    }
  
    public N and() {
      return (N) PolicyFluent.this.withRootOfTrust(builder.build());
    }
    
    public N endRootOfTrust() {
      return and();
    }
    
  }
  public class SignedIdentityNested<N> extends PolicyIdentityFluent<SignedIdentityNested<N>> implements Nested<N>{
  
    PolicyIdentityBuilder builder;
  
    SignedIdentityNested(PolicyIdentity item) {
      this.builder = new PolicyIdentityBuilder(this, item);
    }
  
    public N and() {
      return (N) PolicyFluent.this.withSignedIdentity(builder.build());
    }
    
    public N endSignedIdentity() {
      return and();
    }
    
  }
}