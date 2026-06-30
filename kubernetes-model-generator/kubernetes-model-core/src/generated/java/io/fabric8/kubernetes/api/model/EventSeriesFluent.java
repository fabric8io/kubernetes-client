package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class EventSeriesFluent<A extends io.fabric8.kubernetes.api.model.EventSeriesFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer count;
  private MicroTimeBuilder lastObservedTime;

  public EventSeriesFluent() {
  }
  
  public EventSeriesFluent(EventSeries instance) {
    this.copyInstance(instance);
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
  
  public MicroTime buildLastObservedTime() {
    return this.lastObservedTime != null ? this.lastObservedTime.build() : null;
  }
  
  protected void copyInstance(EventSeries instance) {
    instance = instance != null ? instance : new EventSeries();
    if (instance != null) {
        this.withCount(instance.getCount());
        this.withLastObservedTime(instance.getLastObservedTime());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public LastObservedTimeNested<A> editLastObservedTime() {
    return this.withNewLastObservedTimeLike(Optional.ofNullable(this.buildLastObservedTime()).orElse(null));
  }
  
  public LastObservedTimeNested<A> editOrNewLastObservedTime() {
    return this.withNewLastObservedTimeLike(Optional.ofNullable(this.buildLastObservedTime()).orElse(new MicroTimeBuilder().build()));
  }
  
  public LastObservedTimeNested<A> editOrNewLastObservedTimeLike(MicroTime item) {
    return this.withNewLastObservedTimeLike(Optional.ofNullable(this.buildLastObservedTime()).orElse(item));
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
    EventSeriesFluent that = (EventSeriesFluent) o;
    if (!(Objects.equals(count, that.count))) {
      return false;
    }
    if (!(Objects.equals(lastObservedTime, that.lastObservedTime))) {
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
  
  public Integer getCount() {
    return this.count;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCount() {
    return this.count != null;
  }
  
  public boolean hasLastObservedTime() {
    return this.lastObservedTime != null;
  }
  
  public int hashCode() {
    return Objects.hash(count, lastObservedTime, additionalProperties);
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
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(count == null)) {
        sb.append("count:");
        sb.append(count);
        sb.append(",");
    }
    if (!(lastObservedTime == null)) {
        sb.append("lastObservedTime:");
        sb.append(lastObservedTime);
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
  
  public A withCount(Integer count) {
    this.count = count;
    return (A) this;
  }
  
  public A withLastObservedTime(MicroTime lastObservedTime) {
    this._visitables.remove("lastObservedTime");
    if (lastObservedTime != null) {
        this.lastObservedTime = new MicroTimeBuilder(lastObservedTime);
        this._visitables.get("lastObservedTime").add(this.lastObservedTime);
    } else {
        this.lastObservedTime = null;
        this._visitables.get("lastObservedTime").remove(this.lastObservedTime);
    }
    return (A) this;
  }
  
  public LastObservedTimeNested<A> withNewLastObservedTime() {
    return new LastObservedTimeNested(null);
  }
  
  public A withNewLastObservedTime(String time) {
    return (A) this.withLastObservedTime(new MicroTime(time));
  }
  
  public LastObservedTimeNested<A> withNewLastObservedTimeLike(MicroTime item) {
    return new LastObservedTimeNested(item);
  }
  public class LastObservedTimeNested<N> extends MicroTimeFluent<LastObservedTimeNested<N>> implements Nested<N>{
  
    MicroTimeBuilder builder;
  
    LastObservedTimeNested(MicroTime item) {
      this.builder = new MicroTimeBuilder(this, item);
    }
  
    public N and() {
      return (N) EventSeriesFluent.this.withLastObservedTime(builder.build());
    }
    
    public N endLastObservedTime() {
      return and();
    }
    
  }
}