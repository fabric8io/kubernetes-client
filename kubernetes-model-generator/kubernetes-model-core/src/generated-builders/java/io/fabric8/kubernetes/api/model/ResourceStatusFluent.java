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
public class ResourceStatusFluent<A extends io.fabric8.kubernetes.api.model.ResourceStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String name;
  private ArrayList<ResourceHealthBuilder> resources = new ArrayList<ResourceHealthBuilder>();

  public ResourceStatusFluent() {
  }
  
  public ResourceStatusFluent(ResourceStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToResources(Collection<ResourceHealth> items) {
    if (this.resources == null) {
      this.resources = new ArrayList();
    }
    for (ResourceHealth item : items) {
        ResourceHealthBuilder builder = new ResourceHealthBuilder(item);
        _visitables.get("resources").add(builder);
        this.resources.add(builder);
    }
    return (A) this;
  }
  
  public ResourcesNested<A> addNewResource() {
    return new ResourcesNested(-1, null);
  }
  
  public A addNewResource(String health,String message,String resourceID) {
    return (A) this.addToResources(new ResourceHealth(health, message, resourceID));
  }
  
  public ResourcesNested<A> addNewResourceLike(ResourceHealth item) {
    return new ResourcesNested(-1, item);
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
  
  public A addToResources(ResourceHealth... items) {
    if (this.resources == null) {
      this.resources = new ArrayList();
    }
    for (ResourceHealth item : items) {
        ResourceHealthBuilder builder = new ResourceHealthBuilder(item);
        _visitables.get("resources").add(builder);
        this.resources.add(builder);
    }
    return (A) this;
  }
  
  public A addToResources(int index,ResourceHealth item) {
    if (this.resources == null) {
      this.resources = new ArrayList();
    }
    ResourceHealthBuilder builder = new ResourceHealthBuilder(item);
    if (index < 0 || index >= resources.size()) {
        _visitables.get("resources").add(builder);
        resources.add(builder);
    } else {
        _visitables.get("resources").add(builder);
        resources.add(index, builder);
    }
    return (A) this;
  }
  
  public ResourceHealth buildFirstResource() {
    return this.resources.get(0).build();
  }
  
  public ResourceHealth buildLastResource() {
    return this.resources.get(resources.size() - 1).build();
  }
  
  public ResourceHealth buildMatchingResource(Predicate<ResourceHealthBuilder> predicate) {
      for (ResourceHealthBuilder item : resources) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ResourceHealth buildResource(int index) {
    return this.resources.get(index).build();
  }
  
  public List<ResourceHealth> buildResources() {
    return this.resources != null ? build(resources) : null;
  }
  
  protected void copyInstance(ResourceStatus instance) {
    instance = instance != null ? instance : new ResourceStatus();
    if (instance != null) {
        this.withName(instance.getName());
        this.withResources(instance.getResources());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ResourcesNested<A> editFirstResource() {
    if (resources.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "resources"));
    }
    return this.setNewResourceLike(0, this.buildResource(0));
  }
  
  public ResourcesNested<A> editLastResource() {
    int index = resources.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "resources"));
    }
    return this.setNewResourceLike(index, this.buildResource(index));
  }
  
  public ResourcesNested<A> editMatchingResource(Predicate<ResourceHealthBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < resources.size();i++) {
      if (predicate.test(resources.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "resources"));
    }
    return this.setNewResourceLike(index, this.buildResource(index));
  }
  
  public ResourcesNested<A> editResource(int index) {
    if (resources.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "resources"));
    }
    return this.setNewResourceLike(index, this.buildResource(index));
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
    ResourceStatusFluent that = (ResourceStatusFluent) o;
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(resources, that.resources))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingResource(Predicate<ResourceHealthBuilder> predicate) {
      for (ResourceHealthBuilder item : resources) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasResources() {
    return this.resources != null && !(this.resources.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(name, resources, additionalProperties);
  }
  
  public A removeAllFromResources(Collection<ResourceHealth> items) {
    if (this.resources == null) {
      return (A) this;
    }
    for (ResourceHealth item : items) {
        ResourceHealthBuilder builder = new ResourceHealthBuilder(item);
        _visitables.get("resources").remove(builder);
        this.resources.remove(builder);
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
  
  public A removeFromResources(ResourceHealth... items) {
    if (this.resources == null) {
      return (A) this;
    }
    for (ResourceHealth item : items) {
        ResourceHealthBuilder builder = new ResourceHealthBuilder(item);
        _visitables.get("resources").remove(builder);
        this.resources.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromResources(Predicate<ResourceHealthBuilder> predicate) {
    if (resources == null) {
      return (A) this;
    }
    Iterator<ResourceHealthBuilder> each = resources.iterator();
    List visitables = _visitables.get("resources");
    while (each.hasNext()) {
        ResourceHealthBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ResourcesNested<A> setNewResourceLike(int index,ResourceHealth item) {
    return new ResourcesNested(index, item);
  }
  
  public A setToResources(int index,ResourceHealth item) {
    if (this.resources == null) {
      this.resources = new ArrayList();
    }
    ResourceHealthBuilder builder = new ResourceHealthBuilder(item);
    if (index < 0 || index >= resources.size()) {
        _visitables.get("resources").add(builder);
        resources.add(builder);
    } else {
        _visitables.get("resources").add(builder);
        resources.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(resources == null) && !(resources.isEmpty())) {
        sb.append("resources:");
        sb.append(resources);
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
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withResources(List<ResourceHealth> resources) {
    if (this.resources != null) {
      this._visitables.get("resources").clear();
    }
    if (resources != null) {
        this.resources = new ArrayList();
        for (ResourceHealth item : resources) {
          this.addToResources(item);
        }
    } else {
      this.resources = null;
    }
    return (A) this;
  }
  
  public A withResources(ResourceHealth... resources) {
    if (this.resources != null) {
        this.resources.clear();
        _visitables.remove("resources");
    }
    if (resources != null) {
      for (ResourceHealth item : resources) {
        this.addToResources(item);
      }
    }
    return (A) this;
  }
  public class ResourcesNested<N> extends ResourceHealthFluent<ResourcesNested<N>> implements Nested<N>{
  
    ResourceHealthBuilder builder;
    int index;
  
    ResourcesNested(int index,ResourceHealth item) {
      this.index = index;
      this.builder = new ResourceHealthBuilder(this, item);
    }
  
    public N and() {
      return (N) ResourceStatusFluent.this.setToResources(index, builder.build());
    }
    
    public N endResource() {
      return and();
    }
    
  }
}