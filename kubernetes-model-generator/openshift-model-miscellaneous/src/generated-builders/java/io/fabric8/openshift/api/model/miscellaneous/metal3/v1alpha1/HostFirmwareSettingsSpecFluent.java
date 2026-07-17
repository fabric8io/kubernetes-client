package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.model.IntOrString;
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
public class HostFirmwareSettingsSpecFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1.HostFirmwareSettingsSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Map<String,IntOrString> settings;

  public HostFirmwareSettingsSpecFluent() {
  }
  
  public HostFirmwareSettingsSpecFluent(HostFirmwareSettingsSpec instance) {
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
  
  public A addToSettings(Map<String,IntOrString> map) {
    if (this.settings == null && map != null) {
      this.settings = new LinkedHashMap();
    }
    if (map != null) {
      this.settings.putAll(map);
    }
    return (A) this;
  }
  
  public A addToSettings(String key,IntOrString value) {
    if (this.settings == null && key != null && value != null) {
      this.settings = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.settings.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(HostFirmwareSettingsSpec instance) {
    instance = instance != null ? instance : new HostFirmwareSettingsSpec();
    if (instance != null) {
        this.withSettings(instance.getSettings());
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
    HostFirmwareSettingsSpecFluent that = (HostFirmwareSettingsSpecFluent) o;
    if (!(Objects.equals(settings, that.settings))) {
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
  
  public Map<String,IntOrString> getSettings() {
    return this.settings;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasSettings() {
    return this.settings != null;
  }
  
  public int hashCode() {
    return Objects.hash(settings, additionalProperties);
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
  
  public A removeFromSettings(String key) {
    if (this.settings == null) {
      return (A) this;
    }
    if (key != null && this.settings != null) {
      this.settings.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromSettings(Map<String,IntOrString> map) {
    if (this.settings == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.settings != null) {
          this.settings.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(settings == null) && !(settings.isEmpty())) {
        sb.append("settings:");
        sb.append(settings);
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
  
  public <K,V>A withSettings(Map<String,IntOrString> settings) {
    if (settings == null) {
      this.settings = null;
    } else {
      this.settings = new LinkedHashMap(settings);
    }
    return (A) this;
  }
  
}