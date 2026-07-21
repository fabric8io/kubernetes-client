package io.fabric8.tekton.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class TaskBreakpointsFluent<A extends io.fabric8.tekton.v1.TaskBreakpointsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> beforeSteps = new ArrayList<String>();
  private String onFailure;

  public TaskBreakpointsFluent() {
  }
  
  public TaskBreakpointsFluent(TaskBreakpoints instance) {
    this.copyInstance(instance);
  }

  public A addAllToBeforeSteps(Collection<String> items) {
    if (this.beforeSteps == null) {
      this.beforeSteps = new ArrayList();
    }
    for (String item : items) {
      this.beforeSteps.add(item);
    }
    return (A) this;
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
  
  public A addToBeforeSteps(String... items) {
    if (this.beforeSteps == null) {
      this.beforeSteps = new ArrayList();
    }
    for (String item : items) {
      this.beforeSteps.add(item);
    }
    return (A) this;
  }
  
  public A addToBeforeSteps(int index,String item) {
    if (this.beforeSteps == null) {
      this.beforeSteps = new ArrayList();
    }
    this.beforeSteps.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(TaskBreakpoints instance) {
    instance = instance != null ? instance : new TaskBreakpoints();
    if (instance != null) {
        this.withBeforeSteps(instance.getBeforeSteps());
        this.withOnFailure(instance.getOnFailure());
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
    TaskBreakpointsFluent that = (TaskBreakpointsFluent) o;
    if (!(Objects.equals(beforeSteps, that.beforeSteps))) {
      return false;
    }
    if (!(Objects.equals(onFailure, that.onFailure))) {
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
  
  public String getBeforeStep(int index) {
    return this.beforeSteps.get(index);
  }
  
  public List<String> getBeforeSteps() {
    return this.beforeSteps;
  }
  
  public String getFirstBeforeStep() {
    return this.beforeSteps.get(0);
  }
  
  public String getLastBeforeStep() {
    return this.beforeSteps.get(beforeSteps.size() - 1);
  }
  
  public String getMatchingBeforeStep(Predicate<String> predicate) {
      for (String item : beforeSteps) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getOnFailure() {
    return this.onFailure;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBeforeSteps() {
    return this.beforeSteps != null && !(this.beforeSteps.isEmpty());
  }
  
  public boolean hasMatchingBeforeStep(Predicate<String> predicate) {
      for (String item : beforeSteps) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasOnFailure() {
    return this.onFailure != null;
  }
  
  public int hashCode() {
    return Objects.hash(beforeSteps, onFailure, additionalProperties);
  }
  
  public A removeAllFromBeforeSteps(Collection<String> items) {
    if (this.beforeSteps == null) {
      return (A) this;
    }
    for (String item : items) {
      this.beforeSteps.remove(item);
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
  
  public A removeFromBeforeSteps(String... items) {
    if (this.beforeSteps == null) {
      return (A) this;
    }
    for (String item : items) {
      this.beforeSteps.remove(item);
    }
    return (A) this;
  }
  
  public A setToBeforeSteps(int index,String item) {
    if (this.beforeSteps == null) {
      this.beforeSteps = new ArrayList();
    }
    this.beforeSteps.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(beforeSteps == null) && !(beforeSteps.isEmpty())) {
        sb.append("beforeSteps:");
        sb.append(beforeSteps);
        sb.append(",");
    }
    if (!(onFailure == null)) {
        sb.append("onFailure:");
        sb.append(onFailure);
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
  
  public A withBeforeSteps(List<String> beforeSteps) {
    if (beforeSteps != null) {
        this.beforeSteps = new ArrayList();
        for (String item : beforeSteps) {
          this.addToBeforeSteps(item);
        }
    } else {
      this.beforeSteps = null;
    }
    return (A) this;
  }
  
  public A withBeforeSteps(String... beforeSteps) {
    if (this.beforeSteps != null) {
        this.beforeSteps.clear();
        _visitables.remove("beforeSteps");
    }
    if (beforeSteps != null) {
      for (String item : beforeSteps) {
        this.addToBeforeSteps(item);
      }
    }
    return (A) this;
  }
  
  public A withOnFailure(String onFailure) {
    this.onFailure = onFailure;
    return (A) this;
  }
  
}