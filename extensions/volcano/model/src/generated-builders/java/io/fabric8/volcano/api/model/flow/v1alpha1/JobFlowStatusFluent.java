package io.fabric8.volcano.api.model.flow.v1alpha1;

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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class JobFlowStatusFluent<A extends io.fabric8.volcano.api.model.flow.v1alpha1.JobFlowStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> completedJobs = new ArrayList<String>();
  private Map<String,Condition> conditions;
  private List<String> failedJobs = new ArrayList<String>();
  private ArrayList<JobStatusBuilder> jobStatusList = new ArrayList<JobStatusBuilder>();
  private List<String> pendingJobs = new ArrayList<String>();
  private List<String> runningJobs = new ArrayList<String>();
  private StateBuilder state;
  private List<String> terminatedJobs = new ArrayList<String>();
  private List<String> unKnowJobs = new ArrayList<String>();

  public JobFlowStatusFluent() {
  }
  
  public JobFlowStatusFluent(JobFlowStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToCompletedJobs(Collection<String> items) {
    if (this.completedJobs == null) {
      this.completedJobs = new ArrayList();
    }
    for (String item : items) {
      this.completedJobs.add(item);
    }
    return (A) this;
  }
  
  public A addAllToFailedJobs(Collection<String> items) {
    if (this.failedJobs == null) {
      this.failedJobs = new ArrayList();
    }
    for (String item : items) {
      this.failedJobs.add(item);
    }
    return (A) this;
  }
  
  public A addAllToJobStatusList(Collection<JobStatus> items) {
    if (this.jobStatusList == null) {
      this.jobStatusList = new ArrayList();
    }
    for (JobStatus item : items) {
        JobStatusBuilder builder = new JobStatusBuilder(item);
        _visitables.get("jobStatusList").add(builder);
        this.jobStatusList.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToPendingJobs(Collection<String> items) {
    if (this.pendingJobs == null) {
      this.pendingJobs = new ArrayList();
    }
    for (String item : items) {
      this.pendingJobs.add(item);
    }
    return (A) this;
  }
  
  public A addAllToRunningJobs(Collection<String> items) {
    if (this.runningJobs == null) {
      this.runningJobs = new ArrayList();
    }
    for (String item : items) {
      this.runningJobs.add(item);
    }
    return (A) this;
  }
  
  public A addAllToTerminatedJobs(Collection<String> items) {
    if (this.terminatedJobs == null) {
      this.terminatedJobs = new ArrayList();
    }
    for (String item : items) {
      this.terminatedJobs.add(item);
    }
    return (A) this;
  }
  
  public A addAllToUnKnowJobs(Collection<String> items) {
    if (this.unKnowJobs == null) {
      this.unKnowJobs = new ArrayList();
    }
    for (String item : items) {
      this.unKnowJobs.add(item);
    }
    return (A) this;
  }
  
  public JobStatusListNested<A> addNewJobStatusList() {
    return new JobStatusListNested(-1, null);
  }
  
  public JobStatusListNested<A> addNewJobStatusListLike(JobStatus item) {
    return new JobStatusListNested(-1, item);
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
  
  public A addToCompletedJobs(String... items) {
    if (this.completedJobs == null) {
      this.completedJobs = new ArrayList();
    }
    for (String item : items) {
      this.completedJobs.add(item);
    }
    return (A) this;
  }
  
  public A addToCompletedJobs(int index,String item) {
    if (this.completedJobs == null) {
      this.completedJobs = new ArrayList();
    }
    this.completedJobs.add(index, item);
    return (A) this;
  }
  
  public A addToConditions(Map<String,Condition> map) {
    if (this.conditions == null && map != null) {
      this.conditions = new LinkedHashMap();
    }
    if (map != null) {
      this.conditions.putAll(map);
    }
    return (A) this;
  }
  
  public A addToConditions(String key,Condition value) {
    if (this.conditions == null && key != null && value != null) {
      this.conditions = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.conditions.put(key, value);
    }
    return (A) this;
  }
  
  public A addToFailedJobs(String... items) {
    if (this.failedJobs == null) {
      this.failedJobs = new ArrayList();
    }
    for (String item : items) {
      this.failedJobs.add(item);
    }
    return (A) this;
  }
  
  public A addToFailedJobs(int index,String item) {
    if (this.failedJobs == null) {
      this.failedJobs = new ArrayList();
    }
    this.failedJobs.add(index, item);
    return (A) this;
  }
  
  public A addToJobStatusList(JobStatus... items) {
    if (this.jobStatusList == null) {
      this.jobStatusList = new ArrayList();
    }
    for (JobStatus item : items) {
        JobStatusBuilder builder = new JobStatusBuilder(item);
        _visitables.get("jobStatusList").add(builder);
        this.jobStatusList.add(builder);
    }
    return (A) this;
  }
  
  public A addToJobStatusList(int index,JobStatus item) {
    if (this.jobStatusList == null) {
      this.jobStatusList = new ArrayList();
    }
    JobStatusBuilder builder = new JobStatusBuilder(item);
    if (index < 0 || index >= jobStatusList.size()) {
        _visitables.get("jobStatusList").add(builder);
        jobStatusList.add(builder);
    } else {
        _visitables.get("jobStatusList").add(builder);
        jobStatusList.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToPendingJobs(String... items) {
    if (this.pendingJobs == null) {
      this.pendingJobs = new ArrayList();
    }
    for (String item : items) {
      this.pendingJobs.add(item);
    }
    return (A) this;
  }
  
  public A addToPendingJobs(int index,String item) {
    if (this.pendingJobs == null) {
      this.pendingJobs = new ArrayList();
    }
    this.pendingJobs.add(index, item);
    return (A) this;
  }
  
  public A addToRunningJobs(String... items) {
    if (this.runningJobs == null) {
      this.runningJobs = new ArrayList();
    }
    for (String item : items) {
      this.runningJobs.add(item);
    }
    return (A) this;
  }
  
  public A addToRunningJobs(int index,String item) {
    if (this.runningJobs == null) {
      this.runningJobs = new ArrayList();
    }
    this.runningJobs.add(index, item);
    return (A) this;
  }
  
  public A addToTerminatedJobs(String... items) {
    if (this.terminatedJobs == null) {
      this.terminatedJobs = new ArrayList();
    }
    for (String item : items) {
      this.terminatedJobs.add(item);
    }
    return (A) this;
  }
  
  public A addToTerminatedJobs(int index,String item) {
    if (this.terminatedJobs == null) {
      this.terminatedJobs = new ArrayList();
    }
    this.terminatedJobs.add(index, item);
    return (A) this;
  }
  
  public A addToUnKnowJobs(String... items) {
    if (this.unKnowJobs == null) {
      this.unKnowJobs = new ArrayList();
    }
    for (String item : items) {
      this.unKnowJobs.add(item);
    }
    return (A) this;
  }
  
  public A addToUnKnowJobs(int index,String item) {
    if (this.unKnowJobs == null) {
      this.unKnowJobs = new ArrayList();
    }
    this.unKnowJobs.add(index, item);
    return (A) this;
  }
  
  public JobStatus buildFirstJobStatusList() {
    return this.jobStatusList.get(0).build();
  }
  
  public List<JobStatus> buildJobStatusList() {
    return this.jobStatusList != null ? build(jobStatusList) : null;
  }
  
  public JobStatus buildJobStatusList(int index) {
    return this.jobStatusList.get(index).build();
  }
  
  public JobStatus buildLastJobStatusList() {
    return this.jobStatusList.get(jobStatusList.size() - 1).build();
  }
  
  public JobStatus buildMatchingJobStatusList(Predicate<JobStatusBuilder> predicate) {
      for (JobStatusBuilder item : jobStatusList) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public State buildState() {
    return this.state != null ? this.state.build() : null;
  }
  
  protected void copyInstance(JobFlowStatus instance) {
    instance = instance != null ? instance : new JobFlowStatus();
    if (instance != null) {
        this.withCompletedJobs(instance.getCompletedJobs());
        this.withConditions(instance.getConditions());
        this.withFailedJobs(instance.getFailedJobs());
        this.withJobStatusList(instance.getJobStatusList());
        this.withPendingJobs(instance.getPendingJobs());
        this.withRunningJobs(instance.getRunningJobs());
        this.withState(instance.getState());
        this.withTerminatedJobs(instance.getTerminatedJobs());
        this.withUnKnowJobs(instance.getUnKnowJobs());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public JobStatusListNested<A> editFirstJobStatusList() {
    if (jobStatusList.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "jobStatusList"));
    }
    return this.setNewJobStatusListLike(0, this.buildJobStatusList(0));
  }
  
  public JobStatusListNested<A> editJobStatusList(int index) {
    if (jobStatusList.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "jobStatusList"));
    }
    return this.setNewJobStatusListLike(index, this.buildJobStatusList(index));
  }
  
  public JobStatusListNested<A> editLastJobStatusList() {
    int index = jobStatusList.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "jobStatusList"));
    }
    return this.setNewJobStatusListLike(index, this.buildJobStatusList(index));
  }
  
  public JobStatusListNested<A> editMatchingJobStatusList(Predicate<JobStatusBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < jobStatusList.size();i++) {
      if (predicate.test(jobStatusList.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "jobStatusList"));
    }
    return this.setNewJobStatusListLike(index, this.buildJobStatusList(index));
  }
  
  public StateNested<A> editOrNewState() {
    return this.withNewStateLike(Optional.ofNullable(this.buildState()).orElse(new StateBuilder().build()));
  }
  
  public StateNested<A> editOrNewStateLike(State item) {
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
    JobFlowStatusFluent that = (JobFlowStatusFluent) o;
    if (!(Objects.equals(completedJobs, that.completedJobs))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(failedJobs, that.failedJobs))) {
      return false;
    }
    if (!(Objects.equals(jobStatusList, that.jobStatusList))) {
      return false;
    }
    if (!(Objects.equals(pendingJobs, that.pendingJobs))) {
      return false;
    }
    if (!(Objects.equals(runningJobs, that.runningJobs))) {
      return false;
    }
    if (!(Objects.equals(state, that.state))) {
      return false;
    }
    if (!(Objects.equals(terminatedJobs, that.terminatedJobs))) {
      return false;
    }
    if (!(Objects.equals(unKnowJobs, that.unKnowJobs))) {
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
  
  public String getCompletedJob(int index) {
    return this.completedJobs.get(index);
  }
  
  public List<String> getCompletedJobs() {
    return this.completedJobs;
  }
  
  public Map<String,Condition> getConditions() {
    return this.conditions;
  }
  
  public String getFailedJob(int index) {
    return this.failedJobs.get(index);
  }
  
  public List<String> getFailedJobs() {
    return this.failedJobs;
  }
  
  public String getFirstCompletedJob() {
    return this.completedJobs.get(0);
  }
  
  public String getFirstFailedJob() {
    return this.failedJobs.get(0);
  }
  
  public String getFirstPendingJob() {
    return this.pendingJobs.get(0);
  }
  
  public String getFirstRunningJob() {
    return this.runningJobs.get(0);
  }
  
  public String getFirstTerminatedJob() {
    return this.terminatedJobs.get(0);
  }
  
  public String getFirstUnKnowJob() {
    return this.unKnowJobs.get(0);
  }
  
  public String getLastCompletedJob() {
    return this.completedJobs.get(completedJobs.size() - 1);
  }
  
  public String getLastFailedJob() {
    return this.failedJobs.get(failedJobs.size() - 1);
  }
  
  public String getLastPendingJob() {
    return this.pendingJobs.get(pendingJobs.size() - 1);
  }
  
  public String getLastRunningJob() {
    return this.runningJobs.get(runningJobs.size() - 1);
  }
  
  public String getLastTerminatedJob() {
    return this.terminatedJobs.get(terminatedJobs.size() - 1);
  }
  
  public String getLastUnKnowJob() {
    return this.unKnowJobs.get(unKnowJobs.size() - 1);
  }
  
  public String getMatchingCompletedJob(Predicate<String> predicate) {
      for (String item : completedJobs) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingFailedJob(Predicate<String> predicate) {
      for (String item : failedJobs) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingPendingJob(Predicate<String> predicate) {
      for (String item : pendingJobs) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingRunningJob(Predicate<String> predicate) {
      for (String item : runningJobs) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingTerminatedJob(Predicate<String> predicate) {
      for (String item : terminatedJobs) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingUnKnowJob(Predicate<String> predicate) {
      for (String item : unKnowJobs) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getPendingJob(int index) {
    return this.pendingJobs.get(index);
  }
  
  public List<String> getPendingJobs() {
    return this.pendingJobs;
  }
  
  public String getRunningJob(int index) {
    return this.runningJobs.get(index);
  }
  
  public List<String> getRunningJobs() {
    return this.runningJobs;
  }
  
  public String getTerminatedJob(int index) {
    return this.terminatedJobs.get(index);
  }
  
  public List<String> getTerminatedJobs() {
    return this.terminatedJobs;
  }
  
  public String getUnKnowJob(int index) {
    return this.unKnowJobs.get(index);
  }
  
  public List<String> getUnKnowJobs() {
    return this.unKnowJobs;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCompletedJobs() {
    return this.completedJobs != null && !(this.completedJobs.isEmpty());
  }
  
  public boolean hasConditions() {
    return this.conditions != null;
  }
  
  public boolean hasFailedJobs() {
    return this.failedJobs != null && !(this.failedJobs.isEmpty());
  }
  
  public boolean hasJobStatusList() {
    return this.jobStatusList != null && !(this.jobStatusList.isEmpty());
  }
  
  public boolean hasMatchingCompletedJob(Predicate<String> predicate) {
      for (String item : completedJobs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingFailedJob(Predicate<String> predicate) {
      for (String item : failedJobs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingJobStatusList(Predicate<JobStatusBuilder> predicate) {
      for (JobStatusBuilder item : jobStatusList) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingPendingJob(Predicate<String> predicate) {
      for (String item : pendingJobs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingRunningJob(Predicate<String> predicate) {
      for (String item : runningJobs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingTerminatedJob(Predicate<String> predicate) {
      for (String item : terminatedJobs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingUnKnowJob(Predicate<String> predicate) {
      for (String item : unKnowJobs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPendingJobs() {
    return this.pendingJobs != null && !(this.pendingJobs.isEmpty());
  }
  
  public boolean hasRunningJobs() {
    return this.runningJobs != null && !(this.runningJobs.isEmpty());
  }
  
  public boolean hasState() {
    return this.state != null;
  }
  
  public boolean hasTerminatedJobs() {
    return this.terminatedJobs != null && !(this.terminatedJobs.isEmpty());
  }
  
  public boolean hasUnKnowJobs() {
    return this.unKnowJobs != null && !(this.unKnowJobs.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(completedJobs, conditions, failedJobs, jobStatusList, pendingJobs, runningJobs, state, terminatedJobs, unKnowJobs, additionalProperties);
  }
  
  public A removeAllFromCompletedJobs(Collection<String> items) {
    if (this.completedJobs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.completedJobs.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromFailedJobs(Collection<String> items) {
    if (this.failedJobs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.failedJobs.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromJobStatusList(Collection<JobStatus> items) {
    if (this.jobStatusList == null) {
      return (A) this;
    }
    for (JobStatus item : items) {
        JobStatusBuilder builder = new JobStatusBuilder(item);
        _visitables.get("jobStatusList").remove(builder);
        this.jobStatusList.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromPendingJobs(Collection<String> items) {
    if (this.pendingJobs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.pendingJobs.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromRunningJobs(Collection<String> items) {
    if (this.runningJobs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.runningJobs.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromTerminatedJobs(Collection<String> items) {
    if (this.terminatedJobs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.terminatedJobs.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromUnKnowJobs(Collection<String> items) {
    if (this.unKnowJobs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.unKnowJobs.remove(item);
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
  
  public A removeFromCompletedJobs(String... items) {
    if (this.completedJobs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.completedJobs.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromConditions(String key) {
    if (this.conditions == null) {
      return (A) this;
    }
    if (key != null && this.conditions != null) {
      this.conditions.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromConditions(Map<String,Condition> map) {
    if (this.conditions == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.conditions != null) {
          this.conditions.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromFailedJobs(String... items) {
    if (this.failedJobs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.failedJobs.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromJobStatusList(JobStatus... items) {
    if (this.jobStatusList == null) {
      return (A) this;
    }
    for (JobStatus item : items) {
        JobStatusBuilder builder = new JobStatusBuilder(item);
        _visitables.get("jobStatusList").remove(builder);
        this.jobStatusList.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromPendingJobs(String... items) {
    if (this.pendingJobs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.pendingJobs.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromRunningJobs(String... items) {
    if (this.runningJobs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.runningJobs.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromTerminatedJobs(String... items) {
    if (this.terminatedJobs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.terminatedJobs.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromUnKnowJobs(String... items) {
    if (this.unKnowJobs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.unKnowJobs.remove(item);
    }
    return (A) this;
  }
  
  public A removeMatchingFromJobStatusList(Predicate<JobStatusBuilder> predicate) {
    if (jobStatusList == null) {
      return (A) this;
    }
    Iterator<JobStatusBuilder> each = jobStatusList.iterator();
    List visitables = _visitables.get("jobStatusList");
    while (each.hasNext()) {
        JobStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public JobStatusListNested<A> setNewJobStatusListLike(int index,JobStatus item) {
    return new JobStatusListNested(index, item);
  }
  
  public A setToCompletedJobs(int index,String item) {
    if (this.completedJobs == null) {
      this.completedJobs = new ArrayList();
    }
    this.completedJobs.set(index, item);
    return (A) this;
  }
  
  public A setToFailedJobs(int index,String item) {
    if (this.failedJobs == null) {
      this.failedJobs = new ArrayList();
    }
    this.failedJobs.set(index, item);
    return (A) this;
  }
  
  public A setToJobStatusList(int index,JobStatus item) {
    if (this.jobStatusList == null) {
      this.jobStatusList = new ArrayList();
    }
    JobStatusBuilder builder = new JobStatusBuilder(item);
    if (index < 0 || index >= jobStatusList.size()) {
        _visitables.get("jobStatusList").add(builder);
        jobStatusList.add(builder);
    } else {
        _visitables.get("jobStatusList").add(builder);
        jobStatusList.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToPendingJobs(int index,String item) {
    if (this.pendingJobs == null) {
      this.pendingJobs = new ArrayList();
    }
    this.pendingJobs.set(index, item);
    return (A) this;
  }
  
  public A setToRunningJobs(int index,String item) {
    if (this.runningJobs == null) {
      this.runningJobs = new ArrayList();
    }
    this.runningJobs.set(index, item);
    return (A) this;
  }
  
  public A setToTerminatedJobs(int index,String item) {
    if (this.terminatedJobs == null) {
      this.terminatedJobs = new ArrayList();
    }
    this.terminatedJobs.set(index, item);
    return (A) this;
  }
  
  public A setToUnKnowJobs(int index,String item) {
    if (this.unKnowJobs == null) {
      this.unKnowJobs = new ArrayList();
    }
    this.unKnowJobs.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(completedJobs == null) && !(completedJobs.isEmpty())) {
        sb.append("completedJobs:");
        sb.append(completedJobs);
        sb.append(",");
    }
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(failedJobs == null) && !(failedJobs.isEmpty())) {
        sb.append("failedJobs:");
        sb.append(failedJobs);
        sb.append(",");
    }
    if (!(jobStatusList == null) && !(jobStatusList.isEmpty())) {
        sb.append("jobStatusList:");
        sb.append(jobStatusList);
        sb.append(",");
    }
    if (!(pendingJobs == null) && !(pendingJobs.isEmpty())) {
        sb.append("pendingJobs:");
        sb.append(pendingJobs);
        sb.append(",");
    }
    if (!(runningJobs == null) && !(runningJobs.isEmpty())) {
        sb.append("runningJobs:");
        sb.append(runningJobs);
        sb.append(",");
    }
    if (!(state == null)) {
        sb.append("state:");
        sb.append(state);
        sb.append(",");
    }
    if (!(terminatedJobs == null) && !(terminatedJobs.isEmpty())) {
        sb.append("terminatedJobs:");
        sb.append(terminatedJobs);
        sb.append(",");
    }
    if (!(unKnowJobs == null) && !(unKnowJobs.isEmpty())) {
        sb.append("unKnowJobs:");
        sb.append(unKnowJobs);
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
  
  public A withCompletedJobs(List<String> completedJobs) {
    if (completedJobs != null) {
        this.completedJobs = new ArrayList();
        for (String item : completedJobs) {
          this.addToCompletedJobs(item);
        }
    } else {
      this.completedJobs = null;
    }
    return (A) this;
  }
  
  public A withCompletedJobs(String... completedJobs) {
    if (this.completedJobs != null) {
        this.completedJobs.clear();
        _visitables.remove("completedJobs");
    }
    if (completedJobs != null) {
      for (String item : completedJobs) {
        this.addToCompletedJobs(item);
      }
    }
    return (A) this;
  }
  
  public <K,V>A withConditions(Map<String,Condition> conditions) {
    if (conditions == null) {
      this.conditions = null;
    } else {
      this.conditions = new LinkedHashMap(conditions);
    }
    return (A) this;
  }
  
  public A withFailedJobs(List<String> failedJobs) {
    if (failedJobs != null) {
        this.failedJobs = new ArrayList();
        for (String item : failedJobs) {
          this.addToFailedJobs(item);
        }
    } else {
      this.failedJobs = null;
    }
    return (A) this;
  }
  
  public A withFailedJobs(String... failedJobs) {
    if (this.failedJobs != null) {
        this.failedJobs.clear();
        _visitables.remove("failedJobs");
    }
    if (failedJobs != null) {
      for (String item : failedJobs) {
        this.addToFailedJobs(item);
      }
    }
    return (A) this;
  }
  
  public A withJobStatusList(List<JobStatus> jobStatusList) {
    if (this.jobStatusList != null) {
      this._visitables.get("jobStatusList").clear();
    }
    if (jobStatusList != null) {
        this.jobStatusList = new ArrayList();
        for (JobStatus item : jobStatusList) {
          this.addToJobStatusList(item);
        }
    } else {
      this.jobStatusList = null;
    }
    return (A) this;
  }
  
  public A withJobStatusList(JobStatus... jobStatusList) {
    if (this.jobStatusList != null) {
        this.jobStatusList.clear();
        _visitables.remove("jobStatusList");
    }
    if (jobStatusList != null) {
      for (JobStatus item : jobStatusList) {
        this.addToJobStatusList(item);
      }
    }
    return (A) this;
  }
  
  public StateNested<A> withNewState() {
    return new StateNested(null);
  }
  
  public A withNewState(String phase) {
    return (A) this.withState(new State(phase));
  }
  
  public StateNested<A> withNewStateLike(State item) {
    return new StateNested(item);
  }
  
  public A withPendingJobs(List<String> pendingJobs) {
    if (pendingJobs != null) {
        this.pendingJobs = new ArrayList();
        for (String item : pendingJobs) {
          this.addToPendingJobs(item);
        }
    } else {
      this.pendingJobs = null;
    }
    return (A) this;
  }
  
  public A withPendingJobs(String... pendingJobs) {
    if (this.pendingJobs != null) {
        this.pendingJobs.clear();
        _visitables.remove("pendingJobs");
    }
    if (pendingJobs != null) {
      for (String item : pendingJobs) {
        this.addToPendingJobs(item);
      }
    }
    return (A) this;
  }
  
  public A withRunningJobs(List<String> runningJobs) {
    if (runningJobs != null) {
        this.runningJobs = new ArrayList();
        for (String item : runningJobs) {
          this.addToRunningJobs(item);
        }
    } else {
      this.runningJobs = null;
    }
    return (A) this;
  }
  
  public A withRunningJobs(String... runningJobs) {
    if (this.runningJobs != null) {
        this.runningJobs.clear();
        _visitables.remove("runningJobs");
    }
    if (runningJobs != null) {
      for (String item : runningJobs) {
        this.addToRunningJobs(item);
      }
    }
    return (A) this;
  }
  
  public A withState(State state) {
    this._visitables.remove("state");
    if (state != null) {
        this.state = new StateBuilder(state);
        this._visitables.get("state").add(this.state);
    } else {
        this.state = null;
        this._visitables.get("state").remove(this.state);
    }
    return (A) this;
  }
  
  public A withTerminatedJobs(List<String> terminatedJobs) {
    if (terminatedJobs != null) {
        this.terminatedJobs = new ArrayList();
        for (String item : terminatedJobs) {
          this.addToTerminatedJobs(item);
        }
    } else {
      this.terminatedJobs = null;
    }
    return (A) this;
  }
  
  public A withTerminatedJobs(String... terminatedJobs) {
    if (this.terminatedJobs != null) {
        this.terminatedJobs.clear();
        _visitables.remove("terminatedJobs");
    }
    if (terminatedJobs != null) {
      for (String item : terminatedJobs) {
        this.addToTerminatedJobs(item);
      }
    }
    return (A) this;
  }
  
  public A withUnKnowJobs(List<String> unKnowJobs) {
    if (unKnowJobs != null) {
        this.unKnowJobs = new ArrayList();
        for (String item : unKnowJobs) {
          this.addToUnKnowJobs(item);
        }
    } else {
      this.unKnowJobs = null;
    }
    return (A) this;
  }
  
  public A withUnKnowJobs(String... unKnowJobs) {
    if (this.unKnowJobs != null) {
        this.unKnowJobs.clear();
        _visitables.remove("unKnowJobs");
    }
    if (unKnowJobs != null) {
      for (String item : unKnowJobs) {
        this.addToUnKnowJobs(item);
      }
    }
    return (A) this;
  }
  public class JobStatusListNested<N> extends JobStatusFluent<JobStatusListNested<N>> implements Nested<N>{
  
    JobStatusBuilder builder;
    int index;
  
    JobStatusListNested(int index,JobStatus item) {
      this.index = index;
      this.builder = new JobStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) JobFlowStatusFluent.this.setToJobStatusList(index, builder.build());
    }
    
    public N endJobStatusList() {
      return and();
    }
    
  }
  public class StateNested<N> extends StateFluent<StateNested<N>> implements Nested<N>{
  
    StateBuilder builder;
  
    StateNested(State item) {
      this.builder = new StateBuilder(this, item);
    }
  
    public N and() {
      return (N) JobFlowStatusFluent.this.withState(builder.build());
    }
    
    public N endState() {
      return and();
    }
    
  }
}