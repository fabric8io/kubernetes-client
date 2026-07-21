package io.fabric8.openclustermanagement.api.model.cluster.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Condition;
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
public class PlacementStatusFluent<A extends io.fabric8.openclustermanagement.api.model.cluster.v1beta1.PlacementStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<Condition> conditions = new ArrayList<Condition>();
  private ArrayList<DecisionGroupStatusBuilder> decisionGroups = new ArrayList<DecisionGroupStatusBuilder>();
  private String lastScoreUpdateTime;
  private Integer numberOfSelectedClusters;

  public PlacementStatusFluent() {
  }
  
  public PlacementStatusFluent(PlacementStatus instance) {
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
  
  public A addAllToDecisionGroups(Collection<DecisionGroupStatus> items) {
    if (this.decisionGroups == null) {
      this.decisionGroups = new ArrayList();
    }
    for (DecisionGroupStatus item : items) {
        DecisionGroupStatusBuilder builder = new DecisionGroupStatusBuilder(item);
        _visitables.get("decisionGroups").add(builder);
        this.decisionGroups.add(builder);
    }
    return (A) this;
  }
  
  public DecisionGroupsNested<A> addNewDecisionGroup() {
    return new DecisionGroupsNested(-1, null);
  }
  
  public DecisionGroupsNested<A> addNewDecisionGroupLike(DecisionGroupStatus item) {
    return new DecisionGroupsNested(-1, item);
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
  
  public A addToDecisionGroups(DecisionGroupStatus... items) {
    if (this.decisionGroups == null) {
      this.decisionGroups = new ArrayList();
    }
    for (DecisionGroupStatus item : items) {
        DecisionGroupStatusBuilder builder = new DecisionGroupStatusBuilder(item);
        _visitables.get("decisionGroups").add(builder);
        this.decisionGroups.add(builder);
    }
    return (A) this;
  }
  
  public A addToDecisionGroups(int index,DecisionGroupStatus item) {
    if (this.decisionGroups == null) {
      this.decisionGroups = new ArrayList();
    }
    DecisionGroupStatusBuilder builder = new DecisionGroupStatusBuilder(item);
    if (index < 0 || index >= decisionGroups.size()) {
        _visitables.get("decisionGroups").add(builder);
        decisionGroups.add(builder);
    } else {
        _visitables.get("decisionGroups").add(builder);
        decisionGroups.add(index, builder);
    }
    return (A) this;
  }
  
  public DecisionGroupStatus buildDecisionGroup(int index) {
    return this.decisionGroups.get(index).build();
  }
  
  public List<DecisionGroupStatus> buildDecisionGroups() {
    return this.decisionGroups != null ? build(decisionGroups) : null;
  }
  
  public DecisionGroupStatus buildFirstDecisionGroup() {
    return this.decisionGroups.get(0).build();
  }
  
  public DecisionGroupStatus buildLastDecisionGroup() {
    return this.decisionGroups.get(decisionGroups.size() - 1).build();
  }
  
  public DecisionGroupStatus buildMatchingDecisionGroup(Predicate<DecisionGroupStatusBuilder> predicate) {
      for (DecisionGroupStatusBuilder item : decisionGroups) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(PlacementStatus instance) {
    instance = instance != null ? instance : new PlacementStatus();
    if (instance != null) {
        this.withConditions(instance.getConditions());
        this.withDecisionGroups(instance.getDecisionGroups());
        this.withLastScoreUpdateTime(instance.getLastScoreUpdateTime());
        this.withNumberOfSelectedClusters(instance.getNumberOfSelectedClusters());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DecisionGroupsNested<A> editDecisionGroup(int index) {
    if (decisionGroups.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "decisionGroups"));
    }
    return this.setNewDecisionGroupLike(index, this.buildDecisionGroup(index));
  }
  
  public DecisionGroupsNested<A> editFirstDecisionGroup() {
    if (decisionGroups.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "decisionGroups"));
    }
    return this.setNewDecisionGroupLike(0, this.buildDecisionGroup(0));
  }
  
  public DecisionGroupsNested<A> editLastDecisionGroup() {
    int index = decisionGroups.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "decisionGroups"));
    }
    return this.setNewDecisionGroupLike(index, this.buildDecisionGroup(index));
  }
  
  public DecisionGroupsNested<A> editMatchingDecisionGroup(Predicate<DecisionGroupStatusBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < decisionGroups.size();i++) {
      if (predicate.test(decisionGroups.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "decisionGroups"));
    }
    return this.setNewDecisionGroupLike(index, this.buildDecisionGroup(index));
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
    PlacementStatusFluent that = (PlacementStatusFluent) o;
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(decisionGroups, that.decisionGroups))) {
      return false;
    }
    if (!(Objects.equals(lastScoreUpdateTime, that.lastScoreUpdateTime))) {
      return false;
    }
    if (!(Objects.equals(numberOfSelectedClusters, that.numberOfSelectedClusters))) {
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
  
  public String getLastScoreUpdateTime() {
    return this.lastScoreUpdateTime;
  }
  
  public Condition getMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Integer getNumberOfSelectedClusters() {
    return this.numberOfSelectedClusters;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasDecisionGroups() {
    return this.decisionGroups != null && !(this.decisionGroups.isEmpty());
  }
  
  public boolean hasLastScoreUpdateTime() {
    return this.lastScoreUpdateTime != null;
  }
  
  public boolean hasMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingDecisionGroup(Predicate<DecisionGroupStatusBuilder> predicate) {
      for (DecisionGroupStatusBuilder item : decisionGroups) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNumberOfSelectedClusters() {
    return this.numberOfSelectedClusters != null;
  }
  
  public int hashCode() {
    return Objects.hash(conditions, decisionGroups, lastScoreUpdateTime, numberOfSelectedClusters, additionalProperties);
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
  
  public A removeAllFromDecisionGroups(Collection<DecisionGroupStatus> items) {
    if (this.decisionGroups == null) {
      return (A) this;
    }
    for (DecisionGroupStatus item : items) {
        DecisionGroupStatusBuilder builder = new DecisionGroupStatusBuilder(item);
        _visitables.get("decisionGroups").remove(builder);
        this.decisionGroups.remove(builder);
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
  
  public A removeFromDecisionGroups(DecisionGroupStatus... items) {
    if (this.decisionGroups == null) {
      return (A) this;
    }
    for (DecisionGroupStatus item : items) {
        DecisionGroupStatusBuilder builder = new DecisionGroupStatusBuilder(item);
        _visitables.get("decisionGroups").remove(builder);
        this.decisionGroups.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromDecisionGroups(Predicate<DecisionGroupStatusBuilder> predicate) {
    if (decisionGroups == null) {
      return (A) this;
    }
    Iterator<DecisionGroupStatusBuilder> each = decisionGroups.iterator();
    List visitables = _visitables.get("decisionGroups");
    while (each.hasNext()) {
        DecisionGroupStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public DecisionGroupsNested<A> setNewDecisionGroupLike(int index,DecisionGroupStatus item) {
    return new DecisionGroupsNested(index, item);
  }
  
  public A setToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.set(index, item);
    return (A) this;
  }
  
  public A setToDecisionGroups(int index,DecisionGroupStatus item) {
    if (this.decisionGroups == null) {
      this.decisionGroups = new ArrayList();
    }
    DecisionGroupStatusBuilder builder = new DecisionGroupStatusBuilder(item);
    if (index < 0 || index >= decisionGroups.size()) {
        _visitables.get("decisionGroups").add(builder);
        decisionGroups.add(builder);
    } else {
        _visitables.get("decisionGroups").add(builder);
        decisionGroups.set(index, builder);
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
    if (!(decisionGroups == null) && !(decisionGroups.isEmpty())) {
        sb.append("decisionGroups:");
        sb.append(decisionGroups);
        sb.append(",");
    }
    if (!(lastScoreUpdateTime == null)) {
        sb.append("lastScoreUpdateTime:");
        sb.append(lastScoreUpdateTime);
        sb.append(",");
    }
    if (!(numberOfSelectedClusters == null)) {
        sb.append("numberOfSelectedClusters:");
        sb.append(numberOfSelectedClusters);
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
  
  public A withDecisionGroups(List<DecisionGroupStatus> decisionGroups) {
    if (this.decisionGroups != null) {
      this._visitables.get("decisionGroups").clear();
    }
    if (decisionGroups != null) {
        this.decisionGroups = new ArrayList();
        for (DecisionGroupStatus item : decisionGroups) {
          this.addToDecisionGroups(item);
        }
    } else {
      this.decisionGroups = null;
    }
    return (A) this;
  }
  
  public A withDecisionGroups(DecisionGroupStatus... decisionGroups) {
    if (this.decisionGroups != null) {
        this.decisionGroups.clear();
        _visitables.remove("decisionGroups");
    }
    if (decisionGroups != null) {
      for (DecisionGroupStatus item : decisionGroups) {
        this.addToDecisionGroups(item);
      }
    }
    return (A) this;
  }
  
  public A withLastScoreUpdateTime(String lastScoreUpdateTime) {
    this.lastScoreUpdateTime = lastScoreUpdateTime;
    return (A) this;
  }
  
  public A withNumberOfSelectedClusters(Integer numberOfSelectedClusters) {
    this.numberOfSelectedClusters = numberOfSelectedClusters;
    return (A) this;
  }
  public class DecisionGroupsNested<N> extends DecisionGroupStatusFluent<DecisionGroupsNested<N>> implements Nested<N>{
  
    DecisionGroupStatusBuilder builder;
    int index;
  
    DecisionGroupsNested(int index,DecisionGroupStatus item) {
      this.index = index;
      this.builder = new DecisionGroupStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) PlacementStatusFluent.this.setToDecisionGroups(index, builder.build());
    }
    
    public N endDecisionGroup() {
      return and();
    }
    
  }
}