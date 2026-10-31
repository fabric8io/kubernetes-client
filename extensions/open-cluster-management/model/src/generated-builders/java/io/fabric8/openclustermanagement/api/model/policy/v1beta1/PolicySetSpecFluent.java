package io.fabric8.openclustermanagement.api.model.policy.v1beta1;

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
public class PolicySetSpecFluent<A extends io.fabric8.openclustermanagement.api.model.policy.v1beta1.PolicySetSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String description;
  private ArrayList<PolicySetExclusionBuilder> exclusions = new ArrayList<PolicySetExclusionBuilder>();
  private List<String> policies = new ArrayList<String>();

  public PolicySetSpecFluent() {
  }
  
  public PolicySetSpecFluent(PolicySetSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToExclusions(Collection<PolicySetExclusion> items) {
    if (this.exclusions == null) {
      this.exclusions = new ArrayList();
    }
    for (PolicySetExclusion item : items) {
        PolicySetExclusionBuilder builder = new PolicySetExclusionBuilder(item);
        _visitables.get("exclusions").add(builder);
        this.exclusions.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToPolicies(Collection<String> items) {
    if (this.policies == null) {
      this.policies = new ArrayList();
    }
    for (String item : items) {
      this.policies.add(item);
    }
    return (A) this;
  }
  
  public ExclusionsNested<A> addNewExclusion() {
    return new ExclusionsNested(-1, null);
  }
  
  public ExclusionsNested<A> addNewExclusionLike(PolicySetExclusion item) {
    return new ExclusionsNested(-1, item);
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
  
  public A addToExclusions(PolicySetExclusion... items) {
    if (this.exclusions == null) {
      this.exclusions = new ArrayList();
    }
    for (PolicySetExclusion item : items) {
        PolicySetExclusionBuilder builder = new PolicySetExclusionBuilder(item);
        _visitables.get("exclusions").add(builder);
        this.exclusions.add(builder);
    }
    return (A) this;
  }
  
  public A addToExclusions(int index,PolicySetExclusion item) {
    if (this.exclusions == null) {
      this.exclusions = new ArrayList();
    }
    PolicySetExclusionBuilder builder = new PolicySetExclusionBuilder(item);
    if (index < 0 || index >= exclusions.size()) {
        _visitables.get("exclusions").add(builder);
        exclusions.add(builder);
    } else {
        _visitables.get("exclusions").add(builder);
        exclusions.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToPolicies(String... items) {
    if (this.policies == null) {
      this.policies = new ArrayList();
    }
    for (String item : items) {
      this.policies.add(item);
    }
    return (A) this;
  }
  
  public A addToPolicies(int index,String item) {
    if (this.policies == null) {
      this.policies = new ArrayList();
    }
    this.policies.add(index, item);
    return (A) this;
  }
  
  public PolicySetExclusion buildExclusion(int index) {
    return this.exclusions.get(index).build();
  }
  
  public List<PolicySetExclusion> buildExclusions() {
    return this.exclusions != null ? build(exclusions) : null;
  }
  
  public PolicySetExclusion buildFirstExclusion() {
    return this.exclusions.get(0).build();
  }
  
  public PolicySetExclusion buildLastExclusion() {
    return this.exclusions.get(exclusions.size() - 1).build();
  }
  
  public PolicySetExclusion buildMatchingExclusion(Predicate<PolicySetExclusionBuilder> predicate) {
      for (PolicySetExclusionBuilder item : exclusions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(PolicySetSpec instance) {
    instance = instance != null ? instance : new PolicySetSpec();
    if (instance != null) {
        this.withDescription(instance.getDescription());
        this.withExclusions(instance.getExclusions());
        this.withPolicies(instance.getPolicies());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ExclusionsNested<A> editExclusion(int index) {
    if (exclusions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "exclusions"));
    }
    return this.setNewExclusionLike(index, this.buildExclusion(index));
  }
  
  public ExclusionsNested<A> editFirstExclusion() {
    if (exclusions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "exclusions"));
    }
    return this.setNewExclusionLike(0, this.buildExclusion(0));
  }
  
  public ExclusionsNested<A> editLastExclusion() {
    int index = exclusions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "exclusions"));
    }
    return this.setNewExclusionLike(index, this.buildExclusion(index));
  }
  
  public ExclusionsNested<A> editMatchingExclusion(Predicate<PolicySetExclusionBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < exclusions.size();i++) {
      if (predicate.test(exclusions.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "exclusions"));
    }
    return this.setNewExclusionLike(index, this.buildExclusion(index));
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
    PolicySetSpecFluent that = (PolicySetSpecFluent) o;
    if (!(Objects.equals(description, that.description))) {
      return false;
    }
    if (!(Objects.equals(exclusions, that.exclusions))) {
      return false;
    }
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
  
  public String getDescription() {
    return this.description;
  }
  
  public String getFirstPolicy() {
    return this.policies.get(0);
  }
  
  public String getLastPolicy() {
    return this.policies.get(policies.size() - 1);
  }
  
  public String getMatchingPolicy(Predicate<String> predicate) {
      for (String item : policies) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public List<String> getPolicies() {
    return this.policies;
  }
  
  public String getPolicy(int index) {
    return this.policies.get(index);
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDescription() {
    return this.description != null;
  }
  
  public boolean hasExclusions() {
    return this.exclusions != null && !(this.exclusions.isEmpty());
  }
  
  public boolean hasMatchingExclusion(Predicate<PolicySetExclusionBuilder> predicate) {
      for (PolicySetExclusionBuilder item : exclusions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingPolicy(Predicate<String> predicate) {
      for (String item : policies) {
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
    return Objects.hash(description, exclusions, policies, additionalProperties);
  }
  
  public A removeAllFromExclusions(Collection<PolicySetExclusion> items) {
    if (this.exclusions == null) {
      return (A) this;
    }
    for (PolicySetExclusion item : items) {
        PolicySetExclusionBuilder builder = new PolicySetExclusionBuilder(item);
        _visitables.get("exclusions").remove(builder);
        this.exclusions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromPolicies(Collection<String> items) {
    if (this.policies == null) {
      return (A) this;
    }
    for (String item : items) {
      this.policies.remove(item);
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
  
  public A removeFromExclusions(PolicySetExclusion... items) {
    if (this.exclusions == null) {
      return (A) this;
    }
    for (PolicySetExclusion item : items) {
        PolicySetExclusionBuilder builder = new PolicySetExclusionBuilder(item);
        _visitables.get("exclusions").remove(builder);
        this.exclusions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromPolicies(String... items) {
    if (this.policies == null) {
      return (A) this;
    }
    for (String item : items) {
      this.policies.remove(item);
    }
    return (A) this;
  }
  
  public A removeMatchingFromExclusions(Predicate<PolicySetExclusionBuilder> predicate) {
    if (exclusions == null) {
      return (A) this;
    }
    Iterator<PolicySetExclusionBuilder> each = exclusions.iterator();
    List visitables = _visitables.get("exclusions");
    while (each.hasNext()) {
        PolicySetExclusionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ExclusionsNested<A> setNewExclusionLike(int index,PolicySetExclusion item) {
    return new ExclusionsNested(index, item);
  }
  
  public A setToExclusions(int index,PolicySetExclusion item) {
    if (this.exclusions == null) {
      this.exclusions = new ArrayList();
    }
    PolicySetExclusionBuilder builder = new PolicySetExclusionBuilder(item);
    if (index < 0 || index >= exclusions.size()) {
        _visitables.get("exclusions").add(builder);
        exclusions.add(builder);
    } else {
        _visitables.get("exclusions").add(builder);
        exclusions.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToPolicies(int index,String item) {
    if (this.policies == null) {
      this.policies = new ArrayList();
    }
    this.policies.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(description == null)) {
        sb.append("description:");
        sb.append(description);
        sb.append(",");
    }
    if (!(exclusions == null) && !(exclusions.isEmpty())) {
        sb.append("exclusions:");
        sb.append(exclusions);
        sb.append(",");
    }
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
  
  public A withDescription(String description) {
    this.description = description;
    return (A) this;
  }
  
  public A withExclusions(List<PolicySetExclusion> exclusions) {
    if (this.exclusions != null) {
      this._visitables.get("exclusions").clear();
    }
    if (exclusions != null) {
        this.exclusions = new ArrayList();
        for (PolicySetExclusion item : exclusions) {
          this.addToExclusions(item);
        }
    } else {
      this.exclusions = null;
    }
    return (A) this;
  }
  
  public A withExclusions(PolicySetExclusion... exclusions) {
    if (this.exclusions != null) {
        this.exclusions.clear();
        _visitables.remove("exclusions");
    }
    if (exclusions != null) {
      for (PolicySetExclusion item : exclusions) {
        this.addToExclusions(item);
      }
    }
    return (A) this;
  }
  
  public A withPolicies(List<String> policies) {
    if (policies != null) {
        this.policies = new ArrayList();
        for (String item : policies) {
          this.addToPolicies(item);
        }
    } else {
      this.policies = null;
    }
    return (A) this;
  }
  
  public A withPolicies(String... policies) {
    if (this.policies != null) {
        this.policies.clear();
        _visitables.remove("policies");
    }
    if (policies != null) {
      for (String item : policies) {
        this.addToPolicies(item);
      }
    }
    return (A) this;
  }
  public class ExclusionsNested<N> extends PolicySetExclusionFluent<ExclusionsNested<N>> implements Nested<N>{
  
    PolicySetExclusionBuilder builder;
    int index;
  
    ExclusionsNested(int index,PolicySetExclusion item) {
      this.index = index;
      this.builder = new PolicySetExclusionBuilder(this, item);
    }
  
    public N and() {
      return (N) PolicySetSpecFluent.this.setToExclusions(index, builder.build());
    }
    
    public N endExclusion() {
      return and();
    }
    
  }
}