package io.fabric8.istio.api.api.networking.v1alpha3;

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
public class ConnectionPoolSettingsTCPSettingsTcpKeepaliveFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.ConnectionPoolSettingsTCPSettingsTcpKeepaliveFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String interval;
  private Long probes;
  private String time;

  public ConnectionPoolSettingsTCPSettingsTcpKeepaliveFluent() {
  }
  
  public ConnectionPoolSettingsTCPSettingsTcpKeepaliveFluent(ConnectionPoolSettingsTCPSettingsTcpKeepalive instance) {
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
  
  protected void copyInstance(ConnectionPoolSettingsTCPSettingsTcpKeepalive instance) {
    instance = instance != null ? instance : new ConnectionPoolSettingsTCPSettingsTcpKeepalive();
    if (instance != null) {
        this.withInterval(instance.getInterval());
        this.withProbes(instance.getProbes());
        this.withTime(instance.getTime());
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
    ConnectionPoolSettingsTCPSettingsTcpKeepaliveFluent that = (ConnectionPoolSettingsTCPSettingsTcpKeepaliveFluent) o;
    if (!(Objects.equals(interval, that.interval))) {
      return false;
    }
    if (!(Objects.equals(probes, that.probes))) {
      return false;
    }
    if (!(Objects.equals(time, that.time))) {
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
  
  public String getInterval() {
    return this.interval;
  }
  
  public Long getProbes() {
    return this.probes;
  }
  
  public String getTime() {
    return this.time;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasInterval() {
    return this.interval != null;
  }
  
  public boolean hasProbes() {
    return this.probes != null;
  }
  
  public boolean hasTime() {
    return this.time != null;
  }
  
  public int hashCode() {
    return Objects.hash(interval, probes, time, additionalProperties);
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
    if (!(interval == null)) {
        sb.append("interval:");
        sb.append(interval);
        sb.append(",");
    }
    if (!(probes == null)) {
        sb.append("probes:");
        sb.append(probes);
        sb.append(",");
    }
    if (!(time == null)) {
        sb.append("time:");
        sb.append(time);
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
  
  public A withInterval(String interval) {
    this.interval = interval;
    return (A) this;
  }
  
  public A withProbes(Long probes) {
    this.probes = probes;
    return (A) this;
  }
  
  public A withTime(String time) {
    this.time = time;
    return (A) this;
  }
  
}