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
public class NetworkPartitionSpecFluent<A extends io.fabric8.chaosmesh.v1alpha1.NetworkPartitionSpecFluent<A>> extends BaseFluent<A>{

  private String acceptTcpFlags;
  private Map<String,Object> additionalProperties;
  private String device;
  private String direction;
  private String hostname;
  private String ipAddress;
  private String ipProtocol;

  public NetworkPartitionSpecFluent() {
  }
  
  public NetworkPartitionSpecFluent(NetworkPartitionSpec instance) {
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
  
  protected void copyInstance(NetworkPartitionSpec instance) {
    instance = instance != null ? instance : new NetworkPartitionSpec();
    if (instance != null) {
        this.withAcceptTcpFlags(instance.getAcceptTcpFlags());
        this.withDevice(instance.getDevice());
        this.withDirection(instance.getDirection());
        this.withHostname(instance.getHostname());
        this.withIpAddress(instance.getIpAddress());
        this.withIpProtocol(instance.getIpProtocol());
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
    NetworkPartitionSpecFluent that = (NetworkPartitionSpecFluent) o;
    if (!(Objects.equals(acceptTcpFlags, that.acceptTcpFlags))) {
      return false;
    }
    if (!(Objects.equals(device, that.device))) {
      return false;
    }
    if (!(Objects.equals(direction, that.direction))) {
      return false;
    }
    if (!(Objects.equals(hostname, that.hostname))) {
      return false;
    }
    if (!(Objects.equals(ipAddress, that.ipAddress))) {
      return false;
    }
    if (!(Objects.equals(ipProtocol, that.ipProtocol))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public String getAcceptTcpFlags() {
    return this.acceptTcpFlags;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getDevice() {
    return this.device;
  }
  
  public String getDirection() {
    return this.direction;
  }
  
  public String getHostname() {
    return this.hostname;
  }
  
  public String getIpAddress() {
    return this.ipAddress;
  }
  
  public String getIpProtocol() {
    return this.ipProtocol;
  }
  
  public boolean hasAcceptTcpFlags() {
    return this.acceptTcpFlags != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDevice() {
    return this.device != null;
  }
  
  public boolean hasDirection() {
    return this.direction != null;
  }
  
  public boolean hasHostname() {
    return this.hostname != null;
  }
  
  public boolean hasIpAddress() {
    return this.ipAddress != null;
  }
  
  public boolean hasIpProtocol() {
    return this.ipProtocol != null;
  }
  
  public int hashCode() {
    return Objects.hash(acceptTcpFlags, device, direction, hostname, ipAddress, ipProtocol, additionalProperties);
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
    if (!(acceptTcpFlags == null)) {
        sb.append("acceptTcpFlags:");
        sb.append(acceptTcpFlags);
        sb.append(",");
    }
    if (!(device == null)) {
        sb.append("device:");
        sb.append(device);
        sb.append(",");
    }
    if (!(direction == null)) {
        sb.append("direction:");
        sb.append(direction);
        sb.append(",");
    }
    if (!(hostname == null)) {
        sb.append("hostname:");
        sb.append(hostname);
        sb.append(",");
    }
    if (!(ipAddress == null)) {
        sb.append("ipAddress:");
        sb.append(ipAddress);
        sb.append(",");
    }
    if (!(ipProtocol == null)) {
        sb.append("ipProtocol:");
        sb.append(ipProtocol);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAcceptTcpFlags(String acceptTcpFlags) {
    this.acceptTcpFlags = acceptTcpFlags;
    return (A) this;
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withDevice(String device) {
    this.device = device;
    return (A) this;
  }
  
  public A withDirection(String direction) {
    this.direction = direction;
    return (A) this;
  }
  
  public A withHostname(String hostname) {
    this.hostname = hostname;
    return (A) this;
  }
  
  public A withIpAddress(String ipAddress) {
    this.ipAddress = ipAddress;
    return (A) this;
  }
  
  public A withIpProtocol(String ipProtocol) {
    this.ipProtocol = ipProtocol;
    return (A) this;
  }
  
}