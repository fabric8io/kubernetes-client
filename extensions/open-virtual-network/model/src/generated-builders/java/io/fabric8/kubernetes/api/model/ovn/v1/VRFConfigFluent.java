package io.fabric8.kubernetes.api.model.ovn.v1;

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
public class VRFConfigFluent<A extends io.fabric8.kubernetes.api.model.ovn.v1.VRFConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String routeTarget;
  private Integer vni;

  public VRFConfigFluent() {
  }
  
  public VRFConfigFluent(VRFConfig instance) {
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
  
  protected void copyInstance(VRFConfig instance) {
    instance = instance != null ? instance : new VRFConfig();
    if (instance != null) {
        this.withRouteTarget(instance.getRouteTarget());
        this.withVni(instance.getVni());
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
    VRFConfigFluent that = (VRFConfigFluent) o;
    if (!(Objects.equals(routeTarget, that.routeTarget))) {
      return false;
    }
    if (!(Objects.equals(vni, that.vni))) {
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
  
  public String getRouteTarget() {
    return this.routeTarget;
  }
  
  public Integer getVni() {
    return this.vni;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasRouteTarget() {
    return this.routeTarget != null;
  }
  
  public boolean hasVni() {
    return this.vni != null;
  }
  
  public int hashCode() {
    return Objects.hash(routeTarget, vni, additionalProperties);
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
    if (!(routeTarget == null)) {
        sb.append("routeTarget:");
        sb.append(routeTarget);
        sb.append(",");
    }
    if (!(vni == null)) {
        sb.append("vni:");
        sb.append(vni);
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
  
  public A withRouteTarget(String routeTarget) {
    this.routeTarget = routeTarget;
    return (A) this;
  }
  
  public A withVni(Integer vni) {
    this.vni = vni;
    return (A) this;
  }
  
}