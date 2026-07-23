package io.fabric8.kubernetes.api.model.gatewayapi.v1;

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
public class PolicyStatusFluent<A extends io.fabric8.kubernetes.api.model.gatewayapi.v1.PolicyStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<PolicyAncestorStatusBuilder> ancestors = new ArrayList<PolicyAncestorStatusBuilder>();

  public PolicyStatusFluent() {
  }
  
  public PolicyStatusFluent(PolicyStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToAncestors(Collection<PolicyAncestorStatus> items) {
    if (this.ancestors == null) {
      this.ancestors = new ArrayList();
    }
    for (PolicyAncestorStatus item : items) {
        PolicyAncestorStatusBuilder builder = new PolicyAncestorStatusBuilder(item);
        _visitables.get("ancestors").add(builder);
        this.ancestors.add(builder);
    }
    return (A) this;
  }
  
  public AncestorsNested<A> addNewAncestor() {
    return new AncestorsNested(-1, null);
  }
  
  public AncestorsNested<A> addNewAncestorLike(PolicyAncestorStatus item) {
    return new AncestorsNested(-1, item);
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
  
  public A addToAncestors(PolicyAncestorStatus... items) {
    if (this.ancestors == null) {
      this.ancestors = new ArrayList();
    }
    for (PolicyAncestorStatus item : items) {
        PolicyAncestorStatusBuilder builder = new PolicyAncestorStatusBuilder(item);
        _visitables.get("ancestors").add(builder);
        this.ancestors.add(builder);
    }
    return (A) this;
  }
  
  public A addToAncestors(int index,PolicyAncestorStatus item) {
    if (this.ancestors == null) {
      this.ancestors = new ArrayList();
    }
    PolicyAncestorStatusBuilder builder = new PolicyAncestorStatusBuilder(item);
    if (index < 0 || index >= ancestors.size()) {
        _visitables.get("ancestors").add(builder);
        ancestors.add(builder);
    } else {
        _visitables.get("ancestors").add(builder);
        ancestors.add(index, builder);
    }
    return (A) this;
  }
  
  public PolicyAncestorStatus buildAncestor(int index) {
    return this.ancestors.get(index).build();
  }
  
  public List<PolicyAncestorStatus> buildAncestors() {
    return this.ancestors != null ? build(ancestors) : null;
  }
  
  public PolicyAncestorStatus buildFirstAncestor() {
    return this.ancestors.get(0).build();
  }
  
  public PolicyAncestorStatus buildLastAncestor() {
    return this.ancestors.get(ancestors.size() - 1).build();
  }
  
  public PolicyAncestorStatus buildMatchingAncestor(Predicate<PolicyAncestorStatusBuilder> predicate) {
      for (PolicyAncestorStatusBuilder item : ancestors) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(PolicyStatus instance) {
    instance = instance != null ? instance : new PolicyStatus();
    if (instance != null) {
        this.withAncestors(instance.getAncestors());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AncestorsNested<A> editAncestor(int index) {
    if (ancestors.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "ancestors"));
    }
    return this.setNewAncestorLike(index, this.buildAncestor(index));
  }
  
  public AncestorsNested<A> editFirstAncestor() {
    if (ancestors.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "ancestors"));
    }
    return this.setNewAncestorLike(0, this.buildAncestor(0));
  }
  
  public AncestorsNested<A> editLastAncestor() {
    int index = ancestors.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "ancestors"));
    }
    return this.setNewAncestorLike(index, this.buildAncestor(index));
  }
  
  public AncestorsNested<A> editMatchingAncestor(Predicate<PolicyAncestorStatusBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < ancestors.size();i++) {
      if (predicate.test(ancestors.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "ancestors"));
    }
    return this.setNewAncestorLike(index, this.buildAncestor(index));
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
    PolicyStatusFluent that = (PolicyStatusFluent) o;
    if (!(Objects.equals(ancestors, that.ancestors))) {
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
  
  public boolean hasAncestors() {
    return this.ancestors != null && !(this.ancestors.isEmpty());
  }
  
  public boolean hasMatchingAncestor(Predicate<PolicyAncestorStatusBuilder> predicate) {
      for (PolicyAncestorStatusBuilder item : ancestors) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(ancestors, additionalProperties);
  }
  
  public A removeAllFromAncestors(Collection<PolicyAncestorStatus> items) {
    if (this.ancestors == null) {
      return (A) this;
    }
    for (PolicyAncestorStatus item : items) {
        PolicyAncestorStatusBuilder builder = new PolicyAncestorStatusBuilder(item);
        _visitables.get("ancestors").remove(builder);
        this.ancestors.remove(builder);
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
  
  public A removeFromAncestors(PolicyAncestorStatus... items) {
    if (this.ancestors == null) {
      return (A) this;
    }
    for (PolicyAncestorStatus item : items) {
        PolicyAncestorStatusBuilder builder = new PolicyAncestorStatusBuilder(item);
        _visitables.get("ancestors").remove(builder);
        this.ancestors.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromAncestors(Predicate<PolicyAncestorStatusBuilder> predicate) {
    if (ancestors == null) {
      return (A) this;
    }
    Iterator<PolicyAncestorStatusBuilder> each = ancestors.iterator();
    List visitables = _visitables.get("ancestors");
    while (each.hasNext()) {
        PolicyAncestorStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public AncestorsNested<A> setNewAncestorLike(int index,PolicyAncestorStatus item) {
    return new AncestorsNested(index, item);
  }
  
  public A setToAncestors(int index,PolicyAncestorStatus item) {
    if (this.ancestors == null) {
      this.ancestors = new ArrayList();
    }
    PolicyAncestorStatusBuilder builder = new PolicyAncestorStatusBuilder(item);
    if (index < 0 || index >= ancestors.size()) {
        _visitables.get("ancestors").add(builder);
        ancestors.add(builder);
    } else {
        _visitables.get("ancestors").add(builder);
        ancestors.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(ancestors == null) && !(ancestors.isEmpty())) {
        sb.append("ancestors:");
        sb.append(ancestors);
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
  
  public A withAncestors(List<PolicyAncestorStatus> ancestors) {
    if (this.ancestors != null) {
      this._visitables.get("ancestors").clear();
    }
    if (ancestors != null) {
        this.ancestors = new ArrayList();
        for (PolicyAncestorStatus item : ancestors) {
          this.addToAncestors(item);
        }
    } else {
      this.ancestors = null;
    }
    return (A) this;
  }
  
  public A withAncestors(PolicyAncestorStatus... ancestors) {
    if (this.ancestors != null) {
        this.ancestors.clear();
        _visitables.remove("ancestors");
    }
    if (ancestors != null) {
      for (PolicyAncestorStatus item : ancestors) {
        this.addToAncestors(item);
      }
    }
    return (A) this;
  }
  public class AncestorsNested<N> extends PolicyAncestorStatusFluent<AncestorsNested<N>> implements Nested<N>{
  
    PolicyAncestorStatusBuilder builder;
    int index;
  
    AncestorsNested(int index,PolicyAncestorStatus item) {
      this.index = index;
      this.builder = new PolicyAncestorStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) PolicyStatusFluent.this.setToAncestors(index, builder.build());
    }
    
    public N endAncestor() {
      return and();
    }
    
  }
}