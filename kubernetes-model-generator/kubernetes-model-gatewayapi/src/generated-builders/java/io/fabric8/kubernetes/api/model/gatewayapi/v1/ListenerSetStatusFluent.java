package io.fabric8.kubernetes.api.model.gatewayapi.v1;

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
public class ListenerSetStatusFluent<A extends io.fabric8.kubernetes.api.model.gatewayapi.v1.ListenerSetStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<Condition> conditions = new ArrayList<Condition>();
  private ArrayList<ListenerEntryStatusBuilder> listeners = new ArrayList<ListenerEntryStatusBuilder>();

  public ListenerSetStatusFluent() {
  }
  
  public ListenerSetStatusFluent(ListenerSetStatus instance) {
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
  
  public A addAllToListeners(Collection<ListenerEntryStatus> items) {
    if (this.listeners == null) {
      this.listeners = new ArrayList();
    }
    for (ListenerEntryStatus item : items) {
        ListenerEntryStatusBuilder builder = new ListenerEntryStatusBuilder(item);
        _visitables.get("listeners").add(builder);
        this.listeners.add(builder);
    }
    return (A) this;
  }
  
  public ListenersNested<A> addNewListener() {
    return new ListenersNested(-1, null);
  }
  
  public ListenersNested<A> addNewListenerLike(ListenerEntryStatus item) {
    return new ListenersNested(-1, item);
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
  
  public A addToListeners(ListenerEntryStatus... items) {
    if (this.listeners == null) {
      this.listeners = new ArrayList();
    }
    for (ListenerEntryStatus item : items) {
        ListenerEntryStatusBuilder builder = new ListenerEntryStatusBuilder(item);
        _visitables.get("listeners").add(builder);
        this.listeners.add(builder);
    }
    return (A) this;
  }
  
  public A addToListeners(int index,ListenerEntryStatus item) {
    if (this.listeners == null) {
      this.listeners = new ArrayList();
    }
    ListenerEntryStatusBuilder builder = new ListenerEntryStatusBuilder(item);
    if (index < 0 || index >= listeners.size()) {
        _visitables.get("listeners").add(builder);
        listeners.add(builder);
    } else {
        _visitables.get("listeners").add(builder);
        listeners.add(index, builder);
    }
    return (A) this;
  }
  
  public ListenerEntryStatus buildFirstListener() {
    return this.listeners.get(0).build();
  }
  
  public ListenerEntryStatus buildLastListener() {
    return this.listeners.get(listeners.size() - 1).build();
  }
  
  public ListenerEntryStatus buildListener(int index) {
    return this.listeners.get(index).build();
  }
  
  public List<ListenerEntryStatus> buildListeners() {
    return this.listeners != null ? build(listeners) : null;
  }
  
  public ListenerEntryStatus buildMatchingListener(Predicate<ListenerEntryStatusBuilder> predicate) {
      for (ListenerEntryStatusBuilder item : listeners) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(ListenerSetStatus instance) {
    instance = instance != null ? instance : new ListenerSetStatus();
    if (instance != null) {
        this.withConditions(instance.getConditions());
        this.withListeners(instance.getListeners());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ListenersNested<A> editFirstListener() {
    if (listeners.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "listeners"));
    }
    return this.setNewListenerLike(0, this.buildListener(0));
  }
  
  public ListenersNested<A> editLastListener() {
    int index = listeners.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "listeners"));
    }
    return this.setNewListenerLike(index, this.buildListener(index));
  }
  
  public ListenersNested<A> editListener(int index) {
    if (listeners.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "listeners"));
    }
    return this.setNewListenerLike(index, this.buildListener(index));
  }
  
  public ListenersNested<A> editMatchingListener(Predicate<ListenerEntryStatusBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < listeners.size();i++) {
      if (predicate.test(listeners.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "listeners"));
    }
    return this.setNewListenerLike(index, this.buildListener(index));
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
    ListenerSetStatusFluent that = (ListenerSetStatusFluent) o;
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(listeners, that.listeners))) {
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
  
  public boolean hasListeners() {
    return this.listeners != null && !(this.listeners.isEmpty());
  }
  
  public boolean hasMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingListener(Predicate<ListenerEntryStatusBuilder> predicate) {
      for (ListenerEntryStatusBuilder item : listeners) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(conditions, listeners, additionalProperties);
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
  
  public A removeAllFromListeners(Collection<ListenerEntryStatus> items) {
    if (this.listeners == null) {
      return (A) this;
    }
    for (ListenerEntryStatus item : items) {
        ListenerEntryStatusBuilder builder = new ListenerEntryStatusBuilder(item);
        _visitables.get("listeners").remove(builder);
        this.listeners.remove(builder);
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
  
  public A removeFromListeners(ListenerEntryStatus... items) {
    if (this.listeners == null) {
      return (A) this;
    }
    for (ListenerEntryStatus item : items) {
        ListenerEntryStatusBuilder builder = new ListenerEntryStatusBuilder(item);
        _visitables.get("listeners").remove(builder);
        this.listeners.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromListeners(Predicate<ListenerEntryStatusBuilder> predicate) {
    if (listeners == null) {
      return (A) this;
    }
    Iterator<ListenerEntryStatusBuilder> each = listeners.iterator();
    List visitables = _visitables.get("listeners");
    while (each.hasNext()) {
        ListenerEntryStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ListenersNested<A> setNewListenerLike(int index,ListenerEntryStatus item) {
    return new ListenersNested(index, item);
  }
  
  public A setToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.set(index, item);
    return (A) this;
  }
  
  public A setToListeners(int index,ListenerEntryStatus item) {
    if (this.listeners == null) {
      this.listeners = new ArrayList();
    }
    ListenerEntryStatusBuilder builder = new ListenerEntryStatusBuilder(item);
    if (index < 0 || index >= listeners.size()) {
        _visitables.get("listeners").add(builder);
        listeners.add(builder);
    } else {
        _visitables.get("listeners").add(builder);
        listeners.set(index, builder);
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
    if (!(listeners == null) && !(listeners.isEmpty())) {
        sb.append("listeners:");
        sb.append(listeners);
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
  
  public A withListeners(List<ListenerEntryStatus> listeners) {
    if (this.listeners != null) {
      this._visitables.get("listeners").clear();
    }
    if (listeners != null) {
        this.listeners = new ArrayList();
        for (ListenerEntryStatus item : listeners) {
          this.addToListeners(item);
        }
    } else {
      this.listeners = null;
    }
    return (A) this;
  }
  
  public A withListeners(ListenerEntryStatus... listeners) {
    if (this.listeners != null) {
        this.listeners.clear();
        _visitables.remove("listeners");
    }
    if (listeners != null) {
      for (ListenerEntryStatus item : listeners) {
        this.addToListeners(item);
      }
    }
    return (A) this;
  }
  public class ListenersNested<N> extends ListenerEntryStatusFluent<ListenersNested<N>> implements Nested<N>{
  
    ListenerEntryStatusBuilder builder;
    int index;
  
    ListenersNested(int index,ListenerEntryStatus item) {
      this.index = index;
      this.builder = new ListenerEntryStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) ListenerSetStatusFluent.this.setToListeners(index, builder.build());
    }
    
    public N endListener() {
      return and();
    }
    
  }
}