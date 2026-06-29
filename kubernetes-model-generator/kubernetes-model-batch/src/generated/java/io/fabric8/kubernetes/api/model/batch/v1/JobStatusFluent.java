package io.fabric8.kubernetes.api.model.batch.v1;

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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class JobStatusFluent<A extends io.fabric8.kubernetes.api.model.batch.v1.JobStatusFluent<A>> extends BaseFluent<A>{

  private Integer active;
  private Map<String,Object> additionalProperties;
  private String completedIndexes;
  private String completionTime;
  private ArrayList<JobConditionBuilder> conditions = new ArrayList<JobConditionBuilder>();
  private Integer failed;
  private String failedIndexes;
  private Integer ready;
  private String startTime;
  private Integer succeeded;
  private Integer terminating;
  private UncountedTerminatedPodsBuilder uncountedTerminatedPods;

  public JobStatusFluent() {
  }
  
  public JobStatusFluent(JobStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<JobCondition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (JobCondition item : items) {
        JobConditionBuilder builder = new JobConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public ConditionsNested<A> addNewConditionLike(JobCondition item) {
    return new ConditionsNested(-1, item);
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
  
  public A addToConditions(JobCondition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (JobCondition item : items) {
        JobConditionBuilder builder = new JobConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,JobCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    JobConditionBuilder builder = new JobConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.add(index, builder);
    }
    return (A) this;
  }
  
  public JobCondition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<JobCondition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public JobCondition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public JobCondition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public JobCondition buildMatchingCondition(Predicate<JobConditionBuilder> predicate) {
      for (JobConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public UncountedTerminatedPods buildUncountedTerminatedPods() {
    return this.uncountedTerminatedPods != null ? this.uncountedTerminatedPods.build() : null;
  }
  
  protected void copyInstance(JobStatus instance) {
    instance = instance != null ? instance : new JobStatus();
    if (instance != null) {
        this.withActive(instance.getActive());
        this.withCompletedIndexes(instance.getCompletedIndexes());
        this.withCompletionTime(instance.getCompletionTime());
        this.withConditions(instance.getConditions());
        this.withFailed(instance.getFailed());
        this.withFailedIndexes(instance.getFailedIndexes());
        this.withReady(instance.getReady());
        this.withStartTime(instance.getStartTime());
        this.withSucceeded(instance.getSucceeded());
        this.withTerminating(instance.getTerminating());
        this.withUncountedTerminatedPods(instance.getUncountedTerminatedPods());
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
  
  public ConditionsNested<A> editLastCondition() {
    int index = conditions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public ConditionsNested<A> editMatchingCondition(Predicate<JobConditionBuilder> predicate) {
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
  
  public UncountedTerminatedPodsNested<A> editOrNewUncountedTerminatedPods() {
    return this.withNewUncountedTerminatedPodsLike(Optional.ofNullable(this.buildUncountedTerminatedPods()).orElse(new UncountedTerminatedPodsBuilder().build()));
  }
  
  public UncountedTerminatedPodsNested<A> editOrNewUncountedTerminatedPodsLike(UncountedTerminatedPods item) {
    return this.withNewUncountedTerminatedPodsLike(Optional.ofNullable(this.buildUncountedTerminatedPods()).orElse(item));
  }
  
  public UncountedTerminatedPodsNested<A> editUncountedTerminatedPods() {
    return this.withNewUncountedTerminatedPodsLike(Optional.ofNullable(this.buildUncountedTerminatedPods()).orElse(null));
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
    JobStatusFluent that = (JobStatusFluent) o;
    if (!(Objects.equals(active, that.active))) {
      return false;
    }
    if (!(Objects.equals(completedIndexes, that.completedIndexes))) {
      return false;
    }
    if (!(Objects.equals(completionTime, that.completionTime))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(failed, that.failed))) {
      return false;
    }
    if (!(Objects.equals(failedIndexes, that.failedIndexes))) {
      return false;
    }
    if (!(Objects.equals(ready, that.ready))) {
      return false;
    }
    if (!(Objects.equals(startTime, that.startTime))) {
      return false;
    }
    if (!(Objects.equals(succeeded, that.succeeded))) {
      return false;
    }
    if (!(Objects.equals(terminating, that.terminating))) {
      return false;
    }
    if (!(Objects.equals(uncountedTerminatedPods, that.uncountedTerminatedPods))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public Integer getActive() {
    return this.active;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getCompletedIndexes() {
    return this.completedIndexes;
  }
  
  public String getCompletionTime() {
    return this.completionTime;
  }
  
  public Integer getFailed() {
    return this.failed;
  }
  
  public String getFailedIndexes() {
    return this.failedIndexes;
  }
  
  public Integer getReady() {
    return this.ready;
  }
  
  public String getStartTime() {
    return this.startTime;
  }
  
  public Integer getSucceeded() {
    return this.succeeded;
  }
  
  public Integer getTerminating() {
    return this.terminating;
  }
  
  public boolean hasActive() {
    return this.active != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCompletedIndexes() {
    return this.completedIndexes != null;
  }
  
  public boolean hasCompletionTime() {
    return this.completionTime != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasFailed() {
    return this.failed != null;
  }
  
  public boolean hasFailedIndexes() {
    return this.failedIndexes != null;
  }
  
  public boolean hasMatchingCondition(Predicate<JobConditionBuilder> predicate) {
      for (JobConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasReady() {
    return this.ready != null;
  }
  
  public boolean hasStartTime() {
    return this.startTime != null;
  }
  
  public boolean hasSucceeded() {
    return this.succeeded != null;
  }
  
  public boolean hasTerminating() {
    return this.terminating != null;
  }
  
  public boolean hasUncountedTerminatedPods() {
    return this.uncountedTerminatedPods != null;
  }
  
  public int hashCode() {
    return Objects.hash(active, completedIndexes, completionTime, conditions, failed, failedIndexes, ready, startTime, succeeded, terminating, uncountedTerminatedPods, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<JobCondition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (JobCondition item : items) {
        JobConditionBuilder builder = new JobConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
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
  
  public A removeFromConditions(JobCondition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (JobCondition item : items) {
        JobConditionBuilder builder = new JobConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditions(Predicate<JobConditionBuilder> predicate) {
    if (conditions == null) {
      return (A) this;
    }
    Iterator<JobConditionBuilder> each = conditions.iterator();
    List visitables = _visitables.get("conditions");
    while (each.hasNext()) {
        JobConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,JobCondition item) {
    return new ConditionsNested(index, item);
  }
  
  public A setToConditions(int index,JobCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    JobConditionBuilder builder = new JobConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(active == null)) {
        sb.append("active:");
        sb.append(active);
        sb.append(",");
    }
    if (!(completedIndexes == null)) {
        sb.append("completedIndexes:");
        sb.append(completedIndexes);
        sb.append(",");
    }
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
    if (!(failed == null)) {
        sb.append("failed:");
        sb.append(failed);
        sb.append(",");
    }
    if (!(failedIndexes == null)) {
        sb.append("failedIndexes:");
        sb.append(failedIndexes);
        sb.append(",");
    }
    if (!(ready == null)) {
        sb.append("ready:");
        sb.append(ready);
        sb.append(",");
    }
    if (!(startTime == null)) {
        sb.append("startTime:");
        sb.append(startTime);
        sb.append(",");
    }
    if (!(succeeded == null)) {
        sb.append("succeeded:");
        sb.append(succeeded);
        sb.append(",");
    }
    if (!(terminating == null)) {
        sb.append("terminating:");
        sb.append(terminating);
        sb.append(",");
    }
    if (!(uncountedTerminatedPods == null)) {
        sb.append("uncountedTerminatedPods:");
        sb.append(uncountedTerminatedPods);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withActive(Integer active) {
    this.active = active;
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
  
  public A withCompletedIndexes(String completedIndexes) {
    this.completedIndexes = completedIndexes;
    return (A) this;
  }
  
  public A withCompletionTime(String completionTime) {
    this.completionTime = completionTime;
    return (A) this;
  }
  
  public A withConditions(List<JobCondition> conditions) {
    if (this.conditions != null) {
      this._visitables.get("conditions").clear();
    }
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (JobCondition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(JobCondition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (JobCondition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withFailed(Integer failed) {
    this.failed = failed;
    return (A) this;
  }
  
  public A withFailedIndexes(String failedIndexes) {
    this.failedIndexes = failedIndexes;
    return (A) this;
  }
  
  public UncountedTerminatedPodsNested<A> withNewUncountedTerminatedPods() {
    return new UncountedTerminatedPodsNested(null);
  }
  
  public UncountedTerminatedPodsNested<A> withNewUncountedTerminatedPodsLike(UncountedTerminatedPods item) {
    return new UncountedTerminatedPodsNested(item);
  }
  
  public A withReady(Integer ready) {
    this.ready = ready;
    return (A) this;
  }
  
  public A withStartTime(String startTime) {
    this.startTime = startTime;
    return (A) this;
  }
  
  public A withSucceeded(Integer succeeded) {
    this.succeeded = succeeded;
    return (A) this;
  }
  
  public A withTerminating(Integer terminating) {
    this.terminating = terminating;
    return (A) this;
  }
  
  public A withUncountedTerminatedPods(UncountedTerminatedPods uncountedTerminatedPods) {
    this._visitables.remove("uncountedTerminatedPods");
    if (uncountedTerminatedPods != null) {
        this.uncountedTerminatedPods = new UncountedTerminatedPodsBuilder(uncountedTerminatedPods);
        this._visitables.get("uncountedTerminatedPods").add(this.uncountedTerminatedPods);
    } else {
        this.uncountedTerminatedPods = null;
        this._visitables.get("uncountedTerminatedPods").remove(this.uncountedTerminatedPods);
    }
    return (A) this;
  }
  public class ConditionsNested<N> extends JobConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    JobConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,JobCondition item) {
      this.index = index;
      this.builder = new JobConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) JobStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
  public class UncountedTerminatedPodsNested<N> extends UncountedTerminatedPodsFluent<UncountedTerminatedPodsNested<N>> implements Nested<N>{
  
    UncountedTerminatedPodsBuilder builder;
  
    UncountedTerminatedPodsNested(UncountedTerminatedPods item) {
      this.builder = new UncountedTerminatedPodsBuilder(this, item);
    }
  
    public N and() {
      return (N) JobStatusFluent.this.withUncountedTerminatedPods(builder.build());
    }
    
    public N endUncountedTerminatedPods() {
      return and();
    }
    
  }
}