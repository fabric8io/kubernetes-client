package io.fabric8.kubernetes.api.model.autoscaling.v1;

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
public class HorizontalPodAutoscalerSpecFluent<A extends io.fabric8.kubernetes.api.model.autoscaling.v1.HorizontalPodAutoscalerSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer maxReplicas;
  private Integer minReplicas;
  private CrossVersionObjectReferenceBuilder scaleTargetRef;
  private Integer targetCPUUtilizationPercentage;

  public HorizontalPodAutoscalerSpecFluent() {
  }
  
  public HorizontalPodAutoscalerSpecFluent(HorizontalPodAutoscalerSpec instance) {
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
  
  public CrossVersionObjectReference buildScaleTargetRef() {
    return this.scaleTargetRef != null ? this.scaleTargetRef.build() : null;
  }
  
  protected void copyInstance(HorizontalPodAutoscalerSpec instance) {
    instance = instance != null ? instance : new HorizontalPodAutoscalerSpec();
    if (instance != null) {
        this.withMaxReplicas(instance.getMaxReplicas());
        this.withMinReplicas(instance.getMinReplicas());
        this.withScaleTargetRef(instance.getScaleTargetRef());
        this.withTargetCPUUtilizationPercentage(instance.getTargetCPUUtilizationPercentage());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ScaleTargetRefNested<A> editOrNewScaleTargetRef() {
    return this.withNewScaleTargetRefLike(Optional.ofNullable(this.buildScaleTargetRef()).orElse(new CrossVersionObjectReferenceBuilder().build()));
  }
  
  public ScaleTargetRefNested<A> editOrNewScaleTargetRefLike(CrossVersionObjectReference item) {
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
    HorizontalPodAutoscalerSpecFluent that = (HorizontalPodAutoscalerSpecFluent) o;
    if (!(Objects.equals(maxReplicas, that.maxReplicas))) {
      return false;
    }
    if (!(Objects.equals(minReplicas, that.minReplicas))) {
      return false;
    }
    if (!(Objects.equals(scaleTargetRef, that.scaleTargetRef))) {
      return false;
    }
    if (!(Objects.equals(targetCPUUtilizationPercentage, that.targetCPUUtilizationPercentage))) {
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
  
  public Integer getTargetCPUUtilizationPercentage() {
    return this.targetCPUUtilizationPercentage;
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
  
  public boolean hasTargetCPUUtilizationPercentage() {
    return this.targetCPUUtilizationPercentage != null;
  }
  
  public int hashCode() {
    return Objects.hash(maxReplicas, minReplicas, scaleTargetRef, targetCPUUtilizationPercentage, additionalProperties);
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
    if (!(targetCPUUtilizationPercentage == null)) {
        sb.append("targetCPUUtilizationPercentage:");
        sb.append(targetCPUUtilizationPercentage);
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
    return (A) this.withScaleTargetRef(new CrossVersionObjectReference(apiVersion, kind, name));
  }
  
  public ScaleTargetRefNested<A> withNewScaleTargetRefLike(CrossVersionObjectReference item) {
    return new ScaleTargetRefNested(item);
  }
  
  public A withScaleTargetRef(CrossVersionObjectReference scaleTargetRef) {
    this._visitables.remove("scaleTargetRef");
    if (scaleTargetRef != null) {
        this.scaleTargetRef = new CrossVersionObjectReferenceBuilder(scaleTargetRef);
        this._visitables.get("scaleTargetRef").add(this.scaleTargetRef);
    } else {
        this.scaleTargetRef = null;
        this._visitables.get("scaleTargetRef").remove(this.scaleTargetRef);
    }
    return (A) this;
  }
  
  public A withTargetCPUUtilizationPercentage(Integer targetCPUUtilizationPercentage) {
    this.targetCPUUtilizationPercentage = targetCPUUtilizationPercentage;
    return (A) this;
  }
  public class ScaleTargetRefNested<N> extends CrossVersionObjectReferenceFluent<ScaleTargetRefNested<N>> implements Nested<N>{
  
    CrossVersionObjectReferenceBuilder builder;
  
    ScaleTargetRefNested(CrossVersionObjectReference item) {
      this.builder = new CrossVersionObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) HorizontalPodAutoscalerSpecFluent.this.withScaleTargetRef(builder.build());
    }
    
    public N endScaleTargetRef() {
      return and();
    }
    
  }
}