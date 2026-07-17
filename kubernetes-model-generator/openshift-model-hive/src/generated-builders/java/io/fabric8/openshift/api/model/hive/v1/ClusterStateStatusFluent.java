package io.fabric8.openshift.api.model.hive.v1;

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
public class ClusterStateStatusFluent<A extends io.fabric8.openshift.api.model.hive.v1.ClusterStateStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<ClusterOperatorStateBuilder> clusterOperators = new ArrayList<ClusterOperatorStateBuilder>();
  private String lastUpdated;

  public ClusterStateStatusFluent() {
  }
  
  public ClusterStateStatusFluent(ClusterStateStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToClusterOperators(Collection<ClusterOperatorState> items) {
    if (this.clusterOperators == null) {
      this.clusterOperators = new ArrayList();
    }
    for (ClusterOperatorState item : items) {
        ClusterOperatorStateBuilder builder = new ClusterOperatorStateBuilder(item);
        _visitables.get("clusterOperators").add(builder);
        this.clusterOperators.add(builder);
    }
    return (A) this;
  }
  
  public ClusterOperatorsNested<A> addNewClusterOperator() {
    return new ClusterOperatorsNested(-1, null);
  }
  
  public ClusterOperatorsNested<A> addNewClusterOperatorLike(ClusterOperatorState item) {
    return new ClusterOperatorsNested(-1, item);
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
  
  public A addToClusterOperators(ClusterOperatorState... items) {
    if (this.clusterOperators == null) {
      this.clusterOperators = new ArrayList();
    }
    for (ClusterOperatorState item : items) {
        ClusterOperatorStateBuilder builder = new ClusterOperatorStateBuilder(item);
        _visitables.get("clusterOperators").add(builder);
        this.clusterOperators.add(builder);
    }
    return (A) this;
  }
  
  public A addToClusterOperators(int index,ClusterOperatorState item) {
    if (this.clusterOperators == null) {
      this.clusterOperators = new ArrayList();
    }
    ClusterOperatorStateBuilder builder = new ClusterOperatorStateBuilder(item);
    if (index < 0 || index >= clusterOperators.size()) {
        _visitables.get("clusterOperators").add(builder);
        clusterOperators.add(builder);
    } else {
        _visitables.get("clusterOperators").add(builder);
        clusterOperators.add(index, builder);
    }
    return (A) this;
  }
  
  public ClusterOperatorState buildClusterOperator(int index) {
    return this.clusterOperators.get(index).build();
  }
  
  public List<ClusterOperatorState> buildClusterOperators() {
    return this.clusterOperators != null ? build(clusterOperators) : null;
  }
  
  public ClusterOperatorState buildFirstClusterOperator() {
    return this.clusterOperators.get(0).build();
  }
  
  public ClusterOperatorState buildLastClusterOperator() {
    return this.clusterOperators.get(clusterOperators.size() - 1).build();
  }
  
  public ClusterOperatorState buildMatchingClusterOperator(Predicate<ClusterOperatorStateBuilder> predicate) {
      for (ClusterOperatorStateBuilder item : clusterOperators) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(ClusterStateStatus instance) {
    instance = instance != null ? instance : new ClusterStateStatus();
    if (instance != null) {
        this.withClusterOperators(instance.getClusterOperators());
        this.withLastUpdated(instance.getLastUpdated());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ClusterOperatorsNested<A> editClusterOperator(int index) {
    if (clusterOperators.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "clusterOperators"));
    }
    return this.setNewClusterOperatorLike(index, this.buildClusterOperator(index));
  }
  
  public ClusterOperatorsNested<A> editFirstClusterOperator() {
    if (clusterOperators.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "clusterOperators"));
    }
    return this.setNewClusterOperatorLike(0, this.buildClusterOperator(0));
  }
  
  public ClusterOperatorsNested<A> editLastClusterOperator() {
    int index = clusterOperators.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "clusterOperators"));
    }
    return this.setNewClusterOperatorLike(index, this.buildClusterOperator(index));
  }
  
  public ClusterOperatorsNested<A> editMatchingClusterOperator(Predicate<ClusterOperatorStateBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < clusterOperators.size();i++) {
      if (predicate.test(clusterOperators.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "clusterOperators"));
    }
    return this.setNewClusterOperatorLike(index, this.buildClusterOperator(index));
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
    ClusterStateStatusFluent that = (ClusterStateStatusFluent) o;
    if (!(Objects.equals(clusterOperators, that.clusterOperators))) {
      return false;
    }
    if (!(Objects.equals(lastUpdated, that.lastUpdated))) {
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
  
  public String getLastUpdated() {
    return this.lastUpdated;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClusterOperators() {
    return this.clusterOperators != null && !(this.clusterOperators.isEmpty());
  }
  
  public boolean hasLastUpdated() {
    return this.lastUpdated != null;
  }
  
  public boolean hasMatchingClusterOperator(Predicate<ClusterOperatorStateBuilder> predicate) {
      for (ClusterOperatorStateBuilder item : clusterOperators) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(clusterOperators, lastUpdated, additionalProperties);
  }
  
  public A removeAllFromClusterOperators(Collection<ClusterOperatorState> items) {
    if (this.clusterOperators == null) {
      return (A) this;
    }
    for (ClusterOperatorState item : items) {
        ClusterOperatorStateBuilder builder = new ClusterOperatorStateBuilder(item);
        _visitables.get("clusterOperators").remove(builder);
        this.clusterOperators.remove(builder);
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
  
  public A removeFromClusterOperators(ClusterOperatorState... items) {
    if (this.clusterOperators == null) {
      return (A) this;
    }
    for (ClusterOperatorState item : items) {
        ClusterOperatorStateBuilder builder = new ClusterOperatorStateBuilder(item);
        _visitables.get("clusterOperators").remove(builder);
        this.clusterOperators.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromClusterOperators(Predicate<ClusterOperatorStateBuilder> predicate) {
    if (clusterOperators == null) {
      return (A) this;
    }
    Iterator<ClusterOperatorStateBuilder> each = clusterOperators.iterator();
    List visitables = _visitables.get("clusterOperators");
    while (each.hasNext()) {
        ClusterOperatorStateBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ClusterOperatorsNested<A> setNewClusterOperatorLike(int index,ClusterOperatorState item) {
    return new ClusterOperatorsNested(index, item);
  }
  
  public A setToClusterOperators(int index,ClusterOperatorState item) {
    if (this.clusterOperators == null) {
      this.clusterOperators = new ArrayList();
    }
    ClusterOperatorStateBuilder builder = new ClusterOperatorStateBuilder(item);
    if (index < 0 || index >= clusterOperators.size()) {
        _visitables.get("clusterOperators").add(builder);
        clusterOperators.add(builder);
    } else {
        _visitables.get("clusterOperators").add(builder);
        clusterOperators.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(clusterOperators == null) && !(clusterOperators.isEmpty())) {
        sb.append("clusterOperators:");
        sb.append(clusterOperators);
        sb.append(",");
    }
    if (!(lastUpdated == null)) {
        sb.append("lastUpdated:");
        sb.append(lastUpdated);
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
  
  public A withClusterOperators(List<ClusterOperatorState> clusterOperators) {
    if (this.clusterOperators != null) {
      this._visitables.get("clusterOperators").clear();
    }
    if (clusterOperators != null) {
        this.clusterOperators = new ArrayList();
        for (ClusterOperatorState item : clusterOperators) {
          this.addToClusterOperators(item);
        }
    } else {
      this.clusterOperators = null;
    }
    return (A) this;
  }
  
  public A withClusterOperators(ClusterOperatorState... clusterOperators) {
    if (this.clusterOperators != null) {
        this.clusterOperators.clear();
        _visitables.remove("clusterOperators");
    }
    if (clusterOperators != null) {
      for (ClusterOperatorState item : clusterOperators) {
        this.addToClusterOperators(item);
      }
    }
    return (A) this;
  }
  
  public A withLastUpdated(String lastUpdated) {
    this.lastUpdated = lastUpdated;
    return (A) this;
  }
  public class ClusterOperatorsNested<N> extends ClusterOperatorStateFluent<ClusterOperatorsNested<N>> implements Nested<N>{
  
    ClusterOperatorStateBuilder builder;
    int index;
  
    ClusterOperatorsNested(int index,ClusterOperatorState item) {
      this.index = index;
      this.builder = new ClusterOperatorStateBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterStateStatusFluent.this.setToClusterOperators(index, builder.build());
    }
    
    public N endClusterOperator() {
      return and();
    }
    
  }
}