package io.fabric8.knative.duck.v1;

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
public class DeliveryStatusFluent<A extends io.fabric8.knative.duck.v1.DeliveryStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String deadLetterSinkAudience;
  private String deadLetterSinkCACerts;
  private String deadLetterSinkUri;

  public DeliveryStatusFluent() {
  }
  
  public DeliveryStatusFluent(DeliveryStatus instance) {
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
  
  protected void copyInstance(DeliveryStatus instance) {
    instance = instance != null ? instance : new DeliveryStatus();
    if (instance != null) {
        this.withDeadLetterSinkAudience(instance.getDeadLetterSinkAudience());
        this.withDeadLetterSinkCACerts(instance.getDeadLetterSinkCACerts());
        this.withDeadLetterSinkUri(instance.getDeadLetterSinkUri());
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
    DeliveryStatusFluent that = (DeliveryStatusFluent) o;
    if (!(Objects.equals(deadLetterSinkAudience, that.deadLetterSinkAudience))) {
      return false;
    }
    if (!(Objects.equals(deadLetterSinkCACerts, that.deadLetterSinkCACerts))) {
      return false;
    }
    if (!(Objects.equals(deadLetterSinkUri, that.deadLetterSinkUri))) {
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
  
  public String getDeadLetterSinkAudience() {
    return this.deadLetterSinkAudience;
  }
  
  public String getDeadLetterSinkCACerts() {
    return this.deadLetterSinkCACerts;
  }
  
  public String getDeadLetterSinkUri() {
    return this.deadLetterSinkUri;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDeadLetterSinkAudience() {
    return this.deadLetterSinkAudience != null;
  }
  
  public boolean hasDeadLetterSinkCACerts() {
    return this.deadLetterSinkCACerts != null;
  }
  
  public boolean hasDeadLetterSinkUri() {
    return this.deadLetterSinkUri != null;
  }
  
  public int hashCode() {
    return Objects.hash(deadLetterSinkAudience, deadLetterSinkCACerts, deadLetterSinkUri, additionalProperties);
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
    if (!(deadLetterSinkAudience == null)) {
        sb.append("deadLetterSinkAudience:");
        sb.append(deadLetterSinkAudience);
        sb.append(",");
    }
    if (!(deadLetterSinkCACerts == null)) {
        sb.append("deadLetterSinkCACerts:");
        sb.append(deadLetterSinkCACerts);
        sb.append(",");
    }
    if (!(deadLetterSinkUri == null)) {
        sb.append("deadLetterSinkUri:");
        sb.append(deadLetterSinkUri);
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
  
  public A withDeadLetterSinkAudience(String deadLetterSinkAudience) {
    this.deadLetterSinkAudience = deadLetterSinkAudience;
    return (A) this;
  }
  
  public A withDeadLetterSinkCACerts(String deadLetterSinkCACerts) {
    this.deadLetterSinkCACerts = deadLetterSinkCACerts;
    return (A) this;
  }
  
  public A withDeadLetterSinkUri(String deadLetterSinkUri) {
    this.deadLetterSinkUri = deadLetterSinkUri;
    return (A) this;
  }
  
}