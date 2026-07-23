package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Condition;
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
public class FeatureGateStatusFluent<A extends io.fabric8.openshift.api.model.config.v1.FeatureGateStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<Condition> conditions = new ArrayList<Condition>();
  private ArrayList<FeatureGateDetailsBuilder> featureGates = new ArrayList<FeatureGateDetailsBuilder>();

  public FeatureGateStatusFluent() {
  }
  
  public FeatureGateStatusFluent(FeatureGateStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
      this.conditions.add(item);
    }
    return (A) this;
  }
  
  public A addAllToFeatureGates(Collection<FeatureGateDetails> items) {
    if (this.featureGates == null) {
      this.featureGates = new ArrayList();
    }
    for (FeatureGateDetails item : items) {
        FeatureGateDetailsBuilder builder = new FeatureGateDetailsBuilder(item);
        _visitables.get("featureGates").add(builder);
        this.featureGates.add(builder);
    }
    return (A) this;
  }
  
  public FeatureGatesNested<A> addNewFeatureGate() {
    return new FeatureGatesNested(-1, null);
  }
  
  public FeatureGatesNested<A> addNewFeatureGateLike(FeatureGateDetails item) {
    return new FeatureGatesNested(-1, item);
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
  
  public A addToConditions(Condition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
      this.conditions.add(item);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.add(index, item);
    return (A) this;
  }
  
  public A addToFeatureGates(FeatureGateDetails... items) {
    if (this.featureGates == null) {
      this.featureGates = new ArrayList();
    }
    for (FeatureGateDetails item : items) {
        FeatureGateDetailsBuilder builder = new FeatureGateDetailsBuilder(item);
        _visitables.get("featureGates").add(builder);
        this.featureGates.add(builder);
    }
    return (A) this;
  }
  
  public A addToFeatureGates(int index,FeatureGateDetails item) {
    if (this.featureGates == null) {
      this.featureGates = new ArrayList();
    }
    FeatureGateDetailsBuilder builder = new FeatureGateDetailsBuilder(item);
    if (index < 0 || index >= featureGates.size()) {
        _visitables.get("featureGates").add(builder);
        featureGates.add(builder);
    } else {
        _visitables.get("featureGates").add(builder);
        featureGates.add(index, builder);
    }
    return (A) this;
  }
  
  public FeatureGateDetails buildFeatureGate(int index) {
    return this.featureGates.get(index).build();
  }
  
  public List<FeatureGateDetails> buildFeatureGates() {
    return this.featureGates != null ? build(featureGates) : null;
  }
  
  public FeatureGateDetails buildFirstFeatureGate() {
    return this.featureGates.get(0).build();
  }
  
  public FeatureGateDetails buildLastFeatureGate() {
    return this.featureGates.get(featureGates.size() - 1).build();
  }
  
  public FeatureGateDetails buildMatchingFeatureGate(Predicate<FeatureGateDetailsBuilder> predicate) {
      for (FeatureGateDetailsBuilder item : featureGates) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(FeatureGateStatus instance) {
    instance = instance != null ? instance : new FeatureGateStatus();
    if (instance != null) {
        this.withConditions(instance.getConditions());
        this.withFeatureGates(instance.getFeatureGates());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public FeatureGatesNested<A> editFeatureGate(int index) {
    if (featureGates.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "featureGates"));
    }
    return this.setNewFeatureGateLike(index, this.buildFeatureGate(index));
  }
  
  public FeatureGatesNested<A> editFirstFeatureGate() {
    if (featureGates.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "featureGates"));
    }
    return this.setNewFeatureGateLike(0, this.buildFeatureGate(0));
  }
  
  public FeatureGatesNested<A> editLastFeatureGate() {
    int index = featureGates.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "featureGates"));
    }
    return this.setNewFeatureGateLike(index, this.buildFeatureGate(index));
  }
  
  public FeatureGatesNested<A> editMatchingFeatureGate(Predicate<FeatureGateDetailsBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < featureGates.size();i++) {
      if (predicate.test(featureGates.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "featureGates"));
    }
    return this.setNewFeatureGateLike(index, this.buildFeatureGate(index));
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
    FeatureGateStatusFluent that = (FeatureGateStatusFluent) o;
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(featureGates, that.featureGates))) {
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
  
  public Condition getCondition(int index) {
    return this.conditions.get(index);
  }
  
  public List<Condition> getConditions() {
    return this.conditions;
  }
  
  public Condition getFirstCondition() {
    return this.conditions.get(0);
  }
  
  public Condition getLastCondition() {
    return this.conditions.get(conditions.size() - 1);
  }
  
  public Condition getMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasFeatureGates() {
    return this.featureGates != null && !(this.featureGates.isEmpty());
  }
  
  public boolean hasMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingFeatureGate(Predicate<FeatureGateDetailsBuilder> predicate) {
      for (FeatureGateDetailsBuilder item : featureGates) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(conditions, featureGates, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
      this.conditions.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromFeatureGates(Collection<FeatureGateDetails> items) {
    if (this.featureGates == null) {
      return (A) this;
    }
    for (FeatureGateDetails item : items) {
        FeatureGateDetailsBuilder builder = new FeatureGateDetailsBuilder(item);
        _visitables.get("featureGates").remove(builder);
        this.featureGates.remove(builder);
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
  
  public A removeFromConditions(Condition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
      this.conditions.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromFeatureGates(FeatureGateDetails... items) {
    if (this.featureGates == null) {
      return (A) this;
    }
    for (FeatureGateDetails item : items) {
        FeatureGateDetailsBuilder builder = new FeatureGateDetailsBuilder(item);
        _visitables.get("featureGates").remove(builder);
        this.featureGates.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromFeatureGates(Predicate<FeatureGateDetailsBuilder> predicate) {
    if (featureGates == null) {
      return (A) this;
    }
    Iterator<FeatureGateDetailsBuilder> each = featureGates.iterator();
    List visitables = _visitables.get("featureGates");
    while (each.hasNext()) {
        FeatureGateDetailsBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public FeatureGatesNested<A> setNewFeatureGateLike(int index,FeatureGateDetails item) {
    return new FeatureGatesNested(index, item);
  }
  
  public A setToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.set(index, item);
    return (A) this;
  }
  
  public A setToFeatureGates(int index,FeatureGateDetails item) {
    if (this.featureGates == null) {
      this.featureGates = new ArrayList();
    }
    FeatureGateDetailsBuilder builder = new FeatureGateDetailsBuilder(item);
    if (index < 0 || index >= featureGates.size()) {
        _visitables.get("featureGates").add(builder);
        featureGates.add(builder);
    } else {
        _visitables.get("featureGates").add(builder);
        featureGates.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(featureGates == null) && !(featureGates.isEmpty())) {
        sb.append("featureGates:");
        sb.append(featureGates);
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
  
  public A withConditions(List<Condition> conditions) {
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (Condition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(Condition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (Condition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withFeatureGates(List<FeatureGateDetails> featureGates) {
    if (this.featureGates != null) {
      this._visitables.get("featureGates").clear();
    }
    if (featureGates != null) {
        this.featureGates = new ArrayList();
        for (FeatureGateDetails item : featureGates) {
          this.addToFeatureGates(item);
        }
    } else {
      this.featureGates = null;
    }
    return (A) this;
  }
  
  public A withFeatureGates(FeatureGateDetails... featureGates) {
    if (this.featureGates != null) {
        this.featureGates.clear();
        _visitables.remove("featureGates");
    }
    if (featureGates != null) {
      for (FeatureGateDetails item : featureGates) {
        this.addToFeatureGates(item);
      }
    }
    return (A) this;
  }
  public class FeatureGatesNested<N> extends FeatureGateDetailsFluent<FeatureGatesNested<N>> implements Nested<N>{
  
    FeatureGateDetailsBuilder builder;
    int index;
  
    FeatureGatesNested(int index,FeatureGateDetails item) {
      this.index = index;
      this.builder = new FeatureGateDetailsBuilder(this, item);
    }
  
    public N and() {
      return (N) FeatureGateStatusFluent.this.setToFeatureGates(index, builder.build());
    }
    
    public N endFeatureGate() {
      return and();
    }
    
  }
}