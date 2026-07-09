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
public class PodsMetricStatusFluent<A extends io.fabric8.kubernetes.api.model.autoscaling.v2beta1.PodsMetricStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Quantity currentAverageValue;
  private String metricName;
  private LabelSelectorBuilder selector;

  public PodsMetricStatusFluent() {
  }
  
  public PodsMetricStatusFluent(PodsMetricStatus instance) {
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
  
  protected void copyInstance(PodsMetricStatus instance) {
    instance = instance != null ? instance : new PodsMetricStatus();
    if (instance != null) {
        this.withCurrentAverageValue(instance.getCurrentAverageValue());
        this.withMetricName(instance.getMetricName());
        this.withSelector(instance.getSelector());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SelectorNested<A> editOrNewSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public SelectorNested<A> editOrNewSelectorLike(LabelSelector item) {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(item));
  }
  
  public SelectorNested<A> editSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(null));
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
    PodsMetricStatusFluent that = (PodsMetricStatusFluent) o;
    if (!(Objects.equals(currentAverageValue, that.currentAverageValue))) {
      return false;
    }
    if (!(Objects.equals(metricName, that.metricName))) {
      return false;
    }
    if (!(Objects.equals(selector, that.selector))) {
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
  
  public String getMetricName() {
    return this.metricName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCurrentAverageValue() {
    return this.currentAverageValue != null;
  }
  
  public boolean hasMetricName() {
    return this.metricName != null;
  }
  
  public boolean hasSelector() {
    return this.selector != null;
  }
  
  public int hashCode() {
    return Objects.hash(currentAverageValue, metricName, selector, additionalProperties);
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
  
  public A withMetricName(String metricName) {
    this.metricName = metricName;
    return (A) this;
  }
  
  public A withNewCurrentAverageValue(String amount) {
    return (A) this.withCurrentAverageValue(new Quantity(amount));
  }
  
  public A withNewCurrentAverageValue(String amount,String format) {
    return (A) this.withCurrentAverageValue(new Quantity(amount, format));
  }
  
  public SelectorNested<A> withNewSelector() {
    return new SelectorNested(null);
  }
  
  public SelectorNested<A> withNewSelectorLike(LabelSelector item) {
    return new SelectorNested(item);
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
  public class SelectorNested<N> extends LabelSelectorFluent<SelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    SelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) PodsMetricStatusFluent.this.withSelector(builder.build());
    }
    
    public N endSelector() {
      return and();
    }
    
  }
}