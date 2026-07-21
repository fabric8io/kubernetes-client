package io.fabric8.volcano.api.model.nodeinfo.v1alpha1;

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
public class NumatopoSpecFluent<A extends io.fabric8.volcano.api.model.nodeinfo.v1alpha1.NumatopoSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Map<String,CPUInfo> cpuDetail;
  private Map<String,ResourceInfo> numares;
  private Map<String,String> policies;
  private Map<String,String> resReserved;

  public NumatopoSpecFluent() {
  }
  
  public NumatopoSpecFluent(NumatopoSpec instance) {
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
  
  public A addToCpuDetail(Map<String,CPUInfo> map) {
    if (this.cpuDetail == null && map != null) {
      this.cpuDetail = new LinkedHashMap();
    }
    if (map != null) {
      this.cpuDetail.putAll(map);
    }
    return (A) this;
  }
  
  public A addToCpuDetail(String key,CPUInfo value) {
    if (this.cpuDetail == null && key != null && value != null) {
      this.cpuDetail = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.cpuDetail.put(key, value);
    }
    return (A) this;
  }
  
  public A addToNumares(Map<String,ResourceInfo> map) {
    if (this.numares == null && map != null) {
      this.numares = new LinkedHashMap();
    }
    if (map != null) {
      this.numares.putAll(map);
    }
    return (A) this;
  }
  
  public A addToNumares(String key,ResourceInfo value) {
    if (this.numares == null && key != null && value != null) {
      this.numares = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.numares.put(key, value);
    }
    return (A) this;
  }
  
  public A addToPolicies(Map<String,String> map) {
    if (this.policies == null && map != null) {
      this.policies = new LinkedHashMap();
    }
    if (map != null) {
      this.policies.putAll(map);
    }
    return (A) this;
  }
  
  public A addToPolicies(String key,String value) {
    if (this.policies == null && key != null && value != null) {
      this.policies = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.policies.put(key, value);
    }
    return (A) this;
  }
  
  public A addToResReserved(Map<String,String> map) {
    if (this.resReserved == null && map != null) {
      this.resReserved = new LinkedHashMap();
    }
    if (map != null) {
      this.resReserved.putAll(map);
    }
    return (A) this;
  }
  
  public A addToResReserved(String key,String value) {
    if (this.resReserved == null && key != null && value != null) {
      this.resReserved = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.resReserved.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(NumatopoSpec instance) {
    instance = instance != null ? instance : new NumatopoSpec();
    if (instance != null) {
        this.withCpuDetail(instance.getCpuDetail());
        this.withNumares(instance.getNumares());
        this.withPolicies(instance.getPolicies());
        this.withResReserved(instance.getResReserved());
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
    NumatopoSpecFluent that = (NumatopoSpecFluent) o;
    if (!(Objects.equals(cpuDetail, that.cpuDetail))) {
      return false;
    }
    if (!(Objects.equals(numares, that.numares))) {
      return false;
    }
    if (!(Objects.equals(policies, that.policies))) {
      return false;
    }
    if (!(Objects.equals(resReserved, that.resReserved))) {
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
  
  public Map<String,CPUInfo> getCpuDetail() {
    return this.cpuDetail;
  }
  
  public Map<String,ResourceInfo> getNumares() {
    return this.numares;
  }
  
  public Map<String,String> getPolicies() {
    return this.policies;
  }
  
  public Map<String,String> getResReserved() {
    return this.resReserved;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCpuDetail() {
    return this.cpuDetail != null;
  }
  
  public boolean hasNumares() {
    return this.numares != null;
  }
  
  public boolean hasPolicies() {
    return this.policies != null;
  }
  
  public boolean hasResReserved() {
    return this.resReserved != null;
  }
  
  public int hashCode() {
    return Objects.hash(cpuDetail, numares, policies, resReserved, additionalProperties);
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
  
  public A removeFromCpuDetail(String key) {
    if (this.cpuDetail == null) {
      return (A) this;
    }
    if (key != null && this.cpuDetail != null) {
      this.cpuDetail.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromCpuDetail(Map<String,CPUInfo> map) {
    if (this.cpuDetail == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.cpuDetail != null) {
          this.cpuDetail.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromNumares(String key) {
    if (this.numares == null) {
      return (A) this;
    }
    if (key != null && this.numares != null) {
      this.numares.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromNumares(Map<String,ResourceInfo> map) {
    if (this.numares == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.numares != null) {
          this.numares.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromPolicies(String key) {
    if (this.policies == null) {
      return (A) this;
    }
    if (key != null && this.policies != null) {
      this.policies.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromPolicies(Map<String,String> map) {
    if (this.policies == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.policies != null) {
          this.policies.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromResReserved(String key) {
    if (this.resReserved == null) {
      return (A) this;
    }
    if (key != null && this.resReserved != null) {
      this.resReserved.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromResReserved(Map<String,String> map) {
    if (this.resReserved == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.resReserved != null) {
          this.resReserved.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(cpuDetail == null) && !(cpuDetail.isEmpty())) {
        sb.append("cpuDetail:");
        sb.append(cpuDetail);
        sb.append(",");
    }
    if (!(numares == null) && !(numares.isEmpty())) {
        sb.append("numares:");
        sb.append(numares);
        sb.append(",");
    }
    if (!(policies == null) && !(policies.isEmpty())) {
        sb.append("policies:");
        sb.append(policies);
        sb.append(",");
    }
    if (!(resReserved == null) && !(resReserved.isEmpty())) {
        sb.append("resReserved:");
        sb.append(resReserved);
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
  
  public <K,V>A withCpuDetail(Map<String,CPUInfo> cpuDetail) {
    if (cpuDetail == null) {
      this.cpuDetail = null;
    } else {
      this.cpuDetail = new LinkedHashMap(cpuDetail);
    }
    return (A) this;
  }
  
  public <K,V>A withNumares(Map<String,ResourceInfo> numares) {
    if (numares == null) {
      this.numares = null;
    } else {
      this.numares = new LinkedHashMap(numares);
    }
    return (A) this;
  }
  
  public <K,V>A withPolicies(Map<String,String> policies) {
    if (policies == null) {
      this.policies = null;
    } else {
      this.policies = new LinkedHashMap(policies);
    }
    return (A) this;
  }
  
  public <K,V>A withResReserved(Map<String,String> resReserved) {
    if (resReserved == null) {
      this.resReserved = null;
    } else {
      this.resReserved = new LinkedHashMap(resReserved);
    }
    return (A) this;
  }
  
}