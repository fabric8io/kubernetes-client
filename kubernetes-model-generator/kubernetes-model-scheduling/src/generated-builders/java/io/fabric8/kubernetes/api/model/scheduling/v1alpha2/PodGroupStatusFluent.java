package io.fabric8.kubernetes.api.model.scheduling.v1alpha2;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Condition;
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
public class PodGroupStatusFluent<A extends io.fabric8.kubernetes.api.model.scheduling.v1alpha2.PodGroupStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<Condition> conditions = new ArrayList<Condition>();
  private ArrayList<PodGroupResourceClaimStatusBuilder> resourceClaimStatuses = new ArrayList<PodGroupResourceClaimStatusBuilder>();

  public PodGroupStatusFluent() {
  }
  
  public PodGroupStatusFluent(PodGroupStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
      this.conditions.add(item);
    }
    return (A) this;
  }
  
  public A addAllToResourceClaimStatuses(Collection<PodGroupResourceClaimStatus> items) {
    if (this.resourceClaimStatuses == null) {
      this.resourceClaimStatuses = new ArrayList();
    }
    for (PodGroupResourceClaimStatus item : items) {
        PodGroupResourceClaimStatusBuilder builder = new PodGroupResourceClaimStatusBuilder(item);
        _visitables.get("resourceClaimStatuses").add(builder);
        this.resourceClaimStatuses.add(builder);
    }
    return (A) this;
  }
  
  public ResourceClaimStatusesNested<A> addNewResourceClaimStatus() {
    return new ResourceClaimStatusesNested(-1, null);
  }
  
  public A addNewResourceClaimStatus(String name,String resourceClaimName) {
    return (A) this.addToResourceClaimStatuses(new PodGroupResourceClaimStatus(name, resourceClaimName));
  }
  
  public ResourceClaimStatusesNested<A> addNewResourceClaimStatusLike(PodGroupResourceClaimStatus item) {
    return new ResourceClaimStatusesNested(-1, item);
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
  
  public A addToConditions(Condition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
      this.conditions.add(item);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.add(index, item);
    return (A) this;
  }
  
  public A addToResourceClaimStatuses(PodGroupResourceClaimStatus... items) {
    if (this.resourceClaimStatuses == null) {
      this.resourceClaimStatuses = new ArrayList();
    }
    for (PodGroupResourceClaimStatus item : items) {
        PodGroupResourceClaimStatusBuilder builder = new PodGroupResourceClaimStatusBuilder(item);
        _visitables.get("resourceClaimStatuses").add(builder);
        this.resourceClaimStatuses.add(builder);
    }
    return (A) this;
  }
  
  public A addToResourceClaimStatuses(int index,PodGroupResourceClaimStatus item) {
    if (this.resourceClaimStatuses == null) {
      this.resourceClaimStatuses = new ArrayList();
    }
    PodGroupResourceClaimStatusBuilder builder = new PodGroupResourceClaimStatusBuilder(item);
    if (index < 0 || index >= resourceClaimStatuses.size()) {
        _visitables.get("resourceClaimStatuses").add(builder);
        resourceClaimStatuses.add(builder);
    } else {
        _visitables.get("resourceClaimStatuses").add(builder);
        resourceClaimStatuses.add(index, builder);
    }
    return (A) this;
  }
  
  public PodGroupResourceClaimStatus buildFirstResourceClaimStatus() {
    return this.resourceClaimStatuses.get(0).build();
  }
  
  public PodGroupResourceClaimStatus buildLastResourceClaimStatus() {
    return this.resourceClaimStatuses.get(resourceClaimStatuses.size() - 1).build();
  }
  
  public PodGroupResourceClaimStatus buildMatchingResourceClaimStatus(Predicate<PodGroupResourceClaimStatusBuilder> predicate) {
      for (PodGroupResourceClaimStatusBuilder item : resourceClaimStatuses) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PodGroupResourceClaimStatus buildResourceClaimStatus(int index) {
    return this.resourceClaimStatuses.get(index).build();
  }
  
  public List<PodGroupResourceClaimStatus> buildResourceClaimStatuses() {
    return this.resourceClaimStatuses != null ? build(resourceClaimStatuses) : null;
  }
  
  protected void copyInstance(PodGroupStatus instance) {
    instance = instance != null ? instance : new PodGroupStatus();
    if (instance != null) {
        this.withConditions(instance.getConditions());
        this.withResourceClaimStatuses(instance.getResourceClaimStatuses());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ResourceClaimStatusesNested<A> editFirstResourceClaimStatus() {
    if (resourceClaimStatuses.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "resourceClaimStatuses"));
    }
    return this.setNewResourceClaimStatusLike(0, this.buildResourceClaimStatus(0));
  }
  
  public ResourceClaimStatusesNested<A> editLastResourceClaimStatus() {
    int index = resourceClaimStatuses.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "resourceClaimStatuses"));
    }
    return this.setNewResourceClaimStatusLike(index, this.buildResourceClaimStatus(index));
  }
  
  public ResourceClaimStatusesNested<A> editMatchingResourceClaimStatus(Predicate<PodGroupResourceClaimStatusBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < resourceClaimStatuses.size();i++) {
      if (predicate.test(resourceClaimStatuses.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "resourceClaimStatuses"));
    }
    return this.setNewResourceClaimStatusLike(index, this.buildResourceClaimStatus(index));
  }
  
  public ResourceClaimStatusesNested<A> editResourceClaimStatus(int index) {
    if (resourceClaimStatuses.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "resourceClaimStatuses"));
    }
    return this.setNewResourceClaimStatusLike(index, this.buildResourceClaimStatus(index));
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
    PodGroupStatusFluent that = (PodGroupStatusFluent) o;
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(resourceClaimStatuses, that.resourceClaimStatuses))) {
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
  
  public Condition getCondition(int index) {
    return this.conditions.get(index);
  }
  
  public List<Condition> getConditions() {
    return this.conditions;
  }
  
  public Condition getFirstCondition() {
    return this.conditions.get(0);
  }
  
  public Condition getLastCondition() {
    return this.conditions.get(conditions.size() - 1);
  }
  
  public Condition getMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingResourceClaimStatus(Predicate<PodGroupResourceClaimStatusBuilder> predicate) {
      for (PodGroupResourceClaimStatusBuilder item : resourceClaimStatuses) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasResourceClaimStatuses() {
    return this.resourceClaimStatuses != null && !(this.resourceClaimStatuses.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(conditions, resourceClaimStatuses, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
      this.conditions.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromResourceClaimStatuses(Collection<PodGroupResourceClaimStatus> items) {
    if (this.resourceClaimStatuses == null) {
      return (A) this;
    }
    for (PodGroupResourceClaimStatus item : items) {
        PodGroupResourceClaimStatusBuilder builder = new PodGroupResourceClaimStatusBuilder(item);
        _visitables.get("resourceClaimStatuses").remove(builder);
        this.resourceClaimStatuses.remove(builder);
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
  
  public A removeFromConditions(Condition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
      this.conditions.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromResourceClaimStatuses(PodGroupResourceClaimStatus... items) {
    if (this.resourceClaimStatuses == null) {
      return (A) this;
    }
    for (PodGroupResourceClaimStatus item : items) {
        PodGroupResourceClaimStatusBuilder builder = new PodGroupResourceClaimStatusBuilder(item);
        _visitables.get("resourceClaimStatuses").remove(builder);
        this.resourceClaimStatuses.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromResourceClaimStatuses(Predicate<PodGroupResourceClaimStatusBuilder> predicate) {
    if (resourceClaimStatuses == null) {
      return (A) this;
    }
    Iterator<PodGroupResourceClaimStatusBuilder> each = resourceClaimStatuses.iterator();
    List visitables = _visitables.get("resourceClaimStatuses");
    while (each.hasNext()) {
        PodGroupResourceClaimStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ResourceClaimStatusesNested<A> setNewResourceClaimStatusLike(int index,PodGroupResourceClaimStatus item) {
    return new ResourceClaimStatusesNested(index, item);
  }
  
  public A setToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.set(index, item);
    return (A) this;
  }
  
  public A setToResourceClaimStatuses(int index,PodGroupResourceClaimStatus item) {
    if (this.resourceClaimStatuses == null) {
      this.resourceClaimStatuses = new ArrayList();
    }
    PodGroupResourceClaimStatusBuilder builder = new PodGroupResourceClaimStatusBuilder(item);
    if (index < 0 || index >= resourceClaimStatuses.size()) {
        _visitables.get("resourceClaimStatuses").add(builder);
        resourceClaimStatuses.add(builder);
    } else {
        _visitables.get("resourceClaimStatuses").add(builder);
        resourceClaimStatuses.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(resourceClaimStatuses == null) && !(resourceClaimStatuses.isEmpty())) {
        sb.append("resourceClaimStatuses:");
        sb.append(resourceClaimStatuses);
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
  
  public A withConditions(List<Condition> conditions) {
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (Condition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(Condition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (Condition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withResourceClaimStatuses(List<PodGroupResourceClaimStatus> resourceClaimStatuses) {
    if (this.resourceClaimStatuses != null) {
      this._visitables.get("resourceClaimStatuses").clear();
    }
    if (resourceClaimStatuses != null) {
        this.resourceClaimStatuses = new ArrayList();
        for (PodGroupResourceClaimStatus item : resourceClaimStatuses) {
          this.addToResourceClaimStatuses(item);
        }
    } else {
      this.resourceClaimStatuses = null;
    }
    return (A) this;
  }
  
  public A withResourceClaimStatuses(PodGroupResourceClaimStatus... resourceClaimStatuses) {
    if (this.resourceClaimStatuses != null) {
        this.resourceClaimStatuses.clear();
        _visitables.remove("resourceClaimStatuses");
    }
    if (resourceClaimStatuses != null) {
      for (PodGroupResourceClaimStatus item : resourceClaimStatuses) {
        this.addToResourceClaimStatuses(item);
      }
    }
    return (A) this;
  }
  public class ResourceClaimStatusesNested<N> extends PodGroupResourceClaimStatusFluent<ResourceClaimStatusesNested<N>> implements Nested<N>{
  
    PodGroupResourceClaimStatusBuilder builder;
    int index;
  
    ResourceClaimStatusesNested(int index,PodGroupResourceClaimStatus item) {
      this.index = index;
      this.builder = new PodGroupResourceClaimStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) PodGroupStatusFluent.this.setToResourceClaimStatuses(index, builder.build());
    }
    
    public N endResourceClaimStatus() {
      return and();
    }
    
  }
}