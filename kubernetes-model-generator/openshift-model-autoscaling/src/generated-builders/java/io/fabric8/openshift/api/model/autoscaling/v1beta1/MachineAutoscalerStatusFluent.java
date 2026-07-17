package io.fabric8.openshift.api.model.autoscaling.v1beta1;

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
public class MachineAutoscalerStatusFluent<A extends io.fabric8.openshift.api.model.autoscaling.v1beta1.MachineAutoscalerStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private MachineAutoscalerStatusLastTargetRefBuilder lastTargetRef;

  public MachineAutoscalerStatusFluent() {
  }
  
  public MachineAutoscalerStatusFluent(MachineAutoscalerStatus instance) {
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
  
  public MachineAutoscalerStatusLastTargetRef buildLastTargetRef() {
    return this.lastTargetRef != null ? this.lastTargetRef.build() : null;
  }
  
  protected void copyInstance(MachineAutoscalerStatus instance) {
    instance = instance != null ? instance : new MachineAutoscalerStatus();
    if (instance != null) {
        this.withLastTargetRef(instance.getLastTargetRef());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public LastTargetRefNested<A> editLastTargetRef() {
    return this.withNewLastTargetRefLike(Optional.ofNullable(this.buildLastTargetRef()).orElse(null));
  }
  
  public LastTargetRefNested<A> editOrNewLastTargetRef() {
    return this.withNewLastTargetRefLike(Optional.ofNullable(this.buildLastTargetRef()).orElse(new MachineAutoscalerStatusLastTargetRefBuilder().build()));
  }
  
  public LastTargetRefNested<A> editOrNewLastTargetRefLike(MachineAutoscalerStatusLastTargetRef item) {
    return this.withNewLastTargetRefLike(Optional.ofNullable(this.buildLastTargetRef()).orElse(item));
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
    MachineAutoscalerStatusFluent that = (MachineAutoscalerStatusFluent) o;
    if (!(Objects.equals(lastTargetRef, that.lastTargetRef))) {
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
  
  public boolean hasLastTargetRef() {
    return this.lastTargetRef != null;
  }
  
  public int hashCode() {
    return Objects.hash(lastTargetRef, additionalProperties);
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
    if (!(lastTargetRef == null)) {
        sb.append("lastTargetRef:");
        sb.append(lastTargetRef);
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
  
  public A withLastTargetRef(MachineAutoscalerStatusLastTargetRef lastTargetRef) {
    this._visitables.remove("lastTargetRef");
    if (lastTargetRef != null) {
        this.lastTargetRef = new MachineAutoscalerStatusLastTargetRefBuilder(lastTargetRef);
        this._visitables.get("lastTargetRef").add(this.lastTargetRef);
    } else {
        this.lastTargetRef = null;
        this._visitables.get("lastTargetRef").remove(this.lastTargetRef);
    }
    return (A) this;
  }
  
  public LastTargetRefNested<A> withNewLastTargetRef() {
    return new LastTargetRefNested(null);
  }
  
  public A withNewLastTargetRef(String apiVersion,String kind,String name) {
    return (A) this.withLastTargetRef(new MachineAutoscalerStatusLastTargetRef(apiVersion, kind, name));
  }
  
  public LastTargetRefNested<A> withNewLastTargetRefLike(MachineAutoscalerStatusLastTargetRef item) {
    return new LastTargetRefNested(item);
  }
  public class LastTargetRefNested<N> extends MachineAutoscalerStatusLastTargetRefFluent<LastTargetRefNested<N>> implements Nested<N>{
  
    MachineAutoscalerStatusLastTargetRefBuilder builder;
  
    LastTargetRefNested(MachineAutoscalerStatusLastTargetRef item) {
      this.builder = new MachineAutoscalerStatusLastTargetRefBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineAutoscalerStatusFluent.this.withLastTargetRef(builder.build());
    }
    
    public N endLastTargetRef() {
      return and();
    }
    
  }
}