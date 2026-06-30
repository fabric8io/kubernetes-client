package io.fabric8.kubernetes.api.model;

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
public class ContainerStateFluent<A extends io.fabric8.kubernetes.api.model.ContainerStateFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ContainerStateRunningBuilder running;
  private ContainerStateTerminatedBuilder terminated;
  private ContainerStateWaitingBuilder waiting;

  public ContainerStateFluent() {
  }
  
  public ContainerStateFluent(ContainerState instance) {
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
  
  public ContainerStateRunning buildRunning() {
    return this.running != null ? this.running.build() : null;
  }
  
  public ContainerStateTerminated buildTerminated() {
    return this.terminated != null ? this.terminated.build() : null;
  }
  
  public ContainerStateWaiting buildWaiting() {
    return this.waiting != null ? this.waiting.build() : null;
  }
  
  protected void copyInstance(ContainerState instance) {
    instance = instance != null ? instance : new ContainerState();
    if (instance != null) {
        this.withRunning(instance.getRunning());
        this.withTerminated(instance.getTerminated());
        this.withWaiting(instance.getWaiting());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RunningNested<A> editOrNewRunning() {
    return this.withNewRunningLike(Optional.ofNullable(this.buildRunning()).orElse(new ContainerStateRunningBuilder().build()));
  }
  
  public RunningNested<A> editOrNewRunningLike(ContainerStateRunning item) {
    return this.withNewRunningLike(Optional.ofNullable(this.buildRunning()).orElse(item));
  }
  
  public TerminatedNested<A> editOrNewTerminated() {
    return this.withNewTerminatedLike(Optional.ofNullable(this.buildTerminated()).orElse(new ContainerStateTerminatedBuilder().build()));
  }
  
  public TerminatedNested<A> editOrNewTerminatedLike(ContainerStateTerminated item) {
    return this.withNewTerminatedLike(Optional.ofNullable(this.buildTerminated()).orElse(item));
  }
  
  public WaitingNested<A> editOrNewWaiting() {
    return this.withNewWaitingLike(Optional.ofNullable(this.buildWaiting()).orElse(new ContainerStateWaitingBuilder().build()));
  }
  
  public WaitingNested<A> editOrNewWaitingLike(ContainerStateWaiting item) {
    return this.withNewWaitingLike(Optional.ofNullable(this.buildWaiting()).orElse(item));
  }
  
  public RunningNested<A> editRunning() {
    return this.withNewRunningLike(Optional.ofNullable(this.buildRunning()).orElse(null));
  }
  
  public TerminatedNested<A> editTerminated() {
    return this.withNewTerminatedLike(Optional.ofNullable(this.buildTerminated()).orElse(null));
  }
  
  public WaitingNested<A> editWaiting() {
    return this.withNewWaitingLike(Optional.ofNullable(this.buildWaiting()).orElse(null));
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
    ContainerStateFluent that = (ContainerStateFluent) o;
    if (!(Objects.equals(running, that.running))) {
      return false;
    }
    if (!(Objects.equals(terminated, that.terminated))) {
      return false;
    }
    if (!(Objects.equals(waiting, that.waiting))) {
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
  
  public boolean hasRunning() {
    return this.running != null;
  }
  
  public boolean hasTerminated() {
    return this.terminated != null;
  }
  
  public boolean hasWaiting() {
    return this.waiting != null;
  }
  
  public int hashCode() {
    return Objects.hash(running, terminated, waiting, additionalProperties);
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
    if (!(running == null)) {
        sb.append("running:");
        sb.append(running);
        sb.append(",");
    }
    if (!(terminated == null)) {
        sb.append("terminated:");
        sb.append(terminated);
        sb.append(",");
    }
    if (!(waiting == null)) {
        sb.append("waiting:");
        sb.append(waiting);
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
  
  public RunningNested<A> withNewRunning() {
    return new RunningNested(null);
  }
  
  public A withNewRunning(String startedAt) {
    return (A) this.withRunning(new ContainerStateRunning(startedAt));
  }
  
  public RunningNested<A> withNewRunningLike(ContainerStateRunning item) {
    return new RunningNested(item);
  }
  
  public TerminatedNested<A> withNewTerminated() {
    return new TerminatedNested(null);
  }
  
  public TerminatedNested<A> withNewTerminatedLike(ContainerStateTerminated item) {
    return new TerminatedNested(item);
  }
  
  public WaitingNested<A> withNewWaiting() {
    return new WaitingNested(null);
  }
  
  public A withNewWaiting(String message,String reason) {
    return (A) this.withWaiting(new ContainerStateWaiting(message, reason));
  }
  
  public WaitingNested<A> withNewWaitingLike(ContainerStateWaiting item) {
    return new WaitingNested(item);
  }
  
  public A withRunning(ContainerStateRunning running) {
    this._visitables.remove("running");
    if (running != null) {
        this.running = new ContainerStateRunningBuilder(running);
        this._visitables.get("running").add(this.running);
    } else {
        this.running = null;
        this._visitables.get("running").remove(this.running);
    }
    return (A) this;
  }
  
  public A withTerminated(ContainerStateTerminated terminated) {
    this._visitables.remove("terminated");
    if (terminated != null) {
        this.terminated = new ContainerStateTerminatedBuilder(terminated);
        this._visitables.get("terminated").add(this.terminated);
    } else {
        this.terminated = null;
        this._visitables.get("terminated").remove(this.terminated);
    }
    return (A) this;
  }
  
  public A withWaiting(ContainerStateWaiting waiting) {
    this._visitables.remove("waiting");
    if (waiting != null) {
        this.waiting = new ContainerStateWaitingBuilder(waiting);
        this._visitables.get("waiting").add(this.waiting);
    } else {
        this.waiting = null;
        this._visitables.get("waiting").remove(this.waiting);
    }
    return (A) this;
  }
  public class RunningNested<N> extends ContainerStateRunningFluent<RunningNested<N>> implements Nested<N>{
  
    ContainerStateRunningBuilder builder;
  
    RunningNested(ContainerStateRunning item) {
      this.builder = new ContainerStateRunningBuilder(this, item);
    }
  
    public N and() {
      return (N) ContainerStateFluent.this.withRunning(builder.build());
    }
    
    public N endRunning() {
      return and();
    }
    
  }
  public class TerminatedNested<N> extends ContainerStateTerminatedFluent<TerminatedNested<N>> implements Nested<N>{
  
    ContainerStateTerminatedBuilder builder;
  
    TerminatedNested(ContainerStateTerminated item) {
      this.builder = new ContainerStateTerminatedBuilder(this, item);
    }
  
    public N and() {
      return (N) ContainerStateFluent.this.withTerminated(builder.build());
    }
    
    public N endTerminated() {
      return and();
    }
    
  }
  public class WaitingNested<N> extends ContainerStateWaitingFluent<WaitingNested<N>> implements Nested<N>{
  
    ContainerStateWaitingBuilder builder;
  
    WaitingNested(ContainerStateWaiting item) {
      this.builder = new ContainerStateWaitingBuilder(this, item);
    }
  
    public N and() {
      return (N) ContainerStateFluent.this.withWaiting(builder.build());
    }
    
    public N endWaiting() {
      return and();
    }
    
  }
}