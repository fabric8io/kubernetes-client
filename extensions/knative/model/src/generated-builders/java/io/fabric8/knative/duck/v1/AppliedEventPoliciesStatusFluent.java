package io.fabric8.knative.duck.v1;

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
public class AppliedEventPoliciesStatusFluent<A extends io.fabric8.knative.duck.v1.AppliedEventPoliciesStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<AppliedEventPolicyRefBuilder> policies = new ArrayList<AppliedEventPolicyRefBuilder>();

  public AppliedEventPoliciesStatusFluent() {
  }
  
  public AppliedEventPoliciesStatusFluent(AppliedEventPoliciesStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToPolicies(Collection<AppliedEventPolicyRef> items) {
    if (this.policies == null) {
      this.policies = new ArrayList();
    }
    for (AppliedEventPolicyRef item : items) {
        AppliedEventPolicyRefBuilder builder = new AppliedEventPolicyRefBuilder(item);
        _visitables.get("policies").add(builder);
        this.policies.add(builder);
    }
    return (A) this;
  }
  
  public PoliciesNested<A> addNewPolicy() {
    return new PoliciesNested(-1, null);
  }
  
  public A addNewPolicy(String apiVersion,String name) {
    return (A) this.addToPolicies(new AppliedEventPolicyRef(apiVersion, name));
  }
  
  public PoliciesNested<A> addNewPolicyLike(AppliedEventPolicyRef item) {
    return new PoliciesNested(-1, item);
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
  
  public A addToPolicies(AppliedEventPolicyRef... items) {
    if (this.policies == null) {
      this.policies = new ArrayList();
    }
    for (AppliedEventPolicyRef item : items) {
        AppliedEventPolicyRefBuilder builder = new AppliedEventPolicyRefBuilder(item);
        _visitables.get("policies").add(builder);
        this.policies.add(builder);
    }
    return (A) this;
  }
  
  public A addToPolicies(int index,AppliedEventPolicyRef item) {
    if (this.policies == null) {
      this.policies = new ArrayList();
    }
    AppliedEventPolicyRefBuilder builder = new AppliedEventPolicyRefBuilder(item);
    if (index < 0 || index >= policies.size()) {
        _visitables.get("policies").add(builder);
        policies.add(builder);
    } else {
        _visitables.get("policies").add(builder);
        policies.add(index, builder);
    }
    return (A) this;
  }
  
  public AppliedEventPolicyRef buildFirstPolicy() {
    return this.policies.get(0).build();
  }
  
  public AppliedEventPolicyRef buildLastPolicy() {
    return this.policies.get(policies.size() - 1).build();
  }
  
  public AppliedEventPolicyRef buildMatchingPolicy(Predicate<AppliedEventPolicyRefBuilder> predicate) {
      for (AppliedEventPolicyRefBuilder item : policies) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public List<AppliedEventPolicyRef> buildPolicies() {
    return this.policies != null ? build(policies) : null;
  }
  
  public AppliedEventPolicyRef buildPolicy(int index) {
    return this.policies.get(index).build();
  }
  
  protected void copyInstance(AppliedEventPoliciesStatus instance) {
    instance = instance != null ? instance : new AppliedEventPoliciesStatus();
    if (instance != null) {
        this.withPolicies(instance.getPolicies());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PoliciesNested<A> editFirstPolicy() {
    if (policies.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "policies"));
    }
    return this.setNewPolicyLike(0, this.buildPolicy(0));
  }
  
  public PoliciesNested<A> editLastPolicy() {
    int index = policies.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "policies"));
    }
    return this.setNewPolicyLike(index, this.buildPolicy(index));
  }
  
  public PoliciesNested<A> editMatchingPolicy(Predicate<AppliedEventPolicyRefBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < policies.size();i++) {
      if (predicate.test(policies.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "policies"));
    }
    return this.setNewPolicyLike(index, this.buildPolicy(index));
  }
  
  public PoliciesNested<A> editPolicy(int index) {
    if (policies.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "policies"));
    }
    return this.setNewPolicyLike(index, this.buildPolicy(index));
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
    AppliedEventPoliciesStatusFluent that = (AppliedEventPoliciesStatusFluent) o;
    if (!(Objects.equals(policies, that.policies))) {
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
  
  public boolean hasMatchingPolicy(Predicate<AppliedEventPolicyRefBuilder> predicate) {
      for (AppliedEventPolicyRefBuilder item : policies) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPolicies() {
    return this.policies != null && !(this.policies.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(policies, additionalProperties);
  }
  
  public A removeAllFromPolicies(Collection<AppliedEventPolicyRef> items) {
    if (this.policies == null) {
      return (A) this;
    }
    for (AppliedEventPolicyRef item : items) {
        AppliedEventPolicyRefBuilder builder = new AppliedEventPolicyRefBuilder(item);
        _visitables.get("policies").remove(builder);
        this.policies.remove(builder);
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
  
  public A removeFromPolicies(AppliedEventPolicyRef... items) {
    if (this.policies == null) {
      return (A) this;
    }
    for (AppliedEventPolicyRef item : items) {
        AppliedEventPolicyRefBuilder builder = new AppliedEventPolicyRefBuilder(item);
        _visitables.get("policies").remove(builder);
        this.policies.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromPolicies(Predicate<AppliedEventPolicyRefBuilder> predicate) {
    if (policies == null) {
      return (A) this;
    }
    Iterator<AppliedEventPolicyRefBuilder> each = policies.iterator();
    List visitables = _visitables.get("policies");
    while (each.hasNext()) {
        AppliedEventPolicyRefBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public PoliciesNested<A> setNewPolicyLike(int index,AppliedEventPolicyRef item) {
    return new PoliciesNested(index, item);
  }
  
  public A setToPolicies(int index,AppliedEventPolicyRef item) {
    if (this.policies == null) {
      this.policies = new ArrayList();
    }
    AppliedEventPolicyRefBuilder builder = new AppliedEventPolicyRefBuilder(item);
    if (index < 0 || index >= policies.size()) {
        _visitables.get("policies").add(builder);
        policies.add(builder);
    } else {
        _visitables.get("policies").add(builder);
        policies.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(policies == null) && !(policies.isEmpty())) {
        sb.append("policies:");
        sb.append(policies);
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
  
  public A withPolicies(List<AppliedEventPolicyRef> policies) {
    if (this.policies != null) {
      this._visitables.get("policies").clear();
    }
    if (policies != null) {
        this.policies = new ArrayList();
        for (AppliedEventPolicyRef item : policies) {
          this.addToPolicies(item);
        }
    } else {
      this.policies = null;
    }
    return (A) this;
  }
  
  public A withPolicies(AppliedEventPolicyRef... policies) {
    if (this.policies != null) {
        this.policies.clear();
        _visitables.remove("policies");
    }
    if (policies != null) {
      for (AppliedEventPolicyRef item : policies) {
        this.addToPolicies(item);
      }
    }
    return (A) this;
  }
  public class PoliciesNested<N> extends AppliedEventPolicyRefFluent<PoliciesNested<N>> implements Nested<N>{
  
    AppliedEventPolicyRefBuilder builder;
    int index;
  
    PoliciesNested(int index,AppliedEventPolicyRef item) {
      this.index = index;
      this.builder = new AppliedEventPolicyRefBuilder(this, item);
    }
  
    public N and() {
      return (N) AppliedEventPoliciesStatusFluent.this.setToPolicies(index, builder.build());
    }
    
    public N endPolicy() {
      return and();
    }
    
  }
}