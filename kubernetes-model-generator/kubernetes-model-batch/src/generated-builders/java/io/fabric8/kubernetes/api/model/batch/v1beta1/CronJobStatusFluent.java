package io.fabric8.kubernetes.api.model.batch.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.ObjectReferenceFluent;
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
public class CronJobStatusFluent<A extends io.fabric8.kubernetes.api.model.batch.v1beta1.CronJobStatusFluent<A>> extends BaseFluent<A>{

  private ArrayList<ObjectReferenceBuilder> active = new ArrayList<ObjectReferenceBuilder>();
  private Map<String,Object> additionalProperties;
  private String lastScheduleTime;
  private String lastSuccessfulTime;

  public CronJobStatusFluent() {
  }
  
  public CronJobStatusFluent(CronJobStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToActive(Collection<ObjectReference> items) {
    if (this.active == null) {
      this.active = new ArrayList();
    }
    for (ObjectReference item : items) {
        ObjectReferenceBuilder builder = new ObjectReferenceBuilder(item);
        _visitables.get("active").add(builder);
        this.active.add(builder);
    }
    return (A) this;
  }
  
  public ActiveNested<A> addNewActive() {
    return new ActiveNested(-1, null);
  }
  
  public ActiveNested<A> addNewActiveLike(ObjectReference item) {
    return new ActiveNested(-1, item);
  }
  
  public A addToActive(ObjectReference... items) {
    if (this.active == null) {
      this.active = new ArrayList();
    }
    for (ObjectReference item : items) {
        ObjectReferenceBuilder builder = new ObjectReferenceBuilder(item);
        _visitables.get("active").add(builder);
        this.active.add(builder);
    }
    return (A) this;
  }
  
  public A addToActive(int index,ObjectReference item) {
    if (this.active == null) {
      this.active = new ArrayList();
    }
    ObjectReferenceBuilder builder = new ObjectReferenceBuilder(item);
    if (index < 0 || index >= active.size()) {
        _visitables.get("active").add(builder);
        active.add(builder);
    } else {
        _visitables.get("active").add(builder);
        active.add(index, builder);
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
  
  public List<ObjectReference> buildActive() {
    return this.active != null ? build(active) : null;
  }
  
  public ObjectReference buildActive(int index) {
    return this.active.get(index).build();
  }
  
  public ObjectReference buildFirstActive() {
    return this.active.get(0).build();
  }
  
  public ObjectReference buildLastActive() {
    return this.active.get(active.size() - 1).build();
  }
  
  public ObjectReference buildMatchingActive(Predicate<ObjectReferenceBuilder> predicate) {
      for (ObjectReferenceBuilder item : active) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(CronJobStatus instance) {
    instance = instance != null ? instance : new CronJobStatus();
    if (instance != null) {
        this.withActive(instance.getActive());
        this.withLastScheduleTime(instance.getLastScheduleTime());
        this.withLastSuccessfulTime(instance.getLastSuccessfulTime());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ActiveNested<A> editActive(int index) {
    if (active.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "active"));
    }
    return this.setNewActiveLike(index, this.buildActive(index));
  }
  
  public ActiveNested<A> editFirstActive() {
    if (active.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "active"));
    }
    return this.setNewActiveLike(0, this.buildActive(0));
  }
  
  public ActiveNested<A> editLastActive() {
    int index = active.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "active"));
    }
    return this.setNewActiveLike(index, this.buildActive(index));
  }
  
  public ActiveNested<A> editMatchingActive(Predicate<ObjectReferenceBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < active.size();i++) {
      if (predicate.test(active.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "active"));
    }
    return this.setNewActiveLike(index, this.buildActive(index));
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
    CronJobStatusFluent that = (CronJobStatusFluent) o;
    if (!(Objects.equals(active, that.active))) {
      return false;
    }
    if (!(Objects.equals(lastScheduleTime, that.lastScheduleTime))) {
      return false;
    }
    if (!(Objects.equals(lastSuccessfulTime, that.lastSuccessfulTime))) {
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
  
  public String getLastScheduleTime() {
    return this.lastScheduleTime;
  }
  
  public String getLastSuccessfulTime() {
    return this.lastSuccessfulTime;
  }
  
  public boolean hasActive() {
    return this.active != null && !(this.active.isEmpty());
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasLastScheduleTime() {
    return this.lastScheduleTime != null;
  }
  
  public boolean hasLastSuccessfulTime() {
    return this.lastSuccessfulTime != null;
  }
  
  public boolean hasMatchingActive(Predicate<ObjectReferenceBuilder> predicate) {
      for (ObjectReferenceBuilder item : active) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(active, lastScheduleTime, lastSuccessfulTime, additionalProperties);
  }
  
  public A removeAllFromActive(Collection<ObjectReference> items) {
    if (this.active == null) {
      return (A) this;
    }
    for (ObjectReference item : items) {
        ObjectReferenceBuilder builder = new ObjectReferenceBuilder(item);
        _visitables.get("active").remove(builder);
        this.active.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromActive(ObjectReference... items) {
    if (this.active == null) {
      return (A) this;
    }
    for (ObjectReference item : items) {
        ObjectReferenceBuilder builder = new ObjectReferenceBuilder(item);
        _visitables.get("active").remove(builder);
        this.active.remove(builder);
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
  
  public A removeMatchingFromActive(Predicate<ObjectReferenceBuilder> predicate) {
    if (active == null) {
      return (A) this;
    }
    Iterator<ObjectReferenceBuilder> each = active.iterator();
    List visitables = _visitables.get("active");
    while (each.hasNext()) {
        ObjectReferenceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ActiveNested<A> setNewActiveLike(int index,ObjectReference item) {
    return new ActiveNested(index, item);
  }
  
  public A setToActive(int index,ObjectReference item) {
    if (this.active == null) {
      this.active = new ArrayList();
    }
    ObjectReferenceBuilder builder = new ObjectReferenceBuilder(item);
    if (index < 0 || index >= active.size()) {
        _visitables.get("active").add(builder);
        active.add(builder);
    } else {
        _visitables.get("active").add(builder);
        active.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(active == null) && !(active.isEmpty())) {
        sb.append("active:");
        sb.append(active);
        sb.append(",");
    }
    if (!(lastScheduleTime == null)) {
        sb.append("lastScheduleTime:");
        sb.append(lastScheduleTime);
        sb.append(",");
    }
    if (!(lastSuccessfulTime == null)) {
        sb.append("lastSuccessfulTime:");
        sb.append(lastSuccessfulTime);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withActive(List<ObjectReference> active) {
    if (this.active != null) {
      this._visitables.get("active").clear();
    }
    if (active != null) {
        this.active = new ArrayList();
        for (ObjectReference item : active) {
          this.addToActive(item);
        }
    } else {
      this.active = null;
    }
    return (A) this;
  }
  
  public A withActive(ObjectReference... active) {
    if (this.active != null) {
        this.active.clear();
        _visitables.remove("active");
    }
    if (active != null) {
      for (ObjectReference item : active) {
        this.addToActive(item);
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
  
  public A withLastScheduleTime(String lastScheduleTime) {
    this.lastScheduleTime = lastScheduleTime;
    return (A) this;
  }
  
  public A withLastSuccessfulTime(String lastSuccessfulTime) {
    this.lastSuccessfulTime = lastSuccessfulTime;
    return (A) this;
  }
  public class ActiveNested<N> extends ObjectReferenceFluent<ActiveNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
    int index;
  
    ActiveNested(int index,ObjectReference item) {
      this.index = index;
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) CronJobStatusFluent.this.setToActive(index, builder.build());
    }
    
    public N endActive() {
      return and();
    }
    
  }
}