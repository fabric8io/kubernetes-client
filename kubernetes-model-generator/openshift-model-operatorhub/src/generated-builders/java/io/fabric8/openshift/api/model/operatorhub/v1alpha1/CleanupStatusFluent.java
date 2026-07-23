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
public class CleanupStatusFluent<A extends io.fabric8.openshift.api.model.operatorhub.v1alpha1.CleanupStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<ResourceListBuilder> pendingDeletion = new ArrayList<ResourceListBuilder>();

  public CleanupStatusFluent() {
  }
  
  public CleanupStatusFluent(CleanupStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToPendingDeletion(Collection<ResourceList> items) {
    if (this.pendingDeletion == null) {
      this.pendingDeletion = new ArrayList();
    }
    for (ResourceList item : items) {
        ResourceListBuilder builder = new ResourceListBuilder(item);
        _visitables.get("pendingDeletion").add(builder);
        this.pendingDeletion.add(builder);
    }
    return (A) this;
  }
  
  public PendingDeletionNested<A> addNewPendingDeletion() {
    return new PendingDeletionNested(-1, null);
  }
  
  public PendingDeletionNested<A> addNewPendingDeletionLike(ResourceList item) {
    return new PendingDeletionNested(-1, item);
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
  
  public A addToPendingDeletion(ResourceList... items) {
    if (this.pendingDeletion == null) {
      this.pendingDeletion = new ArrayList();
    }
    for (ResourceList item : items) {
        ResourceListBuilder builder = new ResourceListBuilder(item);
        _visitables.get("pendingDeletion").add(builder);
        this.pendingDeletion.add(builder);
    }
    return (A) this;
  }
  
  public A addToPendingDeletion(int index,ResourceList item) {
    if (this.pendingDeletion == null) {
      this.pendingDeletion = new ArrayList();
    }
    ResourceListBuilder builder = new ResourceListBuilder(item);
    if (index < 0 || index >= pendingDeletion.size()) {
        _visitables.get("pendingDeletion").add(builder);
        pendingDeletion.add(builder);
    } else {
        _visitables.get("pendingDeletion").add(builder);
        pendingDeletion.add(index, builder);
    }
    return (A) this;
  }
  
  public ResourceList buildFirstPendingDeletion() {
    return this.pendingDeletion.get(0).build();
  }
  
  public ResourceList buildLastPendingDeletion() {
    return this.pendingDeletion.get(pendingDeletion.size() - 1).build();
  }
  
  public ResourceList buildMatchingPendingDeletion(Predicate<ResourceListBuilder> predicate) {
      for (ResourceListBuilder item : pendingDeletion) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public List<ResourceList> buildPendingDeletion() {
    return this.pendingDeletion != null ? build(pendingDeletion) : null;
  }
  
  public ResourceList buildPendingDeletion(int index) {
    return this.pendingDeletion.get(index).build();
  }
  
  protected void copyInstance(CleanupStatus instance) {
    instance = instance != null ? instance : new CleanupStatus();
    if (instance != null) {
        this.withPendingDeletion(instance.getPendingDeletion());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PendingDeletionNested<A> editFirstPendingDeletion() {
    if (pendingDeletion.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "pendingDeletion"));
    }
    return this.setNewPendingDeletionLike(0, this.buildPendingDeletion(0));
  }
  
  public PendingDeletionNested<A> editLastPendingDeletion() {
    int index = pendingDeletion.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "pendingDeletion"));
    }
    return this.setNewPendingDeletionLike(index, this.buildPendingDeletion(index));
  }
  
  public PendingDeletionNested<A> editMatchingPendingDeletion(Predicate<ResourceListBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < pendingDeletion.size();i++) {
      if (predicate.test(pendingDeletion.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "pendingDeletion"));
    }
    return this.setNewPendingDeletionLike(index, this.buildPendingDeletion(index));
  }
  
  public PendingDeletionNested<A> editPendingDeletion(int index) {
    if (pendingDeletion.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "pendingDeletion"));
    }
    return this.setNewPendingDeletionLike(index, this.buildPendingDeletion(index));
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
    CleanupStatusFluent that = (CleanupStatusFluent) o;
    if (!(Objects.equals(pendingDeletion, that.pendingDeletion))) {
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
  
  public boolean hasMatchingPendingDeletion(Predicate<ResourceListBuilder> predicate) {
      for (ResourceListBuilder item : pendingDeletion) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPendingDeletion() {
    return this.pendingDeletion != null && !(this.pendingDeletion.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(pendingDeletion, additionalProperties);
  }
  
  public A removeAllFromPendingDeletion(Collection<ResourceList> items) {
    if (this.pendingDeletion == null) {
      return (A) this;
    }
    for (ResourceList item : items) {
        ResourceListBuilder builder = new ResourceListBuilder(item);
        _visitables.get("pendingDeletion").remove(builder);
        this.pendingDeletion.remove(builder);
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
  
  public A removeFromPendingDeletion(ResourceList... items) {
    if (this.pendingDeletion == null) {
      return (A) this;
    }
    for (ResourceList item : items) {
        ResourceListBuilder builder = new ResourceListBuilder(item);
        _visitables.get("pendingDeletion").remove(builder);
        this.pendingDeletion.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromPendingDeletion(Predicate<ResourceListBuilder> predicate) {
    if (pendingDeletion == null) {
      return (A) this;
    }
    Iterator<ResourceListBuilder> each = pendingDeletion.iterator();
    List visitables = _visitables.get("pendingDeletion");
    while (each.hasNext()) {
        ResourceListBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public PendingDeletionNested<A> setNewPendingDeletionLike(int index,ResourceList item) {
    return new PendingDeletionNested(index, item);
  }
  
  public A setToPendingDeletion(int index,ResourceList item) {
    if (this.pendingDeletion == null) {
      this.pendingDeletion = new ArrayList();
    }
    ResourceListBuilder builder = new ResourceListBuilder(item);
    if (index < 0 || index >= pendingDeletion.size()) {
        _visitables.get("pendingDeletion").add(builder);
        pendingDeletion.add(builder);
    } else {
        _visitables.get("pendingDeletion").add(builder);
        pendingDeletion.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(pendingDeletion == null) && !(pendingDeletion.isEmpty())) {
        sb.append("pendingDeletion:");
        sb.append(pendingDeletion);
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
  
  public A withPendingDeletion(List<ResourceList> pendingDeletion) {
    if (this.pendingDeletion != null) {
      this._visitables.get("pendingDeletion").clear();
    }
    if (pendingDeletion != null) {
        this.pendingDeletion = new ArrayList();
        for (ResourceList item : pendingDeletion) {
          this.addToPendingDeletion(item);
        }
    } else {
      this.pendingDeletion = null;
    }
    return (A) this;
  }
  
  public A withPendingDeletion(ResourceList... pendingDeletion) {
    if (this.pendingDeletion != null) {
        this.pendingDeletion.clear();
        _visitables.remove("pendingDeletion");
    }
    if (pendingDeletion != null) {
      for (ResourceList item : pendingDeletion) {
        this.addToPendingDeletion(item);
      }
    }
    return (A) this;
  }
  public class PendingDeletionNested<N> extends ResourceListFluent<PendingDeletionNested<N>> implements Nested<N>{
  
    ResourceListBuilder builder;
    int index;
  
    PendingDeletionNested(int index,ResourceList item) {
      this.index = index;
      this.builder = new ResourceListBuilder(this, item);
    }
  
    public N and() {
      return (N) CleanupStatusFluent.this.setToPendingDeletion(index, builder.build());
    }
    
    public N endPendingDeletion() {
      return and();
    }
    
  }
}