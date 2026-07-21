package io.fabric8.openclustermanagement.api.model.apps.v1;

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
public class PlacementRuleStatusFluent<A extends io.fabric8.openclustermanagement.api.model.apps.v1.PlacementRuleStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<PlacementDecisionBuilder> decisions = new ArrayList<PlacementDecisionBuilder>();

  public PlacementRuleStatusFluent() {
  }
  
  public PlacementRuleStatusFluent(PlacementRuleStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToDecisions(Collection<PlacementDecision> items) {
    if (this.decisions == null) {
      this.decisions = new ArrayList();
    }
    for (PlacementDecision item : items) {
        PlacementDecisionBuilder builder = new PlacementDecisionBuilder(item);
        _visitables.get("decisions").add(builder);
        this.decisions.add(builder);
    }
    return (A) this;
  }
  
  public DecisionsNested<A> addNewDecision() {
    return new DecisionsNested(-1, null);
  }
  
  public A addNewDecision(String clusterName,String clusterNamespace) {
    return (A) this.addToDecisions(new PlacementDecision(clusterName, clusterNamespace));
  }
  
  public DecisionsNested<A> addNewDecisionLike(PlacementDecision item) {
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
  
  public A addToDecisions(PlacementDecision... items) {
    if (this.decisions == null) {
      this.decisions = new ArrayList();
    }
    for (PlacementDecision item : items) {
        PlacementDecisionBuilder builder = new PlacementDecisionBuilder(item);
        _visitables.get("decisions").add(builder);
        this.decisions.add(builder);
    }
    return (A) this;
  }
  
  public A addToDecisions(int index,PlacementDecision item) {
    if (this.decisions == null) {
      this.decisions = new ArrayList();
    }
    PlacementDecisionBuilder builder = new PlacementDecisionBuilder(item);
    if (index < 0 || index >= decisions.size()) {
        _visitables.get("decisions").add(builder);
        decisions.add(builder);
    } else {
        _visitables.get("decisions").add(builder);
        decisions.add(index, builder);
    }
    return (A) this;
  }
  
  public PlacementDecision buildDecision(int index) {
    return this.decisions.get(index).build();
  }
  
  public List<PlacementDecision> buildDecisions() {
    return this.decisions != null ? build(decisions) : null;
  }
  
  public PlacementDecision buildFirstDecision() {
    return this.decisions.get(0).build();
  }
  
  public PlacementDecision buildLastDecision() {
    return this.decisions.get(decisions.size() - 1).build();
  }
  
  public PlacementDecision buildMatchingDecision(Predicate<PlacementDecisionBuilder> predicate) {
      for (PlacementDecisionBuilder item : decisions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(PlacementRuleStatus instance) {
    instance = instance != null ? instance : new PlacementRuleStatus();
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
  
  public DecisionsNested<A> editMatchingDecision(Predicate<PlacementDecisionBuilder> predicate) {
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
    PlacementRuleStatusFluent that = (PlacementRuleStatusFluent) o;
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
  
  public boolean hasMatchingDecision(Predicate<PlacementDecisionBuilder> predicate) {
      for (PlacementDecisionBuilder item : decisions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(decisions, additionalProperties);
  }
  
  public A removeAllFromDecisions(Collection<PlacementDecision> items) {
    if (this.decisions == null) {
      return (A) this;
    }
    for (PlacementDecision item : items) {
        PlacementDecisionBuilder builder = new PlacementDecisionBuilder(item);
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
  
  public A removeFromDecisions(PlacementDecision... items) {
    if (this.decisions == null) {
      return (A) this;
    }
    for (PlacementDecision item : items) {
        PlacementDecisionBuilder builder = new PlacementDecisionBuilder(item);
        _visitables.get("decisions").remove(builder);
        this.decisions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromDecisions(Predicate<PlacementDecisionBuilder> predicate) {
    if (decisions == null) {
      return (A) this;
    }
    Iterator<PlacementDecisionBuilder> each = decisions.iterator();
    List visitables = _visitables.get("decisions");
    while (each.hasNext()) {
        PlacementDecisionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public DecisionsNested<A> setNewDecisionLike(int index,PlacementDecision item) {
    return new DecisionsNested(index, item);
  }
  
  public A setToDecisions(int index,PlacementDecision item) {
    if (this.decisions == null) {
      this.decisions = new ArrayList();
    }
    PlacementDecisionBuilder builder = new PlacementDecisionBuilder(item);
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
  
  public A withDecisions(List<PlacementDecision> decisions) {
    if (this.decisions != null) {
      this._visitables.get("decisions").clear();
    }
    if (decisions != null) {
        this.decisions = new ArrayList();
        for (PlacementDecision item : decisions) {
          this.addToDecisions(item);
        }
    } else {
      this.decisions = null;
    }
    return (A) this;
  }
  
  public A withDecisions(PlacementDecision... decisions) {
    if (this.decisions != null) {
        this.decisions.clear();
        _visitables.remove("decisions");
    }
    if (decisions != null) {
      for (PlacementDecision item : decisions) {
        this.addToDecisions(item);
      }
    }
    return (A) this;
  }
  public class DecisionsNested<N> extends PlacementDecisionFluent<DecisionsNested<N>> implements Nested<N>{
  
    PlacementDecisionBuilder builder;
    int index;
  
    DecisionsNested(int index,PlacementDecision item) {
      this.index = index;
      this.builder = new PlacementDecisionBuilder(this, item);
    }
  
    public N and() {
      return (N) PlacementRuleStatusFluent.this.setToDecisions(index, builder.build());
    }
    
    public N endDecision() {
      return and();
    }
    
  }
}