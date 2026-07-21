package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class ExternalNextHopsFluent<A extends io.fabric8.kubernetes.api.model.ovn.v1.ExternalNextHopsFluent<A>> extends BaseFluent<A>{

  private ArrayList<StaticHopBuilder> _static = new ArrayList<StaticHopBuilder>();
  private Map<String,Object> additionalProperties;
  private ArrayList<DynamicHopBuilder> dynamic = new ArrayList<DynamicHopBuilder>();

  public ExternalNextHopsFluent() {
  }
  
  public ExternalNextHopsFluent(ExternalNextHops instance) {
    this.copyInstance(instance);
  }

  public A addAllToDynamic(Collection<DynamicHop> items) {
    if (this.dynamic == null) {
      this.dynamic = new ArrayList();
    }
    for (DynamicHop item : items) {
        DynamicHopBuilder builder = new DynamicHopBuilder(item);
        _visitables.get("dynamic").add(builder);
        this.dynamic.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToStatic(Collection<StaticHop> items) {
    if (this._static == null) {
      this._static = new ArrayList();
    }
    for (StaticHop item : items) {
        StaticHopBuilder builder = new StaticHopBuilder(item);
        _visitables.get("_static").add(builder);
        this._static.add(builder);
    }
    return (A) this;
  }
  
  public DynamicNested<A> addNewDynamic() {
    return new DynamicNested(-1, null);
  }
  
  public DynamicNested<A> addNewDynamicLike(DynamicHop item) {
    return new DynamicNested(-1, item);
  }
  
  public StaticNested<A> addNewStatic() {
    return new StaticNested(-1, null);
  }
  
  public A addNewStatic(Boolean bfdEnabled,String ip) {
    return (A) this.addToStatic(new StaticHop(bfdEnabled, ip));
  }
  
  public StaticNested<A> addNewStaticLike(StaticHop item) {
    return new StaticNested(-1, item);
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
  
  public A addToDynamic(DynamicHop... items) {
    if (this.dynamic == null) {
      this.dynamic = new ArrayList();
    }
    for (DynamicHop item : items) {
        DynamicHopBuilder builder = new DynamicHopBuilder(item);
        _visitables.get("dynamic").add(builder);
        this.dynamic.add(builder);
    }
    return (A) this;
  }
  
  public A addToDynamic(int index,DynamicHop item) {
    if (this.dynamic == null) {
      this.dynamic = new ArrayList();
    }
    DynamicHopBuilder builder = new DynamicHopBuilder(item);
    if (index < 0 || index >= dynamic.size()) {
        _visitables.get("dynamic").add(builder);
        dynamic.add(builder);
    } else {
        _visitables.get("dynamic").add(builder);
        dynamic.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToStatic(StaticHop... items) {
    if (this._static == null) {
      this._static = new ArrayList();
    }
    for (StaticHop item : items) {
        StaticHopBuilder builder = new StaticHopBuilder(item);
        _visitables.get("_static").add(builder);
        this._static.add(builder);
    }
    return (A) this;
  }
  
  public A addToStatic(int index,StaticHop item) {
    if (this._static == null) {
      this._static = new ArrayList();
    }
    StaticHopBuilder builder = new StaticHopBuilder(item);
    if (index < 0 || index >= _static.size()) {
        _visitables.get("_static").add(builder);
        _static.add(builder);
    } else {
        _visitables.get("_static").add(builder);
        _static.add(index, builder);
    }
    return (A) this;
  }
  
  public List<DynamicHop> buildDynamic() {
    return this.dynamic != null ? build(dynamic) : null;
  }
  
  public DynamicHop buildDynamic(int index) {
    return this.dynamic.get(index).build();
  }
  
  public DynamicHop buildFirstDynamic() {
    return this.dynamic.get(0).build();
  }
  
  public StaticHop buildFirstStatic() {
    return this._static.get(0).build();
  }
  
  public DynamicHop buildLastDynamic() {
    return this.dynamic.get(dynamic.size() - 1).build();
  }
  
  public StaticHop buildLastStatic() {
    return this._static.get(_static.size() - 1).build();
  }
  
  public DynamicHop buildMatchingDynamic(Predicate<DynamicHopBuilder> predicate) {
      for (DynamicHopBuilder item : dynamic) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public StaticHop buildMatchingStatic(Predicate<StaticHopBuilder> predicate) {
      for (StaticHopBuilder item : _static) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public List<StaticHop> buildStatic() {
    return this._static != null ? build(_static) : null;
  }
  
  public StaticHop buildStatic(int index) {
    return this._static.get(index).build();
  }
  
  protected void copyInstance(ExternalNextHops instance) {
    instance = instance != null ? instance : new ExternalNextHops();
    if (instance != null) {
        this.withDynamic(instance.getDynamic());
        this.withStatic(instance.getStatic());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DynamicNested<A> editDynamic(int index) {
    if (dynamic.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "dynamic"));
    }
    return this.setNewDynamicLike(index, this.buildDynamic(index));
  }
  
  public DynamicNested<A> editFirstDynamic() {
    if (dynamic.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "dynamic"));
    }
    return this.setNewDynamicLike(0, this.buildDynamic(0));
  }
  
  public StaticNested<A> editFirstStatic() {
    if (_static.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "_static"));
    }
    return this.setNewStaticLike(0, this.buildStatic(0));
  }
  
  public DynamicNested<A> editLastDynamic() {
    int index = dynamic.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "dynamic"));
    }
    return this.setNewDynamicLike(index, this.buildDynamic(index));
  }
  
  public StaticNested<A> editLastStatic() {
    int index = _static.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "_static"));
    }
    return this.setNewStaticLike(index, this.buildStatic(index));
  }
  
  public DynamicNested<A> editMatchingDynamic(Predicate<DynamicHopBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < dynamic.size();i++) {
      if (predicate.test(dynamic.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "dynamic"));
    }
    return this.setNewDynamicLike(index, this.buildDynamic(index));
  }
  
  public StaticNested<A> editMatchingStatic(Predicate<StaticHopBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < _static.size();i++) {
      if (predicate.test(_static.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "_static"));
    }
    return this.setNewStaticLike(index, this.buildStatic(index));
  }
  
  public StaticNested<A> editStatic(int index) {
    if (_static.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "_static"));
    }
    return this.setNewStaticLike(index, this.buildStatic(index));
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
    ExternalNextHopsFluent that = (ExternalNextHopsFluent) o;
    if (!(Objects.equals(dynamic, that.dynamic))) {
      return false;
    }
    if (!(Objects.equals(_static, that._static))) {
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
  
  public boolean hasDynamic() {
    return this.dynamic != null && !(this.dynamic.isEmpty());
  }
  
  public boolean hasMatchingDynamic(Predicate<DynamicHopBuilder> predicate) {
      for (DynamicHopBuilder item : dynamic) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingStatic(Predicate<StaticHopBuilder> predicate) {
      for (StaticHopBuilder item : _static) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasStatic() {
    return this._static != null && !(this._static.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(dynamic, _static, additionalProperties);
  }
  
  public A removeAllFromDynamic(Collection<DynamicHop> items) {
    if (this.dynamic == null) {
      return (A) this;
    }
    for (DynamicHop item : items) {
        DynamicHopBuilder builder = new DynamicHopBuilder(item);
        _visitables.get("dynamic").remove(builder);
        this.dynamic.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromStatic(Collection<StaticHop> items) {
    if (this._static == null) {
      return (A) this;
    }
    for (StaticHop item : items) {
        StaticHopBuilder builder = new StaticHopBuilder(item);
        _visitables.get("_static").remove(builder);
        this._static.remove(builder);
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
  
  public A removeFromDynamic(DynamicHop... items) {
    if (this.dynamic == null) {
      return (A) this;
    }
    for (DynamicHop item : items) {
        DynamicHopBuilder builder = new DynamicHopBuilder(item);
        _visitables.get("dynamic").remove(builder);
        this.dynamic.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromStatic(StaticHop... items) {
    if (this._static == null) {
      return (A) this;
    }
    for (StaticHop item : items) {
        StaticHopBuilder builder = new StaticHopBuilder(item);
        _visitables.get("_static").remove(builder);
        this._static.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromDynamic(Predicate<DynamicHopBuilder> predicate) {
    if (dynamic == null) {
      return (A) this;
    }
    Iterator<DynamicHopBuilder> each = dynamic.iterator();
    List visitables = _visitables.get("dynamic");
    while (each.hasNext()) {
        DynamicHopBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromStatic(Predicate<StaticHopBuilder> predicate) {
    if (_static == null) {
      return (A) this;
    }
    Iterator<StaticHopBuilder> each = _static.iterator();
    List visitables = _visitables.get("_static");
    while (each.hasNext()) {
        StaticHopBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public DynamicNested<A> setNewDynamicLike(int index,DynamicHop item) {
    return new DynamicNested(index, item);
  }
  
  public StaticNested<A> setNewStaticLike(int index,StaticHop item) {
    return new StaticNested(index, item);
  }
  
  public A setToDynamic(int index,DynamicHop item) {
    if (this.dynamic == null) {
      this.dynamic = new ArrayList();
    }
    DynamicHopBuilder builder = new DynamicHopBuilder(item);
    if (index < 0 || index >= dynamic.size()) {
        _visitables.get("dynamic").add(builder);
        dynamic.add(builder);
    } else {
        _visitables.get("dynamic").add(builder);
        dynamic.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToStatic(int index,StaticHop item) {
    if (this._static == null) {
      this._static = new ArrayList();
    }
    StaticHopBuilder builder = new StaticHopBuilder(item);
    if (index < 0 || index >= _static.size()) {
        _visitables.get("_static").add(builder);
        _static.add(builder);
    } else {
        _visitables.get("_static").add(builder);
        _static.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(dynamic == null) && !(dynamic.isEmpty())) {
        sb.append("dynamic:");
        sb.append(dynamic);
        sb.append(",");
    }
    if (!(_static == null) && !(_static.isEmpty())) {
        sb.append("_static:");
        sb.append(_static);
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
  
  public A withDynamic(List<DynamicHop> dynamic) {
    if (this.dynamic != null) {
      this._visitables.get("dynamic").clear();
    }
    if (dynamic != null) {
        this.dynamic = new ArrayList();
        for (DynamicHop item : dynamic) {
          this.addToDynamic(item);
        }
    } else {
      this.dynamic = null;
    }
    return (A) this;
  }
  
  public A withDynamic(DynamicHop... dynamic) {
    if (this.dynamic != null) {
        this.dynamic.clear();
        _visitables.remove("dynamic");
    }
    if (dynamic != null) {
      for (DynamicHop item : dynamic) {
        this.addToDynamic(item);
      }
    }
    return (A) this;
  }
  
  public A withStatic(List<StaticHop> _static) {
    if (this._static != null) {
      this._visitables.get("_static").clear();
    }
    if (_static != null) {
        this._static = new ArrayList();
        for (StaticHop item : _static) {
          this.addToStatic(item);
        }
    } else {
      this._static = null;
    }
    return (A) this;
  }
  
  public A withStatic(StaticHop... _static) {
    if (this._static != null) {
        this._static.clear();
        _visitables.remove("_static");
    }
    if (_static != null) {
      for (StaticHop item : _static) {
        this.addToStatic(item);
      }
    }
    return (A) this;
  }
  public class DynamicNested<N> extends DynamicHopFluent<DynamicNested<N>> implements Nested<N>{
  
    DynamicHopBuilder builder;
    int index;
  
    DynamicNested(int index,DynamicHop item) {
      this.index = index;
      this.builder = new DynamicHopBuilder(this, item);
    }
  
    public N and() {
      return (N) ExternalNextHopsFluent.this.setToDynamic(index, builder.build());
    }
    
    public N endDynamic() {
      return and();
    }
    
  }
  public class StaticNested<N> extends StaticHopFluent<StaticNested<N>> implements Nested<N>{
  
    StaticHopBuilder builder;
    int index;
  
    StaticNested(int index,StaticHop item) {
      this.index = index;
      this.builder = new StaticHopBuilder(this, item);
    }
  
    public N and() {
      return (N) ExternalNextHopsFluent.this.setToStatic(index, builder.build());
    }
    
    public N endStatic() {
      return and();
    }
    
  }
}