package io.fabric8.kubernetes.api.model.resource.v1alpha2;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.NodeSelector;
import java.lang.Boolean;
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
public class AllocationResultFluent<A extends io.fabric8.kubernetes.api.model.resource.v1alpha2.AllocationResultFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private NodeSelector availableOnNodes;
  private ArrayList<ResourceHandleBuilder> resourceHandles = new ArrayList<ResourceHandleBuilder>();
  private Boolean shareable;

  public AllocationResultFluent() {
  }
  
  public AllocationResultFluent(AllocationResult instance) {
    this.copyInstance(instance);
  }

  public A addAllToResourceHandles(Collection<ResourceHandle> items) {
    if (this.resourceHandles == null) {
      this.resourceHandles = new ArrayList();
    }
    for (ResourceHandle item : items) {
        ResourceHandleBuilder builder = new ResourceHandleBuilder(item);
        _visitables.get("resourceHandles").add(builder);
        this.resourceHandles.add(builder);
    }
    return (A) this;
  }
  
  public ResourceHandlesNested<A> addNewResourceHandle() {
    return new ResourceHandlesNested(-1, null);
  }
  
  public ResourceHandlesNested<A> addNewResourceHandleLike(ResourceHandle item) {
    return new ResourceHandlesNested(-1, item);
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
  
  public A addToResourceHandles(ResourceHandle... items) {
    if (this.resourceHandles == null) {
      this.resourceHandles = new ArrayList();
    }
    for (ResourceHandle item : items) {
        ResourceHandleBuilder builder = new ResourceHandleBuilder(item);
        _visitables.get("resourceHandles").add(builder);
        this.resourceHandles.add(builder);
    }
    return (A) this;
  }
  
  public A addToResourceHandles(int index,ResourceHandle item) {
    if (this.resourceHandles == null) {
      this.resourceHandles = new ArrayList();
    }
    ResourceHandleBuilder builder = new ResourceHandleBuilder(item);
    if (index < 0 || index >= resourceHandles.size()) {
        _visitables.get("resourceHandles").add(builder);
        resourceHandles.add(builder);
    } else {
        _visitables.get("resourceHandles").add(builder);
        resourceHandles.add(index, builder);
    }
    return (A) this;
  }
  
  public ResourceHandle buildFirstResourceHandle() {
    return this.resourceHandles.get(0).build();
  }
  
  public ResourceHandle buildLastResourceHandle() {
    return this.resourceHandles.get(resourceHandles.size() - 1).build();
  }
  
  public ResourceHandle buildMatchingResourceHandle(Predicate<ResourceHandleBuilder> predicate) {
      for (ResourceHandleBuilder item : resourceHandles) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ResourceHandle buildResourceHandle(int index) {
    return this.resourceHandles.get(index).build();
  }
  
  public List<ResourceHandle> buildResourceHandles() {
    return this.resourceHandles != null ? build(resourceHandles) : null;
  }
  
  protected void copyInstance(AllocationResult instance) {
    instance = instance != null ? instance : new AllocationResult();
    if (instance != null) {
        this.withAvailableOnNodes(instance.getAvailableOnNodes());
        this.withResourceHandles(instance.getResourceHandles());
        this.withShareable(instance.getShareable());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ResourceHandlesNested<A> editFirstResourceHandle() {
    if (resourceHandles.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "resourceHandles"));
    }
    return this.setNewResourceHandleLike(0, this.buildResourceHandle(0));
  }
  
  public ResourceHandlesNested<A> editLastResourceHandle() {
    int index = resourceHandles.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "resourceHandles"));
    }
    return this.setNewResourceHandleLike(index, this.buildResourceHandle(index));
  }
  
  public ResourceHandlesNested<A> editMatchingResourceHandle(Predicate<ResourceHandleBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < resourceHandles.size();i++) {
      if (predicate.test(resourceHandles.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "resourceHandles"));
    }
    return this.setNewResourceHandleLike(index, this.buildResourceHandle(index));
  }
  
  public ResourceHandlesNested<A> editResourceHandle(int index) {
    if (resourceHandles.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "resourceHandles"));
    }
    return this.setNewResourceHandleLike(index, this.buildResourceHandle(index));
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
    AllocationResultFluent that = (AllocationResultFluent) o;
    if (!(Objects.equals(availableOnNodes, that.availableOnNodes))) {
      return false;
    }
    if (!(Objects.equals(resourceHandles, that.resourceHandles))) {
      return false;
    }
    if (!(Objects.equals(shareable, that.shareable))) {
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
  
  public NodeSelector getAvailableOnNodes() {
    return this.availableOnNodes;
  }
  
  public Boolean getShareable() {
    return this.shareable;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAvailableOnNodes() {
    return this.availableOnNodes != null;
  }
  
  public boolean hasMatchingResourceHandle(Predicate<ResourceHandleBuilder> predicate) {
      for (ResourceHandleBuilder item : resourceHandles) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasResourceHandles() {
    return this.resourceHandles != null && !(this.resourceHandles.isEmpty());
  }
  
  public boolean hasShareable() {
    return this.shareable != null;
  }
  
  public int hashCode() {
    return Objects.hash(availableOnNodes, resourceHandles, shareable, additionalProperties);
  }
  
  public A removeAllFromResourceHandles(Collection<ResourceHandle> items) {
    if (this.resourceHandles == null) {
      return (A) this;
    }
    for (ResourceHandle item : items) {
        ResourceHandleBuilder builder = new ResourceHandleBuilder(item);
        _visitables.get("resourceHandles").remove(builder);
        this.resourceHandles.remove(builder);
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
  
  public A removeFromResourceHandles(ResourceHandle... items) {
    if (this.resourceHandles == null) {
      return (A) this;
    }
    for (ResourceHandle item : items) {
        ResourceHandleBuilder builder = new ResourceHandleBuilder(item);
        _visitables.get("resourceHandles").remove(builder);
        this.resourceHandles.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromResourceHandles(Predicate<ResourceHandleBuilder> predicate) {
    if (resourceHandles == null) {
      return (A) this;
    }
    Iterator<ResourceHandleBuilder> each = resourceHandles.iterator();
    List visitables = _visitables.get("resourceHandles");
    while (each.hasNext()) {
        ResourceHandleBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ResourceHandlesNested<A> setNewResourceHandleLike(int index,ResourceHandle item) {
    return new ResourceHandlesNested(index, item);
  }
  
  public A setToResourceHandles(int index,ResourceHandle item) {
    if (this.resourceHandles == null) {
      this.resourceHandles = new ArrayList();
    }
    ResourceHandleBuilder builder = new ResourceHandleBuilder(item);
    if (index < 0 || index >= resourceHandles.size()) {
        _visitables.get("resourceHandles").add(builder);
        resourceHandles.add(builder);
    } else {
        _visitables.get("resourceHandles").add(builder);
        resourceHandles.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(availableOnNodes == null)) {
        sb.append("availableOnNodes:");
        sb.append(availableOnNodes);
        sb.append(",");
    }
    if (!(resourceHandles == null) && !(resourceHandles.isEmpty())) {
        sb.append("resourceHandles:");
        sb.append(resourceHandles);
        sb.append(",");
    }
    if (!(shareable == null)) {
        sb.append("shareable:");
        sb.append(shareable);
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
  
  public A withAvailableOnNodes(NodeSelector availableOnNodes) {
    this.availableOnNodes = availableOnNodes;
    return (A) this;
  }
  
  public A withResourceHandles(List<ResourceHandle> resourceHandles) {
    if (this.resourceHandles != null) {
      this._visitables.get("resourceHandles").clear();
    }
    if (resourceHandles != null) {
        this.resourceHandles = new ArrayList();
        for (ResourceHandle item : resourceHandles) {
          this.addToResourceHandles(item);
        }
    } else {
      this.resourceHandles = null;
    }
    return (A) this;
  }
  
  public A withResourceHandles(ResourceHandle... resourceHandles) {
    if (this.resourceHandles != null) {
        this.resourceHandles.clear();
        _visitables.remove("resourceHandles");
    }
    if (resourceHandles != null) {
      for (ResourceHandle item : resourceHandles) {
        this.addToResourceHandles(item);
      }
    }
    return (A) this;
  }
  
  public A withShareable() {
    return withShareable(true);
  }
  
  public A withShareable(Boolean shareable) {
    this.shareable = shareable;
    return (A) this;
  }
  public class ResourceHandlesNested<N> extends ResourceHandleFluent<ResourceHandlesNested<N>> implements Nested<N>{
  
    ResourceHandleBuilder builder;
    int index;
  
    ResourceHandlesNested(int index,ResourceHandle item) {
      this.index = index;
      this.builder = new ResourceHandleBuilder(this, item);
    }
  
    public N and() {
      return (N) AllocationResultFluent.this.setToResourceHandles(index, builder.build());
    }
    
    public N endResourceHandle() {
      return and();
    }
    
  }
}