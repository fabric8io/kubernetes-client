package io.fabric8.kubernetes.api.model.resource.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.model.Quantity;
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
public class CapacityRequestPolicyRangeFluent<A extends io.fabric8.kubernetes.api.model.resource.v1beta1.CapacityRequestPolicyRangeFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Quantity max;
  private Quantity min;
  private Quantity step;

  public CapacityRequestPolicyRangeFluent() {
  }
  
  public CapacityRequestPolicyRangeFluent(CapacityRequestPolicyRange instance) {
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
  
  protected void copyInstance(CapacityRequestPolicyRange instance) {
    instance = instance != null ? instance : new CapacityRequestPolicyRange();
    if (instance != null) {
        this.withMax(instance.getMax());
        this.withMin(instance.getMin());
        this.withStep(instance.getStep());
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
    CapacityRequestPolicyRangeFluent that = (CapacityRequestPolicyRangeFluent) o;
    if (!(Objects.equals(max, that.max))) {
      return false;
    }
    if (!(Objects.equals(min, that.min))) {
      return false;
    }
    if (!(Objects.equals(step, that.step))) {
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
  
  public Quantity getMax() {
    return this.max;
  }
  
  public Quantity getMin() {
    return this.min;
  }
  
  public Quantity getStep() {
    return this.step;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMax() {
    return this.max != null;
  }
  
  public boolean hasMin() {
    return this.min != null;
  }
  
  public boolean hasStep() {
    return this.step != null;
  }
  
  public int hashCode() {
    return Objects.hash(max, min, step, additionalProperties);
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
    if (!(max == null)) {
        sb.append("max:");
        sb.append(max);
        sb.append(",");
    }
    if (!(min == null)) {
        sb.append("min:");
        sb.append(min);
        sb.append(",");
    }
    if (!(step == null)) {
        sb.append("step:");
        sb.append(step);
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
  
  public A withMax(Quantity max) {
    this.max = max;
    return (A) this;
  }
  
  public A withMin(Quantity min) {
    this.min = min;
    return (A) this;
  }
  
  public A withNewMax(String amount) {
    return (A) this.withMax(new Quantity(amount));
  }
  
  public A withNewMax(String amount,String format) {
    return (A) this.withMax(new Quantity(amount, format));
  }
  
  public A withNewMin(String amount) {
    return (A) this.withMin(new Quantity(amount));
  }
  
  public A withNewMin(String amount,String format) {
    return (A) this.withMin(new Quantity(amount, format));
  }
  
  public A withNewStep(String amount) {
    return (A) this.withStep(new Quantity(amount));
  }
  
  public A withNewStep(String amount,String format) {
    return (A) this.withStep(new Quantity(amount, format));
  }
  
  public A withStep(Quantity step) {
    this.step = step;
    return (A) this;
  }
  
}