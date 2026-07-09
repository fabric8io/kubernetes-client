package io.fabric8.kubernetes.api.model.policy.v1beta1;

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
public class RunAsUserStrategyOptionsFluent<A extends io.fabric8.kubernetes.api.model.policy.v1beta1.RunAsUserStrategyOptionsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<IDRangeBuilder> ranges = new ArrayList<IDRangeBuilder>();
  private String rule;

  public RunAsUserStrategyOptionsFluent() {
  }
  
  public RunAsUserStrategyOptionsFluent(RunAsUserStrategyOptions instance) {
    this.copyInstance(instance);
  }

  public A addAllToRanges(Collection<IDRange> items) {
    if (this.ranges == null) {
      this.ranges = new ArrayList();
    }
    for (IDRange item : items) {
        IDRangeBuilder builder = new IDRangeBuilder(item);
        _visitables.get("ranges").add(builder);
        this.ranges.add(builder);
    }
    return (A) this;
  }
  
  public RangesNested<A> addNewRange() {
    return new RangesNested(-1, null);
  }
  
  public A addNewRange(Long max,Long min) {
    return (A) this.addToRanges(new IDRange(max, min));
  }
  
  public RangesNested<A> addNewRangeLike(IDRange item) {
    return new RangesNested(-1, item);
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
  
  public A addToRanges(IDRange... items) {
    if (this.ranges == null) {
      this.ranges = new ArrayList();
    }
    for (IDRange item : items) {
        IDRangeBuilder builder = new IDRangeBuilder(item);
        _visitables.get("ranges").add(builder);
        this.ranges.add(builder);
    }
    return (A) this;
  }
  
  public A addToRanges(int index,IDRange item) {
    if (this.ranges == null) {
      this.ranges = new ArrayList();
    }
    IDRangeBuilder builder = new IDRangeBuilder(item);
    if (index < 0 || index >= ranges.size()) {
        _visitables.get("ranges").add(builder);
        ranges.add(builder);
    } else {
        _visitables.get("ranges").add(builder);
        ranges.add(index, builder);
    }
    return (A) this;
  }
  
  public IDRange buildFirstRange() {
    return this.ranges.get(0).build();
  }
  
  public IDRange buildLastRange() {
    return this.ranges.get(ranges.size() - 1).build();
  }
  
  public IDRange buildMatchingRange(Predicate<IDRangeBuilder> predicate) {
      for (IDRangeBuilder item : ranges) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public IDRange buildRange(int index) {
    return this.ranges.get(index).build();
  }
  
  public List<IDRange> buildRanges() {
    return this.ranges != null ? build(ranges) : null;
  }
  
  protected void copyInstance(RunAsUserStrategyOptions instance) {
    instance = instance != null ? instance : new RunAsUserStrategyOptions();
    if (instance != null) {
        this.withRanges(instance.getRanges());
        this.withRule(instance.getRule());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RangesNested<A> editFirstRange() {
    if (ranges.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "ranges"));
    }
    return this.setNewRangeLike(0, this.buildRange(0));
  }
  
  public RangesNested<A> editLastRange() {
    int index = ranges.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "ranges"));
    }
    return this.setNewRangeLike(index, this.buildRange(index));
  }
  
  public RangesNested<A> editMatchingRange(Predicate<IDRangeBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < ranges.size();i++) {
      if (predicate.test(ranges.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "ranges"));
    }
    return this.setNewRangeLike(index, this.buildRange(index));
  }
  
  public RangesNested<A> editRange(int index) {
    if (ranges.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "ranges"));
    }
    return this.setNewRangeLike(index, this.buildRange(index));
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
    RunAsUserStrategyOptionsFluent that = (RunAsUserStrategyOptionsFluent) o;
    if (!(Objects.equals(ranges, that.ranges))) {
      return false;
    }
    if (!(Objects.equals(rule, that.rule))) {
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
  
  public String getRule() {
    return this.rule;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingRange(Predicate<IDRangeBuilder> predicate) {
      for (IDRangeBuilder item : ranges) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasRanges() {
    return this.ranges != null && !(this.ranges.isEmpty());
  }
  
  public boolean hasRule() {
    return this.rule != null;
  }
  
  public int hashCode() {
    return Objects.hash(ranges, rule, additionalProperties);
  }
  
  public A removeAllFromRanges(Collection<IDRange> items) {
    if (this.ranges == null) {
      return (A) this;
    }
    for (IDRange item : items) {
        IDRangeBuilder builder = new IDRangeBuilder(item);
        _visitables.get("ranges").remove(builder);
        this.ranges.remove(builder);
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
  
  public A removeFromRanges(IDRange... items) {
    if (this.ranges == null) {
      return (A) this;
    }
    for (IDRange item : items) {
        IDRangeBuilder builder = new IDRangeBuilder(item);
        _visitables.get("ranges").remove(builder);
        this.ranges.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromRanges(Predicate<IDRangeBuilder> predicate) {
    if (ranges == null) {
      return (A) this;
    }
    Iterator<IDRangeBuilder> each = ranges.iterator();
    List visitables = _visitables.get("ranges");
    while (each.hasNext()) {
        IDRangeBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public RangesNested<A> setNewRangeLike(int index,IDRange item) {
    return new RangesNested(index, item);
  }
  
  public A setToRanges(int index,IDRange item) {
    if (this.ranges == null) {
      this.ranges = new ArrayList();
    }
    IDRangeBuilder builder = new IDRangeBuilder(item);
    if (index < 0 || index >= ranges.size()) {
        _visitables.get("ranges").add(builder);
        ranges.add(builder);
    } else {
        _visitables.get("ranges").add(builder);
        ranges.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(ranges == null) && !(ranges.isEmpty())) {
        sb.append("ranges:");
        sb.append(ranges);
        sb.append(",");
    }
    if (!(rule == null)) {
        sb.append("rule:");
        sb.append(rule);
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
  
  public A withRanges(List<IDRange> ranges) {
    if (this.ranges != null) {
      this._visitables.get("ranges").clear();
    }
    if (ranges != null) {
        this.ranges = new ArrayList();
        for (IDRange item : ranges) {
          this.addToRanges(item);
        }
    } else {
      this.ranges = null;
    }
    return (A) this;
  }
  
  public A withRanges(IDRange... ranges) {
    if (this.ranges != null) {
        this.ranges.clear();
        _visitables.remove("ranges");
    }
    if (ranges != null) {
      for (IDRange item : ranges) {
        this.addToRanges(item);
      }
    }
    return (A) this;
  }
  
  public A withRule(String rule) {
    this.rule = rule;
    return (A) this;
  }
  public class RangesNested<N> extends IDRangeFluent<RangesNested<N>> implements Nested<N>{
  
    IDRangeBuilder builder;
    int index;
  
    RangesNested(int index,IDRange item) {
      this.index = index;
      this.builder = new IDRangeBuilder(this, item);
    }
  
    public N and() {
      return (N) RunAsUserStrategyOptionsFluent.this.setToRanges(index, builder.build());
    }
    
    public N endRange() {
      return and();
    }
    
  }
}