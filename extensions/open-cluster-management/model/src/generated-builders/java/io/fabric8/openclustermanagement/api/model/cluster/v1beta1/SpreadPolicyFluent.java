package io.fabric8.openclustermanagement.api.model.cluster.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class SpreadPolicyFluent<A extends io.fabric8.openclustermanagement.api.model.cluster.v1beta1.SpreadPolicyFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<SpreadConstraintsTermBuilder> spreadConstraints = new ArrayList<SpreadConstraintsTermBuilder>();

  public SpreadPolicyFluent() {
  }
  
  public SpreadPolicyFluent(SpreadPolicy instance) {
    this.copyInstance(instance);
  }

  public A addAllToSpreadConstraints(Collection<SpreadConstraintsTerm> items) {
    if (this.spreadConstraints == null) {
      this.spreadConstraints = new ArrayList();
    }
    for (SpreadConstraintsTerm item : items) {
        SpreadConstraintsTermBuilder builder = new SpreadConstraintsTermBuilder(item);
        _visitables.get("spreadConstraints").add(builder);
        this.spreadConstraints.add(builder);
    }
    return (A) this;
  }
  
  public SpreadConstraintsNested<A> addNewSpreadConstraint() {
    return new SpreadConstraintsNested(-1, null);
  }
  
  public A addNewSpreadConstraint(Integer maxSkew,String topologyKey,String topologyKeyType,String whenUnsatisfiable) {
    return (A) this.addToSpreadConstraints(new SpreadConstraintsTerm(maxSkew, topologyKey, topologyKeyType, whenUnsatisfiable));
  }
  
  public SpreadConstraintsNested<A> addNewSpreadConstraintLike(SpreadConstraintsTerm item) {
    return new SpreadConstraintsNested(-1, item);
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
  
  public A addToSpreadConstraints(SpreadConstraintsTerm... items) {
    if (this.spreadConstraints == null) {
      this.spreadConstraints = new ArrayList();
    }
    for (SpreadConstraintsTerm item : items) {
        SpreadConstraintsTermBuilder builder = new SpreadConstraintsTermBuilder(item);
        _visitables.get("spreadConstraints").add(builder);
        this.spreadConstraints.add(builder);
    }
    return (A) this;
  }
  
  public A addToSpreadConstraints(int index,SpreadConstraintsTerm item) {
    if (this.spreadConstraints == null) {
      this.spreadConstraints = new ArrayList();
    }
    SpreadConstraintsTermBuilder builder = new SpreadConstraintsTermBuilder(item);
    if (index < 0 || index >= spreadConstraints.size()) {
        _visitables.get("spreadConstraints").add(builder);
        spreadConstraints.add(builder);
    } else {
        _visitables.get("spreadConstraints").add(builder);
        spreadConstraints.add(index, builder);
    }
    return (A) this;
  }
  
  public SpreadConstraintsTerm buildFirstSpreadConstraint() {
    return this.spreadConstraints.get(0).build();
  }
  
  public SpreadConstraintsTerm buildLastSpreadConstraint() {
    return this.spreadConstraints.get(spreadConstraints.size() - 1).build();
  }
  
  public SpreadConstraintsTerm buildMatchingSpreadConstraint(Predicate<SpreadConstraintsTermBuilder> predicate) {
      for (SpreadConstraintsTermBuilder item : spreadConstraints) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public SpreadConstraintsTerm buildSpreadConstraint(int index) {
    return this.spreadConstraints.get(index).build();
  }
  
  public List<SpreadConstraintsTerm> buildSpreadConstraints() {
    return this.spreadConstraints != null ? build(spreadConstraints) : null;
  }
  
  protected void copyInstance(SpreadPolicy instance) {
    instance = instance != null ? instance : new SpreadPolicy();
    if (instance != null) {
        this.withSpreadConstraints(instance.getSpreadConstraints());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SpreadConstraintsNested<A> editFirstSpreadConstraint() {
    if (spreadConstraints.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "spreadConstraints"));
    }
    return this.setNewSpreadConstraintLike(0, this.buildSpreadConstraint(0));
  }
  
  public SpreadConstraintsNested<A> editLastSpreadConstraint() {
    int index = spreadConstraints.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "spreadConstraints"));
    }
    return this.setNewSpreadConstraintLike(index, this.buildSpreadConstraint(index));
  }
  
  public SpreadConstraintsNested<A> editMatchingSpreadConstraint(Predicate<SpreadConstraintsTermBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < spreadConstraints.size();i++) {
      if (predicate.test(spreadConstraints.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "spreadConstraints"));
    }
    return this.setNewSpreadConstraintLike(index, this.buildSpreadConstraint(index));
  }
  
  public SpreadConstraintsNested<A> editSpreadConstraint(int index) {
    if (spreadConstraints.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "spreadConstraints"));
    }
    return this.setNewSpreadConstraintLike(index, this.buildSpreadConstraint(index));
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
    SpreadPolicyFluent that = (SpreadPolicyFluent) o;
    if (!(Objects.equals(spreadConstraints, that.spreadConstraints))) {
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
  
  public boolean hasMatchingSpreadConstraint(Predicate<SpreadConstraintsTermBuilder> predicate) {
      for (SpreadConstraintsTermBuilder item : spreadConstraints) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasSpreadConstraints() {
    return this.spreadConstraints != null && !(this.spreadConstraints.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(spreadConstraints, additionalProperties);
  }
  
  public A removeAllFromSpreadConstraints(Collection<SpreadConstraintsTerm> items) {
    if (this.spreadConstraints == null) {
      return (A) this;
    }
    for (SpreadConstraintsTerm item : items) {
        SpreadConstraintsTermBuilder builder = new SpreadConstraintsTermBuilder(item);
        _visitables.get("spreadConstraints").remove(builder);
        this.spreadConstraints.remove(builder);
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
  
  public A removeFromSpreadConstraints(SpreadConstraintsTerm... items) {
    if (this.spreadConstraints == null) {
      return (A) this;
    }
    for (SpreadConstraintsTerm item : items) {
        SpreadConstraintsTermBuilder builder = new SpreadConstraintsTermBuilder(item);
        _visitables.get("spreadConstraints").remove(builder);
        this.spreadConstraints.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromSpreadConstraints(Predicate<SpreadConstraintsTermBuilder> predicate) {
    if (spreadConstraints == null) {
      return (A) this;
    }
    Iterator<SpreadConstraintsTermBuilder> each = spreadConstraints.iterator();
    List visitables = _visitables.get("spreadConstraints");
    while (each.hasNext()) {
        SpreadConstraintsTermBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public SpreadConstraintsNested<A> setNewSpreadConstraintLike(int index,SpreadConstraintsTerm item) {
    return new SpreadConstraintsNested(index, item);
  }
  
  public A setToSpreadConstraints(int index,SpreadConstraintsTerm item) {
    if (this.spreadConstraints == null) {
      this.spreadConstraints = new ArrayList();
    }
    SpreadConstraintsTermBuilder builder = new SpreadConstraintsTermBuilder(item);
    if (index < 0 || index >= spreadConstraints.size()) {
        _visitables.get("spreadConstraints").add(builder);
        spreadConstraints.add(builder);
    } else {
        _visitables.get("spreadConstraints").add(builder);
        spreadConstraints.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(spreadConstraints == null) && !(spreadConstraints.isEmpty())) {
        sb.append("spreadConstraints:");
        sb.append(spreadConstraints);
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
  
  public A withSpreadConstraints(List<SpreadConstraintsTerm> spreadConstraints) {
    if (this.spreadConstraints != null) {
      this._visitables.get("spreadConstraints").clear();
    }
    if (spreadConstraints != null) {
        this.spreadConstraints = new ArrayList();
        for (SpreadConstraintsTerm item : spreadConstraints) {
          this.addToSpreadConstraints(item);
        }
    } else {
      this.spreadConstraints = null;
    }
    return (A) this;
  }
  
  public A withSpreadConstraints(SpreadConstraintsTerm... spreadConstraints) {
    if (this.spreadConstraints != null) {
        this.spreadConstraints.clear();
        _visitables.remove("spreadConstraints");
    }
    if (spreadConstraints != null) {
      for (SpreadConstraintsTerm item : spreadConstraints) {
        this.addToSpreadConstraints(item);
      }
    }
    return (A) this;
  }
  public class SpreadConstraintsNested<N> extends SpreadConstraintsTermFluent<SpreadConstraintsNested<N>> implements Nested<N>{
  
    SpreadConstraintsTermBuilder builder;
    int index;
  
    SpreadConstraintsNested(int index,SpreadConstraintsTerm item) {
      this.index = index;
      this.builder = new SpreadConstraintsTermBuilder(this, item);
    }
  
    public N and() {
      return (N) SpreadPolicyFluent.this.setToSpreadConstraints(index, builder.build());
    }
    
    public N endSpreadConstraint() {
      return and();
    }
    
  }
}