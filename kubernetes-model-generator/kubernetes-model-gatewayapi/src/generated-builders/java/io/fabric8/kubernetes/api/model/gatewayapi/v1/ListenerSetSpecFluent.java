package io.fabric8.kubernetes.api.model.gatewayapi.v1;

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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ListenerSetSpecFluent<A extends io.fabric8.kubernetes.api.model.gatewayapi.v1.ListenerSetSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<ListenerEntryBuilder> listeners = new ArrayList<ListenerEntryBuilder>();
  private ParentGatewayReferenceBuilder parentRef;

  public ListenerSetSpecFluent() {
  }
  
  public ListenerSetSpecFluent(ListenerSetSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToListeners(Collection<ListenerEntry> items) {
    if (this.listeners == null) {
      this.listeners = new ArrayList();
    }
    for (ListenerEntry item : items) {
        ListenerEntryBuilder builder = new ListenerEntryBuilder(item);
        _visitables.get("listeners").add(builder);
        this.listeners.add(builder);
    }
    return (A) this;
  }
  
  public ListenersNested<A> addNewListener() {
    return new ListenersNested(-1, null);
  }
  
  public ListenersNested<A> addNewListenerLike(ListenerEntry item) {
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
  
  public A addToListeners(ListenerEntry... items) {
    if (this.listeners == null) {
      this.listeners = new ArrayList();
    }
    for (ListenerEntry item : items) {
        ListenerEntryBuilder builder = new ListenerEntryBuilder(item);
        _visitables.get("listeners").add(builder);
        this.listeners.add(builder);
    }
    return (A) this;
  }
  
  public A addToListeners(int index,ListenerEntry item) {
    if (this.listeners == null) {
      this.listeners = new ArrayList();
    }
    ListenerEntryBuilder builder = new ListenerEntryBuilder(item);
    if (index < 0 || index >= listeners.size()) {
        _visitables.get("listeners").add(builder);
        listeners.add(builder);
    } else {
        _visitables.get("listeners").add(builder);
        listeners.add(index, builder);
    }
    return (A) this;
  }
  
  public ListenerEntry buildFirstListener() {
    return this.listeners.get(0).build();
  }
  
  public ListenerEntry buildLastListener() {
    return this.listeners.get(listeners.size() - 1).build();
  }
  
  public ListenerEntry buildListener(int index) {
    return this.listeners.get(index).build();
  }
  
  public List<ListenerEntry> buildListeners() {
    return this.listeners != null ? build(listeners) : null;
  }
  
  public ListenerEntry buildMatchingListener(Predicate<ListenerEntryBuilder> predicate) {
      for (ListenerEntryBuilder item : listeners) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ParentGatewayReference buildParentRef() {
    return this.parentRef != null ? this.parentRef.build() : null;
  }
  
  protected void copyInstance(ListenerSetSpec instance) {
    instance = instance != null ? instance : new ListenerSetSpec();
    if (instance != null) {
        this.withListeners(instance.getListeners());
        this.withParentRef(instance.getParentRef());
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
  
  public ListenersNested<A> editMatchingListener(Predicate<ListenerEntryBuilder> predicate) {
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
  
  public ParentRefNested<A> editOrNewParentRef() {
    return this.withNewParentRefLike(Optional.ofNullable(this.buildParentRef()).orElse(new ParentGatewayReferenceBuilder().build()));
  }
  
  public ParentRefNested<A> editOrNewParentRefLike(ParentGatewayReference item) {
    return this.withNewParentRefLike(Optional.ofNullable(this.buildParentRef()).orElse(item));
  }
  
  public ParentRefNested<A> editParentRef() {
    return this.withNewParentRefLike(Optional.ofNullable(this.buildParentRef()).orElse(null));
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
    ListenerSetSpecFluent that = (ListenerSetSpecFluent) o;
    if (!(Objects.equals(listeners, that.listeners))) {
      return false;
    }
    if (!(Objects.equals(parentRef, that.parentRef))) {
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
  
  public boolean hasListeners() {
    return this.listeners != null && !(this.listeners.isEmpty());
  }
  
  public boolean hasMatchingListener(Predicate<ListenerEntryBuilder> predicate) {
      for (ListenerEntryBuilder item : listeners) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasParentRef() {
    return this.parentRef != null;
  }
  
  public int hashCode() {
    return Objects.hash(listeners, parentRef, additionalProperties);
  }
  
  public A removeAllFromListeners(Collection<ListenerEntry> items) {
    if (this.listeners == null) {
      return (A) this;
    }
    for (ListenerEntry item : items) {
        ListenerEntryBuilder builder = new ListenerEntryBuilder(item);
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
  
  public A removeFromListeners(ListenerEntry... items) {
    if (this.listeners == null) {
      return (A) this;
    }
    for (ListenerEntry item : items) {
        ListenerEntryBuilder builder = new ListenerEntryBuilder(item);
        _visitables.get("listeners").remove(builder);
        this.listeners.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromListeners(Predicate<ListenerEntryBuilder> predicate) {
    if (listeners == null) {
      return (A) this;
    }
    Iterator<ListenerEntryBuilder> each = listeners.iterator();
    List visitables = _visitables.get("listeners");
    while (each.hasNext()) {
        ListenerEntryBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ListenersNested<A> setNewListenerLike(int index,ListenerEntry item) {
    return new ListenersNested(index, item);
  }
  
  public A setToListeners(int index,ListenerEntry item) {
    if (this.listeners == null) {
      this.listeners = new ArrayList();
    }
    ListenerEntryBuilder builder = new ListenerEntryBuilder(item);
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
    if (!(listeners == null) && !(listeners.isEmpty())) {
        sb.append("listeners:");
        sb.append(listeners);
        sb.append(",");
    }
    if (!(parentRef == null)) {
        sb.append("parentRef:");
        sb.append(parentRef);
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
  
  public A withListeners(List<ListenerEntry> listeners) {
    if (this.listeners != null) {
      this._visitables.get("listeners").clear();
    }
    if (listeners != null) {
        this.listeners = new ArrayList();
        for (ListenerEntry item : listeners) {
          this.addToListeners(item);
        }
    } else {
      this.listeners = null;
    }
    return (A) this;
  }
  
  public A withListeners(ListenerEntry... listeners) {
    if (this.listeners != null) {
        this.listeners.clear();
        _visitables.remove("listeners");
    }
    if (listeners != null) {
      for (ListenerEntry item : listeners) {
        this.addToListeners(item);
      }
    }
    return (A) this;
  }
  
  public ParentRefNested<A> withNewParentRef() {
    return new ParentRefNested(null);
  }
  
  public A withNewParentRef(String group,String kind,String name,String namespace) {
    return (A) this.withParentRef(new ParentGatewayReference(group, kind, name, namespace));
  }
  
  public ParentRefNested<A> withNewParentRefLike(ParentGatewayReference item) {
    return new ParentRefNested(item);
  }
  
  public A withParentRef(ParentGatewayReference parentRef) {
    this._visitables.remove("parentRef");
    if (parentRef != null) {
        this.parentRef = new ParentGatewayReferenceBuilder(parentRef);
        this._visitables.get("parentRef").add(this.parentRef);
    } else {
        this.parentRef = null;
        this._visitables.get("parentRef").remove(this.parentRef);
    }
    return (A) this;
  }
  public class ListenersNested<N> extends ListenerEntryFluent<ListenersNested<N>> implements Nested<N>{
  
    ListenerEntryBuilder builder;
    int index;
  
    ListenersNested(int index,ListenerEntry item) {
      this.index = index;
      this.builder = new ListenerEntryBuilder(this, item);
    }
  
    public N and() {
      return (N) ListenerSetSpecFluent.this.setToListeners(index, builder.build());
    }
    
    public N endListener() {
      return and();
    }
    
  }
  public class ParentRefNested<N> extends ParentGatewayReferenceFluent<ParentRefNested<N>> implements Nested<N>{
  
    ParentGatewayReferenceBuilder builder;
  
    ParentRefNested(ParentGatewayReference item) {
      this.builder = new ParentGatewayReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ListenerSetSpecFluent.this.withParentRef(builder.build());
    }
    
    public N endParentRef() {
      return and();
    }
    
  }
}