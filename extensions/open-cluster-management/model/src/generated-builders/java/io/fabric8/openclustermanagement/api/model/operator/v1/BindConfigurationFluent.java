package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Boolean;
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
public class BindConfigurationFluent<A extends io.fabric8.openclustermanagement.api.model.operator.v1.BindConfigurationFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer healthProbePort;
  private Boolean hostNetwork;
  private Integer metricsPort;
  private Integer port;

  public BindConfigurationFluent() {
  }
  
  public BindConfigurationFluent(BindConfiguration instance) {
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
  
  protected void copyInstance(BindConfiguration instance) {
    instance = instance != null ? instance : new BindConfiguration();
    if (instance != null) {
        this.withHealthProbePort(instance.getHealthProbePort());
        this.withHostNetwork(instance.getHostNetwork());
        this.withMetricsPort(instance.getMetricsPort());
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
    BindConfigurationFluent that = (BindConfigurationFluent) o;
    if (!(Objects.equals(healthProbePort, that.healthProbePort))) {
      return false;
    }
    if (!(Objects.equals(hostNetwork, that.hostNetwork))) {
      return false;
    }
    if (!(Objects.equals(metricsPort, that.metricsPort))) {
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
  
  public Integer getHealthProbePort() {
    return this.healthProbePort;
  }
  
  public Boolean getHostNetwork() {
    return this.hostNetwork;
  }
  
  public Integer getMetricsPort() {
    return this.metricsPort;
  }
  
  public Integer getPort() {
    return this.port;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasHealthProbePort() {
    return this.healthProbePort != null;
  }
  
  public boolean hasHostNetwork() {
    return this.hostNetwork != null;
  }
  
  public boolean hasMetricsPort() {
    return this.metricsPort != null;
  }
  
  public boolean hasPort() {
    return this.port != null;
  }
  
  public int hashCode() {
    return Objects.hash(healthProbePort, hostNetwork, metricsPort, port, additionalProperties);
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
    if (!(healthProbePort == null)) {
        sb.append("healthProbePort:");
        sb.append(healthProbePort);
        sb.append(",");
    }
    if (!(hostNetwork == null)) {
        sb.append("hostNetwork:");
        sb.append(hostNetwork);
        sb.append(",");
    }
    if (!(metricsPort == null)) {
        sb.append("metricsPort:");
        sb.append(metricsPort);
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
  
  public A withHealthProbePort(Integer healthProbePort) {
    this.healthProbePort = healthProbePort;
    return (A) this;
  }
  
  public A withHostNetwork() {
    return withHostNetwork(true);
  }
  
  public A withHostNetwork(Boolean hostNetwork) {
    this.hostNetwork = hostNetwork;
    return (A) this;
  }
  
  public A withMetricsPort(Integer metricsPort) {
    this.metricsPort = metricsPort;
    return (A) this;
  }
  
  public A withPort(Integer port) {
    this.port = port;
    return (A) this;
  }
  
}