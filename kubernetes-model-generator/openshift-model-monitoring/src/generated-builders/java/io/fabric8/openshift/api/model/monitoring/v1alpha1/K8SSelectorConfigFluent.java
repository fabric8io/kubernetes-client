package io.fabric8.openshift.api.model.monitoring.v1alpha1;

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
public class K8SSelectorConfigFluent<A extends io.fabric8.openshift.api.model.monitoring.v1alpha1.K8SSelectorConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String field;
  private String label;
  private String role;

  public K8SSelectorConfigFluent() {
  }
  
  public K8SSelectorConfigFluent(K8SSelectorConfig instance) {
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
  
  protected void copyInstance(K8SSelectorConfig instance) {
    instance = instance != null ? instance : new K8SSelectorConfig();
    if (instance != null) {
        this.withField(instance.getField());
        this.withLabel(instance.getLabel());
        this.withRole(instance.getRole());
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
    K8SSelectorConfigFluent that = (K8SSelectorConfigFluent) o;
    if (!(Objects.equals(field, that.field))) {
      return false;
    }
    if (!(Objects.equals(label, that.label))) {
      return false;
    }
    if (!(Objects.equals(role, that.role))) {
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
  
  public String getField() {
    return this.field;
  }
  
  public String getLabel() {
    return this.label;
  }
  
  public String getRole() {
    return this.role;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasField() {
    return this.field != null;
  }
  
  public boolean hasLabel() {
    return this.label != null;
  }
  
  public boolean hasRole() {
    return this.role != null;
  }
  
  public int hashCode() {
    return Objects.hash(field, label, role, additionalProperties);
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
    if (!(field == null)) {
        sb.append("field:");
        sb.append(field);
        sb.append(",");
    }
    if (!(label == null)) {
        sb.append("label:");
        sb.append(label);
        sb.append(",");
    }
    if (!(role == null)) {
        sb.append("role:");
        sb.append(role);
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
  
  public A withField(String field) {
    this.field = field;
    return (A) this;
  }
  
  public A withLabel(String label) {
    this.label = label;
    return (A) this;
  }
  
  public A withRole(String role) {
    this.role = role;
    return (A) this;
  }
  
}