package io.fabric8.openshift.api.model.hive.ovirt.v1;

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
public class CPUFluent<A extends io.fabric8.openshift.api.model.hive.ovirt.v1.CPUFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer cores;
  private Integer sockets;

  public CPUFluent() {
  }
  
  public CPUFluent(CPU instance) {
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
  
  protected void copyInstance(CPU instance) {
    instance = instance != null ? instance : new CPU();
    if (instance != null) {
        this.withCores(instance.getCores());
        this.withSockets(instance.getSockets());
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
    CPUFluent that = (CPUFluent) o;
    if (!(Objects.equals(cores, that.cores))) {
      return false;
    }
    if (!(Objects.equals(sockets, that.sockets))) {
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
  
  public Integer getCores() {
    return this.cores;
  }
  
  public Integer getSockets() {
    return this.sockets;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCores() {
    return this.cores != null;
  }
  
  public boolean hasSockets() {
    return this.sockets != null;
  }
  
  public int hashCode() {
    return Objects.hash(cores, sockets, additionalProperties);
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
    if (!(cores == null)) {
        sb.append("cores:");
        sb.append(cores);
        sb.append(",");
    }
    if (!(sockets == null)) {
        sb.append("sockets:");
        sb.append(sockets);
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
  
  public A withCores(Integer cores) {
    this.cores = cores;
    return (A) this;
  }
  
  public A withSockets(Integer sockets) {
    this.sockets = sockets;
    return (A) this;
  }
  
}