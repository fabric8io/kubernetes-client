package io.fabric8.istio.api.api.networking.v1alpha3;

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
public class EnvoyFilterClusterMatchFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.EnvoyFilterClusterMatchFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String name;
  private Long portNumber;
  private String service;
  private String subset;

  public EnvoyFilterClusterMatchFluent() {
  }
  
  public EnvoyFilterClusterMatchFluent(EnvoyFilterClusterMatch instance) {
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
  
  protected void copyInstance(EnvoyFilterClusterMatch instance) {
    instance = instance != null ? instance : new EnvoyFilterClusterMatch();
    if (instance != null) {
        this.withName(instance.getName());
        this.withPortNumber(instance.getPortNumber());
        this.withService(instance.getService());
        this.withSubset(instance.getSubset());
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
    EnvoyFilterClusterMatchFluent that = (EnvoyFilterClusterMatchFluent) o;
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(portNumber, that.portNumber))) {
      return false;
    }
    if (!(Objects.equals(service, that.service))) {
      return false;
    }
    if (!(Objects.equals(subset, that.subset))) {
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
  
  public String getName() {
    return this.name;
  }
  
  public Long getPortNumber() {
    return this.portNumber;
  }
  
  public String getService() {
    return this.service;
  }
  
  public String getSubset() {
    return this.subset;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasPortNumber() {
    return this.portNumber != null;
  }
  
  public boolean hasService() {
    return this.service != null;
  }
  
  public boolean hasSubset() {
    return this.subset != null;
  }
  
  public int hashCode() {
    return Objects.hash(name, portNumber, service, subset, additionalProperties);
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
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(portNumber == null)) {
        sb.append("portNumber:");
        sb.append(portNumber);
        sb.append(",");
    }
    if (!(service == null)) {
        sb.append("service:");
        sb.append(service);
        sb.append(",");
    }
    if (!(subset == null)) {
        sb.append("subset:");
        sb.append(subset);
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
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withPortNumber(Long portNumber) {
    this.portNumber = portNumber;
    return (A) this;
  }
  
  public A withService(String service) {
    this.service = service;
    return (A) this;
  }
  
  public A withSubset(String subset) {
    this.subset = subset;
    return (A) this;
  }
  
}