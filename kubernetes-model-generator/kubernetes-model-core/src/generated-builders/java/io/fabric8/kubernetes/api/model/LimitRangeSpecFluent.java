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
public class LimitRangeSpecFluent<A extends io.fabric8.kubernetes.api.model.LimitRangeSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<LimitRangeItemBuilder> limits = new ArrayList<LimitRangeItemBuilder>();

  public LimitRangeSpecFluent() {
  }
  
  public LimitRangeSpecFluent(LimitRangeSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToLimits(Collection<LimitRangeItem> items) {
    if (this.limits == null) {
      this.limits = new ArrayList();
    }
    for (LimitRangeItem item : items) {
        LimitRangeItemBuilder builder = new LimitRangeItemBuilder(item);
        _visitables.get("limits").add(builder);
        this.limits.add(builder);
    }
    return (A) this;
  }
  
  public LimitsNested<A> addNewLimit() {
    return new LimitsNested(-1, null);
  }
  
  public LimitsNested<A> addNewLimitLike(LimitRangeItem item) {
    return new LimitsNested(-1, item);
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
  
  public A addToLimits(LimitRangeItem... items) {
    if (this.limits == null) {
      this.limits = new ArrayList();
    }
    for (LimitRangeItem item : items) {
        LimitRangeItemBuilder builder = new LimitRangeItemBuilder(item);
        _visitables.get("limits").add(builder);
        this.limits.add(builder);
    }
    return (A) this;
  }
  
  public A addToLimits(int index,LimitRangeItem item) {
    if (this.limits == null) {
      this.limits = new ArrayList();
    }
    LimitRangeItemBuilder builder = new LimitRangeItemBuilder(item);
    if (index < 0 || index >= limits.size()) {
        _visitables.get("limits").add(builder);
        limits.add(builder);
    } else {
        _visitables.get("limits").add(builder);
        limits.add(index, builder);
    }
    return (A) this;
  }
  
  public LimitRangeItem buildFirstLimit() {
    return this.limits.get(0).build();
  }
  
  public LimitRangeItem buildLastLimit() {
    return this.limits.get(limits.size() - 1).build();
  }
  
  public LimitRangeItem buildLimit(int index) {
    return this.limits.get(index).build();
  }
  
  public List<LimitRangeItem> buildLimits() {
    return this.limits != null ? build(limits) : null;
  }
  
  public LimitRangeItem buildMatchingLimit(Predicate<LimitRangeItemBuilder> predicate) {
      for (LimitRangeItemBuilder item : limits) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(LimitRangeSpec instance) {
    instance = instance != null ? instance : new LimitRangeSpec();
    if (instance != null) {
        this.withLimits(instance.getLimits());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public LimitsNested<A> editFirstLimit() {
    if (limits.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "limits"));
    }
    return this.setNewLimitLike(0, this.buildLimit(0));
  }
  
  public LimitsNested<A> editLastLimit() {
    int index = limits.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "limits"));
    }
    return this.setNewLimitLike(index, this.buildLimit(index));
  }
  
  public LimitsNested<A> editLimit(int index) {
    if (limits.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "limits"));
    }
    return this.setNewLimitLike(index, this.buildLimit(index));
  }
  
  public LimitsNested<A> editMatchingLimit(Predicate<LimitRangeItemBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < limits.size();i++) {
      if (predicate.test(limits.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "limits"));
    }
    return this.setNewLimitLike(index, this.buildLimit(index));
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
    LimitRangeSpecFluent that = (LimitRangeSpecFluent) o;
    if (!(Objects.equals(limits, that.limits))) {
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
  
  public boolean hasLimits() {
    return this.limits != null && !(this.limits.isEmpty());
  }
  
  public boolean hasMatchingLimit(Predicate<LimitRangeItemBuilder> predicate) {
      for (LimitRangeItemBuilder item : limits) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(limits, additionalProperties);
  }
  
  public A removeAllFromLimits(Collection<LimitRangeItem> items) {
    if (this.limits == null) {
      return (A) this;
    }
    for (LimitRangeItem item : items) {
        LimitRangeItemBuilder builder = new LimitRangeItemBuilder(item);
        _visitables.get("limits").remove(builder);
        this.limits.remove(builder);
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
  
  public A removeFromLimits(LimitRangeItem... items) {
    if (this.limits == null) {
      return (A) this;
    }
    for (LimitRangeItem item : items) {
        LimitRangeItemBuilder builder = new LimitRangeItemBuilder(item);
        _visitables.get("limits").remove(builder);
        this.limits.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromLimits(Predicate<LimitRangeItemBuilder> predicate) {
    if (limits == null) {
      return (A) this;
    }
    Iterator<LimitRangeItemBuilder> each = limits.iterator();
    List visitables = _visitables.get("limits");
    while (each.hasNext()) {
        LimitRangeItemBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public LimitsNested<A> setNewLimitLike(int index,LimitRangeItem item) {
    return new LimitsNested(index, item);
  }
  
  public A setToLimits(int index,LimitRangeItem item) {
    if (this.limits == null) {
      this.limits = new ArrayList();
    }
    LimitRangeItemBuilder builder = new LimitRangeItemBuilder(item);
    if (index < 0 || index >= limits.size()) {
        _visitables.get("limits").add(builder);
        limits.add(builder);
    } else {
        _visitables.get("limits").add(builder);
        limits.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(limits == null) && !(limits.isEmpty())) {
        sb.append("limits:");
        sb.append(limits);
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
  
  public A withLimits(List<LimitRangeItem> limits) {
    if (this.limits != null) {
      this._visitables.get("limits").clear();
    }
    if (limits != null) {
        this.limits = new ArrayList();
        for (LimitRangeItem item : limits) {
          this.addToLimits(item);
        }
    } else {
      this.limits = null;
    }
    return (A) this;
  }
  
  public A withLimits(LimitRangeItem... limits) {
    if (this.limits != null) {
        this.limits.clear();
        _visitables.remove("limits");
    }
    if (limits != null) {
      for (LimitRangeItem item : limits) {
        this.addToLimits(item);
      }
    }
    return (A) this;
  }
  public class LimitsNested<N> extends LimitRangeItemFluent<LimitsNested<N>> implements Nested<N>{
  
    LimitRangeItemBuilder builder;
    int index;
  
    LimitsNested(int index,LimitRangeItem item) {
      this.index = index;
      this.builder = new LimitRangeItemBuilder(this, item);
    }
  
    public N and() {
      return (N) LimitRangeSpecFluent.this.setToLimits(index, builder.build());
    }
    
    public N endLimit() {
      return and();
    }
    
  }
}