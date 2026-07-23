package io.fabric8.kubernetes.api.model;

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
public class GlusterfsPersistentVolumeSourceFluent<A extends io.fabric8.kubernetes.api.model.GlusterfsPersistentVolumeSourceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String endpoints;
  private String endpointsNamespace;
  private String path;
  private Boolean readOnly;

  public GlusterfsPersistentVolumeSourceFluent() {
  }
  
  public GlusterfsPersistentVolumeSourceFluent(GlusterfsPersistentVolumeSource instance) {
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
  
  protected void copyInstance(GlusterfsPersistentVolumeSource instance) {
    instance = instance != null ? instance : new GlusterfsPersistentVolumeSource();
    if (instance != null) {
        this.withEndpoints(instance.getEndpoints());
        this.withEndpointsNamespace(instance.getEndpointsNamespace());
        this.withPath(instance.getPath());
        this.withReadOnly(instance.getReadOnly());
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
    GlusterfsPersistentVolumeSourceFluent that = (GlusterfsPersistentVolumeSourceFluent) o;
    if (!(Objects.equals(endpoints, that.endpoints))) {
      return false;
    }
    if (!(Objects.equals(endpointsNamespace, that.endpointsNamespace))) {
      return false;
    }
    if (!(Objects.equals(path, that.path))) {
      return false;
    }
    if (!(Objects.equals(readOnly, that.readOnly))) {
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
  
  public String getEndpoints() {
    return this.endpoints;
  }
  
  public String getEndpointsNamespace() {
    return this.endpointsNamespace;
  }
  
  public String getPath() {
    return this.path;
  }
  
  public Boolean getReadOnly() {
    return this.readOnly;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasEndpoints() {
    return this.endpoints != null;
  }
  
  public boolean hasEndpointsNamespace() {
    return this.endpointsNamespace != null;
  }
  
  public boolean hasPath() {
    return this.path != null;
  }
  
  public boolean hasReadOnly() {
    return this.readOnly != null;
  }
  
  public int hashCode() {
    return Objects.hash(endpoints, endpointsNamespace, path, readOnly, additionalProperties);
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
    if (!(endpoints == null)) {
        sb.append("endpoints:");
        sb.append(endpoints);
        sb.append(",");
    }
    if (!(endpointsNamespace == null)) {
        sb.append("endpointsNamespace:");
        sb.append(endpointsNamespace);
        sb.append(",");
    }
    if (!(path == null)) {
        sb.append("path:");
        sb.append(path);
        sb.append(",");
    }
    if (!(readOnly == null)) {
        sb.append("readOnly:");
        sb.append(readOnly);
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
  
  public A withEndpoints(String endpoints) {
    this.endpoints = endpoints;
    return (A) this;
  }
  
  public A withEndpointsNamespace(String endpointsNamespace) {
    this.endpointsNamespace = endpointsNamespace;
    return (A) this;
  }
  
  public A withPath(String path) {
    this.path = path;
    return (A) this;
  }
  
  public A withReadOnly() {
    return withReadOnly(true);
  }
  
  public A withReadOnly(Boolean readOnly) {
    this.readOnly = readOnly;
    return (A) this;
  }
  
}