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
public class LifecycleFluent<A extends io.fabric8.kubernetes.api.model.LifecycleFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private LifecycleHandlerBuilder postStart;
  private LifecycleHandlerBuilder preStop;
  private String stopSignal;

  public LifecycleFluent() {
  }
  
  public LifecycleFluent(Lifecycle instance) {
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
  
  public LifecycleHandler buildPostStart() {
    return this.postStart != null ? this.postStart.build() : null;
  }
  
  public LifecycleHandler buildPreStop() {
    return this.preStop != null ? this.preStop.build() : null;
  }
  
  protected void copyInstance(Lifecycle instance) {
    instance = instance != null ? instance : new Lifecycle();
    if (instance != null) {
        this.withPostStart(instance.getPostStart());
        this.withPreStop(instance.getPreStop());
        this.withStopSignal(instance.getStopSignal());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PostStartNested<A> editOrNewPostStart() {
    return this.withNewPostStartLike(Optional.ofNullable(this.buildPostStart()).orElse(new LifecycleHandlerBuilder().build()));
  }
  
  public PostStartNested<A> editOrNewPostStartLike(LifecycleHandler item) {
    return this.withNewPostStartLike(Optional.ofNullable(this.buildPostStart()).orElse(item));
  }
  
  public PreStopNested<A> editOrNewPreStop() {
    return this.withNewPreStopLike(Optional.ofNullable(this.buildPreStop()).orElse(new LifecycleHandlerBuilder().build()));
  }
  
  public PreStopNested<A> editOrNewPreStopLike(LifecycleHandler item) {
    return this.withNewPreStopLike(Optional.ofNullable(this.buildPreStop()).orElse(item));
  }
  
  public PostStartNested<A> editPostStart() {
    return this.withNewPostStartLike(Optional.ofNullable(this.buildPostStart()).orElse(null));
  }
  
  public PreStopNested<A> editPreStop() {
    return this.withNewPreStopLike(Optional.ofNullable(this.buildPreStop()).orElse(null));
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
    LifecycleFluent that = (LifecycleFluent) o;
    if (!(Objects.equals(postStart, that.postStart))) {
      return false;
    }
    if (!(Objects.equals(preStop, that.preStop))) {
      return false;
    }
    if (!(Objects.equals(stopSignal, that.stopSignal))) {
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
  
  public String getStopSignal() {
    return this.stopSignal;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasPostStart() {
    return this.postStart != null;
  }
  
  public boolean hasPreStop() {
    return this.preStop != null;
  }
  
  public boolean hasStopSignal() {
    return this.stopSignal != null;
  }
  
  public int hashCode() {
    return Objects.hash(postStart, preStop, stopSignal, additionalProperties);
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
    if (!(postStart == null)) {
        sb.append("postStart:");
        sb.append(postStart);
        sb.append(",");
    }
    if (!(preStop == null)) {
        sb.append("preStop:");
        sb.append(preStop);
        sb.append(",");
    }
    if (!(stopSignal == null)) {
        sb.append("stopSignal:");
        sb.append(stopSignal);
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
  
  public PostStartNested<A> withNewPostStart() {
    return new PostStartNested(null);
  }
  
  public PostStartNested<A> withNewPostStartLike(LifecycleHandler item) {
    return new PostStartNested(item);
  }
  
  public PreStopNested<A> withNewPreStop() {
    return new PreStopNested(null);
  }
  
  public PreStopNested<A> withNewPreStopLike(LifecycleHandler item) {
    return new PreStopNested(item);
  }
  
  public A withPostStart(LifecycleHandler postStart) {
    this._visitables.remove("postStart");
    if (postStart != null) {
        this.postStart = new LifecycleHandlerBuilder(postStart);
        this._visitables.get("postStart").add(this.postStart);
    } else {
        this.postStart = null;
        this._visitables.get("postStart").remove(this.postStart);
    }
    return (A) this;
  }
  
  public A withPreStop(LifecycleHandler preStop) {
    this._visitables.remove("preStop");
    if (preStop != null) {
        this.preStop = new LifecycleHandlerBuilder(preStop);
        this._visitables.get("preStop").add(this.preStop);
    } else {
        this.preStop = null;
        this._visitables.get("preStop").remove(this.preStop);
    }
    return (A) this;
  }
  
  public A withStopSignal(String stopSignal) {
    this.stopSignal = stopSignal;
    return (A) this;
  }
  public class PostStartNested<N> extends LifecycleHandlerFluent<PostStartNested<N>> implements Nested<N>{
  
    LifecycleHandlerBuilder builder;
  
    PostStartNested(LifecycleHandler item) {
      this.builder = new LifecycleHandlerBuilder(this, item);
    }
  
    public N and() {
      return (N) LifecycleFluent.this.withPostStart(builder.build());
    }
    
    public N endPostStart() {
      return and();
    }
    
  }
  public class PreStopNested<N> extends LifecycleHandlerFluent<PreStopNested<N>> implements Nested<N>{
  
    LifecycleHandlerBuilder builder;
  
    PreStopNested(LifecycleHandler item) {
      this.builder = new LifecycleHandlerBuilder(this, item);
    }
  
    public N and() {
      return (N) LifecycleFluent.this.withPreStop(builder.build());
    }
    
    public N endPreStop() {
      return and();
    }
    
  }
}