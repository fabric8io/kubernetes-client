package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
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
public class LossSpecFluent<A extends io.fabric8.chaosmesh.v1alpha1.LossSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String correlation;
  private String loss;

  public LossSpecFluent() {
  }
  
  public LossSpecFluent(LossSpec instance) {
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
  
  protected void copyInstance(LossSpec instance) {
    instance = instance != null ? instance : new LossSpec();
    if (instance != null) {
        this.withCorrelation(instance.getCorrelation());
        this.withLoss(instance.getLoss());
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
    LossSpecFluent that = (LossSpecFluent) o;
    if (!(Objects.equals(correlation, that.correlation))) {
      return false;
    }
    if (!(Objects.equals(loss, that.loss))) {
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
  
  public String getCorrelation() {
    return this.correlation;
  }
  
  public String getLoss() {
    return this.loss;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCorrelation() {
    return this.correlation != null;
  }
  
  public boolean hasLoss() {
    return this.loss != null;
  }
  
  public int hashCode() {
    return Objects.hash(correlation, loss, additionalProperties);
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
    if (!(correlation == null)) {
        sb.append("correlation:");
        sb.append(correlation);
        sb.append(",");
    }
    if (!(loss == null)) {
        sb.append("loss:");
        sb.append(loss);
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
  
  public A withCorrelation(String correlation) {
    this.correlation = correlation;
    return (A) this;
  }
  
  public A withLoss(String loss) {
    this.loss = loss;
    return (A) this;
  }
  
}