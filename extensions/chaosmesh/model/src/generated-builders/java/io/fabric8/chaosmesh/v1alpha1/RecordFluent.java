package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class RecordFluent<A extends io.fabric8.chaosmesh.v1alpha1.RecordFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<RecordEventBuilder> events = new ArrayList<RecordEventBuilder>();
  private String id;
  private Integer injectedCount;
  private String phase;
  private Integer recoveredCount;
  private String selectorKey;

  public RecordFluent() {
  }
  
  public RecordFluent(Record instance) {
    this.copyInstance(instance);
  }

  public A addAllToEvents(Collection<RecordEvent> items) {
    if (this.events == null) {
      this.events = new ArrayList();
    }
    for (RecordEvent item : items) {
        RecordEventBuilder builder = new RecordEventBuilder(item);
        _visitables.get("events").add(builder);
        this.events.add(builder);
    }
    return (A) this;
  }
  
  public EventsNested<A> addNewEvent() {
    return new EventsNested(-1, null);
  }
  
  public A addNewEvent(String message,String operation,String timestamp,String type) {
    return (A) this.addToEvents(new RecordEvent(message, operation, timestamp, type));
  }
  
  public EventsNested<A> addNewEventLike(RecordEvent item) {
    return new EventsNested(-1, item);
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
  
  public A addToEvents(RecordEvent... items) {
    if (this.events == null) {
      this.events = new ArrayList();
    }
    for (RecordEvent item : items) {
        RecordEventBuilder builder = new RecordEventBuilder(item);
        _visitables.get("events").add(builder);
        this.events.add(builder);
    }
    return (A) this;
  }
  
  public A addToEvents(int index,RecordEvent item) {
    if (this.events == null) {
      this.events = new ArrayList();
    }
    RecordEventBuilder builder = new RecordEventBuilder(item);
    if (index < 0 || index >= events.size()) {
        _visitables.get("events").add(builder);
        events.add(builder);
    } else {
        _visitables.get("events").add(builder);
        events.add(index, builder);
    }
    return (A) this;
  }
  
  public RecordEvent buildEvent(int index) {
    return this.events.get(index).build();
  }
  
  public List<RecordEvent> buildEvents() {
    return this.events != null ? build(events) : null;
  }
  
  public RecordEvent buildFirstEvent() {
    return this.events.get(0).build();
  }
  
  public RecordEvent buildLastEvent() {
    return this.events.get(events.size() - 1).build();
  }
  
  public RecordEvent buildMatchingEvent(Predicate<RecordEventBuilder> predicate) {
      for (RecordEventBuilder item : events) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(Record instance) {
    instance = instance != null ? instance : new Record();
    if (instance != null) {
        this.withEvents(instance.getEvents());
        this.withId(instance.getId());
        this.withInjectedCount(instance.getInjectedCount());
        this.withPhase(instance.getPhase());
        this.withRecoveredCount(instance.getRecoveredCount());
        this.withSelectorKey(instance.getSelectorKey());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public EventsNested<A> editEvent(int index) {
    if (events.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "events"));
    }
    return this.setNewEventLike(index, this.buildEvent(index));
  }
  
  public EventsNested<A> editFirstEvent() {
    if (events.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "events"));
    }
    return this.setNewEventLike(0, this.buildEvent(0));
  }
  
  public EventsNested<A> editLastEvent() {
    int index = events.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "events"));
    }
    return this.setNewEventLike(index, this.buildEvent(index));
  }
  
  public EventsNested<A> editMatchingEvent(Predicate<RecordEventBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < events.size();i++) {
      if (predicate.test(events.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "events"));
    }
    return this.setNewEventLike(index, this.buildEvent(index));
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
    RecordFluent that = (RecordFluent) o;
    if (!(Objects.equals(events, that.events))) {
      return false;
    }
    if (!(Objects.equals(id, that.id))) {
      return false;
    }
    if (!(Objects.equals(injectedCount, that.injectedCount))) {
      return false;
    }
    if (!(Objects.equals(phase, that.phase))) {
      return false;
    }
    if (!(Objects.equals(recoveredCount, that.recoveredCount))) {
      return false;
    }
    if (!(Objects.equals(selectorKey, that.selectorKey))) {
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
  
  public String getId() {
    return this.id;
  }
  
  public Integer getInjectedCount() {
    return this.injectedCount;
  }
  
  public String getPhase() {
    return this.phase;
  }
  
  public Integer getRecoveredCount() {
    return this.recoveredCount;
  }
  
  public String getSelectorKey() {
    return this.selectorKey;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasEvents() {
    return this.events != null && !(this.events.isEmpty());
  }
  
  public boolean hasId() {
    return this.id != null;
  }
  
  public boolean hasInjectedCount() {
    return this.injectedCount != null;
  }
  
  public boolean hasMatchingEvent(Predicate<RecordEventBuilder> predicate) {
      for (RecordEventBuilder item : events) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPhase() {
    return this.phase != null;
  }
  
  public boolean hasRecoveredCount() {
    return this.recoveredCount != null;
  }
  
  public boolean hasSelectorKey() {
    return this.selectorKey != null;
  }
  
  public int hashCode() {
    return Objects.hash(events, id, injectedCount, phase, recoveredCount, selectorKey, additionalProperties);
  }
  
  public A removeAllFromEvents(Collection<RecordEvent> items) {
    if (this.events == null) {
      return (A) this;
    }
    for (RecordEvent item : items) {
        RecordEventBuilder builder = new RecordEventBuilder(item);
        _visitables.get("events").remove(builder);
        this.events.remove(builder);
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
  
  public A removeFromEvents(RecordEvent... items) {
    if (this.events == null) {
      return (A) this;
    }
    for (RecordEvent item : items) {
        RecordEventBuilder builder = new RecordEventBuilder(item);
        _visitables.get("events").remove(builder);
        this.events.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromEvents(Predicate<RecordEventBuilder> predicate) {
    if (events == null) {
      return (A) this;
    }
    Iterator<RecordEventBuilder> each = events.iterator();
    List visitables = _visitables.get("events");
    while (each.hasNext()) {
        RecordEventBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public EventsNested<A> setNewEventLike(int index,RecordEvent item) {
    return new EventsNested(index, item);
  }
  
  public A setToEvents(int index,RecordEvent item) {
    if (this.events == null) {
      this.events = new ArrayList();
    }
    RecordEventBuilder builder = new RecordEventBuilder(item);
    if (index < 0 || index >= events.size()) {
        _visitables.get("events").add(builder);
        events.add(builder);
    } else {
        _visitables.get("events").add(builder);
        events.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(events == null) && !(events.isEmpty())) {
        sb.append("events:");
        sb.append(events);
        sb.append(",");
    }
    if (!(id == null)) {
        sb.append("id:");
        sb.append(id);
        sb.append(",");
    }
    if (!(injectedCount == null)) {
        sb.append("injectedCount:");
        sb.append(injectedCount);
        sb.append(",");
    }
    if (!(phase == null)) {
        sb.append("phase:");
        sb.append(phase);
        sb.append(",");
    }
    if (!(recoveredCount == null)) {
        sb.append("recoveredCount:");
        sb.append(recoveredCount);
        sb.append(",");
    }
    if (!(selectorKey == null)) {
        sb.append("selectorKey:");
        sb.append(selectorKey);
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
  
  public A withEvents(List<RecordEvent> events) {
    if (this.events != null) {
      this._visitables.get("events").clear();
    }
    if (events != null) {
        this.events = new ArrayList();
        for (RecordEvent item : events) {
          this.addToEvents(item);
        }
    } else {
      this.events = null;
    }
    return (A) this;
  }
  
  public A withEvents(RecordEvent... events) {
    if (this.events != null) {
        this.events.clear();
        _visitables.remove("events");
    }
    if (events != null) {
      for (RecordEvent item : events) {
        this.addToEvents(item);
      }
    }
    return (A) this;
  }
  
  public A withId(String id) {
    this.id = id;
    return (A) this;
  }
  
  public A withInjectedCount(Integer injectedCount) {
    this.injectedCount = injectedCount;
    return (A) this;
  }
  
  public A withPhase(String phase) {
    this.phase = phase;
    return (A) this;
  }
  
  public A withRecoveredCount(Integer recoveredCount) {
    this.recoveredCount = recoveredCount;
    return (A) this;
  }
  
  public A withSelectorKey(String selectorKey) {
    this.selectorKey = selectorKey;
    return (A) this;
  }
  public class EventsNested<N> extends RecordEventFluent<EventsNested<N>> implements Nested<N>{
  
    RecordEventBuilder builder;
    int index;
  
    EventsNested(int index,RecordEvent item) {
      this.index = index;
      this.builder = new RecordEventBuilder(this, item);
    }
  
    public N and() {
      return (N) RecordFluent.this.setToEvents(index, builder.build());
    }
    
    public N endEvent() {
      return and();
    }
    
  }
}