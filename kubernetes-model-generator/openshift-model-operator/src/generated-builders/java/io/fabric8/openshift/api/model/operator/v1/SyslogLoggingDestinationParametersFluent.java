package io.fabric8.openshift.api.model.operator.v1;

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
public class SyslogLoggingDestinationParametersFluent<A extends io.fabric8.openshift.api.model.operator.v1.SyslogLoggingDestinationParametersFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String address;
  private String facility;
  private Long maxLength;
  private Long port;

  public SyslogLoggingDestinationParametersFluent() {
  }
  
  public SyslogLoggingDestinationParametersFluent(SyslogLoggingDestinationParameters instance) {
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
  
  protected void copyInstance(SyslogLoggingDestinationParameters instance) {
    instance = instance != null ? instance : new SyslogLoggingDestinationParameters();
    if (instance != null) {
        this.withAddress(instance.getAddress());
        this.withFacility(instance.getFacility());
        this.withMaxLength(instance.getMaxLength());
        this.withPort(instance.getPort());
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
    SyslogLoggingDestinationParametersFluent that = (SyslogLoggingDestinationParametersFluent) o;
    if (!(Objects.equals(address, that.address))) {
      return false;
    }
    if (!(Objects.equals(facility, that.facility))) {
      return false;
    }
    if (!(Objects.equals(maxLength, that.maxLength))) {
      return false;
    }
    if (!(Objects.equals(port, that.port))) {
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
  
  public String getAddress() {
    return this.address;
  }
  
  public String getFacility() {
    return this.facility;
  }
  
  public Long getMaxLength() {
    return this.maxLength;
  }
  
  public Long getPort() {
    return this.port;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAddress() {
    return this.address != null;
  }
  
  public boolean hasFacility() {
    return this.facility != null;
  }
  
  public boolean hasMaxLength() {
    return this.maxLength != null;
  }
  
  public boolean hasPort() {
    return this.port != null;
  }
  
  public int hashCode() {
    return Objects.hash(address, facility, maxLength, port, additionalProperties);
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
    if (!(address == null)) {
        sb.append("address:");
        sb.append(address);
        sb.append(",");
    }
    if (!(facility == null)) {
        sb.append("facility:");
        sb.append(facility);
        sb.append(",");
    }
    if (!(maxLength == null)) {
        sb.append("maxLength:");
        sb.append(maxLength);
        sb.append(",");
    }
    if (!(port == null)) {
        sb.append("port:");
        sb.append(port);
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
  
  public A withAddress(String address) {
    this.address = address;
    return (A) this;
  }
  
  public A withFacility(String facility) {
    this.facility = facility;
    return (A) this;
  }
  
  public A withMaxLength(Long maxLength) {
    this.maxLength = maxLength;
    return (A) this;
  }
  
  public A withPort(Long port) {
    this.port = port;
    return (A) this;
  }
  
}