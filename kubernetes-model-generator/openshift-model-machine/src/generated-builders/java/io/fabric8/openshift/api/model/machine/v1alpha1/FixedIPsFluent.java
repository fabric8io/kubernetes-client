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
public class FixedIPsFluent<A extends io.fabric8.openshift.api.model.machine.v1alpha1.FixedIPsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String ipAddress;
  private String subnetID;

  public FixedIPsFluent() {
  }
  
  public FixedIPsFluent(FixedIPs instance) {
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
  
  protected void copyInstance(FixedIPs instance) {
    instance = instance != null ? instance : new FixedIPs();
    if (instance != null) {
        this.withIpAddress(instance.getIpAddress());
        this.withSubnetID(instance.getSubnetID());
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
    FixedIPsFluent that = (FixedIPsFluent) o;
    if (!(Objects.equals(ipAddress, that.ipAddress))) {
      return false;
    }
    if (!(Objects.equals(subnetID, that.subnetID))) {
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
  
  public String getSubnetID() {
    return this.subnetID;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasIpAddress() {
    return this.ipAddress != null;
  }
  
  public boolean hasSubnetID() {
    return this.subnetID != null;
  }
  
  public int hashCode() {
    return Objects.hash(ipAddress, subnetID, additionalProperties);
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
    if (!(subnetID == null)) {
        sb.append("subnetID:");
        sb.append(subnetID);
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
  
  public A withSubnetID(String subnetID) {
    this.subnetID = subnetID;
    return (A) this;
  }
  
}