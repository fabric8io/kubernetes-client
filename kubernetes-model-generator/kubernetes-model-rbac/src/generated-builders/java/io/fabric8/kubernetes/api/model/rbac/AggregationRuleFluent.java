package io.fabric8.kubernetes.api.model.rbac;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LabelSelectorBuilder;
import io.fabric8.kubernetes.api.model.LabelSelectorFluent;
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
public class AggregationRuleFluent<A extends io.fabric8.kubernetes.api.model.rbac.AggregationRuleFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<LabelSelectorBuilder> clusterRoleSelectors = new ArrayList<LabelSelectorBuilder>();

  public AggregationRuleFluent() {
  }
  
  public AggregationRuleFluent(AggregationRule instance) {
    this.copyInstance(instance);
  }

  public A addAllToClusterRoleSelectors(Collection<LabelSelector> items) {
    if (this.clusterRoleSelectors == null) {
      this.clusterRoleSelectors = new ArrayList();
    }
    for (LabelSelector item : items) {
        LabelSelectorBuilder builder = new LabelSelectorBuilder(item);
        _visitables.get("clusterRoleSelectors").add(builder);
        this.clusterRoleSelectors.add(builder);
    }
    return (A) this;
  }
  
  public ClusterRoleSelectorsNested<A> addNewClusterRoleSelector() {
    return new ClusterRoleSelectorsNested(-1, null);
  }
  
  public ClusterRoleSelectorsNested<A> addNewClusterRoleSelectorLike(LabelSelector item) {
    return new ClusterRoleSelectorsNested(-1, item);
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
  
  public A addToClusterRoleSelectors(LabelSelector... items) {
    if (this.clusterRoleSelectors == null) {
      this.clusterRoleSelectors = new ArrayList();
    }
    for (LabelSelector item : items) {
        LabelSelectorBuilder builder = new LabelSelectorBuilder(item);
        _visitables.get("clusterRoleSelectors").add(builder);
        this.clusterRoleSelectors.add(builder);
    }
    return (A) this;
  }
  
  public A addToClusterRoleSelectors(int index,LabelSelector item) {
    if (this.clusterRoleSelectors == null) {
      this.clusterRoleSelectors = new ArrayList();
    }
    LabelSelectorBuilder builder = new LabelSelectorBuilder(item);
    if (index < 0 || index >= clusterRoleSelectors.size()) {
        _visitables.get("clusterRoleSelectors").add(builder);
        clusterRoleSelectors.add(builder);
    } else {
        _visitables.get("clusterRoleSelectors").add(builder);
        clusterRoleSelectors.add(index, builder);
    }
    return (A) this;
  }
  
  public LabelSelector buildClusterRoleSelector(int index) {
    return this.clusterRoleSelectors.get(index).build();
  }
  
  public List<LabelSelector> buildClusterRoleSelectors() {
    return this.clusterRoleSelectors != null ? build(clusterRoleSelectors) : null;
  }
  
  public LabelSelector buildFirstClusterRoleSelector() {
    return this.clusterRoleSelectors.get(0).build();
  }
  
  public LabelSelector buildLastClusterRoleSelector() {
    return this.clusterRoleSelectors.get(clusterRoleSelectors.size() - 1).build();
  }
  
  public LabelSelector buildMatchingClusterRoleSelector(Predicate<LabelSelectorBuilder> predicate) {
      for (LabelSelectorBuilder item : clusterRoleSelectors) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(AggregationRule instance) {
    instance = instance != null ? instance : new AggregationRule();
    if (instance != null) {
        this.withClusterRoleSelectors(instance.getClusterRoleSelectors());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ClusterRoleSelectorsNested<A> editClusterRoleSelector(int index) {
    if (clusterRoleSelectors.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "clusterRoleSelectors"));
    }
    return this.setNewClusterRoleSelectorLike(index, this.buildClusterRoleSelector(index));
  }
  
  public ClusterRoleSelectorsNested<A> editFirstClusterRoleSelector() {
    if (clusterRoleSelectors.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "clusterRoleSelectors"));
    }
    return this.setNewClusterRoleSelectorLike(0, this.buildClusterRoleSelector(0));
  }
  
  public ClusterRoleSelectorsNested<A> editLastClusterRoleSelector() {
    int index = clusterRoleSelectors.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "clusterRoleSelectors"));
    }
    return this.setNewClusterRoleSelectorLike(index, this.buildClusterRoleSelector(index));
  }
  
  public ClusterRoleSelectorsNested<A> editMatchingClusterRoleSelector(Predicate<LabelSelectorBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < clusterRoleSelectors.size();i++) {
      if (predicate.test(clusterRoleSelectors.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "clusterRoleSelectors"));
    }
    return this.setNewClusterRoleSelectorLike(index, this.buildClusterRoleSelector(index));
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
    AggregationRuleFluent that = (AggregationRuleFluent) o;
    if (!(Objects.equals(clusterRoleSelectors, that.clusterRoleSelectors))) {
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
  
  public boolean hasClusterRoleSelectors() {
    return this.clusterRoleSelectors != null && !(this.clusterRoleSelectors.isEmpty());
  }
  
  public boolean hasMatchingClusterRoleSelector(Predicate<LabelSelectorBuilder> predicate) {
      for (LabelSelectorBuilder item : clusterRoleSelectors) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(clusterRoleSelectors, additionalProperties);
  }
  
  public A removeAllFromClusterRoleSelectors(Collection<LabelSelector> items) {
    if (this.clusterRoleSelectors == null) {
      return (A) this;
    }
    for (LabelSelector item : items) {
        LabelSelectorBuilder builder = new LabelSelectorBuilder(item);
        _visitables.get("clusterRoleSelectors").remove(builder);
        this.clusterRoleSelectors.remove(builder);
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
  
  public A removeFromClusterRoleSelectors(LabelSelector... items) {
    if (this.clusterRoleSelectors == null) {
      return (A) this;
    }
    for (LabelSelector item : items) {
        LabelSelectorBuilder builder = new LabelSelectorBuilder(item);
        _visitables.get("clusterRoleSelectors").remove(builder);
        this.clusterRoleSelectors.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromClusterRoleSelectors(Predicate<LabelSelectorBuilder> predicate) {
    if (clusterRoleSelectors == null) {
      return (A) this;
    }
    Iterator<LabelSelectorBuilder> each = clusterRoleSelectors.iterator();
    List visitables = _visitables.get("clusterRoleSelectors");
    while (each.hasNext()) {
        LabelSelectorBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ClusterRoleSelectorsNested<A> setNewClusterRoleSelectorLike(int index,LabelSelector item) {
    return new ClusterRoleSelectorsNested(index, item);
  }
  
  public A setToClusterRoleSelectors(int index,LabelSelector item) {
    if (this.clusterRoleSelectors == null) {
      this.clusterRoleSelectors = new ArrayList();
    }
    LabelSelectorBuilder builder = new LabelSelectorBuilder(item);
    if (index < 0 || index >= clusterRoleSelectors.size()) {
        _visitables.get("clusterRoleSelectors").add(builder);
        clusterRoleSelectors.add(builder);
    } else {
        _visitables.get("clusterRoleSelectors").add(builder);
        clusterRoleSelectors.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(clusterRoleSelectors == null) && !(clusterRoleSelectors.isEmpty())) {
        sb.append("clusterRoleSelectors:");
        sb.append(clusterRoleSelectors);
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
  
  public A withClusterRoleSelectors(List<LabelSelector> clusterRoleSelectors) {
    if (this.clusterRoleSelectors != null) {
      this._visitables.get("clusterRoleSelectors").clear();
    }
    if (clusterRoleSelectors != null) {
        this.clusterRoleSelectors = new ArrayList();
        for (LabelSelector item : clusterRoleSelectors) {
          this.addToClusterRoleSelectors(item);
        }
    } else {
      this.clusterRoleSelectors = null;
    }
    return (A) this;
  }
  
  public A withClusterRoleSelectors(LabelSelector... clusterRoleSelectors) {
    if (this.clusterRoleSelectors != null) {
        this.clusterRoleSelectors.clear();
        _visitables.remove("clusterRoleSelectors");
    }
    if (clusterRoleSelectors != null) {
      for (LabelSelector item : clusterRoleSelectors) {
        this.addToClusterRoleSelectors(item);
      }
    }
    return (A) this;
  }
  public class ClusterRoleSelectorsNested<N> extends LabelSelectorFluent<ClusterRoleSelectorsNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
    int index;
  
    ClusterRoleSelectorsNested(int index,LabelSelector item) {
      this.index = index;
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) AggregationRuleFluent.this.setToClusterRoleSelectors(index, builder.build());
    }
    
    public N endClusterRoleSelector() {
      return and();
    }
    
  }
}