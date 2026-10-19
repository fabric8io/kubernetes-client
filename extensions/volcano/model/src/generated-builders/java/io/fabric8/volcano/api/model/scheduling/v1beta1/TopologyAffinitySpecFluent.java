package io.fabric8.volcano.api.model.scheduling.v1beta1;

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
public class TopologyAffinitySpecFluent<A extends io.fabric8.volcano.api.model.scheduling.v1beta1.TopologyAffinitySpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private PodGroupAntiAffinityBuilder podGroupAntiAffinity;

  public TopologyAffinitySpecFluent() {
  }
  
  public TopologyAffinitySpecFluent(TopologyAffinitySpec instance) {
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
  
  public PodGroupAntiAffinity buildPodGroupAntiAffinity() {
    return this.podGroupAntiAffinity != null ? this.podGroupAntiAffinity.build() : null;
  }
  
  protected void copyInstance(TopologyAffinitySpec instance) {
    instance = instance != null ? instance : new TopologyAffinitySpec();
    if (instance != null) {
        this.withPodGroupAntiAffinity(instance.getPodGroupAntiAffinity());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PodGroupAntiAffinityNested<A> editOrNewPodGroupAntiAffinity() {
    return this.withNewPodGroupAntiAffinityLike(Optional.ofNullable(this.buildPodGroupAntiAffinity()).orElse(new PodGroupAntiAffinityBuilder().build()));
  }
  
  public PodGroupAntiAffinityNested<A> editOrNewPodGroupAntiAffinityLike(PodGroupAntiAffinity item) {
    return this.withNewPodGroupAntiAffinityLike(Optional.ofNullable(this.buildPodGroupAntiAffinity()).orElse(item));
  }
  
  public PodGroupAntiAffinityNested<A> editPodGroupAntiAffinity() {
    return this.withNewPodGroupAntiAffinityLike(Optional.ofNullable(this.buildPodGroupAntiAffinity()).orElse(null));
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
    TopologyAffinitySpecFluent that = (TopologyAffinitySpecFluent) o;
    if (!(Objects.equals(podGroupAntiAffinity, that.podGroupAntiAffinity))) {
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
  
  public boolean hasPodGroupAntiAffinity() {
    return this.podGroupAntiAffinity != null;
  }
  
  public int hashCode() {
    return Objects.hash(podGroupAntiAffinity, additionalProperties);
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
    if (!(podGroupAntiAffinity == null)) {
        sb.append("podGroupAntiAffinity:");
        sb.append(podGroupAntiAffinity);
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
  
  public PodGroupAntiAffinityNested<A> withNewPodGroupAntiAffinity() {
    return new PodGroupAntiAffinityNested(null);
  }
  
  public PodGroupAntiAffinityNested<A> withNewPodGroupAntiAffinityLike(PodGroupAntiAffinity item) {
    return new PodGroupAntiAffinityNested(item);
  }
  
  public A withPodGroupAntiAffinity(PodGroupAntiAffinity podGroupAntiAffinity) {
    this._visitables.remove("podGroupAntiAffinity");
    if (podGroupAntiAffinity != null) {
        this.podGroupAntiAffinity = new PodGroupAntiAffinityBuilder(podGroupAntiAffinity);
        this._visitables.get("podGroupAntiAffinity").add(this.podGroupAntiAffinity);
    } else {
        this.podGroupAntiAffinity = null;
        this._visitables.get("podGroupAntiAffinity").remove(this.podGroupAntiAffinity);
    }
    return (A) this;
  }
  public class PodGroupAntiAffinityNested<N> extends PodGroupAntiAffinityFluent<PodGroupAntiAffinityNested<N>> implements Nested<N>{
  
    PodGroupAntiAffinityBuilder builder;
  
    PodGroupAntiAffinityNested(PodGroupAntiAffinity item) {
      this.builder = new PodGroupAntiAffinityBuilder(this, item);
    }
  
    public N and() {
      return (N) TopologyAffinitySpecFluent.this.withPodGroupAntiAffinity(builder.build());
    }
    
    public N endPodGroupAntiAffinity() {
      return and();
    }
    
  }
}