package io.fabric8.openclustermanagement.api.model.cluster.v1beta1;

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
public class SpreadConstraintsTermFluent<A extends io.fabric8.openclustermanagement.api.model.cluster.v1beta1.SpreadConstraintsTermFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer maxSkew;
  private String topologyKey;
  private String topologyKeyType;
  private String whenUnsatisfiable;

  public SpreadConstraintsTermFluent() {
  }
  
  public SpreadConstraintsTermFluent(SpreadConstraintsTerm instance) {
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
  
  protected void copyInstance(SpreadConstraintsTerm instance) {
    instance = instance != null ? instance : new SpreadConstraintsTerm();
    if (instance != null) {
        this.withMaxSkew(instance.getMaxSkew());
        this.withTopologyKey(instance.getTopologyKey());
        this.withTopologyKeyType(instance.getTopologyKeyType());
        this.withWhenUnsatisfiable(instance.getWhenUnsatisfiable());
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
    SpreadConstraintsTermFluent that = (SpreadConstraintsTermFluent) o;
    if (!(Objects.equals(maxSkew, that.maxSkew))) {
      return false;
    }
    if (!(Objects.equals(topologyKey, that.topologyKey))) {
      return false;
    }
    if (!(Objects.equals(topologyKeyType, that.topologyKeyType))) {
      return false;
    }
    if (!(Objects.equals(whenUnsatisfiable, that.whenUnsatisfiable))) {
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
  
  public Integer getMaxSkew() {
    return this.maxSkew;
  }
  
  public String getTopologyKey() {
    return this.topologyKey;
  }
  
  public String getTopologyKeyType() {
    return this.topologyKeyType;
  }
  
  public String getWhenUnsatisfiable() {
    return this.whenUnsatisfiable;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMaxSkew() {
    return this.maxSkew != null;
  }
  
  public boolean hasTopologyKey() {
    return this.topologyKey != null;
  }
  
  public boolean hasTopologyKeyType() {
    return this.topologyKeyType != null;
  }
  
  public boolean hasWhenUnsatisfiable() {
    return this.whenUnsatisfiable != null;
  }
  
  public int hashCode() {
    return Objects.hash(maxSkew, topologyKey, topologyKeyType, whenUnsatisfiable, additionalProperties);
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
    if (!(maxSkew == null)) {
        sb.append("maxSkew:");
        sb.append(maxSkew);
        sb.append(",");
    }
    if (!(topologyKey == null)) {
        sb.append("topologyKey:");
        sb.append(topologyKey);
        sb.append(",");
    }
    if (!(topologyKeyType == null)) {
        sb.append("topologyKeyType:");
        sb.append(topologyKeyType);
        sb.append(",");
    }
    if (!(whenUnsatisfiable == null)) {
        sb.append("whenUnsatisfiable:");
        sb.append(whenUnsatisfiable);
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
  
  public A withMaxSkew(Integer maxSkew) {
    this.maxSkew = maxSkew;
    return (A) this;
  }
  
  public A withTopologyKey(String topologyKey) {
    this.topologyKey = topologyKey;
    return (A) this;
  }
  
  public A withTopologyKeyType(String topologyKeyType) {
    this.topologyKeyType = topologyKeyType;
    return (A) this;
  }
  
  public A withWhenUnsatisfiable(String whenUnsatisfiable) {
    this.whenUnsatisfiable = whenUnsatisfiable;
    return (A) this;
  }
  
}