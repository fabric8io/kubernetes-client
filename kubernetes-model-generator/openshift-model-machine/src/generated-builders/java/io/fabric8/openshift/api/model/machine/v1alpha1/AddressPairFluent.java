package io.fabric8.openshift.api.model.machine.v1alpha1;

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
public class AddressPairFluent<A extends io.fabric8.openshift.api.model.machine.v1alpha1.AddressPairFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String ipAddress;
  private String macAddress;

  public AddressPairFluent() {
  }
  
  public AddressPairFluent(AddressPair instance) {
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
  
  protected void copyInstance(AddressPair instance) {
    instance = instance != null ? instance : new AddressPair();
    if (instance != null) {
        this.withIpAddress(instance.getIpAddress());
        this.withMacAddress(instance.getMacAddress());
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
    AddressPairFluent that = (AddressPairFluent) o;
    if (!(Objects.equals(ipAddress, that.ipAddress))) {
      return false;
    }
    if (!(Objects.equals(macAddress, that.macAddress))) {
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
  
  public String getIpAddress() {
    return this.ipAddress;
  }
  
  public String getMacAddress() {
    return this.macAddress;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasIpAddress() {
    return this.ipAddress != null;
  }
  
  public boolean hasMacAddress() {
    return this.macAddress != null;
  }
  
  public int hashCode() {
    return Objects.hash(ipAddress, macAddress, additionalProperties);
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
    if (!(ipAddress == null)) {
        sb.append("ipAddress:");
        sb.append(ipAddress);
        sb.append(",");
    }
    if (!(macAddress == null)) {
        sb.append("macAddress:");
        sb.append(macAddress);
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
  
  public A withIpAddress(String ipAddress) {
    this.ipAddress = ipAddress;
    return (A) this;
  }
  
  public A withMacAddress(String macAddress) {
    this.macAddress = macAddress;
    return (A) this;
  }
  
}