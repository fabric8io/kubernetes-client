package io.fabric8.volcano.api.model.flow.v1alpha1;

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
public class JobStatusFluent<A extends io.fabric8.volcano.api.model.flow.v1alpha1.JobStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String endTimestamp;
  private String name;
  private Integer restartCount;
  private ArrayList<JobRunningHistoryBuilder> runningHistories = new ArrayList<JobRunningHistoryBuilder>();
  private String startTimestamp;
  private String state;

  public JobStatusFluent() {
  }
  
  public JobStatusFluent(JobStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToRunningHistories(Collection<JobRunningHistory> items) {
    if (this.runningHistories == null) {
      this.runningHistories = new ArrayList();
    }
    for (JobRunningHistory item : items) {
        JobRunningHistoryBuilder builder = new JobRunningHistoryBuilder(item);
        _visitables.get("runningHistories").add(builder);
        this.runningHistories.add(builder);
    }
    return (A) this;
  }
  
  public RunningHistoriesNested<A> addNewRunningHistory() {
    return new RunningHistoriesNested(-1, null);
  }
  
  public A addNewRunningHistory(String endTimestamp,String startTimestamp,String state) {
    return (A) this.addToRunningHistories(new JobRunningHistory(endTimestamp, startTimestamp, state));
  }
  
  public RunningHistoriesNested<A> addNewRunningHistoryLike(JobRunningHistory item) {
    return new RunningHistoriesNested(-1, item);
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
  
  public A addToRunningHistories(JobRunningHistory... items) {
    if (this.runningHistories == null) {
      this.runningHistories = new ArrayList();
    }
    for (JobRunningHistory item : items) {
        JobRunningHistoryBuilder builder = new JobRunningHistoryBuilder(item);
        _visitables.get("runningHistories").add(builder);
        this.runningHistories.add(builder);
    }
    return (A) this;
  }
  
  public A addToRunningHistories(int index,JobRunningHistory item) {
    if (this.runningHistories == null) {
      this.runningHistories = new ArrayList();
    }
    JobRunningHistoryBuilder builder = new JobRunningHistoryBuilder(item);
    if (index < 0 || index >= runningHistories.size()) {
        _visitables.get("runningHistories").add(builder);
        runningHistories.add(builder);
    } else {
        _visitables.get("runningHistories").add(builder);
        runningHistories.add(index, builder);
    }
    return (A) this;
  }
  
  public JobRunningHistory buildFirstRunningHistory() {
    return this.runningHistories.get(0).build();
  }
  
  public JobRunningHistory buildLastRunningHistory() {
    return this.runningHistories.get(runningHistories.size() - 1).build();
  }
  
  public JobRunningHistory buildMatchingRunningHistory(Predicate<JobRunningHistoryBuilder> predicate) {
      for (JobRunningHistoryBuilder item : runningHistories) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public List<JobRunningHistory> buildRunningHistories() {
    return this.runningHistories != null ? build(runningHistories) : null;
  }
  
  public JobRunningHistory buildRunningHistory(int index) {
    return this.runningHistories.get(index).build();
  }
  
  protected void copyInstance(JobStatus instance) {
    instance = instance != null ? instance : new JobStatus();
    if (instance != null) {
        this.withEndTimestamp(instance.getEndTimestamp());
        this.withName(instance.getName());
        this.withRestartCount(instance.getRestartCount());
        this.withRunningHistories(instance.getRunningHistories());
        this.withStartTimestamp(instance.getStartTimestamp());
        this.withState(instance.getState());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RunningHistoriesNested<A> editFirstRunningHistory() {
    if (runningHistories.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "runningHistories"));
    }
    return this.setNewRunningHistoryLike(0, this.buildRunningHistory(0));
  }
  
  public RunningHistoriesNested<A> editLastRunningHistory() {
    int index = runningHistories.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "runningHistories"));
    }
    return this.setNewRunningHistoryLike(index, this.buildRunningHistory(index));
  }
  
  public RunningHistoriesNested<A> editMatchingRunningHistory(Predicate<JobRunningHistoryBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < runningHistories.size();i++) {
      if (predicate.test(runningHistories.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "runningHistories"));
    }
    return this.setNewRunningHistoryLike(index, this.buildRunningHistory(index));
  }
  
  public RunningHistoriesNested<A> editRunningHistory(int index) {
    if (runningHistories.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "runningHistories"));
    }
    return this.setNewRunningHistoryLike(index, this.buildRunningHistory(index));
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
    if (!(Objects.equals(endTimestamp, that.endTimestamp))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(restartCount, that.restartCount))) {
      return false;
    }
    if (!(Objects.equals(runningHistories, that.runningHistories))) {
      return false;
    }
    if (!(Objects.equals(startTimestamp, that.startTimestamp))) {
      return false;
    }
    if (!(Objects.equals(state, that.state))) {
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
  
  public String getEndTimestamp() {
    return this.endTimestamp;
  }
  
  public String getName() {
    return this.name;
  }
  
  public Integer getRestartCount() {
    return this.restartCount;
  }
  
  public String getStartTimestamp() {
    return this.startTimestamp;
  }
  
  public String getState() {
    return this.state;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasEndTimestamp() {
    return this.endTimestamp != null;
  }
  
  public boolean hasMatchingRunningHistory(Predicate<JobRunningHistoryBuilder> predicate) {
      for (JobRunningHistoryBuilder item : runningHistories) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasRestartCount() {
    return this.restartCount != null;
  }
  
  public boolean hasRunningHistories() {
    return this.runningHistories != null && !(this.runningHistories.isEmpty());
  }
  
  public boolean hasStartTimestamp() {
    return this.startTimestamp != null;
  }
  
  public boolean hasState() {
    return this.state != null;
  }
  
  public int hashCode() {
    return Objects.hash(endTimestamp, name, restartCount, runningHistories, startTimestamp, state, additionalProperties);
  }
  
  public A removeAllFromRunningHistories(Collection<JobRunningHistory> items) {
    if (this.runningHistories == null) {
      return (A) this;
    }
    for (JobRunningHistory item : items) {
        JobRunningHistoryBuilder builder = new JobRunningHistoryBuilder(item);
        _visitables.get("runningHistories").remove(builder);
        this.runningHistories.remove(builder);
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
  
  public A removeFromRunningHistories(JobRunningHistory... items) {
    if (this.runningHistories == null) {
      return (A) this;
    }
    for (JobRunningHistory item : items) {
        JobRunningHistoryBuilder builder = new JobRunningHistoryBuilder(item);
        _visitables.get("runningHistories").remove(builder);
        this.runningHistories.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromRunningHistories(Predicate<JobRunningHistoryBuilder> predicate) {
    if (runningHistories == null) {
      return (A) this;
    }
    Iterator<JobRunningHistoryBuilder> each = runningHistories.iterator();
    List visitables = _visitables.get("runningHistories");
    while (each.hasNext()) {
        JobRunningHistoryBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public RunningHistoriesNested<A> setNewRunningHistoryLike(int index,JobRunningHistory item) {
    return new RunningHistoriesNested(index, item);
  }
  
  public A setToRunningHistories(int index,JobRunningHistory item) {
    if (this.runningHistories == null) {
      this.runningHistories = new ArrayList();
    }
    JobRunningHistoryBuilder builder = new JobRunningHistoryBuilder(item);
    if (index < 0 || index >= runningHistories.size()) {
        _visitables.get("runningHistories").add(builder);
        runningHistories.add(builder);
    } else {
        _visitables.get("runningHistories").add(builder);
        runningHistories.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(endTimestamp == null)) {
        sb.append("endTimestamp:");
        sb.append(endTimestamp);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(restartCount == null)) {
        sb.append("restartCount:");
        sb.append(restartCount);
        sb.append(",");
    }
    if (!(runningHistories == null) && !(runningHistories.isEmpty())) {
        sb.append("runningHistories:");
        sb.append(runningHistories);
        sb.append(",");
    }
    if (!(startTimestamp == null)) {
        sb.append("startTimestamp:");
        sb.append(startTimestamp);
        sb.append(",");
    }
    if (!(state == null)) {
        sb.append("state:");
        sb.append(state);
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
  
  public A withEndTimestamp(String endTimestamp) {
    this.endTimestamp = endTimestamp;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withRestartCount(Integer restartCount) {
    this.restartCount = restartCount;
    return (A) this;
  }
  
  public A withRunningHistories(List<JobRunningHistory> runningHistories) {
    if (this.runningHistories != null) {
      this._visitables.get("runningHistories").clear();
    }
    if (runningHistories != null) {
        this.runningHistories = new ArrayList();
        for (JobRunningHistory item : runningHistories) {
          this.addToRunningHistories(item);
        }
    } else {
      this.runningHistories = null;
    }
    return (A) this;
  }
  
  public A withRunningHistories(JobRunningHistory... runningHistories) {
    if (this.runningHistories != null) {
        this.runningHistories.clear();
        _visitables.remove("runningHistories");
    }
    if (runningHistories != null) {
      for (JobRunningHistory item : runningHistories) {
        this.addToRunningHistories(item);
      }
    }
    return (A) this;
  }
  
  public A withStartTimestamp(String startTimestamp) {
    this.startTimestamp = startTimestamp;
    return (A) this;
  }
  
  public A withState(String state) {
    this.state = state;
    return (A) this;
  }
  public class RunningHistoriesNested<N> extends JobRunningHistoryFluent<RunningHistoriesNested<N>> implements Nested<N>{
  
    JobRunningHistoryBuilder builder;
    int index;
  
    RunningHistoriesNested(int index,JobRunningHistory item) {
      this.index = index;
      this.builder = new JobRunningHistoryBuilder(this, item);
    }
  
    public N and() {
      return (N) JobStatusFluent.this.setToRunningHistories(index, builder.build());
    }
    
    public N endRunningHistory() {
      return and();
    }
    
  }
}