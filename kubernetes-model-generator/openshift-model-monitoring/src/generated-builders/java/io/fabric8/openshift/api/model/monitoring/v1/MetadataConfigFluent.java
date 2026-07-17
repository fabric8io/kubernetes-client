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
public class MetadataConfigFluent<A extends io.fabric8.openshift.api.model.monitoring.v1.MetadataConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer maxSamplesPerSend;
  private Boolean send;
  private String sendInterval;

  public MetadataConfigFluent() {
  }
  
  public MetadataConfigFluent(MetadataConfig instance) {
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
  
  protected void copyInstance(MetadataConfig instance) {
    instance = instance != null ? instance : new MetadataConfig();
    if (instance != null) {
        this.withMaxSamplesPerSend(instance.getMaxSamplesPerSend());
        this.withSend(instance.getSend());
        this.withSendInterval(instance.getSendInterval());
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
    MetadataConfigFluent that = (MetadataConfigFluent) o;
    if (!(Objects.equals(maxSamplesPerSend, that.maxSamplesPerSend))) {
      return false;
    }
    if (!(Objects.equals(send, that.send))) {
      return false;
    }
    if (!(Objects.equals(sendInterval, that.sendInterval))) {
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
  
  public Integer getMaxSamplesPerSend() {
    return this.maxSamplesPerSend;
  }
  
  public Boolean getSend() {
    return this.send;
  }
  
  public String getSendInterval() {
    return this.sendInterval;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMaxSamplesPerSend() {
    return this.maxSamplesPerSend != null;
  }
  
  public boolean hasSend() {
    return this.send != null;
  }
  
  public boolean hasSendInterval() {
    return this.sendInterval != null;
  }
  
  public int hashCode() {
    return Objects.hash(maxSamplesPerSend, send, sendInterval, additionalProperties);
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
    if (!(maxSamplesPerSend == null)) {
        sb.append("maxSamplesPerSend:");
        sb.append(maxSamplesPerSend);
        sb.append(",");
    }
    if (!(send == null)) {
        sb.append("send:");
        sb.append(send);
        sb.append(",");
    }
    if (!(sendInterval == null)) {
        sb.append("sendInterval:");
        sb.append(sendInterval);
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
  
  public A withMaxSamplesPerSend(Integer maxSamplesPerSend) {
    this.maxSamplesPerSend = maxSamplesPerSend;
    return (A) this;
  }
  
  public A withSend() {
    return withSend(true);
  }
  
  public A withSend(Boolean send) {
    this.send = send;
    return (A) this;
  }
  
  public A withSendInterval(String sendInterval) {
    this.sendInterval = sendInterval;
    return (A) this;
  }
  
}