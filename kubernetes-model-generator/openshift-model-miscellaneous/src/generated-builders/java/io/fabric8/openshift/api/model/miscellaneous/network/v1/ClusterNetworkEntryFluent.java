package io.fabric8.openshift.api.model.miscellaneous.network.v1;

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
public class ClusterNetworkEntryFluent<A extends io.fabric8.openshift.api.model.miscellaneous.network.v1.ClusterNetworkEntryFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String cIDR;
  private Long hostSubnetLength;

  public ClusterNetworkEntryFluent() {
  }
  
  public ClusterNetworkEntryFluent(ClusterNetworkEntry instance) {
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
  
  protected void copyInstance(ClusterNetworkEntry instance) {
    instance = instance != null ? instance : new ClusterNetworkEntry();
    if (instance != null) {
        this.withCIDR(instance.getCIDR());
        this.withHostSubnetLength(instance.getHostSubnetLength());
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
    ClusterNetworkEntryFluent that = (ClusterNetworkEntryFluent) o;
    if (!(Objects.equals(cIDR, that.cIDR))) {
      return false;
    }
    if (!(Objects.equals(hostSubnetLength, that.hostSubnetLength))) {
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
  
  public String getCIDR() {
    return this.cIDR;
  }
  
  public Long getHostSubnetLength() {
    return this.hostSubnetLength;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCIDR() {
    return this.cIDR != null;
  }
  
  public boolean hasHostSubnetLength() {
    return this.hostSubnetLength != null;
  }
  
  public int hashCode() {
    return Objects.hash(cIDR, hostSubnetLength, additionalProperties);
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
    if (!(cIDR == null)) {
        sb.append("cIDR:");
        sb.append(cIDR);
        sb.append(",");
    }
    if (!(hostSubnetLength == null)) {
        sb.append("hostSubnetLength:");
        sb.append(hostSubnetLength);
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
  
  public A withCIDR(String cIDR) {
    this.cIDR = cIDR;
    return (A) this;
  }
  
  public A withHostSubnetLength(Long hostSubnetLength) {
    this.hostSubnetLength = hostSubnetLength;
    return (A) this;
  }
  
}