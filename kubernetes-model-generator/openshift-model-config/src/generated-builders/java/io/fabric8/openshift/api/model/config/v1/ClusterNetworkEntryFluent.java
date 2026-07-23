package io.fabric8.openshift.api.model.config.v1;

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
public class ClusterNetworkEntryFluent<A extends io.fabric8.openshift.api.model.config.v1.ClusterNetworkEntryFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String cidr;
  private Long hostPrefix;

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
        this.withCidr(instance.getCidr());
        this.withHostPrefix(instance.getHostPrefix());
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
    if (!(Objects.equals(cidr, that.cidr))) {
      return false;
    }
    if (!(Objects.equals(hostPrefix, that.hostPrefix))) {
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
  
  public String getCidr() {
    return this.cidr;
  }
  
  public Long getHostPrefix() {
    return this.hostPrefix;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCidr() {
    return this.cidr != null;
  }
  
  public boolean hasHostPrefix() {
    return this.hostPrefix != null;
  }
  
  public int hashCode() {
    return Objects.hash(cidr, hostPrefix, additionalProperties);
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
    if (!(cidr == null)) {
        sb.append("cidr:");
        sb.append(cidr);
        sb.append(",");
    }
    if (!(hostPrefix == null)) {
        sb.append("hostPrefix:");
        sb.append(hostPrefix);
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
  
  public A withCidr(String cidr) {
    this.cidr = cidr;
    return (A) this;
  }
  
  public A withHostPrefix(Long hostPrefix) {
    this.hostPrefix = hostPrefix;
    return (A) this;
  }
  
}