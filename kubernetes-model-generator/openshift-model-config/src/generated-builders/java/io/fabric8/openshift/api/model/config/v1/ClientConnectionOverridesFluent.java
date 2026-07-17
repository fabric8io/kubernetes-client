package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Float;
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
public class ClientConnectionOverridesFluent<A extends io.fabric8.openshift.api.model.config.v1.ClientConnectionOverridesFluent<A>> extends BaseFluent<A>{

  private String acceptContentTypes;
  private Map<String,Object> additionalProperties;
  private Integer burst;
  private String contentType;
  private Float qps;

  public ClientConnectionOverridesFluent() {
  }
  
  public ClientConnectionOverridesFluent(ClientConnectionOverrides instance) {
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
  
  protected void copyInstance(ClientConnectionOverrides instance) {
    instance = instance != null ? instance : new ClientConnectionOverrides();
    if (instance != null) {
        this.withAcceptContentTypes(instance.getAcceptContentTypes());
        this.withBurst(instance.getBurst());
        this.withContentType(instance.getContentType());
        this.withQps(instance.getQps());
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
    ClientConnectionOverridesFluent that = (ClientConnectionOverridesFluent) o;
    if (!(Objects.equals(acceptContentTypes, that.acceptContentTypes))) {
      return false;
    }
    if (!(Objects.equals(burst, that.burst))) {
      return false;
    }
    if (!(Objects.equals(contentType, that.contentType))) {
      return false;
    }
    if (!(Objects.equals(qps, that.qps))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public String getAcceptContentTypes() {
    return this.acceptContentTypes;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public Integer getBurst() {
    return this.burst;
  }
  
  public String getContentType() {
    return this.contentType;
  }
  
  public Float getQps() {
    return this.qps;
  }
  
  public boolean hasAcceptContentTypes() {
    return this.acceptContentTypes != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBurst() {
    return this.burst != null;
  }
  
  public boolean hasContentType() {
    return this.contentType != null;
  }
  
  public boolean hasQps() {
    return this.qps != null;
  }
  
  public int hashCode() {
    return Objects.hash(acceptContentTypes, burst, contentType, qps, additionalProperties);
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
    if (!(acceptContentTypes == null)) {
        sb.append("acceptContentTypes:");
        sb.append(acceptContentTypes);
        sb.append(",");
    }
    if (!(burst == null)) {
        sb.append("burst:");
        sb.append(burst);
        sb.append(",");
    }
    if (!(contentType == null)) {
        sb.append("contentType:");
        sb.append(contentType);
        sb.append(",");
    }
    if (!(qps == null)) {
        sb.append("qps:");
        sb.append(qps);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAcceptContentTypes(String acceptContentTypes) {
    this.acceptContentTypes = acceptContentTypes;
    return (A) this;
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withBurst(Integer burst) {
    this.burst = burst;
    return (A) this;
  }
  
  public A withContentType(String contentType) {
    this.contentType = contentType;
    return (A) this;
  }
  
  public A withQps(Float qps) {
    this.qps = qps;
    return (A) this;
  }
  
}