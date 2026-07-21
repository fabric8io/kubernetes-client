package io.fabric8.autoscaling.api.model.v1beta2;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Double;
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
public class HistogramCheckpointFluent<A extends io.fabric8.autoscaling.api.model.v1beta2.HistogramCheckpointFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Map<String,Long> bucketWeights;
  private String referenceTimestamp;
  private Double totalWeight;

  public HistogramCheckpointFluent() {
  }
  
  public HistogramCheckpointFluent(HistogramCheckpoint instance) {
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
  
  public A addToBucketWeights(Map<String,Long> map) {
    if (this.bucketWeights == null && map != null) {
      this.bucketWeights = new LinkedHashMap();
    }
    if (map != null) {
      this.bucketWeights.putAll(map);
    }
    return (A) this;
  }
  
  public A addToBucketWeights(String key,Long value) {
    if (this.bucketWeights == null && key != null && value != null) {
      this.bucketWeights = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.bucketWeights.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(HistogramCheckpoint instance) {
    instance = instance != null ? instance : new HistogramCheckpoint();
    if (instance != null) {
        this.withBucketWeights(instance.getBucketWeights());
        this.withReferenceTimestamp(instance.getReferenceTimestamp());
        this.withTotalWeight(instance.getTotalWeight());
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
    HistogramCheckpointFluent that = (HistogramCheckpointFluent) o;
    if (!(Objects.equals(bucketWeights, that.bucketWeights))) {
      return false;
    }
    if (!(Objects.equals(referenceTimestamp, that.referenceTimestamp))) {
      return false;
    }
    if (!(Objects.equals(totalWeight, that.totalWeight))) {
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
  
  public Map<String,Long> getBucketWeights() {
    return this.bucketWeights;
  }
  
  public String getReferenceTimestamp() {
    return this.referenceTimestamp;
  }
  
  public Double getTotalWeight() {
    return this.totalWeight;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBucketWeights() {
    return this.bucketWeights != null;
  }
  
  public boolean hasReferenceTimestamp() {
    return this.referenceTimestamp != null;
  }
  
  public boolean hasTotalWeight() {
    return this.totalWeight != null;
  }
  
  public int hashCode() {
    return Objects.hash(bucketWeights, referenceTimestamp, totalWeight, additionalProperties);
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
  
  public A removeFromBucketWeights(String key) {
    if (this.bucketWeights == null) {
      return (A) this;
    }
    if (key != null && this.bucketWeights != null) {
      this.bucketWeights.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromBucketWeights(Map<String,Long> map) {
    if (this.bucketWeights == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.bucketWeights != null) {
          this.bucketWeights.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(bucketWeights == null) && !(bucketWeights.isEmpty())) {
        sb.append("bucketWeights:");
        sb.append(bucketWeights);
        sb.append(",");
    }
    if (!(referenceTimestamp == null)) {
        sb.append("referenceTimestamp:");
        sb.append(referenceTimestamp);
        sb.append(",");
    }
    if (!(totalWeight == null)) {
        sb.append("totalWeight:");
        sb.append(totalWeight);
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
  
  public <K,V>A withBucketWeights(Map<String,Long> bucketWeights) {
    if (bucketWeights == null) {
      this.bucketWeights = null;
    } else {
      this.bucketWeights = new LinkedHashMap(bucketWeights);
    }
    return (A) this;
  }
  
  public A withReferenceTimestamp(String referenceTimestamp) {
    this.referenceTimestamp = referenceTimestamp;
    return (A) this;
  }
  
  public A withTotalWeight(Double totalWeight) {
    this.totalWeight = totalWeight;
    return (A) this;
  }
  
}