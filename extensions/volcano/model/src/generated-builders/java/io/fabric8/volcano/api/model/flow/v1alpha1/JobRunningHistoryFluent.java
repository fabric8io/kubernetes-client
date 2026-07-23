package io.fabric8.volcano.api.model.flow.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
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
public class JobRunningHistoryFluent<A extends io.fabric8.volcano.api.model.flow.v1alpha1.JobRunningHistoryFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String endTimestamp;
  private String startTimestamp;
  private String state;

  public JobRunningHistoryFluent() {
  }
  
  public JobRunningHistoryFluent(JobRunningHistory instance) {
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
  
  protected void copyInstance(JobRunningHistory instance) {
    instance = instance != null ? instance : new JobRunningHistory();
    if (instance != null) {
        this.withEndTimestamp(instance.getEndTimestamp());
        this.withStartTimestamp(instance.getStartTimestamp());
        this.withState(instance.getState());
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
    JobRunningHistoryFluent that = (JobRunningHistoryFluent) o;
    if (!(Objects.equals(endTimestamp, that.endTimestamp))) {
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
  
  public boolean hasStartTimestamp() {
    return this.startTimestamp != null;
  }
  
  public boolean hasState() {
    return this.state != null;
  }
  
  public int hashCode() {
    return Objects.hash(endTimestamp, startTimestamp, state, additionalProperties);
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
    if (!(endTimestamp == null)) {
        sb.append("endTimestamp:");
        sb.append(endTimestamp);
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
  
  public A withStartTimestamp(String startTimestamp) {
    this.startTimestamp = startTimestamp;
    return (A) this;
  }
  
  public A withState(String state) {
    this.state = state;
    return (A) this;
  }
  
}