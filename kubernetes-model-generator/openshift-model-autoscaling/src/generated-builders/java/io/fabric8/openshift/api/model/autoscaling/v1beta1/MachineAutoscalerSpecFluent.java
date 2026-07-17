package io.fabric8.openshift.api.model.autoscaling.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
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
public class MachineAutoscalerSpecFluent<A extends io.fabric8.openshift.api.model.autoscaling.v1beta1.MachineAutoscalerSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer maxReplicas;
  private Integer minReplicas;
  private MachineAutoscalerSpecScaleTargetRefBuilder scaleTargetRef;

  public MachineAutoscalerSpecFluent() {
  }
  
  public MachineAutoscalerSpecFluent(MachineAutoscalerSpec instance) {
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
  
  public MachineAutoscalerSpecScaleTargetRef buildScaleTargetRef() {
    return this.scaleTargetRef != null ? this.scaleTargetRef.build() : null;
  }
  
  protected void copyInstance(MachineAutoscalerSpec instance) {
    instance = instance != null ? instance : new MachineAutoscalerSpec();
    if (instance != null) {
        this.withMaxReplicas(instance.getMaxReplicas());
        this.withMinReplicas(instance.getMinReplicas());
        this.withScaleTargetRef(instance.getScaleTargetRef());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ScaleTargetRefNested<A> editOrNewScaleTargetRef() {
    return this.withNewScaleTargetRefLike(Optional.ofNullable(this.buildScaleTargetRef()).orElse(new MachineAutoscalerSpecScaleTargetRefBuilder().build()));
  }
  
  public ScaleTargetRefNested<A> editOrNewScaleTargetRefLike(MachineAutoscalerSpecScaleTargetRef item) {
    return this.withNewScaleTargetRefLike(Optional.ofNullable(this.buildScaleTargetRef()).orElse(item));
  }
  
  public ScaleTargetRefNested<A> editScaleTargetRef() {
    return this.withNewScaleTargetRefLike(Optional.ofNullable(this.buildScaleTargetRef()).orElse(null));
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
    MachineAutoscalerSpecFluent that = (MachineAutoscalerSpecFluent) o;
    if (!(Objects.equals(maxReplicas, that.maxReplicas))) {
      return false;
    }
    if (!(Objects.equals(minReplicas, that.minReplicas))) {
      return false;
    }
    if (!(Objects.equals(scaleTargetRef, that.scaleTargetRef))) {
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
  
  public Integer getMaxReplicas() {
    return this.maxReplicas;
  }
  
  public Integer getMinReplicas() {
    return this.minReplicas;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMaxReplicas() {
    return this.maxReplicas != null;
  }
  
  public boolean hasMinReplicas() {
    return this.minReplicas != null;
  }
  
  public boolean hasScaleTargetRef() {
    return this.scaleTargetRef != null;
  }
  
  public int hashCode() {
    return Objects.hash(maxReplicas, minReplicas, scaleTargetRef, additionalProperties);
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
    if (!(maxReplicas == null)) {
        sb.append("maxReplicas:");
        sb.append(maxReplicas);
        sb.append(",");
    }
    if (!(minReplicas == null)) {
        sb.append("minReplicas:");
        sb.append(minReplicas);
        sb.append(",");
    }
    if (!(scaleTargetRef == null)) {
        sb.append("scaleTargetRef:");
        sb.append(scaleTargetRef);
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
  
  public A withMaxReplicas(Integer maxReplicas) {
    this.maxReplicas = maxReplicas;
    return (A) this;
  }
  
  public A withMinReplicas(Integer minReplicas) {
    this.minReplicas = minReplicas;
    return (A) this;
  }
  
  public ScaleTargetRefNested<A> withNewScaleTargetRef() {
    return new ScaleTargetRefNested(null);
  }
  
  public A withNewScaleTargetRef(String apiVersion,String kind,String name) {
    return (A) this.withScaleTargetRef(new MachineAutoscalerSpecScaleTargetRef(apiVersion, kind, name));
  }
  
  public ScaleTargetRefNested<A> withNewScaleTargetRefLike(MachineAutoscalerSpecScaleTargetRef item) {
    return new ScaleTargetRefNested(item);
  }
  
  public A withScaleTargetRef(MachineAutoscalerSpecScaleTargetRef scaleTargetRef) {
    this._visitables.remove("scaleTargetRef");
    if (scaleTargetRef != null) {
        this.scaleTargetRef = new MachineAutoscalerSpecScaleTargetRefBuilder(scaleTargetRef);
        this._visitables.get("scaleTargetRef").add(this.scaleTargetRef);
    } else {
        this.scaleTargetRef = null;
        this._visitables.get("scaleTargetRef").remove(this.scaleTargetRef);
    }
    return (A) this;
  }
  public class ScaleTargetRefNested<N> extends MachineAutoscalerSpecScaleTargetRefFluent<ScaleTargetRefNested<N>> implements Nested<N>{
  
    MachineAutoscalerSpecScaleTargetRefBuilder builder;
  
    ScaleTargetRefNested(MachineAutoscalerSpecScaleTargetRef item) {
      this.builder = new MachineAutoscalerSpecScaleTargetRefBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineAutoscalerSpecFluent.this.withScaleTargetRef(builder.build());
    }
    
    public N endScaleTargetRef() {
      return and();
    }
    
  }
}