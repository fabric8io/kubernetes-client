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
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class JobSpecFluent<A extends io.fabric8.volcano.api.model.batch.v1alpha1.JobSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer maxRetry;
  private Integer minAvailable;
  private Integer minSuccess;
  private Map<String,List<String>> plugins;
  private ArrayList<LifecyclePolicyBuilder> policies = new ArrayList<LifecyclePolicyBuilder>();
  private String priorityClassName;
  private String queue;
  private Duration runningEstimate;
  private String schedulerName;
  private ArrayList<TaskSpecBuilder> tasks = new ArrayList<TaskSpecBuilder>();
  private Integer ttlSecondsAfterFinished;
  private ArrayList<VolumeSpecBuilder> volumes = new ArrayList<VolumeSpecBuilder>();

  public JobSpecFluent() {
  }
  
  public JobSpecFluent(JobSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToPolicies(Collection<LifecyclePolicy> items) {
    if (this.policies == null) {
      this.policies = new ArrayList();
    }
    for (LifecyclePolicy item : items) {
        LifecyclePolicyBuilder builder = new LifecyclePolicyBuilder(item);
        _visitables.get("policies").add(builder);
        this.policies.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToTasks(Collection<TaskSpec> items) {
    if (this.tasks == null) {
      this.tasks = new ArrayList();
    }
    for (TaskSpec item : items) {
        TaskSpecBuilder builder = new TaskSpecBuilder(item);
        _visitables.get("tasks").add(builder);
        this.tasks.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToVolumes(Collection<VolumeSpec> items) {
    if (this.volumes == null) {
      this.volumes = new ArrayList();
    }
    for (VolumeSpec item : items) {
        VolumeSpecBuilder builder = new VolumeSpecBuilder(item);
        _visitables.get("volumes").add(builder);
        this.volumes.add(builder);
    }
    return (A) this;
  }
  
  public PoliciesNested<A> addNewPolicy() {
    return new PoliciesNested(-1, null);
  }
  
  public PoliciesNested<A> addNewPolicyLike(LifecyclePolicy item) {
    return new PoliciesNested(-1, item);
  }
  
  public TasksNested<A> addNewTask() {
    return new TasksNested(-1, null);
  }
  
  public TasksNested<A> addNewTaskLike(TaskSpec item) {
    return new TasksNested(-1, item);
  }
  
  public VolumesNested<A> addNewVolume() {
    return new VolumesNested(-1, null);
  }
  
  public VolumesNested<A> addNewVolumeLike(VolumeSpec item) {
    return new VolumesNested(-1, item);
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
  
  public A addToPlugins(Map<String,List<String>> map) {
    if (this.plugins == null && map != null) {
      this.plugins = new LinkedHashMap();
    }
    if (map != null) {
      this.plugins.putAll(map);
    }
    return (A) this;
  }
  
  public A addToPlugins(String key,List<String> value) {
    if (this.plugins == null && key != null && value != null) {
      this.plugins = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.plugins.put(key, value);
    }
    return (A) this;
  }
  
  public A addToPolicies(LifecyclePolicy... items) {
    if (this.policies == null) {
      this.policies = new ArrayList();
    }
    for (LifecyclePolicy item : items) {
        LifecyclePolicyBuilder builder = new LifecyclePolicyBuilder(item);
        _visitables.get("policies").add(builder);
        this.policies.add(builder);
    }
    return (A) this;
  }
  
  public A addToPolicies(int index,LifecyclePolicy item) {
    if (this.policies == null) {
      this.policies = new ArrayList();
    }
    LifecyclePolicyBuilder builder = new LifecyclePolicyBuilder(item);
    if (index < 0 || index >= policies.size()) {
        _visitables.get("policies").add(builder);
        policies.add(builder);
    } else {
        _visitables.get("policies").add(builder);
        policies.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToTasks(TaskSpec... items) {
    if (this.tasks == null) {
      this.tasks = new ArrayList();
    }
    for (TaskSpec item : items) {
        TaskSpecBuilder builder = new TaskSpecBuilder(item);
        _visitables.get("tasks").add(builder);
        this.tasks.add(builder);
    }
    return (A) this;
  }
  
  public A addToTasks(int index,TaskSpec item) {
    if (this.tasks == null) {
      this.tasks = new ArrayList();
    }
    TaskSpecBuilder builder = new TaskSpecBuilder(item);
    if (index < 0 || index >= tasks.size()) {
        _visitables.get("tasks").add(builder);
        tasks.add(builder);
    } else {
        _visitables.get("tasks").add(builder);
        tasks.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToVolumes(VolumeSpec... items) {
    if (this.volumes == null) {
      this.volumes = new ArrayList();
    }
    for (VolumeSpec item : items) {
        VolumeSpecBuilder builder = new VolumeSpecBuilder(item);
        _visitables.get("volumes").add(builder);
        this.volumes.add(builder);
    }
    return (A) this;
  }
  
  public A addToVolumes(int index,VolumeSpec item) {
    if (this.volumes == null) {
      this.volumes = new ArrayList();
    }
    VolumeSpecBuilder builder = new VolumeSpecBuilder(item);
    if (index < 0 || index >= volumes.size()) {
        _visitables.get("volumes").add(builder);
        volumes.add(builder);
    } else {
        _visitables.get("volumes").add(builder);
        volumes.add(index, builder);
    }
    return (A) this;
  }
  
  public LifecyclePolicy buildFirstPolicy() {
    return this.policies.get(0).build();
  }
  
  public TaskSpec buildFirstTask() {
    return this.tasks.get(0).build();
  }
  
  public VolumeSpec buildFirstVolume() {
    return this.volumes.get(0).build();
  }
  
  public LifecyclePolicy buildLastPolicy() {
    return this.policies.get(policies.size() - 1).build();
  }
  
  public TaskSpec buildLastTask() {
    return this.tasks.get(tasks.size() - 1).build();
  }
  
  public VolumeSpec buildLastVolume() {
    return this.volumes.get(volumes.size() - 1).build();
  }
  
  public LifecyclePolicy buildMatchingPolicy(Predicate<LifecyclePolicyBuilder> predicate) {
      for (LifecyclePolicyBuilder item : policies) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public TaskSpec buildMatchingTask(Predicate<TaskSpecBuilder> predicate) {
      for (TaskSpecBuilder item : tasks) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public VolumeSpec buildMatchingVolume(Predicate<VolumeSpecBuilder> predicate) {
      for (VolumeSpecBuilder item : volumes) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public List<LifecyclePolicy> buildPolicies() {
    return this.policies != null ? build(policies) : null;
  }
  
  public LifecyclePolicy buildPolicy(int index) {
    return this.policies.get(index).build();
  }
  
  public TaskSpec buildTask(int index) {
    return this.tasks.get(index).build();
  }
  
  public List<TaskSpec> buildTasks() {
    return this.tasks != null ? build(tasks) : null;
  }
  
  public VolumeSpec buildVolume(int index) {
    return this.volumes.get(index).build();
  }
  
  public List<VolumeSpec> buildVolumes() {
    return this.volumes != null ? build(volumes) : null;
  }
  
  protected void copyInstance(JobSpec instance) {
    instance = instance != null ? instance : new JobSpec();
    if (instance != null) {
        this.withMaxRetry(instance.getMaxRetry());
        this.withMinAvailable(instance.getMinAvailable());
        this.withMinSuccess(instance.getMinSuccess());
        this.withPlugins(instance.getPlugins());
        this.withPolicies(instance.getPolicies());
        this.withPriorityClassName(instance.getPriorityClassName());
        this.withQueue(instance.getQueue());
        this.withRunningEstimate(instance.getRunningEstimate());
        this.withSchedulerName(instance.getSchedulerName());
        this.withTasks(instance.getTasks());
        this.withTtlSecondsAfterFinished(instance.getTtlSecondsAfterFinished());
        this.withVolumes(instance.getVolumes());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PoliciesNested<A> editFirstPolicy() {
    if (policies.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "policies"));
    }
    return this.setNewPolicyLike(0, this.buildPolicy(0));
  }
  
  public TasksNested<A> editFirstTask() {
    if (tasks.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "tasks"));
    }
    return this.setNewTaskLike(0, this.buildTask(0));
  }
  
  public VolumesNested<A> editFirstVolume() {
    if (volumes.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "volumes"));
    }
    return this.setNewVolumeLike(0, this.buildVolume(0));
  }
  
  public PoliciesNested<A> editLastPolicy() {
    int index = policies.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "policies"));
    }
    return this.setNewPolicyLike(index, this.buildPolicy(index));
  }
  
  public TasksNested<A> editLastTask() {
    int index = tasks.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "tasks"));
    }
    return this.setNewTaskLike(index, this.buildTask(index));
  }
  
  public VolumesNested<A> editLastVolume() {
    int index = volumes.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "volumes"));
    }
    return this.setNewVolumeLike(index, this.buildVolume(index));
  }
  
  public PoliciesNested<A> editMatchingPolicy(Predicate<LifecyclePolicyBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < policies.size();i++) {
      if (predicate.test(policies.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "policies"));
    }
    return this.setNewPolicyLike(index, this.buildPolicy(index));
  }
  
  public TasksNested<A> editMatchingTask(Predicate<TaskSpecBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < tasks.size();i++) {
      if (predicate.test(tasks.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "tasks"));
    }
    return this.setNewTaskLike(index, this.buildTask(index));
  }
  
  public VolumesNested<A> editMatchingVolume(Predicate<VolumeSpecBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < volumes.size();i++) {
      if (predicate.test(volumes.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "volumes"));
    }
    return this.setNewVolumeLike(index, this.buildVolume(index));
  }
  
  public PoliciesNested<A> editPolicy(int index) {
    if (policies.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "policies"));
    }
    return this.setNewPolicyLike(index, this.buildPolicy(index));
  }
  
  public TasksNested<A> editTask(int index) {
    if (tasks.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "tasks"));
    }
    return this.setNewTaskLike(index, this.buildTask(index));
  }
  
  public VolumesNested<A> editVolume(int index) {
    if (volumes.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "volumes"));
    }
    return this.setNewVolumeLike(index, this.buildVolume(index));
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
    JobSpecFluent that = (JobSpecFluent) o;
    if (!(Objects.equals(maxRetry, that.maxRetry))) {
      return false;
    }
    if (!(Objects.equals(minAvailable, that.minAvailable))) {
      return false;
    }
    if (!(Objects.equals(minSuccess, that.minSuccess))) {
      return false;
    }
    if (!(Objects.equals(plugins, that.plugins))) {
      return false;
    }
    if (!(Objects.equals(policies, that.policies))) {
      return false;
    }
    if (!(Objects.equals(priorityClassName, that.priorityClassName))) {
      return false;
    }
    if (!(Objects.equals(queue, that.queue))) {
      return false;
    }
    if (!(Objects.equals(runningEstimate, that.runningEstimate))) {
      return false;
    }
    if (!(Objects.equals(schedulerName, that.schedulerName))) {
      return false;
    }
    if (!(Objects.equals(tasks, that.tasks))) {
      return false;
    }
    if (!(Objects.equals(ttlSecondsAfterFinished, that.ttlSecondsAfterFinished))) {
      return false;
    }
    if (!(Objects.equals(volumes, that.volumes))) {
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
  
  public Integer getMaxRetry() {
    return this.maxRetry;
  }
  
  public Integer getMinAvailable() {
    return this.minAvailable;
  }
  
  public Integer getMinSuccess() {
    return this.minSuccess;
  }
  
  public Map<String,List<String>> getPlugins() {
    return this.plugins;
  }
  
  public String getPriorityClassName() {
    return this.priorityClassName;
  }
  
  public String getQueue() {
    return this.queue;
  }
  
  public Duration getRunningEstimate() {
    return this.runningEstimate;
  }
  
  public String getSchedulerName() {
    return this.schedulerName;
  }
  
  public Integer getTtlSecondsAfterFinished() {
    return this.ttlSecondsAfterFinished;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingPolicy(Predicate<LifecyclePolicyBuilder> predicate) {
      for (LifecyclePolicyBuilder item : policies) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingTask(Predicate<TaskSpecBuilder> predicate) {
      for (TaskSpecBuilder item : tasks) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingVolume(Predicate<VolumeSpecBuilder> predicate) {
      for (VolumeSpecBuilder item : volumes) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMaxRetry() {
    return this.maxRetry != null;
  }
  
  public boolean hasMinAvailable() {
    return this.minAvailable != null;
  }
  
  public boolean hasMinSuccess() {
    return this.minSuccess != null;
  }
  
  public boolean hasPlugins() {
    return this.plugins != null;
  }
  
  public boolean hasPolicies() {
    return this.policies != null && !(this.policies.isEmpty());
  }
  
  public boolean hasPriorityClassName() {
    return this.priorityClassName != null;
  }
  
  public boolean hasQueue() {
    return this.queue != null;
  }
  
  public boolean hasRunningEstimate() {
    return this.runningEstimate != null;
  }
  
  public boolean hasSchedulerName() {
    return this.schedulerName != null;
  }
  
  public boolean hasTasks() {
    return this.tasks != null && !(this.tasks.isEmpty());
  }
  
  public boolean hasTtlSecondsAfterFinished() {
    return this.ttlSecondsAfterFinished != null;
  }
  
  public boolean hasVolumes() {
    return this.volumes != null && !(this.volumes.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(maxRetry, minAvailable, minSuccess, plugins, policies, priorityClassName, queue, runningEstimate, schedulerName, tasks, ttlSecondsAfterFinished, volumes, additionalProperties);
  }
  
  public A removeAllFromPolicies(Collection<LifecyclePolicy> items) {
    if (this.policies == null) {
      return (A) this;
    }
    for (LifecyclePolicy item : items) {
        LifecyclePolicyBuilder builder = new LifecyclePolicyBuilder(item);
        _visitables.get("policies").remove(builder);
        this.policies.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromTasks(Collection<TaskSpec> items) {
    if (this.tasks == null) {
      return (A) this;
    }
    for (TaskSpec item : items) {
        TaskSpecBuilder builder = new TaskSpecBuilder(item);
        _visitables.get("tasks").remove(builder);
        this.tasks.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromVolumes(Collection<VolumeSpec> items) {
    if (this.volumes == null) {
      return (A) this;
    }
    for (VolumeSpec item : items) {
        VolumeSpecBuilder builder = new VolumeSpecBuilder(item);
        _visitables.get("volumes").remove(builder);
        this.volumes.remove(builder);
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
  
  public A removeFromPlugins(String key) {
    if (this.plugins == null) {
      return (A) this;
    }
    if (key != null && this.plugins != null) {
      this.plugins.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromPlugins(Map<String,List<String>> map) {
    if (this.plugins == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.plugins != null) {
          this.plugins.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromPolicies(LifecyclePolicy... items) {
    if (this.policies == null) {
      return (A) this;
    }
    for (LifecyclePolicy item : items) {
        LifecyclePolicyBuilder builder = new LifecyclePolicyBuilder(item);
        _visitables.get("policies").remove(builder);
        this.policies.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromTasks(TaskSpec... items) {
    if (this.tasks == null) {
      return (A) this;
    }
    for (TaskSpec item : items) {
        TaskSpecBuilder builder = new TaskSpecBuilder(item);
        _visitables.get("tasks").remove(builder);
        this.tasks.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromVolumes(VolumeSpec... items) {
    if (this.volumes == null) {
      return (A) this;
    }
    for (VolumeSpec item : items) {
        VolumeSpecBuilder builder = new VolumeSpecBuilder(item);
        _visitables.get("volumes").remove(builder);
        this.volumes.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromPolicies(Predicate<LifecyclePolicyBuilder> predicate) {
    if (policies == null) {
      return (A) this;
    }
    Iterator<LifecyclePolicyBuilder> each = policies.iterator();
    List visitables = _visitables.get("policies");
    while (each.hasNext()) {
        LifecyclePolicyBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromTasks(Predicate<TaskSpecBuilder> predicate) {
    if (tasks == null) {
      return (A) this;
    }
    Iterator<TaskSpecBuilder> each = tasks.iterator();
    List visitables = _visitables.get("tasks");
    while (each.hasNext()) {
        TaskSpecBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromVolumes(Predicate<VolumeSpecBuilder> predicate) {
    if (volumes == null) {
      return (A) this;
    }
    Iterator<VolumeSpecBuilder> each = volumes.iterator();
    List visitables = _visitables.get("volumes");
    while (each.hasNext()) {
        VolumeSpecBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public PoliciesNested<A> setNewPolicyLike(int index,LifecyclePolicy item) {
    return new PoliciesNested(index, item);
  }
  
  public TasksNested<A> setNewTaskLike(int index,TaskSpec item) {
    return new TasksNested(index, item);
  }
  
  public VolumesNested<A> setNewVolumeLike(int index,VolumeSpec item) {
    return new VolumesNested(index, item);
  }
  
  public A setToPolicies(int index,LifecyclePolicy item) {
    if (this.policies == null) {
      this.policies = new ArrayList();
    }
    LifecyclePolicyBuilder builder = new LifecyclePolicyBuilder(item);
    if (index < 0 || index >= policies.size()) {
        _visitables.get("policies").add(builder);
        policies.add(builder);
    } else {
        _visitables.get("policies").add(builder);
        policies.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToTasks(int index,TaskSpec item) {
    if (this.tasks == null) {
      this.tasks = new ArrayList();
    }
    TaskSpecBuilder builder = new TaskSpecBuilder(item);
    if (index < 0 || index >= tasks.size()) {
        _visitables.get("tasks").add(builder);
        tasks.add(builder);
    } else {
        _visitables.get("tasks").add(builder);
        tasks.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToVolumes(int index,VolumeSpec item) {
    if (this.volumes == null) {
      this.volumes = new ArrayList();
    }
    VolumeSpecBuilder builder = new VolumeSpecBuilder(item);
    if (index < 0 || index >= volumes.size()) {
        _visitables.get("volumes").add(builder);
        volumes.add(builder);
    } else {
        _visitables.get("volumes").add(builder);
        volumes.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(maxRetry == null)) {
        sb.append("maxRetry:");
        sb.append(maxRetry);
        sb.append(",");
    }
    if (!(minAvailable == null)) {
        sb.append("minAvailable:");
        sb.append(minAvailable);
        sb.append(",");
    }
    if (!(minSuccess == null)) {
        sb.append("minSuccess:");
        sb.append(minSuccess);
        sb.append(",");
    }
    if (!(plugins == null) && !(plugins.isEmpty())) {
        sb.append("plugins:");
        sb.append(plugins);
        sb.append(",");
    }
    if (!(policies == null) && !(policies.isEmpty())) {
        sb.append("policies:");
        sb.append(policies);
        sb.append(",");
    }
    if (!(priorityClassName == null)) {
        sb.append("priorityClassName:");
        sb.append(priorityClassName);
        sb.append(",");
    }
    if (!(queue == null)) {
        sb.append("queue:");
        sb.append(queue);
        sb.append(",");
    }
    if (!(runningEstimate == null)) {
        sb.append("runningEstimate:");
        sb.append(runningEstimate);
        sb.append(",");
    }
    if (!(schedulerName == null)) {
        sb.append("schedulerName:");
        sb.append(schedulerName);
        sb.append(",");
    }
    if (!(tasks == null) && !(tasks.isEmpty())) {
        sb.append("tasks:");
        sb.append(tasks);
        sb.append(",");
    }
    if (!(ttlSecondsAfterFinished == null)) {
        sb.append("ttlSecondsAfterFinished:");
        sb.append(ttlSecondsAfterFinished);
        sb.append(",");
    }
    if (!(volumes == null) && !(volumes.isEmpty())) {
        sb.append("volumes:");
        sb.append(volumes);
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
  
  public A withMaxRetry(Integer maxRetry) {
    this.maxRetry = maxRetry;
    return (A) this;
  }
  
  public A withMinAvailable(Integer minAvailable) {
    this.minAvailable = minAvailable;
    return (A) this;
  }
  
  public A withMinSuccess(Integer minSuccess) {
    this.minSuccess = minSuccess;
    return (A) this;
  }
  
  public <K,V>A withPlugins(Map<String,List<String>> plugins) {
    if (plugins == null) {
      this.plugins = null;
    } else {
      this.plugins = new LinkedHashMap(plugins);
    }
    return (A) this;
  }
  
  public A withPolicies(List<LifecyclePolicy> policies) {
    if (this.policies != null) {
      this._visitables.get("policies").clear();
    }
    if (policies != null) {
        this.policies = new ArrayList();
        for (LifecyclePolicy item : policies) {
          this.addToPolicies(item);
        }
    } else {
      this.policies = null;
    }
    return (A) this;
  }
  
  public A withPolicies(LifecyclePolicy... policies) {
    if (this.policies != null) {
        this.policies.clear();
        _visitables.remove("policies");
    }
    if (policies != null) {
      for (LifecyclePolicy item : policies) {
        this.addToPolicies(item);
      }
    }
    return (A) this;
  }
  
  public A withPriorityClassName(String priorityClassName) {
    this.priorityClassName = priorityClassName;
    return (A) this;
  }
  
  public A withQueue(String queue) {
    this.queue = queue;
    return (A) this;
  }
  
  public A withRunningEstimate(Duration runningEstimate) {
    this.runningEstimate = runningEstimate;
    return (A) this;
  }
  
  public A withSchedulerName(String schedulerName) {
    this.schedulerName = schedulerName;
    return (A) this;
  }
  
  public A withTasks(List<TaskSpec> tasks) {
    if (this.tasks != null) {
      this._visitables.get("tasks").clear();
    }
    if (tasks != null) {
        this.tasks = new ArrayList();
        for (TaskSpec item : tasks) {
          this.addToTasks(item);
        }
    } else {
      this.tasks = null;
    }
    return (A) this;
  }
  
  public A withTasks(TaskSpec... tasks) {
    if (this.tasks != null) {
        this.tasks.clear();
        _visitables.remove("tasks");
    }
    if (tasks != null) {
      for (TaskSpec item : tasks) {
        this.addToTasks(item);
      }
    }
    return (A) this;
  }
  
  public A withTtlSecondsAfterFinished(Integer ttlSecondsAfterFinished) {
    this.ttlSecondsAfterFinished = ttlSecondsAfterFinished;
    return (A) this;
  }
  
  public A withVolumes(List<VolumeSpec> volumes) {
    if (this.volumes != null) {
      this._visitables.get("volumes").clear();
    }
    if (volumes != null) {
        this.volumes = new ArrayList();
        for (VolumeSpec item : volumes) {
          this.addToVolumes(item);
        }
    } else {
      this.volumes = null;
    }
    return (A) this;
  }
  
  public A withVolumes(VolumeSpec... volumes) {
    if (this.volumes != null) {
        this.volumes.clear();
        _visitables.remove("volumes");
    }
    if (volumes != null) {
      for (VolumeSpec item : volumes) {
        this.addToVolumes(item);
      }
    }
    return (A) this;
  }
  public class PoliciesNested<N> extends LifecyclePolicyFluent<PoliciesNested<N>> implements Nested<N>{
  
    LifecyclePolicyBuilder builder;
    int index;
  
    PoliciesNested(int index,LifecyclePolicy item) {
      this.index = index;
      this.builder = new LifecyclePolicyBuilder(this, item);
    }
  
    public N and() {
      return (N) JobSpecFluent.this.setToPolicies(index, builder.build());
    }
    
    public N endPolicy() {
      return and();
    }
    
  }
  public class TasksNested<N> extends TaskSpecFluent<TasksNested<N>> implements Nested<N>{
  
    TaskSpecBuilder builder;
    int index;
  
    TasksNested(int index,TaskSpec item) {
      this.index = index;
      this.builder = new TaskSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) JobSpecFluent.this.setToTasks(index, builder.build());
    }
    
    public N endTask() {
      return and();
    }
    
  }
  public class VolumesNested<N> extends VolumeSpecFluent<VolumesNested<N>> implements Nested<N>{
  
    VolumeSpecBuilder builder;
    int index;
  
    VolumesNested(int index,VolumeSpec item) {
      this.index = index;
      this.builder = new VolumeSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) JobSpecFluent.this.setToVolumes(index, builder.build());
    }
    
    public N endVolume() {
      return and();
    }
    
  }
}