package io.fabric8.openshift.api.model.operator.v1;

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
public class StaticIPAMRoutesFluent<A extends io.fabric8.openshift.api.model.operator.v1.StaticIPAMRoutesFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String destination;
  private String gateway;

  public StaticIPAMRoutesFluent() {
  }
  
  public StaticIPAMRoutesFluent(StaticIPAMRoutes instance) {
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
  
  protected void copyInstance(StaticIPAMRoutes instance) {
    instance = instance != null ? instance : new StaticIPAMRoutes();
    if (instance != null) {
        this.withDestination(instance.getDestination());
        this.withGateway(instance.getGateway());
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
    StaticIPAMRoutesFluent that = (StaticIPAMRoutesFluent) o;
    if (!(Objects.equals(destination, that.destination))) {
      return false;
    }
    if (!(Objects.equals(gateway, that.gateway))) {
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
  
  public String getDestination() {
    return this.destination;
  }
  
  public String getGateway() {
    return this.gateway;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDestination() {
    return this.destination != null;
  }
  
  public boolean hasGateway() {
    return this.gateway != null;
  }
  
  public int hashCode() {
    return Objects.hash(destination, gateway, additionalProperties);
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
    if (!(destination == null)) {
        sb.append("destination:");
        sb.append(destination);
        sb.append(",");
    }
    if (!(gateway == null)) {
        sb.append("gateway:");
        sb.append(gateway);
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
  
  public A withDestination(String destination) {
    this.destination = destination;
    return (A) this;
  }
  
  public A withGateway(String gateway) {
    this.gateway = gateway;
    return (A) this;
  }
  
}