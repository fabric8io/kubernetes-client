package io.fabric8.openshift.api.model.monitoring.v1beta1;

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
public class TimeIntervalFluent<A extends io.fabric8.openshift.api.model.monitoring.v1beta1.TimeIntervalFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String name;
  private ArrayList<TimePeriodBuilder> timeIntervals = new ArrayList<TimePeriodBuilder>();

  public TimeIntervalFluent() {
  }
  
  public TimeIntervalFluent(TimeInterval instance) {
    this.copyInstance(instance);
  }

  public A addAllToTimeIntervals(Collection<TimePeriod> items) {
    if (this.timeIntervals == null) {
      this.timeIntervals = new ArrayList();
    }
    for (TimePeriod item : items) {
        TimePeriodBuilder builder = new TimePeriodBuilder(item);
        _visitables.get("timeIntervals").add(builder);
        this.timeIntervals.add(builder);
    }
    return (A) this;
  }
  
  public TimeIntervalsNested<A> addNewTimeInterval() {
    return new TimeIntervalsNested(-1, null);
  }
  
  public TimeIntervalsNested<A> addNewTimeIntervalLike(TimePeriod item) {
    return new TimeIntervalsNested(-1, item);
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
  
  public A addToTimeIntervals(TimePeriod... items) {
    if (this.timeIntervals == null) {
      this.timeIntervals = new ArrayList();
    }
    for (TimePeriod item : items) {
        TimePeriodBuilder builder = new TimePeriodBuilder(item);
        _visitables.get("timeIntervals").add(builder);
        this.timeIntervals.add(builder);
    }
    return (A) this;
  }
  
  public A addToTimeIntervals(int index,TimePeriod item) {
    if (this.timeIntervals == null) {
      this.timeIntervals = new ArrayList();
    }
    TimePeriodBuilder builder = new TimePeriodBuilder(item);
    if (index < 0 || index >= timeIntervals.size()) {
        _visitables.get("timeIntervals").add(builder);
        timeIntervals.add(builder);
    } else {
        _visitables.get("timeIntervals").add(builder);
        timeIntervals.add(index, builder);
    }
    return (A) this;
  }
  
  public TimePeriod buildFirstTimeInterval() {
    return this.timeIntervals.get(0).build();
  }
  
  public TimePeriod buildLastTimeInterval() {
    return this.timeIntervals.get(timeIntervals.size() - 1).build();
  }
  
  public TimePeriod buildMatchingTimeInterval(Predicate<TimePeriodBuilder> predicate) {
      for (TimePeriodBuilder item : timeIntervals) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public TimePeriod buildTimeInterval(int index) {
    return this.timeIntervals.get(index).build();
  }
  
  public List<TimePeriod> buildTimeIntervals() {
    return this.timeIntervals != null ? build(timeIntervals) : null;
  }
  
  protected void copyInstance(TimeInterval instance) {
    instance = instance != null ? instance : new TimeInterval();
    if (instance != null) {
        this.withName(instance.getName());
        this.withTimeIntervals(instance.getTimeIntervals());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public TimeIntervalsNested<A> editFirstTimeInterval() {
    if (timeIntervals.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "timeIntervals"));
    }
    return this.setNewTimeIntervalLike(0, this.buildTimeInterval(0));
  }
  
  public TimeIntervalsNested<A> editLastTimeInterval() {
    int index = timeIntervals.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "timeIntervals"));
    }
    return this.setNewTimeIntervalLike(index, this.buildTimeInterval(index));
  }
  
  public TimeIntervalsNested<A> editMatchingTimeInterval(Predicate<TimePeriodBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < timeIntervals.size();i++) {
      if (predicate.test(timeIntervals.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "timeIntervals"));
    }
    return this.setNewTimeIntervalLike(index, this.buildTimeInterval(index));
  }
  
  public TimeIntervalsNested<A> editTimeInterval(int index) {
    if (timeIntervals.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "timeIntervals"));
    }
    return this.setNewTimeIntervalLike(index, this.buildTimeInterval(index));
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
    TimeIntervalFluent that = (TimeIntervalFluent) o;
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(timeIntervals, that.timeIntervals))) {
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
  
  public String getName() {
    return this.name;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingTimeInterval(Predicate<TimePeriodBuilder> predicate) {
      for (TimePeriodBuilder item : timeIntervals) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasTimeIntervals() {
    return this.timeIntervals != null && !(this.timeIntervals.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(name, timeIntervals, additionalProperties);
  }
  
  public A removeAllFromTimeIntervals(Collection<TimePeriod> items) {
    if (this.timeIntervals == null) {
      return (A) this;
    }
    for (TimePeriod item : items) {
        TimePeriodBuilder builder = new TimePeriodBuilder(item);
        _visitables.get("timeIntervals").remove(builder);
        this.timeIntervals.remove(builder);
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
  
  public A removeFromTimeIntervals(TimePeriod... items) {
    if (this.timeIntervals == null) {
      return (A) this;
    }
    for (TimePeriod item : items) {
        TimePeriodBuilder builder = new TimePeriodBuilder(item);
        _visitables.get("timeIntervals").remove(builder);
        this.timeIntervals.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromTimeIntervals(Predicate<TimePeriodBuilder> predicate) {
    if (timeIntervals == null) {
      return (A) this;
    }
    Iterator<TimePeriodBuilder> each = timeIntervals.iterator();
    List visitables = _visitables.get("timeIntervals");
    while (each.hasNext()) {
        TimePeriodBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public TimeIntervalsNested<A> setNewTimeIntervalLike(int index,TimePeriod item) {
    return new TimeIntervalsNested(index, item);
  }
  
  public A setToTimeIntervals(int index,TimePeriod item) {
    if (this.timeIntervals == null) {
      this.timeIntervals = new ArrayList();
    }
    TimePeriodBuilder builder = new TimePeriodBuilder(item);
    if (index < 0 || index >= timeIntervals.size()) {
        _visitables.get("timeIntervals").add(builder);
        timeIntervals.add(builder);
    } else {
        _visitables.get("timeIntervals").add(builder);
        timeIntervals.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(timeIntervals == null) && !(timeIntervals.isEmpty())) {
        sb.append("timeIntervals:");
        sb.append(timeIntervals);
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
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withTimeIntervals(List<TimePeriod> timeIntervals) {
    if (this.timeIntervals != null) {
      this._visitables.get("timeIntervals").clear();
    }
    if (timeIntervals != null) {
        this.timeIntervals = new ArrayList();
        for (TimePeriod item : timeIntervals) {
          this.addToTimeIntervals(item);
        }
    } else {
      this.timeIntervals = null;
    }
    return (A) this;
  }
  
  public A withTimeIntervals(TimePeriod... timeIntervals) {
    if (this.timeIntervals != null) {
        this.timeIntervals.clear();
        _visitables.remove("timeIntervals");
    }
    if (timeIntervals != null) {
      for (TimePeriod item : timeIntervals) {
        this.addToTimeIntervals(item);
      }
    }
    return (A) this;
  }
  public class TimeIntervalsNested<N> extends TimePeriodFluent<TimeIntervalsNested<N>> implements Nested<N>{
  
    TimePeriodBuilder builder;
    int index;
  
    TimeIntervalsNested(int index,TimePeriod item) {
      this.index = index;
      this.builder = new TimePeriodBuilder(this, item);
    }
  
    public N and() {
      return (N) TimeIntervalFluent.this.setToTimeIntervals(index, builder.build());
    }
    
    public N endTimeInterval() {
      return and();
    }
    
  }
}