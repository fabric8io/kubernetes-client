package io.fabric8.certmanager.api.model.v1;

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
public class OtherNameFluent<A extends io.fabric8.certmanager.api.model.v1.OtherNameFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String oid;
  private String utf8Value;

  public OtherNameFluent() {
  }
  
  public OtherNameFluent(OtherName instance) {
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
  
  protected void copyInstance(OtherName instance) {
    instance = instance != null ? instance : new OtherName();
    if (instance != null) {
        this.withOid(instance.getOid());
        this.withUtf8Value(instance.getUtf8Value());
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
    OtherNameFluent that = (OtherNameFluent) o;
    if (!(Objects.equals(oid, that.oid))) {
      return false;
    }
    if (!(Objects.equals(utf8Value, that.utf8Value))) {
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
  
  public String getOid() {
    return this.oid;
  }
  
  public String getUtf8Value() {
    return this.utf8Value;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasOid() {
    return this.oid != null;
  }
  
  public boolean hasUtf8Value() {
    return this.utf8Value != null;
  }
  
  public int hashCode() {
    return Objects.hash(oid, utf8Value, additionalProperties);
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
    if (!(oid == null)) {
        sb.append("oid:");
        sb.append(oid);
        sb.append(",");
    }
    if (!(utf8Value == null)) {
        sb.append("utf8Value:");
        sb.append(utf8Value);
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
  
  public A withOid(String oid) {
    this.oid = oid;
    return (A) this;
  }
  
  public A withUtf8Value(String utf8Value) {
    this.utf8Value = utf8Value;
    return (A) this;
  }
  
}