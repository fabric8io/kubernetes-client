package io.fabric8.openclustermanagement.api.model.cluster.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Long;
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
public class PlacementDecisionStatusFluent<A extends io.fabric8.openclustermanagement.api.model.cluster.v1beta1.PlacementDecisionStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<ClusterDecisionBuilder> decisions = new ArrayList<ClusterDecisionBuilder>();

  public PlacementDecisionStatusFluent() {
  }
  
  public PlacementDecisionStatusFluent(PlacementDecisionStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToDecisions(Collection<ClusterDecision> items) {
    if (this.decisions == null) {
      this.decisions = new ArrayList();
    }
    for (ClusterDecision item : items) {
        ClusterDecisionBuilder builder = new ClusterDecisionBuilder(item);
        _visitables.get("decisions").add(builder);
        this.decisions.add(builder);
    }
    return (A) this;
  }
  
  public DecisionsNested<A> addNewDecision() {
    return new DecisionsNested(-1, null);
  }
  
  public A addNewDecision(String clusterName,String reason,Long score) {
    return (A) this.addToDecisions(new ClusterDecision(clusterName, reason, score));
  }
  
  public DecisionsNested<A> addNewDecisionLike(ClusterDecision item) {
    return new DecisionsNested(-1, item);
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
  
  public A addToDecisions(ClusterDecision... items) {
    if (this.decisions == null) {
      this.decisions = new ArrayList();
    }
    for (ClusterDecision item : items) {
        ClusterDecisionBuilder builder = new ClusterDecisionBuilder(item);
        _visitables.get("decisions").add(builder);
        this.decisions.add(builder);
    }
    return (A) this;
  }
  
  public A addToDecisions(int index,ClusterDecision item) {
    if (this.decisions == null) {
      this.decisions = new ArrayList();
    }
    ClusterDecisionBuilder builder = new ClusterDecisionBuilder(item);
    if (index < 0 || index >= decisions.size()) {
        _visitables.get("decisions").add(builder);
        decisions.add(builder);
    } else {
        _visitables.get("decisions").add(builder);
        decisions.add(index, builder);
    }
    return (A) this;
  }
  
  public ClusterDecision buildDecision(int index) {
    return this.decisions.get(index).build();
  }
  
  public List<ClusterDecision> buildDecisions() {
    return this.decisions != null ? build(decisions) : null;
  }
  
  public ClusterDecision buildFirstDecision() {
    return this.decisions.get(0).build();
  }
  
  public ClusterDecision buildLastDecision() {
    return this.decisions.get(decisions.size() - 1).build();
  }
  
  public ClusterDecision buildMatchingDecision(Predicate<ClusterDecisionBuilder> predicate) {
      for (ClusterDecisionBuilder item : decisions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(PlacementDecisionStatus instance) {
    instance = instance != null ? instance : new PlacementDecisionStatus();
    if (instance != null) {
        this.withDecisions(instance.getDecisions());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DecisionsNested<A> editDecision(int index) {
    if (decisions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "decisions"));
    }
    return this.setNewDecisionLike(index, this.buildDecision(index));
  }
  
  public DecisionsNested<A> editFirstDecision() {
    if (decisions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "decisions"));
    }
    return this.setNewDecisionLike(0, this.buildDecision(0));
  }
  
  public DecisionsNested<A> editLastDecision() {
    int index = decisions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "decisions"));
    }
    return this.setNewDecisionLike(index, this.buildDecision(index));
  }
  
  public DecisionsNested<A> editMatchingDecision(Predicate<ClusterDecisionBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < decisions.size();i++) {
      if (predicate.test(decisions.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "decisions"));
    }
    return this.setNewDecisionLike(index, this.buildDecision(index));
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
    PlacementDecisionStatusFluent that = (PlacementDecisionStatusFluent) o;
    if (!(Objects.equals(decisions, that.decisions))) {
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
  
  public boolean hasDecisions() {
    return this.decisions != null && !(this.decisions.isEmpty());
  }
  
  public boolean hasMatchingDecision(Predicate<ClusterDecisionBuilder> predicate) {
      for (ClusterDecisionBuilder item : decisions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(decisions, additionalProperties);
  }
  
  public A removeAllFromDecisions(Collection<ClusterDecision> items) {
    if (this.decisions == null) {
      return (A) this;
    }
    for (ClusterDecision item : items) {
        ClusterDecisionBuilder builder = new ClusterDecisionBuilder(item);
        _visitables.get("decisions").remove(builder);
        this.decisions.remove(builder);
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
  
  public A removeFromDecisions(ClusterDecision... items) {
    if (this.decisions == null) {
      return (A) this;
    }
    for (ClusterDecision item : items) {
        ClusterDecisionBuilder builder = new ClusterDecisionBuilder(item);
        _visitables.get("decisions").remove(builder);
        this.decisions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromDecisions(Predicate<ClusterDecisionBuilder> predicate) {
    if (decisions == null) {
      return (A) this;
    }
    Iterator<ClusterDecisionBuilder> each = decisions.iterator();
    List visitables = _visitables.get("decisions");
    while (each.hasNext()) {
        ClusterDecisionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public DecisionsNested<A> setNewDecisionLike(int index,ClusterDecision item) {
    return new DecisionsNested(index, item);
  }
  
  public A setToDecisions(int index,ClusterDecision item) {
    if (this.decisions == null) {
      this.decisions = new ArrayList();
    }
    ClusterDecisionBuilder builder = new ClusterDecisionBuilder(item);
    if (index < 0 || index >= decisions.size()) {
        _visitables.get("decisions").add(builder);
        decisions.add(builder);
    } else {
        _visitables.get("decisions").add(builder);
        decisions.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(decisions == null) && !(decisions.isEmpty())) {
        sb.append("decisions:");
        sb.append(decisions);
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
  
  public A withDecisions(List<ClusterDecision> decisions) {
    if (this.decisions != null) {
      this._visitables.get("decisions").clear();
    }
    if (decisions != null) {
        this.decisions = new ArrayList();
        for (ClusterDecision item : decisions) {
          this.addToDecisions(item);
        }
    } else {
      this.decisions = null;
    }
    return (A) this;
  }
  
  public A withDecisions(ClusterDecision... decisions) {
    if (this.decisions != null) {
        this.decisions.clear();
        _visitables.remove("decisions");
    }
    if (decisions != null) {
      for (ClusterDecision item : decisions) {
        this.addToDecisions(item);
      }
    }
    return (A) this;
  }
  public class DecisionsNested<N> extends ClusterDecisionFluent<DecisionsNested<N>> implements Nested<N>{
  
    ClusterDecisionBuilder builder;
    int index;
  
    DecisionsNested(int index,ClusterDecision item) {
      this.index = index;
      this.builder = new ClusterDecisionBuilder(this, item);
    }
  
    public N and() {
      return (N) PlacementDecisionStatusFluent.this.setToDecisions(index, builder.build());
    }
    
    public N endDecision() {
      return and();
    }
    
  }
}