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
public class TrafficPolicyTunnelSettingsFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.TrafficPolicyTunnelSettingsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String protocol;
  private String targetHost;
  private Long targetPort;

  public TrafficPolicyTunnelSettingsFluent() {
  }
  
  public TrafficPolicyTunnelSettingsFluent(TrafficPolicyTunnelSettings instance) {
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
  
  protected void copyInstance(TrafficPolicyTunnelSettings instance) {
    instance = instance != null ? instance : new TrafficPolicyTunnelSettings();
    if (instance != null) {
        this.withProtocol(instance.getProtocol());
        this.withTargetHost(instance.getTargetHost());
        this.withTargetPort(instance.getTargetPort());
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
    TrafficPolicyTunnelSettingsFluent that = (TrafficPolicyTunnelSettingsFluent) o;
    if (!(Objects.equals(protocol, that.protocol))) {
      return false;
    }
    if (!(Objects.equals(targetHost, that.targetHost))) {
      return false;
    }
    if (!(Objects.equals(targetPort, that.targetPort))) {
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
  
  public String getProtocol() {
    return this.protocol;
  }
  
  public String getTargetHost() {
    return this.targetHost;
  }
  
  public Long getTargetPort() {
    return this.targetPort;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasProtocol() {
    return this.protocol != null;
  }
  
  public boolean hasTargetHost() {
    return this.targetHost != null;
  }
  
  public boolean hasTargetPort() {
    return this.targetPort != null;
  }
  
  public int hashCode() {
    return Objects.hash(protocol, targetHost, targetPort, additionalProperties);
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
    if (!(protocol == null)) {
        sb.append("protocol:");
        sb.append(protocol);
        sb.append(",");
    }
    if (!(targetHost == null)) {
        sb.append("targetHost:");
        sb.append(targetHost);
        sb.append(",");
    }
    if (!(targetPort == null)) {
        sb.append("targetPort:");
        sb.append(targetPort);
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
  
  public A withProtocol(String protocol) {
    this.protocol = protocol;
    return (A) this;
  }
  
  public A withTargetHost(String targetHost) {
    this.targetHost = targetHost;
    return (A) this;
  }
  
  public A withTargetPort(Long targetPort) {
    this.targetPort = targetPort;
    return (A) this;
  }
  
}