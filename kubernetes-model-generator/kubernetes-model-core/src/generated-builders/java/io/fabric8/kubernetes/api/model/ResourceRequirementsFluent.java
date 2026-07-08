package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ResourceRequirementsFluent<A extends io.fabric8.kubernetes.api.model.ResourceRequirementsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<ResourceClaimBuilder> claims = new ArrayList<ResourceClaimBuilder>();
  private Map<String,Quantity> limits;
  private Map<String,Quantity> requests;

  public ResourceRequirementsFluent() {
  }
  
  public ResourceRequirementsFluent(ResourceRequirements instance) {
    this.copyInstance(instance);
  }

  public A addAllToClaims(Collection<ResourceClaim> items) {
    if (this.claims == null) {
      this.claims = new ArrayList();
    }
    for (ResourceClaim item : items) {
        ResourceClaimBuilder builder = new ResourceClaimBuilder(item);
        _visitables.get("claims").add(builder);
        this.claims.add(builder);
    }
    return (A) this;
  }
  
  public ClaimsNested<A> addNewClaim() {
    return new ClaimsNested(-1, null);
  }
  
  public A addNewClaim(String name,String request) {
    return (A) this.addToClaims(new ResourceClaim(name, request));
  }
  
  public ClaimsNested<A> addNewClaimLike(ResourceClaim item) {
    return new ClaimsNested(-1, item);
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
  
  public A addToClaims(ResourceClaim... items) {
    if (this.claims == null) {
      this.claims = new ArrayList();
    }
    for (ResourceClaim item : items) {
        ResourceClaimBuilder builder = new ResourceClaimBuilder(item);
        _visitables.get("claims").add(builder);
        this.claims.add(builder);
    }
    return (A) this;
  }
  
  public A addToClaims(int index,ResourceClaim item) {
    if (this.claims == null) {
      this.claims = new ArrayList();
    }
    ResourceClaimBuilder builder = new ResourceClaimBuilder(item);
    if (index < 0 || index >= claims.size()) {
        _visitables.get("claims").add(builder);
        claims.add(builder);
    } else {
        _visitables.get("claims").add(builder);
        claims.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToLimits(Map<String,Quantity> map) {
    if (this.limits == null && map != null) {
      this.limits = new LinkedHashMap();
    }
    if (map != null) {
      this.limits.putAll(map);
    }
    return (A) this;
  }
  
  public A addToLimits(String key,Quantity value) {
    if (this.limits == null && key != null && value != null) {
      this.limits = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.limits.put(key, value);
    }
    return (A) this;
  }
  
  public A addToRequests(Map<String,Quantity> map) {
    if (this.requests == null && map != null) {
      this.requests = new LinkedHashMap();
    }
    if (map != null) {
      this.requests.putAll(map);
    }
    return (A) this;
  }
  
  public A addToRequests(String key,Quantity value) {
    if (this.requests == null && key != null && value != null) {
      this.requests = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.requests.put(key, value);
    }
    return (A) this;
  }
  
  public ResourceClaim buildClaim(int index) {
    return this.claims.get(index).build();
  }
  
  public List<ResourceClaim> buildClaims() {
    return this.claims != null ? build(claims) : null;
  }
  
  public ResourceClaim buildFirstClaim() {
    return this.claims.get(0).build();
  }
  
  public ResourceClaim buildLastClaim() {
    return this.claims.get(claims.size() - 1).build();
  }
  
  public ResourceClaim buildMatchingClaim(Predicate<ResourceClaimBuilder> predicate) {
      for (ResourceClaimBuilder item : claims) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(ResourceRequirements instance) {
    instance = instance != null ? instance : new ResourceRequirements();
    if (instance != null) {
        this.withClaims(instance.getClaims());
        this.withLimits(instance.getLimits());
        this.withRequests(instance.getRequests());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ClaimsNested<A> editClaim(int index) {
    if (claims.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "claims"));
    }
    return this.setNewClaimLike(index, this.buildClaim(index));
  }
  
  public ClaimsNested<A> editFirstClaim() {
    if (claims.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "claims"));
    }
    return this.setNewClaimLike(0, this.buildClaim(0));
  }
  
  public ClaimsNested<A> editLastClaim() {
    int index = claims.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "claims"));
    }
    return this.setNewClaimLike(index, this.buildClaim(index));
  }
  
  public ClaimsNested<A> editMatchingClaim(Predicate<ResourceClaimBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < claims.size();i++) {
      if (predicate.test(claims.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "claims"));
    }
    return this.setNewClaimLike(index, this.buildClaim(index));
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
    ResourceRequirementsFluent that = (ResourceRequirementsFluent) o;
    if (!(Objects.equals(claims, that.claims))) {
      return false;
    }
    if (!(Objects.equals(limits, that.limits))) {
      return false;
    }
    if (!(Objects.equals(requests, that.requests))) {
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
  
  public Map<String,Quantity> getLimits() {
    return this.limits;
  }
  
  public Map<String,Quantity> getRequests() {
    return this.requests;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClaims() {
    return this.claims != null && !(this.claims.isEmpty());
  }
  
  public boolean hasLimits() {
    return this.limits != null;
  }
  
  public boolean hasMatchingClaim(Predicate<ResourceClaimBuilder> predicate) {
      for (ResourceClaimBuilder item : claims) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasRequests() {
    return this.requests != null;
  }
  
  public int hashCode() {
    return Objects.hash(claims, limits, requests, additionalProperties);
  }
  
  public A removeAllFromClaims(Collection<ResourceClaim> items) {
    if (this.claims == null) {
      return (A) this;
    }
    for (ResourceClaim item : items) {
        ResourceClaimBuilder builder = new ResourceClaimBuilder(item);
        _visitables.get("claims").remove(builder);
        this.claims.remove(builder);
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
  
  public A removeFromClaims(ResourceClaim... items) {
    if (this.claims == null) {
      return (A) this;
    }
    for (ResourceClaim item : items) {
        ResourceClaimBuilder builder = new ResourceClaimBuilder(item);
        _visitables.get("claims").remove(builder);
        this.claims.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromLimits(String key) {
    if (this.limits == null) {
      return (A) this;
    }
    if (key != null && this.limits != null) {
      this.limits.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromLimits(Map<String,Quantity> map) {
    if (this.limits == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.limits != null) {
          this.limits.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromRequests(String key) {
    if (this.requests == null) {
      return (A) this;
    }
    if (key != null && this.requests != null) {
      this.requests.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromRequests(Map<String,Quantity> map) {
    if (this.requests == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.requests != null) {
          this.requests.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeMatchingFromClaims(Predicate<ResourceClaimBuilder> predicate) {
    if (claims == null) {
      return (A) this;
    }
    Iterator<ResourceClaimBuilder> each = claims.iterator();
    List visitables = _visitables.get("claims");
    while (each.hasNext()) {
        ResourceClaimBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ClaimsNested<A> setNewClaimLike(int index,ResourceClaim item) {
    return new ClaimsNested(index, item);
  }
  
  public A setToClaims(int index,ResourceClaim item) {
    if (this.claims == null) {
      this.claims = new ArrayList();
    }
    ResourceClaimBuilder builder = new ResourceClaimBuilder(item);
    if (index < 0 || index >= claims.size()) {
        _visitables.get("claims").add(builder);
        claims.add(builder);
    } else {
        _visitables.get("claims").add(builder);
        claims.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(claims == null) && !(claims.isEmpty())) {
        sb.append("claims:");
        sb.append(claims);
        sb.append(",");
    }
    if (!(limits == null) && !(limits.isEmpty())) {
        sb.append("limits:");
        sb.append(limits);
        sb.append(",");
    }
    if (!(requests == null) && !(requests.isEmpty())) {
        sb.append("requests:");
        sb.append(requests);
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
  
  public A withClaims(List<ResourceClaim> claims) {
    if (this.claims != null) {
      this._visitables.get("claims").clear();
    }
    if (claims != null) {
        this.claims = new ArrayList();
        for (ResourceClaim item : claims) {
          this.addToClaims(item);
        }
    } else {
      this.claims = null;
    }
    return (A) this;
  }
  
  public A withClaims(ResourceClaim... claims) {
    if (this.claims != null) {
        this.claims.clear();
        _visitables.remove("claims");
    }
    if (claims != null) {
      for (ResourceClaim item : claims) {
        this.addToClaims(item);
      }
    }
    return (A) this;
  }
  
  public <K,V>A withLimits(Map<String,Quantity> limits) {
    if (limits == null) {
      this.limits = null;
    } else {
      this.limits = new LinkedHashMap(limits);
    }
    return (A) this;
  }
  
  public <K,V>A withRequests(Map<String,Quantity> requests) {
    if (requests == null) {
      this.requests = null;
    } else {
      this.requests = new LinkedHashMap(requests);
    }
    return (A) this;
  }
  public class ClaimsNested<N> extends ResourceClaimFluent<ClaimsNested<N>> implements Nested<N>{
  
    ResourceClaimBuilder builder;
    int index;
  
    ClaimsNested(int index,ResourceClaim item) {
      this.index = index;
      this.builder = new ResourceClaimBuilder(this, item);
    }
  
    public N and() {
      return (N) ResourceRequirementsFluent.this.setToClaims(index, builder.build());
    }
    
    public N endClaim() {
      return and();
    }
    
  }
}