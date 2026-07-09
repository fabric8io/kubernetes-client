package io.fabric8.kubernetes.api.model.autoscaling.v2beta2;

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
public class HorizontalPodAutoscalerBehaviorFluent<A extends io.fabric8.kubernetes.api.model.autoscaling.v2beta2.HorizontalPodAutoscalerBehaviorFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private HPAScalingRulesBuilder scaleDown;
  private HPAScalingRulesBuilder scaleUp;

  public HorizontalPodAutoscalerBehaviorFluent() {
  }
  
  public HorizontalPodAutoscalerBehaviorFluent(HorizontalPodAutoscalerBehavior instance) {
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
  
  public HPAScalingRules buildScaleDown() {
    return this.scaleDown != null ? this.scaleDown.build() : null;
  }
  
  public HPAScalingRules buildScaleUp() {
    return this.scaleUp != null ? this.scaleUp.build() : null;
  }
  
  protected void copyInstance(HorizontalPodAutoscalerBehavior instance) {
    instance = instance != null ? instance : new HorizontalPodAutoscalerBehavior();
    if (instance != null) {
        this.withScaleDown(instance.getScaleDown());
        this.withScaleUp(instance.getScaleUp());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ScaleDownNested<A> editOrNewScaleDown() {
    return this.withNewScaleDownLike(Optional.ofNullable(this.buildScaleDown()).orElse(new HPAScalingRulesBuilder().build()));
  }
  
  public ScaleDownNested<A> editOrNewScaleDownLike(HPAScalingRules item) {
    return this.withNewScaleDownLike(Optional.ofNullable(this.buildScaleDown()).orElse(item));
  }
  
  public ScaleUpNested<A> editOrNewScaleUp() {
    return this.withNewScaleUpLike(Optional.ofNullable(this.buildScaleUp()).orElse(new HPAScalingRulesBuilder().build()));
  }
  
  public ScaleUpNested<A> editOrNewScaleUpLike(HPAScalingRules item) {
    return this.withNewScaleUpLike(Optional.ofNullable(this.buildScaleUp()).orElse(item));
  }
  
  public ScaleDownNested<A> editScaleDown() {
    return this.withNewScaleDownLike(Optional.ofNullable(this.buildScaleDown()).orElse(null));
  }
  
  public ScaleUpNested<A> editScaleUp() {
    return this.withNewScaleUpLike(Optional.ofNullable(this.buildScaleUp()).orElse(null));
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
    HorizontalPodAutoscalerBehaviorFluent that = (HorizontalPodAutoscalerBehaviorFluent) o;
    if (!(Objects.equals(scaleDown, that.scaleDown))) {
      return false;
    }
    if (!(Objects.equals(scaleUp, that.scaleUp))) {
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
  
  public boolean hasScaleDown() {
    return this.scaleDown != null;
  }
  
  public boolean hasScaleUp() {
    return this.scaleUp != null;
  }
  
  public int hashCode() {
    return Objects.hash(scaleDown, scaleUp, additionalProperties);
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
    if (!(scaleDown == null)) {
        sb.append("scaleDown:");
        sb.append(scaleDown);
        sb.append(",");
    }
    if (!(scaleUp == null)) {
        sb.append("scaleUp:");
        sb.append(scaleUp);
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
  
  public ScaleDownNested<A> withNewScaleDown() {
    return new ScaleDownNested(null);
  }
  
  public ScaleDownNested<A> withNewScaleDownLike(HPAScalingRules item) {
    return new ScaleDownNested(item);
  }
  
  public ScaleUpNested<A> withNewScaleUp() {
    return new ScaleUpNested(null);
  }
  
  public ScaleUpNested<A> withNewScaleUpLike(HPAScalingRules item) {
    return new ScaleUpNested(item);
  }
  
  public A withScaleDown(HPAScalingRules scaleDown) {
    this._visitables.remove("scaleDown");
    if (scaleDown != null) {
        this.scaleDown = new HPAScalingRulesBuilder(scaleDown);
        this._visitables.get("scaleDown").add(this.scaleDown);
    } else {
        this.scaleDown = null;
        this._visitables.get("scaleDown").remove(this.scaleDown);
    }
    return (A) this;
  }
  
  public A withScaleUp(HPAScalingRules scaleUp) {
    this._visitables.remove("scaleUp");
    if (scaleUp != null) {
        this.scaleUp = new HPAScalingRulesBuilder(scaleUp);
        this._visitables.get("scaleUp").add(this.scaleUp);
    } else {
        this.scaleUp = null;
        this._visitables.get("scaleUp").remove(this.scaleUp);
    }
    return (A) this;
  }
  public class ScaleDownNested<N> extends HPAScalingRulesFluent<ScaleDownNested<N>> implements Nested<N>{
  
    HPAScalingRulesBuilder builder;
  
    ScaleDownNested(HPAScalingRules item) {
      this.builder = new HPAScalingRulesBuilder(this, item);
    }
  
    public N and() {
      return (N) HorizontalPodAutoscalerBehaviorFluent.this.withScaleDown(builder.build());
    }
    
    public N endScaleDown() {
      return and();
    }
    
  }
  public class ScaleUpNested<N> extends HPAScalingRulesFluent<ScaleUpNested<N>> implements Nested<N>{
  
    HPAScalingRulesBuilder builder;
  
    ScaleUpNested(HPAScalingRules item) {
      this.builder = new HPAScalingRulesBuilder(this, item);
    }
  
    public N and() {
      return (N) HorizontalPodAutoscalerBehaviorFluent.this.withScaleUp(builder.build());
    }
    
    public N endScaleUp() {
      return and();
    }
    
  }
}