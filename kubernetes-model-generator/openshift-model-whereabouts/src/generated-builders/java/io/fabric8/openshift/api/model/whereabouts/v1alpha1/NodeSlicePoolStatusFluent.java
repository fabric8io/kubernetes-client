package io.fabric8.openshift.api.model.whereabouts.v1alpha1;

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
public class NodeSlicePoolStatusFluent<A extends io.fabric8.openshift.api.model.whereabouts.v1alpha1.NodeSlicePoolStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<NodeSlicePoolStatusAllocationsBuilder> allocations = new ArrayList<NodeSlicePoolStatusAllocationsBuilder>();

  public NodeSlicePoolStatusFluent() {
  }
  
  public NodeSlicePoolStatusFluent(NodeSlicePoolStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToAllocations(Collection<NodeSlicePoolStatusAllocations> items) {
    if (this.allocations == null) {
      this.allocations = new ArrayList();
    }
    for (NodeSlicePoolStatusAllocations item : items) {
        NodeSlicePoolStatusAllocationsBuilder builder = new NodeSlicePoolStatusAllocationsBuilder(item);
        _visitables.get("allocations").add(builder);
        this.allocations.add(builder);
    }
    return (A) this;
  }
  
  public AllocationsNested<A> addNewAllocation() {
    return new AllocationsNested(-1, null);
  }
  
  public A addNewAllocation(String nodeName,String sliceRange) {
    return (A) this.addToAllocations(new NodeSlicePoolStatusAllocations(nodeName, sliceRange));
  }
  
  public AllocationsNested<A> addNewAllocationLike(NodeSlicePoolStatusAllocations item) {
    return new AllocationsNested(-1, item);
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
  
  public A addToAllocations(NodeSlicePoolStatusAllocations... items) {
    if (this.allocations == null) {
      this.allocations = new ArrayList();
    }
    for (NodeSlicePoolStatusAllocations item : items) {
        NodeSlicePoolStatusAllocationsBuilder builder = new NodeSlicePoolStatusAllocationsBuilder(item);
        _visitables.get("allocations").add(builder);
        this.allocations.add(builder);
    }
    return (A) this;
  }
  
  public A addToAllocations(int index,NodeSlicePoolStatusAllocations item) {
    if (this.allocations == null) {
      this.allocations = new ArrayList();
    }
    NodeSlicePoolStatusAllocationsBuilder builder = new NodeSlicePoolStatusAllocationsBuilder(item);
    if (index < 0 || index >= allocations.size()) {
        _visitables.get("allocations").add(builder);
        allocations.add(builder);
    } else {
        _visitables.get("allocations").add(builder);
        allocations.add(index, builder);
    }
    return (A) this;
  }
  
  public NodeSlicePoolStatusAllocations buildAllocation(int index) {
    return this.allocations.get(index).build();
  }
  
  public List<NodeSlicePoolStatusAllocations> buildAllocations() {
    return this.allocations != null ? build(allocations) : null;
  }
  
  public NodeSlicePoolStatusAllocations buildFirstAllocation() {
    return this.allocations.get(0).build();
  }
  
  public NodeSlicePoolStatusAllocations buildLastAllocation() {
    return this.allocations.get(allocations.size() - 1).build();
  }
  
  public NodeSlicePoolStatusAllocations buildMatchingAllocation(Predicate<NodeSlicePoolStatusAllocationsBuilder> predicate) {
      for (NodeSlicePoolStatusAllocationsBuilder item : allocations) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(NodeSlicePoolStatus instance) {
    instance = instance != null ? instance : new NodeSlicePoolStatus();
    if (instance != null) {
        this.withAllocations(instance.getAllocations());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AllocationsNested<A> editAllocation(int index) {
    if (allocations.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "allocations"));
    }
    return this.setNewAllocationLike(index, this.buildAllocation(index));
  }
  
  public AllocationsNested<A> editFirstAllocation() {
    if (allocations.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "allocations"));
    }
    return this.setNewAllocationLike(0, this.buildAllocation(0));
  }
  
  public AllocationsNested<A> editLastAllocation() {
    int index = allocations.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "allocations"));
    }
    return this.setNewAllocationLike(index, this.buildAllocation(index));
  }
  
  public AllocationsNested<A> editMatchingAllocation(Predicate<NodeSlicePoolStatusAllocationsBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < allocations.size();i++) {
      if (predicate.test(allocations.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "allocations"));
    }
    return this.setNewAllocationLike(index, this.buildAllocation(index));
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
    NodeSlicePoolStatusFluent that = (NodeSlicePoolStatusFluent) o;
    if (!(Objects.equals(allocations, that.allocations))) {
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
  
  public boolean hasAllocations() {
    return this.allocations != null && !(this.allocations.isEmpty());
  }
  
  public boolean hasMatchingAllocation(Predicate<NodeSlicePoolStatusAllocationsBuilder> predicate) {
      for (NodeSlicePoolStatusAllocationsBuilder item : allocations) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(allocations, additionalProperties);
  }
  
  public A removeAllFromAllocations(Collection<NodeSlicePoolStatusAllocations> items) {
    if (this.allocations == null) {
      return (A) this;
    }
    for (NodeSlicePoolStatusAllocations item : items) {
        NodeSlicePoolStatusAllocationsBuilder builder = new NodeSlicePoolStatusAllocationsBuilder(item);
        _visitables.get("allocations").remove(builder);
        this.allocations.remove(builder);
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
  
  public A removeFromAllocations(NodeSlicePoolStatusAllocations... items) {
    if (this.allocations == null) {
      return (A) this;
    }
    for (NodeSlicePoolStatusAllocations item : items) {
        NodeSlicePoolStatusAllocationsBuilder builder = new NodeSlicePoolStatusAllocationsBuilder(item);
        _visitables.get("allocations").remove(builder);
        this.allocations.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromAllocations(Predicate<NodeSlicePoolStatusAllocationsBuilder> predicate) {
    if (allocations == null) {
      return (A) this;
    }
    Iterator<NodeSlicePoolStatusAllocationsBuilder> each = allocations.iterator();
    List visitables = _visitables.get("allocations");
    while (each.hasNext()) {
        NodeSlicePoolStatusAllocationsBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public AllocationsNested<A> setNewAllocationLike(int index,NodeSlicePoolStatusAllocations item) {
    return new AllocationsNested(index, item);
  }
  
  public A setToAllocations(int index,NodeSlicePoolStatusAllocations item) {
    if (this.allocations == null) {
      this.allocations = new ArrayList();
    }
    NodeSlicePoolStatusAllocationsBuilder builder = new NodeSlicePoolStatusAllocationsBuilder(item);
    if (index < 0 || index >= allocations.size()) {
        _visitables.get("allocations").add(builder);
        allocations.add(builder);
    } else {
        _visitables.get("allocations").add(builder);
        allocations.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(allocations == null) && !(allocations.isEmpty())) {
        sb.append("allocations:");
        sb.append(allocations);
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
  
  public A withAllocations(List<NodeSlicePoolStatusAllocations> allocations) {
    if (this.allocations != null) {
      this._visitables.get("allocations").clear();
    }
    if (allocations != null) {
        this.allocations = new ArrayList();
        for (NodeSlicePoolStatusAllocations item : allocations) {
          this.addToAllocations(item);
        }
    } else {
      this.allocations = null;
    }
    return (A) this;
  }
  
  public A withAllocations(NodeSlicePoolStatusAllocations... allocations) {
    if (this.allocations != null) {
        this.allocations.clear();
        _visitables.remove("allocations");
    }
    if (allocations != null) {
      for (NodeSlicePoolStatusAllocations item : allocations) {
        this.addToAllocations(item);
      }
    }
    return (A) this;
  }
  public class AllocationsNested<N> extends NodeSlicePoolStatusAllocationsFluent<AllocationsNested<N>> implements Nested<N>{
  
    NodeSlicePoolStatusAllocationsBuilder builder;
    int index;
  
    AllocationsNested(int index,NodeSlicePoolStatusAllocations item) {
      this.index = index;
      this.builder = new NodeSlicePoolStatusAllocationsBuilder(this, item);
    }
  
    public N and() {
      return (N) NodeSlicePoolStatusFluent.this.setToAllocations(index, builder.build());
    }
    
    public N endAllocation() {
      return and();
    }
    
  }
}