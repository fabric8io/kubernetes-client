package io.fabric8.kubernetes.api.model;

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
public class NodeAllocatableResourceClaimStatusFluent<A extends io.fabric8.kubernetes.api.model.NodeAllocatableResourceClaimStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> containers = new ArrayList<String>();
  private ArrayList<NodeAllocatableMappedResourcesBuilder> mapping = new ArrayList<NodeAllocatableMappedResourcesBuilder>();
  private ArrayList<NodeAllocatableOverheadResourcesBuilder> overhead = new ArrayList<NodeAllocatableOverheadResourcesBuilder>();
  private String resourceClaimName;

  public NodeAllocatableResourceClaimStatusFluent() {
  }
  
  public NodeAllocatableResourceClaimStatusFluent(NodeAllocatableResourceClaimStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToContainers(Collection<String> items) {
    if (this.containers == null) {
      this.containers = new ArrayList();
    }
    for (String item : items) {
      this.containers.add(item);
    }
    return (A) this;
  }
  
  public A addAllToMapping(Collection<NodeAllocatableMappedResources> items) {
    if (this.mapping == null) {
      this.mapping = new ArrayList();
    }
    for (NodeAllocatableMappedResources item : items) {
        NodeAllocatableMappedResourcesBuilder builder = new NodeAllocatableMappedResourcesBuilder(item);
        _visitables.get("mapping").add(builder);
        this.mapping.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToOverhead(Collection<NodeAllocatableOverheadResources> items) {
    if (this.overhead == null) {
      this.overhead = new ArrayList();
    }
    for (NodeAllocatableOverheadResources item : items) {
        NodeAllocatableOverheadResourcesBuilder builder = new NodeAllocatableOverheadResourcesBuilder(item);
        _visitables.get("overhead").add(builder);
        this.overhead.add(builder);
    }
    return (A) this;
  }
  
  public MappingNested<A> addNewMapping() {
    return new MappingNested(-1, null);
  }
  
  public MappingNested<A> addNewMappingLike(NodeAllocatableMappedResources item) {
    return new MappingNested(-1, item);
  }
  
  public OverheadNested<A> addNewOverhead() {
    return new OverheadNested(-1, null);
  }
  
  public OverheadNested<A> addNewOverheadLike(NodeAllocatableOverheadResources item) {
    return new OverheadNested(-1, item);
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
  
  public A addToContainers(String... items) {
    if (this.containers == null) {
      this.containers = new ArrayList();
    }
    for (String item : items) {
      this.containers.add(item);
    }
    return (A) this;
  }
  
  public A addToContainers(int index,String item) {
    if (this.containers == null) {
      this.containers = new ArrayList();
    }
    this.containers.add(index, item);
    return (A) this;
  }
  
  public A addToMapping(NodeAllocatableMappedResources... items) {
    if (this.mapping == null) {
      this.mapping = new ArrayList();
    }
    for (NodeAllocatableMappedResources item : items) {
        NodeAllocatableMappedResourcesBuilder builder = new NodeAllocatableMappedResourcesBuilder(item);
        _visitables.get("mapping").add(builder);
        this.mapping.add(builder);
    }
    return (A) this;
  }
  
  public A addToMapping(int index,NodeAllocatableMappedResources item) {
    if (this.mapping == null) {
      this.mapping = new ArrayList();
    }
    NodeAllocatableMappedResourcesBuilder builder = new NodeAllocatableMappedResourcesBuilder(item);
    if (index < 0 || index >= mapping.size()) {
        _visitables.get("mapping").add(builder);
        mapping.add(builder);
    } else {
        _visitables.get("mapping").add(builder);
        mapping.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToOverhead(NodeAllocatableOverheadResources... items) {
    if (this.overhead == null) {
      this.overhead = new ArrayList();
    }
    for (NodeAllocatableOverheadResources item : items) {
        NodeAllocatableOverheadResourcesBuilder builder = new NodeAllocatableOverheadResourcesBuilder(item);
        _visitables.get("overhead").add(builder);
        this.overhead.add(builder);
    }
    return (A) this;
  }
  
  public A addToOverhead(int index,NodeAllocatableOverheadResources item) {
    if (this.overhead == null) {
      this.overhead = new ArrayList();
    }
    NodeAllocatableOverheadResourcesBuilder builder = new NodeAllocatableOverheadResourcesBuilder(item);
    if (index < 0 || index >= overhead.size()) {
        _visitables.get("overhead").add(builder);
        overhead.add(builder);
    } else {
        _visitables.get("overhead").add(builder);
        overhead.add(index, builder);
    }
    return (A) this;
  }
  
  public NodeAllocatableMappedResources buildFirstMapping() {
    return this.mapping.get(0).build();
  }
  
  public NodeAllocatableOverheadResources buildFirstOverhead() {
    return this.overhead.get(0).build();
  }
  
  public NodeAllocatableMappedResources buildLastMapping() {
    return this.mapping.get(mapping.size() - 1).build();
  }
  
  public NodeAllocatableOverheadResources buildLastOverhead() {
    return this.overhead.get(overhead.size() - 1).build();
  }
  
  public List<NodeAllocatableMappedResources> buildMapping() {
    return this.mapping != null ? build(mapping) : null;
  }
  
  public NodeAllocatableMappedResources buildMapping(int index) {
    return this.mapping.get(index).build();
  }
  
  public NodeAllocatableMappedResources buildMatchingMapping(Predicate<NodeAllocatableMappedResourcesBuilder> predicate) {
      for (NodeAllocatableMappedResourcesBuilder item : mapping) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public NodeAllocatableOverheadResources buildMatchingOverhead(Predicate<NodeAllocatableOverheadResourcesBuilder> predicate) {
      for (NodeAllocatableOverheadResourcesBuilder item : overhead) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public List<NodeAllocatableOverheadResources> buildOverhead() {
    return this.overhead != null ? build(overhead) : null;
  }
  
  public NodeAllocatableOverheadResources buildOverhead(int index) {
    return this.overhead.get(index).build();
  }
  
  protected void copyInstance(NodeAllocatableResourceClaimStatus instance) {
    instance = instance != null ? instance : new NodeAllocatableResourceClaimStatus();
    if (instance != null) {
        this.withContainers(instance.getContainers());
        this.withMapping(instance.getMapping());
        this.withOverhead(instance.getOverhead());
        this.withResourceClaimName(instance.getResourceClaimName());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MappingNested<A> editFirstMapping() {
    if (mapping.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "mapping"));
    }
    return this.setNewMappingLike(0, this.buildMapping(0));
  }
  
  public OverheadNested<A> editFirstOverhead() {
    if (overhead.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "overhead"));
    }
    return this.setNewOverheadLike(0, this.buildOverhead(0));
  }
  
  public MappingNested<A> editLastMapping() {
    int index = mapping.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "mapping"));
    }
    return this.setNewMappingLike(index, this.buildMapping(index));
  }
  
  public OverheadNested<A> editLastOverhead() {
    int index = overhead.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "overhead"));
    }
    return this.setNewOverheadLike(index, this.buildOverhead(index));
  }
  
  public MappingNested<A> editMapping(int index) {
    if (mapping.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "mapping"));
    }
    return this.setNewMappingLike(index, this.buildMapping(index));
  }
  
  public MappingNested<A> editMatchingMapping(Predicate<NodeAllocatableMappedResourcesBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < mapping.size();i++) {
      if (predicate.test(mapping.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "mapping"));
    }
    return this.setNewMappingLike(index, this.buildMapping(index));
  }
  
  public OverheadNested<A> editMatchingOverhead(Predicate<NodeAllocatableOverheadResourcesBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < overhead.size();i++) {
      if (predicate.test(overhead.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "overhead"));
    }
    return this.setNewOverheadLike(index, this.buildOverhead(index));
  }
  
  public OverheadNested<A> editOverhead(int index) {
    if (overhead.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "overhead"));
    }
    return this.setNewOverheadLike(index, this.buildOverhead(index));
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
    NodeAllocatableResourceClaimStatusFluent that = (NodeAllocatableResourceClaimStatusFluent) o;
    if (!(Objects.equals(containers, that.containers))) {
      return false;
    }
    if (!(Objects.equals(mapping, that.mapping))) {
      return false;
    }
    if (!(Objects.equals(overhead, that.overhead))) {
      return false;
    }
    if (!(Objects.equals(resourceClaimName, that.resourceClaimName))) {
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
  
  public String getContainer(int index) {
    return this.containers.get(index);
  }
  
  public List<String> getContainers() {
    return this.containers;
  }
  
  public String getFirstContainer() {
    return this.containers.get(0);
  }
  
  public String getLastContainer() {
    return this.containers.get(containers.size() - 1);
  }
  
  public String getMatchingContainer(Predicate<String> predicate) {
      for (String item : containers) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getResourceClaimName() {
    return this.resourceClaimName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasContainers() {
    return this.containers != null && !(this.containers.isEmpty());
  }
  
  public boolean hasMapping() {
    return this.mapping != null && !(this.mapping.isEmpty());
  }
  
  public boolean hasMatchingContainer(Predicate<String> predicate) {
      for (String item : containers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingMapping(Predicate<NodeAllocatableMappedResourcesBuilder> predicate) {
      for (NodeAllocatableMappedResourcesBuilder item : mapping) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingOverhead(Predicate<NodeAllocatableOverheadResourcesBuilder> predicate) {
      for (NodeAllocatableOverheadResourcesBuilder item : overhead) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasOverhead() {
    return this.overhead != null && !(this.overhead.isEmpty());
  }
  
  public boolean hasResourceClaimName() {
    return this.resourceClaimName != null;
  }
  
  public int hashCode() {
    return Objects.hash(containers, mapping, overhead, resourceClaimName, additionalProperties);
  }
  
  public A removeAllFromContainers(Collection<String> items) {
    if (this.containers == null) {
      return (A) this;
    }
    for (String item : items) {
      this.containers.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromMapping(Collection<NodeAllocatableMappedResources> items) {
    if (this.mapping == null) {
      return (A) this;
    }
    for (NodeAllocatableMappedResources item : items) {
        NodeAllocatableMappedResourcesBuilder builder = new NodeAllocatableMappedResourcesBuilder(item);
        _visitables.get("mapping").remove(builder);
        this.mapping.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromOverhead(Collection<NodeAllocatableOverheadResources> items) {
    if (this.overhead == null) {
      return (A) this;
    }
    for (NodeAllocatableOverheadResources item : items) {
        NodeAllocatableOverheadResourcesBuilder builder = new NodeAllocatableOverheadResourcesBuilder(item);
        _visitables.get("overhead").remove(builder);
        this.overhead.remove(builder);
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
  
  public A removeFromContainers(String... items) {
    if (this.containers == null) {
      return (A) this;
    }
    for (String item : items) {
      this.containers.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromMapping(NodeAllocatableMappedResources... items) {
    if (this.mapping == null) {
      return (A) this;
    }
    for (NodeAllocatableMappedResources item : items) {
        NodeAllocatableMappedResourcesBuilder builder = new NodeAllocatableMappedResourcesBuilder(item);
        _visitables.get("mapping").remove(builder);
        this.mapping.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromOverhead(NodeAllocatableOverheadResources... items) {
    if (this.overhead == null) {
      return (A) this;
    }
    for (NodeAllocatableOverheadResources item : items) {
        NodeAllocatableOverheadResourcesBuilder builder = new NodeAllocatableOverheadResourcesBuilder(item);
        _visitables.get("overhead").remove(builder);
        this.overhead.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromMapping(Predicate<NodeAllocatableMappedResourcesBuilder> predicate) {
    if (mapping == null) {
      return (A) this;
    }
    Iterator<NodeAllocatableMappedResourcesBuilder> each = mapping.iterator();
    List visitables = _visitables.get("mapping");
    while (each.hasNext()) {
        NodeAllocatableMappedResourcesBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromOverhead(Predicate<NodeAllocatableOverheadResourcesBuilder> predicate) {
    if (overhead == null) {
      return (A) this;
    }
    Iterator<NodeAllocatableOverheadResourcesBuilder> each = overhead.iterator();
    List visitables = _visitables.get("overhead");
    while (each.hasNext()) {
        NodeAllocatableOverheadResourcesBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public MappingNested<A> setNewMappingLike(int index,NodeAllocatableMappedResources item) {
    return new MappingNested(index, item);
  }
  
  public OverheadNested<A> setNewOverheadLike(int index,NodeAllocatableOverheadResources item) {
    return new OverheadNested(index, item);
  }
  
  public A setToContainers(int index,String item) {
    if (this.containers == null) {
      this.containers = new ArrayList();
    }
    this.containers.set(index, item);
    return (A) this;
  }
  
  public A setToMapping(int index,NodeAllocatableMappedResources item) {
    if (this.mapping == null) {
      this.mapping = new ArrayList();
    }
    NodeAllocatableMappedResourcesBuilder builder = new NodeAllocatableMappedResourcesBuilder(item);
    if (index < 0 || index >= mapping.size()) {
        _visitables.get("mapping").add(builder);
        mapping.add(builder);
    } else {
        _visitables.get("mapping").add(builder);
        mapping.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToOverhead(int index,NodeAllocatableOverheadResources item) {
    if (this.overhead == null) {
      this.overhead = new ArrayList();
    }
    NodeAllocatableOverheadResourcesBuilder builder = new NodeAllocatableOverheadResourcesBuilder(item);
    if (index < 0 || index >= overhead.size()) {
        _visitables.get("overhead").add(builder);
        overhead.add(builder);
    } else {
        _visitables.get("overhead").add(builder);
        overhead.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(containers == null) && !(containers.isEmpty())) {
        sb.append("containers:");
        sb.append(containers);
        sb.append(",");
    }
    if (!(mapping == null) && !(mapping.isEmpty())) {
        sb.append("mapping:");
        sb.append(mapping);
        sb.append(",");
    }
    if (!(overhead == null) && !(overhead.isEmpty())) {
        sb.append("overhead:");
        sb.append(overhead);
        sb.append(",");
    }
    if (!(resourceClaimName == null)) {
        sb.append("resourceClaimName:");
        sb.append(resourceClaimName);
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
  
  public A withContainers(List<String> containers) {
    if (containers != null) {
        this.containers = new ArrayList();
        for (String item : containers) {
          this.addToContainers(item);
        }
    } else {
      this.containers = null;
    }
    return (A) this;
  }
  
  public A withContainers(String... containers) {
    if (this.containers != null) {
        this.containers.clear();
        _visitables.remove("containers");
    }
    if (containers != null) {
      for (String item : containers) {
        this.addToContainers(item);
      }
    }
    return (A) this;
  }
  
  public A withMapping(List<NodeAllocatableMappedResources> mapping) {
    if (this.mapping != null) {
      this._visitables.get("mapping").clear();
    }
    if (mapping != null) {
        this.mapping = new ArrayList();
        for (NodeAllocatableMappedResources item : mapping) {
          this.addToMapping(item);
        }
    } else {
      this.mapping = null;
    }
    return (A) this;
  }
  
  public A withMapping(NodeAllocatableMappedResources... mapping) {
    if (this.mapping != null) {
        this.mapping.clear();
        _visitables.remove("mapping");
    }
    if (mapping != null) {
      for (NodeAllocatableMappedResources item : mapping) {
        this.addToMapping(item);
      }
    }
    return (A) this;
  }
  
  public A withOverhead(List<NodeAllocatableOverheadResources> overhead) {
    if (this.overhead != null) {
      this._visitables.get("overhead").clear();
    }
    if (overhead != null) {
        this.overhead = new ArrayList();
        for (NodeAllocatableOverheadResources item : overhead) {
          this.addToOverhead(item);
        }
    } else {
      this.overhead = null;
    }
    return (A) this;
  }
  
  public A withOverhead(NodeAllocatableOverheadResources... overhead) {
    if (this.overhead != null) {
        this.overhead.clear();
        _visitables.remove("overhead");
    }
    if (overhead != null) {
      for (NodeAllocatableOverheadResources item : overhead) {
        this.addToOverhead(item);
      }
    }
    return (A) this;
  }
  
  public A withResourceClaimName(String resourceClaimName) {
    this.resourceClaimName = resourceClaimName;
    return (A) this;
  }
  public class MappingNested<N> extends NodeAllocatableMappedResourcesFluent<MappingNested<N>> implements Nested<N>{
  
    NodeAllocatableMappedResourcesBuilder builder;
    int index;
  
    MappingNested(int index,NodeAllocatableMappedResources item) {
      this.index = index;
      this.builder = new NodeAllocatableMappedResourcesBuilder(this, item);
    }
  
    public N and() {
      return (N) NodeAllocatableResourceClaimStatusFluent.this.setToMapping(index, builder.build());
    }
    
    public N endMapping() {
      return and();
    }
    
  }
  public class OverheadNested<N> extends NodeAllocatableOverheadResourcesFluent<OverheadNested<N>> implements Nested<N>{
  
    NodeAllocatableOverheadResourcesBuilder builder;
    int index;
  
    OverheadNested(int index,NodeAllocatableOverheadResources item) {
      this.index = index;
      this.builder = new NodeAllocatableOverheadResourcesBuilder(this, item);
    }
  
    public N and() {
      return (N) NodeAllocatableResourceClaimStatusFluent.this.setToOverhead(index, builder.build());
    }
    
    public N endOverhead() {
      return and();
    }
    
  }
}