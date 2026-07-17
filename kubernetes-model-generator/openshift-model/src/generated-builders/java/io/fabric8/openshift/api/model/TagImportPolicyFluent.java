package io.fabric8.openshift.api.model;

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
public class TagImportPolicyFluent<A extends io.fabric8.openshift.api.model.TagImportPolicyFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String importMode;
  private Boolean insecure;
  private Boolean scheduled;

  public TagImportPolicyFluent() {
  }
  
  public TagImportPolicyFluent(TagImportPolicy instance) {
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
  
  protected void copyInstance(TagImportPolicy instance) {
    instance = instance != null ? instance : new TagImportPolicy();
    if (instance != null) {
        this.withImportMode(instance.getImportMode());
        this.withInsecure(instance.getInsecure());
        this.withScheduled(instance.getScheduled());
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
    TagImportPolicyFluent that = (TagImportPolicyFluent) o;
    if (!(Objects.equals(importMode, that.importMode))) {
      return false;
    }
    if (!(Objects.equals(insecure, that.insecure))) {
      return false;
    }
    if (!(Objects.equals(scheduled, that.scheduled))) {
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
  
  public String getImportMode() {
    return this.importMode;
  }
  
  public Boolean getInsecure() {
    return this.insecure;
  }
  
  public Boolean getScheduled() {
    return this.scheduled;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasImportMode() {
    return this.importMode != null;
  }
  
  public boolean hasInsecure() {
    return this.insecure != null;
  }
  
  public boolean hasScheduled() {
    return this.scheduled != null;
  }
  
  public int hashCode() {
    return Objects.hash(importMode, insecure, scheduled, additionalProperties);
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
    if (!(importMode == null)) {
        sb.append("importMode:");
        sb.append(importMode);
        sb.append(",");
    }
    if (!(insecure == null)) {
        sb.append("insecure:");
        sb.append(insecure);
        sb.append(",");
    }
    if (!(scheduled == null)) {
        sb.append("scheduled:");
        sb.append(scheduled);
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
  
  public A withImportMode(String importMode) {
    this.importMode = importMode;
    return (A) this;
  }
  
  public A withInsecure() {
    return withInsecure(true);
  }
  
  public A withInsecure(Boolean insecure) {
    this.insecure = insecure;
    return (A) this;
  }
  
  public A withScheduled() {
    return withScheduled(true);
  }
  
  public A withScheduled(Boolean scheduled) {
    this.scheduled = scheduled;
    return (A) this;
  }
  
}