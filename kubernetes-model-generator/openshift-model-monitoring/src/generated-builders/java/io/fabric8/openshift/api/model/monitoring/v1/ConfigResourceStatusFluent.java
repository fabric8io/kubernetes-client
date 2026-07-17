package io.fabric8.openshift.api.model.monitoring.v1;

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
public class ConfigResourceStatusFluent<A extends io.fabric8.openshift.api.model.monitoring.v1.ConfigResourceStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<WorkloadBindingBuilder> bindings = new ArrayList<WorkloadBindingBuilder>();

  public ConfigResourceStatusFluent() {
  }
  
  public ConfigResourceStatusFluent(ConfigResourceStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToBindings(Collection<WorkloadBinding> items) {
    if (this.bindings == null) {
      this.bindings = new ArrayList();
    }
    for (WorkloadBinding item : items) {
        WorkloadBindingBuilder builder = new WorkloadBindingBuilder(item);
        _visitables.get("bindings").add(builder);
        this.bindings.add(builder);
    }
    return (A) this;
  }
  
  public BindingsNested<A> addNewBinding() {
    return new BindingsNested(-1, null);
  }
  
  public BindingsNested<A> addNewBindingLike(WorkloadBinding item) {
    return new BindingsNested(-1, item);
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
  
  public A addToBindings(WorkloadBinding... items) {
    if (this.bindings == null) {
      this.bindings = new ArrayList();
    }
    for (WorkloadBinding item : items) {
        WorkloadBindingBuilder builder = new WorkloadBindingBuilder(item);
        _visitables.get("bindings").add(builder);
        this.bindings.add(builder);
    }
    return (A) this;
  }
  
  public A addToBindings(int index,WorkloadBinding item) {
    if (this.bindings == null) {
      this.bindings = new ArrayList();
    }
    WorkloadBindingBuilder builder = new WorkloadBindingBuilder(item);
    if (index < 0 || index >= bindings.size()) {
        _visitables.get("bindings").add(builder);
        bindings.add(builder);
    } else {
        _visitables.get("bindings").add(builder);
        bindings.add(index, builder);
    }
    return (A) this;
  }
  
  public WorkloadBinding buildBinding(int index) {
    return this.bindings.get(index).build();
  }
  
  public List<WorkloadBinding> buildBindings() {
    return this.bindings != null ? build(bindings) : null;
  }
  
  public WorkloadBinding buildFirstBinding() {
    return this.bindings.get(0).build();
  }
  
  public WorkloadBinding buildLastBinding() {
    return this.bindings.get(bindings.size() - 1).build();
  }
  
  public WorkloadBinding buildMatchingBinding(Predicate<WorkloadBindingBuilder> predicate) {
      for (WorkloadBindingBuilder item : bindings) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(ConfigResourceStatus instance) {
    instance = instance != null ? instance : new ConfigResourceStatus();
    if (instance != null) {
        this.withBindings(instance.getBindings());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public BindingsNested<A> editBinding(int index) {
    if (bindings.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "bindings"));
    }
    return this.setNewBindingLike(index, this.buildBinding(index));
  }
  
  public BindingsNested<A> editFirstBinding() {
    if (bindings.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "bindings"));
    }
    return this.setNewBindingLike(0, this.buildBinding(0));
  }
  
  public BindingsNested<A> editLastBinding() {
    int index = bindings.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "bindings"));
    }
    return this.setNewBindingLike(index, this.buildBinding(index));
  }
  
  public BindingsNested<A> editMatchingBinding(Predicate<WorkloadBindingBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < bindings.size();i++) {
      if (predicate.test(bindings.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "bindings"));
    }
    return this.setNewBindingLike(index, this.buildBinding(index));
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
    ConfigResourceStatusFluent that = (ConfigResourceStatusFluent) o;
    if (!(Objects.equals(bindings, that.bindings))) {
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
  
  public boolean hasBindings() {
    return this.bindings != null && !(this.bindings.isEmpty());
  }
  
  public boolean hasMatchingBinding(Predicate<WorkloadBindingBuilder> predicate) {
      for (WorkloadBindingBuilder item : bindings) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(bindings, additionalProperties);
  }
  
  public A removeAllFromBindings(Collection<WorkloadBinding> items) {
    if (this.bindings == null) {
      return (A) this;
    }
    for (WorkloadBinding item : items) {
        WorkloadBindingBuilder builder = new WorkloadBindingBuilder(item);
        _visitables.get("bindings").remove(builder);
        this.bindings.remove(builder);
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
  
  public A removeFromBindings(WorkloadBinding... items) {
    if (this.bindings == null) {
      return (A) this;
    }
    for (WorkloadBinding item : items) {
        WorkloadBindingBuilder builder = new WorkloadBindingBuilder(item);
        _visitables.get("bindings").remove(builder);
        this.bindings.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromBindings(Predicate<WorkloadBindingBuilder> predicate) {
    if (bindings == null) {
      return (A) this;
    }
    Iterator<WorkloadBindingBuilder> each = bindings.iterator();
    List visitables = _visitables.get("bindings");
    while (each.hasNext()) {
        WorkloadBindingBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public BindingsNested<A> setNewBindingLike(int index,WorkloadBinding item) {
    return new BindingsNested(index, item);
  }
  
  public A setToBindings(int index,WorkloadBinding item) {
    if (this.bindings == null) {
      this.bindings = new ArrayList();
    }
    WorkloadBindingBuilder builder = new WorkloadBindingBuilder(item);
    if (index < 0 || index >= bindings.size()) {
        _visitables.get("bindings").add(builder);
        bindings.add(builder);
    } else {
        _visitables.get("bindings").add(builder);
        bindings.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(bindings == null) && !(bindings.isEmpty())) {
        sb.append("bindings:");
        sb.append(bindings);
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
  
  public A withBindings(List<WorkloadBinding> bindings) {
    if (this.bindings != null) {
      this._visitables.get("bindings").clear();
    }
    if (bindings != null) {
        this.bindings = new ArrayList();
        for (WorkloadBinding item : bindings) {
          this.addToBindings(item);
        }
    } else {
      this.bindings = null;
    }
    return (A) this;
  }
  
  public A withBindings(WorkloadBinding... bindings) {
    if (this.bindings != null) {
        this.bindings.clear();
        _visitables.remove("bindings");
    }
    if (bindings != null) {
      for (WorkloadBinding item : bindings) {
        this.addToBindings(item);
      }
    }
    return (A) this;
  }
  public class BindingsNested<N> extends WorkloadBindingFluent<BindingsNested<N>> implements Nested<N>{
  
    WorkloadBindingBuilder builder;
    int index;
  
    BindingsNested(int index,WorkloadBinding item) {
      this.index = index;
      this.builder = new WorkloadBindingBuilder(this, item);
    }
  
    public N and() {
      return (N) ConfigResourceStatusFluent.this.setToBindings(index, builder.build());
    }
    
    public N endBinding() {
      return and();
    }
    
  }
}