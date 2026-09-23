package io.fabric8.kubernetes.api.model.lifecycle.v1alpha1;

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
public class EvictionRequestTargetFluent<A extends io.fabric8.kubernetes.api.model.lifecycle.v1alpha1.EvictionRequestTargetFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private EvictionRequestPodReferenceBuilder pod;

  public EvictionRequestTargetFluent() {
  }
  
  public EvictionRequestTargetFluent(EvictionRequestTarget instance) {
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
  
  public EvictionRequestPodReference buildPod() {
    return this.pod != null ? this.pod.build() : null;
  }
  
  protected void copyInstance(EvictionRequestTarget instance) {
    instance = instance != null ? instance : new EvictionRequestTarget();
    if (instance != null) {
        this.withPod(instance.getPod());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PodNested<A> editOrNewPod() {
    return this.withNewPodLike(Optional.ofNullable(this.buildPod()).orElse(new EvictionRequestPodReferenceBuilder().build()));
  }
  
  public PodNested<A> editOrNewPodLike(EvictionRequestPodReference item) {
    return this.withNewPodLike(Optional.ofNullable(this.buildPod()).orElse(item));
  }
  
  public PodNested<A> editPod() {
    return this.withNewPodLike(Optional.ofNullable(this.buildPod()).orElse(null));
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
    EvictionRequestTargetFluent that = (EvictionRequestTargetFluent) o;
    if (!(Objects.equals(pod, that.pod))) {
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
  
  public boolean hasPod() {
    return this.pod != null;
  }
  
  public int hashCode() {
    return Objects.hash(pod, additionalProperties);
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
    if (!(pod == null)) {
        sb.append("pod:");
        sb.append(pod);
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
  
  public PodNested<A> withNewPod() {
    return new PodNested(null);
  }
  
  public A withNewPod(String name,String uid) {
    return (A) this.withPod(new EvictionRequestPodReference(name, uid));
  }
  
  public PodNested<A> withNewPodLike(EvictionRequestPodReference item) {
    return new PodNested(item);
  }
  
  public A withPod(EvictionRequestPodReference pod) {
    this._visitables.remove("pod");
    if (pod != null) {
        this.pod = new EvictionRequestPodReferenceBuilder(pod);
        this._visitables.get("pod").add(this.pod);
    } else {
        this.pod = null;
        this._visitables.get("pod").remove(this.pod);
    }
    return (A) this;
  }
  public class PodNested<N> extends EvictionRequestPodReferenceFluent<PodNested<N>> implements Nested<N>{
  
    EvictionRequestPodReferenceBuilder builder;
  
    PodNested(EvictionRequestPodReference item) {
      this.builder = new EvictionRequestPodReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) EvictionRequestTargetFluent.this.withPod(builder.build());
    }
    
    public N endPod() {
      return and();
    }
    
  }
}