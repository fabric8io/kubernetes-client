package io.fabric8.certmanager.api.model.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.model.Duration;
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
public class CertificateRenewalWindowsFluent<A extends io.fabric8.certmanager.api.model.v1.CertificateRenewalWindowsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String cron;
  private String timezone;
  private Duration windowDuration;

  public CertificateRenewalWindowsFluent() {
  }
  
  public CertificateRenewalWindowsFluent(CertificateRenewalWindows instance) {
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
  
  protected void copyInstance(CertificateRenewalWindows instance) {
    instance = instance != null ? instance : new CertificateRenewalWindows();
    if (instance != null) {
        this.withCron(instance.getCron());
        this.withTimezone(instance.getTimezone());
        this.withWindowDuration(instance.getWindowDuration());
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
    CertificateRenewalWindowsFluent that = (CertificateRenewalWindowsFluent) o;
    if (!(Objects.equals(cron, that.cron))) {
      return false;
    }
    if (!(Objects.equals(timezone, that.timezone))) {
      return false;
    }
    if (!(Objects.equals(windowDuration, that.windowDuration))) {
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
  
  public String getCron() {
    return this.cron;
  }
  
  public String getTimezone() {
    return this.timezone;
  }
  
  public Duration getWindowDuration() {
    return this.windowDuration;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCron() {
    return this.cron != null;
  }
  
  public boolean hasTimezone() {
    return this.timezone != null;
  }
  
  public boolean hasWindowDuration() {
    return this.windowDuration != null;
  }
  
  public int hashCode() {
    return Objects.hash(cron, timezone, windowDuration, additionalProperties);
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
    if (!(cron == null)) {
        sb.append("cron:");
        sb.append(cron);
        sb.append(",");
    }
    if (!(timezone == null)) {
        sb.append("timezone:");
        sb.append(timezone);
        sb.append(",");
    }
    if (!(windowDuration == null)) {
        sb.append("windowDuration:");
        sb.append(windowDuration);
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
  
  public A withCron(String cron) {
    this.cron = cron;
    return (A) this;
  }
  
  public A withTimezone(String timezone) {
    this.timezone = timezone;
    return (A) this;
  }
  
  public A withWindowDuration(Duration windowDuration) {
    this.windowDuration = windowDuration;
    return (A) this;
  }
  
}