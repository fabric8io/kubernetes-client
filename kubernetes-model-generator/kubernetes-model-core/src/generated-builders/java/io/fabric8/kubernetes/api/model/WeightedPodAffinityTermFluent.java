package io.fabric8.kubernetes.api.model;

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
public class WeightedPodAffinityTermFluent<A extends io.fabric8.kubernetes.api.model.WeightedPodAffinityTermFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private PodAffinityTermBuilder podAffinityTerm;
  private Integer weight;

  public WeightedPodAffinityTermFluent() {
  }
  
  public WeightedPodAffinityTermFluent(WeightedPodAffinityTerm instance) {
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
  
  public PodAffinityTerm buildPodAffinityTerm() {
    return this.podAffinityTerm != null ? this.podAffinityTerm.build() : null;
  }
  
  protected void copyInstance(WeightedPodAffinityTerm instance) {
    instance = instance != null ? instance : new WeightedPodAffinityTerm();
    if (instance != null) {
        this.withPodAffinityTerm(instance.getPodAffinityTerm());
        this.withWeight(instance.getWeight());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PodAffinityTermNested<A> editOrNewPodAffinityTerm() {
    return this.withNewPodAffinityTermLike(Optional.ofNullable(this.buildPodAffinityTerm()).orElse(new PodAffinityTermBuilder().build()));
  }
  
  public PodAffinityTermNested<A> editOrNewPodAffinityTermLike(PodAffinityTerm item) {
    return this.withNewPodAffinityTermLike(Optional.ofNullable(this.buildPodAffinityTerm()).orElse(item));
  }
  
  public PodAffinityTermNested<A> editPodAffinityTerm() {
    return this.withNewPodAffinityTermLike(Optional.ofNullable(this.buildPodAffinityTerm()).orElse(null));
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
    WeightedPodAffinityTermFluent that = (WeightedPodAffinityTermFluent) o;
    if (!(Objects.equals(podAffinityTerm, that.podAffinityTerm))) {
      return false;
    }
    if (!(Objects.equals(weight, that.weight))) {
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
  
  public Integer getWeight() {
    return this.weight;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasPodAffinityTerm() {
    return this.podAffinityTerm != null;
  }
  
  public boolean hasWeight() {
    return this.weight != null;
  }
  
  public int hashCode() {
    return Objects.hash(podAffinityTerm, weight, additionalProperties);
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
    if (!(podAffinityTerm == null)) {
        sb.append("podAffinityTerm:");
        sb.append(podAffinityTerm);
        sb.append(",");
    }
    if (!(weight == null)) {
        sb.append("weight:");
        sb.append(weight);
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
  
  public PodAffinityTermNested<A> withNewPodAffinityTerm() {
    return new PodAffinityTermNested(null);
  }
  
  public PodAffinityTermNested<A> withNewPodAffinityTermLike(PodAffinityTerm item) {
    return new PodAffinityTermNested(item);
  }
  
  public A withPodAffinityTerm(PodAffinityTerm podAffinityTerm) {
    this._visitables.remove("podAffinityTerm");
    if (podAffinityTerm != null) {
        this.podAffinityTerm = new PodAffinityTermBuilder(podAffinityTerm);
        this._visitables.get("podAffinityTerm").add(this.podAffinityTerm);
    } else {
        this.podAffinityTerm = null;
        this._visitables.get("podAffinityTerm").remove(this.podAffinityTerm);
    }
    return (A) this;
  }
  
  public A withWeight(Integer weight) {
    this.weight = weight;
    return (A) this;
  }
  public class PodAffinityTermNested<N> extends PodAffinityTermFluent<PodAffinityTermNested<N>> implements Nested<N>{
  
    PodAffinityTermBuilder builder;
  
    PodAffinityTermNested(PodAffinityTerm item) {
      this.builder = new PodAffinityTermBuilder(this, item);
    }
  
    public N and() {
      return (N) WeightedPodAffinityTermFluent.this.withPodAffinityTerm(builder.build());
    }
    
    public N endPodAffinityTerm() {
      return and();
    }
    
  }
}