package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Long;
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
public class ImageLayerDataFluent<A extends io.fabric8.openshift.api.model.ImageLayerDataFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String mediaType;
  private Long size;

  public ImageLayerDataFluent() {
  }
  
  public ImageLayerDataFluent(ImageLayerData instance) {
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
  
  protected void copyInstance(ImageLayerData instance) {
    instance = instance != null ? instance : new ImageLayerData();
    if (instance != null) {
        this.withMediaType(instance.getMediaType());
        this.withSize(instance.getSize());
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
    ImageLayerDataFluent that = (ImageLayerDataFluent) o;
    if (!(Objects.equals(mediaType, that.mediaType))) {
      return false;
    }
    if (!(Objects.equals(size, that.size))) {
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
  
  public String getMediaType() {
    return this.mediaType;
  }
  
  public Long getSize() {
    return this.size;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMediaType() {
    return this.mediaType != null;
  }
  
  public boolean hasSize() {
    return this.size != null;
  }
  
  public int hashCode() {
    return Objects.hash(mediaType, size, additionalProperties);
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
    if (!(mediaType == null)) {
        sb.append("mediaType:");
        sb.append(mediaType);
        sb.append(",");
    }
    if (!(size == null)) {
        sb.append("size:");
        sb.append(size);
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
  
  public A withMediaType(String mediaType) {
    this.mediaType = mediaType;
    return (A) this;
  }
  
  public A withSize(Long size) {
    this.size = size;
    return (A) this;
  }
  
}