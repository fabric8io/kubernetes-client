package io.fabric8.chaosmesh.v1alpha1;

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
public class StatusCheckStatusFluent<A extends io.fabric8.chaosmesh.v1alpha1.StatusCheckStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String completionTime;
  private ArrayList<StatusCheckConditionBuilder> conditions = new ArrayList<StatusCheckConditionBuilder>();
  private Long count;
  private ArrayList<StatusCheckRecordBuilder> records = new ArrayList<StatusCheckRecordBuilder>();
  private String startTime;

  public StatusCheckStatusFluent() {
  }
  
  public StatusCheckStatusFluent(StatusCheckStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<StatusCheckCondition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (StatusCheckCondition item : items) {
        StatusCheckConditionBuilder builder = new StatusCheckConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToRecords(Collection<StatusCheckRecord> items) {
    if (this.records == null) {
      this.records = new ArrayList();
    }
    for (StatusCheckRecord item : items) {
        StatusCheckRecordBuilder builder = new StatusCheckRecordBuilder(item);
        _visitables.get("records").add(builder);
        this.records.add(builder);
    }
    return (A) this;
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public A addNewCondition(String lastProbeTime,String lastTransitionTime,String reason,String status,String type) {
    return (A) this.addToConditions(new StatusCheckCondition(lastProbeTime, lastTransitionTime, reason, status, type));
  }
  
  public ConditionsNested<A> addNewConditionLike(StatusCheckCondition item) {
    return new ConditionsNested(-1, item);
  }
  
  public RecordsNested<A> addNewRecord() {
    return new RecordsNested(-1, null);
  }
  
  public A addNewRecord(String outcome,String startTime) {
    return (A) this.addToRecords(new StatusCheckRecord(outcome, startTime));
  }
  
  public RecordsNested<A> addNewRecordLike(StatusCheckRecord item) {
    return new RecordsNested(-1, item);
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
  
  public A addToConditions(StatusCheckCondition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (StatusCheckCondition item : items) {
        StatusCheckConditionBuilder builder = new StatusCheckConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,StatusCheckCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    StatusCheckConditionBuilder builder = new StatusCheckConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToRecords(StatusCheckRecord... items) {
    if (this.records == null) {
      this.records = new ArrayList();
    }
    for (StatusCheckRecord item : items) {
        StatusCheckRecordBuilder builder = new StatusCheckRecordBuilder(item);
        _visitables.get("records").add(builder);
        this.records.add(builder);
    }
    return (A) this;
  }
  
  public A addToRecords(int index,StatusCheckRecord item) {
    if (this.records == null) {
      this.records = new ArrayList();
    }
    StatusCheckRecordBuilder builder = new StatusCheckRecordBuilder(item);
    if (index < 0 || index >= records.size()) {
        _visitables.get("records").add(builder);
        records.add(builder);
    } else {
        _visitables.get("records").add(builder);
        records.add(index, builder);
    }
    return (A) this;
  }
  
  public StatusCheckCondition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<StatusCheckCondition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public StatusCheckCondition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public StatusCheckRecord buildFirstRecord() {
    return this.records.get(0).build();
  }
  
  public StatusCheckCondition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public StatusCheckRecord buildLastRecord() {
    return this.records.get(records.size() - 1).build();
  }
  
  public StatusCheckCondition buildMatchingCondition(Predicate<StatusCheckConditionBuilder> predicate) {
      for (StatusCheckConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public StatusCheckRecord buildMatchingRecord(Predicate<StatusCheckRecordBuilder> predicate) {
      for (StatusCheckRecordBuilder item : records) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public StatusCheckRecord buildRecord(int index) {
    return this.records.get(index).build();
  }
  
  public List<StatusCheckRecord> buildRecords() {
    return this.records != null ? build(records) : null;
  }
  
  protected void copyInstance(StatusCheckStatus instance) {
    instance = instance != null ? instance : new StatusCheckStatus();
    if (instance != null) {
        this.withCompletionTime(instance.getCompletionTime());
        this.withConditions(instance.getConditions());
        this.withCount(instance.getCount());
        this.withRecords(instance.getRecords());
        this.withStartTime(instance.getStartTime());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConditionsNested<A> editCondition(int index) {
    if (conditions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public ConditionsNested<A> editFirstCondition() {
    if (conditions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(0, this.buildCondition(0));
  }
  
  public RecordsNested<A> editFirstRecord() {
    if (records.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "records"));
    }
    return this.setNewRecordLike(0, this.buildRecord(0));
  }
  
  public ConditionsNested<A> editLastCondition() {
    int index = conditions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public RecordsNested<A> editLastRecord() {
    int index = records.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "records"));
    }
    return this.setNewRecordLike(index, this.buildRecord(index));
  }
  
  public ConditionsNested<A> editMatchingCondition(Predicate<StatusCheckConditionBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < conditions.size();i++) {
      if (predicate.test(conditions.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public RecordsNested<A> editMatchingRecord(Predicate<StatusCheckRecordBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < records.size();i++) {
      if (predicate.test(records.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "records"));
    }
    return this.setNewRecordLike(index, this.buildRecord(index));
  }
  
  public RecordsNested<A> editRecord(int index) {
    if (records.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "records"));
    }
    return this.setNewRecordLike(index, this.buildRecord(index));
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
    StatusCheckStatusFluent that = (StatusCheckStatusFluent) o;
    if (!(Objects.equals(completionTime, that.completionTime))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(count, that.count))) {
      return false;
    }
    if (!(Objects.equals(records, that.records))) {
      return false;
    }
    if (!(Objects.equals(startTime, that.startTime))) {
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
  
  public String getCompletionTime() {
    return this.completionTime;
  }
  
  public Long getCount() {
    return this.count;
  }
  
  public String getStartTime() {
    return this.startTime;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCompletionTime() {
    return this.completionTime != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasCount() {
    return this.count != null;
  }
  
  public boolean hasMatchingCondition(Predicate<StatusCheckConditionBuilder> predicate) {
      for (StatusCheckConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingRecord(Predicate<StatusCheckRecordBuilder> predicate) {
      for (StatusCheckRecordBuilder item : records) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasRecords() {
    return this.records != null && !(this.records.isEmpty());
  }
  
  public boolean hasStartTime() {
    return this.startTime != null;
  }
  
  public int hashCode() {
    return Objects.hash(completionTime, conditions, count, records, startTime, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<StatusCheckCondition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (StatusCheckCondition item : items) {
        StatusCheckConditionBuilder builder = new StatusCheckConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromRecords(Collection<StatusCheckRecord> items) {
    if (this.records == null) {
      return (A) this;
    }
    for (StatusCheckRecord item : items) {
        StatusCheckRecordBuilder builder = new StatusCheckRecordBuilder(item);
        _visitables.get("records").remove(builder);
        this.records.remove(builder);
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
  
  public A removeFromConditions(StatusCheckCondition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (StatusCheckCondition item : items) {
        StatusCheckConditionBuilder builder = new StatusCheckConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromRecords(StatusCheckRecord... items) {
    if (this.records == null) {
      return (A) this;
    }
    for (StatusCheckRecord item : items) {
        StatusCheckRecordBuilder builder = new StatusCheckRecordBuilder(item);
        _visitables.get("records").remove(builder);
        this.records.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditions(Predicate<StatusCheckConditionBuilder> predicate) {
    if (conditions == null) {
      return (A) this;
    }
    Iterator<StatusCheckConditionBuilder> each = conditions.iterator();
    List visitables = _visitables.get("conditions");
    while (each.hasNext()) {
        StatusCheckConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromRecords(Predicate<StatusCheckRecordBuilder> predicate) {
    if (records == null) {
      return (A) this;
    }
    Iterator<StatusCheckRecordBuilder> each = records.iterator();
    List visitables = _visitables.get("records");
    while (each.hasNext()) {
        StatusCheckRecordBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,StatusCheckCondition item) {
    return new ConditionsNested(index, item);
  }
  
  public RecordsNested<A> setNewRecordLike(int index,StatusCheckRecord item) {
    return new RecordsNested(index, item);
  }
  
  public A setToConditions(int index,StatusCheckCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    StatusCheckConditionBuilder builder = new StatusCheckConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToRecords(int index,StatusCheckRecord item) {
    if (this.records == null) {
      this.records = new ArrayList();
    }
    StatusCheckRecordBuilder builder = new StatusCheckRecordBuilder(item);
    if (index < 0 || index >= records.size()) {
        _visitables.get("records").add(builder);
        records.add(builder);
    } else {
        _visitables.get("records").add(builder);
        records.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(completionTime == null)) {
        sb.append("completionTime:");
        sb.append(completionTime);
        sb.append(",");
    }
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(count == null)) {
        sb.append("count:");
        sb.append(count);
        sb.append(",");
    }
    if (!(records == null) && !(records.isEmpty())) {
        sb.append("records:");
        sb.append(records);
        sb.append(",");
    }
    if (!(startTime == null)) {
        sb.append("startTime:");
        sb.append(startTime);
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
  
  public A withCompletionTime(String completionTime) {
    this.completionTime = completionTime;
    return (A) this;
  }
  
  public A withConditions(List<StatusCheckCondition> conditions) {
    if (this.conditions != null) {
      this._visitables.get("conditions").clear();
    }
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (StatusCheckCondition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(StatusCheckCondition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (StatusCheckCondition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withCount(Long count) {
    this.count = count;
    return (A) this;
  }
  
  public A withRecords(List<StatusCheckRecord> records) {
    if (this.records != null) {
      this._visitables.get("records").clear();
    }
    if (records != null) {
        this.records = new ArrayList();
        for (StatusCheckRecord item : records) {
          this.addToRecords(item);
        }
    } else {
      this.records = null;
    }
    return (A) this;
  }
  
  public A withRecords(StatusCheckRecord... records) {
    if (this.records != null) {
        this.records.clear();
        _visitables.remove("records");
    }
    if (records != null) {
      for (StatusCheckRecord item : records) {
        this.addToRecords(item);
      }
    }
    return (A) this;
  }
  
  public A withStartTime(String startTime) {
    this.startTime = startTime;
    return (A) this;
  }
  public class ConditionsNested<N> extends StatusCheckConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    StatusCheckConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,StatusCheckCondition item) {
      this.index = index;
      this.builder = new StatusCheckConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) StatusCheckStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
  public class RecordsNested<N> extends StatusCheckRecordFluent<RecordsNested<N>> implements Nested<N>{
  
    StatusCheckRecordBuilder builder;
    int index;
  
    RecordsNested(int index,StatusCheckRecord item) {
      this.index = index;
      this.builder = new StatusCheckRecordBuilder(this, item);
    }
  
    public N and() {
      return (N) StatusCheckStatusFluent.this.setToRecords(index, builder.build());
    }
    
    public N endRecord() {
      return and();
    }
    
  }
}