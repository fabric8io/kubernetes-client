package io.fabric8.kubernetes.api.model;

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
public class ImageVolumeSourceFluent<A extends io.fabric8.kubernetes.api.model.ImageVolumeSourceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String pullPolicy;
  private String reference;

  public ImageVolumeSourceFluent() {
  }
  
  public ImageVolumeSourceFluent(ImageVolumeSource instance) {
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
  
  protected void copyInstance(ImageVolumeSource instance) {
    instance = instance != null ? instance : new ImageVolumeSource();
    if (instance != null) {
        this.withPullPolicy(instance.getPullPolicy());
        this.withReference(instance.getReference());
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
    ImageVolumeSourceFluent that = (ImageVolumeSourceFluent) o;
    if (!(Objects.equals(pullPolicy, that.pullPolicy))) {
      return false;
    }
    if (!(Objects.equals(reference, that.reference))) {
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
  
  public String getPullPolicy() {
    return this.pullPolicy;
  }
  
  public String getReference() {
    return this.reference;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasPullPolicy() {
    return this.pullPolicy != null;
  }
  
  public boolean hasReference() {
    return this.reference != null;
  }
  
  public int hashCode() {
    return Objects.hash(pullPolicy, reference, additionalProperties);
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
    if (!(pullPolicy == null)) {
        sb.append("pullPolicy:");
        sb.append(pullPolicy);
        sb.append(",");
    }
    if (!(reference == null)) {
        sb.append("reference:");
        sb.append(reference);
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
  
  public A withPullPolicy(String pullPolicy) {
    this.pullPolicy = pullPolicy;
    return (A) this;
  }
  
  public A withReference(String reference) {
    this.reference = reference;
    return (A) this;
  }
  
}