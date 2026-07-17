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
public class PolicyIdentityFluent<A extends io.fabric8.openshift.api.model.config.v1.PolicyIdentityFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private PolicyMatchExactRepositoryBuilder exactRepository;
  private String matchPolicy;
  private PolicyMatchRemapIdentityBuilder remapIdentity;

  public PolicyIdentityFluent() {
  }
  
  public PolicyIdentityFluent(PolicyIdentity instance) {
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
  
  public PolicyMatchExactRepository buildExactRepository() {
    return this.exactRepository != null ? this.exactRepository.build() : null;
  }
  
  public PolicyMatchRemapIdentity buildRemapIdentity() {
    return this.remapIdentity != null ? this.remapIdentity.build() : null;
  }
  
  protected void copyInstance(PolicyIdentity instance) {
    instance = instance != null ? instance : new PolicyIdentity();
    if (instance != null) {
        this.withExactRepository(instance.getExactRepository());
        this.withMatchPolicy(instance.getMatchPolicy());
        this.withRemapIdentity(instance.getRemapIdentity());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ExactRepositoryNested<A> editExactRepository() {
    return this.withNewExactRepositoryLike(Optional.ofNullable(this.buildExactRepository()).orElse(null));
  }
  
  public ExactRepositoryNested<A> editOrNewExactRepository() {
    return this.withNewExactRepositoryLike(Optional.ofNullable(this.buildExactRepository()).orElse(new PolicyMatchExactRepositoryBuilder().build()));
  }
  
  public ExactRepositoryNested<A> editOrNewExactRepositoryLike(PolicyMatchExactRepository item) {
    return this.withNewExactRepositoryLike(Optional.ofNullable(this.buildExactRepository()).orElse(item));
  }
  
  public RemapIdentityNested<A> editOrNewRemapIdentity() {
    return this.withNewRemapIdentityLike(Optional.ofNullable(this.buildRemapIdentity()).orElse(new PolicyMatchRemapIdentityBuilder().build()));
  }
  
  public RemapIdentityNested<A> editOrNewRemapIdentityLike(PolicyMatchRemapIdentity item) {
    return this.withNewRemapIdentityLike(Optional.ofNullable(this.buildRemapIdentity()).orElse(item));
  }
  
  public RemapIdentityNested<A> editRemapIdentity() {
    return this.withNewRemapIdentityLike(Optional.ofNullable(this.buildRemapIdentity()).orElse(null));
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
    PolicyIdentityFluent that = (PolicyIdentityFluent) o;
    if (!(Objects.equals(exactRepository, that.exactRepository))) {
      return false;
    }
    if (!(Objects.equals(matchPolicy, that.matchPolicy))) {
      return false;
    }
    if (!(Objects.equals(remapIdentity, that.remapIdentity))) {
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
  
  public String getMatchPolicy() {
    return this.matchPolicy;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasExactRepository() {
    return this.exactRepository != null;
  }
  
  public boolean hasMatchPolicy() {
    return this.matchPolicy != null;
  }
  
  public boolean hasRemapIdentity() {
    return this.remapIdentity != null;
  }
  
  public int hashCode() {
    return Objects.hash(exactRepository, matchPolicy, remapIdentity, additionalProperties);
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
    if (!(exactRepository == null)) {
        sb.append("exactRepository:");
        sb.append(exactRepository);
        sb.append(",");
    }
    if (!(matchPolicy == null)) {
        sb.append("matchPolicy:");
        sb.append(matchPolicy);
        sb.append(",");
    }
    if (!(remapIdentity == null)) {
        sb.append("remapIdentity:");
        sb.append(remapIdentity);
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
  
  public A withExactRepository(PolicyMatchExactRepository exactRepository) {
    this._visitables.remove("exactRepository");
    if (exactRepository != null) {
        this.exactRepository = new PolicyMatchExactRepositoryBuilder(exactRepository);
        this._visitables.get("exactRepository").add(this.exactRepository);
    } else {
        this.exactRepository = null;
        this._visitables.get("exactRepository").remove(this.exactRepository);
    }
    return (A) this;
  }
  
  public A withMatchPolicy(String matchPolicy) {
    this.matchPolicy = matchPolicy;
    return (A) this;
  }
  
  public ExactRepositoryNested<A> withNewExactRepository() {
    return new ExactRepositoryNested(null);
  }
  
  public A withNewExactRepository(String repository) {
    return (A) this.withExactRepository(new PolicyMatchExactRepository(repository));
  }
  
  public ExactRepositoryNested<A> withNewExactRepositoryLike(PolicyMatchExactRepository item) {
    return new ExactRepositoryNested(item);
  }
  
  public RemapIdentityNested<A> withNewRemapIdentity() {
    return new RemapIdentityNested(null);
  }
  
  public A withNewRemapIdentity(String prefix,String signedPrefix) {
    return (A) this.withRemapIdentity(new PolicyMatchRemapIdentity(prefix, signedPrefix));
  }
  
  public RemapIdentityNested<A> withNewRemapIdentityLike(PolicyMatchRemapIdentity item) {
    return new RemapIdentityNested(item);
  }
  
  public A withRemapIdentity(PolicyMatchRemapIdentity remapIdentity) {
    this._visitables.remove("remapIdentity");
    if (remapIdentity != null) {
        this.remapIdentity = new PolicyMatchRemapIdentityBuilder(remapIdentity);
        this._visitables.get("remapIdentity").add(this.remapIdentity);
    } else {
        this.remapIdentity = null;
        this._visitables.get("remapIdentity").remove(this.remapIdentity);
    }
    return (A) this;
  }
  public class ExactRepositoryNested<N> extends PolicyMatchExactRepositoryFluent<ExactRepositoryNested<N>> implements Nested<N>{
  
    PolicyMatchExactRepositoryBuilder builder;
  
    ExactRepositoryNested(PolicyMatchExactRepository item) {
      this.builder = new PolicyMatchExactRepositoryBuilder(this, item);
    }
  
    public N and() {
      return (N) PolicyIdentityFluent.this.withExactRepository(builder.build());
    }
    
    public N endExactRepository() {
      return and();
    }
    
  }
  public class RemapIdentityNested<N> extends PolicyMatchRemapIdentityFluent<RemapIdentityNested<N>> implements Nested<N>{
  
    PolicyMatchRemapIdentityBuilder builder;
  
    RemapIdentityNested(PolicyMatchRemapIdentity item) {
      this.builder = new PolicyMatchRemapIdentityBuilder(this, item);
    }
  
    public N and() {
      return (N) PolicyIdentityFluent.this.withRemapIdentity(builder.build());
    }
    
    public N endRemapIdentity() {
      return and();
    }
    
  }
}