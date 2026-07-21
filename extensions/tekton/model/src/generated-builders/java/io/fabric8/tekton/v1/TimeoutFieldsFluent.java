package io.fabric8.tekton.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.model.Duration;
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
public class TimeoutFieldsFluent<A extends io.fabric8.tekton.v1.TimeoutFieldsFluent<A>> extends BaseFluent<A>{

  private Duration _finally;
  private Map<String,Object> additionalProperties;
  private Duration pipeline;
  private Duration tasks;

  public TimeoutFieldsFluent() {
  }
  
  public TimeoutFieldsFluent(TimeoutFields instance) {
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
  
  protected void copyInstance(TimeoutFields instance) {
    instance = instance != null ? instance : new TimeoutFields();
    if (instance != null) {
        this.withFinally(instance.getFinally());
        this.withPipeline(instance.getPipeline());
        this.withTasks(instance.getTasks());
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
    TimeoutFieldsFluent that = (TimeoutFieldsFluent) o;
    if (!(Objects.equals(_finally, that._finally))) {
      return false;
    }
    if (!(Objects.equals(pipeline, that.pipeline))) {
      return false;
    }
    if (!(Objects.equals(tasks, that.tasks))) {
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
  
  public Duration getFinally() {
    return this._finally;
  }
  
  public Duration getPipeline() {
    return this.pipeline;
  }
  
  public Duration getTasks() {
    return this.tasks;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasFinally() {
    return this._finally != null;
  }
  
  public boolean hasPipeline() {
    return this.pipeline != null;
  }
  
  public boolean hasTasks() {
    return this.tasks != null;
  }
  
  public int hashCode() {
    return Objects.hash(_finally, pipeline, tasks, additionalProperties);
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
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(_finally == null)) {
        sb.append("_finally:");
        sb.append(_finally);
        sb.append(",");
    }
    if (!(pipeline == null)) {
        sb.append("pipeline:");
        sb.append(pipeline);
        sb.append(",");
    }
    if (!(tasks == null)) {
        sb.append("tasks:");
        sb.append(tasks);
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
  
  public A withFinally(Duration _finally) {
    this._finally = _finally;
    return (A) this;
  }
  
  public A withPipeline(Duration pipeline) {
    this.pipeline = pipeline;
    return (A) this;
  }
  
  public A withTasks(Duration tasks) {
    this.tasks = tasks;
    return (A) this;
  }
  
}