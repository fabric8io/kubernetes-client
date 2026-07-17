package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

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
public class MetaDataHostInterfaceFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1.MetaDataHostInterfaceFluent<A>> extends BaseFluent<A>{

  private String _interface;
  private Map<String,Object> additionalProperties;
  private Boolean fromBootMAC;
  private String key;

  public MetaDataHostInterfaceFluent() {
  }
  
  public MetaDataHostInterfaceFluent(MetaDataHostInterface instance) {
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
  
  protected void copyInstance(MetaDataHostInterface instance) {
    instance = instance != null ? instance : new MetaDataHostInterface();
    if (instance != null) {
        this.withFromBootMAC(instance.getFromBootMAC());
        this.withInterface(instance.getInterface());
        this.withKey(instance.getKey());
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
    MetaDataHostInterfaceFluent that = (MetaDataHostInterfaceFluent) o;
    if (!(Objects.equals(fromBootMAC, that.fromBootMAC))) {
      return false;
    }
    if (!(Objects.equals(_interface, that._interface))) {
      return false;
    }
    if (!(Objects.equals(key, that.key))) {
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
  
  public Boolean getFromBootMAC() {
    return this.fromBootMAC;
  }
  
  public String getInterface() {
    return this._interface;
  }
  
  public String getKey() {
    return this.key;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasFromBootMAC() {
    return this.fromBootMAC != null;
  }
  
  public boolean hasInterface() {
    return this._interface != null;
  }
  
  public boolean hasKey() {
    return this.key != null;
  }
  
  public int hashCode() {
    return Objects.hash(fromBootMAC, _interface, key, additionalProperties);
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
    if (!(fromBootMAC == null)) {
        sb.append("fromBootMAC:");
        sb.append(fromBootMAC);
        sb.append(",");
    }
    if (!(_interface == null)) {
        sb.append("_interface:");
        sb.append(_interface);
        sb.append(",");
    }
    if (!(key == null)) {
        sb.append("key:");
        sb.append(key);
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
  
  public A withFromBootMAC() {
    return withFromBootMAC(true);
  }
  
  public A withFromBootMAC(Boolean fromBootMAC) {
    this.fromBootMAC = fromBootMAC;
    return (A) this;
  }
  
  public A withInterface(String _interface) {
    this._interface = _interface;
    return (A) this;
  }
  
  public A withKey(String key) {
    this.key = key;
    return (A) this;
  }
  
}