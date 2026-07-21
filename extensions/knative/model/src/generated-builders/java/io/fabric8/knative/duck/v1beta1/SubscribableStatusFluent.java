package io.fabric8.knative.duck.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Long;
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
public class SubscribableStatusFluent<A extends io.fabric8.knative.duck.v1beta1.SubscribableStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<SubscriberStatusBuilder> subscribers = new ArrayList<SubscriberStatusBuilder>();

  public SubscribableStatusFluent() {
  }
  
  public SubscribableStatusFluent(SubscribableStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToSubscribers(Collection<SubscriberStatus> items) {
    if (this.subscribers == null) {
      this.subscribers = new ArrayList();
    }
    for (SubscriberStatus item : items) {
        SubscriberStatusBuilder builder = new SubscriberStatusBuilder(item);
        _visitables.get("subscribers").add(builder);
        this.subscribers.add(builder);
    }
    return (A) this;
  }
  
  public SubscribersNested<A> addNewSubscriber() {
    return new SubscribersNested(-1, null);
  }
  
  public A addNewSubscriber(String message,Long observedGeneration,String ready,String uid) {
    return (A) this.addToSubscribers(new SubscriberStatus(message, observedGeneration, ready, uid));
  }
  
  public SubscribersNested<A> addNewSubscriberLike(SubscriberStatus item) {
    return new SubscribersNested(-1, item);
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
  
  public A addToSubscribers(SubscriberStatus... items) {
    if (this.subscribers == null) {
      this.subscribers = new ArrayList();
    }
    for (SubscriberStatus item : items) {
        SubscriberStatusBuilder builder = new SubscriberStatusBuilder(item);
        _visitables.get("subscribers").add(builder);
        this.subscribers.add(builder);
    }
    return (A) this;
  }
  
  public A addToSubscribers(int index,SubscriberStatus item) {
    if (this.subscribers == null) {
      this.subscribers = new ArrayList();
    }
    SubscriberStatusBuilder builder = new SubscriberStatusBuilder(item);
    if (index < 0 || index >= subscribers.size()) {
        _visitables.get("subscribers").add(builder);
        subscribers.add(builder);
    } else {
        _visitables.get("subscribers").add(builder);
        subscribers.add(index, builder);
    }
    return (A) this;
  }
  
  public SubscriberStatus buildFirstSubscriber() {
    return this.subscribers.get(0).build();
  }
  
  public SubscriberStatus buildLastSubscriber() {
    return this.subscribers.get(subscribers.size() - 1).build();
  }
  
  public SubscriberStatus buildMatchingSubscriber(Predicate<SubscriberStatusBuilder> predicate) {
      for (SubscriberStatusBuilder item : subscribers) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public SubscriberStatus buildSubscriber(int index) {
    return this.subscribers.get(index).build();
  }
  
  public List<SubscriberStatus> buildSubscribers() {
    return this.subscribers != null ? build(subscribers) : null;
  }
  
  protected void copyInstance(SubscribableStatus instance) {
    instance = instance != null ? instance : new SubscribableStatus();
    if (instance != null) {
        this.withSubscribers(instance.getSubscribers());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SubscribersNested<A> editFirstSubscriber() {
    if (subscribers.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "subscribers"));
    }
    return this.setNewSubscriberLike(0, this.buildSubscriber(0));
  }
  
  public SubscribersNested<A> editLastSubscriber() {
    int index = subscribers.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "subscribers"));
    }
    return this.setNewSubscriberLike(index, this.buildSubscriber(index));
  }
  
  public SubscribersNested<A> editMatchingSubscriber(Predicate<SubscriberStatusBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < subscribers.size();i++) {
      if (predicate.test(subscribers.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "subscribers"));
    }
    return this.setNewSubscriberLike(index, this.buildSubscriber(index));
  }
  
  public SubscribersNested<A> editSubscriber(int index) {
    if (subscribers.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "subscribers"));
    }
    return this.setNewSubscriberLike(index, this.buildSubscriber(index));
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
    SubscribableStatusFluent that = (SubscribableStatusFluent) o;
    if (!(Objects.equals(subscribers, that.subscribers))) {
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
  
  public boolean hasMatchingSubscriber(Predicate<SubscriberStatusBuilder> predicate) {
      for (SubscriberStatusBuilder item : subscribers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasSubscribers() {
    return this.subscribers != null && !(this.subscribers.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(subscribers, additionalProperties);
  }
  
  public A removeAllFromSubscribers(Collection<SubscriberStatus> items) {
    if (this.subscribers == null) {
      return (A) this;
    }
    for (SubscriberStatus item : items) {
        SubscriberStatusBuilder builder = new SubscriberStatusBuilder(item);
        _visitables.get("subscribers").remove(builder);
        this.subscribers.remove(builder);
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
  
  public A removeFromSubscribers(SubscriberStatus... items) {
    if (this.subscribers == null) {
      return (A) this;
    }
    for (SubscriberStatus item : items) {
        SubscriberStatusBuilder builder = new SubscriberStatusBuilder(item);
        _visitables.get("subscribers").remove(builder);
        this.subscribers.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromSubscribers(Predicate<SubscriberStatusBuilder> predicate) {
    if (subscribers == null) {
      return (A) this;
    }
    Iterator<SubscriberStatusBuilder> each = subscribers.iterator();
    List visitables = _visitables.get("subscribers");
    while (each.hasNext()) {
        SubscriberStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public SubscribersNested<A> setNewSubscriberLike(int index,SubscriberStatus item) {
    return new SubscribersNested(index, item);
  }
  
  public A setToSubscribers(int index,SubscriberStatus item) {
    if (this.subscribers == null) {
      this.subscribers = new ArrayList();
    }
    SubscriberStatusBuilder builder = new SubscriberStatusBuilder(item);
    if (index < 0 || index >= subscribers.size()) {
        _visitables.get("subscribers").add(builder);
        subscribers.add(builder);
    } else {
        _visitables.get("subscribers").add(builder);
        subscribers.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(subscribers == null) && !(subscribers.isEmpty())) {
        sb.append("subscribers:");
        sb.append(subscribers);
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
  
  public A withSubscribers(List<SubscriberStatus> subscribers) {
    if (this.subscribers != null) {
      this._visitables.get("subscribers").clear();
    }
    if (subscribers != null) {
        this.subscribers = new ArrayList();
        for (SubscriberStatus item : subscribers) {
          this.addToSubscribers(item);
        }
    } else {
      this.subscribers = null;
    }
    return (A) this;
  }
  
  public A withSubscribers(SubscriberStatus... subscribers) {
    if (this.subscribers != null) {
        this.subscribers.clear();
        _visitables.remove("subscribers");
    }
    if (subscribers != null) {
      for (SubscriberStatus item : subscribers) {
        this.addToSubscribers(item);
      }
    }
    return (A) this;
  }
  public class SubscribersNested<N> extends SubscriberStatusFluent<SubscribersNested<N>> implements Nested<N>{
  
    SubscriberStatusBuilder builder;
    int index;
  
    SubscribersNested(int index,SubscriberStatus item) {
      this.index = index;
      this.builder = new SubscriberStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) SubscribableStatusFluent.this.setToSubscribers(index, builder.build());
    }
    
    public N endSubscriber() {
      return and();
    }
    
  }
}