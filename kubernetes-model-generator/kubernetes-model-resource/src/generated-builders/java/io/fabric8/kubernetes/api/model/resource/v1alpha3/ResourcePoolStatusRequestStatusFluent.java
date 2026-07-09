package io.fabric8.kubernetes.api.model.resource.v1alpha3;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Condition;
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
public class ResourcePoolStatusRequestStatusFluent<A extends io.fabric8.kubernetes.api.model.resource.v1alpha3.ResourcePoolStatusRequestStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<Condition> conditions = new ArrayList<Condition>();
  private Integer poolCount;
  private ArrayList<PoolStatusBuilder> pools = new ArrayList<PoolStatusBuilder>();

  public ResourcePoolStatusRequestStatusFluent() {
  }
  
  public ResourcePoolStatusRequestStatusFluent(ResourcePoolStatusRequestStatus instance) {
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
  
  public A addAllToPools(Collection<PoolStatus> items) {
    if (this.pools == null) {
      this.pools = new ArrayList();
    }
    for (PoolStatus item : items) {
        PoolStatusBuilder builder = new PoolStatusBuilder(item);
        _visitables.get("pools").add(builder);
        this.pools.add(builder);
    }
    return (A) this;
  }
  
  public PoolsNested<A> addNewPool() {
    return new PoolsNested(-1, null);
  }
  
  public PoolsNested<A> addNewPoolLike(PoolStatus item) {
    return new PoolsNested(-1, item);
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
  
  public A addToPools(PoolStatus... items) {
    if (this.pools == null) {
      this.pools = new ArrayList();
    }
    for (PoolStatus item : items) {
        PoolStatusBuilder builder = new PoolStatusBuilder(item);
        _visitables.get("pools").add(builder);
        this.pools.add(builder);
    }
    return (A) this;
  }
  
  public A addToPools(int index,PoolStatus item) {
    if (this.pools == null) {
      this.pools = new ArrayList();
    }
    PoolStatusBuilder builder = new PoolStatusBuilder(item);
    if (index < 0 || index >= pools.size()) {
        _visitables.get("pools").add(builder);
        pools.add(builder);
    } else {
        _visitables.get("pools").add(builder);
        pools.add(index, builder);
    }
    return (A) this;
  }
  
  public PoolStatus buildFirstPool() {
    return this.pools.get(0).build();
  }
  
  public PoolStatus buildLastPool() {
    return this.pools.get(pools.size() - 1).build();
  }
  
  public PoolStatus buildMatchingPool(Predicate<PoolStatusBuilder> predicate) {
      for (PoolStatusBuilder item : pools) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PoolStatus buildPool(int index) {
    return this.pools.get(index).build();
  }
  
  public List<PoolStatus> buildPools() {
    return this.pools != null ? build(pools) : null;
  }
  
  protected void copyInstance(ResourcePoolStatusRequestStatus instance) {
    instance = instance != null ? instance : new ResourcePoolStatusRequestStatus();
    if (instance != null) {
        this.withConditions(instance.getConditions());
        this.withPoolCount(instance.getPoolCount());
        this.withPools(instance.getPools());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PoolsNested<A> editFirstPool() {
    if (pools.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "pools"));
    }
    return this.setNewPoolLike(0, this.buildPool(0));
  }
  
  public PoolsNested<A> editLastPool() {
    int index = pools.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "pools"));
    }
    return this.setNewPoolLike(index, this.buildPool(index));
  }
  
  public PoolsNested<A> editMatchingPool(Predicate<PoolStatusBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < pools.size();i++) {
      if (predicate.test(pools.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "pools"));
    }
    return this.setNewPoolLike(index, this.buildPool(index));
  }
  
  public PoolsNested<A> editPool(int index) {
    if (pools.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "pools"));
    }
    return this.setNewPoolLike(index, this.buildPool(index));
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
    ResourcePoolStatusRequestStatusFluent that = (ResourcePoolStatusRequestStatusFluent) o;
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(poolCount, that.poolCount))) {
      return false;
    }
    if (!(Objects.equals(pools, that.pools))) {
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
  
  public Integer getPoolCount() {
    return this.poolCount;
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
  
  public boolean hasMatchingPool(Predicate<PoolStatusBuilder> predicate) {
      for (PoolStatusBuilder item : pools) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPoolCount() {
    return this.poolCount != null;
  }
  
  public boolean hasPools() {
    return this.pools != null && !(this.pools.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(conditions, poolCount, pools, additionalProperties);
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
  
  public A removeAllFromPools(Collection<PoolStatus> items) {
    if (this.pools == null) {
      return (A) this;
    }
    for (PoolStatus item : items) {
        PoolStatusBuilder builder = new PoolStatusBuilder(item);
        _visitables.get("pools").remove(builder);
        this.pools.remove(builder);
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
  
  public A removeFromPools(PoolStatus... items) {
    if (this.pools == null) {
      return (A) this;
    }
    for (PoolStatus item : items) {
        PoolStatusBuilder builder = new PoolStatusBuilder(item);
        _visitables.get("pools").remove(builder);
        this.pools.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromPools(Predicate<PoolStatusBuilder> predicate) {
    if (pools == null) {
      return (A) this;
    }
    Iterator<PoolStatusBuilder> each = pools.iterator();
    List visitables = _visitables.get("pools");
    while (each.hasNext()) {
        PoolStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public PoolsNested<A> setNewPoolLike(int index,PoolStatus item) {
    return new PoolsNested(index, item);
  }
  
  public A setToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.set(index, item);
    return (A) this;
  }
  
  public A setToPools(int index,PoolStatus item) {
    if (this.pools == null) {
      this.pools = new ArrayList();
    }
    PoolStatusBuilder builder = new PoolStatusBuilder(item);
    if (index < 0 || index >= pools.size()) {
        _visitables.get("pools").add(builder);
        pools.add(builder);
    } else {
        _visitables.get("pools").add(builder);
        pools.set(index, builder);
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
    if (!(poolCount == null)) {
        sb.append("poolCount:");
        sb.append(poolCount);
        sb.append(",");
    }
    if (!(pools == null) && !(pools.isEmpty())) {
        sb.append("pools:");
        sb.append(pools);
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
  
  public A withPoolCount(Integer poolCount) {
    this.poolCount = poolCount;
    return (A) this;
  }
  
  public A withPools(List<PoolStatus> pools) {
    if (this.pools != null) {
      this._visitables.get("pools").clear();
    }
    if (pools != null) {
        this.pools = new ArrayList();
        for (PoolStatus item : pools) {
          this.addToPools(item);
        }
    } else {
      this.pools = null;
    }
    return (A) this;
  }
  
  public A withPools(PoolStatus... pools) {
    if (this.pools != null) {
        this.pools.clear();
        _visitables.remove("pools");
    }
    if (pools != null) {
      for (PoolStatus item : pools) {
        this.addToPools(item);
      }
    }
    return (A) this;
  }
  public class PoolsNested<N> extends PoolStatusFluent<PoolsNested<N>> implements Nested<N>{
  
    PoolStatusBuilder builder;
    int index;
  
    PoolsNested(int index,PoolStatus item) {
      this.index = index;
      this.builder = new PoolStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) ResourcePoolStatusRequestStatusFluent.this.setToPools(index, builder.build());
    }
    
    public N endPool() {
      return and();
    }
    
  }
}