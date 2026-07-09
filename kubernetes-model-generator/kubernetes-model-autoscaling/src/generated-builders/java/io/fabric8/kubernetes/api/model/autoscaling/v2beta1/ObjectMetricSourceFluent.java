package io.fabric8.kubernetes.api.model.autoscaling.v2beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LabelSelectorBuilder;
import io.fabric8.kubernetes.api.model.LabelSelectorFluent;
import io.fabric8.kubernetes.api.model.Quantity;
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
public class ObjectMetricSourceFluent<A extends io.fabric8.kubernetes.api.model.autoscaling.v2beta1.ObjectMetricSourceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Quantity averageValue;
  private String metricName;
  private LabelSelectorBuilder selector;
  private CrossVersionObjectReferenceBuilder target;
  private Quantity targetValue;

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
  
  public LabelSelector buildSelector() {
    return this.selector != null ? this.selector.build() : null;
  }
  
  public CrossVersionObjectReference buildTarget() {
    return this.target != null ? this.target.build() : null;
  }
  
  protected void copyInstance(ObjectMetricSource instance) {
    instance = instance != null ? instance : new ObjectMetricSource();
    if (instance != null) {
        this.withAverageValue(instance.getAverageValue());
        this.withMetricName(instance.getMetricName());
        this.withSelector(instance.getSelector());
        this.withTarget(instance.getTarget());
        this.withTargetValue(instance.getTargetValue());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SelectorNested<A> editOrNewSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public SelectorNested<A> editOrNewSelectorLike(LabelSelector item) {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(item));
  }
  
  public TargetNested<A> editOrNewTarget() {
    return this.withNewTargetLike(Optional.ofNullable(this.buildTarget()).orElse(new CrossVersionObjectReferenceBuilder().build()));
  }
  
  public TargetNested<A> editOrNewTargetLike(CrossVersionObjectReference item) {
    return this.withNewTargetLike(Optional.ofNullable(this.buildTarget()).orElse(item));
  }
  
  public SelectorNested<A> editSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(null));
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
    if (!(Objects.equals(averageValue, that.averageValue))) {
      return false;
    }
    if (!(Objects.equals(metricName, that.metricName))) {
      return false;
    }
    if (!(Objects.equals(selector, that.selector))) {
      return false;
    }
    if (!(Objects.equals(target, that.target))) {
      return false;
    }
    if (!(Objects.equals(targetValue, that.targetValue))) {
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
  
  public Quantity getAverageValue() {
    return this.averageValue;
  }
  
  public String getMetricName() {
    return this.metricName;
  }
  
  public Quantity getTargetValue() {
    return this.targetValue;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAverageValue() {
    return this.averageValue != null;
  }
  
  public boolean hasMetricName() {
    return this.metricName != null;
  }
  
  public boolean hasSelector() {
    return this.selector != null;
  }
  
  public boolean hasTarget() {
    return this.target != null;
  }
  
  public boolean hasTargetValue() {
    return this.targetValue != null;
  }
  
  public int hashCode() {
    return Objects.hash(averageValue, metricName, selector, target, targetValue, additionalProperties);
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
    if (!(averageValue == null)) {
        sb.append("averageValue:");
        sb.append(averageValue);
        sb.append(",");
    }
    if (!(metricName == null)) {
        sb.append("metricName:");
        sb.append(metricName);
        sb.append(",");
    }
    if (!(selector == null)) {
        sb.append("selector:");
        sb.append(selector);
        sb.append(",");
    }
    if (!(target == null)) {
        sb.append("target:");
        sb.append(target);
        sb.append(",");
    }
    if (!(targetValue == null)) {
        sb.append("targetValue:");
        sb.append(targetValue);
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
  
  public A withAverageValue(Quantity averageValue) {
    this.averageValue = averageValue;
    return (A) this;
  }
  
  public A withMetricName(String metricName) {
    this.metricName = metricName;
    return (A) this;
  }
  
  public A withNewAverageValue(String amount) {
    return (A) this.withAverageValue(new Quantity(amount));
  }
  
  public A withNewAverageValue(String amount,String format) {
    return (A) this.withAverageValue(new Quantity(amount, format));
  }
  
  public SelectorNested<A> withNewSelector() {
    return new SelectorNested(null);
  }
  
  public SelectorNested<A> withNewSelectorLike(LabelSelector item) {
    return new SelectorNested(item);
  }
  
  public TargetNested<A> withNewTarget() {
    return new TargetNested(null);
  }
  
  public A withNewTarget(String apiVersion,String kind,String name) {
    return (A) this.withTarget(new CrossVersionObjectReference(apiVersion, kind, name));
  }
  
  public TargetNested<A> withNewTargetLike(CrossVersionObjectReference item) {
    return new TargetNested(item);
  }
  
  public A withNewTargetValue(String amount) {
    return (A) this.withTargetValue(new Quantity(amount));
  }
  
  public A withNewTargetValue(String amount,String format) {
    return (A) this.withTargetValue(new Quantity(amount, format));
  }
  
  public A withSelector(LabelSelector selector) {
    this._visitables.remove("selector");
    if (selector != null) {
        this.selector = new LabelSelectorBuilder(selector);
        this._visitables.get("selector").add(this.selector);
    } else {
        this.selector = null;
        this._visitables.get("selector").remove(this.selector);
    }
    return (A) this;
  }
  
  public A withTarget(CrossVersionObjectReference target) {
    this._visitables.remove("target");
    if (target != null) {
        this.target = new CrossVersionObjectReferenceBuilder(target);
        this._visitables.get("target").add(this.target);
    } else {
        this.target = null;
        this._visitables.get("target").remove(this.target);
    }
    return (A) this;
  }
  
  public A withTargetValue(Quantity targetValue) {
    this.targetValue = targetValue;
    return (A) this;
  }
  public class SelectorNested<N> extends LabelSelectorFluent<SelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    SelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) ObjectMetricSourceFluent.this.withSelector(builder.build());
    }
    
    public N endSelector() {
      return and();
    }
    
  }
  public class TargetNested<N> extends CrossVersionObjectReferenceFluent<TargetNested<N>> implements Nested<N>{
  
    CrossVersionObjectReferenceBuilder builder;
  
    TargetNested(CrossVersionObjectReference item) {
      this.builder = new CrossVersionObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ObjectMetricSourceFluent.this.withTarget(builder.build());
    }
    
    public N endTarget() {
      return and();
    }
    
  }
}