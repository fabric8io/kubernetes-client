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
public class ExternalMetricSourceFluent<A extends io.fabric8.kubernetes.api.model.autoscaling.v2beta1.ExternalMetricSourceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String metricName;
  private LabelSelectorBuilder metricSelector;
  private Quantity targetAverageValue;
  private Quantity targetValue;

  public ExternalMetricSourceFluent() {
  }
  
  public ExternalMetricSourceFluent(ExternalMetricSource instance) {
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
  
  public LabelSelector buildMetricSelector() {
    return this.metricSelector != null ? this.metricSelector.build() : null;
  }
  
  protected void copyInstance(ExternalMetricSource instance) {
    instance = instance != null ? instance : new ExternalMetricSource();
    if (instance != null) {
        this.withMetricName(instance.getMetricName());
        this.withMetricSelector(instance.getMetricSelector());
        this.withTargetAverageValue(instance.getTargetAverageValue());
        this.withTargetValue(instance.getTargetValue());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MetricSelectorNested<A> editMetricSelector() {
    return this.withNewMetricSelectorLike(Optional.ofNullable(this.buildMetricSelector()).orElse(null));
  }
  
  public MetricSelectorNested<A> editOrNewMetricSelector() {
    return this.withNewMetricSelectorLike(Optional.ofNullable(this.buildMetricSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public MetricSelectorNested<A> editOrNewMetricSelectorLike(LabelSelector item) {
    return this.withNewMetricSelectorLike(Optional.ofNullable(this.buildMetricSelector()).orElse(item));
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
    ExternalMetricSourceFluent that = (ExternalMetricSourceFluent) o;
    if (!(Objects.equals(metricName, that.metricName))) {
      return false;
    }
    if (!(Objects.equals(metricSelector, that.metricSelector))) {
      return false;
    }
    if (!(Objects.equals(targetAverageValue, that.targetAverageValue))) {
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
  
  public String getMetricName() {
    return this.metricName;
  }
  
  public Quantity getTargetAverageValue() {
    return this.targetAverageValue;
  }
  
  public Quantity getTargetValue() {
    return this.targetValue;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMetricName() {
    return this.metricName != null;
  }
  
  public boolean hasMetricSelector() {
    return this.metricSelector != null;
  }
  
  public boolean hasTargetAverageValue() {
    return this.targetAverageValue != null;
  }
  
  public boolean hasTargetValue() {
    return this.targetValue != null;
  }
  
  public int hashCode() {
    return Objects.hash(metricName, metricSelector, targetAverageValue, targetValue, additionalProperties);
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
    if (!(metricName == null)) {
        sb.append("metricName:");
        sb.append(metricName);
        sb.append(",");
    }
    if (!(metricSelector == null)) {
        sb.append("metricSelector:");
        sb.append(metricSelector);
        sb.append(",");
    }
    if (!(targetAverageValue == null)) {
        sb.append("targetAverageValue:");
        sb.append(targetAverageValue);
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
  
  public A withMetricName(String metricName) {
    this.metricName = metricName;
    return (A) this;
  }
  
  public A withMetricSelector(LabelSelector metricSelector) {
    this._visitables.remove("metricSelector");
    if (metricSelector != null) {
        this.metricSelector = new LabelSelectorBuilder(metricSelector);
        this._visitables.get("metricSelector").add(this.metricSelector);
    } else {
        this.metricSelector = null;
        this._visitables.get("metricSelector").remove(this.metricSelector);
    }
    return (A) this;
  }
  
  public MetricSelectorNested<A> withNewMetricSelector() {
    return new MetricSelectorNested(null);
  }
  
  public MetricSelectorNested<A> withNewMetricSelectorLike(LabelSelector item) {
    return new MetricSelectorNested(item);
  }
  
  public A withNewTargetAverageValue(String amount) {
    return (A) this.withTargetAverageValue(new Quantity(amount));
  }
  
  public A withNewTargetAverageValue(String amount,String format) {
    return (A) this.withTargetAverageValue(new Quantity(amount, format));
  }
  
  public A withNewTargetValue(String amount) {
    return (A) this.withTargetValue(new Quantity(amount));
  }
  
  public A withNewTargetValue(String amount,String format) {
    return (A) this.withTargetValue(new Quantity(amount, format));
  }
  
  public A withTargetAverageValue(Quantity targetAverageValue) {
    this.targetAverageValue = targetAverageValue;
    return (A) this;
  }
  
  public A withTargetValue(Quantity targetValue) {
    this.targetValue = targetValue;
    return (A) this;
  }
  public class MetricSelectorNested<N> extends LabelSelectorFluent<MetricSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    MetricSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) ExternalMetricSourceFluent.this.withMetricSelector(builder.build());
    }
    
    public N endMetricSelector() {
      return and();
    }
    
  }
}