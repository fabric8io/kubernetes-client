package io.fabric8.openshift.api.model.operator.imageregistry.v1;

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
public class ImageRegistryConfigRequestsLimitsFluent<A extends io.fabric8.openshift.api.model.operator.imageregistry.v1.ImageRegistryConfigRequestsLimitsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer maxInQueue;
  private Integer maxRunning;
  private String maxWaitInQueue;

  public ImageRegistryConfigRequestsLimitsFluent() {
  }
  
  public ImageRegistryConfigRequestsLimitsFluent(ImageRegistryConfigRequestsLimits instance) {
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
  
  protected void copyInstance(ImageRegistryConfigRequestsLimits instance) {
    instance = instance != null ? instance : new ImageRegistryConfigRequestsLimits();
    if (instance != null) {
        this.withMaxInQueue(instance.getMaxInQueue());
        this.withMaxRunning(instance.getMaxRunning());
        this.withMaxWaitInQueue(instance.getMaxWaitInQueue());
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
    ImageRegistryConfigRequestsLimitsFluent that = (ImageRegistryConfigRequestsLimitsFluent) o;
    if (!(Objects.equals(maxInQueue, that.maxInQueue))) {
      return false;
    }
    if (!(Objects.equals(maxRunning, that.maxRunning))) {
      return false;
    }
    if (!(Objects.equals(maxWaitInQueue, that.maxWaitInQueue))) {
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
  
  public Integer getMaxInQueue() {
    return this.maxInQueue;
  }
  
  public Integer getMaxRunning() {
    return this.maxRunning;
  }
  
  public String getMaxWaitInQueue() {
    return this.maxWaitInQueue;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMaxInQueue() {
    return this.maxInQueue != null;
  }
  
  public boolean hasMaxRunning() {
    return this.maxRunning != null;
  }
  
  public boolean hasMaxWaitInQueue() {
    return this.maxWaitInQueue != null;
  }
  
  public int hashCode() {
    return Objects.hash(maxInQueue, maxRunning, maxWaitInQueue, additionalProperties);
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
    if (!(maxInQueue == null)) {
        sb.append("maxInQueue:");
        sb.append(maxInQueue);
        sb.append(",");
    }
    if (!(maxRunning == null)) {
        sb.append("maxRunning:");
        sb.append(maxRunning);
        sb.append(",");
    }
    if (!(maxWaitInQueue == null)) {
        sb.append("maxWaitInQueue:");
        sb.append(maxWaitInQueue);
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
  
  public A withMaxInQueue(Integer maxInQueue) {
    this.maxInQueue = maxInQueue;
    return (A) this;
  }
  
  public A withMaxRunning(Integer maxRunning) {
    this.maxRunning = maxRunning;
    return (A) this;
  }
  
  public A withMaxWaitInQueue(String maxWaitInQueue) {
    this.maxWaitInQueue = maxWaitInQueue;
    return (A) this;
  }
  
}