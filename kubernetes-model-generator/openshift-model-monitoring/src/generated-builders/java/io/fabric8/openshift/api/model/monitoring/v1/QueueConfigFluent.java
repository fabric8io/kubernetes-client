package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Boolean;
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
public class QueueConfigFluent<A extends io.fabric8.openshift.api.model.monitoring.v1.QueueConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String batchSendDeadline;
  private Integer capacity;
  private String maxBackoff;
  private Integer maxRetries;
  private Integer maxSamplesPerSend;
  private Integer maxShards;
  private String minBackoff;
  private Integer minShards;
  private Boolean retryOnRateLimit;
  private String sampleAgeLimit;

  public QueueConfigFluent() {
  }
  
  public QueueConfigFluent(QueueConfig instance) {
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
  
  protected void copyInstance(QueueConfig instance) {
    instance = instance != null ? instance : new QueueConfig();
    if (instance != null) {
        this.withBatchSendDeadline(instance.getBatchSendDeadline());
        this.withCapacity(instance.getCapacity());
        this.withMaxBackoff(instance.getMaxBackoff());
        this.withMaxRetries(instance.getMaxRetries());
        this.withMaxSamplesPerSend(instance.getMaxSamplesPerSend());
        this.withMaxShards(instance.getMaxShards());
        this.withMinBackoff(instance.getMinBackoff());
        this.withMinShards(instance.getMinShards());
        this.withRetryOnRateLimit(instance.getRetryOnRateLimit());
        this.withSampleAgeLimit(instance.getSampleAgeLimit());
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
    QueueConfigFluent that = (QueueConfigFluent) o;
    if (!(Objects.equals(batchSendDeadline, that.batchSendDeadline))) {
      return false;
    }
    if (!(Objects.equals(capacity, that.capacity))) {
      return false;
    }
    if (!(Objects.equals(maxBackoff, that.maxBackoff))) {
      return false;
    }
    if (!(Objects.equals(maxRetries, that.maxRetries))) {
      return false;
    }
    if (!(Objects.equals(maxSamplesPerSend, that.maxSamplesPerSend))) {
      return false;
    }
    if (!(Objects.equals(maxShards, that.maxShards))) {
      return false;
    }
    if (!(Objects.equals(minBackoff, that.minBackoff))) {
      return false;
    }
    if (!(Objects.equals(minShards, that.minShards))) {
      return false;
    }
    if (!(Objects.equals(retryOnRateLimit, that.retryOnRateLimit))) {
      return false;
    }
    if (!(Objects.equals(sampleAgeLimit, that.sampleAgeLimit))) {
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
  
  public String getBatchSendDeadline() {
    return this.batchSendDeadline;
  }
  
  public Integer getCapacity() {
    return this.capacity;
  }
  
  public String getMaxBackoff() {
    return this.maxBackoff;
  }
  
  public Integer getMaxRetries() {
    return this.maxRetries;
  }
  
  public Integer getMaxSamplesPerSend() {
    return this.maxSamplesPerSend;
  }
  
  public Integer getMaxShards() {
    return this.maxShards;
  }
  
  public String getMinBackoff() {
    return this.minBackoff;
  }
  
  public Integer getMinShards() {
    return this.minShards;
  }
  
  public Boolean getRetryOnRateLimit() {
    return this.retryOnRateLimit;
  }
  
  public String getSampleAgeLimit() {
    return this.sampleAgeLimit;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBatchSendDeadline() {
    return this.batchSendDeadline != null;
  }
  
  public boolean hasCapacity() {
    return this.capacity != null;
  }
  
  public boolean hasMaxBackoff() {
    return this.maxBackoff != null;
  }
  
  public boolean hasMaxRetries() {
    return this.maxRetries != null;
  }
  
  public boolean hasMaxSamplesPerSend() {
    return this.maxSamplesPerSend != null;
  }
  
  public boolean hasMaxShards() {
    return this.maxShards != null;
  }
  
  public boolean hasMinBackoff() {
    return this.minBackoff != null;
  }
  
  public boolean hasMinShards() {
    return this.minShards != null;
  }
  
  public boolean hasRetryOnRateLimit() {
    return this.retryOnRateLimit != null;
  }
  
  public boolean hasSampleAgeLimit() {
    return this.sampleAgeLimit != null;
  }
  
  public int hashCode() {
    return Objects.hash(batchSendDeadline, capacity, maxBackoff, maxRetries, maxSamplesPerSend, maxShards, minBackoff, minShards, retryOnRateLimit, sampleAgeLimit, additionalProperties);
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
    if (!(batchSendDeadline == null)) {
        sb.append("batchSendDeadline:");
        sb.append(batchSendDeadline);
        sb.append(",");
    }
    if (!(capacity == null)) {
        sb.append("capacity:");
        sb.append(capacity);
        sb.append(",");
    }
    if (!(maxBackoff == null)) {
        sb.append("maxBackoff:");
        sb.append(maxBackoff);
        sb.append(",");
    }
    if (!(maxRetries == null)) {
        sb.append("maxRetries:");
        sb.append(maxRetries);
        sb.append(",");
    }
    if (!(maxSamplesPerSend == null)) {
        sb.append("maxSamplesPerSend:");
        sb.append(maxSamplesPerSend);
        sb.append(",");
    }
    if (!(maxShards == null)) {
        sb.append("maxShards:");
        sb.append(maxShards);
        sb.append(",");
    }
    if (!(minBackoff == null)) {
        sb.append("minBackoff:");
        sb.append(minBackoff);
        sb.append(",");
    }
    if (!(minShards == null)) {
        sb.append("minShards:");
        sb.append(minShards);
        sb.append(",");
    }
    if (!(retryOnRateLimit == null)) {
        sb.append("retryOnRateLimit:");
        sb.append(retryOnRateLimit);
        sb.append(",");
    }
    if (!(sampleAgeLimit == null)) {
        sb.append("sampleAgeLimit:");
        sb.append(sampleAgeLimit);
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
  
  public A withBatchSendDeadline(String batchSendDeadline) {
    this.batchSendDeadline = batchSendDeadline;
    return (A) this;
  }
  
  public A withCapacity(Integer capacity) {
    this.capacity = capacity;
    return (A) this;
  }
  
  public A withMaxBackoff(String maxBackoff) {
    this.maxBackoff = maxBackoff;
    return (A) this;
  }
  
  public A withMaxRetries(Integer maxRetries) {
    this.maxRetries = maxRetries;
    return (A) this;
  }
  
  public A withMaxSamplesPerSend(Integer maxSamplesPerSend) {
    this.maxSamplesPerSend = maxSamplesPerSend;
    return (A) this;
  }
  
  public A withMaxShards(Integer maxShards) {
    this.maxShards = maxShards;
    return (A) this;
  }
  
  public A withMinBackoff(String minBackoff) {
    this.minBackoff = minBackoff;
    return (A) this;
  }
  
  public A withMinShards(Integer minShards) {
    this.minShards = minShards;
    return (A) this;
  }
  
  public A withRetryOnRateLimit() {
    return withRetryOnRateLimit(true);
  }
  
  public A withRetryOnRateLimit(Boolean retryOnRateLimit) {
    this.retryOnRateLimit = retryOnRateLimit;
    return (A) this;
  }
  
  public A withSampleAgeLimit(String sampleAgeLimit) {
    this.sampleAgeLimit = sampleAgeLimit;
    return (A) this;
  }
  
}