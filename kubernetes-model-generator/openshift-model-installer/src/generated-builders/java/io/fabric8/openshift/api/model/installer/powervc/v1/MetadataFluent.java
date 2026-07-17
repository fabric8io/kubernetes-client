package io.fabric8.openshift.api.model.installer.powervc.v1;

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
public class MetadataFluent<A extends io.fabric8.openshift.api.model.installer.powervc.v1.MetadataFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String cloud;
  private Map<String,String> identifier;

  public MetadataFluent() {
  }
  
  public MetadataFluent(Metadata instance) {
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
  
  public A addToIdentifier(Map<String,String> map) {
    if (this.identifier == null && map != null) {
      this.identifier = new LinkedHashMap();
    }
    if (map != null) {
      this.identifier.putAll(map);
    }
    return (A) this;
  }
  
  public A addToIdentifier(String key,String value) {
    if (this.identifier == null && key != null && value != null) {
      this.identifier = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.identifier.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(Metadata instance) {
    instance = instance != null ? instance : new Metadata();
    if (instance != null) {
        this.withCloud(instance.getCloud());
        this.withIdentifier(instance.getIdentifier());
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
    MetadataFluent that = (MetadataFluent) o;
    if (!(Objects.equals(cloud, that.cloud))) {
      return false;
    }
    if (!(Objects.equals(identifier, that.identifier))) {
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
  
  public String getCloud() {
    return this.cloud;
  }
  
  public Map<String,String> getIdentifier() {
    return this.identifier;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCloud() {
    return this.cloud != null;
  }
  
  public boolean hasIdentifier() {
    return this.identifier != null;
  }
  
  public int hashCode() {
    return Objects.hash(cloud, identifier, additionalProperties);
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
  
  public A removeFromIdentifier(String key) {
    if (this.identifier == null) {
      return (A) this;
    }
    if (key != null && this.identifier != null) {
      this.identifier.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromIdentifier(Map<String,String> map) {
    if (this.identifier == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.identifier != null) {
          this.identifier.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(cloud == null)) {
        sb.append("cloud:");
        sb.append(cloud);
        sb.append(",");
    }
    if (!(identifier == null) && !(identifier.isEmpty())) {
        sb.append("identifier:");
        sb.append(identifier);
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
  
  public A withCloud(String cloud) {
    this.cloud = cloud;
    return (A) this;
  }
  
  public <K,V>A withIdentifier(Map<String,String> identifier) {
    if (identifier == null) {
      this.identifier = null;
    } else {
      this.identifier = new LinkedHashMap(identifier);
    }
    return (A) this;
  }
  
}