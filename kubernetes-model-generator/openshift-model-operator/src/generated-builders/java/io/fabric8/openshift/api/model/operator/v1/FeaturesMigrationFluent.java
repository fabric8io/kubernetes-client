package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Boolean;
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
public class FeaturesMigrationFluent<A extends io.fabric8.openshift.api.model.operator.v1.FeaturesMigrationFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean egressFirewall;
  private Boolean egressIP;
  private Boolean multicast;

  public FeaturesMigrationFluent() {
  }
  
  public FeaturesMigrationFluent(FeaturesMigration instance) {
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
  
  protected void copyInstance(FeaturesMigration instance) {
    instance = instance != null ? instance : new FeaturesMigration();
    if (instance != null) {
        this.withEgressFirewall(instance.getEgressFirewall());
        this.withEgressIP(instance.getEgressIP());
        this.withMulticast(instance.getMulticast());
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
    FeaturesMigrationFluent that = (FeaturesMigrationFluent) o;
    if (!(Objects.equals(egressFirewall, that.egressFirewall))) {
      return false;
    }
    if (!(Objects.equals(egressIP, that.egressIP))) {
      return false;
    }
    if (!(Objects.equals(multicast, that.multicast))) {
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
  
  public Boolean getEgressFirewall() {
    return this.egressFirewall;
  }
  
  public Boolean getEgressIP() {
    return this.egressIP;
  }
  
  public Boolean getMulticast() {
    return this.multicast;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasEgressFirewall() {
    return this.egressFirewall != null;
  }
  
  public boolean hasEgressIP() {
    return this.egressIP != null;
  }
  
  public boolean hasMulticast() {
    return this.multicast != null;
  }
  
  public int hashCode() {
    return Objects.hash(egressFirewall, egressIP, multicast, additionalProperties);
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
    if (!(egressFirewall == null)) {
        sb.append("egressFirewall:");
        sb.append(egressFirewall);
        sb.append(",");
    }
    if (!(egressIP == null)) {
        sb.append("egressIP:");
        sb.append(egressIP);
        sb.append(",");
    }
    if (!(multicast == null)) {
        sb.append("multicast:");
        sb.append(multicast);
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
  
  public A withEgressFirewall() {
    return withEgressFirewall(true);
  }
  
  public A withEgressFirewall(Boolean egressFirewall) {
    this.egressFirewall = egressFirewall;
    return (A) this;
  }
  
  public A withEgressIP() {
    return withEgressIP(true);
  }
  
  public A withEgressIP(Boolean egressIP) {
    this.egressIP = egressIP;
    return (A) this;
  }
  
  public A withMulticast() {
    return withMulticast(true);
  }
  
  public A withMulticast(Boolean multicast) {
    this.multicast = multicast;
    return (A) this;
  }
  
}