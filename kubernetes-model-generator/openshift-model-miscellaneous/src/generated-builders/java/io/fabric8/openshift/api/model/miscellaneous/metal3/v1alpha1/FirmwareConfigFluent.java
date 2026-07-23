package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

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
public class FirmwareConfigFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1.FirmwareConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean simultaneousMultithreadingEnabled;
  private Boolean sriovEnabled;
  private Boolean virtualizationEnabled;

  public FirmwareConfigFluent() {
  }
  
  public FirmwareConfigFluent(FirmwareConfig instance) {
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
  
  protected void copyInstance(FirmwareConfig instance) {
    instance = instance != null ? instance : new FirmwareConfig();
    if (instance != null) {
        this.withSimultaneousMultithreadingEnabled(instance.getSimultaneousMultithreadingEnabled());
        this.withSriovEnabled(instance.getSriovEnabled());
        this.withVirtualizationEnabled(instance.getVirtualizationEnabled());
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
    FirmwareConfigFluent that = (FirmwareConfigFluent) o;
    if (!(Objects.equals(simultaneousMultithreadingEnabled, that.simultaneousMultithreadingEnabled))) {
      return false;
    }
    if (!(Objects.equals(sriovEnabled, that.sriovEnabled))) {
      return false;
    }
    if (!(Objects.equals(virtualizationEnabled, that.virtualizationEnabled))) {
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
  
  public Boolean getSimultaneousMultithreadingEnabled() {
    return this.simultaneousMultithreadingEnabled;
  }
  
  public Boolean getSriovEnabled() {
    return this.sriovEnabled;
  }
  
  public Boolean getVirtualizationEnabled() {
    return this.virtualizationEnabled;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasSimultaneousMultithreadingEnabled() {
    return this.simultaneousMultithreadingEnabled != null;
  }
  
  public boolean hasSriovEnabled() {
    return this.sriovEnabled != null;
  }
  
  public boolean hasVirtualizationEnabled() {
    return this.virtualizationEnabled != null;
  }
  
  public int hashCode() {
    return Objects.hash(simultaneousMultithreadingEnabled, sriovEnabled, virtualizationEnabled, additionalProperties);
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
    if (!(simultaneousMultithreadingEnabled == null)) {
        sb.append("simultaneousMultithreadingEnabled:");
        sb.append(simultaneousMultithreadingEnabled);
        sb.append(",");
    }
    if (!(sriovEnabled == null)) {
        sb.append("sriovEnabled:");
        sb.append(sriovEnabled);
        sb.append(",");
    }
    if (!(virtualizationEnabled == null)) {
        sb.append("virtualizationEnabled:");
        sb.append(virtualizationEnabled);
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
  
  public A withSimultaneousMultithreadingEnabled() {
    return withSimultaneousMultithreadingEnabled(true);
  }
  
  public A withSimultaneousMultithreadingEnabled(Boolean simultaneousMultithreadingEnabled) {
    this.simultaneousMultithreadingEnabled = simultaneousMultithreadingEnabled;
    return (A) this;
  }
  
  public A withSriovEnabled() {
    return withSriovEnabled(true);
  }
  
  public A withSriovEnabled(Boolean sriovEnabled) {
    this.sriovEnabled = sriovEnabled;
    return (A) this;
  }
  
  public A withVirtualizationEnabled() {
    return withVirtualizationEnabled(true);
  }
  
  public A withVirtualizationEnabled(Boolean virtualizationEnabled) {
    this.virtualizationEnabled = virtualizationEnabled;
    return (A) this;
  }
  
}