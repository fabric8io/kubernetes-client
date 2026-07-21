package io.fabric8.chaosmesh.v1alpha1;

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
public class RedisPenetrationSpecFluent<A extends io.fabric8.chaosmesh.v1alpha1.RedisPenetrationSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String addr;
  private String password;
  private Integer requestNum;

  public RedisPenetrationSpecFluent() {
  }
  
  public RedisPenetrationSpecFluent(RedisPenetrationSpec instance) {
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
  
  protected void copyInstance(RedisPenetrationSpec instance) {
    instance = instance != null ? instance : new RedisPenetrationSpec();
    if (instance != null) {
        this.withAddr(instance.getAddr());
        this.withPassword(instance.getPassword());
        this.withRequestNum(instance.getRequestNum());
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
    RedisPenetrationSpecFluent that = (RedisPenetrationSpecFluent) o;
    if (!(Objects.equals(addr, that.addr))) {
      return false;
    }
    if (!(Objects.equals(password, that.password))) {
      return false;
    }
    if (!(Objects.equals(requestNum, that.requestNum))) {
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
  
  public String getPassword() {
    return this.password;
  }
  
  public Integer getRequestNum() {
    return this.requestNum;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAddr() {
    return this.addr != null;
  }
  
  public boolean hasPassword() {
    return this.password != null;
  }
  
  public boolean hasRequestNum() {
    return this.requestNum != null;
  }
  
  public int hashCode() {
    return Objects.hash(addr, password, requestNum, additionalProperties);
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
    if (!(password == null)) {
        sb.append("password:");
        sb.append(password);
        sb.append(",");
    }
    if (!(requestNum == null)) {
        sb.append("requestNum:");
        sb.append(requestNum);
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
  
  public A withPassword(String password) {
    this.password = password;
    return (A) this;
  }
  
  public A withRequestNum(Integer requestNum) {
    this.requestNum = requestNum;
    return (A) this;
  }
  
}