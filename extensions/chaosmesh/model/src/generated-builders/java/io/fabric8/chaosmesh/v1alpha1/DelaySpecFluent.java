package io.fabric8.chaosmesh.v1alpha1;

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
public class DelaySpecFluent<A extends io.fabric8.chaosmesh.v1alpha1.DelaySpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String correlation;
  private String jitter;
  private String latency;
  private ReorderSpecBuilder reorder;

  public DelaySpecFluent() {
  }
  
  public DelaySpecFluent(DelaySpec instance) {
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
  
  public ReorderSpec buildReorder() {
    return this.reorder != null ? this.reorder.build() : null;
  }
  
  protected void copyInstance(DelaySpec instance) {
    instance = instance != null ? instance : new DelaySpec();
    if (instance != null) {
        this.withCorrelation(instance.getCorrelation());
        this.withJitter(instance.getJitter());
        this.withLatency(instance.getLatency());
        this.withReorder(instance.getReorder());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ReorderNested<A> editOrNewReorder() {
    return this.withNewReorderLike(Optional.ofNullable(this.buildReorder()).orElse(new ReorderSpecBuilder().build()));
  }
  
  public ReorderNested<A> editOrNewReorderLike(ReorderSpec item) {
    return this.withNewReorderLike(Optional.ofNullable(this.buildReorder()).orElse(item));
  }
  
  public ReorderNested<A> editReorder() {
    return this.withNewReorderLike(Optional.ofNullable(this.buildReorder()).orElse(null));
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
    DelaySpecFluent that = (DelaySpecFluent) o;
    if (!(Objects.equals(correlation, that.correlation))) {
      return false;
    }
    if (!(Objects.equals(jitter, that.jitter))) {
      return false;
    }
    if (!(Objects.equals(latency, that.latency))) {
      return false;
    }
    if (!(Objects.equals(reorder, that.reorder))) {
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
  
  public String getCorrelation() {
    return this.correlation;
  }
  
  public String getJitter() {
    return this.jitter;
  }
  
  public String getLatency() {
    return this.latency;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCorrelation() {
    return this.correlation != null;
  }
  
  public boolean hasJitter() {
    return this.jitter != null;
  }
  
  public boolean hasLatency() {
    return this.latency != null;
  }
  
  public boolean hasReorder() {
    return this.reorder != null;
  }
  
  public int hashCode() {
    return Objects.hash(correlation, jitter, latency, reorder, additionalProperties);
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
    if (!(correlation == null)) {
        sb.append("correlation:");
        sb.append(correlation);
        sb.append(",");
    }
    if (!(jitter == null)) {
        sb.append("jitter:");
        sb.append(jitter);
        sb.append(",");
    }
    if (!(latency == null)) {
        sb.append("latency:");
        sb.append(latency);
        sb.append(",");
    }
    if (!(reorder == null)) {
        sb.append("reorder:");
        sb.append(reorder);
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
  
  public A withCorrelation(String correlation) {
    this.correlation = correlation;
    return (A) this;
  }
  
  public A withJitter(String jitter) {
    this.jitter = jitter;
    return (A) this;
  }
  
  public A withLatency(String latency) {
    this.latency = latency;
    return (A) this;
  }
  
  public ReorderNested<A> withNewReorder() {
    return new ReorderNested(null);
  }
  
  public A withNewReorder(String correlation,Integer gap,String reorder) {
    return (A) this.withReorder(new ReorderSpec(correlation, gap, reorder));
  }
  
  public ReorderNested<A> withNewReorderLike(ReorderSpec item) {
    return new ReorderNested(item);
  }
  
  public A withReorder(ReorderSpec reorder) {
    this._visitables.remove("reorder");
    if (reorder != null) {
        this.reorder = new ReorderSpecBuilder(reorder);
        this._visitables.get("reorder").add(this.reorder);
    } else {
        this.reorder = null;
        this._visitables.get("reorder").remove(this.reorder);
    }
    return (A) this;
  }
  public class ReorderNested<N> extends ReorderSpecFluent<ReorderNested<N>> implements Nested<N>{
  
    ReorderSpecBuilder builder;
  
    ReorderNested(ReorderSpec item) {
      this.builder = new ReorderSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) DelaySpecFluent.this.withReorder(builder.build());
    }
    
    public N endReorder() {
      return and();
    }
    
  }
}