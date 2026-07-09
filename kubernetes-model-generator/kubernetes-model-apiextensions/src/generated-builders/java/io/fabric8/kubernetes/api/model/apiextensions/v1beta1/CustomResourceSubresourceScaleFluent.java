package io.fabric8.kubernetes.api.model.apiextensions.v1beta1;

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
public class CustomResourceSubresourceScaleFluent<A extends io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceSubresourceScaleFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String labelSelectorPath;
  private String specReplicasPath;
  private String statusReplicasPath;

  public CustomResourceSubresourceScaleFluent() {
  }
  
  public CustomResourceSubresourceScaleFluent(CustomResourceSubresourceScale instance) {
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
  
  protected void copyInstance(CustomResourceSubresourceScale instance) {
    instance = instance != null ? instance : new CustomResourceSubresourceScale();
    if (instance != null) {
        this.withLabelSelectorPath(instance.getLabelSelectorPath());
        this.withSpecReplicasPath(instance.getSpecReplicasPath());
        this.withStatusReplicasPath(instance.getStatusReplicasPath());
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
    CustomResourceSubresourceScaleFluent that = (CustomResourceSubresourceScaleFluent) o;
    if (!(Objects.equals(labelSelectorPath, that.labelSelectorPath))) {
      return false;
    }
    if (!(Objects.equals(specReplicasPath, that.specReplicasPath))) {
      return false;
    }
    if (!(Objects.equals(statusReplicasPath, that.statusReplicasPath))) {
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
  
  public String getLabelSelectorPath() {
    return this.labelSelectorPath;
  }
  
  public String getSpecReplicasPath() {
    return this.specReplicasPath;
  }
  
  public String getStatusReplicasPath() {
    return this.statusReplicasPath;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasLabelSelectorPath() {
    return this.labelSelectorPath != null;
  }
  
  public boolean hasSpecReplicasPath() {
    return this.specReplicasPath != null;
  }
  
  public boolean hasStatusReplicasPath() {
    return this.statusReplicasPath != null;
  }
  
  public int hashCode() {
    return Objects.hash(labelSelectorPath, specReplicasPath, statusReplicasPath, additionalProperties);
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
    if (!(labelSelectorPath == null)) {
        sb.append("labelSelectorPath:");
        sb.append(labelSelectorPath);
        sb.append(",");
    }
    if (!(specReplicasPath == null)) {
        sb.append("specReplicasPath:");
        sb.append(specReplicasPath);
        sb.append(",");
    }
    if (!(statusReplicasPath == null)) {
        sb.append("statusReplicasPath:");
        sb.append(statusReplicasPath);
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
  
  public A withLabelSelectorPath(String labelSelectorPath) {
    this.labelSelectorPath = labelSelectorPath;
    return (A) this;
  }
  
  public A withSpecReplicasPath(String specReplicasPath) {
    this.specReplicasPath = specReplicasPath;
    return (A) this;
  }
  
  public A withStatusReplicasPath(String statusReplicasPath) {
    this.statusReplicasPath = statusReplicasPath;
    return (A) this;
  }
  
}