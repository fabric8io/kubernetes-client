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
public class ObjectMetricStatusFluent<A extends io.fabric8.kubernetes.api.model.autoscaling.v2beta2.ObjectMetricStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private MetricValueStatusBuilder current;
  private CrossVersionObjectReferenceBuilder describedObject;
  private MetricIdentifierBuilder metric;

  public ObjectMetricStatusFluent() {
  }
  
  public ObjectMetricStatusFluent(ObjectMetricStatus instance) {
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
  
  public MetricValueStatus buildCurrent() {
    return this.current != null ? this.current.build() : null;
  }
  
  public CrossVersionObjectReference buildDescribedObject() {
    return this.describedObject != null ? this.describedObject.build() : null;
  }
  
  public MetricIdentifier buildMetric() {
    return this.metric != null ? this.metric.build() : null;
  }
  
  protected void copyInstance(ObjectMetricStatus instance) {
    instance = instance != null ? instance : new ObjectMetricStatus();
    if (instance != null) {
        this.withCurrent(instance.getCurrent());
        this.withDescribedObject(instance.getDescribedObject());
        this.withMetric(instance.getMetric());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CurrentNested<A> editCurrent() {
    return this.withNewCurrentLike(Optional.ofNullable(this.buildCurrent()).orElse(null));
  }
  
  public DescribedObjectNested<A> editDescribedObject() {
    return this.withNewDescribedObjectLike(Optional.ofNullable(this.buildDescribedObject()).orElse(null));
  }
  
  public MetricNested<A> editMetric() {
    return this.withNewMetricLike(Optional.ofNullable(this.buildMetric()).orElse(null));
  }
  
  public CurrentNested<A> editOrNewCurrent() {
    return this.withNewCurrentLike(Optional.ofNullable(this.buildCurrent()).orElse(new MetricValueStatusBuilder().build()));
  }
  
  public CurrentNested<A> editOrNewCurrentLike(MetricValueStatus item) {
    return this.withNewCurrentLike(Optional.ofNullable(this.buildCurrent()).orElse(item));
  }
  
  public DescribedObjectNested<A> editOrNewDescribedObject() {
    return this.withNewDescribedObjectLike(Optional.ofNullable(this.buildDescribedObject()).orElse(new CrossVersionObjectReferenceBuilder().build()));
  }
  
  public DescribedObjectNested<A> editOrNewDescribedObjectLike(CrossVersionObjectReference item) {
    return this.withNewDescribedObjectLike(Optional.ofNullable(this.buildDescribedObject()).orElse(item));
  }
  
  public MetricNested<A> editOrNewMetric() {
    return this.withNewMetricLike(Optional.ofNullable(this.buildMetric()).orElse(new MetricIdentifierBuilder().build()));
  }
  
  public MetricNested<A> editOrNewMetricLike(MetricIdentifier item) {
    return this.withNewMetricLike(Optional.ofNullable(this.buildMetric()).orElse(item));
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
    ObjectMetricStatusFluent that = (ObjectMetricStatusFluent) o;
    if (!(Objects.equals(current, that.current))) {
      return false;
    }
    if (!(Objects.equals(describedObject, that.describedObject))) {
      return false;
    }
    if (!(Objects.equals(metric, that.metric))) {
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
  
  public boolean hasCurrent() {
    return this.current != null;
  }
  
  public boolean hasDescribedObject() {
    return this.describedObject != null;
  }
  
  public boolean hasMetric() {
    return this.metric != null;
  }
  
  public int hashCode() {
    return Objects.hash(current, describedObject, metric, additionalProperties);
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
    if (!(current == null)) {
        sb.append("current:");
        sb.append(current);
        sb.append(",");
    }
    if (!(describedObject == null)) {
        sb.append("describedObject:");
        sb.append(describedObject);
        sb.append(",");
    }
    if (!(metric == null)) {
        sb.append("metric:");
        sb.append(metric);
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
  
  public A withCurrent(MetricValueStatus current) {
    this._visitables.remove("current");
    if (current != null) {
        this.current = new MetricValueStatusBuilder(current);
        this._visitables.get("current").add(this.current);
    } else {
        this.current = null;
        this._visitables.get("current").remove(this.current);
    }
    return (A) this;
  }
  
  public A withDescribedObject(CrossVersionObjectReference describedObject) {
    this._visitables.remove("describedObject");
    if (describedObject != null) {
        this.describedObject = new CrossVersionObjectReferenceBuilder(describedObject);
        this._visitables.get("describedObject").add(this.describedObject);
    } else {
        this.describedObject = null;
        this._visitables.get("describedObject").remove(this.describedObject);
    }
    return (A) this;
  }
  
  public A withMetric(MetricIdentifier metric) {
    this._visitables.remove("metric");
    if (metric != null) {
        this.metric = new MetricIdentifierBuilder(metric);
        this._visitables.get("metric").add(this.metric);
    } else {
        this.metric = null;
        this._visitables.get("metric").remove(this.metric);
    }
    return (A) this;
  }
  
  public CurrentNested<A> withNewCurrent() {
    return new CurrentNested(null);
  }
  
  public CurrentNested<A> withNewCurrentLike(MetricValueStatus item) {
    return new CurrentNested(item);
  }
  
  public DescribedObjectNested<A> withNewDescribedObject() {
    return new DescribedObjectNested(null);
  }
  
  public A withNewDescribedObject(String apiVersion,String kind,String name) {
    return (A) this.withDescribedObject(new CrossVersionObjectReference(apiVersion, kind, name));
  }
  
  public DescribedObjectNested<A> withNewDescribedObjectLike(CrossVersionObjectReference item) {
    return new DescribedObjectNested(item);
  }
  
  public MetricNested<A> withNewMetric() {
    return new MetricNested(null);
  }
  
  public MetricNested<A> withNewMetricLike(MetricIdentifier item) {
    return new MetricNested(item);
  }
  public class CurrentNested<N> extends MetricValueStatusFluent<CurrentNested<N>> implements Nested<N>{
  
    MetricValueStatusBuilder builder;
  
    CurrentNested(MetricValueStatus item) {
      this.builder = new MetricValueStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) ObjectMetricStatusFluent.this.withCurrent(builder.build());
    }
    
    public N endCurrent() {
      return and();
    }
    
  }
  public class DescribedObjectNested<N> extends CrossVersionObjectReferenceFluent<DescribedObjectNested<N>> implements Nested<N>{
  
    CrossVersionObjectReferenceBuilder builder;
  
    DescribedObjectNested(CrossVersionObjectReference item) {
      this.builder = new CrossVersionObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ObjectMetricStatusFluent.this.withDescribedObject(builder.build());
    }
    
    public N endDescribedObject() {
      return and();
    }
    
  }
  public class MetricNested<N> extends MetricIdentifierFluent<MetricNested<N>> implements Nested<N>{
  
    MetricIdentifierBuilder builder;
  
    MetricNested(MetricIdentifier item) {
      this.builder = new MetricIdentifierBuilder(this, item);
    }
  
    public N and() {
      return (N) ObjectMetricStatusFluent.this.withMetric(builder.build());
    }
    
    public N endMetric() {
      return and();
    }
    
  }
}