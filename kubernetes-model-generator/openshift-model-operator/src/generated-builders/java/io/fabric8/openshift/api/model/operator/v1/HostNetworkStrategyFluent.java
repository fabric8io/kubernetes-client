package io.fabric8.openshift.api.model.operator.v1;

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
public class HostNetworkStrategyFluent<A extends io.fabric8.openshift.api.model.operator.v1.HostNetworkStrategyFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer httpPort;
  private Integer httpsPort;
  private String protocol;
  private Integer statsPort;

  public HostNetworkStrategyFluent() {
  }
  
  public HostNetworkStrategyFluent(HostNetworkStrategy instance) {
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
  
  protected void copyInstance(HostNetworkStrategy instance) {
    instance = instance != null ? instance : new HostNetworkStrategy();
    if (instance != null) {
        this.withHttpPort(instance.getHttpPort());
        this.withHttpsPort(instance.getHttpsPort());
        this.withProtocol(instance.getProtocol());
        this.withStatsPort(instance.getStatsPort());
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
    HostNetworkStrategyFluent that = (HostNetworkStrategyFluent) o;
    if (!(Objects.equals(httpPort, that.httpPort))) {
      return false;
    }
    if (!(Objects.equals(httpsPort, that.httpsPort))) {
      return false;
    }
    if (!(Objects.equals(protocol, that.protocol))) {
      return false;
    }
    if (!(Objects.equals(statsPort, that.statsPort))) {
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
  
  public Integer getHttpPort() {
    return this.httpPort;
  }
  
  public Integer getHttpsPort() {
    return this.httpsPort;
  }
  
  public String getProtocol() {
    return this.protocol;
  }
  
  public Integer getStatsPort() {
    return this.statsPort;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasHttpPort() {
    return this.httpPort != null;
  }
  
  public boolean hasHttpsPort() {
    return this.httpsPort != null;
  }
  
  public boolean hasProtocol() {
    return this.protocol != null;
  }
  
  public boolean hasStatsPort() {
    return this.statsPort != null;
  }
  
  public int hashCode() {
    return Objects.hash(httpPort, httpsPort, protocol, statsPort, additionalProperties);
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
    if (!(httpPort == null)) {
        sb.append("httpPort:");
        sb.append(httpPort);
        sb.append(",");
    }
    if (!(httpsPort == null)) {
        sb.append("httpsPort:");
        sb.append(httpsPort);
        sb.append(",");
    }
    if (!(protocol == null)) {
        sb.append("protocol:");
        sb.append(protocol);
        sb.append(",");
    }
    if (!(statsPort == null)) {
        sb.append("statsPort:");
        sb.append(statsPort);
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
  
  public A withHttpPort(Integer httpPort) {
    this.httpPort = httpPort;
    return (A) this;
  }
  
  public A withHttpsPort(Integer httpsPort) {
    this.httpsPort = httpsPort;
    return (A) this;
  }
  
  public A withProtocol(String protocol) {
    this.protocol = protocol;
    return (A) this;
  }
  
  public A withStatsPort(Integer statsPort) {
    this.statsPort = statsPort;
    return (A) this;
  }
  
}