package io.fabric8.openshift.api.model.miscellaneous.cncf.cni.v1;

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
public class PortMapEntryFluent<A extends io.fabric8.openshift.api.model.miscellaneous.cncf.cni.v1.PortMapEntryFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer containerPort;
  private String hostIP;
  private Integer hostPort;
  private String protocol;

  public PortMapEntryFluent() {
  }
  
  public PortMapEntryFluent(PortMapEntry instance) {
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
  
  protected void copyInstance(PortMapEntry instance) {
    instance = instance != null ? instance : new PortMapEntry();
    if (instance != null) {
        this.withContainerPort(instance.getContainerPort());
        this.withHostIP(instance.getHostIP());
        this.withHostPort(instance.getHostPort());
        this.withProtocol(instance.getProtocol());
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
    PortMapEntryFluent that = (PortMapEntryFluent) o;
    if (!(Objects.equals(containerPort, that.containerPort))) {
      return false;
    }
    if (!(Objects.equals(hostIP, that.hostIP))) {
      return false;
    }
    if (!(Objects.equals(hostPort, that.hostPort))) {
      return false;
    }
    if (!(Objects.equals(protocol, that.protocol))) {
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
  
  public Integer getContainerPort() {
    return this.containerPort;
  }
  
  public String getHostIP() {
    return this.hostIP;
  }
  
  public Integer getHostPort() {
    return this.hostPort;
  }
  
  public String getProtocol() {
    return this.protocol;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasContainerPort() {
    return this.containerPort != null;
  }
  
  public boolean hasHostIP() {
    return this.hostIP != null;
  }
  
  public boolean hasHostPort() {
    return this.hostPort != null;
  }
  
  public boolean hasProtocol() {
    return this.protocol != null;
  }
  
  public int hashCode() {
    return Objects.hash(containerPort, hostIP, hostPort, protocol, additionalProperties);
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
    if (!(containerPort == null)) {
        sb.append("containerPort:");
        sb.append(containerPort);
        sb.append(",");
    }
    if (!(hostIP == null)) {
        sb.append("hostIP:");
        sb.append(hostIP);
        sb.append(",");
    }
    if (!(hostPort == null)) {
        sb.append("hostPort:");
        sb.append(hostPort);
        sb.append(",");
    }
    if (!(protocol == null)) {
        sb.append("protocol:");
        sb.append(protocol);
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
  
  public A withContainerPort(Integer containerPort) {
    this.containerPort = containerPort;
    return (A) this;
  }
  
  public A withHostIP(String hostIP) {
    this.hostIP = hostIP;
    return (A) this;
  }
  
  public A withHostPort(Integer hostPort) {
    this.hostPort = hostPort;
    return (A) this;
  }
  
  public A withProtocol(String protocol) {
    this.protocol = protocol;
    return (A) this;
  }
  
}