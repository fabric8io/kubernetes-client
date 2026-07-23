package io.fabric8.openclustermanagement.api.model.apps.v1;

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
public class TimeWindowFluent<A extends io.fabric8.openclustermanagement.api.model.apps.v1.TimeWindowFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> daysofweek = new ArrayList<String>();
  private ArrayList<HourRangeBuilder> hours = new ArrayList<HourRangeBuilder>();
  private String location;
  private String windowtype;

  public TimeWindowFluent() {
  }
  
  public TimeWindowFluent(TimeWindow instance) {
    this.copyInstance(instance);
  }

  public A addAllToDaysofweek(Collection<String> items) {
    if (this.daysofweek == null) {
      this.daysofweek = new ArrayList();
    }
    for (String item : items) {
      this.daysofweek.add(item);
    }
    return (A) this;
  }
  
  public A addAllToHours(Collection<HourRange> items) {
    if (this.hours == null) {
      this.hours = new ArrayList();
    }
    for (HourRange item : items) {
        HourRangeBuilder builder = new HourRangeBuilder(item);
        _visitables.get("hours").add(builder);
        this.hours.add(builder);
    }
    return (A) this;
  }
  
  public HoursNested<A> addNewHour() {
    return new HoursNested(-1, null);
  }
  
  public A addNewHour(String end,String start) {
    return (A) this.addToHours(new HourRange(end, start));
  }
  
  public HoursNested<A> addNewHourLike(HourRange item) {
    return new HoursNested(-1, item);
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
  
  public A addToDaysofweek(String... items) {
    if (this.daysofweek == null) {
      this.daysofweek = new ArrayList();
    }
    for (String item : items) {
      this.daysofweek.add(item);
    }
    return (A) this;
  }
  
  public A addToDaysofweek(int index,String item) {
    if (this.daysofweek == null) {
      this.daysofweek = new ArrayList();
    }
    this.daysofweek.add(index, item);
    return (A) this;
  }
  
  public A addToHours(HourRange... items) {
    if (this.hours == null) {
      this.hours = new ArrayList();
    }
    for (HourRange item : items) {
        HourRangeBuilder builder = new HourRangeBuilder(item);
        _visitables.get("hours").add(builder);
        this.hours.add(builder);
    }
    return (A) this;
  }
  
  public A addToHours(int index,HourRange item) {
    if (this.hours == null) {
      this.hours = new ArrayList();
    }
    HourRangeBuilder builder = new HourRangeBuilder(item);
    if (index < 0 || index >= hours.size()) {
        _visitables.get("hours").add(builder);
        hours.add(builder);
    } else {
        _visitables.get("hours").add(builder);
        hours.add(index, builder);
    }
    return (A) this;
  }
  
  public HourRange buildFirstHour() {
    return this.hours.get(0).build();
  }
  
  public HourRange buildHour(int index) {
    return this.hours.get(index).build();
  }
  
  public List<HourRange> buildHours() {
    return this.hours != null ? build(hours) : null;
  }
  
  public HourRange buildLastHour() {
    return this.hours.get(hours.size() - 1).build();
  }
  
  public HourRange buildMatchingHour(Predicate<HourRangeBuilder> predicate) {
      for (HourRangeBuilder item : hours) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(TimeWindow instance) {
    instance = instance != null ? instance : new TimeWindow();
    if (instance != null) {
        this.withDaysofweek(instance.getDaysofweek());
        this.withHours(instance.getHours());
        this.withLocation(instance.getLocation());
        this.withWindowtype(instance.getWindowtype());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public HoursNested<A> editFirstHour() {
    if (hours.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "hours"));
    }
    return this.setNewHourLike(0, this.buildHour(0));
  }
  
  public HoursNested<A> editHour(int index) {
    if (hours.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "hours"));
    }
    return this.setNewHourLike(index, this.buildHour(index));
  }
  
  public HoursNested<A> editLastHour() {
    int index = hours.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "hours"));
    }
    return this.setNewHourLike(index, this.buildHour(index));
  }
  
  public HoursNested<A> editMatchingHour(Predicate<HourRangeBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < hours.size();i++) {
      if (predicate.test(hours.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "hours"));
    }
    return this.setNewHourLike(index, this.buildHour(index));
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
    TimeWindowFluent that = (TimeWindowFluent) o;
    if (!(Objects.equals(daysofweek, that.daysofweek))) {
      return false;
    }
    if (!(Objects.equals(hours, that.hours))) {
      return false;
    }
    if (!(Objects.equals(location, that.location))) {
      return false;
    }
    if (!(Objects.equals(windowtype, that.windowtype))) {
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
  
  public List<String> getDaysofweek() {
    return this.daysofweek;
  }
  
  public String getDaysofweek(int index) {
    return this.daysofweek.get(index);
  }
  
  public String getFirstDaysofweek() {
    return this.daysofweek.get(0);
  }
  
  public String getLastDaysofweek() {
    return this.daysofweek.get(daysofweek.size() - 1);
  }
  
  public String getLocation() {
    return this.location;
  }
  
  public String getMatchingDaysofweek(Predicate<String> predicate) {
      for (String item : daysofweek) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getWindowtype() {
    return this.windowtype;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDaysofweek() {
    return this.daysofweek != null && !(this.daysofweek.isEmpty());
  }
  
  public boolean hasHours() {
    return this.hours != null && !(this.hours.isEmpty());
  }
  
  public boolean hasLocation() {
    return this.location != null;
  }
  
  public boolean hasMatchingDaysofweek(Predicate<String> predicate) {
      for (String item : daysofweek) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingHour(Predicate<HourRangeBuilder> predicate) {
      for (HourRangeBuilder item : hours) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasWindowtype() {
    return this.windowtype != null;
  }
  
  public int hashCode() {
    return Objects.hash(daysofweek, hours, location, windowtype, additionalProperties);
  }
  
  public A removeAllFromDaysofweek(Collection<String> items) {
    if (this.daysofweek == null) {
      return (A) this;
    }
    for (String item : items) {
      this.daysofweek.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromHours(Collection<HourRange> items) {
    if (this.hours == null) {
      return (A) this;
    }
    for (HourRange item : items) {
        HourRangeBuilder builder = new HourRangeBuilder(item);
        _visitables.get("hours").remove(builder);
        this.hours.remove(builder);
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
  
  public A removeFromDaysofweek(String... items) {
    if (this.daysofweek == null) {
      return (A) this;
    }
    for (String item : items) {
      this.daysofweek.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromHours(HourRange... items) {
    if (this.hours == null) {
      return (A) this;
    }
    for (HourRange item : items) {
        HourRangeBuilder builder = new HourRangeBuilder(item);
        _visitables.get("hours").remove(builder);
        this.hours.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromHours(Predicate<HourRangeBuilder> predicate) {
    if (hours == null) {
      return (A) this;
    }
    Iterator<HourRangeBuilder> each = hours.iterator();
    List visitables = _visitables.get("hours");
    while (each.hasNext()) {
        HourRangeBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public HoursNested<A> setNewHourLike(int index,HourRange item) {
    return new HoursNested(index, item);
  }
  
  public A setToDaysofweek(int index,String item) {
    if (this.daysofweek == null) {
      this.daysofweek = new ArrayList();
    }
    this.daysofweek.set(index, item);
    return (A) this;
  }
  
  public A setToHours(int index,HourRange item) {
    if (this.hours == null) {
      this.hours = new ArrayList();
    }
    HourRangeBuilder builder = new HourRangeBuilder(item);
    if (index < 0 || index >= hours.size()) {
        _visitables.get("hours").add(builder);
        hours.add(builder);
    } else {
        _visitables.get("hours").add(builder);
        hours.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(daysofweek == null) && !(daysofweek.isEmpty())) {
        sb.append("daysofweek:");
        sb.append(daysofweek);
        sb.append(",");
    }
    if (!(hours == null) && !(hours.isEmpty())) {
        sb.append("hours:");
        sb.append(hours);
        sb.append(",");
    }
    if (!(location == null)) {
        sb.append("location:");
        sb.append(location);
        sb.append(",");
    }
    if (!(windowtype == null)) {
        sb.append("windowtype:");
        sb.append(windowtype);
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
  
  public A withDaysofweek(List<String> daysofweek) {
    if (daysofweek != null) {
        this.daysofweek = new ArrayList();
        for (String item : daysofweek) {
          this.addToDaysofweek(item);
        }
    } else {
      this.daysofweek = null;
    }
    return (A) this;
  }
  
  public A withDaysofweek(String... daysofweek) {
    if (this.daysofweek != null) {
        this.daysofweek.clear();
        _visitables.remove("daysofweek");
    }
    if (daysofweek != null) {
      for (String item : daysofweek) {
        this.addToDaysofweek(item);
      }
    }
    return (A) this;
  }
  
  public A withHours(List<HourRange> hours) {
    if (this.hours != null) {
      this._visitables.get("hours").clear();
    }
    if (hours != null) {
        this.hours = new ArrayList();
        for (HourRange item : hours) {
          this.addToHours(item);
        }
    } else {
      this.hours = null;
    }
    return (A) this;
  }
  
  public A withHours(HourRange... hours) {
    if (this.hours != null) {
        this.hours.clear();
        _visitables.remove("hours");
    }
    if (hours != null) {
      for (HourRange item : hours) {
        this.addToHours(item);
      }
    }
    return (A) this;
  }
  
  public A withLocation(String location) {
    this.location = location;
    return (A) this;
  }
  
  public A withWindowtype(String windowtype) {
    this.windowtype = windowtype;
    return (A) this;
  }
  public class HoursNested<N> extends HourRangeFluent<HoursNested<N>> implements Nested<N>{
  
    HourRangeBuilder builder;
    int index;
  
    HoursNested(int index,HourRange item) {
      this.index = index;
      this.builder = new HourRangeBuilder(this, item);
    }
  
    public N and() {
      return (N) TimeWindowFluent.this.setToHours(index, builder.build());
    }
    
    public N endHour() {
      return and();
    }
    
  }
}