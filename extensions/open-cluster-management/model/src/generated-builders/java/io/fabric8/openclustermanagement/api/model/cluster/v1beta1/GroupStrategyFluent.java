package io.fabric8.openclustermanagement.api.model.cluster.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.IntOrStringBuilder;
import io.fabric8.kubernetes.api.model.IntOrStringFluent;
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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class GroupStrategyFluent<A extends io.fabric8.openclustermanagement.api.model.cluster.v1beta1.GroupStrategyFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private IntOrStringBuilder clustersPerDecisionGroup;
  private ArrayList<DecisionGroupBuilder> decisionGroups = new ArrayList<DecisionGroupBuilder>();

  public GroupStrategyFluent() {
  }
  
  public GroupStrategyFluent(GroupStrategy instance) {
    this.copyInstance(instance);
  }

  public A addAllToDecisionGroups(Collection<DecisionGroup> items) {
    if (this.decisionGroups == null) {
      this.decisionGroups = new ArrayList();
    }
    for (DecisionGroup item : items) {
        DecisionGroupBuilder builder = new DecisionGroupBuilder(item);
        _visitables.get("decisionGroups").add(builder);
        this.decisionGroups.add(builder);
    }
    return (A) this;
  }
  
  public DecisionGroupsNested<A> addNewDecisionGroup() {
    return new DecisionGroupsNested(-1, null);
  }
  
  public DecisionGroupsNested<A> addNewDecisionGroupLike(DecisionGroup item) {
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
  
  public A addToDecisionGroups(DecisionGroup... items) {
    if (this.decisionGroups == null) {
      this.decisionGroups = new ArrayList();
    }
    for (DecisionGroup item : items) {
        DecisionGroupBuilder builder = new DecisionGroupBuilder(item);
        _visitables.get("decisionGroups").add(builder);
        this.decisionGroups.add(builder);
    }
    return (A) this;
  }
  
  public A addToDecisionGroups(int index,DecisionGroup item) {
    if (this.decisionGroups == null) {
      this.decisionGroups = new ArrayList();
    }
    DecisionGroupBuilder builder = new DecisionGroupBuilder(item);
    if (index < 0 || index >= decisionGroups.size()) {
        _visitables.get("decisionGroups").add(builder);
        decisionGroups.add(builder);
    } else {
        _visitables.get("decisionGroups").add(builder);
        decisionGroups.add(index, builder);
    }
    return (A) this;
  }
  
  public IntOrString buildClustersPerDecisionGroup() {
    return this.clustersPerDecisionGroup != null ? this.clustersPerDecisionGroup.build() : null;
  }
  
  public DecisionGroup buildDecisionGroup(int index) {
    return this.decisionGroups.get(index).build();
  }
  
  public List<DecisionGroup> buildDecisionGroups() {
    return this.decisionGroups != null ? build(decisionGroups) : null;
  }
  
  public DecisionGroup buildFirstDecisionGroup() {
    return this.decisionGroups.get(0).build();
  }
  
  public DecisionGroup buildLastDecisionGroup() {
    return this.decisionGroups.get(decisionGroups.size() - 1).build();
  }
  
  public DecisionGroup buildMatchingDecisionGroup(Predicate<DecisionGroupBuilder> predicate) {
      for (DecisionGroupBuilder item : decisionGroups) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(GroupStrategy instance) {
    instance = instance != null ? instance : new GroupStrategy();
    if (instance != null) {
        this.withClustersPerDecisionGroup(instance.getClustersPerDecisionGroup());
        this.withDecisionGroups(instance.getDecisionGroups());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ClustersPerDecisionGroupNested<A> editClustersPerDecisionGroup() {
    return this.withNewClustersPerDecisionGroupLike(Optional.ofNullable(this.buildClustersPerDecisionGroup()).orElse(null));
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
  
  public DecisionGroupsNested<A> editMatchingDecisionGroup(Predicate<DecisionGroupBuilder> predicate) {
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
  
  public ClustersPerDecisionGroupNested<A> editOrNewClustersPerDecisionGroup() {
    return this.withNewClustersPerDecisionGroupLike(Optional.ofNullable(this.buildClustersPerDecisionGroup()).orElse(new IntOrStringBuilder().build()));
  }
  
  public ClustersPerDecisionGroupNested<A> editOrNewClustersPerDecisionGroupLike(IntOrString item) {
    return this.withNewClustersPerDecisionGroupLike(Optional.ofNullable(this.buildClustersPerDecisionGroup()).orElse(item));
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
    GroupStrategyFluent that = (GroupStrategyFluent) o;
    if (!(Objects.equals(clustersPerDecisionGroup, that.clustersPerDecisionGroup))) {
      return false;
    }
    if (!(Objects.equals(decisionGroups, that.decisionGroups))) {
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
  
  public boolean hasClustersPerDecisionGroup() {
    return this.clustersPerDecisionGroup != null;
  }
  
  public boolean hasDecisionGroups() {
    return this.decisionGroups != null && !(this.decisionGroups.isEmpty());
  }
  
  public boolean hasMatchingDecisionGroup(Predicate<DecisionGroupBuilder> predicate) {
      for (DecisionGroupBuilder item : decisionGroups) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(clustersPerDecisionGroup, decisionGroups, additionalProperties);
  }
  
  public A removeAllFromDecisionGroups(Collection<DecisionGroup> items) {
    if (this.decisionGroups == null) {
      return (A) this;
    }
    for (DecisionGroup item : items) {
        DecisionGroupBuilder builder = new DecisionGroupBuilder(item);
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
  
  public A removeFromDecisionGroups(DecisionGroup... items) {
    if (this.decisionGroups == null) {
      return (A) this;
    }
    for (DecisionGroup item : items) {
        DecisionGroupBuilder builder = new DecisionGroupBuilder(item);
        _visitables.get("decisionGroups").remove(builder);
        this.decisionGroups.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromDecisionGroups(Predicate<DecisionGroupBuilder> predicate) {
    if (decisionGroups == null) {
      return (A) this;
    }
    Iterator<DecisionGroupBuilder> each = decisionGroups.iterator();
    List visitables = _visitables.get("decisionGroups");
    while (each.hasNext()) {
        DecisionGroupBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public DecisionGroupsNested<A> setNewDecisionGroupLike(int index,DecisionGroup item) {
    return new DecisionGroupsNested(index, item);
  }
  
  public A setToDecisionGroups(int index,DecisionGroup item) {
    if (this.decisionGroups == null) {
      this.decisionGroups = new ArrayList();
    }
    DecisionGroupBuilder builder = new DecisionGroupBuilder(item);
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
    if (!(clustersPerDecisionGroup == null)) {
        sb.append("clustersPerDecisionGroup:");
        sb.append(clustersPerDecisionGroup);
        sb.append(",");
    }
    if (!(decisionGroups == null) && !(decisionGroups.isEmpty())) {
        sb.append("decisionGroups:");
        sb.append(decisionGroups);
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
  
  public A withClustersPerDecisionGroup(IntOrString clustersPerDecisionGroup) {
    this._visitables.remove("clustersPerDecisionGroup");
    if (clustersPerDecisionGroup != null) {
        this.clustersPerDecisionGroup = new IntOrStringBuilder(clustersPerDecisionGroup);
        this._visitables.get("clustersPerDecisionGroup").add(this.clustersPerDecisionGroup);
    } else {
        this.clustersPerDecisionGroup = null;
        this._visitables.get("clustersPerDecisionGroup").remove(this.clustersPerDecisionGroup);
    }
    return (A) this;
  }
  
  public A withDecisionGroups(List<DecisionGroup> decisionGroups) {
    if (this.decisionGroups != null) {
      this._visitables.get("decisionGroups").clear();
    }
    if (decisionGroups != null) {
        this.decisionGroups = new ArrayList();
        for (DecisionGroup item : decisionGroups) {
          this.addToDecisionGroups(item);
        }
    } else {
      this.decisionGroups = null;
    }
    return (A) this;
  }
  
  public A withDecisionGroups(DecisionGroup... decisionGroups) {
    if (this.decisionGroups != null) {
        this.decisionGroups.clear();
        _visitables.remove("decisionGroups");
    }
    if (decisionGroups != null) {
      for (DecisionGroup item : decisionGroups) {
        this.addToDecisionGroups(item);
      }
    }
    return (A) this;
  }
  
  public ClustersPerDecisionGroupNested<A> withNewClustersPerDecisionGroup() {
    return new ClustersPerDecisionGroupNested(null);
  }
  
  public A withNewClustersPerDecisionGroup(Object value) {
    return (A) this.withClustersPerDecisionGroup(new IntOrString(value));
  }
  
  public ClustersPerDecisionGroupNested<A> withNewClustersPerDecisionGroupLike(IntOrString item) {
    return new ClustersPerDecisionGroupNested(item);
  }
  public class ClustersPerDecisionGroupNested<N> extends IntOrStringFluent<ClustersPerDecisionGroupNested<N>> implements Nested<N>{
  
    IntOrStringBuilder builder;
  
    ClustersPerDecisionGroupNested(IntOrString item) {
      this.builder = new IntOrStringBuilder(this, item);
    }
  
    public N and() {
      return (N) GroupStrategyFluent.this.withClustersPerDecisionGroup(builder.build());
    }
    
    public N endClustersPerDecisionGroup() {
      return and();
    }
    
  }
  public class DecisionGroupsNested<N> extends DecisionGroupFluent<DecisionGroupsNested<N>> implements Nested<N>{
  
    DecisionGroupBuilder builder;
    int index;
  
    DecisionGroupsNested(int index,DecisionGroup item) {
      this.index = index;
      this.builder = new DecisionGroupBuilder(this, item);
    }
  
    public N and() {
      return (N) GroupStrategyFluent.this.setToDecisionGroups(index, builder.build());
    }
    
    public N endDecisionGroup() {
      return and();
    }
    
  }
}