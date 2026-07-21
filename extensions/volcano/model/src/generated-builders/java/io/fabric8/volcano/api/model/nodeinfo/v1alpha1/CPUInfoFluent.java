package io.fabric8.volcano.api.model.nodeinfo.v1alpha1;

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
public class CPUInfoFluent<A extends io.fabric8.volcano.api.model.nodeinfo.v1alpha1.CPUInfoFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer core;
  private Integer numa;
  private Integer socket;

  public CPUInfoFluent() {
  }
  
  public CPUInfoFluent(CPUInfo instance) {
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
  
  protected void copyInstance(CPUInfo instance) {
    instance = instance != null ? instance : new CPUInfo();
    if (instance != null) {
        this.withCore(instance.getCore());
        this.withNuma(instance.getNuma());
        this.withSocket(instance.getSocket());
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
    CPUInfoFluent that = (CPUInfoFluent) o;
    if (!(Objects.equals(core, that.core))) {
      return false;
    }
    if (!(Objects.equals(numa, that.numa))) {
      return false;
    }
    if (!(Objects.equals(socket, that.socket))) {
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
  
  public Integer getCore() {
    return this.core;
  }
  
  public Integer getNuma() {
    return this.numa;
  }
  
  public Integer getSocket() {
    return this.socket;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCore() {
    return this.core != null;
  }
  
  public boolean hasNuma() {
    return this.numa != null;
  }
  
  public boolean hasSocket() {
    return this.socket != null;
  }
  
  public int hashCode() {
    return Objects.hash(core, numa, socket, additionalProperties);
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
    if (!(core == null)) {
        sb.append("core:");
        sb.append(core);
        sb.append(",");
    }
    if (!(numa == null)) {
        sb.append("numa:");
        sb.append(numa);
        sb.append(",");
    }
    if (!(socket == null)) {
        sb.append("socket:");
        sb.append(socket);
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
  
  public A withCore(Integer core) {
    this.core = core;
    return (A) this;
  }
  
  public A withNuma(Integer numa) {
    this.numa = numa;
    return (A) this;
  }
  
  public A withSocket(Integer socket) {
    this.socket = socket;
    return (A) this;
  }
  
}