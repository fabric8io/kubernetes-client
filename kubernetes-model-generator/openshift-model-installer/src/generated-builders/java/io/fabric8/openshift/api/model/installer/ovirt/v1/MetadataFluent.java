package io.fabric8.openshift.api.model.installer.ovirt.v1;

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
public class MetadataFluent<A extends io.fabric8.openshift.api.model.installer.ovirt.v1.MetadataFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String clusterId;
  private Boolean removeTemplate;

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
  
  protected void copyInstance(Metadata instance) {
    instance = instance != null ? instance : new Metadata();
    if (instance != null) {
        this.withClusterId(instance.getClusterId());
        this.withRemoveTemplate(instance.getRemoveTemplate());
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
    if (!(Objects.equals(clusterId, that.clusterId))) {
      return false;
    }
    if (!(Objects.equals(removeTemplate, that.removeTemplate))) {
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
  
  public String getClusterId() {
    return this.clusterId;
  }
  
  public Boolean getRemoveTemplate() {
    return this.removeTemplate;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClusterId() {
    return this.clusterId != null;
  }
  
  public boolean hasRemoveTemplate() {
    return this.removeTemplate != null;
  }
  
  public int hashCode() {
    return Objects.hash(clusterId, removeTemplate, additionalProperties);
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
    if (!(clusterId == null)) {
        sb.append("clusterId:");
        sb.append(clusterId);
        sb.append(",");
    }
    if (!(removeTemplate == null)) {
        sb.append("removeTemplate:");
        sb.append(removeTemplate);
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
  
  public A withClusterId(String clusterId) {
    this.clusterId = clusterId;
    return (A) this;
  }
  
  public A withRemoveTemplate() {
    return withRemoveTemplate(true);
  }
  
  public A withRemoveTemplate(Boolean removeTemplate) {
    this.removeTemplate = removeTemplate;
    return (A) this;
  }
  
}