package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

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
public class ResourceListFluent<A extends io.fabric8.openshift.api.model.operatorhub.v1alpha1.ResourceListFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String group;
  private ArrayList<ResourceInstanceBuilder> instances = new ArrayList<ResourceInstanceBuilder>();
  private String kind;

  public ResourceListFluent() {
  }
  
  public ResourceListFluent(ResourceList instance) {
    this.copyInstance(instance);
  }

  public A addAllToInstances(Collection<ResourceInstance> items) {
    if (this.instances == null) {
      this.instances = new ArrayList();
    }
    for (ResourceInstance item : items) {
        ResourceInstanceBuilder builder = new ResourceInstanceBuilder(item);
        _visitables.get("instances").add(builder);
        this.instances.add(builder);
    }
    return (A) this;
  }
  
  public InstancesNested<A> addNewInstance() {
    return new InstancesNested(-1, null);
  }
  
  public A addNewInstance(String name,String namespace) {
    return (A) this.addToInstances(new ResourceInstance(name, namespace));
  }
  
  public InstancesNested<A> addNewInstanceLike(ResourceInstance item) {
    return new InstancesNested(-1, item);
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
  
  public A addToInstances(ResourceInstance... items) {
    if (this.instances == null) {
      this.instances = new ArrayList();
    }
    for (ResourceInstance item : items) {
        ResourceInstanceBuilder builder = new ResourceInstanceBuilder(item);
        _visitables.get("instances").add(builder);
        this.instances.add(builder);
    }
    return (A) this;
  }
  
  public A addToInstances(int index,ResourceInstance item) {
    if (this.instances == null) {
      this.instances = new ArrayList();
    }
    ResourceInstanceBuilder builder = new ResourceInstanceBuilder(item);
    if (index < 0 || index >= instances.size()) {
        _visitables.get("instances").add(builder);
        instances.add(builder);
    } else {
        _visitables.get("instances").add(builder);
        instances.add(index, builder);
    }
    return (A) this;
  }
  
  public ResourceInstance buildFirstInstance() {
    return this.instances.get(0).build();
  }
  
  public ResourceInstance buildInstance(int index) {
    return this.instances.get(index).build();
  }
  
  public List<ResourceInstance> buildInstances() {
    return this.instances != null ? build(instances) : null;
  }
  
  public ResourceInstance buildLastInstance() {
    return this.instances.get(instances.size() - 1).build();
  }
  
  public ResourceInstance buildMatchingInstance(Predicate<ResourceInstanceBuilder> predicate) {
      for (ResourceInstanceBuilder item : instances) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(ResourceList instance) {
    instance = instance != null ? instance : new ResourceList();
    if (instance != null) {
        this.withGroup(instance.getGroup());
        this.withInstances(instance.getInstances());
        this.withKind(instance.getKind());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public InstancesNested<A> editFirstInstance() {
    if (instances.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "instances"));
    }
    return this.setNewInstanceLike(0, this.buildInstance(0));
  }
  
  public InstancesNested<A> editInstance(int index) {
    if (instances.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "instances"));
    }
    return this.setNewInstanceLike(index, this.buildInstance(index));
  }
  
  public InstancesNested<A> editLastInstance() {
    int index = instances.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "instances"));
    }
    return this.setNewInstanceLike(index, this.buildInstance(index));
  }
  
  public InstancesNested<A> editMatchingInstance(Predicate<ResourceInstanceBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < instances.size();i++) {
      if (predicate.test(instances.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "instances"));
    }
    return this.setNewInstanceLike(index, this.buildInstance(index));
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
    ResourceListFluent that = (ResourceListFluent) o;
    if (!(Objects.equals(group, that.group))) {
      return false;
    }
    if (!(Objects.equals(instances, that.instances))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
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
  
  public String getGroup() {
    return this.group;
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasGroup() {
    return this.group != null;
  }
  
  public boolean hasInstances() {
    return this.instances != null && !(this.instances.isEmpty());
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasMatchingInstance(Predicate<ResourceInstanceBuilder> predicate) {
      for (ResourceInstanceBuilder item : instances) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(group, instances, kind, additionalProperties);
  }
  
  public A removeAllFromInstances(Collection<ResourceInstance> items) {
    if (this.instances == null) {
      return (A) this;
    }
    for (ResourceInstance item : items) {
        ResourceInstanceBuilder builder = new ResourceInstanceBuilder(item);
        _visitables.get("instances").remove(builder);
        this.instances.remove(builder);
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
  
  public A removeFromInstances(ResourceInstance... items) {
    if (this.instances == null) {
      return (A) this;
    }
    for (ResourceInstance item : items) {
        ResourceInstanceBuilder builder = new ResourceInstanceBuilder(item);
        _visitables.get("instances").remove(builder);
        this.instances.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromInstances(Predicate<ResourceInstanceBuilder> predicate) {
    if (instances == null) {
      return (A) this;
    }
    Iterator<ResourceInstanceBuilder> each = instances.iterator();
    List visitables = _visitables.get("instances");
    while (each.hasNext()) {
        ResourceInstanceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public InstancesNested<A> setNewInstanceLike(int index,ResourceInstance item) {
    return new InstancesNested(index, item);
  }
  
  public A setToInstances(int index,ResourceInstance item) {
    if (this.instances == null) {
      this.instances = new ArrayList();
    }
    ResourceInstanceBuilder builder = new ResourceInstanceBuilder(item);
    if (index < 0 || index >= instances.size()) {
        _visitables.get("instances").add(builder);
        instances.add(builder);
    } else {
        _visitables.get("instances").add(builder);
        instances.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(group == null)) {
        sb.append("group:");
        sb.append(group);
        sb.append(",");
    }
    if (!(instances == null) && !(instances.isEmpty())) {
        sb.append("instances:");
        sb.append(instances);
        sb.append(",");
    }
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
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
  
  public A withGroup(String group) {
    this.group = group;
    return (A) this;
  }
  
  public A withInstances(List<ResourceInstance> instances) {
    if (this.instances != null) {
      this._visitables.get("instances").clear();
    }
    if (instances != null) {
        this.instances = new ArrayList();
        for (ResourceInstance item : instances) {
          this.addToInstances(item);
        }
    } else {
      this.instances = null;
    }
    return (A) this;
  }
  
  public A withInstances(ResourceInstance... instances) {
    if (this.instances != null) {
        this.instances.clear();
        _visitables.remove("instances");
    }
    if (instances != null) {
      for (ResourceInstance item : instances) {
        this.addToInstances(item);
      }
    }
    return (A) this;
  }
  
  public A withKind(String kind) {
    this.kind = kind;
    return (A) this;
  }
  public class InstancesNested<N> extends ResourceInstanceFluent<InstancesNested<N>> implements Nested<N>{
  
    ResourceInstanceBuilder builder;
    int index;
  
    InstancesNested(int index,ResourceInstance item) {
      this.index = index;
      this.builder = new ResourceInstanceBuilder(this, item);
    }
  
    public N and() {
      return (N) ResourceListFluent.this.setToInstances(index, builder.build());
    }
    
    public N endInstance() {
      return and();
    }
    
  }
}