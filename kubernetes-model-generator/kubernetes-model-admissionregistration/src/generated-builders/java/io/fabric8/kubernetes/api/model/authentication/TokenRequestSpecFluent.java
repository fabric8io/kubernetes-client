package io.fabric8.kubernetes.api.model.authentication;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class TokenRequestSpecFluent<A extends io.fabric8.kubernetes.api.model.authentication.TokenRequestSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> audiences = new ArrayList<String>();
  private BoundObjectReferenceBuilder boundObjectRef;
  private Long expirationSeconds;

  public TokenRequestSpecFluent() {
  }
  
  public TokenRequestSpecFluent(TokenRequestSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToAudiences(Collection<String> items) {
    if (this.audiences == null) {
      this.audiences = new ArrayList();
    }
    for (String item : items) {
      this.audiences.add(item);
    }
    return (A) this;
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
  
  public A addToAudiences(String... items) {
    if (this.audiences == null) {
      this.audiences = new ArrayList();
    }
    for (String item : items) {
      this.audiences.add(item);
    }
    return (A) this;
  }
  
  public A addToAudiences(int index,String item) {
    if (this.audiences == null) {
      this.audiences = new ArrayList();
    }
    this.audiences.add(index, item);
    return (A) this;
  }
  
  public BoundObjectReference buildBoundObjectRef() {
    return this.boundObjectRef != null ? this.boundObjectRef.build() : null;
  }
  
  protected void copyInstance(TokenRequestSpec instance) {
    instance = instance != null ? instance : new TokenRequestSpec();
    if (instance != null) {
        this.withAudiences(instance.getAudiences());
        this.withBoundObjectRef(instance.getBoundObjectRef());
        this.withExpirationSeconds(instance.getExpirationSeconds());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public BoundObjectRefNested<A> editBoundObjectRef() {
    return this.withNewBoundObjectRefLike(Optional.ofNullable(this.buildBoundObjectRef()).orElse(null));
  }
  
  public BoundObjectRefNested<A> editOrNewBoundObjectRef() {
    return this.withNewBoundObjectRefLike(Optional.ofNullable(this.buildBoundObjectRef()).orElse(new BoundObjectReferenceBuilder().build()));
  }
  
  public BoundObjectRefNested<A> editOrNewBoundObjectRefLike(BoundObjectReference item) {
    return this.withNewBoundObjectRefLike(Optional.ofNullable(this.buildBoundObjectRef()).orElse(item));
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
    TokenRequestSpecFluent that = (TokenRequestSpecFluent) o;
    if (!(Objects.equals(audiences, that.audiences))) {
      return false;
    }
    if (!(Objects.equals(boundObjectRef, that.boundObjectRef))) {
      return false;
    }
    if (!(Objects.equals(expirationSeconds, that.expirationSeconds))) {
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
  
  public String getAudience(int index) {
    return this.audiences.get(index);
  }
  
  public List<String> getAudiences() {
    return this.audiences;
  }
  
  public Long getExpirationSeconds() {
    return this.expirationSeconds;
  }
  
  public String getFirstAudience() {
    return this.audiences.get(0);
  }
  
  public String getLastAudience() {
    return this.audiences.get(audiences.size() - 1);
  }
  
  public String getMatchingAudience(Predicate<String> predicate) {
      for (String item : audiences) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAudiences() {
    return this.audiences != null && !(this.audiences.isEmpty());
  }
  
  public boolean hasBoundObjectRef() {
    return this.boundObjectRef != null;
  }
  
  public boolean hasExpirationSeconds() {
    return this.expirationSeconds != null;
  }
  
  public boolean hasMatchingAudience(Predicate<String> predicate) {
      for (String item : audiences) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(audiences, boundObjectRef, expirationSeconds, additionalProperties);
  }
  
  public A removeAllFromAudiences(Collection<String> items) {
    if (this.audiences == null) {
      return (A) this;
    }
    for (String item : items) {
      this.audiences.remove(item);
    }
    return (A) this;
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
  
  public A removeFromAudiences(String... items) {
    if (this.audiences == null) {
      return (A) this;
    }
    for (String item : items) {
      this.audiences.remove(item);
    }
    return (A) this;
  }
  
  public A setToAudiences(int index,String item) {
    if (this.audiences == null) {
      this.audiences = new ArrayList();
    }
    this.audiences.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(audiences == null) && !(audiences.isEmpty())) {
        sb.append("audiences:");
        sb.append(audiences);
        sb.append(",");
    }
    if (!(boundObjectRef == null)) {
        sb.append("boundObjectRef:");
        sb.append(boundObjectRef);
        sb.append(",");
    }
    if (!(expirationSeconds == null)) {
        sb.append("expirationSeconds:");
        sb.append(expirationSeconds);
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
  
  public A withAudiences(List<String> audiences) {
    if (audiences != null) {
        this.audiences = new ArrayList();
        for (String item : audiences) {
          this.addToAudiences(item);
        }
    } else {
      this.audiences = null;
    }
    return (A) this;
  }
  
  public A withAudiences(String... audiences) {
    if (this.audiences != null) {
        this.audiences.clear();
        _visitables.remove("audiences");
    }
    if (audiences != null) {
      for (String item : audiences) {
        this.addToAudiences(item);
      }
    }
    return (A) this;
  }
  
  public A withBoundObjectRef(BoundObjectReference boundObjectRef) {
    this._visitables.remove("boundObjectRef");
    if (boundObjectRef != null) {
        this.boundObjectRef = new BoundObjectReferenceBuilder(boundObjectRef);
        this._visitables.get("boundObjectRef").add(this.boundObjectRef);
    } else {
        this.boundObjectRef = null;
        this._visitables.get("boundObjectRef").remove(this.boundObjectRef);
    }
    return (A) this;
  }
  
  public A withExpirationSeconds(Long expirationSeconds) {
    this.expirationSeconds = expirationSeconds;
    return (A) this;
  }
  
  public BoundObjectRefNested<A> withNewBoundObjectRef() {
    return new BoundObjectRefNested(null);
  }
  
  public A withNewBoundObjectRef(String apiVersion,String kind,String name,String uid) {
    return (A) this.withBoundObjectRef(new BoundObjectReference(apiVersion, kind, name, uid));
  }
  
  public BoundObjectRefNested<A> withNewBoundObjectRefLike(BoundObjectReference item) {
    return new BoundObjectRefNested(item);
  }
  public class BoundObjectRefNested<N> extends BoundObjectReferenceFluent<BoundObjectRefNested<N>> implements Nested<N>{
  
    BoundObjectReferenceBuilder builder;
  
    BoundObjectRefNested(BoundObjectReference item) {
      this.builder = new BoundObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) TokenRequestSpecFluent.this.withBoundObjectRef(builder.build());
    }
    
    public N endBoundObjectRef() {
      return and();
    }
    
  }
}