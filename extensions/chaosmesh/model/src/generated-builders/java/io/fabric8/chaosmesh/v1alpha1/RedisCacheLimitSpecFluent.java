package io.fabric8.chaosmesh.v1alpha1;

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
public class RedisCacheLimitSpecFluent<A extends io.fabric8.chaosmesh.v1alpha1.RedisCacheLimitSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String addr;
  private String cacheSize;
  private String password;
  private String percent;

  public RedisCacheLimitSpecFluent() {
  }
  
  public RedisCacheLimitSpecFluent(RedisCacheLimitSpec instance) {
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
  
  protected void copyInstance(RedisCacheLimitSpec instance) {
    instance = instance != null ? instance : new RedisCacheLimitSpec();
    if (instance != null) {
        this.withAddr(instance.getAddr());
        this.withCacheSize(instance.getCacheSize());
        this.withPassword(instance.getPassword());
        this.withPercent(instance.getPercent());
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
    RedisCacheLimitSpecFluent that = (RedisCacheLimitSpecFluent) o;
    if (!(Objects.equals(addr, that.addr))) {
      return false;
    }
    if (!(Objects.equals(cacheSize, that.cacheSize))) {
      return false;
    }
    if (!(Objects.equals(password, that.password))) {
      return false;
    }
    if (!(Objects.equals(percent, that.percent))) {
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
  
  public String getAddr() {
    return this.addr;
  }
  
  public String getCacheSize() {
    return this.cacheSize;
  }
  
  public String getPassword() {
    return this.password;
  }
  
  public String getPercent() {
    return this.percent;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAddr() {
    return this.addr != null;
  }
  
  public boolean hasCacheSize() {
    return this.cacheSize != null;
  }
  
  public boolean hasPassword() {
    return this.password != null;
  }
  
  public boolean hasPercent() {
    return this.percent != null;
  }
  
  public int hashCode() {
    return Objects.hash(addr, cacheSize, password, percent, additionalProperties);
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
    if (!(addr == null)) {
        sb.append("addr:");
        sb.append(addr);
        sb.append(",");
    }
    if (!(cacheSize == null)) {
        sb.append("cacheSize:");
        sb.append(cacheSize);
        sb.append(",");
    }
    if (!(password == null)) {
        sb.append("password:");
        sb.append(password);
        sb.append(",");
    }
    if (!(percent == null)) {
        sb.append("percent:");
        sb.append(percent);
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
  
  public A withAddr(String addr) {
    this.addr = addr;
    return (A) this;
  }
  
  public A withCacheSize(String cacheSize) {
    this.cacheSize = cacheSize;
    return (A) this;
  }
  
  public A withPassword(String password) {
    this.password = password;
    return (A) this;
  }
  
  public A withPercent(String percent) {
    this.percent = percent;
    return (A) this;
  }
  
}