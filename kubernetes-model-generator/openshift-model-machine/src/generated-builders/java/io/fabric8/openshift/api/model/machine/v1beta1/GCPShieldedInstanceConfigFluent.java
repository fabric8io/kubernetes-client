package io.fabric8.openshift.api.model.machine.v1beta1;

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
public class GCPShieldedInstanceConfigFluent<A extends io.fabric8.openshift.api.model.machine.v1beta1.GCPShieldedInstanceConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String integrityMonitoring;
  private String secureBoot;
  private String virtualizedTrustedPlatformModule;

  public GCPShieldedInstanceConfigFluent() {
  }
  
  public GCPShieldedInstanceConfigFluent(GCPShieldedInstanceConfig instance) {
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
  
  protected void copyInstance(GCPShieldedInstanceConfig instance) {
    instance = instance != null ? instance : new GCPShieldedInstanceConfig();
    if (instance != null) {
        this.withIntegrityMonitoring(instance.getIntegrityMonitoring());
        this.withSecureBoot(instance.getSecureBoot());
        this.withVirtualizedTrustedPlatformModule(instance.getVirtualizedTrustedPlatformModule());
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
    GCPShieldedInstanceConfigFluent that = (GCPShieldedInstanceConfigFluent) o;
    if (!(Objects.equals(integrityMonitoring, that.integrityMonitoring))) {
      return false;
    }
    if (!(Objects.equals(secureBoot, that.secureBoot))) {
      return false;
    }
    if (!(Objects.equals(virtualizedTrustedPlatformModule, that.virtualizedTrustedPlatformModule))) {
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
  
  public String getIntegrityMonitoring() {
    return this.integrityMonitoring;
  }
  
  public String getSecureBoot() {
    return this.secureBoot;
  }
  
  public String getVirtualizedTrustedPlatformModule() {
    return this.virtualizedTrustedPlatformModule;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasIntegrityMonitoring() {
    return this.integrityMonitoring != null;
  }
  
  public boolean hasSecureBoot() {
    return this.secureBoot != null;
  }
  
  public boolean hasVirtualizedTrustedPlatformModule() {
    return this.virtualizedTrustedPlatformModule != null;
  }
  
  public int hashCode() {
    return Objects.hash(integrityMonitoring, secureBoot, virtualizedTrustedPlatformModule, additionalProperties);
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
    if (!(integrityMonitoring == null)) {
        sb.append("integrityMonitoring:");
        sb.append(integrityMonitoring);
        sb.append(",");
    }
    if (!(secureBoot == null)) {
        sb.append("secureBoot:");
        sb.append(secureBoot);
        sb.append(",");
    }
    if (!(virtualizedTrustedPlatformModule == null)) {
        sb.append("virtualizedTrustedPlatformModule:");
        sb.append(virtualizedTrustedPlatformModule);
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
  
  public A withIntegrityMonitoring(String integrityMonitoring) {
    this.integrityMonitoring = integrityMonitoring;
    return (A) this;
  }
  
  public A withSecureBoot(String secureBoot) {
    this.secureBoot = secureBoot;
    return (A) this;
  }
  
  public A withVirtualizedTrustedPlatformModule(String virtualizedTrustedPlatformModule) {
    this.virtualizedTrustedPlatformModule = virtualizedTrustedPlatformModule;
    return (A) this;
  }
  
}