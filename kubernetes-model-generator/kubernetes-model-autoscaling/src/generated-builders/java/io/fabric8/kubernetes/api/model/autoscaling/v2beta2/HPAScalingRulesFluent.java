package io.fabric8.kubernetes.api.model.autoscaling.v2beta2;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
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
public class HPAScalingRulesFluent<A extends io.fabric8.kubernetes.api.model.autoscaling.v2beta2.HPAScalingRulesFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<HPAScalingPolicyBuilder> policies = new ArrayList<HPAScalingPolicyBuilder>();
  private String selectPolicy;
  private Integer stabilizationWindowSeconds;

  public HPAScalingRulesFluent() {
  }
  
  public HPAScalingRulesFluent(HPAScalingRules instance) {
    this.copyInstance(instance);
  }

  public A addAllToPolicies(Collection<HPAScalingPolicy> items) {
    if (this.policies == null) {
      this.policies = new ArrayList();
    }
    for (HPAScalingPolicy item : items) {
        HPAScalingPolicyBuilder builder = new HPAScalingPolicyBuilder(item);
        _visitables.get("policies").add(builder);
        this.policies.add(builder);
    }
    return (A) this;
  }
  
  public PoliciesNested<A> addNewPolicy() {
    return new PoliciesNested(-1, null);
  }
  
  public A addNewPolicy(Integer periodSeconds,String type,Integer value) {
    return (A) this.addToPolicies(new HPAScalingPolicy(periodSeconds, type, value));
  }
  
  public PoliciesNested<A> addNewPolicyLike(HPAScalingPolicy item) {
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
  
  public A addToPolicies(HPAScalingPolicy... items) {
    if (this.policies == null) {
      this.policies = new ArrayList();
    }
    for (HPAScalingPolicy item : items) {
        HPAScalingPolicyBuilder builder = new HPAScalingPolicyBuilder(item);
        _visitables.get("policies").add(builder);
        this.policies.add(builder);
    }
    return (A) this;
  }
  
  public A addToPolicies(int index,HPAScalingPolicy item) {
    if (this.policies == null) {
      this.policies = new ArrayList();
    }
    HPAScalingPolicyBuilder builder = new HPAScalingPolicyBuilder(item);
    if (index < 0 || index >= policies.size()) {
        _visitables.get("policies").add(builder);
        policies.add(builder);
    } else {
        _visitables.get("policies").add(builder);
        policies.add(index, builder);
    }
    return (A) this;
  }
  
  public HPAScalingPolicy buildFirstPolicy() {
    return this.policies.get(0).build();
  }
  
  public HPAScalingPolicy buildLastPolicy() {
    return this.policies.get(policies.size() - 1).build();
  }
  
  public HPAScalingPolicy buildMatchingPolicy(Predicate<HPAScalingPolicyBuilder> predicate) {
      for (HPAScalingPolicyBuilder item : policies) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public List<HPAScalingPolicy> buildPolicies() {
    return this.policies != null ? build(policies) : null;
  }
  
  public HPAScalingPolicy buildPolicy(int index) {
    return this.policies.get(index).build();
  }
  
  protected void copyInstance(HPAScalingRules instance) {
    instance = instance != null ? instance : new HPAScalingRules();
    if (instance != null) {
        this.withPolicies(instance.getPolicies());
        this.withSelectPolicy(instance.getSelectPolicy());
        this.withStabilizationWindowSeconds(instance.getStabilizationWindowSeconds());
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
  
  public PoliciesNested<A> editMatchingPolicy(Predicate<HPAScalingPolicyBuilder> predicate) {
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
    HPAScalingRulesFluent that = (HPAScalingRulesFluent) o;
    if (!(Objects.equals(policies, that.policies))) {
      return false;
    }
    if (!(Objects.equals(selectPolicy, that.selectPolicy))) {
      return false;
    }
    if (!(Objects.equals(stabilizationWindowSeconds, that.stabilizationWindowSeconds))) {
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
  
  public String getSelectPolicy() {
    return this.selectPolicy;
  }
  
  public Integer getStabilizationWindowSeconds() {
    return this.stabilizationWindowSeconds;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingPolicy(Predicate<HPAScalingPolicyBuilder> predicate) {
      for (HPAScalingPolicyBuilder item : policies) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPolicies() {
    return this.policies != null && !(this.policies.isEmpty());
  }
  
  public boolean hasSelectPolicy() {
    return this.selectPolicy != null;
  }
  
  public boolean hasStabilizationWindowSeconds() {
    return this.stabilizationWindowSeconds != null;
  }
  
  public int hashCode() {
    return Objects.hash(policies, selectPolicy, stabilizationWindowSeconds, additionalProperties);
  }
  
  public A removeAllFromPolicies(Collection<HPAScalingPolicy> items) {
    if (this.policies == null) {
      return (A) this;
    }
    for (HPAScalingPolicy item : items) {
        HPAScalingPolicyBuilder builder = new HPAScalingPolicyBuilder(item);
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
  
  public A removeFromPolicies(HPAScalingPolicy... items) {
    if (this.policies == null) {
      return (A) this;
    }
    for (HPAScalingPolicy item : items) {
        HPAScalingPolicyBuilder builder = new HPAScalingPolicyBuilder(item);
        _visitables.get("policies").remove(builder);
        this.policies.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromPolicies(Predicate<HPAScalingPolicyBuilder> predicate) {
    if (policies == null) {
      return (A) this;
    }
    Iterator<HPAScalingPolicyBuilder> each = policies.iterator();
    List visitables = _visitables.get("policies");
    while (each.hasNext()) {
        HPAScalingPolicyBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public PoliciesNested<A> setNewPolicyLike(int index,HPAScalingPolicy item) {
    return new PoliciesNested(index, item);
  }
  
  public A setToPolicies(int index,HPAScalingPolicy item) {
    if (this.policies == null) {
      this.policies = new ArrayList();
    }
    HPAScalingPolicyBuilder builder = new HPAScalingPolicyBuilder(item);
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
    if (!(selectPolicy == null)) {
        sb.append("selectPolicy:");
        sb.append(selectPolicy);
        sb.append(",");
    }
    if (!(stabilizationWindowSeconds == null)) {
        sb.append("stabilizationWindowSeconds:");
        sb.append(stabilizationWindowSeconds);
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
  
  public A withPolicies(List<HPAScalingPolicy> policies) {
    if (this.policies != null) {
      this._visitables.get("policies").clear();
    }
    if (policies != null) {
        this.policies = new ArrayList();
        for (HPAScalingPolicy item : policies) {
          this.addToPolicies(item);
        }
    } else {
      this.policies = null;
    }
    return (A) this;
  }
  
  public A withPolicies(HPAScalingPolicy... policies) {
    if (this.policies != null) {
        this.policies.clear();
        _visitables.remove("policies");
    }
    if (policies != null) {
      for (HPAScalingPolicy item : policies) {
        this.addToPolicies(item);
      }
    }
    return (A) this;
  }
  
  public A withSelectPolicy(String selectPolicy) {
    this.selectPolicy = selectPolicy;
    return (A) this;
  }
  
  public A withStabilizationWindowSeconds(Integer stabilizationWindowSeconds) {
    this.stabilizationWindowSeconds = stabilizationWindowSeconds;
    return (A) this;
  }
  public class PoliciesNested<N> extends HPAScalingPolicyFluent<PoliciesNested<N>> implements Nested<N>{
  
    HPAScalingPolicyBuilder builder;
    int index;
  
    PoliciesNested(int index,HPAScalingPolicy item) {
      this.index = index;
      this.builder = new HPAScalingPolicyBuilder(this, item);
    }
  
    public N and() {
      return (N) HPAScalingRulesFluent.this.setToPolicies(index, builder.build());
    }
    
    public N endPolicy() {
      return and();
    }
    
  }
}