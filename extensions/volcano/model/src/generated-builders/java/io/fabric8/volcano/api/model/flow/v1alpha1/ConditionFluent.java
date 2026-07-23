package io.fabric8.volcano.api.model.flow.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.model.Duration;
import io.fabric8.volcano.api.model.batch.v1alpha1.TaskState;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ConditionFluent<A extends io.fabric8.volcano.api.model.flow.v1alpha1.ConditionFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String createTime;
  private String phase;
  private Duration runningDuration;
  private Map<String,TaskState> taskStatusCount;

  public ConditionFluent() {
  }
  
  public ConditionFluent(Condition instance) {
    this.copyInstance(instance);
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
  
  protected void copyInstance(Condition instance) {
    instance = instance != null ? instance : new Condition();
    if (instance != null) {
        this.withCreateTime(instance.getCreateTime());
        this.withPhase(instance.getPhase());
        this.withRunningDuration(instance.getRunningDuration());
        this.withTaskStatusCount(instance.getTaskStatusCount());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
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
    ConditionFluent that = (ConditionFluent) o;
    if (!(Objects.equals(createTime, that.createTime))) {
      return false;
    }
    if (!(Objects.equals(phase, that.phase))) {
      return false;
    }
    if (!(Objects.equals(runningDuration, that.runningDuration))) {
      return false;
    }
    if (!(Objects.equals(taskStatusCount, that.taskStatusCount))) {
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
  
  public String getCreateTime() {
    return this.createTime;
  }
  
  public String getPhase() {
    return this.phase;
  }
  
  public Duration getRunningDuration() {
    return this.runningDuration;
  }
  
  public Map<String,TaskState> getTaskStatusCount() {
    return this.taskStatusCount;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCreateTime() {
    return this.createTime != null;
  }
  
  public boolean hasPhase() {
    return this.phase != null;
  }
  
  public boolean hasRunningDuration() {
    return this.runningDuration != null;
  }
  
  public boolean hasTaskStatusCount() {
    return this.taskStatusCount != null;
  }
  
  public int hashCode() {
    return Objects.hash(createTime, phase, runningDuration, taskStatusCount, additionalProperties);
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
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(createTime == null)) {
        sb.append("createTime:");
        sb.append(createTime);
        sb.append(",");
    }
    if (!(phase == null)) {
        sb.append("phase:");
        sb.append(phase);
        sb.append(",");
    }
    if (!(runningDuration == null)) {
        sb.append("runningDuration:");
        sb.append(runningDuration);
        sb.append(",");
    }
    if (!(taskStatusCount == null) && !(taskStatusCount.isEmpty())) {
        sb.append("taskStatusCount:");
        sb.append(taskStatusCount);
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
  
  public A withCreateTime(String createTime) {
    this.createTime = createTime;
    return (A) this;
  }
  
  public A withPhase(String phase) {
    this.phase = phase;
    return (A) this;
  }
  
  public A withRunningDuration(Duration runningDuration) {
    this.runningDuration = runningDuration;
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
  
}