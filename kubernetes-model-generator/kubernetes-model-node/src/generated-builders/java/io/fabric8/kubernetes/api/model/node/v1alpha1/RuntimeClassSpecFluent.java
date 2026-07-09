package io.fabric8.kubernetes.api.model.node.v1alpha1;

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
public class RuntimeClassSpecFluent<A extends io.fabric8.kubernetes.api.model.node.v1alpha1.RuntimeClassSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private OverheadBuilder overhead;
  private String runtimeHandler;
  private SchedulingBuilder scheduling;

  public RuntimeClassSpecFluent() {
  }
  
  public RuntimeClassSpecFluent(RuntimeClassSpec instance) {
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
  
  public Overhead buildOverhead() {
    return this.overhead != null ? this.overhead.build() : null;
  }
  
  public Scheduling buildScheduling() {
    return this.scheduling != null ? this.scheduling.build() : null;
  }
  
  protected void copyInstance(RuntimeClassSpec instance) {
    instance = instance != null ? instance : new RuntimeClassSpec();
    if (instance != null) {
        this.withOverhead(instance.getOverhead());
        this.withRuntimeHandler(instance.getRuntimeHandler());
        this.withScheduling(instance.getScheduling());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public OverheadNested<A> editOrNewOverhead() {
    return this.withNewOverheadLike(Optional.ofNullable(this.buildOverhead()).orElse(new OverheadBuilder().build()));
  }
  
  public OverheadNested<A> editOrNewOverheadLike(Overhead item) {
    return this.withNewOverheadLike(Optional.ofNullable(this.buildOverhead()).orElse(item));
  }
  
  public SchedulingNested<A> editOrNewScheduling() {
    return this.withNewSchedulingLike(Optional.ofNullable(this.buildScheduling()).orElse(new SchedulingBuilder().build()));
  }
  
  public SchedulingNested<A> editOrNewSchedulingLike(Scheduling item) {
    return this.withNewSchedulingLike(Optional.ofNullable(this.buildScheduling()).orElse(item));
  }
  
  public OverheadNested<A> editOverhead() {
    return this.withNewOverheadLike(Optional.ofNullable(this.buildOverhead()).orElse(null));
  }
  
  public SchedulingNested<A> editScheduling() {
    return this.withNewSchedulingLike(Optional.ofNullable(this.buildScheduling()).orElse(null));
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
    RuntimeClassSpecFluent that = (RuntimeClassSpecFluent) o;
    if (!(Objects.equals(overhead, that.overhead))) {
      return false;
    }
    if (!(Objects.equals(runtimeHandler, that.runtimeHandler))) {
      return false;
    }
    if (!(Objects.equals(scheduling, that.scheduling))) {
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
  
  public String getRuntimeHandler() {
    return this.runtimeHandler;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasOverhead() {
    return this.overhead != null;
  }
  
  public boolean hasRuntimeHandler() {
    return this.runtimeHandler != null;
  }
  
  public boolean hasScheduling() {
    return this.scheduling != null;
  }
  
  public int hashCode() {
    return Objects.hash(overhead, runtimeHandler, scheduling, additionalProperties);
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
    if (!(overhead == null)) {
        sb.append("overhead:");
        sb.append(overhead);
        sb.append(",");
    }
    if (!(runtimeHandler == null)) {
        sb.append("runtimeHandler:");
        sb.append(runtimeHandler);
        sb.append(",");
    }
    if (!(scheduling == null)) {
        sb.append("scheduling:");
        sb.append(scheduling);
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
  
  public OverheadNested<A> withNewOverhead() {
    return new OverheadNested(null);
  }
  
  public OverheadNested<A> withNewOverheadLike(Overhead item) {
    return new OverheadNested(item);
  }
  
  public SchedulingNested<A> withNewScheduling() {
    return new SchedulingNested(null);
  }
  
  public SchedulingNested<A> withNewSchedulingLike(Scheduling item) {
    return new SchedulingNested(item);
  }
  
  public A withOverhead(Overhead overhead) {
    this._visitables.remove("overhead");
    if (overhead != null) {
        this.overhead = new OverheadBuilder(overhead);
        this._visitables.get("overhead").add(this.overhead);
    } else {
        this.overhead = null;
        this._visitables.get("overhead").remove(this.overhead);
    }
    return (A) this;
  }
  
  public A withRuntimeHandler(String runtimeHandler) {
    this.runtimeHandler = runtimeHandler;
    return (A) this;
  }
  
  public A withScheduling(Scheduling scheduling) {
    this._visitables.remove("scheduling");
    if (scheduling != null) {
        this.scheduling = new SchedulingBuilder(scheduling);
        this._visitables.get("scheduling").add(this.scheduling);
    } else {
        this.scheduling = null;
        this._visitables.get("scheduling").remove(this.scheduling);
    }
    return (A) this;
  }
  public class OverheadNested<N> extends OverheadFluent<OverheadNested<N>> implements Nested<N>{
  
    OverheadBuilder builder;
  
    OverheadNested(Overhead item) {
      this.builder = new OverheadBuilder(this, item);
    }
  
    public N and() {
      return (N) RuntimeClassSpecFluent.this.withOverhead(builder.build());
    }
    
    public N endOverhead() {
      return and();
    }
    
  }
  public class SchedulingNested<N> extends SchedulingFluent<SchedulingNested<N>> implements Nested<N>{
  
    SchedulingBuilder builder;
  
    SchedulingNested(Scheduling item) {
      this.builder = new SchedulingBuilder(this, item);
    }
  
    public N and() {
      return (N) RuntimeClassSpecFluent.this.withScheduling(builder.build());
    }
    
    public N endScheduling() {
      return and();
    }
    
  }
}