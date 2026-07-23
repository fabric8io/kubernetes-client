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
public class NetworkFloodSpecFluent<A extends io.fabric8.chaosmesh.v1alpha1.NetworkFloodSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String duration;
  private String ipAddress;
  private Integer parallel;
  private String port;
  private String rate;

  public NetworkFloodSpecFluent() {
  }
  
  public NetworkFloodSpecFluent(NetworkFloodSpec instance) {
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
  
  protected void copyInstance(NetworkFloodSpec instance) {
    instance = instance != null ? instance : new NetworkFloodSpec();
    if (instance != null) {
        this.withDuration(instance.getDuration());
        this.withIpAddress(instance.getIpAddress());
        this.withParallel(instance.getParallel());
        this.withPort(instance.getPort());
        this.withRate(instance.getRate());
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
    NetworkFloodSpecFluent that = (NetworkFloodSpecFluent) o;
    if (!(Objects.equals(duration, that.duration))) {
      return false;
    }
    if (!(Objects.equals(ipAddress, that.ipAddress))) {
      return false;
    }
    if (!(Objects.equals(parallel, that.parallel))) {
      return false;
    }
    if (!(Objects.equals(port, that.port))) {
      return false;
    }
    if (!(Objects.equals(rate, that.rate))) {
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
  
  public String getDuration() {
    return this.duration;
  }
  
  public String getIpAddress() {
    return this.ipAddress;
  }
  
  public Integer getParallel() {
    return this.parallel;
  }
  
  public String getPort() {
    return this.port;
  }
  
  public String getRate() {
    return this.rate;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDuration() {
    return this.duration != null;
  }
  
  public boolean hasIpAddress() {
    return this.ipAddress != null;
  }
  
  public boolean hasParallel() {
    return this.parallel != null;
  }
  
  public boolean hasPort() {
    return this.port != null;
  }
  
  public boolean hasRate() {
    return this.rate != null;
  }
  
  public int hashCode() {
    return Objects.hash(duration, ipAddress, parallel, port, rate, additionalProperties);
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
    if (!(duration == null)) {
        sb.append("duration:");
        sb.append(duration);
        sb.append(",");
    }
    if (!(ipAddress == null)) {
        sb.append("ipAddress:");
        sb.append(ipAddress);
        sb.append(",");
    }
    if (!(parallel == null)) {
        sb.append("parallel:");
        sb.append(parallel);
        sb.append(",");
    }
    if (!(port == null)) {
        sb.append("port:");
        sb.append(port);
        sb.append(",");
    }
    if (!(rate == null)) {
        sb.append("rate:");
        sb.append(rate);
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
  
  public A withDuration(String duration) {
    this.duration = duration;
    return (A) this;
  }
  
  public A withIpAddress(String ipAddress) {
    this.ipAddress = ipAddress;
    return (A) this;
  }
  
  public A withParallel(Integer parallel) {
    this.parallel = parallel;
    return (A) this;
  }
  
  public A withPort(String port) {
    this.port = port;
    return (A) this;
  }
  
  public A withRate(String rate) {
    this.rate = rate;
    return (A) this;
  }
  
}