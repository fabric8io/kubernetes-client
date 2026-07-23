package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Integer;
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
public class ReorderSpecFluent<A extends io.fabric8.chaosmesh.v1alpha1.ReorderSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String correlation;
  private Integer gap;
  private String reorder;

  public ReorderSpecFluent() {
  }
  
  public ReorderSpecFluent(ReorderSpec instance) {
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
  
  protected void copyInstance(ReorderSpec instance) {
    instance = instance != null ? instance : new ReorderSpec();
    if (instance != null) {
        this.withCorrelation(instance.getCorrelation());
        this.withGap(instance.getGap());
        this.withReorder(instance.getReorder());
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
    ReorderSpecFluent that = (ReorderSpecFluent) o;
    if (!(Objects.equals(correlation, that.correlation))) {
      return false;
    }
    if (!(Objects.equals(gap, that.gap))) {
      return false;
    }
    if (!(Objects.equals(reorder, that.reorder))) {
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
  
  public Integer getGap() {
    return this.gap;
  }
  
  public String getReorder() {
    return this.reorder;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCorrelation() {
    return this.correlation != null;
  }
  
  public boolean hasGap() {
    return this.gap != null;
  }
  
  public boolean hasReorder() {
    return this.reorder != null;
  }
  
  public int hashCode() {
    return Objects.hash(correlation, gap, reorder, additionalProperties);
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
    if (!(gap == null)) {
        sb.append("gap:");
        sb.append(gap);
        sb.append(",");
    }
    if (!(reorder == null)) {
        sb.append("reorder:");
        sb.append(reorder);
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
  
  public A withGap(Integer gap) {
    this.gap = gap;
    return (A) this;
  }
  
  public A withReorder(String reorder) {
    this.reorder = reorder;
    return (A) this;
  }
  
}