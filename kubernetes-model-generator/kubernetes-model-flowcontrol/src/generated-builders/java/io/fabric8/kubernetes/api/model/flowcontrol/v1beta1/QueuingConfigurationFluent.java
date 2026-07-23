package io.fabric8.kubernetes.api.model.flowcontrol.v1beta1;

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
public class QueuingConfigurationFluent<A extends io.fabric8.kubernetes.api.model.flowcontrol.v1beta1.QueuingConfigurationFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer handSize;
  private Integer queueLengthLimit;
  private Integer queues;

  public QueuingConfigurationFluent() {
  }
  
  public QueuingConfigurationFluent(QueuingConfiguration instance) {
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
  
  protected void copyInstance(QueuingConfiguration instance) {
    instance = instance != null ? instance : new QueuingConfiguration();
    if (instance != null) {
        this.withHandSize(instance.getHandSize());
        this.withQueueLengthLimit(instance.getQueueLengthLimit());
        this.withQueues(instance.getQueues());
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
    QueuingConfigurationFluent that = (QueuingConfigurationFluent) o;
    if (!(Objects.equals(handSize, that.handSize))) {
      return false;
    }
    if (!(Objects.equals(queueLengthLimit, that.queueLengthLimit))) {
      return false;
    }
    if (!(Objects.equals(queues, that.queues))) {
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
  
  public Integer getHandSize() {
    return this.handSize;
  }
  
  public Integer getQueueLengthLimit() {
    return this.queueLengthLimit;
  }
  
  public Integer getQueues() {
    return this.queues;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasHandSize() {
    return this.handSize != null;
  }
  
  public boolean hasQueueLengthLimit() {
    return this.queueLengthLimit != null;
  }
  
  public boolean hasQueues() {
    return this.queues != null;
  }
  
  public int hashCode() {
    return Objects.hash(handSize, queueLengthLimit, queues, additionalProperties);
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
    if (!(handSize == null)) {
        sb.append("handSize:");
        sb.append(handSize);
        sb.append(",");
    }
    if (!(queueLengthLimit == null)) {
        sb.append("queueLengthLimit:");
        sb.append(queueLengthLimit);
        sb.append(",");
    }
    if (!(queues == null)) {
        sb.append("queues:");
        sb.append(queues);
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
  
  public A withHandSize(Integer handSize) {
    this.handSize = handSize;
    return (A) this;
  }
  
  public A withQueueLengthLimit(Integer queueLengthLimit) {
    this.queueLengthLimit = queueLengthLimit;
    return (A) this;
  }
  
  public A withQueues(Integer queues) {
    this.queues = queues;
    return (A) this;
  }
  
}