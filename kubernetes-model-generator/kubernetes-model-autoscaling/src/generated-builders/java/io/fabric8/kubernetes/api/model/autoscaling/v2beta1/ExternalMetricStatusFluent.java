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
public class ExternalMetricStatusFluent<A extends io.fabric8.kubernetes.api.model.autoscaling.v2beta1.ExternalMetricStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Quantity currentAverageValue;
  private Quantity currentValue;
  private String metricName;
  private LabelSelectorBuilder metricSelector;

  public ExternalMetricStatusFluent() {
  }
  
  public ExternalMetricStatusFluent(ExternalMetricStatus instance) {
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
  
  protected void copyInstance(ExternalMetricStatus instance) {
    instance = instance != null ? instance : new ExternalMetricStatus();
    if (instance != null) {
        this.withCurrentAverageValue(instance.getCurrentAverageValue());
        this.withCurrentValue(instance.getCurrentValue());
        this.withMetricName(instance.getMetricName());
        this.withMetricSelector(instance.getMetricSelector());
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
    ExternalMetricStatusFluent that = (ExternalMetricStatusFluent) o;
    if (!(Objects.equals(currentAverageValue, that.currentAverageValue))) {
      return false;
    }
    if (!(Objects.equals(currentValue, that.currentValue))) {
      return false;
    }
    if (!(Objects.equals(metricName, that.metricName))) {
      return false;
    }
    if (!(Objects.equals(metricSelector, that.metricSelector))) {
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
  
  public Quantity getCurrentAverageValue() {
    return this.currentAverageValue;
  }
  
  public Quantity getCurrentValue() {
    return this.currentValue;
  }
  
  public String getMetricName() {
    return this.metricName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCurrentAverageValue() {
    return this.currentAverageValue != null;
  }
  
  public boolean hasCurrentValue() {
    return this.currentValue != null;
  }
  
  public boolean hasMetricName() {
    return this.metricName != null;
  }
  
  public boolean hasMetricSelector() {
    return this.metricSelector != null;
  }
  
  public int hashCode() {
    return Objects.hash(currentAverageValue, currentValue, metricName, metricSelector, additionalProperties);
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
    if (!(currentAverageValue == null)) {
        sb.append("currentAverageValue:");
        sb.append(currentAverageValue);
        sb.append(",");
    }
    if (!(currentValue == null)) {
        sb.append("currentValue:");
        sb.append(currentValue);
        sb.append(",");
    }
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
  
  public A withCurrentAverageValue(Quantity currentAverageValue) {
    this.currentAverageValue = currentAverageValue;
    return (A) this;
  }
  
  public A withCurrentValue(Quantity currentValue) {
    this.currentValue = currentValue;
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
  
  public A withNewCurrentAverageValue(String amount) {
    return (A) this.withCurrentAverageValue(new Quantity(amount));
  }
  
  public A withNewCurrentAverageValue(String amount,String format) {
    return (A) this.withCurrentAverageValue(new Quantity(amount, format));
  }
  
  public A withNewCurrentValue(String amount) {
    return (A) this.withCurrentValue(new Quantity(amount));
  }
  
  public A withNewCurrentValue(String amount,String format) {
    return (A) this.withCurrentValue(new Quantity(amount, format));
  }
  
  public MetricSelectorNested<A> withNewMetricSelector() {
    return new MetricSelectorNested(null);
  }
  
  public MetricSelectorNested<A> withNewMetricSelectorLike(LabelSelector item) {
    return new MetricSelectorNested(item);
  }
  public class MetricSelectorNested<N> extends LabelSelectorFluent<MetricSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    MetricSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) ExternalMetricStatusFluent.this.withMetricSelector(builder.build());
    }
    
    public N endMetricSelector() {
      return and();
    }
    
  }
}