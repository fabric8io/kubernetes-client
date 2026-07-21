package io.fabric8.volcano.api.model.batch.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Duration;
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
public class JobStatusFluent<A extends io.fabric8.volcano.api.model.batch.v1alpha1.JobStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<JobConditionBuilder> conditions = new ArrayList<JobConditionBuilder>();
  private Map<String,String> controlledResources;
  private Integer failed;
  private Integer minAvailable;
  private Integer pending;
  private Integer retryCount;
  private Integer running;
  private Duration runningDuration;
  private JobStateBuilder state;
  private Integer succeeded;
  private Map<String,TaskState> taskStatusCount;
  private Integer terminating;
  private Integer unknown;
  private Integer version;

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
  
  public A addNewCondition(String lastTransitionTime,String status) {
    return (A) this.addToConditions(new JobCondition(lastTransitionTime, status));
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
  
  public A addToControlledResources(Map<String,String> map) {
    if (this.controlledResources == null && map != null) {
      this.controlledResources = new LinkedHashMap();
    }
    if (map != null) {
      this.controlledResources.putAll(map);
    }
    return (A) this;
  }
  
  public A addToControlledResources(String key,String value) {
    if (this.controlledResources == null && key != null && value != null) {
      this.controlledResources = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.controlledResources.put(key, value);
    }
    return (A) this;
  }
  
  public A addToTaskStatusCount(Map<String,TaskState> map) {
    if (this.taskStatusCount == null && map != null) {
      this.taskStatusCount = new LinkedHashMap();
    }
    if (map != null) {
      this.taskStatusCount.putAll(map);
    }
    return (A) this;
  }
  
  public A addToTaskStatusCount(String key,TaskState value) {
    if (this.taskStatusCount == null && key != null && value != null) {
      this.taskStatusCount = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.taskStatusCount.put(key, value);
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
  
  public JobState buildState() {
    return this.state != null ? this.state.build() : null;
  }
  
  protected void copyInstance(JobStatus instance) {
    instance = instance != null ? instance : new JobStatus();
    if (instance != null) {
        this.withConditions(instance.getConditions());
        this.withControlledResources(instance.getControlledResources());
        this.withFailed(instance.getFailed());
        this.withMinAvailable(instance.getMinAvailable());
        this.withPending(instance.getPending());
        this.withRetryCount(instance.getRetryCount());
        this.withRunning(instance.getRunning());
        this.withRunningDuration(instance.getRunningDuration());
        this.withState(instance.getState());
        this.withSucceeded(instance.getSucceeded());
        this.withTaskStatusCount(instance.getTaskStatusCount());
        this.withTerminating(instance.getTerminating());
        this.withUnknown(instance.getUnknown());
        this.withVersion(instance.getVersion());
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
  
  public StateNested<A> editOrNewState() {
    return this.withNewStateLike(Optional.ofNullable(this.buildState()).orElse(new JobStateBuilder().build()));
  }
  
  public StateNested<A> editOrNewStateLike(JobState item) {
    return this.withNewStateLike(Optional.ofNullable(this.buildState()).orElse(item));
  }
  
  public StateNested<A> editState() {
    return this.withNewStateLike(Optional.ofNullable(this.buildState()).orElse(null));
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
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(controlledResources, that.controlledResources))) {
      return false;
    }
    if (!(Objects.equals(failed, that.failed))) {
      return false;
    }
    if (!(Objects.equals(minAvailable, that.minAvailable))) {
      return false;
    }
    if (!(Objects.equals(pending, that.pending))) {
      return false;
    }
    if (!(Objects.equals(retryCount, that.retryCount))) {
      return false;
    }
    if (!(Objects.equals(running, that.running))) {
      return false;
    }
    if (!(Objects.equals(runningDuration, that.runningDuration))) {
      return false;
    }
    if (!(Objects.equals(state, that.state))) {
      return false;
    }
    if (!(Objects.equals(succeeded, that.succeeded))) {
      return false;
    }
    if (!(Objects.equals(taskStatusCount, that.taskStatusCount))) {
      return false;
    }
    if (!(Objects.equals(terminating, that.terminating))) {
      return false;
    }
    if (!(Objects.equals(unknown, that.unknown))) {
      return false;
    }
    if (!(Objects.equals(version, that.version))) {
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
  
  public Map<String,String> getControlledResources() {
    return this.controlledResources;
  }
  
  public Integer getFailed() {
    return this.failed;
  }
  
  public Integer getMinAvailable() {
    return this.minAvailable;
  }
  
  public Integer getPending() {
    return this.pending;
  }
  
  public Integer getRetryCount() {
    return this.retryCount;
  }
  
  public Integer getRunning() {
    return this.running;
  }
  
  public Duration getRunningDuration() {
    return this.runningDuration;
  }
  
  public Integer getSucceeded() {
    return this.succeeded;
  }
  
  public Map<String,TaskState> getTaskStatusCount() {
    return this.taskStatusCount;
  }
  
  public Integer getTerminating() {
    return this.terminating;
  }
  
  public Integer getUnknown() {
    return this.unknown;
  }
  
  public Integer getVersion() {
    return this.version;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasControlledResources() {
    return this.controlledResources != null;
  }
  
  public boolean hasFailed() {
    return this.failed != null;
  }
  
  public boolean hasMatchingCondition(Predicate<JobConditionBuilder> predicate) {
      for (JobConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMinAvailable() {
    return this.minAvailable != null;
  }
  
  public boolean hasPending() {
    return this.pending != null;
  }
  
  public boolean hasRetryCount() {
    return this.retryCount != null;
  }
  
  public boolean hasRunning() {
    return this.running != null;
  }
  
  public boolean hasRunningDuration() {
    return this.runningDuration != null;
  }
  
  public boolean hasState() {
    return this.state != null;
  }
  
  public boolean hasSucceeded() {
    return this.succeeded != null;
  }
  
  public boolean hasTaskStatusCount() {
    return this.taskStatusCount != null;
  }
  
  public boolean hasTerminating() {
    return this.terminating != null;
  }
  
  public boolean hasUnknown() {
    return this.unknown != null;
  }
  
  public boolean hasVersion() {
    return this.version != null;
  }
  
  public int hashCode() {
    return Objects.hash(conditions, controlledResources, failed, minAvailable, pending, retryCount, running, runningDuration, state, succeeded, taskStatusCount, terminating, unknown, version, additionalProperties);
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
  
  public A removeFromControlledResources(String key) {
    if (this.controlledResources == null) {
      return (A) this;
    }
    if (key != null && this.controlledResources != null) {
      this.controlledResources.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromControlledResources(Map<String,String> map) {
    if (this.controlledResources == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.controlledResources != null) {
          this.controlledResources.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromTaskStatusCount(String key) {
    if (this.taskStatusCount == null) {
      return (A) this;
    }
    if (key != null && this.taskStatusCount != null) {
      this.taskStatusCount.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromTaskStatusCount(Map<String,TaskState> map) {
    if (this.taskStatusCount == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.taskStatusCount != null) {
          this.taskStatusCount.remove(key);
        }
      }
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
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(controlledResources == null) && !(controlledResources.isEmpty())) {
        sb.append("controlledResources:");
        sb.append(controlledResources);
        sb.append(",");
    }
    if (!(failed == null)) {
        sb.append("failed:");
        sb.append(failed);
        sb.append(",");
    }
    if (!(minAvailable == null)) {
        sb.append("minAvailable:");
        sb.append(minAvailable);
        sb.append(",");
    }
    if (!(pending == null)) {
        sb.append("pending:");
        sb.append(pending);
        sb.append(",");
    }
    if (!(retryCount == null)) {
        sb.append("retryCount:");
        sb.append(retryCount);
        sb.append(",");
    }
    if (!(running == null)) {
        sb.append("running:");
        sb.append(running);
        sb.append(",");
    }
    if (!(runningDuration == null)) {
        sb.append("runningDuration:");
        sb.append(runningDuration);
        sb.append(",");
    }
    if (!(state == null)) {
        sb.append("state:");
        sb.append(state);
        sb.append(",");
    }
    if (!(succeeded == null)) {
        sb.append("succeeded:");
        sb.append(succeeded);
        sb.append(",");
    }
    if (!(taskStatusCount == null) && !(taskStatusCount.isEmpty())) {
        sb.append("taskStatusCount:");
        sb.append(taskStatusCount);
        sb.append(",");
    }
    if (!(terminating == null)) {
        sb.append("terminating:");
        sb.append(terminating);
        sb.append(",");
    }
    if (!(unknown == null)) {
        sb.append("unknown:");
        sb.append(unknown);
        sb.append(",");
    }
    if (!(version == null)) {
        sb.append("version:");
        sb.append(version);
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
  
  public <K,V>A withControlledResources(Map<String,String> controlledResources) {
    if (controlledResources == null) {
      this.controlledResources = null;
    } else {
      this.controlledResources = new LinkedHashMap(controlledResources);
    }
    return (A) this;
  }
  
  public A withFailed(Integer failed) {
    this.failed = failed;
    return (A) this;
  }
  
  public A withMinAvailable(Integer minAvailable) {
    this.minAvailable = minAvailable;
    return (A) this;
  }
  
  public StateNested<A> withNewState() {
    return new StateNested(null);
  }
  
  public A withNewState(String lastTransitionTime,String message,String phase,String reason) {
    return (A) this.withState(new JobState(lastTransitionTime, message, phase, reason));
  }
  
  public StateNested<A> withNewStateLike(JobState item) {
    return new StateNested(item);
  }
  
  public A withPending(Integer pending) {
    this.pending = pending;
    return (A) this;
  }
  
  public A withRetryCount(Integer retryCount) {
    this.retryCount = retryCount;
    return (A) this;
  }
  
  public A withRunning(Integer running) {
    this.running = running;
    return (A) this;
  }
  
  public A withRunningDuration(Duration runningDuration) {
    this.runningDuration = runningDuration;
    return (A) this;
  }
  
  public A withState(JobState state) {
    this._visitables.remove("state");
    if (state != null) {
        this.state = new JobStateBuilder(state);
        this._visitables.get("state").add(this.state);
    } else {
        this.state = null;
        this._visitables.get("state").remove(this.state);
    }
    return (A) this;
  }
  
  public A withSucceeded(Integer succeeded) {
    this.succeeded = succeeded;
    return (A) this;
  }
  
  public <K,V>A withTaskStatusCount(Map<String,TaskState> taskStatusCount) {
    if (taskStatusCount == null) {
      this.taskStatusCount = null;
    } else {
      this.taskStatusCount = new LinkedHashMap(taskStatusCount);
    }
    return (A) this;
  }
  
  public A withTerminating(Integer terminating) {
    this.terminating = terminating;
    return (A) this;
  }
  
  public A withUnknown(Integer unknown) {
    this.unknown = unknown;
    return (A) this;
  }
  
  public A withVersion(Integer version) {
    this.version = version;
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
  public class StateNested<N> extends JobStateFluent<StateNested<N>> implements Nested<N>{
  
    JobStateBuilder builder;
  
    StateNested(JobState item) {
      this.builder = new JobStateBuilder(this, item);
    }
  
    public N and() {
      return (N) JobStatusFluent.this.withState(builder.build());
    }
    
    public N endState() {
      return and();
    }
    
  }
}