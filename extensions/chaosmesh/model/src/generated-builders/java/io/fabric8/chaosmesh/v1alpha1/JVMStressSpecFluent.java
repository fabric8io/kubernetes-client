package io.fabric8.chaosmesh.v1alpha1;

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
public class JVMStressSpecFluent<A extends io.fabric8.chaosmesh.v1alpha1.JVMStressSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer cpuCount;
  private String memType;
  private Integer pid;
  private Integer port;

  public JVMStressSpecFluent() {
  }
  
  public JVMStressSpecFluent(JVMStressSpec instance) {
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
  
  protected void copyInstance(JVMStressSpec instance) {
    instance = instance != null ? instance : new JVMStressSpec();
    if (instance != null) {
        this.withCpuCount(instance.getCpuCount());
        this.withMemType(instance.getMemType());
        this.withPid(instance.getPid());
        this.withPort(instance.getPort());
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
    JVMStressSpecFluent that = (JVMStressSpecFluent) o;
    if (!(Objects.equals(cpuCount, that.cpuCount))) {
      return false;
    }
    if (!(Objects.equals(memType, that.memType))) {
      return false;
    }
    if (!(Objects.equals(pid, that.pid))) {
      return false;
    }
    if (!(Objects.equals(port, that.port))) {
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
  
  public Integer getCpuCount() {
    return this.cpuCount;
  }
  
  public String getMemType() {
    return this.memType;
  }
  
  public Integer getPid() {
    return this.pid;
  }
  
  public Integer getPort() {
    return this.port;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCpuCount() {
    return this.cpuCount != null;
  }
  
  public boolean hasMemType() {
    return this.memType != null;
  }
  
  public boolean hasPid() {
    return this.pid != null;
  }
  
  public boolean hasPort() {
    return this.port != null;
  }
  
  public int hashCode() {
    return Objects.hash(cpuCount, memType, pid, port, additionalProperties);
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
    if (!(cpuCount == null)) {
        sb.append("cpuCount:");
        sb.append(cpuCount);
        sb.append(",");
    }
    if (!(memType == null)) {
        sb.append("memType:");
        sb.append(memType);
        sb.append(",");
    }
    if (!(pid == null)) {
        sb.append("pid:");
        sb.append(pid);
        sb.append(",");
    }
    if (!(port == null)) {
        sb.append("port:");
        sb.append(port);
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
  
  public A withCpuCount(Integer cpuCount) {
    this.cpuCount = cpuCount;
    return (A) this;
  }
  
  public A withMemType(String memType) {
    this.memType = memType;
    return (A) this;
  }
  
  public A withPid(Integer pid) {
    this.pid = pid;
    return (A) this;
  }
  
  public A withPort(Integer port) {
    this.port = port;
    return (A) this;
  }
  
}