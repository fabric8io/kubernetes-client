package io.fabric8.kubernetes.api.model.resource.v1alpha2;

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
public class NamedResourcesResourcesFluent<A extends io.fabric8.kubernetes.api.model.resource.v1alpha2.NamedResourcesResourcesFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<NamedResourcesInstanceBuilder> instances = new ArrayList<NamedResourcesInstanceBuilder>();

  public NamedResourcesResourcesFluent() {
  }
  
  public NamedResourcesResourcesFluent(NamedResourcesResources instance) {
    this.copyInstance(instance);
  }

  public A addAllToInstances(Collection<NamedResourcesInstance> items) {
    if (this.instances == null) {
      this.instances = new ArrayList();
    }
    for (NamedResourcesInstance item : items) {
        NamedResourcesInstanceBuilder builder = new NamedResourcesInstanceBuilder(item);
        _visitables.get("instances").add(builder);
        this.instances.add(builder);
    }
    return (A) this;
  }
  
  public InstancesNested<A> addNewInstance() {
    return new InstancesNested(-1, null);
  }
  
  public InstancesNested<A> addNewInstanceLike(NamedResourcesInstance item) {
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
  
  public A addToInstances(NamedResourcesInstance... items) {
    if (this.instances == null) {
      this.instances = new ArrayList();
    }
    for (NamedResourcesInstance item : items) {
        NamedResourcesInstanceBuilder builder = new NamedResourcesInstanceBuilder(item);
        _visitables.get("instances").add(builder);
        this.instances.add(builder);
    }
    return (A) this;
  }
  
  public A addToInstances(int index,NamedResourcesInstance item) {
    if (this.instances == null) {
      this.instances = new ArrayList();
    }
    NamedResourcesInstanceBuilder builder = new NamedResourcesInstanceBuilder(item);
    if (index < 0 || index >= instances.size()) {
        _visitables.get("instances").add(builder);
        instances.add(builder);
    } else {
        _visitables.get("instances").add(builder);
        instances.add(index, builder);
    }
    return (A) this;
  }
  
  public NamedResourcesInstance buildFirstInstance() {
    return this.instances.get(0).build();
  }
  
  public NamedResourcesInstance buildInstance(int index) {
    return this.instances.get(index).build();
  }
  
  public List<NamedResourcesInstance> buildInstances() {
    return this.instances != null ? build(instances) : null;
  }
  
  public NamedResourcesInstance buildLastInstance() {
    return this.instances.get(instances.size() - 1).build();
  }
  
  public NamedResourcesInstance buildMatchingInstance(Predicate<NamedResourcesInstanceBuilder> predicate) {
      for (NamedResourcesInstanceBuilder item : instances) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(NamedResourcesResources instance) {
    instance = instance != null ? instance : new NamedResourcesResources();
    if (instance != null) {
        this.withInstances(instance.getInstances());
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
  
  public InstancesNested<A> editMatchingInstance(Predicate<NamedResourcesInstanceBuilder> predicate) {
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
    NamedResourcesResourcesFluent that = (NamedResourcesResourcesFluent) o;
    if (!(Objects.equals(instances, that.instances))) {
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
  
  public boolean hasInstances() {
    return this.instances != null && !(this.instances.isEmpty());
  }
  
  public boolean hasMatchingInstance(Predicate<NamedResourcesInstanceBuilder> predicate) {
      for (NamedResourcesInstanceBuilder item : instances) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(instances, additionalProperties);
  }
  
  public A removeAllFromInstances(Collection<NamedResourcesInstance> items) {
    if (this.instances == null) {
      return (A) this;
    }
    for (NamedResourcesInstance item : items) {
        NamedResourcesInstanceBuilder builder = new NamedResourcesInstanceBuilder(item);
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
  
  public A removeFromInstances(NamedResourcesInstance... items) {
    if (this.instances == null) {
      return (A) this;
    }
    for (NamedResourcesInstance item : items) {
        NamedResourcesInstanceBuilder builder = new NamedResourcesInstanceBuilder(item);
        _visitables.get("instances").remove(builder);
        this.instances.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromInstances(Predicate<NamedResourcesInstanceBuilder> predicate) {
    if (instances == null) {
      return (A) this;
    }
    Iterator<NamedResourcesInstanceBuilder> each = instances.iterator();
    List visitables = _visitables.get("instances");
    while (each.hasNext()) {
        NamedResourcesInstanceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public InstancesNested<A> setNewInstanceLike(int index,NamedResourcesInstance item) {
    return new InstancesNested(index, item);
  }
  
  public A setToInstances(int index,NamedResourcesInstance item) {
    if (this.instances == null) {
      this.instances = new ArrayList();
    }
    NamedResourcesInstanceBuilder builder = new NamedResourcesInstanceBuilder(item);
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
    if (!(instances == null) && !(instances.isEmpty())) {
        sb.append("instances:");
        sb.append(instances);
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
  
  public A withInstances(List<NamedResourcesInstance> instances) {
    if (this.instances != null) {
      this._visitables.get("instances").clear();
    }
    if (instances != null) {
        this.instances = new ArrayList();
        for (NamedResourcesInstance item : instances) {
          this.addToInstances(item);
        }
    } else {
      this.instances = null;
    }
    return (A) this;
  }
  
  public A withInstances(NamedResourcesInstance... instances) {
    if (this.instances != null) {
        this.instances.clear();
        _visitables.remove("instances");
    }
    if (instances != null) {
      for (NamedResourcesInstance item : instances) {
        this.addToInstances(item);
      }
    }
    return (A) this;
  }
  public class InstancesNested<N> extends NamedResourcesInstanceFluent<InstancesNested<N>> implements Nested<N>{
  
    NamedResourcesInstanceBuilder builder;
    int index;
  
    InstancesNested(int index,NamedResourcesInstance item) {
      this.index = index;
      this.builder = new NamedResourcesInstanceBuilder(this, item);
    }
  
    public N and() {
      return (N) NamedResourcesResourcesFluent.this.setToInstances(index, builder.build());
    }
    
    public N endInstance() {
      return and();
    }
    
  }
}