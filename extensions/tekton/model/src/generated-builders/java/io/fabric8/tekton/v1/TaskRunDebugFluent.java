package io.fabric8.tekton.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class TaskRunDebugFluent<A extends io.fabric8.tekton.v1.TaskRunDebugFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private TaskBreakpointsBuilder breakpoints;

  public TaskRunDebugFluent() {
  }
  
  public TaskRunDebugFluent(TaskRunDebug instance) {
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
  
  public TaskBreakpoints buildBreakpoints() {
    return this.breakpoints != null ? this.breakpoints.build() : null;
  }
  
  protected void copyInstance(TaskRunDebug instance) {
    instance = instance != null ? instance : new TaskRunDebug();
    if (instance != null) {
        this.withBreakpoints(instance.getBreakpoints());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public BreakpointsNested<A> editBreakpoints() {
    return this.withNewBreakpointsLike(Optional.ofNullable(this.buildBreakpoints()).orElse(null));
  }
  
  public BreakpointsNested<A> editOrNewBreakpoints() {
    return this.withNewBreakpointsLike(Optional.ofNullable(this.buildBreakpoints()).orElse(new TaskBreakpointsBuilder().build()));
  }
  
  public BreakpointsNested<A> editOrNewBreakpointsLike(TaskBreakpoints item) {
    return this.withNewBreakpointsLike(Optional.ofNullable(this.buildBreakpoints()).orElse(item));
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
    TaskRunDebugFluent that = (TaskRunDebugFluent) o;
    if (!(Objects.equals(breakpoints, that.breakpoints))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBreakpoints() {
    return this.breakpoints != null;
  }
  
  public int hashCode() {
    return Objects.hash(breakpoints, additionalProperties);
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
    if (!(breakpoints == null)) {
        sb.append("breakpoints:");
        sb.append(breakpoints);
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
  
  public A withBreakpoints(TaskBreakpoints breakpoints) {
    this._visitables.remove("breakpoints");
    if (breakpoints != null) {
        this.breakpoints = new TaskBreakpointsBuilder(breakpoints);
        this._visitables.get("breakpoints").add(this.breakpoints);
    } else {
        this.breakpoints = null;
        this._visitables.get("breakpoints").remove(this.breakpoints);
    }
    return (A) this;
  }
  
  public BreakpointsNested<A> withNewBreakpoints() {
    return new BreakpointsNested(null);
  }
  
  public BreakpointsNested<A> withNewBreakpointsLike(TaskBreakpoints item) {
    return new BreakpointsNested(item);
  }
  public class BreakpointsNested<N> extends TaskBreakpointsFluent<BreakpointsNested<N>> implements Nested<N>{
  
    TaskBreakpointsBuilder builder;
  
    BreakpointsNested(TaskBreakpoints item) {
      this.builder = new TaskBreakpointsBuilder(this, item);
    }
  
    public N and() {
      return (N) TaskRunDebugFluent.this.withBreakpoints(builder.build());
    }
    
    public N endBreakpoints() {
      return and();
    }
    
  }
}