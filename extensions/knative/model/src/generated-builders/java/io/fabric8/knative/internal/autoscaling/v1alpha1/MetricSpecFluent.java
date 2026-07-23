package io.fabric8.knative.internal.autoscaling.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Long;
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
public class MetricSpecFluent<A extends io.fabric8.knative.internal.autoscaling.v1alpha1.MetricSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Long panicWindow;
  private String scrapeTarget;
  private Long stableWindow;

  public MetricSpecFluent() {
  }
  
  public MetricSpecFluent(MetricSpec instance) {
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
  
  protected void copyInstance(MetricSpec instance) {
    instance = instance != null ? instance : new MetricSpec();
    if (instance != null) {
        this.withPanicWindow(instance.getPanicWindow());
        this.withScrapeTarget(instance.getScrapeTarget());
        this.withStableWindow(instance.getStableWindow());
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
    MetricSpecFluent that = (MetricSpecFluent) o;
    if (!(Objects.equals(panicWindow, that.panicWindow))) {
      return false;
    }
    if (!(Objects.equals(scrapeTarget, that.scrapeTarget))) {
      return false;
    }
    if (!(Objects.equals(stableWindow, that.stableWindow))) {
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
  
  public Long getPanicWindow() {
    return this.panicWindow;
  }
  
  public String getScrapeTarget() {
    return this.scrapeTarget;
  }
  
  public Long getStableWindow() {
    return this.stableWindow;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasPanicWindow() {
    return this.panicWindow != null;
  }
  
  public boolean hasScrapeTarget() {
    return this.scrapeTarget != null;
  }
  
  public boolean hasStableWindow() {
    return this.stableWindow != null;
  }
  
  public int hashCode() {
    return Objects.hash(panicWindow, scrapeTarget, stableWindow, additionalProperties);
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
    if (!(panicWindow == null)) {
        sb.append("panicWindow:");
        sb.append(panicWindow);
        sb.append(",");
    }
    if (!(scrapeTarget == null)) {
        sb.append("scrapeTarget:");
        sb.append(scrapeTarget);
        sb.append(",");
    }
    if (!(stableWindow == null)) {
        sb.append("stableWindow:");
        sb.append(stableWindow);
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
  
  public A withPanicWindow(Long panicWindow) {
    this.panicWindow = panicWindow;
    return (A) this;
  }
  
  public A withScrapeTarget(String scrapeTarget) {
    this.scrapeTarget = scrapeTarget;
    return (A) this;
  }
  
  public A withStableWindow(Long stableWindow) {
    this.stableWindow = stableWindow;
    return (A) this;
  }
  
}