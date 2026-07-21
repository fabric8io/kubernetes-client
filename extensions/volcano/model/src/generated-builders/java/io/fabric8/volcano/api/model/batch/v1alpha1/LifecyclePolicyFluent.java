package io.fabric8.volcano.api.model.batch.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.model.Duration;
import java.lang.Integer;
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
public class LifecyclePolicyFluent<A extends io.fabric8.volcano.api.model.batch.v1alpha1.LifecyclePolicyFluent<A>> extends BaseFluent<A>{

  private String action;
  private Map<String,Object> additionalProperties;
  private String event;
  private List<String> events = new ArrayList<String>();
  private Integer exitCode;
  private Duration timeout;

  public LifecyclePolicyFluent() {
  }
  
  public LifecyclePolicyFluent(LifecyclePolicy instance) {
    this.copyInstance(instance);
  }

  public A addAllToEvents(Collection<String> items) {
    if (this.events == null) {
      this.events = new ArrayList();
    }
    for (String item : items) {
      this.events.add(item);
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
  
  public A addToEvents(String... items) {
    if (this.events == null) {
      this.events = new ArrayList();
    }
    for (String item : items) {
      this.events.add(item);
    }
    return (A) this;
  }
  
  public A addToEvents(int index,String item) {
    if (this.events == null) {
      this.events = new ArrayList();
    }
    this.events.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(LifecyclePolicy instance) {
    instance = instance != null ? instance : new LifecyclePolicy();
    if (instance != null) {
        this.withAction(instance.getAction());
        this.withEvent(instance.getEvent());
        this.withEvents(instance.getEvents());
        this.withExitCode(instance.getExitCode());
        this.withTimeout(instance.getTimeout());
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
    LifecyclePolicyFluent that = (LifecyclePolicyFluent) o;
    if (!(Objects.equals(action, that.action))) {
      return false;
    }
    if (!(Objects.equals(event, that.event))) {
      return false;
    }
    if (!(Objects.equals(events, that.events))) {
      return false;
    }
    if (!(Objects.equals(exitCode, that.exitCode))) {
      return false;
    }
    if (!(Objects.equals(timeout, that.timeout))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public String getAction() {
    return this.action;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getEvent() {
    return this.event;
  }
  
  public String getEvent(int index) {
    return this.events.get(index);
  }
  
  public List<String> getEvents() {
    return this.events;
  }
  
  public Integer getExitCode() {
    return this.exitCode;
  }
  
  public String getFirstEvent() {
    return this.events.get(0);
  }
  
  public String getLastEvent() {
    return this.events.get(events.size() - 1);
  }
  
  public String getMatchingEvent(Predicate<String> predicate) {
      for (String item : events) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Duration getTimeout() {
    return this.timeout;
  }
  
  public boolean hasAction() {
    return this.action != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasEvent() {
    return this.event != null;
  }
  
  public boolean hasEvents() {
    return this.events != null && !(this.events.isEmpty());
  }
  
  public boolean hasExitCode() {
    return this.exitCode != null;
  }
  
  public boolean hasMatchingEvent(Predicate<String> predicate) {
      for (String item : events) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasTimeout() {
    return this.timeout != null;
  }
  
  public int hashCode() {
    return Objects.hash(action, event, events, exitCode, timeout, additionalProperties);
  }
  
  public A removeAllFromEvents(Collection<String> items) {
    if (this.events == null) {
      return (A) this;
    }
    for (String item : items) {
      this.events.remove(item);
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
  
  public A removeFromEvents(String... items) {
    if (this.events == null) {
      return (A) this;
    }
    for (String item : items) {
      this.events.remove(item);
    }
    return (A) this;
  }
  
  public A setToEvents(int index,String item) {
    if (this.events == null) {
      this.events = new ArrayList();
    }
    this.events.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(action == null)) {
        sb.append("action:");
        sb.append(action);
        sb.append(",");
    }
    if (!(event == null)) {
        sb.append("event:");
        sb.append(event);
        sb.append(",");
    }
    if (!(events == null) && !(events.isEmpty())) {
        sb.append("events:");
        sb.append(events);
        sb.append(",");
    }
    if (!(exitCode == null)) {
        sb.append("exitCode:");
        sb.append(exitCode);
        sb.append(",");
    }
    if (!(timeout == null)) {
        sb.append("timeout:");
        sb.append(timeout);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAction(String action) {
    this.action = action;
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
  
  public A withEvent(String event) {
    this.event = event;
    return (A) this;
  }
  
  public A withEvents(List<String> events) {
    if (events != null) {
        this.events = new ArrayList();
        for (String item : events) {
          this.addToEvents(item);
        }
    } else {
      this.events = null;
    }
    return (A) this;
  }
  
  public A withEvents(String... events) {
    if (this.events != null) {
        this.events.clear();
        _visitables.remove("events");
    }
    if (events != null) {
      for (String item : events) {
        this.addToEvents(item);
      }
    }
    return (A) this;
  }
  
  public A withExitCode(Integer exitCode) {
    this.exitCode = exitCode;
    return (A) this;
  }
  
  public A withTimeout(Duration timeout) {
    this.timeout = timeout;
    return (A) this;
  }
  
}