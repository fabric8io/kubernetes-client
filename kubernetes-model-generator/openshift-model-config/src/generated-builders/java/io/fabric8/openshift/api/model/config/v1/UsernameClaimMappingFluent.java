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
public class UsernameClaimMappingFluent<A extends io.fabric8.openshift.api.model.config.v1.UsernameClaimMappingFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String claim;
  private UsernamePrefixBuilder prefix;
  private String prefixPolicy;

  public UsernameClaimMappingFluent() {
  }
  
  public UsernameClaimMappingFluent(UsernameClaimMapping instance) {
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
  
  public UsernamePrefix buildPrefix() {
    return this.prefix != null ? this.prefix.build() : null;
  }
  
  protected void copyInstance(UsernameClaimMapping instance) {
    instance = instance != null ? instance : new UsernameClaimMapping();
    if (instance != null) {
        this.withClaim(instance.getClaim());
        this.withPrefix(instance.getPrefix());
        this.withPrefixPolicy(instance.getPrefixPolicy());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PrefixNested<A> editOrNewPrefix() {
    return this.withNewPrefixLike(Optional.ofNullable(this.buildPrefix()).orElse(new UsernamePrefixBuilder().build()));
  }
  
  public PrefixNested<A> editOrNewPrefixLike(UsernamePrefix item) {
    return this.withNewPrefixLike(Optional.ofNullable(this.buildPrefix()).orElse(item));
  }
  
  public PrefixNested<A> editPrefix() {
    return this.withNewPrefixLike(Optional.ofNullable(this.buildPrefix()).orElse(null));
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
    UsernameClaimMappingFluent that = (UsernameClaimMappingFluent) o;
    if (!(Objects.equals(claim, that.claim))) {
      return false;
    }
    if (!(Objects.equals(prefix, that.prefix))) {
      return false;
    }
    if (!(Objects.equals(prefixPolicy, that.prefixPolicy))) {
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
  
  public String getClaim() {
    return this.claim;
  }
  
  public String getPrefixPolicy() {
    return this.prefixPolicy;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClaim() {
    return this.claim != null;
  }
  
  public boolean hasPrefix() {
    return this.prefix != null;
  }
  
  public boolean hasPrefixPolicy() {
    return this.prefixPolicy != null;
  }
  
  public int hashCode() {
    return Objects.hash(claim, prefix, prefixPolicy, additionalProperties);
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
    if (!(claim == null)) {
        sb.append("claim:");
        sb.append(claim);
        sb.append(",");
    }
    if (!(prefix == null)) {
        sb.append("prefix:");
        sb.append(prefix);
        sb.append(",");
    }
    if (!(prefixPolicy == null)) {
        sb.append("prefixPolicy:");
        sb.append(prefixPolicy);
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
  
  public A withClaim(String claim) {
    this.claim = claim;
    return (A) this;
  }
  
  public PrefixNested<A> withNewPrefix() {
    return new PrefixNested(null);
  }
  
  public A withNewPrefix(String prefixString) {
    return (A) this.withPrefix(new UsernamePrefix(prefixString));
  }
  
  public PrefixNested<A> withNewPrefixLike(UsernamePrefix item) {
    return new PrefixNested(item);
  }
  
  public A withPrefix(UsernamePrefix prefix) {
    this._visitables.remove("prefix");
    if (prefix != null) {
        this.prefix = new UsernamePrefixBuilder(prefix);
        this._visitables.get("prefix").add(this.prefix);
    } else {
        this.prefix = null;
        this._visitables.get("prefix").remove(this.prefix);
    }
    return (A) this;
  }
  
  public A withPrefixPolicy(String prefixPolicy) {
    this.prefixPolicy = prefixPolicy;
    return (A) this;
  }
  public class PrefixNested<N> extends UsernamePrefixFluent<PrefixNested<N>> implements Nested<N>{
  
    UsernamePrefixBuilder builder;
  
    PrefixNested(UsernamePrefix item) {
      this.builder = new UsernamePrefixBuilder(this, item);
    }
  
    public N and() {
      return (N) UsernameClaimMappingFluent.this.withPrefix(builder.build());
    }
    
    public N endPrefix() {
      return and();
    }
    
  }
}