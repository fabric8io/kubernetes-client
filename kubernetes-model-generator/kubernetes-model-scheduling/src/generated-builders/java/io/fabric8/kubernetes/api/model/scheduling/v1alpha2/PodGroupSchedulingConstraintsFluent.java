package io.fabric8.kubernetes.api.model.scheduling.v1alpha2;

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
public class PodGroupSchedulingConstraintsFluent<A extends io.fabric8.kubernetes.api.model.scheduling.v1alpha2.PodGroupSchedulingConstraintsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<TopologyConstraintBuilder> topology = new ArrayList<TopologyConstraintBuilder>();

  public PodGroupSchedulingConstraintsFluent() {
  }
  
  public PodGroupSchedulingConstraintsFluent(PodGroupSchedulingConstraints instance) {
    this.copyInstance(instance);
  }

  public A addAllToTopology(Collection<TopologyConstraint> items) {
    if (this.topology == null) {
      this.topology = new ArrayList();
    }
    for (TopologyConstraint item : items) {
        TopologyConstraintBuilder builder = new TopologyConstraintBuilder(item);
        _visitables.get("topology").add(builder);
        this.topology.add(builder);
    }
    return (A) this;
  }
  
  public TopologyNested<A> addNewTopology() {
    return new TopologyNested(-1, null);
  }
  
  public A addNewTopology(String key) {
    return (A) this.addToTopology(new TopologyConstraint(key));
  }
  
  public TopologyNested<A> addNewTopologyLike(TopologyConstraint item) {
    return new TopologyNested(-1, item);
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
  
  public A addToTopology(TopologyConstraint... items) {
    if (this.topology == null) {
      this.topology = new ArrayList();
    }
    for (TopologyConstraint item : items) {
        TopologyConstraintBuilder builder = new TopologyConstraintBuilder(item);
        _visitables.get("topology").add(builder);
        this.topology.add(builder);
    }
    return (A) this;
  }
  
  public A addToTopology(int index,TopologyConstraint item) {
    if (this.topology == null) {
      this.topology = new ArrayList();
    }
    TopologyConstraintBuilder builder = new TopologyConstraintBuilder(item);
    if (index < 0 || index >= topology.size()) {
        _visitables.get("topology").add(builder);
        topology.add(builder);
    } else {
        _visitables.get("topology").add(builder);
        topology.add(index, builder);
    }
    return (A) this;
  }
  
  public TopologyConstraint buildFirstTopology() {
    return this.topology.get(0).build();
  }
  
  public TopologyConstraint buildLastTopology() {
    return this.topology.get(topology.size() - 1).build();
  }
  
  public TopologyConstraint buildMatchingTopology(Predicate<TopologyConstraintBuilder> predicate) {
      for (TopologyConstraintBuilder item : topology) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public List<TopologyConstraint> buildTopology() {
    return this.topology != null ? build(topology) : null;
  }
  
  public TopologyConstraint buildTopology(int index) {
    return this.topology.get(index).build();
  }
  
  protected void copyInstance(PodGroupSchedulingConstraints instance) {
    instance = instance != null ? instance : new PodGroupSchedulingConstraints();
    if (instance != null) {
        this.withTopology(instance.getTopology());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public TopologyNested<A> editFirstTopology() {
    if (topology.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "topology"));
    }
    return this.setNewTopologyLike(0, this.buildTopology(0));
  }
  
  public TopologyNested<A> editLastTopology() {
    int index = topology.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "topology"));
    }
    return this.setNewTopologyLike(index, this.buildTopology(index));
  }
  
  public TopologyNested<A> editMatchingTopology(Predicate<TopologyConstraintBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < topology.size();i++) {
      if (predicate.test(topology.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "topology"));
    }
    return this.setNewTopologyLike(index, this.buildTopology(index));
  }
  
  public TopologyNested<A> editTopology(int index) {
    if (topology.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "topology"));
    }
    return this.setNewTopologyLike(index, this.buildTopology(index));
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
    PodGroupSchedulingConstraintsFluent that = (PodGroupSchedulingConstraintsFluent) o;
    if (!(Objects.equals(topology, that.topology))) {
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
  
  public boolean hasMatchingTopology(Predicate<TopologyConstraintBuilder> predicate) {
      for (TopologyConstraintBuilder item : topology) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasTopology() {
    return this.topology != null && !(this.topology.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(topology, additionalProperties);
  }
  
  public A removeAllFromTopology(Collection<TopologyConstraint> items) {
    if (this.topology == null) {
      return (A) this;
    }
    for (TopologyConstraint item : items) {
        TopologyConstraintBuilder builder = new TopologyConstraintBuilder(item);
        _visitables.get("topology").remove(builder);
        this.topology.remove(builder);
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
  
  public A removeFromTopology(TopologyConstraint... items) {
    if (this.topology == null) {
      return (A) this;
    }
    for (TopologyConstraint item : items) {
        TopologyConstraintBuilder builder = new TopologyConstraintBuilder(item);
        _visitables.get("topology").remove(builder);
        this.topology.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromTopology(Predicate<TopologyConstraintBuilder> predicate) {
    if (topology == null) {
      return (A) this;
    }
    Iterator<TopologyConstraintBuilder> each = topology.iterator();
    List visitables = _visitables.get("topology");
    while (each.hasNext()) {
        TopologyConstraintBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public TopologyNested<A> setNewTopologyLike(int index,TopologyConstraint item) {
    return new TopologyNested(index, item);
  }
  
  public A setToTopology(int index,TopologyConstraint item) {
    if (this.topology == null) {
      this.topology = new ArrayList();
    }
    TopologyConstraintBuilder builder = new TopologyConstraintBuilder(item);
    if (index < 0 || index >= topology.size()) {
        _visitables.get("topology").add(builder);
        topology.add(builder);
    } else {
        _visitables.get("topology").add(builder);
        topology.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(topology == null) && !(topology.isEmpty())) {
        sb.append("topology:");
        sb.append(topology);
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
  
  public A withTopology(List<TopologyConstraint> topology) {
    if (this.topology != null) {
      this._visitables.get("topology").clear();
    }
    if (topology != null) {
        this.topology = new ArrayList();
        for (TopologyConstraint item : topology) {
          this.addToTopology(item);
        }
    } else {
      this.topology = null;
    }
    return (A) this;
  }
  
  public A withTopology(TopologyConstraint... topology) {
    if (this.topology != null) {
        this.topology.clear();
        _visitables.remove("topology");
    }
    if (topology != null) {
      for (TopologyConstraint item : topology) {
        this.addToTopology(item);
      }
    }
    return (A) this;
  }
  public class TopologyNested<N> extends TopologyConstraintFluent<TopologyNested<N>> implements Nested<N>{
  
    TopologyConstraintBuilder builder;
    int index;
  
    TopologyNested(int index,TopologyConstraint item) {
      this.index = index;
      this.builder = new TopologyConstraintBuilder(this, item);
    }
  
    public N and() {
      return (N) PodGroupSchedulingConstraintsFluent.this.setToTopology(index, builder.build());
    }
    
    public N endTopology() {
      return and();
    }
    
  }
}