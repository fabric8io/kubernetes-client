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
public class ObjectMetricSourceFluent<A extends io.fabric8.kubernetes.api.model.autoscaling.v2beta2.ObjectMetricSourceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private CrossVersionObjectReferenceBuilder describedObject;
  private MetricIdentifierBuilder metric;
  private MetricTargetBuilder target;

  public ObjectMetricSourceFluent() {
  }
  
  public ObjectMetricSourceFluent(ObjectMetricSource instance) {
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
  
  public CrossVersionObjectReference buildDescribedObject() {
    return this.describedObject != null ? this.describedObject.build() : null;
  }
  
  public MetricIdentifier buildMetric() {
    return this.metric != null ? this.metric.build() : null;
  }
  
  public MetricTarget buildTarget() {
    return this.target != null ? this.target.build() : null;
  }
  
  protected void copyInstance(ObjectMetricSource instance) {
    instance = instance != null ? instance : new ObjectMetricSource();
    if (instance != null) {
        this.withDescribedObject(instance.getDescribedObject());
        this.withMetric(instance.getMetric());
        this.withTarget(instance.getTarget());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DescribedObjectNested<A> editDescribedObject() {
    return this.withNewDescribedObjectLike(Optional.ofNullable(this.buildDescribedObject()).orElse(null));
  }
  
  public MetricNested<A> editMetric() {
    return this.withNewMetricLike(Optional.ofNullable(this.buildMetric()).orElse(null));
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
  
  public TargetNested<A> editOrNewTarget() {
    return this.withNewTargetLike(Optional.ofNullable(this.buildTarget()).orElse(new MetricTargetBuilder().build()));
  }
  
  public TargetNested<A> editOrNewTargetLike(MetricTarget item) {
    return this.withNewTargetLike(Optional.ofNullable(this.buildTarget()).orElse(item));
  }
  
  public TargetNested<A> editTarget() {
    return this.withNewTargetLike(Optional.ofNullable(this.buildTarget()).orElse(null));
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
    ObjectMetricSourceFluent that = (ObjectMetricSourceFluent) o;
    if (!(Objects.equals(describedObject, that.describedObject))) {
      return false;
    }
    if (!(Objects.equals(metric, that.metric))) {
      return false;
    }
    if (!(Objects.equals(target, that.target))) {
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
  
  public boolean hasDescribedObject() {
    return this.describedObject != null;
  }
  
  public boolean hasMetric() {
    return this.metric != null;
  }
  
  public boolean hasTarget() {
    return this.target != null;
  }
  
  public int hashCode() {
    return Objects.hash(describedObject, metric, target, additionalProperties);
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
    if (!(target == null)) {
        sb.append("target:");
        sb.append(target);
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
  
  public TargetNested<A> withNewTarget() {
    return new TargetNested(null);
  }
  
  public TargetNested<A> withNewTargetLike(MetricTarget item) {
    return new TargetNested(item);
  }
  
  public A withTarget(MetricTarget target) {
    this._visitables.remove("target");
    if (target != null) {
        this.target = new MetricTargetBuilder(target);
        this._visitables.get("target").add(this.target);
    } else {
        this.target = null;
        this._visitables.get("target").remove(this.target);
    }
    return (A) this;
  }
  public class DescribedObjectNested<N> extends CrossVersionObjectReferenceFluent<DescribedObjectNested<N>> implements Nested<N>{
  
    CrossVersionObjectReferenceBuilder builder;
  
    DescribedObjectNested(CrossVersionObjectReference item) {
      this.builder = new CrossVersionObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ObjectMetricSourceFluent.this.withDescribedObject(builder.build());
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
      return (N) ObjectMetricSourceFluent.this.withMetric(builder.build());
    }
    
    public N endMetric() {
      return and();
    }
    
  }
  public class TargetNested<N> extends MetricTargetFluent<TargetNested<N>> implements Nested<N>{
  
    MetricTargetBuilder builder;
  
    TargetNested(MetricTarget item) {
      this.builder = new MetricTargetBuilder(this, item);
    }
  
    public N and() {
      return (N) ObjectMetricSourceFluent.this.withTarget(builder.build());
    }
    
    public N endTarget() {
      return and();
    }
    
  }
}