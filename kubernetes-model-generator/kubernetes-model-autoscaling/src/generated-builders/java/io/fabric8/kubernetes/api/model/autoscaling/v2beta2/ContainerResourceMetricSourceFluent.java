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
public class ContainerResourceMetricSourceFluent<A extends io.fabric8.kubernetes.api.model.autoscaling.v2beta2.ContainerResourceMetricSourceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String container;
  private String name;
  private MetricTargetBuilder target;

  public ContainerResourceMetricSourceFluent() {
  }
  
  public ContainerResourceMetricSourceFluent(ContainerResourceMetricSource instance) {
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
  
  public MetricTarget buildTarget() {
    return this.target != null ? this.target.build() : null;
  }
  
  protected void copyInstance(ContainerResourceMetricSource instance) {
    instance = instance != null ? instance : new ContainerResourceMetricSource();
    if (instance != null) {
        this.withContainer(instance.getContainer());
        this.withName(instance.getName());
        this.withTarget(instance.getTarget());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
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
    ContainerResourceMetricSourceFluent that = (ContainerResourceMetricSourceFluent) o;
    if (!(Objects.equals(container, that.container))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
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
  
  public String getContainer() {
    return this.container;
  }
  
  public String getName() {
    return this.name;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasContainer() {
    return this.container != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasTarget() {
    return this.target != null;
  }
  
  public int hashCode() {
    return Objects.hash(container, name, target, additionalProperties);
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
    if (!(container == null)) {
        sb.append("container:");
        sb.append(container);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
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
  
  public A withContainer(String container) {
    this.container = container;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
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
  public class TargetNested<N> extends MetricTargetFluent<TargetNested<N>> implements Nested<N>{
  
    MetricTargetBuilder builder;
  
    TargetNested(MetricTarget item) {
      this.builder = new MetricTargetBuilder(this, item);
    }
  
    public N and() {
      return (N) ContainerResourceMetricSourceFluent.this.withTarget(builder.build());
    }
    
    public N endTarget() {
      return and();
    }
    
  }
}