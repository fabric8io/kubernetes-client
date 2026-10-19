package io.fabric8.volcano.api.model.nodeinfo.v1alpha1;

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
public class PodAllocationFluent<A extends io.fabric8.volcano.api.model.nodeinfo.v1alpha1.PodAllocationFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<ContainerAllocationBuilder> containerAllocations = new ArrayList<ContainerAllocationBuilder>();
  private String name;
  private String namespace;
  private String uid;

  public PodAllocationFluent() {
  }
  
  public PodAllocationFluent(PodAllocation instance) {
    this.copyInstance(instance);
  }

  public A addAllToContainerAllocations(Collection<ContainerAllocation> items) {
    if (this.containerAllocations == null) {
      this.containerAllocations = new ArrayList();
    }
    for (ContainerAllocation item : items) {
        ContainerAllocationBuilder builder = new ContainerAllocationBuilder(item);
        _visitables.get("containerAllocations").add(builder);
        this.containerAllocations.add(builder);
    }
    return (A) this;
  }
  
  public ContainerAllocationsNested<A> addNewContainerAllocation() {
    return new ContainerAllocationsNested(-1, null);
  }
  
  public ContainerAllocationsNested<A> addNewContainerAllocationLike(ContainerAllocation item) {
    return new ContainerAllocationsNested(-1, item);
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
  
  public A addToContainerAllocations(ContainerAllocation... items) {
    if (this.containerAllocations == null) {
      this.containerAllocations = new ArrayList();
    }
    for (ContainerAllocation item : items) {
        ContainerAllocationBuilder builder = new ContainerAllocationBuilder(item);
        _visitables.get("containerAllocations").add(builder);
        this.containerAllocations.add(builder);
    }
    return (A) this;
  }
  
  public A addToContainerAllocations(int index,ContainerAllocation item) {
    if (this.containerAllocations == null) {
      this.containerAllocations = new ArrayList();
    }
    ContainerAllocationBuilder builder = new ContainerAllocationBuilder(item);
    if (index < 0 || index >= containerAllocations.size()) {
        _visitables.get("containerAllocations").add(builder);
        containerAllocations.add(builder);
    } else {
        _visitables.get("containerAllocations").add(builder);
        containerAllocations.add(index, builder);
    }
    return (A) this;
  }
  
  public ContainerAllocation buildContainerAllocation(int index) {
    return this.containerAllocations.get(index).build();
  }
  
  public List<ContainerAllocation> buildContainerAllocations() {
    return this.containerAllocations != null ? build(containerAllocations) : null;
  }
  
  public ContainerAllocation buildFirstContainerAllocation() {
    return this.containerAllocations.get(0).build();
  }
  
  public ContainerAllocation buildLastContainerAllocation() {
    return this.containerAllocations.get(containerAllocations.size() - 1).build();
  }
  
  public ContainerAllocation buildMatchingContainerAllocation(Predicate<ContainerAllocationBuilder> predicate) {
      for (ContainerAllocationBuilder item : containerAllocations) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(PodAllocation instance) {
    instance = instance != null ? instance : new PodAllocation();
    if (instance != null) {
        this.withContainerAllocations(instance.getContainerAllocations());
        this.withName(instance.getName());
        this.withNamespace(instance.getNamespace());
        this.withUid(instance.getUid());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ContainerAllocationsNested<A> editContainerAllocation(int index) {
    if (containerAllocations.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "containerAllocations"));
    }
    return this.setNewContainerAllocationLike(index, this.buildContainerAllocation(index));
  }
  
  public ContainerAllocationsNested<A> editFirstContainerAllocation() {
    if (containerAllocations.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "containerAllocations"));
    }
    return this.setNewContainerAllocationLike(0, this.buildContainerAllocation(0));
  }
  
  public ContainerAllocationsNested<A> editLastContainerAllocation() {
    int index = containerAllocations.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "containerAllocations"));
    }
    return this.setNewContainerAllocationLike(index, this.buildContainerAllocation(index));
  }
  
  public ContainerAllocationsNested<A> editMatchingContainerAllocation(Predicate<ContainerAllocationBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < containerAllocations.size();i++) {
      if (predicate.test(containerAllocations.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "containerAllocations"));
    }
    return this.setNewContainerAllocationLike(index, this.buildContainerAllocation(index));
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
    PodAllocationFluent that = (PodAllocationFluent) o;
    if (!(Objects.equals(containerAllocations, that.containerAllocations))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(namespace, that.namespace))) {
      return false;
    }
    if (!(Objects.equals(uid, that.uid))) {
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
  
  public String getName() {
    return this.name;
  }
  
  public String getNamespace() {
    return this.namespace;
  }
  
  public String getUid() {
    return this.uid;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasContainerAllocations() {
    return this.containerAllocations != null && !(this.containerAllocations.isEmpty());
  }
  
  public boolean hasMatchingContainerAllocation(Predicate<ContainerAllocationBuilder> predicate) {
      for (ContainerAllocationBuilder item : containerAllocations) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasNamespace() {
    return this.namespace != null;
  }
  
  public boolean hasUid() {
    return this.uid != null;
  }
  
  public int hashCode() {
    return Objects.hash(containerAllocations, name, namespace, uid, additionalProperties);
  }
  
  public A removeAllFromContainerAllocations(Collection<ContainerAllocation> items) {
    if (this.containerAllocations == null) {
      return (A) this;
    }
    for (ContainerAllocation item : items) {
        ContainerAllocationBuilder builder = new ContainerAllocationBuilder(item);
        _visitables.get("containerAllocations").remove(builder);
        this.containerAllocations.remove(builder);
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
  
  public A removeFromContainerAllocations(ContainerAllocation... items) {
    if (this.containerAllocations == null) {
      return (A) this;
    }
    for (ContainerAllocation item : items) {
        ContainerAllocationBuilder builder = new ContainerAllocationBuilder(item);
        _visitables.get("containerAllocations").remove(builder);
        this.containerAllocations.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromContainerAllocations(Predicate<ContainerAllocationBuilder> predicate) {
    if (containerAllocations == null) {
      return (A) this;
    }
    Iterator<ContainerAllocationBuilder> each = containerAllocations.iterator();
    List visitables = _visitables.get("containerAllocations");
    while (each.hasNext()) {
        ContainerAllocationBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ContainerAllocationsNested<A> setNewContainerAllocationLike(int index,ContainerAllocation item) {
    return new ContainerAllocationsNested(index, item);
  }
  
  public A setToContainerAllocations(int index,ContainerAllocation item) {
    if (this.containerAllocations == null) {
      this.containerAllocations = new ArrayList();
    }
    ContainerAllocationBuilder builder = new ContainerAllocationBuilder(item);
    if (index < 0 || index >= containerAllocations.size()) {
        _visitables.get("containerAllocations").add(builder);
        containerAllocations.add(builder);
    } else {
        _visitables.get("containerAllocations").add(builder);
        containerAllocations.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(containerAllocations == null) && !(containerAllocations.isEmpty())) {
        sb.append("containerAllocations:");
        sb.append(containerAllocations);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(namespace == null)) {
        sb.append("namespace:");
        sb.append(namespace);
        sb.append(",");
    }
    if (!(uid == null)) {
        sb.append("uid:");
        sb.append(uid);
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
  
  public A withContainerAllocations(List<ContainerAllocation> containerAllocations) {
    if (this.containerAllocations != null) {
      this._visitables.get("containerAllocations").clear();
    }
    if (containerAllocations != null) {
        this.containerAllocations = new ArrayList();
        for (ContainerAllocation item : containerAllocations) {
          this.addToContainerAllocations(item);
        }
    } else {
      this.containerAllocations = null;
    }
    return (A) this;
  }
  
  public A withContainerAllocations(ContainerAllocation... containerAllocations) {
    if (this.containerAllocations != null) {
        this.containerAllocations.clear();
        _visitables.remove("containerAllocations");
    }
    if (containerAllocations != null) {
      for (ContainerAllocation item : containerAllocations) {
        this.addToContainerAllocations(item);
      }
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withNamespace(String namespace) {
    this.namespace = namespace;
    return (A) this;
  }
  
  public A withUid(String uid) {
    this.uid = uid;
    return (A) this;
  }
  public class ContainerAllocationsNested<N> extends ContainerAllocationFluent<ContainerAllocationsNested<N>> implements Nested<N>{
  
    ContainerAllocationBuilder builder;
    int index;
  
    ContainerAllocationsNested(int index,ContainerAllocation item) {
      this.index = index;
      this.builder = new ContainerAllocationBuilder(this, item);
    }
  
    public N and() {
      return (N) PodAllocationFluent.this.setToContainerAllocations(index, builder.build());
    }
    
    public N endContainerAllocation() {
      return and();
    }
    
  }
}