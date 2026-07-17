package io.fabric8.openshift.api.model.miscellaneous.network.v1alpha1;

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
public class DNSNameResolverResolvedAddressFluent<A extends io.fabric8.openshift.api.model.miscellaneous.network.v1alpha1.DNSNameResolverResolvedAddressFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String ip;
  private String lastLookupTime;
  private Integer ttlSeconds;

  public DNSNameResolverResolvedAddressFluent() {
  }
  
  public DNSNameResolverResolvedAddressFluent(DNSNameResolverResolvedAddress instance) {
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
  
  protected void copyInstance(DNSNameResolverResolvedAddress instance) {
    instance = instance != null ? instance : new DNSNameResolverResolvedAddress();
    if (instance != null) {
        this.withIp(instance.getIp());
        this.withLastLookupTime(instance.getLastLookupTime());
        this.withTtlSeconds(instance.getTtlSeconds());
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
    DNSNameResolverResolvedAddressFluent that = (DNSNameResolverResolvedAddressFluent) o;
    if (!(Objects.equals(ip, that.ip))) {
      return false;
    }
    if (!(Objects.equals(lastLookupTime, that.lastLookupTime))) {
      return false;
    }
    if (!(Objects.equals(ttlSeconds, that.ttlSeconds))) {
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
  
  public String getIp() {
    return this.ip;
  }
  
  public String getLastLookupTime() {
    return this.lastLookupTime;
  }
  
  public Integer getTtlSeconds() {
    return this.ttlSeconds;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasIp() {
    return this.ip != null;
  }
  
  public boolean hasLastLookupTime() {
    return this.lastLookupTime != null;
  }
  
  public boolean hasTtlSeconds() {
    return this.ttlSeconds != null;
  }
  
  public int hashCode() {
    return Objects.hash(ip, lastLookupTime, ttlSeconds, additionalProperties);
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
    if (!(ip == null)) {
        sb.append("ip:");
        sb.append(ip);
        sb.append(",");
    }
    if (!(lastLookupTime == null)) {
        sb.append("lastLookupTime:");
        sb.append(lastLookupTime);
        sb.append(",");
    }
    if (!(ttlSeconds == null)) {
        sb.append("ttlSeconds:");
        sb.append(ttlSeconds);
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
  
  public A withIp(String ip) {
    this.ip = ip;
    return (A) this;
  }
  
  public A withLastLookupTime(String lastLookupTime) {
    this.lastLookupTime = lastLookupTime;
    return (A) this;
  }
  
  public A withTtlSeconds(Integer ttlSeconds) {
    this.ttlSeconds = ttlSeconds;
    return (A) this;
  }
  
}