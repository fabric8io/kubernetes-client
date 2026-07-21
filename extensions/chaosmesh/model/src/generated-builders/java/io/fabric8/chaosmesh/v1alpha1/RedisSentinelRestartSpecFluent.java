package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Boolean;
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
public class RedisSentinelRestartSpecFluent<A extends io.fabric8.chaosmesh.v1alpha1.RedisSentinelRestartSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String addr;
  private String conf;
  private Boolean flushConfig;
  private String password;
  private Boolean redisPath;

  public RedisSentinelRestartSpecFluent() {
  }
  
  public RedisSentinelRestartSpecFluent(RedisSentinelRestartSpec instance) {
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
  
  protected void copyInstance(RedisSentinelRestartSpec instance) {
    instance = instance != null ? instance : new RedisSentinelRestartSpec();
    if (instance != null) {
        this.withAddr(instance.getAddr());
        this.withConf(instance.getConf());
        this.withFlushConfig(instance.getFlushConfig());
        this.withPassword(instance.getPassword());
        this.withRedisPath(instance.getRedisPath());
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
    RedisSentinelRestartSpecFluent that = (RedisSentinelRestartSpecFluent) o;
    if (!(Objects.equals(addr, that.addr))) {
      return false;
    }
    if (!(Objects.equals(conf, that.conf))) {
      return false;
    }
    if (!(Objects.equals(flushConfig, that.flushConfig))) {
      return false;
    }
    if (!(Objects.equals(password, that.password))) {
      return false;
    }
    if (!(Objects.equals(redisPath, that.redisPath))) {
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
  
  public String getConf() {
    return this.conf;
  }
  
  public Boolean getFlushConfig() {
    return this.flushConfig;
  }
  
  public String getPassword() {
    return this.password;
  }
  
  public Boolean getRedisPath() {
    return this.redisPath;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAddr() {
    return this.addr != null;
  }
  
  public boolean hasConf() {
    return this.conf != null;
  }
  
  public boolean hasFlushConfig() {
    return this.flushConfig != null;
  }
  
  public boolean hasPassword() {
    return this.password != null;
  }
  
  public boolean hasRedisPath() {
    return this.redisPath != null;
  }
  
  public int hashCode() {
    return Objects.hash(addr, conf, flushConfig, password, redisPath, additionalProperties);
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
    if (!(conf == null)) {
        sb.append("conf:");
        sb.append(conf);
        sb.append(",");
    }
    if (!(flushConfig == null)) {
        sb.append("flushConfig:");
        sb.append(flushConfig);
        sb.append(",");
    }
    if (!(password == null)) {
        sb.append("password:");
        sb.append(password);
        sb.append(",");
    }
    if (!(redisPath == null)) {
        sb.append("redisPath:");
        sb.append(redisPath);
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
  
  public A withConf(String conf) {
    this.conf = conf;
    return (A) this;
  }
  
  public A withFlushConfig() {
    return withFlushConfig(true);
  }
  
  public A withFlushConfig(Boolean flushConfig) {
    this.flushConfig = flushConfig;
    return (A) this;
  }
  
  public A withPassword(String password) {
    this.password = password;
    return (A) this;
  }
  
  public A withRedisPath() {
    return withRedisPath(true);
  }
  
  public A withRedisPath(Boolean redisPath) {
    this.redisPath = redisPath;
    return (A) this;
  }
  
}