package io.fabric8.knative.internal.autoscaling.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.ObjectReferenceFluent;
import java.lang.Long;
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
public class PodAutoscalerSpecFluent<A extends io.fabric8.knative.internal.autoscaling.v1alpha1.PodAutoscalerSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Long containerConcurrency;
  private String protocolType;
  private String reachability;
  private ObjectReferenceBuilder scaleTargetRef;

  public PodAutoscalerSpecFluent() {
  }
  
  public PodAutoscalerSpecFluent(PodAutoscalerSpec instance) {
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
  
  public ObjectReference buildScaleTargetRef() {
    return this.scaleTargetRef != null ? this.scaleTargetRef.build() : null;
  }
  
  protected void copyInstance(PodAutoscalerSpec instance) {
    instance = instance != null ? instance : new PodAutoscalerSpec();
    if (instance != null) {
        this.withContainerConcurrency(instance.getContainerConcurrency());
        this.withProtocolType(instance.getProtocolType());
        this.withReachability(instance.getReachability());
        this.withScaleTargetRef(instance.getScaleTargetRef());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ScaleTargetRefNested<A> editOrNewScaleTargetRef() {
    return this.withNewScaleTargetRefLike(Optional.ofNullable(this.buildScaleTargetRef()).orElse(new ObjectReferenceBuilder().build()));
  }
  
  public ScaleTargetRefNested<A> editOrNewScaleTargetRefLike(ObjectReference item) {
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
    PodAutoscalerSpecFluent that = (PodAutoscalerSpecFluent) o;
    if (!(Objects.equals(containerConcurrency, that.containerConcurrency))) {
      return false;
    }
    if (!(Objects.equals(protocolType, that.protocolType))) {
      return false;
    }
    if (!(Objects.equals(reachability, that.reachability))) {
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
  
  public Long getContainerConcurrency() {
    return this.containerConcurrency;
  }
  
  public String getProtocolType() {
    return this.protocolType;
  }
  
  public String getReachability() {
    return this.reachability;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasContainerConcurrency() {
    return this.containerConcurrency != null;
  }
  
  public boolean hasProtocolType() {
    return this.protocolType != null;
  }
  
  public boolean hasReachability() {
    return this.reachability != null;
  }
  
  public boolean hasScaleTargetRef() {
    return this.scaleTargetRef != null;
  }
  
  public int hashCode() {
    return Objects.hash(containerConcurrency, protocolType, reachability, scaleTargetRef, additionalProperties);
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
    if (!(containerConcurrency == null)) {
        sb.append("containerConcurrency:");
        sb.append(containerConcurrency);
        sb.append(",");
    }
    if (!(protocolType == null)) {
        sb.append("protocolType:");
        sb.append(protocolType);
        sb.append(",");
    }
    if (!(reachability == null)) {
        sb.append("reachability:");
        sb.append(reachability);
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
  
  public A withContainerConcurrency(Long containerConcurrency) {
    this.containerConcurrency = containerConcurrency;
    return (A) this;
  }
  
  public ScaleTargetRefNested<A> withNewScaleTargetRef() {
    return new ScaleTargetRefNested(null);
  }
  
  public ScaleTargetRefNested<A> withNewScaleTargetRefLike(ObjectReference item) {
    return new ScaleTargetRefNested(item);
  }
  
  public A withProtocolType(String protocolType) {
    this.protocolType = protocolType;
    return (A) this;
  }
  
  public A withReachability(String reachability) {
    this.reachability = reachability;
    return (A) this;
  }
  
  public A withScaleTargetRef(ObjectReference scaleTargetRef) {
    this._visitables.remove("scaleTargetRef");
    if (scaleTargetRef != null) {
        this.scaleTargetRef = new ObjectReferenceBuilder(scaleTargetRef);
        this._visitables.get("scaleTargetRef").add(this.scaleTargetRef);
    } else {
        this.scaleTargetRef = null;
        this._visitables.get("scaleTargetRef").remove(this.scaleTargetRef);
    }
    return (A) this;
  }
  public class ScaleTargetRefNested<N> extends ObjectReferenceFluent<ScaleTargetRefNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
  
    ScaleTargetRefNested(ObjectReference item) {
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) PodAutoscalerSpecFluent.this.withScaleTargetRef(builder.build());
    }
    
    public N endScaleTargetRef() {
      return and();
    }
    
  }
}