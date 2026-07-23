package io.fabric8.openshift.api.model.monitoring.v1alpha1;

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
public class TimeIntervalFluent<A extends io.fabric8.openshift.api.model.monitoring.v1alpha1.TimeIntervalFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<DayOfMonthRangeBuilder> daysOfMonth = new ArrayList<DayOfMonthRangeBuilder>();
  private List<String> months = new ArrayList<String>();
  private ArrayList<TimeRangeBuilder> times = new ArrayList<TimeRangeBuilder>();
  private List<String> weekdays = new ArrayList<String>();
  private List<String> years = new ArrayList<String>();

  public TimeIntervalFluent() {
  }
  
  public TimeIntervalFluent(TimeInterval instance) {
    this.copyInstance(instance);
  }

  public A addAllToDaysOfMonth(Collection<DayOfMonthRange> items) {
    if (this.daysOfMonth == null) {
      this.daysOfMonth = new ArrayList();
    }
    for (DayOfMonthRange item : items) {
        DayOfMonthRangeBuilder builder = new DayOfMonthRangeBuilder(item);
        _visitables.get("daysOfMonth").add(builder);
        this.daysOfMonth.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToMonths(Collection<String> items) {
    if (this.months == null) {
      this.months = new ArrayList();
    }
    for (String item : items) {
      this.months.add(item);
    }
    return (A) this;
  }
  
  public A addAllToTimes(Collection<TimeRange> items) {
    if (this.times == null) {
      this.times = new ArrayList();
    }
    for (TimeRange item : items) {
        TimeRangeBuilder builder = new TimeRangeBuilder(item);
        _visitables.get("times").add(builder);
        this.times.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToWeekdays(Collection<String> items) {
    if (this.weekdays == null) {
      this.weekdays = new ArrayList();
    }
    for (String item : items) {
      this.weekdays.add(item);
    }
    return (A) this;
  }
  
  public A addAllToYears(Collection<String> items) {
    if (this.years == null) {
      this.years = new ArrayList();
    }
    for (String item : items) {
      this.years.add(item);
    }
    return (A) this;
  }
  
  public DaysOfMonthNested<A> addNewDaysOfMonth() {
    return new DaysOfMonthNested(-1, null);
  }
  
  public A addNewDaysOfMonth(Integer end,Integer start) {
    return (A) this.addToDaysOfMonth(new DayOfMonthRange(end, start));
  }
  
  public DaysOfMonthNested<A> addNewDaysOfMonthLike(DayOfMonthRange item) {
    return new DaysOfMonthNested(-1, item);
  }
  
  public TimesNested<A> addNewTime() {
    return new TimesNested(-1, null);
  }
  
  public A addNewTime(String endTime,String startTime) {
    return (A) this.addToTimes(new TimeRange(endTime, startTime));
  }
  
  public TimesNested<A> addNewTimeLike(TimeRange item) {
    return new TimesNested(-1, item);
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
  
  public A addToDaysOfMonth(DayOfMonthRange... items) {
    if (this.daysOfMonth == null) {
      this.daysOfMonth = new ArrayList();
    }
    for (DayOfMonthRange item : items) {
        DayOfMonthRangeBuilder builder = new DayOfMonthRangeBuilder(item);
        _visitables.get("daysOfMonth").add(builder);
        this.daysOfMonth.add(builder);
    }
    return (A) this;
  }
  
  public A addToDaysOfMonth(int index,DayOfMonthRange item) {
    if (this.daysOfMonth == null) {
      this.daysOfMonth = new ArrayList();
    }
    DayOfMonthRangeBuilder builder = new DayOfMonthRangeBuilder(item);
    if (index < 0 || index >= daysOfMonth.size()) {
        _visitables.get("daysOfMonth").add(builder);
        daysOfMonth.add(builder);
    } else {
        _visitables.get("daysOfMonth").add(builder);
        daysOfMonth.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToMonths(String... items) {
    if (this.months == null) {
      this.months = new ArrayList();
    }
    for (String item : items) {
      this.months.add(item);
    }
    return (A) this;
  }
  
  public A addToMonths(int index,String item) {
    if (this.months == null) {
      this.months = new ArrayList();
    }
    this.months.add(index, item);
    return (A) this;
  }
  
  public A addToTimes(TimeRange... items) {
    if (this.times == null) {
      this.times = new ArrayList();
    }
    for (TimeRange item : items) {
        TimeRangeBuilder builder = new TimeRangeBuilder(item);
        _visitables.get("times").add(builder);
        this.times.add(builder);
    }
    return (A) this;
  }
  
  public A addToTimes(int index,TimeRange item) {
    if (this.times == null) {
      this.times = new ArrayList();
    }
    TimeRangeBuilder builder = new TimeRangeBuilder(item);
    if (index < 0 || index >= times.size()) {
        _visitables.get("times").add(builder);
        times.add(builder);
    } else {
        _visitables.get("times").add(builder);
        times.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToWeekdays(String... items) {
    if (this.weekdays == null) {
      this.weekdays = new ArrayList();
    }
    for (String item : items) {
      this.weekdays.add(item);
    }
    return (A) this;
  }
  
  public A addToWeekdays(int index,String item) {
    if (this.weekdays == null) {
      this.weekdays = new ArrayList();
    }
    this.weekdays.add(index, item);
    return (A) this;
  }
  
  public A addToYears(String... items) {
    if (this.years == null) {
      this.years = new ArrayList();
    }
    for (String item : items) {
      this.years.add(item);
    }
    return (A) this;
  }
  
  public A addToYears(int index,String item) {
    if (this.years == null) {
      this.years = new ArrayList();
    }
    this.years.add(index, item);
    return (A) this;
  }
  
  public List<DayOfMonthRange> buildDaysOfMonth() {
    return this.daysOfMonth != null ? build(daysOfMonth) : null;
  }
  
  public DayOfMonthRange buildDaysOfMonth(int index) {
    return this.daysOfMonth.get(index).build();
  }
  
  public DayOfMonthRange buildFirstDaysOfMonth() {
    return this.daysOfMonth.get(0).build();
  }
  
  public TimeRange buildFirstTime() {
    return this.times.get(0).build();
  }
  
  public DayOfMonthRange buildLastDaysOfMonth() {
    return this.daysOfMonth.get(daysOfMonth.size() - 1).build();
  }
  
  public TimeRange buildLastTime() {
    return this.times.get(times.size() - 1).build();
  }
  
  public DayOfMonthRange buildMatchingDaysOfMonth(Predicate<DayOfMonthRangeBuilder> predicate) {
      for (DayOfMonthRangeBuilder item : daysOfMonth) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public TimeRange buildMatchingTime(Predicate<TimeRangeBuilder> predicate) {
      for (TimeRangeBuilder item : times) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public TimeRange buildTime(int index) {
    return this.times.get(index).build();
  }
  
  public List<TimeRange> buildTimes() {
    return this.times != null ? build(times) : null;
  }
  
  protected void copyInstance(TimeInterval instance) {
    instance = instance != null ? instance : new TimeInterval();
    if (instance != null) {
        this.withDaysOfMonth(instance.getDaysOfMonth());
        this.withMonths(instance.getMonths());
        this.withTimes(instance.getTimes());
        this.withWeekdays(instance.getWeekdays());
        this.withYears(instance.getYears());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DaysOfMonthNested<A> editDaysOfMonth(int index) {
    if (daysOfMonth.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "daysOfMonth"));
    }
    return this.setNewDaysOfMonthLike(index, this.buildDaysOfMonth(index));
  }
  
  public DaysOfMonthNested<A> editFirstDaysOfMonth() {
    if (daysOfMonth.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "daysOfMonth"));
    }
    return this.setNewDaysOfMonthLike(0, this.buildDaysOfMonth(0));
  }
  
  public TimesNested<A> editFirstTime() {
    if (times.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "times"));
    }
    return this.setNewTimeLike(0, this.buildTime(0));
  }
  
  public DaysOfMonthNested<A> editLastDaysOfMonth() {
    int index = daysOfMonth.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "daysOfMonth"));
    }
    return this.setNewDaysOfMonthLike(index, this.buildDaysOfMonth(index));
  }
  
  public TimesNested<A> editLastTime() {
    int index = times.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "times"));
    }
    return this.setNewTimeLike(index, this.buildTime(index));
  }
  
  public DaysOfMonthNested<A> editMatchingDaysOfMonth(Predicate<DayOfMonthRangeBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < daysOfMonth.size();i++) {
      if (predicate.test(daysOfMonth.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "daysOfMonth"));
    }
    return this.setNewDaysOfMonthLike(index, this.buildDaysOfMonth(index));
  }
  
  public TimesNested<A> editMatchingTime(Predicate<TimeRangeBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < times.size();i++) {
      if (predicate.test(times.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "times"));
    }
    return this.setNewTimeLike(index, this.buildTime(index));
  }
  
  public TimesNested<A> editTime(int index) {
    if (times.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "times"));
    }
    return this.setNewTimeLike(index, this.buildTime(index));
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
    if (!(Objects.equals(daysOfMonth, that.daysOfMonth))) {
      return false;
    }
    if (!(Objects.equals(months, that.months))) {
      return false;
    }
    if (!(Objects.equals(times, that.times))) {
      return false;
    }
    if (!(Objects.equals(weekdays, that.weekdays))) {
      return false;
    }
    if (!(Objects.equals(years, that.years))) {
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
  
  public String getFirstMonth() {
    return this.months.get(0);
  }
  
  public String getFirstWeekday() {
    return this.weekdays.get(0);
  }
  
  public String getFirstYear() {
    return this.years.get(0);
  }
  
  public String getLastMonth() {
    return this.months.get(months.size() - 1);
  }
  
  public String getLastWeekday() {
    return this.weekdays.get(weekdays.size() - 1);
  }
  
  public String getLastYear() {
    return this.years.get(years.size() - 1);
  }
  
  public String getMatchingMonth(Predicate<String> predicate) {
      for (String item : months) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingWeekday(Predicate<String> predicate) {
      for (String item : weekdays) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingYear(Predicate<String> predicate) {
      for (String item : years) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMonth(int index) {
    return this.months.get(index);
  }
  
  public List<String> getMonths() {
    return this.months;
  }
  
  public String getWeekday(int index) {
    return this.weekdays.get(index);
  }
  
  public List<String> getWeekdays() {
    return this.weekdays;
  }
  
  public String getYear(int index) {
    return this.years.get(index);
  }
  
  public List<String> getYears() {
    return this.years;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDaysOfMonth() {
    return this.daysOfMonth != null && !(this.daysOfMonth.isEmpty());
  }
  
  public boolean hasMatchingDaysOfMonth(Predicate<DayOfMonthRangeBuilder> predicate) {
      for (DayOfMonthRangeBuilder item : daysOfMonth) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingMonth(Predicate<String> predicate) {
      for (String item : months) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingTime(Predicate<TimeRangeBuilder> predicate) {
      for (TimeRangeBuilder item : times) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingWeekday(Predicate<String> predicate) {
      for (String item : weekdays) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingYear(Predicate<String> predicate) {
      for (String item : years) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMonths() {
    return this.months != null && !(this.months.isEmpty());
  }
  
  public boolean hasTimes() {
    return this.times != null && !(this.times.isEmpty());
  }
  
  public boolean hasWeekdays() {
    return this.weekdays != null && !(this.weekdays.isEmpty());
  }
  
  public boolean hasYears() {
    return this.years != null && !(this.years.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(daysOfMonth, months, times, weekdays, years, additionalProperties);
  }
  
  public A removeAllFromDaysOfMonth(Collection<DayOfMonthRange> items) {
    if (this.daysOfMonth == null) {
      return (A) this;
    }
    for (DayOfMonthRange item : items) {
        DayOfMonthRangeBuilder builder = new DayOfMonthRangeBuilder(item);
        _visitables.get("daysOfMonth").remove(builder);
        this.daysOfMonth.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromMonths(Collection<String> items) {
    if (this.months == null) {
      return (A) this;
    }
    for (String item : items) {
      this.months.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromTimes(Collection<TimeRange> items) {
    if (this.times == null) {
      return (A) this;
    }
    for (TimeRange item : items) {
        TimeRangeBuilder builder = new TimeRangeBuilder(item);
        _visitables.get("times").remove(builder);
        this.times.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromWeekdays(Collection<String> items) {
    if (this.weekdays == null) {
      return (A) this;
    }
    for (String item : items) {
      this.weekdays.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromYears(Collection<String> items) {
    if (this.years == null) {
      return (A) this;
    }
    for (String item : items) {
      this.years.remove(item);
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
  
  public A removeFromDaysOfMonth(DayOfMonthRange... items) {
    if (this.daysOfMonth == null) {
      return (A) this;
    }
    for (DayOfMonthRange item : items) {
        DayOfMonthRangeBuilder builder = new DayOfMonthRangeBuilder(item);
        _visitables.get("daysOfMonth").remove(builder);
        this.daysOfMonth.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromMonths(String... items) {
    if (this.months == null) {
      return (A) this;
    }
    for (String item : items) {
      this.months.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromTimes(TimeRange... items) {
    if (this.times == null) {
      return (A) this;
    }
    for (TimeRange item : items) {
        TimeRangeBuilder builder = new TimeRangeBuilder(item);
        _visitables.get("times").remove(builder);
        this.times.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromWeekdays(String... items) {
    if (this.weekdays == null) {
      return (A) this;
    }
    for (String item : items) {
      this.weekdays.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromYears(String... items) {
    if (this.years == null) {
      return (A) this;
    }
    for (String item : items) {
      this.years.remove(item);
    }
    return (A) this;
  }
  
  public A removeMatchingFromDaysOfMonth(Predicate<DayOfMonthRangeBuilder> predicate) {
    if (daysOfMonth == null) {
      return (A) this;
    }
    Iterator<DayOfMonthRangeBuilder> each = daysOfMonth.iterator();
    List visitables = _visitables.get("daysOfMonth");
    while (each.hasNext()) {
        DayOfMonthRangeBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromTimes(Predicate<TimeRangeBuilder> predicate) {
    if (times == null) {
      return (A) this;
    }
    Iterator<TimeRangeBuilder> each = times.iterator();
    List visitables = _visitables.get("times");
    while (each.hasNext()) {
        TimeRangeBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public DaysOfMonthNested<A> setNewDaysOfMonthLike(int index,DayOfMonthRange item) {
    return new DaysOfMonthNested(index, item);
  }
  
  public TimesNested<A> setNewTimeLike(int index,TimeRange item) {
    return new TimesNested(index, item);
  }
  
  public A setToDaysOfMonth(int index,DayOfMonthRange item) {
    if (this.daysOfMonth == null) {
      this.daysOfMonth = new ArrayList();
    }
    DayOfMonthRangeBuilder builder = new DayOfMonthRangeBuilder(item);
    if (index < 0 || index >= daysOfMonth.size()) {
        _visitables.get("daysOfMonth").add(builder);
        daysOfMonth.add(builder);
    } else {
        _visitables.get("daysOfMonth").add(builder);
        daysOfMonth.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToMonths(int index,String item) {
    if (this.months == null) {
      this.months = new ArrayList();
    }
    this.months.set(index, item);
    return (A) this;
  }
  
  public A setToTimes(int index,TimeRange item) {
    if (this.times == null) {
      this.times = new ArrayList();
    }
    TimeRangeBuilder builder = new TimeRangeBuilder(item);
    if (index < 0 || index >= times.size()) {
        _visitables.get("times").add(builder);
        times.add(builder);
    } else {
        _visitables.get("times").add(builder);
        times.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToWeekdays(int index,String item) {
    if (this.weekdays == null) {
      this.weekdays = new ArrayList();
    }
    this.weekdays.set(index, item);
    return (A) this;
  }
  
  public A setToYears(int index,String item) {
    if (this.years == null) {
      this.years = new ArrayList();
    }
    this.years.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(daysOfMonth == null) && !(daysOfMonth.isEmpty())) {
        sb.append("daysOfMonth:");
        sb.append(daysOfMonth);
        sb.append(",");
    }
    if (!(months == null) && !(months.isEmpty())) {
        sb.append("months:");
        sb.append(months);
        sb.append(",");
    }
    if (!(times == null) && !(times.isEmpty())) {
        sb.append("times:");
        sb.append(times);
        sb.append(",");
    }
    if (!(weekdays == null) && !(weekdays.isEmpty())) {
        sb.append("weekdays:");
        sb.append(weekdays);
        sb.append(",");
    }
    if (!(years == null) && !(years.isEmpty())) {
        sb.append("years:");
        sb.append(years);
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
  
  public A withDaysOfMonth(List<DayOfMonthRange> daysOfMonth) {
    if (this.daysOfMonth != null) {
      this._visitables.get("daysOfMonth").clear();
    }
    if (daysOfMonth != null) {
        this.daysOfMonth = new ArrayList();
        for (DayOfMonthRange item : daysOfMonth) {
          this.addToDaysOfMonth(item);
        }
    } else {
      this.daysOfMonth = null;
    }
    return (A) this;
  }
  
  public A withDaysOfMonth(DayOfMonthRange... daysOfMonth) {
    if (this.daysOfMonth != null) {
        this.daysOfMonth.clear();
        _visitables.remove("daysOfMonth");
    }
    if (daysOfMonth != null) {
      for (DayOfMonthRange item : daysOfMonth) {
        this.addToDaysOfMonth(item);
      }
    }
    return (A) this;
  }
  
  public A withMonths(List<String> months) {
    if (months != null) {
        this.months = new ArrayList();
        for (String item : months) {
          this.addToMonths(item);
        }
    } else {
      this.months = null;
    }
    return (A) this;
  }
  
  public A withMonths(String... months) {
    if (this.months != null) {
        this.months.clear();
        _visitables.remove("months");
    }
    if (months != null) {
      for (String item : months) {
        this.addToMonths(item);
      }
    }
    return (A) this;
  }
  
  public A withTimes(List<TimeRange> times) {
    if (this.times != null) {
      this._visitables.get("times").clear();
    }
    if (times != null) {
        this.times = new ArrayList();
        for (TimeRange item : times) {
          this.addToTimes(item);
        }
    } else {
      this.times = null;
    }
    return (A) this;
  }
  
  public A withTimes(TimeRange... times) {
    if (this.times != null) {
        this.times.clear();
        _visitables.remove("times");
    }
    if (times != null) {
      for (TimeRange item : times) {
        this.addToTimes(item);
      }
    }
    return (A) this;
  }
  
  public A withWeekdays(List<String> weekdays) {
    if (weekdays != null) {
        this.weekdays = new ArrayList();
        for (String item : weekdays) {
          this.addToWeekdays(item);
        }
    } else {
      this.weekdays = null;
    }
    return (A) this;
  }
  
  public A withWeekdays(String... weekdays) {
    if (this.weekdays != null) {
        this.weekdays.clear();
        _visitables.remove("weekdays");
    }
    if (weekdays != null) {
      for (String item : weekdays) {
        this.addToWeekdays(item);
      }
    }
    return (A) this;
  }
  
  public A withYears(List<String> years) {
    if (years != null) {
        this.years = new ArrayList();
        for (String item : years) {
          this.addToYears(item);
        }
    } else {
      this.years = null;
    }
    return (A) this;
  }
  
  public A withYears(String... years) {
    if (this.years != null) {
        this.years.clear();
        _visitables.remove("years");
    }
    if (years != null) {
      for (String item : years) {
        this.addToYears(item);
      }
    }
    return (A) this;
  }
  public class DaysOfMonthNested<N> extends DayOfMonthRangeFluent<DaysOfMonthNested<N>> implements Nested<N>{
  
    DayOfMonthRangeBuilder builder;
    int index;
  
    DaysOfMonthNested(int index,DayOfMonthRange item) {
      this.index = index;
      this.builder = new DayOfMonthRangeBuilder(this, item);
    }
  
    public N and() {
      return (N) TimeIntervalFluent.this.setToDaysOfMonth(index, builder.build());
    }
    
    public N endDaysOfMonth() {
      return and();
    }
    
  }
  public class TimesNested<N> extends TimeRangeFluent<TimesNested<N>> implements Nested<N>{
  
    TimeRangeBuilder builder;
    int index;
  
    TimesNested(int index,TimeRange item) {
      this.index = index;
      this.builder = new TimeRangeBuilder(this, item);
    }
  
    public N and() {
      return (N) TimeIntervalFluent.this.setToTimes(index, builder.build());
    }
    
    public N endTime() {
      return and();
    }
    
  }
}