package io.fabric8.kubernetes.api.model.discovery.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Boolean;
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
public class EndpointConditionsFluent<A extends io.fabric8.kubernetes.api.model.discovery.v1.EndpointConditionsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean ready;
  private Boolean serving;
  private Boolean terminating;

  public EndpointConditionsFluent() {
  }
  
  public EndpointConditionsFluent(EndpointConditions instance) {
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
  
  protected void copyInstance(EndpointConditions instance) {
    instance = instance != null ? instance : new EndpointConditions();
    if (instance != null) {
        this.withReady(instance.getReady());
        this.withServing(instance.getServing());
        this.withTerminating(instance.getTerminating());
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
    EndpointConditionsFluent that = (EndpointConditionsFluent) o;
    if (!(Objects.equals(ready, that.ready))) {
      return false;
    }
    if (!(Objects.equals(serving, that.serving))) {
      return false;
    }
    if (!(Objects.equals(terminating, that.terminating))) {
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
  
  public Boolean getReady() {
    return this.ready;
  }
  
  public Boolean getServing() {
    return this.serving;
  }
  
  public Boolean getTerminating() {
    return this.terminating;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasReady() {
    return this.ready != null;
  }
  
  public boolean hasServing() {
    return this.serving != null;
  }
  
  public boolean hasTerminating() {
    return this.terminating != null;
  }
  
  public int hashCode() {
    return Objects.hash(ready, serving, terminating, additionalProperties);
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
    if (!(ready == null)) {
        sb.append("ready:");
        sb.append(ready);
        sb.append(",");
    }
    if (!(serving == null)) {
        sb.append("serving:");
        sb.append(serving);
        sb.append(",");
    }
    if (!(terminating == null)) {
        sb.append("terminating:");
        sb.append(terminating);
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
  
  public A withReady() {
    return withReady(true);
  }
  
  public A withReady(Boolean ready) {
    this.ready = ready;
    return (A) this;
  }
  
  public A withServing() {
    return withServing(true);
  }
  
  public A withServing(Boolean serving) {
    this.serving = serving;
    return (A) this;
  }
  
  public A withTerminating() {
    return withTerminating(true);
  }
  
  public A withTerminating(Boolean terminating) {
    this.terminating = terminating;
    return (A) this;
  }
  
}