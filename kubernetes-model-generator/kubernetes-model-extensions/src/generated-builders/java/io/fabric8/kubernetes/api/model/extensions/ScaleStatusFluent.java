package io.fabric8.kubernetes.api.model.extensions;

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
public class ScaleStatusFluent<A extends io.fabric8.kubernetes.api.model.extensions.ScaleStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer replicas;
  private Map<String,String> selector;
  private String targetSelector;

  public ScaleStatusFluent() {
  }
  
  public ScaleStatusFluent(ScaleStatus instance) {
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
  
  public A addToSelector(Map<String,String> map) {
    if (this.selector == null && map != null) {
      this.selector = new LinkedHashMap();
    }
    if (map != null) {
      this.selector.putAll(map);
    }
    return (A) this;
  }
  
  public A addToSelector(String key,String value) {
    if (this.selector == null && key != null && value != null) {
      this.selector = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.selector.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(ScaleStatus instance) {
    instance = instance != null ? instance : new ScaleStatus();
    if (instance != null) {
        this.withReplicas(instance.getReplicas());
        this.withSelector(instance.getSelector());
        this.withTargetSelector(instance.getTargetSelector());
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
    ScaleStatusFluent that = (ScaleStatusFluent) o;
    if (!(Objects.equals(replicas, that.replicas))) {
      return false;
    }
    if (!(Objects.equals(selector, that.selector))) {
      return false;
    }
    if (!(Objects.equals(targetSelector, that.targetSelector))) {
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
  
  public Integer getReplicas() {
    return this.replicas;
  }
  
  public Map<String,String> getSelector() {
    return this.selector;
  }
  
  public String getTargetSelector() {
    return this.targetSelector;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasReplicas() {
    return this.replicas != null;
  }
  
  public boolean hasSelector() {
    return this.selector != null;
  }
  
  public boolean hasTargetSelector() {
    return this.targetSelector != null;
  }
  
  public int hashCode() {
    return Objects.hash(replicas, selector, targetSelector, additionalProperties);
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
  
  public A removeFromSelector(String key) {
    if (this.selector == null) {
      return (A) this;
    }
    if (key != null && this.selector != null) {
      this.selector.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromSelector(Map<String,String> map) {
    if (this.selector == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.selector != null) {
          this.selector.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(replicas == null)) {
        sb.append("replicas:");
        sb.append(replicas);
        sb.append(",");
    }
    if (!(selector == null) && !(selector.isEmpty())) {
        sb.append("selector:");
        sb.append(selector);
        sb.append(",");
    }
    if (!(targetSelector == null)) {
        sb.append("targetSelector:");
        sb.append(targetSelector);
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
  
  public A withReplicas(Integer replicas) {
    this.replicas = replicas;
    return (A) this;
  }
  
  public <K,V>A withSelector(Map<String,String> selector) {
    if (selector == null) {
      this.selector = null;
    } else {
      this.selector = new LinkedHashMap(selector);
    }
    return (A) this;
  }
  
  public A withTargetSelector(String targetSelector) {
    this.targetSelector = targetSelector;
    return (A) this;
  }
  
}