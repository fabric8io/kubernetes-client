package io.fabric8.chaosmesh.v1alpha1;

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
public class PodIOChaosSpecFluent<A extends io.fabric8.chaosmesh.v1alpha1.PodIOChaosSpecFluent<A>> extends BaseFluent<A>{

  private ArrayList<IOChaosActionBuilder> actions = new ArrayList<IOChaosActionBuilder>();
  private Map<String,Object> additionalProperties;
  private String container;
  private String volumeMountPath;

  public PodIOChaosSpecFluent() {
  }
  
  public PodIOChaosSpecFluent(PodIOChaosSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToActions(Collection<IOChaosAction> items) {
    if (this.actions == null) {
      this.actions = new ArrayList();
    }
    for (IOChaosAction item : items) {
        IOChaosActionBuilder builder = new IOChaosActionBuilder(item);
        _visitables.get("actions").add(builder);
        this.actions.add(builder);
    }
    return (A) this;
  }
  
  public ActionsNested<A> addNewAction() {
    return new ActionsNested(-1, null);
  }
  
  public ActionsNested<A> addNewActionLike(IOChaosAction item) {
    return new ActionsNested(-1, item);
  }
  
  public A addToActions(IOChaosAction... items) {
    if (this.actions == null) {
      this.actions = new ArrayList();
    }
    for (IOChaosAction item : items) {
        IOChaosActionBuilder builder = new IOChaosActionBuilder(item);
        _visitables.get("actions").add(builder);
        this.actions.add(builder);
    }
    return (A) this;
  }
  
  public A addToActions(int index,IOChaosAction item) {
    if (this.actions == null) {
      this.actions = new ArrayList();
    }
    IOChaosActionBuilder builder = new IOChaosActionBuilder(item);
    if (index < 0 || index >= actions.size()) {
        _visitables.get("actions").add(builder);
        actions.add(builder);
    } else {
        _visitables.get("actions").add(builder);
        actions.add(index, builder);
    }
    return (A) this;
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
  
  public IOChaosAction buildAction(int index) {
    return this.actions.get(index).build();
  }
  
  public List<IOChaosAction> buildActions() {
    return this.actions != null ? build(actions) : null;
  }
  
  public IOChaosAction buildFirstAction() {
    return this.actions.get(0).build();
  }
  
  public IOChaosAction buildLastAction() {
    return this.actions.get(actions.size() - 1).build();
  }
  
  public IOChaosAction buildMatchingAction(Predicate<IOChaosActionBuilder> predicate) {
      for (IOChaosActionBuilder item : actions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(PodIOChaosSpec instance) {
    instance = instance != null ? instance : new PodIOChaosSpec();
    if (instance != null) {
        this.withActions(instance.getActions());
        this.withContainer(instance.getContainer());
        this.withVolumeMountPath(instance.getVolumeMountPath());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ActionsNested<A> editAction(int index) {
    if (actions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "actions"));
    }
    return this.setNewActionLike(index, this.buildAction(index));
  }
  
  public ActionsNested<A> editFirstAction() {
    if (actions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "actions"));
    }
    return this.setNewActionLike(0, this.buildAction(0));
  }
  
  public ActionsNested<A> editLastAction() {
    int index = actions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "actions"));
    }
    return this.setNewActionLike(index, this.buildAction(index));
  }
  
  public ActionsNested<A> editMatchingAction(Predicate<IOChaosActionBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < actions.size();i++) {
      if (predicate.test(actions.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "actions"));
    }
    return this.setNewActionLike(index, this.buildAction(index));
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
    PodIOChaosSpecFluent that = (PodIOChaosSpecFluent) o;
    if (!(Objects.equals(actions, that.actions))) {
      return false;
    }
    if (!(Objects.equals(container, that.container))) {
      return false;
    }
    if (!(Objects.equals(volumeMountPath, that.volumeMountPath))) {
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
  
  public String getContainer() {
    return this.container;
  }
  
  public String getVolumeMountPath() {
    return this.volumeMountPath;
  }
  
  public boolean hasActions() {
    return this.actions != null && !(this.actions.isEmpty());
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasContainer() {
    return this.container != null;
  }
  
  public boolean hasMatchingAction(Predicate<IOChaosActionBuilder> predicate) {
      for (IOChaosActionBuilder item : actions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasVolumeMountPath() {
    return this.volumeMountPath != null;
  }
  
  public int hashCode() {
    return Objects.hash(actions, container, volumeMountPath, additionalProperties);
  }
  
  public A removeAllFromActions(Collection<IOChaosAction> items) {
    if (this.actions == null) {
      return (A) this;
    }
    for (IOChaosAction item : items) {
        IOChaosActionBuilder builder = new IOChaosActionBuilder(item);
        _visitables.get("actions").remove(builder);
        this.actions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromActions(IOChaosAction... items) {
    if (this.actions == null) {
      return (A) this;
    }
    for (IOChaosAction item : items) {
        IOChaosActionBuilder builder = new IOChaosActionBuilder(item);
        _visitables.get("actions").remove(builder);
        this.actions.remove(builder);
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
  
  public A removeMatchingFromActions(Predicate<IOChaosActionBuilder> predicate) {
    if (actions == null) {
      return (A) this;
    }
    Iterator<IOChaosActionBuilder> each = actions.iterator();
    List visitables = _visitables.get("actions");
    while (each.hasNext()) {
        IOChaosActionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ActionsNested<A> setNewActionLike(int index,IOChaosAction item) {
    return new ActionsNested(index, item);
  }
  
  public A setToActions(int index,IOChaosAction item) {
    if (this.actions == null) {
      this.actions = new ArrayList();
    }
    IOChaosActionBuilder builder = new IOChaosActionBuilder(item);
    if (index < 0 || index >= actions.size()) {
        _visitables.get("actions").add(builder);
        actions.add(builder);
    } else {
        _visitables.get("actions").add(builder);
        actions.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(actions == null) && !(actions.isEmpty())) {
        sb.append("actions:");
        sb.append(actions);
        sb.append(",");
    }
    if (!(container == null)) {
        sb.append("container:");
        sb.append(container);
        sb.append(",");
    }
    if (!(volumeMountPath == null)) {
        sb.append("volumeMountPath:");
        sb.append(volumeMountPath);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withActions(List<IOChaosAction> actions) {
    if (this.actions != null) {
      this._visitables.get("actions").clear();
    }
    if (actions != null) {
        this.actions = new ArrayList();
        for (IOChaosAction item : actions) {
          this.addToActions(item);
        }
    } else {
      this.actions = null;
    }
    return (A) this;
  }
  
  public A withActions(IOChaosAction... actions) {
    if (this.actions != null) {
        this.actions.clear();
        _visitables.remove("actions");
    }
    if (actions != null) {
      for (IOChaosAction item : actions) {
        this.addToActions(item);
      }
    }
    return (A) this;
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withContainer(String container) {
    this.container = container;
    return (A) this;
  }
  
  public A withVolumeMountPath(String volumeMountPath) {
    this.volumeMountPath = volumeMountPath;
    return (A) this;
  }
  public class ActionsNested<N> extends IOChaosActionFluent<ActionsNested<N>> implements Nested<N>{
  
    IOChaosActionBuilder builder;
    int index;
  
    ActionsNested(int index,IOChaosAction item) {
      this.index = index;
      this.builder = new IOChaosActionBuilder(this, item);
    }
  
    public N and() {
      return (N) PodIOChaosSpecFluent.this.setToActions(index, builder.build());
    }
    
    public N endAction() {
      return and();
    }
    
  }
}