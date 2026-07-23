package io.fabric8.kubernetes.api.model.autoscaling.v2beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class HorizontalPodAutoscalerSpecFluent<A extends io.fabric8.kubernetes.api.model.autoscaling.v2beta1.HorizontalPodAutoscalerSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer maxReplicas;
  private ArrayList<MetricSpecBuilder> metrics = new ArrayList<MetricSpecBuilder>();
  private Integer minReplicas;
  private CrossVersionObjectReferenceBuilder scaleTargetRef;

  public HorizontalPodAutoscalerSpecFluent() {
  }
  
  public HorizontalPodAutoscalerSpecFluent(HorizontalPodAutoscalerSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToMetrics(Collection<MetricSpec> items) {
    if (this.metrics == null) {
      this.metrics = new ArrayList();
    }
    for (MetricSpec item : items) {
        MetricSpecBuilder builder = new MetricSpecBuilder(item);
        _visitables.get("metrics").add(builder);
        this.metrics.add(builder);
    }
    return (A) this;
  }
  
  public MetricsNested<A> addNewMetric() {
    return new MetricsNested(-1, null);
  }
  
  public MetricsNested<A> addNewMetricLike(MetricSpec item) {
    return new MetricsNested(-1, item);
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
  
  public A addToMetrics(MetricSpec... items) {
    if (this.metrics == null) {
      this.metrics = new ArrayList();
    }
    for (MetricSpec item : items) {
        MetricSpecBuilder builder = new MetricSpecBuilder(item);
        _visitables.get("metrics").add(builder);
        this.metrics.add(builder);
    }
    return (A) this;
  }
  
  public A addToMetrics(int index,MetricSpec item) {
    if (this.metrics == null) {
      this.metrics = new ArrayList();
    }
    MetricSpecBuilder builder = new MetricSpecBuilder(item);
    if (index < 0 || index >= metrics.size()) {
        _visitables.get("metrics").add(builder);
        metrics.add(builder);
    } else {
        _visitables.get("metrics").add(builder);
        metrics.add(index, builder);
    }
    return (A) this;
  }
  
  public MetricSpec buildFirstMetric() {
    return this.metrics.get(0).build();
  }
  
  public MetricSpec buildLastMetric() {
    return this.metrics.get(metrics.size() - 1).build();
  }
  
  public MetricSpec buildMatchingMetric(Predicate<MetricSpecBuilder> predicate) {
      for (MetricSpecBuilder item : metrics) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public MetricSpec buildMetric(int index) {
    return this.metrics.get(index).build();
  }
  
  public List<MetricSpec> buildMetrics() {
    return this.metrics != null ? build(metrics) : null;
  }
  
  public CrossVersionObjectReference buildScaleTargetRef() {
    return this.scaleTargetRef != null ? this.scaleTargetRef.build() : null;
  }
  
  protected void copyInstance(HorizontalPodAutoscalerSpec instance) {
    instance = instance != null ? instance : new HorizontalPodAutoscalerSpec();
    if (instance != null) {
        this.withMaxReplicas(instance.getMaxReplicas());
        this.withMetrics(instance.getMetrics());
        this.withMinReplicas(instance.getMinReplicas());
        this.withScaleTargetRef(instance.getScaleTargetRef());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MetricsNested<A> editFirstMetric() {
    if (metrics.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "metrics"));
    }
    return this.setNewMetricLike(0, this.buildMetric(0));
  }
  
  public MetricsNested<A> editLastMetric() {
    int index = metrics.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "metrics"));
    }
    return this.setNewMetricLike(index, this.buildMetric(index));
  }
  
  public MetricsNested<A> editMatchingMetric(Predicate<MetricSpecBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < metrics.size();i++) {
      if (predicate.test(metrics.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "metrics"));
    }
    return this.setNewMetricLike(index, this.buildMetric(index));
  }
  
  public MetricsNested<A> editMetric(int index) {
    if (metrics.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "metrics"));
    }
    return this.setNewMetricLike(index, this.buildMetric(index));
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
    if (!(Objects.equals(metrics, that.metrics))) {
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
  
  public boolean hasMatchingMetric(Predicate<MetricSpecBuilder> predicate) {
      for (MetricSpecBuilder item : metrics) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMaxReplicas() {
    return this.maxReplicas != null;
  }
  
  public boolean hasMetrics() {
    return this.metrics != null && !(this.metrics.isEmpty());
  }
  
  public boolean hasMinReplicas() {
    return this.minReplicas != null;
  }
  
  public boolean hasScaleTargetRef() {
    return this.scaleTargetRef != null;
  }
  
  public int hashCode() {
    return Objects.hash(maxReplicas, metrics, minReplicas, scaleTargetRef, additionalProperties);
  }
  
  public A removeAllFromMetrics(Collection<MetricSpec> items) {
    if (this.metrics == null) {
      return (A) this;
    }
    for (MetricSpec item : items) {
        MetricSpecBuilder builder = new MetricSpecBuilder(item);
        _visitables.get("metrics").remove(builder);
        this.metrics.remove(builder);
    }
    return (A) this;
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
  
  public A removeFromMetrics(MetricSpec... items) {
    if (this.metrics == null) {
      return (A) this;
    }
    for (MetricSpec item : items) {
        MetricSpecBuilder builder = new MetricSpecBuilder(item);
        _visitables.get("metrics").remove(builder);
        this.metrics.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromMetrics(Predicate<MetricSpecBuilder> predicate) {
    if (metrics == null) {
      return (A) this;
    }
    Iterator<MetricSpecBuilder> each = metrics.iterator();
    List visitables = _visitables.get("metrics");
    while (each.hasNext()) {
        MetricSpecBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public MetricsNested<A> setNewMetricLike(int index,MetricSpec item) {
    return new MetricsNested(index, item);
  }
  
  public A setToMetrics(int index,MetricSpec item) {
    if (this.metrics == null) {
      this.metrics = new ArrayList();
    }
    MetricSpecBuilder builder = new MetricSpecBuilder(item);
    if (index < 0 || index >= metrics.size()) {
        _visitables.get("metrics").add(builder);
        metrics.add(builder);
    } else {
        _visitables.get("metrics").add(builder);
        metrics.set(index, builder);
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
    if (!(metrics == null) && !(metrics.isEmpty())) {
        sb.append("metrics:");
        sb.append(metrics);
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
  
  public A withMetrics(List<MetricSpec> metrics) {
    if (this.metrics != null) {
      this._visitables.get("metrics").clear();
    }
    if (metrics != null) {
        this.metrics = new ArrayList();
        for (MetricSpec item : metrics) {
          this.addToMetrics(item);
        }
    } else {
      this.metrics = null;
    }
    return (A) this;
  }
  
  public A withMetrics(MetricSpec... metrics) {
    if (this.metrics != null) {
        this.metrics.clear();
        _visitables.remove("metrics");
    }
    if (metrics != null) {
      for (MetricSpec item : metrics) {
        this.addToMetrics(item);
      }
    }
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
  public class MetricsNested<N> extends MetricSpecFluent<MetricsNested<N>> implements Nested<N>{
  
    MetricSpecBuilder builder;
    int index;
  
    MetricsNested(int index,MetricSpec item) {
      this.index = index;
      this.builder = new MetricSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) HorizontalPodAutoscalerSpecFluent.this.setToMetrics(index, builder.build());
    }
    
    public N endMetric() {
      return and();
    }
    
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