package io.fabric8.openshift.api.model.machine.v1beta1;

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
public class LifecycleHooksFluent<A extends io.fabric8.openshift.api.model.machine.v1beta1.LifecycleHooksFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<LifecycleHookBuilder> preDrain = new ArrayList<LifecycleHookBuilder>();
  private ArrayList<LifecycleHookBuilder> preTerminate = new ArrayList<LifecycleHookBuilder>();

  public LifecycleHooksFluent() {
  }
  
  public LifecycleHooksFluent(LifecycleHooks instance) {
    this.copyInstance(instance);
  }

  public A addAllToPreDrain(Collection<LifecycleHook> items) {
    if (this.preDrain == null) {
      this.preDrain = new ArrayList();
    }
    for (LifecycleHook item : items) {
        LifecycleHookBuilder builder = new LifecycleHookBuilder(item);
        _visitables.get("preDrain").add(builder);
        this.preDrain.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToPreTerminate(Collection<LifecycleHook> items) {
    if (this.preTerminate == null) {
      this.preTerminate = new ArrayList();
    }
    for (LifecycleHook item : items) {
        LifecycleHookBuilder builder = new LifecycleHookBuilder(item);
        _visitables.get("preTerminate").add(builder);
        this.preTerminate.add(builder);
    }
    return (A) this;
  }
  
  public PreDrainNested<A> addNewPreDrain() {
    return new PreDrainNested(-1, null);
  }
  
  public A addNewPreDrain(String name,String owner) {
    return (A) this.addToPreDrain(new LifecycleHook(name, owner));
  }
  
  public PreDrainNested<A> addNewPreDrainLike(LifecycleHook item) {
    return new PreDrainNested(-1, item);
  }
  
  public PreTerminateNested<A> addNewPreTerminate() {
    return new PreTerminateNested(-1, null);
  }
  
  public A addNewPreTerminate(String name,String owner) {
    return (A) this.addToPreTerminate(new LifecycleHook(name, owner));
  }
  
  public PreTerminateNested<A> addNewPreTerminateLike(LifecycleHook item) {
    return new PreTerminateNested(-1, item);
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
  
  public A addToPreDrain(LifecycleHook... items) {
    if (this.preDrain == null) {
      this.preDrain = new ArrayList();
    }
    for (LifecycleHook item : items) {
        LifecycleHookBuilder builder = new LifecycleHookBuilder(item);
        _visitables.get("preDrain").add(builder);
        this.preDrain.add(builder);
    }
    return (A) this;
  }
  
  public A addToPreDrain(int index,LifecycleHook item) {
    if (this.preDrain == null) {
      this.preDrain = new ArrayList();
    }
    LifecycleHookBuilder builder = new LifecycleHookBuilder(item);
    if (index < 0 || index >= preDrain.size()) {
        _visitables.get("preDrain").add(builder);
        preDrain.add(builder);
    } else {
        _visitables.get("preDrain").add(builder);
        preDrain.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToPreTerminate(LifecycleHook... items) {
    if (this.preTerminate == null) {
      this.preTerminate = new ArrayList();
    }
    for (LifecycleHook item : items) {
        LifecycleHookBuilder builder = new LifecycleHookBuilder(item);
        _visitables.get("preTerminate").add(builder);
        this.preTerminate.add(builder);
    }
    return (A) this;
  }
  
  public A addToPreTerminate(int index,LifecycleHook item) {
    if (this.preTerminate == null) {
      this.preTerminate = new ArrayList();
    }
    LifecycleHookBuilder builder = new LifecycleHookBuilder(item);
    if (index < 0 || index >= preTerminate.size()) {
        _visitables.get("preTerminate").add(builder);
        preTerminate.add(builder);
    } else {
        _visitables.get("preTerminate").add(builder);
        preTerminate.add(index, builder);
    }
    return (A) this;
  }
  
  public LifecycleHook buildFirstPreDrain() {
    return this.preDrain.get(0).build();
  }
  
  public LifecycleHook buildFirstPreTerminate() {
    return this.preTerminate.get(0).build();
  }
  
  public LifecycleHook buildLastPreDrain() {
    return this.preDrain.get(preDrain.size() - 1).build();
  }
  
  public LifecycleHook buildLastPreTerminate() {
    return this.preTerminate.get(preTerminate.size() - 1).build();
  }
  
  public LifecycleHook buildMatchingPreDrain(Predicate<LifecycleHookBuilder> predicate) {
      for (LifecycleHookBuilder item : preDrain) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public LifecycleHook buildMatchingPreTerminate(Predicate<LifecycleHookBuilder> predicate) {
      for (LifecycleHookBuilder item : preTerminate) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public List<LifecycleHook> buildPreDrain() {
    return this.preDrain != null ? build(preDrain) : null;
  }
  
  public LifecycleHook buildPreDrain(int index) {
    return this.preDrain.get(index).build();
  }
  
  public List<LifecycleHook> buildPreTerminate() {
    return this.preTerminate != null ? build(preTerminate) : null;
  }
  
  public LifecycleHook buildPreTerminate(int index) {
    return this.preTerminate.get(index).build();
  }
  
  protected void copyInstance(LifecycleHooks instance) {
    instance = instance != null ? instance : new LifecycleHooks();
    if (instance != null) {
        this.withPreDrain(instance.getPreDrain());
        this.withPreTerminate(instance.getPreTerminate());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PreDrainNested<A> editFirstPreDrain() {
    if (preDrain.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "preDrain"));
    }
    return this.setNewPreDrainLike(0, this.buildPreDrain(0));
  }
  
  public PreTerminateNested<A> editFirstPreTerminate() {
    if (preTerminate.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "preTerminate"));
    }
    return this.setNewPreTerminateLike(0, this.buildPreTerminate(0));
  }
  
  public PreDrainNested<A> editLastPreDrain() {
    int index = preDrain.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "preDrain"));
    }
    return this.setNewPreDrainLike(index, this.buildPreDrain(index));
  }
  
  public PreTerminateNested<A> editLastPreTerminate() {
    int index = preTerminate.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "preTerminate"));
    }
    return this.setNewPreTerminateLike(index, this.buildPreTerminate(index));
  }
  
  public PreDrainNested<A> editMatchingPreDrain(Predicate<LifecycleHookBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < preDrain.size();i++) {
      if (predicate.test(preDrain.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "preDrain"));
    }
    return this.setNewPreDrainLike(index, this.buildPreDrain(index));
  }
  
  public PreTerminateNested<A> editMatchingPreTerminate(Predicate<LifecycleHookBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < preTerminate.size();i++) {
      if (predicate.test(preTerminate.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "preTerminate"));
    }
    return this.setNewPreTerminateLike(index, this.buildPreTerminate(index));
  }
  
  public PreDrainNested<A> editPreDrain(int index) {
    if (preDrain.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "preDrain"));
    }
    return this.setNewPreDrainLike(index, this.buildPreDrain(index));
  }
  
  public PreTerminateNested<A> editPreTerminate(int index) {
    if (preTerminate.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "preTerminate"));
    }
    return this.setNewPreTerminateLike(index, this.buildPreTerminate(index));
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
    LifecycleHooksFluent that = (LifecycleHooksFluent) o;
    if (!(Objects.equals(preDrain, that.preDrain))) {
      return false;
    }
    if (!(Objects.equals(preTerminate, that.preTerminate))) {
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
  
  public boolean hasMatchingPreDrain(Predicate<LifecycleHookBuilder> predicate) {
      for (LifecycleHookBuilder item : preDrain) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingPreTerminate(Predicate<LifecycleHookBuilder> predicate) {
      for (LifecycleHookBuilder item : preTerminate) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPreDrain() {
    return this.preDrain != null && !(this.preDrain.isEmpty());
  }
  
  public boolean hasPreTerminate() {
    return this.preTerminate != null && !(this.preTerminate.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(preDrain, preTerminate, additionalProperties);
  }
  
  public A removeAllFromPreDrain(Collection<LifecycleHook> items) {
    if (this.preDrain == null) {
      return (A) this;
    }
    for (LifecycleHook item : items) {
        LifecycleHookBuilder builder = new LifecycleHookBuilder(item);
        _visitables.get("preDrain").remove(builder);
        this.preDrain.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromPreTerminate(Collection<LifecycleHook> items) {
    if (this.preTerminate == null) {
      return (A) this;
    }
    for (LifecycleHook item : items) {
        LifecycleHookBuilder builder = new LifecycleHookBuilder(item);
        _visitables.get("preTerminate").remove(builder);
        this.preTerminate.remove(builder);
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
  
  public A removeFromPreDrain(LifecycleHook... items) {
    if (this.preDrain == null) {
      return (A) this;
    }
    for (LifecycleHook item : items) {
        LifecycleHookBuilder builder = new LifecycleHookBuilder(item);
        _visitables.get("preDrain").remove(builder);
        this.preDrain.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromPreTerminate(LifecycleHook... items) {
    if (this.preTerminate == null) {
      return (A) this;
    }
    for (LifecycleHook item : items) {
        LifecycleHookBuilder builder = new LifecycleHookBuilder(item);
        _visitables.get("preTerminate").remove(builder);
        this.preTerminate.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromPreDrain(Predicate<LifecycleHookBuilder> predicate) {
    if (preDrain == null) {
      return (A) this;
    }
    Iterator<LifecycleHookBuilder> each = preDrain.iterator();
    List visitables = _visitables.get("preDrain");
    while (each.hasNext()) {
        LifecycleHookBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromPreTerminate(Predicate<LifecycleHookBuilder> predicate) {
    if (preTerminate == null) {
      return (A) this;
    }
    Iterator<LifecycleHookBuilder> each = preTerminate.iterator();
    List visitables = _visitables.get("preTerminate");
    while (each.hasNext()) {
        LifecycleHookBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public PreDrainNested<A> setNewPreDrainLike(int index,LifecycleHook item) {
    return new PreDrainNested(index, item);
  }
  
  public PreTerminateNested<A> setNewPreTerminateLike(int index,LifecycleHook item) {
    return new PreTerminateNested(index, item);
  }
  
  public A setToPreDrain(int index,LifecycleHook item) {
    if (this.preDrain == null) {
      this.preDrain = new ArrayList();
    }
    LifecycleHookBuilder builder = new LifecycleHookBuilder(item);
    if (index < 0 || index >= preDrain.size()) {
        _visitables.get("preDrain").add(builder);
        preDrain.add(builder);
    } else {
        _visitables.get("preDrain").add(builder);
        preDrain.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToPreTerminate(int index,LifecycleHook item) {
    if (this.preTerminate == null) {
      this.preTerminate = new ArrayList();
    }
    LifecycleHookBuilder builder = new LifecycleHookBuilder(item);
    if (index < 0 || index >= preTerminate.size()) {
        _visitables.get("preTerminate").add(builder);
        preTerminate.add(builder);
    } else {
        _visitables.get("preTerminate").add(builder);
        preTerminate.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(preDrain == null) && !(preDrain.isEmpty())) {
        sb.append("preDrain:");
        sb.append(preDrain);
        sb.append(",");
    }
    if (!(preTerminate == null) && !(preTerminate.isEmpty())) {
        sb.append("preTerminate:");
        sb.append(preTerminate);
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
  
  public A withPreDrain(List<LifecycleHook> preDrain) {
    if (this.preDrain != null) {
      this._visitables.get("preDrain").clear();
    }
    if (preDrain != null) {
        this.preDrain = new ArrayList();
        for (LifecycleHook item : preDrain) {
          this.addToPreDrain(item);
        }
    } else {
      this.preDrain = null;
    }
    return (A) this;
  }
  
  public A withPreDrain(LifecycleHook... preDrain) {
    if (this.preDrain != null) {
        this.preDrain.clear();
        _visitables.remove("preDrain");
    }
    if (preDrain != null) {
      for (LifecycleHook item : preDrain) {
        this.addToPreDrain(item);
      }
    }
    return (A) this;
  }
  
  public A withPreTerminate(List<LifecycleHook> preTerminate) {
    if (this.preTerminate != null) {
      this._visitables.get("preTerminate").clear();
    }
    if (preTerminate != null) {
        this.preTerminate = new ArrayList();
        for (LifecycleHook item : preTerminate) {
          this.addToPreTerminate(item);
        }
    } else {
      this.preTerminate = null;
    }
    return (A) this;
  }
  
  public A withPreTerminate(LifecycleHook... preTerminate) {
    if (this.preTerminate != null) {
        this.preTerminate.clear();
        _visitables.remove("preTerminate");
    }
    if (preTerminate != null) {
      for (LifecycleHook item : preTerminate) {
        this.addToPreTerminate(item);
      }
    }
    return (A) this;
  }
  public class PreDrainNested<N> extends LifecycleHookFluent<PreDrainNested<N>> implements Nested<N>{
  
    LifecycleHookBuilder builder;
    int index;
  
    PreDrainNested(int index,LifecycleHook item) {
      this.index = index;
      this.builder = new LifecycleHookBuilder(this, item);
    }
  
    public N and() {
      return (N) LifecycleHooksFluent.this.setToPreDrain(index, builder.build());
    }
    
    public N endPreDrain() {
      return and();
    }
    
  }
  public class PreTerminateNested<N> extends LifecycleHookFluent<PreTerminateNested<N>> implements Nested<N>{
  
    LifecycleHookBuilder builder;
    int index;
  
    PreTerminateNested(int index,LifecycleHook item) {
      this.index = index;
      this.builder = new LifecycleHookBuilder(this, item);
    }
  
    public N and() {
      return (N) LifecycleHooksFluent.this.setToPreTerminate(index, builder.build());
    }
    
    public N endPreTerminate() {
      return and();
    }
    
  }
}