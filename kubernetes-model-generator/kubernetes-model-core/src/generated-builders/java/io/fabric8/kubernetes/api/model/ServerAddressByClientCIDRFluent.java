package io.fabric8.kubernetes.api.model;

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
public class ServerAddressByClientCIDRFluent<A extends io.fabric8.kubernetes.api.model.ServerAddressByClientCIDRFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String clientCIDR;
  private String serverAddress;

  public ServerAddressByClientCIDRFluent() {
  }
  
  public ServerAddressByClientCIDRFluent(ServerAddressByClientCIDR instance) {
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
  
  protected void copyInstance(ServerAddressByClientCIDR instance) {
    instance = instance != null ? instance : new ServerAddressByClientCIDR();
    if (instance != null) {
        this.withClientCIDR(instance.getClientCIDR());
        this.withServerAddress(instance.getServerAddress());
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
    ServerAddressByClientCIDRFluent that = (ServerAddressByClientCIDRFluent) o;
    if (!(Objects.equals(clientCIDR, that.clientCIDR))) {
      return false;
    }
    if (!(Objects.equals(serverAddress, that.serverAddress))) {
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
  
  public String getClientCIDR() {
    return this.clientCIDR;
  }
  
  public String getServerAddress() {
    return this.serverAddress;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClientCIDR() {
    return this.clientCIDR != null;
  }
  
  public boolean hasServerAddress() {
    return this.serverAddress != null;
  }
  
  public int hashCode() {
    return Objects.hash(clientCIDR, serverAddress, additionalProperties);
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
    if (!(clientCIDR == null)) {
        sb.append("clientCIDR:");
        sb.append(clientCIDR);
        sb.append(",");
    }
    if (!(serverAddress == null)) {
        sb.append("serverAddress:");
        sb.append(serverAddress);
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
  
  public A withClientCIDR(String clientCIDR) {
    this.clientCIDR = clientCIDR;
    return (A) this;
  }
  
  public A withServerAddress(String serverAddress) {
    this.serverAddress = serverAddress;
    return (A) this;
  }
  
}