package io.fabric8.openshift.api.model.config.v1;

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
public class MaxAgePolicyFluent<A extends io.fabric8.openshift.api.model.config.v1.MaxAgePolicyFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer largestMaxAge;
  private Integer smallestMaxAge;

  public MaxAgePolicyFluent() {
  }
  
  public MaxAgePolicyFluent(MaxAgePolicy instance) {
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
  
  protected void copyInstance(MaxAgePolicy instance) {
    instance = instance != null ? instance : new MaxAgePolicy();
    if (instance != null) {
        this.withLargestMaxAge(instance.getLargestMaxAge());
        this.withSmallestMaxAge(instance.getSmallestMaxAge());
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
    MaxAgePolicyFluent that = (MaxAgePolicyFluent) o;
    if (!(Objects.equals(largestMaxAge, that.largestMaxAge))) {
      return false;
    }
    if (!(Objects.equals(smallestMaxAge, that.smallestMaxAge))) {
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
  
  public Integer getLargestMaxAge() {
    return this.largestMaxAge;
  }
  
  public Integer getSmallestMaxAge() {
    return this.smallestMaxAge;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasLargestMaxAge() {
    return this.largestMaxAge != null;
  }
  
  public boolean hasSmallestMaxAge() {
    return this.smallestMaxAge != null;
  }
  
  public int hashCode() {
    return Objects.hash(largestMaxAge, smallestMaxAge, additionalProperties);
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
    if (!(largestMaxAge == null)) {
        sb.append("largestMaxAge:");
        sb.append(largestMaxAge);
        sb.append(",");
    }
    if (!(smallestMaxAge == null)) {
        sb.append("smallestMaxAge:");
        sb.append(smallestMaxAge);
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
  
  public A withLargestMaxAge(Integer largestMaxAge) {
    this.largestMaxAge = largestMaxAge;
    return (A) this;
  }
  
  public A withSmallestMaxAge(Integer smallestMaxAge) {
    this.smallestMaxAge = smallestMaxAge;
    return (A) this;
  }
  
}