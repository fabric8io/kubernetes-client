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
public class RedisExpirationSpecFluent<A extends io.fabric8.chaosmesh.v1alpha1.RedisExpirationSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String addr;
  private String expiration;
  private String key;
  private String option;
  private String password;

  public RedisExpirationSpecFluent() {
  }
  
  public RedisExpirationSpecFluent(RedisExpirationSpec instance) {
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
  
  protected void copyInstance(RedisExpirationSpec instance) {
    instance = instance != null ? instance : new RedisExpirationSpec();
    if (instance != null) {
        this.withAddr(instance.getAddr());
        this.withExpiration(instance.getExpiration());
        this.withKey(instance.getKey());
        this.withOption(instance.getOption());
        this.withPassword(instance.getPassword());
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
    RedisExpirationSpecFluent that = (RedisExpirationSpecFluent) o;
    if (!(Objects.equals(addr, that.addr))) {
      return false;
    }
    if (!(Objects.equals(expiration, that.expiration))) {
      return false;
    }
    if (!(Objects.equals(key, that.key))) {
      return false;
    }
    if (!(Objects.equals(option, that.option))) {
      return false;
    }
    if (!(Objects.equals(password, that.password))) {
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
  
  public String getExpiration() {
    return this.expiration;
  }
  
  public String getKey() {
    return this.key;
  }
  
  public String getOption() {
    return this.option;
  }
  
  public String getPassword() {
    return this.password;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAddr() {
    return this.addr != null;
  }
  
  public boolean hasExpiration() {
    return this.expiration != null;
  }
  
  public boolean hasKey() {
    return this.key != null;
  }
  
  public boolean hasOption() {
    return this.option != null;
  }
  
  public boolean hasPassword() {
    return this.password != null;
  }
  
  public int hashCode() {
    return Objects.hash(addr, expiration, key, option, password, additionalProperties);
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
    if (!(expiration == null)) {
        sb.append("expiration:");
        sb.append(expiration);
        sb.append(",");
    }
    if (!(key == null)) {
        sb.append("key:");
        sb.append(key);
        sb.append(",");
    }
    if (!(option == null)) {
        sb.append("option:");
        sb.append(option);
        sb.append(",");
    }
    if (!(password == null)) {
        sb.append("password:");
        sb.append(password);
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
  
  public A withExpiration(String expiration) {
    this.expiration = expiration;
    return (A) this;
  }
  
  public A withKey(String key) {
    this.key = key;
    return (A) this;
  }
  
  public A withOption(String option) {
    this.option = option;
    return (A) this;
  }
  
  public A withPassword(String password) {
    this.password = password;
    return (A) this;
  }
  
}