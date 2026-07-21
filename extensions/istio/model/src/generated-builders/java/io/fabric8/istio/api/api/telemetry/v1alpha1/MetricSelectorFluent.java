package io.fabric8.istio.api.api.telemetry.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class MetricSelectorFluent<A extends io.fabric8.istio.api.api.telemetry.v1alpha1.MetricSelectorFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private VisitableBuilder<? extends IsMetricSelectorMetricMatch,?> metricMatch;
  private WorkloadMode mode;

  public MetricSelectorFluent() {
  }
  
  public MetricSelectorFluent(MetricSelector instance) {
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
  
  public IsMetricSelectorMetricMatch buildMetricMatch() {
    return this.metricMatch != null ? this.metricMatch.build() : null;
  }
  
  protected static <T>VisitableBuilder<T,?> builder(Object item) {
    switch (item.getClass().getName()) {
      case "MetricSelectorMetric":
    
          return (VisitableBuilder<T,?>) new MetricSelectorMetricBuilder((MetricSelectorMetric) item);
    
      case "MetricSelectorCustomMetric":
    
          return (VisitableBuilder<T,?>) new MetricSelectorCustomMetricBuilder((MetricSelectorCustomMetric) item);
    
      default:
    
          return (VisitableBuilder<T,?>) builderOf(item);
    
    }
  }
  
  protected void copyInstance(MetricSelector instance) {
    instance = instance != null ? instance : new MetricSelector();
    if (instance != null) {
        this.withMetricMatch(instance.getMetricMatch());
        this.withMode(instance.getMode());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
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
    MetricSelectorFluent that = (MetricSelectorFluent) o;
    if (!(Objects.equals(metricMatch, that.metricMatch))) {
      return false;
    }
    if (!(Objects.equals(mode, that.mode))) {
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
  
  public WorkloadMode getMode() {
    return this.mode;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMetricMatch() {
    return this.metricMatch != null;
  }
  
  public boolean hasMode() {
    return this.mode != null;
  }
  
  public int hashCode() {
    return Objects.hash(metricMatch, mode, additionalProperties);
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
    if (!(metricMatch == null)) {
        sb.append("metricMatch:");
        sb.append(metricMatch);
        sb.append(",");
    }
    if (!(mode == null)) {
        sb.append("mode:");
        sb.append(mode);
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
  
  public A withMetricMatch(IsMetricSelectorMetricMatch metricMatch) {
    if (metricMatch == null) {
        this.metricMatch = null;
        this._visitables.remove("metricMatch");
        return (A) this;
    } else {
        VisitableBuilder<? extends IsMetricSelectorMetricMatch,?> builder = builder(metricMatch);
        this._visitables.get("metricMatch").clear();
        this._visitables.get("metricMatch").add(builder);
        this.metricMatch = builder;
        return (A) this;
    }
  }
  
  public A withMode(WorkloadMode mode) {
    this.mode = mode;
    return (A) this;
  }
  
  public MetricSelectorCustomMetricMatchNested<A> withNewMetricSelectorCustomMetricMatch() {
    return new MetricSelectorCustomMetricMatchNested(null);
  }
  
  public A withNewMetricSelectorCustomMetricMatch(String customMetric) {
    return (A) this.withMetricMatch(new MetricSelectorCustomMetric(customMetric));
  }
  
  public MetricSelectorCustomMetricMatchNested<A> withNewMetricSelectorCustomMetricMatchLike(MetricSelectorCustomMetric item) {
    return new MetricSelectorCustomMetricMatchNested(item);
  }
  
  public MetricSelectorMetricMatchNested<A> withNewMetricSelectorMetricMatch() {
    return new MetricSelectorMetricMatchNested(null);
  }
  
  public MetricSelectorMetricMatchNested<A> withNewMetricSelectorMetricMatchLike(MetricSelectorMetric item) {
    return new MetricSelectorMetricMatchNested(item);
  }
  public class MetricSelectorCustomMetricMatchNested<N> extends MetricSelectorCustomMetricFluent<MetricSelectorCustomMetricMatchNested<N>> implements Nested<N>{
  
    MetricSelectorCustomMetricBuilder builder;
  
    MetricSelectorCustomMetricMatchNested(MetricSelectorCustomMetric item) {
      this.builder = new MetricSelectorCustomMetricBuilder(this, item);
    }
  
    public N and() {
      return (N) MetricSelectorFluent.this.withMetricMatch(builder.build());
    }
    
    public N endMetricSelectorCustomMetricMatch() {
      return and();
    }
    
  }
  public class MetricSelectorMetricMatchNested<N> extends MetricSelectorMetricFluent<MetricSelectorMetricMatchNested<N>> implements Nested<N>{
  
    MetricSelectorMetricBuilder builder;
  
    MetricSelectorMetricMatchNested(MetricSelectorMetric item) {
      this.builder = new MetricSelectorMetricBuilder(this, item);
    }
  
    public N and() {
      return (N) MetricSelectorFluent.this.withMetricMatch(builder.build());
    }
    
    public N endMetricSelectorMetricMatch() {
      return and();
    }
    
  }
}